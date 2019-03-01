package cn.stylefeng.guns.modular.orderinfo.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.OrdersLine;
import cn.stylefeng.guns.modular.orderinfo.service.IOrdersLineService;

/**
 * 订单明细控制器
 *
 * @author fengshuonan
 * @Date 2019-03-01 21:54:21
 */
@Controller
@RequestMapping("/ordersLine")
public class OrdersLineController extends BaseController {

    private String PREFIX = "/orderinfo/ordersLine/";

    @Autowired
    private IOrdersLineService ordersLineService;

    /**
     * 跳转到订单明细首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "ordersLine.html";
    }

    /**
     * 跳转到添加订单明细
     */
    @RequestMapping("/ordersLine_add")
    public String ordersLineAdd() {
        return PREFIX + "ordersLine_add.html";
    }

    /**
     * 跳转到修改订单明细
     */
    @RequestMapping("/ordersLine_update/{ordersLineId}")
    public String ordersLineUpdate(@PathVariable Integer ordersLineId, Model model) {
        OrdersLine ordersLine = ordersLineService.selectById(ordersLineId);
        model.addAttribute("item",ordersLine);
        LogObjectHolder.me().set(ordersLine);
        return PREFIX + "ordersLine_edit.html";
    }

    /**
     * 获取订单明细列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return ordersLineService.selectList(null);
    }

    /**
     * 新增订单明细
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(OrdersLine ordersLine) {
        ordersLineService.insert(ordersLine);
        return SUCCESS_TIP;
    }

    /**
     * 删除订单明细
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer ordersLineId) {
        ordersLineService.deleteById(ordersLineId);
        return SUCCESS_TIP;
    }

    /**
     * 修改订单明细
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(OrdersLine ordersLine) {
        ordersLineService.updateById(ordersLine);
        return SUCCESS_TIP;
    }

    /**
     * 订单明细详情
     */
    @RequestMapping(value = "/detail/{ordersLineId}")
    @ResponseBody
    public Object detail(@PathVariable("ordersLineId") Integer ordersLineId) {
        return ordersLineService.selectById(ordersLineId);
    }
}
