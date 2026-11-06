package com.byazt.mp;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_OFFER_SEND_TIME, 8})
public class s {
    public static Function<SparseArray<Object>, Object> n(Object obj) {
        if (obj instanceof Function) {
            return (Function) obj;
        }
        return com.byazt.qvu.n.qg;
    }
}
