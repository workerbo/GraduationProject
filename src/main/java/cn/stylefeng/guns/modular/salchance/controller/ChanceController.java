package cn.stylefeng.guns.modular.salchance.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Chance;
import cn.stylefeng.guns.modular.salchance.service.IChanceService;

/**
 * 机会管理控制器
 *
 * @author fengshuonan
 * @Date 2019-03-01 13:17:44
 */
@Controller
@RequestMapping("/chance")
public class ChanceController extends BaseController {

    private String PREFIX = "/salchance/chance/";

    @Autowired
    private IChanceService chanceService;

    /**
     * 跳转到机会管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "chance.html";
    }

    /**
     * 跳转到添加机会管理
     */
    @RequestMapping("/chance_add")
    public String chanceAdd() {
        return PREFIX + "chance_add.html";
    }

    /**
     * 跳转到修改机会管理
     */
    @RequestMapping("/chance_update/{chanceId}")
    public String chanceUpdate(@PathVariable Integer chanceId, Model model) {
        Chance chance = chanceService.selectById(chanceId);
        model.addAttribute("item",chance);
        LogObjectHolder.me().set(chance);
        return PREFIX + "chance_edit.html";
    }

    /**
     * 获取机会管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return chanceService.selectList(null);
    }

    /**
     * 新增机会管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Chance chance) {
        chanceService.insert(chance);
        return SUCCESS_TIP;
    }

    /**
     * 删除机会管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer chanceId) {
        chanceService.deleteById(chanceId);
        return SUCCESS_TIP;
    }

    /**
     * 修改机会管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Chance chance) {
        chanceService.updateById(chance);
        return SUCCESS_TIP;
    }

    /**
     * 机会管理详情
     */
    @RequestMapping(value = "/detail/{chanceId}")
    @ResponseBody
    public Object detail(@PathVariable("chanceId") Integer chanceId) {
        return chanceService.selectById(chanceId);
    }
}
