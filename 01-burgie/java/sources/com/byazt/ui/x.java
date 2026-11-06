package com.byazt.ui;

import com.byazt.ca.aj;
import com.byazt.ewt.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 121})
public class x extends com.byazt.ewt.hn<com.byazt.tq.x, com.byazt.pv.x> {
    public x(String str, String str2) {
        this.hn = new com.byazt.pv.x(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pr(final com.byazt.tq.x xVar, final zo zoVar) {
        this.hw = xVar;
        if (zoVar == null) {
            zoVar = new zo(System.currentTimeMillis());
        }
        aj.hn().post(new Runnable() { // from class: com.byazt.ui.x.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.ewt.uc ucVar : x.this.pr) {
                    if (ucVar instanceof com.byazt.mc.x) {
                        switch (AnonymousClass2.pr[xVar.ordinal()]) {
                            case 1:
                                ((com.byazt.mc.x) ucVar).pr(x.this.getContext(), zoVar);
                                break;
                            case 2:
                                ((com.byazt.mc.x) ucVar).hw(x.this.getContext(), zoVar);
                                break;
                            case 3:
                                ((com.byazt.mc.x) ucVar).hn(x.this.getContext(), zoVar);
                                break;
                            case 4:
                                ((com.byazt.mc.x) ucVar).x(x.this.getContext(), zoVar);
                                break;
                            case 5:
                                ((com.byazt.mc.x) ucVar).c(x.this.getContext(), zoVar);
                                break;
                            case 6:
                                ((com.byazt.mc.x) ucVar).uc(x.this.getContext(), zoVar);
                                break;
                            case 7:
                                ((com.byazt.mc.x) ucVar).fw(x.this.getContext(), zoVar);
                                break;
                            case 8:
                                ((com.byazt.mc.x) ucVar).zo(x.this.getContext(), zoVar);
                                break;
                            case 9:
                                ((com.byazt.mc.x) ucVar).aj(x.this.getContext(), zoVar);
                                break;
                            case 10:
                                ((com.byazt.mc.x) ucVar).vk(x.this.getContext(), zoVar);
                                break;
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.byazt.ui.x$2, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 441})
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[com.byazt.tq.x.values().length];
            pr = iArr;
            try {
                iArr[com.byazt.tq.x.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[com.byazt.tq.x.INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[com.byazt.tq.x.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                pr[com.byazt.tq.x.PREPARED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                pr[com.byazt.tq.x.PLAYED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                pr[com.byazt.tq.x.BUFFERED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                pr[com.byazt.tq.x.PAUSED.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                pr[com.byazt.tq.x.STOPPED.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                pr[com.byazt.tq.x.COMPLETED.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                pr[com.byazt.tq.x.END.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }
}
