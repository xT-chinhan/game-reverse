package com.byazt.wb;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 426, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public final class c extends pr {
    public static final c hn = new c(7500200, "执行成功");
    public static final c x = new c(7500204, "deeplink链接为空，打开失败");
    public static final c c = new c(7500205, "deeplink 被拒绝");
    public static final c uc = new c(7500206, "deeplink 打开失败");
    public static final c fw = new c(7500207, "未知打开方式");
    public static final c zo = new c(7500208, "quick_url为空，打开失败");
    public static final c aj = new c(7500209, "快应用打开失败");

    private c(int i, String str) {
        this.pr = i;
        this.hw = str;
    }
}
