package com.byazt.ak;

import android.content.Context;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import com.byazt.wt.er;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, 37})
public class pr implements com.byazt.ba.hw {
    public static volatile pr pr;

    private pr() {
    }

    public static pr hw() {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr = new pr();
                }
            }
        }
        return pr;
    }

    @Override // com.byazt.ba.hw
    public String pr() {
        return x.fw().hw();
    }

    @Override // com.byazt.ba.hw
    public String pr(String str, String str2) {
        return com.byazt.qn.x.pr(null, pr()).getString(str, "");
    }

    @Override // com.byazt.ba.hw
    public void pr(String str, String str2, String str3) {
        com.byazt.qn.x.pr(null, pr()).pr(str, str2);
    }

    public void pr(int i, int i2, int i3, int i4, double d, double d2, double d3, int i5) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        String strPr;
        String strPr2;
        String strPr3;
        String strPr4 = pr("x_rotation_".concat(String.valueOf(i5)), (String) null);
        String strPr5 = pr("y_rotation_".concat(String.valueOf(i5)), (String) null);
        String str = "z_rotation_";
        String strPr6 = pr("z_rotation_".concat(String.valueOf(i5)), (String) null);
        double dRound = Math.round(d * 100.0d) / 100.0d;
        double dRound2 = Math.round(d2 * 100.0d) / 100.0d;
        double dRound3 = Math.round(d3 * 100.0d) / 100.0d;
        String string = new StringBuilder().append(pr(i, i2, i3, i4)).toString();
        try {
            if (TextUtils.isEmpty(strPr4)) {
                jSONObject3 = new JSONObject();
            } else {
                jSONObject3 = new JSONObject(strPr4);
            }
            try {
                if (TextUtils.isEmpty(strPr5)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(strPr5);
                }
                try {
                    if (TextUtils.isEmpty(strPr6)) {
                        jSONObject2 = new JSONObject();
                    } else {
                        jSONObject2 = new JSONObject(strPr6);
                    }
                    try {
                        String strOptString = jSONObject3.optString(string);
                        String strOptString2 = jSONObject.optString(string);
                        str = "z_rotation_";
                        try {
                            String strOptString3 = jSONObject2.optString(string);
                            if (TextUtils.isEmpty(strOptString)) {
                                strPr = String.valueOf(dRound);
                            } else {
                                strPr = pr(strOptString, dRound);
                            }
                            if (TextUtils.isEmpty(strOptString2)) {
                                strPr2 = String.valueOf(dRound2);
                            } else {
                                strPr2 = pr(strOptString2, dRound2);
                            }
                            if (TextUtils.isEmpty(strOptString3)) {
                                strPr3 = String.valueOf(dRound3);
                            } else {
                                strPr3 = pr(strOptString3, dRound3);
                            }
                            jSONObject3.put(string, strPr);
                            jSONObject.put(string, strPr2);
                            jSONObject2.put(string, strPr3);
                        } catch (JSONException e) {
                        }
                    } catch (JSONException e2) {
                        str = "z_rotation_";
                    }
                } catch (JSONException e3) {
                    jSONObject2 = null;
                }
            } catch (JSONException e4) {
                jSONObject = null;
            }
        } catch (JSONException e5) {
            str = "z_rotation_";
            jSONObject = null;
            jSONObject2 = null;
            jSONObject3 = null;
        }
        if (jSONObject3 != null && jSONObject != null && jSONObject2 != null) {
            pr("x_rotation_".concat(String.valueOf(i5)), jSONObject3.toString(), null);
            pr("y_rotation_".concat(String.valueOf(i5)), jSONObject.toString(), null);
            pr(str.concat(String.valueOf(i5)), jSONObject2.toString(), null);
        }
    }

    public String pr(String str, int i) {
        String strPr = pr("x_rotation_".concat(String.valueOf(i)), (String) null);
        try {
            if (!TextUtils.isEmpty(strPr)) {
                return new JSONObject(strPr).optString(str);
            }
        } catch (JSONException e) {
        }
        return null;
    }

    public String hw(String str, int i) {
        String strPr = pr("y_rotation_".concat(String.valueOf(i)), (String) null);
        try {
            if (!TextUtils.isEmpty(strPr)) {
                return new JSONObject(strPr).optString(str);
            }
        } catch (JSONException e) {
        }
        return null;
    }

    public String hn(String str, int i) {
        String strPr = pr("z_rotation_".concat(String.valueOf(i)), (String) null);
        try {
            if (!TextUtils.isEmpty(strPr)) {
                return new JSONObject(strPr).optString(str);
            }
        } catch (JSONException e) {
        }
        return null;
    }

    private String pr(String str, double d) {
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length > 18) {
            strArrSplit = (String[]) Arrays.copyOfRange(strArrSplit, strArrSplit.length - 18, strArrSplit.length);
        }
        String strJoin = TextUtils.join(",", strArrSplit);
        return TextUtils.isEmpty(strJoin) ? String.valueOf(d) : strJoin + "," + d;
    }

    public int pr(int i, int i2, int i3, int i4) {
        int iUc = (((i2 + (i4 / 2)) / (er.uc((Context) null) / 4)) * 2) + ((i + (i3 / 2) < er.c((Context) null) / 2 ? 1 : 0) ^ 1);
        if (iUc >= 8) {
            return 7;
        }
        return iUc;
    }
}
