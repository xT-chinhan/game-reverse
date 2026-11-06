package com.bytedance.sdk.component.adexpress.dynamic.d;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.mobads.sdk.internal.cm;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.sdk.component.adexpress.xr.zb;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.t;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class hi {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Set<String> f787ms = Collections.unmodifiableSet(new HashSet(Arrays.asList("dislike", ILivePush.ClickType.CLOSE, "close-fill", "webview-close")));
    private static String xr;

    /* JADX WARN: Code duplicated, block: B:218:0x0484  */
    /* JADX WARN: Code duplicated, block: B:221:0x0492 A[Catch: Exception -> 0x04a3, JSONException -> 0x04a8, TryCatch #2 {JSONException -> 0x04a8, blocks: (B:177:0x03a4, B:179:0x0404, B:181:0x0409, B:183:0x0411, B:191:0x0426, B:193:0x042d, B:195:0x0439, B:197:0x0441, B:200:0x0448, B:204:0x0452, B:210:0x0466, B:212:0x046e, B:214:0x0474, B:216:0x047c, B:228:0x04a3, B:219:0x0488, B:221:0x0492, B:226:0x049c, B:206:0x045b), top: B:276:0x03a4 }] */
    /* JADX WARN: Code duplicated, block: B:223:0x0498 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:225:0x049b  */
    public static xr.ah ms(String str, String str2, String str3, boolean z, boolean z2, int i, com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar, double d, int i2, double d2, String str4, zb zbVar) {
        int i3;
        int i4;
        float f;
        float f2;
        xr.ah ahVarMs;
        int i5;
        com.bytedance.sdk.component.adexpress.dynamic.ah.c cVarKa;
        String strOptString = str;
        int i6 = i;
        String strC = zbVar.c();
        int iCh = zbVar.ch();
        if (com.bytedance.sdk.component.adexpress.d.ms() && i2 != 4 && (TextUtils.equals(str2, "text_star") || TextUtils.equals(str2, "score-count") || TextUtils.equals(str2, "score-count-type-1") || TextUtils.equals(str2, "score-count-type-2"))) {
            return new xr.ah(0.0f, 0.0f);
        }
        xr.ah ahVar = new xr.ah();
        if (strOptString.startsWith("<svg") || f787ms.contains(str2)) {
            try {
                if (ILivePush.ClickType.CLOSE.equals(str2) || (com.bytedance.sdk.component.adexpress.d.ms() && "close-fill".equals(str2))) {
                    float fOptDouble = (float) new JSONObject(str3).optDouble("fontSize");
                    ahVar.f791ms = fOptDouble;
                    ahVar.xr = fOptDouble;
                    return ahVar;
                }
            } catch (Exception unused) {
            }
            ahVar.f791ms = 10.0f;
            ahVar.xr = 10.0f;
            return ahVar;
        }
        if ("logo".equals(str2)) {
            if (!com.bytedance.sdk.component.adexpress.d.ms() && ((!TextUtils.isEmpty(str) && strOptString.contains("adx:")) || xr())) {
                if (xr()) {
                    return ms(ahVar, strOptString, str3, xr);
                }
                return ms(ahVar, strOptString, str3, "");
            }
            ahVar.f791ms = "union".equals(strOptString) ? 10.0f : 20.0f;
            ahVar.xr = 10.0f;
            if (com.bytedance.sdk.component.adexpress.d.ms()) {
                String str5 = str2 + strOptString;
                float fXr = (float) xr(str3);
                if (str5.contains("logoad")) {
                    return ms(t.ms(com.bytedance.sdk.component.adexpress.d.getContext(), "tt_logo_en"), str3);
                }
                ahVar.xr = fXr;
            }
            return ahVar;
        }
        if ("development-name".equals(str2)) {
            strOptString = t.ms(com.bytedance.sdk.component.adexpress.d.getContext(), "tt_text_privacy_development") + strOptString;
        }
        if ("app-version".equals(str2)) {
            strOptString = t.ms(com.bytedance.sdk.component.adexpress.d.getContext(), "tt_text_privacy_app_version") + strOptString;
        }
        if ("score-count".equals(str2)) {
            try {
                i3 = Integer.parseInt(strOptString);
            } catch (NumberFormatException unused2) {
                i3 = 0;
            }
            if (com.bytedance.sdk.component.adexpress.d.ms() && i3 < 0) {
                return new xr.ah(0.0f, 0.0f);
            }
            return ms("(" + String.format(t.ms(com.bytedance.sdk.component.adexpress.d.getContext(), "tt_comment_num"), Integer.valueOf(i3)) + ")", str3);
        }
        if ("score-count-type-2".equals(str2)) {
            try {
                i4 = Integer.parseInt(strOptString);
            } catch (NumberFormatException unused3) {
                i4 = 0;
            }
            if (com.bytedance.sdk.component.adexpress.d.ms() && i4 < 0) {
                return new xr.ah(0.0f, 0.0f);
            }
            return ms("(" + String.format(new DecimalFormat("###,###,###").format(i4), Integer.valueOf(i4)) + ")", str3);
        }
        if ("feedback-dislike".equals(str2)) {
            if (com.bytedance.sdk.component.adexpress.d.ms()) {
                xr.ah ahVar2 = new xr.ah();
                float fXr2 = (float) xr(str3);
                ahVar2.f791ms = fXr2;
                ahVar2.xr = fXr2;
                return ahVar2;
            }
            return ms(t.ms(com.bytedance.sdk.component.adexpress.d.getContext(), "tt_reward_feedback"), str3);
        }
        if ("skip-with-time-countdown".equals(str2) || TextUtils.equals("skip-with-countdowns-video-countdown", str2)) {
            if (zbVar.ah() && com.bytedance.sdk.component.adexpress.d.ab.xr(strC)) {
                if (((int) (d + 0.5d)) - iCh < 10) {
                    return com.bytedance.sdk.component.adexpress.d.ms() ? ms("0s", str3) : ms(String.format(t.ms(com.bytedance.sdk.component.adexpress.d.getContext(), "tt_reward_full_skip"), "0"), str3);
                }
                return com.bytedance.sdk.component.adexpress.d.ms() ? ms("00s", str3) : ms(String.format(t.ms(com.bytedance.sdk.component.adexpress.d.getContext(), "tt_reward_full_skip"), "00"), str3);
            }
            if (d < 10.0d) {
                return ms("0S", str3);
            }
            return ms("00S", str3);
        }
        if (TextUtils.equals("skip-with-countdowns-skip-btn", str2)) {
            return ms("| " + t.ms(com.bytedance.sdk.component.adexpress.d.getContext(), "tt_reward_screen_skip_tx"), str3);
        }
        if (TextUtils.equals("skip-with-countdowns-skip-countdown", str2)) {
            return ms("| ".concat(String.valueOf(String.format(t.ms(com.bytedance.sdk.component.adexpress.d.getContext(), "tt_reward_full_skip_count_down"), "00"))), str3);
        }
        if ("skip-with-time-skip-btn".equals(str2)) {
            xr.ah ahVarMs2 = ms("| " + t.ms(com.bytedance.sdk.component.adexpress.d.getContext(), "tt_reward_screen_skip_tx"), str3);
            if (com.bytedance.sdk.component.adexpress.d.ms()) {
                try {
                    ahVarMs2.xr = (float) ((((double) ahVarMs2.xr) * new JSONObject(str3).optDouble("lineHeight")) / 1.2d);
                } catch (Throwable unused4) {
                }
                ahVarMs2.f791ms = ahVarMs2.xr;
            }
            return ahVarMs2;
        }
        if ("skip".equals(str2)) {
            return ms(t.ms(com.bytedance.sdk.component.adexpress.d.getContext(), "tt_reward_screen_skip_tx"), str3);
        }
        if ("timedown".equals(str2)) {
            return ms(cm.d, str3);
        }
        if ("text_star".equals(str2)) {
            if (com.bytedance.sdk.component.adexpress.d.ms() && (d2 < 0.0d || d2 > 5.0d)) {
                return new xr.ah(0.0f, 0.0f);
            }
            return ms(cm.d, str3);
        }
        if (TextUtils.equals("privacy-detail", str2)) {
            return ms("功能 | 权限 | 隐私", str3);
        }
        if ("arrowButton".equals(str2)) {
            return ms("Download", str3);
        }
        if ("text".equals(str2) && com.bytedance.sdk.component.adexpress.d.ms() && TextUtils.isEmpty(strOptString) && (cVarKa = xVar.ch().ka()) != null) {
            strOptString = cVarKa.sk() != null ? xVar.ch().ka().sk().optString(com.bytedance.sdk.component.adexpress.d.x.d(com.bytedance.sdk.component.adexpress.d.getContext())) : "";
        }
        if ("fillButton".equals(str2) || "text".equals(str2) || "button".equals(str2) || "downloadWithIcon".equals(str2) || "downloadButton".equals(str2) || "laceButton".equals(str2) || "cardButton".equals(str2) || "colourMixtureButton".equals(str2) || "arrowButton".equals(str2) || (("source".equals(str2) && (!com.bytedance.sdk.component.adexpress.d.ms() || !"open_ad".equals(strC))) || TextUtils.equals("app-version", str2) || TextUtils.equals("development-name", str2))) {
            return ms(strOptString, str3);
        }
        try {
            JSONObject jSONObject = new JSONObject(str3);
            int length = strOptString.length();
            float fOptDouble2 = (float) jSONObject.optDouble("fontSize");
            float fOptDouble3 = (float) jSONObject.optDouble("letterSpacing");
            float fOptDouble4 = (float) jSONObject.optDouble("lineHeight");
            float fOptDouble5 = (float) jSONObject.optDouble("maxWidth");
            float f3 = (length * (fOptDouble2 + fOptDouble3)) - fOptDouble3;
            sl.d("DynamicBaseWidget", "getDomSizeFromNative letterSpacing==" + fOptDouble3 + ",lineHeight==" + fOptDouble4 + ",maxWidth ==" + fOptDouble5 + ",totalStrLength" + f3);
            if ("muted".equals(str2)) {
                ahVar.f791ms = fOptDouble2;
                ahVar.xr = fOptDouble2;
                return ahVar;
            }
            if ("star".equals(str2)) {
                if (com.bytedance.sdk.component.adexpress.d.ms() && (d2 < 0.0d || d2 > 5.0d || i2 != 4)) {
                    return new xr.ah(0.0f, 0.0f);
                }
                xr.ah ahVarMs3 = ms("str", str3);
                ahVarMs3.f791ms = fOptDouble2 * 5.0f;
                return ahVarMs3;
            }
            if ("icon".equals(str2)) {
                ahVar.f791ms = fOptDouble2;
                ahVar.xr = fOptDouble2;
                return ahVar;
            }
            if (!z) {
                f = (float) (((double) (fOptDouble4 * fOptDouble2)) * 1.2d);
                if (f3 <= fOptDouble5) {
                    f2 = f3;
                }
                if (!"title".equals(str2) || (com.bytedance.sdk.component.adexpress.d.ms() && "open_ad".equals(strC) && "source".equals(str2))) {
                    try {
                        ahVarMs = ms(strOptString.replace('\n', ' '), str3, false);
                        if (z) {
                            i5 = ((int) (f3 / fOptDouble5)) + 1;
                            if (z2 || i5 < i6) {
                                i6 = i5;
                            }
                            ahVarMs.xr *= i6;
                        }
                        return ahVarMs;
                    } catch (Exception unused5) {
                    }
                }
                ahVar.f791ms = f2;
                ahVar.xr = f;
                return ahVar;
            }
            int i7 = ((int) (f3 / fOptDouble5)) + 1;
            if (z2 && i7 >= i6) {
                i7 = i6;
            }
            f = (float) (((double) (fOptDouble4 * fOptDouble2 * i7)) * 1.2d);
            f2 = fOptDouble5;
            if (!"title".equals(str2)) {
                ahVarMs = ms(strOptString.replace('\n', ' '), str3, false);
                if (z) {
                    i5 = ((int) (f3 / fOptDouble5)) + 1;
                    if (z2) {
                        i6 = i5;
                    } else {
                        i6 = i5;
                    }
                    ahVarMs.xr *= i6;
                }
                return ahVarMs;
            }
            ahVarMs = ms(strOptString.replace('\n', ' '), str3, false);
            if (z) {
                i5 = ((int) (f3 / fOptDouble5)) + 1;
                if (z2) {
                    i6 = i5;
                } else {
                    i6 = i5;
                }
                ahVarMs.xr *= i6;
            }
            return ahVarMs;
            return ahVar;
        } catch (JSONException e) {
            sl.ms(e);
        }
    }

    public static String ms(String str) {
        String[] strArrSplit;
        return (TextUtils.isEmpty(str) || (strArrSplit = str.split("adx:")) == null || strArrSplit.length < 2) ? "" : strArrSplit[1];
    }

    private static xr.ah ms(xr.ah ahVar, String str, String str2, String str3) {
        if (str.contains("union")) {
            ahVar.f791ms = 0.0f;
            ahVar.xr = 0.0f;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = ms(str);
            }
            if (TextUtils.isEmpty(str3)) {
                ahVar.f791ms = 0.0f;
                ahVar.xr = 0.0f;
            } else {
                return ms(str3, str2);
            }
        }
        return ahVar;
    }

    public static xr.ah ms(String str, String str2) {
        return ms(str, str2, false);
    }

    public static xr.ah ms(String str, String str2, boolean z) {
        xr.ah ahVar = new xr.ah();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int[] iArrMs = ms(str, (float) xr(str2), z);
            ahVar.f791ms = iArrMs[0];
            ahVar.xr = iArrMs[1];
            if (jSONObject.optDouble("lineHeight", 1.0d) == 0.0d) {
                ahVar.xr = 0.0f;
            }
        } catch (Exception e) {
            sl.ms(e);
        }
        return ahVar;
    }

    public static double xr(String str) {
        try {
            return Double.parseDouble(new JSONObject(str).optString("fontSize"));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public static int[] ms(String str, float f, boolean z) {
        int[] iArrXr = xr(str, f, z);
        return new int[]{com.bytedance.sdk.component.adexpress.d.x.xr(com.bytedance.sdk.component.adexpress.d.getContext(), iArrXr[0]), com.bytedance.sdk.component.adexpress.d.x.xr(com.bytedance.sdk.component.adexpress.d.getContext(), iArrXr[1])};
    }

    public static int[] xr(String str, float f, boolean z) {
        try {
            TextView textView = new TextView(com.bytedance.sdk.component.adexpress.d.getContext());
            textView.setTextSize(f);
            textView.setText(str);
            textView.setIncludeFontPadding(false);
            if (z) {
                textView.setSingleLine();
            }
            textView.measure(-2, -2);
            return new int[]{textView.getMeasuredWidth() + 2, textView.getMeasuredHeight() + 2};
        } catch (Exception unused) {
            return new int[]{0, 0};
        }
    }

    public static String ms() {
        return xr;
    }

    public static boolean xr() {
        return !TextUtils.isEmpty(xr);
    }
}
