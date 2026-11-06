package com.byazt.jax;

import com.byazt.tk.rv;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 5})
public class q extends com.byazt.bok.n<com.byazt.hes.q, com.byazt.wea.l> {
    public q(String str, String str2) {
        this.s = new com.byazt.wea.l(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n(final com.byazt.hes.q qVar, final com.byazt.bok.w wVar) {
        this.qg = qVar;
        if (wVar == null) {
            wVar = new com.byazt.bok.w(System.currentTimeMillis());
        }
        rv.s().post(new Runnable() { // from class: com.byazt.jax.q.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.bok.l lVar : q.this.n) {
                    if (lVar instanceof com.byazt.kmf.q) {
                        try {
                            switch (AnonymousClass2.n[qVar.ordinal()]) {
                                case 1:
                                    ((com.byazt.kmf.q) lVar).n(q.this.getContext(), wVar);
                                    break;
                                case 2:
                                    ((com.byazt.kmf.q) lVar).qg(q.this.getContext(), wVar);
                                    break;
                                case 3:
                                    ((com.byazt.kmf.q) lVar).s(q.this.getContext(), wVar);
                                    break;
                                case 4:
                                    ((com.byazt.kmf.q) lVar).q(q.this.getContext(), wVar);
                                    break;
                                case 5:
                                    ((com.byazt.kmf.q) lVar).l(q.this.getContext(), wVar);
                                    break;
                                case 6:
                                    ((com.byazt.kmf.q) lVar).w(q.this.getContext(), wVar);
                                    break;
                                case 7:
                                    ((com.byazt.kmf.q) lVar).x(q.this.getContext(), wVar);
                                    break;
                                case 8:
                                    ((com.byazt.kmf.q) lVar).fs(q.this.getContext(), wVar);
                                    break;
                                case 9:
                                    ((com.byazt.kmf.q) lVar).rv(q.this.getContext(), wVar);
                                    break;
                                case 10:
                                    ((com.byazt.kmf.q) lVar).tj(q.this.getContext(), wVar);
                                    break;
                            }
                        } catch (Throwable th) {
                            com.byazt.bok.q.n(lVar, th, MediaFormat.KEY_VIDEO, q.qg(qVar));
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.byazt.jax.q$2, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 63})
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[com.byazt.hes.q.values().length];
            n = iArr;
            try {
                iArr[com.byazt.hes.q.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[com.byazt.hes.q.INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[com.byazt.hes.q.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                n[com.byazt.hes.q.PREPARED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                n[com.byazt.hes.q.PLAYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                n[com.byazt.hes.q.BUFFERED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                n[com.byazt.hes.q.PAUSED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                n[com.byazt.hes.q.STOPPED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                n[com.byazt.hes.q.COMPLETED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                n[com.byazt.hes.q.END.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String qg(com.byazt.hes.q qVar) {
        if (qVar == null) {
            return null;
        }
        switch (AnonymousClass2.n[qVar.ordinal()]) {
            case 1:
                return "created";
            case 2:
                return "initialized";
            case 3:
                return "started";
            case 4:
                return "prepared";
            case 5:
                return "played";
            case 6:
                return "buffered";
            case 7:
                return "paused";
            case 8:
                return "stopped";
            case 9:
                return "completed";
            case 10:
                return "end";
            default:
                return null;
        }
    }
}
