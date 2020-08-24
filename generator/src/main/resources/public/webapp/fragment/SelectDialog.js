sap.ui.define([
    'jquery.sap.global',
    'sap/ui/core/Fragment',
    "sap/ui/base/Object",
    'sap/ui/model/Filter',
    'sap/ui/model/json/JSONModel'
], function (jQuery, Fragment, Object, Filter, JSONModel) {
    "use strict";
    return Object.extend("gen.fragment.SelectDialog", {
        /**
         * oEvent:為該function使用的
         * me:為該頁面的view
         * myfunction:有事件要完成所調用的function
         */
        open: function (oSource, me, myfunction) {
            this.oView = me.getView(); //畫面的view
            this.inputId = oSource.getId(); //設定input的id
            var customDatas = oSource.getCustomData(); //取得自訂的數據
            this.myfunction = myfunction;
            if (customDatas) {
                for (var i = 0; i < customDatas.length; i++) {
                    var customData = customDatas[i];
                    switch (customData.getKey().toUpperCase()) {
                        case 'callBackKey'.toUpperCase(): //要返回的設定數值
                            this.callBackKey = customData.getValue();
                            break;
                        case 'columns'.toUpperCase(): //取得要設定的欄位字串
                            this.columnsStr = customData.getValue();
                            this.title = this.columnsStr.split("|")[0];
                            this.description = this.columnsStr.split("|")[1];
                            break;
                        case 'title'.toUpperCase(): //取得彈出框的標題
                            this.handle = customData.getValue();
                            break;
                        case 'root'.toUpperCase(): //取得root
                            this.root = customData.getValue();
                            break;
                        case 'root'.toUpperCase(): //取得root
                            this.root = customData.getValue();
                            break;
                    }
                }
            }
            //設定彈出框架構
            if (!this.dialog) { //該彈出框的設定
                this.dialog = sap.ui.xmlfragment(
                    "gen.fragment.SelectDialog",
                    this
                );
                jQuery.sap.syncStyleClass("sapUiSizeCompact", this.oView, this.dialog);
                this.oView.addDependent(this.dialog);
            }
            //設定標題
            this.dialog.setTitle(me.getI18N().getText("g.select") + me.getI18N().getText(this.handle));
            //設定root和cell
            var oTableItems = new sap.m.StandardListItem({
                title: "{" + this.title + "}",
                description: "{" + this.description + "}"
            });
            this.dialog.bindAggregation("items", this.root, oTableItems);
            this.dialog.open();
            return this.dialog;
        },
        /**
         * 檢索
         */
        searchDialog: function (oEvent) {
            var value = oEvent.getParameter("value");
            var filters = [
                new Filter(
                    this.title,
                    sap.ui.model.FilterOperator.Contains,
                    value
                ),
                new Filter(
                    this.description,
                    sap.ui.model.FilterOperator.Contains,
                    value
                )
            ];
            oEvent.getSource().getBinding("items").filter(new Filter({
                filters: filters,
                and: false
            }));
        },
        /**
         * 確定
         */
        confirmDialog: function (oEvent) {
            var input = this.oView.byId(this.inputId);
            if (input == null) {
                input = sap.ui.getCore().byId(this.inputId);
            }
            var context = oEvent.getParameter("selectedContexts");
            if (context && context.length) {
                var select = context.map((sel) => sel.getObject());
                input.setValue(select[0][this.callBackKey]); //設定要反回的input值
                if (this.myfunction) { //調用程式
                    this.myfunction(select[0]);
                }
            }
        }
    });
});