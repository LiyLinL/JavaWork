sap.ui.define(['sap/ui/core/mvc/Controller'], function (Controller) {
  'use strict';
  return Controller.extend('view.Main', {
    onInit: function () {
      var me = this;
      var oView = this.getView();
      var oTable = oView.byId('table');
      this.getView().setModel(
        new sap.ui.model.json.JSONModel({
          table: [],
          visible: '',
          rows: 20
        })
      );

      var oData = this.getView().getModel().getData();
      var api = 'http://localhost:90/sfc?site=1000&order=ShopOrderBO:1000,P_2020041502';
      // 取得總數
      $.ajax({
        url: 'http://localhost:90/sfc/cnt?site=1000&order=ShopOrderBO:1000,P_2020041502',
        type: 'GET',
        cache: false,
        async: false,
        dataType: 'html',
        processData: false,
        contentType: false,
        headers: {
          'Accept-Language': 'zh'
        }
      }).done(function (res) {
        me.createButton('box', res, oData.rows, api, function (res) {
          oData.table = [];
          res.forEach(v => {
            oData.table.push({
              'row': v.row,
              'sfc': v.sfc,
              'item': v.itemBo.split(',')[1]
            });
          });
          me.getView().getModel().refresh();
        });
      }).fail(function (jqXHR, textStatus) {
        console.log(jqXHR.responseJSON.status);
      });
      // 貼上儲存格
      oTable.attachBrowserEvent('paste', function (e) {
        e.preventDefault();
        var text = e.originalEvent.clipboardData.getData('text/plain');
        var oData = me.getView().getModel().getData();
        var arr = text.split('\n').map(x => {
          var obj = {};
          var sp = x.split('\t');
          obj.sfc = sp[0];
          obj.item = sp[1];
          return obj;
        });
        if (oData.table.lenght == 0) {
          oData.table = arr;
          me.getView().getModel().refresh();
        } else {
          arr.forEach(v => {
            oData.table.push(v);
            me.getView().getModel().refresh();
          });
        }
      });

    },
    createButton: function (flexId, totalRow, visibleRow, api, result, msg, msgfun) {
      var me = this;
      var view = this.getView();
      var oData = this.getView().getModel().getData();
      var flex = view.byId(flexId);
      var total = totalRow;
      oData.visible = visibleRow;
      var page = Math.round(total / oData.visible);

      // 前後按鈕Function
      var click = function (oEvent) {
        let source = oEvent.getSource();
        let nPage = source.getCustomData()[0].getValue(); // 現在頁數
        let surplus = total - (nPage * oData.visible); // 剩餘筆數
        let item = [];
        // 頁數往後
        if (nPage % 5 == 0 && nPage * oData.visible < total) {
          flex.destroyItems();
          if (Math.round(surplus / oData.visible) >= 5) { // 超過五頁以上
            if (nPage != 0) { // 第一頁不產生往前按鈕
              // 往前按鈕
              flex.addItem(
                new sap.m.Button({
                  text: '...',
                  press: click,
                  customData: new sap.ui.core.CustomData({
                    key: 'page',
                    value: nPage - 5
                  })
                })
              )
            }
            // 頁數按鈕
            for (let i = nPage; i < nPage + 5; i++) {
              flex.addItem(
                new sap.m.Button({
                  text: i + 1,
                  press: link,
                  customData: new sap.ui.core.CustomData({
                    key: 'page',
                    value: i + 1
                  })
                })
              )
            }
            if ((nPage + 5) * oData.visible < total) { // 最後一頁不產生往後按鈕
              // 往後按鈕
              flex.addItem(
                new sap.m.Button({
                  text: '...',
                  press: click,
                  customData: new sap.ui.core.CustomData({
                    key: 'page',
                    value: nPage + 5
                  })
                })
              )
            }
          } else {
            // 剩餘筆數小於可見筆數不在產生多餘按鈕
            var v = Math.round(surplus / oData.visible)
            if (v < 5) { // 不足五頁
              // 往前按鈕
              flex.addItem(
                new sap.m.Button({
                  text: '...',
                  press: click,
                  customData: new sap.ui.core.CustomData({
                    key: 'page',
                    value: nPage - 5
                  })
                })
              )
              // 頁數按鈕
              for (let i = nPage; i < nPage + v; i++) {
                flex.addItem(
                  new sap.m.Button({
                    text: i + 1,
                    press: link,
                    customData: new sap.ui.core.CustomData({
                      key: 'page',
                      value: i + 1
                    })
                  })
                )
              }
            }
          }
        }

        // 下拉選單
        for (let i = 0; i < 5; i++) {
          item.push(new sap.ui.core.Item({
            key: oData.rows * (i + 1),
            text: oData.rows * (i + 1)
          }))
        }
        flex.addItem(new sap.m.Select({
          id: 'select',
          selectedKey: oData.visible,
          items: item,
          change: sChange
        }));
      };

      // 分頁按鈕Function
      var link = function (oEvent) {
        // new ajax(me.getWebApi()).get(api, 'json', function (res) {
        //   result(res);
        // }, function (error) {
        //   if (msgfun) {
        //     me.showMessageClose(error, msgfun());
        //   } else {
        //     msg(error);
        //   }
        // });
        var source = oEvent.getSource();
        var nPage = source.getCustomData()[0].getValue(); // 現在頁數
        var first = (nPage - 1) * oData.visible + 1;
        var last = (nPage * oData.visible) + 1;

        $.ajax({
          url: api + '&first=' + first + '&last=' + last,
          type: 'GET',
          cache: false,
          async: false,
          dataType: 'JSON',
          processData: false,
          contentType: false,
          headers: {
            'Accept-Language': 'zh'
          }
        }).done(function (res) {
          result(res);
        }).fail(function (jqXHR, textStatus) {
          console.log(jqXHR.responseJSON.status);
        });
      };

      // 選單Function
      var sChange = function (oEvent) {
        oData.table = [];
        oData.visible = oEvent.getParameters().selectedItem.getText();
        let nPage = 0;
        let surplus = total - (nPage * oData.visible); // 剩餘筆數
        let item = [];

        flex.destroyItems();
        if (Math.round(surplus / oData.visible) >= 5) { // 超過五頁以上
          if (nPage != 0) { // 第一頁不產生往前按鈕
            // 往前按鈕
            flex.addItem(
              new sap.m.Button({
                text: '...',
                press: click,
                customData: new sap.ui.core.CustomData({
                  key: 'page',
                  value: nPage - 5
                })
              })
            )
          }
          // 頁數按鈕
          for (let i = nPage; i < nPage + 5; i++) {
            flex.addItem(
              new sap.m.Button({
                text: i + 1,
                press: link,
                customData: new sap.ui.core.CustomData({
                  key: 'page',
                  value: i + 1
                })
              })
            )
          }
          if ((nPage + 5) * oData.visible < total) { // 最後一頁不產生往後按鈕
            // 往後按鈕
            flex.addItem(
              new sap.m.Button({
                text: '...',
                press: click,
                customData: new sap.ui.core.CustomData({
                  key: 'page',
                  value: nPage + 5
                })
              })
            )
          }
        } else {
          // 剩餘筆數小於可見筆數不在產生多餘按鈕
          var v = Math.round(surplus / oData.visible)
          if (v < 5) { // 不足五頁
            // 往前按鈕
            flex.addItem(
              new sap.m.Button({
                text: '...',
                press: click,
                customData: new sap.ui.core.CustomData({
                  key: 'page',
                  value: nPage - 5
                })
              })
            )
            // 頁數按鈕
            for (let i = nPage; i < nPage + v; i++) {
              flex.addItem(
                new sap.m.Button({
                  text: i + 1,
                  press: link,
                  customData: new sap.ui.core.CustomData({
                    key: 'page',
                    value: i + 1
                  })
                })
              )
            }
          }
        }
        // 創建選單
        for (let i = 0; i < 5; i++) {
          item.push(new sap.ui.core.Item({
            key: oData.rows * (i + 1),
            text: oData.rows * (i + 1)
          }))
        }
        flex.addItem(new sap.m.Select({
          id: 'select',
          selectedKey: oData.visible,
          items: item,
          change: sChange
        }));
        me.getView().getModel().refresh();
      };

      // 產生初始按鈕
      if (page > 5) {
        // 頁數按鈕
        for (let i = 0; i < 5; i++) {
          flex.addItem(
            new sap.m.Button({
              text: i + 1,
              press: link,
              customData: new sap.ui.core.CustomData({
                key: 'page',
                value: i + 1
              })
            })
          )
        }
        // 往後按鈕
        flex.addItem(
          new sap.m.Button({
            text: '...',
            press: click,
            customData: new sap.ui.core.CustomData({
              key: 'page',
              value: 5
            })
          })
        )
      } else {
        for (let i = 0; i < page; i++) {
          flex.addItem(
            new sap.m.Button({
              text: i + 1,
              press: link,
              customData: new sap.ui.core.CustomData({
                key: 'page',
                value: i + 1
              })
            })
          )
        }
      }

      // 初始筆數按鈕
      let item = [];
      for (let i = 0; i < 5; i++) {
        item.push(new sap.ui.core.Item({
          key: oData.rows * (i + 1),
          text: oData.rows * (i + 1)
        }))
      }
      flex.addItem(new sap.m.Select({
        id: 'select',
        selectedKey: oData.visible,
        items: item,
        change: sChange
      }));
    }
  });
});