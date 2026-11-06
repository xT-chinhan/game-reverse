package com.mcto.sspsdk.internal;

import android.content.res.ColorStateList;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.constraint.Constraints;
import android.support.constraint.Guideline;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.button.DownloadButtonView;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;
import com.mcto.sspsdk.component.interaction.QySharkView;
import com.mcto.sspsdk.component.interaction.QyTwistView;
import com.taptap.sdk.compliance.constants.BundleKey;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public final class bd extends cd {
    public final String g;
    public final int h;
    public final String i;
    public final boolean j;
    public final e k;
    public String l;
    public String m;
    public String n;
    public me o;
    public final QYNiceImageView p;
    public final TextView q;
    public final TextView r;
    public final be s;
    public final TextView t;
    public final TextView u;
    public TextView v;
    public final TextView w;
    public View x;
    public final p y;

    public bd(AppCompatActivity appCompatActivity, p pVar, e eVar) {
        super(appCompatActivity, eVar);
        this.l = "";
        this.y = pVar;
        this.n = pVar.i().optString(BundleKey.TITLE);
        String strA = gj.a((new Random((!TextUtils.isEmpty(pVar.P) ? pVar.P : pVar.v).hashCode()).nextInt(999) * 10000) + 10);
        float fNextInt = (new Random((!TextUtils.isEmpty(pVar.P) ? pVar.P : pVar.v).hashCode()).nextInt(5) / 10.0f) + 4.5f;
        this.i = pVar.i().optString("apkName");
        this.g = pVar.E;
        int i = pVar.S0;
        this.h = i;
        boolean z = i == 4 || i == 3;
        this.j = z;
        this.m = pVar.g();
        this.k = eVar;
        String strOptString = pVar.i().optString("complianceStatement");
        if (pVar.p()) {
            TextView textViewA = j1.a(appCompatActivity, pVar.H0);
            this.u = textViewA;
            textViewA.setId(R.id.qy_card_app_developer_info);
        }
        String strSubstring = pVar.P;
        TextView textView = new TextView(this.a);
        this.q = textView;
        textView.setId(R.id.qy_card_name_text);
        strSubstring = strSubstring.length() > 8 ? strSubstring.substring(0, 8) : strSubstring;
        textView.setText(strSubstring);
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.qy_text_color_black_90alpha));
        textView.setTextSize(1, 16.0f);
        textView.getPaint().setFakeBoldText(true);
        textView.setSingleLine();
        textView.setVisibility(lj.b(strSubstring) ? 8 : 0);
        String str = pVar.Q;
        QYNiceImageView qYNiceImageView = new QYNiceImageView(this.a);
        this.p = qYNiceImageView;
        qYNiceImageView.setId(R.id.qy_card_icon_img);
        qYNiceImageView.a(str);
        qYNiceImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        qYNiceImageView.a(12, 0, 0);
        TextView textView2 = new TextView(getContext());
        this.r = textView2;
        textView2.setId(R.id.qy_card_title_text);
        textView2.setTextColor(ContextCompat.getColor(getContext(), R.color.qy_text_color_black_50alpha));
        textView2.setTextSize(1, 13.0f);
        textView2.setText(this.n);
        textView2.setSingleLine(false);
        textView2.setMaxLines(2);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setVisibility(lj.b(this.n) ? 8 : 0);
        if (!TextUtils.isEmpty(strOptString)) {
            TextView textView3 = new TextView(this.a);
            this.w = textView3;
            textView3.setId(R.id.qy_card_compliance_statement);
            textView3.setTextColor(ContextCompat.getColor(getContext(), R.color.qy_text_color_black_50alpha));
            textView3.setTypeface(null, 1);
            textView3.setTextSize(1, 8.0f);
            textView3.setText(strOptString);
            textView3.setGravity(17);
        }
        if (z) {
            be beVar = new be(this.a);
            this.s = beVar;
            beVar.setId(R.id.qy_card_score_stars_bar);
            beVar.setRating(fNextInt == 5.0f ? 5.0f : 4.5f);
            beVar.setNumStars(5);
            beVar.setIsIndicator(true);
            beVar.setVisibility(0);
            beVar.setClickable(false);
            int color = getResources().getColor(R.color.qy_trueview_star_color);
            int color2 = getResources().getColor(R.color.qy_trueview_star_bg_color);
            beVar.getClass();
            beVar.setProgressTintList(new ColorStateList(new int[][]{new int[0], new int[0]}, new int[]{color, color2}));
            TextView textView4 = new TextView(this.a);
            this.t = textView4;
            textView4.setId(R.id.qy_card_download_counts_text);
            textView4.setTextSize(1, 13.0f);
            textView4.setSingleLine();
            textView4.setGravity(17);
            textView4.setText(strA + "人已下载");
            textView4.setVisibility(lj.b(String.valueOf(strA)) ? 8 : 0);
        }
    }

    @Override // com.mcto.sspsdk.internal.cd
    public final void a(int i, long j) {
        String str;
        String strOptString;
        if (this.k.p != 5) {
            return;
        }
        switch (j.a(i)) {
            case 0:
                String strReplace = this.k.S.replace("%erc", "" + this.y.X);
                String strReplace2 = this.k.P.replace("%nrt", ((int) Math.ceil(j / 1000.0d)) + "秒");
                str = strReplace;
                strOptString = strReplace2;
                break;
            case 1:
                String strReplace3 = this.k.S.replace("%erc", "" + this.y.X);
                String strReplace4 = this.k.Q.replace("%nrt", ((int) Math.ceil(j / 1000.0d)) + "秒");
                str = strReplace3;
                strOptString = strReplace4;
                break;
            case 2:
                TextView textView = (TextView) findViewById(R.id.qy_card_gold_amount_text);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("恭喜获得");
                int i2 = this.y.X;
                String strValueOf = String.valueOf(i2 > 0 ? Integer.valueOf(i2) : "0");
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) strValueOf);
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(46, true), length, spannableStringBuilder.length(), 33);
                spannableStringBuilder.append((CharSequence) "金币");
                textView.setText(spannableStringBuilder);
                strOptString = this.y.i().optString(BundleKey.TITLE);
                str = "金币下发中";
                break;
            case 3:
                strOptString = this.y.i().optString(BundleKey.TITLE);
                str = "已领取";
                break;
            case 4:
                strOptString = this.y.i().optString(BundleKey.TITLE);
                str = "领取金币";
                break;
            default:
                return;
        }
        this.m = str;
        DownloadButtonView downloadButtonView = this.b;
        if (downloadButtonView != null) {
            downloadButtonView.b(str);
        }
        this.n = strOptString;
        TextView textView2 = this.r;
        if (textView2 != null) {
            textView2.setText(strOptString);
        }
    }

    public final void b(boolean z) {
        View view = new View(getContext());
        view.setId(R.id.qy_card_background_view);
        view.setBackgroundResource(R.drawable.qy_bg_corner8_solid_white95);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, hk.a(this.a, 220.0f));
        int i = R.id.qy_card_view;
        layoutParams.topToTop = i;
        layoutParams.bottomToBottom = i;
        if (z) {
            layoutParams.bottomMargin = hk.a(this.a, 24.0f);
        }
        addView(view, layoutParams);
        setBackgroundColor(0);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(hk.a(this.a, 50.0f), hk.a(this.a, 50.0f));
        int i2 = R.id.qy_card_background_view;
        layoutParams2.topToTop = i2;
        layoutParams2.leftToLeft = i2;
        layoutParams2.rightToRight = i2;
        layoutParams2.bottomToTop = R.id.qy_card_name_text;
        layoutParams2.topMargin = hk.a(this.a, 28.0f);
        addView(this.p, layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
        int i3 = R.id.qy_card_background_view;
        layoutParams3.leftToLeft = i3;
        layoutParams3.rightToRight = i3;
        layoutParams3.matchConstraintMaxWidth = hk.a(this.a, 220.0f);
        layoutParams3.topToBottom = R.id.qy_card_icon_img;
        layoutParams3.bottomToTop = R.id.qy_card_title_text;
        this.q.setTextSize(1, 17.0f);
        addView(this.q, layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, -2);
        int i4 = R.id.qy_card_background_view;
        layoutParams4.leftToLeft = i4;
        layoutParams4.rightToRight = i4;
        layoutParams4.topToBottom = R.id.qy_card_name_text;
        layoutParams4.matchConstraintMaxWidth = hk.a(this.a, 220.0f);
        layoutParams4.topMargin = hk.a(this.a, 10.0f);
        this.r.setTextColor(ContextCompat.getColor(getContext(), R.color.qy_text_color_black_50alpha));
        this.r.setTextSize(1, 13.0f);
        addView(this.r, layoutParams4);
        ImageView imageView = new ImageView(this.a);
        imageView.setId(R.id.qy_card_lg_lottie);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(this.a.getResources(), R.drawable.qy_lg_slide));
                imageView.setImageDrawable(drawableDecodeDrawable);
                if (drawableDecodeDrawable instanceof AnimatedImageDrawable) {
                    ((AnimatedImageDrawable) drawableDecodeDrawable).start();
                }
            } catch (Exception e) {
                r9.a("QyCardViewBase", "Failed to load animated WebP", e);
                imageView.setImageResource(R.drawable.qy_lg_slide);
            }
        } else {
            imageView.setImageResource(R.drawable.qy_lg_slide);
        }
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(0, hk.a(this.a, 84.0f));
        int i5 = R.id.qy_card_background_view;
        layoutParams5.leftToLeft = i5;
        layoutParams5.rightToRight = i5;
        layoutParams5.bottomToBottom = i5;
        addView(imageView, layoutParams5);
        TextView textView = new TextView(this.a);
        textView.setText("上滑或点击" + this.m);
        textView.setTextColor(-1);
        textView.setTextSize(1, 12.0f);
        textView.setGravity(17);
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(0, -2);
        int i6 = R.id.qy_card_lg_lottie;
        layoutParams6.leftToLeft = i6;
        layoutParams6.rightToRight = i6;
        layoutParams6.bottomToBottom = i6;
        layoutParams6.bottomMargin = hk.a(this.a, 18.0f);
        addView(textView, layoutParams6);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.mcto.sspsdk.internal.n7] */
    @Override // com.mcto.sspsdk.internal.cd
    public final void d() {
        ?? r0 = this.x;
        if (r0 != 0) {
            r0.a();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.mcto.sspsdk.internal.n7] */
    @Override // com.mcto.sspsdk.internal.cd
    public final void e() {
        ?? r0 = this.x;
        if (r0 != 0) {
            r0.b();
        }
    }

    public final void b(int i) {
        if (this.k.a()) {
            this.b.a(true);
            if (this.x == null && this.k.a()) {
                if (this.k.b()) {
                    this.l = "摇动/点击";
                    QySharkView qySharkView = new QySharkView(this.a);
                    qySharkView.setImageResource(R.drawable.qy_lg_shark);
                    qySharkView.setId(R.id.qy_card_sensor_logo);
                    e eVar = this.k;
                    qySharkView.a(eVar.l, eVar.m, eVar.n);
                    qySharkView.a(new zc(this, this, qySharkView));
                    this.x = qySharkView;
                } else {
                    int i2 = this.k.q;
                    if (i2 == 2 || i2 == 5) {
                        this.l = "扭转/点击";
                        QyTwistView qyTwistView = new QyTwistView(this.a);
                        qyTwistView.a(this.k.j);
                        qyTwistView.b(this.k.i);
                        qyTwistView.setId(R.id.qy_card_sensor_logo);
                        qyTwistView.a(new ad(this, qyTwistView));
                        this.x = qyTwistView;
                    }
                }
            }
            float f = i;
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(hk.a(this.a, f), hk.a(this.a, f));
            int i3 = R.id.qy_card_download_btn;
            layoutParams.topToTop = i3;
            layoutParams.leftToLeft = i3;
            layoutParams.bottomToBottom = i3;
            layoutParams.rightToLeft = R.id.qy_card_sensor_action_desc;
            layoutParams.rightMargin = hk.a(this.a, 4.0f);
            layoutParams.horizontalChainStyle = 2;
            addView(this.x, layoutParams);
            TextView textView = new TextView(this.a);
            this.v = textView;
            textView.setText(String.format("%s%s", this.l, this.b.b()));
            this.v.setId(R.id.qy_card_sensor_action_desc);
            this.v.setSingleLine();
            this.v.setTextColor(-1);
            this.v.setTextSize(1, 17);
            ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
            int i4 = R.id.qy_card_download_btn;
            layoutParams2.topToTop = i4;
            layoutParams2.rightToRight = i4;
            layoutParams2.bottomToBottom = i4;
            layoutParams2.leftToRight = R.id.qy_card_sensor_logo;
            addView(this.v, layoutParams2);
        }
    }

    public final void a(float f, float f2, float f3) {
        DownloadButtonView downloadButtonView = this.b;
        if (downloadButtonView != null) {
            downloadButtonView.setWidth(hk.a(getContext(), f));
            this.b.setHeight(hk.a(getContext(), f2));
            this.b.b(hk.a(getContext(), f2 / 2.0f));
            this.b.setTextSize(1, f3);
            return;
        }
        DownloadButtonView downloadButtonView2 = new DownloadButtonView(getContext());
        this.b = downloadButtonView2;
        downloadButtonView2.setId(R.id.qy_card_download_btn);
        this.b.setWidth(hk.a(getContext(), f));
        this.b.setHeight(hk.a(getContext(), f2));
        this.b.b(hk.a(getContext(), f2 / 2.0f));
        this.b.setTextSize(1, f3);
        if (this.h == 3 && this.k.p != 5) {
            if (this.u != null) {
                this.m = "立即下载";
                this.b.b("立即下载");
            }
            h hVar = new h(this.b);
            hVar.e = new yc(this);
            hVar.a(this.g, this.i);
            this.b.a(hVar);
            return;
        }
        this.b.b(this.m);
    }

    @Override // com.mcto.sspsdk.internal.cd
    public final void a(me meVar) {
        this.o = meVar;
    }

    @Override // com.mcto.sspsdk.internal.cd
    public final void a(int i, int i2) {
        if (i != 4) {
            if (i != 8) {
                return;
            }
            if (i2 == 19 || i2 == 20) {
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(this);
                constraintSet.setVisibility(R.id.qy_card_gold_amount_text, 8);
                constraintSet.clear(R.id.qy_card_icon_img);
                constraintSet.constrainWidth(R.id.qy_card_icon_img, hk.a(this.a, 78.0f));
                constraintSet.constrainHeight(R.id.qy_card_icon_img, hk.a(this.a, 78.0f));
                constraintSet.connect(R.id.qy_card_icon_img, 1, 0, 1);
                constraintSet.connect(R.id.qy_card_icon_img, 2, 0, 2);
                constraintSet.connect(R.id.qy_card_icon_img, 3, 0, 3);
                constraintSet.connect(R.id.qy_card_icon_img, 4, R.id.qy_card_title_text, 3);
                constraintSet.setVerticalChainStyle(R.id.qy_card_icon_img, 2);
                constraintSet.clear(R.id.qy_card_title_text);
                this.r.setTextSize(1, 23.0f);
                constraintSet.constrainWidth(R.id.qy_card_title_text, -2);
                constraintSet.constrainHeight(R.id.qy_card_title_text, -2);
                constraintSet.connect(R.id.qy_card_title_text, 1, 0, 1);
                constraintSet.connect(R.id.qy_card_title_text, 2, 0, 2);
                constraintSet.connect(R.id.qy_card_title_text, 3, R.id.qy_card_icon_img, 4, hk.a(this.a, 14.0f));
                constraintSet.connect(R.id.qy_card_title_text, 4, R.id.qy_card_download_btn, 3, hk.a(this.a, 61.0f));
                constraintSet.setVerticalChainStyle(R.id.qy_card_title_text, 2);
                constraintSet.clear(R.id.qy_card_gold_label);
                constraintSet.constrainWidth(R.id.qy_card_gold_label, hk.a(this.a, 63.0f));
                constraintSet.constrainHeight(R.id.qy_card_gold_label, hk.a(this.a, 23.8f));
                constraintSet.setTranslationX(R.id.qy_card_gold_label, -hk.a(this.a, 30.0f));
                constraintSet.connect(R.id.qy_card_gold_label, 2, R.id.qy_card_download_btn, 2);
                constraintSet.connect(R.id.qy_card_gold_label, 4, R.id.qy_card_download_btn, 3, hk.a(this.a, 6.2f));
                constraintSet.clear(R.id.qy_card_download_btn);
                constraintSet.constrainWidth(R.id.qy_card_download_btn, hk.a(this.a, 300.0f));
                constraintSet.constrainHeight(R.id.qy_card_download_btn, hk.a(this.a, 44.0f));
                constraintSet.connect(R.id.qy_card_download_btn, 1, 0, 1);
                constraintSet.connect(R.id.qy_card_download_btn, 2, 0, 2);
                constraintSet.connect(R.id.qy_card_download_btn, 3, R.id.qy_card_title_text, 4, hk.a(this.a, 14.0f));
                constraintSet.connect(R.id.qy_card_download_btn, 4, 0, 4);
                constraintSet.setVerticalChainStyle(R.id.qy_card_title_text, 2);
                constraintSet.applyTo(this);
            } else if (i2 != 13 && i2 != 18) {
                removeAllViews();
                a(true);
            } else {
                removeAllViews();
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(hk.a(this.a, 100.0f), hk.a(this.a, 100.0f));
                layoutParams.topToTop = 0;
                layoutParams.bottomToTop = R.id.qy_card_name_text;
                layoutParams.leftToLeft = 0;
                layoutParams.rightToRight = 0;
                layoutParams.verticalChainStyle = 2;
                addView(this.p, layoutParams);
                this.q.setTextSize(1, 26.0f);
                this.q.getPaint().setFakeBoldText(true);
                this.q.setTextColor(-1);
                ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
                layoutParams2.leftToLeft = 0;
                layoutParams2.rightToRight = 0;
                layoutParams2.topToBottom = R.id.qy_card_icon_img;
                layoutParams2.bottomToTop = R.id.qy_card_title_text;
                layoutParams2.topMargin = hk.a(this.a, 10.0f);
                addView(this.q, layoutParams2);
                this.r.setGravity(1);
                this.r.setTextSize(1, 15.0f);
                this.r.setTextColor(-7829368);
                ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(0, -2);
                int iA = hk.a(this.a, 40.0f);
                layoutParams3.leftMargin = iA;
                layoutParams3.rightMargin = iA;
                layoutParams3.leftToLeft = 0;
                layoutParams3.rightToRight = 0;
                layoutParams3.topToBottom = R.id.qy_card_name_text;
                layoutParams3.bottomToTop = this.j ? R.id.qy_card_score_stars_bar : R.id.qy_card_download_btn;
                layoutParams3.topMargin = hk.a(this.a, 15.0f);
                layoutParams3.bottomMargin = hk.a(this.a, 15.0f);
                layoutParams3.matchConstraintMaxWidth = hk.a(this.a, 350.0f);
                addView(this.r, layoutParams3);
                if (this.j) {
                    this.s.setMinimumWidth(hk.a(this.a, 24.0f));
                    be beVar = this.s;
                    beVar.h = hk.a(this.a, 10.0f);
                    beVar.requestLayout();
                    ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(0, hk.a(this.a, 24.0f));
                    layoutParams4.matchConstraintMaxWidth = hk.a(this.a, 160.0f);
                    layoutParams4.setMargins(hk.a(this.a, 58.0f), 0, hk.a(this.a, 58.0f), 0);
                    layoutParams4.leftToLeft = 0;
                    layoutParams4.rightToRight = 0;
                    layoutParams4.topToBottom = R.id.qy_card_title_text;
                    layoutParams4.bottomToTop = R.id.qy_card_download_counts_text;
                    layoutParams4.topMargin = hk.a(this.a, 5.0f);
                    addView(this.s, layoutParams4);
                    this.t.setTextColor(-7829368);
                    ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, hk.a(this.a, 18.0f));
                    layoutParams5.leftToLeft = 0;
                    layoutParams5.rightToRight = 0;
                    layoutParams5.topToBottom = R.id.qy_card_score_stars_bar;
                    layoutParams5.bottomToTop = R.id.qy_card_download_btn;
                    layoutParams5.topMargin = hk.a(this.a, 10.0f);
                    layoutParams5.bottomMargin = hk.a(this.a, 10.0f);
                    addView(this.t, layoutParams5);
                }
                a(260.0f, 50.0f, 17.0f);
                ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(hk.a(this.a, 260.0f), hk.a(this.a, 50.0f));
                layoutParams6.leftToLeft = 0;
                layoutParams6.rightToRight = 0;
                layoutParams6.topToBottom = this.j ? R.id.qy_card_download_counts_text : R.id.qy_card_title_text;
                layoutParams6.bottomToBottom = 0;
                layoutParams6.topMargin = hk.a(this.a, 10.0f);
                addView(this.b, layoutParams6);
                TextView textView = this.u;
                if (textView != null) {
                    hk.a((View) textView, -1);
                    ConstraintLayout.LayoutParams layoutParams7 = new ConstraintLayout.LayoutParams(-1, -2);
                    int iA2 = hk.a(this.a, 10.0f);
                    layoutParams7.rightMargin = iA2;
                    layoutParams7.leftMargin = iA2;
                    layoutParams7.leftToLeft = 0;
                    layoutParams7.rightToRight = 0;
                    layoutParams7.bottomToBottom = 0;
                    layoutParams7.bottomMargin = hk.a(this.a, 20.0f);
                    addView(this.u, layoutParams7);
                }
            }
            a(this.c.a(-1));
            return;
        }
        switch (j.a(i2)) {
            case 0:
            case 10:
            case 11:
            case 12:
                Constraints.LayoutParams layoutParams8 = new Constraints.LayoutParams(hk.a(this.a, 59.0f), hk.a(this.a, 59.0f));
                int i3 = R.id.qy_card_view;
                layoutParams8.leftToLeft = i3;
                layoutParams8.topToTop = i3;
                layoutParams8.bottomToTop = R.id.qy_card_download_btn;
                int iA3 = hk.a(this.a, 10.0f);
                ((ConstraintLayout.LayoutParams) layoutParams8).topMargin = iA3;
                ((ConstraintLayout.LayoutParams) layoutParams8).bottomMargin = iA3;
                ((ConstraintLayout.LayoutParams) layoutParams8).leftMargin = hk.a(this.a, 16.0f);
                addView(this.p, layoutParams8);
                Constraints.LayoutParams layoutParams9 = new Constraints.LayoutParams(0, -2);
                int i4 = R.id.qy_card_icon_img;
                layoutParams9.leftToRight = i4;
                layoutParams9.topToTop = i4;
                layoutParams9.rightToRight = R.id.qy_card_view;
                layoutParams9.bottomToTop = R.id.qy_card_title_text;
                ((ConstraintLayout.LayoutParams) layoutParams9).leftMargin = hk.a(this.a, 8.0f);
                ((ConstraintLayout.LayoutParams) layoutParams9).rightMargin = hk.a(this.a, 16.0f);
                layoutParams9.goneLeftMargin = hk.a(this.a, 80.0f);
                layoutParams9.verticalChainStyle = 2;
                this.q.setTextSize(1, 17.0f);
                addView(this.q, layoutParams9);
                Constraints.LayoutParams layoutParams10 = new Constraints.LayoutParams(0, -2);
                int i5 = R.id.qy_card_name_text;
                layoutParams10.leftToLeft = i5;
                layoutParams10.topToBottom = i5;
                layoutParams10.bottomToBottom = R.id.qy_card_icon_img;
                layoutParams10.rightToRight = i5;
                ((ConstraintLayout.LayoutParams) layoutParams10).topMargin = hk.a(this.a, 6.0f);
                addView(this.r, layoutParams10);
                a(311.0f, 34.0f, 14.0f);
                ConstraintLayout.LayoutParams layoutParams11 = new ConstraintLayout.LayoutParams(-1, -2);
                layoutParams11.topToBottom = R.id.qy_card_icon_img;
                int i6 = R.id.qy_card_view;
                layoutParams11.leftToLeft = i6;
                layoutParams11.rightToRight = i6;
                int iA4 = hk.a(this.a, 22.0f);
                if (this.w != null) {
                    layoutParams11.bottomToTop = R.id.qy_card_compliance_statement;
                    iA4 = hk.a(this.a, 4.0f);
                } else if (this.u != null) {
                    layoutParams11.bottomToTop = R.id.qy_card_app_developer_info;
                } else {
                    layoutParams11.bottomToBottom = 0;
                }
                layoutParams11.setMargins(hk.a(this.a, 16.0f), 0, hk.a(this.a, 16.0f), iA4);
                addView(this.b, layoutParams11);
                b(20);
                if (this.w != null) {
                    ConstraintLayout.LayoutParams layoutParams12 = new ConstraintLayout.LayoutParams(0, -2);
                    int i7 = R.id.qy_card_download_btn;
                    layoutParams12.rightToRight = i7;
                    layoutParams12.leftToLeft = i7;
                    layoutParams12.topToBottom = i7;
                    if (this.u != null) {
                        layoutParams12.bottomToTop = R.id.qy_card_app_developer_info;
                    } else {
                        layoutParams12.bottomToBottom = 0;
                    }
                    layoutParams12.bottomMargin = hk.a(this.a, 10.0f);
                    addView(this.w, layoutParams12);
                }
                if (this.u != null) {
                    ConstraintLayout.LayoutParams layoutParams13 = new ConstraintLayout.LayoutParams(-1, -2);
                    int i8 = R.id.qy_card_view;
                    layoutParams13.bottomToBottom = i8;
                    layoutParams13.leftToLeft = i8;
                    layoutParams13.rightToRight = i8;
                    if (this.w != null) {
                        layoutParams13.topToBottom = R.id.qy_card_compliance_statement;
                    } else {
                        layoutParams13.topToBottom = R.id.qy_card_download_btn;
                    }
                    this.u.setGravity(17);
                    this.u.setTextColor(getResources().getColor(R.color.qy_text_color_white_80alpha));
                    addView(this.u, layoutParams13);
                    ConstraintLayout.LayoutParams layoutParams14 = new ConstraintLayout.LayoutParams(-1, 0);
                    int i9 = R.id.qy_card_view;
                    layoutParams14.topToTop = i9;
                    layoutParams14.leftToLeft = i9;
                    layoutParams14.rightToRight = i9;
                    layoutParams14.bottomToTop = R.id.qy_card_app_developer_info;
                    layoutParams14.bottomMargin = hk.a(getContext(), 12.0f);
                    View view = new View(getContext());
                    view.setId(R.id.qy_card_background_view);
                    hk.a(view, hk.a(this.a, 8.0f));
                    view.setBackgroundColor(-167772161);
                    addView(view, 0, layoutParams14);
                    setBackgroundColor(0);
                } else {
                    hk.a(this, hk.a(this.a, 8.0f));
                }
                break;
            case 1:
                View guideline = new Guideline(this.a);
                guideline.setId(R.id.qy_card_guideline);
                ConstraintLayout.LayoutParams layoutParams15 = new ConstraintLayout.LayoutParams(-2, -2);
                int i10 = R.id.qy_card_view;
                layoutParams15.topToTop = i10;
                layoutParams15.bottomToBottom = i10;
                layoutParams15.guidePercent = 0.5f;
                layoutParams15.orientation = 0;
                addView(guideline, layoutParams15);
                ConstraintLayout.LayoutParams layoutParams16 = new ConstraintLayout.LayoutParams(hk.a(this.a, 70.0f), hk.a(this.a, 70.0f));
                int i11 = R.id.qy_card_view;
                layoutParams16.leftToLeft = i11;
                layoutParams16.topToTop = i11;
                layoutParams16.topMargin = hk.a(this.a, 126.0f);
                layoutParams16.leftMargin = hk.a(this.a, 48.0f);
                addView(this.p, layoutParams16);
                this.q.setTextColor(-1);
                this.q.setTextSize(1, 21.0f);
                ConstraintLayout.LayoutParams layoutParams17 = new ConstraintLayout.LayoutParams(0, -2);
                int i12 = R.id.qy_card_icon_img;
                layoutParams17.leftToRight = i12;
                layoutParams17.rightToRight = R.id.qy_card_view;
                layoutParams17.topToTop = i12;
                layoutParams17.leftMargin = hk.a(this.a, 17.0f);
                layoutParams17.rightMargin = hk.a(this.a, 48.0f);
                layoutParams17.goneLeftMargin = hk.a(this.a, 48.0f);
                addView(this.q, layoutParams17);
                if (this.j) {
                    this.s.setMinimumHeight(hk.a(this.a, 12.0f));
                    this.s.setMinimumWidth(hk.a(this.a, 12.0f));
                    be beVar2 = this.s;
                    beVar2.h = hk.a(this.a, 8.0f);
                    beVar2.requestLayout();
                    ConstraintLayout.LayoutParams layoutParams18 = new ConstraintLayout.LayoutParams(hk.a(this.a, 85.0f), hk.a(this.a, 14.0f));
                    layoutParams18.leftToRight = R.id.qy_card_icon_img;
                    layoutParams18.topToBottom = R.id.qy_card_name_text;
                    layoutParams18.topMargin = hk.a(this.a, 20.0f);
                    layoutParams18.leftMargin = hk.a(this.a, 17.0f);
                    addView(this.s, layoutParams18);
                    this.t.setTextColor(-1);
                    ConstraintLayout.LayoutParams layoutParams19 = new ConstraintLayout.LayoutParams(-2, -2);
                    int i13 = R.id.qy_card_score_stars_bar;
                    layoutParams19.bottomToBottom = i13;
                    layoutParams19.leftToRight = i13;
                    layoutParams19.leftMargin = hk.a(this.a, 12.0f);
                    addView(this.t, layoutParams19);
                } else {
                    this.r.setTextColor(ContextCompat.getColor(getContext(), R.color.qy_loading_des_color));
                    this.r.setTextSize(1, 13.0f);
                    ConstraintLayout.LayoutParams layoutParams20 = new ConstraintLayout.LayoutParams(hk.a(this.a, 162.0f), hk.a(this.a, 37.0f));
                    layoutParams20.leftToRight = R.id.qy_card_icon_img;
                    layoutParams20.topToBottom = R.id.qy_card_name_text;
                    layoutParams20.topMargin = hk.a(this.a, 4.0f);
                    layoutParams20.leftMargin = hk.a(this.a, 17.0f);
                    addView(this.r, layoutParams20);
                }
                a(260.0f, 50.0f, 19.0f);
                ConstraintLayout.LayoutParams layoutParams21 = new ConstraintLayout.LayoutParams(hk.a(this.a, 260.0f), hk.a(this.a, 49.0f));
                TextView textView2 = this.u;
                if (textView2 != null) {
                    layoutParams21.bottomToTop = R.id.qy_card_app_developer_info;
                } else {
                    layoutParams21.bottomToBottom = R.id.qy_card_view;
                }
                int i14 = R.id.qy_card_view;
                layoutParams21.leftToLeft = i14;
                layoutParams21.rightToRight = i14;
                layoutParams21.bottomMargin = hk.a(this.a, textView2 == null ? 110.0f : 80.0f);
                addView(this.b, layoutParams21);
                TextView textView3 = this.u;
                if (textView3 != null) {
                    textView3.setTextColor(getResources().getColor(R.color.qy_text_color_white_30alpha));
                    ConstraintLayout.LayoutParams layoutParams22 = new ConstraintLayout.LayoutParams(-1, -2);
                    int i15 = R.id.qy_card_view;
                    layoutParams22.bottomToBottom = i15;
                    layoutParams22.leftToLeft = i15;
                    layoutParams22.rightToRight = i15;
                    layoutParams22.bottomMargin = hk.a(this.a, 20.0f);
                    addView(this.u, layoutParams22);
                }
                break;
            case 2:
            case 3:
                ConstraintLayout.LayoutParams layoutParams23 = new ConstraintLayout.LayoutParams(hk.a(this.a, 335.0f), -2);
                int i16 = R.id.qy_card_view;
                layoutParams23.rightToRight = i16;
                layoutParams23.bottomToBottom = i16;
                View view2 = new View(getContext());
                view2.setId(R.id.qy_card_background_view);
                view2.setPadding(0, 10, 0, 10);
                hk.a(view2, hk.a(this.a, 8.0f));
                view2.setBackgroundColor(-167772161);
                addView(view2, layoutParams23);
                setBackgroundColor(0);
                Constraints.LayoutParams layoutParams24 = new Constraints.LayoutParams(hk.a(this.a, 59.0f), hk.a(this.a, 59.0f));
                layoutParams24.topToTop = R.id.qy_card_background_view;
                int i17 = R.id.qy_card_download_btn;
                layoutParams24.leftToLeft = i17;
                layoutParams24.bottomToTop = i17;
                ((ConstraintLayout.LayoutParams) layoutParams24).bottomMargin = hk.a(this.a, 10.0f);
                layoutParams24.verticalChainStyle = 2;
                addView(this.p, layoutParams24);
                Constraints.LayoutParams layoutParams25 = new Constraints.LayoutParams(0, -2);
                int i18 = R.id.qy_card_icon_img;
                layoutParams25.leftToRight = i18;
                layoutParams25.topToTop = i18;
                layoutParams25.rightToRight = R.id.qy_card_download_btn;
                layoutParams25.bottomToTop = R.id.qy_card_title_text;
                ((ConstraintLayout.LayoutParams) layoutParams25).leftMargin = hk.a(this.a, 8.0f);
                layoutParams25.goneLeftMargin = hk.a(this.a, 80.0f);
                layoutParams25.verticalChainStyle = 0;
                this.q.setTextSize(1, 17.0f);
                addView(this.q, layoutParams25);
                Constraints.LayoutParams layoutParams26 = new Constraints.LayoutParams(0, -2);
                int i19 = R.id.qy_card_name_text;
                layoutParams26.leftToLeft = i19;
                layoutParams26.topToBottom = i19;
                layoutParams26.bottomToBottom = R.id.qy_card_icon_img;
                layoutParams26.rightToRight = i19;
                ((ConstraintLayout.LayoutParams) layoutParams26).topMargin = hk.a(this.a, 6.0f);
                addView(this.r, layoutParams26);
                a(311.0f, 34.0f, 14.0f);
                ConstraintLayout.LayoutParams layoutParams27 = new ConstraintLayout.LayoutParams(-2, -2);
                layoutParams27.topToBottom = R.id.qy_card_icon_img;
                int i20 = R.id.qy_card_background_view;
                layoutParams27.leftToLeft = i20;
                layoutParams27.rightToRight = i20;
                if (this.w != null) {
                    layoutParams27.bottomToTop = R.id.qy_card_compliance_statement;
                } else {
                    layoutParams27.bottomToBottom = i20;
                }
                int iA5 = hk.a(this.a, 16.0f);
                layoutParams27.leftMargin = iA5;
                layoutParams27.rightMargin = iA5;
                addView(this.b, layoutParams27);
                b(20);
                if (this.w != null) {
                    ConstraintLayout.LayoutParams layoutParams28 = new ConstraintLayout.LayoutParams(0, -2);
                    int i21 = R.id.qy_card_download_btn;
                    layoutParams28.rightToRight = i21;
                    layoutParams28.leftToLeft = i21;
                    layoutParams28.topToBottom = i21;
                    layoutParams28.bottomToBottom = R.id.qy_card_background_view;
                    addView(this.w, layoutParams28);
                }
                if (this.u != null) {
                    ConstraintLayout.LayoutParams layoutParams29 = new ConstraintLayout.LayoutParams(0, -2);
                    int i22 = R.id.qy_card_view;
                    layoutParams29.bottomToBottom = i22;
                    layoutParams29.leftToLeft = i22;
                    layoutParams29.rightToLeft = R.id.qy_card_background_view;
                    layoutParams29.matchConstraintMaxWidth = hk.a(this.a, 335.0f);
                    this.u.setGravity(17);
                    this.u.setTextColor(getResources().getColor(R.color.qy_text_color_white_80alpha));
                    addView(this.u, layoutParams29);
                }
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                a(false);
                break;
            case 13:
            case 14:
                b(true);
                break;
            case 15:
            case 16:
            case 17:
                b(false);
                break;
            case 18:
            case 19:
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                gradientDrawable.setColors(new int[]{-5689, -1});
                gradientDrawable.setCornerRadii(new float[8]);
                setBackground(gradientDrawable);
                TextView textView4 = new TextView(this.a);
                textView4.setId(R.id.qy_card_gold_amount_text);
                textView4.setGravity(81);
                textView4.setTextColor(ContextCompat.getColor(this.a, R.color.qy_vip_text_color));
                textView4.setTypeface(null, 1);
                textView4.setTextSize(1, 21.0f);
                h6.a(this.a, textView4, this.k.R);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                int i23 = this.y.X;
                String strValueOf = String.valueOf(i23 > 0 ? Integer.valueOf(i23) : "0");
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) strValueOf);
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(46, true), length, spannableStringBuilder.length(), 33);
                spannableStringBuilder.append((CharSequence) " 金币");
                textView4.setText(spannableStringBuilder);
                ConstraintLayout.LayoutParams layoutParams30 = new ConstraintLayout.LayoutParams(-2, -2);
                layoutParams30.leftToLeft = 0;
                layoutParams30.rightToRight = 0;
                layoutParams30.topToTop = 0;
                layoutParams30.bottomToTop = R.id.qy_card_icon_img;
                layoutParams30.topMargin = hk.a(this.a, 21.0f);
                layoutParams30.verticalChainStyle = 2;
                addView(textView4, layoutParams30);
                ImageView imageView = new ImageView(this.a);
                imageView.setId(R.id.qy_card_gold_label);
                imageView.setBackgroundResource(R.drawable.qy_ic_gold_label);
                ConstraintLayout.LayoutParams layoutParams31 = new ConstraintLayout.LayoutParams(hk.a(this.a, 63.0f), hk.a(this.a, 23.8f));
                layoutParams31.topMargin = hk.a(this.a, 16.0f);
                imageView.setTranslationX(hk.a(this.a, 30.0f));
                layoutParams31.rightToRight = R.id.qy_card_gold_amount_text;
                layoutParams31.topToTop = 0;
                addView(imageView, layoutParams31);
                ConstraintLayout.LayoutParams layoutParams32 = new ConstraintLayout.LayoutParams(hk.a(this.a, 28.0f), hk.a(this.a, 28.0f));
                layoutParams32.leftToLeft = 0;
                layoutParams32.rightToLeft = R.id.qy_card_title_text;
                layoutParams32.topToBottom = R.id.qy_card_gold_amount_text;
                layoutParams32.bottomToTop = R.id.qy_card_download_btn;
                layoutParams32.horizontalChainStyle = 2;
                layoutParams32.verticalChainStyle = 2;
                layoutParams32.topMargin = hk.a(this.a, 12.0f);
                layoutParams32.bottomMargin = hk.a(this.a, 13.0f);
                hk.a(this.p);
                addView(this.p, layoutParams32);
                this.r.setTextSize(1, 16.0f);
                this.r.setLines(1);
                this.r.setEllipsize(TextUtils.TruncateAt.END);
                this.r.setTypeface(null, 1);
                h6.a(this.a, this.r, this.k.R);
                this.r.setTextColor(ContextCompat.getColor(this.a, R.color.qy_vip_text_color));
                ConstraintLayout.LayoutParams layoutParams33 = new ConstraintLayout.LayoutParams(-2, -2);
                int i24 = R.id.qy_card_icon_img;
                layoutParams33.leftToRight = i24;
                layoutParams33.rightToRight = 0;
                layoutParams33.topToTop = i24;
                layoutParams33.bottomToBottom = i24;
                layoutParams33.matchConstraintMaxWidth = hk.a(this.a, 163.0f);
                layoutParams33.leftMargin = hk.a(this.a, 6.0f);
                layoutParams33.horizontalChainStyle = 2;
                addView(this.r, layoutParams33);
                a(hk.a(this.a, 301.0f), hk.a(this.a, 40.0f), 16.0f);
                this.b.a(new int[]{ContextCompat.getColor(this.a, R.color.qy_vip_button_bg), ContextCompat.getColor(this.a, R.color.qy_vip_button_bg2)});
                ConstraintLayout.LayoutParams layoutParams34 = new ConstraintLayout.LayoutParams(hk.a(this.a, 301.0f), hk.a(this.a, 40.0f));
                layoutParams34.leftToLeft = 0;
                layoutParams34.rightToRight = 0;
                layoutParams34.topToBottom = R.id.qy_card_icon_img;
                layoutParams34.bottomToBottom = 0;
                layoutParams34.bottomMargin = hk.a(this.a, 20.0f);
                layoutParams34.verticalChainStyle = 2;
                addView(this.b, layoutParams34);
                break;
        }
        a(this.c.a(0));
    }

    public final void a(boolean z) {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(hk.a(this.a, 100.0f), hk.a(this.a, 100.0f));
        layoutParams.topToTop = 0;
        layoutParams.bottomToTop = R.id.qy_card_name_text;
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.verticalChainStyle = 0;
        addView(this.p, layoutParams);
        this.q.setTextSize(1, 26.0f);
        this.q.getPaint().setFakeBoldText(true);
        this.q.setTextColor(ContextCompat.getColor(getContext(), R.color.qy_text_color_black_90alpha));
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.leftToLeft = 0;
        layoutParams2.rightToRight = 0;
        layoutParams2.topToBottom = R.id.qy_card_icon_img;
        layoutParams2.bottomToTop = R.id.qy_card_title_text;
        addView(this.q, layoutParams2);
        this.r.setGravity(1);
        this.r.setTextSize(1, 15.0f);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(0, -2);
        int iA = hk.a(this.a, 40.0f);
        layoutParams3.leftMargin = iA;
        layoutParams3.rightMargin = iA;
        layoutParams3.leftToLeft = 0;
        layoutParams3.rightToRight = 0;
        layoutParams3.topToBottom = R.id.qy_card_name_text;
        layoutParams3.bottomToTop = this.j ? R.id.qy_card_score_stars_bar : R.id.qy_card_download_btn;
        addView(this.r, layoutParams3);
        if (this.j) {
            this.s.setMinimumWidth(hk.a(this.a, 24.0f));
            be beVar = this.s;
            beVar.h = hk.a(this.a, 10.0f);
            beVar.requestLayout();
            ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(0, hk.a(this.a, 24.0f));
            layoutParams4.matchConstraintMaxWidth = hk.a(this.a, 160.0f);
            layoutParams4.setMargins(hk.a(this.a, 58.0f), 0, hk.a(this.a, 58.0f), 0);
            layoutParams4.leftToLeft = 0;
            layoutParams4.rightToRight = 0;
            layoutParams4.topToBottom = R.id.qy_card_title_text;
            layoutParams4.bottomToTop = R.id.qy_card_download_counts_text;
            addView(this.s, layoutParams4);
            this.t.setTextColor(-7829368);
            ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, hk.a(this.a, 18.0f));
            layoutParams5.leftToLeft = 0;
            layoutParams5.rightToRight = 0;
            layoutParams5.topToBottom = R.id.qy_card_score_stars_bar;
            layoutParams5.bottomToTop = R.id.qy_card_download_btn;
            addView(this.t, layoutParams5);
        }
        a(260.0f, 50.0f, 17.0f);
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(hk.a(this.a, 260.0f), hk.a(this.a, 50.0f));
        layoutParams6.leftToLeft = 0;
        layoutParams6.rightToRight = 0;
        layoutParams6.topToBottom = this.j ? R.id.qy_card_download_counts_text : R.id.qy_card_title_text;
        if (this.w != null) {
            layoutParams6.bottomToTop = R.id.qy_card_compliance_statement;
        } else if (this.u != null) {
            layoutParams6.bottomToTop = R.id.qy_card_app_developer_info;
        } else {
            layoutParams6.bottomToBottom = 0;
        }
        addView(this.b, layoutParams6);
        if (this.w != null) {
            ConstraintLayout.LayoutParams layoutParams7 = new ConstraintLayout.LayoutParams(0, -2);
            int i = R.id.qy_card_download_btn;
            layoutParams7.rightToRight = i;
            layoutParams7.leftToLeft = i;
            layoutParams7.topToBottom = i;
            if (this.u != null) {
                layoutParams7.bottomToTop = R.id.qy_card_app_developer_info;
            } else {
                layoutParams7.bottomToBottom = 0;
            }
            addView(this.w, layoutParams7);
        }
        TextView textView = this.u;
        if (textView != null) {
            hk.a((View) textView, getResources().getColor(R.color.qy_text_color_black_30alpha));
            ConstraintLayout.LayoutParams layoutParams8 = new ConstraintLayout.LayoutParams(-1, -2);
            int iA2 = hk.a(this.a, 7.0f);
            layoutParams8.rightMargin = iA2;
            layoutParams8.leftMargin = iA2;
            layoutParams8.leftToLeft = 0;
            layoutParams8.rightToRight = 0;
            if (this.w != null) {
                layoutParams8.topToBottom = R.id.qy_card_compliance_statement;
            } else {
                layoutParams8.topToBottom = R.id.qy_card_download_btn;
            }
            layoutParams8.bottomToBottom = 0;
            addView(this.u, layoutParams8);
        }
        if (z) {
            b(30);
        }
    }
}
