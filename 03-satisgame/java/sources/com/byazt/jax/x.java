package com.byazt.jax;

import com.byazt.wea.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 21})
public class x extends com.byazt.bok.n<com.byazt.hes.x, rv> {
    public x(String str, String str2) {
        this.s = new rv(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n(final com.byazt.hes.x xVar, final com.byazt.bok.w wVar) {
        this.qg = xVar;
        if (wVar == null) {
            wVar = new com.byazt.bok.w(System.currentTimeMillis());
        }
        com.byazt.tk.rv.s().post(new Runnable() { // from class: com.byazt.jax.x.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.bok.l lVar : x.this.n) {
                    if (lVar instanceof com.byazt.kmf.x) {
                        try {
                            switch (AnonymousClass2.n[xVar.ordinal()]) {
                                case 1:
                                    ((com.byazt.kmf.x) lVar).n(x.this.getContext(), wVar);
                                    break;
                                case 2:
                                    ((com.byazt.kmf.x) lVar).qg(x.this.getContext(), wVar);
                                    break;
                                case 3:
                                    ((com.byazt.kmf.x) lVar).s(x.this.getContext(), wVar);
                                    break;
                                case 4:
                                    ((com.byazt.kmf.x) lVar).q(x.this.getContext(), wVar);
                                    break;
                                case 5:
                                    ((com.byazt.kmf.x) lVar).l(x.this.getContext(), wVar);
                                    break;
                                case 6:
                                    ((com.byazt.kmf.x) lVar).w(x.this.getContext(), wVar);
                                    break;
                                case 7:
                                    ((com.byazt.kmf.x) lVar).x(x.this.getContext(), wVar);
                                    break;
                                case 8:
                                    ((com.byazt.kmf.x) lVar).fs(x.this.getContext(), wVar);
                                    break;
                            }
                        } catch (Throwable th) {
                            com.byazt.bok.q.n(lVar, th, "easy_play", x.qg(xVar));
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.byazt.jax.x$2, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL})
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[com.byazt.hes.x.values().length];
            n = iArr;
            try {
                iArr[com.byazt.hes.x.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[com.byazt.hes.x.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[com.byazt.hes.x.LOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                n[com.byazt.hes.x.RENDER_STARTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                n[com.byazt.hes.x.RENDERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                n[com.byazt.hes.x.SHOWED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                n[com.byazt.hes.x.CLICKED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                n[com.byazt.hes.x.END.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String qg(com.byazt.hes.x xVar) {
        if (xVar == null) {
            return null;
        }
        switch (AnonymousClass2.n[xVar.ordinal()]) {
            case 1:
                return "created";
            case 2:
                return "started";
            case 3:
                return "loaded";
            case 4:
                return "render_started";
            case 5:
                return "rendered";
            case 6:
                return "showed";
            case 7:
                return "clicked";
            case 8:
                return "end";
            default:
                return null;
        }
    }
}
