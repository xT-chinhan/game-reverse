package com.bytedance.sdk.openadsdk.core.hi.ah.ah;

import android.content.Context;
import com.bytedance.sdk.component.utils.op;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.nw;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms {
    protected int ah;
    protected boolean d = true;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected Context f2580ms;
    protected lm xr;

    abstract boolean ah();

    public void ms(Context context) {
        this.f2580ms = context;
    }

    public void ms(lm lmVar) {
        this.xr = lmVar;
    }

    public void ms(boolean z) {
        this.d = z;
    }

    public boolean ms() {
        Context context;
        if (this.xr == null || (context = this.f2580ms) == null) {
            return true;
        }
        if (!this.d) {
            return false;
        }
        if (u.ah(context) == 0) {
            try {
                Context context2 = this.f2580ms;
                op.ms(context2, t.ms(context2, "tt_no_network"), 0);
            } catch (Throwable unused) {
            }
        }
        boolean zAh = ah();
        if (zAh) {
            c.f2579ms = true;
            c.ah = true;
        }
        return zAh;
    }

    public int xr() {
        return this.ah;
    }

    protected boolean d() {
        int iAh = u.ah(this.f2580ms);
        lm lmVar = this.xr;
        if (lmVar == null) {
            return false;
        }
        int iUb = nw.ub(lmVar);
        if (iUb == -1) {
            return !ch.ub().ah(iAh);
        }
        if (iUb == 0) {
            return false;
        }
        if (iUb != 2) {
            if (iUb != 3) {
                if (ch.ub().ah(iAh)) {
                    return false;
                }
                com.bytedance.sdk.openadsdk.core.nw.ka kaVarZh = this.xr.zh();
                if (((kaVarZh == null || kaVarZh.ab() <= 0) ? 104857600 : kaVarZh.ab()) <= nw.ao(this.xr)) {
                    return false;
                }
            }
        } else if (iAh == 4) {
            return false;
        }
        return true;
    }
}
