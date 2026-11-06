package com.byazt.uxi;

import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1300, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo<T> {
    public T hw;
    public T pr;

    public void pr(T t, T t2) {
        this.pr = t;
        this.hw = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return hw(pair.first, this.pr) && hw(pair.second, this.hw);
    }

    private static boolean hw(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public int hashCode() {
        T t = this.pr;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.hw;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.pr + " " + this.hw + "}";
    }
}
