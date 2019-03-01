/**
 * 客户联系人管理初始化
 */
var Linkman = {
    id: "LinkmanTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Linkman.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '联系人编号（主键自动增长）', field: 'id', visible: false, align: 'center', valign: 'middle'},
            {title: '客户编号', field: 'lkmCustNo', visible: true, align: 'center', valign: 'middle'},
            {title: '联系人名称', field: 'lkmName', visible: true, align: 'center', valign: 'middle'},
            {title: '性别', field: 'lkmSex', visible: true, align: 'center', valign: 'middle'},
            {title: '职位', field: 'lkmPostion', visible: true, align: 'center', valign: 'middle'},
            {title: '办公室电话', field: 'lkmTel', visible: true, align: 'center', valign: 'middle'},
            {title: '手机', field: 'lkmMobile', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'lkmMemo', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Linkman.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Linkman.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加客户联系人
 */
Linkman.openAddLinkman = function () {
    var index = layer.open({
        type: 2,
        title: '添加客户联系人',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/linkman/linkman_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看客户联系人详情
 */
Linkman.openLinkmanDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '客户联系人详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/linkman/linkman_update/' + Linkman.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除客户联系人
 */
Linkman.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/linkman/delete", function (data) {
            Feng.success("删除成功!");
            Linkman.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("linkmanId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询客户联系人列表
 */
Linkman.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Linkman.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Linkman.initColumn();
    var table = new BSTable(Linkman.id, "/linkman/list", defaultColunms);
    table.setPaginationType("client");
    Linkman.table = table.init();
});
