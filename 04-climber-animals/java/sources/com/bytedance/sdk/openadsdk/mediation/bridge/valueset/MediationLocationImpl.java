package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* JADX INFO: loaded from: classes2.dex */
public class MediationLocationImpl implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private IMediationLocation f3985ms;

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    public MediationLocationImpl(IMediationLocation iMediationLocation) {
        this.f3985ms = iMediationLocation;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
        IMediationLocation iMediationLocation = this.f3985ms;
        mediationValueSetBuilderCreate.add(8481, iMediationLocation != null ? iMediationLocation.getLatitude() : 0.0d);
        IMediationLocation iMediationLocation2 = this.f3985ms;
        mediationValueSetBuilderCreate.add(8482, iMediationLocation2 != null ? iMediationLocation2.getLongitude() : 0.0d);
        return mediationValueSetBuilderCreate.build();
    }
}
