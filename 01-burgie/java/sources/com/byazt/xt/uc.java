package com.byazt.xt;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.of;
import com.byazt.hg.y;
import com.byazt.oc.UpieImageView;
import com.byazt.pi.RatioImageView;
import com.byazt.pi.TTRatingBar;
import com.byazt.pi.TTRoundRectImageView;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 5})
public class uc extends hw {
    public TextView a;
    public UpieImageView cz;
    public RatioImageView g;
    public TTRoundRectImageView ho;
    public TextView lb;
    public TextView nt;
    public TTRatingBar qa;
    public TextView yb;

    public uc(TTBaseVideoActivity tTBaseVideoActivity, of ofVar, boolean z) {
        super(tTBaseVideoActivity, ofVar, z);
    }

    @Override // com.byazt.xt.hw
    public void pr() {
        super.pr();
        this.aj = (FrameLayout) this.fw.findViewById(2114387642);
        this.g = (RatioImageView) this.fw.findViewById(2114387766);
        this.ho = (TTRoundRectImageView) this.fw.findViewById(2114387722);
        this.nt = (TextView) this.fw.findViewById(2114387702);
        this.yb = (TextView) this.fw.findViewById(2114387934);
        this.lb = (TextView) this.fw.findViewById(2114387789);
        this.a = (TextView) this.fw.findViewById(2114387962);
        this.qa = (TTRatingBar) this.fw.findViewById(2114387787);
        if (this.g != null && com.byazt.ja.pr.x(this.hn)) {
            UpieImageView upieImageView = new UpieImageView(this.g.getContext(), com.byazt.ja.pr.vk(this.hn), com.byazt.vr.pr.pr(this.hn), com.byazt.ja.pr.w(this.hn));
            this.cz = upieImageView;
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        hw();
    }

    @Override // com.byazt.xt.hw
    public void pr(com.byazt.az.hw hwVar, com.byazt.az.hw hwVar2) {
        pr(this.a, hwVar, hwVar);
        pr(this.g, hwVar2, hwVar2);
        pr(this.ho, hwVar2, hwVar2);
        pr(this.nt, hwVar2, hwVar2);
        pr(this.yb, hwVar2, hwVar2);
        pr(this.lb, hwVar2, hwVar2);
        pr(this.qa, hwVar2, hwVar2);
        pr(this.cz, hwVar2, hwVar2);
    }

    public void pr(View view, com.byazt.az.hw hwVar, View.OnTouchListener onTouchListener) {
        if (view == null || this.hw == null) {
            return;
        }
        view.setOnTouchListener(onTouchListener);
        view.setOnClickListener(hwVar);
    }

    private void hw() {
        y yVarMo;
        er.pr((TextView) this.hw.findViewById(2114387658), this.hn);
        if (this.g != null) {
            switch (this.hn.jg()) {
                case 3:
                    this.g.setRatio(1.91f);
                    break;
                case 33:
                    this.g.setRatio(1.0f);
                    break;
                default:
                    this.g.setRatio(0.56f);
                    break;
            }
            pr(this.g, this.cz);
        }
        if (this.ho != null && (yVarMo = this.hn.mo()) != null) {
            com.byazt.ub.hw.pr(yVarMo).pr(this.ho);
        }
        TextView textView = this.nt;
        if (textView != null) {
            textView.setText(g());
        }
        TextView textView2 = this.yb;
        if (textView2 != null) {
            textView2.setText(ho());
        }
        hn();
        x();
    }

    private void hn() {
        TTRatingBar tTRatingBar = this.qa;
        if (tTRatingBar == null) {
            return;
        }
        tTRatingBar.setStarEmptyNum(1);
        this.qa.setStarFillNum(4);
        this.qa.setStarImageWidth(er.hn(this.hw, 16.0f));
        this.qa.setStarImageHeight(er.hn(this.hw, 16.0f));
        this.qa.setStarImagePadding(er.hn(this.hw, 4.0f));
        this.qa.pr();
    }

    private void x() {
        if (this.lb == null) {
            return;
        }
        int iUc = 6870;
        if (this.hn.ho() != null) {
            iUc = this.hn.ho().uc();
        }
        this.lb.setText(String.format("(%1$s个评论)", iUc > 10000 ? (iUc / 10000) + "万" : String.valueOf(iUc)));
    }
}
