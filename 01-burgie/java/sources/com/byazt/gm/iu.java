package com.byazt.gm;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 166})
public class iu extends com.byazt.ee.c<JSONObject, JSONObject> {
    public com.byazt.hg.of hw;
    public Context pr;

    public iu(Context context, com.byazt.hg.of ofVar) {
        this.pr = context;
        this.hw = ofVar;
    }

    public static void pr(com.byazt.ee.yb ybVar, Context context, com.byazt.hg.of ofVar) {
        ybVar.pr("openNewCommonWebPage", (com.byazt.ee.c<?, ?>) new iu(context, ofVar));
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        try {
            String strOptString = jSONObject.optString("web_url");
            String strOptString2 = jSONObject.optString("web_title");
            if (!TextUtils.isEmpty(strOptString)) {
                if (TextUtils.isEmpty(strOptString2)) {
                    strOptString2 = "";
                }
                TTDelegateActivity.x(this.pr, strOptString, strOptString2);
                return null;
            }
            return null;
        } catch (Throwable th) {
            com.byazt.ca.ho.hw("OpenNewWebPageMethod", "method:" + th.getMessage());
            return null;
        }
    }
}
