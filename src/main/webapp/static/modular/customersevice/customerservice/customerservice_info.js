/**
 * 初始化客户服务详情对话框
 */
var CustomerserviceInfoDlg = {
    customerserviceInfoData : {}
};

/**
 * 清除数据
 */
CustomerserviceInfoDlg.clearData = function() {
    this.customerserviceInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CustomerserviceInfoDlg.set = function(key, val) {
    this.customerserviceInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CustomerserviceInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CustomerserviceInfoDlg.close = function() {
    parent.layer.close(window.parent.Customerservice.layerIndex);
}

/**
 * 收集数据
 */
CustomerserviceInfoDlg.collectData = function() {
    this
    .set('svrType')
    .set('svrTitle')
    .set('svrCustNo')
    .set('svrStatus')
    .set('svrRequest')
    .set('svrCreateId')
    .set('svrCreateDate')
    .set('svrDueId')
    .set('svrDueDate')
    .set('svrDeal')
    .set('svrDealDate')
    .set('svrResult')
    .set('svrSatisfy');
}

/**
 * 提交添加
 */
CustomerserviceInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/customerservice/add", function(data){
        Feng.success("添加成功!");
        window.parent.Customerservice.table.refresh();
        CustomerserviceInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.customerserviceInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CustomerserviceInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/customerservice/update", function(data){
        Feng.success("修改成功!");
        window.parent.Customerservice.table.refresh();
        CustomerserviceInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.customerserviceInfoData);
    ajax.start();
}

$(function() {

});
