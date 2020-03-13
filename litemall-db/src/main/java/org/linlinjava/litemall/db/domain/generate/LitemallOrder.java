package org.linlinjava.litemall.db.domain.generate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class LitemallOrder {
    public static final Boolean IS_DELETED = Deleted.IS_DELETED.value();

    public static final Boolean NOT_DELETED = Deleted.NOT_DELETED.value();

    private Integer id;

    private Integer userId;

    private String orderSn;

    private Short orderStatus;

    private Short aftersaleStatus;

    private String consignee;

    private String mobile;

    private String address;

    private String message;

    private BigDecimal goodsPrice;

    private BigDecimal freightPrice;

    private BigDecimal couponPrice;

    private BigDecimal integralPrice;

    private BigDecimal grouponPrice;

    private BigDecimal orderPrice;

    private BigDecimal actualPrice;

    private String payId;

    private LocalDateTime payTime;

    private String shipSn;

    private String shipChannel;

    private LocalDateTime shipTime;

    private BigDecimal refundAmount;

    private String refundType;

    private String refundContent;

    private LocalDateTime refundTime;

    private LocalDateTime confirmTime;

    private Short comments;

    private LocalDateTime endTime;

    private LocalDateTime addTime;

    private LocalDateTime updateTime;

    private Boolean deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Short getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Short orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Short getAftersaleStatus() {
        return aftersaleStatus;
    }

    public void setAftersaleStatus(Short aftersaleStatus) {
        this.aftersaleStatus = aftersaleStatus;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    public BigDecimal getIntegralPrice() {
        return integralPrice;
    }

    public void setIntegralPrice(BigDecimal integralPrice) {
        this.integralPrice = integralPrice;
    }

    public BigDecimal getGrouponPrice() {
        return grouponPrice;
    }

    public void setGrouponPrice(BigDecimal grouponPrice) {
        this.grouponPrice = grouponPrice;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public LocalDateTime getPayTime() {
        return payTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }

    public String getShipSn() {
        return shipSn;
    }

    public void setShipSn(String shipSn) {
        this.shipSn = shipSn;
    }

    public String getShipChannel() {
        return shipChannel;
    }

    public void setShipChannel(String shipChannel) {
        this.shipChannel = shipChannel;
    }

    public LocalDateTime getShipTime() {
        return shipTime;
    }

    public void setShipTime(LocalDateTime shipTime) {
        this.shipTime = shipTime;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType;
    }

    public String getRefundContent() {
        return refundContent;
    }

    public void setRefundContent(String refundContent) {
        this.refundContent = refundContent;
    }

    public LocalDateTime getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(LocalDateTime refundTime) {
        this.refundTime = refundTime;
    }

    public LocalDateTime getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(LocalDateTime confirmTime) {
        this.confirmTime = confirmTime;
    }

    public Short getComments() {
        return comments;
    }

    public void setComments(Short comments) {
        this.comments = comments;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public void andLogicalDeleted(boolean deleted) {
        setDeleted(deleted ? Deleted.IS_DELETED.value() : Deleted.NOT_DELETED.value());
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", IS_DELETED=").append(IS_DELETED);
        sb.append(", NOT_DELETED=").append(NOT_DELETED);
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", aftersaleStatus=").append(aftersaleStatus);
        sb.append(", consignee=").append(consignee);
        sb.append(", mobile=").append(mobile);
        sb.append(", address=").append(address);
        sb.append(", message=").append(message);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", freightPrice=").append(freightPrice);
        sb.append(", couponPrice=").append(couponPrice);
        sb.append(", integralPrice=").append(integralPrice);
        sb.append(", grouponPrice=").append(grouponPrice);
        sb.append(", orderPrice=").append(orderPrice);
        sb.append(", actualPrice=").append(actualPrice);
        sb.append(", payId=").append(payId);
        sb.append(", payTime=").append(payTime);
        sb.append(", shipSn=").append(shipSn);
        sb.append(", shipChannel=").append(shipChannel);
        sb.append(", shipTime=").append(shipTime);
        sb.append(", refundAmount=").append(refundAmount);
        sb.append(", refundType=").append(refundType);
        sb.append(", refundContent=").append(refundContent);
        sb.append(", refundTime=").append(refundTime);
        sb.append(", confirmTime=").append(confirmTime);
        sb.append(", comments=").append(comments);
        sb.append(", endTime=").append(endTime);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleted=").append(deleted);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LitemallOrder other = (LitemallOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOrderSn() == null ? other.getOrderSn() == null : this.getOrderSn().equals(other.getOrderSn()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getAftersaleStatus() == null ? other.getAftersaleStatus() == null : this.getAftersaleStatus().equals(other.getAftersaleStatus()))
            && (this.getConsignee() == null ? other.getConsignee() == null : this.getConsignee().equals(other.getConsignee()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
            && (this.getGoodsPrice() == null ? other.getGoodsPrice() == null : this.getGoodsPrice().equals(other.getGoodsPrice()))
            && (this.getFreightPrice() == null ? other.getFreightPrice() == null : this.getFreightPrice().equals(other.getFreightPrice()))
            && (this.getCouponPrice() == null ? other.getCouponPrice() == null : this.getCouponPrice().equals(other.getCouponPrice()))
            && (this.getIntegralPrice() == null ? other.getIntegralPrice() == null : this.getIntegralPrice().equals(other.getIntegralPrice()))
            && (this.getGrouponPrice() == null ? other.getGrouponPrice() == null : this.getGrouponPrice().equals(other.getGrouponPrice()))
            && (this.getOrderPrice() == null ? other.getOrderPrice() == null : this.getOrderPrice().equals(other.getOrderPrice()))
            && (this.getActualPrice() == null ? other.getActualPrice() == null : this.getActualPrice().equals(other.getActualPrice()))
            && (this.getPayId() == null ? other.getPayId() == null : this.getPayId().equals(other.getPayId()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getShipSn() == null ? other.getShipSn() == null : this.getShipSn().equals(other.getShipSn()))
            && (this.getShipChannel() == null ? other.getShipChannel() == null : this.getShipChannel().equals(other.getShipChannel()))
            && (this.getShipTime() == null ? other.getShipTime() == null : this.getShipTime().equals(other.getShipTime()))
            && (this.getRefundAmount() == null ? other.getRefundAmount() == null : this.getRefundAmount().equals(other.getRefundAmount()))
            && (this.getRefundType() == null ? other.getRefundType() == null : this.getRefundType().equals(other.getRefundType()))
            && (this.getRefundContent() == null ? other.getRefundContent() == null : this.getRefundContent().equals(other.getRefundContent()))
            && (this.getRefundTime() == null ? other.getRefundTime() == null : this.getRefundTime().equals(other.getRefundTime()))
            && (this.getConfirmTime() == null ? other.getConfirmTime() == null : this.getConfirmTime().equals(other.getConfirmTime()))
            && (this.getComments() == null ? other.getComments() == null : this.getComments().equals(other.getComments()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOrderSn() == null) ? 0 : getOrderSn().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getAftersaleStatus() == null) ? 0 : getAftersaleStatus().hashCode());
        result = prime * result + ((getConsignee() == null) ? 0 : getConsignee().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
        result = prime * result + ((getGoodsPrice() == null) ? 0 : getGoodsPrice().hashCode());
        result = prime * result + ((getFreightPrice() == null) ? 0 : getFreightPrice().hashCode());
        result = prime * result + ((getCouponPrice() == null) ? 0 : getCouponPrice().hashCode());
        result = prime * result + ((getIntegralPrice() == null) ? 0 : getIntegralPrice().hashCode());
        result = prime * result + ((getGrouponPrice() == null) ? 0 : getGrouponPrice().hashCode());
        result = prime * result + ((getOrderPrice() == null) ? 0 : getOrderPrice().hashCode());
        result = prime * result + ((getActualPrice() == null) ? 0 : getActualPrice().hashCode());
        result = prime * result + ((getPayId() == null) ? 0 : getPayId().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getShipSn() == null) ? 0 : getShipSn().hashCode());
        result = prime * result + ((getShipChannel() == null) ? 0 : getShipChannel().hashCode());
        result = prime * result + ((getShipTime() == null) ? 0 : getShipTime().hashCode());
        result = prime * result + ((getRefundAmount() == null) ? 0 : getRefundAmount().hashCode());
        result = prime * result + ((getRefundType() == null) ? 0 : getRefundType().hashCode());
        result = prime * result + ((getRefundContent() == null) ? 0 : getRefundContent().hashCode());
        result = prime * result + ((getRefundTime() == null) ? 0 : getRefundTime().hashCode());
        result = prime * result + ((getConfirmTime() == null) ? 0 : getConfirmTime().hashCode());
        result = prime * result + ((getComments() == null) ? 0 : getComments().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    public enum Deleted {
        NOT_DELETED(new Boolean("0"), "未删除"),
        IS_DELETED(new Boolean("1"), "已删除");

        private final Boolean value;

        private final String name;

        Deleted(Boolean value, String name) {
            this.value = value;
            this.name = name;
        }

        public Boolean getValue() {
            return this.value;
        }

        public Boolean value() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }
    }

    public enum Column {
        id("id", "id", "INTEGER", false),
        userId("user_id", "userId", "INTEGER", false),
        orderSn("order_sn", "orderSn", "VARCHAR", false),
        orderStatus("order_status", "orderStatus", "SMALLINT", false),
        aftersaleStatus("aftersale_status", "aftersaleStatus", "SMALLINT", false),
        consignee("consignee", "consignee", "VARCHAR", false),
        mobile("mobile", "mobile", "VARCHAR", false),
        address("address", "address", "VARCHAR", false),
        message("message", "message", "VARCHAR", false),
        goodsPrice("goods_price", "goodsPrice", "DECIMAL", false),
        freightPrice("freight_price", "freightPrice", "DECIMAL", false),
        couponPrice("coupon_price", "couponPrice", "DECIMAL", false),
        integralPrice("integral_price", "integralPrice", "DECIMAL", false),
        grouponPrice("groupon_price", "grouponPrice", "DECIMAL", false),
        orderPrice("order_price", "orderPrice", "DECIMAL", false),
        actualPrice("actual_price", "actualPrice", "DECIMAL", false),
        payId("pay_id", "payId", "VARCHAR", false),
        payTime("pay_time", "payTime", "TIMESTAMP", false),
        shipSn("ship_sn", "shipSn", "VARCHAR", false),
        shipChannel("ship_channel", "shipChannel", "VARCHAR", false),
        shipTime("ship_time", "shipTime", "TIMESTAMP", false),
        refundAmount("refund_amount", "refundAmount", "DECIMAL", false),
        refundType("refund_type", "refundType", "VARCHAR", false),
        refundContent("refund_content", "refundContent", "VARCHAR", false),
        refundTime("refund_time", "refundTime", "TIMESTAMP", false),
        confirmTime("confirm_time", "confirmTime", "TIMESTAMP", false),
        comments("comments", "comments", "SMALLINT", false),
        endTime("end_time", "endTime", "TIMESTAMP", false),
        addTime("add_time", "addTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        deleted("deleted", "deleted", "BIT", false);

        private static final String BEGINNING_DELIMITER = "`";

        private static final String ENDING_DELIMITER = "`";

        private final String column;

        private final boolean isColumnNameDelimited;

        private final String javaProperty;

        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}