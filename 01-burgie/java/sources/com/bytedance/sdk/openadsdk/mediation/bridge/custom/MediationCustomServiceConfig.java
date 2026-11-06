package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import com.byazt.vzx.pr;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 81, 232, 233, 1551})
public final class MediationCustomServiceConfig {
    private String c;
    private int hn;
    private String hw;
    private String pr;
    private int x;

    public MediationCustomServiceConfig(String str, String str2, int i, int i2, String str3) {
        this.pr = str;
        this.hw = str2;
        this.hn = i;
        this.x = i2;
        this.c = str3;
    }

    public MediationCustomServiceConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.pr = valueSet.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec);
            this.hw = valueSet.stringValue(2);
            this.hn = valueSet.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
            this.x = valueSet.intValue(8094);
            this.c = valueSet.stringValue(8547);
        }
    }

    public String getADNNetworkName() {
        return this.pr;
    }

    public String getADNNetworkSlotId() {
        return this.hw;
    }

    public int getAdStyleType() {
        return this.hn;
    }

    public int getSubAdtype() {
        return this.x;
    }

    public String getCustomAdapterJson() {
        return this.c;
    }

    public String toString() {
        return "MediationCustomServiceConfig{mADNNetworkName='" + this.pr + "', mADNNetworkSlotId='" + this.hw + "', mAdStyleType=" + this.hn + ", mSubAdtype=" + this.x + ", mCustomAdapterJson='" + this.c + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
