package com.tapsdk.tapad.group.adapter;

/* JADX INFO: loaded from: classes2.dex */
public final class AdapterSplashLoadRequest {
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int ORIENTATION_UNKNOWN = 0;
    private final int acceptedImageHeightPx;
    private final int acceptedImageWidthPx;
    private final AdapterLoadRequest common;
    private final boolean doubleWindow;
    private final boolean providerPreload;
    private final int screenOrientation;
    private final boolean selfRendered;
    private final long timeoutMillis;

    public AdapterSplashLoadRequest(AdapterLoadRequest adapterLoadRequest, int i, int i2, int i3, boolean z, boolean z2, boolean z3, long j) {
        if (adapterLoadRequest == null) {
            throw new IllegalArgumentException("missing common load request");
        }
        this.common = adapterLoadRequest;
        this.acceptedImageWidthPx = i;
        this.acceptedImageHeightPx = i2;
        this.screenOrientation = i3;
        this.selfRendered = z;
        this.providerPreload = z2;
        this.doubleWindow = z3;
        this.timeoutMillis = Math.max(0L, j);
    }

    public int getAcceptedImageHeightPx() {
        return this.acceptedImageHeightPx;
    }

    public int getAcceptedImageWidthPx() {
        return this.acceptedImageWidthPx;
    }

    public AdapterLoadRequest getCommon() {
        return this.common;
    }

    public int getScreenOrientation() {
        return this.screenOrientation;
    }

    public long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    public boolean isDoubleWindow() {
        return this.doubleWindow;
    }

    public boolean isProviderPreload() {
        return this.providerPreload;
    }

    public boolean isSelfRendered() {
        return this.selfRendered;
    }
}
