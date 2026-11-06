package com.anythink.basead.i;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.aq;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.t;
import com.efs.sdk.base.Constants;
import com.umeng.analytics.pro.bv;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b extends com.anythink.core.common.m.a {
    String a;
    JSONObject b;

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
    protected final String g() {
        return "";
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

    public b(int i, ay ayVar, String str) {
        String strF = "";
        try {
            switch (i) {
                case 1:
                    strF = ayVar.f();
                    break;
                case 2:
                    strF = ayVar.g();
                    break;
                case 3:
                    strF = ayVar.ax();
                    break;
                case 4:
                    strF = ayVar.ay();
                    break;
                case 5:
                    strF = ayVar.az();
                    break;
                case 6:
                    strF = ayVar.aA();
                    break;
                case 7:
                    strF = ayVar.aB();
                    break;
                case 8:
                    strF = ayVar.aC();
                    break;
                case 9:
                    strF = ayVar.aD();
                    break;
            }
            if (TextUtils.isEmpty(strF)) {
                return;
            }
            Uri uri = Uri.parse(ayVar.ak(strF));
            this.a = uri.getScheme() + "://" + uri.getAuthority() + uri.getPath();
            this.b = new JSONObject();
            for (String str2 : uri.getQueryParameterNames()) {
                this.b.put(str2, URLEncoder.encode(uri.getQueryParameter(str2)));
            }
            this.b.put("req_id", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final String n() {
        return this.a;
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
        return this.a;
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
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            return new byte[0];
        }
        try {
            jSONObject.put(bv.aI, String.valueOf(System.currentTimeMillis()));
        } catch (Exception unused) {
        }
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
