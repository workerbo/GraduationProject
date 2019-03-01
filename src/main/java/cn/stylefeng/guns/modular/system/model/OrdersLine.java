package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 订单明细表
 * </p>
 *
 * @author 何波
 * @since 2019-03-01
 */
@TableName("orders_line")
public class OrdersLine extends Model<OrdersLine> {

    private static final long serialVersionUID = 1L;

    /**
     * 明细编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 订单编号
     */
    @TableField("odd_order_id")
    private Long oddOrderId;
    /**
     * 商品编号
     */
    @TableField("odd_prod_id")
    private Long oddProdId;
    /**
     * 数量
     */
    @TableField("odd_count")
    private Integer oddCount;
    /**
     * 单位
     */
    @TableField("odd_unit")
    private String oddUnit;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOddOrderId() {
        return oddOrderId;
    }

    public void setOddOrderId(Long oddOrderId) {
        this.oddOrderId = oddOrderId;
    }

    public Long getOddProdId() {
        return oddProdId;
    }

    public void setOddProdId(Long oddProdId) {
        this.oddProdId = oddProdId;
    }

    public Integer getOddCount() {
        return oddCount;
    }

    public void setOddCount(Integer oddCount) {
        this.oddCount = oddCount;
    }

    public String getOddUnit() {
        return oddUnit;
    }

    public void setOddUnit(String oddUnit) {
        this.oddUnit = oddUnit;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "OrdersLine{" +
        ", id=" + id +
        ", oddOrderId=" + oddOrderId +
        ", oddProdId=" + oddProdId +
        ", oddCount=" + oddCount +
        ", oddUnit=" + oddUnit +
        "}";
    }
}
