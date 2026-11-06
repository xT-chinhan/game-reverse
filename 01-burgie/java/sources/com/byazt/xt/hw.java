package com.byazt.xt;

import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.ca.g;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.ie;
import com.byazt.hg.of;
import com.byazt.hg.y;
import com.byazt.oc.UpieImageView;
import com.byazt.sd.EmptyView;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 13})
public class hw {
    public FrameLayout aj;
    public final float c;
    public ViewGroup fw;
    public final of hn;
    public final TTBaseVideoActivity hw;
    public TextView k;
    public int m = 3;
    public final String pr;
    public final boolean uc;
    public TextView vk;
    public RelativeLayout w;
    public final int x;
    public RelativeLayout zo;

    public hw(TTBaseVideoActivity tTBaseVideoActivity, of ofVar, boolean z) {
        this.hw = tTBaseVideoActivity;
        this.hn = ofVar;
        this.x = ofVar.rf();
        this.c = ofVar.oq();
        this.uc = z;
        this.pr = z ? "rewarded_video" : "fullscreen_interstitial_ad";
    }

    public void pr() {
        ViewGroup viewGroup = (ViewGroup) this.hw.findViewById(2114387959);
        this.fw = viewGroup;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.byazt.mk.zo.pr(this.fw);
        if (ie.pr(this.hn) != 2) {
            hw();
        }
    }

    private void hw() {
        ViewGroup viewGroup = this.fw;
        if (viewGroup != null) {
            EmptyView emptyViewPr = pr(viewGroup);
            if (emptyViewPr == null) {
                int iOv = 1000;
                of ofVar = this.hn;
                if (ofVar != null) {
                    iOv = ofVar.ov();
                }
                EmptyView emptyView = new EmptyView(this.hw, this.fw, iOv);
                emptyView.pr(this.hn, this.pr);
                this.fw.addView(emptyView);
                emptyViewPr = emptyView;
            }
            emptyViewPr.setNeedCheckingShow(false);
            emptyViewPr.setCallback(new EmptyView.pr() { // from class: com.byazt.xt.hw.1
                @Override // com.byazt.sd.EmptyView.pr
                public void pr(boolean z) {
                }

                @Override // com.byazt.sd.EmptyView.pr
                public void pr() {
                }

                @Override // com.byazt.sd.EmptyView.pr
                public void hw() {
                }

                @Override // com.byazt.sd.EmptyView.pr
                public void pr(View view, Map<String, Object> map) {
                }
            });
        }
    }

    public void pr(com.byazt.az.hw hwVar, com.byazt.az.hw hwVar2) {
    }

    public void pr(DownloadListener downloadListener) {
    }

    public void hw(int i) {
    }

    public void hn(int i) {
    }

    public void x(int i) {
    }

    public void w() {
        if (!this.uc) {
            return;
        }
        int iFs = this.hn.fs();
        this.m = iFs;
        if (iFs == -200) {
            this.m = a.hw().w(new StringBuilder().append(ls.m(this.hn)).toString());
        }
        if (this.m == -1) {
            er.pr((View) this.zo, 0);
        }
    }

    public void c(int i) {
        er.pr((View) this.vk, i);
    }

    public void uc(int i) {
        er.pr((View) this.zo, i);
    }

    public FrameLayout k() {
        return this.aj;
    }

    public RelativeLayout m() {
        return this.zo;
    }

    public String g() {
        return ls.cz(this.hn);
    }

    public String ho() {
        return ls.ny(this.hn);
    }

    public void pr(ImageView imageView, UpieImageView upieImageView) {
        List<y> listDe;
        if (imageView != null && (listDe = this.hn.de()) != null && listDe.size() > 0) {
            com.byazt.ub.hw.pr(listDe.get(0)).pr(imageView);
            if (upieImageView != null && com.byazt.ja.pr.x(this.hn)) {
                com.byazt.ja.pr.pr(imageView, upieImageView);
            }
        }
    }

    public void hn(boolean z) {
        this.hw.e().getWidgetFrameContainer().setVisibility(z ? 0 : 8);
    }

    public void vk() {
    }

    public void nt() {
        of ofVar = this.hn;
        String strJr = ofVar != null ? ofVar.jr() : null;
        if (this.vk != null && TextUtils.isEmpty(strJr)) {
            g.pr(this.hw, "tt_ad_logo_backup", this.vk, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
    }

    private EmptyView pr(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }
}
