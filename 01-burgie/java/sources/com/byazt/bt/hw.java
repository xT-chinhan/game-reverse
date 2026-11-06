package com.byazt.bt;

import android.text.TextUtils;
import com.byazt.rd.hn;
import com.byazt.sd.a;
import com.tapsdk.tapad.group.constants.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1303, 13})
public class hw extends com.byazt.rd.pr {
    public String hn;
    public double hw;
    public final String x = "xgc_prop_volume";
    public volatile int c = -2;
    public pr pr = new pr(a.getContext());

    public int c() {
        return this.c;
    }

    public void pr(double d) {
        this.hw = d;
    }

    public void pr(String str) {
        this.hn = str;
    }

    public int uc() {
        return (int) hn.pr().uc();
    }

    public int fw() {
        int iUc = uc();
        int iHw = this.pr.hw() - this.pr.pr();
        if (iHw != 0) {
            return Math.round((iUc * 100.0f) / iHw);
        }
        return -1;
    }

    public void hw(double d) {
        int iHw = this.pr.hw();
        int iPr = this.pr.pr();
        int i = (int) d;
        if (d < iHw) {
            if (d > iPr) {
                iHw = i;
            } else {
                iHw = iPr;
            }
        }
        this.c = iHw;
        this.pr.pr(iHw);
    }

    @Override // com.byazt.rd.pr
    public JSONObject x() {
        return a.hw().wz();
    }

    @Override // com.byazt.rd.pr
    public boolean pr(int i) {
        JSONObject jSONObjectX = x();
        if (jSONObjectX == null) {
            return false;
        }
        double dPr = 1.0d;
        if (i == 1) {
            double dOptDouble = jSONObjectX.optDouble(Constants.VALUE_FIELD, 0.0d);
            if (dOptDouble <= -1.0d) {
                dPr = -1.0d;
            } else if (dOptDouble < 1.0d) {
                dPr = dOptDouble;
            }
        } else {
            if (i != 2) {
                return false;
            }
            dPr = pr(jSONObjectX);
        }
        if (dPr == 0.0d || dPr == -2.0d) {
            return false;
        }
        hw(((double) uc()) + (((double) (this.pr.hw() - this.pr.pr())) * dPr));
        return true;
    }

    private double pr(JSONObject jSONObject) {
        boolean z;
        if (jSONObject != null) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("applist");
            double dOptDouble = jSONObject.optDouble("content_factor", 0.0d);
            double dOptDouble2 = jSONObject.optDouble("duration_factor", 0.0d);
            double dOptDouble3 = jSONObject.optDouble("night_factor", 0.0d);
            double dOptDouble4 = jSONObject.optDouble("week_factor", 0.0d);
            double dOptDouble5 = jSONObject.optDouble("headset_factor", 0.0d);
            double dOptDouble6 = jSONObject.optDouble("factor", 0.0d);
            if (jSONArrayOptJSONArray != null && !TextUtils.isEmpty(this.hn) && jSONArrayOptJSONArray.toString().contains(this.hn)) {
                z = true;
            } else {
                z = false;
            }
            return pr(((((double) (z ? 1 : -1)) * dOptDouble) + (((double) (this.hw >= 10.0d ? 1 : -1)) * dOptDouble2) + (((double) (com.byazt.rd.hw.hw() ? 1 : -1)) * dOptDouble3) + (dOptDouble4 * ((double) (com.byazt.rd.hw.pr() ? 1 : -1))) + (((double) (this.pr.x() ? 1 : -1)) * dOptDouble5)) * dOptDouble6, jSONObject);
        }
        return -2.0d;
    }

    @Override // com.byazt.rd.pr
    public void hw(int i) {
        float fUc = hn.pr().uc();
        if (fUc != -2.0f) {
            int iHw = this.pr.hw();
            int iPr = this.pr.pr();
            int i2 = (int) fUc;
            if (fUc < iHw) {
                if (fUc > iPr) {
                    iHw = i2;
                } else {
                    iHw = iPr;
                }
            }
            this.c = iHw;
            this.pr.pr(iHw);
        }
    }

    @Override // com.byazt.rd.pr
    public boolean hw() {
        return hn.pr().x();
    }

    @Override // com.byazt.rd.pr
    public boolean hn() {
        int iFw = fw();
        if (iFw >= 94 || iFw <= 6) {
            return true;
        }
        return false;
    }
}
