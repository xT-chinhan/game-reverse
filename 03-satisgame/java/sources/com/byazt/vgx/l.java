package com.byazt.vgx;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.c.d.c;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_PTS, 18})
public class l {
    public static void n(final pk pkVar, final Double d) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.byazt.qit.l.qg(new com.byazt.qit.x("win") { // from class: com.byazt.vgx.l.1
                @Override // java.lang.Runnable
                public void run() {
                    l.s(pkVar, d);
                }
            });
        } else {
            s(pkVar, d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(pk pkVar, Double d) {
        if (pkVar == null || pkVar.wl() == null) {
            return;
        }
        pkVar.kx().s(1);
        try {
            Object obj = pkVar.wl().get("sdk_bidding_type");
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String strReplace = (String) pkVar.wl().get("nurl");
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                if (d != null) {
                    strReplace = strReplace.replace(c.f, String.valueOf(d));
                }
                rv.n().n(n(pkVar, strReplace, "${AUCTION_EXT}"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void n(final pk pkVar, final Double d, final String str, final String str2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.byazt.qit.l.qg(new com.byazt.qit.x("loss") { // from class: com.byazt.vgx.l.2
                @Override // java.lang.Runnable
                public void run() {
                    l.s(pkVar, d, str, str2);
                }
            });
        } else {
            s(pkVar, d, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(pk pkVar, Double d, String str, String str2) {
        if (pkVar == null || pkVar.wl() == null) {
            return;
        }
        try {
            pkVar.kx().s(2);
            Object obj = pkVar.wl().get("sdk_bidding_type");
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String strReplace = (String) pkVar.wl().get("lurl");
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                if (d != null) {
                    strReplace = strReplace.replace(c.b, String.valueOf(d));
                }
                if (str != null) {
                    strReplace = strReplace.replace(c.d, str);
                }
                if (str2 != null) {
                    strReplace = strReplace.replace("${AUCTION_WINNER}", str2);
                }
                rv.n().n(n(pkVar, strReplace, "${AUCTION_EXT}"));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0038 A[PHI: r0
      0x0038: PHI (r0v3 java.lang.String) = (r0v2 java.lang.String), (r0v5 java.lang.String) binds: [B:8:0x001b, B:13:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    private static String n(pk pkVar, String str, String str2) throws Exception {
        int iIntValue;
        if (pkVar == null || str == null || !str.contains(str2)) {
            return str;
        }
        Pair<Integer, JSONObject> pairN = com.byazt.cl.q.n().n(pkVar.F_(), false);
        String strOptString = "";
        if (pairN == null) {
            iIntValue = 3;
        } else {
            strOptString = pairN.second != null ? ((JSONObject) pairN.second).optString("message") : "";
            if (pairN.first != null) {
                iIntValue = ((Integer) pairN.first).intValue();
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
            } catch (Exception unused) {
            }
        }
        return str.replace(str2, URLEncoder.encode(strOptString, "UTF-8"));
    }
}
