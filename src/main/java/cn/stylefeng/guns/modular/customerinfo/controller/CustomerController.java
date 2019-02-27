package cn.stylefeng.guns.modular.customerinfo.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Customer;
import cn.stylefeng.guns.modular.customerinfo.service.ICustomerService;

/**
 * 客户信息管理控制器
 *
 * @author fengshuonan
 * @Date 2019-02-27 22:50:41
 */
@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController {

    private String PREFIX = "/customerinfo/customer/";

    @Autowired
    private ICustomerService customerService;

    /**
     * 跳转到客户信息管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "customer.html";
    }

    /**
     * 跳转到添加客户信息管理
     */
    @RequestMapping("/customer_add")
    public String customerAdd() {
        return PREFIX + "customer_add.html";
    }

    /**
     * 跳转到修改客户信息管理
     */
    @RequestMapping("/customer_update/{customerId}")
    public String customerUpdate(@PathVariable Integer customerId, Model model) {
        Customer customer = customerService.selectById(customerId);
        model.addAttribute("item",customer);
        LogObjectHolder.me().set(customer);
        return PREFIX + "customer_edit.html";
    }

    /**
     * 获取客户信息管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return customerService.selectList(null);
    }

    /**
     * 新增客户信息管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Customer customer) {
        customerService.insert(customer);
        return SUCCESS_TIP;
    }

    /**
     * 删除客户信息管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer customerId) {
        customerService.deleteById(customerId);
        return SUCCESS_TIP;
    }

    /**
     * 修改客户信息管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Customer customer) {
        customerService.updateById(customer);
        return SUCCESS_TIP;
    }

    /**
     * 客户信息管理详情
     */
    @RequestMapping(value = "/detail/{customerId}")
    @ResponseBody
    public Object detail(@PathVariable("customerId") Integer customerId) {
        return customerService.selectById(customerId);
    }
}
