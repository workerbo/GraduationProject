package cn.stylefeng.guns.modular.ordermgr.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Orders;
import cn.stylefeng.guns.modular.ordermgr.service.IOrdersService;

/**
 * 订单管理控制器
 *
 * @author fengshuonan
 * @Date 2019-03-01 21:58:51
 */
@Controller
@RequestMapping("/orders")
public class OrdersController extends BaseController {

    private String PREFIX = "/ordermgr/orders/";

    @Autowired
    private IOrdersService ordersService;

    /**
     * 跳转到订单管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "orders.html";
    }

    /**
     * 跳转到添加订单管理
     */
    @RequestMapping("/orders_add")
    public String ordersAdd() {
        return PREFIX + "orders_add.html";
    }

    /**
     * 跳转到修改订单管理
     */
    @RequestMapping("/orders_update/{ordersId}")
    public String ordersUpdate(@PathVariable Integer ordersId, Model model) {
        Orders orders = ordersService.selectById(ordersId);
        model.addAttribute("item",orders);
        LogObjectHolder.me().set(orders);
        return PREFIX + "orders_edit.html";
    }

    /**
     * 获取订单管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return ordersService.selectList(null);
    }

    /**
     * 新增订单管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Orders orders) {
        ordersService.insert(orders);
        return SUCCESS_TIP;
    }

    /**
     * 删除订单管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer ordersId) {
        ordersService.deleteById(ordersId);
        return SUCCESS_TIP;
    }

    /**
     * 修改订单管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Orders orders) {
        ordersService.updateById(orders);
        return SUCCESS_TIP;
    }

    /**
     * 订单管理详情
     */
    @RequestMapping(value = "/detail/{ordersId}")
    @ResponseBody
    public Object detail(@PathVariable("ordersId") Integer ordersId) {
        return ordersService.selectById(ordersId);
    }
}
