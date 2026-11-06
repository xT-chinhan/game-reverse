package com.anythink.basead.f.b.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.anythink.basead.d.j;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.a.f;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements com.anythink.basead.f.a {
    protected int A;
    protected int B;
    JSONArray C;
    protected long D;
    private final String a = "d";
    protected Context r;
    bj s;
    x t;
    protected boolean u;
    protected com.anythink.basead.g.a v;
    protected com.anythink.basead.ui.a.InterfaceC0052a w;
    boolean x;
    String y;
    protected int z;

    @Override // com.anythink.basead.f.a
    public View B() {
        return null;
    }

    @Override // com.anythink.basead.f.a
    public long C() {
        return 0L;
    }

    protected abstract View H();

    @Override // com.anythink.basead.f.a
    public void b(boolean z) {
    }

    @Override // com.anythink.basead.f.a
    public void q() {
    }

    @Override // com.anythink.basead.f.a
    public void u() {
    }

    @Override // com.anythink.basead.f.a
    public void v() {
    }

    public d(Context context, bj bjVar, x xVar, boolean z) {
        this.z = 1;
        this.r = context.getApplicationContext();
        this.s = bjVar;
        this.t = xVar;
        this.u = z;
        this.z = com.anythink.basead.b.e.a(bjVar, xVar) ? 1 : 2;
    }

    @Override // com.anythink.basead.f.a
    public void a(int i, int i2) {
        this.A = i;
        this.B = i2;
    }

    @Override // com.anythink.basead.f.a
    public final void a(JSONArray jSONArray) {
        this.C = jSONArray;
    }

    @Override // com.anythink.basead.f.a
    public final w a() {
        return this.s;
    }

    @Override // com.anythink.basead.f.a
    public String c() {
        bj bjVar = this.s;
        return bjVar != null ? bjVar.x() : "";
    }

    @Override // com.anythink.basead.f.a
    public String d() {
        bj bjVar = this.s;
        return bjVar != null ? bjVar.y() : "";
    }

    @Override // com.anythink.basead.f.a
    public String e() {
        bj bjVar = this.s;
        return bjVar != null ? bjVar.D() : "";
    }

    @Override // com.anythink.basead.f.a
    public String f() {
        bj bjVar = this.s;
        return bjVar != null ? bjVar.z() : "";
    }

    @Override // com.anythink.basead.f.a
    public String g() {
        bj bjVar = this.s;
        return bjVar != null ? bjVar.B() : "";
    }

    @Override // com.anythink.basead.f.a
    public String h() {
        bj bjVar = this.s;
        return bjVar != null ? bjVar.C() : "";
    }

    @Override // com.anythink.basead.f.a
    public String i() {
        bj bjVar = this.s;
        return bjVar != null ? bjVar.aK() : "";
    }

    @Override // com.anythink.basead.f.a
    public String j() {
        bj bjVar = this.s;
        return bjVar != null ? bjVar.M() : "";
    }

    @Override // com.anythink.basead.f.a
    public String k() {
        bj bjVar = this.s;
        return bjVar != null ? bjVar.P() : "";
    }

    @Override // com.anythink.basead.f.a
    public String l() {
        bj bjVar = this.s;
        return bjVar != null ? bjVar.O() : "";
    }

    @Override // com.anythink.basead.f.a
    public String m() {
        bj bjVar = this.s;
        return bjVar != null ? bjVar.N() : "";
    }

    @Override // com.anythink.basead.f.a
    public String n() {
        bj bjVar = this.s;
        return bjVar != null ? bjVar.h() : "";
    }

    @Override // com.anythink.basead.f.a
    public boolean o() {
        bj bjVar = this.s;
        if (bjVar != null) {
            return (TextUtils.isEmpty(bjVar.M()) && TextUtils.isEmpty(this.s.aK()) && TextUtils.isEmpty(this.s.P()) && TextUtils.isEmpty(this.s.O()) && TextUtils.isEmpty(this.s.h()) && TextUtils.isEmpty(this.s.N())) ? false : true;
        }
        return false;
    }

    @Override // com.anythink.basead.f.a
    public boolean p() {
        return this.u;
    }

    @Override // com.anythink.basead.f.a
    public void a(com.anythink.basead.g.a aVar) {
        this.v = aVar;
    }

    @Override // com.anythink.basead.f.a
    public void a(boolean z) {
        this.x = z;
    }

    @Override // com.anythink.basead.f.a
    public void a(String str) {
        this.y = str;
    }

    @Override // com.anythink.basead.f.a
    public void r() {
        q();
        this.v = null;
    }

    @Override // com.anythink.basead.f.a
    public final boolean a(boolean z, boolean z2) {
        if (this.s.t() != 67) {
            return false;
        }
        return this.s.a(z, z2);
    }

    @Override // com.anythink.basead.f.a
    public void s() {
        u();
    }

    @Override // com.anythink.basead.f.a
    public void t() {
        v();
    }

    @Override // com.anythink.basead.f.a
    public final int w() {
        return this.z;
    }

    @Override // com.anythink.basead.f.a
    public int x() {
        bj bjVar = this.s;
        if (bjVar != null) {
            return bjVar.ab();
        }
        return 0;
    }

    @Override // com.anythink.basead.f.a
    public int y() {
        bj bjVar = this.s;
        if (bjVar != null) {
            return bjVar.ac();
        }
        return 0;
    }

    @Override // com.anythink.basead.f.a
    public int z() {
        bj bjVar = this.s;
        if (bjVar != null) {
            return bjVar.K();
        }
        return 0;
    }

    @Override // com.anythink.basead.f.a
    public int A() {
        bj bjVar;
        if (this.u || (bjVar = this.s) == null) {
            return 0;
        }
        return bjVar.aa();
    }

    @Override // com.anythink.basead.f.a
    public final void a(com.anythink.basead.ui.a.InterfaceC0052a interfaceC0052a) {
        this.w = interfaceC0052a;
    }

    @Override // com.anythink.basead.f.a
    public int D() {
        bj bjVar = this.s;
        if (bjVar != null) {
            return bjVar.V();
        }
        return 0;
    }

    @Override // com.anythink.basead.f.a
    public int E() {
        bj bjVar = this.s;
        if (bjVar != null) {
            return bjVar.W();
        }
        return 0;
    }

    @Override // com.anythink.basead.f.a
    public long F() {
        bj bjVar = this.s;
        if (bjVar != null) {
            return bjVar.X();
        }
        return 0L;
    }

    final j M() {
        j jVar = new j(this.t, "");
        View viewH = H();
        if (viewH != null) {
            jVar.g = viewH.getWidth();
            jVar.h = viewH.getHeight();
            try {
                int[] iArr = new int[2];
                viewH.getLocationOnScreen(iArr);
                jVar.n = iArr[0];
                jVar.o = iArr[1];
            } catch (Throwable unused) {
            }
            jVar.p = f.b.a(viewH);
            long j = this.D;
            if (j > 0) {
                jVar.q = j;
            }
        }
        return jVar;
    }
}
