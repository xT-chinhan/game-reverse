package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class u6 extends p7 {
    public final /* synthetic */ v6 a;

    public u6(v6 v6Var) {
        this.a = v6Var;
    }

    @Override // com.mcto.sspsdk.internal.p7
    public final void a(int i, int i2) {
        this.a.f.a("media player error, what:" + i + ";ext:" + i2);
    }

    @Override // com.mcto.sspsdk.internal.p7
    public final void b() {
        v6 v6Var = this.a;
        v6Var.v.a(v6Var.w);
        vd vdVar = this.a.v.s;
        if (vdVar != null) {
            vdVar.j = true;
        }
    }

    @Override // com.mcto.sspsdk.internal.p7
    public final void c() {
        try {
            v6 v6Var = this.a;
            v6Var.j = true;
            v6Var.findViewById(R.id.qy_full_screen_ad_video_volume).setVisibility(0);
            v6 v6Var2 = this.a;
            if (v6Var2.i) {
                return;
            }
            v6Var2.findViewById(R.id.qy_full_screen_ad_title).setVisibility(4);
        } catch (Exception e) {
        }
    }

    @Override // com.mcto.sspsdk.internal.p7
    public final void a(p pVar) {
        this.a.f.d();
    }

    @Override // com.mcto.sspsdk.internal.p7
    public final void a(p pVar, long j, long j2) {
        m mVar = this.a.f;
        mVar.e = j2;
        l lVarA = l.a();
        p pVar2 = mVar.a;
        lVarA.getClass();
        l.b((int) j2, pVar2);
    }

    @Override // com.mcto.sspsdk.internal.p7
    public final void a(float f) {
        if (f > 0.0f) {
            v6 v6Var = this.a;
            if (v6Var.w) {
                v6Var.v.a(false);
                v6Var.x.setImageResource(R.drawable.qy_ic_volume_on_with_bg);
                v6Var.w = false;
                return;
            }
        }
        if (f <= 0.0f) {
            v6 v6Var2 = this.a;
            if (v6Var2.w) {
                return;
            }
            v6Var2.v.a(true);
            v6Var2.x.setImageResource(R.drawable.qy_ic_volume_off_with_bg);
            v6Var2.w = true;
        }
    }

    @Override // com.mcto.sspsdk.internal.p7
    public final void b(p pVar) {
        v6 v6Var = this.a;
        v6Var.v.a(v6Var.w);
        c();
        this.a.f.c();
    }
}
