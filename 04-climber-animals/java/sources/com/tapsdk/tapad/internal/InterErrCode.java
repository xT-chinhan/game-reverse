package com.tapsdk.tapad.internal;

/* JADX INFO: loaded from: classes3.dex */
public enum InterErrCode {
    COMMON_INIT_ERROR(5001, "激励广告无视频素材，或视频已过期"),
    COMMON_NO_AD_ERROR(5002, "广告素材不存在");

    private final int code;
    private final String desc;

    InterErrCode(int i, String str) {
        this.code = i;
        this.desc = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ErrorCode:{code='" + this.code + "', desc='" + this.desc + "'}";
    }
}
