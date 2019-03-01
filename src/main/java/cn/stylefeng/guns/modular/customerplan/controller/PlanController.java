package cn.stylefeng.guns.modular.customerplan.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Plan;
import cn.stylefeng.guns.modular.customerplan.service.IPlanService;

/**
 * 客户开发控制器
 *
 * @author fengshuonan
 * @Date 2019-03-01 13:20:14
 */
@Controller
@RequestMapping("/plan")
public class PlanController extends BaseController {

    private String PREFIX = "/customerplan/plan/";

    @Autowired
    private IPlanService planService;

    /**
     * 跳转到客户开发首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "plan.html";
    }

    /**
     * 跳转到添加客户开发
     */
    @RequestMapping("/plan_add")
    public String planAdd() {
        return PREFIX + "plan_add.html";
    }

    /**
     * 跳转到修改客户开发
     */
    @RequestMapping("/plan_update/{planId}")
    public String planUpdate(@PathVariable Integer planId, Model model) {
        Plan plan = planService.selectById(planId);
        model.addAttribute("item",plan);
        LogObjectHolder.me().set(plan);
        return PREFIX + "plan_edit.html";
    }

    /**
     * 获取客户开发列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return planService.selectList(null);
    }

    /**
     * 新增客户开发
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Plan plan) {
        planService.insert(plan);
        return SUCCESS_TIP;
    }

    /**
     * 删除客户开发
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer planId) {
        planService.deleteById(planId);
        return SUCCESS_TIP;
    }

    /**
     * 修改客户开发
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Plan plan) {
        planService.updateById(plan);
        return SUCCESS_TIP;
    }

    /**
     * 客户开发详情
     */
    @RequestMapping(value = "/detail/{planId}")
    @ResponseBody
    public Object detail(@PathVariable("planId") Integer planId) {
        return planService.selectById(planId);
    }
}
