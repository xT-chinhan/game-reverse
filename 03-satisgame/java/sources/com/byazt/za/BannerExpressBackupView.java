package com.byazt.za;

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
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.ndr.TTRatingBar;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.wt.UpieImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 1684})
public class BannerExpressBackupView extends BackupView {
    public static um[] oa = {new um(1, 6.4f, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 100), new um(3, 1.2f, 600, 500)};
    public TextView a;
    public um cd;
    public ITTInnerDownloadAdapter cy;
    public int hd;
    public NativeExpressView k;
    public ImageView py;
    public View sz;
    public TextView um;

    public BannerExpressBackupView(Context context) {
        super(context);
        this.hd = 1;
        this.n = context;
    }

    @Override // com.byazt.za.BackupView
    public void n(View view, int i, com.byazt.gct.wm wmVar) {
        if (this.k != null) {
            if (i == 1 || i == 2) {
                View viewFindViewById = this.sz.findViewById(2114387854);
                if (i == 1) {
                    this.k.getClickListener().qg(viewFindViewById);
                } else {
                    this.k.getClickCreativeListener().qg(viewFindViewById);
                }
            }
            this.k.n(view, i, wmVar, -1);
        }
    }

    public void n(pk pkVar, NativeExpressView nativeExpressView, ITTInnerDownloadAdapter iTTInnerDownloadAdapter) {
        setBackgroundColor(-1);
        this.qg = pkVar;
        this.k = nativeExpressView;
        this.cy = iTTInnerDownloadAdapter;
        this.l = com.byazt.wg.qg.AD_TAG_BANNER;
        this.k.addView(this, new ViewGroup.LayoutParams(-2, -2));
        this.fs = com.byazt.vgx.w.cy(this.qg);
        qg(this.fs);
        n();
        s(com.byazt.vyf.s.cy().dh());
    }

    private void n() {
        this.cd = n(this.k.getExpectExpressWidth(), this.k.getExpectExpressHeight());
        if (this.k.getExpectExpressWidth() > 0 && this.k.getExpectExpressHeight() > 0) {
            this.w = com.byazt.okk.s.s(this.n, this.k.getExpectExpressWidth());
            this.x = com.byazt.okk.s.s(this.n, this.k.getExpectExpressHeight());
        } else {
            this.w = com.byazt.okk.s.l(this.n);
            this.x = Float.valueOf(this.w / this.cd.s).intValue();
        }
        if (this.w > 0 && this.w > com.byazt.okk.s.l(this.n)) {
            float fL = com.byazt.okk.s.l(this.n) / this.w;
            this.w = com.byazt.okk.s.l(this.n);
            this.x = Float.valueOf(this.x * fL).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.w, this.x);
        }
        layoutParams.width = this.w;
        layoutParams.height = this.x;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        if (this.cd.n != 1 && this.cd.n == 3) {
            n(this.cd);
        } else {
            qg();
        }
    }

    private void n(ImageView imageView) {
        com.byazt.imu.s.n(this.qg.jo().get(0)).n(imageView);
        if (com.byazt.aci.n.q(this.qg)) {
            UpieImageView upieImageView = new UpieImageView(imageView.getContext(), com.byazt.aci.n.tj(this.qg), com.byazt.du.n.n(this.qg), com.byazt.aci.n.d(this.qg));
            upieImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            com.byazt.aci.n.n(imageView, upieImageView);
        }
    }

    private void n(um umVar) {
        View viewN;
        float fS = (this.x * 1.0f) / com.byazt.okk.s.s(this.n, 250.0f);
        View viewPk = com.byazt.cb.qg.pk(this.n);
        this.sz = viewPk;
        addView(viewPk);
        FrameLayout frameLayout = (FrameLayout) this.sz.findViewById(2114387772);
        this.py = (ImageView) this.sz.findViewById(2114387854);
        ImageView imageView = (ImageView) this.sz.findViewById(2114387936);
        ImageView imageView2 = (ImageView) this.sz.findViewById(2114387931);
        this.um = (TextView) this.sz.findViewById(2114387940);
        this.a = (TextView) this.sz.findViewById(2114387920);
        TextView textView = (TextView) this.sz.findViewById(2114387927);
        TextView textView2 = (TextView) this.sz.findViewById(2114387633);
        com.byazt.okk.s.n((TextView) this.sz.findViewById(2114387658), this.qg);
        LinearLayout linearLayout = (LinearLayout) this.sz.findViewById(2114387871);
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (com.byazt.okk.s.s(this.n, 45.0f) * fS);
            layoutParams.height = (int) (com.byazt.okk.s.s(this.n, 45.0f) * fS);
        }
        this.um.setTextSize(2, com.byazt.okk.s.qg(this.n, this.um.getTextSize()) * fS);
        this.a.setTextSize(2, com.byazt.okk.s.qg(this.n, this.a.getTextSize()) * fS);
        textView.setTextSize(2, com.byazt.okk.s.qg(this.n, textView.getTextSize()) * fS);
        textView2.setTextSize(2, com.byazt.okk.s.qg(this.n, textView2.getTextSize()) * fS);
        try {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            float f = fS - 1.0f;
            if (f > 0.0f) {
                layoutParams2.topMargin = com.byazt.okk.s.s(this.n, f * 8.0f);
            }
            ((RelativeLayout.LayoutParams) textView2.getLayoutParams()).setMargins(0, (int) (com.byazt.okk.s.s(this.n, 16.0f) * fS), 0, 0);
        } catch (Throwable unused) {
        }
        this.py.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.za.BannerExpressBackupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.l();
            }
        });
        int iS = com.byazt.okk.s.s(this.n, 15.0f);
        com.byazt.okk.s.n(this.py, iS, iS, iS, iS);
        if (ta.k(this.qg) != null && (viewN = n(this.k)) != null) {
            int i = (this.w * 406) / 600;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i, (i * 9) / 16);
            if (umVar.qg == 1) {
                int i2 = (this.w * 406) / 600;
                layoutParams3 = new FrameLayout.LayoutParams(i2, (i2 * 9) / 16);
            } else if (umVar.qg == 2) {
                layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            } else if (umVar.qg == 3) {
                int i3 = (this.x * MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION) / MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME;
                layoutParams3 = new FrameLayout.LayoutParams((i3 * 16) / 9, i3);
            } else if (umVar.qg == 4) {
                int i4 = (this.w * 480) / 690;
                layoutParams3 = new FrameLayout.LayoutParams(i4, (i4 * 9) / 16);
            }
            layoutParams3.gravity = 17;
            frameLayout.addView(viewN, 0, layoutParams3);
            com.byazt.okk.s.n((View) imageView, 8);
        } else {
            n(imageView);
            com.byazt.okk.s.n((View) imageView, 0);
        }
        com.byazt.imu.s.n(this.qg.xu()).n(imageView2);
        textView.setText(getNameOrSource());
        this.um.setText(String.format(Locale.getDefault(), "%s提供的广告", getNameOrSource()));
        this.a.setText(getDescription());
        if (!TextUtils.isEmpty(this.qg.jb())) {
            textView2.setText(this.qg.jb());
        }
        n((View) this, true);
        n((View) textView2, true);
        n(frameLayout);
    }

    private void qg() {
        float fS = (this.x * 1.0f) / com.byazt.okk.s.s(this.n, 50.0f);
        if ((this.x * 1.0f) / this.w > 0.21875f) {
            fS = (this.w * 1.0f) / com.byazt.okk.s.s(this.n, 320.0f);
        }
        View viewU = com.byazt.cb.qg.u(this.n);
        this.sz = viewU;
        addView(viewU);
        this.py = (ImageView) this.sz.findViewById(2114387854);
        ImageView imageView = (ImageView) this.sz.findViewById(2114387931);
        this.um = (TextView) this.sz.findViewById(2114387940);
        TextView textView = (TextView) this.sz.findViewById(2114387794);
        TTRatingBar tTRatingBar = (TTRatingBar) this.sz.findViewById(2114387891);
        TextView textView2 = (TextView) this.sz.findViewById(2114387633);
        this.um.setTextSize(2, com.byazt.okk.s.qg(this.n, this.um.getTextSize()) * fS);
        textView.setTextSize(2, com.byazt.okk.s.qg(this.n, textView.getTextSize()) * fS);
        textView2.setTextSize(2, com.byazt.okk.s.qg(this.n, textView2.getTextSize()) * fS);
        TextView textView3 = (TextView) this.sz.findViewById(2114387658);
        this.py.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.za.BannerExpressBackupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.l();
            }
        });
        com.byazt.okk.s.n(textView3, this.qg, 27, 11);
        com.byazt.imu.s.n(this.qg.xu()).n(imageView);
        this.um.setText(getTitle());
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (com.byazt.okk.s.s(this.n, 45.0f) * fS);
            layoutParams.height = (int) (com.byazt.okk.s.s(this.n, 45.0f) * fS);
        }
        if (!TextUtils.isEmpty(this.qg.jb())) {
            textView2.setText(this.qg.jb());
        }
        int iL = this.qg.k() != null ? this.qg.k().l() : 4;
        textView.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(iL)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(iL);
        tTRatingBar.setStarImageWidth(com.byazt.okk.s.s(this.n, 15.0f) * fS);
        tTRatingBar.setStarImageHeight(com.byazt.okk.s.s(this.n, 14.0f) * fS);
        tTRatingBar.setStarImagePadding(com.byazt.okk.s.s(this.n, 4.0f));
        tTRatingBar.n();
        n((View) this, true);
        n((View) textView2, true);
    }

    private um n(int i, int i2) {
        try {
            return ((double) i2) >= Math.floor((((double) i) * 300.0d) / 600.0d) ? oa[1] : oa[0];
        } catch (Throwable unused) {
            return oa[0];
        }
    }

    private void s(int i) {
        if (i == 1) {
            q();
            this.sz.setBackgroundColor(0);
        } else {
            s();
            this.sz.setBackgroundColor(-1);
        }
    }

    private void s() {
        if (this.cd.n == 2 || this.cd.n == 3) {
            TextView textView = this.um;
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#FFAEAEAE"));
            }
            TextView textView2 = this.a;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor("#3E3E3E"));
            }
            if (this.py != null) {
                this.py.setImageDrawable(com.byazt.cb.qg.wo(this.n));
                return;
            }
            return;
        }
        TextView textView3 = this.um;
        if (textView3 != null) {
            textView3.setTextColor(Color.parseColor("#FF333333"));
        }
        if (this.py != null) {
            com.byazt.tk.sz.n(getContext(), "tt_dislike_icon", this.py, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
    }

    private void q() {
        if (this.cd.n == 2 || this.cd.n == 3) {
            TextView textView = this.um;
            if (textView != null) {
                textView.setTextColor(-1);
            }
            TextView textView2 = this.a;
            if (textView2 != null) {
                textView2.setTextColor(-1);
            }
        } else {
            TextView textView3 = this.um;
            if (textView3 != null) {
                textView3.setTextColor(-1);
            }
        }
        if (this.py != null) {
            com.byazt.tk.sz.n(getContext(), "tt_dislike_icon_night", this.py, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
    }

    @Override // com.byazt.za.BackupView, com.byazt.hne.n
    public void b_(int i) {
        super.b_(i);
        s(i);
    }
}
