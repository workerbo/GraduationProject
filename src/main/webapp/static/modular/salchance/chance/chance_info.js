/**
 * 初始化机会管理详情对话框
 */
var ChanceInfoDlg = {
    chanceInfoData : {}
};

/**
 * 清除数据
 */
ChanceInfoDlg.clearData = function() {
    this.chanceInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ChanceInfoDlg.set = function(key, val) {
    this.chanceInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ChanceInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ChanceInfoDlg.close = function() {
    parent.layer.close(window.parent.Chance.layerIndex);
}

/**
 * 收集数据
 */
ChanceInfoDlg.collectData = function() {
    this
    .set('chcSource')
    .set('chcCustName')
    .set('chcTitle')
    .set('chcRate')
    .set('chcLinkman')
    .set('chcTel')
    .set('chcCreateId')
    .set('chcCreateDate')
    .set('chcDueId')
    .set('chcDueDate')
    .set('chcStatus');
}

/**
 * 提交添加
 */
ChanceInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/chance/add", function(data){
        Feng.success("添加成功!");
        window.parent.Chance.table.refresh();
        ChanceInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.chanceInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ChanceInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/chance/update", function(data){
        Feng.success("修改成功!");
        window.parent.Chance.table.refresh();
        ChanceInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.chanceInfoData);
    ajax.start();
}

$(function() {

});
