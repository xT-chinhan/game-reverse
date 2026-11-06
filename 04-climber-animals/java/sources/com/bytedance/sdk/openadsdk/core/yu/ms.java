package com.bytedance.sdk.openadsdk.core.yu;

import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.live.ka.xr;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.op.ab;
import com.bytedance.sdk.openadsdk.op.hi;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final int f3800ms;

    public int d() {
        return 2;
    }

    public ms(int i) {
        this.f3800ms = i;
    }

    public ms(int i, boolean z) {
        this.f3800ms = i;
        x.ms().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.yu.ms.1
            @Override // java.lang.Runnable
            public void run() {
                ms.this.c();
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ab.ms(new ny("csj-plugin-check") { // from class: com.bytedance.sdk.openadsdk.core.yu.ms.2
            @Override // java.lang.Runnable
            public void run() {
                if (ms.this.xr() == 5) {
                    xr.ms();
                }
            }
        });
    }

    public int ms(int i) {
        int i2 = this.f3800ms >> i;
        int i3 = i2 & 7;
        if (i3 == 0) {
            return d();
        }
        return ((i2 & 8) >> 3) == 1 ? -i3 : i3;
    }

    public int ms() {
        return ms(0);
    }

    public int xr() {
        return ms(4);
    }

    public int ah() {
        return ms(8);
    }

    public int ms(String str) {
        if ("com.byted.live.lite".equals(str)) {
            if (re.xr().it()) {
                return xr();
            }
            return 4;
        }
        if ("com.byted.csj.ext".equals(str)) {
            return ah();
        }
        if ("com.byted.pangle".equals(str)) {
            return ms();
        }
        return d();
    }

    public void ka() {
        JSONObject jSONObjectKz = re.xr().kz();
        if (jSONObjectKz == null) {
            return;
        }
        try {
            ms(jSONObjectKz, "com.byted.live.lite", 4, true);
            ms(jSONObjectKz, "com.byted.csj.ext", 8, true);
            ms(jSONObjectKz, "com.byted.mixed", 0, true);
            ms(jSONObjectKz, "com.byted.pangle", 0, false);
        } catch (Throwable th) {
            sl.xr("onReceiveServerStatus", th);
        }
    }

    private void ms(JSONObject jSONObject, String str, int i, boolean z) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        int iOptInt = jSONObjectOptJSONObject.optInt("state", 2);
        if (iOptInt == 5) {
            int iXr = hi.xr(str);
            int iAh = hi.ah(str);
            int iD = hi.d(str);
            if (z || iAh > iD) {
                String strOptString = jSONObjectOptJSONObject.optString("api_rule", "=");
                String strOptString2 = jSONObjectOptJSONObject.optString("plugin_rule", "=");
                int iOptInt2 = jSONObjectOptJSONObject.optInt("api_v", 0);
                int iOptInt3 = jSONObjectOptJSONObject.optInt("plugin_v", 0);
                if (ms(iXr, iOptInt2, strOptString) && ms(iAh, iOptInt3, strOptString2)) {
                    hi.ms(str);
                    return;
                }
                return;
            }
            return;
        }
        if (iOptInt == -1 && ms(i) == 5 && hi.ah(str) > hi.d(str)) {
            hi.ms(str);
        }
    }

    private boolean ms(int i, int i2, String str) {
        str.hashCode();
        switch (str) {
            case "<":
                return i < i2;
            case "=":
            case "==":
                return i == i2;
            case ">":
                return i > i2;
            case "<=":
                return i <= i2;
            case ">=":
                return i >= i2;
            default:
                return false;
        }
    }

    public String toString() {
        return String.valueOf(this.f3800ms);
    }
}
