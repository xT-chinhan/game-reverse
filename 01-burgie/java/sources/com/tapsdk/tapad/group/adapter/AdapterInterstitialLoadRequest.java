package com.tapsdk.tapad.group.adapter;

/* JADX INFO: loaded from: classes2.dex */
public final class AdapterInterstitialLoadRequest {
    private final AdapterLoadRequest common;
    private final int presentationStyle;
    private final boolean selfRendered;
    private final long timeoutMillis;

    public AdapterInterstitialLoadRequest(AdapterLoadRequest adapterLoadRequest, int i, boolean z, long j) {
        if (adapterLoadRequest == null) {
            throw new IllegalArgumentException("missing common load request");
        }
        this.common = adapterLoadRequest;
        this.presentationStyle = i;
        this.selfRendered = z;
        this.timeoutMillis = Math.max(0L, j);
    }

    public AdapterLoadRequest getCommon() {
        return this.common;
    }

    public int getPresentationStyle() {
        return this.presentationStyle;
    }

    public long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    public boolean isSelfRendered() {
        return this.selfRendered;
    }
}
