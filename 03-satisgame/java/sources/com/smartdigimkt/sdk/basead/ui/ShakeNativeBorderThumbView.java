package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import com.smartdigimkt.b2.y;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.d1.d;
import com.smartdigimkt.d1.f;
import com.smartdigimkt.n1.g2;
import com.smartdigimkt.n1.x4;
import com.smartdigimkt.n1.y4;
import com.smartdigimkt.n1.z4;
import com.smartdigimkt.p3.l;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.z.o;

/* JADX INFO: loaded from: classes3.dex */
public class ShakeNativeBorderThumbView extends ShakeBorderThumbView {
    public final String p;
    public d q;
    public l r;
    public boolean s;
    public final x4 t;
    public final y4 u;

    public ShakeNativeBorderThumbView(Context context) {
        super(context);
        this.p = "ShakeNativeBorderThumbView";
        this.t = new x4(this);
        this.u = new y4(this);
        this.r = new l(1);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.ShakeBorderThumbView, com.smartdigimkt.sdk.basead.ui.BaseShakeView
    public final void a() {
        super.a();
        setBackgroundResource(k.a(SDKContext.getInstance().d(), "myoffer_bg_shake_native_border_thumb", "drawable"));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseShakeView
    public final void b() {
        if (this.l || this.q == null) {
            return;
        }
        y yVarA = y.a();
        y4 y4Var = this.u;
        synchronized (yVarA.b) {
            if (yVarA.c.contains(y4Var)) {
                return;
            }
            yVarA.c.add(y4Var);
            y4Var.getClass();
            yVarA.c.size();
            if (yVarA.c.size() == 1) {
                yVarA.d = true;
                o.a().a(yVarA.j);
            }
        }
    }

    public void changeBackground() {
        int iA = k.a(getContext(), 10.0f);
        int iA2 = k.a(getContext(), 10.0f);
        int iA3 = k.a(getContext(), 6.0f);
        setPadding(iA, iA3, iA2, iA3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1725553114);
        gradientDrawable.setCornerRadius(k.a(getContext(), 20.0f));
        setBackground(gradientDrawable);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.ShakeBorderThumbView
    public int getLayoutId() {
        return k.a(getContext(), "myoffer_shake_native_border_thumb", "layout");
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseShakeView
    public void releaseShakeListener() {
        super.releaseShakeListener();
        this.q = null;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseShakeView
    public void setOnShakeListener(g2 g2Var, e eVar) {
        if (this.l) {
            return;
        }
        unRegisterShakeListener();
        this.s = (eVar == null || eVar.P1) ? false : true;
        if (eVar != null) {
            this.r = new l(eVar.a());
        }
        d dVarA = f.a(eVar);
        this.q = dVarA;
        if (dVarA == null) {
            this.k = g2Var;
            return;
        }
        dVarA.a(new z4(this, g2Var));
        this.k = g2Var;
        if (isAttachedToWindow()) {
            b();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseShakeView
    public void unRegisterShakeListener() {
        y yVarA = y.a();
        y4 y4Var = this.u;
        synchronized (yVarA.b) {
            yVarA.c.remove(y4Var);
            y4Var.getClass();
            yVarA.c.size();
            if (yVarA.c.size() == 0) {
                o.a().b(yVarA.j);
            }
        }
    }
}
