package com.byazt.jjx;

import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import com.anythink.core.common.f.e;
import com.byazt.fr.s;
import com.byazt.nf.rv;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1659, 26})
public class qg extends com.byazt.fr.n {
    public Window n;
    public final String qg = "xgc_prop_bright";
    public final float s = 255.0f;
    public final int q = -1;

    public qg(Window window) {
        this.n = window;
        if (s.n().l() == -2.0f) {
            s.n().n(l() / 255.0f);
        }
    }

    public int l() {
        return Settings.System.getInt(rv.getContext().getContentResolver(), "screen_brightness", 0);
    }

    public void n(double d) {
        qg(d);
    }

    public float n(Window window) {
        return window.getAttributes().screenBrightness;
    }

    @Override // com.byazt.fr.n
    public JSONObject q() {
        return rv.qg().la();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001c A[PHI: r7
      0x001c: PHI (r7v3 double) = (r7v1 double), (r7v2 double) binds: [B:8:0x001a, B:11:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.byazt.fr.n
    public boolean n(int i) {
        double dQg;
        JSONObject jSONObjectQ = q();
        if (jSONObjectQ == null) {
            return false;
        }
        s.n();
        if (i == 1) {
            dQg = jSONObjectQ.optDouble(e.a.d, 0.0d);
            double d = 1.0d;
            if (dQg >= 1.0d) {
                dQg = d;
            } else {
                d = -1.0d;
                if (dQg <= -1.0d) {
                    dQg = d;
                }
            }
        } else {
            if (i != 2) {
                return false;
            }
            dQg = s.n().qg();
            if (dQg == -2.0d) {
                return false;
            }
        }
        if (dQg == 0.0d) {
            return false;
        }
        if (n(this.n) == -1.0f) {
            n(((double) (l() / 255.0f)) + dQg);
        }
        return true;
    }

    @Override // com.byazt.fr.n
    public void qg(int i) {
        qg(-1.0d);
    }

    private void qg(double d) {
        WindowManager.LayoutParams attributes = this.n.getAttributes();
        if (attributes != null) {
            if (d != -1.0d) {
                d = Math.max(0.0d, Math.min(d, 1.0d));
                if (d == 0.0d) {
                    d = -1.0d;
                }
            }
            attributes.screenBrightness = (float) d;
            this.n.setAttributes(attributes);
        }
    }

    @Override // com.byazt.fr.n
    public boolean qg() {
        return s.n().s();
    }

    @Override // com.byazt.fr.n
    public boolean s() {
        if (this.n == null) {
            return true;
        }
        double dL = s.n().l();
        return dL >= 0.95d || dL <= 0.05d;
    }
}
