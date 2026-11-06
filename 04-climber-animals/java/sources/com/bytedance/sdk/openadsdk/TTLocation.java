package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: classes2.dex */
public class TTLocation implements LocationProvider {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private double f1643ms;
    private double xr;

    public TTLocation(double d, double d2) {
        this.f1643ms = d;
        this.xr = d2;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.f1643ms;
    }

    public void setLatitude(double d) {
        this.f1643ms = d;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.xr;
    }

    public void setLongitude(double d) {
        this.xr = d;
    }
}
