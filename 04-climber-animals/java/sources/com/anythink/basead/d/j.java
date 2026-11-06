package com.anythink.basead.d;

import com.anythink.core.common.h.x;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    public x a;
    public String b;
    public String c;
    public String d;
    public int e;
    public int f;
    public int g;
    public int h;
    public a i;
    public k j;
    public b k;
    public boolean l = false;
    public boolean m = false;
    public int n;
    public int o;
    public int p;
    public long q;
    public Map<String, Object> r;

    public j(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    public j(x xVar, String str) {
        if (xVar != null) {
            this.a = xVar;
            this.b = xVar.d;
            this.c = xVar.b;
        }
        this.d = str;
    }
}
