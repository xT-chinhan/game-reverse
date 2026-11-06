package com.bytedance.ms.xr;

import com.tapsdk.tapad.constants.Constants;

/* JADX INFO: loaded from: classes2.dex */
public enum ah {
    LAUNCH("launch"),
    JAVA("java"),
    NATIVE("native"),
    ANR("anr"),
    BLOCK("block"),
    ENSURE("ensure"),
    DART("dart"),
    CUSTOM_JAVA("custom_java"),
    ALL(Constants.e.c);

    private String ch;

    ah(String str) {
        this.ch = str;
    }

    public String ms() {
        return this.ch;
    }
}
