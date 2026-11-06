package com.byazt.lh;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1475, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public float n;
    public float qg;

    public rv(float f, float f2) {
        this.n = f;
        this.qg = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            rv rvVar = (rv) obj;
            if (Float.compare(rvVar.n, this.n) == 0 && Float.compare(rvVar.qg, this.qg) == 0) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.n), Float.valueOf(this.qg)});
    }
}
