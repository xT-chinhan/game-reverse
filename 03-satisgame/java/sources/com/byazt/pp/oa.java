package com.byazt.pp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public final class oa<V> {
    public final V n;
    public final Throwable qg;

    public oa(V v) {
        this.n = v;
        this.qg = null;
    }

    public oa(Throwable th) {
        this.qg = th;
        this.n = null;
    }

    public V n() {
        return this.n;
    }

    public Throwable qg() {
        return this.qg;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oa)) {
            return false;
        }
        oa oaVar = (oa) obj;
        if (n() != null && n().equals(oaVar.n())) {
            return true;
        }
        if (qg() == null || oaVar.qg() == null) {
            return false;
        }
        return qg().toString().equals(qg().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{n(), qg()});
    }
}
