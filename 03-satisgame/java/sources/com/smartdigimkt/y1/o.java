package com.smartdigimkt.y1;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public final Context a;
    public final com.smartdigimkt.b3.c b;
    public final com.smartdigimkt.a3.a c;
    public final RelativeLayout d;
    public final int e;
    public final View f;
    public e0 h;
    public final com.smartdigimkt.b2.e i;
    public Map j;
    public final n k = new n(this);
    public final ConcurrentLinkedQueue g = new ConcurrentLinkedQueue();

    /* JADX WARN: Code duplicated, block: B:15:0x0069  */
    public o(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, int i, RelativeLayout relativeLayout, View view, com.smartdigimkt.b2.e eVar) {
        this.a = context;
        this.b = cVar;
        this.c = aVar;
        this.e = i;
        this.d = relativeLayout;
        this.f = view;
        this.i = eVar;
        com.smartdigimkt.b3.e eVar2 = aVar.s;
        int iY = i == 3 ? eVar2.m : com.smartdigimkt.r4.h.y(context);
        long j = eVar2.o0;
        String str = eVar2.p0;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                int i2 = 0;
                while (i2 < jSONArray.length()) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                    int iOptInt = jSONObjectOptJSONObject.optInt("cgf_type", -1);
                    if (!a(iOptInt, iY)) {
                        long jOptLong = jSONObjectOptJSONObject.optLong("cgf_st", -1L);
                        if (iOptInt > 0 && jOptLong >= 0) {
                            this.g.add(new e0(this.a, this.b, this.c, this.e, new d0(i2 + 1, iOptInt, j, jOptLong, eVar2.q0, iY), this.d, this.f, this.i, this.k));
                        }
                    }
                    i2++;
                    eVar2 = eVar2;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void a() {
        e0 e0Var = this.h;
        if (e0Var != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = e0Var.s;
            e0Var.t = jCurrentTimeMillis - j;
            if (j > 0) {
                com.smartdigimkt.a3.a aVar = e0Var.c;
                com.smartdigimkt.b3.c cVar = e0Var.b;
                boolean zH = com.smartdigimkt.z.c0.h(cVar, aVar);
                int i = e0Var.r;
                int i2 = e0Var.g;
                long j2 = e0Var.s;
                long j3 = e0Var.t;
                if (aVar != null && cVar != null) {
                    com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(null, null);
                    cVar2.a = "1004699";
                    cVar2.a(aVar);
                    cVar2.l = zH ? "2" : "1";
                    cVar2.m = String.valueOf(i);
                    cVar2.n = String.valueOf(j2);
                    cVar2.o = String.valueOf(j3);
                    cVar2.p = String.valueOf(aVar.c);
                    cVar2.q = String.valueOf(i2);
                    if (cVar instanceof com.smartdigimkt.b3.b) {
                        com.smartdigimkt.b3.b bVar = (com.smartdigimkt.b3.b) cVar;
                        cVar2.r = String.valueOf(bVar.c0);
                        cVar2.s = String.valueOf(bVar.a);
                    }
                    com.smartdigimkt.n3.k.a(cVar2);
                }
            }
            com.smartdigimkt.q3.f.a().b.removeCallbacks(e0Var.p);
            BaseG2CV2View baseG2CV2View = e0Var.i;
            if (baseG2CV2View != null) {
                baseG2CV2View.release();
                com.smartdigimkt.o3.d.a(e0Var.i);
            }
            View view = e0Var.e;
            if (view != null) {
                view.setBackgroundColor(Color.parseColor("#80000000"));
                e0Var.e.setVisibility(8);
            }
            this.h = null;
        }
    }

    public final void b() {
        e0 e0Var = this.h;
        if (e0Var == null) {
            c();
            return;
        }
        if (e0Var.q) {
            return;
        }
        e0Var.q = true;
        e0Var.j = SystemClock.elapsedRealtime();
        com.smartdigimkt.q3.f.a().a(e0Var.k, e0Var.p);
    }

    public final void c() {
        a();
        if (this.g.size() > 0) {
            this.h = (e0) this.g.poll();
            b();
        }
    }

    public final boolean a(int i, int i2) {
        switch (i) {
            case 1:
            case 6:
            case 7:
            case 11:
            case 12:
                return i == 6 && !com.smartdigimkt.m1.d.a().c(com.anythink.core.common.a.b.d.i);
            case 2:
                if (com.smartdigimkt.z.c0.h(this.b, this.c)) {
                    return true;
                }
                int i3 = this.e;
                return (i3 == 1 || i3 == 3) ? false : true;
            case 3:
                int i4 = this.e;
                return (i4 == 1 || i4 == 3) ? false : true;
            case 4:
            case 5:
                int i5 = this.e;
                return !(i5 == 1 || i5 == 2 || i5 == 3) || this.f == null;
            case 8:
            case 9:
            case 10:
                boolean z = (this.c.c == 1 && i2 == 1) ? false : true;
                if (z) {
                    return z;
                }
                if (i == 9 && !com.smartdigimkt.m1.d.a().c(com.anythink.core.common.a.b.d.f)) {
                    z = true;
                }
                if ((i == 8 || i == 10) && !com.smartdigimkt.m1.d.a().c(com.anythink.core.common.a.b.d.k)) {
                    z = true;
                }
                if (i == 10 && !com.smartdigimkt.m1.d.a().c(com.anythink.core.common.a.b.d.l)) {
                    z = true;
                }
                if (i != 8 || com.smartdigimkt.m1.d.a().c(com.anythink.core.common.a.b.d.m)) {
                    return z;
                }
                return true;
            case 13:
                int i6 = this.c.c;
                return ((i6 == 4 || i6 == 3) && i2 == 1) ? false : true;
            default:
                return true;
        }
    }
}
