package cn.stylefeng.guns.modular.productmgr.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Product;
import cn.stylefeng.guns.modular.productmgr.service.IProductService;

/**
 * 产品信息管理控制器
 *
 * @author fengshuonan
 * @Date 2019-03-01 22:03:27
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {

    private String PREFIX = "/productmgr/product/";

    @Autowired
    private IProductService productService;

    /**
     * 跳转到产品信息管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "product.html";
    }

    /**
     * 跳转到添加产品信息管理
     */
    @RequestMapping("/product_add")
    public String productAdd() {
        return PREFIX + "product_add.html";
    }

    /**
     * 跳转到修改产品信息管理
     */
    @RequestMapping("/product_update/{productId}")
    public String productUpdate(@PathVariable Integer productId, Model model) {
        Product product = productService.selectById(productId);
        model.addAttribute("item",product);
        LogObjectHolder.me().set(product);
        return PREFIX + "product_edit.html";
    }

    /**
     * 获取产品信息管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return productService.selectList(null);
    }

    /**
     * 新增产品信息管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Product product) {
        productService.insert(product);
        return SUCCESS_TIP;
    }

    /**
     * 删除产品信息管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer productId) {
        productService.deleteById(productId);
        return SUCCESS_TIP;
    }

    /**
     * 修改产品信息管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Product product) {
        productService.updateById(product);
        return SUCCESS_TIP;
    }

    /**
     * 产品信息管理详情
     */
    @RequestMapping(value = "/detail/{productId}")
    @ResponseBody
    public Object detail(@PathVariable("productId") Integer productId) {
        return productService.selectById(productId);
    }
}
