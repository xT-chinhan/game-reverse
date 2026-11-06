package com.byazt.bq;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.anythink.core.common.f.e;
import com.byazt.kfh.SSWebView;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 290, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj {
    public static volatile String n = "";
    public static final AtomicBoolean qg = new AtomicBoolean(false);

    public static String n() {
        String strConcat;
        try {
            strConcat = System.getProperty("http.agent");
        } catch (Exception unused) {
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

    public static String n(Context context, com.byazt.vf.n nVar, boolean z, boolean z2) {
        if (!TextUtils.isEmpty(n)) {
            return n;
        }
        return n(z, context, nVar, z2);
    }

    private static String n(boolean z, Context context, com.byazt.vf.n nVar, boolean z2) {
        String string;
        long j;
        try {
            String strQg = fs.qg("sdk_local_web_ua", "", nVar);
            if (TextUtils.isEmpty(strQg)) {
                string = null;
                j = 0;
            } else {
                JSONObject jSONObject = new JSONObject(strQg);
                string = jSONObject.getString(e.a.d);
                j = jSONObject.getLong("time");
                n = string;
            }
            if (!z && z2) {
                return n;
            }
            if (TextUtils.isEmpty(string)) {
                s(context, nVar);
            } else if (System.currentTimeMillis() - j > 259200000 && qg.compareAndSet(false, true)) {
                qg(context, nVar);
            }
            return n;
        } catch (Throwable unused) {
        }
    }

    private static void qg(final Context context, final com.byazt.vf.n nVar) {
        ((wo) com.byazt.qp.q.n("thread_service")).qg().execute(new com.byazt.qit.x("tt-webua") { // from class: com.byazt.bq.tj.1
            @Override // java.lang.Runnable
            public void run() {
                tj.s(context, nVar);
            }
        });
    }

    /* JADX INFO: renamed from: com.byazt.bq.tj$2, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 290, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME})
    static class AnonymousClass2 implements Runnable {
        public final /* synthetic */ Context n;
        public final /* synthetic */ com.byazt.vf.n qg;

        public AnonymousClass2(Context context, com.byazt.vf.n nVar) {
            this.n = context;
            this.qg = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = tj.n = tj.s(new SSWebView(this.n).getUserAgentString());
                fs.s("sdk_local_web_ua", tj.n, this.qg);
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(Context context, com.byazt.vf.n nVar) {
        try {
            n = s(WebSettings.getDefaultUserAgent(context));
            fs.s("sdk_local_web_ua", n, nVar);
            qg.set(false);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String s(String str) {
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
