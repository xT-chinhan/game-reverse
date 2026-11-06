package com.smartdigimkt.a3;

import android.text.TextUtils;
import com.smartdigimkt.p3.e;
import com.smartdigimkt.p4.g;
import com.smartdigimkt.sdk.core.SDKContext;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Serializable {
    public transient e a;
    public String b;
    public int c;
    public int d;
    public int e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public int k;
    public String l;
    public int m;
    public String n;
    public long o;
    public String p;
    public int q;
    public int r;
    public com.smartdigimkt.b3.e s;
    public boolean t;
    public HashMap u;
    public boolean v;
    public boolean w;
    public double x;
    public int y;
    public transient com.smartdigimkt.h3.b z;

    public a() {
        SDKContext.getInstance().getClass();
        this.m = -1;
    }

    public static a a(String str, com.smartdigimkt.p4.e eVar, g gVar) {
        a aVar = new a();
        aVar.j = gVar.o;
        aVar.k = gVar.b;
        aVar.f = gVar.r;
        aVar.g = str;
        aVar.b = eVar.e;
        aVar.c = eVar.m;
        aVar.n = gVar.d;
        com.smartdigimkt.d3.c cVar = gVar.a;
        if (cVar != null) {
            cVar.F = str;
            long jCurrentTimeMillis = System.currentTimeMillis() + cVar.q;
            cVar.r = jCurrentTimeMillis;
            if (TextUtils.isEmpty(aVar.j)) {
                aVar.j = cVar.e;
            }
            aVar.i = cVar.Q;
            aVar.h = cVar.j;
            aVar.l = cVar.s;
            aVar.p = cVar.t;
            aVar.o = jCurrentTimeMillis;
        }
        aVar.q = eVar.t;
        aVar.r = eVar.u;
        aVar.x = gVar.z;
        aVar.y = gVar.J;
        return aVar;
    }
}
