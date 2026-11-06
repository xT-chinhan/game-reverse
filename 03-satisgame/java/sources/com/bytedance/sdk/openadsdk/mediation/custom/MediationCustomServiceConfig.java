package com.bytedance.sdk.openadsdk.mediation.custom;

import com.byazt.cp.n;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 1689})
public final class MediationCustomServiceConfig {
    private String l;
    private String n;
    private int q;
    private String qg;
    private int s;
    private Map<String, Object> w = new HashMap();

    public MediationCustomServiceConfig(String str, String str2, int i, int i2, String str3) {
        this.n = str;
        this.qg = str2;
        this.s = i;
        this.q = i2;
        this.l = str3;
    }

    public MediationCustomServiceConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.n = valueSet.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec);
            this.qg = valueSet.stringValue(2);
            this.s = valueSet.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
            this.q = valueSet.intValue(8094);
            this.l = valueSet.stringValue(8547);
            Map<? extends String, ? extends Object> map = (Map) valueSet.objectValue(8075, Map.class);
            if (map == null || map.size() <= 0) {
                return;
            }
            this.w.putAll(map);
        }
    }

    public String getADNNetworkName() {
        return this.n;
    }

    public String getADNNetworkSlotId() {
        return this.qg;
    }

    public int getAdStyleType() {
        return this.s;
    }

    public int getSubAdtype() {
        return this.q;
    }

    public String getCustomAdapterJson() {
        return this.l;
    }

    public Map<String, Object> getExtraData() {
        return this.w;
    }

    public String toString() {
        return "MediationCustomServiceConfig{mADNNetworkName='" + this.n + "', mADNNetworkSlotId='" + this.qg + "', mAdStyleType=" + this.s + ", mSubAdtype=" + this.q + ", mCustomAdapterJson='" + this.l + "'}";
    }
}
