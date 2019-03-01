/**
 * 初始化客户流失详情对话框
 */
var LostInfoDlg = {
    lostInfoData : {}
};

/**
 * 清除数据
 */
LostInfoDlg.clearData = function() {
    this.lostInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
LostInfoDlg.set = function(key, val) {
    this.lostInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
LostInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
LostInfoDlg.close = function() {
    parent.layer.close(window.parent.Lost.layerIndex);
}

/**
 * 收集数据
 */
LostInfoDlg.collectData = function() {
    this
    .set('lstCustNo')
    .set('lstCustManagerId')
    .set('lstLastOrderDate')
    .set('lstLostDate')
    .set('lstDelay')
    .set('lstReason')
    .set('lstStatus');
}

/**
 * 提交添加
 */
LostInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/lost/add", function(data){
        Feng.success("添加成功!");
        window.parent.Lost.table.refresh();
        LostInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.lostInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
LostInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/lost/update", function(data){
        Feng.success("修改成功!");
        window.parent.Lost.table.refresh();
        LostInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.lostInfoData);
    ajax.start();
}

$(function() {

});
