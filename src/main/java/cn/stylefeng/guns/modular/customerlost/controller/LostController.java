package cn.stylefeng.guns.modular.customerlost.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Lost;
import cn.stylefeng.guns.modular.customerlost.service.ILostService;

/**
 * 客户流失控制器
 *
 * @author fengshuonan
 * @Date 2019-03-01 13:07:08
 */
@Controller
@RequestMapping("/lost")
public class LostController extends BaseController {

    private String PREFIX = "/customerlost/lost/";

    @Autowired
    private ILostService lostService;

    /**
     * 跳转到客户流失首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "lost.html";
    }

    /**
     * 跳转到添加客户流失
     */
    @RequestMapping("/lost_add")
    public String lostAdd() {
        return PREFIX + "lost_add.html";
    }

    /**
     * 跳转到修改客户流失
     */
    @RequestMapping("/lost_update/{lostId}")
    public String lostUpdate(@PathVariable Integer lostId, Model model) {
        Lost lost = lostService.selectById(lostId);
        model.addAttribute("item",lost);
        LogObjectHolder.me().set(lost);
        return PREFIX + "lost_edit.html";
    }

    /**
     * 获取客户流失列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return lostService.selectList(null);
    }

    /**
     * 新增客户流失
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Lost lost) {
        lostService.insert(lost);
        return SUCCESS_TIP;
    }

    /**
     * 删除客户流失
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer lostId) {
        lostService.deleteById(lostId);
        return SUCCESS_TIP;
    }

    /**
     * 修改客户流失
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Lost lost) {
        lostService.updateById(lost);
        return SUCCESS_TIP;
    }

    /**
     * 客户流失详情
     */
    @RequestMapping(value = "/detail/{lostId}")
    @ResponseBody
    public Object detail(@PathVariable("lostId") Integer lostId) {
        return lostService.selectById(lostId);
    }
}
