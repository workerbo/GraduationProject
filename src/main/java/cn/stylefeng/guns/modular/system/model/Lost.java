package cn.stylefeng.guns.modular.system.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 客户流失表
 * </p>
 *
 * @author 何波
 * @since 2019-03-01
 */
@TableName("cst_lost")
public class Lost extends Model<Lost> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号（主键自动增长1）
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 客户编号
     */
    @TableField("lst_cust_no")
    private Integer lstCustNo;
    /**
     * 客户经理编号
     */
    @TableField("lst_cust_manager_id")
    private Integer lstCustManagerId;
    /**
     * 上次下单时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("lst_last_order_date")
    private Date lstLastOrderDate;
    /**
     * 确认流失时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("lst_lost_date")
    private Date lstLostDate;
    /**
     * 暂缓措施
     */
    @TableField("lst_delay")
    private String lstDelay;
    /**
     * 流失原因
     */
    @TableField("lst_reason")
    private String lstReason;
    /**
     * 流失状态 1-警告，2-暂缓流失，3-已流失
     */
    @TableField("lst_status")
    private String lstStatus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLstCustNo() {
        return lstCustNo;
    }

    public void setLstCustNo(Integer lstCustNo) {
        this.lstCustNo = lstCustNo;
    }

    public Integer getLstCustManagerId() {
        return lstCustManagerId;
    }

    public void setLstCustManagerId(Integer lstCustManagerId) {
        this.lstCustManagerId = lstCustManagerId;
    }

    public Date getLstLastOrderDate() {
        return lstLastOrderDate;
    }

    public void setLstLastOrderDate(Date lstLastOrderDate) {
        this.lstLastOrderDate = lstLastOrderDate;
    }

    public Date getLstLostDate() {
        return lstLostDate;
    }

    public void setLstLostDate(Date lstLostDate) {
        this.lstLostDate = lstLostDate;
    }

    public String getLstDelay() {
        return lstDelay;
    }

    public void setLstDelay(String lstDelay) {
        this.lstDelay = lstDelay;
    }

    public String getLstReason() {
        return lstReason;
    }

    public void setLstReason(String lstReason) {
        this.lstReason = lstReason;
    }

    public String getLstStatus() {
        return lstStatus;
    }

    public void setLstStatus(String lstStatus) {
        this.lstStatus = lstStatus;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Lost{" +
        ", id=" + id +
        ", lstCustNo=" + lstCustNo +
        ", lstCustManagerId=" + lstCustManagerId +
        ", lstLastOrderDate=" + lstLastOrderDate +
        ", lstLostDate=" + lstLostDate +
        ", lstDelay=" + lstDelay +
        ", lstReason=" + lstReason +
        ", lstStatus=" + lstStatus +
        "}";
    }
}
