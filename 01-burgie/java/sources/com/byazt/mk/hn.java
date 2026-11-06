package com.byazt.mk;

import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.ca.aj;
import com.byazt.ca.ho;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.byazt.sd.lb;
import com.byazt.wt.DeviceUtils;
import com.byazt.wt.ls;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1191, 20})
public class hn implements com.byazt.wt.pr.hw {
    public static volatile hn hw = null;
    public float m;
    public final ConcurrentHashMap<Integer, x> hn = new ConcurrentHashMap<>();
    public final Map<String, Float> x = new ConcurrentHashMap();
    public x c = null;
    public JSONArray fw = new JSONArray();
    public final String zo = "realtime_feature";
    public long aj = 0;
    public long vk = 0;
    public long w = 0;
    public long k = 0;
    public long pr = 0;
    public Handler uc = aj.pr();

    private Handler ho() {
        return this.uc;
    }

    public long c() {
        if (this.w == 0) {
            this.w = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
        }
        return this.w;
    }

    public long uc() {
        if (this.k == 0) {
            this.k = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - lb.c);
        }
        return this.k;
    }

    private hn() {
        com.byazt.wt.pr prVarHn = com.byazt.sd.zo.nt().hn();
        if (prVarHn != null) {
            prVarHn.pr(this);
        }
    }

    public static hn fw() {
        if (hw == null) {
            synchronized (hn.class) {
                if (hw == null) {
                    hw = new hn();
                }
            }
        }
        return hw;
    }

    public void zo() {
        c();
        uc();
        pr.pr(pr.pr, 0L, 0L);
        pr.pr(pr.x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str, String str2, String str3, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !a.hw().tt()) {
            return;
        }
        if (i <= 0 || i > 10) {
            if (this.c == null) {
                this.c = new x(str2);
            }
            this.c.pr(str, str3);
        } else {
            x xVar = this.hn.get(Integer.valueOf(i));
            if (xVar == null) {
                xVar = new x(str2);
                this.hn.put(Integer.valueOf(i), xVar);
            }
            xVar.pr(str, str3);
        }
    }

    public void pr(final String str, final String str2, final String str3, final JSONObject jSONObject, final String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !a.hw().tt()) {
            return;
        }
        switch (str) {
            case "show":
            case "click":
            case "skip":
            case "play_start":
            case "feed_pause":
            case "feed_continue":
            case "feed_over":
            case "feed_break":
                ho().post(new Runnable() { // from class: com.byazt.mk.hn.1
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
                            hn.this.pr(str, str2, strOptString, iOptInt);
                        } catch (Exception e) {
                        }
                    }
                });
                break;
        }
    }

    public void pr(final String str, final of ofVar) {
        if (TextUtils.isEmpty(str) || !a.hw().tt() || !"videoPercent30".equals(str)) {
            return;
        }
        ho().post(new Runnable() { // from class: com.byazt.mk.hn.2
            @Override // java.lang.Runnable
            public void run() {
                of ofVar2 = ofVar;
                if (ofVar2 != null) {
                    String strX = ofVar2.x();
                    if (!TextUtils.isEmpty(strX)) {
                        hn.this.pr(str, strX, ofVar.ny(), ls.k(ofVar));
                    }
                }
            }
        });
    }

    public void pr(final String str, final of ofVar, final String str2) {
        if (TextUtils.isEmpty(str) || !a.hw().tt()) {
            return;
        }
        if (!"landingStart".equals(str) && !"landingFinish".equals(str) && !"landingContinue".equals(str) && !"landingPause".equals(str)) {
            return;
        }
        ho().post(new Runnable() { // from class: com.byazt.mk.hn.3
            @Override // java.lang.Runnable
            public void run() {
                of ofVar2 = ofVar;
                if (ofVar2 != null) {
                    String strX = ofVar2.x();
                    if (!TextUtils.isEmpty(strX)) {
                        hn.this.pr(str, strX, ofVar.ny() + str2, ls.k(ofVar));
                    }
                }
            }
        });
    }

    public JSONArray aj() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.hn.keySet().isEmpty()) {
            this.fw = new JSONArray();
        } else {
            JSONArray jSONArray = new JSONArray();
            try {
                try {
                    Iterator<Integer> it = this.hn.keySet().iterator();
                    while (it.hasNext()) {
                        int iIntValue = it.next().intValue();
                        x xVar = this.hn.get(Integer.valueOf(iIntValue));
                        if (xVar != null && xVar.pr().length() > 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("slot_type", iIntValue);
                            jSONObject.put("event_cnts", xVar.pr());
                            jSONArray.put(jSONObject);
                        }
                    }
                    if (this.c != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("slot_type", -1);
                        jSONObject2.put("event_cnts", this.c.pr());
                        jSONArray.put(jSONObject2);
                    }
                } catch (JSONException e) {
                    ho.pr(e.getMessage());
                }
            } catch (Throwable th) {
                ho.pr(th.getMessage());
            }
            this.fw = jSONArray;
        }
        if (a.hw().na()) {
            double dCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis;
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("cost", dCurrentTimeMillis);
                jSONObject3.put("feature_cnt", this.fw.length());
            } catch (JSONException e2) {
                ho.pr(e2.getMessage());
            }
            com.byazt.xk.hw.pr().w(jSONObject3);
        }
        return this.fw;
    }

    public void vk() {
        long jW = w();
        if (jW != this.pr) {
            pr.pr(pr.c);
            this.pr = jW;
        }
    }

    public long w() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        if (this.pr == 0) {
            this.pr = timeInMillis;
        }
        return timeInMillis;
    }

    public long k() {
        return this.aj;
    }

    public long m() {
        return this.vk;
    }

    @Override // com.byazt.wt.pr.hw
    public void pr() {
        if (com.byazt.sd.zo.nt().y() || !a.hw().tt()) {
            return;
        }
        ho().post(new Runnable() { // from class: com.byazt.mk.hn.4
            @Override // java.lang.Runnable
            public void run() {
                pr.pr(pr.hn, pr.uc(), 0L);
                if (hn.this.c != null) {
                    hn.this.c.hw();
                }
                Iterator it = hn.this.hn.values().iterator();
                while (it.hasNext()) {
                    ((x) it.next()).hw();
                }
                hn.this.vk = System.currentTimeMillis();
            }
        });
    }

    public float g() {
        if (this.m == 0.0f) {
            this.m = DeviceUtils.zo();
        }
        return this.m;
    }

    @Override // com.byazt.wt.pr.hw
    public void hw() {
        if (com.byazt.sd.zo.nt().y() || !a.hw().tt()) {
            return;
        }
        ho().post(new Runnable() { // from class: com.byazt.mk.hn.5
            @Override // java.lang.Runnable
            public void run() {
                hn.this.m = DeviceUtils.zo();
                pr.pr(pr.hw, 0L, pr.fw());
                pr.pr(pr.uc);
                hn.this.aj = System.currentTimeMillis();
            }
        });
    }

    @Override // com.byazt.wt.pr.hw
    public void hn() {
    }

    @Override // com.byazt.wt.pr.hw
    public void x() {
    }

    public void pr(of ofVar, float f) {
        if (ofVar != null) {
            this.x.put(ls.pr(ofVar, ""), Float.valueOf(f));
        }
    }

    public float pr(String str) {
        Float f;
        if (TextUtils.isEmpty(str) || (f = this.x.get(str)) == null) {
            return 0.0f;
        }
        return f.floatValue();
    }
}
