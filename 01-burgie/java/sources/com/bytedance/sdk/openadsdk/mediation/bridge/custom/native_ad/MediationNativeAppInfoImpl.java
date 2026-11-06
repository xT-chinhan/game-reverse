package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.util.SparseArray;
import com.byazt.vzx.pr;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 81, 232, 233, 1412, 1521})
public class MediationNativeAppInfoImpl extends com.byazt.f.pr {
    private SparseArray<Object> hw = new SparseArray<>();
    private MediationNativeAdAppInfo pr;

    public MediationNativeAppInfoImpl(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.pr = mediationNativeAdAppInfo;
    }

    public SparseArray<Object> values() {
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.pr;
        if (mediationNativeAdAppInfo != null) {
            this.hw.put(8505, mediationNativeAdAppInfo.getAppName());
            this.hw.put(8506, this.pr.getAuthorName());
            this.hw.put(8507, Long.valueOf(this.pr.getPackageSizeBytes()));
            this.hw.put(8508, this.pr.getPermissionsUrl());
            this.hw.put(8509, this.pr.getPermissionsMap());
            this.hw.put(8510, this.pr.getPrivacyAgreement());
            this.hw.put(8511, this.pr.getVersionName());
            this.hw.put(8512, this.pr.getAppInfoExtra());
            this.hw.put(8551, this.pr.getFunctionDescUrl());
            this.hw.put(8559, this.pr.getRegUrl());
        }
        return this.hw;
    }

    @Override // com.byazt.f.pr
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) values();
        }
        return null;
    }

    @Override // com.byazt.f.pr
    public SparseArray<Object> get() {
        SparseArray<Object> sparseArrayValues = values();
        if (sparseArrayValues != null) {
            return sparseArrayValues;
        }
        return null;
    }
}
