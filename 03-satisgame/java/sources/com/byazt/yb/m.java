package com.byazt.yb;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY})
public final class m extends s<com.byazt.bo.qg> {
    public m() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.byazt.yb.s
    public hu.qg<com.byazt.bo.qg, String> n() {
        return new hu.qg<com.byazt.bo.qg, String>() { // from class: com.byazt.yb.m.1
            @Override // com.byazt.yb.hu.qg
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public com.byazt.bo.qg qg(IBinder iBinder) {
                return com.byazt.bo.qg.n.n(iBinder);
            }

            @Override // com.byazt.yb.hu.qg
            public String n(com.byazt.bo.qg qgVar) throws Exception {
                return qgVar.n();
            }
        };
    }

    @Override // com.byazt.yb.s
    public Intent n(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }
}
