package com.byazt.wb;

import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.ehw.DeviceUtils;
import com.byazt.gct.pk;
import com.byazt.tk.k;
import com.byazt.tk.rv;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1324, 8})
public class s implements com.byazt.ot.n.qg {
    public static volatile s qg;
    public float oa;
    public final ConcurrentHashMap<Integer, q> s = new ConcurrentHashMap<>();
    public final Map<String, Float> q = new ConcurrentHashMap();
    public q l = null;
    public JSONArray x = new JSONArray();
    public final String fs = "realtime_feature";
    public long rv = 0;
    public long tj = 0;
    public long cp = 0;
    public long d = 0;
    public long n = 0;
    public Handler w = rv.n();

    @Override // com.byazt.ot.n.qg
    public void q() {
    }

    @Override // com.byazt.ot.n.qg
    public void s() {
    }

    private Handler k() {
        return this.w;
    }

    public long l() {
        if (this.cp == 0) {
            this.cp = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
        }
        return this.cp;
    }

    public long w() {
        if (this.d == 0) {
            this.d = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - com.byazt.vyf.l.l);
        }
        return this.d;
    }

    private s() {
        com.byazt.ot.n nVarS = com.byazt.vyf.s.cy().s();
        if (nVarS != null) {
            nVarS.n(this);
        }
    }

    public static s x() {
        if (qg == null) {
            synchronized (s.class) {
                if (qg == null) {
                    qg = new s();
                }
            }
        }
        return qg;
    }

    public void fs() {
        l();
        w();
        n.n(n.n, 0L, 0L);
        n.n(n.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, String str2, String str3, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !com.byazt.nf.rv.qg().cl()) {
            return;
        }
        if (i <= 0 || i > 10) {
            if (this.l == null) {
                this.l = new q(str2);
            }
            this.l.n(str, str3);
        } else {
            q qVar = this.s.get(Integer.valueOf(i));
            if (qVar == null) {
                qVar = new q(str2);
                this.s.put(Integer.valueOf(i), qVar);
            }
            qVar.n(str, str3);
        }
    }

    public void n(final String str, final String str2, final String str3, final JSONObject jSONObject, final String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !com.byazt.nf.rv.qg().cl()) {
            return;
        }
        str.hashCode();
        switch (str) {
            case "feed_over":
            case "show":
            case "skip":
            case "click":
            case "feed_continue":
            case "feed_break":
            case "feed_pause":
            case "play_start":
                k().post(new Runnable() { // from class: com.byazt.wb.s.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            String strOptString = str3;
                            int iOptInt = 0;
                            if (jSONObject != null) {
                                if (TextUtils.isEmpty(strOptString)) {
                                    strOptString = jSONObject.optString("req_id");
                                }
                                iOptInt = jSONObject.optInt("ad_slot_type", 0);
                            } else if (str4 != null) {
                                JSONObject jSONObject2 = new JSONObject(str4);
                                if (TextUtils.isEmpty(strOptString)) {
                                    strOptString = jSONObject2.optString("req_id");
                                }
                                iOptInt = jSONObject2.optInt("ad_slot_type", 0);
                            }
                            s.this.n(str, str2, strOptString, iOptInt);
                        } catch (Exception unused) {
                        }
                    }
                });
                break;
        }
    }

    public void n(final String str, final pk pkVar) {
        if (!TextUtils.isEmpty(str) && com.byazt.nf.rv.qg().cl() && "videoPercent30".equals(str)) {
            k().post(new Runnable() { // from class: com.byazt.wb.s.2
                @Override // java.lang.Runnable
                public void run() {
                    pk pkVar2 = pkVar;
                    if (pkVar2 != null) {
                        String strQ = pkVar2.q();
                        if (TextUtils.isEmpty(strQ)) {
                            return;
                        }
                        s.this.n(str, strQ, pkVar.ou(), com.byazt.vgx.w.d(pkVar));
                    }
                }
            });
        }
    }

    public void n(final String str, final pk pkVar, final String str2) {
        if (TextUtils.isEmpty(str) || !com.byazt.nf.rv.qg().cl()) {
            return;
        }
        if ("landingStart".equals(str) || "landingFinish".equals(str) || "landingContinue".equals(str) || "landingPause".equals(str)) {
            k().post(new Runnable() { // from class: com.byazt.wb.s.3
                @Override // java.lang.Runnable
                public void run() {
                    pk pkVar2 = pkVar;
                    if (pkVar2 != null) {
                        String strQ = pkVar2.q();
                        if (TextUtils.isEmpty(strQ)) {
                            return;
                        }
                        s.this.n(str, strQ, pkVar.ou() + str2, com.byazt.vgx.w.d(pkVar));
                    }
                }
            });
        }
    }

    public JSONArray rv() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.s.keySet().isEmpty()) {
            this.x = new JSONArray();
        } else {
            JSONArray jSONArray = new JSONArray();
            try {
                try {
                    Iterator<Integer> it = this.s.keySet().iterator();
                    while (it.hasNext()) {
                        int iIntValue = it.next().intValue();
                        q qVar = this.s.get(Integer.valueOf(iIntValue));
                        if (qVar != null && qVar.n().length() > 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("slot_type", iIntValue);
                            jSONObject.put("event_cnts", qVar.n());
                            jSONArray.put(jSONObject);
                        }
                    }
                    if (this.l != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("slot_type", -1);
                        jSONObject2.put("event_cnts", this.l.n());
                        jSONArray.put(jSONObject2);
                    }
                } catch (JSONException e) {
                    k.n(e.getMessage());
                }
            } catch (Throwable th) {
                k.n(th.getMessage());
            }
            this.x = jSONArray;
        }
        if (com.byazt.nf.rv.qg().ei()) {
            double dCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis;
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("cost", dCurrentTimeMillis);
                jSONObject3.put("feature_cnt", this.x.length());
            } catch (JSONException e2) {
                k.n(e2.getMessage());
            }
            com.byazt.eji.s.n().d(jSONObject3);
        }
        return this.x;
    }

    public void tj() {
        long jCp = cp();
        if (jCp != this.n) {
            n.n(n.l);
            this.n = jCp;
        }
    }

    public long cp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        if (this.n == 0) {
            this.n = timeInMillis;
        }
        return timeInMillis;
    }

    public long d() {
        return this.rv;
    }

    public long oa() {
        return this.tj;
    }

    @Override // com.byazt.ot.n.qg
    public void n() {
        if (!com.byazt.vyf.s.cy().lh() && com.byazt.nf.rv.qg().cl()) {
            k().post(new Runnable() { // from class: com.byazt.wb.s.4
                @Override // java.lang.Runnable
                public void run() {
                    n.n(n.s, n.w(), 0L);
                    if (s.this.l != null) {
                        s.this.l.qg();
                    }
                    Iterator it = s.this.s.values().iterator();
                    while (it.hasNext()) {
                        ((q) it.next()).qg();
                    }
                    s.this.tj = System.currentTimeMillis();
                }
            });
        }
    }

    public float sz() {
        if (this.oa == 0.0f) {
            this.oa = DeviceUtils.fs();
        }
        return this.oa;
    }

    @Override // com.byazt.ot.n.qg
    public void qg() {
        if (!com.byazt.vyf.s.cy().lh() && com.byazt.nf.rv.qg().cl()) {
            k().post(new Runnable() { // from class: com.byazt.wb.s.5
                @Override // java.lang.Runnable
                public void run() {
                    s.this.oa = DeviceUtils.fs();
                    n.n(n.qg, 0L, n.x());
                    n.n(n.w);
                    s.this.rv = System.currentTimeMillis();
                }
            });
        }
    }

    public void n(pk pkVar, float f) {
        if (pkVar != null) {
            this.q.put(com.byazt.vgx.w.n(pkVar, ""), Float.valueOf(f));
        }
    }

    public float n(String str) {
        Float f;
        if (TextUtils.isEmpty(str) || (f = this.q.get(str)) == null) {
            return 0.0f;
        }
        return f.floatValue();
    }
}
