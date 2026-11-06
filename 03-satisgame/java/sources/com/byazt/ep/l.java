package com.byazt.ep;

import android.content.Context;
import com.byazt.vh.cd;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 18})
public class l {
    public static final String[] n = {"game_start", "game_pause", "game_restart", "game_interact", "game_finish", "game_next", "game_action"};

    public static void n() {
        com.byazt.gu.w.n().n(com.byazt.nf.rv.getContext(), new com.byazt.vh.s() { // from class: com.byazt.ep.l.1
            @Override // com.byazt.vh.s
            public List<com.byazt.vh.qg> n() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.byazt.vh.qg("View") { // from class: com.byazt.ep.l.1.1
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.ar.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("CustomComponent") { // from class: com.byazt.ep.l.1.12
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.ar.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("Text") { // from class: com.byazt.ep.l.1.23
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.ud.qg(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("Image") { // from class: com.byazt.ep.l.1.34
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.mb.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("UpieImage") { // from class: com.byazt.ep.l.1.41
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.dk.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("FlexLayout") { // from class: com.byazt.ep.l.1.42
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.yx.l(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("FrameLayout") { // from class: com.byazt.ep.l.1.43
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.om.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("InteractContainerView") { // from class: com.byazt.ep.l.1.44
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.rg.rv(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("ScrollLayout") { // from class: com.byazt.ep.l.1.45
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.ro.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("RichText") { // from class: com.byazt.ep.l.1.2
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.ud.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("Input") { // from class: com.byazt.ep.l.1.3
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.yj.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("Dislike") { // from class: com.byazt.ep.l.1.4
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.at.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("RatingBar") { // from class: com.byazt.ep.l.1.5
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.ath.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("RatingStar") { // from class: com.byazt.ep.l.1.6
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.ath.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("UgenProgressView") { // from class: com.byazt.ep.l.1.7
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.zy.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("ProgressButton") { // from class: com.byazt.ep.l.1.8
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.zy.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("ProgressBar") { // from class: com.byazt.ep.l.1.9
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.sa.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("Button") { // from class: com.byazt.ep.l.1.10
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.guh.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("RecyclerLayout") { // from class: com.byazt.ep.l.1.11
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.mu.w(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("GridView") { // from class: com.byazt.ep.l.1.13
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.pcc.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("RecycleView") { // from class: com.byazt.ep.l.1.14
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.ama.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("Video") { // from class: com.byazt.ep.l.1.15
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.kx.qg(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("Gif") { // from class: com.byazt.ep.l.1.16
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.yf.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("VideoPlaceholder") { // from class: com.byazt.ep.l.1.17
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.hp.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("Lottie") { // from class: com.byazt.ep.l.1.18
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.kru.qg(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("InterLottie") { // from class: com.byazt.ep.l.1.19
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.kru.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("InteractionWebView") { // from class: com.byazt.ep.l.1.20
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.rg.tj(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("WebView") { // from class: com.byazt.ep.l.1.21
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.il.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("Blur") { // from class: com.byazt.ep.l.1.22
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.xud.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("Swiper") { // from class: com.byazt.ep.l.1.24
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.gu.q(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("SwiperView") { // from class: com.byazt.ep.l.1.25
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.gu.s(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("FVCountdown") { // from class: com.byazt.ep.l.1.26
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.jx.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("RVCountdown") { // from class: com.byazt.ep.l.1.27
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.jx.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("CycleCountDownView") { // from class: com.byazt.ep.l.1.28
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.jx.qg(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("CycleSkip") { // from class: com.byazt.ep.l.1.29
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.uo.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("RewardClickCountdown") { // from class: com.byazt.ep.l.1.30
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.jx.q(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("Icon") { // from class: com.byazt.ep.l.1.31
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.hz.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("FVSkip") { // from class: com.byazt.ep.l.1.32
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.uo.qg(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("RVSkip") { // from class: com.byazt.ep.l.1.33
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.uo.qg(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("VideoV3") { // from class: com.byazt.ep.l.1.35
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.hp.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("PlayableComponent") { // from class: com.byazt.ep.l.1.36
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.om.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("CsjRefreshTip") { // from class: com.byazt.ep.l.1.37
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.jx.s(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("BrokenImage") { // from class: com.byazt.ep.l.1.38
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.ty.n(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("SpriteView") { // from class: com.byazt.ep.l.1.39
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.sj.qg(context);
                    }
                });
                arrayList.add(new com.byazt.vh.qg("GameView") { // from class: com.byazt.ep.l.1.40
                    @Override // com.byazt.vh.qg
                    public com.byazt.ih.s n(Context context) {
                        return new com.byazt.sj.s(context);
                    }
                });
                return arrayList;
            }
        }, new q());
        com.byazt.gu.w.n().n(new com.byazt.xz.rv() { // from class: com.byazt.ep.l.2
            @Override // com.byazt.xz.rv
            public List<com.byazt.xz.fs> n() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.byazt.xz.fs("shake") { // from class: com.byazt.ep.l.2.1
                    @Override // com.byazt.xz.fs
                    public com.byazt.et.qg n(Context context) {
                        return new com.byazt.cv.l(context);
                    }
                });
                arrayList.add(new com.byazt.xz.fs("twist") { // from class: com.byazt.ep.l.2.2
                    @Override // com.byazt.xz.fs
                    public com.byazt.et.qg n(Context context) {
                        return new com.byazt.cv.w(context);
                    }
                });
                arrayList.add(new com.byazt.xz.fs("videoProgress") { // from class: com.byazt.ep.l.2.3
                    @Override // com.byazt.xz.fs
                    public com.byazt.et.qg n(Context context) {
                        return new w(context);
                    }
                });
                arrayList.add(new com.byazt.xz.fs("eraseState") { // from class: com.byazt.ep.l.2.4
                    @Override // com.byazt.xz.fs
                    public com.byazt.et.qg n(Context context) {
                        return new com.byazt.cv.s(context);
                    }
                });
                arrayList.add(new com.byazt.xz.fs("Lottie://state") { // from class: com.byazt.ep.l.2.5
                    @Override // com.byazt.xz.fs
                    public com.byazt.et.qg n(Context context) {
                        return new com.byazt.cv.q(context);
                    }
                });
                arrayList.add(new com.byazt.xz.fs("longTap") { // from class: com.byazt.ep.l.2.6
                    @Override // com.byazt.xz.fs
                    public com.byazt.et.qg n(Context context) {
                        return new w(context);
                    }
                });
                arrayList.add(new com.byazt.xz.fs("tick") { // from class: com.byazt.ep.l.2.7
                    @Override // com.byazt.xz.fs
                    public com.byazt.et.qg n(Context context) {
                        return new w(context);
                    }
                });
                return arrayList;
            }
        });
        com.byazt.gu.w.n().n(new com.byazt.uj.w());
        com.byazt.gu.w.n().n(new com.byazt.uy.q() { // from class: com.byazt.ep.l.3
            @Override // com.byazt.uy.q
            public com.byazt.uy.q.n n(Context context, com.byazt.ih.s sVar) {
                return new x(context, sVar);
            }
        });
        com.byazt.gu.w.n().n(new com.byazt.ey.n() { // from class: com.byazt.ep.l.4
            @Override // com.byazt.ey.n
            public com.byazt.ey.qg n(cd cdVar) {
                return new tj(cdVar);
            }
        });
        com.byazt.gu.w.n().n(new com.byazt.xz.s() { // from class: com.byazt.ep.l.5
            @Override // com.byazt.xz.s
            public List<com.byazt.xz.qg> n() {
                ArrayList arrayList = new ArrayList();
                String[] strArr = {"interactiveFinish", "nextVideoCancel", "haptic", "closeWidget", "dismiss", "openNewAdPage", "businessStatusNotify"};
                for (int i = 0; i < 7; i++) {
                    arrayList.add(new com.byazt.xz.qg(strArr[i]) { // from class: com.byazt.ep.l.5.1
                        @Override // com.byazt.xz.qg
                        public com.byazt.ss.n n(com.byazt.ih.s sVar, String str, com.byazt.xz.x.n nVar) {
                            return new com.byazt.ss.l(sVar, str, nVar);
                        }
                    });
                }
                arrayList.add(new com.byazt.xz.qg("execEffect") { // from class: com.byazt.ep.l.5.2
                    @Override // com.byazt.xz.qg
                    public com.byazt.ss.n n(com.byazt.ih.s sVar, String str, com.byazt.xz.x.n nVar) {
                        return new com.byazt.up.n(sVar, str, nVar);
                    }
                });
                arrayList.add(new com.byazt.xz.qg("Lottie://start") { // from class: com.byazt.ep.l.5.3
                    @Override // com.byazt.xz.qg
                    public com.byazt.ss.n n(com.byazt.ih.s sVar, String str, com.byazt.xz.x.n nVar) {
                        return new com.byazt.up.qg(sVar, str, nVar);
                    }
                });
                arrayList.add(new com.byazt.xz.qg("renderScene") { // from class: com.byazt.ep.l.5.4
                    @Override // com.byazt.xz.qg
                    public com.byazt.ss.n n(com.byazt.ih.s sVar, String str, com.byazt.xz.x.n nVar) {
                        return new com.byazt.ss.l(sVar, str, nVar);
                    }
                });
                arrayList.add(new com.byazt.xz.qg("dismissScene") { // from class: com.byazt.ep.l.5.5
                    @Override // com.byazt.xz.qg
                    public com.byazt.ss.n n(com.byazt.ih.s sVar, String str, com.byazt.xz.x.n nVar) {
                        return new com.byazt.ss.l(sVar, str, nVar);
                    }
                });
                for (final String str : l.n) {
                    arrayList.add(new com.byazt.xz.qg(str) { // from class: com.byazt.ep.l.5.6
                        @Override // com.byazt.xz.qg
                        public com.byazt.ss.n n(com.byazt.ih.s sVar, String str2, com.byazt.xz.x.n nVar) {
                            return new com.byazt.mq.n(sVar, str2, nVar, str);
                        }
                    });
                }
                return arrayList;
            }
        });
    }
}
