package com.byazt.ae;

import android.os.Build;
import com.byakv.j.FlippedV2Impl;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 592, 13})
public class hw {
    public static final AtomicBoolean pr = new AtomicBoolean(false);

    public static void pr() {
        AtomicBoolean atomicBoolean = pr;
        if (!atomicBoolean.get()) {
            synchronized (hw.class) {
                if (atomicBoolean.compareAndSet(false, true)) {
                    hw().invokeHiddenApiRestrictions();
                }
            }
        }
    }

    private static com.byazt.frx.hn hw() {
        if (hn()) {
            return new FlippedV2Impl();
        }
        if (x()) {
            return new com.byazt.frx.hw();
        }
        return new com.byazt.frx.pr();
    }

    private static boolean hn() {
        if (Build.VERSION.SDK_INT < 30) {
            return Build.VERSION.SDK_INT == 29 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    private static boolean x() {
        if (Build.VERSION.SDK_INT < 28) {
            return Build.VERSION.SDK_INT == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }
}
