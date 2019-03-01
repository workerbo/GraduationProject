/**
 * 客户服务管理初始化
 */
var Customerservice = {
    id: "CustomerserviceTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Customerservice.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '服务编号', field: 'id', visible: false, align: 'center', valign: 'middle'},
            {title: '服务类型', field: 'svrType', visible: true, align: 'center', valign: 'middle'},
            {title: '服务概要', field: 'svrTitle', visible: true, align: 'center', valign: 'middle'},
            {title: '客户编号', field: 'svrCustNo', visible: true, align: 'center', valign: 'middle'},
            {title: '服务状态', field: 'svrStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '服务请求', field: 'svrRequest', visible: true, align: 'center', valign: 'middle'},
            {title: '创建人编号', field: 'svrCreateId', visible: true, align: 'center', valign: 'middle'},
            {title: '创建日期', field: 'svrCreateDate', visible: true, align: 'center', valign: 'middle'},
            {title: '分配给某人的编号', field: 'svrDueId', visible: true, align: 'center', valign: 'middle'},
            {title: '分配时间', field: 'svrDueDate', visible: true, align: 'center', valign: 'middle'},
            {title: '服务处理', field: 'svrDeal', visible: true, align: 'center', valign: 'middle'},
            {title: '处理日期', field: 'svrDealDate', visible: true, align: 'center', valign: 'middle'},
            {title: '处理结果', field: 'svrResult', visible: true, align: 'center', valign: 'middle'},
            {title: '满意度', field: 'svrSatisfy', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Customerservice.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Customerservice.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加客户服务
 */
Customerservice.openAddCustomerservice = function () {
    var index = layer.open({
        type: 2,
        title: '添加客户服务',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/customerservice/customerservice_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看客户服务详情
 */
Customerservice.openCustomerserviceDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '客户服务详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/customerservice/customerservice_update/' + Customerservice.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除客户服务
 */
Customerservice.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/customerservice/delete", function (data) {
            Feng.success("删除成功!");
            Customerservice.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("customerserviceId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询客户服务列表
 */
Customerservice.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Customerservice.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Customerservice.initColumn();
    var table = new BSTable(Customerservice.id, "/customerservice/list", defaultColunms);
    table.setPaginationType("client");
    Customerservice.table = table.init();
});
