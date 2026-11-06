package com.byazt.vhv;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.byazt.pnm.w;
import com.byazt.tk.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME, 26})
public class qg implements com.byazt.ot.n.qg, s {
    public long cp;
    public long d;
    public long k;
    public final int l;
    public com.byazt.mkl.n n;
    public long oa;
    public long sz;
    public final String w;
    public final String x;
    public long s = 0;
    public int q = -1;
    public volatile boolean fs = false;
    public volatile boolean rv = false;
    public volatile boolean tj = false;
    public int cy = -1;
    public int hd = -1;
    public int cd = -1;
    public int um = -1;
    public int a = 0;
    public String py = "";
    public String ou = "";
    public Runnable wm = new Runnable() { // from class: com.byazt.vhv.qg.1
        public String q;
        public String qg;
        public String s;

        @Override // java.lang.Runnable
        public void run() {
            if (qg.this.fs || !qg.this.rv || qg.this.tj) {
                return;
            }
            String strValueOf = String.valueOf(qg.this.q == -1 ? "0" : Integer.valueOf(qg.this.q));
            boolean z = !strValueOf.equals(qg.this.ou);
            qg.this.ou = strValueOf;
            if (z || TextUtils.isEmpty(this.qg)) {
                this.qg = n.qg().n(strValueOf, qg.this.l);
            }
            if (z || TextUtils.isEmpty(this.s)) {
                this.s = n.qg().qg(strValueOf, qg.this.l);
            }
            if (z || TextUtils.isEmpty(this.q)) {
                this.q = n.qg().s(strValueOf, qg.this.l);
            }
            q.n.C0371n c0371n = new q.n.C0371n();
            c0371n.n(strValueOf).qg(this.qg).s(this.s).q(this.q).n(qg.this.l).l(qg.this.w);
            c0371n.n(qg.this.tj());
            q.x().n(c0371n.n(), qg.this.m);
        }
    };
    public final com.byazt.qg.qg<q.qg> m = new com.byazt.qg.qg<q.qg>() { // from class: com.byazt.vhv.qg.2
        @Override // com.byazt.qg.qg
        public void n(int i, String str, JSONObject jSONObject) {
        }

        @Override // com.byazt.qg.qg
        public void n(final q.qg qgVar, long j) {
            if (qgVar == null) {
                return;
            }
            if (qg.this.n != null && qgVar.qg()) {
                rv.qg().post(new Runnable() { // from class: com.byazt.vhv.qg.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.byazt.mkl.n nVar = qg.this.n;
                        if (nVar != null) {
                            nVar.n(qgVar.qg(), null);
                        }
                    }
                });
            }
            if (qgVar.qg()) {
                qg.this.fs = true;
                qg.this.l();
            } else {
                qg.this.n(qgVar.q());
            }
            try {
                qg.this.n(qgVar, j);
            } catch (JSONException unused) {
            }
        }
    };
    public final Handler qg = new Handler(rv.n().getLooper());

    @Override // com.byazt.ot.n.qg
    public void q() {
    }

    @Override // com.byazt.ot.n.qg
    public void s() {
    }

    public qg(int i, String str, String str2) {
        this.l = i;
        this.w = str;
        this.x = str2;
        com.byazt.ikv.qg.qg(str, this, getClass());
        w wVarXk = com.byazt.nf.rv.qg().xk();
        if (wVarXk == null) {
            return;
        }
        long jL = wVarXk.l();
        this.d = jL;
        this.cp = jL;
        this.oa = wVarXk.w();
        com.byazt.vyf.s.cy().n(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float tj() {
        int i = -1;
        try {
            Context context = com.byazt.nf.rv.getContext();
            if (context != null) {
                i = Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
            }
        } catch (Throwable unused) {
        }
        if (i < 0) {
            return -1.0f;
        }
        return Math.round((i / 255.0f) * 10.0f) / 10.0f;
    }

    public void l() {
        this.rv = false;
        this.qg.removeCallbacksAndMessages(null);
        com.byazt.de.qg.l(this.x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (TextUtils.equals("no_data", jSONObject.optString("noise_module"))) {
                long j = this.cp * 2;
                this.cp = j;
                this.cp = Math.min(j, 2000L);
            } else {
                this.cp = this.d;
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = this.cp - (jCurrentTimeMillis - this.s);
        if (j2 < 0) {
            j2 = 0;
        }
        this.s = jCurrentTimeMillis;
        if (this.fs || !this.rv) {
            return;
        }
        if (this.tj) {
            this.sz = j2;
            this.k = 0L;
        } else {
            n(j2);
        }
    }

    private void n(long j) {
        long jMax = Math.max(j, 0L);
        this.sz = jMax;
        this.k = System.currentTimeMillis() + jMax;
        this.qg.removeCallbacks(this.wm);
        this.qg.postDelayed(this.wm, jMax);
    }

    @Override // com.byazt.vhv.s
    public void n(int i, int i2, int i3, int i4, boolean z) {
        this.a = z ? 2 : 1;
        this.cy = i;
        this.hd = i2;
        this.cd = i3;
        this.um = i4;
        this.q = n.qg().n(i, i2, i3, i4);
    }

    public void n(com.byazt.mkl.n nVar) {
        if (nVar == null) {
            return;
        }
        this.n = nVar;
    }

    public void w() {
        w wVarXk;
        if (this.fs || this.rv || !q.x().s() || (wVarXk = com.byazt.nf.rv.qg().xk()) == null || !wVarXk.s(this.l)) {
            return;
        }
        this.rv = true;
        this.tj = false;
        this.sz = this.oa;
        this.s = System.currentTimeMillis();
        n(this.oa);
        com.byazt.ikv.qg.n(this.w, Boolean.FALSE, Boolean.class);
    }

    public void x() {
        if (!this.rv || this.fs || this.tj) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.k;
        if (j > jCurrentTimeMillis) {
            this.sz = j - jCurrentTimeMillis;
        } else {
            this.sz = 0L;
        }
        this.tj = true;
        this.k = 0L;
        this.qg.removeCallbacks(this.wm);
    }

    public void fs() {
        if (this.rv && !this.fs && this.tj) {
            this.tj = false;
            this.s = System.currentTimeMillis();
            if (this.sz <= 0) {
                this.sz = this.cp;
            }
            n(this.sz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(q.qg qgVar, long j) throws JSONException {
        String strOptString;
        JSONObject jSONObjectN = n(this.x);
        if (jSONObjectN == null) {
            return;
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectN.optJSONArray("cost_time");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONObjectN.putOpt("cost_time", jSONArrayOptJSONArray);
        }
        jSONArrayOptJSONArray.put(j);
        if (!qgVar.qg()) {
            JSONObject jSONObjectQ = qgVar.q();
            if (jSONObjectQ != null) {
                String strOptString2 = jSONObjectQ.optString("noise_module");
                if (!TextUtils.isEmpty(strOptString2)) {
                    this.py = strOptString2;
                    JSONObject jSONObjectOptJSONObject = jSONObjectN.optJSONObject("noise_module");
                    if (jSONObjectOptJSONObject == null) {
                        jSONObjectOptJSONObject = new JSONObject();
                        jSONObjectN.putOpt("noise_module", jSONObjectOptJSONObject);
                    }
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(strOptString2);
                    if (jSONArrayOptJSONArray2 == null) {
                        jSONArrayOptJSONArray2 = new JSONArray();
                        try {
                            jSONObjectOptJSONObject.putOpt(strOptString2, jSONArrayOptJSONArray2);
                        } catch (JSONException unused) {
                        }
                    }
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectQ.optJSONObject("noise_detail");
                    if (jSONObjectOptJSONObject2 == null) {
                        strOptString = String.valueOf(System.currentTimeMillis());
                    } else {
                        strOptString = jSONObjectOptJSONObject2.optString("ts");
                    }
                    jSONArrayOptJSONArray2.put(strOptString);
                } else {
                    this.py = ILivePush.ClickType.CLOSE;
                    jSONObjectN.putOpt("is_close", Integer.valueOf(qgVar.n()));
                    if (qgVar.s() > 0.0d) {
                        com.byazt.ikv.qg.n(this.w, Boolean.TRUE, Boolean.class);
                        JSONArray jSONArrayOptJSONArray3 = jSONObjectN.optJSONArray("close_desire");
                        if (jSONArrayOptJSONArray3 == null) {
                            jSONArrayOptJSONArray3 = new JSONArray();
                            jSONObjectN.putOpt("close_desire", jSONArrayOptJSONArray3);
                        }
                        jSONArrayOptJSONArray3.put(qgVar.s());
                    }
                }
            }
        } else {
            this.py = ILivePush.ClickType.CLOSE;
            com.byazt.ikv.qg.n(this.w, Boolean.TRUE, Boolean.class);
            JSONObject jSONObjectQ2 = qgVar.q();
            if (jSONObjectQ2 != null) {
                Iterator<String> itKeys = jSONObjectQ2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        if (!next.equals("noise_module")) {
                            jSONObjectN.put(next, jSONObjectQ2.get(next));
                        }
                    } catch (JSONException unused2) {
                    }
                }
            }
            jSONObjectN.put("listner", this.n != null);
            jSONObjectN.put("stop", this.fs);
        }
        jSONObjectN.put("task_call_ts", System.currentTimeMillis());
        jSONObjectN.put("task_call_ets", SystemClock.elapsedRealtime());
        jSONObjectN.put("close_pos", this.q);
        jSONObjectN.put("close_x", this.cy);
        jSONObjectN.put("close_y", this.hd);
        jSONObjectN.put("close_width", this.cd);
        jSONObjectN.put("close_height", this.um);
        jSONObjectN.put("is_skip", this.a);
        jSONObjectN.put("last_noise_mode", this.py);
    }

    public static JSONObject n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object objQ = com.byazt.de.qg.q(str, 3);
        if (objQ instanceof JSONObject) {
            return (JSONObject) objQ;
        }
        JSONObject jSONObject = new JSONObject();
        com.byazt.de.qg.n(str, 3, jSONObject);
        return jSONObject;
    }

    public void rv() {
        this.fs = true;
        this.rv = false;
        this.tj = false;
        this.sz = 0L;
        this.k = 0L;
        this.n = null;
        this.qg.removeCallbacksAndMessages(null);
        com.byazt.vyf.s.cy().qg(this);
    }

    @Override // com.byazt.ot.n.qg
    public void n() {
        x();
    }

    @Override // com.byazt.ot.n.qg
    public void qg() {
        fs();
    }
}
