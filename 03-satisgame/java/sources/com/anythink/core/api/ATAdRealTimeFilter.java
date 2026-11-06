package com.anythink.core.api;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ATAdRealTimeFilter {
    private static ATAdRealTimeFilter sInstance;
    private Long biddingWaitMaxTime;
    private RLFilterListener filterListener;

    public static abstract class RLFilterListener {
        public abstract ATAdFilter filterAdByBiddingResult(List<ATAdInfo> list, boolean z);
    }

    public Long getBiddingWaitMaxTime() {
        return this.biddingWaitMaxTime;
    }

    public static ATAdRealTimeFilter getInstance() {
        ATAdRealTimeFilter aTAdRealTimeFilter;
        synchronized (ATAdRealTimeFilter.class) {
            if (sInstance == null) {
                sInstance = new ATAdRealTimeFilter();
            }
            aTAdRealTimeFilter = sInstance;
        }
        return aTAdRealTimeFilter;
    }

    public void registerAdRealTimeFilterListener(RLFilterListener rLFilterListener) {
        this.filterListener = rLFilterListener;
    }

    public void registerAdRealTimeFilterListener(RLFilterListener rLFilterListener, Long l) {
        this.filterListener = rLFilterListener;
        this.biddingWaitMaxTime = l;
    }

    public RLFilterListener getRLFilterListener() {
        return this.filterListener;
    }
}
