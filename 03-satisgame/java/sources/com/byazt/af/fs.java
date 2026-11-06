package com.byazt.af;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME, 101})
public abstract class fs {
    public static final String n = "fs";
    public final Set<String> qg = new HashSet(1);

    public abstract void n();

    public abstract void n(String str);

    public synchronized boolean qg(String str) {
        return true;
    }

    public final synchronized boolean n(String str, int i) {
        try {
            if (i == 0) {
                return n(str, w.GRANTED);
            }
            return n(str, w.DENIED);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.byazt.af.fs$5, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CLOCK_DIFF})
    static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[w.values().length];
            n = iArr;
            try {
                iArr[w.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[w.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[w.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public final synchronized boolean n(final String str, w wVar) {
        this.qg.remove(str);
        int i = AnonymousClass5.n[wVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.af.fs.2
                    @Override // java.lang.Runnable
                    public void run() {
                        fs.this.n(str);
                    }
                });
                return true;
            }
            if (i == 3) {
                if (qg(str)) {
                    if (this.qg.isEmpty()) {
                        com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.af.fs.3
                            @Override // java.lang.Runnable
                            public void run() {
                                fs.this.n();
                            }
                        });
                        return true;
                    }
                } else {
                    com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.af.fs.4
                        @Override // java.lang.Runnable
                        public void run() {
                            fs.this.n(str);
                        }
                    });
                    return true;
                }
            }
        } else if (this.qg.isEmpty()) {
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.af.fs.1
                @Override // java.lang.Runnable
                public void run() {
                    fs.this.n();
                }
            });
            return true;
        }
        return false;
    }

    public final synchronized void n(String[] strArr) {
        Collections.addAll(this.qg, strArr);
    }
}
