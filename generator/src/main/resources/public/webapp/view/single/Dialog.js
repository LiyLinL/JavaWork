sap.ui.define([
   'sap/ui/core/Fragment',
   "sap/ui/base/Object",
   'sap/ui/model/json/JSONModel',
   'sap/m/MessageBox'
], function (Fragment, Object, JSONModel, MessageBox) {
   "use strict";
   return Object.extend("gen.view.single.Dialog", {
      showDialog: function (me) {
         this.me = me;

         if (!this.dialog) {
            this.dialog = Fragment.load({
               id: 'Dialog',
               name: "gen.view.single.Dialog",
               controller: this
            }).then(function (oDialog) {
               oDialog.setTitle('T');
               return oDialog;
            });
         }
         this.dialog.then(function (oDialog) {
            oDialog.open();
         });
      },
      close: function () {
         var b = Fragment.byId('Dialog', 'button');
         this.dialog.then(function (oDialog) {
            oDialog.destroy();
         });
      }
   });
});