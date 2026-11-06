package com.bytedance.sdk.openadsdk.core.nativeexpress;

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
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
class zb extends BackupView {
    private static qv[] zb = {new qv(2, 3.0241935f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 124), new qv(3, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300), new qv(4, 1.4044944f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME), new qv(16, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300), new qv(5, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300), new qv(15, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300)};
    private NativeExpressView ao;
    private com.bytedance.sdk.openadsdk.core.hi.xr.ah h;
    private TextView qv;
    private ImageView t;
    private int u;
    private View ub;
    private TextView y;

    zb(Context context) {
        super(context);
        this.f2933ms = context;
    }

    void ms(lm lmVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar) {
        setBackgroundColor(-1);
        this.xr = lmVar;
        this.ao = nativeExpressView;
        this.h = ahVar;
        int iNy = f.ny(this.xr);
        this.u = iNy;
        xr(iNy);
        int iX = f.x(this.xr);
        ah(iX);
        ka(com.bytedance.sdk.openadsdk.core.ch.ub().l());
        int i = iX != 9 ? -2 : -1;
        this.ao.addView(this, new ViewGroup.LayoutParams(i, i));
    }

    private void ah(int i) {
        qv qvVarD = d(this.xr.kz());
        this.c = ul.ah(this.f2933ms, this.ao.getExpectExpressWidth());
        this.ab = ul.ah(this.f2933ms, this.ao.getExpectExpressHeight());
        if (this.c <= 0) {
            this.c = ul.d(this.f2933ms);
        }
        if (this.ab <= 0) {
            this.ab = Float.valueOf(this.c / qvVarD.ah).intValue();
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
        if (i == 9) {
            this.ka = "draw_ad";
            if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.xr)) {
                hi();
                return;
            } else {
                x();
                return;
            }
        }
        this.ka = "embeded_ad";
        int iKz = this.xr.kz();
        if (iKz == 2) {
            ah();
            return;
        }
        if (iKz == 3) {
            c();
            return;
        }
        if (iKz == 4) {
            d();
            return;
        }
        if (iKz == 5) {
            ny();
            return;
        }
        if (iKz == 15) {
            ab();
            return;
        }
        if (iKz == 16) {
            ch();
            return;
        }
        if (iKz == 131) {
            ch();
        } else if (iKz == 166) {
            sl();
        } else {
            ch();
        }
    }

    private qv d(int i) {
        qv[] qvVarArr = zb;
        qv qvVar = qvVarArr[0];
        try {
            for (qv qvVar2 : qvVarArr) {
                if (qvVar2.f2986ms == i) {
                    return qvVar2;
                }
            }
            return qvVar;
        } catch (Throwable unused) {
            return qvVar;
        }
    }

    private void ms(ImageView imageView) {
        com.bytedance.sdk.openadsdk.x.xr.ms(this.xr.fk().get(0)).ms(imageView);
        if (com.bytedance.sdk.openadsdk.ka.ms.d(this.xr)) {
            UpieImageView upieImageView = new UpieImageView(imageView.getContext(), com.bytedance.sdk.openadsdk.ka.ms.ny(this.xr), com.bytedance.sdk.openadsdk.ka.ms.ch(this.xr));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.bytedance.sdk.openadsdk.ka.ms.ms(imageView, upieImageView);
        }
    }

    private void ah() {
        View viewLm = com.bytedance.sdk.openadsdk.res.ka.lm(this.f2933ms);
        this.ub = viewLm;
        addView(viewLm);
        ImageView imageView = (ImageView) this.ub.findViewById(2114387942);
        this.t = (ImageView) this.ub.findViewById(2114387860);
        this.y = (TextView) this.ub.findViewById(2114387926);
        this.qv = (TextView) this.ub.findViewById(2114387946);
        ms((LinearLayout) this.ub.findViewById(2114387666), (TextView) this.ub.findViewById(2114387664), this.xr);
        ms(imageView);
        this.y.setText(getDescription());
        this.qv.setText(getTitle());
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.zb.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                zb.this.ka();
            }
        });
        ms(this, true);
    }

    private void ms(View view, TextView textView, lm lmVar) {
        if (view == null || textView == null) {
            return;
        }
        if (lmVar == null) {
            view.setVisibility(0);
            return;
        }
        if (TextUtils.isEmpty(lmVar.ze())) {
            view.setVisibility(0);
            textView.setVisibility(8);
            ul.ms(view, lmVar);
        } else {
            view.setVisibility(8);
            textView.setVisibility(0);
            ul.ms(textView, lmVar);
        }
    }

    private void d() {
        View viewL = com.bytedance.sdk.openadsdk.res.ka.l(this.f2933ms);
        this.ub = viewL;
        addView(viewL);
        ImageView imageView = (ImageView) this.ub.findViewById(2114387701);
        ImageView imageView2 = (ImageView) this.ub.findViewById(2114387698);
        ImageView imageView3 = (ImageView) this.ub.findViewById(2114387696);
        ImageView imageView4 = (ImageView) this.ub.findViewById(2114387937);
        this.t = (ImageView) this.ub.findViewById(2114387860);
        this.y = (TextView) this.ub.findViewById(2114387926);
        this.qv = (TextView) this.ub.findViewById(2114387946);
        TextView textView = (TextView) this.ub.findViewById(2114387639);
        ul.ms((TextView) this.ub.findViewById(2114387664), this.xr);
        com.bytedance.sdk.openadsdk.x.xr.ms(this.xr.fk().get(0)).ms(imageView);
        com.bytedance.sdk.openadsdk.x.xr.ms(this.xr.fk().get(1)).ms(imageView2);
        com.bytedance.sdk.openadsdk.x.xr.ms(this.xr.fk().get(2)).ms(imageView3);
        com.bytedance.sdk.openadsdk.x.xr.ms(this.xr.qd()).ms(imageView4);
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.zb.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                zb.this.ka();
            }
        });
        this.y.setText(getDescription());
        this.qv.setText(getTitle());
        if (!TextUtils.isEmpty(this.xr.bn())) {
            textView.setText(this.xr.bn());
        }
        ms(this, false);
        ms(textView, true);
    }

    private void c() {
        View viewIl = com.bytedance.sdk.openadsdk.res.ka.il(this.f2933ms);
        this.ub = viewIl;
        addView(viewIl);
        this.ub.findViewById(2114387740).setVisibility(8);
        this.ub.findViewById(2114387955).setVisibility(0);
        ImageView imageView = (ImageView) this.ub.findViewById(2114387942);
        this.t = (ImageView) this.ub.findViewById(2114387860);
        this.y = (TextView) this.ub.findViewById(2114387926);
        this.qv = (TextView) this.ub.findViewById(2114387946);
        TextView textView = (TextView) this.ub.findViewById(2114387639);
        ul.ms((TextView) this.ub.findViewById(2114387664), this.xr);
        imageView.setAdjustViewBounds(true);
        imageView.setMaxHeight(this.ab);
        ms(imageView);
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.zb.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                zb.this.ka();
            }
        });
        this.y.setText(getDescription());
        this.qv.setText(getTitle());
        if (!TextUtils.isEmpty(this.xr.bn())) {
            textView.setText(this.xr.bn());
        }
        ms(this, false);
        ms(textView, true);
    }

    private void ab() {
        View viewSa = com.bytedance.sdk.openadsdk.res.ka.sa(this.f2933ms);
        this.ub = viewSa;
        addView(viewSa);
        this.ub.findViewById(2114387740).setVisibility(0);
        this.ub.findViewById(2114387955).setVisibility(8);
        FrameLayout frameLayout = (FrameLayout) this.ub.findViewById(2114387965);
        ImageView imageView = (ImageView) this.ub.findViewById(2114387919);
        this.t = (ImageView) this.ub.findViewById(2114387860);
        this.y = (TextView) this.ub.findViewById(2114387926);
        this.qv = (TextView) this.ub.findViewById(2114387946);
        TextView textView = (TextView) this.ub.findViewById(2114387861);
        TextView textView2 = (TextView) this.ub.findViewById(2114387862);
        TextView textView3 = (TextView) this.ub.findViewById(2114387639);
        TextView textView4 = (TextView) this.ub.findViewById(2114387914);
        TTRatingBar tTRatingBar = (TTRatingBar) this.ub.findViewById(2114387880);
        ul.ms((TextView) this.ub.findViewById(2114387623), this.xr);
        com.bytedance.sdk.openadsdk.x.xr.ms(this.xr.qd()).ms(imageView);
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.zb.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                zb.this.ka();
            }
        });
        int iKa = this.xr.zh() != null ? this.xr.zh().ka() : 4;
        textView4.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(iKa)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(iKa);
        tTRatingBar.setStarImageWidth(ul.ah(this.f2933ms, 15.0f));
        tTRatingBar.setStarImageHeight(ul.ah(this.f2933ms, 14.0f));
        tTRatingBar.setStarImagePadding(ul.ah(this.f2933ms, 4.0f));
        tTRatingBar.ms();
        textView.setText(getNameOrSource());
        textView2.setText(getTitle());
        this.y.setText(getDescription());
        this.qv.setText(getTitle());
        if (!TextUtils.isEmpty(this.xr.bn())) {
            textView3.setText(this.xr.bn());
        }
        View viewMs = ms(this.ao);
        if (viewMs != null) {
            int i = (this.c * 123) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
            frameLayout.removeAllViews();
            frameLayout.addView(viewMs, new ViewGroup.LayoutParams(i, (i * 16) / 9));
        }
        ms(this, false);
        ms(textView3, true);
    }

    private void x() {
        View viewFm = com.bytedance.sdk.openadsdk.res.ka.fm(this.f2933ms);
        this.ub = viewFm;
        addView(viewFm);
        FrameLayout frameLayout = (FrameLayout) this.ub.findViewById(2114387740);
        ImageView imageView = (ImageView) this.ub.findViewById(2114387942);
        TextView textView = (TextView) this.ub.findViewById(2114387926);
        TextView textView2 = (TextView) this.ub.findViewById(2114387946);
        TextView textView3 = (TextView) this.ub.findViewById(2114387639);
        TextView textView4 = (TextView) this.ub.findViewById(2114387664);
        textView.setText(getDescription());
        textView2.setText(getTitle());
        ul.ms(textView4, this.xr);
        if (!TextUtils.isEmpty(this.xr.bn())) {
            textView3.setText(this.xr.bn());
        }
        if (!lm.xr(this.xr)) {
            ms(imageView);
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        } else {
            imageView.setVisibility(8);
        }
        View viewMs = ms(this.ao);
        NativeExpressView nativeExpressView = this.ao;
        if ((nativeExpressView instanceof NativeExpressVideoView) && (viewMs instanceof NativeVideoTsView)) {
            NativeExpressVideoView nativeExpressVideoView = (NativeExpressVideoView) nativeExpressView;
            NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) viewMs;
            nativeVideoTsView.setVideoAdLoadListener(nativeExpressVideoView);
            nativeVideoTsView.setVideoAdInteractionListener(nativeExpressVideoView);
        }
        if (viewMs != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(viewMs, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.ub.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        ms(textView2, false);
        ms(textView, false);
        ms(textView3, true);
    }

    private void ny() {
        View viewIl = com.bytedance.sdk.openadsdk.res.ka.il(this.f2933ms);
        this.ub = viewIl;
        addView(viewIl);
        FrameLayout frameLayout = (FrameLayout) this.ub.findViewById(2114387740);
        frameLayout.setVisibility(0);
        this.ub.findViewById(2114387955).setVisibility(8);
        this.t = (ImageView) this.ub.findViewById(2114387860);
        this.y = (TextView) this.ub.findViewById(2114387926);
        this.qv = (TextView) this.ub.findViewById(2114387946);
        TextView textView = (TextView) this.ub.findViewById(2114387639);
        ul.ms((TextView) this.ub.findViewById(2114387664), this.xr);
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.zb.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                zb.this.ka();
            }
        });
        this.y.setText(getDescription());
        this.qv.setText(getTitle());
        if (!TextUtils.isEmpty(this.xr.bn())) {
            textView.setText(this.xr.bn());
        }
        View viewMs = ms(this.ao);
        if (viewMs != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(viewMs, new ViewGroup.LayoutParams(this.c, (this.c * 9) / 16));
        }
        ms(this, false);
        ms(textView, true);
    }

    private void ch() {
        View viewSa = com.bytedance.sdk.openadsdk.res.ka.sa(this.f2933ms);
        this.ub = viewSa;
        addView(viewSa);
        this.ub.findViewById(2114387740).setVisibility(8);
        this.ub.findViewById(2114387955).setVisibility(0);
        ImageView imageView = (ImageView) this.ub.findViewById(2114387942);
        this.t = (ImageView) this.ub.findViewById(2114387860);
        this.y = (TextView) this.ub.findViewById(2114387926);
        this.qv = (TextView) this.ub.findViewById(2114387946);
        TextView textView = (TextView) this.ub.findViewById(2114387639);
        ul.ms((TextView) this.ub.findViewById(2114387664), this.xr);
        ms(imageView);
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.zb.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                zb.this.ka();
            }
        });
        this.y.setText(getDescription());
        this.qv.setText(getTitle());
        if (!TextUtils.isEmpty(this.xr.bn())) {
            textView.setText(this.xr.bn());
        }
        ms(this, false);
        ms(textView, true);
    }

    private void hi() {
        if (this.xr == null) {
            return;
        }
        View viewXn = com.bytedance.sdk.openadsdk.res.ka.xn(this.f2933ms);
        this.ub = viewXn;
        addView(viewXn);
        FrameLayout frameLayout = (FrameLayout) this.ub.findViewById(2114387771);
        TextView textView = (TextView) this.ub.findViewById(2114387905);
        View view = (RelativeLayout) this.ub.findViewById(2114387656);
        RoundImageView roundImageView = (RoundImageView) this.ub.findViewById(2114387824);
        RelativeLayout relativeLayout = (RelativeLayout) this.ub.findViewById(2114387783);
        TextView textView2 = (TextView) this.ub.findViewById(2114387774);
        TextView textView3 = (TextView) this.ub.findViewById(2114387625);
        TextView textView4 = (TextView) this.ub.findViewById(2114387901);
        ImageView imageView = (ImageView) this.ub.findViewById(2114387887);
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.xr)) {
            String strNy = com.bytedance.sdk.openadsdk.core.nw.ul.ny(this.xr);
            if (!TextUtils.isEmpty(strNy) && roundImageView != null) {
                ul.ms((View) relativeLayout, 0);
                com.bytedance.sdk.openadsdk.x.xr.ms(strNy).ms(roundImageView);
            } else {
                ul.ms((View) relativeLayout, 8);
            }
            if (textView != null) {
                textView.setText(com.bytedance.sdk.openadsdk.core.nw.ul.ah(this.xr));
            }
            if (textView2 != null) {
                int iD = com.bytedance.sdk.openadsdk.core.nw.ul.d(this.xr);
                if (iD < 0) {
                    textView2.setVisibility(4);
                    ul.ms((View) imageView, 4);
                } else {
                    textView2.setText(String.format(com.bytedance.sdk.component.utils.t.ms(this.f2933ms, "tt_live_fans_text"), iD > 10000 ? (iD / 10000.0f) + IAdInterListener.AdReqParam.WIDTH : String.valueOf(iD)));
                }
            }
            if (textView3 != null) {
                int iKa = com.bytedance.sdk.openadsdk.core.nw.ul.ka(this.xr);
                if (iKa < 0) {
                    ul.ms((View) imageView, 4);
                    textView3.setVisibility(4);
                } else {
                    textView3.setText(String.format(com.bytedance.sdk.component.utils.t.ms(this.f2933ms, "tt_live_watch_text"), iKa > 10000 ? (iKa / 10000.0f) + IAdInterListener.AdReqParam.WIDTH : String.valueOf(iKa)));
                }
            }
            if (textView4 != null) {
                textView4.setText(com.bytedance.sdk.openadsdk.core.nw.ul.c(this.xr));
            }
            View viewMs = ms(this.ao);
            if (viewMs != null) {
                frameLayout.removeAllViews();
                frameLayout.addView(viewMs, new ViewGroup.LayoutParams(-1, -1));
            }
            com.bytedance.sdk.openadsdk.core.xr.ms msVarZb = zb();
            ms(roundImageView, msVarZb, "click_live_avata");
            ms(textView, msVarZb, "click_live_author_nickname");
            ms(textView2, msVarZb, "click_live_author_follower_count");
            ms(textView3, msVarZb, "click_live_author_following_count");
            ms(textView4, msVarZb, "click_live_author_description");
            ms(frameLayout, msVarZb, "click_live_feed");
            ms(view, msVarZb, "click_live_button");
        }
    }

    private void sl() {
        if (this.xr == null) {
            return;
        }
        View viewQf = com.bytedance.sdk.openadsdk.res.ka.qf(this.f2933ms);
        this.ub = viewQf;
        addView(viewQf);
        FrameLayout frameLayout = (FrameLayout) this.ub.findViewById(2114387627);
        TextView textView = (TextView) this.ub.findViewById(2114387833);
        TextView textView2 = (TextView) this.ub.findViewById(2114387943);
        View view = (TextView) this.ub.findViewById(2114387867);
        RoundImageView roundImageView = (RoundImageView) this.ub.findViewById(2114387908);
        RelativeLayout relativeLayout = (RelativeLayout) this.ub.findViewById(2114387857);
        TextView textView3 = (TextView) this.ub.findViewById(2114387628);
        TextView textView4 = (TextView) this.ub.findViewById(2114387678);
        TextView textView5 = (TextView) this.ub.findViewById(2114387709);
        ImageView imageView = (ImageView) this.ub.findViewById(2114387887);
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.xr)) {
            String strNy = com.bytedance.sdk.openadsdk.core.nw.ul.ny(this.xr);
            if (!TextUtils.isEmpty(strNy) && roundImageView != null) {
                ul.ms((View) relativeLayout, 0);
                com.bytedance.sdk.openadsdk.x.xr.ms(strNy).ms(roundImageView);
            } else {
                ul.ms((View) relativeLayout, 8);
            }
            if (textView2 != null) {
                textView2.setText(com.bytedance.sdk.openadsdk.core.nw.ul.ah(this.xr));
            }
            if (textView3 != null) {
                int iD = com.bytedance.sdk.openadsdk.core.nw.ul.d(this.xr);
                if (iD < 0) {
                    textView3.setVisibility(4);
                    ul.ms((View) imageView, 4);
                } else {
                    textView3.setText(String.format(com.bytedance.sdk.component.utils.t.ms(this.f2933ms, "tt_live_fans_text"), iD > 10000 ? (iD / 10000.0f) + IAdInterListener.AdReqParam.WIDTH : String.valueOf(iD)));
                }
            }
            if (textView4 != null) {
                int iKa = com.bytedance.sdk.openadsdk.core.nw.ul.ka(this.xr);
                if (iKa < 0) {
                    textView4.setVisibility(4);
                    ul.ms((View) imageView, 4);
                } else {
                    textView4.setText(String.format(com.bytedance.sdk.component.utils.t.ms(this.f2933ms, "tt_live_watch_text"), iKa > 10000 ? (iKa / 10000.0f) + IAdInterListener.AdReqParam.WIDTH : String.valueOf(iKa)));
                }
            }
            if (textView != null) {
                textView.setText(com.bytedance.sdk.openadsdk.core.nw.ul.c(this.xr));
            }
            View viewMs = ms(this.ao);
            if (viewMs != null) {
                frameLayout.removeAllViews();
                frameLayout.addView(viewMs, new ViewGroup.LayoutParams(-1, -1));
            }
            com.bytedance.sdk.openadsdk.core.xr.ms msVarZb = zb();
            ms(roundImageView, msVarZb, "click_live_avata");
            ms(textView2, msVarZb, "click_live_author_nickname");
            ms(textView3, msVarZb, "click_live_author_follower_count");
            ms(textView4, msVarZb, "click_live_author_following_count");
            ms(textView, msVarZb, "click_live_author_description");
            ms(frameLayout, msVarZb, "click_live_feed");
            ms(view, msVarZb, "click_live_button");
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.zb.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    zb.this.ka();
                }
            });
        }
    }

    private com.bytedance.sdk.openadsdk.core.xr.ms zb() {
        final com.bytedance.sdk.openadsdk.core.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.xr.ms(this.f2933ms, this.xr, this.ka, f.xr(this.ka)) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.zb.8
            @Override // com.bytedance.sdk.openadsdk.core.xr.xr, com.bytedance.sdk.openadsdk.core.xr.d
            public void ms(View view, com.bytedance.sdk.openadsdk.core.nw.hi hiVar) {
                if (view == null) {
                    super.ms(view, hiVar);
                    return;
                }
                HashMap map = new HashMap();
                map.put("click_live_element", view.getTag());
                ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(map);
                super.ms(view, hiVar);
            }
        };
        ah ahVar = new ah() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.zb.9
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ah
            public void ms(View view, int i, com.bytedance.sdk.openadsdk.core.nw.i iVar) {
                try {
                    iVar.ms().put("click_extra_map", ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ka());
                } catch (JSONException unused) {
                }
                zb.this.ms(view, i, iVar);
            }
        };
        com.bytedance.sdk.openadsdk.core.xr.ms.xr.ms msVar2 = (com.bytedance.sdk.openadsdk.core.xr.ms.xr.ms) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.xr.ms.class);
        if (msVar2 != null) {
            msVar2.ms(ahVar);
            msVar2.ms(2);
        }
        return msVar;
    }

    private void ms(View view, com.bytedance.sdk.openadsdk.core.xr.xr xrVar, String str) {
        if (view == null || xrVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        view.setTag(str);
        view.setOnClickListener(xrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void ms(View view, int i, com.bytedance.sdk.openadsdk.core.nw.i iVar) {
        NativeExpressView nativeExpressView = this.ao;
        if (nativeExpressView != null) {
            if (i == 1 && nativeExpressView.getClickListener() != null) {
                this.ao.getClickListener().xr(this.t);
            }
            if (i == 2 && this.ao.getClickCreativeListener() != null) {
                this.ao.getClickCreativeListener().xr(this.t);
            }
            this.ao.ms(view, i, iVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected NativeVideoTsView ms(Context context, lm lmVar, String str, boolean z, boolean z2) {
        if ("draw_ad".equals(str)) {
            return new NativeDrawVideoTsView(context, lmVar, str, z, z2);
        }
        return new NativeVideoTsView(context, lmVar, str, z, z2);
    }

    private void ka(int i) {
        if (i == 1) {
            xr();
            this.ub.setBackgroundColor(0);
            if (this.t != null) {
                com.bytedance.sdk.component.utils.t.ms(getContext(), "tt_dislike_icon_night", this.t);
                return;
            }
            return;
        }
        ms();
        this.ub.setBackgroundColor(-1);
        if (this.t != null) {
            com.bytedance.sdk.component.utils.t.ms(getContext(), "tt_dislike_icon2", this.t);
        }
    }

    public void ms() {
        if (this.qv == null || this.y == null) {
            return;
        }
        int iKz = this.xr.kz();
        if (iKz == 2) {
            this.qv.setTextColor(Color.parseColor("#FFBCBCBC"));
            this.y.setTextColor(Color.parseColor("#FF999999"));
            return;
        }
        if (iKz != 3) {
            if (iKz == 4) {
                this.qv.setTextColor(Color.parseColor("#FF3E3E3E"));
                this.y.setTextColor(Color.parseColor("#FF3E3E3E"));
                return;
            } else if (iKz != 5 && iKz != 15 && iKz != 16) {
                return;
            }
        }
        this.qv.setTextColor(Color.parseColor("#FF222222"));
        this.y.setTextColor(Color.parseColor("#FF505050"));
    }

    public void xr() {
        TextView textView = this.qv;
        if (textView == null || this.y == null) {
            return;
        }
        textView.setTextColor(-1);
        this.y.setTextColor(-1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView, com.bytedance.sdk.component.adexpress.theme.ms
    public void b_(int i) {
        super.b_(i);
        ka(i);
    }
}
