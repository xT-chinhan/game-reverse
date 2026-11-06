package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* JADX INFO: loaded from: classes2.dex */
public class MediationAdDislikeImpl implements Bridge, MediationAdDislike {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Bridge f3937ms;

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public MediationAdDislikeImpl(Bridge bridge) {
        this.f3937ms = bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void showDislikeDialog() {
        Bridge bridge = this.f3937ms;
        if (bridge != null) {
            bridge.call(8184, null, null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void setDislikeCallback(IMediationDislikeCallback iMediationDislikeCallback) {
        if (this.f3937ms != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8317, new MediationDislikeCallbackImpl(iMediationDislikeCallback));
            this.f3937ms.call(6085, mediationValueSetBuilderCreate.build(), null);
        }
    }
}
