sap.ui.define([
    "sap/ui/core/UIComponent",
    'gen/core/BaseController',
    "gen/utils/decimal.min",
    "gen/utils/moment",
    "gen/utils/excelJS.min",
    "gen/utils/FileSaver",
    "gen/utils/dhtmlxscheduler"
], function (UIComponent, BaseController) {
    "use strict";
    return UIComponent.extend("gen.Component", {
        metadata: {
            manifest: "json"
        },
        init: function () {
            var me = this;

            jQuery.sap.includeStyleSheet(jQuery.sap.getModulePath("gen") + "/style.css?_" + new Date().getTime());
            jQuery.sap.includeStyleSheet(jQuery.sap.getModulePath("gen") + "/css/dhtmlxscheduler_material.css?_" + new Date().getTime());
            UIComponent.prototype.init.apply(this, arguments);
            me.getRouter().initialize();
        }
    });
});