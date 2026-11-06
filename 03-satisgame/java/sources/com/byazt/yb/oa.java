package com.byazt.yb;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public final class oa extends s<com.byazt.bo.s> {
    public oa() {
        super("com.zui.deviceidservice");
    }

    @Override // com.byazt.yb.s
    public hu.qg<com.byazt.bo.s, String> n() {
        return new hu.qg<com.byazt.bo.s, String>() { // from class: com.byazt.yb.oa.1
            @Override // com.byazt.yb.hu.qg
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public com.byazt.bo.s qg(IBinder iBinder) {
                return com.byazt.bo.s.n.n(iBinder);
            }

            @Override // com.byazt.yb.hu.qg
            public String n(com.byazt.bo.s sVar) throws Exception {
                if (sVar == null) {
                    return null;
                }
                return sVar.n();
            }
        };
    }

    @Override // com.byazt.yb.s
    public Intent n(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }
}
