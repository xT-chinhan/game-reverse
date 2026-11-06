package com.byazt.ry;

import android.os.Build;
import com.byakv.l.FlippedV2Impl;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH, 26})
public class qg {
    public static final AtomicBoolean n = new AtomicBoolean(false);

    public static void n() {
        AtomicBoolean atomicBoolean = n;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (qg.class) {
            if (atomicBoolean.compareAndSet(false, true)) {
                qg().invokeHiddenApiRestrictions();
            }
        }
    }

    private static com.byazt.qbj.s qg() {
        if (s()) {
            return new FlippedV2Impl();
        }
        if (q()) {
            return new com.byazt.qbj.qg();
        }
        return new com.byazt.qbj.n();
    }

    private static boolean s() {
        if (Build.VERSION.SDK_INT < 30) {
            return Build.VERSION.SDK_INT == 29 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    private static boolean q() {
        if (Build.VERSION.SDK_INT < 28) {
            return Build.VERSION.SDK_INT == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }
}
