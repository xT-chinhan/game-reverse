package com.bytedance.sdk.component.x.xr.c;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.e.m;
import com.bytedance.sdk.component.utils.sl;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements xr {
    private com.bytedance.sdk.component.x.ms.ka ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Context f1547ms;
    private final ka xr;

    public ah(ka kaVar, com.bytedance.sdk.component.x.ms.ka kaVar2) {
        this.f1547ms = kaVar2.getContext();
        this.xr = kaVar;
        this.ah = kaVar2;
    }

    public Context getContext() {
        Context context = this.f1547ms;
        return context == null ? this.ah.getContext() : context;
    }

    @Override // com.bytedance.sdk.component.x.xr.c.xr
    public void ms(String str, List<String> list, boolean z, Map<String, String> map, JSONObject jSONObject) {
        com.bytedance.sdk.component.x.ms.d dVarD = this.ah.d();
        if (dVarD == null || this.ah.getContext() == null || dVarD.c() == null || !dVarD.ka() || list == null || list.size() == 0) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            dVarD.c().execute(new ms(new d(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), it.next(), z, 5, jSONObject, 1), str, map));
        }
    }

    @Override // com.bytedance.sdk.component.x.xr.c.xr
    public void ms(final String str) {
        com.bytedance.sdk.component.x.ms.d dVarD = this.ah.d();
        if (dVarD == null || this.ah.getContext() == null || !dVarD.ka()) {
            return;
        }
        com.bytedance.sdk.component.x.xr.ka.xr xrVar = new com.bytedance.sdk.component.x.xr.ka.xr("trackFailedUrls") { // from class: com.bytedance.sdk.component.x.xr.c.ah.1
            @Override // java.lang.Runnable
            public void run() {
                ah.this.ms(ah.this.xr.ms(), str);
            }
        };
        xrVar.ms(1);
        if (dVarD.c() != null) {
            dVarD.c().execute(xrVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(List<d> list, String str) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.bytedance.sdk.component.x.ms.d dVarD = this.ah.d();
        for (d dVar : list) {
            if (dVarD != null && dVarD.c() != null) {
                dVarD.c().execute(new ms(dVar, str, null));
            }
        }
    }

    private class ms extends com.bytedance.sdk.component.x.xr.ka.xr {
        private final String ah;
        private final Map<String, String> d;
        private final d xr;

        private ms(d dVar, String str, Map<String, String> map) {
            super("AdsStats");
            this.xr = dVar;
            this.ah = str;
            this.d = map;
        }

        private String ah(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.contains("{TS}") || str.contains("__TS__")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                str = str.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace("__TS__", String.valueOf(jCurrentTimeMillis));
            }
            return ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.ah)) ? str.replace("{UID}", this.ah).replace("__UID__", this.ah) : str;
        }

        boolean ms(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("http://") || str.startsWith("https://");
        }

        String xr(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return str.replace("[ss_random]", String.valueOf(ah.xr().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
            } catch (Exception e) {
                sl.ms(e);
                return str;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.x.ms.ms.ka kaVarMs;
            com.bytedance.sdk.component.x.ms.d dVarD = ah.this.ah.d();
            if (dVarD == null || ah.this.ah.getContext() == null || !dVarD.ka()) {
                return;
            }
            if (!ms(this.xr.ah())) {
                d dVar = this.xr;
                ms(null, dVarD, dVar, dVar.ah(), "not http url");
                return;
            }
            if (this.xr.ka() == 0) {
                ah.this.xr.delete(this.xr);
                d dVar2 = this.xr;
                ms(null, dVarD, dVar2, dVar2.ah(), "retry max");
                return;
            }
            try {
                if (this.xr.ka() == 5) {
                    ah.this.xr.insert(this.xr);
                }
                if (!dVarD.ms(ah.this.getContext())) {
                    d dVar3 = this.xr;
                    ms(null, dVarD, dVar3, dVar3.ah(), "no net");
                    return;
                }
                System.currentTimeMillis();
                String strAh = this.xr.ah();
                if (dVarD.x() == 0) {
                    strAh = ah(this.xr.ah());
                    if (this.xr.d()) {
                        strAh = xr(strAh);
                    }
                }
                String str = strAh;
                com.bytedance.sdk.component.x.ms.ms.xr xrVarSl = dVarD.sl();
                if (xrVarSl == null) {
                    ms(null, this.xr, str, "no executor");
                    return;
                }
                xrVarSl.ms("User-Agent", dVarD.hi());
                xrVarSl.ms("csj_client_source_from", "1");
                if (this.d != null) {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.d.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                    xrVarSl.ms("csj_extra_info", jSONObject.toString());
                }
                xrVarSl.ms(str);
                try {
                    kaVarMs = xrVarSl.ms();
                } catch (Throwable unused) {
                    kaVarMs = null;
                }
                if (kaVarMs != null && kaVarMs.ms()) {
                    ah.this.xr.delete(this.xr);
                    com.bytedance.sdk.component.x.ms.ka unused2 = ah.this.ah;
                    System.currentTimeMillis();
                } else {
                    if (kaVarMs != null && kaVarMs.ah() == 8848) {
                        kaVarMs.d();
                        ah.this.xr.delete(this.xr);
                    }
                    com.bytedance.sdk.component.x.ms.ka unused3 = ah.this.ah;
                    d dVar4 = this.xr;
                    dVar4.ms(dVar4.ka() - 1);
                    if (this.xr.ka() == 0) {
                        ah.this.xr.delete(this.xr);
                        com.bytedance.sdk.component.x.ms.ka unused4 = ah.this.ah;
                    } else {
                        ah.this.xr.update(this.xr);
                    }
                    if (kaVarMs != null) {
                        kaVarMs.d();
                        System.currentTimeMillis();
                    } else {
                        System.currentTimeMillis();
                    }
                }
                ms(kaVarMs, dVarD, this.xr, str, null);
            } catch (Throwable unused5) {
            }
        }

        private void ms(com.bytedance.sdk.component.x.ms.ms.ka kaVar, com.bytedance.sdk.component.x.ms.d dVar, d dVar2, String str, String str2) {
            try {
                dVar.ms(this.xr.ms(), ms(kaVar, dVar2, str, str2));
            } catch (Exception e) {
                sl.ms(e);
            }
        }

        private JSONObject ms(com.bytedance.sdk.component.x.ms.ms.ka kaVar, d dVar, String str, String str2) {
            JSONObject jSONObject = new JSONObject();
            if (dVar == null) {
                return jSONObject;
            }
            try {
                jSONObject.put(m.b.h, 5 - dVar.ka());
                JSONObject jSONObjectMs = dVar.ms();
                if (jSONObjectMs != null) {
                    jSONObject.put("track_type", jSONObjectMs.optString("track_type", ""));
                }
                jSONObject.put("url", str);
                jSONObject.put("current", System.currentTimeMillis());
                jSONObject.put("error_msg", str2);
                if (kaVar != null) {
                    jSONObject.put("http_code", kaVar.ah());
                    String strXr = kaVar.xr();
                    if (!TextUtils.isEmpty(strXr)) {
                        if (strXr.length() > 5000) {
                            strXr = strXr.substring(0, 5000);
                        }
                        jSONObject.put("http_response", strXr);
                    }
                    jSONObject.put("success", kaVar.ms() ? 1 : 0);
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Random xr() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }
}
