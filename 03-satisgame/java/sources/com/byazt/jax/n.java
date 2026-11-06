package com.byazt.jax;

import com.byazt.tk.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 19})
public class n extends com.byazt.bok.n<com.byazt.hes.n, com.byazt.wea.qg> {
    public n(String str, String str2) {
        this.s = new com.byazt.wea.qg(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n(final com.byazt.hes.n nVar, final com.byazt.bok.w wVar) {
        this.qg = nVar;
        if (wVar == null) {
            wVar = new com.byazt.bok.w(System.currentTimeMillis());
        }
        rv.s().post(new Runnable() { // from class: com.byazt.jax.n.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.bok.l lVar : n.this.n) {
                    if (lVar instanceof com.byazt.kmf.n) {
                        try {
                            switch (AnonymousClass2.n[nVar.ordinal()]) {
                                case 1:
                                    ((com.byazt.kmf.n) lVar).n(n.this.getContext(), wVar);
                                    break;
                                case 2:
                                    ((com.byazt.kmf.n) lVar).qg(n.this.getContext(), wVar);
                                    break;
                                case 3:
                                    ((com.byazt.kmf.n) lVar).s(n.this.getContext(), wVar);
                                    break;
                                case 4:
                                    ((com.byazt.kmf.n) lVar).q(n.this.getContext(), wVar);
                                    break;
                                case 5:
                                    ((com.byazt.kmf.n) lVar).l(n.this.getContext(), wVar);
                                    break;
                                case 6:
                                    ((com.byazt.kmf.n) lVar).w(n.this.getContext(), wVar);
                                    break;
                                case 7:
                                    ((com.byazt.kmf.n) lVar).x(n.this.getContext(), wVar);
                                    break;
                                case 8:
                                    ((com.byazt.kmf.n) lVar).fs(n.this.getContext(), wVar);
                                    break;
                                case 9:
                                    ((com.byazt.kmf.n) lVar).rv(n.this.getContext(), wVar);
                                    break;
                                case 10:
                                    ((com.byazt.kmf.n) lVar).tj(n.this.getContext(), wVar);
                                    break;
                            }
                        } catch (Throwable th) {
                            com.byazt.bok.q.n(lVar, th, "download", n.qg(nVar));
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.byazt.jax.n$2, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 82})
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[com.byazt.hes.n.values().length];
            n = iArr;
            try {
                iArr[com.byazt.hes.n.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[com.byazt.hes.n.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[com.byazt.hes.n.MARKET_OPENED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                n[com.byazt.hes.n.MARKET_CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                n[com.byazt.hes.n.DOWNLOAD_STARTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                n[com.byazt.hes.n.DOWNLOAD_PAUSED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                n[com.byazt.hes.n.DOWNLOAD_FAILED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                n[com.byazt.hes.n.DOWNLOAD_CANCELED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                n[com.byazt.hes.n.DOWNLOAD_FINISHED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                n[com.byazt.hes.n.END.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String qg(com.byazt.hes.n nVar) {
        if (nVar == null) {
            return null;
        }
        switch (AnonymousClass2.n[nVar.ordinal()]) {
            case 1:
                return "created";
            case 2:
                return "started";
            case 3:
                return "market_opened";
            case 4:
                return "market_closed";
            case 5:
                return "download_started";
            case 6:
                return "download_paused";
            case 7:
                return "download_failed";
            case 8:
                return "download_canceled";
            case 9:
                return "download_finished";
            case 10:
                return "end";
            default:
                return null;
        }
    }
}
