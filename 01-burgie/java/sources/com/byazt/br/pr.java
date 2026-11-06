package com.byazt.br;

import android.content.Context;
import com.byazt.ca.ho;
import com.byazt.ee.c;
import com.byazt.ee.uc;
import com.byazt.ee.yb;
import com.byazt.eg.hw;
import com.byazt.mg.PluginConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2294, 37})
public class pr extends c<JSONObject, JSONObject> {
    public final Context pr;

    public pr(Context context) {
        this.pr = context;
    }

    public static void pr(yb ybVar, Context context) {
        ybVar.pr("openLiveRoom", (c<?, ?>) new pr(context));
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, uc ucVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        int iPr = -1;
        try {
            long jPr = pr(jSONObject);
            if (jPr > 0 && this.pr != null) {
                iPr = hw.pr().pr(this.pr, jPr);
            }
        } catch (Throwable th) {
            ho.hw("OpenLiveRoomMethod", "method:" + th.getMessage());
        }
        jSONObject2.put(PluginConstants.KEY_ERROR_CODE, iPr);
        return jSONObject2;
    }

    private static long pr(JSONObject jSONObject) {
        try {
            return Long.parseLong(jSONObject.optString("room_id", "0"));
        } catch (NumberFormatException e) {
            return 0L;
        }
    }
}
