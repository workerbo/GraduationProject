/**
 * 客户流失管理初始化
 */
var Lost = {
    id: "LostTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Lost.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '编号（主键自动增长1）', field: 'id', visible: false, align: 'center', valign: 'middle'},
            {title: '客户编号', field: 'lstCustNo', visible: true, align: 'center', valign: 'middle'},
            {title: '客户经理编号', field: 'lstCustManagerId', visible: true, align: 'center', valign: 'middle'},
            {title: '上次下单时间', field: 'lstLastOrderDate', visible: true, align: 'center', valign: 'middle'},
            {title: '确认流失时间', field: 'lstLostDate', visible: true, align: 'center', valign: 'middle'},
            {title: '暂缓措施', field: 'lstDelay', visible: true, align: 'center', valign: 'middle'},
            {title: '流失原因', field: 'lstReason', visible: true, align: 'center', valign: 'middle'},
            {title: '流失状态 1-警告，2-暂缓流失，3-已流失', field: 'lstStatus', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Lost.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Lost.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加客户流失
 */
Lost.openAddLost = function () {
    var index = layer.open({
        type: 2,
        title: '添加客户流失',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/lost/lost_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看客户流失详情
 */
Lost.openLostDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '客户流失详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/lost/lost_update/' + Lost.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除客户流失
 */
Lost.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/lost/delete", function (data) {
            Feng.success("删除成功!");
            Lost.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("lostId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询客户流失列表
 */
Lost.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Lost.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Lost.initColumn();
    var table = new BSTable(Lost.id, "/lost/list", defaultColunms);
    table.setPaginationType("client");
    Lost.table = table.init();
});
