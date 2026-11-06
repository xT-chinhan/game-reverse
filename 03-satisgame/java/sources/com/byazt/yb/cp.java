package com.byazt.yb;

import android.os.Bundle;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 29})
public class cp extends com.byazt.bgo.n.AbstractBinderC0135n {
    public volatile boolean n = false;

    @Override // com.byazt.bgo.n
    public void n(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
    }

    @Override // com.byazt.bgo.n
    public void n(int i, Bundle bundle) throws RemoteException {
        if (i != 0 || bundle == null) {
            return;
        }
        this.n = bundle.getBoolean("oa_id_limit_state");
    }

    public boolean n() {
        return this.n;
    }
}
