package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 仓库表
 * </p>
 *
 * @author 何波
 * @since 2019-03-01
 */
@TableName("storage")
public class Storage extends Model<Storage> {

    private static final long serialVersionUID = 1L;

    /**
     * 仓库编号自动增长1，1
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 商品编号
     */
    @TableField("stk_prod_id")
    private Integer stkProdId;
    /**
     * 仓库名称
     */
    @TableField("stk_warehouse")
    private String stkWarehouse;
    /**
     * 货位
     */
    @TableField("stk_ware")
    private String stkWare;
    /**
     * 数量
     */
    @TableField("stk_count")
    private Integer stkCount;
    /**
     * 备注
     */
    @TableField("stk_memo")
    private String stkMemo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStkProdId() {
        return stkProdId;
    }

    public void setStkProdId(Integer stkProdId) {
        this.stkProdId = stkProdId;
    }

    public String getStkWarehouse() {
        return stkWarehouse;
    }

    public void setStkWarehouse(String stkWarehouse) {
        this.stkWarehouse = stkWarehouse;
    }

    public String getStkWare() {
        return stkWare;
    }

    public void setStkWare(String stkWare) {
        this.stkWare = stkWare;
    }

    public Integer getStkCount() {
        return stkCount;
    }

    public void setStkCount(Integer stkCount) {
        this.stkCount = stkCount;
    }

    public String getStkMemo() {
        return stkMemo;
    }

    public void setStkMemo(String stkMemo) {
        this.stkMemo = stkMemo;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Storage{" +
        ", id=" + id +
        ", stkProdId=" + stkProdId +
        ", stkWarehouse=" + stkWarehouse +
        ", stkWare=" + stkWare +
        ", stkCount=" + stkCount +
        ", stkMemo=" + stkMemo +
        "}";
    }
}
