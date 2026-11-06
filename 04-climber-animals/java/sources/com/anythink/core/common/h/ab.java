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
    private String e;
    private int f;
    private long g;
    private int h;
    private String i;

    private ab() {
    }

    public static ab a(cd cdVar) {
        ab abVar = new ab();
        abVar.a = 1;
        abVar.b = cdVar.x();
        abVar.c = cdVar.A();
        abVar.d = cdVar.p();
        abVar.i = cdVar.g();
        a(abVar, cdVar.C());
        return abVar;
    }

    public static ab a(aw awVar) {
        ab abVar = new ab();
        abVar.a = 2;
        abVar.b = awVar.w();
        abVar.c = awVar.r();
        abVar.d = awVar.x();
        abVar.e = awVar.y();
        abVar.f = awVar.E();
        a(abVar, awVar.F());
        return abVar;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.umeng.analytics.pro.bv.aI, this.a);
            jSONObject.put("post_t", this.b);
            jSONObject.put("price", String.valueOf(this.d));
            long j = this.g;
            if (j > 0) {
                jSONObject.put("real_wait_price_t", j);
            }
            int i = this.h;
            if (i > 0) {
                jSONObject.put("bp_from", i);
            }
            if (this.a == 2) {
                jSONObject.put(MediationConstant.KEY_REASON, this.e);
                jSONObject.put("winner_firm_id", this.f);
            }
            if (this.a == 1) {
                jSONObject.put("h_code", this.i);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private static void a(ab abVar, MgComparedResult mgComparedResult) {
        abVar.g = mgComparedResult != null ? mgComparedResult.getCpCostTime() : 0L;
        int i = 0;
        if (mgComparedResult != null && mgComparedResult.isCompared()) {
            i = mgComparedResult.isMgWin() ? 2 : 1;
        }
        abVar.h = i;
    }
}
