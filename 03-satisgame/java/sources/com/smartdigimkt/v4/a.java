package com.smartdigimkt.v4;

import android.content.Context;
import com.smartdigimkt.b3.k;
import com.smartdigimkt.o4.n;
import com.smartdigimkt.p4.e;
import com.smartdigimkt.p4.g;
import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.t4.p;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public boolean B;
    public e D;
    public AdError E;
    public volatile n F;
    public final Context a;
    public final SDMAdRequest b;
    public final int c;
    public final p d;
    public final String e;
    public String g;
    public boolean h;
    public com.smartdigimkt.w4.a i;
    public k j;
    public com.smartdigimkt.m3.b l;
    public e n;
    public g o;
    public com.smartdigimkt.a3.a p;
    public com.smartdigimkt.e1.e q;
    public com.smartdigimkt.d3.c r;
    public JSONObject s;
    public com.smartdigimkt.z3.a t;
    public d u;
    public com.smartdigimkt.f3.a v;
    public final int w;
    public com.smartdigimkt.h3.b x;
    public boolean y;
    public boolean z;
    public final AtomicBoolean f = new AtomicBoolean(false);
    public int k = -1;
    public int m = 0;
    public int A = 1;
    public final AtomicBoolean C = new AtomicBoolean(false);

    public a(Context context, String str, int i, int i2, SDMAdRequest sDMAdRequest, p pVar) {
        this.a = context.getApplicationContext();
        this.b = sDMAdRequest;
        this.w = i2;
        this.d = pVar;
        this.e = str;
        this.c = i;
    }

    public final void a(com.smartdigimkt.z3.a aVar) {
        this.t = aVar;
        aVar.a = this.v;
    }

    public final boolean a() {
        int i = this.m;
        return i == 1 || i == 2;
    }

    public final void a(int i) {
        this.m = i;
        com.smartdigimkt.h3.b bVar = this.x;
        if (bVar != null) {
            synchronized (bVar) {
                bVar.b.get();
            }
        }
    }

    public final void a(long j) {
        com.smartdigimkt.w4.a aVar = this.i;
        if (aVar != null) {
            aVar.f = j;
        }
    }

    public final synchronized void a(e eVar, AdError adError) {
        this.D = eVar;
        this.E = adError;
        this.C.set(true);
        n nVar = this.F;
        this.F = null;
        if (nVar != null) {
            if (eVar != null) {
                nVar.b(eVar);
            } else {
                nVar.a(adError);
            }
        }
    }

    public final void a(com.smartdigimkt.h3.b bVar) {
        this.x = bVar;
        if (bVar != null) {
            synchronized (bVar) {
                bVar.b.get();
            }
        }
        com.smartdigimkt.a3.a aVar = this.p;
        if (aVar != null) {
            aVar.z = bVar;
        }
    }
}
