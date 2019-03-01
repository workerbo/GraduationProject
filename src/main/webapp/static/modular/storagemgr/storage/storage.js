/**
 * 仓库管理管理初始化
 */
var Storage = {
    id: "StorageTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Storage.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '仓库编号自动增长1，1', field: 'id', visible: false, align: 'center', valign: 'middle'},
            {title: '商品编号', field: 'stkProdId', visible: true, align: 'center', valign: 'middle'},
            {title: '仓库名称', field: 'stkWarehouse', visible: true, align: 'center', valign: 'middle'},
            {title: '货位', field: 'stkWare', visible: true, align: 'center', valign: 'middle'},
            {title: '数量', field: 'stkCount', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'stkMemo', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Storage.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Storage.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加仓库管理
 */
Storage.openAddStorage = function () {
    var index = layer.open({
        type: 2,
        title: '添加仓库管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/storage/storage_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看仓库管理详情
 */
Storage.openStorageDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '仓库管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/storage/storage_update/' + Storage.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除仓库管理
 */
Storage.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/storage/delete", function (data) {
            Feng.success("删除成功!");
            Storage.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("storageId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询仓库管理列表
 */
Storage.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Storage.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Storage.initColumn();
    var table = new BSTable(Storage.id, "/storage/list", defaultColunms);
    table.setPaginationType("client");
    Storage.table = table.init();
});
