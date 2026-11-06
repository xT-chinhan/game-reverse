package com.byazt.fp;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.byazt.fj.SSWebView;
import com.byazt.vkw.qi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 50})
public class vk {
    public static volatile String pr = "";
    public static final AtomicBoolean hw = new AtomicBoolean(false);

    public static String pr() {
        String strConcat;
        try {
            strConcat = System.getProperty("http.agent");
        } catch (Exception e) {
            strConcat = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (strConcat == null) {
            return "";
        }
        int iLastIndexOf = strConcat.lastIndexOf(";");
        if (iLastIndexOf != -1 && strConcat.length() > iLastIndexOf) {
            int i = iLastIndexOf + 1;
            strConcat = strConcat.substring(0, i).concat(" " + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry() + ";").concat(strConcat.substring(i));
        }
        int length = strConcat.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = strConcat.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static String pr(Context context, com.byazt.vkw.pr prVar, boolean z, boolean z2) {
        if (!TextUtils.isEmpty(pr)) {
            return pr;
        }
        return pr(z, context, prVar, z2);
    }

    private static String pr(boolean z, Context context, com.byazt.vkw.pr prVar, boolean z2) {
        String string;
        try {
            String strHw = zo.hw("sdk_local_web_ua", "", prVar);
            long j = 0;
            if (TextUtils.isEmpty(strHw)) {
                string = null;
            } else {
                JSONObject jSONObject = new JSONObject(strHw);
                string = jSONObject.getString(Constants.VALUE_FIELD);
                j = jSONObject.getLong("time");
                pr = string;
            }
            if (!z && z2) {
                return pr;
            }
            if (TextUtils.isEmpty(string)) {
                hn(context, prVar);
            } else if (System.currentTimeMillis() - j > 259200000 && hw.compareAndSet(false, true)) {
                hw(context, prVar);
            }
            return pr;
        } catch (Throwable th) {
        }
    }

    private static void hw(final Context context, final com.byazt.vkw.pr prVar) {
        ((qi) com.byazt.zs.uc.pr("thread_service")).hw().execute(new com.byazt.xlm.fw("tt-webua") { // from class: com.byazt.fp.vk.1
            @Override // java.lang.Runnable
            public void run() {
                vk.hn(context, prVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hn(final Context context, final com.byazt.vkw.pr prVar) {
        try {
            if (Build.VERSION.SDK_INT < 17) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    pr = hn(new SSWebView(context).getUserAgentString());
                    return;
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.byazt.fp.vk.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String unused = vk.pr = vk.hn(new SSWebView(context).getUserAgentString());
                                zo.hn("sdk_local_web_ua", vk.pr, prVar);
                            } catch (Exception e) {
                            }
                        }
                    });
                    return;
                }
            }
            pr = hn(WebSettings.getDefaultUserAgent(context));
            zo.hn("sdk_local_web_ua", pr, prVar);
            hw.set(false);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String hn(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }
}
