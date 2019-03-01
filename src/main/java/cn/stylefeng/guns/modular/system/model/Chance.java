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
 * 机会销售表
 * </p>
 *
 * @author 何波
 * @since 2019-03-01
 */
@TableName("sal_chance")
public class Chance extends Model<Chance> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 机会来源
     */
    @TableField("chc_source")
    private String chcSource;
    /**
     * 客户名称
     */
    @TableField("chc_cust_name")
    private String chcCustName;
    /**
     * 概要
     */
    @TableField("chc_title")
    private String chcTitle;
    /**
     * 成功机率
     */
    @TableField("chc_rate")
    private Integer chcRate;
    /**
     * 联系人
     */
    @TableField("chc_linkman")
    private String chcLinkman;
    /**
     * 联系电话
     */
    @TableField("chc_tel")
    private String chcTel;
    /**
     * 创建人编号
     */
    @TableField("chc_create_id")
    private Integer chcCreateId;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("chc_create_date")
    private Date chcCreateDate;
    /**
     * 指派的客户经理编号
     */
    @TableField("chc_due_id")
    private Long chcDueId;
    /**
     * 指派时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("chc_due_date")
    private Date chcDueDate;
    /**
     * 状态：1--未指派；2--已指派3--开发成功；4--终止开发(开发失败)。
     */
    @TableField("chc_status")
    private String chcStatus;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChcSource() {
        return chcSource;
    }

    public void setChcSource(String chcSource) {
        this.chcSource = chcSource;
    }

    public String getChcCustName() {
        return chcCustName;
    }

    public void setChcCustName(String chcCustName) {
        this.chcCustName = chcCustName;
    }

    public String getChcTitle() {
        return chcTitle;
    }

    public void setChcTitle(String chcTitle) {
        this.chcTitle = chcTitle;
    }

    public Integer getChcRate() {
        return chcRate;
    }

    public void setChcRate(Integer chcRate) {
        this.chcRate = chcRate;
    }

    public String getChcLinkman() {
        return chcLinkman;
    }

    public void setChcLinkman(String chcLinkman) {
        this.chcLinkman = chcLinkman;
    }

    public String getChcTel() {
        return chcTel;
    }

    public void setChcTel(String chcTel) {
        this.chcTel = chcTel;
    }

    public Integer getChcCreateId() {
        return chcCreateId;
    }

    public void setChcCreateId(Integer chcCreateId) {
        this.chcCreateId = chcCreateId;
    }

    public Date getChcCreateDate() {
        return chcCreateDate;
    }

    public void setChcCreateDate(Date chcCreateDate) {
        this.chcCreateDate = chcCreateDate;
    }

    public Long getChcDueId() {
        return chcDueId;
    }

    public void setChcDueId(Long chcDueId) {
        this.chcDueId = chcDueId;
    }

    public Date getChcDueDate() {
        return chcDueDate;
    }

    public void setChcDueDate(Date chcDueDate) {
        this.chcDueDate = chcDueDate;
    }

    public String getChcStatus() {
        return chcStatus;
    }

    public void setChcStatus(String chcStatus) {
        this.chcStatus = chcStatus;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Chance{" +
        ", id=" + id +
        ", chcSource=" + chcSource +
        ", chcCustName=" + chcCustName +
        ", chcTitle=" + chcTitle +
        ", chcRate=" + chcRate +
        ", chcLinkman=" + chcLinkman +
        ", chcTel=" + chcTel +
        ", chcCreateId=" + chcCreateId +
        ", chcCreateDate=" + chcCreateDate +
        ", chcDueId=" + chcDueId +
        ", chcDueDate=" + chcDueDate +
        ", chcStatus=" + chcStatus +
        "}";
    }
}
