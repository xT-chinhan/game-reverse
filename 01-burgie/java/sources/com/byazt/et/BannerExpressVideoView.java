package com.byazt.et;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.hg.of;
import com.byazt.qx.NativeExpressVideoView;
import com.byazt.qx.NativeExpressView;
import com.byazt.wt.er;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 51, 1755})
public class BannerExpressVideoView extends pr {
    @Override // com.byazt.et.pr
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.byazt.et.pr
    public /* bridge */ /* synthetic */ NativeExpressView getCurView() {
        return super.getCurView();
    }

    @Override // com.byazt.et.pr
    public /* bridge */ /* synthetic */ NativeExpressView getNextView() {
        return super.getNextView();
    }

    @Override // com.byazt.et.pr
    public /* bridge */ /* synthetic */ void hn() {
        super.hn();
    }

    @Override // com.byazt.et.pr
    public /* bridge */ /* synthetic */ boolean hw() {
        return super.hw();
    }

    @Override // com.byazt.et.pr
    public /* bridge */ /* synthetic */ void setDuration(int i) {
        super.setDuration(i);
    }

    @Override // com.byazt.et.pr
    public /* bridge */ /* synthetic */ void setExpressInteractionListener(com.byazt.qx.pr prVar) {
        super.setExpressInteractionListener(prVar);
    }

    @Override // com.byazt.et.pr
    public /* bridge */ /* synthetic */ void setVideoAdListener(com.byazt.qh.hn hnVar) {
        super.setVideoAdListener(hnVar);
    }

    @Override // com.byazt.et.pr
    public /* bridge */ /* synthetic */ void x() {
        super.x();
    }

    public BannerExpressVideoView(Context context, of ofVar, com.byazt.qe.hw hwVar) {
        super(context, ofVar, hwVar);
    }

    @Override // com.byazt.et.pr
    public void pr() {
        this.hw = new NativeExpressVideoView(this.pr, this.x, this.c, this.vk);
        addView(this.hw, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.byazt.et.pr
    public void pr(of ofVar, com.byazt.qe.hw hwVar) {
        this.hn = new NativeExpressVideoView(this.pr, ofVar, hwVar, this.vk);
        this.hn.setExpressInteractionListener(new com.byazt.qx.pr() { // from class: com.byazt.et.BannerExpressVideoView.1
            @Override // com.byazt.qx.pr
            public void pr(View view, int i) {
                if (BannerExpressVideoView.this.uc != null) {
                    BannerExpressVideoView.this.uc.pr(BannerExpressVideoView.this, i);
                }
            }

            @Override // com.byazt.qx.pr
            public void pr(View view, float f, float f2) {
                BannerExpressVideoView.this.pr(f, f2);
                BannerExpressVideoView.this.uc();
            }
        });
        er.pr((View) this.hn, 8);
        addView(this.hn, new ViewGroup.LayoutParams(-1, -1));
    }

    public com.byazt.mm.pr getVideoModel() {
        if (this.hw != null) {
            return ((NativeExpressVideoView) this.hw).getVideoModel();
        }
        return null;
    }
}
