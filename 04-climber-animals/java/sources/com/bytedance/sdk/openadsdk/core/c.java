package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.tapsdk.tapad.e.a;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private AtomicBoolean ah;
    private final AtomicBoolean d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile String f2025ms;
    private String xr;

    private static final class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final c f2032ms = new c();
    }

    public String ab() {
        return "unionser_slardar_applog";
    }

    public String c() {
        return "164362";
    }

    private c() {
        this.f2025ms = null;
        this.xr = null;
        this.ah = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        ms(re.getContext());
    }

    private void ms(Context context) {
        final com.bytedance.sdk.openadsdk.core.f.ka kaVarAo = ch.ub().ao();
        com.bytedance.embedapplog.x xVar = new com.bytedance.embedapplog.x("164362", "unionser_slardar_applog");
        if (kaVarAo != null) {
            boolean zAh = kaVarAo.ah();
            xVar.xr(zAh);
            if (!zAh) {
                xVar.xr(kaVarAo.ny());
            }
            xVar.ms(kaVarAo.d());
            if (g.xr >= 4600) {
                xVar.ah(kaVarAo.c());
                if (g.c() && g.xr >= 4900) {
                    xVar.ms(kaVarAo.sl());
                }
            }
        }
        xVar.d(!com.bytedance.sdk.openadsdk.core.d.ms.ah());
        xVar.ms(new com.bytedance.embedapplog.ab() { // from class: com.bytedance.sdk.openadsdk.core.c.1
            @Override // com.bytedance.embedapplog.ab
            public String ms() {
                com.bytedance.sdk.openadsdk.core.f.ka kaVar = kaVarAo;
                if (kaVar == null || kaVar.d()) {
                    return com.bytedance.sdk.openadsdk.ub.xr.ms();
                }
                return null;
            }

            @Override // com.bytedance.embedapplog.ab
            public String ms(Context context2) {
                return com.bytedance.sdk.component.utils.h.xr(context2);
            }

            @Override // com.bytedance.embedapplog.ab
            public String xr() {
                return t.re();
            }

            @Override // com.bytedance.embedapplog.ab
            public boolean ah() {
                return re.xr().p();
            }

            @Override // com.bytedance.embedapplog.ab
            public boolean d() {
                return com.bytedance.sdk.openadsdk.core.jw.ub.ms();
            }

            @Override // com.bytedance.embedapplog.ab
            public Looper ka() {
                return com.bytedance.sdk.component.utils.x.ms().getLooper();
            }

            @Override // com.bytedance.embedapplog.ab
            public Looper c() {
                return com.bytedance.sdk.component.utils.x.ms().getLooper();
            }

            @Override // com.bytedance.embedapplog.ab
            public String ms(String str) {
                return com.bytedance.sdk.openadsdk.core.jw.w.xr(str);
            }

            @Override // com.bytedance.embedapplog.ab
            public JSONObject ms(JSONObject jSONObject) {
                if (jSONObject != null) {
                    JSONArray jSONArrayX = com.bytedance.sdk.openadsdk.core.jw.ch.x();
                    try {
                        if (jSONArrayX.length() != 0) {
                            jSONObject.put("ipv6_list", jSONArrayX);
                        }
                    } catch (Exception unused) {
                    }
                }
                return jSONObject;
            }
        });
        xVar.xr(0);
        x();
        com.bytedance.embedapplog.ms.ms(context, xVar);
        HashMap map = new HashMap();
        String strT = ch.ub().t();
        map.put("host_appid", TextUtils.isEmpty(strT) ? "164362" : strT);
        map.put("is_plugin", Boolean.valueOf(g.ms()));
        map.put("sdk_version", "6.9.2.3");
        map.put(PluginConstants.KEY_PLUGIN_VERSION, "6.9.2.3");
        map.put("sdk_api_version", g.ah);
        map.put("channel", g.ka());
        if (re.xr().qv()) {
            map.put("use_apm_sdk", "1");
        }
        com.bytedance.embedapplog.ms.ms((HashMap<String, Object>) map);
    }

    private void x() {
        final boolean zX = ch.ub().x();
        boolean zNy = ch.ub().ny();
        com.bytedance.embedapplog.ms.ms(zX && !zNy);
        final boolean zHi = ch.ub().hi();
        com.bytedance.embedapplog.ms.ms(new com.bytedance.embedapplog.ka() { // from class: com.bytedance.sdk.openadsdk.core.c.2
            @Override // com.bytedance.embedapplog.ka
            public void ms(com.bytedance.embedapplog.ka.ms msVar) {
                if (msVar != null) {
                    com.bytedance.sdk.openadsdk.core.jw.b.ms(msVar.f497ms);
                }
                if (zHi || !zX || c.this.ah.get()) {
                    return;
                }
                c.this.ms(new com.bytedance.sdk.openadsdk.ub.d(msVar));
            }
        });
        if (zNy) {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.ms(new com.bytedance.sdk.openadsdk.ub.d(com.bytedance.sdk.openadsdk.core.jw.b.ah(com.bytedance.sdk.openadsdk.core.jw.b.ms(false))));
                }
            });
        } else {
            if (zHi || !zX) {
                return;
            }
            com.bytedance.sdk.component.utils.x.ms().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.4
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ah.get()) {
                        return;
                    }
                    c.this.ms(new com.bytedance.sdk.openadsdk.ub.d("timeout"));
                }
            }, a.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.ub.d dVar) {
        this.ah.set(true);
        com.bytedance.sdk.openadsdk.core.jw.b.ms(dVar);
    }

    public static c ms() {
        return ms.f2032ms;
    }

    public void xr() {
        if (ch.ub().ny()) {
            if (this.d.get()) {
                return;
            }
            this.d.set(true);
            new com.bytedance.sdk.openadsdk.core.d.xr("acquire_od").ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.6
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.d != null) {
                        c.this.d.set(false);
                    }
                }
            }).xr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.5
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.embedapplog.ms.ms(ch.ub().x());
                    com.bytedance.embedapplog.ms.ms();
                    if (c.this.d != null) {
                        c.this.d.set(false);
                    }
                }
            });
            return;
        }
        com.bytedance.embedapplog.ms.ms(ch.ub().x());
        com.bytedance.embedapplog.ms.ms();
    }

    public String ah() {
        if (TextUtils.isEmpty(this.f2025ms)) {
            this.f2025ms = com.bytedance.embedapplog.ms.x();
            com.bytedance.sdk.openadsdk.tools.xr.ah(16, this.f2025ms);
            com.bytedance.sdk.openadsdk.core.ah.d.ms().sl(this.f2025ms == null ? "" : this.f2025ms);
        }
        return this.f2025ms;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String d() {
        if (TextUtils.isEmpty(this.xr)) {
            this.xr = com.bytedance.embedapplog.ms.ch();
        }
        return this.xr;
    }

    public String ka() {
        return (String) com.bytedance.embedapplog.ms.ms(com.tapsdk.tapad.internal.tracker.experiment.a.b, "");
    }

    public void ms(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        com.bytedance.embedapplog.ms.xr(str, jSONObject);
    }

    public static void xr(String str, JSONObject jSONObject) {
        com.bytedance.embedapplog.ms.ms(str, jSONObject);
    }
}
