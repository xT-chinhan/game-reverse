package com.byazt.jax;

import com.byazt.tk.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 26})
public class qg extends com.byazt.bok.n<com.byazt.hes.qg, com.byazt.wea.s> {
    public long q;

    public qg(String str, String str2) {
        this.s = new com.byazt.wea.s(str, str2);
        this.q = System.currentTimeMillis();
    }

    public boolean n(long j) {
        return j > 0 && this.s != 0 && ((com.byazt.wea.s) this.s).qg == 1 && System.currentTimeMillis() - (j * 1000) > this.q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n(final com.byazt.hes.qg qgVar, final com.byazt.bok.w wVar) {
        this.qg = qgVar;
        if (wVar == null) {
            wVar = new com.byazt.bok.w(System.currentTimeMillis());
        }
        rv.s().post(new Runnable() { // from class: com.byazt.jax.qg.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.bok.l lVar : qg.this.n) {
                    if (lVar instanceof com.byazt.kmf.qg) {
                        try {
                            int i = AnonymousClass2.n[qgVar.ordinal()];
                            if (i == 1) {
                                ((com.byazt.kmf.qg) lVar).n(qg.this.getContext(), wVar);
                            } else if (i == 2) {
                                ((com.byazt.kmf.qg) lVar).qg(qg.this.getContext(), wVar);
                            } else if (i == 3) {
                                ((com.byazt.kmf.qg) lVar).s(qg.this.getContext(), wVar);
                            } else if (i == 4) {
                                ((com.byazt.kmf.qg) lVar).q(qg.this.getContext(), wVar);
                            }
                        } catch (Throwable th) {
                            com.byazt.bok.q.n(lVar, th, "ad_load", qg.qg(qgVar));
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.byazt.jax.qg$2, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 87})
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[com.byazt.hes.qg.values().length];
            n = iArr;
            try {
                iArr[com.byazt.hes.qg.STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[com.byazt.hes.qg.REQED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[com.byazt.hes.qg.RECEIVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                n[com.byazt.hes.qg.LOADED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String qg(com.byazt.hes.qg qgVar) {
        if (qgVar == null) {
            return null;
        }
        int i = AnonymousClass2.n[qgVar.ordinal()];
        if (i == 1) {
            return "started";
        }
        if (i == 2) {
            return "reqed";
        }
        if (i == 3) {
            return "received";
        }
        if (i != 4) {
            return null;
        }
        return "loaded";
    }
}
