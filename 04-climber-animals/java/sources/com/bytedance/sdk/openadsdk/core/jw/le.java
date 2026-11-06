package com.bytedance.sdk.openadsdk.core.jw;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class le {
    public static void ms(final com.bytedance.sdk.openadsdk.core.nw.lm lmVar, final Double d) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("win") { // from class: com.bytedance.sdk.openadsdk.core.jw.le.1
                @Override // java.lang.Runnable
                public void run() {
                    le.ah(lmVar, d);
                }
            });
        } else {
            ah(lmVar, d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ah(com.bytedance.sdk.openadsdk.core.nw.lm lmVar, Double d) {
        if (lmVar == null || lmVar.ou() == null) {
            return;
        }
        try {
            Object obj = lmVar.ou().get("sdk_bidding_type");
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String strReplace = (String) lmVar.ou().get("nurl");
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                if (d != null) {
                    strReplace = strReplace.replace(com.anythink.core.b.d.c.f, String.valueOf(d));
                }
                com.bytedance.sdk.openadsdk.core.re.ms().ms(ms(lmVar, strReplace, "${AUCTION_EXT}"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void ms(final com.bytedance.sdk.openadsdk.core.nw.lm lmVar, final Double d, final String str, final String str2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("loss") { // from class: com.bytedance.sdk.openadsdk.core.jw.le.2
                @Override // java.lang.Runnable
                public void run() {
                    le.ah(lmVar, d, str, str2);
                }
            });
        } else {
            ah(lmVar, d, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ah(com.bytedance.sdk.openadsdk.core.nw.lm lmVar, Double d, String str, String str2) {
        if (lmVar == null || lmVar.ou() == null) {
            return;
        }
        try {
            Object obj = lmVar.ou().get("sdk_bidding_type");
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String strReplace = (String) lmVar.ou().get("lurl");
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                if (d != null) {
                    strReplace = strReplace.replace(com.anythink.core.b.d.c.b, String.valueOf(d));
                }
                if (str != null) {
                    strReplace = strReplace.replace(com.anythink.core.b.d.c.d, str);
                }
                if (str2 != null) {
                    strReplace = strReplace.replace("${AUCTION_WINNER}", str2);
                }
                com.bytedance.sdk.openadsdk.core.re.ms().ms(ms(lmVar, strReplace, "${AUCTION_EXT}"));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0039 A[PHI: r0
      0x0039: PHI (r0v3 java.lang.String) = (r0v2 java.lang.String), (r0v5 java.lang.String) binds: [B:8:0x001c, B:13:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
    private static String ms(com.bytedance.sdk.openadsdk.core.nw.lm lmVar, String str, String str2) throws Exception {
        int iIntValue;
        if (lmVar == null || str == null || !str.contains(str2)) {
            return str;
        }
        Pair<Integer, JSONObject> pairMs = com.bytedance.sdk.openadsdk.core.ah.c.ms().ms(lmVar.lx(), false);
        String strOptString = "";
        if (pairMs == null) {
            iIntValue = 3;
        } else {
            strOptString = pairMs.second != null ? ((JSONObject) pairMs.second).optString("message") : "";
            if (pairMs.first != null) {
                iIntValue = ((Integer) pairMs.first).intValue();
            } else {
                iIntValue = 3;
            }
        }
        if (iIntValue != 3) {
            try {
                if (TextUtils.isEmpty(new URL(str).getQuery())) {
                    str = str + "?abort_aes=1";
                } else {
                    str = str + "&abort_aes=1";
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
        }
        return str.replace(str2, URLEncoder.encode(strOptString, "UTF-8"));
    }
}
