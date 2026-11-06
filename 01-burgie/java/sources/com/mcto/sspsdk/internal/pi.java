package com.mcto.sspsdk.internal;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.mcto.sspsdk.IQySplash;
import com.mcto.sspsdk.QyAdSlot;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class pi implements IQySplash {
    public final Context a;
    public final QyAdSlot f;
    public IQySplash.IAdInteractionListener k;
    public ai l;
    public final AtomicBoolean b = new AtomicBoolean(false);
    public final AtomicInteger c = new AtomicInteger(0);
    public final AtomicBoolean d = new AtomicBoolean(false);
    public p e = null;
    public int g = 5000;
    public int h = -1;
    public boolean i = true;
    public fj j = null;
    public final li m = new li(this);
    public final mi n = new mi(this, Looper.getMainLooper());

    public pi(Context context, QyAdSlot qyAdSlot) {
        this.f = null;
        this.a = context;
        this.f = qyAdSlot;
    }

    public static void a(pi piVar, b4 b4Var) {
        piVar.c.get();
        z3 z3Var = b4Var.a;
        if (z3Var == null) {
            z3Var = z3.GRAPHIC;
        }
        if (z3.CLOSE.equals(z3Var)) {
            if (piVar.i || piVar.g <= 0) {
                piVar.c.set(-1);
                piVar.n.removeCallbacksAndMessages(null);
                if (piVar.k != null) {
                    piVar.n.post(new oi(piVar));
                }
                l lVarA = l.a();
                p pVar = piVar.e;
                HashMap mapA = gj.a(b4Var, piVar.j);
                lVarA.getClass();
                l.a(21, pVar, mapA);
                return;
            }
            return;
        }
        piVar.d.set(true);
        l lVarA2 = l.a();
        p pVar2 = piVar.e;
        HashMap mapA2 = gj.a(b4Var, piVar.j);
        lVarA2.getClass();
        l.a(21, pVar2, mapA2);
        int iA = y3.a(piVar.a, piVar.e, b4Var);
        if (iA != -1) {
            if (iA == 4) {
                l lVarA3 = l.a();
                p pVar3 = piVar.e;
                lVarA3.getClass();
                l.a(25, pVar3, null);
            }
            piVar.n.removeCallbacksAndMessages(null);
            IQySplash.IAdInteractionListener iAdInteractionListener = piVar.k;
            if (iAdInteractionListener != null) {
                iAdInteractionListener.onAdClick();
            }
        }
    }

    @Override // com.mcto.sspsdk.IQySplash
    public final Map getAdExtra() {
        return this.e.j();
    }

    @Override // com.mcto.sspsdk.IQySplash
    public final View getSplashView() {
        return this.j;
    }

    @Override // com.mcto.sspsdk.IQySplash
    public final void setSplashInteractionListener(IQySplash.IAdInteractionListener iAdInteractionListener) {
        this.k = iAdInteractionListener;
    }
}
