package com.byazt.ui;

import com.byazt.ca.aj;
import com.byazt.pv.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 62})
public class fw extends com.byazt.ewt.hn<com.byazt.tq.fw, zo> {
    public fw(String str, String str2) {
        this.hn = new zo(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pr(final com.byazt.tq.fw fwVar, final com.byazt.ewt.zo zoVar) {
        this.hw = fwVar;
        if (zoVar == null) {
            zoVar = new com.byazt.ewt.zo(System.currentTimeMillis());
        }
        aj.hn().post(new Runnable() { // from class: com.byazt.ui.fw.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.ewt.uc ucVar : fw.this.pr) {
                    if (ucVar instanceof com.byazt.mc.fw) {
                        switch (AnonymousClass2.pr[fwVar.ordinal()]) {
                            case 1:
                                ((com.byazt.mc.fw) ucVar).pr(fw.this.getContext(), zoVar);
                                break;
                            case 2:
                                ((com.byazt.mc.fw) ucVar).hw(fw.this.getContext(), zoVar);
                                break;
                            case 3:
                                ((com.byazt.mc.fw) ucVar).hn(fw.this.getContext(), zoVar);
                                break;
                            case 4:
                                ((com.byazt.mc.fw) ucVar).x(fw.this.getContext(), zoVar);
                                break;
                            case 5:
                                ((com.byazt.mc.fw) ucVar).c(fw.this.getContext(), zoVar);
                                break;
                            case 6:
                                ((com.byazt.mc.fw) ucVar).uc(fw.this.getContext(), zoVar);
                                break;
                            case 7:
                                ((com.byazt.mc.fw) ucVar).fw(fw.this.getContext(), zoVar);
                                break;
                            case 8:
                                ((com.byazt.mc.fw) ucVar).zo(fw.this.getContext(), zoVar);
                                break;
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.byazt.ui.fw$2, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[com.byazt.tq.fw.values().length];
            pr = iArr;
            try {
                iArr[com.byazt.tq.fw.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[com.byazt.tq.fw.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[com.byazt.tq.fw.LOADED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                pr[com.byazt.tq.fw.RENDER_STARTED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                pr[com.byazt.tq.fw.RENDERED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                pr[com.byazt.tq.fw.SHOWED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                pr[com.byazt.tq.fw.CLICKED.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                pr[com.byazt.tq.fw.END.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }
}
