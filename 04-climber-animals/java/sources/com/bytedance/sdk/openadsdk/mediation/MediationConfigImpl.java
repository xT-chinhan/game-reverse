package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MediationConfigImpl implements Bridge, IMediationConfig {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private IMediationConfig f3939ms;

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment() {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public MediationConfigImpl(IMediationConfig iMediationConfig) {
        this.f3939ms = iMediationConfig;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8460) {
            return (T) String.valueOf(getPublisherDid());
        }
        if (i == 8461) {
            return (T) Boolean.valueOf(isOpenAdnTest());
        }
        if (i == 8310) {
            return (T) ms();
        }
        if (i == 8462) {
            return (T) getLocalExtra();
        }
        if (i == 8458) {
            return (T) Boolean.valueOf(getHttps());
        }
        if (i == 8463) {
            return (T) getCustomLocalConfig();
        }
        if (i == 8464) {
            return (T) String.valueOf(getOpensdkVer());
        }
        if (i == 8465) {
            return (T) Boolean.valueOf(isWxInstalled());
        }
        if (i == 8466) {
            return (T) Boolean.valueOf(isSupportH265());
        }
        if (i == 8467) {
            return (T) Boolean.valueOf(isSupportSplashZoomout());
        }
        if (i == 8459) {
            return (T) String.valueOf(wxAppId());
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getPublisherDid() {
        IMediationConfig iMediationConfig = this.f3939ms;
        return iMediationConfig != null ? iMediationConfig.getPublisherDid() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isOpenAdnTest() {
        IMediationConfig iMediationConfig = this.f3939ms;
        if (iMediationConfig != null) {
            return iMediationConfig.isOpenAdnTest();
        }
        return false;
    }

    private Bridge ms() {
        if (this.f3939ms.getMediationConfigUserInfoForSegment() != null) {
            return new MediationUserInfoForSegmentImpl(this.f3939ms.getMediationConfigUserInfoForSegment());
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public Map<String, Object> getLocalExtra() {
        IMediationConfig iMediationConfig = this.f3939ms;
        if (iMediationConfig != null) {
            return iMediationConfig.getLocalExtra();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean getHttps() {
        IMediationConfig iMediationConfig = this.f3939ms;
        if (iMediationConfig != null) {
            return iMediationConfig.getHttps();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public JSONObject getCustomLocalConfig() {
        IMediationConfig iMediationConfig = this.f3939ms;
        if (iMediationConfig != null) {
            return iMediationConfig.getCustomLocalConfig();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getOpensdkVer() {
        IMediationConfig iMediationConfig = this.f3939ms;
        return iMediationConfig != null ? iMediationConfig.getOpensdkVer() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isWxInstalled() {
        IMediationConfig iMediationConfig = this.f3939ms;
        if (iMediationConfig != null) {
            return iMediationConfig.isWxInstalled();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportH265() {
        IMediationConfig iMediationConfig = this.f3939ms;
        if (iMediationConfig != null) {
            return iMediationConfig.isSupportH265();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportSplashZoomout() {
        IMediationConfig iMediationConfig = this.f3939ms;
        if (iMediationConfig != null) {
            return iMediationConfig.isSupportSplashZoomout();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String wxAppId() {
        IMediationConfig iMediationConfig = this.f3939ms;
        return iMediationConfig != null ? iMediationConfig.wxAppId() : "";
    }
}
