/**
 * 初始化客户联系人详情对话框
 */
var LinkmanInfoDlg = {
    linkmanInfoData : {}
};

/**
 * 清除数据
 */
LinkmanInfoDlg.clearData = function() {
    this.linkmanInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
LinkmanInfoDlg.set = function(key, val) {
    this.linkmanInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
LinkmanInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
LinkmanInfoDlg.close = function() {
    parent.layer.close(window.parent.Linkman.layerIndex);
}

/**
 * 收集数据
 */
LinkmanInfoDlg.collectData = function() {
    this
    .set('lkmCustNo')
    .set('lkmName')
    .set('lkmSex')
    .set('lkmPostion')
    .set('lkmTel')
    .set('lkmMobile')
    .set('lkmMemo');
}

/**
 * 提交添加
 */
LinkmanInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/linkman/add", function(data){
        Feng.success("添加成功!");
        window.parent.Linkman.table.refresh();
        LinkmanInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.linkmanInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
LinkmanInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/linkman/update", function(data){
        Feng.success("修改成功!");
        window.parent.Linkman.table.refresh();
        LinkmanInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.linkmanInfoData);
    ajax.start();
}

$(function() {

});
