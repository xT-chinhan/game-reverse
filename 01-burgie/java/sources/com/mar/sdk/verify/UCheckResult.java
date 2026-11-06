package com.mar.sdk.verify;

/* JADX INFO: loaded from: classes2.dex */
public class UCheckResult {
    private int pollOrderNumLimited;
    private int state;
    private int supplyOrderNum;

    public UCheckResult(int state, int supplyOrderNum, int pollOrderNumLimited) {
        this.state = state;
        this.supplyOrderNum = supplyOrderNum;
        this.pollOrderNumLimited = pollOrderNumLimited;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getSupplyOrderNum() {
        return this.supplyOrderNum;
    }

    public void setSupplyOrderNum(int supplyOrderNum) {
        this.supplyOrderNum = supplyOrderNum;
    }

    public void setPollOrderNumLimited(int pollOrderNumLimited) {
        this.pollOrderNumLimited = pollOrderNumLimited;
    }

    public int getPollOrderNumLimited() {
        return this.pollOrderNumLimited;
    }

    public String toString() {
        return "UCheckResult [state=" + this.state + ", supplyOrderNum=" + this.supplyOrderNum + ",pollOrderNumLimited=" + this.pollOrderNumLimited + "]";
    }
}
