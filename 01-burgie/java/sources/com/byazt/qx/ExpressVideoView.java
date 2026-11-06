package com.byazt.qx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.gz.NativeVideoTsView;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 1332})
public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {
    public boolean cz;
    public boolean fo;
    public ImageView hw;
    public boolean ny;
    public int pr;

    public ExpressVideoView(Context context, of ofVar, String str, boolean z) {
        super(context, ofVar, false, false, str, false, false);
        this.cz = false;
        if ("draw_ad".equals(str)) {
            this.cz = true;
        }
        this.ny = z;
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
    }

    @Override // com.byazt.gz.NativeVideoTsView
    public com.byazt.w.hn pr(Context context, ViewGroup viewGroup, of ofVar, String str, boolean z, boolean z2, boolean z3) {
        if (this.ny) {
            return new com.byazt.gz.hn(context, viewGroup, ofVar, str, z, z2, z3);
        }
        return super.pr(context, viewGroup, ofVar, str, z, z2, z3);
    }

    @Override // com.byazt.gz.NativeVideoTsView
    public void hw() {
        if (this.cz) {
            super.hw(this.pr);
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.cz = z;
    }

    public void setVideoPlayStatus(int i) {
        this.pr = i;
    }

    public void setShouldCheckNetChange(boolean z) {
        if (this.c != null) {
            this.c.c(z);
        }
    }

    public void hn() {
        if (this.m != null) {
            er.pr((View) this.m, 8);
        }
    }

    public void J_() {
        if (this.m != null) {
            er.pr((View) this.m, 0);
        }
    }

    @Override // com.byazt.gz.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        if (this.k != null && this.k.getVisibility() == 0) {
            cz();
        } else {
            super.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.byazt.gz.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.k != null && this.k.getVisibility() == 0) {
            cz();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    private void zo() {
        er.pr((View) this.vk, 0);
        er.pr((View) this.w, 0);
        er.pr((View) this.m, 8);
    }

    @Override // com.byazt.gz.NativeVideoTsView
    public void pr(boolean z) {
        if (this.fo) {
            super.pr(z);
        }
    }

    public void hw(boolean z) {
        this.fo = z;
    }

    private void cz() {
        k();
        if (this.vk != null) {
            if (this.vk.getVisibility() == 0) {
                return;
            }
            com.byazt.ub.hw.pr(qv.hw(this.x)).pr(this.w);
            pr(this.w, qv.hw(this.x));
        }
        zo();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.k != null && this.k.getVisibility() == 0) {
            er.c(this.vk);
        }
        hw(this.pr);
    }

    public void setShowAdInteractionView(boolean z) {
        com.byazt.w.hw hwVarLb;
        if (this.c != null && (hwVarLb = this.c.lb()) != null) {
            hwVarLb.pr(z);
        }
    }

    public void K_() {
        k();
        er.pr((View) this.vk, 0);
    }

    public void uc() {
        if (this.k != null) {
            er.pr((View) this.k, 8);
        }
    }

    public boolean L_() {
        return (this.c == null || this.c.yb() == null || !this.c.yb().vk()) ? false : true;
    }

    public void setPauseIcon(boolean z) {
        if (this.hw == null) {
            this.hw = new ImageView(getContext());
            if (com.byazt.sd.zo.nt().qi() != null) {
                this.hw.setImageBitmap(com.byazt.sd.zo.nt().qi());
            } else {
                com.byazt.ca.g.pr(com.byazt.sd.a.getContext(), "tt_new_play_video", this.hw, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
            this.hw.setScaleType(ImageView.ScaleType.FIT_XY);
            int iHn = er.hn(getContext(), this.nt);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iHn, iHn);
            layoutParams.gravity = 17;
            this.uc.addView(this.hw, layoutParams);
        }
        if (z) {
            this.hw.setVisibility(0);
        } else {
            this.hw.setVisibility(8);
        }
    }

    public com.byazt.w.hn getVideoController() {
        return this.c;
    }
}
