package com.byazt.xqu;

import com.tapsdk.tapad.group.constants.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 432, 62})
public class fw {
    public static void pr(String str, long j) {
        com.byazt.shh.c cVarC = com.byazt.shh.uc.pr().c(j);
        if (!cVarC.rc()) {
            cVarC.hn.setRefer(str);
            com.byazt.mf.pr.pr().hw("lp_app_dialog_click", cVarC);
        }
    }

    public static void hw(String str, long j) {
        pr(str, null, j);
    }

    public static void pr(String str, JSONObject jSONObject, long j) {
        com.byazt.mf.pr.pr().hw(str, jSONObject, com.byazt.shh.uc.pr().c(j));
    }

    public static void pr(String str, com.byazt.shh.c cVar) {
        com.byazt.mf.pr.pr().hw(str, cVar);
    }

    public static void pr(int i, com.byazt.shh.c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(Constants.ERROR_CODE_FIELD, Integer.valueOf(i));
        } catch (Exception e) {
        }
        com.byazt.mf.pr.pr().hw("lp_compliance_error", jSONObject, cVar);
    }

    public static void pr(int i, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(Constants.ERROR_CODE_FIELD, Integer.valueOf(i));
        } catch (Exception e) {
        }
        com.byazt.mf.pr.pr().hw("lp_compliance_error", jSONObject, com.byazt.shh.uc.pr().c(j));
    }
}
