package com.anythink.core.common.m;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.aq;
import com.efs.sdk.base.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d extends a {
    Context a;
    int b;
    List<String> e;
    int f;
    boolean g = false;
    String c = com.anythink.core.common.d.t.b().p();
    String d = com.anythink.core.common.d.t.b().q();

    @Override // com.anythink.core.common.m.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.m.a
    protected final void b(AdError adError) {
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, Object> k() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final int l() {
        return 4;
    }

    @Override // com.anythink.core.common.m.a
    protected final boolean p() {
        return true;
    }

    public d(Context context, int i, List<String> list) {
        this.a = context;
        this.e = list;
        this.b = list.size();
        this.f = i;
    }

    public final void s() {
        this.g = true;
    }

    @Override // com.anythink.core.common.m.a
    protected final String b() {
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.i();
    }

    @Override // com.anythink.core.common.m.a
    public final void a(int i, q qVar) {
        if (!TextUtils.isEmpty(b())) {
            super.a(i, qVar);
        } else if (qVar != null) {
            qVar.onLoadFinish(i, Integer.valueOf(this.b));
        }
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("Content-Encoding", Constants.CP_GZIP);
        map.put("Content-Type", "application/json;charset=utf-8");
        return map;
    }

    @Override // com.anythink.core.common.m.a
    protected final byte[] d() {
        return b(g());
    }

    @Override // com.anythink.core.common.m.a
    protected final String h() {
        return this.c;
    }

    @Override // com.anythink.core.common.m.a
    protected final Context i() {
        return this.a;
    }

    @Override // com.anythink.core.common.m.a
    protected final String j() {
        return this.d;
    }

    @Override // com.anythink.core.common.m.a
    protected final JSONObject e() {
        JSONObject jSONObjectE = super.e();
        if (jSONObjectE != null) {
            try {
                jSONObjectE.put("app_id", this.c);
                jSONObjectE.put("nw_ver", com.anythink.core.common.v.m.h());
                Map<String, Object> mapM = com.anythink.core.common.d.t.b().m();
                if (mapM != null) {
                    try {
                        if (mapM.size() > 0 && mapM != null) {
                            JSONObject jSONObject = new JSONObject();
                            for (String str : mapM.keySet()) {
                                Object obj = mapM.get(str);
                                if (obj != null) {
                                    jSONObject.put(str, obj.toString());
                                }
                            }
                            jSONObjectE.put("custom", jSONObject);
                        }
                    } catch (Throwable unused) {
                    }
                }
                JSONArray jSONArray = new JSONArray();
                List<String> list = this.e;
                if (list != null && list.size() > 0) {
                    for (String str2 : this.e) {
                        if (!TextUtils.isEmpty(str2)) {
                            jSONArray.put(new JSONObject(str2));
                        }
                    }
                }
                jSONObjectE.put("data", jSONArray);
            } catch (Exception unused2) {
            }
        }
        return jSONObjectE;
    }

    @Override // com.anythink.core.common.m.a
    protected final JSONObject f() {
        JSONObject jSONObjectF = super.f();
        if (jSONObjectF != null) {
            try {
                jSONObjectF.put(e.S, this.f);
            } catch (Exception unused) {
            }
        }
        return jSONObjectF;
    }

    @Override // com.anythink.core.common.m.a
    protected final Object a(Object obj) {
        return Integer.valueOf(this.b);
    }

    @Override // com.anythink.core.common.m.a
    protected final void a(AdError adError) {
        if (this.g) {
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
            String strG = g();
            com.anythink.core.common.t.a().a(1, b(), string, strG, aq.a(1001));
        }
    }

    private static String a(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
