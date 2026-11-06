package com.byazt.cy;

import com.byazt.hg.of;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2359, 13})
public class hw {
    public of pr;

    public void pr(of ofVar) {
        this.pr = ofVar;
    }

    public void pr(int i) {
        pr("config_change_type", i);
    }

    public void hw(int i) {
        pr("real_change_type", i);
    }

    public void hn(int i) {
        pr("business_notify_status", i);
    }

    public void x(int i) {
        pr("video_countdown_status", i);
    }

    public void c(int i) {
        pr("jump_dest_type", i);
    }

    public void pr(boolean z) {
        pr("is_ab_style", z ? 1 : 0);
    }

    public void hw(boolean z) {
        pr("predict_in_endcard", z ? 1 : 0);
    }

    private void pr(String str, int i) {
        JSONObject jSONObjectPr;
        of ofVar = this.pr;
        if (ofVar == null || (jSONObjectPr = com.byazt.ak.hw.pr(ofVar.z())) == null) {
            return;
        }
        try {
            jSONObjectPr.put(str, i);
        } catch (JSONException e) {
        }
    }
}
