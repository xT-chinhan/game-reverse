package com.smartdigimkt.k1;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.smartdigimkt.j1.w;
import com.smartdigimkt.z.a0;
import com.smartdigimkt.z.c0;
import com.smartdigimkt.z.s;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends d implements com.smartdigimkt.p3.d {
    public com.smartdigimkt.j1.a i;
    public boolean j;
    public a0 k;
    public View l;
    public volatile boolean m;
    public View n;
    public final g o;
    public final h p;
    public k q;

    public l(Context context, com.smartdigimkt.a3.a aVar, String str, boolean z) {
        super(context, aVar, str, z);
        this.o = new g(this);
        this.p = new h(this);
    }

    public final void a(int i, int i2, boolean z) {
        this.j = true;
        try {
            f();
            this.j = false;
            if (this.k == null) {
                this.k = new a0(this.a, this.b, this.e, this.l);
            }
            com.smartdigimkt.a0.e eVar = this.k.g;
            if (eVar == null || !eVar.e.get()) {
                a0 a0Var = this.k;
                i iVar = new i(this, i, i2);
                com.smartdigimkt.a0.e eVar2 = a0Var.g;
                if (eVar2 != null) {
                    eVar2.a = iVar;
                }
                com.smartdigimkt.h0.m mVar = new com.smartdigimkt.h0.m(this.b, "");
                if (z) {
                    mVar.k = true;
                }
                a0Var.a(mVar);
                k kVar = this.q;
                if (kVar != null) {
                    kVar.a(113);
                }
            }
        } catch (Throwable th) {
            this.j = false;
            throw th;
        }
    }

    @Override // com.smartdigimkt.k1.d
    public final void c() {
        super.c();
        com.smartdigimkt.p3.e eVar = this.b.a;
        if (eVar != null) {
            eVar.c();
        }
        k kVar = this.q;
        if (kVar != null) {
            kVar.a(112);
        }
        this.i = null;
        a0 a0Var = this.k;
        if (a0Var != null) {
            a0Var.a();
            this.k = null;
        }
        this.l = null;
        this.n = null;
        this.q = null;
    }

    public final void f() {
        com.smartdigimkt.p3.e eVar;
        if (this.m || (eVar = this.b.a) == null || !eVar.a(this.j)) {
            return;
        }
        k kVar = this.q;
        if (kVar != null) {
            kVar.a(114);
        }
        this.m = true;
        com.smartdigimkt.l1.e eVarA = com.smartdigimkt.l1.e.a(this.a);
        com.smartdigimkt.e3.a aVar = this.e;
        eVarA.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = ((SimpleDateFormat) com.smartdigimkt.l1.e.d.get()).format(new Date(jCurrentTimeMillis));
        com.smartdigimkt.h0.c cVarA = eVarA.a(aVar);
        if (cVarA.f.equals(str)) {
            cVarA.d++;
        } else {
            cVarA.d = 1;
            cVarA.f = str;
        }
        cVarA.e = jCurrentTimeMillis;
        com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.l1.d(eVarA, cVarA));
        this.b.a.f();
        com.smartdigimkt.j1.a aVar2 = this.i;
        if (aVar2 != null) {
            aVar2.onAdShow(new w());
        }
    }

    @Override // com.smartdigimkt.p3.d
    public final int impressionMaterialType() {
        return c0.a(this.e, this.b);
    }

    @Override // com.smartdigimkt.p3.d
    public final void onImpressionExpired() {
        this.m = true;
    }

    @Override // com.smartdigimkt.p3.d
    public final void sendMediaImpression() {
        f();
    }

    @Override // com.smartdigimkt.p3.d
    public final void sendUpstreamImpression() {
        s.a(8, this.e, new com.smartdigimkt.h0.m(this.b, ""));
    }

    public final void a(View view, View[] viewArr) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), viewArr);
            }
            return;
        }
        if ((view instanceof Button) || (view instanceof TextView)) {
            String string = ((TextView) view).getText().toString();
            if (TextUtils.isEmpty(string)) {
                return;
            }
            com.smartdigimkt.e3.a aVar = this.e;
            if (TextUtils.equals(string, aVar != null ? aVar.h : "")) {
                viewArr[0] = view;
            }
        }
    }

    public static void a(View view, g gVar) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), gVar);
            }
            return;
        }
        view.setOnClickListener(gVar);
    }
}
