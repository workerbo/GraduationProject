package cn.stylefeng.guns.modular.customerlost.service.impl;

import cn.stylefeng.guns.modular.system.model.Lost;
import cn.stylefeng.guns.modular.system.dao.LostMapper;
import cn.stylefeng.guns.modular.customerlost.service.ILostService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户流失表 服务实现类
 * </p>
 *
 * @author 何波
 * @since 2019-03-01
 */
@Service
public class LostServiceImpl extends ServiceImpl<LostMapper, Lost> implements ILostService {

}
