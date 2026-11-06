package com.bytedance.sdk.openadsdk.core.jw;

import android.os.SystemClock;
import android.text.TextUtils;
import com.taptap.sdk.db.constant.Common;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile xr f2749ms;
    private com.bytedance.sdk.component.d.ms.xr ab;
    private com.bytedance.sdk.component.d.ms.xr ch;
    private com.bytedance.sdk.component.d.ms.xr ny;
    private com.bytedance.sdk.component.d.ms.xr x;
    private volatile int hi = 0;
    private int sl = 0;
    private int zb = 0;
    private final Map<String, Integer> xr = new HashMap();
    private final ConcurrentHashMap<String, Integer> ah = new ConcurrentHashMap<>();
    private final Map<String, Long> d = new HashMap();
    private final ConcurrentHashMap<String, Long> ka = new ConcurrentHashMap<>();
    private final long c = SystemClock.elapsedRealtime();

    private xr() {
    }

    public static xr ms() {
        if (f2749ms == null) {
            synchronized (xr.class) {
                if (f2749ms == null) {
                    f2749ms = new xr();
                }
            }
        }
        return f2749ms;
    }

    public void ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Integer num = this.xr.get(str);
        this.xr.put(str, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
        this.ka.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
        if (this.ka.size() > 1) {
            this.sl++;
        }
        xr(str);
    }

    public void xr(final String str) {
        com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.xr.1
            @Override // java.lang.Runnable
            public void run() {
                xr.this.d().ms(str, xr.this.d().xr(str, 0) + 1);
                if (xr.this.hi == 0) {
                    xr xrVar = xr.this;
                    xrVar.hi = xrVar.ab().xr("histRunningCount", 0) + 1;
                    xr.this.ab().ms("histRunningCount", xr.this.hi);
                }
            }
        });
    }

    public void ah(String str) {
        if (TextUtils.isEmpty(str) || !this.ka.containsKey(str)) {
            return;
        }
        long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.ka.remove(str).longValue()) / 1000;
        if (jElapsedRealtime >= 0) {
            Long l = this.d.get(str);
            if (l == null || l.longValue() < 0) {
                l = 0L;
            }
            this.d.put(str, Long.valueOf(l.longValue() + jElapsedRealtime));
            ms(str, jElapsedRealtime);
        }
    }

    public void ms(final String str, final long j) {
        com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.xr.2
            @Override // java.lang.Runnable
            public void run() {
                long jXr = xr.this.c().xr(str, 0L);
                xr.this.c().ms(str, (jXr >= 0 ? jXr : 0L) + j);
                xr.this.ah();
                xr.this.ms(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(long j) {
        int i = this.zb;
        if (i == 0) {
            try {
                Map<String, ?> all = c().getAll();
                if (all != null) {
                    Iterator<?> it = all.values().iterator();
                    while (it.hasNext()) {
                        this.zb = (int) (((long) this.zb) + ((Long) it.next()).longValue());
                    }
                }
            } catch (Throwable unused) {
                this.zb = -1;
            }
        } else {
            this.zb = (int) (((long) i) + j);
        }
        re.ms(this.zb, this.hi);
    }

    public void xr() {
        if (this.ka.size() == 1) {
            for (String str : this.ka.keySet()) {
                Integer num = this.ah.get(str);
                this.ah.put(str, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
                d(str);
            }
        }
    }

    public void d(final String str) {
        com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.xr.3
            @Override // java.lang.Runnable
            public void run() {
                xr.this.ka().ms(str, xr.this.ka().xr(str, 0) + 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah() {
        try {
            Map<String, ?> all = d().getAll();
            if (all == null) {
                return;
            }
            Iterator<?> it = all.values().iterator();
            int iIntValue = 0;
            while (it.hasNext()) {
                iIntValue += ((Integer) it.next()).intValue();
            }
            if (iIntValue != 0 && iIntValue % 75 == 0) {
                final JSONArray jSONArray = new JSONArray();
                for (String str : this.xr.keySet()) {
                    Integer num = this.xr.get(str);
                    Long l = this.d.get(str);
                    Integer num2 = this.ah.get(str);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(Common.System.NAME, str);
                        jSONObject.put("rc", num != null ? num.intValue() : 0);
                        jSONObject.put("ft", l != null ? l.longValue() : 0L);
                        jSONObject.put("asc", num2 != null ? num2.intValue() : 0);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.sl.ms(e);
                    }
                }
                final JSONArray jSONArray2 = new JSONArray();
                Map<String, ?> all2 = c().getAll();
                Map<String, ?> all3 = ka().getAll();
                if (all2 != null && all3 != null) {
                    for (String str2 : all.keySet()) {
                        Integer num3 = (Integer) all.get(str2);
                        Long l2 = (Long) all2.get(str2);
                        Integer num4 = (Integer) all3.get(str2);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(Common.System.NAME, str2);
                            jSONObject2.put("rc", num3 != null ? num3.intValue() : 0);
                            jSONObject2.put("ft", l2 != null ? l2.longValue() : 0L);
                            jSONObject2.put("asc", num4 != null ? num4.intValue() : 0);
                            jSONArray2.put(jSONObject2);
                        } catch (JSONException e2) {
                            com.bytedance.sdk.component.utils.sl.ms(e2);
                        }
                    }
                }
                final long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.c) / 1000;
                com.bytedance.sdk.openadsdk.core.t.u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.jw.xr.4
                    @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
                    public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("ara", jSONArray);
                        jSONObject3.put("hara", jSONArray2);
                        jSONObject3.put("rt", jElapsedRealtime);
                        jSONObject3.put("hrc", xr.this.hi);
                        jSONObject3.put("drc", xr.this.sl);
                        return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("ad_activity_record").xr(jSONObject3.toString());
                    }
                }, "ad_activity_record");
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.d.ms.xr d() {
        if (this.ab == null) {
            this.ab = g.ms("activity_resume_count");
        }
        return this.ab;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.d.ms.xr ka() {
        if (this.x == null) {
            this.x = g.ms("activity_adshow_count");
        }
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.d.ms.xr c() {
        if (this.ny == null) {
            this.ny = g.ms("activity_foreground_time");
        }
        return this.ny;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.d.ms.xr ab() {
        if (this.ch == null) {
            this.ch = g.ms("activity_recorder");
        }
        return this.ch;
    }
}
