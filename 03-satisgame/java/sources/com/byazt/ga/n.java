package com.byazt.ga;

import android.util.Base64;
import com.byazt.eau.s;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE, 19})
public class n implements s {
    @Override // com.byazt.eau.s
    public int n() {
        return 32;
    }

    @Override // com.byazt.eau.s
    public String n(String str) {
        return Base64.encodeToString(str.toString().getBytes(Charset.forName("UTF-8")), 0);
    }

    @Override // com.byazt.eau.s
    public String qg(String str) {
        return new String(Base64.decode(str.toString().getBytes(Charset.forName("UTF-8")), 0), Charset.forName("UTF-8"));
    }
}
