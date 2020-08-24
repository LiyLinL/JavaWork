sap.ui.define([
   'sap/ui/core/Fragment',
   "sap/ui/base/Object",
   'sap/ui/model/json/JSONModel',
   'sap/m/MessageBox'
], function (Fragment, Object, JSONModel, MessageBox) {
   "use strict";
   return Object.extend("yo.me.packing.packingOut", {
      showDialog: function (me, obj) {
         this.me = me;
         var dialog = Fragment.byId("Dialog", "Dialog");
         var I18N = me.getModel("i18n").getResourceBundle()
         if (dialog) { //未關閉時銷毀
            dialog.destroy();
            dialog = null;
         }
         if (!this.dialog) {
            this.dialog = sap.ui.xmlfragment("Dialog", "gen.view.single.Dialog", this);
         }
         this.dialog.setModel(me.getModel("i18n"), "i18n");
         this.dialog.setModel(new JSONModel({
            obj: obj,
            typeItem: [{
                  text: "Type01",
                  type: "Type01"
               },
               {
                  text: "Type02",
                  type: "Type02"
               },
               {
                  text: "Type03",
                  type: "Type03"
               },
               {
                  text: "Type04",
                  type: "Type04"
               },
               {
                  text: "Type05",
                  type: "Type05"
               }
            ]
         }));
         Fragment.byId("Dialog", "appTitle").setValue(obj.title);
         Fragment.byId("Dialog", "moreInfo").setValue(obj.text);
         Fragment.byId("Dialog", "DTPStartDate").setDateValue(obj.startDate);
         Fragment.byId("Dialog", "DTPEndDate").setDateValue(obj.endDate);
         this.dialog.open();
         return this;
      },
      handleDialogCancelButton: function () {
         this.dialog.destroy();
         this.dialog = null;
      },
      handleDialogOkButton: function () {
         var sTitle = Fragment.byId("Dialog", "appTitle").getValue(),
            sText = Fragment.byId("Dialog", "moreInfo").getValue(),
            oStartDate = Fragment.byId("Dialog", "DTPStartDate").getDateValue(),
            oEndDate = Fragment.byId("Dialog", "DTPEndDate").getDateValue(),
            sType = Fragment.byId("Dialog", "typeInfo").getSelectedItem().getKey(),
            mData = this.me.getData();
         var oData = this.dialog.getModel().getData();

         if (oStartDate !== "Error" && oEndDate !== "Error") {
            if (oData.obj.type === 'edit') {
               let sPath = oData.obj.sPath;
               mData.appointments[sPath].title = sTitle;
               mData.appointments[sPath].text = sText;
               mData.appointments[sPath].startDate = oStartDate;
               mData.appointments[sPath].endDate = oEndDate;
               mData.appointments[sPath].type = sType;
               this.me.refresh();
            } else {
               mData.appointments.push({
                  title: sTitle,
                  text: sText,
                  startDate: oStartDate,
                  endDate: oEndDate
               });
               this.me.refresh();
            }
            this.handleDialogCancelButton();
         }
      },
   });
});