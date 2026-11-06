package com.byazt.za;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_COLOR_TRC})
public class BannerExpressVideoView extends q {
    @Override // com.byazt.za.q
    public /* bridge */ /* synthetic */ NativeExpressView getCurView() {
        return super.getCurView();
    }

    @Override // com.byazt.za.q
    public /* bridge */ /* synthetic */ NativeExpressView getNextView() {
        return super.getNextView();
    }

    @Override // com.byazt.za.q
    public /* bridge */ /* synthetic */ void l() {
        super.l();
    }

    @Override // com.byazt.za.q
    public /* bridge */ /* synthetic */ void q() {
        super.q();
    }

    @Override // com.byazt.za.q
    public /* bridge */ /* synthetic */ boolean qg() {
        return super.qg();
    }

    @Override // com.byazt.za.q
    public /* bridge */ /* synthetic */ void s() {
        super.s();
    }

    @Override // com.byazt.za.q
    public /* bridge */ /* synthetic */ void setDuration(int i) {
        super.setDuration(i);
    }

    @Override // com.byazt.za.q
    public /* bridge */ /* synthetic */ void setExpressInteractionListener(n nVar) {
        super.setExpressInteractionListener(nVar);
    }

    @Override // com.byazt.za.q
    public /* bridge */ /* synthetic */ void setVideoAdListener(com.byazt.fx.s sVar) {
        super.setVideoAdListener(sVar);
    }

    public BannerExpressVideoView(Context context, pk pkVar, com.byazt.zq.qg qgVar) {
        super(context, pkVar, qgVar);
    }

    @Override // com.byazt.za.q
    public void n() {
        this.qg = new NativeExpressVideoView(this.n, this.q, this.l, this.tj);
        addView(this.qg, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.byazt.za.q
    public void n(pk pkVar, com.byazt.zq.qg qgVar) {
        this.s = new NativeExpressVideoView(this.n, pkVar, qgVar, this.tj);
        this.s.setExpressInteractionListener(new n() { // from class: com.byazt.za.BannerExpressVideoView.1
            @Override // com.byazt.za.n
            public void n(View view, int i) {
                if (BannerExpressVideoView.this.w != null) {
                    BannerExpressVideoView.this.w.n(BannerExpressVideoView.this, i);
                }
            }

            @Override // com.byazt.za.n
            public void n(View view, float f, float f2) {
                BannerExpressVideoView.this.n(f, f2);
                BannerExpressVideoView.this.w();
            }
        });
        com.byazt.okk.s.n((View) this.s, 8);
        addView(this.s, new ViewGroup.LayoutParams(-1, -1));
    }

    public com.byazt.cs.n getVideoModel() {
        if (this.qg != null) {
            return ((NativeExpressVideoView) this.qg).getVideoModel();
        }
        return null;
    }
}
