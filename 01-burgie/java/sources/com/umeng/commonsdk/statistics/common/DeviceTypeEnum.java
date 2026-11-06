package com.umeng.commonsdk.statistics.common;

import com.taptap.sdk.db.constant.Common;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public enum DeviceTypeEnum {
    IMEI("imei", "imei"),
    OAID("oaid", "oaid"),
    ANDROIDID(Common.Predefined.SUB_ANDROID_ID, Common.Predefined.SUB_ANDROID_ID),
    MAC("mac", "mac"),
    SERIALNO("serial_no", "serial_no"),
    IDFA("idfa", "idfa"),
    DEFAULT(AbstractJsonLexerKt.NULL, AbstractJsonLexerKt.NULL);

    private String description;
    private String deviceIdType;

    DeviceTypeEnum(String str, String str2) {
        this.deviceIdType = str;
        this.description = str2;
    }

    public String getDeviceIdType() {
        return this.deviceIdType;
    }

    public String getDescription() {
        return this.description;
    }
}
