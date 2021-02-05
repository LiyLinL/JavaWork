sap.ui.define([
      'gen/core/BaseController',
      "sap/ui/core/Fragment",
      "sap/ui/model/json/JSONModel",
      "sap/ui/unified/library",
      'gen/view/single/Dialog',
      'gen/view/single/test'
   ],
   function (BaseController, Fragment, JSONModel, unifiedLibrary, Dialog) {
      "use strict";
      return BaseController.extend("gen.view.single.single", {
         onInit: function () {
            var me = this,
               oView = this.getView();
            this.attachPatternMatched('single', me.onRouteMatched);
         },
         onRouteMatched: function (oEvent) {
            var me = this,
               oView = me.getView();
            sch.a();
            var req = oEvent.getParameter('arguments')['?req'];
            me.getView().setModel(new JSONModel({}));
            // this.setEventData();
         },
      });
   });