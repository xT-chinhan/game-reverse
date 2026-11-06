package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.ms.ms;

/* JADX INFO: loaded from: classes2.dex */
public class MediationNativeAppInfoImpl extends ms implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private MediationNativeAdAppInfo f3981ms;
    private MediationValueSetBuilder xr = MediationValueSetBuilder.create();

    @Override // com.bytedance.sdk.openadsdk.mediation.ms.ms
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    public MediationNativeAppInfoImpl(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.f3981ms = mediationNativeAdAppInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.f3981ms;
        if (mediationNativeAdAppInfo != null) {
            this.xr.add(8505, mediationNativeAdAppInfo.getAppName());
            this.xr.add(8506, this.f3981ms.getAuthorName());
            this.xr.add(8507, this.f3981ms.getPackageSizeBytes());
            this.xr.add(8508, this.f3981ms.getPermissionsUrl());
            this.xr.add(8509, this.f3981ms.getPermissionsMap());
            this.xr.add(8510, this.f3981ms.getPrivacyAgreement());
            this.xr.add(8511, this.f3981ms.getVersionName());
            this.xr.add(8512, this.f3981ms.getAppInfoExtra());
        }
        return this.xr.build();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ms.ms, java.util.function.Supplier
    public SparseArray<Object> get() {
        ValueSet valueSetValues = values();
        if (valueSetValues != null) {
            SparseArray<Object> sparseArray = valueSetValues.sparseArray();
            appendProto2Params(sparseArray);
            return sparseArray;
        }
        return super.get();
    }
}
