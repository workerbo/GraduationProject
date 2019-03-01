package cn.stylefeng.guns.modular.customersevice.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Customerservice;
import cn.stylefeng.guns.modular.customersevice.service.ICustomerserviceService;

/**
 * 客户服务控制器
 *
 * @author fengshuonan
 * @Date 2019-02-27 23:33:11
 */
@Controller
@RequestMapping("/customerservice")
public class CustomerserviceController extends BaseController {

    private String PREFIX = "/customersevice/customerservice/";

    @Autowired
    private ICustomerserviceService customerserviceService;

    /**
     * 跳转到客户服务首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "customerservice.html";
    }

    /**
     * 跳转到添加客户服务
     */
    @RequestMapping("/customerservice_add")
    public String customerserviceAdd() {
        return PREFIX + "customerservice_add.html";
    }

    /**
     * 跳转到修改客户服务
     */
    @RequestMapping("/customerservice_update/{customerserviceId}")
    public String customerserviceUpdate(@PathVariable Integer customerserviceId, Model model) {
        Customerservice customerservice = customerserviceService.selectById(customerserviceId);
        model.addAttribute("item",customerservice);
        LogObjectHolder.me().set(customerservice);
        return PREFIX + "customerservice_edit.html";
    }

    /**
     * 获取客户服务列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return customerserviceService.selectList(null);
    }

    /**
     * 新增客户服务
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Customerservice customerservice) {
        customerserviceService.insert(customerservice);
        return SUCCESS_TIP;
    }

    /**
     * 删除客户服务
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer customerserviceId) {
        customerserviceService.deleteById(customerserviceId);
        return SUCCESS_TIP;
    }

    /**
     * 修改客户服务
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Customerservice customerservice) {
        customerserviceService.updateById(customerservice);
        return SUCCESS_TIP;
    }

    /**
     * 客户服务详情
     */
    @RequestMapping(value = "/detail/{customerserviceId}")
    @ResponseBody
    public Object detail(@PathVariable("customerserviceId") Integer customerserviceId) {
        return customerserviceService.selectById(customerserviceId);
    }
}
