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
 * 交往记录表
 * </p>
 *
 * @author 何波
 * @since 2019-02-27
 */
@TableName("cst_activity")
public class Activity extends Model<Activity> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 客户编号
     */
    @TableField("atv_cust_no")
    private Integer atvCustNo;
    /**
     * 交往日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("atv_date")
    private Date atvDate;
    /**
     * 交往地点
     */
    @TableField("atv_place")
    private String atvPlace;
    /**
     * 交往概要
     */
    @TableField("atv_title")
    private String atvTitle;
    /**
     * 详细信息
     */
    @TableField("atv_desc")
    private String atvDesc;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAtvCustNo() {
        return atvCustNo;
    }

    public void setAtvCustNo(Integer atvCustNo) {
        this.atvCustNo = atvCustNo;
    }

    public Date getAtvDate() {
        return atvDate;
    }

    public void setAtvDate(Date atvDate) {
        this.atvDate = atvDate;
    }

    public String getAtvPlace() {
        return atvPlace;
    }

    public void setAtvPlace(String atvPlace) {
        this.atvPlace = atvPlace;
    }

    public String getAtvTitle() {
        return atvTitle;
    }

    public void setAtvTitle(String atvTitle) {
        this.atvTitle = atvTitle;
    }

    public String getAtvDesc() {
        return atvDesc;
    }

    public void setAtvDesc(String atvDesc) {
        this.atvDesc = atvDesc;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Activity{" +
        ", id=" + id +
        ", atvCustNo=" + atvCustNo +
        ", atvDate=" + atvDate +
        ", atvPlace=" + atvPlace +
        ", atvTitle=" + atvTitle +
        ", atvDesc=" + atvDesc +
        "}";
    }
}
