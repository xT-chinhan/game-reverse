package com.byazt.ui;

import com.byazt.ca.aj;
import com.byazt.ewt.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 5})
public class uc extends com.byazt.ewt.hn<com.byazt.tq.uc, com.byazt.pv.uc> {
    public uc(String str, String str2) {
        this.hn = new com.byazt.pv.uc(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pr(final com.byazt.tq.uc ucVar, final zo zoVar) {
        this.hw = ucVar;
        if (zoVar == null) {
            zoVar = new zo(System.currentTimeMillis());
        }
        aj.hn().post(new Runnable() { // from class: com.byazt.ui.uc.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.ewt.uc ucVar2 : uc.this.pr) {
                    if (ucVar2 instanceof com.byazt.mc.uc) {
                        switch (AnonymousClass2.pr[ucVar.ordinal()]) {
                            case 1:
                                ((com.byazt.mc.uc) ucVar2).pr(uc.this.getContext(), zoVar);
                                break;
                            case 2:
                                ((com.byazt.mc.uc) ucVar2).hw(uc.this.getContext(), zoVar);
                                break;
                            case 3:
                                ((com.byazt.mc.uc) ucVar2).hn(uc.this.getContext(), zoVar);
                                break;
                            case 4:
                                ((com.byazt.mc.uc) ucVar2).x(uc.this.getContext(), zoVar);
                                break;
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.byazt.ui.uc$2, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 68})
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[com.byazt.tq.uc.values().length];
            pr = iArr;
            try {
                iArr[com.byazt.tq.uc.STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[com.byazt.tq.uc.FOREGROUNDED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[com.byazt.tq.uc.BACKGROUNDED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                pr[com.byazt.tq.uc.END.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }
}
