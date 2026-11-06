package com.varbto.utils.anr;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ProcessedError {
    public final String a;
    public final String b;
    public final Map c;

    public ProcessedError(String str, String str2, Map<String, String> map) {
        this.a = str;
        this.b = str2;
        this.c = map;
    }

    public String getCategory() {
        return this.b;
    }

    public String getErrorId() {
        return this.a;
    }

    public Map<String, String> getMetadata() {
        return this.c;
    }
}
