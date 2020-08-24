sap.ui.define([
   'sap/ui/core/Fragment',
   "sap/ui/base/Object",
   'sap/ui/model/json/JSONModel',
   'sap/ui/model/Filter'
], function (Fragment, Object, JSONModel, Filter) {
   "use strict";
   return Object.extend("gen.view.calendar.Create", {
      // rackDialog: function (oEvent) {
      //     var me = this,
      //         oView = this.getView(),
      //         oData = this.getData(),
      //         I18N = this.getI18N();
      //     var oSource = oEvent.getSource();

      //     var rackNo = oView.byId("inp_rack").getValue();
      //     var arr = rackNo.split("-");

      //     oSource.data('customTitle', I18N.getText('rackBasis.Dialog.Title') + arr[0]);

      //     var data = {};

      //     new ajax(me.getWebApi()).get('/carrier/rack/info?site=' + oData.site + "&rackNo=" + arr[0], 'json', function (res) {
      //         data.table = res;
      //         data.title = arr[0];
      //         me.refresh();
      //     }, me.showMessage)
      //     new TableSelectDialog().open(oSource, me, data.table, null);
      // },
      open: function (me, data) {
         var oView = me.getView();
         var dialog = Fragment.byId("Create", "Create");
         if (dialog) { //未關閉時銷毀
            dialog.destroy();
            dialog = null;
         }

         if (!me._oDialog) {
            Fragment.load({
               name: "gen.view.calendar.Create",
               controller: me
            }).then(function (oDialog) {
               me._oDialog = oDialog;
               me._oDialog.setModel(new JSONModel(data));
               me._oDialog.setModel(oView.getModel("i18n"), "i18n");
               me._oDialog.open();
            }.bind(me));
         } else {
            me._oDialog.setModel(new JSONModel(data));
            me._oDialog.setModel(oView.getModel("i18n"), "i18n");
            me._oDialog.open();
         }
      },
      search: function (oEvent) {
         var value = oEvent.getParameter("value");
         var filter = new Filter("standNo", sap.ui.model.FilterOperator.Contains, value);
         var bind = oEvent.getSource().getBinding("items");
         bind.filter(filter);
      }
   });
});