package com.anythink.core.common.inner.b;

import com.anythink.core.common.h.x;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public x a;
    public String b;
    public String c;
    public String d;
    public int e;
    public int f;
    public int g;
    public int h;
    public Map<String, Object> i;

    private d(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    private d(x xVar, String str) {
        if (xVar != null) {
            this.a = xVar;
            this.b = xVar.f;
            this.c = xVar.a;
        }
        this.d = str;
    }
}
