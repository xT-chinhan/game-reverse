package com.byazt.gq;

import android.content.Context;
import com.tapsdk.tapad.group.constants.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1588, 37})
public abstract class pr {
    public String hn = "";
    public final com.byazt.jdi.pr hw = new com.byazt.jdi.pr();
    public Context pr;
    public JSONObject x;

    public abstract String hn();

    public abstract String hw();

    public pr(Context context, JSONObject jSONObject) {
        this.pr = context;
        this.x = jSONObject;
    }

    public com.byazt.jdi.pr pr() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strHw = hw();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            this.hw.hw(strHw);
            this.hw.pr(hn());
            this.hw.pr(jCurrentTimeMillis2 - jCurrentTimeMillis);
            this.hw.hn(x());
            this.hw.hn();
            if (this.x.has(Constants.INDEX_FIELD)) {
                this.hw.pr(this.x.optInt(Constants.INDEX_FIELD));
            }
            return this.hw;
        } catch (Exception e) {
            com.byazt.wx.pr.hw("__kite" + hn() + " doLoad# error " + e.getMessage());
            return this.hw;
        }
    }

    private String x() {
        return this.hn;
    }
}
