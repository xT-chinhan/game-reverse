package com.anythink.core.api;

import com.anythink.core.common.g.c;

/* JADX INFO: loaded from: classes.dex */
public class ATCustomAdapterConfig {
    private long adCacheTime;
    private int lossNoticePosition;
    private boolean realTimeBidSwitch;

    private ATCustomAdapterConfig() {
    }

    public boolean isRealTimeBidSwitch() {
        return this.realTimeBidSwitch;
    }

    public long getAdCacheTime() {
        return this.adCacheTime;
    }

    public int getLossNoticePostion() {
        return this.lossNoticePosition;
    }

    public static class Builder {
        private boolean realTimeBidSwitch = false;
        private long adCacheTime = c.a;
        private int lossNoticePosition = -1;

        public Builder realTimeBidSwitch(boolean z) {
            this.realTimeBidSwitch = z;
            return this;
        }

        public Builder adCacheTime(long j) {
            this.adCacheTime = j;
            return this;
        }

        public Builder lossNoticePosition(int i) {
            this.lossNoticePosition = i;
            return this;
        }

        public ATCustomAdapterConfig build() {
            ATCustomAdapterConfig aTCustomAdapterConfig = new ATCustomAdapterConfig();
            aTCustomAdapterConfig.realTimeBidSwitch = this.realTimeBidSwitch;
            aTCustomAdapterConfig.adCacheTime = this.adCacheTime;
            aTCustomAdapterConfig.lossNoticePosition = this.lossNoticePosition;
            return aTCustomAdapterConfig;
        }
    }
}
