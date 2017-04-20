package com.haima.crm.userinfo;

public class DealerInfo {


    private Long dealerId;
    private String dealerName;
    private String dealerType; //1总部 2经销商

    public Long getDealerId() {
        return dealerId;
    }

    public void setDealerId(Long dealerId) {
        this.dealerId = dealerId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getDealerType() {
        return dealerType;
    }

    public void setDealerType(String dealerType) {
        this.dealerType = dealerType;
    }

    @Override
    public String toString() {
        return "DealerInfo [dealerId=" + dealerId + ", dealerName="
                + dealerName + ", dealerType=" + dealerType + "]";
    }
}
