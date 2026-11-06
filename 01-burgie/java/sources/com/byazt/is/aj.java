package com.byazt.is;

import android.support.v4.app.NotificationCompat;
import com.byazt.ca.ho;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, 61})
public class aj {
    public static PluginValueSet hn;
    public static com.byazt.sd.hn hw;
    public static final AtomicInteger pr = new AtomicInteger(com.byazt.mg.hw.hw(a.getContext(), "sync_switch", 0).getInt(NotificationCompat.CATEGORY_STATUS, 1));

    public static boolean pr() {
        return pr.get() == 1;
    }

    public static void pr(int i) {
        com.byazt.sd.hn hnVar;
        if (i != 1 && i != 2) {
            return;
        }
        com.byazt.mg.hw.hw(a.getContext(), "sync_switch", 0).edit().putInt(NotificationCompat.CATEGORY_STATUS, i).apply();
        AtomicInteger atomicInteger = pr;
        int i2 = atomicInteger.get();
        atomicInteger.set(i);
        if (i2 == 2 && i == 1 && (hnVar = hw) != null && !hnVar.pr()) {
            try {
                hw.pr(a.getContext(), hn, new com.byazt.ofr.hn((Function) hn.objectValue(15, Function.class)));
                hw = null;
                hn = null;
            } catch (Throwable th) {
                ho.pr("SdkSwitch", "init sdk error", th);
            }
        }
    }
}
