package com.byazt.ea;

import android.content.Context;
import com.bumptech.glide.Registry;
import com.byazt.ch.lb;
import com.byazt.sd.a;
import com.byazt.uq.k;
import com.byazt.uq.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static void pr() {
        com.byazt.llk.uc.pr().pr(a.getContext(), new com.byazt.ch.hn() { // from class: com.byazt.ea.c.1
            @Override // com.byazt.ch.hn
            public List<com.byazt.ch.hw> pr() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.byazt.ch.hw("View") { // from class: com.byazt.ea.c.1.1
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.jhh.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("CustomComponent") { // from class: com.byazt.ea.c.1.12
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.jhh.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("Text") { // from class: com.byazt.ea.c.1.23
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.id.hw(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("Image") { // from class: com.byazt.ea.c.1.34
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.ru.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("UpieImage") { // from class: com.byazt.ea.c.1.36
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.of.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("FlexLayout") { // from class: com.byazt.ea.c.1.37
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.gqi.c(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("FrameLayout") { // from class: com.byazt.ea.c.1.38
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.ajv.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("InteractContainerView") { // from class: com.byazt.ea.c.1.39
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new k(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("ScrollLayout") { // from class: com.byazt.ea.c.1.40
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.fo.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("RichText") { // from class: com.byazt.ea.c.1.2
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.id.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("Input") { // from class: com.byazt.ea.c.1.3
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.hj.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("Dislike") { // from class: com.byazt.ea.c.1.4
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.wni.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("RatingBar") { // from class: com.byazt.ea.c.1.5
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.vy.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("RatingStar") { // from class: com.byazt.ea.c.1.6
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.vy.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("UgenProgressView") { // from class: com.byazt.ea.c.1.7
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.oab.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("ProgressButton") { // from class: com.byazt.ea.c.1.8
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.oab.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("Button") { // from class: com.byazt.ea.c.1.9
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.zk.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("RecyclerLayout") { // from class: com.byazt.ea.c.1.10
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.um.uc(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("Video") { // from class: com.byazt.ea.c.1.11
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.hd.hw(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw(Registry.BUCKET_GIF) { // from class: com.byazt.ea.c.1.13
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.gl.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("VideoPlaceholder") { // from class: com.byazt.ea.c.1.14
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.he.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("Lottie") { // from class: com.byazt.ea.c.1.15
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.qs.hw(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("InterLottie") { // from class: com.byazt.ea.c.1.16
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.qs.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("InteractionWebView") { // from class: com.byazt.ea.c.1.17
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new m(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("WebView") { // from class: com.byazt.ea.c.1.18
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.mw.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("Blur") { // from class: com.byazt.ea.c.1.19
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.uu.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("Swiper") { // from class: com.byazt.ea.c.1.20
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.llk.x(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("SwiperView") { // from class: com.byazt.ea.c.1.21
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.llk.hn(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("FVCountdown") { // from class: com.byazt.ea.c.1.22
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.jd.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("RVCountdown") { // from class: com.byazt.ea.c.1.24
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.jd.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("CycleCountDownView") { // from class: com.byazt.ea.c.1.25
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.jd.hw(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("CycleSkip") { // from class: com.byazt.ea.c.1.26
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.yw.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("RewardClickCountdown") { // from class: com.byazt.ea.c.1.27
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.jd.x(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("Icon") { // from class: com.byazt.ea.c.1.28
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.ll.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("FVSkip") { // from class: com.byazt.ea.c.1.29
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.yw.hw(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("RVSkip") { // from class: com.byazt.ea.c.1.30
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.yw.hw(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("VideoV3") { // from class: com.byazt.ea.c.1.31
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.he.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("PlayableComponent") { // from class: com.byazt.ea.c.1.32
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.ajv.pr(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("CsjRefreshTip") { // from class: com.byazt.ea.c.1.33
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.jd.hn(context);
                    }
                });
                arrayList.add(new com.byazt.ch.hw("BrokenImage") { // from class: com.byazt.ea.c.1.35
                    @Override // com.byazt.ch.hw
                    public com.byazt.ik.hn pr(Context context) {
                        return new com.byazt.ny.pr(context);
                    }
                });
                return arrayList;
            }
        }, new x());
        com.byazt.llk.uc.pr().pr(new com.byazt.dd.aj() { // from class: com.byazt.ea.c.2
            @Override // com.byazt.dd.aj
            public List<com.byazt.dd.zo> pr() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.byazt.dd.zo("shake") { // from class: com.byazt.ea.c.2.1
                    @Override // com.byazt.dd.zo
                    public com.byazt.xv.hw pr(Context context) {
                        return new com.byazt.nk.c(context);
                    }
                });
                arrayList.add(new com.byazt.dd.zo("twist") { // from class: com.byazt.ea.c.2.2
                    @Override // com.byazt.dd.zo
                    public com.byazt.xv.hw pr(Context context) {
                        return new com.byazt.nk.uc(context);
                    }
                });
                arrayList.add(new com.byazt.dd.zo("videoProgress") { // from class: com.byazt.ea.c.2.3
                    @Override // com.byazt.dd.zo
                    public com.byazt.xv.hw pr(Context context) {
                        return new com.byazt.nk.fw(context);
                    }
                });
                arrayList.add(new com.byazt.dd.zo("eraseState") { // from class: com.byazt.ea.c.2.4
                    @Override // com.byazt.dd.zo
                    public com.byazt.xv.hw pr(Context context) {
                        return new com.byazt.nk.hn(context);
                    }
                });
                arrayList.add(new com.byazt.dd.zo("Lottie://state") { // from class: com.byazt.ea.c.2.5
                    @Override // com.byazt.dd.zo
                    public com.byazt.xv.hw pr(Context context) {
                        return new com.byazt.nk.x(context);
                    }
                });
                arrayList.add(new com.byazt.dd.zo("longTap") { // from class: com.byazt.ea.c.2.6
                    @Override // com.byazt.dd.zo
                    public com.byazt.xv.hw pr(Context context) {
                        return new uc(context);
                    }
                });
                return arrayList;
            }
        });
        com.byazt.llk.uc.pr().pr(new com.byazt.tit.c());
        com.byazt.llk.uc.pr().pr(new com.byazt.qi.x() { // from class: com.byazt.ea.c.3
            @Override // com.byazt.qi.x
            public com.byazt.qi.x.pr pr(Context context, com.byazt.ik.hn hnVar) {
                return new fw(context, hnVar);
            }
        });
        com.byazt.llk.uc.pr().pr(new com.byazt.ef.pr() { // from class: com.byazt.ea.c.4
            @Override // com.byazt.ef.pr
            public com.byazt.ef.hw pr(lb lbVar) {
                return new vk(lbVar);
            }
        });
        com.byazt.llk.uc.pr().pr(new com.byazt.dd.hn() { // from class: com.byazt.ea.c.5
            @Override // com.byazt.dd.hn
            public List<com.byazt.dd.hw> pr() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.byazt.dd.hw("interactiveFinish") { // from class: com.byazt.ea.c.5.1
                    @Override // com.byazt.dd.hw
                    public com.byazt.tby.pr pr(com.byazt.ik.hn hnVar, String str, com.byazt.dd.fw.pr prVar) {
                        return new com.byazt.tby.hn(hnVar, str, prVar);
                    }
                });
                arrayList.add(new com.byazt.dd.hw("nextVideoCancel") { // from class: com.byazt.ea.c.5.3
                    @Override // com.byazt.dd.hw
                    public com.byazt.tby.pr pr(com.byazt.ik.hn hnVar, String str, com.byazt.dd.fw.pr prVar) {
                        return new com.byazt.tby.hn(hnVar, str, prVar);
                    }
                });
                arrayList.add(new com.byazt.dd.hw("haptic") { // from class: com.byazt.ea.c.5.4
                    @Override // com.byazt.dd.hw
                    public com.byazt.tby.pr pr(com.byazt.ik.hn hnVar, String str, com.byazt.dd.fw.pr prVar) {
                        return new com.byazt.tby.hn(hnVar, str, prVar);
                    }
                });
                arrayList.add(new com.byazt.dd.hw("closeWidget") { // from class: com.byazt.ea.c.5.5
                    @Override // com.byazt.dd.hw
                    public com.byazt.tby.pr pr(com.byazt.ik.hn hnVar, String str, com.byazt.dd.fw.pr prVar) {
                        return new com.byazt.tby.hn(hnVar, str, prVar);
                    }
                });
                arrayList.add(new com.byazt.dd.hw("dismiss") { // from class: com.byazt.ea.c.5.6
                    @Override // com.byazt.dd.hw
                    public com.byazt.tby.pr pr(com.byazt.ik.hn hnVar, String str, com.byazt.dd.fw.pr prVar) {
                        return new com.byazt.tby.hn(hnVar, str, prVar);
                    }
                });
                arrayList.add(new com.byazt.dd.hw("execEffect") { // from class: com.byazt.ea.c.5.7
                    @Override // com.byazt.dd.hw
                    public com.byazt.tby.pr pr(com.byazt.ik.hn hnVar, String str, com.byazt.dd.fw.pr prVar) {
                        return new com.byazt.jj.pr(hnVar, str, prVar);
                    }
                });
                arrayList.add(new com.byazt.dd.hw("openNewAdPage") { // from class: com.byazt.ea.c.5.8
                    @Override // com.byazt.dd.hw
                    public com.byazt.tby.pr pr(com.byazt.ik.hn hnVar, String str, com.byazt.dd.fw.pr prVar) {
                        return new com.byazt.tby.hn(hnVar, str, prVar);
                    }
                });
                arrayList.add(new com.byazt.dd.hw("Lottie://start") { // from class: com.byazt.ea.c.5.9
                    @Override // com.byazt.dd.hw
                    public com.byazt.tby.pr pr(com.byazt.ik.hn hnVar, String str, com.byazt.dd.fw.pr prVar) {
                        return new com.byazt.jj.hw(hnVar, str, prVar);
                    }
                });
                arrayList.add(new com.byazt.dd.hw("renderScene") { // from class: com.byazt.ea.c.5.10
                    @Override // com.byazt.dd.hw
                    public com.byazt.tby.pr pr(com.byazt.ik.hn hnVar, String str, com.byazt.dd.fw.pr prVar) {
                        return new com.byazt.tby.hn(hnVar, str, prVar);
                    }
                });
                arrayList.add(new com.byazt.dd.hw("dismissScene") { // from class: com.byazt.ea.c.5.2
                    @Override // com.byazt.dd.hw
                    public com.byazt.tby.pr pr(com.byazt.ik.hn hnVar, String str, com.byazt.dd.fw.pr prVar) {
                        return new com.byazt.tby.hn(hnVar, str, prVar);
                    }
                });
                return arrayList;
            }
        });
    }
}
