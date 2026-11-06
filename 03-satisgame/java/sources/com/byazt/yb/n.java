package com.byazt.yb;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 19})
public final class n extends s<com.byazt.bo.q> {
    public n() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.byazt.yb.s
    public hu.qg<com.byazt.bo.q, String> n() {
        return new hu.qg<com.byazt.bo.q, String>() { // from class: com.byazt.yb.n.1
            @Override // com.byazt.yb.hu.qg
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public com.byazt.bo.q qg(IBinder iBinder) {
                return com.byazt.bo.q.n.n(iBinder);
            }

            @Override // com.byazt.yb.hu.qg
            public String n(com.byazt.bo.q qVar) throws Exception {
                if (qVar == null) {
                    return null;
                }
                return qVar.s();
            }
        };
    }

    @Override // com.byazt.yb.s
    public Intent n(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }
}
