package cn.stylefeng.guns.modular.productmgr.service.impl;

import cn.stylefeng.guns.modular.system.model.Product;
import cn.stylefeng.guns.modular.system.dao.ProductMapper;
import cn.stylefeng.guns.modular.productmgr.service.IProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author 何波
 * @since 2019-03-01
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
