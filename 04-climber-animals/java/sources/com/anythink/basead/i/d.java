package com.anythink.basead.i;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.x;
import com.anythink.core.common.i;
import com.anythink.core.common.m.o;
import com.anythink.core.common.v.k;
import com.anythink.core.common.v.m;
import com.efs.sdk.base.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d extends com.anythink.core.common.m.a {
    String a;
    String b;
    String c;
    int d;
    int e;
    int f;
    int g;
    String[] h;
    int i;
    int j;
    String k;
    String l = "OnlineOfferLoader";

    @Override // com.anythink.core.common.m.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.m.a
    protected final Object a(Object obj) {
        return obj;
    }

    @Override // com.anythink.core.common.m.a
    protected final void a(AdError adError) {
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

    @Override // com.anythink.core.common.m.a
    protected final int l() {
        return 130;
    }

    public d(x xVar, int i, int i2, String[] strArr, String str) {
        this.a = xVar.d;
        this.b = xVar.b;
        this.c = xVar.c;
        this.i = xVar.e;
        this.f = i;
        this.g = i2;
        this.h = strArr;
        this.d = xVar.h;
        this.e = xVar.i;
        this.j = xVar.j;
        this.k = str;
    }

    @Override // com.anythink.core.common.m.a
    protected final String b() {
        i.a();
        return i.f();
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
        try {
            return g().getBytes("utf-8");
        } catch (Exception unused) {
            return g().getBytes();
        }
    }

    @Override // com.anythink.core.common.m.a
    protected final JSONObject e() {
        JSONObject jSONObjectE = super.e();
        try {
            jSONObjectE.put("app_id", t.b().p());
            jSONObjectE.put(com.anythink.core.common.m.e.bk, this.b);
            jSONObjectE.put("session_id", t.b().g(this.b));
            jSONObjectE.put("t_g_id", this.d);
            jSONObjectE.put("gro_id", this.e);
            String strC = t.b().C();
            if (!TextUtils.isEmpty(strC)) {
                jSONObjectE.put("sy_id", strC);
            }
            String strD = t.b().D();
            if (!TextUtils.isEmpty(strD)) {
                jSONObjectE.put("bk_id", strD);
            } else {
                t.b().k(t.b().B());
                jSONObjectE.put("bk_id", t.b().B());
            }
            jSONObjectE.put("deny", m.p(t.b().g()));
            JSONObject jSONObjectA = com.anythink.core.common.m.e.a(this.b);
            if (jSONObjectA != null) {
                jSONObjectE.put("customs", jSONObjectA);
            }
            com.anythink.core.common.m.e.a(jSONObjectE);
        } catch (Exception unused) {
        }
        return jSONObjectE;
    }

    @Override // com.anythink.core.common.m.a
    protected final JSONObject f() {
        return super.f();
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00e0  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.anythink.core.common.m.a
    protected final String g() {
        HashMap map = new HashMap();
        String strA = k.a(e().toString());
        String strA2 = k.a(f().toString());
        map.put("p", strA);
        map.put(com.anythink.core.common.m.e.W, strA2);
        map.put("request_id", this.a);
        map.put("ad_source_id", Integer.valueOf(Integer.parseInt(this.c)));
        map.put("ad_num", Integer.valueOf(this.i));
        String[] strArr = this.h;
        byte b = 0;
        if (strArr != null && strArr.length > 0) {
            JSONArray jSONArray = new JSONArray();
            for (String str : this.h) {
                jSONArray.put(str);
            }
            map.put("exclude_offers", jSONArray);
        }
        if (t.b().l() != null) {
            map.put(com.anythink.core.b.a.a.c, k.a(t.b().l().toString()));
        }
        int i = this.f;
        if (i > 0 && this.g > 0) {
            map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, Integer.valueOf(i));
            map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, Integer.valueOf(this.g));
        }
        JSONObject jSONObject = new JSONObject(map);
        try {
            String strValueOf = String.valueOf(this.j);
            switch (strValueOf.hashCode()) {
                case 49:
                    if (strValueOf.equals("1")) {
                        b = 3;
                    } else {
                        b = -1;
                    }
                    break;
                case 50:
                    if (!strValueOf.equals("2")) {
                        b = -1;
                    }
                    break;
                case 51:
                    if (strValueOf.equals("3")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                    break;
                case 52:
                    if (strValueOf.equals("4")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0 || b == 1 || b == 2 || b == 3) {
                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADP_ACCEPT_TYPE, new JSONArray(ATAdConst.AD_SUPPORT_TYPE_ARRAY));
                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADP_ACCEPT_VAST_VER, new JSONArray(ATAdConst.AD_SUPPORT_VAST_VERSION_ARRAY));
            }
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.anythink.core.common.m.a
    protected final void a(int i, Object obj) {
        if (obj == null) {
            a(i, o.m, "Return Empty Ad.", ErrorCode.getErrorCode(ErrorCode.noADError, "", ""));
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(obj.toString());
            if (TextUtils.isEmpty(jSONObject.optString("data"))) {
                a(i, o.n, obj.toString(), ErrorCode.getErrorCode(ErrorCode.noADError, "", obj.toString()));
            } else {
                super.a(i, jSONObject);
            }
        } catch (Throwable th) {
            a(i, o.o, obj != null ? obj.toString() : th.getMessage(), ErrorCode.getErrorCode(ErrorCode.noADError, "", obj != null ? obj.toString() : "Online Api Service Error."));
        }
    }
}
