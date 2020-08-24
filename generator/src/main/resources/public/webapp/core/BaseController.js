sap.ui.define([
    "sap/ui/core/mvc/Controller",
    "sap/m/MessageToast",
    'sap/m/MessageBox',
    "sap/m/Button",
    "sap/m/Dialog",
    "sap/m/Text",
    "jquery.sap.global"
], function (Controller, MessageToast, MessageBox) {
    "use strict";
    return Controller.extend("gen.core.BaseController", {

        /**
         * Convenience method for accessing the router.
         * @public
         * @returns {sap.ui.core.routing.Router} the router for this component
         */
        getRouter: function () {
            return sap.ui.core.UIComponent.getRouterFor(this);
        },

        getI18N: function (sName) {
            if (sName) {
                return this.getModel(sName).getResourceBundle();
            } else {
                return this.getModel("i18n").getResourceBundle();
            }
        },

        /**
         * Convenience method for getting the view model by name.
         * @public
         * @param {string} sName the model name
         * @returns {sap.ui.model.Model} the model instance
         */
        getModel: function (sName) {
            return sName == undefined ?
                this.getView().getModel() :
                this.getView().getModel(sName);
        },
        getProperty: function (sPath, sName) {
            return sName == undefined ?
                this.getView().getModel().getProperty(sPath) :
                this.getView().getModel(sName).getProperty(sPath);
        },
        getPath: function (oEvent, sName) {
            return sName == undefined ?
                oEvent.getSource().getBindingContext(undefined).getPath() :
                oEvent.getSource().getBindingContext(sName).getPath();
        },
        getBindData: function (oEvent, sName) {
            return sName == undefined ?
                this.getProperty(this.getPath(oEvent, undefined), undefined) :
                this.getProperty(this.getPath(oEvent, sName), sName)
        },
        getData: function (sName) {
            return sName == undefined ?
                this.getView().getModel().getData() :
                this.getView().getModel(sName).getData();
        },
        refresh: function (sName) {
            return sName == undefined ?
                this.getView().getModel().refresh() :
                this.getView().getModel(sName).refresh();
        },

        /**
         * Convenience method for setting the view model.
         * @public
         * @param {object} oModel the model instance
         * @param {string} sName the model name
         * @returns {sap.ui.mvc.View} the view instance
         */
        setModel: function (oModel, sName) {
            return sName == undefined ?
                this.getView().setModel(new sap.ui.model.json.JSONModel(oModel)).getModel().getData() :
                this.getView().setModel(new sap.ui.model.json.JSONModel(oModel), sName).getModel(sName).getData();
        },
        getSite: function () {
            var site = undefined;
            $.ajax({
                type: "get",
                async: false,
                url: location.protocol + "//" + location.host + "/manufacturing/com/sap/me/activity/client/ActivityManager.jsp",
                dataType: "html",
                crossDomain: true,
                success: function (data) {
                    var el = document.createElement('html');
                    el.innerHTML = data;
                    for (var i = 0; el.getElementsByTagName('script').length; i++) {
                        if (el.getElementsByTagName('script')[i].innerHTML.match("siteChange,") == "siteChange,") {
                            site = el.getElementsByTagName('script')[i].innerHTML.split(":")[3].split("\"")[0].trim();
                            break;
                        }
                    }
                },
                error: function (err) {
                    jQuery.sap.log.error(err.message);
                    return;
                }
            });
            return site;
        },
        getUser: function () {
            var user;
            $.ajax({
                type: "get",
                async: false,
                url: location.protocol + "//" + location.host + "/manufacturing-odata/AppConfig.svc/GetSiteForUser",
                dataType: "json",
                crossDomain: true,
                success: function (data) {
                    user = data.d.GetSiteForUser.userId;
                },
                error: function (err) {
                    jQuery.sap.log.error(err.message);
                    return;
                }
            });
            return user;
        },

        /**
         * Convenience method for getting the root url of web api.
         * @public
         * @returns {string} the url.
         */
        getWebApi: function () {
            // return this.getOwnerComponent().getManifestEntry("sap.ui5").config.webapi;
            return location.protocol + "//" + location.host + "/manufacturing-app/api/v1";
        },

        showMessage: function (errorCode) {
            if (errorCode.responseText != undefined && errorCode.responseText != "") {
                if (typeof errorCode.responseText == 'string') {
                    try {
                        errorCode = JSON.parse(errorCode.responseText);
                        MessageBox.error("message : " + errorCode.message);
                    } catch (e) {
                        MessageBox.error(errorCode.status + " " + errorCode.statusText);
                    }
                }
            } else {
                MessageBox.error("error,please check");
            }
            throw errorCode;
        },

        showMessageClose: function (errorCode, funct) {
            if (errorCode.responseText != undefined && errorCode.responseText != "") {
                if (typeof errorCode.responseText == 'string') {
                    try {
                        errorCode = JSON.parse(errorCode.responseText);
                        MessageBox.error("message : " + errorCode.message, {
                            onClose: function () {
                                funct();
                            }
                        });
                    } catch (e) {
                        MessageBox.error(errorCode.status + " " + errorCode.statusText);
                    }
                }
            } else {
                MessageBox.error("error,please check");
            }
        },

        /**
         * Convenience method for getting the configuration from manifest.
         * @public
         * @param {string} sName the route name.
         * @param {function} handle Callback of attachPatternMatched.
         */
        attachPatternMatched: function (sName, handle) {
            var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
            oRouter.getRoute(sName).attachPatternMatched(handle, this);
        },
        /**
         * 取得ui:table的選擇
         */
        getIndex: function (evt, modelName) {
            if (modelName) {
                return evt.getSource().oPropagatedProperties.oBindingContexts[modelName].sPath.split("/")[2];
            } else {
                return evt.getSource().oPropagatedProperties.oBindingContexts[undefined].sPath.split("/")[2];
            }
        },
        isEmpty: function (array, textArray) {
            var I18N = this.getI18N();
            for (let i = 0; i < array.length; i++) {
                const element = array[i];
                if (!element) {
                    var message = '「' + I18N.getText(textArray[i]) + '」' + I18N.getText("g.is.empty");
                    MessageBox.error(message);
                    throw message;
                }
            }
        },
        checkData: function (data, message) {
            if (data.length == 0) {
                if (!message) {
                    message = this.getI18N().getText('g.retrieve.please');
                }
                MessageBox.error(message);
                throw message;
            }
        },
        confirmMessage: function (message, funct, cancel) {
            MessageBox.confirm(message, {
                actions: [MessageBox.Action.OK, MessageBox.Action.CANCEL],
                onClose: function (sAction) {
                    if (sAction == 'OK') {
                        if (funct) {
                            funct();
                        }
                    } else {
                        if (cancel) {
                            cancel();
                        }
                    }
                }
            });
        },
        newJson: function (json) {
            return JSON.parse(JSON.stringify(json));
        },
        getDateRange: function (key, format) {
            var time = {
                "start": "",
                "end": ""
            };
            switch (key) {
                case "0": //今天
                    time.start = moment().day(moment().day()).startOf('day').format(format);
                    time.end = moment().day(moment().day()).endOf('day').format(format);
                    break;
                case "1": //昨天
                    time.start = moment().day(moment().day() - 1).startOf('day').format(format);
                    time.end = moment().day(moment().day() - 1).endOf('day').format(format);
                    break;
                case "2": //本周
                    time.start = moment().week(moment().week()).startOf('week').format(format);
                    time.end = moment().week(moment().week()).endOf('week').format(format);
                    break;
                case "3": //上週
                    time.start = moment().week(moment().week() - 1).startOf('week').format(format);
                    time.end = moment().week(moment().week() - 1).endOf('week').format(format);
                    break;
                case "4": //本月
                    time.start = moment().month(moment().month()).startOf('month').format(format);
                    time.end = moment().month(moment().month()).endOf('month').format(format);
                    break;
                case "5": //上個月
                    time.start = moment().month(moment().month() - 1).startOf('month').format(format);
                    time.end = moment().month(moment().month() - 1).endOf('month').format(format);
                    break;
                case "6": //今年
                    time.start = moment().year(moment().year()).startOf('year').format(format);
                    time.end = moment().year(moment().year()).endOf('year').format(format);
                    break;
                case "7": //去年
                    time.start = moment().year(moment().year() - 1).startOf('year').format(format);
                    time.end = moment().year(moment().year() - 1).endOf('year').format(format);
                    break;
            }
            return time;
        },
        /**
         * 驗證日期
         * @param {陣列，時間資料} times 
         * @param {陣列，資料名稱} array 
         * @param {時間格式} format 
         */
        validDate: function (times, array, format) {
            var I18N = this.getI18N();
            for (let i = 0; i < times.length; i++) {
                if (!moment(times[i], format, true).isValid()) {
                    var txt = "「" + I18N.getText(array[i]) + "」" + I18N.getText("g.is.wrong");
                    MessageBox.error(txt);
                    throw txt;
                }
            }
        },

        /**
         * 
         * @param {設定的陣列} arr 
         * @param {排序的key} key 
         * @param {*} flag 
         */
        sort: function (arr, key, flag) {
            if (flag) {
                return arr.sort((a, b) => a[key] < b[key] ? 1 : a[key] == b[key] ? 0 : -1);
            } else {
                return arr.sort((a, b) => a[key] > b[key] ? 1 : a[key] == b[key] ? 0 : -1);
            }
        },
        /**
         * 
         * @param {為json} arr 
         * @param {設定的key} key 
         */
        setSeq(arr, key) {
            for (let i = 0; i < arr.length; i++) {
                arr[i][key] = i + 1;
            }
            return arr;
        },
        /**
         * 第一參數為i18n的key，非value
         * 其他為i18n的value中的{0},{1}...
         */
        stringFormat: function (args) {
            if (arguments.length == 0)
                return null;
            var str = arguments[0];
            for (var i = 1; i < arguments.length; i++) {
                var re = new RegExp('\\{' + (i - 1) + '\\}', 'gm');
                str = str.replace(re, arguments[i]);
            }
            return str;
        },
        error: function (txt) {
            txt = this.getI18N().getText(txt);
            MessageBox.error(txt);
            throw txt;
        },
        /**
         * 第一參數為i18n的key，非value
         * 其他為i18n的value中的{0},{1}...
         */
        i18nFormatError: function (args) {
            if (arguments.length == 0)
                return null;
            var str = this.getI18N().getText(arguments[0]);
            for (var i = 1; i < arguments.length; i++) {
                var re = new RegExp('\\{' + (i - 1) + '\\}', 'gm');
                str = str.replace(re, arguments[i]);
            }
            MessageBox.error(str);
            throw str;
        },
        handleChange: function (oEvent) {
            var oDP = oEvent.getSource(),
                bValid = oEvent.getParameter("valid");
            if (bValid) {
                oDP.setValueState(sap.ui.core.ValueState.None);
            } else {
                oDP.setValueState(sap.ui.core.ValueState.Error);
            }
        },
        /**
         * 預設跳過'site', 'user', 'activity'
         * @param {json 清除的資料} data 
         * @param {array 跳過的key} exclude 
         */
        clearData: function (data, exclude) {
            var keys = ['site', 'user', 'activity'];
            var include = Object.keys(data);
            if (exclude) {
                keys = keys.concat(exclude);
            }
            for (let i = 0; i < include.length; i++) {
                if (keys.indexOf(include[i]) != -1) {
                    continue;
                }
                switch (typeof data[include[i]]) {
                    case 'string':
                        data[include[i]] = '';
                        break;
                    case 'number':
                        data[include[i]] = '';
                        break;
                    case 'boolean':
                        data[include[i]] = false;
                        break;
                    case 'object':
                        if (Array.isArray(data[include[i]])) {
                            data[include[i]] = [];
                        }
                        break;
                }
            }
        },
        /**
         * 
         * @param {'new','before','after','delete','all'} doWhat 
         * @param {表id，僅限listBase的table} tableId 
         */
        doTable: function (doWhat, tableId) {
            var me = this;
            var oData = this.getData();
            var table = this.byId(tableId);
            var path = table.getBinding("rows").getPath();
            var indices = table.getSelectedIndices();
            if (doWhat == 'new') {
                oData[path].push({});
            } else if (doWhat == 'all') {
                oData[path] = [];
            } else if (indices.length != 0) {
                switch (doWhat) {
                    case 'before':
                        oData[path].splice(indices[0], 0, {});
                        break;
                    case 'after':
                        oData[path].splice(indices[0] + 1, 0, {});
                        break;
                    case 'delete':
                        indices.reverse().forEach(function (index) {
                            oData[path].splice(index, 1);
                        });
                        break;
                }
            }
            me.setSeq(me.getData()[path], 'seq');
            table.clearSelection();
            me.refresh();
        },
        removeAllEventDelegate: function () {
            for (var i = this.oView.aDelegates.length - 1; i >= 0; i--) {
                this.oView.removeEventDelegate(this.oView.aDelegates[i]);
            }
        },
        /**
         * 
         * @param {表id} id 
         * @param {boolean}} functKey 回傳是否讓checkBox選擇，function(value,index,array)
         */
        changeTebelAllCheckBox: function (id, functKey) {
            var me = this;
            var table = me.byId(id);
            var data = this.getProperty(table.getBindingInfo('items').path);
            var items = [];
            for (let i = 0; i < data.length; i++) {
                let item = table.getAggregation('items')[i];
                let checkBox = sap.ui.getCore().byId(item.sId + "-selectMulti");
                let flag = functKey(data[i], i, data);
                if (flag) {
                    items.push({
                        id: item.sId + "-selectMulti",
                        path: checkBox.getBindingContext(undefined).getPath()
                    });
                }
                //設定checkBox能選
                checkBox.setEnabled(flag);
                checkBox.mEventRegistry.select[0].fFunction = function (evt) {
                    var path = evt.getSource().getBindingContext(undefined).getPath();

                    //設定選擇後是否要打勾全選
                    if (evt.getParameter('selected')) {
                        let all = true;
                        for (let j = 0; j < items.length; j++) {
                            if (sap.ui.getCore().byId(items[j].id).getSelected() == false) {
                                all = false;
                            }
                        }
                        table._selectAllCheckBox.setSelected(all);
                        table._aSelectedPaths.push(path);
                    } else {
                        //全選取消
                        table._selectAllCheckBox.setSelected(false);
                        table._aSelectedPaths.splice(table._aSelectedPaths.indexOf(path), 1);
                    }
                }
            }
            if (data.length) {
                table._selectAllCheckBox.mEventRegistry.select[0].fFunction = function (evt) {
                    if (evt.getParameter('selected') && (table.getAggregation('items').length == 0 || items.length == 0)) {
                        table._selectAllCheckBox.setSelected(false);
                    } else {
                        for (let i = 0; i < items.length; i++) {
                            var index = table._aSelectedPaths.indexOf(items[i].path);
                            if (evt.getParameter('selected')) {
                                sap.ui.getCore().byId(items[i].id).setSelected(true);
                                if (index == -1) {
                                    table._aSelectedPaths.push(items[i].path);
                                }
                            } else {
                                sap.ui.getCore().byId(items[i].id).setSelected(false);
                                if (index != -1) {
                                    table._aSelectedPaths.splice(index, 1);
                                }
                            }
                        }
                    }
                }
            }
        }
    });

});