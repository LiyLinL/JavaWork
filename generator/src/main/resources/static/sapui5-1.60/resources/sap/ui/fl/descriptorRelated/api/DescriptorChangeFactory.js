/*!
 * OpenUI5
 * (c) Copyright 2009-2020 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.define(["sap/ui/fl/ChangePersistenceFactory","sap/ui/fl/Change","sap/ui/fl/descriptorRelated/internal/Utils","sap/ui/fl/registry/Settings","sap/ui/fl/Utils","sap/ui/fl/LayerUtils","sap/base/util/merge"],function(C,a,U,S,F,L,b){"use strict";var D=function(m,i,s){this._mChangeFile=m;this._mChangeFile.packageName='$TMP';this._oInlineChange=i;this._sTransportRequest=null;this._oSettings=s;};D.prototype.setTransportRequest=function(t){try{U.checkTransportRequest(t);}catch(e){return Promise.reject(e);}this._sTransportRequest=t;return Promise.resolve();};D.prototype.setPackage=function(p){try{U.checkPackage(p);}catch(e){return Promise.reject(e);}this._mChangeFile.packageName=p;return Promise.resolve();};D.prototype.submit=function(){this.store();var o=this._getChangePersistence(this._mChangeFile.reference);return o.saveDirtyChanges();};D.prototype.store=function(){var s=this._mChangeFile.reference;var A=this._mChangeFile.validAppVersions.creation;var o=this._getChangePersistence(s,A);var d=this._getChangeToSubmit();o.addChange(d);return d;};D.prototype._getChangePersistence=function(s,A){return C.getChangePersistenceForComponent(s,A);};D.prototype._getChangeToSubmit=function(){var o=new a(this._getMap());if(this._sTransportRequest){o.setRequest(this._sTransportRequest);}else if(this._oSettings.isAtoEnabled()&&L.isCustomerDependentLayer(this._mChangeFile.layer)){o.setRequest('ATO_NOTIFICATION');}return o;};D.prototype._getMap=function(){var i=this._oInlineChange.getMap();this._mChangeFile.content=i.content;this._mChangeFile.texts=i.texts;return this._mChangeFile;};D.prototype.getJson=function(){return b({},this._getMap());};var c=function(){};c.prototype.createNew=function(r,i,l,A,t){var s=function(_,I){if(_["setHostingIdForTextKey"]){_.setHostingIdForTextKey(I);}};s(i,r);var d;if(A){d=A.appVersion;if(!A.appId&&!d){var m=A.getManifest();d=F.getAppVersionFromManifest(m);}}var p={};p.changeType=i._getChangeType();p.componentName=r;p.reference=r;p.validAppVersions=d?{creation:d,from:d}:{};p.generator=t;p.layer=l||'CUSTOMER';var e=a.createInitialFileContent(p);return S.getInstance().then(function(o){return Promise.resolve(new D(e,i,o));});};return c;},true);
