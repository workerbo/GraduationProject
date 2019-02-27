/**
 * 客户信息管理管理初始化
 */
var Customer = {
    id: "CustomerTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Customer.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键', field: 'custNo', visible: true, align: 'center', valign: 'middle'},
            {title: '客户名称', field: 'custName', visible: true, align: 'center', valign: 'middle'},
            {title: '地区', field: 'custRegion', visible: true, align: 'center', valign: 'middle'},
            {title: '客户经理编号', field: 'custManagerId', visible: true, align: 'center', valign: 'middle'},
            {title: '客户等级', field: 'custLevel', visible: true, align: 'center', valign: 'middle'},
            {title: '满意度（1-5），默认为3', field: 'custSatisfy', visible: true, align: 'center', valign: 'middle'},
            {title: '信用度（1-5），默认为3', field: 'custCredit', visible: true, align: 'center', valign: 'middle'},
            {title: '地址', field: 'custAddr', visible: true, align: 'center', valign: 'middle'},
            {title: '邮政编码', field: 'custZip', visible: true, align: 'center', valign: 'middle'},
            {title: '电话', field: 'custTel', visible: true, align: 'center', valign: 'middle'},
            {title: '网址', field: 'custWebsite', visible: true, align: 'center', valign: 'middle'},
            {title: '营业执照注册号', field: 'custLicenceNo', visible: true, align: 'center', valign: 'middle'},
            {title: '法人', field: 'custChieftain', visible: true, align: 'center', valign: 'middle'},
            {title: '注册资金', field: 'custBankroll', visible: true, align: 'center', valign: 'middle'},
            {title: '营业额', field: 'custTurnover', visible: true, align: 'center', valign: 'middle'},
            {title: '客户状态：1--正常；2--流失；3--删除。', field: 'custStatus', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Customer.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Customer.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加客户信息管理
 */
Customer.openAddCustomer = function () {
    var index = layer.open({
        type: 2,
        title: '添加客户信息管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/customer/customer_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看客户信息管理详情
 */
Customer.openCustomerDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '客户信息管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/customer/customer_update/' + Customer.seItem.custNo
        });
        this.layerIndex = index;
    }
};

/**
 * 删除客户信息管理
 */
Customer.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/customer/delete", function (data) {
            Feng.success("删除成功!");
            Customer.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("customerId",this.seItem.cutNo);
        ajax.start();
    }
};

/**
 * 查询客户信息管理列表
 */
Customer.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Customer.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Customer.initColumn();
    var table = new BSTable(Customer.id, "/customer/list", defaultColunms);
    table.setPaginationType("client");
    Customer.table = table.init();
});
