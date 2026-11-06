package com.byazt.kd;

import com.byazt.fi.BaseConstants;
import com.byazt.sd.a;
import com.tapsdk.tapad.group.constants.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1299, 37})
public abstract class pr {
    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    public int pr(int i) {
        int iOptInt;
        JSONObject jSONObjectXg = a.hw().xg();
        if (jSONObjectXg != null) {
            if (hw(i)) {
                iOptInt = jSONObjectXg.optInt("explicit_interval", 0);
            } else if (hn(i)) {
                iOptInt = jSONObjectXg.optInt("ambiguous_interval", 0);
            } else {
                iOptInt = -1;
            }
        } else {
            iOptInt = -1;
        }
        return iOptInt > 86400000 ? BaseConstants.Time.DAY : iOptInt;
    }

    public void pr(int i, long j, long j2) {
        com.byazt.na.pr prVarPr = com.byazt.na.pr.pr();
        prVarPr.pr(i);
        prVarPr.pr(j, j2);
    }

    public int pr(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt(Constants.DELAY_FIELD, 200);
        }
        return 200;
    }

    public boolean hw(int i) {
        return i == 0 || i == 1;
    }

    public boolean hn(int i) {
        return i == 2 || i == 3;
    }
}
