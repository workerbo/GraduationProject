/**
 * 交往记录管理初始化
 */
var Activity = {
    id: "ActivityTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Activity.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键', field: 'id', visible: false, align: 'center', valign: 'middle'},
            {title: '客户编号', field: 'atvCustNo', visible: true, align: 'center', valign: 'middle'},
            {title: '交往日期', field: 'atvDate', visible: true, align: 'center', valign: 'middle'},
            {title: '交往地点', field: 'atvPlace', visible: true, align: 'center', valign: 'middle'},
            {title: '交往概要', field: 'atvTitle', visible: true, align: 'center', valign: 'middle'},
            {title: '详细信息', field: 'atvDesc', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Activity.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Activity.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加交往记录
 */
Activity.openAddActivity = function () {
    var index = layer.open({
        type: 2,
        title: '添加交往记录',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/activity/activity_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看交往记录详情
 */
Activity.openActivityDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '交往记录详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/activity/activity_update/' + Activity.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除交往记录
 */
Activity.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/activity/delete", function (data) {
            Feng.success("删除成功!");
            Activity.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("activityId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询交往记录列表
 */
Activity.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Activity.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Activity.initColumn();
    var table = new BSTable(Activity.id, "/activity/list", defaultColunms);
    table.setPaginationType("client");
    Activity.table = table.init();
});
