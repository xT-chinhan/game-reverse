package com.byazt.wt;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bumptech.glide.load.Key;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 672})
public class gz {
    public static void pr(final of ofVar, final Double d) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.byazt.xlm.c.hw(new com.byazt.xlm.fw("win") { // from class: com.byazt.wt.gz.1
                @Override // java.lang.Runnable
                public void run() {
                    gz.hn(ofVar, d);
                }
            });
        } else {
            hn(ofVar, d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hn(of ofVar, Double d) {
        if (ofVar != null && ofVar.zc() != null) {
            ofVar.xh().hn(1);
            try {
                Object obj = ofVar.zc().get("sdk_bidding_type");
                if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                    String strReplace = (String) ofVar.zc().get("nurl");
                    if (!TextUtils.isEmpty(strReplace)) {
                        if (d != null) {
                            strReplace = strReplace.replace("${AUCTION_BID_TO_WIN}", String.valueOf(d));
                        }
                        com.byazt.sd.a.pr().pr(pr(ofVar, strReplace, "${AUCTION_EXT}"));
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public static void pr(final of ofVar, final Double d, final String str, final String str2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.byazt.xlm.c.hw(new com.byazt.xlm.fw("loss") { // from class: com.byazt.wt.gz.2
                @Override // java.lang.Runnable
                public void run() {
                    gz.hn(ofVar, d, str, str2);
                }
            });
        } else {
            hn(ofVar, d, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hn(of ofVar, Double d, String str, String str2) {
        if (ofVar != null && ofVar.zc() != null) {
            try {
                ofVar.xh().hn(2);
                Object obj = ofVar.zc().get("sdk_bidding_type");
                if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                    String strReplace = (String) ofVar.zc().get("lurl");
                    if (TextUtils.isEmpty(strReplace)) {
                        return;
                    }
                    if (d != null) {
                        strReplace = strReplace.replace("${AUCTION_PRICE}", String.valueOf(d));
                    }
                    if (str != null) {
                        strReplace = strReplace.replace("${AUCTION_LOSS}", str);
                    }
                    if (str2 != null) {
                        strReplace = strReplace.replace("${AUCTION_WINNER}", str2);
                    }
                    com.byazt.sd.a.pr().pr(pr(ofVar, strReplace, "${AUCTION_EXT}"));
                }
            } catch (Throwable th) {
            }
        }
    }

    private static String pr(of ofVar, String str, String str2) throws Exception {
        int iIntValue;
        if (ofVar == null || str == null || !str.contains(str2)) {
            return str;
        }
        Pair<Integer, JSONObject> pairPr = com.byazt.mp.uc.pr().pr(ofVar.B_(), false);
        String strOptString = "";
        if (pairPr != null) {
            strOptString = pairPr.second != null ? ((JSONObject) pairPr.second).optString("message") : "";
            iIntValue = pairPr.first != null ? ((Integer) pairPr.first).intValue() : 3;
        } else {
            iIntValue = 3;
        }
        if (iIntValue != 3) {
            try {
                if (TextUtils.isEmpty(new URL(str).getQuery())) {
                    str = str + "?abort_aes=1";
                } else {
                    str = str + "&abort_aes=1";
                }
            } catch (Exception e) {
            }
        }
        return str.replace(str2, URLEncoder.encode(strOptString, Key.STRING_CHARSET_NAME));
    }
}
