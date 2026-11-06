package com.byazt.hg;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 203})
public class r {
    public List<bh> pr;

    public r(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("components")) != null) {
            this.pr = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                this.pr.add(new bh(jSONArrayOptJSONArray.optJSONObject(i), 3));
            }
        }
    }

    public static List<bh> pr(of ofVar) {
        r rVarEe;
        if (ofVar == null || (rVarEe = ofVar.ee()) == null) {
            return null;
        }
        return rVarEe.pr;
    }

    public static boolean hw(of ofVar) {
        r rVarEe;
        List<bh> list;
        if (ofVar == null || (rVarEe = ofVar.ee()) == null || (list = rVarEe.pr) == null || list.isEmpty()) {
            return false;
        }
        return true;
    }
}
