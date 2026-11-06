package com.bytedance.sdk.openadsdk;

import com.byazt.cp.n;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, AVMDLDataLoader.KeyIsEnableLoaderPreempt})
public class TTLocation implements LocationProvider {
    private double n;
    private double qg;

    public TTLocation(double d, double d2) {
        this.n = d;
        this.qg = d2;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.n;
    }

    public void setLatitude(double d) {
        this.n = d;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.qg;
    }

    public void setLongitude(double d) {
        this.qg = d;
    }
}
