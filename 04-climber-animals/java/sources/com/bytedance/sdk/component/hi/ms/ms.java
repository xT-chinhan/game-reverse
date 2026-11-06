package com.bytedance.sdk.component.hi.ms;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.hi.d.d;
import com.bytedance.sdk.component.hi.d.ka;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private d ab;
    private com.bytedance.sdk.component.hi.ah.ms ah;
    private d c;
    private int ch = 1;
    private String d;
    private com.bytedance.sdk.component.hi.d.xr hi;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private JSONObject f1241ms;
    private Map<String, Object> ny;
    private String x;
    private Map<String, Object> xr;

    public ms(com.bytedance.sdk.component.hi.ah.ms msVar, JSONObject jSONObject, Map<String, Object> map) {
        this.ah = msVar;
        this.f1241ms = jSONObject;
        this.xr = map;
    }

    public ms(StringBuilder sb, JSONObject jSONObject, Map<String, Object> map) {
        this.f1241ms = jSONObject;
        this.xr = map;
    }

    public Map<String, Object> ms() {
        return this.xr;
    }

    public Map<String, Object> xr() {
        return this.ny;
    }

    public JSONObject ah() {
        return this.f1241ms;
    }

    public void ms(String str) {
        this.ka = str;
    }

    public String d() {
        return this.ka;
    }

    public d ka() {
        return this.c;
    }

    public void ms(d dVar) {
        if (dVar instanceof xr) {
            this.c = dVar;
        } else {
            this.ab = dVar;
        }
    }

    private void x() {
        if (this.ch != 2) {
            com.bytedance.sdk.component.hi.ah.ms msVar = this.ah;
            if (msVar == null) {
                return;
            } else {
                this.x = msVar.xr();
            }
        }
        if (!TextUtils.isEmpty(this.x)) {
            this.d = Uri.parse(this.x).getHost();
        }
        if (!TextUtils.isEmpty(this.d)) {
            String str = this.d.split("/")[0];
            this.d = str;
            int iIndexOf = str.indexOf(":");
            if (iIndexOf == -1) {
                iIndexOf = this.d.length();
            }
            this.d = this.d.substring(0, iIndexOf);
        }
        xr(this.x);
    }

    private void xr(String str) {
        JSONObject jSONObjectMs = com.bytedance.sdk.component.hi.x.xr.ms(str);
        if (jSONObjectMs == null) {
            return;
        }
        Iterator<String> itKeys = jSONObjectMs.keys();
        this.ny = new HashMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                Object objOpt = jSONObjectMs.opt(next);
                if (objOpt instanceof String) {
                    objOpt = ms((String) objOpt, this.f1241ms);
                }
                this.ny.put(next, objOpt);
            }
        }
    }

    private static Object ms(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return str;
        }
        try {
            return (str.startsWith("${") && str.endsWith("}")) ? com.bytedance.adsdk.xr.xr.ms.ms(str.substring(2, str.length() - 1)).ms(jSONObject) : str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public void ms(com.bytedance.sdk.component.hi.d.xr xrVar) {
        this.hi = xrVar;
    }

    public void c() {
        x();
        com.bytedance.sdk.component.hi.d.xr xrVar = this.hi;
        if (xrVar != null) {
            xrVar.ms();
        } else {
            com.bytedance.sdk.component.hi.ab.ms.ms().ms(this.d, this, new com.bytedance.sdk.component.hi.d.ms() { // from class: com.bytedance.sdk.component.hi.ms.ms.1
            });
        }
    }

    public void ms(Map<String, Object> map) {
        ka kaVarXr;
        ka kaVarXr2;
        d dVar = this.c;
        if (dVar != null && (kaVarXr2 = dVar.xr()) != null) {
            kaVarXr2.ms(this, map);
        }
        d dVar2 = this.ab;
        if (dVar2 == null || (kaVarXr = dVar2.xr()) == null) {
            return;
        }
        kaVarXr.ms(this, map);
    }

    public void xr(Map<String, Object> map) {
        ka kaVarXr;
        ka kaVarXr2;
        d dVar = this.c;
        if (dVar != null && (kaVarXr2 = dVar.xr()) != null) {
            kaVarXr2.xr(this, this.xr);
        }
        d dVar2 = this.ab;
        if (dVar2 == null || (kaVarXr = dVar2.xr()) == null) {
            return;
        }
        kaVarXr.xr(this, map);
    }

    public com.bytedance.sdk.component.hi.ah.ms ab() {
        return this.ah;
    }
}
