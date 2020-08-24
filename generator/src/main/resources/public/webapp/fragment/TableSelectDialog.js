sap.ui.define([
    'jquery.sap.global',
    'sap/ui/core/Fragment',
    "sap/ui/base/Object",
    'sap/ui/model/Filter',
    'sap/ui/model/json/JSONModel',
    'sap/m/Token'
], function (jQuery, Fragment, Object, Filter, JSONModel, Token) {
    "use strict";
    return Object.extend("gen.fragment.TableSelectDialog", {
        /**
         * oSource:為該function使用的
         * oView:為該頁面的view
         * oModel:為table使用的JSONModel
         * width:每欄位的寬度 (現無使用)
         * myfunction:有事件要完成所調用的function
         */
        open: function (oSource, me, oModel, myfunction) {
            var sInputValue = oSource.getValue();
            this.me = me; //畫面的view
            var oView = me.getView();
            this.inputId = oSource.getId(); //設定input的id
            var customDatas = oSource.getCustomData(); //取得自訂的數據
            this.myfunction = myfunction;
            if (customDatas) {
                for (let i = 0; i < customDatas.length; i++) {
                    var customData = customDatas[i];
                    switch (customData.getKey().toUpperCase()) {
                        case 'FilterKey'.toUpperCase(): //要檢索的key值
                            this.filterKey = customData.getValue();
                            break;
                        case 'callBackKey'.toUpperCase(): //要返回的設定數值
                            this.callBackKey = customData.getValue();
                            break;
                        case 'columns'.toUpperCase(): //取得要設定的欄位字串
                            this.columnsStr = customData.getValue();
                            break;
                        case 'title'.toUpperCase(): //取得彈出框的標題
                            this.title = customData.getValue();
                            break;
                        case 'root'.toUpperCase(): //取得root
                            this.root = customData.getValue();
                            break;
                        case 'otherInput'.toUpperCase(): //取得其他input要設值 例如描述
                            this.otherInput = customData.getValue();
                            break;
                        case 'inputModel'.toUpperCase(): //取得其他input要設值 例如描述
                            this.inputModel = customData.getValue();
                            break;
                        case 'customTitle'.toUpperCase(): //取得其他input要設值 例如描述
                            this.customTitle = customData.getValue();
                            break;
                        case 'multiple'.toUpperCase(): //取得多選設定
                            this.multiple = customData.getValue() == "true" ? true : false;
                            break;
                        case 'selected'.toUpperCase(): //設定全選
                            this.selected = customData.getValue() == "true" ? true : false;
                            break;
                    }
                }
            }
            //設定彈出框架構
            if (!this.dialog) { //該彈出框的設定
                this.dialog = sap.ui.xmlfragment(
                    "gen.fragment.TableSelectDialog",
                    this
                );
                oView.addDependent(this.dialog);
            }
            this.dialog.setModel(oView.getModel("i18n"), "i18n"); //設定彈出框的i18n
            var oBundle = oView.getModel("i18n").getResourceBundle();
            //設定標題
            if (this.title) {
                this.dialog.setTitle(oBundle.getText("g.select") + oBundle.getText(this.title));
            }
            if (this.customTitle) {
                this.dialog.setTitle(this.customTitle);
            }
            var column = this.columnsStr.split(";"); //分割欄位
            this.dialog.destroyColumns(); //銷毀之前的欄位
            var cell = []
            if (column.length > 0) {
                for (let i = 0; i < column.length; i++) {
                    this.dialog.addColumn(new sap.m.Column({
                            header: new sap.m.Label({ //設定每行的標頭
                                text: oBundle.getText(column[i].split("|")[1])
                            })
                        }
                        //,width: 可設定寬度
                    ));
                    cell.push(new sap.m.Text({
                        text: "{" + column[i].split("|")[0] + "}" //設定每欄位要綁定的資料
                    }));
                }
            }
            var oTableItems = new sap.m.ColumnListItem({
                selected: this.selected,
                cells: cell
            });
            //設定綁定的搜尋物件
            if (this.dialog.getBinding("items")) {
                this.dialog.getBinding("items").filter([new Filter(
                    this.filterKey,
                    sap.ui.model.FilterOperator.Contains, sInputValue
                )]);
            }
            //設定root和cell
            this.dialog.bindAggregation("items", this.root, oTableItems);
            //設定多選
            this.dialog.setMultiSelect(this.multiple);
            //設定model
            this.dialog.setModel(new JSONModel(oModel));
            this.dialog.open();
            document.getElementById(this.dialog.sId + "-cancel-inner").className = "sapMBtnEmphasized sapMBtnHoverable sapMBtnInner sapMBtnText sapMFocusable";
        },
        /**
         * 設定寬度
         */
        setDialogContentWidth: function (evt) {
            this.dialog.setContentWidth(evt);
        },
        /**
         * 檢索
         */
        search: function (oEvent) {
            var sValue = oEvent.getParameter("value");
            var oFilter = new Filter(
                this.filterKey,
                sap.ui.model.FilterOperator.Contains, sValue
            );
            if (oEvent.getSource().getBinding("items")) {
                oEvent.getSource().getBinding("items").filter([oFilter]);
            }
        },
        /**
         * 確定
         */
        confirm: function (oEvent) {
            var input = this.me.getView().byId(this.inputId);
            if (input == null) {
                input = sap.ui.getCore().byId(this.inputId);
            }
            var context = oEvent.getParameter("selectedContexts");
            if (context && context.length) {
                var data = context.map(
                    function (context) {
                        return context.getObject();
                    });

                const key = this.callBackKey;
                if (this.multiple) { // 多選Input
                    var tokens = [];
                    tokens = data.map(function (values) {
                        return new Token({
                            text: values[key]
                        })
                    })
                    input.setTokens(tokens); // 返回多選Values
                } else {
                    input.setValue(data[0][this.callBackKey]); //設定要反回的input值
                }
                if (this.myfunction) { //調用程式
                    this.myfunction(data[0]);
                }
                if (this.inputModel == "true") {
                    input.setModel(new JSONModel(data[0]));
                }
                if (this.otherInput) {
                    var otherInput = this.otherInput.split(";");
                    for (var i = 0; i < otherInput.length; i++) { //設定其他input的value
                        input = otherInput[i].split("|");
                        var inputtype = this.oView.byId(input[1]).__proto__.hasOwnProperty("setText");
                        if (inputtype) {
                            this.oView.byId(input[1]).setText(data[0][input[0]]);
                        } else {
                            this.oView.byId(input[1]).setValue(data[0][input[0]]);
                        }
                    }
                }
            }
        }
    });
});