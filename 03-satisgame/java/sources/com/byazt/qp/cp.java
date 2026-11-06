package com.byazt.qp;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.f.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 525, 29})
public class cp implements tj {
    public static final cp n = new cp();
    public volatile JSONObject fs;
    public final com.byazt.ji.l l;
    public final com.byazt.ji.x q;
    public Map<String, Object> qg = new ConcurrentHashMap(1);
    public volatile JSONObject rv;
    public final com.byazt.ji.w s;
    public volatile int tj;
    public final com.byazt.ji.s w;
    public volatile com.byazt.ji.n x;

    private cp() {
        com.byazt.ji.w wVar = new com.byazt.ji.w();
        this.s = wVar;
        com.byazt.ji.x xVar = new com.byazt.ji.x();
        this.q = xVar;
        this.l = new com.byazt.ji.l();
        this.w = new com.byazt.ji.s(wVar, xVar, new com.byazt.ji.s.n() { // from class: com.byazt.qp.cp.1
            @Override // com.byazt.ji.s.n
            public void n(JSONObject jSONObject) {
                cp.this.s(jSONObject);
            }
        });
        this.x = com.byazt.ji.n.n();
    }

    @Override // com.byazt.qp.tj
    public void n(String str, Throwable th) {
        n(new com.byazt.ji.qg("create_failed", "ats_b", str, "", "", -1, 0L, false, -1, -1));
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(e.a.b, str);
            jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "sv cr failed");
            jSONObject.put("object", jSONObject2);
            jSONObject.put("scene", "ats_b");
            if (th != null) {
                jSONObject.put("exception", Log.getStackTraceString(th));
            }
        } catch (JSONException unused) {
        }
        qg(jSONObject);
    }

    @Override // com.byazt.qp.tj
    public void n(d dVar, int i, Object obj, Object obj2) {
        n(com.byazt.ji.qg.n("proxy_create", dVar == null ? "" : dVar.w, dVar, obj2 != null));
    }

    @Override // com.byazt.qp.tj
    public void n(d dVar, int i, String str, Throwable th) {
        String str2 = dVar == null ? "" : dVar.w;
        n(com.byazt.ji.qg.n("proxy_failed", str2, dVar, false));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(e.a.b, str2);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
            jSONObject.put("type", i);
        } catch (JSONException unused) {
        }
        n("ats_b_proxy", jSONObject, th);
    }

    @Override // com.byazt.qp.tj
    public void n(d dVar, Object obj, Object obj2, boolean z, JSONObject jSONObject, Throwable th) {
        Map<String, Object> map;
        n(com.byazt.ji.qg.n("reuse", dVar == null ? "" : dVar.w, dVar, !z && th == null));
        if (dVar == null || obj2 == null || (map = this.qg) == null) {
            return;
        }
        map.put(dVar.w, obj2);
    }

    @Override // com.byazt.qp.tj
    public void n(String str, Object obj, int i, int i2) {
        n(new com.byazt.ji.qg("reg_update", "ats_b", str, "", "", -1, 0L, true, i, i2));
    }

    @Override // com.byazt.qp.tj
    public void n(int i, String str, Throwable th) {
        n(new com.byazt.ji.qg("exception", "ats_b", str, "", "", -1, 0L, false, i, i));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
            jSONObject.put("code", i);
        } catch (JSONException unused) {
        }
        n("ats_b_e", jSONObject, th);
    }

    @Override // com.byazt.qp.tj
    public void n(String str, Object obj, int i) {
        n(new com.byazt.ji.qg("create", "ats_b", str, "", "", -1, 0L, true, i, i));
    }

    @Override // com.byazt.qp.tj
    public void n(String str, Object obj, Object obj2, int i, int i2) {
        n(new com.byazt.ji.qg("update", "ats_b", str, "", "", -1, 0L, true, i, i2));
    }

    @Override // com.byazt.qp.tj
    public void qg(String str, Object obj, Object obj2, int i, int i2) {
        n(new com.byazt.ji.qg("share_update", "ats_b", str, "", "", -1, 0L, true, i, i2));
    }

    @Override // com.byazt.qp.tj
    public void qg(String str, Object obj, int i) {
        n(new com.byazt.ji.qg("release", "ats_b", str, "", "", -1, 0L, true, i, i));
    }

    @Override // com.byazt.qp.tj
    public void n(com.byazt.sym.s sVar) {
        if (sVar == null) {
            return;
        }
        n("init", sVar.n, n(com.byazt.ji.qg.n(sVar)));
    }

    @Override // com.byazt.qp.tj
    public void n(com.byazt.sym.qg qgVar) {
        if (qgVar == null) {
            return;
        }
        n("ad_show", qgVar.n, n(com.byazt.ji.qg.n(qgVar)));
    }

    public void n(String str, JSONObject jSONObject) {
        this.rv = jSONObject;
    }

    public Map<String, Object> n() {
        return this.qg;
    }

    public JSONObject qg() {
        return this.fs;
    }

    public JSONObject s() {
        return this.rv;
    }

    public void n(JSONObject jSONObject) {
        this.x = com.byazt.ji.n.n(jSONObject);
        this.s.n(this.x);
        this.w.n(this.x);
    }

    private void n(final String str, final JSONObject jSONObject, final Throwable th) {
        com.byazt.tk.rv.n().postDelayed(new Runnable() { // from class: com.byazt.qp.cp.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.eji.s.n().n(str, jSONObject, th);
            }
        }, 2000L);
    }

    private void qg(final JSONObject jSONObject) {
        com.byazt.tk.rv.n().postDelayed(new Runnable() { // from class: com.byazt.qp.cp.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.hm.w.n("exception", jSONObject, false);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int i = this.x.w * 1024;
        while (jSONObject.toString().length() > i && jSONObject.optJSONArray("entries") != null && jSONObject.optJSONArray("entries").length() > 1) {
            jSONObject.optJSONArray("entries").remove(jSONObject.optJSONArray("entries").length() - 1);
            try {
                jSONObject.put("entry_count", jSONObject.optJSONArray("entries").length());
                jSONObject.put("trimmed", true);
            } catch (JSONException unused) {
            }
        }
        this.fs = jSONObject;
        com.byazt.hm.w.n("ats_chain", jSONObject, false);
    }

    private void n(String str, String str2, com.byazt.ji.w.n nVar) {
        if (!this.x.n || this.tj >= this.x.fs || nVar == null || this.q.n(nVar) >= this.x.q) {
            return;
        }
        JSONObject jSONObjectN = this.l.n(str, str2, nVar).n();
        if (jSONObjectN.toString().length() > this.x.w * 1024) {
            jSONObjectN = this.l.n(jSONObjectN, this.x.w * 1024);
        }
        this.tj++;
        n(str, jSONObjectN);
    }

    private com.byazt.ji.w.n n(com.byazt.ji.qg qgVar) {
        if (qgVar == null || !q()) {
            return null;
        }
        com.byazt.ji.w.qg qgVarN = this.s.n(qgVar);
        if (qgVarN.n) {
            this.w.n("entry_limit");
            qgVarN = this.s.n(qgVar);
        }
        this.w.s();
        return qgVarN.qg;
    }

    private boolean q() {
        return this.x.qg >= 1.0f || Math.random() < ((double) this.x.qg);
    }
}
