package cn.stylefeng.guns.modular.storagemgr.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Storage;
import cn.stylefeng.guns.modular.storagemgr.service.IStorageService;

/**
 * 仓库管理控制器
 *
 * @author fengshuonan
 * @Date 2019-03-01 22:20:44
 */
@Controller
@RequestMapping("/storage")
public class StorageController extends BaseController {

    private String PREFIX = "/storagemgr/storage/";

    @Autowired
    private IStorageService storageService;

    /**
     * 跳转到仓库管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "storage.html";
    }

    /**
     * 跳转到添加仓库管理
     */
    @RequestMapping("/storage_add")
    public String storageAdd() {
        return PREFIX + "storage_add.html";
    }

    /**
     * 跳转到修改仓库管理
     */
    @RequestMapping("/storage_update/{storageId}")
    public String storageUpdate(@PathVariable Integer storageId, Model model) {
        Storage storage = storageService.selectById(storageId);
        model.addAttribute("item",storage);
        LogObjectHolder.me().set(storage);
        return PREFIX + "storage_edit.html";
    }

    /**
     * 获取仓库管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return storageService.selectList(null);
    }

    /**
     * 新增仓库管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Storage storage) {
        storageService.insert(storage);
        return SUCCESS_TIP;
    }

    /**
     * 删除仓库管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer storageId) {
        storageService.deleteById(storageId);
        return SUCCESS_TIP;
    }

    /**
     * 修改仓库管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Storage storage) {
        storageService.updateById(storage);
        return SUCCESS_TIP;
    }

    /**
     * 仓库管理详情
     */
    @RequestMapping(value = "/detail/{storageId}")
    @ResponseBody
    public Object detail(@PathVariable("storageId") Integer storageId) {
        return storageService.selectById(storageId);
    }
}
