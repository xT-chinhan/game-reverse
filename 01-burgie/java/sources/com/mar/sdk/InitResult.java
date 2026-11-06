package com.mar.sdk;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class InitResult {
    private String advertId;
    private boolean customSwitch;
    private boolean disableRealName;
    private String ip;
    private boolean rebootSkipLoginSwitch;
    private long time;

    public InitResult(long time, String advertId, String ip, boolean disableRealName, boolean rebootSkipLoginSwitch, boolean customSwitch) {
        this.time = 0L;
        this.advertId = "";
        this.ip = "";
        this.disableRealName = false;
        this.rebootSkipLoginSwitch = false;
        this.customSwitch = false;
        this.advertId = advertId;
        this.disableRealName = disableRealName;
        this.rebootSkipLoginSwitch = rebootSkipLoginSwitch;
        this.ip = ip;
        this.time = time;
        this.customSwitch = customSwitch;
    }

    public long getTime() {
        return this.time;
    }

    public String getAdvertId() {
        return this.advertId;
    }

    public String getIp() {
        return this.ip;
    }

    public boolean isDisableRealName() {
        return this.disableRealName;
    }

    public boolean isRebootSkipLoginSwitch() {
        return this.rebootSkipLoginSwitch;
    }

    public boolean isCustomSwitch() {
        return this.customSwitch;
    }

    public String toString() {
        return "InitResult{time=" + this.time + ", advertId='" + this.advertId + "', ip='" + this.ip + "', disableRealName=" + this.disableRealName + ", rebootSkipLoginSwitch=" + this.rebootSkipLoginSwitch + AbstractJsonLexerKt.END_OBJ;
    }
}
