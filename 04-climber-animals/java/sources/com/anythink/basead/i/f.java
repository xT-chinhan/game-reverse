package com.anythink.basead.i;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.aq;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.y;
import com.anythink.core.common.i;
import com.anythink.core.common.t;
import com.anythink.core.common.v.m;
import com.efs.sdk.base.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f extends com.anythink.core.common.m.a {
    String a;
    JSONObject b;
    int c;
    String d;
    bj e;
    Map<String, Object> f;

    @Override // com.anythink.core.common.m.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.m.a
    protected final Object a(Object obj) {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final void b(AdError adError) {
    }

    @Override // com.anythink.core.common.m.a
    protected final String h() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final Context i() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final String j() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, Object> k() {
        return null;
    }

    public f(int i, bj bjVar, String str, Map<String, Object> map) {
        this.c = i;
        this.e = bjVar;
        this.f = map;
        this.d = str;
    }

    public final void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.b.put("scenario", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.core.common.m.a
    protected final String b() {
        try {
            if (!TextUtils.isEmpty(this.d)) {
                this.b = new JSONObject(this.d);
                for (Map.Entry<String, Object> entry : this.f.entrySet()) {
                    this.b.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        i.a();
        String strE = i.e();
        this.a = strE;
        return strE;
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, String> c() {
        y yVarR;
        HashMap map = new HashMap();
        map.put("Content-Encoding", Constants.CP_GZIP);
        map.put("Content-Type", "application/json;charset=utf-8");
        bj bjVar = this.e;
        if (bjVar != null && (yVarR = bjVar.r()) != null && com.anythink.basead.b.b.a(this.c, yVarR)) {
            String strI = m.i();
            if (!TextUtils.isEmpty(strI)) {
                map.put("User-Agent", strI);
            }
        }
        return map;
    }

    @Override // com.anythink.core.common.m.a
    protected final byte[] d() {
        return b(this.b.toString());
    }

    @Override // com.anythink.core.common.m.a
    protected final void a(AdError adError) {
        JSONObject jSONObject = new JSONObject();
        Map<String, String> mapC = c();
        if (mapC != null) {
            try {
                for (String str : mapC.keySet()) {
                    jSONObject.put(str, mapC.get(str));
                }
            } catch (Exception unused) {
            }
        }
        String string = jSONObject.toString();
        JSONObject jSONObject2 = this.b;
        String string2 = jSONObject2 != null ? jSONObject2.toString() : "";
        t.a().a(1, b(), string, string2, aq.a(1000));
        com.anythink.core.common.u.e.a("tk", adError.getPlatformCode(), adError.getPlatformMSG(), this.a, "", "1", "", (ATAdRequest) null);
    }
}
