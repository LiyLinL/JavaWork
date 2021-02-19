sap.ui.define([
      'gen/core/BaseController',
      "sap/ui/model/json/JSONModel",
      'gen/view/single/Dialog'
   ],
   function (BaseController, JSONModel, Dialog) {
      "use strict";
      return BaseController.extend("gen.view.single.test", {
         onInit: function () {
            var me = this,
               oView = this.getView();
            this.attachPatternMatched('test', me.onRouteMatched);
         },
         onRouteMatched: function (oEvent) {
            var me = this,
               oView = me.getView();
            var req = oEvent.getParameter('arguments')['?req'];
            me.getView().setModel(new JSONModel({
               test: '',
               table: [{
                  seq: 1
               }, {
                  seq: 2
               }]
            }));
         },
         pressTest: function (oEvent, id) {
            var c = this.byId('Dialog').open();
            // new Dialog(this).showDialog();
         },
         close: function () {
            this.byId('Dialog').close();
            // this.byId('ip').setValue('');
         }
      });
   });