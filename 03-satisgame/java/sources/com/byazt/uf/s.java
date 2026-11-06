package com.byazt.uf;

/* JADX INFO: loaded from: classes2.dex */
public enum s {
    JSON(".json"),
    ZIP(".zip");

    public final String s;

    s(String str) {
        this.s = str;
    }

    public String n() {
        return ".temp" + this.s;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.s;
    }
}
