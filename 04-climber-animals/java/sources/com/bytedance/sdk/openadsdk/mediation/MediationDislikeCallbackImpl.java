package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;

/* JADX INFO: loaded from: classes2.dex */
public class MediationDislikeCallbackImpl implements Bridge, IMediationDislikeCallback {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private IMediationDislikeCallback f3943ms;

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onCancel() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onShow() {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public MediationDislikeCallbackImpl(IMediationDislikeCallback iMediationDislikeCallback) {
        this.f3943ms = iMediationDislikeCallback;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8188) {
            onSelected(valueSet.intValue(8038), valueSet.stringValue(8039));
            return null;
        }
        if (i == 8189) {
            onCancel();
            return null;
        }
        if (i != 8190) {
            return null;
        }
        onShow();
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onSelected(int i, String str) {
        IMediationDislikeCallback iMediationDislikeCallback = this.f3943ms;
        if (iMediationDislikeCallback != null) {
            iMediationDislikeCallback.onSelected(i, str);
        }
    }
}
