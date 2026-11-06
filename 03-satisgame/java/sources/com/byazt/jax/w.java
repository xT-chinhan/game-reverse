package com.byazt.jax;

import com.anythink.core.common.f.a;
import com.byazt.tk.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 13})
public class w extends com.byazt.bok.n<com.byazt.hes.w, com.byazt.wea.x> {
    public w(String str, String str2) {
        this.s = new com.byazt.wea.x(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n(final com.byazt.hes.w wVar, final com.byazt.bok.w wVar2) {
        this.qg = wVar;
        if (wVar2 == null) {
            wVar2 = new com.byazt.bok.w(System.currentTimeMillis());
        }
        rv.s().post(new Runnable() { // from class: com.byazt.jax.w.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.bok.l lVar : w.this.n) {
                    if (lVar instanceof com.byazt.kmf.w) {
                        try {
                            int i = AnonymousClass2.n[wVar.ordinal()];
                            if (i == 1) {
                                ((com.byazt.kmf.w) lVar).n(w.this.getContext(), wVar2);
                            } else if (i == 2) {
                                ((com.byazt.kmf.w) lVar).qg(w.this.getContext(), wVar2);
                            } else if (i == 3) {
                                ((com.byazt.kmf.w) lVar).s(w.this.getContext(), wVar2);
                            } else if (i == 4) {
                                ((com.byazt.kmf.w) lVar).q(w.this.getContext(), wVar2);
                            }
                        } catch (Throwable th) {
                            com.byazt.bok.q.n(lVar, th, a.C0017a.c, w.qg(wVar));
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.byazt.jax.w$2, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 43})
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[com.byazt.hes.w.values().length];
            n = iArr;
            try {
                iArr[com.byazt.hes.w.STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[com.byazt.hes.w.FOREGROUNDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[com.byazt.hes.w.BACKGROUNDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                n[com.byazt.hes.w.END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String qg(com.byazt.hes.w wVar) {
        if (wVar == null) {
            return null;
        }
        int i = AnonymousClass2.n[wVar.ordinal()];
        if (i == 1) {
            return "started";
        }
        if (i == 2) {
            return "foregrounded";
        }
        if (i == 3) {
            return "backgrounded";
        }
        if (i != 4) {
            return null;
        }
        return "end";
    }
}
