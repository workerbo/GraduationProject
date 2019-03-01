/**
 * 机会管理管理初始化
 */
var Chance = {
    id: "ChanceTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Chance.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键', field: 'id', visible: false, align: 'center', valign: 'middle'},
            {title: '机会来源', field: 'chcSource', visible: true, align: 'center', valign: 'middle'},
            {title: '客户名称', field: 'chcCustName', visible: true, align: 'center', valign: 'middle'},
            {title: '概要', field: 'chcTitle', visible: true, align: 'center', valign: 'middle'},
            {title: '成功机率', field: 'chcRate', visible: true, align: 'center', valign: 'middle'},
            {title: '联系人', field: 'chcLinkman', visible: true, align: 'center', valign: 'middle'},
            {title: '联系电话', field: 'chcTel', visible: true, align: 'center', valign: 'middle'},
            {title: '创建人编号', field: 'chcCreateId', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'chcCreateDate', visible: true, align: 'center', valign: 'middle'},
            {title: '指派的客户经理编号', field: 'chcDueId', visible: true, align: 'center', valign: 'middle'},
            {title: '指派时间', field: 'chcDueDate', visible: true, align: 'center', valign: 'middle'},
            {title: '状态：1--未指派；2--已指派3--开发成功；4--终止开发(开发失败)。', field: 'chcStatus', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Chance.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Chance.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加机会管理
 */
Chance.openAddChance = function () {
    var index = layer.open({
        type: 2,
        title: '添加机会管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/chance/chance_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看机会管理详情
 */
Chance.openChanceDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '机会管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/chance/chance_update/' + Chance.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除机会管理
 */
Chance.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/chance/delete", function (data) {
            Feng.success("删除成功!");
            Chance.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("chanceId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询机会管理列表
 */
Chance.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Chance.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Chance.initColumn();
    var table = new BSTable(Chance.id, "/chance/list", defaultColunms);
    table.setPaginationType("client");
    Chance.table = table.init();
});
