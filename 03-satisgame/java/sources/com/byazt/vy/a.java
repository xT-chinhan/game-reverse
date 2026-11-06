package com.byazt.vy;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
public class a {
    private static com.byazt.gwu.s s() {
        try {
            if (com.byazt.qt.n.d() != null) {
                return com.byazt.lk.l.n(null, "gm_evt_upload_info");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void n(String str, boolean z, long j, String str2) {
        JSONObject jSONObject;
        try {
            com.byazt.gwu.s sVarS = s();
            if (sVarS == null) {
                return;
            }
            String string = sVarS.getString(str, "");
            if (TextUtils.isEmpty(string)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(string);
            }
            int i = 1;
            if (z) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("success");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                    jSONObject.put("success", jSONObjectOptJSONObject);
                }
                int iOptInt = jSONObjectOptJSONObject.optInt("times", -1);
                if (iOptInt != -1) {
                    i = 1 + iOptInt;
                }
                jSONObjectOptJSONObject.put("times", i);
                if (j <= 10000) {
                    long jOptInt = jSONObjectOptJSONObject.optInt("avg_req_duration", -1);
                    if (jOptInt != -1) {
                        j = ((jOptInt * ((long) (i - 1))) + j) / ((long) i);
                    }
                    jSONObjectOptJSONObject.put("avg_req_duration", j);
                }
            } else {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("fail");
                if (jSONObjectOptJSONObject2 == null) {
                    jSONObjectOptJSONObject2 = new JSONObject();
                    jSONObject.put("fail", jSONObjectOptJSONObject2);
                }
                int iOptInt2 = jSONObjectOptJSONObject2.optInt("times", -1);
                jSONObjectOptJSONObject2.put("times", iOptInt2 == -1 ? 1 : iOptInt2 + 1);
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("error_code");
                if (jSONObjectOptJSONObject3 == null) {
                    jSONObjectOptJSONObject3 = new JSONObject();
                    jSONObjectOptJSONObject2.put("error_code", jSONObjectOptJSONObject3);
                }
                int iOptInt3 = jSONObjectOptJSONObject3.optInt(str2, -1);
                if (iOptInt3 != -1) {
                    i = 1 + iOptInt3;
                }
                jSONObjectOptJSONObject3.put(str2, i);
            }
            sVarS.n(str, jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public static JSONObject n(String str) {
        try {
            com.byazt.gwu.s sVarS = s();
            if (sVarS == null) {
                return null;
            }
            String string = sVarS.getString(str, "");
            if (!TextUtils.isEmpty(string)) {
                sVarS.n(str);
                return new JSONObject(string);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void n(String str, long j) {
        JSONObject jSONObject;
        try {
            com.byazt.gwu.s sVarS = s();
            if (sVarS == null) {
                return;
            }
            String string = sVarS.getString("init_time", "");
            if (TextUtils.isEmpty(string)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(string);
            }
            jSONObject.put(str, j);
            sVarS.n("init_time", jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public static JSONObject n() {
        try {
            com.byazt.gwu.s sVarS = s();
            if (sVarS == null) {
                return null;
            }
            String string = sVarS.getString("init_time", "");
            if (!TextUtils.isEmpty(string)) {
                sVarS.n("init_time");
                return new JSONObject(string);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void n(int i, int i2) {
        try {
            com.byazt.gwu.s sVarS = s();
            if (sVarS == null) {
                return;
            }
            int i3 = sVarS.getInt("low_m_cnt", 0);
            int i4 = sVarS.getInt("clean_invalid_cnt", 0);
            int i5 = sVarS.getInt("force_clean_cnt", 0) + i2;
            sVarS.n("low_m_cnt", i3 + 1);
            sVarS.n("clean_invalid_cnt", i4 + i);
            sVarS.n("force_clean_cnt", i5);
        } catch (Throwable unused) {
        }
    }

    public static void n(Map<String, Object> map) {
        try {
            com.byazt.gwu.s sVarS = s();
            if (sVarS == null) {
                return;
            }
            int i = sVarS.getInt("low_m_cnt", 0);
            int i2 = sVarS.getInt("clean_invalid_cnt", 0);
            int i3 = sVarS.getInt("force_clean_cnt", 0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("low_m_cnt", i);
            jSONObject.put("invalid_cnt", i2);
            jSONObject.put("force_cnt", i3);
            map.put("low_m_clean", jSONObject);
            sVarS.n("low_m_cnt", 0);
            sVarS.n("clean_invalid_cnt", 0);
            sVarS.n("force_clean_cnt", 0);
        } catch (Throwable unused) {
        }
    }

    public static void qg(Map<String, Object> map) {
        try {
            Context context = com.byazt.qt.qg.getContext();
            SharedPreferences sharedPreferencesQg = com.byazt.qyu.qg.qg((Context) com.byazt.rb.n.n(context), "cb_test", 0);
            String string = sharedPreferencesQg.getString(MediationConstant.ADN_KS, "");
            String string2 = sharedPreferencesQg.getString(MediationConstant.ADN_GDT, "");
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                sharedPreferencesQg = com.byazt.qyu.qg.qg(context, "cb_test", 0);
                string = sharedPreferencesQg.getString(MediationConstant.ADN_KS, "");
                string2 = sharedPreferencesQg.getString(MediationConstant.ADN_GDT, "");
            }
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put(MediationConstant.ADN_KS, string);
            }
            if (!TextUtils.isEmpty(string2)) {
                jSONObject.put(MediationConstant.ADN_GDT, string2);
            }
            map.put("cb_stacktrace", jSONObject);
            sharedPreferencesQg.edit().clear().apply();
        } catch (Throwable unused) {
        }
    }

    public static int qg() {
        try {
            com.byazt.gwu.s sVarS = s();
            if (sVarS == null) {
                return 0;
            }
            int iQg = sVarS.qg("init_count", 0);
            if (iQg == 0) {
                sVarS.n("init_count", 1);
            }
            return iQg;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
