package com.bytedance.sdk.openadsdk.core.bannerexpress;

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
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.qv;
import com.bytedance.sdk.openadsdk.core.nw.i;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.res.ka;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class BannerExpressBackupView extends BackupView {
    private static qv[] zb = {new qv(1, 6.4f, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 100), new qv(3, 1.2f, 600, 500)};
    private com.bytedance.sdk.openadsdk.core.hi.xr.ah ao;
    private int h;
    private ImageView nw;
    private qv qv;
    private TextView t;
    private View u;
    private NativeExpressView ub;
    private TextView y;

    public BannerExpressBackupView(Context context) {
        super(context);
        this.h = 1;
        this.f2933ms = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void ms(View view, int i, i iVar) {
        if (this.ub != null) {
            if (i == 1 || i == 2) {
                View viewFindViewById = this.u.findViewById(2114387860);
                if (i == 1) {
                    this.ub.getClickListener().xr(viewFindViewById);
                } else {
                    this.ub.getClickCreativeListener().xr(viewFindViewById);
                }
            }
            this.ub.ms(view, i, iVar);
        }
    }

    void ms(lm lmVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar) {
        setBackgroundColor(-1);
        this.xr = lmVar;
        this.ub = nativeExpressView;
        this.ao = ahVar;
        this.ka = "banner_ad";
        this.ub.addView(this, new ViewGroup.LayoutParams(-2, -2));
        this.x = f.ny(this.xr);
        xr(this.x);
        ms();
        ah(ch.ub().l());
    }

    private void ms() {
        this.qv = ms(this.ub.getExpectExpressWidth(), this.ub.getExpectExpressHeight());
        if (this.ub.getExpectExpressWidth() > 0 && this.ub.getExpectExpressHeight() > 0) {
            this.c = ul.ah(this.f2933ms, this.ub.getExpectExpressWidth());
            this.ab = ul.ah(this.f2933ms, this.ub.getExpectExpressHeight());
        } else {
            this.c = ul.d(this.f2933ms);
            this.ab = Float.valueOf(this.c / this.qv.ah).intValue();
        }
        if (this.c > 0 && this.c > ul.d(this.f2933ms)) {
            float fD = ul.d(this.f2933ms) / this.c;
            this.c = ul.d(this.f2933ms);
            this.ab = Float.valueOf(this.ab * fD).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.c, this.ab);
        }
        layoutParams.width = this.c;
        layoutParams.height = this.ab;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        if (this.qv.f2986ms != 1 && this.qv.f2986ms == 3) {
            ms(this.qv);
        } else {
            xr();
        }
    }

    private void ms(ImageView imageView) {
        com.bytedance.sdk.openadsdk.x.xr.ms(this.xr.fk().get(0)).ms(imageView);
        if (com.bytedance.sdk.openadsdk.ka.ms.d(this.xr)) {
            UpieImageView upieImageView = new UpieImageView(imageView.getContext(), com.bytedance.sdk.openadsdk.ka.ms.ny(this.xr), com.bytedance.sdk.openadsdk.ka.ms.ch(this.xr));
            upieImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            com.bytedance.sdk.openadsdk.ka.ms.ms(imageView, upieImageView);
        }
    }

    private void ms(qv qvVar) {
        View viewMs;
        float fAh = (this.ab * 1.0f) / ul.ah(this.f2933ms, 250.0f);
        View viewK = ka.k(this.f2933ms);
        this.u = viewK;
        addView(viewK);
        FrameLayout frameLayout = (FrameLayout) this.u.findViewById(2114387778);
        this.nw = (ImageView) this.u.findViewById(2114387860);
        ImageView imageView = (ImageView) this.u.findViewById(2114387942);
        ImageView imageView2 = (ImageView) this.u.findViewById(2114387937);
        this.y = (TextView) this.u.findViewById(2114387946);
        this.t = (TextView) this.u.findViewById(2114387926);
        TextView textView = (TextView) this.u.findViewById(2114387933);
        TextView textView2 = (TextView) this.u.findViewById(2114387639);
        ul.ms((TextView) this.u.findViewById(2114387664), this.xr);
        LinearLayout linearLayout = (LinearLayout) this.u.findViewById(2114387877);
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (ul.ah(this.f2933ms, 45.0f) * fAh);
            layoutParams.height = (int) (ul.ah(this.f2933ms, 45.0f) * fAh);
        }
        this.y.setTextSize(2, ul.xr(this.f2933ms, this.y.getTextSize()) * fAh);
        this.t.setTextSize(2, ul.xr(this.f2933ms, this.t.getTextSize()) * fAh);
        textView.setTextSize(2, ul.xr(this.f2933ms, textView.getTextSize()) * fAh);
        textView2.setTextSize(2, ul.xr(this.f2933ms, textView2.getTextSize()) * fAh);
        try {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            float f = fAh - 1.0f;
            if (f > 0.0f) {
                layoutParams2.topMargin = ul.ah(this.f2933ms, f * 8.0f);
            }
            ((RelativeLayout.LayoutParams) textView2.getLayoutParams()).setMargins(0, (int) (ul.ah(this.f2933ms, 16.0f) * fAh), 0, 0);
        } catch (Throwable unused) {
        }
        this.nw.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.ka();
            }
        });
        int iAh = ul.ah(this.f2933ms, 15.0f);
        ul.ms(this.nw, iAh, iAh, iAh, iAh);
        if (qr.u(this.xr) != null && (viewMs = ms(this.ub)) != null) {
            int i = (this.c * 406) / 600;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i, (i * 9) / 16);
            if (qvVar.xr == 1) {
                int i2 = (this.c * 406) / 600;
                layoutParams3 = new FrameLayout.LayoutParams(i2, (i2 * 9) / 16);
            } else if (qvVar.xr == 2) {
                layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            } else if (qvVar.xr == 3) {
                int i3 = (this.ab * MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION) / MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME;
                layoutParams3 = new FrameLayout.LayoutParams((i3 * 16) / 9, i3);
            } else if (qvVar.xr == 4) {
                int i4 = (this.c * 480) / 690;
                layoutParams3 = new FrameLayout.LayoutParams(i4, (i4 * 9) / 16);
            }
            layoutParams3.gravity = 17;
            frameLayout.addView(viewMs, 0, layoutParams3);
            ul.ms((View) imageView, 8);
        } else {
            ms(imageView);
            ul.ms((View) imageView, 0);
        }
        com.bytedance.sdk.openadsdk.x.xr.ms(this.xr.qd()).ms(imageView2);
        textView.setText(getNameOrSource());
        this.y.setText(String.format(Locale.getDefault(), "%s提供的广告", getNameOrSource()));
        this.t.setText(getDescription());
        if (!TextUtils.isEmpty(this.xr.bn())) {
            textView2.setText(this.xr.bn());
        }
        ms((View) this, true);
        ms((View) textView2, true);
        ms(frameLayout);
    }

    private void xr() {
        float fAh = (this.ab * 1.0f) / ul.ah(this.f2933ms, 50.0f);
        if ((this.ab * 1.0f) / this.c > 0.21875f) {
            fAh = (this.c * 1.0f) / ul.ah(this.f2933ms, 320.0f);
        }
        View viewE = ka.e(this.f2933ms);
        this.u = viewE;
        addView(viewE);
        this.nw = (ImageView) this.u.findViewById(2114387860);
        ImageView imageView = (ImageView) this.u.findViewById(2114387937);
        this.y = (TextView) this.u.findViewById(2114387946);
        TextView textView = (TextView) this.u.findViewById(2114387800);
        TTRatingBar tTRatingBar = (TTRatingBar) this.u.findViewById(2114387897);
        TextView textView2 = (TextView) this.u.findViewById(2114387639);
        this.y.setTextSize(2, ul.xr(this.f2933ms, this.y.getTextSize()) * fAh);
        textView.setTextSize(2, ul.xr(this.f2933ms, textView.getTextSize()) * fAh);
        textView2.setTextSize(2, ul.xr(this.f2933ms, textView2.getTextSize()) * fAh);
        TextView textView3 = (TextView) this.u.findViewById(2114387664);
        this.nw.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.ka();
            }
        });
        ul.ms(textView3, this.xr, 27, 11);
        com.bytedance.sdk.openadsdk.x.xr.ms(this.xr.qd()).ms(imageView);
        this.y.setText(getTitle());
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (ul.ah(this.f2933ms, 45.0f) * fAh);
            layoutParams.height = (int) (ul.ah(this.f2933ms, 45.0f) * fAh);
        }
        if (!TextUtils.isEmpty(this.xr.bn())) {
            textView2.setText(this.xr.bn());
        }
        int iKa = this.xr.zh() != null ? this.xr.zh().ka() : 4;
        textView.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(iKa)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(iKa);
        tTRatingBar.setStarImageWidth(ul.ah(this.f2933ms, 15.0f) * fAh);
        tTRatingBar.setStarImageHeight(ul.ah(this.f2933ms, 14.0f) * fAh);
        tTRatingBar.setStarImagePadding(ul.ah(this.f2933ms, 4.0f));
        tTRatingBar.ms();
        ms((View) this, true);
        ms((View) textView2, true);
    }

    private qv ms(int i, int i2) {
        try {
            return ((double) i2) >= Math.floor((((double) i) * 300.0d) / 600.0d) ? zb[1] : zb[0];
        } catch (Throwable unused) {
            return zb[0];
        }
    }

    private void ah(int i) {
        if (i == 1) {
            d();
            this.u.setBackgroundColor(0);
        } else {
            ah();
            this.u.setBackgroundColor(-1);
        }
    }

    private void ah() {
        if (this.qv.f2986ms == 2 || this.qv.f2986ms == 3) {
            TextView textView = this.y;
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#FFAEAEAE"));
            }
            TextView textView2 = this.t;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor("#3E3E3E"));
            }
            if (this.nw != null) {
                this.nw.setImageDrawable(ka.eg(this.f2933ms));
                return;
            }
            return;
        }
        TextView textView3 = this.y;
        if (textView3 != null) {
            textView3.setTextColor(Color.parseColor("#FF333333"));
        }
        if (this.nw != null) {
            t.ms(getContext(), "tt_dislike_icon", this.nw);
        }
    }

    private void d() {
        if (this.qv.f2986ms == 2 || this.qv.f2986ms == 3) {
            TextView textView = this.y;
            if (textView != null) {
                textView.setTextColor(-1);
            }
            TextView textView2 = this.t;
            if (textView2 != null) {
                textView2.setTextColor(-1);
            }
        } else {
            TextView textView3 = this.y;
            if (textView3 != null) {
                textView3.setTextColor(-1);
            }
        }
        if (this.nw != null) {
            t.ms(getContext(), "tt_dislike_icon_night", this.nw);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView, com.bytedance.sdk.component.adexpress.theme.ms
    public void b_(int i) {
        super.b_(i);
        ah(i);
    }
}
