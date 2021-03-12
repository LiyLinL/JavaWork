sap.ui.define([
      'gen/core/BaseController',
      "sap/ui/model/json/JSONModel",
      'gen/view/dialog/Dialog',
      "sap/ui/model/Filter",
      "sap/ui/model/FilterOperator"
   ],
   function (BaseController, JSONModel, Dialog, Filter, FilterOperator) {
      "use strict";
      return BaseController.extend("gen.view.test.test", {
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
                  seq: 1,
                  text: 'A'
               }, {
                  seq: 1,
                  text: 'C'
               }, {
                  seq: 2,
                  text: 'B'
               }, {
                  seq: 3,
                  text: 'B'
               }]
            }));
         },
         test: function (oEvent) {
            console.log(oEvent);
         },
         testF: function (oEvent) {
            var oColumn = oEvent.getParameter("column");
            var c = this.byId('s');
            if (oColumn != c) {
               return;
            }
            oEvent.preventDefault(); // 阻止原本事件

            var clear = function () {
               oColumn.setFiltered(false);
               this.byId("table").getBinding().filter(null, 'Application');
            }

            var sValue = oEvent.getParameter("value");
            if (!sValue) {
               clear.apply(this);
               return;
            }
            var value = parseInt(sValue);
            var f = new Filter('seq', FilterOperator.EQ, value);
            oColumn.setFiltered(true);
            //Control
            //Application
            this.byId("table").getBinding().filter(f, 'Application');

         },
         pressTest: function (oEvent, id) {
            var c = this.byId('Dialog').open();
            // new Dialog(this).showDialog();
         },
         actPress: function (oEvent) {
            var e = oEvent;
         },
         close: function () {
            this.byId('Dialog').close();
            // this.byId('ip').setValue('');
         }
      });
   });