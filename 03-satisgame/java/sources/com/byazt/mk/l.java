package com.byazt.mk;

import android.os.Handler;
import android.os.Looper;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1141, 18})
public abstract class l {
    public static final String n = "l";
    public Looper qg = Looper.getMainLooper();
    public final Set<String> s = new HashSet(1);

    public abstract void n();

    public abstract void n(String str);

    public synchronized boolean qg(String str) {
        com.byazt.rb.qg.qg(n, "permission not found:".concat(String.valueOf(str)));
        return true;
    }

    public final synchronized boolean n(String str, int i) {
        try {
            if (i == 0) {
                return n(str, s.GRANTED);
            }
            return n(str, s.DENIED);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.byazt.mk.l$5, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 1141, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE})
    static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[s.values().length];
            n = iArr;
            try {
                iArr[s.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[s.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[s.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public final synchronized boolean n(final String str, s sVar) {
        this.s.remove(str);
        int i = AnonymousClass5.n[sVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                new Handler(this.qg).post(new Runnable() { // from class: com.byazt.mk.l.2
                    @Override // java.lang.Runnable
                    public void run() {
                        l.this.n(str);
                    }
                });
                return true;
            }
            if (i == 3) {
                if (qg(str)) {
                    if (this.s.isEmpty()) {
                        new Handler(this.qg).post(new Runnable() { // from class: com.byazt.mk.l.3
                            @Override // java.lang.Runnable
                            public void run() {
                                l.this.n();
                            }
                        });
                        return true;
                    }
                } else {
                    new Handler(this.qg).post(new Runnable() { // from class: com.byazt.mk.l.4
                        @Override // java.lang.Runnable
                        public void run() {
                            l.this.n(str);
                        }
                    });
                    return true;
                }
            }
        } else if (this.s.isEmpty()) {
            new Handler(this.qg).post(new Runnable() { // from class: com.byazt.mk.l.1
                @Override // java.lang.Runnable
                public void run() {
                    l.this.n();
                }
            });
            return true;
        }
        return false;
    }

    public final synchronized void n(String[] strArr) {
        Collections.addAll(this.s, strArr);
    }
}
