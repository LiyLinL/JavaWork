sap.ui.define([
   'sap/ui/core/Fragment',
   "sap/ui/base/Object",
   'sap/ui/model/json/JSONModel',
   'sap/ui/model/Filter'
], function (Fragment, Object, JSONModel, Filter) {
   "use strict";
   return Object.extend("yo.view.calendar.Detail", {
      open: function (me, data) {
         var oView = me.getView();
         var dialog2 = Fragment.byId("Detail", "Detail");
         if (dialog2) { //未關閉時銷毀
            dialog2.destroy();
            dialog2 = null;
         }

         if (!me._oDialog2) {
            Fragment.load({
               name: "yo.view.calendar.Detail",
               controller: me
            }).then(function (oDialog) {
               me._oDialog2 = oDialog;
               me._oDialog2.setModel(new JSONModel(data));
               me._oDialog2.setModel(oView.getModel("i18n"), "i18n");
               me._oDialog2.open();
            }.bind(me));
         } else {
            me._oDialog2.setModel(new JSONModel(data));
            me._oDialog2.setModel(oView.getModel("i18n"), "i18n");
            me._oDialog2.open();
         }
      }
   });
});