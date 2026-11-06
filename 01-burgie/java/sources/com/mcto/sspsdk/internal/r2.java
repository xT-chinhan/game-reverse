package com.mcto.sspsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.mcto.sspsdk.IQyBanner;
import com.mcto.sspsdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class r2 extends y2 {
    public pa H;
    public j2 I;
    public q2 J;
    public x1 K;
    public IQyBanner.IAdInteractionListener L;

    public r2(Context context) {
        super(context);
    }

    @Override // com.mcto.sspsdk.internal.y2
    public final z3 a(View view) {
        return view == this.n ? z3.CLICK_AREA_PLAYER : z3.GRAPHIC;
    }

    @Override // com.mcto.sspsdk.internal.y2
    public final void b() {
        if (this.v == null) {
            return;
        }
        j2 j2Var = new j2(getContext(), this.l, TextUtils.isEmpty(this.x), this.m);
        this.I = j2Var;
        q2 q2Var = this.J;
        j2Var.t = q2Var;
        j2Var.s = q2Var.f;
        j2Var.v = this;
        pa paVar = new pa(getContext());
        this.H = paVar;
        j2 j2Var2 = this.I;
        try {
            o3 o3Var = paVar.g;
            if (o3Var != j2Var2) {
                if (o3Var != null) {
                    paVar.b.removeView(o3Var);
                }
                paVar.g = j2Var2;
                j2Var2.getClass();
                ((j2) paVar.g).a = paVar;
                paVar.b.addView(paVar.g, new FrameLayout.LayoutParams(-1, -1));
            } else {
                o3Var.getClass();
            }
        } catch (Exception e) {
        }
        this.H.a(this.v);
        pa paVar2 = this.H;
        this.n = paVar2;
        paVar2.setId(R.id.qy_banner_core);
        if (this.v.n()) {
            return;
        }
        this.n.setOnClickListener(this);
    }

    @Override // com.mcto.sspsdk.internal.y2
    public final String c() {
        return this.l.getVideoRadio();
    }

    @Override // com.mcto.sspsdk.internal.y2
    public final void d() {
        j2 j2Var = this.I;
        if (j2Var != null) {
            pa paVar = j2Var.a;
            if (paVar != null) {
                paVar.c();
            }
            j2Var.removeAllViews();
        }
        removeAllViews();
    }
}
