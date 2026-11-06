package com.byazt.za;

import android.text.TextUtils;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj {
    public static void n(String str, String str2, pk pkVar) {
        com.byazt.eji.s.n().n("dynamic_backup_render_new", str2, com.byazt.vgx.w.a(pkVar), n(str), (com.byazt.rs.n) null);
    }

    public static void n(int i, String str, String str2, pk pkVar) {
        com.byazt.eji.s.n().n("express_ad_render", str2, null, com.byazt.vgx.w.a(pkVar), n(str), null, null, null, com.byazt.bxg.n.n(i), i, null);
    }

    public static int n(String str) {
        if (TextUtils.isEmpty(str)) {
            return 5;
        }
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return 1;
            case "rewarded_video":
                return 7;
            case "stream":
                return 6;
            case "fullscreen_interstitial_ad":
                return 8;
            case "splash_ad":
                return 3;
            case "interaction":
                return 2;
            case "draw_ad":
                return 9;
            default:
                return 5;
        }
    }
}
