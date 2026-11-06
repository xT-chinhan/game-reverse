package com.bytedance.sdk.openadsdk.core.live;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.g.ny;
import com.bytedance.sdk.openadsdk.core.live.ms.ab;
import com.bytedance.sdk.openadsdk.core.live.ms.d;
import com.bytedance.sdk.openadsdk.core.live.ms.ka;
import com.bytedance.sdk.openadsdk.core.nw.az;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.xr.ms.ms.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final d f2847ms;

    private xr() {
        if (!ny.ms()) {
            this.f2847ms = new com.bytedance.sdk.openadsdk.core.live.ms.xr();
            return;
        }
        if (g.ka) {
            this.f2847ms = new ab();
        } else if (g.c()) {
            this.f2847ms = new ka();
        } else {
            this.f2847ms = new com.bytedance.sdk.openadsdk.core.live.ms.xr();
        }
    }

    private static final class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static final xr f2849ms = new xr();
    }

    public static final xr ms() {
        return ms.f2849ms;
    }

    public void ms(Bridge bridge) {
        this.f2847ms.ms(bridge);
    }

    public int ms(Context context, lm lmVar, Map<String, Object> map) {
        if (context == null || lmVar == null) {
            return 5;
        }
        return this.f2847ms.ms(context, lmVar, map);
    }

    public void ms(String str, boolean z) {
        this.f2847ms.ms(str, z);
    }

    public int ms(lm lmVar, com.bytedance.sdk.openadsdk.core.live.ms.ah ahVar, String str) {
        return this.f2847ms.ms(lmVar, ahVar, str);
    }

    public int ms(c cVar) {
        if (cVar == null) {
            return 5;
        }
        HashMap map = new HashMap(2);
        map.put("event_tag", cVar.hi());
        map.put("reward_countdown", Long.valueOf(cVar.ub()));
        return xr(cVar.getContext(), cVar.xr(), map);
    }

    public int xr(Context context, lm lmVar, Map<String, Object> map) {
        return this.f2847ms.xr(context, lmVar, map);
    }

    public boolean ms(lm lmVar) {
        return this.f2847ms.ms(lmVar);
    }

    public void ms(String str, lm lmVar, long j) {
        this.f2847ms.ms(str, lmVar, j);
    }

    public boolean xr(lm lmVar) {
        if (lmVar == null || TextUtils.isEmpty(lmVar.eo())) {
            return false;
        }
        return ms(lmVar.eo(), lmVar.ku());
    }

    public boolean ms(String str, int i) {
        return this.f2847ms.ms(str, i);
    }

    public void xr() {
        this.f2847ms.ms();
    }

    public int ah() {
        return this.f2847ms.xr();
    }

    public int ah(lm lmVar) {
        if (re.xr().tf()) {
            return this.f2847ms.b_(lmVar);
        }
        return 0;
    }

    public void d() {
        this.f2847ms.d();
    }

    public int ka() {
        return this.f2847ms.ka();
    }

    public void d(final lm lmVar) {
        if (lmVar == null) {
            return;
        }
        ka(lmVar);
        if (TextUtils.isEmpty(lmVar.eo())) {
            return;
        }
        int iAh = com.bytedance.sdk.openadsdk.core.ah.d.ms().ah() + 1;
        if (iAh > 100) {
            iAh = 100;
        }
        com.bytedance.sdk.openadsdk.core.ah.d.ms().ms(iAh);
        final int iAh2 = ah();
        final int iKa = ka();
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime();
        if (lmVar.ku() == 1 && lmVar.cn() == 1) {
            com.bytedance.sdk.openadsdk.core.t.xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.live.xr.1
                @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
                public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("ext", lmVar.lx());
                        jSONObject.put("live_sdk_status", iAh2);
                        jSONObject.put("live_auth_status", iKa);
                        jSONObject.put("app_start_time", jElapsedRealtime);
                        jSONObject.put("is_web", lmVar.ms());
                    } catch (Throwable unused) {
                    }
                    return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("saas_miss").xr(jSONObject.toString());
                }
            }, "saas_miss", true);
        }
    }

    public int c() {
        return com.bytedance.sdk.openadsdk.core.ah.d.ms().ah();
    }

    public String ab() {
        return this.f2847ms.ab();
    }

    public void ms(View view, az azVar, Map<String, Object> map, Map<String, Object> map2) {
        Object tag;
        if (view == null || azVar == null || (tag = view.getTag(TTAdConstant.KEY_CLICK_AREA)) == null || !(tag instanceof Integer)) {
            return;
        }
        int iIntValue = ((Integer) tag).intValue();
        int i = iIntValue & 255;
        int i2 = (iIntValue & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8;
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (i == 101 && !azVar.ah()) {
            i = 102;
        }
        map.put("live_saas_param_interaction_type", Integer.valueOf(i));
        map2.put("click_saas_area", Integer.valueOf(i2));
    }

    public JSONObject x() {
        return this.f2847ms.x();
    }

    public int ms(String str) {
        return this.f2847ms.ms(str);
    }

    public int ms(com.bytedance.sdk.openadsdk.core.live.xr.xr xrVar, boolean z) {
        return this.f2847ms.ms(xrVar, z);
    }

    public void ka(lm lmVar) {
        this.f2847ms.d(lmVar);
    }

    public void ms(com.bytedance.sdk.openadsdk.ub.d dVar) {
        this.f2847ms.ms(dVar);
    }

    public long ny() {
        return this.f2847ms.ah();
    }
}
