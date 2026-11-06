package com.byazt.uk;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET, 250})
public class k {

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET, 785})
    private static class pr {
        public static k pr = new k();
    }

    public static k pr() {
        return pr.pr;
    }

    private k() {
    }

    public void pr(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String.format("sdk:%s.%s:", str, str2);
        }
    }

    public void hw(String str, String str2, String str3) {
        String str4;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            str4 = String.format("sdk:%s.%s:", str, str2);
        } else {
            str4 = "";
        }
        ho.hw("[TTDownloaderLogger]", str4 + str3);
    }
}
