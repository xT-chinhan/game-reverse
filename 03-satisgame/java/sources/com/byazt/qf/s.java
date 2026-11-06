package com.byazt.qf;

/* JADX INFO: loaded from: classes2.dex */
public enum s {
    LAUNCH("launch"),
    JAVA("java"),
    NATIVE("native"),
    ANR("anr"),
    BLOCK("block"),
    ENSURE("ensure"),
    DART("dart"),
    CUSTOM_JAVA("custom_java"),
    ALL("all");

    public String tj;

    s(String str) {
        this.tj = str;
    }

    public String n() {
        return this.tj;
    }
}
