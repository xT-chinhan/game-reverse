package com.bytedance.sdk.openadsdk.core.jw;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    private static boolean ms(int i) {
        return i == 3 || i == 7 || i == 8;
    }

    public static void ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar, int i, int i2) {
        if (msVar == null || msVar.xr() == null || i2 <= 0) {
            return;
        }
        List<com.bytedance.sdk.openadsdk.core.nw.lm> listXr = msVar.xr();
        int size = listXr.size();
        try {
            com.bytedance.sdk.component.d.ms.xr xrVarMs = g.ms(i + "_prefetch");
            delete(i, i2, xrVarMs, size);
            for (com.bytedance.sdk.openadsdk.core.nw.lm lmVar : listXr) {
                String strP = lmVar.p();
                String strXr = com.bytedance.sdk.component.utils.ms.xr(lmVar.rm().toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pre_fetch_time", System.currentTimeMillis());
                jSONObject.put("message", strXr);
                xrVarMs.ms(strP, jSONObject.toString());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }

    private static void delete(int i, int i2, com.bytedance.sdk.component.d.ms.xr xrVar, int i3) {
        JSONObject jSONObject;
        if (xrVar == null) {
            return;
        }
        try {
            Map<String, ?> all = xrVar.getAll();
            if (all != null && all.size() != 0) {
                int size = all.size();
                if (ms(i)) {
                    if (size > 1) {
                        xrVar.ms();
                        return;
                    }
                    return;
                }
                if (i3 >= i2) {
                    xrVar.ms();
                    return;
                }
                int i4 = size + i3;
                if (i4 > i2) {
                    PriorityQueue priorityQueue = new PriorityQueue();
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        String str = (String) entry.getValue();
                        if (str != null && str.contains("pre_fetch_time")) {
                            jSONObject = new JSONObject(str);
                        } else {
                            jSONObject = str != null ? new JSONObject(com.bytedance.sdk.component.utils.ms.ah(str)) : null;
                        }
                        if (jSONObject != null) {
                            priorityQueue.add(new ms(entry.getKey(), jSONObject.optLong("pre_fetch_time")));
                        }
                    }
                    int size2 = priorityQueue.size();
                    int i5 = i4 - i2;
                    if (size2 == 0 || size2 < i5) {
                        xrVar.ms();
                        return;
                    }
                    for (int i6 = 0; i6 < i5; i6++) {
                        ms msVar = (ms) priorityQueue.poll();
                        if (msVar != null) {
                            xrVar.ms(msVar.xr);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static com.bytedance.sdk.openadsdk.core.nw.lm ms(String str, int i) {
        if (com.bytedance.sdk.openadsdk.core.re.xr().g() <= 0) {
            return null;
        }
        com.bytedance.sdk.component.d.ms.xr xrVarMs = g.ms(i + "_prefetch");
        String strXr = xrVarMs.xr(str, (String) null);
        if (!TextUtils.isEmpty(strXr)) {
            try {
                if (strXr.contains("pre_fetch_time")) {
                    strXr = new JSONObject(strXr).optString("message");
                }
                com.bytedance.sdk.openadsdk.core.nw.lm lmVarMs = com.bytedance.sdk.openadsdk.core.ms.ms(new JSONObject(com.bytedance.sdk.component.utils.ms.ah(strXr)));
                xrVarMs.ms(str);
                return lmVarMs;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    static class ms implements Comparable<ms> {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private long f2708ms;
        private String xr;

        public ms(String str, long j) {
            this.xr = str;
            this.f2708ms = j;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public int compareTo(ms msVar) {
            if (msVar == null) {
                return 1;
            }
            long j = this.f2708ms;
            long j2 = msVar.f2708ms;
            if (j > j2) {
                return 1;
            }
            return j == j2 ? 0 : -1;
        }
    }
}
