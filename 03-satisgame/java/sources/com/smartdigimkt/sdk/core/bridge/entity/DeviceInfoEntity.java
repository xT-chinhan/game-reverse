package com.smartdigimkt.sdk.core.bridge.entity;

import com.smartdigimkt.f.i;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceInfoEntity extends BaseInfoEntity {

    @DataField("a_id")
    private String androidId;

    @DataField("i_mei")
    private String imei;

    @DataField("im_si")
    private String imsi;

    @DataField("ip_v4")
    private String ipV4;

    @DataField("ip_v6")
    private String ipV6;

    @DataField("m_ac")
    private String mac;

    @DataField("oa_id")
    private String oaid;

    @DataField("ss_id")
    private String ssid;

    @DataField("up_id")
    private String upId;

    @DataField("ua")
    private String userAgent;

    public String getAndroidId() {
        return this.androidId;
    }

    public String getImei() {
        return this.imei;
    }

    public String getImsi() {
        return this.imsi;
    }

    public String getIpV4() {
        return this.ipV4;
    }

    public String getIpV6() {
        return this.ipV6;
    }

    public String getMac() {
        return this.mac;
    }

    public String getOaid() {
        return this.oaid;
    }

    public String getSsid() {
        return this.ssid;
    }

    public String getUpId() {
        return this.upId;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setImsi(String str) {
        this.imsi = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    public String toString() {
        return i.a(new StringBuilder("DeviceInfoEntity{upId='").append(this.upId).append("', oaid='").append(this.oaid).append("', androidId='").append(this.androidId).append("', imei='").append(this.imei).append("', imsi='").append(this.imsi).append("', mac='").append(this.mac).append("', ssid='").append(this.ssid).append("', userAgent='").append(this.userAgent).append("', ipV4='").append(this.ipV4).append("', ipV6='"), this.ipV6, "'}");
    }
}
