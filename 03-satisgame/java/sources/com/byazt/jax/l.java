package com.byazt.jax;

import com.byazt.tk.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 18})
public class l extends com.byazt.bok.n<com.byazt.hes.l, com.byazt.wea.w> {
    public l(String str, String str2) {
        this.s = new com.byazt.wea.w(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n(final com.byazt.hes.l lVar, final com.byazt.bok.w wVar) {
        this.qg = lVar;
        if (wVar == null) {
            wVar = new com.byazt.bok.w(System.currentTimeMillis());
        }
        rv.s().post(new Runnable() { // from class: com.byazt.jax.l.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.bok.l lVar2 : l.this.n) {
                    if (lVar2 instanceof com.byazt.kmf.l) {
                        try {
                            switch (AnonymousClass2.n[lVar.ordinal()]) {
                                case 1:
                                    ((com.byazt.kmf.l) lVar2).n(l.this.getContext(), wVar);
                                    break;
                                case 2:
                                    ((com.byazt.kmf.l) lVar2).qg(l.this.getContext(), wVar);
                                    break;
                                case 3:
                                    ((com.byazt.kmf.l) lVar2).s(l.this.getContext(), wVar);
                                    break;
                                case 4:
                                    ((com.byazt.kmf.l) lVar2).q(l.this.getContext(), wVar);
                                    break;
                                case 5:
                                    ((com.byazt.kmf.l) lVar2).l(l.this.getContext(), wVar);
                                    break;
                                case 6:
                                    ((com.byazt.kmf.l) lVar2).w(l.this.getContext(), wVar);
                                    break;
                                case 7:
                                    ((com.byazt.kmf.l) lVar2).x(l.this.getContext(), wVar);
                                    break;
                            }
                        } catch (Throwable th) {
                            com.byazt.bok.q.n(lVar2, th, "view", l.qg(lVar));
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.byazt.jax.l$2, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 97})
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[com.byazt.hes.l.values().length];
            n = iArr;
            try {
                iArr[com.byazt.hes.l.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[com.byazt.hes.l.ATTACHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[com.byazt.hes.l.FOCUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                n[com.byazt.hes.l.VISIBLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                n[com.byazt.hes.l.INVISIBLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                n[com.byazt.hes.l.DETACHED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                n[com.byazt.hes.l.END.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String qg(com.byazt.hes.l lVar) {
        if (lVar == null) {
            return null;
        }
        switch (AnonymousClass2.n[lVar.ordinal()]) {
            case 1:
                return "created";
            case 2:
                return "attached";
            case 3:
                return "focused";
            case 4:
                return "visibled";
            case 5:
                return "invisibled";
            case 6:
                return "detached";
            case 7:
                return "end";
            default:
                return null;
        }
    }
}
