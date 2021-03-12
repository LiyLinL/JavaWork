sap.ui.define([
      'sap/ui/table/Table'
   ],
   function (Table) {
      "use strict";
      var t = Table.extend('gen.view.lib.cTable', {
         metadata: {
            library: 'gen.view.lib'
         },
         invalidate: function () {
            Table.prototype.invalidate.call(this);
         },
         renderer: function (oRm, oTable) {
            sap.ui.table.TableRenderer.render(oRm, oTable);
            oRm.write("<Label>");
            oRm.write(":");
            oRm.write("</Label>");
         },
         onAfterRendering: function () {
            Table.prototype.onAfterRendering.apply(this);
         }
      });
      return t;
   });