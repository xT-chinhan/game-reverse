package com.byazt.zsl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.byazt.ej.k;
import com.byazt.ej.oa;
import com.byazt.qyu.PluginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 469, 5})
public class q implements oa {
    public static final AtomicInteger ou = new AtomicInteger();
    public String a;
    public int cd;
    public double cp;
    public int cy;
    public double d;
    public String fs;
    public JSONObject h;
    public int hd;
    public int hu;
    public long k;
    public String l;
    public String m;
    public StringBuilder n;
    public long oa;
    public int py;
    public String q;
    public JSONArray qg;
    public StringBuilder rv;
    public String s;
    public long sz;
    public String tj;
    public boolean um;
    public String w;
    public int wm;
    public int x;

    private q() {
        this.n = new StringBuilder();
        this.qg = new JSONArray();
        this.cd = -8888;
        this.um = false;
        this.py = -8888;
        this.wm = 0;
        this.hu = -1;
        this.wm = ou.addAndGet(1);
    }

    private q(n nVar) {
        this.n = new StringBuilder();
        this.qg = new JSONArray();
        this.cd = -8888;
        this.um = false;
        this.py = -8888;
        this.wm = 0;
        this.hu = -1;
        this.s = nVar.qg;
        this.q = nVar.s;
        this.l = nVar.q;
        this.w = nVar.l;
        this.x = nVar.w;
        this.cy = nVar.rv;
        this.hu = nVar.tj;
        this.k = nVar.x;
        this.hd = nVar.fs;
        this.cp = nVar.cp;
        this.m = nVar.n;
        this.h = nVar.oa;
        String str = nVar.d;
        this.rv = new StringBuilder(TextUtils.isEmpty(str) ? "" : str);
        this.wm = ou.addAndGet(1);
    }

    @Override // com.byazt.ej.oa
    public void n(String str) {
        int iIndexOf = this.rv.indexOf(str);
        if (TextUtils.isEmpty(this.rv)) {
            this.rv.append(str);
        } else if (iIndexOf == -1) {
            this.rv.append(",").append(str);
        }
    }

    @Override // com.byazt.ej.oa
    public void n(int i, int i2, String str) {
        this.cd = i;
        this.py = i2;
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject qg() {
        JSONObject jSONObject = this.h;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(f.bo, this.rv.toString());
            jSONObject.put("node_line", this.n.toString());
            jSONObject.put("node_line_detail", this.qg.toString());
            jSONObject.put("video_url", this.tj);
            jSONObject.put("video_duration", this.cp);
            jSONObject.put("video_size", this.d);
            jSONObject.put("start_duration", this.sz - this.oa);
            jSONObject.put("play_duration", SystemClock.elapsedRealtime() - this.oa);
            jSONObject.put("play_cache_size", this.k);
            jSONObject.put("play_type", this.cy);
            jSONObject.put("player_type", this.hd);
            jSONObject.put("video_index", this.wm);
            jSONObject.put("is_audio", this.um ? 1 : 0);
            jSONObject.put("dynamic_join_type", this.hu);
            int i = this.cd;
            if (i != -8888) {
                jSONObject.put("error_code", i);
            }
            jSONObject.put("error_msg", this.a);
            int i2 = this.py;
            if (i2 != -8888) {
                jSONObject.put("extra_error_code", i2);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // com.byazt.ej.oa
    public void qg(String str) {
        this.n.append(str);
        String strS = s(str);
        JSONObject jSONObject = new JSONObject();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (TextUtils.equals("0505", str)) {
            this.oa = jElapsedRealtime;
        } else if (TextUtils.equals("0506", str)) {
            this.sz = jElapsedRealtime;
        }
        try {
            jSONObject.putOpt("type", strS);
            jSONObject.putOpt("ts", Long.valueOf(System.currentTimeMillis()));
        } catch (Exception unused) {
        }
        this.qg.put(jSONObject);
    }

    @Override // com.byazt.ej.oa
    public void n(long j, k kVar) {
        com.byazt.sf.s sVar = (com.byazt.sf.s) com.byazt.qp.q.n("ad_log", com.byazt.qp.q.qg(null));
        if (sVar == null || kVar == null) {
            return;
        }
        this.d = kVar.cy();
        this.um = kVar.fs();
        this.fs = String.valueOf(j);
        this.tj = kVar.ou();
        sVar.n(this.m, (byte) 1, new com.byazt.rs.n() { // from class: com.byazt.zsl.q.1
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, q.this.w);
                jSONObject.put("rit", q.this.l);
                jSONObject.put("cid", q.this.q);
                jSONObject.put("adtype", q.this.x);
                jSONObject.put("req_id", q.this.s);
                jSONObject.put(MediationConstant.EXTRA_DURATION, q.this.fs);
                return q.this.qg();
            }
        });
    }

    @Override // com.byazt.ej.oa
    public JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rit", this.l);
            jSONObject.put("cid", this.q);
            jSONObject.put("adtype", this.x);
            jSONObject.put("req_id", this.s);
            jSONObject.put(MediationConstant.EXTRA_DURATION, this.fs);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // com.byazt.ej.oa
    public String s(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        str.hashCode();
        switch (str) {
            case "0501":
                return "created";
            case "0502":
                return "bindview";
            case "0503":
                return "initialized";
            case "0504":
                return "prepared";
            case "0505":
                return "started";
            case "0506":
                return "played";
            case "0507":
                return "paused";
            case "0508":
                return "stopped";
            case "0509":
                return "completed";
            case "0510":
                return "error";
            default:
                return "unknown";
        }
    }

    @com.byazt.cp.n(n = {0, 1, 469, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    public static class n {
        public double cp;
        public int fs;
        public String l;
        public String n;
        public JSONObject oa;
        public String q;
        public String qg;
        public int rv;
        public String s;
        public int w;
        public long x;
        public int tj = -1;
        public String d = "";

        public n n(String str) {
            this.n = str;
            return this;
        }

        public n n(double d) {
            this.cp = d;
            return this;
        }

        public n qg(String str) {
            this.s = str;
            return this;
        }

        public n s(String str) {
            this.qg = str;
            return this;
        }

        public n q(String str) {
            this.q = str;
            return this;
        }

        public n n(int i) {
            this.w = i;
            return this;
        }

        public n n(long j) {
            this.x = j;
            return this;
        }

        public n qg(int i) {
            this.fs = i;
            return this;
        }

        public n s(int i) {
            this.rv = i;
            return this;
        }

        public n q(int i) {
            this.tj = i;
            return this;
        }

        public n n(JSONObject jSONObject) {
            this.oa = jSONObject;
            return this;
        }

        public n l(String str) {
            this.l = str;
            return this;
        }

        public q n() {
            return new q(this);
        }
    }
}
