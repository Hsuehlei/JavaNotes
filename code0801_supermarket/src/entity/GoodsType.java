package entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/28 20:43
 */
public class GoodsType {
    /*
    类型ID  int 自增 唯一
    父id   int   当父id为0时  代表的是一级类目  pid
    类型名称 varchar(20) 非空
    是否为父类型 tinyint(1) 1为是，0为否
    创建时间 datetime 可空
    修改时间 datetime 可空
     */
    private Integer typeId;
    private Integer fatherId;
    private String typeName;
    private Boolean ifFatherType;
    private Timestamp createTime;
    private Timestamp updateTime;

    public GoodsType() {
    }

    public GoodsType(Integer typeId, Integer fatherId, String typeName, Boolean ifFatherType) {
        this.typeId = typeId;
        this.fatherId = fatherId;
        this.typeName = typeName;
        this.ifFatherType = ifFatherType;
    }

    public GoodsType(Integer fatherId, String typeName, Boolean ifFatherType) {
        this.fatherId = fatherId;
        this.typeName = typeName;
        this.ifFatherType = ifFatherType;
    }

    public GoodsType(Integer typeId, Integer fatherId, String typeName, Boolean ifFatherType, Timestamp createTime, Timestamp updateTime) {
        this.typeId = typeId;
        this.fatherId = fatherId;
        this.typeName = typeName;
        this.ifFatherType = ifFatherType;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Boolean getIfFatherType() {
        return ifFatherType;
    }

    public void setIfFatherType(Boolean ifFatherType) {
        this.ifFatherType = ifFatherType;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
