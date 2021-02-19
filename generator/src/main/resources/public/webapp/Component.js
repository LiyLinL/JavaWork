sap.ui.define([
    "sap/ui/core/UIComponent",
    'gen/core/BaseController',
    "gen/utils/decimal.min",
    "gen/utils/moment",
    "gen/utils/excelJS.min",
    "gen/utils/FileSaver"
], function (UIComponent, BaseController) {
    "use strict";
    return UIComponent.extend("gen.Component", {
        metadata: {
            manifest: "json"
        },
        init: function () {
            var me = this;

            UIComponent.prototype.init.apply(this, arguments);
            me.getRouter().initialize();
        }
    });
});