package com.byazt.za;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.ia.NativeVideoTsView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 1003})
public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {
    public int n;
    public boolean ou;
    public boolean py;
    public ImageView qg;
    public boolean wm;

    public ExpressVideoView(Context context, pk pkVar, String str, boolean z) {
        super(context, pkVar, false, false, str, false, false);
        this.py = false;
        if ("draw_ad".equals(str)) {
            this.py = true;
        }
        this.ou = z;
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
    }

    @Override // com.byazt.ia.NativeVideoTsView
    public com.byazt.iag.s n(Context context, ViewGroup viewGroup, pk pkVar, String str, boolean z, boolean z2, boolean z3) {
        if (this.ou) {
            return new com.byazt.ia.s(context, viewGroup, pkVar, str, z, z2, z3);
        }
        return super.n(context, viewGroup, pkVar, str, z, z2, z3);
    }

    @Override // com.byazt.ia.NativeVideoTsView
    public void qg() {
        if (this.py) {
            super.qg(this.n);
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.py = z;
    }

    public void setVideoPlayStatus(int i) {
        this.n = i;
    }

    public void setShouldCheckNetChange(boolean z) {
        if (this.l != null) {
            this.l.l(z);
        }
    }

    public void s() {
        if (this.oa != null) {
            com.byazt.okk.s.n((View) this.oa, 8);
        }
    }

    public void q_() {
        if (this.oa != null) {
            com.byazt.okk.s.n((View) this.oa, 0);
        }
    }

    @Override // com.byazt.ia.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        if (this.d != null && this.d.getVisibility() == 0) {
            hu();
        } else {
            super.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.byazt.ia.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.d != null && this.d.getVisibility() == 0) {
            hu();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    private void m() {
        com.byazt.okk.s.n((View) this.tj, 0);
        com.byazt.okk.s.n((View) this.cp, 0);
        com.byazt.okk.s.n((View) this.oa, 8);
    }

    @Override // com.byazt.ia.NativeVideoTsView
    public void n(boolean z) {
        if (this.wm) {
            super.n(z);
        }
    }

    public void qg(boolean z) {
        this.wm = z;
    }

    private void hu() {
        d();
        if (this.tj != null) {
            if (this.tj.getVisibility() == 0) {
                return;
            }
            com.byazt.imu.s.n(ta.qg(this.q)).n(this.cp);
            n(this.cp, ta.qg(this.q));
        }
        m();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.d != null && this.d.getVisibility() == 0) {
            com.byazt.okk.s.l(this.tj);
        }
        qg(this.n);
    }

    public void setShowAdInteractionView(boolean z) {
        com.byazt.iag.qg qgVarCd;
        if (this.l == null || (qgVarCd = this.l.cd()) == null) {
            return;
        }
        qgVarCd.n(z);
    }

    public void l() {
        d();
        com.byazt.okk.s.n((View) this.tj, 0);
    }

    public void w() {
        if (this.d != null) {
            com.byazt.okk.s.n((View) this.d, 8);
        }
    }

    public boolean x() {
        return (this.l == null || this.l.hd() == null || !this.l.hd().tj()) ? false : true;
    }

    public void setPauseIcon(boolean z) {
        if (this.qg == null) {
            this.qg = new ImageView(getContext());
            if (com.byazt.vyf.s.cy().dg() != null) {
                this.qg.setImageBitmap(com.byazt.vyf.s.cy().dg());
            } else {
                com.byazt.tk.sz.n(com.byazt.nf.rv.getContext(), "tt_new_play_video", this.qg, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
            this.qg.setScaleType(ImageView.ScaleType.FIT_XY);
            int iS = com.byazt.okk.s.s(getContext(), this.cy);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iS, iS);
            layoutParams.gravity = 17;
            this.w.addView(this.qg, layoutParams);
        }
        if (z) {
            this.qg.setVisibility(0);
        } else {
            this.qg.setVisibility(8);
        }
    }

    public com.byazt.iag.s getVideoController() {
        return this.l;
    }
}
