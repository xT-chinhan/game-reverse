package com.byazt.mrs;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1368, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static volatile String pr = "";
    public static volatile String hw = "";
    public static volatile String hn = "";
    public static long x = 512000;
    public static long c = 50;
    public static long uc = 5242880;
    public static long fw = 31457280;
    public static long zo = 10485760;
    public static final JSONObject aj = new JSONObject();

    public static void pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        pr = str;
    }
}
