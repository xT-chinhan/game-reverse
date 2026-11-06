package com.anythink.core.mg.api;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MgPreLoadAdRequest {
    private int abId;
    private int abItemId;
    private int cpEcpmReceiveTime;
    private int cpEcpmSwitch;
    private long cpEcpmTimeout;
    private MgComparedResult mgComparedResult;
    private JSONObject mpc;
    private String placementId;
    private MgPreLoadCallbackRegister preLoadCallbackRegister;
    private String psId;
    public String requestId;
    private int segId;

    private MgPreLoadAdRequest() {
        this.cpEcpmTimeout = 1000L;
    }

    public static class Builder {
        private final MgPreLoadAdRequest preLoadInfo = new MgPreLoadAdRequest();

        public Builder setRequestId(String str) {
            this.preLoadInfo.requestId = str;
            return this;
        }

        public Builder setPsId(String str) {
            this.preLoadInfo.psId = str;
            return this;
        }

        public Builder setPlacementId(String str) {
            this.preLoadInfo.placementId = str;
            return this;
        }

        public Builder setCpEcpmSwitch(int i) {
            this.preLoadInfo.cpEcpmSwitch = i;
            return this;
        }

        public Builder setCpEcpmTimeout(long j) {
            this.preLoadInfo.cpEcpmTimeout = j;
            return this;
        }

        public Builder setCpCallbackRegister(MgPreLoadCallbackRegister mgPreLoadCallbackRegister) {
            this.preLoadInfo.preLoadCallbackRegister = mgPreLoadCallbackRegister;
            return this;
        }

        public Builder setMPC(JSONObject jSONObject) {
            this.preLoadInfo.mpc = jSONObject;
            return this;
        }

        public Builder setSegId(int i) {
            this.preLoadInfo.segId = i;
            return this;
        }

        public Builder setAbId(int i) {
            this.preLoadInfo.abId = i;
            return this;
        }

        public Builder setAbItemId(int i) {
            this.preLoadInfo.abItemId = i;
            return this;
        }

        public MgPreLoadAdRequest build() {
            return this.preLoadInfo;
        }
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public String getPsId() {
        return this.psId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public boolean isEnableCpEcpm() {
        return this.cpEcpmSwitch == 1;
    }

    public int getCpEcpmSwitch() {
        return this.cpEcpmSwitch;
    }

    public long getCpEcpmTimeout() {
        return this.cpEcpmTimeout;
    }

    public MgPreLoadCallbackRegister getPreLoadCallbackRegister() {
        return this.preLoadCallbackRegister;
    }

    public MgComparedResult getMgComparedResult() {
        return this.mgComparedResult;
    }

    public void setMgComparedResult(MgComparedResult mgComparedResult) {
        this.mgComparedResult = mgComparedResult;
    }

    public int getCpEcpmReceiveTime() {
        return this.cpEcpmReceiveTime;
    }

    public void setCpEcpmReceiveTime(int i) {
        this.cpEcpmReceiveTime = i;
    }

    public JSONObject getMpc() {
        return this.mpc;
    }

    public int getSegId() {
        return this.segId;
    }

    public int getAbId() {
        return this.abId;
    }

    public int getAbItemId() {
        return this.abItemId;
    }
}
