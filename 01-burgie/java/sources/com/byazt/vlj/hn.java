package com.byazt.vlj;

import com.uc.crashsdk.export.LogType;

/* JADX INFO: loaded from: classes2.dex */
public enum hn {
    LAUNCH("launch"),
    JAVA(LogType.JAVA_TYPE),
    NATIVE("native"),
    ANR(LogType.ANR_TYPE),
    BLOCK("block"),
    ENSURE("ensure"),
    DART("dart"),
    CUSTOM_JAVA("custom_java"),
    ALL("all");

    public String vk;

    hn(String str) {
        this.vk = str;
    }

    public String pr() {
        return this.vk;
    }
}
