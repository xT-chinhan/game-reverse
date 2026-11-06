package com.byazt.su;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 726, 21})
public class x {
    public static void n(String str, long j) {
        com.byazt.vl.l lVarL = com.byazt.vl.w.n().l(j);
        if (lVarL.m()) {
            return;
        }
        lVarL.s.setRefer(str);
        com.byazt.vj.n.n().qg("lp_app_dialog_click", lVarL);
    }

    public static void qg(String str, long j) {
        n(str, null, j);
    }

    public static void n(String str, JSONObject jSONObject, long j) {
        com.byazt.vj.n.n().qg(str, jSONObject, com.byazt.vl.w.n().l(j));
    }

    public static void n(String str, com.byazt.vl.l lVar) {
        com.byazt.vj.n.n().qg(str, lVar);
    }

    public static void n(int i, com.byazt.vl.l lVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception unused) {
        }
        com.byazt.vj.n.n().qg("lp_compliance_error", jSONObject, lVar);
    }

    public static void n(int i, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception unused) {
        }
        com.byazt.vj.n.n().qg("lp_compliance_error", jSONObject, com.byazt.vl.w.n().l(j));
    }
}
