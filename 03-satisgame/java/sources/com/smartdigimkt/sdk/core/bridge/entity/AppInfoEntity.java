package com.smartdigimkt.sdk.core.bridge.entity;

import com.smartdigimkt.f.i;

/* JADX INFO: loaded from: classes3.dex */
public class AppInfoEntity extends BaseInfoEntity {

    @DataField("med_app_id")
    private String mediationAppId;

    @DataField("med_app_key")
    private String mediationAppKey;

    @DataField("med_plat")
    private int mediationPlatform;

    @DataField("med_version")
    private String mediationVersion;

    public String getMediationAppId() {
        return this.mediationAppId;
    }

    public String getMediationAppKey() {
        return this.mediationAppKey;
    }

    public int getMediationPlatform() {
        return this.mediationPlatform;
    }

    public String getMediationVersion() {
        return this.mediationVersion;
    }

    public void setMediationAppId(String str) {
        this.mediationAppId = str;
    }

    public void setMediationAppKey(String str) {
        this.mediationAppKey = str;
    }

    public void setMediationPlatform(int i) {
        this.mediationPlatform = i;
    }

    public void setMediationVersion(String str) {
        this.mediationVersion = str;
    }

    public String toString() {
        return i.a(new StringBuilder("AppInfoEntity{mediationPlatform=").append(this.mediationPlatform).append(", mediationVersion='").append(this.mediationVersion).append("', mediationAppId='").append(this.mediationAppId).append("', mediationAppKey='"), this.mediationAppKey, "'}");
    }
}
