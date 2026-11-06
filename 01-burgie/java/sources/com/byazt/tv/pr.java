package com.byazt.tv;

import android.content.Context;
import com.byazt.vlj.zo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1488, 37})
public class pr {
    public static volatile pr pr;
    public volatile Context hw;

    public static pr pr() {
        if (pr == null) {
            pr = new pr(zo.x());
        }
        return pr;
    }

    private pr(Context context) {
        this.hw = context;
    }

    public String pr(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        try {
            return com.byazt.wf.x.pr(com.byazt.wf.zo.pr(this.hw), com.byazt.wf.zo.pr(), hw.pr(zo.pr().pr()), jSONObject, hw.pr());
        } catch (Throwable th) {
            return null;
        }
    }

    public void hw(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        try {
            String strPr = hw.pr(zo.pr().pr());
            String strPr2 = com.byazt.wf.x.pr(com.byazt.wf.zo.pr(this.hw), com.byazt.wf.zo.hw(), strPr, jSONObject, hw.hw());
            jSONObject.put("upload_scene", "direct");
            if (hw.pr(strPr, jSONObject.toString()).pr()) {
                com.byazt.wf.x.pr(strPr2);
            }
        } catch (Throwable th) {
        }
    }
}
