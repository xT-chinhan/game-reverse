package com.byazt.mn;

import android.text.TextUtils;
import com.byazt.hg.of;
import com.byazt.pv.zo;
import com.byazt.sd.a;
import com.tapsdk.tapad.group.constants.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 403, 20})
public class hn {
    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject hn(hw hwVar, of ofVar, com.byazt.ewt.pr prVar) {
        if (hwVar == null || prVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String strHw = hwVar.hw();
            String strPr = hwVar.pr();
            jSONObject.putOpt("lifecycle_id", prVar.hw());
            jSONObject.putOpt("type", strHw + "_" + strPr);
            jSONObject.putOpt("l_type", strHw);
            jSONObject.putOpt("state", strPr);
            jSONObject.putOpt("state_num", x.pr(hwVar));
            if ("ad_load_loaded".equals(strHw + "_" + strPr) && (prVar instanceof com.byazt.pv.hw)) {
                jSONObject.putOpt("ad_count", Integer.valueOf(((com.byazt.pv.hw) prVar).pr()));
            } else {
                jSONObject.putOpt("ad_count", Integer.valueOf(pr(prVar)));
            }
            jSONObject.putOpt("bidding_type", Integer.valueOf(prVar.m));
            if ((prVar instanceof com.byazt.pv.hw) && ((com.byazt.pv.hw) prVar).x != null) {
                int iPr = ((com.byazt.pv.hw) prVar).x.pr();
                int iPr2 = pr(((com.byazt.pv.hw) prVar).x.hw());
                jSONObject.putOpt(Constants.ERROR_CODE_FIELD, Integer.valueOf(iPr));
                jSONObject.putOpt("error_reason", Integer.valueOf(iPr2));
                jSONObject.putOpt("error_code_reason", iPr + "_" + iPr2);
                jSONObject.putOpt(Constants.ERROR_MSG_FIELD, ((com.byazt.pv.hw) prVar).x.hw());
            }
            if (prVar instanceof zo) {
                jSONObject.putOpt("ugen_id", ((zo) prVar).hw);
                jSONObject.putOpt("category_id", Integer.valueOf(((zo) prVar).hn));
            }
            if (prVar instanceof com.byazt.pv.hn) {
                jSONObject.putOpt("ugen_id", ((com.byazt.pv.hn) prVar).vk);
                jSONObject.putOpt("category_id", Integer.valueOf(((com.byazt.pv.hn) prVar).w));
            }
            if (hwVar.x() != -1) {
                jSONObject.putOpt("source", Integer.valueOf(hwVar.x()));
            }
            jSONObject.putOpt("ts", Long.valueOf(hwVar.hn()));
            JSONObject jSONObject2 = new JSONObject();
            if (prVar.k > 0) {
                jSONObject2.putOpt("ad_slot_type", Integer.valueOf(prVar.k == 4 ? 3 : prVar.k));
            }
            jSONObject2.putOpt("rit", prVar.g);
            if (ofVar != null) {
                jSONObject2.putOpt("aid", ofVar.x());
                jSONObject2.putOpt("cid", ofVar.fo());
                jSONObject2.putOpt("req_id", ofVar.ny());
            }
            jSONObject.putOpt("ad_info", jSONObject2);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    private static int pr(com.byazt.ewt.pr prVar) {
        int iK;
        if (prVar instanceof com.byazt.pv.hw) {
            com.byazt.pv.hw hwVar = (com.byazt.pv.hw) prVar;
            if (hwVar.pr != null && (iK = hwVar.pr.k()) > 0) {
                return iK;
            }
            return 1;
        }
        return 1;
    }

    public static void pr(final hw hwVar, final of ofVar, final com.byazt.ewt.pr prVar) {
        if (!a.hw().dl()) {
            return;
        }
        com.byazt.uw.hn.pr().post(new Runnable() { // from class: com.byazt.mn.hn.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObjectHn = hn.hn(hwVar, ofVar, prVar);
                    if (jSONObjectHn != null) {
                        com.byazt.gf.pr.pr().pr(jSONObjectHn);
                    }
                } catch (Throwable th) {
                }
            }
        });
    }

    private static int pr(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            String[] strArrSplit2 = str.split("message:");
            if (strArrSplit2 != null && strArrSplit2.length > 0) {
                String str2 = strArrSplit2[0];
                if (!TextUtils.isEmpty(str2) && (strArrSplit = str2.trim().split(":")) != null && strArrSplit.length >= 2) {
                    String str3 = strArrSplit[1];
                    if (!TextUtils.isEmpty(str3)) {
                        return Integer.valueOf(str3.trim()).intValue();
                    }
                }
            }
        } catch (Throwable th) {
        }
        return 0;
    }
}
