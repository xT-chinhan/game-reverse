package com.bytedance.sdk.component.ny.ah;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private static final Object d = new Object();
    private boolean ah;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f1277ms;
    private ah xr = new ah();

    public d(Context context, boolean z, int i) {
        this.f1277ms = context;
        this.ah = z;
        this.ka = i;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00a9  */
    public void ms(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (!this.ah) {
            com.bytedance.sdk.component.ny.d.ah.xr("TNCConfigHandler", "handleConfigChanged: no mainProc");
            return;
        }
        ab.ms().ms(this.ka).ka();
        try {
            boolean z = jSONObject.optInt("ttnet_url_dispatcher_enabled", 0) > 0;
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ttnet_dispatch_actions");
            if (ab.ms().ms(this.ka).ah() && z && jSONArrayOptJSONArray != null) {
                ArrayList<JSONObject> arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject3 = ((JSONObject) jSONArrayOptJSONArray.get(i)).getJSONObject("param");
                    if (jSONObject3.optString("service_name", "").equals("idc_selection")) {
                        arrayList.add(jSONObject3.getJSONObject("strategy_info"));
                    }
                }
                if (arrayList.isEmpty()) {
                    jSONObject2 = null;
                } else {
                    jSONObject2 = new JSONObject();
                    for (JSONObject jSONObject4 : arrayList) {
                        Iterator<String> itKeys = jSONObject4.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            jSONObject2.put(next, jSONObject4.getString(next));
                        }
                    }
                }
            } else {
                jSONObject2 = null;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("tnc_config");
            if (jSONObjectOptJSONObject == null && jSONObject2 == null) {
                com.bytedance.sdk.component.ny.d.ah.ms("TNCConfigHandler", " tnc host_replace_map config is null");
            } else if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
                jSONObjectOptJSONObject.put("host_replace_map", jSONObject2);
            } else if (jSONObject2 != null) {
                jSONObjectOptJSONObject.put("host_replace_map", jSONObject2);
            }
            ah ahVarXr = xr(jSONObjectOptJSONObject);
            com.bytedance.sdk.component.ny.d.ah.xr("TNCConfigHandler", "handleConfigChanged, newConfig: " + (ahVarXr == null ? AbstractJsonLexerKt.NULL : ahVarXr.toString()));
            if (ahVarXr == null) {
                synchronized (d) {
                    com.bytedance.sdk.openadsdk.api.plugin.xr.xr(this.f1277ms, ab.ms().ms(this.ka).ms(), 0).edit().putString("tnc_config_str", "").apply();
                    com.bytedance.sdk.component.ny.d.d.ms(this.f1277ms, 1, "", this.ka);
                }
            } else {
                this.xr = ahVarXr;
                String string = jSONObjectOptJSONObject.toString();
                synchronized (d) {
                    com.bytedance.sdk.openadsdk.api.plugin.xr.xr(this.f1277ms, ab.ms().ms(this.ka).ms(), 0).edit().putString("tnc_config_str", string).apply();
                    com.bytedance.sdk.component.ny.d.d.ms(this.f1277ms, 1, string, this.ka);
                }
            }
        } catch (Throwable th) {
            try {
                sl.ms(th);
                this.xr = new ah();
            } finally {
                synchronized (d) {
                    com.bytedance.sdk.openadsdk.api.plugin.xr.xr(this.f1277ms, ab.ms().ms(this.ka).ms(), 0).edit().putString("tnc_config_str", "").apply();
                    com.bytedance.sdk.component.ny.d.d.ms(this.f1277ms, 1, "", this.ka);
                }
            }
        }
    }

    public void ms() {
        if (this.ah) {
            String string = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(this.f1277ms, ab.ms().ms(this.ka).ms(), 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                com.bytedance.sdk.component.ny.d.ah.xr("TNCConfigHandler", "loadLocalConfig: no existed");
                return;
            }
            try {
                ah ahVarXr = xr(new JSONObject(string));
                if (ahVarXr != null) {
                    this.xr = ahVarXr;
                }
                com.bytedance.sdk.component.ny.d.ah.xr("TNCConfigHandler", "loadLocalConfig: " + (ahVarXr == null ? AbstractJsonLexerKt.NULL : ahVarXr.toString()));
            } catch (Throwable th) {
                sl.ms(th);
                com.bytedance.sdk.component.ny.d.ah.xr("TNCConfigHandler", "loadLocalConfig: except: " + th.getMessage());
            }
        }
    }

    public void xr() {
        try {
            String strMs = com.bytedance.sdk.component.ny.d.d.ms(this.f1277ms, 1, this.ka);
            if (TextUtils.isEmpty(strMs)) {
                com.bytedance.sdk.component.ny.d.ah.xr("TNCConfigHandler", "loadLocalConfigForOtherProcess, data empty");
                return;
            }
            ah ahVarXr = xr(new JSONObject(strMs));
            com.bytedance.sdk.component.ny.d.ah.xr("TNCConfigHandler", "loadLocalConfigForOtherProcess, config: " + (ahVarXr == null ? AbstractJsonLexerKt.NULL : ahVarXr.toString()));
            if (ahVarXr != null) {
                this.xr = ahVarXr;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.ny.d.ah.xr("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        }
    }

    public ah ah() {
        return this.xr;
    }

    private ah xr(JSONObject jSONObject) {
        try {
            ah ahVar = new ah();
            if (jSONObject.has("local_enable")) {
                ahVar.f1275ms = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                ahVar.xr = jSONObject.getInt("probe_enable") != 0;
            }
            if (jSONObject.has("local_host_filter")) {
                JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                HashMap map = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string)) {
                            map.put(string, 0);
                        }
                    }
                }
                ahVar.ah = map;
            } else {
                ahVar.ah = null;
            }
            if (jSONObject.has("host_replace_map")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                HashMap map2 = new HashMap();
                if (jSONObject2.length() > 0) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String string2 = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                            map2.put(next, string2);
                        }
                    }
                }
                ahVar.d = map2;
            } else {
                ahVar.d = null;
            }
            ahVar.ka = jSONObject.optInt("req_to_cnt", ahVar.ka);
            ahVar.c = jSONObject.optInt("req_to_api_cnt", ahVar.c);
            ahVar.ab = jSONObject.optInt("req_to_ip_cnt", ahVar.ab);
            ahVar.x = jSONObject.optInt("req_err_cnt", ahVar.x);
            ahVar.ny = jSONObject.optInt("req_err_api_cnt", ahVar.ny);
            ahVar.ch = jSONObject.optInt("req_err_ip_cnt", ahVar.ch);
            ahVar.hi = jSONObject.optInt("update_interval", ahVar.hi);
            ahVar.sl = jSONObject.optInt("update_random_range", ahVar.sl);
            ahVar.zb = jSONObject.optString("http_code_black", ahVar.zb);
            return ahVar;
        } catch (Throwable th) {
            sl.ms(th);
            return null;
        }
    }
}
