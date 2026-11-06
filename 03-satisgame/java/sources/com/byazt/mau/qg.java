package com.byazt.mau;

import android.text.TextUtils;
import com.anythink.core.common.f.e;
import com.byazt.fr.s;
import com.byazt.nf.rv;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 734, 26})
public class qg extends com.byazt.fr.n {
    public double qg;
    public String s;
    public final String q = "xgc_prop_volume";
    public volatile int l = -2;
    public n n = new n(rv.getContext());

    public int l() {
        return this.l;
    }

    public void n(double d) {
        this.qg = d;
    }

    public void n(String str) {
        this.s = str;
    }

    public int w() {
        return (int) s.n().w();
    }

    public int x() {
        int iW = w();
        int iQg = this.n.qg() - this.n.n();
        if (iQg != 0) {
            return Math.round((iW * 100.0f) / iQg);
        }
        return -1;
    }

    public void qg(double d) {
        int iQg = this.n.qg();
        int iN = this.n.n();
        int i = (int) d;
        if (d < iQg) {
            iQg = d <= ((double) iN) ? iN : i;
        }
        this.l = iQg;
        this.n.n(iQg);
    }

    @Override // com.byazt.fr.n
    public JSONObject q() {
        return rv.qg().il();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0019 A[PHI: r7
      0x0019: PHI (r7v2 double) = (r7v0 double), (r7v1 double) binds: [B:8:0x0017, B:11:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.byazt.fr.n
    public boolean n(int i) {
        double dN;
        JSONObject jSONObjectQ = q();
        if (jSONObjectQ == null) {
            return false;
        }
        if (i != 1) {
            if (i == 2) {
                dN = n(jSONObjectQ);
            }
            return false;
        }
        dN = jSONObjectQ.optDouble(e.a.d, 0.0d);
        double d = -1.0d;
        if (dN <= -1.0d) {
            dN = d;
        } else {
            d = 1.0d;
            if (dN >= 1.0d) {
                dN = d;
            }
        }
        if (dN != 0.0d && dN != -2.0d) {
            qg(((double) w()) + (((double) (this.n.qg() - this.n.n())) * dN));
            return true;
        }
        return false;
    }

    private double n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return -2.0d;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("applist");
        return n(((((double) (jSONArrayOptJSONArray != null && !TextUtils.isEmpty(this.s) && jSONArrayOptJSONArray.toString().contains(this.s) ? 1 : -1)) * jSONObject.optDouble("content_factor", 0.0d)) + (((double) (this.qg >= 10.0d ? 1 : -1)) * jSONObject.optDouble("duration_factor", 0.0d)) + (((double) (com.byazt.fr.qg.qg() ? 1 : -1)) * jSONObject.optDouble("night_factor", 0.0d)) + (jSONObject.optDouble("week_factor", 0.0d) * ((double) (com.byazt.fr.qg.n() ? 1 : -1))) + (((double) (this.n.q() ? 1 : -1)) * jSONObject.optDouble("headset_factor", 0.0d))) * jSONObject.optDouble("factor", 0.0d), jSONObject);
    }

    @Override // com.byazt.fr.n
    public void qg(int i) {
        float fW = s.n().w();
        if (fW != -2.0f) {
            int iQg = this.n.qg();
            int iN = this.n.n();
            int i2 = (int) fW;
            if (fW < iQg) {
                iQg = fW <= ((float) iN) ? iN : i2;
            }
            this.l = iQg;
            this.n.n(iQg);
        }
    }

    @Override // com.byazt.fr.n
    public boolean qg() {
        return s.n().q();
    }

    @Override // com.byazt.fr.n
    public boolean s() {
        int iX = x();
        return iX >= 94 || iX <= 6;
    }
}
