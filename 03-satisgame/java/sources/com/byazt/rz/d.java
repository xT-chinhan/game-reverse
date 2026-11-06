package com.byazt.rz;

import android.text.TextUtils;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 113})
public class d {

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 89})
    private static class n {
        public static d n = new d();
    }

    public static d n() {
        return n.n;
    }

    private d() {
    }

    public void n(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String.format("sdk:%s.%s:", str, str2);
    }

    public void qg(String str, String str2, String str3) {
        k.qg("[TTDownloaderLogger]", ((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : String.format("sdk:%s.%s:", str, str2)) + str3);
    }
}
