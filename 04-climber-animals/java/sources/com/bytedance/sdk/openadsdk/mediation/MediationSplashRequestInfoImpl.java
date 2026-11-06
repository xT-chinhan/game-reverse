package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;

/* JADX INFO: loaded from: classes2.dex */
public class MediationSplashRequestInfoImpl implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private IMediationSplashRequestInfo f3948ms;

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public MediationSplashRequestInfoImpl(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        this.f3948ms = iMediationSplashRequestInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        IMediationSplashRequestInfo iMediationSplashRequestInfo;
        if (i == 8530) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo2 = this.f3948ms;
            if (iMediationSplashRequestInfo2 != null) {
                return (T) iMediationSplashRequestInfo2.getAdnName();
            }
            return null;
        }
        if (i == 8532) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo3 = this.f3948ms;
            if (iMediationSplashRequestInfo3 != null) {
                return (T) iMediationSplashRequestInfo3.getAppId();
            }
            return null;
        }
        if (i == 8533) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo4 = this.f3948ms;
            if (iMediationSplashRequestInfo4 != null) {
                return (T) iMediationSplashRequestInfo4.getAppkey();
            }
            return null;
        }
        if (i != 8531 || (iMediationSplashRequestInfo = this.f3948ms) == null) {
            return null;
        }
        return (T) iMediationSplashRequestInfo.getAdnSlotId();
    }
}
