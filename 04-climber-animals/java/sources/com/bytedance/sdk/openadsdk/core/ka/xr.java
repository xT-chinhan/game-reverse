package com.bytedance.sdk.openadsdk.core.ka;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.nw.x;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final HashMap<String, ms> f2815ms = new HashMap<>();

    public static ms ms(String str, x.xr xrVar) {
        if (TextUtils.isEmpty(str)) {
            return new ms(xrVar);
        }
        HashMap<String, ms> map = f2815ms;
        ms msVar = map.get(str);
        if (msVar != null) {
            return msVar;
        }
        ms msVar2 = new ms(xrVar);
        map.put(str, msVar2);
        return msVar2;
    }

    public static class ms {
        private int d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private long f2816ms = 0;
        private int xr = 0;
        private int ah = 0;

        public ms(x.xr xrVar) {
            this.d = xrVar.hi();
        }

        public void ms(x.xr xrVar) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (xrVar.c() > 0) {
                if (jCurrentTimeMillis - this.f2816ms < xrVar.c()) {
                    this.xr++;
                    this.d += xrVar.ab();
                }
                this.f2816ms = jCurrentTimeMillis;
            }
            if (xrVar.x() > 0) {
                int i = this.ah + 1;
                this.ah = i;
                if (i > xrVar.x()) {
                    this.d += xrVar.ny();
                }
            }
        }

        public void xr(x.xr xrVar) {
            this.ah = 0;
            this.xr = 0;
            this.d += xrVar.ch();
            this.d = Math.min(xrVar.hi(), this.d);
        }

        public int ms(int i, x.xr xrVar) {
            int i2 = this.d - i;
            if (i2 < 0) {
                return 0;
            }
            LinkedHashMap<Integer, Integer> linkedHashMapSl = xrVar.sl();
            int i3 = -1;
            if (linkedHashMapSl == null) {
                return -1;
            }
            for (Map.Entry<Integer, Integer> entry : linkedHashMapSl.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                if (entry.getValue().intValue() + i2 <= 0 && iIntValue > i3) {
                    i3 = iIntValue;
                }
            }
            return i3;
        }

        public void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final x.xr xrVar2, final String str, final String str2) {
            u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.ka.xr.ms.1
                @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
                public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("slot_type", Integer.valueOf(xrVar.t()));
                    jSONObject.putOpt("rit", xrVar.d());
                    jSONObject.putOpt(MediationConstant.KEY_REASON, str);
                    jSONObject.putOpt("reason_value", str2);
                    jSONObject.putOpt("freq_count", Integer.valueOf(ms.this.xr));
                    jSONObject.putOpt("continuous_count", Integer.valueOf(ms.this.ah));
                    jSONObject.putOpt("score", Integer.valueOf(ms.this.d));
                    jSONObject.putOpt("score_threshold", Integer.valueOf(xrVar2.d()));
                    return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("load_score_cache").xr(jSONObject.toString());
                }
            }, "load_score_cache");
        }
    }
}
