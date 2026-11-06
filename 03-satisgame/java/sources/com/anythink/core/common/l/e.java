package com.anythink.core.common.l;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e extends b {
    Context a;
    int b;
    List<String> m;
    int n;
    boolean o = false;
    String c = com.anythink.core.common.d.s.b().p();
    String l = com.anythink.core.common.d.s.b().q();

    @Override // com.anythink.core.common.l.b
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.l.b
    protected final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, Object> h() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final void l() {
    }

    @Override // com.anythink.core.common.l.b
    protected final int n() {
        return 4;
    }

    @Override // com.anythink.core.common.l.b
    protected final boolean p() {
        return true;
    }

    public e(Context context, int i, List<String> list) {
        this.a = context;
        this.m = list;
        this.b = list.size();
        this.n = i;
    }

    public final void t() {
        this.o = true;
    }

    @Override // com.anythink.core.common.l.b
    protected final String b() {
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.e();
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("Content-Encoding", "gzip");
        map.put(b.g, "application/json;charset=utf-8");
        return map;
    }

    @Override // com.anythink.core.common.l.b
    protected final byte[] d() {
        return a(k());
    }

    @Override // com.anythink.core.common.l.b
    protected final String e() {
        return this.c;
    }

    @Override // com.anythink.core.common.l.b
    protected final Context f() {
        return this.a;
    }

    @Override // com.anythink.core.common.l.b
    protected final String g() {
        return this.l;
    }

    @Override // com.anythink.core.common.l.b
    protected final JSONObject i() {
        JSONObject jSONObjectI = super.i();
        if (jSONObjectI != null) {
            try {
                jSONObjectI.put("app_id", this.c);
                jSONObjectI.put("nw_ver", com.anythink.core.common.u.l.h());
                Map<String, Object> mapM = com.anythink.core.common.d.s.b().m();
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
                            jSONObjectI.put("custom", jSONObject);
                        }
                    } catch (Throwable unused) {
                    }
                }
                JSONArray jSONArray = new JSONArray();
                List<String> list = this.m;
                if (list != null && list.size() > 0) {
                    for (String str2 : this.m) {
                        if (!TextUtils.isEmpty(str2)) {
                            jSONArray.put(new JSONObject(str2));
                        }
                    }
                }
                jSONObjectI.put(f.R, jSONArray);
            } catch (Exception unused2) {
            }
        }
        return jSONObjectI;
    }

    @Override // com.anythink.core.common.l.b
    protected final JSONObject j() {
        JSONObject jSONObjectJ = super.j();
        if (jSONObjectJ != null) {
            try {
                jSONObjectJ.put(f.S, this.n);
            } catch (Exception unused) {
            }
        }
        return jSONObjectJ;
    }

    @Override // com.anythink.core.common.l.b
    protected final Object a(Object obj) {
        return Integer.valueOf(this.b);
    }

    private static String b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    @Override // com.anythink.core.common.l.b
    public final void a(int i, s sVar) {
        com.anythink.core.common.i.a();
        if (!TextUtils.isEmpty(com.anythink.core.common.i.e())) {
            super.a(i, sVar);
        } else if (sVar != null) {
            sVar.onLoadFinish(i, Integer.valueOf(this.b));
        }
    }
}
