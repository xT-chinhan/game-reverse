package com.byazt.yl;

import com.byazt.ak.x;
import com.byazt.hg.of;
import com.byazt.vkw.hn;
import com.byazt.zs.uc;
import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 687, 37})
public class pr {
    public static Object pr(int i, int i2) {
        hn hnVar = (hn) uc.pr("embed_applog");
        if (i != 1) {
            return null;
        }
        switch (i2) {
            case 1001:
                return hnVar.pr();
            case 1002:
                return hnVar.pr(false);
            default:
                return null;
        }
    }

    public static JSONObject pr(int... iArr) {
        if (iArr != null) {
            try {
                if (iArr.length != 0) {
                    JSONObject jSONObject = new JSONObject();
                    for (int i : iArr) {
                        Object objPr = pr(1, i);
                        switch (i) {
                            case 1001:
                                jSONObject.putOpt("did", objPr);
                                break;
                            case 1002:
                                jSONObject.putOpt("oaid", objPr);
                                break;
                        }
                    }
                    return jSONObject;
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static void pr(int i, int i2, String str, of ofVar) {
        if (i != 2 || ofVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            new JSONObject().putOpt("union_key", ofVar.le());
            if (i2 == 2001) {
                new x.c.pr().pr(jSONObject.optDouble("x", 0.0d)).hw(jSONObject.optDouble("y", 0.0d)).hn(jSONObject.optDouble(an.aD, 0.0d)).pr(ofVar.le()).pr(jSONObject.optLong("ts", 0L)).pr();
            } else if (i2 == 2002) {
                new x.C0015x.pr().pr(jSONObject.optDouble("x", 0.0d)).hw(jSONObject.optDouble("y", 0.0d)).hn(jSONObject.optDouble(an.aD, 0.0d)).pr(ofVar.le()).pr(jSONObject.optLong("ts", 0L)).pr();
            } else if (i2 == 2003) {
                new x.hn.pr().pr(jSONObject.optDouble("yaw", 0.0d)).hw(jSONObject.optDouble("pitch", 0.0d)).hn(jSONObject.optDouble("roll", 0.0d)).pr(ofVar.le()).pr(jSONObject.optLong("ts", 0L)).pr();
            }
        } catch (Throwable th) {
        }
    }
}
