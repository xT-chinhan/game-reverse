package com.bytedance.sdk.openadsdk.core.ka.xr;

import android.text.TextUtils;
import com.anythink.core.common.m.e;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private lm ab;
    private c c;
    private int hi;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final AtomicBoolean f2821ms = new AtomicBoolean(false);
    private final AtomicBoolean xr = new AtomicBoolean(false);
    private int ah = -1;
    private long d = -1;
    private long x = -1;
    private long ny = -1;
    private long ch = -1;
    private Runnable sl = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ka.xr.ms.1
        @Override // java.lang.Runnable
        public void run() {
            if (ms.this.xr.get()) {
                return;
            }
            ms.this.f2821ms.set(true);
            ms.this.d(100003L);
        }
    };

    public ms(int i) {
        this.hi = i;
    }

    public void ms() {
        this.c = null;
        x.ah().removeCallbacks(this.sl);
    }

    public void ms(long j) {
        this.x = j;
    }

    public void xr(long j) {
        this.ny = j;
    }

    private void ah(long j) {
        this.ch = j;
    }

    public long ms(lm lmVar, c cVar) {
        this.c = cVar;
        this.ab = lmVar;
        xr(lmVar, cVar);
        return this.ah;
    }

    private void xr(lm lmVar, c cVar) {
        JSONObject jSONObjectBr = lmVar.br();
        if (jSONObjectBr == null) {
            ms(-1);
            xr();
            return;
        }
        boolean z = false;
        int iOptInt = jSONObjectBr.optInt("cache_correct_type", 0);
        int iOptInt2 = jSONObjectBr.optInt("is_need_cache_correct", 0);
        boolean z2 = jSONObjectBr.optInt("is_need_cache_check", 0) == 1;
        if (iOptInt == 0) {
            ms(0);
            xr();
            return;
        }
        if (!TextUtils.isEmpty(lmVar.sd())) {
            ms(1);
            xr();
            return;
        }
        if (iOptInt2 == 0) {
            if (z2) {
                ms(3);
                ah(lmVar, cVar);
                return;
            } else {
                ms(2);
                d(100002L);
                return;
            }
        }
        long jOptLong = jSONObjectBr.optLong("creative_check_duration", 0L);
        if (jOptLong > 0) {
            if (Math.abs((System.currentTimeMillis() / 1000) - f.sl(lmVar)) <= jOptLong) {
                z = true;
            }
        }
        if (z) {
            if (!z2) {
                ms(4);
                d(100002L);
                return;
            } else {
                ms(6);
                ah(lmVar, cVar);
                return;
            }
        }
        if (!z2) {
            ms(5);
            d(lmVar, cVar);
        } else {
            ms(7);
            ka(lmVar, cVar);
        }
    }

    private void ah(lm lmVar, c cVar) {
        ms(1, lmVar, cVar);
    }

    private void d(lm lmVar, c cVar) {
        ms(2, lmVar, cVar);
    }

    private void ka(lm lmVar, c cVar) {
        ms(3, lmVar, cVar);
    }

    private void ms(final int i, final lm lmVar, c cVar) {
        JSONObject jSONObjectBr = lmVar.br();
        long jOptLong = jSONObjectBr == null ? 0L : jSONObjectBr.optLong("correct_interface_timeout", 0L);
        if (jOptLong > 0) {
            x.ah().postDelayed(this.sl, jOptLong);
        }
        re.ms().ms(ms(i, lmVar), new xr<ka>() { // from class: com.bytedance.sdk.openadsdk.core.ka.xr.ms.2
            @Override // com.bytedance.sdk.openadsdk.core.ka.xr.xr
            public void ms(ka kaVar, long j, long j2) {
                try {
                    ms.this.ms(i, lmVar, kaVar, j);
                } catch (Exception e) {
                    sl.ms(e);
                    e.getMessage();
                }
            }
        });
    }

    private JSONObject ms(int i, lm lmVar) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(ms(lmVar, i));
            jSONObject.put("ads", jSONArray);
            jSONObject.put("check_type", i);
        } catch (JSONException e) {
            e.getMessage();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, lm lmVar, ka kaVar, long j) throws JSONException {
        if (this.f2821ms.get()) {
            return;
        }
        this.xr.set(true);
        if (kaVar == null || kaVar.ms()) {
            ms(false, j);
            return;
        }
        if (j != 20000) {
            d(100001L);
            return;
        }
        String strMs = ka.ms(lmVar.df(), lmVar.eu());
        JSONObject jSONObject = TextUtils.isEmpty(strMs) ? null : kaVar.xr.get(strMs);
        if (jSONObject == null) {
            d(100004L);
            return;
        }
        if (jSONObject.has("is_valid")) {
            if (jSONObject.optBoolean("is_valid")) {
                if (i == 2 || i == 3) {
                    String strOptString = jSONObject.optString("ext");
                    String strOptString2 = jSONObject.optString("media_ext");
                    if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                        d(100006L);
                        return;
                    } else {
                        lmVar.nw(strOptString);
                        lmVar.ms(ms(new JSONObject(strOptString2), lmVar.ou()));
                    }
                }
                ms(true, 100000L);
                return;
            }
            this.ka = jSONObject.optString(MediationConstant.KEY_REASON);
            ms(false, 100007L);
            return;
        }
        d(100005L);
    }

    public static Map<String, Object> ms(JSONObject jSONObject, Map<String, Object> map) {
        if (jSONObject == null) {
            return map;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, jSONObject.opt(next));
            }
        }
        return map;
    }

    private JSONObject ms(lm lmVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strDf = lmVar.df();
            String strLx = lmVar.lx();
            Map<String, Object> mapOu = lmVar.ou();
            String string = "";
            if (mapOu != null) {
                JSONObject jSONObject2 = new JSONObject();
                Set<Map.Entry<String, Object>> setEntrySet = mapOu.entrySet();
                if (!setEntrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : setEntrySet) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                if (jSONObject2.length() > 0) {
                    string = jSONObject2.toString();
                }
            }
            ms(strDf, strLx, string, lmVar.eu(), i, jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void ms(String str, String str2, String str3, String str4, int i, JSONObject jSONObject) throws JSONException {
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        StringBuilder sb = new StringBuilder("id=");
        sb.append(str).append("&timestamp=").append(iCurrentTimeMillis).append("&ext=").append(str2).append("&media_ext=").append(str3).append("&req_id=").append(str4);
        String upperCase = com.bytedance.sdk.component.utils.ka.xr(sb.toString()).toUpperCase();
        jSONObject.put("id", str);
        jSONObject.put("timestamp", iCurrentTimeMillis);
        jSONObject.put("ext", str2);
        jSONObject.put("media_ext", str3);
        jSONObject.put("req_id", str4);
        jSONObject.put(e.X, upperCase);
    }

    private void ms(boolean z, long j) {
        this.d = j;
        ah();
        lm lmVar = this.ab;
        c cVar = this.c;
        if (cVar != null) {
            cVar.ms(z, j);
        }
        ms(lmVar);
        ms();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        this.d = j;
        ah();
        lm lmVar = this.ab;
        c cVar = this.c;
        if (cVar != null) {
            cVar.xr();
        }
        ms(lmVar);
        ms();
    }

    private void xr() {
        ah();
        lm lmVar = this.ab;
        c cVar = this.c;
        if (cVar != null) {
            cVar.ms();
        }
        ms(lmVar);
        ms();
    }

    private void ms(int i) {
        this.ah = i;
    }

    private void ah() {
        lm lmVar = this.ab;
        if (lmVar != null) {
            lmVar.ab(this.ah);
            lmVar.x(this.d);
        }
    }

    private void ms(lm lmVar) {
        ah(System.currentTimeMillis());
        JSONObject jSONObject = new JSONObject();
        try {
            String strXr = f.xr(this.hi);
            long j = this.ny;
            long j2 = this.x;
            jSONObject.put("cache_get_duration", j - j2 < 0 ? -1L : j - j2);
            long j3 = this.ch;
            long j4 = this.ny;
            jSONObject.put("network_check_duration", j3 - j4 < 0 ? -1L : j3 - j4);
            long j5 = this.ch;
            long j6 = this.x;
            jSONObject.put("cache_total_duration", j5 - j6 < 0 ? -1L : j5 - j6);
            jSONObject.put("correct_action_code", this.ah);
            jSONObject.put("correct_result_code", this.d);
            jSONObject.put("cache_loss_reason", this.ka);
            if (lmVar != null) {
                jSONObject.put("creative_check_duration", lmVar.br() != null ? lmVar.br().optLong("creative_check_duration", 0L) : -1L);
            }
            com.bytedance.sdk.openadsdk.core.zb.ah.xr(lmVar, strXr, jSONObject);
        } catch (Exception unused) {
        }
    }
}
