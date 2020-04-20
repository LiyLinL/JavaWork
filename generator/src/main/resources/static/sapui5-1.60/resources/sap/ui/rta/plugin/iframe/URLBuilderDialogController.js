/*!
 * OpenUI5
 * (c) Copyright 2009-2020 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.define(["sap/ui/core/mvc/Controller","sap/ui/model/Filter","sap/ui/model/FilterOperator","sap/ui/rta/Utils","sap/base/Log","sap/ui/rta/plugin/iframe/urlCleaner"],function(C,F,a,U,L,u){"use strict";return C.extend("sap.ui.rta.plugin.iframe.URLBuilderDialogController",{constructor:function(j,p){this._oJSONModel=j;this._importParameters(p);this._mParameterHashMap=this._buildParameterHashMap(p);},onShowPreview:function(){var s=this._buildPreviewURL(this._buildReturnedURL());var i=sap.ui.getCore().byId("sapUiRtaUrlBuilderIframe");i.setUrl("about:blank");try{this._oJSONModel.setProperty("/previewUrl/value",s);i.setUrl(s);}catch(e){L.error("Error previewing the URL: ",e);}},onParameterPress:function(e){var k=e.getSource().getBindingContext().getObject().key;this._oJSONModel.setProperty("/editURL/value",this._addURLParameter(k));},onSearch:function(e){var f=new F("label",a.Contains,e.getParameter("query"));var b=sap.ui.getCore().byId("sapUiRtaUrlBuilderParameterTable").getBinding("items");b.filter([f]);},onSavePress:function(){this._close(this._buildReturnedURL());},onCancelPress:function(){this._close();},_close:function(r){var o=sap.ui.getCore().byId("sapUiRtaURLBuilderDialog");this._mReturnedURL=r;o.close();},getURL:function(){return this._mReturnedURL;},_importParameters:function(p){if(p){Object.keys(p).forEach(function(f){this._oJSONModel.setProperty("/"+f+"/value",p[f]);},this);}},_buildPreviewURL:function(e){return e.replace(/{(.*?)}/g,function(m){return this._mParameterHashMap[m];}.bind(this));},_addURLParameter:function(p){return this._buildReturnedURL()+p;},_buildReturnedURL:function(){return u(this._oJSONModel.getProperty("/editURL/value"));},_buildParameterHashMap:function(p){if(p&&p.parameters){return U.buildHashMapFromArray(p.parameters,"key","value");}return{};}});});
