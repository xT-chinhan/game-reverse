package com.byazt.pw;

import android.app.Dialog;
import com.byazt.hg.ie;
import com.byazt.hg.of;
import com.byazt.mr.uc;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 420, 37})
public class pr implements com.byazt.vg.pr {
    public final of pr;

    public pr(of ofVar) {
        this.pr = ofVar;
    }

    @Override // com.byazt.vg.pr
    public boolean pr(String str, Dialog dialog) {
        return false;
    }

    @Override // com.byazt.vg.pr
    public boolean pr(uc ucVar, String str, Dialog dialog) {
        if ("7:1".equals(ucVar.pr())) {
            com.byazt.xk.hw.pr().pr("stats_feedback_cannot_close", this.pr.ny(), this.pr.B_(), new com.byazt.ttf.pr() { // from class: com.byazt.pw.pr.1
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("render_control", ie.hn(pr.this.pr));
                    jSONObject2.put("ad_info", pr.this.pr.td());
                    jSONObject2.put("render_sequence", ie.hn(pr.this.pr));
                    return jSONObject2;
                }
            });
            return true;
        }
        return false;
    }

    public static void pr(com.byazt.pfl.hw hwVar, of ofVar) {
        if (hwVar == null || ofVar == null) {
            return;
        }
        hwVar.pr(new pr(ofVar));
    }
}
