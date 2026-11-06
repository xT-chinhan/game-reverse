package com.mcto.sspsdk.internal;

import android.content.Context;
import android.content.res.Configuration;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.button.DownloadButtonView;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;
import com.mcto.sspsdk.ssp.fullscreen.QyFullActivity;
import com.taptap.sdk.compliance.constants.BundleKey;

/* JADX INFO: loaded from: classes2.dex */
public class q6 extends sc implements View.OnTouchListener {
    public static final int u = R.drawable.qy_gradient_black_100_to_0_bg;
    public final int b;
    public final int c;
    public p d;
    public QyAdSlot e;
    public m f;
    public e g;
    public qd h;
    public boolean i;
    public boolean j;
    public volatile float k;
    public View l;
    public DownloadButtonView m;
    public hi n;
    public TextView o;
    public ConstraintLayout p;
    public int q;
    public int r;
    public o6 s;
    public e9 t;

    public q6(QyFullActivity qyFullActivity) {
        super(qyFullActivity, null);
        this.i = false;
        this.j = false;
        this.k = 0.5625f;
        this.q = -1;
        this.r = 100;
        this.b = (int) ((qyFullActivity.getResources().getDisplayMetrics().density * 8.0f) + 0.5f);
        this.c = (int) ((qyFullActivity.getResources().getDisplayMetrics().density * 24.0f) + 0.5f);
    }

    public void a(QYNiceImageView qYNiceImageView, float f) {
        qYNiceImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.k = f;
        this.l = qYNiceImageView;
        qYNiceImageView.setId(R.id.qy_full_screen_main_creative);
    }

    @Override // com.mcto.sspsdk.internal.sc
    public final void b() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        int i = this.q;
        if (i > 0) {
            o6 o6Var = this.s;
            if (o6Var == null) {
                o6 o6Var2 = new o6(this, ((long) i) * 1000);
                synchronized (o6Var2) {
                    o6Var2.c();
                }
                this.s = o6Var2;
            } else {
                o6Var.c();
            }
        }
        this.f.b();
    }

    public void d() {
        String str;
        int i;
        int[] iArr;
        Context context = getContext();
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        this.p = constraintLayout;
        constraintLayout.setId(R.id.qy_full_screen_background);
        this.p.setBackgroundColor(-1);
        addView(this.p);
        addView(this.l);
        View view = new View(context);
        view.setId(R.id.qy_full_screen_gradient);
        int i2 = u;
        view.setBackgroundResource(i2);
        view.setVisibility(8);
        addView(view);
        QYNiceImageView qYNiceImageView = new QYNiceImageView(context);
        qYNiceImageView.setId(R.id.qy_full_screen_app_icon);
        qYNiceImageView.a(12, 1, ContextCompat.getColor(context, R.color.qy_text_color_white_60alpha));
        qYNiceImageView.a(this.d.Q);
        addView(qYNiceImageView);
        TextView textView = new TextView(context);
        textView.setId(R.id.qy_full_screen_app_name);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setTypeface(null, 1);
        textView.setSingleLine();
        textView.setTextSize(1, 16.0f);
        textView.setGravity(17);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        textView.setText(this.d.P);
        textView.setIncludeFontPadding(false);
        addView(textView);
        DownloadButtonView downloadButtonView = new DownloadButtonView(jd.a);
        this.m = downloadButtonView;
        downloadButtonView.setId(R.id.qy_full_screen_ad_button);
        this.m.b(this.d.p() ? "立即下载" : this.d.g());
        this.m.setTextColor(-1);
        this.m.d();
        this.m.setTypeface(null, 1);
        this.m.setTextSize(1, 16.0f);
        this.m.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.qy_button_color_green_new));
        this.m.a(ContextCompat.getColor(getContext(), R.color.qy_text_color_black_15alpha));
        this.m.b(hk.a(getContext(), 6.0f));
        this.m.setHeight(hk.a(getContext(), 36.0f));
        if (j.b(3, this.d.S0)) {
            h hVar = new h(this.m);
            p pVar = this.d;
            hVar.a(pVar.E, pVar.i().optString("apkName"));
            this.m.a(hVar);
        }
        addView(this.m);
        int i3 = this.g.q;
        if (i3 == 2) {
            bj ziVar = this.k > 1.0f ? new zi(getContext()) : new bj(getContext());
            this.n = ziVar;
            ziVar.a(this.g.j);
            ((bj) this.n).g.b(this.g.i);
            this.n.f = true;
            str = "扭动/点击";
        } else if (i3 == 1) {
            xi viVar = this.k > 1.0f ? new vi(getContext()) : new xi(getContext());
            this.n = viVar;
            viVar.a(0);
            xi xiVar = (xi) this.n;
            e eVar = this.g;
            xiVar.g.a(eVar.l, eVar.m, eVar.n);
            this.n.f = true;
            str = "摇动/点击";
        } else {
            str = "";
        }
        if (this.n != null) {
            if (this.k > 1.0f) {
                hi hiVar = this.n;
                String str2 = str + this.d.i().optString("creativeTitle", this.d.g());
                TextView textView2 = hiVar.b;
                if (textView2 != null) {
                    textView2.setText(str2);
                }
            } else {
                this.n.setBackgroundResource(i2);
                this.n.a(this.d.i().optString("creativeTitle", "跳转详情页或第三方应用"));
            }
            this.n.setId(R.id.qy_full_screen_action);
            hi hiVar2 = this.n;
            hiVar2.e = new n6(this);
            addView(hiVar2);
        }
        TextView textView3 = new TextView(context);
        this.o = textView3;
        textView3.setId(R.id.qy_full_screen_ad_title);
        this.o.setText(this.d.i().optString(BundleKey.TITLE));
        this.o.setTextSize(1, 15.0f);
        this.o.setEllipsize(truncateAt);
        this.o.setMaxLines(1);
        this.o.setIncludeFontPadding(false);
        this.o.setTextColor(ContextCompat.getColor(context, R.color.qy_text_color_black_65alpha));
        addView(this.o);
        jc jcVar = new jc(context);
        jcVar.setId(R.id.qy_full_screen_ad_badge);
        jcVar.setTextSize(1, 12.0f);
        int iOptInt = this.d.H.optInt("needDspIcon", !rd.a() ? 1 : 0);
        p pVar2 = this.d;
        jcVar.a(iOptInt, pVar2.g0, pVar2.h0);
        jcVar.setShadowLayer(4.0f, 0.0f, 0.0f, 1711342861);
        if (!this.d.i().optBoolean("needAdBadge", true)) {
            jcVar.setVisibility(8);
        }
        addView(jcVar);
        TextView textView4 = new TextView(context);
        textView4.setId(R.id.qy_card_app_developer_info);
        if (this.d.p() && j1.a(context, this.d.H0, textView4)) {
            textView4.setTextColor(getResources().getColor(R.color.qy_text_color_white_60alpha));
            textView4.setTextSize(1, 8.0f);
        } else {
            textView4.setVisibility(8);
        }
        addView(textView4);
        ImageView imageView = new ImageView(context);
        imageView.setId(R.id.qy_full_screen_ad_close_icon);
        imageView.setImageResource(R.drawable.qy_ic_close_36_icon);
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_CENTER;
        imageView.setScaleType(scaleType);
        imageView.setOnTouchListener(this);
        int i4 = this.c;
        e eVar2 = this.g;
        if (eVar2 == null || (iArr = eVar2.f) == null || iArr.length < 2) {
            i = i4;
        } else {
            i4 = iArr[0];
            i = iArr[1];
        }
        addView(imageView, new ViewGroup.LayoutParams(i4, i));
        ImageView imageView2 = new ImageView(context);
        imageView2.setId(R.id.qy_full_screen_ad_video_volume);
        imageView2.setImageResource(R.drawable.qy_ic_volume_off_with_bg);
        imageView2.setScaleType(scaleType);
        imageView2.setOnTouchListener(this);
        imageView2.setVisibility(8);
        int i5 = this.c;
        addView(imageView2, new ViewGroup.LayoutParams(i5, i5));
        if (this.g.p == 0) {
            this.t = new g9(this, this.b);
        } else if (this.k < 1.0f) {
            this.t = new h9(this, this.b);
        } else {
            this.t = new f9(this, this.b);
        }
        Configuration configuration = getResources().getConfiguration();
        if (this.t != null) {
            this.t.a(new ConstraintSet(), configuration, this);
        }
        this.f.a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        m mVar = this.f;
        mVar.getClass();
        int action = motionEvent.getAction();
        if (action == 0) {
            mVar.f = motionEvent.getX();
            mVar.g = motionEvent.getY();
            mVar.h = motionEvent.getX();
            mVar.i = motionEvent.getY();
            mVar.j = motionEvent.getRawX();
            mVar.k = motionEvent.getRawY();
        } else if (action == 1) {
            mVar.h = motionEvent.getX();
            mVar.i = motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        post(new p6(this, configuration));
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && view.getId() == R.id.qy_full_screen_ad_close_icon) {
            if (this.r >= 100 || this.f.l || gj.a(view, motionEvent.getX(), motionEvent.getY(), this.r)) {
                qd qdVar = this.h;
                if (qdVar != null) {
                    qdVar.a.finish();
                }
            } else {
                this.f.onClick(view);
            }
        }
        return true;
    }

    @Override // com.mcto.sspsdk.internal.sc
    public final void a() {
        o6 o6Var = this.s;
        if (o6Var != null) {
            o6Var.a();
        }
    }
}
