package com.byazt.hkc;

import android.text.TextUtils;
import android.widget.TextView;
import com.byazt.tk.k;
import com.byazt.udb.oa;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 46, 29})
public class cp {
    public static final Set<String> n = Collections.unmodifiableSet(new HashSet(Arrays.asList(com.byazt.wg.qg.AD_TAG_DISLIKE, ILivePush.ClickType.CLOSE, "close-fill", "webview-close")));
    public static String qg;

    /* JADX WARN: Code duplicated, block: B:216:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:219:0x040c A[Catch: Exception -> 0x041d, JSONException -> 0x0421, TryCatch #0 {JSONException -> 0x0421, blocks: (B:175:0x0322, B:177:0x0382, B:179:0x0387, B:181:0x038f, B:189:0x03a0, B:191:0x03a7, B:193:0x03b3, B:195:0x03bb, B:198:0x03c2, B:202:0x03cc, B:208:0x03e0, B:210:0x03e8, B:212:0x03ee, B:214:0x03f6, B:226:0x041d, B:217:0x0402, B:219:0x040c, B:224:0x0416, B:204:0x03d5), top: B:256:0x0322 }] */
    /* JADX WARN: Code duplicated, block: B:221:0x0412 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:223:0x0415  */
    public static qg.s n(String str, String str2, String str3, boolean z, boolean z2, int i, com.byazt.lh.fs fsVar, double d, int i2, double d2, String str4, oa oaVar) {
        int i3;
        int i4;
        float f;
        float f2;
        qg.s sVarN;
        int i5;
        com.byazt.lh.w wVarL;
        String strOptString = str;
        int i6 = i;
        String strW = oaVar.w();
        if (com.byazt.twc.q.n() && i2 != 4 && (TextUtils.equals(str2, "text_star") || TextUtils.equals(str2, "score-count") || TextUtils.equals(str2, "score-count-type-1") || TextUtils.equals(str2, "score-count-type-2"))) {
            return new qg.s(0.0f, 0.0f);
        }
        qg.s sVar = new qg.s();
        if (strOptString.startsWith("<svg") || n.contains(str2)) {
            try {
                if (ILivePush.ClickType.CLOSE.equals(str2) || (com.byazt.twc.q.n() && "close-fill".equals(str2))) {
                    float fOptDouble = (float) new JSONObject(str3).optDouble("fontSize");
                    sVar.n = fOptDouble;
                    sVar.qg = fOptDouble;
                    return sVar;
                }
            } catch (Exception unused) {
            }
            sVar.n = 10.0f;
            sVar.qg = 10.0f;
            return sVar;
        }
        if ("logo".equals(str2)) {
            if (!com.byazt.twc.q.n() && ((!TextUtils.isEmpty(str) && strOptString.contains("adx:")) || qg())) {
                if (qg()) {
                    return n(sVar, strOptString, str3, qg);
                }
                return n(sVar, strOptString, str3, "");
            }
            sVar.n = "union".equals(strOptString) ? 10.0f : 20.0f;
            sVar.qg = 10.0f;
            if (com.byazt.twc.q.n()) {
                String str5 = str2 + strOptString;
                float fQg = (float) qg(str3);
                if (str5.contains("logoad")) {
                    return n("AD", str3);
                }
                sVar.qg = fQg;
            }
            return sVar;
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
            } catch (NumberFormatException unused2) {
                i3 = 0;
            }
            if (com.byazt.twc.q.n() && i3 < 0) {
                return new qg.s(0.0f, 0.0f);
            }
            return n("(" + String.format("%1$s个评分", Integer.valueOf(i3)) + ")", str3);
        }
        if ("score-count-type-2".equals(str2)) {
            try {
                i4 = Integer.parseInt(strOptString);
            } catch (NumberFormatException unused3) {
                i4 = 0;
            }
            if (com.byazt.twc.q.n() && i4 < 0) {
                return new qg.s(0.0f, 0.0f);
            }
            return n("(" + String.format(new DecimalFormat("###,###,###").format(i4), Integer.valueOf(i4)) + ")", str3);
        }
        if ("feedback-dislike".equals(str2)) {
            if (com.byazt.twc.q.n()) {
                qg.s sVar2 = new qg.s();
                float fQg2 = (float) qg(str3);
                sVar2.n = fQg2;
                sVar2.qg = fQg2;
                return sVar2;
            }
            return n("反馈", str3);
        }
        if ("skip-with-time-countdown".equals(str2) || TextUtils.equals("skip-with-countdowns-video-countdown", str2)) {
            if (oaVar.s() && com.byazt.cq.x.qg(strW)) {
                return n("0s", str3);
            }
            if (d < 10.0d) {
                return n("0S", str3);
            }
            return n("00S", str3);
        }
        if (TextUtils.equals("skip-with-countdowns-skip-btn", str2)) {
            return n("| 跳过", str3);
        }
        if (TextUtils.equals("skip-with-countdowns-skip-countdown", str2)) {
            return n("| ".concat(String.valueOf(String.format("%1$ss后可跳过", "00"))), str3);
        }
        if ("skip-with-time-skip-btn".equals(str2)) {
            qg.s sVarN2 = n("| 跳过", str3);
            if (com.byazt.twc.q.n()) {
                try {
                    sVarN2.qg = (float) ((((double) sVarN2.qg) * new JSONObject(str3).optDouble("lineHeight")) / 1.2d);
                } catch (Throwable unused4) {
                }
                sVarN2.n = sVarN2.qg;
            }
            return sVarN2;
        }
        if ("skip".equals(str2)) {
            return n("跳过", str3);
        }
        if ("timedown".equals(str2)) {
            return n("0.0", str3);
        }
        if ("text_star".equals(str2)) {
            if (com.byazt.twc.q.n() && (d2 < 0.0d || d2 > 5.0d)) {
                return new qg.s(0.0f, 0.0f);
            }
            return n("0.0", str3);
        }
        if (TextUtils.equals("privacy-detail", str2)) {
            return n("功能 | 权限 | 隐私", str3);
        }
        if ("arrowButton".equals(str2)) {
            return n("Download", str3);
        }
        if ("text".equals(str2) && com.byazt.twc.q.n() && TextUtils.isEmpty(strOptString) && (wVarL = fsVar.tj().l()) != null) {
            strOptString = wVarL.kc() != null ? fsVar.tj().l().kc().optString(com.byazt.cq.fs.q(com.byazt.twc.q.getContext())) : "";
        }
        if ("fillButton".equals(str2) || "text".equals(str2) || "button".equals(str2) || "downloadWithIcon".equals(str2) || "downloadButton".equals(str2) || "laceButton".equals(str2) || "cardButton".equals(str2) || "colourMixtureButton".equals(str2) || "arrowButton".equals(str2) || (("source".equals(str2) && (!com.byazt.twc.q.n() || !"open_ad".equals(strW))) || TextUtils.equals("app-version", str2) || TextUtils.equals("development-name", str2))) {
            return n(strOptString, str3);
        }
        try {
            JSONObject jSONObject = new JSONObject(str3);
            int length = strOptString.length();
            float fOptDouble2 = (float) jSONObject.optDouble("fontSize");
            float fOptDouble3 = (float) jSONObject.optDouble("letterSpacing");
            float fOptDouble4 = (float) jSONObject.optDouble("lineHeight");
            float fOptDouble5 = (float) jSONObject.optDouble("maxWidth");
            float f3 = (length * (fOptDouble2 + fOptDouble3)) - fOptDouble3;
            k.qg("DynamicBaseWidget", "getDomSizeFromNative letterSpacing==" + fOptDouble3 + ",lineHeight==" + fOptDouble4 + ",maxWidth ==" + fOptDouble5 + ",totalStrLength" + f3);
            if ("muted".equals(str2)) {
                sVar.n = fOptDouble2;
                sVar.qg = fOptDouble2;
                return sVar;
            }
            if ("star".equals(str2)) {
                if (com.byazt.twc.q.n() && (d2 < 0.0d || d2 > 5.0d || i2 != 4)) {
                    return new qg.s(0.0f, 0.0f);
                }
                qg.s sVarN3 = n("str", str3);
                sVarN3.n = fOptDouble2 * 5.0f;
                return sVarN3;
            }
            if ("icon".equals(str2)) {
                sVar.n = fOptDouble2;
                sVar.qg = fOptDouble2;
                return sVar;
            }
            if (!z) {
                f = (float) (((double) (fOptDouble4 * fOptDouble2)) * 1.2d);
                if (f3 <= fOptDouble5) {
                    f2 = f3;
                }
                if (!"title".equals(str2) || (com.byazt.twc.q.n() && "open_ad".equals(strW) && "source".equals(str2))) {
                    try {
                        sVarN = n(strOptString.replace('\n', ' '), str3, false);
                        if (z) {
                            i5 = ((int) (f3 / fOptDouble5)) + 1;
                            if (z2 || i5 < i6) {
                                i6 = i5;
                            }
                            sVarN.qg *= i6;
                        }
                        return sVarN;
                    } catch (Exception unused5) {
                    }
                }
                sVar.n = f2;
                sVar.qg = f;
                return sVar;
            }
            int i7 = ((int) (f3 / fOptDouble5)) + 1;
            if (z2 && i7 >= i6) {
                i7 = i6;
            }
            f = (float) (((double) (fOptDouble4 * fOptDouble2 * i7)) * 1.2d);
            f2 = fOptDouble5;
            if (!"title".equals(str2)) {
                sVarN = n(strOptString.replace('\n', ' '), str3, false);
                if (z) {
                    i5 = ((int) (f3 / fOptDouble5)) + 1;
                    if (z2) {
                        i6 = i5;
                    } else {
                        i6 = i5;
                    }
                    sVarN.qg *= i6;
                }
                return sVarN;
            }
            sVarN = n(strOptString.replace('\n', ' '), str3, false);
            if (z) {
                i5 = ((int) (f3 / fOptDouble5)) + 1;
                if (z2) {
                    i6 = i5;
                } else {
                    i6 = i5;
                }
                sVarN.qg *= i6;
            }
            return sVarN;
            return sVar;
        } catch (JSONException unused6) {
        }
    }

    public static String n(String str) {
        String[] strArrSplit;
        return (TextUtils.isEmpty(str) || (strArrSplit = str.split("adx:")) == null || strArrSplit.length < 2) ? "" : strArrSplit[1];
    }

    private static qg.s n(qg.s sVar, String str, String str2, String str3) {
        if (str.contains("union")) {
            sVar.n = 0.0f;
            sVar.qg = 0.0f;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = n(str);
            }
            if (TextUtils.isEmpty(str3)) {
                sVar.n = 0.0f;
                sVar.qg = 0.0f;
            } else {
                return n(str3, str2);
            }
        }
        return sVar;
    }

    public static qg.s n(String str, String str2) {
        return n(str, str2, false);
    }

    public static qg.s n(String str, String str2, boolean z) {
        qg.s sVar = new qg.s();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int[] iArrN = n(str, (float) qg(str2), z);
            sVar.n = iArrN[0];
            sVar.qg = iArrN[1];
            if (jSONObject.optDouble("lineHeight", 1.0d) == 0.0d) {
                sVar.qg = 0.0f;
            }
        } catch (Exception unused) {
        }
        return sVar;
    }

    public static double qg(String str) {
        try {
            return Double.parseDouble(new JSONObject(str).optString("fontSize"));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public static int[] n(String str, float f, boolean z) {
        int[] iArrQg = qg(str, f, z);
        return new int[]{com.byazt.cq.fs.qg(com.byazt.twc.q.getContext(), iArrQg[0]), com.byazt.cq.fs.qg(com.byazt.twc.q.getContext(), iArrQg[1])};
    }

    public static int[] qg(String str, float f, boolean z) {
        try {
            TextView textView = new TextView(com.byazt.twc.q.getContext());
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

    public static String n() {
        return qg;
    }

    public static boolean qg() {
        return !TextUtils.isEmpty(qg);
    }
}
