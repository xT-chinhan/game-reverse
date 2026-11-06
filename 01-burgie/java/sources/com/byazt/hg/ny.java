package com.byazt.hg;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.umeng.commonsdk.framework.UMModuleRegister;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 36})
public class ny {
    public static int pr = 0;
    public static int hw = 0;

    public static void pr(com.byazt.zq.c cVar) {
        try {
            JSONObject jSONObject = new JSONObject(cVar.hw("dpl_status_counter", ""));
            pr = jSONObject.optInt("minute", 0);
            hw = jSONObject.optInt(UMModuleRegister.INNER, 0);
            com.byazt.wm.pr.hw();
        } catch (JSONException e) {
        }
    }

    public static void hw(com.byazt.zq.c cVar) {
        cVar.pr("dpl_status_counter", new JSONObject().toString());
    }

    public static int pr() {
        return pr;
    }

    public static int hw() {
        return hw;
    }

    public static void pr(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("dpl_status_counter");
                if (jSONObjectOptJSONObject2 != null) {
                    pr = jSONObjectOptJSONObject2.optInt("minute", 0);
                    hw = jSONObjectOptJSONObject2.optInt(UMModuleRegister.INNER, 0);
                }
            } catch (Exception e) {
            }
        }
    }
}
