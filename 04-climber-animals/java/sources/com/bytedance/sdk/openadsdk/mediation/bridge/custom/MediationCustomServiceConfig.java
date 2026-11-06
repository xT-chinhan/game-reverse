package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public final class MediationCustomServiceConfig {
    private int ah;
    private int d;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3978ms;
    private String xr;

    public MediationCustomServiceConfig(String str, String str2, int i, int i2, String str3) {
        this.f3978ms = str;
        this.xr = str2;
        this.ah = i;
        this.d = i2;
        this.ka = str3;
    }

    public MediationCustomServiceConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.f3978ms = valueSet.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec);
            this.xr = valueSet.stringValue(2);
            this.ah = valueSet.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
            this.d = valueSet.intValue(8094);
            this.ka = valueSet.stringValue(8547);
        }
    }

    public String getADNNetworkName() {
        return this.f3978ms;
    }

    public String getADNNetworkSlotId() {
        return this.xr;
    }

    public int getAdStyleType() {
        return this.ah;
    }

    public int getSubAdtype() {
        return this.d;
    }

    public String getCustomAdapterJson() {
        return this.ka;
    }

    public String toString() {
        return "MediationCustomServiceConfig{mADNNetworkName='" + this.f3978ms + "', mADNNetworkSlotId='" + this.xr + "', mAdStyleType=" + this.ah + ", mSubAdtype=" + this.d + ", mCustomAdapterJson='" + this.ka + "'}";
    }
}
