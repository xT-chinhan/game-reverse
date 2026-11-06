package com.byazt.qx;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 121})
public class x {
    public static void pr(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        boolean z;
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject2 != null && (jSONObjectOptJSONObject = jSONObject2.optJSONObject("xAppInfo")) != null && jSONObjectOptJSONObject.optInt("themeStatus") == 1) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return;
        }
        JSONObject jSONObject3 = null;
        if (jSONObject2.optJSONObject("xSetting") != null && ((JSONObject) Objects.requireNonNull(jSONObject2.optJSONObject("xSetting"))).optJSONObject("dark_mode_config") != null) {
            jSONObject3 = ((JSONObject) Objects.requireNonNull(jSONObject2.optJSONObject("xSetting"))).optJSONObject("dark_mode_config");
        }
        if (jSONObject3 == null) {
            jSONObject3 = new JSONObject();
        }
        switch (pr(jSONObject.optString("backgroundColor"), jSONObject3)) {
            case 1:
                jSONObject.put("backgroundColor", x(jSONObject.optString("backgroundColor"), jSONObject3));
                break;
            case 2:
                jSONObject.put("backgroundColor", hw(jSONObject.optString("backgroundColor"), jSONObject3));
                break;
        }
        if (pr(jSONObject.optString("textColor"), jSONObject3) == 1) {
            jSONObject.put("textColor", hn(jSONObject.optString("textColor"), jSONObject3));
        }
    }

    private static int pr(String str, JSONObject jSONObject) {
        try {
            int iOptInt = jSONObject.optInt("luminance_upper", 90);
            int iOptInt2 = jSONObject.optInt("luminance_lower", 40);
            int iOptInt3 = jSONObject.optInt("gray_threshold", 20);
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int iPr = com.byazt.aa.pr.pr(str);
            int iRed = Color.red(iPr);
            int iGreen = Color.green(iPr);
            int iBlue = Color.blue(iPr);
            int iMax = Math.max(iRed, Math.max(iGreen, iBlue));
            int iMin = Math.min(iRed, Math.min(iGreen, iBlue));
            int i = (iMax + iMin) / 2;
            int i2 = iMax - iMin;
            if (i > iOptInt && i2 < iOptInt3) {
                return 2;
            }
            if (i >= iOptInt2 || i2 >= iOptInt3) {
                return 0;
            }
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    private static String pr(int i, int i2, int i3, int i4) {
        return String.format("#%02X%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    private static String hw(String str, JSONObject jSONObject) {
        int iPr = com.byazt.aa.pr.pr(str);
        try {
            int iOptInt = jSONObject.optInt("gray_threshold", 20);
            int iOptInt2 = jSONObject.optInt("dark_gray_threshold", 30);
            int iRed = Color.red(iPr);
            int iGreen = Color.green(iPr);
            int iBlue = Color.blue(iPr);
            int iAlpha = Color.alpha(iPr);
            if (iAlpha < 0) {
                iAlpha = 1;
            }
            int iMax = Math.max(iRed, Math.max(iGreen, iBlue));
            int iMin = Math.min(iRed, Math.min(iGreen, iBlue));
            int i = 255 - iRed;
            int i2 = 255 - iGreen;
            int i3 = 255 - iBlue;
            if (iMax - iMin < iOptInt) {
                return pr(iAlpha, i, i2, i3);
            }
            return pr(iAlpha, iOptInt2, iOptInt2, iOptInt2);
        } catch (Exception e) {
            return str;
        }
    }

    private static String hn(String str, JSONObject jSONObject) {
        int iPr = com.byazt.aa.pr.pr(str);
        try {
            int iOptInt = jSONObject.optInt("gray_threshold", 20);
            int iOptInt2 = jSONObject.optInt("light_gray_threshold", 225);
            int iRed = Color.red(iPr);
            int iGreen = Color.green(iPr);
            int iBlue = Color.blue(iPr);
            int iAlpha = Color.alpha(iPr);
            if (iAlpha < 0) {
                iAlpha = 1;
            }
            int iMax = Math.max(iRed, Math.max(iGreen, iBlue));
            int iMin = Math.min(iRed, Math.min(iGreen, iBlue));
            int i = 255 - iRed;
            int i2 = 255 - iGreen;
            int i3 = 255 - iBlue;
            if (iMax - iMin < iOptInt) {
                return pr(iAlpha, i, i2, i3);
            }
            return pr(iAlpha, iOptInt2, iOptInt2, iOptInt2);
        } catch (Exception e) {
            return str;
        }
    }

    private static String x(String str, JSONObject jSONObject) {
        int iPr = com.byazt.aa.pr.pr(str);
        try {
            int iOptInt = jSONObject.optInt("black_bright_offset", 20);
            int iRed = Color.red(iPr);
            int iGreen = Color.green(iPr);
            int iBlue = Color.blue(iPr);
            int iAlpha = Color.alpha(iPr);
            int iMax = Math.max(0, Math.min(100, iOptInt));
            return pr(iAlpha, Math.min(255, iRed + ((255 - iRed) * (iMax / 100))), Math.min(255, iGreen + ((255 - iGreen) * (iMax / 100))), Math.min(255, iBlue + ((255 - iBlue) * (iMax / 100))));
        } catch (Exception e) {
            return str;
        }
    }
}
