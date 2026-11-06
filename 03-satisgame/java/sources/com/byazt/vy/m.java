package com.byazt.vy;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY})
public class m {
    public static String n;

    public static boolean n() {
        return com.byazt.rb.qg.qg() && com.byazt.vyf.s.cy().sh();
    }

    public static String n(String str) {
        try {
            if (!n()) {
                return str;
            }
            String strA = com.byazt.qt.n.d().a();
            if (TextUtils.isEmpty(strA)) {
                return str;
            }
            com.byazt.rb.qg.n("TestHelperUtils", "AnyDoorId=" + strA);
            return Uri.parse(str).buildUpon().appendQueryParameter(qg(), strA).appendQueryParameter("aid", "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String qg() {
        if (TextUtils.isEmpty(n)) {
            n = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return n;
    }
}
