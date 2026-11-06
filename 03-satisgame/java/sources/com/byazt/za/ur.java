package com.byazt.za;

import android.content.Context;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 1088})
public class ur extends h {
    public ur(Context context, pk pkVar, com.byazt.zq.qg qgVar, int i) {
        super(context, pkVar, qgVar, i);
    }

    @Override // com.byazt.za.h
    public void n(Context context, pk pkVar, com.byazt.zq.qg qgVar) {
        this.s = new NativeExpressVideoView(context, pkVar, qgVar, com.byazt.wg.qg.AD_TAG_FEED);
        n(this.s, this.l);
    }

    @Override // com.byazt.za.qg, com.byazt.fvm.sz
    public void n(final com.byazt.fx.s sVar) {
        if (this.s != null) {
            this.s.setVideoAdListener(new com.byazt.iag.s.q() { // from class: com.byazt.za.ur.1
                @Override // com.byazt.iag.s.q
                public void w_() {
                    com.byazt.fx.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.n();
                    }
                }

                @Override // com.byazt.iag.s.q
                public void a_(int i, int i2) {
                    com.byazt.fx.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.n(i, i2);
                    }
                }
            });
            this.s.setVideoAdInteractionListener(new com.byazt.iag.s.InterfaceC0200s() { // from class: com.byazt.za.ur.2
                @Override // com.byazt.iag.s.InterfaceC0200s
                public void s_() {
                    com.byazt.fx.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.qg();
                    }
                }

                @Override // com.byazt.iag.s.InterfaceC0200s
                public void t_() {
                    com.byazt.fx.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.s();
                    }
                }

                @Override // com.byazt.iag.s.InterfaceC0200s
                public void u_() {
                    com.byazt.fx.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.q();
                    }
                }

                @Override // com.byazt.iag.s.InterfaceC0200s
                public void n(long j, long j2) {
                    com.byazt.fx.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.n(j, j2);
                    }
                }

                @Override // com.byazt.iag.s.InterfaceC0200s
                public void v_() {
                    com.byazt.fx.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.l();
                    }
                }
            });
        }
    }

    @Override // com.byazt.za.qg
    public com.byazt.cs.n d() {
        if (this.x != null && this.x.get() != null) {
            return this.x.get().getVideoModel();
        }
        if (!(this.s instanceof NativeExpressVideoView)) {
            return null;
        }
        ((NativeExpressVideoView) this.s).d();
        return ((NativeExpressVideoView) this.s).getVideoModel();
    }
}
