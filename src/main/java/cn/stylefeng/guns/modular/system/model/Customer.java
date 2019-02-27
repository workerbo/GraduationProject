package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 客户信息表
 * </p>
 *
 * @author 何波
 * @since 2019-02-27
 */
@TableName("cst_customer")
public class Customer extends Model<Customer> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "cust_no", type = IdType.AUTO)
    private Integer custNo;
    /**
     * 客户名称
     */
    @TableField("cust_name")
    private String custName;
    /**
     * 地区
     */
    @TableField("cust_region")
    private String custRegion;
    /**
     * 客户经理编号
     */
    @TableField("cust_manager_id")
    private Integer custManagerId;
    /**
     * 客户等级
     */
    @TableField("cust_level")
    private Integer custLevel;
    /**
     * 满意度（1-5），默认为3
     */
    @TableField("cust_satisfy")
    private Integer custSatisfy;
    /**
     * 信用度（1-5），默认为3
     */
    @TableField("cust_credit")
    private Integer custCredit;
    /**
     * 地址
     */
    @TableField("cust_addr")
    private String custAddr;
    /**
     * 邮政编码
     */
    @TableField("cust_zip")
    private String custZip;
    /**
     * 电话
     */
    @TableField("cust_tel")
    private String custTel;
    /**
     * 网址
     */
    @TableField("cust_website")
    private String custWebsite;
    /**
     * 营业执照注册号
     */
    @TableField("cust_licence_no")
    private String custLicenceNo;
    /**
     * 法人
     */
    @TableField("cust_chieftain")
    private String custChieftain;
    /**
     * 注册资金
     */
    @TableField("cust_bankroll")
    private Long custBankroll;
    /**
     * 营业额
     */
    @TableField("cust_turnover")
    private Long custTurnover;
    /**
     * 客户状态：1--正常；2--流失；3--删除。
     */
    @TableField("cust_status")
    private String custStatus;


    public Integer getCustNo() {
        return custNo;
    }

    public void setCustNo(Integer custNo) {
        this.custNo = custNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustRegion() {
        return custRegion;
    }

    public void setCustRegion(String custRegion) {
        this.custRegion = custRegion;
    }

    public Integer getCustManagerId() {
        return custManagerId;
    }

    public void setCustManagerId(Integer custManagerId) {
        this.custManagerId = custManagerId;
    }

    public Integer getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(Integer custLevel) {
        this.custLevel = custLevel;
    }

    public Integer getCustSatisfy() {
        return custSatisfy;
    }

    public void setCustSatisfy(Integer custSatisfy) {
        this.custSatisfy = custSatisfy;
    }

    public Integer getCustCredit() {
        return custCredit;
    }

    public void setCustCredit(Integer custCredit) {
        this.custCredit = custCredit;
    }

    public String getCustAddr() {
        return custAddr;
    }

    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr;
    }

    public String getCustZip() {
        return custZip;
    }

    public void setCustZip(String custZip) {
        this.custZip = custZip;
    }

    public String getCustTel() {
        return custTel;
    }

    public void setCustTel(String custTel) {
        this.custTel = custTel;
    }

    public String getCustWebsite() {
        return custWebsite;
    }

    public void setCustWebsite(String custWebsite) {
        this.custWebsite = custWebsite;
    }

    public String getCustLicenceNo() {
        return custLicenceNo;
    }

    public void setCustLicenceNo(String custLicenceNo) {
        this.custLicenceNo = custLicenceNo;
    }

    public String getCustChieftain() {
        return custChieftain;
    }

    public void setCustChieftain(String custChieftain) {
        this.custChieftain = custChieftain;
    }

    public Long getCustBankroll() {
        return custBankroll;
    }

    public void setCustBankroll(Long custBankroll) {
        this.custBankroll = custBankroll;
    }

    public Long getCustTurnover() {
        return custTurnover;
    }

    public void setCustTurnover(Long custTurnover) {
        this.custTurnover = custTurnover;
    }

    public String getCustStatus() {
        return custStatus;
    }

    public void setCustStatus(String custStatus) {
        this.custStatus = custStatus;
    }

    @Override
    protected Serializable pkVal() {
        return this.custNo;
    }

    @Override
    public String toString() {
        return "Customer{" +
        ", custNo=" + custNo +
        ", custName=" + custName +
        ", custRegion=" + custRegion +
        ", custManagerId=" + custManagerId +
        ", custLevel=" + custLevel +
        ", custSatisfy=" + custSatisfy +
        ", custCredit=" + custCredit +
        ", custAddr=" + custAddr +
        ", custZip=" + custZip +
        ", custTel=" + custTel +
        ", custWebsite=" + custWebsite +
        ", custLicenceNo=" + custLicenceNo +
        ", custChieftain=" + custChieftain +
        ", custBankroll=" + custBankroll +
        ", custTurnover=" + custTurnover +
        ", custStatus=" + custStatus +
        "}";
    }
}
