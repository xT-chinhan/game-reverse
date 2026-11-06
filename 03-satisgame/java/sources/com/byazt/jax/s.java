package com.byazt.jax;

import com.byazt.tk.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 8})
public class s extends com.byazt.bok.n<com.byazt.hes.s, com.byazt.wea.q> {
    public s(String str, String str2) {
        this.s = new com.byazt.wea.q(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n(final com.byazt.hes.s sVar, final com.byazt.bok.w wVar) {
        this.qg = sVar;
        if (wVar == null) {
            wVar = new com.byazt.bok.w(System.currentTimeMillis());
        }
        rv.s().post(new Runnable() { // from class: com.byazt.jax.s.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.bok.l lVar : s.this.n) {
                    if (lVar instanceof com.byazt.kmf.s) {
                        try {
                            switch (AnonymousClass2.n[sVar.ordinal()]) {
                                case 1:
                                    ((com.byazt.kmf.s) lVar).n(s.this.getContext(), wVar);
                                    break;
                                case 2:
                                    ((com.byazt.kmf.s) lVar).qg(s.this.getContext(), wVar);
                                    break;
                                case 3:
                                    ((com.byazt.kmf.s) lVar).s(s.this.getContext(), wVar);
                                    break;
                                case 4:
                                    ((com.byazt.kmf.s) lVar).q(s.this.getContext(), wVar);
                                    break;
                                case 5:
                                    ((com.byazt.kmf.s) lVar).l(s.this.getContext(), wVar);
                                    break;
                                case 6:
                                    ((com.byazt.kmf.s) lVar).w(s.this.getContext(), wVar);
                                    break;
                                case 7:
                                    ((com.byazt.kmf.s) lVar).x(s.this.getContext(), wVar);
                                    break;
                            }
                        } catch (Throwable th) {
                            com.byazt.bok.q.n(lVar, th, "ad_show", s.qg(sVar));
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.byazt.jax.s$2, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 205})
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[com.byazt.hes.s.values().length];
            n = iArr;
            try {
                iArr[com.byazt.hes.s.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[com.byazt.hes.s.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[com.byazt.hes.s.SHOWED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                n[com.byazt.hes.s.VISIBLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                n[com.byazt.hes.s.INVISIBLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                n[com.byazt.hes.s.CLICKED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                n[com.byazt.hes.s.END.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String qg(com.byazt.hes.s sVar) {
        if (sVar == null) {
            return null;
        }
        switch (AnonymousClass2.n[sVar.ordinal()]) {
            case 1:
                return "created";
            case 2:
                return "started";
            case 3:
                return "showed";
            case 4:
                return "visibled";
            case 5:
                return "invisibled";
            case 6:
                return "clicked";
            case 7:
                return "end";
            default:
                return null;
        }
    }
}
