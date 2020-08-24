sap.ui.define([
   'gen/core/BaseController',
   'sap/ui/model/json/JSONModel',
   'sap/m/MessageBox',
   'gen/view/calendar/Create',
   'gen/view/calendar/Detail'
], function (BaseController, JSONModel, MessageBox, Create, Detail) {
   'use strict';
   return BaseController.extend('gen.view.calendar.calendar', {
      onInit: function (oEvent) {
         var oModel = new JSONModel();
         oModel.setData({
            startDate: new Date("2020", "7", "1"),
            scheduler: [{
               "name": "A",
               "team": "Team A",
               "pic": "sap-icon://employee",
               "appointments": [{
                  start: new Date(2020, 7, 1),
                  end: new Date(2020, 7, 15),
                  title: "Working out of the building",
                  type: "Type02",
                  pic: "sap-icon://sap-ui5",
                  tentative: false
               }, {
                  start: new Date(2020, 7, 5),
                  end: new Date(2020, 7, 15),
                  title: "Working out of the building",
                  type: "Type01",
                  pic: "sap-icon://attachment",
                  tentative: false
               }, {
                  start: new Date(2020, 7, 18),
                  end: new Date(2020, 7, 23),
                  title: "Working out of the building",
                  type: "Type03",
                  pic: "sap-icon://attachment",
                  tentative: false
               }]
            }, {
               "name": "B",
               "team": "Team B",
               "pic": "sap-icon://employee",
               "appointments": [{
                  start: new Date(2020, 7, 9),
                  end: new Date(2020, 7, 15),
                  title: "Working out of the building",
                  type: "Type02",
                  pic: "sap-icon://sap-ui5",
                  tentative: false
               }, {
                  start: new Date(2020, 7, 16),
                  end: new Date(2020, 7, 30),
                  title: "Working out of the building",
                  type: "Type01",
                  pic: "sap-icon://attachment",
                  tentative: false
               }, {
                  start: new Date(2020, 7, 18),
                  end: new Date(2020, 7, 23),
                  title: "Working out of the building",
                  type: "Type03",
                  pic: "sap-icon://attachment",
                  tentative: false
               }],
               "headers": [{
                  start: new Date(2020, 7, 18),
                  end: new Date(2020, 7, 19),
                  title: "private",
                  type: "Type10",
                  tentative: false
               }]
            }]
         });
         this.getView().setModel(oModel);
      },
      handleAppointmentSelect: function (oEvent) {
         var me = this;
         new Detail().open(me, '');
      },
      handleAppointmentAddWithContext: function (oEvent) {
         var me = this;
         new Create().open(me, '');
      }
   })
})