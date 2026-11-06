package com.mcto.sspsdk.internal;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d4 implements i7 {
    public final /* synthetic */ e4 a;

    public d4(e4 e4Var) {
        this.a = e4Var;
    }

    @Override // com.mcto.sspsdk.internal.i7
    public final void a(String str, h7 h7Var) {
        e4 e4Var = this.a;
        e4Var.getClass();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(NotificationCompat.CATEGORY_MESSAGE);
            u1 u1Var = new u1();
            e4Var.a = u1Var;
            u1Var.c = jSONObject.optInt("st");
            e4Var.a.d = jSONObject.optLong("si");
            e4Var.a.e = jSONObject.optLong("sqi");
            e4Var.a.a = jSONObject.optInt("isp", 0) == 1;
            e4Var.a.b = jSONObject.optInt("sdl", 15000);
            e4Var.a.f = gj.a(32, jSONObject.optString("sp"), "e84584df1113ff82bccbdfef9b69c2f3");
            e4.a(jSONObject.optJSONArray("sch"));
            String strOptString = jSONObject.optString("pu");
            if (!TextUtils.isEmpty(strOptString) && !strOptString.equals(kl.b)) {
                kl.b = strOptString;
                nh.a(jd.a).a("iad_dev", "dpu", strOptString);
            }
            String strOptString2 = jSONObject.optString("mu");
            if (!TextUtils.isEmpty(strOptString2) && !strOptString2.equals(kl.a)) {
                kl.a = strOptString2;
                nh.a(jd.a).a("iad_dev", "mu", strOptString2);
            }
            HashMap map = new HashMap(5);
            map.put("ql_cbmi", jSONObject.optString("ql_cbmi", null));
            map.put("ql_misc", jSONObject.optString("ql_misc", null));
            map.put("simdw", jSONObject.optString("simd"));
            map.put("lcsw", jSONObject.optString("lcsw", "0"));
            map.put("simet", "" + jSONObject.optLong("simet", 2592000000L));
            nh.a(jd.a).a(map);
        } catch (Exception e) {
        }
        t1 t1VarA = t1.a();
        u1 u1Var2 = this.a.a;
        t1VarA.getClass();
        if (!rd.a() && t1VarA.f.compareAndSet(false, true)) {
            t1VarA.b = u1Var2;
            t1VarA.g.sendEmptyMessage(1);
        }
        c1.a();
        th.a().b();
    }

    @Override // com.mcto.sspsdk.internal.i7
    public final void a(h7 h7Var) {
        t1 t1VarA = t1.a();
        u1 u1Var = this.a.a;
        t1VarA.getClass();
        if (!rd.a() && t1VarA.f.compareAndSet(false, true)) {
            t1VarA.b = u1Var;
            t1VarA.g.sendEmptyMessage(1);
        }
        c1.a();
        th.a().b();
    }
}
