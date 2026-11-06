package com.bytedance.sdk.openadsdk;

import com.byazt.vzx.pr;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 1615})
public abstract class TTCustomController {
    public boolean isCanUseLocation() {
        return true;
    }

    public LocationProvider getTTLocation() {
        return null;
    }

    public boolean alist() {
        return true;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }

    public String getDevImei() {
        return null;
    }

    public boolean isCanUseWifiState() {
        return true;
    }

    public String getMacAddress() {
        return null;
    }

    public boolean isCanUseWriteExternal() {
        return true;
    }

    public String getDevOaid() {
        return null;
    }

    public boolean isCanUseAndroidId() {
        return true;
    }

    public IMediationPrivacyConfig getMediationPrivacyConfig() {
        return null;
    }

    public String getAndroidId() {
        return null;
    }

    public boolean isCanUsePermissionRecordAudio() {
        return true;
    }

    public Map<String, Object> userPrivacyConfig() {
        return null;
    }

    public boolean isCanUseMessage() {
        return true;
    }
}
