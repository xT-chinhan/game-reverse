package com.byazt.uko;

import android.text.TextUtils;
import android.widget.TextView;
import com.byazt.ca.ho;
import com.byazt.mq.m;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.tapsdk.tapad.internal.runtime.view.TextViewManager;
import com.taptap.sdk.compliance.constants.BundleKey;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 931, 109})
public class w {
    public static String hw;
    public static final Set<String> pr = Collections.unmodifiableSet(new HashSet(Arrays.asList(com.byazt.pfl.hw.AD_TAG_DISLIKE, ILivePush.ClickType.CLOSE, "close-fill", "webview-close")));

    public static hw.hn pr(String str, String str2, String str3, boolean z, boolean z2, int i, com.byazt.rk.zo zoVar, double d, int i2, double d2, String str4, m mVar) {
        int i3;
        int i4;
        float f;
        float f2;
        com.byazt.rk.uc ucVarC;
        String strOptString = str;
        int i5 = i;
        String strUc = mVar.uc();
        if (com.byazt.dj.x.pr() && i2 != 4 && (TextUtils.equals(str2, "text_star") || TextUtils.equals(str2, "score-count") || TextUtils.equals(str2, "score-count-type-1") || TextUtils.equals(str2, "score-count-type-2"))) {
            return new hw.hn(0.0f, 0.0f);
        }
        hw.hn hnVar = new hw.hn();
        if (strOptString.startsWith("<svg") || pr.contains(str2)) {
            try {
                if (!ILivePush.ClickType.CLOSE.equals(str2) && (!com.byazt.dj.x.pr() || !"close-fill".equals(str2))) {
                    hnVar.pr = 10.0f;
                    hnVar.hw = 10.0f;
                    return hnVar;
                }
                float fOptDouble = (float) new JSONObject(str3).optDouble("fontSize");
                hnVar.pr = fOptDouble;
                hnVar.hw = fOptDouble;
                return hnVar;
            } catch (Exception e) {
            }
        } else {
            if ("logo".equals(str2)) {
                if (!com.byazt.dj.x.pr() && ((!TextUtils.isEmpty(str) && strOptString.contains("adx:")) || hw())) {
                    if (hw()) {
                        return pr(hnVar, strOptString, str3, hw);
                    }
                    return pr(hnVar, strOptString, str3, "");
                }
                hnVar.pr = "union".equals(strOptString) ? 10.0f : 20.0f;
                hnVar.hw = 10.0f;
                if (com.byazt.dj.x.pr()) {
                    String str5 = str2 + strOptString;
                    float fHw = (float) hw(str3);
                    if (str5.contains("logoad")) {
                        return pr("AD", str3);
                    }
                    hnVar.hw = fHw;
                }
                return hnVar;
            }
            if ("development-name".equals(str2)) {
                strOptString = "开发者：".concat(String.valueOf(str));
            }
            if ("app-version".equals(str2)) {
                strOptString = "版本号：V".concat(String.valueOf(strOptString));
            }
            if ("score-count".equals(str2)) {
                try {
                    i3 = Integer.parseInt(strOptString);
                } catch (NumberFormatException e2) {
                    i3 = 0;
                }
                if (com.byazt.dj.x.pr() && i3 < 0) {
                    return new hw.hn(0.0f, 0.0f);
                }
                return pr("(" + String.format("%1$s个评分", Integer.valueOf(i3)) + ")", str3);
            }
            if ("score-count-type-2".equals(str2)) {
                try {
                    i4 = Integer.parseInt(strOptString);
                } catch (NumberFormatException e3) {
                    i4 = 0;
                }
                if (com.byazt.dj.x.pr() && i4 < 0) {
                    return new hw.hn(0.0f, 0.0f);
                }
                return pr("(" + String.format(new DecimalFormat("###,###,###").format(i4), Integer.valueOf(i4)) + ")", str3);
            }
            if ("feedback-dislike".equals(str2)) {
                if (com.byazt.dj.x.pr()) {
                    hw.hn hnVar2 = new hw.hn();
                    float fHw2 = (float) hw(str3);
                    hnVar2.pr = fHw2;
                    hnVar2.hw = fHw2;
                    return hnVar2;
                }
                return pr("反馈", str3);
            }
            if ("skip-with-time-countdown".equals(str2) || TextUtils.equals("skip-with-countdowns-video-countdown", str2)) {
                if (mVar.hn() && com.byazt.js.fw.hw(strUc)) {
                    return pr("0s", str3);
                }
                if (d < 10.0d) {
                    return pr("0S", str3);
                }
                return pr("00S", str3);
            }
            if (TextUtils.equals("skip-with-countdowns-skip-btn", str2)) {
                return pr("| 跳过", str3);
            }
            if (TextUtils.equals("skip-with-countdowns-skip-countdown", str2)) {
                return pr("| ".concat(String.valueOf(String.format("%1$ss后可跳过", "00"))), str3);
            }
            if ("skip-with-time-skip-btn".equals(str2)) {
                hw.hn hnVarPr = pr("| 跳过", str3);
                if (com.byazt.dj.x.pr()) {
                    try {
                        hnVarPr.hw = (float) ((((double) hnVarPr.hw) * new JSONObject(str3).optDouble("lineHeight")) / 1.2d);
                    } catch (Throwable th) {
                    }
                    hnVarPr.pr = hnVarPr.hw;
                }
                return hnVarPr;
            }
            if ("skip".equals(str2)) {
                return pr("跳过", str3);
            }
            if ("timedown".equals(str2)) {
                return pr("0.0", str3);
            }
            if ("text_star".equals(str2)) {
                if (com.byazt.dj.x.pr() && (d2 < 0.0d || d2 > 5.0d)) {
                    return new hw.hn(0.0f, 0.0f);
                }
                return pr("0.0", str3);
            }
            if (TextUtils.equals("privacy-detail", str2)) {
                return pr("功能 | 权限 | 隐私", str3);
            }
            if ("arrowButton".equals(str2)) {
                return pr("Download", str3);
            }
            if (TextViewManager.NAME.equals(str2) && com.byazt.dj.x.pr() && TextUtils.isEmpty(strOptString) && (ucVarC = zoVar.vk().c()) != null) {
                if (ucVarC.d() == null) {
                    strOptString = "";
                } else {
                    strOptString = zoVar.vk().c().d().optString(com.byazt.js.zo.x(com.byazt.dj.x.getContext()));
                }
            }
            if ("fillButton".equals(str2) || TextViewManager.NAME.equals(str2) || "button".equals(str2) || "downloadWithIcon".equals(str2) || "downloadButton".equals(str2) || "laceButton".equals(str2) || "cardButton".equals(str2) || "colourMixtureButton".equals(str2) || "arrowButton".equals(str2) || (("source".equals(str2) && (!com.byazt.dj.x.pr() || !"open_ad".equals(strUc))) || TextUtils.equals("app-version", str2) || TextUtils.equals("development-name", str2))) {
                return pr(strOptString, str3);
            }
            try {
                JSONObject jSONObject = new JSONObject(str3);
                int length = strOptString.length();
                float fOptDouble2 = (float) jSONObject.optDouble("fontSize");
                float fOptDouble3 = (float) jSONObject.optDouble("letterSpacing");
                float fOptDouble4 = (float) jSONObject.optDouble("lineHeight");
                float fOptDouble5 = (float) jSONObject.optDouble("maxWidth");
                float f3 = (length * (fOptDouble2 + fOptDouble3)) - fOptDouble3;
                ho.hw("DynamicBaseWidget", "getDomSizeFromNative letterSpacing==" + fOptDouble3 + ",lineHeight==" + fOptDouble4 + ",maxWidth ==" + fOptDouble5 + ",totalStrLength" + f3);
                if ("muted".equals(str2)) {
                    hnVar.pr = fOptDouble2;
                    hnVar.hw = fOptDouble2;
                    return hnVar;
                }
                if ("star".equals(str2)) {
                    if (com.byazt.dj.x.pr() && (d2 < 0.0d || d2 > 5.0d || i2 != 4)) {
                        return new hw.hn(0.0f, 0.0f);
                    }
                    hw.hn hnVarPr2 = pr("str", str3);
                    hnVarPr2.pr = fOptDouble2 * 5.0f;
                    return hnVarPr2;
                }
                if ("icon".equals(str2)) {
                    hnVar.pr = fOptDouble2;
                    hnVar.hw = fOptDouble2;
                    return hnVar;
                }
                if (z) {
                    int i6 = ((int) (f3 / fOptDouble5)) + 1;
                    if (z2 && i6 >= i5) {
                        i6 = i5;
                    }
                    f = (float) (((double) (fOptDouble4 * fOptDouble2 * i6)) * 1.2d);
                    f2 = fOptDouble5;
                } else {
                    f = (float) (((double) (fOptDouble4 * fOptDouble2)) * 1.2d);
                    f2 = f3 > fOptDouble5 ? fOptDouble5 : f3;
                }
                if (BundleKey.TITLE.equals(str2) || (com.byazt.dj.x.pr() && "open_ad".equals(strUc) && "source".equals(str2))) {
                    try {
                        hw.hn hnVarPr3 = pr(strOptString.replace('\n', ' '), str3, false);
                        if (z) {
                            int i7 = ((int) (f3 / fOptDouble5)) + 1;
                            if (!z2 || i7 < i5) {
                                i5 = i7;
                            }
                            hnVarPr3.hw *= i5;
                        }
                        return hnVarPr3;
                    } catch (Exception e4) {
                    }
                }
                hnVar.pr = f2;
                hnVar.hw = f;
                return hnVar;
            } catch (JSONException e5) {
            }
        }
    }

    public static String pr(String str) {
        String[] strArrSplit;
        return (TextUtils.isEmpty(str) || (strArrSplit = str.split("adx:")) == null || strArrSplit.length < 2) ? "" : strArrSplit[1];
    }

    private static hw.hn pr(hw.hn hnVar, String str, String str2, String str3) {
        if (str.contains("union")) {
            hnVar.pr = 0.0f;
            hnVar.hw = 0.0f;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = pr(str);
            }
            if (TextUtils.isEmpty(str3)) {
                hnVar.pr = 0.0f;
                hnVar.hw = 0.0f;
            } else {
                return pr(str3, str2);
            }
        }
        return hnVar;
    }

    public static hw.hn pr(String str, String str2) {
        return pr(str, str2, false);
    }

    public static hw.hn pr(String str, String str2, boolean z) {
        hw.hn hnVar = new hw.hn();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int[] iArrPr = pr(str, (float) hw(str2), z);
            hnVar.pr = iArrPr[0];
            hnVar.hw = iArrPr[1];
            if (jSONObject.optDouble("lineHeight", 1.0d) == 0.0d) {
                hnVar.hw = 0.0f;
            }
        } catch (Exception e) {
        }
        return hnVar;
    }

    public static double hw(String str) {
        try {
            return Double.parseDouble(new JSONObject(str).optString("fontSize"));
        } catch (Throwable th) {
            return 0.0d;
        }
    }

    public static int[] pr(String str, float f, boolean z) {
        int[] iArrHw = hw(str, f, z);
        return new int[]{com.byazt.js.zo.hw(com.byazt.dj.x.getContext(), iArrHw[0]), com.byazt.js.zo.hw(com.byazt.dj.x.getContext(), iArrHw[1])};
    }

    public static int[] hw(String str, float f, boolean z) {
        try {
            TextView textView = new TextView(com.byazt.dj.x.getContext());
            textView.setTextSize(f);
            textView.setText(str);
            textView.setIncludeFontPadding(false);
            if (z) {
                textView.setSingleLine();
            }
            textView.measure(-2, -2);
            return new int[]{textView.getMeasuredWidth() + 2, textView.getMeasuredHeight() + 2};
        } catch (Exception e) {
            return new int[]{0, 0};
        }
    }

    public static String pr() {
        return hw;
    }

    public static boolean hw() {
        if (TextUtils.isEmpty(hw)) {
            return false;
        }
        return true;
    }
}
