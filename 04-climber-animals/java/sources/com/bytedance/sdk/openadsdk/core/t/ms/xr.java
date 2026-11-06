package com.bytedance.sdk.openadsdk.core.t.ms;

import android.os.Build;
import android.text.TextUtils;
import com.anythink.basead.c.b;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.core.t.ms.xr;
import com.tapsdk.tapad.constants.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr<T extends xr> implements ms {
    private String ah;
    private String ch;
    private String hi;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3315ms;
    private String sl;
    private String u;
    private String ub;
    private String x;
    private String xr;
    private String zb;
    private String d = g.ah;
    private long c = System.currentTimeMillis() / 1000;
    private int ab = 0;
    private int ny = 0;

    private T qv() {
        return this;
    }

    public static xr<xr> xr() {
        return new xr<>();
    }

    @Override // com.bytedance.sdk.openadsdk.core.t.ms.ms
    public JSONObject ms() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(getType())) {
                jSONObject.put("type", getType());
            }
            if (!TextUtils.isEmpty(d())) {
                jSONObject.put("rit", d());
            }
            if (!TextUtils.isEmpty(ka())) {
                jSONObject.put("creative_id", ka());
            }
            if (!TextUtils.isEmpty(c())) {
                jSONObject.put("ad_sdk_version", c());
            }
            if (!TextUtils.isEmpty(x())) {
                jSONObject.put("app_version", x());
            } else {
                jSONObject.put("app_version", f.sl());
            }
            if (ny() > 0) {
                jSONObject.put("timestamp", ny());
            }
            if (ch() > 0) {
                jSONObject.put("adtype", ch());
            }
            if (!TextUtils.isEmpty(hi())) {
                jSONObject.put("req_id", hi());
            }
            jSONObject.put("error_code", sl());
            if (!TextUtils.isEmpty(zb())) {
                jSONObject.put("error_msg", zb());
            }
            if (!TextUtils.isEmpty(u())) {
                jSONObject.put("extra", u());
            }
            if (!TextUtils.isEmpty(ub())) {
                jSONObject.put(b.a.h, ub());
            }
            if (!TextUtils.isEmpty(ah())) {
                jSONObject.put("event_extra", ah());
            }
            if (!TextUtils.isEmpty(ab())) {
                jSONObject.put("duration", ab());
            }
            if (!TextUtils.isEmpty(ch.ub().t())) {
                jSONObject.put("appid", ch.ub().t());
            }
            if (!TextUtils.isEmpty(ao())) {
                jSONObject.put(Constants.p.a, ao());
            }
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "6.9.2.3");
            jSONObject.put("is_plugin", g.ms());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("conn_type", u.xr(re.getContext()));
        } catch (Exception e) {
            sl.ms(e);
        }
        try {
            jSONObject.put(com.anythink.basead.webtemplet.a.b.c.d, h());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", 1);
            com.bytedance.sdk.openadsdk.ub.xr.xr(re.getContext(), jSONObject);
            jSONObject.put("oaid", com.bytedance.sdk.openadsdk.core.jw.b.ms(false));
            jSONObject.put("model", t.re());
            jSONObject.put("android_id", t.c());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("package_name", f.ch());
            jSONObject.put("ua", f.ab());
            jSONObject.put("applog_did", c.ms().ah());
            jSONObject.put("ip", com.bytedance.sdk.openadsdk.core.jw.ch.c());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String getType() {
        return this.f3315ms;
    }

    public T ms(String str) {
        this.f3315ms = str;
        return (T) qv();
    }

    public String ah() {
        return this.zb;
    }

    public T xr(String str) {
        this.zb = str;
        return (T) qv();
    }

    public String d() {
        return this.xr;
    }

    public T ah(String str) {
        this.xr = str;
        return (T) qv();
    }

    public String ka() {
        return this.ah;
    }

    public T d(String str) {
        this.ah = str;
        return (T) qv();
    }

    public String c() {
        return this.d;
    }

    public String ab() {
        return this.u;
    }

    public T ka(String str) {
        this.u = str;
        return (T) qv();
    }

    public String x() {
        return this.ka;
    }

    public long ny() {
        return this.c;
    }

    public T ms(long j) {
        this.c = j;
        return (T) qv();
    }

    public int ch() {
        return this.ab;
    }

    public T ms(int i) {
        this.ab = i;
        return (T) qv();
    }

    public String hi() {
        return this.x;
    }

    public T c(String str) {
        this.x = str;
        return (T) qv();
    }

    public int sl() {
        return this.ny;
    }

    public T xr(int i) {
        this.ny = i;
        return (T) qv();
    }

    public String zb() {
        return this.ch;
    }

    public T ab(String str) {
        this.ch = str;
        return (T) qv();
    }

    public String u() {
        return this.hi;
    }

    public T x(String str) {
        this.hi = str;
        return (T) qv();
    }

    public String ub() {
        return this.sl;
    }

    public String ao() {
        return this.ub;
    }

    public T ny(String str) {
        this.ub = str;
        return (T) qv();
    }
}
