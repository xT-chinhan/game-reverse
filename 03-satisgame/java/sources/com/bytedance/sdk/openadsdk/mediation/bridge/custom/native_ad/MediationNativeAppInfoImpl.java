package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.util.SparseArray;
import com.byazt.cp.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 1656, 1657})
public class MediationNativeAppInfoImpl extends com.byazt.ku.n {
    private MediationNativeAdAppInfo n;
    private SparseArray<Object> qg = new SparseArray<>();

    public MediationNativeAppInfoImpl(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.n = mediationNativeAdAppInfo;
    }

    public SparseArray<Object> values() {
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.n;
        if (mediationNativeAdAppInfo != null) {
            this.qg.put(8505, mediationNativeAdAppInfo.getAppName());
            this.qg.put(8506, this.n.getAuthorName());
            this.qg.put(8507, Long.valueOf(this.n.getPackageSizeBytes()));
            this.qg.put(8508, this.n.getPermissionsUrl());
            this.qg.put(8509, this.n.getPermissionsMap());
            this.qg.put(8510, this.n.getPrivacyAgreement());
            this.qg.put(8511, this.n.getVersionName());
            this.qg.put(8512, this.n.getAppInfoExtra());
            this.qg.put(8551, this.n.getFunctionDescUrl());
            this.qg.put(8559, this.n.getRegUrl());
        }
        return this.qg;
    }

    @Override // com.byazt.ku.n
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) values();
        }
        return null;
    }

    @Override // com.byazt.ku.n
    public SparseArray<Object> get() {
        SparseArray<Object> sparseArrayValues = values();
        if (sparseArrayValues != null) {
            return sparseArrayValues;
        }
        return null;
    }
}
