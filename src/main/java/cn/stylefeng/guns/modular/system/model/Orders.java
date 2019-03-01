package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author 何波
 * @since 2019-03-01
 */
@TableName("orders")
public class Orders extends Model<Orders> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号（自动增长1，1）
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 订单客户公司编号
     */
    @TableField("odr_customer_no")
    private Integer odrCustomerNo;
    /**
     * 订单日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("odr_date")
    private Date odrDate;
    /**
     * 地址
     */
    @TableField("odr_addr")
    private String odrAddr;
    /**
     * 状态(5:已发货  6:已回款)
     */
    @TableField("odr_status")
    private String odrStatus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOdrCustomerNo() {
        return odrCustomerNo;
    }

    public void setOdrCustomerNo(Integer odrCustomerNo) {
        this.odrCustomerNo = odrCustomerNo;
    }

    public Date getOdrDate() {
        return odrDate;
    }

    public void setOdrDate(Date odrDate) {
        this.odrDate = odrDate;
    }

    public String getOdrAddr() {
        return odrAddr;
    }

    public void setOdrAddr(String odrAddr) {
        this.odrAddr = odrAddr;
    }

    public String getOdrStatus() {
        return odrStatus;
    }

    public void setOdrStatus(String odrStatus) {
        this.odrStatus = odrStatus;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Orders{" +
        ", id=" + id +
        ", odrCustomerNo=" + odrCustomerNo +
        ", odrDate=" + odrDate +
        ", odrAddr=" + odrAddr +
        ", odrStatus=" + odrStatus +
        "}";
    }
}
