package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author 何波
 * @since 2019-03-01
 */
@TableName("product")
public class Product extends Model<Product> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品编号（自动增长1，1）
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 商品名称
     */
    @TableField("prod_name")
    private String prodName;
    /**
     * 商品类型
     */
    @TableField("prod_type")
    private String prodType;
    /**
     * 批号
     */
    @TableField("prod_batch")
    private String prodBatch;
    /**
     * 单位
     */
    @TableField("prod_unit")
    private String prodUnit;
    /**
     * 价格
     */
    @TableField("prod_price")
    private Integer prodPrice;
    /**
     * 备注
     */
    @TableField("prod_memo")
    private String prodMemo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getProdBatch() {
        return prodBatch;
    }

    public void setProdBatch(String prodBatch) {
        this.prodBatch = prodBatch;
    }

    public String getProdUnit() {
        return prodUnit;
    }

    public void setProdUnit(String prodUnit) {
        this.prodUnit = prodUnit;
    }

    public Integer getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(Integer prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdMemo() {
        return prodMemo;
    }

    public void setProdMemo(String prodMemo) {
        this.prodMemo = prodMemo;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Product{" +
        ", id=" + id +
        ", prodName=" + prodName +
        ", prodType=" + prodType +
        ", prodBatch=" + prodBatch +
        ", prodUnit=" + prodUnit +
        ", prodPrice=" + prodPrice +
        ", prodMemo=" + prodMemo +
        "}";
    }
}
