package com.anythink.core.api;

import com.anythink.core.basead.adx.api.ATAdxBidFloorInfo;
import com.anythink.core.common.d.t;
import com.anythink.core.mg.api.MgPreLoadAdRequest;

/* JADX INFO: loaded from: classes.dex */
public class ATAdRequest {
    private ATAdxBidFloorInfo adxBidFloorInfo;
    private int channelSource;
    private MgPreLoadAdRequest preLoadInfo;

    private ATAdRequest() {
    }

    public int getChannelSource() {
        return this.channelSource;
    }

    public ATAdxBidFloorInfo getATAdxBidFloorInfo() {
        return this.adxBidFloorInfo;
    }

    public MgPreLoadAdRequest getPreLoadInfo() {
        return this.preLoadInfo;
    }

    public void setAdxBidFloorInfo(ATAdxBidFloorInfo aTAdxBidFloorInfo) {
        this.adxBidFloorInfo = aTAdxBidFloorInfo;
    }

    public static class Builder {
        private ATAdxBidFloorInfo adxBidFloorInfo;
        private int channelSource = t.b().E();
        private MgPreLoadAdRequest preLoadInfo;

        public Builder setChannelSource(int i) {
            this.channelSource = i;
            return this;
        }

        public Builder setATAdxBidFloorInfo(ATAdxBidFloorInfo aTAdxBidFloorInfo) {
            this.adxBidFloorInfo = aTAdxBidFloorInfo;
            return this;
        }

        public Builder setPreLoadInfo(MgPreLoadAdRequest mgPreLoadAdRequest) {
            this.preLoadInfo = mgPreLoadAdRequest;
            return this;
        }

        public ATAdRequest build() {
            ATAdRequest aTAdRequest = new ATAdRequest();
            aTAdRequest.channelSource = this.channelSource;
            aTAdRequest.adxBidFloorInfo = this.adxBidFloorInfo;
            aTAdRequest.preLoadInfo = this.preLoadInfo;
            return aTAdRequest;
        }
    }
}
