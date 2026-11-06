package com.bytedance.sdk.openadsdk.core.yu.ms;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.ny.xr.d;
import com.bytedance.sdk.component.ny.xr.ka;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.b;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ny {
    private ms() {
        super("PluginSettingsFetchTask");
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.yu.ms.ms$ms, reason: collision with other inner class name */
    private static class C0328ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static final ms f3804ms = new ms();
    }

    public static ms ah() {
        return C0328ms.f3804ms;
    }

    public void d() {
        if (u.ms(re.getContext())) {
            ab.xr(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        ka kaVarXr = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().xr();
        kaVarXr.ms(f.ny("/api/ad/union/sdk/settings/plugins"));
        kaVarXr.xr("User-Agent", f.ab());
        kaVarXr.ms(com.bytedance.sdk.component.utils.ms.ms(ka()));
        kaVarXr.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.yu.ms.ms.1
            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                if (xrVar == null || !xrVar.x() || TextUtils.isEmpty(xrVar.d())) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(xrVar.d());
                    if (jSONObject.optInt("cypher") == 3) {
                        String strAh = com.bytedance.sdk.component.utils.ms.ah(jSONObject.optString("message"));
                        if (TextUtils.isEmpty(strAh)) {
                            return;
                        }
                        xr.ms().ms(new JSONObject(strAh).optJSONArray("plugins"));
                    }
                } catch (JSONException unused) {
                }
            }

            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(d dVar, IOException iOException) {
                try {
                    Iterator<String> itKeys = ch.ub().of().keys();
                    while (itKeys.hasNext()) {
                        xr.ms().ms(itKeys.next(), 1007);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private JSONObject ka() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oaid", b.ms(false));
            jSONObject.put("conn_type", u.xr(re.getContext()));
            jSONObject.put("os", 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("sdk_version", g.ah);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "6.9.2.3");
            jSONObject.put("package_name", f.ch());
            jSONObject.put("app_version", f.sl());
            jSONObject.put("app_code", f.hi());
            jSONObject.put("vendor", Build.MANUFACTURER);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            String strT = ch.ub().t();
            jSONObject.put("ts", jCurrentTimeMillis);
            jSONObject.put("app_id", strT);
            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.ka.xr(strT != null ? strT.concat(String.valueOf(jCurrentTimeMillis)).concat(g.ah) : ""));
            jSONObject.put("channel", g.c);
            jSONObject.put("applog_did", c.ms().ah());
            jSONObject.put("imei", t.ab());
            jSONObject.put("source", 1);
            jSONObject.put("device_abi", Build.SUPPORTED_ABIS[0]);
            jSONObject.put("plugins", c());
            jSONObject.put("csj_type", ch.ub().lm() ? 1 : 0);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONObject c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectOf = ch.ub().of();
        boolean zDv = re.xr().dv();
        if (jSONObjectOf != null) {
            Iterator<String> itKeys = jSONObjectOf.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next)) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectOf.optJSONObject(next);
                    if (jSONObjectOptJSONObject != null) {
                        jSONObjectOptJSONObject.put("plugin_update_network", ch.ub().i().ms(next));
                    }
                    if (zDv && next.equals("com.byted.live.lite")) {
                        jSONObject.putOpt(xr.xr(), jSONObjectOptJSONObject);
                    } else {
                        jSONObject.putOpt(next, jSONObjectOptJSONObject);
                    }
                }
            }
        }
        return jSONObject;
    }
}
