package com.byazt.ui;

import com.byazt.ca.aj;
import com.byazt.ewt.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 20})
public class hn extends com.byazt.ewt.hn<com.byazt.tq.hn, com.byazt.pv.hn> {
    public hn(String str, String str2) {
        this.hn = new com.byazt.pv.hn(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pr(final com.byazt.tq.hn hnVar, final zo zoVar) {
        this.hw = hnVar;
        if (zoVar == null) {
            zoVar = new zo(System.currentTimeMillis());
        }
        aj.hn().post(new Runnable() { // from class: com.byazt.ui.hn.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.ewt.uc ucVar : hn.this.pr) {
                    if (ucVar instanceof com.byazt.mc.hn) {
                        switch (AnonymousClass2.pr[hnVar.ordinal()]) {
                            case 1:
                                ((com.byazt.mc.hn) ucVar).pr(hn.this.getContext(), zoVar);
                                break;
                            case 2:
                                ((com.byazt.mc.hn) ucVar).hw(hn.this.getContext(), zoVar);
                                break;
                            case 3:
                                ((com.byazt.mc.hn) ucVar).hn(hn.this.getContext(), zoVar);
                                break;
                            case 4:
                                ((com.byazt.mc.hn) ucVar).x(hn.this.getContext(), zoVar);
                                break;
                            case 5:
                                ((com.byazt.mc.hn) ucVar).c(hn.this.getContext(), zoVar);
                                break;
                            case 6:
                                ((com.byazt.mc.hn) ucVar).uc(hn.this.getContext(), zoVar);
                                break;
                            case 7:
                                ((com.byazt.mc.hn) ucVar).fw(hn.this.getContext(), zoVar);
                                break;
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.byazt.ui.hn$2, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 58})
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[com.byazt.tq.hn.values().length];
            pr = iArr;
            try {
                iArr[com.byazt.tq.hn.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[com.byazt.tq.hn.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[com.byazt.tq.hn.SHOWED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                pr[com.byazt.tq.hn.VISIBLED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                pr[com.byazt.tq.hn.INVISIBLED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                pr[com.byazt.tq.hn.CLICKED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                pr[com.byazt.tq.hn.END.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }
}
