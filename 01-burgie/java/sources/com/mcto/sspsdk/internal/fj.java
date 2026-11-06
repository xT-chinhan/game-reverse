package com.mcto.sspsdk.internal;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.GradientDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.constraint.Constraints;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.imageview2.QYImageView2;
import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import com.taptap.sdk.compliance.constants.BundleKey;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class fj extends sc implements View.OnTouchListener, gi {
    public volatile long b;
    public boolean c;
    public JSONObject d;
    public int e;
    public p f;
    public e g;
    public int h;
    public int i;
    public int j;
    public int k;
    public float l;
    public View m;
    public vg n;
    public li o;
    public int p;
    public boolean q;
    public float r;
    public float s;
    public float t;
    public float u;
    public boolean v;
    public ConstraintSet w;
    public int x;
    public int y;

    public fj(Context context) {
        super(context);
        this.b = 0L;
        this.c = true;
        this.e = 0;
        this.j = 0;
        this.k = 0;
        this.p = 100;
        this.q = false;
        this.r = -999.0f;
        this.s = -999.0f;
        this.t = -999.0f;
        this.u = -999.0f;
        this.v = false;
        this.w = null;
        this.x = 0;
        this.y = 0;
        setId(R.id.qy_splash_contain);
    }

    public final void a(int i) {
        if (this.n == null) {
            return;
        }
        JSONObject jSONObject = this.d;
        String strOptString = jSONObject != null ? jSONObject.optString("closeTitle", "关闭") : "关闭";
        if (this.e == 1) {
            int iCeil = (int) Math.ceil(((double) i) / 1000.0d);
            if (iCeil > 0) {
                this.n.setText((this.c ? new StringBuilder().append(iCeil).append(" ").append(strOptString) : new StringBuilder("").append(iCeil)).toString());
            } else {
                this.n.setText(this.c ? "0 " + strOptString : "0");
            }
        } else {
            this.n.setText(strOptString);
            if (this.e == 2) {
                vg vgVar = this.n;
                vgVar.e = (i * 1.0f) / this.i;
                vgVar.invalidate();
            }
        }
        this.n.setVisibility(0);
    }

    public final hi b(Context context) {
        hi hiVar;
        if (this.g.b()) {
            vi viVar = new vi(context);
            viVar.a(0);
            e eVar = this.g;
            viVar.g.a(eVar.l, eVar.m, eVar.n);
            hiVar = viVar;
        } else {
            zi ziVar = new zi(context);
            ziVar.a(0);
            ziVar.g.b(this.g.i);
            hiVar = ziVar;
        }
        hiVar.e = this;
        return hiVar;
    }

    public final void d() {
        View view;
        int[] iArr;
        View view2;
        hi hiVarA;
        int i;
        String strConcat;
        Context context = getContext();
        boolean z = true;
        if (this.l >= 1.0f) {
            QYImageView2 qYImageView2 = new QYImageView2(context);
            qYImageView2.d();
            qYImageView2.setId(R.id.qy_splash_background);
            qYImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            String strA = n4.a().a(this.f.h(), ImageViewManager.NAME);
            if (TextUtils.isEmpty(strA) || !new File(strA).exists()) {
                qYImageView2.b(this.f.h());
            } else {
                qYImageView2.a(strA);
            }
            addView(qYImageView2, new Constraints.LayoutParams(-1, -1));
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-1, 0);
            ((ConstraintLayout.LayoutParams) layoutParams).topMargin = hk.a(context, 7.0f);
            layoutParams.topToBottom = R.id.qy_splash_title;
            layoutParams.rightToRight = 0;
            layoutParams.leftToLeft = 0;
            layoutParams.dimensionRatio = "H," + this.l + ":1";
            addView(this.m, layoutParams);
            QYImageView2 qYImageView3 = new QYImageView2(context);
            qYImageView3.b(this.f.Q);
            qYImageView3.e();
            qYImageView3.setId(R.id.qy_splash_app_icon);
            Constraints.LayoutParams layoutParams2 = new Constraints.LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 54.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 54.0f) + 0.5f));
            ((ConstraintLayout.LayoutParams) layoutParams2).topMargin = (int) ((context.getResources().getDisplayMetrics().density * 108.0f) + 0.5f);
            layoutParams2.topToTop = 0;
            layoutParams2.rightToRight = 0;
            layoutParams2.leftToLeft = 0;
            addView(qYImageView3, layoutParams2);
            TextView textView = new TextView(context);
            textView.setTextSize(1, 16.0f);
            textView.setTypeface(null, 1);
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setSingleLine(true);
            textView.setText(this.f.P);
            textView.setId(R.id.qy_splash_app_name);
            textView.setShadowLayer(4.0f, 0.0f, 4.0f, 1275068416);
            Constraints.LayoutParams layoutParams3 = new Constraints.LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 150.0f) + 0.5f), -2);
            ((ConstraintLayout.LayoutParams) layoutParams3).topMargin = (int) ((context.getResources().getDisplayMetrics().density * 9.0f) + 0.5f);
            layoutParams3.topToBottom = R.id.qy_splash_app_icon;
            layoutParams3.rightToRight = 0;
            layoutParams3.leftToLeft = 0;
            addView(textView, layoutParams3);
            TextView textView2 = new TextView(context);
            textView2.setTextSize(1, 13.0f);
            textView2.setTypeface(null, 1);
            textView2.setTextColor(ContextCompat.getColor(context, R.color.qy_text_color_white_60alpha));
            textView2.setGravity(17);
            textView2.setMaxLines(2);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setText(this.f.i().optString(BundleKey.TITLE));
            textView2.setId(R.id.qy_splash_title);
            Constraints.LayoutParams layoutParams4 = new Constraints.LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 250.0f) + 0.5f), -2);
            ((ConstraintLayout.LayoutParams) layoutParams4).topMargin = (int) ((context.getResources().getDisplayMetrics().density * 7.0f) + 0.5f);
            layoutParams4.topToBottom = R.id.qy_splash_app_name;
            layoutParams4.rightToRight = 0;
            layoutParams4.leftToLeft = 0;
            addView(textView2, layoutParams4);
        } else {
            Constraints.LayoutParams layoutParams5 = new Constraints.LayoutParams(0, 0);
            layoutParams5.topToTop = 0;
            layoutParams5.bottomToBottom = 0;
            layoutParams5.leftToLeft = 0;
            layoutParams5.rightToRight = 0;
            addView(this.m, layoutParams5);
        }
        View view3 = new View(context);
        view3.setId(R.id.qy_splash_c_background);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{0, -1728053248});
        gradientDrawable.setCornerRadii(new float[8]);
        view3.setBackground(gradientDrawable);
        Constraints.LayoutParams layoutParams6 = new Constraints.LayoutParams(-1, 0);
        layoutParams6.bottomToBottom = 0;
        layoutParams6.topToTop = 0;
        layoutParams6.matchConstraintPercentHeight = 0.5f;
        layoutParams6.verticalBias = 1.0f;
        addView(view3, layoutParams6);
        Context context2 = getContext();
        if (this.h != 0) {
            ImageView imageView = new ImageView(context2);
            imageView.setImageResource(this.h);
            imageView.setScaleType(ImageView.ScaleType.FIT_START);
            imageView.setId(R.id.qy_splash_app_logo);
            Constraints.LayoutParams layoutParams7 = new Constraints.LayoutParams(0, hk.a(context2, 40.0f));
            layoutParams7.topToTop = 0;
            layoutParams7.rightToLeft = R.id.qy_splash_countdown;
            layoutParams7.leftToLeft = R.id.qy_splash_ad_logo;
            ((ConstraintLayout.LayoutParams) layoutParams7).topMargin = (int) ((context2.getResources().getDisplayMetrics().density * 35.0f) + 0.5f);
            addView(imageView, layoutParams7);
        }
        Context context3 = getContext();
        int i2 = this.j;
        if (i2 == 2) {
            QYImageView2 qYImageView4 = new QYImageView2(context3);
            qYImageView4.b("https://pic3.iqiyipic.com/lequ/20260106/76e4a2008d0847f6a197be7749ad0d19.webp");
            qYImageView4.setId(R.id.qy_splash_button);
            qYImageView4.setScaleType(ImageView.ScaleType.FIT_CENTER);
            qYImageView4.setOnTouchListener(this);
            Constraints.LayoutParams layoutParams8 = new Constraints.LayoutParams(hk.a(context3, 321.0f), (int) ((context3.getResources().getDisplayMetrics().density * 187.5f) + 0.5f));
            layoutParams8.leftToLeft = 0;
            layoutParams8.rightToRight = 0;
            layoutParams8.bottomToBottom = 0;
            addView(qYImageView4, layoutParams8);
            if (this.g.a()) {
                hi hiVarB = b(context3);
                boolean zC = this.g.c();
                String str = this.g.b() ? "摇动" : "扭动";
                if (zC) {
                    strConcat = "点击、" + str + "或随意滑动手机";
                } else {
                    strConcat = "点击或".concat(str);
                }
                TextView textView3 = hiVarB.b;
                if (textView3 != null) {
                    textView3.setText(strConcat);
                }
                TextView textView4 = hiVarB.b;
                if (textView4 != null) {
                    textView4.setTextSize(1, 16.0f);
                }
                hiVarB.a("跳转详情页或第三方应用");
                TextView textView5 = hiVarB.c;
                if (textView5 != null) {
                    textView5.setTextSize(1, 13.0f);
                }
                TextView textView6 = hiVarB.c;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                }
                TextView textView7 = hiVarB.c;
                view2 = hiVarB;
                if (textView7 != null) {
                    textView7.setTypeface(null, 0);
                    view2 = hiVarB;
                }
            } else {
                TextView textView8 = new TextView(context3);
                textView8.setText("点击" + (this.g.c() ? "或随意滑动手机\n" : "按钮\n") + "跳转详情页或第三方应用");
                textView8.setMaxLines(2);
                textView8.setLineSpacing(16.0f, 1.0f);
                textView8.setTextSize(1, 16.0f);
                textView8.setTypeface(null, 1);
                textView8.setTextColor(-1);
                textView8.setGravity(17);
                view2 = textView8;
            }
            view2.setId(R.id.qy_splash_button_title);
            Constraints.LayoutParams layoutParams9 = new Constraints.LayoutParams(0, -2);
            int i3 = R.id.qy_splash_button;
            layoutParams9.leftToLeft = i3;
            layoutParams9.rightToRight = i3;
            layoutParams9.bottomToBottom = i3;
            ((ConstraintLayout.LayoutParams) layoutParams9).bottomMargin = (int) ((context3.getResources().getDisplayMetrics().density * 45.0f) + 0.5f);
            addView(view2, layoutParams9);
            if (this.g.c() && (hiVarA = a(context3)) != null) {
                hiVarA.setId(R.id.qy_splash_action_view);
                TextView textView9 = hiVarA.b;
                if (textView9 != null) {
                    i = 8;
                    textView9.setVisibility(8);
                } else {
                    i = 8;
                }
                TextView textView10 = hiVarA.c;
                if (textView10 != null) {
                    textView10.setVisibility(i);
                }
                hiVarA.e = this;
                Constraints.LayoutParams layoutParams10 = new Constraints.LayoutParams(-2, -2);
                layoutParams10.leftToLeft = 0;
                layoutParams10.rightToRight = 0;
                layoutParams10.bottomToTop = R.id.qy_splash_button;
                ((ConstraintLayout.LayoutParams) layoutParams10).bottomMargin = (int) ((context3.getResources().getDisplayMetrics().density * 21.0f) + 0.5f);
                addView(hiVarA, layoutParams10);
            }
        } else if (i2 == 1) {
            int i4 = this.g.q;
            if (i4 == 4 || i4 == 5) {
                hi hiVarB2 = b(context3);
                String str2 = "点击或" + (this.g.b() ? "摇动" : "扭动") + "跳转详情页或第三方应用";
                TextView textView11 = hiVarB2.b;
                if (textView11 != null) {
                    textView11.setText(str2);
                }
                TextView textView12 = hiVarB2.b;
                if (textView12 != null) {
                    textView12.setTextSize(1, 14.0f);
                }
                hiVarB2.setPadding(hk.a(context3, 27.0f), 0, (int) ((context3.getResources().getDisplayMetrics().density * 27.0f) + 0.5f), 0);
                view = hiVarB2;
            } else {
                TextView textView13 = new TextView(context3);
                textView13.setText("点击跳转详情页或第三方应用");
                textView13.setTextSize(1, 14.0f);
                textView13.setPadding(hk.a(context3, 27.0f), 0, (int) ((context3.getResources().getDisplayMetrics().density * 27.0f) + 0.5f), 0);
                textView13.setSingleLine(true);
                textView13.setGravity(17);
                textView13.setEllipsize(TextUtils.TruncateAt.END);
                textView13.setIncludeFontPadding(false);
                textView13.setTextColor(ContextCompat.getColor(context3, R.color.qy_text_color_white_90alpha));
                view = textView13;
            }
            view.setId(R.id.qy_splash_button);
            view.setOnTouchListener(this);
            view.setBackgroundResource(R.drawable.qy_bg_splash_rectify_button);
            ConstraintLayout.LayoutParams layoutParams11 = new ConstraintLayout.LayoutParams(-2, hk.a(context3, 55.0f));
            layoutParams11.leftToLeft = 0;
            layoutParams11.rightToRight = 0;
            layoutParams11.bottomToBottom = 0;
            layoutParams11.bottomMargin = (int) ((context3.getResources().getDisplayMetrics().density * 67.0f) + 0.5f);
            addView(view, layoutParams11);
            hi hiVarA2 = a(context3);
            if (hiVarA2 != null) {
                hiVarA2.setId(R.id.qy_splash_action_view);
                TextView textView14 = hiVarA2.c;
                if (textView14 != null) {
                    textView14.setVisibility(8);
                }
                hiVarA2.e = this;
                Constraints.LayoutParams layoutParams12 = new Constraints.LayoutParams(-2, -2);
                layoutParams12.leftToLeft = 0;
                layoutParams12.rightToRight = 0;
                layoutParams12.bottomToTop = R.id.qy_splash_button;
                ((ConstraintLayout.LayoutParams) layoutParams12).bottomMargin = (int) ((context3.getResources().getDisplayMetrics().density * 21.0f) + 0.5f);
                addView(hiVarA2, layoutParams12);
            }
        } else {
            hi hiVarA3 = a(context3);
            if (hiVarA3 != null) {
                hiVarA3.setId(R.id.qy_splash_action_view);
                hiVarA3.e = this;
                Constraints.LayoutParams layoutParams13 = new Constraints.LayoutParams(-2, -2);
                layoutParams13.leftToLeft = 0;
                layoutParams13.rightToRight = 0;
                layoutParams13.bottomToBottom = 0;
                ((ConstraintLayout.LayoutParams) layoutParams13).bottomMargin = hk.a(context3, 57.5f);
                addView(hiVarA3, layoutParams13);
            }
        }
        if (this.k != 2 || this.g.c()) {
            setOnTouchListener(this);
        }
        jc jcVar = new jc(context2);
        int iOptInt = this.f.H.optInt("needDspIcon", !rd.a() ? 1 : 0);
        p pVar = this.f;
        jcVar.a(iOptInt, pVar.g0, pVar.h0);
        jcVar.setTextSize(1, 10.0f);
        jcVar.setId(R.id.qy_splash_ad_logo);
        Constraints.LayoutParams layoutParams14 = new Constraints.LayoutParams(-2, -2);
        int iA = hk.a(context2, 20.0f);
        ((ConstraintLayout.LayoutParams) layoutParams14).bottomMargin = iA;
        ((ConstraintLayout.LayoutParams) layoutParams14).leftMargin = iA;
        layoutParams14.bottomToBottom = 0;
        layoutParams14.leftToLeft = 0;
        addView(jcVar, layoutParams14);
        if (this.c) {
            Context context4 = getContext();
            vg vgVar = new vg(context4);
            this.n = vgVar;
            vgVar.setText("关闭");
            this.n.setId(R.id.qy_splash_countdown);
            int iA2 = hk.a(getContext(), this.d.optInt("closeTitleSize", 28) / 2.0f);
            if (iA2 > 0) {
                this.n.setTextSize(0, iA2);
            }
            int iA3 = hk.a(getContext(), this.d.optInt("closePaddingLeft", 38) / 2.0f);
            if (iA3 > 0) {
                this.n.setPadding(iA3, 0, iA3, 0);
            }
            e eVar = this.g;
            Constraints.LayoutParams layoutParams15 = new Constraints.LayoutParams(-2, (eVar == null || (iArr = eVar.f) == null || iArr.length <= 1 || iArr[1] <= 0) ? hk.a(getContext(), 40.0f) : hk.a(getContext(), this.g.f[1] / 2.0f));
            e eVar2 = this.g;
            int i5 = eVar2 != null ? eVar2.g : 2;
            int i6 = (int) ((context4.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            boolean z2 = i5 == 3 || i5 == 4;
            if (i5 != 1 && i5 != 4) {
                z = false;
            }
            if (z2) {
                layoutParams15.bottomToBottom = 0;
                layoutParams15.bottomMargin = (int) ((context4.getResources().getDisplayMetrics().density * 84.5f) + 0.5f);
            } else {
                layoutParams15.topToTop = 0;
                layoutParams15.topMargin = (int) ((context4.getResources().getDisplayMetrics().density * 35.0f) + 0.5f);
            }
            if (z) {
                layoutParams15.leftToLeft = 0;
                layoutParams15.leftMargin = i6;
            } else {
                layoutParams15.rightToRight = 0;
                layoutParams15.rightMargin = i6;
            }
            addView(this.n, layoutParams15);
            vg vgVar2 = (vg) findViewById(R.id.qy_splash_countdown);
            this.n = vgVar2;
            vgVar2.setOnTouchListener(this);
        }
        a(this.i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.r = motionEvent.getX();
            this.s = motionEvent.getY();
            this.t = motionEvent.getRawX();
            this.u = motionEvent.getRawY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.support.constraint.ConstraintLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        View view;
        int i3;
        int i4;
        int i5;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (size == 0 || size2 == 0) {
            return;
        }
        if ((this.v && size == this.x && size2 == this.y) || (view = this.m) == null) {
            return;
        }
        float f = this.l;
        if (f <= 0.0f || f >= 1.0f) {
            return;
        }
        float f2 = size2;
        float f3 = size;
        float f4 = f2 / f3;
        boolean z = view instanceof ImageView;
        if (!(view instanceof a0)) {
            if (z) {
                if (f4 < 1.7777778f) {
                    ((ImageView) view).setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    ((ImageView) view).setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                this.x = size;
                this.y = size2;
                this.v = true;
                return;
            }
            return;
        }
        if (this.w == null) {
            this.w = new ConstraintSet();
        }
        this.w.clone(this);
        int id = this.m.getId();
        if (f4 < 1.7777778f) {
            this.w.constrainWidth(id, (int) (this.l * f2));
            this.w.constrainHeight(id, size2);
            i5 = (int) (f2 * this.l);
            i4 = size2;
        } else {
            float f5 = this.l;
            float f6 = f3 / f5;
            float f7 = f5 * f2;
            if (f6 > f2) {
                i4 = (int) f6;
                i3 = size;
            } else {
                i3 = (int) f7;
                i4 = size2;
            }
            this.w.constrainWidth(id, i3);
            this.w.constrainHeight(id, i4);
            i5 = i3;
        }
        this.w.applyTo(this);
        if (this.m.isAttachedToWindow()) {
            View view2 = this.m;
            if ((view2 instanceof a0) && i5 > 0 && i4 > 0) {
                ((a0) view2).getHolder().setFixedSize(i5, i4);
            }
        }
        this.x = size;
        this.y = size2;
        this.v = true;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.b < 500) {
            return true;
        }
        if (!this.c || view != this.n) {
            int id = view.getId();
            if (id != R.id.qy_splash_button && this.k == 2 && (id != R.id.qy_splash_contain || motionEvent.getAction() != 1 || PointF.length(motionEvent.getX() - this.r, motionEvent.getY() - this.s) <= hk.a(getContext(), this.g.r))) {
                return true;
            }
            this.b = jCurrentTimeMillis;
            a4 a4Var = new a4();
            a4Var.a = view;
            a4Var.e = gj.a(view);
            a4Var.b = z3.GRAPHIC;
            a4 a4VarA = a4Var.a(this.t, this.u);
            float f = this.r;
            float f2 = this.s;
            a4VarA.h = f;
            a4VarA.i = f2;
            a4VarA.j = f;
            a4VarA.k = f2;
            b4 b4Var = new b4(a4VarA);
            this.q = true;
            li liVar = this.o;
            if (liVar != null) {
                pi.a(liVar.a, b4Var);
            }
            return true;
        }
        this.b = jCurrentTimeMillis;
        if (this.q || this.p >= 100 || gj.a(view, motionEvent.getX(), motionEvent.getY(), this.p)) {
            a4 a4Var2 = new a4();
            a4Var2.a = view;
            a4Var2.b = z3.CLOSE;
            b4 b4Var2 = new b4(a4Var2);
            this.q = true;
            li liVar2 = this.o;
            if (liVar2 != null) {
                pi.a(liVar2.a, b4Var2);
            }
            return true;
        }
        a4 a4Var3 = new a4();
        a4Var3.a = view;
        a4Var3.e = gj.a(view);
        a4Var3.b = z3.CLOSE_ACT;
        a4 a4VarA2 = a4Var3.a(this.t, this.u);
        float f3 = this.r;
        float f4 = this.s;
        a4VarA2.h = f3;
        a4VarA2.i = f4;
        a4VarA2.j = f3;
        a4VarA2.k = f4;
        b4 b4Var3 = new b4(a4VarA2);
        this.q = true;
        li liVar3 = this.o;
        if (liVar3 != null) {
            pi.a(liVar3.a, b4Var3);
        }
        return true;
    }

    @Override // com.mcto.sspsdk.internal.sc
    public final void b() {
    }

    public final hi a(Context context) {
        if (this.g.c()) {
            yi yiVar = new yi(context);
            LayoutInflater.from(yiVar.getContext()).inflate(R.layout.qy_layout_splash_slide, (ViewGroup) yiVar, true);
            ImageView imageView = (ImageView) yiVar.findViewById(R.id.qy_splash_action_icon);
            yiVar.d = imageView;
            qk.a(imageView, R.drawable.qy_lg_slide2);
            yiVar.b = (TextView) yiVar.findViewById(R.id.qy_splash_action_title);
            yiVar.c = (TextView) yiVar.findViewById(R.id.qy_splash_action_sub_title);
            return yiVar;
        }
        if (this.g.b()) {
            xi xiVar = new xi(context);
            xiVar.a(0);
            e eVar = this.g;
            xiVar.g.a(eVar.l, eVar.m, eVar.n);
            return xiVar;
        }
        int i = this.g.q;
        if (i != 2 && i != 5) {
            return null;
        }
        bj bjVar = new bj(context);
        bjVar.a(0);
        bjVar.g.b(this.g.i);
        return bjVar;
    }

    @Override // com.mcto.sspsdk.internal.sc
    public final void a() {
    }

    @Override // com.mcto.sspsdk.internal.gi
    public final void a(b4 b4Var) {
        this.q = true;
        li liVar = this.o;
        if (liVar != null) {
            pi.a(liVar.a, b4Var);
        }
    }
}
