/*!
 * OpenUI5
 * (c) Copyright 2009-2020 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.define(["sap/ui/rta/plugin/BaseCreate","sap/ui/fl/Utils","sap/ui/rta/Utils","sap/ui/dt/Util","sap/base/util/uid","sap/ui/rta/plugin/iframe/SettingsDialog"],function(B,F,R,D,u,I){"use strict";var A=B.extend("sap.ui.rta.plugin.AddIFrame",{metadata:{library:"sap.ui.rta",properties:{},associations:{},events:{}}});A.prototype._getAddIFrameCommand=function(m,s,d,v){var V=F.getViewForControl(m);var b=V.createId(u());var w;var h;if(s.frameWidth){w=s.frameWidth+s.frameWidthUnit;}else{w="100%";}if(s.frameHeight){h=s.frameHeight+s.frameHeightUnit;}else{h="100%";}return this.getCommandFactory().getCommandFor(m,"addIFrame",{targetAggregation:s.aggregation,baseId:b,index:s.index,url:s.frameUrl,width:w,height:h},d,v);};A.prototype.handleCreate=function(m,o){var a=m.action;var p=this._getParentOverlay(m.isSibling,o);var P=p.getElement();var d=p.getDesignTimeMetadata();var s;if(m.isSibling){s=o.getElement();}var g=d.getAggregation(a.aggregation).getIndex;var i=this._determineIndex(P,s,a.aggregation,g);var v=this.getVariantManagementReference(p);var b=new I();var c={urlBuilderParameters:I.buildUrlBuilderParametersFor(P)};b.open(c).then(function(S){if(!S){return Promise.reject();}S.index=i;S.aggregation=a.aggregation;return this._getAddIFrameCommand(P,S,d,v);}.bind(this)).then(function(C){this.fireElementModified({command:C,newControlId:C.getBaseId(),action:a});}.bind(this)).catch(function(M){if(M){throw D.createError("AddIFrame#handler",M,"sap.ui.rta");}});};A.prototype.buildMenuItem=function(m){return Object.assign({text:this.getCreateMenuItemText.bind(this,m,"CTX_ADDIFRAME"),handler:this.handler.bind(this,m),enabled:this.isEnabled.bind(this,m)},m);};A.prototype.getMenuItems=function(e){var b=140;var m=[];var t=sap.ui.getCore().getLibraryResourceBundle("sap.ui.rta");var i=t.getText("CTX_ADDIFRAME_GROUP");if(this.isAvailable(true,e)){var a=this.getCreateAction(true,e[0]);if(a){m.push(this.buildMenuItem({isSibling:true,action:a,id:"CTX_CREATE_SIBLING_IFRAME",icon:"sap-icon://add-product",rank:b,group:i}));b+=10;}}if(this.isAvailable(false,e)){m=m.concat(this.getCreateActions(false,e[0]).map(function(a,c){return this.buildMenuItem({isSibling:false,action:a,id:"CTX_CREATE_CHILD_IFRAME_"+a.aggregation.toUpperCase(),icon:"sap-icon://add-product",rank:b+10*c,group:i});},this));}return m;};A.prototype.getActionName=function(){return"addIFrame";};return A;});
