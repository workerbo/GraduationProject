package cn.stylefeng.guns.modular.ordermgr.service.impl;

import cn.stylefeng.guns.modular.system.model.Orders;
import cn.stylefeng.guns.modular.system.dao.OrdersMapper;
import cn.stylefeng.guns.modular.ordermgr.service.IOrdersService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author 何波
 * @since 2019-03-01
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

}
