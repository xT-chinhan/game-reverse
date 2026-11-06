package com.byazt.za;

import android.graphics.Color;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 18})
public class l {
    public static void n(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        JSONObject jSONObjectOptJSONObject;
        if ((jSONObject2 == null || (jSONObjectOptJSONObject = jSONObject2.optJSONObject("xAppInfo")) == null || jSONObjectOptJSONObject.optInt("themeStatus") != 1) ? false : true) {
            JSONObject jSONObjectOptJSONObject2 = (jSONObject2.optJSONObject("xSetting") == null || ((JSONObject) Objects.requireNonNull(jSONObject2.optJSONObject("xSetting"))).optJSONObject("dark_mode_config") == null) ? null : ((JSONObject) Objects.requireNonNull(jSONObject2.optJSONObject("xSetting"))).optJSONObject("dark_mode_config");
            if (jSONObjectOptJSONObject2 == null) {
                jSONObjectOptJSONObject2 = new JSONObject();
            }
            int iN = n(jSONObject.optString("backgroundColor"), jSONObjectOptJSONObject2);
            if (iN == 1) {
                jSONObject.put("backgroundColor", q(jSONObject.optString("backgroundColor"), jSONObjectOptJSONObject2));
            } else if (iN == 2) {
                jSONObject.put("backgroundColor", qg(jSONObject.optString("backgroundColor"), jSONObjectOptJSONObject2));
            }
            if (n(jSONObject.optString("textColor"), jSONObjectOptJSONObject2) == 1) {
                jSONObject.put("textColor", s(jSONObject.optString("textColor"), jSONObjectOptJSONObject2));
            }
        }
    }

    private static int n(String str, JSONObject jSONObject) {
        try {
            int iOptInt = jSONObject.optInt("luminance_upper", 90);
            int iOptInt2 = jSONObject.optInt("luminance_lower", 40);
            int iOptInt3 = jSONObject.optInt("gray_threshold", 20);
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int iN = com.byazt.hb.n.n(str);
            int iRed = Color.red(iN);
            int iGreen = Color.green(iN);
            int iBlue = Color.blue(iN);
            int iMax = Math.max(iRed, Math.max(iGreen, iBlue));
            int iMin = Math.min(iRed, Math.min(iGreen, iBlue));
            int i = (iMax + iMin) / 2;
            int i2 = iMax - iMin;
            if (i > iOptInt && i2 < iOptInt3) {
                return 2;
            }
            if (i < iOptInt2 && i2 < iOptInt3) {
                return 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private static String n(int i, int i2, int i3, int i4) {
        return String.format("#%02X%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    private static String qg(String str, JSONObject jSONObject) {
        int iN = com.byazt.hb.n.n(str);
        try {
            int iOptInt = jSONObject.optInt("gray_threshold", 20);
            int iOptInt2 = jSONObject.optInt("dark_gray_threshold", 30);
            int iRed = Color.red(iN);
            int iGreen = Color.green(iN);
            int iBlue = Color.blue(iN);
            int iAlpha = Color.alpha(iN);
            if (iAlpha < 0) {
                iAlpha = 1;
            }
            int iMax = Math.max(iRed, Math.max(iGreen, iBlue));
            int iMin = Math.min(iRed, Math.min(iGreen, iBlue));
            int i = 255 - iRed;
            int i2 = 255 - iGreen;
            int i3 = 255 - iBlue;
            if (iMax - iMin < iOptInt) {
                return n(iAlpha, i, i2, i3);
            }
            return n(iAlpha, iOptInt2, iOptInt2, iOptInt2);
        } catch (Exception unused) {
            return str;
        }
    }

    private static String s(String str, JSONObject jSONObject) {
        int iN = com.byazt.hb.n.n(str);
        try {
            int iOptInt = jSONObject.optInt("gray_threshold", 20);
            int iOptInt2 = jSONObject.optInt("light_gray_threshold", 225);
            int iRed = Color.red(iN);
            int iGreen = Color.green(iN);
            int iBlue = Color.blue(iN);
            int iAlpha = Color.alpha(iN);
            if (iAlpha < 0) {
                iAlpha = 1;
            }
            int iMax = Math.max(iRed, Math.max(iGreen, iBlue));
            int iMin = Math.min(iRed, Math.min(iGreen, iBlue));
            int i = 255 - iRed;
            int i2 = 255 - iGreen;
            int i3 = 255 - iBlue;
            if (iMax - iMin < iOptInt) {
                return n(iAlpha, i, i2, i3);
            }
            return n(iAlpha, iOptInt2, iOptInt2, iOptInt2);
        } catch (Exception unused) {
            return str;
        }
    }

    private static String q(String str, JSONObject jSONObject) {
        int iN = com.byazt.hb.n.n(str);
        try {
            int iOptInt = jSONObject.optInt("black_bright_offset", 20);
            int iRed = Color.red(iN);
            int iGreen = Color.green(iN);
            int iBlue = Color.blue(iN);
            int iAlpha = Color.alpha(iN);
            int iMax = Math.max(0, Math.min(100, iOptInt));
            return n(iAlpha, Math.min(255, iRed + ((255 - iRed) * (iMax / 100))), Math.min(255, iGreen + ((255 - iGreen) * (iMax / 100))), Math.min(255, iBlue + ((255 - iBlue) * (iMax / 100))));
        } catch (Exception unused) {
            return str;
        }
    }
}
