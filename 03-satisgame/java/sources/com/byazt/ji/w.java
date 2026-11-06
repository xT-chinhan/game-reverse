package com.byazt.ji;

import com.anythink.core.common.f.e;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 115, 13})
public class w {
    public final LinkedHashMap<String, n> n = new LinkedHashMap<>();
    public com.byazt.ji.n qg = com.byazt.ji.n.n();

    @com.byazt.cp.n(n = {0, 1, 115, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ})
    public static final class qg {
        public final boolean n;
        public final n qg;

        public qg(boolean z, n nVar) {
            this.n = z;
            this.qg = nVar;
        }
    }

    public synchronized void n(com.byazt.ji.n nVar) {
        if (nVar == null) {
            try {
                nVar = com.byazt.ji.n.n();
            } catch (Throwable th) {
                throw th;
            }
        }
        this.qg = nVar;
        s();
    }

    public synchronized qg n(com.byazt.ji.qg qgVar) {
        if (qgVar != null) {
            if (this.qg.n && !this.qg.n(qgVar.s)) {
                if (!this.n.containsKey(qgVar.n()) && this.n.size() >= this.qg.l) {
                    return new qg(true, null);
                }
                n nVar = this.n.get(qgVar.n());
                if (nVar == null) {
                    nVar = new n(qgVar);
                    this.n.put(qgVar.n(), nVar);
                }
                nVar.n(qgVar);
                return new qg(false, nVar);
            }
        }
        return new qg(false, null);
    }

    public synchronized JSONObject n(x xVar, String str) {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject.put(MediationConstant.KEY_REASON, str);
            jSONObject.put("entry_count", this.n.size());
            Iterator<n> it = this.n.values().iterator();
            while (it.hasNext()) {
                JSONObject jSONObjectN = it.next().n(xVar);
                if (jSONObjectN != null) {
                    jSONArray.put(jSONObjectN);
                }
            }
            jSONObject.put("entries", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public synchronized void n() {
        this.n.clear();
    }

    public synchronized boolean qg() {
        return !this.n.isEmpty();
    }

    private void s() {
        while (this.n.size() > this.qg.l) {
            Iterator<String> it = this.n.keySet().iterator();
            if (!it.hasNext()) {
                return;
            }
            it.next();
            it.remove();
        }
    }

    @com.byazt.cp.n(n = {0, 1, 115, 108})
    public static class n {
        public int cp;
        public long d;
        public int fs;
        public final int l;
        public final String n;
        public final String q;
        public final String qg;
        public int rv;
        public final String s;
        public int tj;
        public String w;
        public int x;

        public n(com.byazt.ji.qg qgVar) {
            this.n = qgVar.n;
            this.qg = qgVar.qg;
            this.s = qgVar.s;
            this.q = qgVar.l;
            this.l = qgVar.w;
        }

        public void n(com.byazt.ji.qg qgVar) {
            this.x++;
            if (qgVar.fs) {
                this.fs++;
            } else {
                this.rv++;
            }
            if (qgVar.tj > qgVar.rv && qgVar.rv >= 0) {
                this.tj++;
            }
            if ("miss".equals(qgVar.l) || "remote_fallback".equals(qgVar.l)) {
                this.cp++;
            }
            if (qgVar.q != null) {
                this.w = qgVar.q;
            }
            this.d += Math.max(0L, qgVar.x);
        }

        public JSONObject n(x xVar) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("category", this.n);
                jSONObject.put("scene", this.qg);
                jSONObject.put(e.a.b, this.s);
                jSONObject.put("hit_level", this.q);
                jSONObject.put("method_id", this.l);
                jSONObject.put("trace_token", this.w);
                jSONObject.put("total_count", this.x);
                jSONObject.put("success_count", this.fs);
                jSONObject.put("failure_count", this.rv);
                jSONObject.put("version_drift_count", this.tj);
                jSONObject.put("missing_node_count", this.cp);
                jSONObject.put("duration_ms", this.d);
                jSONObject.put("health_score", xVar.n(this));
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }
}
