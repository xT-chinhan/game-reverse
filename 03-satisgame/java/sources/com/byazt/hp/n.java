package com.byazt.hp;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.byazt.ih.s;
import com.byazt.om.UGFrameLayout;
import com.byazt.vh.cy;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1688, 19})
public class n extends com.byazt.xs.n {
    public n(Context context) {
        super(context);
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: cx, reason: merged with bridge method [inline-methods] */
    public UGFrameLayout n() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(this.qg);
        uGFrameLayout.n(this);
        return uGFrameLayout;
    }

    @Override // com.byazt.xs.n, com.byazt.ih.n, com.byazt.ih.s
    public void qg() {
        super.qg();
    }

    public void n(long j, long j2) {
        cy cyVar;
        JSONObject jSONObjectS;
        if (!n(12) || (cyVar = this.xi.get(12)) == null || (jSONObjectS = cyVar.s()) == null) {
            return;
        }
        jSONObjectS.optString("type");
        JSONArray jSONArrayOptJSONArray = jSONObjectS.optJSONArray("actions");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("type");
                int iOptInt = jSONObjectOptJSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS) * 1000;
                if (iOptInt > j2) {
                    iOptInt = (int) j2;
                }
                if (j == iOptInt && TextUtils.equals(strOptString, "onShow")) {
                    s sVarQg = qg(this);
                    String strOptString2 = jSONObjectOptJSONObject.optString("nodeId");
                    if (sVarQg != null) {
                        sVarQg.q(strOptString2).qg(0);
                    }
                }
            }
        }
    }
}
