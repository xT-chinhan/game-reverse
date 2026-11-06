package com.byazt.ui;

import com.byazt.ca.aj;
import com.byazt.ewt.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 37})
public class pr extends com.byazt.ewt.hn<com.byazt.tq.pr, com.byazt.pv.pr> {
    public pr(String str, String str2) {
        this.hn = new com.byazt.pv.pr(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pr(final com.byazt.tq.pr prVar, final zo zoVar) {
        this.hw = prVar;
        if (zoVar == null) {
            zoVar = new zo(System.currentTimeMillis());
        }
        aj.hn().post(new Runnable() { // from class: com.byazt.ui.pr.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.ewt.uc ucVar : pr.this.pr) {
                    if (ucVar instanceof com.byazt.mc.pr) {
                        switch (AnonymousClass2.pr[prVar.ordinal()]) {
                            case 1:
                                ((com.byazt.mc.pr) ucVar).pr(pr.this.getContext(), zoVar);
                                break;
                            case 2:
                                ((com.byazt.mc.pr) ucVar).hw(pr.this.getContext(), zoVar);
                                break;
                            case 3:
                                ((com.byazt.mc.pr) ucVar).hn(pr.this.getContext(), zoVar);
                                break;
                            case 4:
                                ((com.byazt.mc.pr) ucVar).x(pr.this.getContext(), zoVar);
                                break;
                            case 5:
                                ((com.byazt.mc.pr) ucVar).c(pr.this.getContext(), zoVar);
                                break;
                            case 6:
                                ((com.byazt.mc.pr) ucVar).uc(pr.this.getContext(), zoVar);
                                break;
                            case 7:
                                ((com.byazt.mc.pr) ucVar).fw(pr.this.getContext(), zoVar);
                                break;
                            case 8:
                                ((com.byazt.mc.pr) ucVar).zo(pr.this.getContext(), zoVar);
                                break;
                            case 9:
                                ((com.byazt.mc.pr) ucVar).aj(pr.this.getContext(), zoVar);
                                break;
                            case 10:
                                ((com.byazt.mc.pr) ucVar).vk(pr.this.getContext(), zoVar);
                                break;
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.byazt.ui.pr$2, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[com.byazt.tq.pr.values().length];
            pr = iArr;
            try {
                iArr[com.byazt.tq.pr.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[com.byazt.tq.pr.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[com.byazt.tq.pr.MARKET_OPENED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                pr[com.byazt.tq.pr.MARKET_CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                pr[com.byazt.tq.pr.DOWNLOAD_STARTED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                pr[com.byazt.tq.pr.DOWNLOAD_PAUSED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                pr[com.byazt.tq.pr.DOWNLOAD_FAILED.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                pr[com.byazt.tq.pr.DOWNLOAD_CANCELED.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                pr[com.byazt.tq.pr.DOWNLOAD_FINISHED.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                pr[com.byazt.tq.pr.END.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }
}
