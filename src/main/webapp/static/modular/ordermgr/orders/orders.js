/**
 * 订单管理管理初始化
 */
var Orders = {
    id: "OrdersTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Orders.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '订单编号（自动增长1，1）', field: 'id', visible: false, align: 'center', valign: 'middle'},
            {title: '订单客户公司编号', field: 'odrCustomerNo', visible: true, align: 'center', valign: 'middle'},
            {title: '订单日期', field: 'odrDate', visible: true, align: 'center', valign: 'middle'},
            {title: '地址', field: 'odrAddr', visible: true, align: 'center', valign: 'middle'},
            {title: '状态(5:已发货  6:已回款)', field: 'odrStatus', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Orders.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Orders.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加订单管理
 */
Orders.openAddOrders = function () {
    var index = layer.open({
        type: 2,
        title: '添加订单管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/orders/orders_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看订单管理详情
 */
Orders.openOrdersDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '订单管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/orders/orders_update/' + Orders.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除订单管理
 */
Orders.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/orders/delete", function (data) {
            Feng.success("删除成功!");
            Orders.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("ordersId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询订单管理列表
 */
Orders.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Orders.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Orders.initColumn();
    var table = new BSTable(Orders.id, "/orders/list", defaultColunms);
    table.setPaginationType("client");
    Orders.table = table.init();
});
