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
 * 客户开发计划表
 * </p>
 *
 * @author 何波
 * @since 2019-03-01
 */
@TableName("sal_plan")
public class Plan extends Model<Plan> {

    private static final long serialVersionUID = 1L;

    /**
     * 计划编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("pla_date")
    private Date plaDate;
    /**
     * 计划项
     */
    @TableField("pla_todo")
    private String plaTodo;
    /**
     * 执行结果
     */
    @TableField("pla_result")
    private String plaResult;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPlaDate() {
        return plaDate;
    }

    public void setPlaDate(Date plaDate) {
        this.plaDate = plaDate;
    }

    public String getPlaTodo() {
        return plaTodo;
    }

    public void setPlaTodo(String plaTodo) {
        this.plaTodo = plaTodo;
    }

    public String getPlaResult() {
        return plaResult;
    }

    public void setPlaResult(String plaResult) {
        this.plaResult = plaResult;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Plan{" +
        ", id=" + id +
        ", plaDate=" + plaDate +
        ", plaTodo=" + plaTodo +
        ", plaResult=" + plaResult +
        "}";
    }
}
