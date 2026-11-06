package com.varbto.utils.crash;

import com.varbto.internal.g;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CrashReport {
    public final String a;
    public final g b;
    public final int c;
    public final String d;
    public final String e;
    public final Map f;

    public CrashReport(String str, g gVar, int i, String str2, String str3, Map<String, String> map) {
        this.a = str;
        this.b = gVar;
        this.c = i;
        this.d = str2;
        this.e = str3;
        this.f = map;
    }

    public g getCategory() {
        return this.b;
    }

    public int getConfidence() {
        return this.c;
    }

    public String getErrorId() {
        return this.a;
    }

    public String getMatchedPackage() {
        return this.d;
    }

    public String getMatchedType() {
        return this.e;
    }

    public Map<String, String> getMetadata() {
        return this.f;
    }
}
