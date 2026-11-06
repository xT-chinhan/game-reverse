package com.byazt.bny;

/* JADX INFO: loaded from: classes.dex */
public enum hn {
    JSON(".json"),
    ZIP(".zip");

    public final String hn;

    hn(String str) {
        this.hn = str;
    }

    public String pr() {
        return ".temp" + this.hn;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.hn;
    }
}
