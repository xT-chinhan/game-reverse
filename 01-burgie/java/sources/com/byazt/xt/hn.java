package com.byazt.xt;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.ca.g;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.of;
import com.byazt.hg.y;
import com.byazt.nc.k;
import com.byazt.pi.TTRatingBar;
import com.byazt.pi.TTRoundRectImageView;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 20})
public class hn extends hw {
    public TTRatingBar a;
    public FrameLayout cz;
    public int g;
    public final AtomicBoolean ho;
    public TextView lb;
    public TTRoundRectImageView nt;
    public FrameLayout ny;
    public TextView qa;
    public TextView yb;

    public hn(TTBaseVideoActivity tTBaseVideoActivity, of ofVar, boolean z) {
        super(tTBaseVideoActivity, ofVar, z);
        this.g = 0;
        this.ho = new AtomicBoolean(false);
    }

    @Override // com.byazt.xt.hw
    public void pr() {
        super.pr();
        this.zo = (RelativeLayout) this.hw.findViewById(2114387649);
        this.nt = (TTRoundRectImageView) this.hw.findViewById(2114387793);
        this.yb = (TextView) this.hw.findViewById(2114387875);
        this.lb = (TextView) this.hw.findViewById(2114387630);
        this.qa = (TextView) this.hw.findViewById(2114387830);
        TTRatingBar tTRatingBar = (TTRatingBar) this.hw.findViewById(2114387609);
        this.a = tTRatingBar;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.a.setStarFillNum(4);
            this.a.setStarImageWidth(er.hn(this.hw, 15.0f));
            this.a.setStarImageHeight(er.hn(this.hw, 14.0f));
            this.a.setStarImagePadding(er.hn(this.hw, 4.0f));
            this.a.pr();
        }
        this.vk = (TextView) this.hw.findViewById(2114387658);
        this.aj = (FrameLayout) this.hw.findViewById(2114387642);
        this.cz = (FrameLayout) this.hw.findViewById(2114387964);
        this.ny = (FrameLayout) this.hw.findViewById(2114387925);
        er.pr(this.vk, this.hn);
        try {
            if (this.x == 2 && this.hn.xb() == 1 && (this.qa.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.qa.getLayoutParams();
                layoutParams.height = er.hn(this.hw, 55.0f);
                layoutParams.topMargin = er.hn(this.hw, 20.0f);
                this.qa.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.zo.getLayoutParams();
                layoutParams2.bottomMargin = er.hn(this.hw, 12.0f);
                this.zo.setLayoutParams(layoutParams2);
            }
        } catch (Throwable th) {
        }
        if (this.hn.xb() == 1 && this.aj != null && (this.aj.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.aj.getLayoutParams();
            int iC = er.c((Context) this.hw);
            layoutParams3.width = iC;
            int i = (iC * 9) / 16;
            layoutParams3.height = i;
            this.aj.setLayoutParams(layoutParams3);
            this.g = (er.uc((Context) this.hw) - i) / 2;
        }
        hn();
        x();
        c();
        uc();
        fw();
        w();
    }

    private void hn() {
        if (this.nt != null) {
            y yVarMo = this.hn.mo();
            if (yVarMo != null && !TextUtils.isEmpty(yVarMo.pr())) {
                com.byazt.ub.hw.pr(yVarMo).pr(this.nt);
            } else {
                g.pr((Context) this.hw, "tt_ad_logo_small", (ImageView) this.nt, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
        }
        if (this.yb != null) {
            if (this.x == 1 && this.hn.ho() != null && !TextUtils.isEmpty(this.hn.ho().hn())) {
                this.yb.setText(this.hn.ho().hn());
            } else {
                this.yb.setText(this.hn.A_());
            }
        }
    }

    private void x() {
        if (this.lb == null) {
            return;
        }
        int iUc = 6870;
        if (this.hn.ho() != null) {
            iUc = this.hn.ho().uc();
        }
        this.lb.setText(String.format("%1$s个评分", iUc > 10000 ? (iUc / 10000) + "万" : String.valueOf(iUc)));
    }

    private void c() {
        TextView textView = this.qa;
        if (textView != null) {
            textView.setText(this.hn.xb() == 3 ? zo() : hw());
        }
    }

    private void uc() {
        if (this.x == 1) {
            TextView textView = this.yb;
            if (textView != null) {
                textView.setMaxWidth(er.hn(this.hw, 153.0f));
            }
        } else {
            TextView textView2 = this.yb;
            if (textView2 != null) {
                textView2.setMaxWidth(er.hn(this.hw, 404.0f));
            }
        }
        if (!this.uc) {
            er.pr((View) this.zo, 0);
        }
    }

    private void fw() {
        if (this.hn.xb() == 3) {
            int[] iArr = {Color.parseColor("#0070FF")};
            k.pr((LinearLayout) this.hw.findViewById(2114387898), new k.pr().pr(iArr[0]).hw(Color.parseColor("#80000000")).pr(iArr).hn(er.hn(this.hw, 17.0f)).x(0).c(er.hn(this.hw, 3.0f)));
        }
    }

    public String hw() {
        if (this.hn == null) {
            return "立即下载";
        }
        if (TextUtils.isEmpty(this.hn.se())) {
            return this.hn.aj() != 4 ? "查看详情" : "立即下载";
        }
        return this.hn.se();
    }

    private String zo() {
        boolean z;
        boolean zEquals;
        String strPr = ls.pr(this.hw);
        if (strPr == null) {
            strPr = "";
        }
        try {
            z = strPr.equals(Locale.CHINESE.getLanguage()) || strPr.equals(Locale.CHINA.getLanguage()) || strPr.equals(Locale.TRADITIONAL_CHINESE.getLanguage());
            try {
                zEquals = strPr.equals(Locale.ENGLISH.getLanguage());
            } catch (Throwable th) {
                zEquals = false;
            }
        } catch (Throwable th2) {
            z = true;
        }
        String strSe = "下载";
        if (!z && zEquals) {
            strSe = "Install";
        }
        if (this.hn == null) {
            return strSe;
        }
        if (TextUtils.isEmpty(this.hn.se())) {
            if (this.hn.aj() != 4) {
                if (z) {
                    strSe = "查看";
                } else if (zEquals) {
                    strSe = "View";
                }
            }
        } else {
            strSe = this.hn.se();
            if (strSe != null) {
                if (ls.zo(strSe) && strSe.length() > 2) {
                    if (z) {
                        strSe = pr(true);
                    } else if (zEquals) {
                        strSe = pr(false);
                    }
                } else if (!ls.zo(strSe) && strSe.length() > 7) {
                    if (z) {
                        strSe = pr(true);
                    } else if (zEquals) {
                        strSe = pr(false);
                    }
                }
            }
        }
        if (zEquals && !ls.zo(strSe)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.qa.getLayoutParams();
            layoutParams.bottomMargin = er.hn(this.hw, 4.0f);
            this.qa.setLayoutParams(layoutParams);
        }
        return strSe;
    }

    private String pr(boolean z) {
        if (this.hn == null) {
            return null;
        }
        if (z) {
            return this.hn.aj() == 4 ? "下载" : "查看";
        }
        return this.hn.aj() == 4 ? "Install" : "View";
    }

    @Override // com.byazt.xt.hw
    public void pr(com.byazt.az.hw hwVar, com.byazt.az.hw hwVar2) {
        if (this.hn == null) {
            return;
        }
        er.pr((View) this.qa, (View.OnClickListener) hwVar, (String) null);
        er.pr((View) this.qa, (View.OnTouchListener) hwVar, (String) null);
        pr((View.OnTouchListener) hwVar2);
        pr((View.OnClickListener) hwVar2);
        if (this.hn.xb() == 1) {
            FrameLayout frameLayout = this.cz;
            if (frameLayout != null) {
                er.pr((View) frameLayout, 0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cz.getLayoutParams();
                layoutParams.height = this.g;
                this.cz.setLayoutParams(layoutParams);
            }
            FrameLayout frameLayout2 = this.ny;
            if (frameLayout2 != null) {
                er.pr((View) frameLayout2, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ny.getLayoutParams();
                layoutParams2.height = this.g;
                this.ny.setLayoutParams(layoutParams2);
            }
        }
    }

    private void pr(View.OnTouchListener onTouchListener) {
        er.pr(this.zo, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
        er.pr(this.yb, onTouchListener, "TTBaseVideoActivity#mTvAppName");
        er.pr(this.nt, onTouchListener, "TTBaseVideoActivity#mIvIcon");
        er.pr(this.lb, onTouchListener, "TTBaseVideoActivity#mTvCommentVertical");
        er.pr(this.a, onTouchListener, "TTBaseVideoActivity#mRbScore");
        er.pr(this.aj, onTouchListener, "TTBaseVideoActivity#mVideoNativeFrame");
        er.pr(this.cz, onTouchListener, "TTBaseVideoActivity#mClickUpperNonContentArea");
        er.pr(this.ny, onTouchListener, "TTBaseVideoActivity#mClickLowerNonContentArea");
    }

    private void pr(View.OnClickListener onClickListener) {
        er.pr(this.zo, onClickListener, "TTBaseVideoActivity#mRlDownloadBar");
        er.pr(this.yb, onClickListener, "TTBaseVideoActivity#mTvAppName");
        er.pr(this.nt, onClickListener, "TTBaseVideoActivity#mIvIcon");
        er.pr(this.lb, onClickListener, "TTBaseVideoActivity#mTvCommentVertical");
        er.pr(this.a, onClickListener, "TTBaseVideoActivity#mRbScore");
        er.pr(this.aj, onClickListener, "TTBaseVideoActivity#mVideoNativeFrame");
        er.pr(this.cz, onClickListener, "TTBaseVideoActivity#mClickUpperNonContentArea");
        er.pr(this.ny, onClickListener, "TTBaseVideoActivity#mClickLowerNonContentArea");
    }

    @Override // com.byazt.xt.hw
    public void hw(int i) {
        if (this.zo != null && this.m != -1 && i == this.m && !this.ho.getAndSet(true)) {
            er.pr((View) this.zo, 0);
            Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
            Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
            Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
            Keyframe keyframeOfFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
            Keyframe keyframeOfFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
            Keyframe keyframeOfFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.zo, PropertyValuesHolder.ofKeyframe("scaleX", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6), PropertyValuesHolder.ofKeyframe("scaleY", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6));
            objectAnimatorOfPropertyValuesHolder.setDuration(1000L);
            objectAnimatorOfPropertyValuesHolder.start();
        }
    }
}
