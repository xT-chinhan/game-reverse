package com.bytedance.sdk.openadsdk.core.op;

import android.os.Build;
import com.bytedance.sdk.openadsdk.core.ah.d;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.op.ms.ah;
import com.bytedance.sdk.openadsdk.core.op.ms.xr;
import com.bytedance.sdk.openadsdk.core.re;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static ms f3228ms = new ms();
    private volatile int xr = -1;
    private volatile long ah = 0;
    private volatile long d = 0;

    private ms() {
    }

    public static ms ms() {
        return f3228ms;
    }

    public long xr() {
        return this.ah;
    }

    public long ah() {
        return this.d;
    }

    public void ms(long j, long j2) {
        this.ah = j;
        this.d = j2;
    }

    public void d() {
        JSONObject jSONObjectQr = re.xr().qr();
        if (jSONObjectQr == null) {
            this.xr = 1;
        }
        if (ms(jSONObjectQr)) {
            new ah().ms(jSONObjectQr, this.xr);
        } else if (xr(jSONObjectQr)) {
            new xr().ms(jSONObjectQr, this.xr);
        } else {
            this.xr = 1;
        }
    }

    public boolean ka() {
        return this.xr == 0 || this.xr == 3;
    }

    public boolean ms(String str) {
        String str2 = Build.MANUFACTURER;
        String str3 = Build.BRAND;
        if (str2 != null && str3 != null) {
            return str2.equalsIgnoreCase(str) || str3.equalsIgnoreCase(str);
        }
        if (str2 != null) {
            return str2.equalsIgnoreCase(str);
        }
        if (str3 != null) {
            return str3.equalsIgnoreCase(str);
        }
        return false;
    }

    public int c() {
        if (!ch.ub().ka()) {
            return 0;
        }
        if (this.xr == -1) {
            int iT = d.ms().t();
            if (iT == -1) {
                if (re.xr().qr() == null) {
                    this.xr = 1;
                } else {
                    this.xr = 2;
                }
            } else {
                this.xr = iT;
            }
        }
        return this.xr;
    }

    public void ms(int i) {
        if (this.xr != i) {
            d.ms().c(i);
        }
        this.xr = i;
    }

    public boolean ms(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("register")) != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                if (ms(jSONArrayOptJSONArray.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean xr(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("callback")) != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                if (ms(jSONArrayOptJSONArray.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
