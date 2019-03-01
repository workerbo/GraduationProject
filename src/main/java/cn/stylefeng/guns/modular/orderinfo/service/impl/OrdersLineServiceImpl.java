package cn.stylefeng.guns.modular.orderinfo.service.impl;

import cn.stylefeng.guns.modular.system.model.OrdersLine;
import cn.stylefeng.guns.modular.system.dao.OrdersLineMapper;
import cn.stylefeng.guns.modular.orderinfo.service.IOrdersLineService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单明细表 服务实现类
 * </p>
 *
 * @author 何波
 * @since 2019-03-01
 */
@Service
public class OrdersLineServiceImpl extends ServiceImpl<OrdersLineMapper, OrdersLine> implements IOrdersLineService {

}
