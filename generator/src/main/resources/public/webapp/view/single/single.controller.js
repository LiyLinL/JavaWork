sap.ui.define([
      'gen/core/BaseController',
      "sap/ui/core/Fragment",
      "sap/ui/model/json/JSONModel",
      "sap/ui/unified/library",
      'gen/view/single/Dialog'
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
            var req = oEvent.getParameter('arguments')['?req'];
            me.getView().setModel(new JSONModel({
               startDate: new Date("2020", "7", "9"),
               appointments: [{
                  title: "Meet John Miller",
                  type: "Type10",
                  color: "#8600FF",
                  startDate: new Date("2020", "7", "8", "1", "0"),
                  endDate: new Date("2020", "7", "8", "2", "0")
               }, {
                  title: "Discussion of the plan",
                  type: "Type03",
                  color: "#FF60AF",
                  startDate: new Date("2020", "7", "11", "6", "0"),
                  endDate: new Date("2020", "7", "11", "7", "9")
               }, {
                  title: "Lunch",
                  text: "canteen",
                  type: "Type02",
                  color: "#FF60AF",
                  startDate: new Date("2020", "7", "23", "7", "0"),
                  endDate: new Date("2020", "7", "23", "8", "0")
               }, {
                  title: "Discussion of the plan",
                  type: "Type04",
                  color: "#96FED1",
                  startDate: new Date("2020", "7", "15", "6", "0"),
                  endDate: new Date("2020", "7", "15", "7", "9")
               }],
               dhx: [{
                     id: '12341',
                     start_date: "2020-08-18 09:00",
                     end_date: "2020-08-18 12:00",
                     text: "English lesson"
                  },
                  {
                     id: '12341f2134',
                     start_date: "2020-08-20 10:00",
                     end_date: "2020-08-21 16:00",
                     text: "Math exam"
                  },
                  {
                     id: '123213gbdaser41',
                     start_date: "2020-08-21 10:00",
                     end_date: "2020-08-21 14:00",
                     text: "Science lesson",
                     evType: 1
                  },
                  {
                     id: '1234wefqwe1',
                     start_date: "2020-08-23 16:00",
                     end_date: "2020-08-23 17:00",
                     text: "English lesson"
                  },
                  {
                     id: '1234sdqwqehj6y6u1',
                     test: '123',
                     start_date: "2020-08-22 09:00",
                     end_date: "2020-08-22 17:00",
                     text: "Usual event"
                  }
               ]
            }));
            // this.setEventData();
         },
         setEventData: function () {
            var me = this,
               oData = me.getData();
            // Data bindings
            scheduler.parse(oData.dhx);
            // 保存事件
            scheduler.attachEvent("onEventSave", function (id, ev) {
               var index = findIndex(oData.dhx, id);
               if (index > 0) {
                  oData.dhx[index].text = ev.text;
                  oData.dhx[index].start_date = ev.start_date;
                  oData.dhx[index].end_date = ev.end_date;
               } else {
                  const uuid = me.uuid();
                  scheduler.changeEventId(id, uuid);
                  var obj = {
                     id: uuid,
                     text: ev.text,
                     start_date: ev.start_date,
                     end_date: ev.end_date
                  }
                  oData.dhx.push(obj);
               }
               me.refresh();
               return true;
            })
            // 拖拉新增事件
            scheduler.attachEvent("onEventAdded", function (id, ev) {
               const uuid = me.uuid();
               scheduler.changeEventId(id, uuid);
               var obj = {
                  id: uuid,
                  text: ev.text,
                  start_date: ev.start_date,
                  end_date: ev.end_date
               }
               oData.dhx.push(obj);
               me.refresh();
               return true;
            });
            // 修改事件
            scheduler.attachEvent("onEventChanged", function (id, ev) {
               var index = findIndex(oData.dhx, id);
               oData.dhx[index].text = ev.text;
               oData.dhx[index].start_date = ev.start_date;
               oData.dhx[index].end_date = ev.end_date;
               me.refresh();
               return true;
            });
            scheduler.attachEvent("onEventDeleted", function (id, ev) {
               var index = findIndex(oData.dhx, id);
               oData.dhx.splice(index, 1);
               me.refresh();
               return true;
            });

            function findIndex(data, id) {
               return data.map(v => {
                  return v.id;
               }).indexOf(id);
            }
         },
         setView: function () {
            // set sat,sun background color
            scheduler.templates.week_date_class = function (date, today) {
               if (date.getDay() == 0 || date.getDay() == 6)
                  return "weekday";
               return "";
            };
            // view work week
            scheduler.xy.editor_width = 0; //disable editor's auto-size
            scheduler.locale.labels.workweek_tab = "Work-Week";
            scheduler.attachEvent("onTemplatesReady", function () {
               //work week
               scheduler.date.workweek_start = scheduler.date.week_start;
               scheduler.templates.workweek_date = scheduler.templates.week_date;
               scheduler.templates.workweek_scale_date = scheduler.templates.week_scale_date;
               scheduler.date.add_workweek = function (date, inc) {
                  return scheduler.date.add(date, inc * 7, "day");
               }
               scheduler.date.get_workweek_end = function (date) {
                  return scheduler.date.add(date, 5, "day");
               }
            });

            // event color
            scheduler.templates.event_class = function (start, end, event) {
               var css = "";

               if (event.evType) // if event has type property then special class should be assigned
                  css += "event_" + getLabel(evType, event.evType).toLowerCase();

               return css; // default return
            };

            function getLabel(array, key) {
               for (var i = 0; i < array.length; i++) {
                  if (key == array[i].key)
                     return array[i].label;
               }
               return null;
            }

            var evType = [{
                  key: '',
                  label: 'Select event type'
               },
               {
                  key: 1,
                  label: 'Type01'
               },
               {
                  key: 2,
                  label: 'Type02'
               },
               {
                  key: 3,
                  label: 'Type03'
               },
               {
                  key: 4,
                  label: 'Type04'
               }
            ];
            // dialog view
            scheduler.locale.labels.section_evType = "Event type";
            scheduler.config.lightbox.sections = [{
                  name: "description",
                  height: 43,
                  map_to: "text",
                  type: "textarea",
                  focus: true
               },
               {
                  name: "evType",
                  height: 20,
                  type: "select",
                  options: evType,
                  map_to: "evType"
               },
               {
                  name: "time",
                  height: 72,
                  type: "time",
                  map_to: "auto"
               }
            ];
         },
         onAfterRendering: function () {
            // init
            // this.setView();
            // scheduler.init('__xmlview1--scheduler_here', new Date(2020, 7, 20), "week");
         },
         // 創建按鈕
         handleAppointmentCreate: function () {
            var me = this;
            new Dialog().showDialog(me, '');
         },
         // 拖拉
         handleAppointmentDrop: function (oEvent) {
            var oAppointment = oEvent.getParameter("appointment"),
               oStartDate = oEvent.getParameter("startDate"),
               oEndDate = oEvent.getParameter("endDate"),
               bCopy = oEvent.getParameter("copy"),
               sAppointmentTitle = oAppointment.getTitle(),
               oModel = this.getView().getModel(),
               oNewAppointment;

            if (bCopy) {
               oNewAppointment = {
                  title: sAppointmentTitle,
                  icon: oAppointment.getIcon(),
                  text: oAppointment.getText(),
                  type: oAppointment.getType(),
                  startDate: oStartDate,
                  endDate: oEndDate
               };
               oModel.getData().appointments.push(oNewAppointment);
               oModel.updateBindings();
            } else {
               oAppointment.setStartDate(oStartDate);
               oAppointment.setEndDate(oEndDate);
            }
         },
         // 調整時間
         handleAppointmentResize: function (oEvent) {
            var oAppointment = oEvent.getParameter("appointment"),
               oStartDate = oEvent.getParameter("startDate"),
               oEndDate = oEvent.getParameter("endDate"),
               sAppointmentTitle = oAppointment.getTitle(),
               sPath = oAppointment.getBindingContext().getPath().split('/')[2];
            var me = this,
               oData = me.getData();

            oAppointment.setStartDate(oStartDate);
            oAppointment.setEndDate(oEndDate);

            oData.appointments[sPath].startDate = oStartDate;
            oData.appointments[sPath].endDate = oEndDate;
         },
         // 拖拉創建時間
         handleAppointmentCreateDnD: function (oEvent) {
            var oStartDate = oEvent.getParameter("startDate"),
               oEndDate = oEvent.getParameter("endDate"),
               sAppointmentTitle = "New Appointment";
            var me = this,
               oData = me.getData();

            var oNewAppointment = {
               title: sAppointmentTitle,
               startDate: oStartDate,
               endDate: oEndDate
            };
            oData.appointments.push(oNewAppointment);
            me.refresh();
         },
         // 選擇修改時間
         handleAppointmentSelect: function (oEvent) {
            var oAppointment = oEvent.getParameter("appointment"),
               oStartDate = oAppointment.getStartDate(),
               oEndDate = oAppointment.getEndDate(),
               sPath = oAppointment.getBindingContext().getPath().split('/')[2];

            var me = this,
               oView = me.getView(),
               oData = me.getData();

            var obj = {
               type: 'edit',
               sPath: sPath,
               title: oAppointment.getTitle(),
               text: oAppointment.getText(),
               startDate: oStartDate,
               endDate: oEndDate
            };
            new Dialog().showDialog(me, obj);
         },
         uuid: function () {
            var d = Date.now();
            if (typeof performance !== 'undefined' && typeof performance.now === 'function') {
               d += performance.now(); //use high-precision timer if available
            }
            return 'xxxxxxxx-xxxx-xxxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
               var r = (d + Math.random() * 16) % 16 | 0;
               d = Math.floor(d / 16);
               return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
            });
         }
      });
   });