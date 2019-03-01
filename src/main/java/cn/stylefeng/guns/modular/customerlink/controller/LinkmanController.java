package cn.stylefeng.guns.modular.customerlink.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Linkman;
import cn.stylefeng.guns.modular.customerlink.service.ILinkmanService;

/**
 * 客户联系人控制器
 *
 * @author fengshuonan
 * @Date 2019-03-01 12:55:58
 */
@Controller
@RequestMapping("/linkman")
public class LinkmanController extends BaseController {

    private String PREFIX = "/customerlink/linkman/";

    @Autowired
    private ILinkmanService linkmanService;

    /**
     * 跳转到客户联系人首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "linkman.html";
    }

    /**
     * 跳转到添加客户联系人
     */
    @RequestMapping("/linkman_add")
    public String linkmanAdd() {
        return PREFIX + "linkman_add.html";
    }

    /**
     * 跳转到修改客户联系人
     */
    @RequestMapping("/linkman_update/{linkmanId}")
    public String linkmanUpdate(@PathVariable Integer linkmanId, Model model) {
        Linkman linkman = linkmanService.selectById(linkmanId);
        model.addAttribute("item",linkman);
        LogObjectHolder.me().set(linkman);
        return PREFIX + "linkman_edit.html";
    }

    /**
     * 获取客户联系人列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return linkmanService.selectList(null);
    }

    /**
     * 新增客户联系人
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Linkman linkman) {
        linkmanService.insert(linkman);
        return SUCCESS_TIP;
    }

    /**
     * 删除客户联系人
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer linkmanId) {
        linkmanService.deleteById(linkmanId);
        return SUCCESS_TIP;
    }

    /**
     * 修改客户联系人
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Linkman linkman) {
        linkmanService.updateById(linkman);
        return SUCCESS_TIP;
    }

    /**
     * 客户联系人详情
     */
    @RequestMapping(value = "/detail/{linkmanId}")
    @ResponseBody
    public Object detail(@PathVariable("linkmanId") Integer linkmanId) {
        return linkmanService.selectById(linkmanId);
    }
}
