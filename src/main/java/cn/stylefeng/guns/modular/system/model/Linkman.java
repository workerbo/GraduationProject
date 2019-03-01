package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 客户联系人表
 * </p>
 *
 * @author 何波
 * @since 2019-03-01
 */
@TableName("cst_linkman")
public class Linkman extends Model<Linkman> {

    private static final long serialVersionUID = 1L;

    /**
     * 联系人编号（主键自动增长）
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 客户编号
     */
    @TableField("lkm_cust_no")
    private Integer lkmCustNo;
    /**
     * 联系人名称
     */
    @TableField("lkm_name")
    private String lkmName;
    /**
     * 性别
     */
    @TableField("lkm_sex")
    private String lkmSex;
    /**
     * 职位
     */
    @TableField("lkm_postion")
    private String lkmPostion;
    /**
     * 办公室电话
     */
    @TableField("lkm_tel")
    private String lkmTel;
    /**
     * 手机
     */
    @TableField("lkm_mobile")
    private String lkmMobile;
    /**
     * 备注
     */
    @TableField("lkm_memo")
    private String lkmMemo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLkmCustNo() {
        return lkmCustNo;
    }

    public void setLkmCustNo(Integer lkmCustNo) {
        this.lkmCustNo = lkmCustNo;
    }

    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName;
    }

    public String getLkmSex() {
        return lkmSex;
    }

    public void setLkmSex(String lkmSex) {
        this.lkmSex = lkmSex;
    }

    public String getLkmPostion() {
        return lkmPostion;
    }

    public void setLkmPostion(String lkmPostion) {
        this.lkmPostion = lkmPostion;
    }

    public String getLkmTel() {
        return lkmTel;
    }

    public void setLkmTel(String lkmTel) {
        this.lkmTel = lkmTel;
    }

    public String getLkmMobile() {
        return lkmMobile;
    }

    public void setLkmMobile(String lkmMobile) {
        this.lkmMobile = lkmMobile;
    }

    public String getLkmMemo() {
        return lkmMemo;
    }

    public void setLkmMemo(String lkmMemo) {
        this.lkmMemo = lkmMemo;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Linkman{" +
        ", id=" + id +
        ", lkmCustNo=" + lkmCustNo +
        ", lkmName=" + lkmName +
        ", lkmSex=" + lkmSex +
        ", lkmPostion=" + lkmPostion +
        ", lkmTel=" + lkmTel +
        ", lkmMobile=" + lkmMobile +
        ", lkmMemo=" + lkmMemo +
        "}";
    }
}
