package com.byazt.ot;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.tk.rv;
import com.byazt.vf.x;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 50, 26})
public class qg {
    public static volatile qg n;
    public com.byazt.gwu.s fs;
    public com.byazt.gwu.s rv;
    public com.byazt.gwu.s tj;
    public com.byazt.gwu.s x;
    public volatile int cp = 0;
    public int d = 0;
    public int oa = 0;
    public final Map<String, Integer> qg = new HashMap();
    public final ConcurrentHashMap<String, Integer> s = new ConcurrentHashMap<>();
    public final Map<String, Long> q = new HashMap();
    public final ConcurrentHashMap<String, Long> l = new ConcurrentHashMap<>();
    public final long w = SystemClock.elapsedRealtime();

    private qg() {
    }

    public static qg n() {
        if (n == null) {
            synchronized (qg.class) {
                if (n == null) {
                    n = new qg();
                }
            }
        }
        return n;
    }

    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Integer num = this.qg.get(str);
        this.qg.put(str, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
        this.l.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
        if (this.l.size() > 1) {
            this.d++;
        }
        qg(str);
    }

    public void qg(final String str) {
        rv.n().post(new Runnable() { // from class: com.byazt.ot.qg.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    qg.this.q().n(str, qg.this.q().qg(str, 0) + 1);
                    if (qg.this.cp == 0) {
                        qg qgVar = qg.this;
                        qgVar.cp = qgVar.x().qg("histRunningCount", 0) + 1;
                        qg.this.x().n("histRunningCount", qg.this.cp);
                    }
                } catch (InternalError unused) {
                }
            }
        });
    }

    public void s(String str) {
        Long lRemove;
        if (TextUtils.isEmpty(str) || (lRemove = this.l.remove(str)) == null) {
            return;
        }
        long jElapsedRealtime = (SystemClock.elapsedRealtime() - lRemove.longValue()) / 1000;
        if (jElapsedRealtime >= 0) {
            Long l = this.q.get(str);
            if (l == null || l.longValue() < 0) {
                l = 0L;
            }
            this.q.put(str, Long.valueOf(l.longValue() + jElapsedRealtime));
            n(str, jElapsedRealtime);
        }
    }

    public void n(final String str, final long j) {
        rv.n().post(new Runnable() { // from class: com.byazt.ot.qg.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long j2 = 0;
                    long jQg = qg.this.w().qg(str, 0L);
                    if (jQg >= 0) {
                        j2 = jQg;
                    }
                    qg.this.w().n(str, j2 + j);
                    qg.this.s();
                    qg.this.n(j);
                } catch (InternalError unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j) {
        int i = this.oa;
        if (i == 0) {
            try {
                Map all = w().getAll();
                if (all != null) {
                    Iterator it = all.values().iterator();
                    while (it.hasNext()) {
                        this.oa = (int) (((long) this.oa) + ((Long) it.next()).longValue());
                    }
                }
            } catch (Throwable unused) {
                this.oa = -1;
            }
        } else {
            this.oa = (int) (((long) i) + j);
        }
        x xVar = (x) com.byazt.qp.q.n("armor_service");
        if (xVar != null) {
            xVar.n(this.oa, this.cp);
        }
    }

    public void qg() {
        if (this.l.size() == 1) {
            for (String str : this.l.keySet()) {
                Integer num = this.s.get(str);
                this.s.put(str, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
                q(str);
            }
        }
    }

    public void q(final String str) {
        rv.n().post(new Runnable() { // from class: com.byazt.ot.qg.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    qg.this.l().n(str, qg.this.l().qg(str, 0) + 1);
                } catch (InternalError unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        try {
            Map all = q().getAll();
            if (all == null) {
                return;
            }
            Iterator it = all.values().iterator();
            int iIntValue = 0;
            while (it.hasNext()) {
                iIntValue += ((Integer) it.next()).intValue();
            }
            if (iIntValue != 0 && iIntValue % 75 == 0) {
                final JSONArray jSONArray = new JSONArray();
                Iterator<String> it2 = this.qg.keySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    String next = it2.next();
                    Integer num = this.qg.get(next);
                    Long l = this.q.get(next);
                    Integer num2 = this.s.get(next);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(TapEventParamConstants.PARAM_NAME, next);
                        jSONObject.put("rc", num != null ? num.intValue() : 0);
                        jSONObject.put("ft", l != null ? l.longValue() : 0L);
                        jSONObject.put("asc", num2 != null ? num2.intValue() : 0);
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                final JSONArray jSONArray2 = new JSONArray();
                Map all2 = w().getAll();
                Map all3 = l().getAll();
                if (all2 != null && all3 != null) {
                    for (String str : all.keySet()) {
                        Integer num3 = (Integer) all.get(str);
                        Long l2 = (Long) all2.get(str);
                        Integer num4 = (Integer) all3.get(str);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(TapEventParamConstants.PARAM_NAME, str);
                            jSONObject2.put("rc", num3 != null ? num3.intValue() : 0);
                            jSONObject2.put("ft", l2 != null ? l2.longValue() : 0L);
                            jSONObject2.put("asc", num4 != null ? num4.intValue() : 0);
                            jSONArray2.put(jSONObject2);
                        } catch (JSONException unused2) {
                        }
                    }
                }
                final long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.w) / 1000;
                com.byazt.eji.s.n().n("ad_activity_record", new com.byazt.rs.n() { // from class: com.byazt.ot.qg.4
                    @Override // com.byazt.rs.n
                    public JSONObject n(JSONObject jSONObject3) throws JSONException {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("ara", jSONArray);
                        jSONObject4.put("hara", jSONArray2);
                        jSONObject4.put("rt", jElapsedRealtime);
                        jSONObject4.put("hrc", qg.this.cp);
                        jSONObject4.put("drc", qg.this.d);
                        return jSONObject4;
                    }
                });
            }
        } catch (Throwable unused3) {
        }
    }

    private com.byazt.gwu.s l(String str) {
        return com.byazt.lk.l.qg(com.byazt.vgx.s.q(), str, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.gwu.s q() {
        if (this.x == null) {
            this.x = l("activity_resume_count");
        }
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.gwu.s l() {
        if (this.fs == null) {
            this.fs = l("activity_adshow_count");
        }
        return this.fs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.gwu.s w() {
        if (this.rv == null) {
            this.rv = l("activity_foreground_time");
        }
        return this.rv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.gwu.s x() {
        if (this.tj == null) {
            this.tj = l("activity_recorder");
        }
        return this.tj;
    }
}
