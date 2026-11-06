package com.byazt.sb;

import com.byazt.ho.BaseConstants;
import com.byazt.nf.rv;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 527, 19})
public abstract class n {
    public boolean qg(int i) {
        return i == 0 || i == 1;
    }

    public boolean s(int i) {
        return i == 2 || i == 3;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    public int n(int i) {
        int iOptInt;
        JSONObject jSONObjectOx = rv.qg().ox();
        if (jSONObjectOx == null) {
            iOptInt = -1;
        } else if (qg(i)) {
            iOptInt = jSONObjectOx.optInt("explicit_interval", 0);
        } else if (s(i)) {
            iOptInt = jSONObjectOx.optInt("ambiguous_interval", 0);
        } else {
            iOptInt = -1;
        }
        return iOptInt > 86400000 ? BaseConstants.Time.DAY : iOptInt;
    }

    public void n(int i, long j, long j2) {
        com.byazt.hnb.qg qgVarN = com.byazt.hnb.qg.n();
        qgVarN.n(i);
        qgVarN.n(j, j2);
    }

    public int n(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("delay", 200);
        }
        return 200;
    }
}
