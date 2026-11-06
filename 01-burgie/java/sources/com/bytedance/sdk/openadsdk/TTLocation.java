package com.bytedance.sdk.openadsdk;

import com.byazt.vzx.pr;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 2309})
public class TTLocation implements LocationProvider {
    private double hw;
    private double pr;

    public TTLocation(double d, double d2) {
        this.pr = 0.0d;
        this.hw = 0.0d;
        this.pr = d;
        this.hw = d2;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.pr;
    }

    public void setLatitude(double d) {
        this.pr = d;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.hw;
    }

    public void setLongitude(double d) {
        this.hw = d;
    }
}
