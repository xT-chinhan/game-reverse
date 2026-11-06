package com.byazt.ui;

import com.byazt.ca.aj;
import com.byazt.ewt.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends com.byazt.ewt.hn<com.byazt.tq.c, com.byazt.pv.c> {
    public c(String str, String str2) {
        this.hn = new com.byazt.pv.c(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pr(final com.byazt.tq.c cVar, final zo zoVar) {
        this.hw = cVar;
        if (zoVar == null) {
            zoVar = new zo(System.currentTimeMillis());
        }
        aj.hn().post(new Runnable() { // from class: com.byazt.ui.c.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.ewt.uc ucVar : c.this.pr) {
                    if (ucVar instanceof com.byazt.mc.c) {
                        switch (AnonymousClass2.pr[cVar.ordinal()]) {
                            case 1:
                                ((com.byazt.mc.c) ucVar).pr(c.this.getContext(), zoVar);
                                break;
                            case 2:
                                ((com.byazt.mc.c) ucVar).hw(c.this.getContext(), zoVar);
                                break;
                            case 3:
                                ((com.byazt.mc.c) ucVar).hn(c.this.getContext(), zoVar);
                                break;
                            case 4:
                                ((com.byazt.mc.c) ucVar).x(c.this.getContext(), zoVar);
                                break;
                            case 5:
                                ((com.byazt.mc.c) ucVar).c(c.this.getContext(), zoVar);
                                break;
                            case 6:
                                ((com.byazt.mc.c) ucVar).uc(c.this.getContext(), zoVar);
                                break;
                            case 7:
                                ((com.byazt.mc.c) ucVar).fw(c.this.getContext(), zoVar);
                                break;
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.byazt.ui.c$2, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS})
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[com.byazt.tq.c.values().length];
            pr = iArr;
            try {
                iArr[com.byazt.tq.c.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[com.byazt.tq.c.ATTACHED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[com.byazt.tq.c.FOCUSED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                pr[com.byazt.tq.c.VISIBLED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                pr[com.byazt.tq.c.INVISIBLED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                pr[com.byazt.tq.c.DETACHED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                pr[com.byazt.tq.c.END.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }
}
