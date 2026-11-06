package com.bytedance.sdk.openadsdk.mediation.custom;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class MediationCustomServiceConfig {
    private int ah;
    private Map<String, Object> c = new HashMap();
    private int d;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3987ms;
    private String xr;

    public MediationCustomServiceConfig(String str, String str2, int i, int i2, String str3) {
        this.f3987ms = str;
        this.xr = str2;
        this.ah = i;
        this.d = i2;
        this.ka = str3;
    }

    public MediationCustomServiceConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.f3987ms = valueSet.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec);
            this.xr = valueSet.stringValue(2);
            this.ah = valueSet.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
            this.d = valueSet.intValue(8094);
            this.ka = valueSet.stringValue(8547);
            Map<? extends String, ? extends Object> map = (Map) valueSet.objectValue(8075, Map.class);
            if (map == null || map.size() <= 0) {
                return;
            }
            this.c.putAll(map);
        }
    }

    public String getADNNetworkName() {
        return this.f3987ms;
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

    public Map<String, Object> getExtraData() {
        return this.c;
    }

    public String toString() {
        return "MediationCustomServiceConfig{mADNNetworkName='" + this.f3987ms + "', mADNNetworkSlotId='" + this.xr + "', mAdStyleType=" + this.ah + ", mSubAdtype=" + this.d + ", mCustomAdapterJson='" + this.ka + "'}";
    }
}
