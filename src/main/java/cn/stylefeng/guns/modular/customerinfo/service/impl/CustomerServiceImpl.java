package cn.stylefeng.guns.modular.customerinfo.service.impl;

import cn.stylefeng.guns.modular.system.model.Customer;
import cn.stylefeng.guns.modular.system.dao.CustomerMapper;
import cn.stylefeng.guns.modular.customerinfo.service.ICustomerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户信息表 服务实现类
 * </p>
 *
 * @author 何波
 * @since 2019-02-27
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}
