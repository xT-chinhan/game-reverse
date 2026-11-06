package com.anythink.core.common.h;

import com.anythink.core.mg.api.MgComparedResult;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ab {
    private int a;
    private int b;
    private int c;
    private double d;
    private double e;
    private String f;
    private int g;
    private long h;
    private int i;
    private String j;

    private ab() {
    }

    public static ab a(cg cgVar) {
        ab abVar = new ab();
        abVar.a = 1;
        abVar.b = cgVar.x();
        abVar.c = cgVar.A();
        abVar.d = cgVar.p();
        abVar.j = cgVar.g();
        a(abVar, cgVar.C());
        return abVar;
    }

    public static ab a(ay ayVar) {
        ab abVar = new ab();
        abVar.a = 2;
        abVar.b = ayVar.y();
        abVar.c = ayVar.t();
        abVar.d = ayVar.z();
        abVar.f = ayVar.A();
        abVar.g = ayVar.G();
        abVar.e = ayVar.K();
        a(abVar, ayVar.H());
        return abVar;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", this.a);
            jSONObject.put("post_t", this.b);
            jSONObject.put(com.anythink.core.d.b.e.a.h, String.valueOf(this.d));
            long j = this.h;
            if (j > 0) {
                jSONObject.put("real_wait_price_t", j);
            }
            int i = this.i;
            if (i > 0) {
                jSONObject.put("bp_from", i);
            }
            if (this.a == 2) {
                jSONObject.put(MediationConstant.KEY_REASON, this.f);
                jSONObject.put("winner_firm_id", this.g);
                double d = this.e;
                if (d > 0.0d) {
                    jSONObject.put("custom_f_price", String.valueOf(d));
                }
            }
            if (this.a == 1) {
                jSONObject.put("h_code", this.j);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private static void a(ab abVar, MgComparedResult mgComparedResult) {
        abVar.h = mgComparedResult != null ? mgComparedResult.getCpCostTime() : 0L;
        int i = 0;
        if (mgComparedResult != null && mgComparedResult.isCompared()) {
            i = mgComparedResult.isMgWin() ? 2 : 1;
        }
        abVar.i = i;
    }
}
