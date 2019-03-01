/**
 * 初始化订单明细详情对话框
 */
var OrdersLineInfoDlg = {
    ordersLineInfoData : {}
};

/**
 * 清除数据
 */
OrdersLineInfoDlg.clearData = function() {
    this.ordersLineInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OrdersLineInfoDlg.set = function(key, val) {
    this.ordersLineInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OrdersLineInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
OrdersLineInfoDlg.close = function() {
    parent.layer.close(window.parent.OrdersLine.layerIndex);
}

/**
 * 收集数据
 */
OrdersLineInfoDlg.collectData = function() {
    this
    .set('oddOrderId')
    .set('oddProdId')
    .set('oddCount')
    .set('oddUnit');
}

/**
 * 提交添加
 */
OrdersLineInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/ordersLine/add", function(data){
        Feng.success("添加成功!");
        window.parent.OrdersLine.table.refresh();
        OrdersLineInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ordersLineInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
OrdersLineInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/ordersLine/update", function(data){
        Feng.success("修改成功!");
        window.parent.OrdersLine.table.refresh();
        OrdersLineInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ordersLineInfoData);
    ajax.start();
}

$(function() {

});
