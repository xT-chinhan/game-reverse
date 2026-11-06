package com.byazt.ui;

import com.byazt.ca.aj;
import com.byazt.ewt.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 13})
public class hw extends com.byazt.ewt.hn<com.byazt.tq.hw, com.byazt.pv.hw> {
    public hw(String str, String str2) {
        this.hn = new com.byazt.pv.hw(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pr(final com.byazt.tq.hw hwVar, final zo zoVar) {
        this.hw = hwVar;
        if (zoVar == null) {
            zoVar = new zo(System.currentTimeMillis());
        }
        aj.hn().post(new Runnable() { // from class: com.byazt.ui.hw.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.ewt.uc ucVar : hw.this.pr) {
                    if (ucVar instanceof com.byazt.mc.hw) {
                        switch (AnonymousClass2.pr[hwVar.ordinal()]) {
                            case 1:
                                ((com.byazt.mc.hw) ucVar).pr(hw.this.getContext(), zoVar);
                                break;
                            case 2:
                                ((com.byazt.mc.hw) ucVar).hw(hw.this.getContext(), zoVar);
                                break;
                            case 3:
                                ((com.byazt.mc.hw) ucVar).hn(hw.this.getContext(), zoVar);
                                break;
                            case 4:
                                ((com.byazt.mc.hw) ucVar).x(hw.this.getContext(), zoVar);
                                break;
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.byazt.ui.hw$2, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_ACK_DELAY})
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[com.byazt.tq.hw.values().length];
            pr = iArr;
            try {
                iArr[com.byazt.tq.hw.STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[com.byazt.tq.hw.REQED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[com.byazt.tq.hw.RECEIVED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                pr[com.byazt.tq.hw.LOADED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }
}
