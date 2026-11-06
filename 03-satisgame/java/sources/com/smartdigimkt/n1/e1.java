package com.smartdigimkt.n1;

import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.ui.BaseATActivity;
import com.smartdigimkt.sdk.basead.ui.BaseScreenATView;
import com.smartdigimkt.sdk.basead.ui.CloseImageView;
import com.smartdigimkt.sdk.basead.ui.CountDownView;
import com.smartdigimkt.sdk.basead.ui.MuteImageView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;
import com.smartdigimkt.sdk.basead.ui.web.WebProgressBarView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class e1 implements com.smartdigimkt.q1.k {
    public final /* synthetic */ BaseScreenATView a;

    public e1(BaseScreenATView baseScreenATView) {
        this.a = baseScreenATView;
    }

    @Override // com.smartdigimkt.q1.k
    public final void a() {
        BaseScreenATView baseScreenATView;
        com.smartdigimkt.i2.m mVar;
        com.smartdigimkt.j1.v vVar = this.a.t0;
        if (vVar != null) {
            vVar.d();
        }
        if (!this.a.q()) {
            this.a.z();
        }
        BaseScreenATView baseScreenATView2 = this.a;
        if (baseScreenATView2.b.s.D == 1) {
            baseScreenATView2.l = true;
            if (baseScreenATView2.V) {
                baseScreenATView2.F();
                return;
            } else {
                baseScreenATView2.K();
                return;
            }
        }
        if (baseScreenATView2.getCloseView() != null && (mVar = (baseScreenATView = this.a).s) != null) {
            CloseImageView closeView = baseScreenATView.getCloseView();
            mVar.a(closeView, closeView, 1);
        }
        this.a.c(2);
    }

    @Override // com.smartdigimkt.q1.k
    public final void a(int i) {
    }

    @Override // com.smartdigimkt.q1.k
    public final void b() {
    }

    @Override // com.smartdigimkt.q1.k
    public final void b(long j) {
        if (this.a.f) {
            return;
        }
        this.a.a(j);
        this.a.b(j);
        BaseScreenATView baseScreenATView = this.a;
        if (!baseScreenATView.v0) {
            baseScreenATView.d(0);
            BaseScreenATView baseScreenATView2 = this.a;
            MuteImageView muteImageView = baseScreenATView2.n0;
            if (muteImageView != null && muteImageView.getVisibility() != 0) {
                baseScreenATView2.n0.setVisibility(0);
            }
            this.a.v0 = true;
        }
        BaseScreenATView baseScreenATView3 = this.a;
        int i = baseScreenATView3.J;
        if (i >= 0 && j >= i) {
            baseScreenATView3.J();
        }
        BaseScreenATView baseScreenATView4 = this.a;
        if (j < baseScreenATView4.T || baseScreenATView4.p()) {
            return;
        }
        this.a.z();
    }

    @Override // com.smartdigimkt.q1.k
    public final void c() {
    }

    @Override // com.smartdigimkt.q1.k
    public final void d() {
    }

    @Override // com.smartdigimkt.q1.k
    public final void e() {
    }

    @Override // com.smartdigimkt.q1.k
    public final void f() {
        if (this.a.o != null) {
            HashMap map = new HashMap();
            BasePlayerView basePlayerView = this.a.n.h;
            map.put("video_length", Long.valueOf(basePlayerView != null ? basePlayerView.getVideoLength() : 0L));
            this.a.o.a(map);
        }
        this.a.N();
        this.a.m();
        com.smartdigimkt.j1.v vVar = this.a.t0;
        if (vVar != null) {
            vVar.e();
        }
    }

    @Override // com.smartdigimkt.q1.k
    public final void g() {
        BaseScreenATView baseScreenATView = this.a;
        com.smartdigimkt.u1.d dVar = baseScreenATView.n;
        if (dVar != null) {
            long jA = dVar.a();
            if (baseScreenATView.N && baseScreenATView.K == -1) {
                long j = baseScreenATView.L;
                if (j != 0) {
                    baseScreenATView.K = jA;
                    if (j > 0) {
                        baseScreenATView.M = jA + j;
                    }
                    baseScreenATView.L();
                }
            }
        }
        BaseScreenATView baseScreenATView2 = this.a;
        com.smartdigimkt.b3.e eVar = baseScreenATView2.b.s;
        if ((eVar == null || eVar.b != 1) && !baseScreenATView2.y()) {
            return;
        }
        this.a.a(1, 3);
    }

    @Override // com.smartdigimkt.q1.k
    public final void a(com.smartdigimkt.h0.g gVar) {
        BaseScreenATView baseScreenATView = this.a;
        baseScreenATView.l = true;
        com.smartdigimkt.j1.v vVar = baseScreenATView.t0;
        if (vVar != null) {
            d0 d0Var = (d0) vVar;
            if (TextUtils.equals(d0Var.d, "1")) {
                d0Var.d = "3";
                BaseATActivity baseATActivity = d0Var.e;
                baseATActivity.a("6-".concat(baseATActivity.y - baseATActivity.z <= 0 ? "2" : "1"), 0L);
            }
        }
        com.smartdigimkt.j1.v vVar2 = this.a.t0;
        if (vVar2 != null) {
            vVar2.a(gVar);
        }
        BaseScreenATView baseScreenATView2 = this.a;
        if (baseScreenATView2.b.s.y == 1) {
            baseScreenATView2.z();
        }
        com.smartdigimkt.u1.e eVar = this.a.r0;
        if (eVar != null) {
            CountDownView countDownView = eVar.b;
            if (countDownView != null) {
                countDownView.refreshToEnd();
            }
            WebProgressBarView webProgressBarView = eVar.c;
            if (webProgressBarView != null) {
                webProgressBarView.setProgress(100);
            }
        }
        BaseScreenATView baseScreenATView3 = this.a;
        if (!baseScreenATView3.V) {
            baseScreenATView3.m();
            this.a.K();
        } else {
            baseScreenATView3.F();
        }
    }

    @Override // com.smartdigimkt.q1.k
    public final void a(long j) {
        BaseScreenATView baseScreenATView = this.a;
        baseScreenATView.S = j;
        com.smartdigimkt.j1.v vVar = baseScreenATView.t0;
        if (vVar != null) {
            d0 d0Var = (d0) vVar;
            if (TextUtils.equals(d0Var.d, "1")) {
                d0Var.d = "2";
            }
            BaseATActivity baseATActivity = d0Var.e;
            baseATActivity.a("5-".concat(baseATActivity.y - baseATActivity.z <= 0 ? "2" : "1"), 0L);
        }
        this.a.setCountDownDuration(j);
    }
}
