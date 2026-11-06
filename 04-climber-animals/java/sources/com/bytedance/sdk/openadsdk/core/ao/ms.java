package com.bytedance.sdk.openadsdk.core.ao;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.c.b;
import com.anythink.core.common.e.g;
import com.bytedance.sdk.openadsdk.core.hi.ah.sl;
import com.bytedance.sdk.openadsdk.core.hi.ah.ub;
import com.bytedance.sdk.openadsdk.core.hi.ah.x;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.c;
import com.bytedance.sdk.openadsdk.core.nw.ce;
import com.bytedance.sdk.openadsdk.core.nw.h;
import com.bytedance.sdk.openadsdk.core.nw.ka;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.nw;
import com.taptap.sdk.db.constant.Common;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements ah {
    private boolean ah;
    private com.bytedance.sdk.openadsdk.core.hi.xr.ms c;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final lm f1982ms;
    private final xr xr;
    private final Map<String, com.bytedance.sdk.openadsdk.core.hi.xr.d> d = new HashMap();
    private boolean ka = true;
    private boolean ab = false;

    private ms(xr xrVar, lm lmVar, boolean z) {
        this.xr = xrVar;
        this.f1982ms = lmVar;
        this.ah = z;
    }

    public static ms ms(xr xrVar, lm lmVar, boolean z) {
        return new ms(xrVar, lmVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ao.ah
    public void ms() {
        for (com.bytedance.sdk.openadsdk.core.hi.xr.d dVar : this.d.values()) {
            if (dVar != null) {
                dVar.x();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ao.ah
    public void xr() {
        Iterator<com.bytedance.sdk.openadsdk.core.hi.xr.d> it = this.d.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ao.ah
    public void ah() {
        xr();
        for (com.bytedance.sdk.openadsdk.core.hi.xr.d dVar : this.d.values()) {
            if (dVar != null) {
                dVar.ny();
            }
        }
        this.d.clear();
    }

    public static lm ms(lm lmVar, JSONObject jSONObject, String str) {
        String strOptString;
        boolean z;
        lm lmVarMs;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        if (jSONObject != null) {
            strOptString = jSONObject.optString("download_url");
            z = true;
        } else {
            strOptString = "";
            z = false;
        }
        if (TextUtils.isEmpty(strOptString)) {
            z = false;
        }
        boolean z2 = (lmVar.zh() == null || lmVar.zh().xr() == null || !lmVar.zh().xr().equals(strOptString)) ? z : false;
        if (jSONObject != null && (jSONObjectOptJSONObject2 = jSONObject.optJSONObject("download_config_json")) != null && !jSONObjectOptJSONObject2.optBoolean("has_valid_download_url", true)) {
            z2 = true;
        }
        if (z2) {
            lmVarMs = new lm();
            lmVarMs.d(lmVar.ka());
            lmVarMs.g(lmVar.oy());
            lmVarMs.cv(lmVar.dv());
            lmVarMs.g(jSONObject.optInt("lp_down_rule"));
            lmVarMs.p(4);
            lmVarMs.t(jSONObject.optString("id"));
            lmVarMs.zb(jSONObject.optString("source"));
            ka kaVar = new ka();
            kaVar.d(jSONObject.optString(g.a.g));
            kaVar.ah(jSONObject.optString(Common.System.NAME));
            kaVar.xr(strOptString);
            lmVarMs.ms(kaVar);
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("download_config_json");
            if (jSONObjectOptJSONObject3 != null) {
                lmVarMs.ms(new nw(jSONObjectOptJSONObject3));
                if (!jSONObjectOptJSONObject3.optBoolean("has_valid_download_url", true)) {
                    lmVarMs.ch(true);
                }
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("app_manage_json");
            if (jSONObjectOptJSONObject4 != null) {
                c cVarPh = lmVarMs.ph();
                if (cVarPh == null) {
                    cVarPh = new c();
                }
                cVarPh.ms(jSONObjectOptJSONObject4.optInt("score"));
                cVarPh.ms(jSONObjectOptJSONObject4.optJSONArray("creative_tags"));
                lmVarMs.ms(cVarPh);
                lmVarMs.sl(jSONObjectOptJSONObject4.toString());
                com.bytedance.sdk.openadsdk.core.nw.g gVarQd = lmVarMs.qd();
                if (gVarQd == null) {
                    gVarQd = new com.bytedance.sdk.openadsdk.core.nw.g();
                }
                gVarQd.ms(jSONObjectOptJSONObject4.optString("icon_url"));
                lmVarMs.ms(gVarQd);
                lmVarMs.qv(jSONObjectOptJSONObject4.optString(b.a.f));
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("app_manage_type_json");
            if (jSONObjectOptJSONObject5 != null) {
                lmVarMs.cv(jSONObjectOptJSONObject5.optInt("app_manage_type"));
            }
            int iOptInt = jSONObject.optInt("live_interaction_type");
            String strOptString2 = jSONObject.optString("live_room_id");
            if (iOptInt > 0 && !TextUtils.isEmpty(strOptString2)) {
                lmVarMs.v(iOptInt);
                lmVarMs.pc(strOptString2);
            }
            lmVarMs.s(jSONObject.optInt("ad_type"));
            ce ceVarMs = ce.ms(jSONObject.optJSONObject("wc_miniapp_info"));
            if (ceVarMs != null) {
                lmVarMs.ms(ceVarMs);
            }
            String strOptString3 = jSONObject.optString("quick_app_url");
            if (!TextUtils.isEmpty(strOptString3)) {
                ka kaVarZh = lmVarMs.zh() != null ? lmVarMs.zh() : new ka();
                kaVarZh.ms(strOptString3);
                lmVarMs.ms(kaVarZh);
            }
        } else {
            lmVarMs = com.bytedance.sdk.openadsdk.core.ms.ms(lmVar.rm());
        }
        if (!TextUtils.isEmpty(str)) {
            lmVarMs.nw(str);
        }
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("deep_link")) != null) {
            h hVar = new h();
            if (lmVar.tc() != null) {
                hVar.ms(lmVar.tc());
            }
            hVar.ms(new h(jSONObjectOptJSONObject));
            lmVarMs.ms(hVar);
        }
        return lmVarMs;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ao.ah
    public void ms(Context context, JSONObject jSONObject, String str, int i, boolean z, boolean z2) {
        JSONObject jSONObjectOptJSONObject;
        if (context == null || jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        lm lmVarMs = ms(this.f1982ms, jSONObjectOptJSONObject, str);
        ms(context, lmVarMs, jSONObjectOptJSONObject, i, z ? ub.ms(lmVarMs) : 0, z2);
    }

    private void ms(Context context, lm lmVar, JSONObject jSONObject, int i, int i2, boolean z) {
        if (context == null || lmVar == null || lmVar.zh() == null || jSONObject == null || this.xr == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.hi.xr.d dVar = this.d.get(lmVar.zh().xr());
        if (dVar != null) {
            dVar.ms(i2);
            return;
        }
        String strMs = f.ms(i);
        if (TextUtils.isEmpty(strMs)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.hi.xr.d dVarMs = ms(context, lmVar, jSONObject, strMs);
        dVarMs.ms(i2);
        if (dVarMs instanceof com.bytedance.sdk.openadsdk.core.hi.ah.c) {
            ((com.bytedance.sdk.openadsdk.core.hi.ah.c) dVarMs).ah(z);
        }
        this.d.put(lmVar.zh().xr(), dVarMs);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ao.ah
    public void ms(Context context, JSONObject jSONObject, String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        if (context == null || jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        ms(context, ms(this.f1982ms, jSONObjectOptJSONObject, str2), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void ms(Context context, lm lmVar, String str) {
        if (context == 0 || lmVar == null) {
            return;
        }
        if (lmVar.zh() == null) {
            com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVarXr = com.bytedance.sdk.openadsdk.core.hi.ka.xr(context, lmVar, str, false);
            if (ahVarXr instanceof x) {
                ((x) ahVarXr).ah(this.ah);
            }
            ahVarXr.ms(lmVar, false);
        } else {
            final String strDf = lmVar.df();
            com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = (com.bytedance.sdk.openadsdk.core.hi.xr.d) this.d.get(lmVar.zh().xr());
            if (ahVar != null) {
                ahVar.xr(this.ab);
                if (ahVar instanceof x) {
                    ((x) ahVar).hi().ms(this.ka);
                } else if (ahVar instanceof sl) {
                    ((sl) ahVar).xr().ms(this.ka);
                }
                ahVar.ms(lmVar, false);
                ahVar.ms(new com.bytedance.sdk.openadsdk.core.hi.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.ao.ms.1
                    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                    public void ms() {
                        C0265ms.ms(strDf, 1, 0);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                    public void ms(long j, long j2, String str2, String str3) {
                        if (j > 0) {
                            C0265ms.ms(strDf, 3, (int) ((j2 * 100) / j));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                    public void xr(long j, long j2, String str2, String str3) {
                        if (j > 0) {
                            C0265ms.ms(strDf, 2, (int) ((j2 * 100) / j));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                    public void ah(long j, long j2, String str2, String str3) {
                        if (j > 0) {
                            C0265ms.ms(strDf, 4, (int) ((j2 * 100) / j));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                    public void ms(long j, String str2, String str3) {
                        C0265ms.ms(strDf, 5, 100);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                    public void ms(String str2, String str3) {
                        C0265ms.ms(strDf, 6, 100);
                    }
                });
            }
        }
        if (context instanceof com.bytedance.sdk.openadsdk.core.x.xr) {
            ((com.bytedance.sdk.openadsdk.core.x.xr) context).ms(1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ao.ah
    public void ms(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        ms(ms(this.f1982ms, jSONObjectOptJSONObject, (String) null), jSONObjectOptJSONObject);
    }

    private void ms(lm lmVar, JSONObject jSONObject) {
        if (this.xr == null || lmVar == null || lmVar.zh() == null) {
            return;
        }
        String strXr = lmVar.zh().xr();
        if (this.d.containsKey(strXr)) {
            com.bytedance.sdk.openadsdk.core.hi.xr.d dVarRemove = this.d.remove(strXr);
            if (dVarRemove != null) {
                try {
                    dVarRemove.ny();
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                    return;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("message", "success");
            jSONObject2.put("status", "unsubscribed");
            jSONObject2.put("appad", jSONObject);
            this.xr.ms("app_ad_event", jSONObject2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ao.ah
    public void xr(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || this.xr == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.hi.xr.d dVar = this.d.get(ms(this.f1982ms, jSONObjectOptJSONObject, (String) null).zh().xr());
        if (dVar != null) {
            dVar.ab();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ao.ah
    public void ms(boolean z) {
        this.ka = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ao.ah
    public void ms(String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.hi.xr.d dVar;
        if (TextUtils.isEmpty(str) || (dVar = this.d.get(str)) == null) {
            return;
        }
        dVar.c(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ao.ah
    public void xr(boolean z) {
        this.ab = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.bytedance.sdk.openadsdk.core.hi.xr.d ms(Context context, lm lmVar, final JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.hi.xr.d dVarXr = com.bytedance.sdk.openadsdk.core.hi.ka.xr(context, lmVar, str, false);
        if (dVarXr instanceof x) {
            ((x) dVarXr).ah(this.ah);
        }
        dVarXr.ms(new com.bytedance.sdk.openadsdk.core.hi.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.ao.ms.2
            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms() {
                ms("status", "idle");
                if (ms.this.c == null) {
                    return;
                }
                ms.this.c.ms();
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms(long j, long j2, String str2, String str3) {
                ms("status", "download_active", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (ms.this.c == null) {
                    return;
                }
                ms.this.c.ms(j, j2, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void xr(long j, long j2, String str2, String str3) {
                ms("status", "download_paused", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (ms.this.c == null) {
                    return;
                }
                ms.this.c.xr(j, j2, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ah(long j, long j2, String str2, String str3) {
                ms("status", "download_failed", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (ms.this.c == null) {
                    return;
                }
                ms.this.c.ah(j, j2, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms(long j, String str2, String str3) {
                ms("status", "download_finished", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j));
                if (ms.this.c == null) {
                    return;
                }
                ms.this.c.ms(j, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms(String str2, String str3) {
                ms("status", "installed");
                if (ms.this.c == null) {
                    return;
                }
                ms.this.c.ms(str2, str3);
            }

            private void ms(String... strArr) {
                if (strArr == null || strArr.length % 2 != 0) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("message", "success");
                    jSONObject2.put("appad", jSONObject);
                    for (int i = 0; i < strArr.length; i += 2) {
                        jSONObject2.put(strArr[i], strArr[i + 1]);
                    }
                    ms.this.xr.ms("app_ad_event", jSONObject2);
                } catch (JSONException unused) {
                }
            }
        });
        dVarXr.ms(new com.bytedance.sdk.openadsdk.core.hi.xr.d.ms() { // from class: com.bytedance.sdk.openadsdk.core.ao.ms.3
        });
        return dVarXr;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ao.ms$ms, reason: collision with other inner class name */
    public static class C0265ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static ConcurrentHashMap<String, JSONObject> f1986ms = new ConcurrentHashMap<>();

        public static synchronized JSONObject ms(String str) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            ConcurrentHashMap<String, JSONObject> concurrentHashMap = f1986ms;
            if (concurrentHashMap == null) {
                return new JSONObject();
            }
            JSONObject jSONObject = concurrentHashMap.get(str);
            if (jSONObject != null) {
                return jSONObject;
            }
            return new JSONObject();
        }

        public static synchronized void ms(String str, int i, int i2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (f1986ms == null) {
                f1986ms = new ConcurrentHashMap<>();
            }
            JSONObject jSONObject = f1986ms.get(str);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
                f1986ms.put(str, jSONObject);
            }
            try {
                jSONObject.put("downloadStatus", i);
                jSONObject.put("downloadProcessRate", i2);
                jSONObject.put("code", 0);
                jSONObject.put("codeMsg", "get ad_down_load_id success");
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
        }
    }
}
