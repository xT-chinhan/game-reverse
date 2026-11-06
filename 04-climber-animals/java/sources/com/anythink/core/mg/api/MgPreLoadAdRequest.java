package com.anythink.core.mg.api;

/* JADX INFO: loaded from: classes.dex */
public class MgPreLoadAdRequest {
    private int cpEcpmReceiveTime;
    private int cpEcpmSwitch;
    private long cpEcpmTimeout;
    private MgComparedResult mgComparedResult;
    private String placementId;
    private MgPreLoadCallbackRegister preLoadCallbackRegister;
    private String psId;
    private String requestId;

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
}
