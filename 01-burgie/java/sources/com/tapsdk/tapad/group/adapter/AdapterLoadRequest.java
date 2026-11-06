package com.tapsdk.tapad.group.adapter;

/* JADX INFO: loaded from: classes2.dex */
public final class AdapterLoadRequest {
    private final int acceptedHeightPx;
    private final int acceptedWidthPx;
    private final int adCount;
    private final long minaId;
    private final String placementId;
    private final boolean preload;
    private final String query;

    public AdapterLoadRequest(String str, int i, int i2, int i3, boolean z, long j, String str2) {
        this.placementId = str == null ? "" : str;
        this.acceptedWidthPx = i;
        this.acceptedHeightPx = i2;
        this.adCount = Math.max(1, i3);
        this.preload = z;
        this.minaId = j;
        this.query = str2 == null ? "" : str2;
    }

    public int getAcceptedHeightPx() {
        return this.acceptedHeightPx;
    }

    public int getAcceptedWidthPx() {
        return this.acceptedWidthPx;
    }

    public int getAdCount() {
        return this.adCount;
    }

    public long getMinaId() {
        return this.minaId;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public String getQuery() {
        return this.query;
    }

    public boolean isPreload() {
        return this.preload;
    }
}
