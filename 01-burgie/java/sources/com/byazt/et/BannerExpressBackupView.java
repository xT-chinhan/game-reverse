package com.byazt.et;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.ca.g;
import com.byazt.hg.fo;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.oc.UpieImageView;
import com.byazt.pi.TTRatingBar;
import com.byazt.qx.BackupView;
import com.byazt.qx.NativeExpressView;
import com.byazt.qx.lb;
import com.byazt.sd.zo;
import com.byazt.sdv.c;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 51, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSION_TIME_MS})
public class BannerExpressBackupView extends BackupView {
    public static lb[] m = {new lb(1, 6.4f, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 100), new lb(3, 1.2f, 600, 500)};
    public TextView a;
    public ImageView cz;
    public View g;
    public NativeExpressView ho;
    public lb lb;
    public com.byazt.nv.hn nt;
    public TextView qa;
    public int yb;

    public BannerExpressBackupView(Context context) {
        super(context);
        this.yb = 1;
        this.pr = context;
    }

    @Override // com.byazt.qx.BackupView
    public void pr(View view, int i, fo foVar) {
        if (this.ho != null) {
            if (i == 1 || i == 2) {
                View viewFindViewById = this.g.findViewById(2114387854);
                if (i == 1) {
                    this.ho.getClickListener().hw(viewFindViewById);
                } else {
                    this.ho.getClickCreativeListener().hw(viewFindViewById);
                }
            }
            this.ho.pr(view, i, foVar, -1);
        }
    }

    public void pr(of ofVar, NativeExpressView nativeExpressView, com.byazt.nv.hn hnVar) {
        setBackgroundColor(-1);
        this.hw = ofVar;
        this.ho = nativeExpressView;
        this.nt = hnVar;
        this.c = com.byazt.pfl.hw.AD_TAG_BANNER;
        this.ho.addView(this, new ViewGroup.LayoutParams(-2, -2));
        this.zo = ls.m(this.hw);
        hw(this.zo);
        pr();
        hn(zo.nt().nw());
    }

    private void pr() {
        this.lb = pr(this.ho.getExpectExpressWidth(), this.ho.getExpectExpressHeight());
        if (this.ho.getExpectExpressWidth() > 0 && this.ho.getExpectExpressHeight() > 0) {
            this.uc = er.hn(this.pr, this.ho.getExpectExpressWidth());
            this.fw = er.hn(this.pr, this.ho.getExpectExpressHeight());
        } else {
            this.uc = er.c(this.pr);
            this.fw = Float.valueOf(this.uc / this.lb.hn).intValue();
        }
        if (this.uc > 0 && this.uc > er.c(this.pr)) {
            float fC = er.c(this.pr) / this.uc;
            this.uc = er.c(this.pr);
            this.fw = Float.valueOf(this.fw * fC).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.uc, this.fw);
        }
        layoutParams.width = this.uc;
        layoutParams.height = this.fw;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        if (this.lb.pr != 1 && this.lb.pr == 3) {
            pr(this.lb);
        } else {
            hw();
        }
    }

    private void pr(ImageView imageView) {
        com.byazt.ub.hw.pr(this.hw.de().get(0)).pr(imageView);
        if (com.byazt.ja.pr.x(this.hw)) {
            UpieImageView upieImageView = new UpieImageView(imageView.getContext(), com.byazt.ja.pr.vk(this.hw), com.byazt.vr.pr.pr(this.hw), com.byazt.ja.pr.w(this.hw));
            upieImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            com.byazt.ja.pr.pr(imageView, upieImageView);
        }
    }

    private void pr(lb lbVar) {
        View viewPr;
        float fHn = (this.fw * 1.0f) / er.hn(this.pr, 250.0f);
        View viewIi = c.ii(this.pr);
        this.g = viewIi;
        addView(viewIi);
        FrameLayout frameLayout = (FrameLayout) this.g.findViewById(2114387772);
        this.cz = (ImageView) this.g.findViewById(2114387854);
        ImageView imageView = (ImageView) this.g.findViewById(2114387936);
        ImageView imageView2 = (ImageView) this.g.findViewById(2114387931);
        this.qa = (TextView) this.g.findViewById(2114387940);
        this.a = (TextView) this.g.findViewById(2114387920);
        TextView textView = (TextView) this.g.findViewById(2114387927);
        TextView textView2 = (TextView) this.g.findViewById(2114387633);
        er.pr((TextView) this.g.findViewById(2114387658), this.hw);
        LinearLayout linearLayout = (LinearLayout) this.g.findViewById(2114387871);
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (er.hn(this.pr, 45.0f) * fHn);
            layoutParams.height = (int) (er.hn(this.pr, 45.0f) * fHn);
        }
        this.qa.setTextSize(2, er.hw(this.pr, this.qa.getTextSize()) * fHn);
        this.a.setTextSize(2, er.hw(this.pr, this.a.getTextSize()) * fHn);
        textView.setTextSize(2, er.hw(this.pr, textView.getTextSize()) * fHn);
        textView2.setTextSize(2, er.hw(this.pr, textView2.getTextSize()) * fHn);
        try {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            float f = fHn - 1.0f;
            if (f > 0.0f) {
                layoutParams2.topMargin = er.hn(this.pr, f * 8.0f);
            }
            ((RelativeLayout.LayoutParams) textView2.getLayoutParams()).setMargins(0, (int) (er.hn(this.pr, 16.0f) * fHn), 0, 0);
        } catch (Throwable th) {
        }
        this.cz.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.et.BannerExpressBackupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.c();
            }
        });
        int iHn = er.hn(this.pr, 15.0f);
        er.pr(this.cz, iHn, iHn, iHn, iHn);
        if (qv.ho(this.hw) != null && (viewPr = pr(this.ho)) != null) {
            int i = (this.uc * 406) / 600;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i, (i * 9) / 16);
            if (lbVar.hw == 1) {
                int i2 = (this.uc * 406) / 600;
                layoutParams3 = new FrameLayout.LayoutParams(i2, (i2 * 9) / 16);
            } else if (lbVar.hw == 2) {
                layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            } else if (lbVar.hw == 3) {
                int i3 = (this.fw * MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION) / MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME;
                layoutParams3 = new FrameLayout.LayoutParams((i3 * 16) / 9, i3);
            } else if (lbVar.hw == 4) {
                int i4 = (this.uc * 480) / 690;
                layoutParams3 = new FrameLayout.LayoutParams(i4, (i4 * 9) / 16);
            }
            layoutParams3.gravity = 17;
            frameLayout.addView(viewPr, 0, layoutParams3);
            er.pr((View) imageView, 8);
        } else {
            pr(imageView);
            er.pr((View) imageView, 0);
        }
        com.byazt.ub.hw.pr(this.hw.mo()).pr(imageView2);
        textView.setText(getNameOrSource());
        this.qa.setText(String.format(Locale.getDefault(), "%s提供的广告", getNameOrSource()));
        this.a.setText(getDescription());
        if (!TextUtils.isEmpty(this.hw.se())) {
            textView2.setText(this.hw.se());
        }
        pr((View) this, true);
        pr((View) textView2, true);
        pr(frameLayout);
    }

    private void hw() {
        float fHn = (this.fw * 1.0f) / er.hn(this.pr, 50.0f);
        if ((this.fw * 1.0f) / this.uc > 0.21875f) {
            fHn = (this.uc * 1.0f) / er.hn(this.pr, 320.0f);
        }
        View viewOf = c.of(this.pr);
        this.g = viewOf;
        addView(viewOf);
        this.cz = (ImageView) this.g.findViewById(2114387854);
        ImageView imageView = (ImageView) this.g.findViewById(2114387931);
        this.qa = (TextView) this.g.findViewById(2114387940);
        TextView textView = (TextView) this.g.findViewById(2114387794);
        TTRatingBar tTRatingBar = (TTRatingBar) this.g.findViewById(2114387891);
        TextView textView2 = (TextView) this.g.findViewById(2114387633);
        this.qa.setTextSize(2, er.hw(this.pr, this.qa.getTextSize()) * fHn);
        textView.setTextSize(2, er.hw(this.pr, textView.getTextSize()) * fHn);
        textView2.setTextSize(2, er.hw(this.pr, textView2.getTextSize()) * fHn);
        TextView textView3 = (TextView) this.g.findViewById(2114387658);
        this.cz.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.et.BannerExpressBackupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.c();
            }
        });
        er.pr(textView3, this.hw, 27, 11);
        com.byazt.ub.hw.pr(this.hw.mo()).pr(imageView);
        this.qa.setText(getTitle());
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (er.hn(this.pr, 45.0f) * fHn);
            layoutParams.height = (int) (er.hn(this.pr, 45.0f) * fHn);
        }
        if (!TextUtils.isEmpty(this.hw.se())) {
            textView2.setText(this.hw.se());
        }
        int iC = this.hw.ho() != null ? this.hw.ho().c() : 4;
        textView.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(iC)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(iC);
        tTRatingBar.setStarImageWidth(er.hn(this.pr, 15.0f) * fHn);
        tTRatingBar.setStarImageHeight(er.hn(this.pr, 14.0f) * fHn);
        tTRatingBar.setStarImagePadding(er.hn(this.pr, 4.0f));
        tTRatingBar.pr();
        pr((View) this, true);
        pr((View) textView2, true);
    }

    private lb pr(int i, int i2) {
        try {
            lb lbVar = m[0];
            if (i2 >= Math.floor((((double) i) * 300.0d) / 600.0d)) {
                return m[1];
            }
            return lbVar;
        } catch (Throwable th) {
            return m[0];
        }
    }

    private void hn(int i) {
        if (i == 1) {
            x();
            this.g.setBackgroundColor(0);
        } else {
            hn();
            this.g.setBackgroundColor(-1);
        }
    }

    private void hn() {
        if (this.lb.pr == 2 || this.lb.pr == 3) {
            TextView textView = this.qa;
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#FFAEAEAE"));
            }
            TextView textView2 = this.a;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor("#3E3E3E"));
            }
            if (this.cz != null) {
                this.cz.setImageDrawable(c.i(this.pr));
                return;
            }
            return;
        }
        TextView textView3 = this.qa;
        if (textView3 != null) {
            textView3.setTextColor(Color.parseColor("#FF333333"));
        }
        if (this.cz != null) {
            g.pr(getContext(), "tt_dislike_icon", this.cz, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
    }

    private void x() {
        if (this.lb.pr == 2 || this.lb.pr == 3) {
            TextView textView = this.qa;
            if (textView != null) {
                textView.setTextColor(-1);
            }
            TextView textView2 = this.a;
            if (textView2 != null) {
                textView2.setTextColor(-1);
            }
        } else {
            TextView textView3 = this.qa;
            if (textView3 != null) {
                textView3.setTextColor(-1);
            }
        }
        if (this.cz != null) {
            g.pr(getContext(), "tt_dislike_icon_night", this.cz, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
    }

    @Override // com.byazt.qx.BackupView, com.byazt.mo.pr
    public void b_(int i) {
        super.b_(i);
        hn(i);
    }
}
