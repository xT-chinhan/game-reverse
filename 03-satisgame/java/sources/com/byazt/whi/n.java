package com.byazt.whi;

import android.content.Context;
import com.byazt.gct.h;
import com.byazt.gct.oa;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 953, 19})
public class n {
    public com.byazt.dc.qg n;
    public qg q;
    public JSONObject qg;
    public pk w;
    public oa x;
    public int s = -1;
    public final AtomicBoolean fs = new AtomicBoolean(false);
    public final AtomicBoolean rv = new AtomicBoolean(false);
    public final Context l = rv.getContext();

    public n(pk pkVar, oa oaVar) {
        this.w = pkVar;
        this.x = oaVar;
    }

    public void n(com.byazt.dc.qg qgVar, int i) {
        this.n = qgVar;
        this.s = i;
    }

    public int n() {
        return this.s;
    }

    public void n(qg qgVar) {
        this.q = qgVar;
    }

    public void n(oa oaVar) {
        this.x = oaVar;
    }

    public pk qg() {
        return this.w;
    }

    public Context getContext() {
        return this.l;
    }

    public void n(pk pkVar) {
        if (this.n != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("style_category", String.valueOf(h.w(pkVar)));
                oa oaVar = this.x;
                if (oaVar != null) {
                    int iW = oaVar.w();
                    if (iW > 0) {
                        jSONObject.put("preferred_size_width", iW);
                    }
                    int iX = this.x.x();
                    if (iX > 0) {
                        jSONObject.put("preferred_size_height", iX);
                    }
                    double dFs = this.x.fs();
                    if (dFs > 0.0d) {
                        jSONObject.put("preferred_aspect_ratio", dFs);
                    }
                }
            } catch (JSONException unused) {
            }
            this.n.n(jSONObject);
        }
    }

    public JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        if (!h.n()) {
            return jSONObject;
        }
        try {
            com.byazt.dc.qg qgVar = this.n;
            if (qgVar != null) {
                JSONObject jSONObjectN = qgVar.n();
                this.qg = jSONObjectN;
                return jSONObjectN;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return jSONObject;
    }

    public void n(JSONObject jSONObject) {
        if (h.n() && this.rv.compareAndSet(false, true)) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.byazt.dc.qg qgVar = this.n;
            if (qgVar != null) {
                qgVar.qg(jSONObject);
            }
        }
    }

    public void q() {
        HashMap map = new HashMap();
        map.put("estimatedArea", this.qg);
        map.put("realArea", this.q.getMaxRectJson());
        map.put("exceedAreaRate", Double.valueOf(this.q.getExceedAreaRate()));
        map.put("widgetArea", this.q.getActualRectJson());
        com.byazt.rg.s.qg(this.w, this.x, false, 100, new JSONObject(map));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", 1);
        } catch (JSONException unused) {
        }
        qg(jSONObject);
    }

    public void qg(JSONObject jSONObject) {
        if (h.n() && this.rv.compareAndSet(false, true)) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.byazt.dc.qg qgVar = this.n;
            if (qgVar != null) {
                qgVar.s(jSONObject);
            }
        }
    }

    public void l() {
        com.byazt.dc.qg qgVar;
        if (h.n() && this.fs.compareAndSet(false, true) && (qgVar = this.n) != null) {
            qgVar.qg();
        }
    }

    public void n(pk pkVar, float f, float f2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("convert", 0);
            jSONObject.put("down_x", f);
            jSONObject.put("down_y", f2);
        } catch (Exception e) {
            e.getMessage();
        }
        com.byazt.rg.s.n(pkVar, this.x, false, jSONObject);
    }
}
