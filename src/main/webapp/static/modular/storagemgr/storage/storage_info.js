/**
 * 初始化仓库管理详情对话框
 */
var StorageInfoDlg = {
    storageInfoData : {}
};

/**
 * 清除数据
 */
StorageInfoDlg.clearData = function() {
    this.storageInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
StorageInfoDlg.set = function(key, val) {
    this.storageInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
StorageInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
StorageInfoDlg.close = function() {
    parent.layer.close(window.parent.Storage.layerIndex);
}

/**
 * 收集数据
 */
StorageInfoDlg.collectData = function() {
    this
    .set('stkProdId')
    .set('stkWarehouse')
    .set('stkWare')
    .set('stkCount')
    .set('stkMemo');
}

/**
 * 提交添加
 */
StorageInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/storage/add", function(data){
        Feng.success("添加成功!");
        window.parent.Storage.table.refresh();
        StorageInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.storageInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
StorageInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/storage/update", function(data){
        Feng.success("修改成功!");
        window.parent.Storage.table.refresh();
        StorageInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.storageInfoData);
    ajax.start();
}

$(function() {

});
