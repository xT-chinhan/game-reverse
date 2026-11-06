package com.byazt.ak;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import com.byazt.ca.aj;
import com.byazt.is.k;
import com.byazt.sd.a;
import com.byazt.sd.cz;
import com.byazt.sd.zo;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, 13})
public class hw implements com.byazt.wt.pr.hw, hn {
    public final int c;
    public final String fw;
    public long g;
    public long ho;
    public long k;
    public long m;
    public com.byazt.cy.pr pr;
    public final String uc;
    public long w;
    public long hn = 0;
    public int x = -1;
    public volatile boolean zo = false;
    public volatile boolean aj = false;
    public volatile boolean vk = false;
    public Runnable nt = new Runnable() { // from class: com.byazt.ak.hw.1
        public String c;
        public String hn;
        public String hw;
        public String x;

        @Override // java.lang.Runnable
        public void run() {
            if (!hw.this.zo && hw.this.aj && !hw.this.vk) {
                String strValueOf = String.valueOf(hw.this.x == -1 ? "0" : Integer.valueOf(hw.this.x));
                boolean z = false;
                if (!strValueOf.equals(this.c)) {
                    z = true;
                }
                if (z || TextUtils.isEmpty(this.hw)) {
                    this.hw = pr.hw().pr(strValueOf, hw.this.c);
                }
                if (z || TextUtils.isEmpty(this.hn)) {
                    this.hn = pr.hw().hw(strValueOf, hw.this.c);
                }
                if (z || TextUtils.isEmpty(this.x)) {
                    this.x = pr.hw().hn(strValueOf, hw.this.c);
                }
                x.pr.C0014pr c0014pr = new x.pr.C0014pr();
                c0014pr.pr(strValueOf).hw(this.hw).hn(this.hn).x(this.x).pr(hw.this.c).c(hw.this.uc);
                c0014pr.pr(hw.this.aj());
                x.fw().pr(c0014pr.pr(), hw.this.yb);
            }
        }
    };
    public final com.byazt.ep.hw<x.hw> yb = new com.byazt.ep.hw<x.hw>() { // from class: com.byazt.ak.hw.2
        @Override // com.byazt.ep.hw
        public void pr(final x.hw hwVar, long j) {
            if (hwVar != null) {
                if (hw.this.pr != null && hwVar.hw()) {
                    aj.hw().post(new Runnable() { // from class: com.byazt.ak.hw.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.byazt.cy.pr prVar = hw.this.pr;
                            if (prVar != null) {
                                prVar.pr(hwVar.hw(), null);
                            }
                        }
                    });
                }
                if (hwVar.hw()) {
                    hw.this.zo = true;
                } else {
                    hw.this.pr(hwVar.x());
                }
                try {
                    hw.this.pr(hwVar, j);
                } catch (JSONException e) {
                }
            }
        }
    };
    public final Handler hw = new Handler(aj.pr().getLooper());

    public hw(int i, String str, String str2) {
        this.c = i;
        this.uc = str;
        this.fw = str2;
        k kVarIa = a.hw().ia();
        if (kVarIa == null) {
            return;
        }
        long jC = kVarIa.c();
        this.k = jC;
        this.w = jC;
        this.m = kVarIa.uc();
        zo.nt().pr(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float aj() {
        int i = -1;
        try {
            Context context = a.getContext();
            if (context != null) {
                i = Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
            }
        } catch (Throwable th) {
        }
        if (i < 0) {
            return -1.0f;
        }
        return Math.round((i / 255.0f) * 10.0f) / 10.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (TextUtils.equals("no_data", jSONObject.optString("noise_module"))) {
                long j = this.w * 2;
                this.w = j;
                this.w = Math.min(j, 2000L);
            } else {
                this.w = this.k;
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = this.w - (jCurrentTimeMillis - this.hn);
        if (j2 < 0) {
            j2 = 0;
        }
        this.hn = jCurrentTimeMillis;
        if (this.zo || !this.aj) {
            return;
        }
        if (this.vk) {
            this.g = j2;
            this.ho = 0L;
        } else {
            pr(j2);
        }
    }

    private void pr(long j) {
        long jMax = Math.max(j, 0L);
        this.g = jMax;
        this.ho = System.currentTimeMillis() + jMax;
        this.hw.removeCallbacks(this.nt);
        this.hw.postDelayed(this.nt, jMax);
    }

    @Override // com.byazt.ak.hn
    public void pr(int i, int i2, int i3, int i4) {
        this.x = pr.hw().pr(i, i2, i3, i4);
    }

    public void pr(com.byazt.cy.pr prVar) {
        if (prVar == null) {
            return;
        }
        this.pr = prVar;
    }

    public void c() {
        k kVarIa;
        if (this.zo || this.aj || !x.fw().hn() || (kVarIa = a.hw().ia()) == null || !kVarIa.hn(this.c)) {
            return;
        }
        this.aj = true;
        this.vk = false;
        this.g = this.m;
        this.hn = System.currentTimeMillis();
        pr(this.m);
        cz.pr(this.uc, Boolean.FALSE, Boolean.class);
    }

    public void uc() {
        if (!this.aj || this.zo || this.vk) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.ho;
        if (j > jCurrentTimeMillis) {
            this.g = j - jCurrentTimeMillis;
        } else {
            this.g = 0L;
        }
        this.vk = true;
        this.ho = 0L;
        this.hw.removeCallbacks(this.nt);
    }

    public void fw() {
        if (!this.aj || this.zo || !this.vk) {
            return;
        }
        this.vk = false;
        this.hn = System.currentTimeMillis();
        if (this.g <= 0) {
            this.g = this.w;
        }
        pr(this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(x.hw hwVar, long j) throws JSONException {
        String strOptString;
        JSONObject jSONObjectPr = pr(this.fw);
        if (jSONObjectPr == null) {
            return;
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectPr.optJSONArray("cost_time");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONObjectPr.putOpt("cost_time", jSONArrayOptJSONArray);
        }
        jSONArrayOptJSONArray.put(j);
        if (!hwVar.hw()) {
            JSONObject jSONObjectX = hwVar.x();
            if (jSONObjectX != null) {
                String strOptString2 = jSONObjectX.optString("noise_module");
                if (!TextUtils.isEmpty(strOptString2)) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectPr.optJSONObject("noise_module");
                    if (jSONObjectOptJSONObject == null) {
                        jSONObjectOptJSONObject = new JSONObject();
                        jSONObjectPr.putOpt("noise_module", jSONObjectOptJSONObject);
                    }
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(strOptString2);
                    if (jSONArrayOptJSONArray2 == null) {
                        jSONArrayOptJSONArray2 = new JSONArray();
                        try {
                            jSONObjectOptJSONObject.putOpt(strOptString2, jSONArrayOptJSONArray2);
                        } catch (JSONException e) {
                        }
                    }
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectX.optJSONObject("noise_detail");
                    if (jSONObjectOptJSONObject2 == null) {
                        strOptString = String.valueOf(System.currentTimeMillis());
                    } else {
                        strOptString = jSONObjectOptJSONObject2.optString("ts");
                    }
                    jSONArrayOptJSONArray2.put(strOptString);
                } else {
                    jSONObjectPr.putOpt("is_close", Integer.valueOf(hwVar.pr()));
                    if (hwVar.hn() > 0.0d) {
                        cz.pr(this.uc, Boolean.TRUE, Boolean.class);
                        JSONArray jSONArrayOptJSONArray3 = jSONObjectPr.optJSONArray("close_desire");
                        if (jSONArrayOptJSONArray3 == null) {
                            jSONArrayOptJSONArray3 = new JSONArray();
                            jSONObjectPr.putOpt("close_desire", jSONArrayOptJSONArray3);
                        }
                        jSONArrayOptJSONArray3.put(hwVar.hn());
                    }
                }
            }
        } else {
            cz.pr(this.uc, Boolean.TRUE, Boolean.class);
            JSONObject jSONObjectX2 = hwVar.x();
            if (jSONObjectX2 != null) {
                Iterator<String> itKeys = jSONObjectX2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        if (!next.equals("noise_module")) {
                            jSONObjectPr.put(next, jSONObjectX2.get(next));
                        }
                    } catch (JSONException e2) {
                    }
                }
            }
            jSONObjectPr.put("listner", this.pr != null);
            jSONObjectPr.put("stop", this.zo);
        }
        jSONObjectPr.put("task_call_ts", System.currentTimeMillis());
        jSONObjectPr.put("task_call_ets", SystemClock.elapsedRealtime());
    }

    public static JSONObject pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object objX = com.byazt.qd.hw.x(str, 3);
        if (objX instanceof JSONObject) {
            return (JSONObject) objX;
        }
        JSONObject jSONObject = new JSONObject();
        com.byazt.qd.hw.pr(str, 3, jSONObject);
        return jSONObject;
    }

    public void zo() {
        this.zo = true;
        this.aj = false;
        this.vk = false;
        this.g = 0L;
        this.ho = 0L;
        this.pr = null;
        this.hw.removeCallbacksAndMessages(null);
        zo.nt().hw(this);
    }

    @Override // com.byazt.wt.pr.hw
    public void pr() {
        uc();
    }

    @Override // com.byazt.wt.pr.hw
    public void hw() {
        fw();
    }

    @Override // com.byazt.wt.pr.hw
    public void hn() {
    }

    @Override // com.byazt.wt.pr.hw
    public void x() {
    }
}
