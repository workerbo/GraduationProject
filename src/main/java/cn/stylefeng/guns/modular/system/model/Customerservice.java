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
 * 客户服务表
 * </p>
 *
 * @author 何波
 * @since 2019-02-27
 */
@TableName("cst_customerservice")
public class Customerservice extends Model<Customerservice> {

    private static final long serialVersionUID = 1L;

    /**
     * 服务
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 服务类型
     */
    @TableField("svr_type")
    private String svrType;
    /**
     * 服务概要
     */
    @TableField("svr_title")
    private String svrTitle;
    /**
     * 客户编号
     */
    @TableField("svr_cust_no")
    private Integer svrCustNo;
    /**
     * 服务状态
     */
    @TableField("svr_status")
    private String svrStatus;
    /**
     * 服务请求
     */
    @TableField("svr_request")
    private String svrRequest;
    /**
     * 创建人编号
     */
    @TableField("svr_create_id")
    private String svrCreateId;
    /**
     * 创建日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("svr_create_date")
    private Date svrCreateDate;
    /**
     * 分配给某人的编号
     */
    @TableField("svr_due_id")
    private Integer svrDueId;
    /**
     * 分配时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("svr_due_date")
    private Date svrDueDate;
    /**
     * 服务处理
     */
    @TableField("svr_deal")
    private String svrDeal;
    /**
     * 处理日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("svr_deal_date")
    private Date svrDealDate;
    /**
     * 处理结果
     */
    @TableField("svr_result")
    private String svrResult;
    /**
     * 满意度
     */
    @TableField("svr_satisfy")
    private Integer svrSatisfy;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSvrType() {
        return svrType;
    }

    public void setSvrType(String svrType) {
        this.svrType = svrType;
    }

    public String getSvrTitle() {
        return svrTitle;
    }

    public void setSvrTitle(String svrTitle) {
        this.svrTitle = svrTitle;
    }

    public Integer getSvrCustNo() {
        return svrCustNo;
    }

    public void setSvrCustNo(Integer svrCustNo) {
        this.svrCustNo = svrCustNo;
    }

    public String getSvrStatus() {
        return svrStatus;
    }

    public void setSvrStatus(String svrStatus) {
        this.svrStatus = svrStatus;
    }

    public String getSvrRequest() {
        return svrRequest;
    }

    public void setSvrRequest(String svrRequest) {
        this.svrRequest = svrRequest;
    }

    public String getSvrCreateId() {
        return svrCreateId;
    }

    public void setSvrCreateId(String svrCreateId) {
        this.svrCreateId = svrCreateId;
    }

    public Date getSvrCreateDate() {
        return svrCreateDate;
    }

    public void setSvrCreateDate(Date svrCreateDate) {
        this.svrCreateDate = svrCreateDate;
    }

    public Integer getSvrDueId() {
        return svrDueId;
    }

    public void setSvrDueId(Integer svrDueId) {
        this.svrDueId = svrDueId;
    }

    public Date getSvrDueDate() {
        return svrDueDate;
    }

    public void setSvrDueDate(Date svrDueDate) {
        this.svrDueDate = svrDueDate;
    }

    public String getSvrDeal() {
        return svrDeal;
    }

    public void setSvrDeal(String svrDeal) {
        this.svrDeal = svrDeal;
    }

    public Date getSvrDealDate() {
        return svrDealDate;
    }

    public void setSvrDealDate(Date svrDealDate) {
        this.svrDealDate = svrDealDate;
    }

    public String getSvrResult() {
        return svrResult;
    }

    public void setSvrResult(String svrResult) {
        this.svrResult = svrResult;
    }

    public Integer getSvrSatisfy() {
        return svrSatisfy;
    }

    public void setSvrSatisfy(Integer svrSatisfy) {
        this.svrSatisfy = svrSatisfy;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Customerservice{" +
        ", id=" + id +
        ", svrType=" + svrType +
        ", svrTitle=" + svrTitle +
        ", svrCustNo=" + svrCustNo +
        ", svrStatus=" + svrStatus +
        ", svrRequest=" + svrRequest +
        ", svrCreateId=" + svrCreateId +
        ", svrCreateDate=" + svrCreateDate +
        ", svrDueId=" + svrDueId +
        ", svrDueDate=" + svrDueDate +
        ", svrDeal=" + svrDeal +
        ", svrDealDate=" + svrDealDate +
        ", svrResult=" + svrResult +
        ", svrSatisfy=" + svrSatisfy +
        "}";
    }
}
