package com.byazt.vhv;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.lk.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME, 19})
public class n implements com.byazt.gh.qg {
    public static volatile n n;

    private n() {
    }

    public static n qg() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    @Override // com.byazt.gh.qg
    public String n() {
        return q.x().qg();
    }

    @Override // com.byazt.gh.qg
    public String n(String str, String str2) {
        return l.n(null, n()).getString(str, "");
    }

    @Override // com.byazt.gh.qg
    public void n(String str, String str2, String str3) {
        l.n(null, n()).n(str, str2);
    }

    public void n(int i, int i2, int i3, int i4, double d, double d2, double d3, int i5) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        String strN;
        String strN2;
        String strN3;
        String strN4 = n("x_rotation_".concat(String.valueOf(i5)), (String) null);
        String strN5 = n("y_rotation_".concat(String.valueOf(i5)), (String) null);
        String str = "z_rotation_";
        String strN6 = n("z_rotation_".concat(String.valueOf(i5)), (String) null);
        double dRound = Math.round(d * 100.0d) / 100.0d;
        double dRound2 = Math.round(d2 * 100.0d) / 100.0d;
        double dRound3 = Math.round(d3 * 100.0d) / 100.0d;
        String string = new StringBuilder().append(n(i, i2, i3, i4)).toString();
        try {
            if (TextUtils.isEmpty(strN4)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(strN4);
            }
            try {
                if (TextUtils.isEmpty(strN5)) {
                    jSONObject2 = new JSONObject();
                } else {
                    jSONObject2 = new JSONObject(strN5);
                }
                try {
                    if (TextUtils.isEmpty(strN6)) {
                        jSONObject3 = new JSONObject();
                    } else {
                        jSONObject3 = new JSONObject(strN6);
                    }
                    try {
                        String strOptString = jSONObject.optString(string);
                        String strOptString2 = jSONObject2.optString(string);
                        str = "z_rotation_";
                        try {
                            String strOptString3 = jSONObject3.optString(string);
                            if (TextUtils.isEmpty(strOptString)) {
                                strN = String.valueOf(dRound);
                            } else {
                                strN = n(strOptString, dRound);
                            }
                            if (TextUtils.isEmpty(strOptString2)) {
                                strN2 = String.valueOf(dRound2);
                            } else {
                                strN2 = n(strOptString2, dRound2);
                            }
                            if (TextUtils.isEmpty(strOptString3)) {
                                strN3 = String.valueOf(dRound3);
                            } else {
                                strN3 = n(strOptString3, dRound3);
                            }
                            jSONObject.put(string, strN);
                            jSONObject2.put(string, strN2);
                            jSONObject3.put(string, strN3);
                        } catch (JSONException unused) {
                        }
                    } catch (JSONException unused2) {
                        str = "z_rotation_";
                    }
                } catch (JSONException unused3) {
                    str = "z_rotation_";
                    jSONObject3 = null;
                }
            } catch (JSONException unused4) {
                jSONObject2 = null;
                jSONObject3 = null;
                if (jSONObject != null) {
                    return;
                } else {
                    return;
                }
            }
        } catch (JSONException unused5) {
            jSONObject = null;
        }
        if (jSONObject != null || jSONObject2 == null || jSONObject3 == null) {
            return;
        }
        n("x_rotation_".concat(String.valueOf(i5)), jSONObject.toString(), null);
        n("y_rotation_".concat(String.valueOf(i5)), jSONObject2.toString(), null);
        n(str.concat(String.valueOf(i5)), jSONObject3.toString(), null);
    }

    public String n(String str, int i) {
        String strN = n("x_rotation_".concat(String.valueOf(i)), (String) null);
        try {
            if (!TextUtils.isEmpty(strN)) {
                return new JSONObject(strN).optString(str);
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    public String qg(String str, int i) {
        String strN = n("y_rotation_".concat(String.valueOf(i)), (String) null);
        try {
            if (!TextUtils.isEmpty(strN)) {
                return new JSONObject(strN).optString(str);
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    public String s(String str, int i) {
        String strN = n("z_rotation_".concat(String.valueOf(i)), (String) null);
        try {
            if (!TextUtils.isEmpty(strN)) {
                return new JSONObject(strN).optString(str);
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    private String n(String str, double d) {
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length > 18) {
            strArrSplit = (String[]) Arrays.copyOfRange(strArrSplit, strArrSplit.length - 18, strArrSplit.length);
        }
        String strJoin = TextUtils.join(",", strArrSplit);
        return TextUtils.isEmpty(strJoin) ? String.valueOf(d) : strJoin + "," + d;
    }

    public int n(int i, int i2, int i3, int i4) {
        int iW = (((i2 + (i4 / 2)) / (com.byazt.okk.s.w((Context) null) / 4)) * 2) + ((i + (i3 / 2) < com.byazt.okk.s.l((Context) null) / 2 ? 1 : 0) ^ 1);
        if (iW >= 8) {
            return 7;
        }
        return iW;
    }
}
