package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.UgenLottieView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar2;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.text.DecimalFormat;
import java.util.Stack;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends AlertDialog {
    private TextView ab;
    private ImageView ah;
    private TextView ao;
    private String b;
    private TextView c;
    private TTRatingBar2 ch;
    private RelativeLayout cv;
    private TTRoundRectImageView d;
    private View g;
    private Button h;
    private TextView hi;
    private String i;
    private TextView ka;
    private float le;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected Context f3695ms;
    private String nw;
    private LinearLayout ny;
    private ms of;
    private JSONArray op;
    private String p;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xr qv;
    private String re;
    private TextView sl;
    private String t;
    private TextView u;
    private TextView ub;
    private String w;
    private LinearLayout x;
    Stack<View> xr;
    private String y;
    private String yu;
    private TextView zb;

    public interface ms {
        void ah(Dialog dialog);

        void c(Dialog dialog);

        void d(Dialog dialog);

        void ka(Dialog dialog);

        void ms(Dialog dialog);

        void xr(Dialog dialog);
    }

    public ah(Context context) {
        super(context, t.ab(context, "tt_dialog_full"));
        this.xr = new Stack<>();
        this.f3695ms = context;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ms();
        setCanceledOnTouchOutside(false);
        xr();
    }

    public void ms() {
        if (this.f3695ms == null) {
            this.f3695ms = re.getContext();
        }
        if (this.f3695ms.getResources().getConfiguration().orientation == 1) {
            this.g = ms(1);
        } else {
            this.g = ms(0);
        }
        setContentView(this.g);
    }

    private View ms(int i) {
        int iAh;
        LinearLayout linearLayoutXr = xr(i);
        LinearLayout linearLayout = new LinearLayout(this.f3695ms);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (i == 0) {
            iAh = ul.ah(this.f3695ms, 40.0f);
        } else {
            layoutParams.addRule(3, c().getId());
            iAh = ul.ah(this.f3695ms, 16.0f);
        }
        layoutParams.leftMargin = iAh;
        layoutParams.rightMargin = iAh;
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        this.cv.addView(linearLayout);
        this.d = new TTRoundRectImageView(this.f3695ms);
        int iAh2 = ul.ah(this.f3695ms, 64.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iAh2, iAh2);
        layoutParams2.gravity = 1;
        if (i == 0) {
            layoutParams2.topMargin = ul.ah(this.f3695ms, 40.0f);
        } else {
            layoutParams2.topMargin = ul.ah(this.f3695ms, 36.0f);
        }
        this.d.setMaxHeight(iAh2);
        this.d.setMaxWidth(iAh2);
        this.d.setMinimumHeight(iAh2);
        this.d.setMinimumWidth(iAh2);
        this.d.setLayoutParams(layoutParams2);
        linearLayout.addView(this.d);
        return ms(i, linearLayoutXr, linearLayout, iAh);
    }

    private LinearLayout ms(int i, LinearLayout linearLayout, LinearLayout linearLayout2, int i2) {
        this.ka = new TextView(this.f3695ms);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        if (i == 0) {
            layoutParams.topMargin = ul.ah(this.f3695ms, 16.0f);
            int iAh = ul.ah(this.f3695ms, 25.0f);
            layoutParams.leftMargin = iAh;
            layoutParams.rightMargin = iAh;
        } else {
            layoutParams.topMargin = ul.ah(this.f3695ms, 14.0f);
        }
        this.ka.setLayoutParams(layoutParams);
        this.ka.setEllipsize(TextUtils.TruncateAt.END);
        this.ka.setTextColor(Color.parseColor("#161823"));
        this.ka.setTextSize(18.0f);
        this.ka.setGravity(17);
        this.ka.setTypeface(null, 1);
        linearLayout2.addView(this.ka);
        this.c = new TextView(this.f3695ms);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = ul.ah(this.f3695ms, 5.0f);
        this.c.setLayoutParams(layoutParams2);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        this.c.setSingleLine(true);
        this.c.setAlpha(0.5f);
        this.c.setTextColor(Color.parseColor("#161823"));
        this.c.setTextSize(14.0f);
        this.c.setGravity(17);
        linearLayout2.addView(this.c);
        return xr(i, linearLayout, linearLayout2, i2);
    }

    private LinearLayout xr(int i, LinearLayout linearLayout, LinearLayout linearLayout2, int i2) {
        this.x = new LinearLayout(this.f3695ms);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = ul.ah(this.f3695ms, 10.0f);
        this.x.setLayoutParams(layoutParams);
        this.x.setOrientation(0);
        linearLayout2.addView(this.x);
        this.ny = new LinearLayout(this.f3695ms);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = ul.ah(this.f3695ms, 10.0f);
        if (i == 0) {
            layoutParams2.topMargin = ul.ah(this.f3695ms, 16.0f);
        } else {
            layoutParams2.topMargin = ul.ah(this.f3695ms, 10.0f);
        }
        this.ny.setLayoutParams(layoutParams2);
        this.ny.setOrientation(0);
        this.ch = new TTRatingBar2(this.f3695ms, null);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        this.ch.setLayoutParams(layoutParams3);
        this.ny.addView(this.ch);
        this.hi = new TextView(this.f3695ms);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = ul.ah(this.f3695ms, 3.0f);
        this.hi.setTextSize(16.0f);
        this.hi.setTextColor(Color.parseColor("#161823"));
        this.hi.setLayoutParams(layoutParams4);
        this.ny.addView(this.hi);
        linearLayout2.addView(this.ny);
        return ms(i, linearLayout, i2);
    }

    private LinearLayout ms(int i, LinearLayout linearLayout, int i2) {
        Button button = new Button(this.f3695ms);
        this.h = button;
        button.setId(View.generateViewId());
        LinearLayout linearLayout2 = new LinearLayout(this.f3695ms);
        linearLayout2.setId(View.generateViewId());
        View view = new View(this.f3695ms);
        view.setId(View.generateViewId());
        TextView textView = new TextView(this.f3695ms);
        this.zb = textView;
        textView.setId(View.generateViewId());
        if (i == 1) {
            ms(i, this.cv);
        } else {
            ms(ul.ah(this.f3695ms, 89.0f), i);
        }
        return ms(i, linearLayout, i2, linearLayout2, view);
    }

    private LinearLayout ms(int i, LinearLayout linearLayout, int i2, LinearLayout linearLayout2, View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(2, linearLayout2.getId());
        if (i == 1) {
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
        } else {
            int iAh = ul.ah(this.f3695ms, 16.0f);
            layoutParams.leftMargin = iAh;
            layoutParams.rightMargin = iAh;
        }
        layoutParams.topMargin = ul.ah(this.f3695ms, 3.0f);
        this.zb.setEllipsize(TextUtils.TruncateAt.END);
        this.zb.setGravity(17);
        this.zb.setTextColor(Color.parseColor("#4D161823"));
        if (i == 0) {
            this.zb.setTextSize(10.0f);
        } else {
            this.zb.setTextSize(12.0f);
        }
        this.zb.setLayoutParams(layoutParams);
        this.cv.addView(this.zb);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.leftMargin = i2;
        layoutParams2.rightMargin = i2;
        if (i == 1) {
            layoutParams2.topMargin = ul.ah(this.f3695ms, 9.0f);
        } else {
            layoutParams2.topMargin = ul.ah(this.f3695ms, 2.0f);
            layoutParams2.bottomMargin = ul.ah(this.f3695ms, 20.0f);
        }
        if (i == 1) {
            layoutParams2.addRule(2, view.getId());
        } else {
            layoutParams2.addRule(12);
            layoutParams2.addRule(14);
        }
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setGravity(1);
        return xr(i, linearLayout, i2, linearLayout2, view);
    }

    private LinearLayout xr(int i, LinearLayout linearLayout, int i2, LinearLayout linearLayout2, View view) {
        if (i == 0) {
            ms(i, (ViewGroup) linearLayout2);
            if (!TextUtils.isEmpty(this.re)) {
                ImageView imageView = new ImageView(this.f3695ms);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ul.ah(this.f3695ms, 0.5f), ul.ah(this.f3695ms, 9.0f));
                layoutParams.leftMargin = ul.ah(this.f3695ms, 8.0f);
                layoutParams.gravity = 17;
                imageView.setLayoutParams(layoutParams);
                imageView.setBackgroundColor(Color.parseColor("#D8D8D8"));
                linearLayout2.addView(imageView);
            }
        }
        int iAh = ul.ah(this.f3695ms, 8.0f);
        ms(linearLayout2, iAh);
        xr(linearLayout2, iAh);
        return ms(i, linearLayout, i2, linearLayout2, view, iAh);
    }

    private void ms(LinearLayout linearLayout, int i) {
        this.ao = new TextView(this.f3695ms);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.ao.setLayoutParams(layoutParams);
        this.ao.setAlpha(0.75f);
        this.ao.setTextColor(Color.parseColor("#66161823"));
        if (this.f3695ms.getResources().getConfiguration().orientation == 2) {
            this.ao.setTextSize(10.0f);
        } else {
            this.ao.setTextSize(12.0f);
        }
        this.ao.setText("功能");
        linearLayout.addView(this.ao);
    }

    private void xr(LinearLayout linearLayout, int i) {
        linearLayout.addView(ka());
        this.ab = new TextView(this.f3695ms);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.ab.setLayoutParams(layoutParams);
        this.ab.setAlpha(0.75f);
        this.ab.setTextColor(Color.parseColor("#66161823"));
        if (this.f3695ms.getResources().getConfiguration().orientation == 2) {
            this.ab.setTextSize(10.0f);
        } else {
            this.ab.setTextSize(12.0f);
        }
        this.ab.setText("权限");
        linearLayout.addView(this.ab);
    }

    private ImageView ka() {
        ImageView imageView = new ImageView(this.f3695ms);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ul.ah(this.f3695ms, 0.5f), ul.ah(this.f3695ms, 9.0f));
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundColor(Color.parseColor("#D8D8D8"));
        return imageView;
    }

    private LinearLayout ms(int i, LinearLayout linearLayout, int i2, LinearLayout linearLayout2, View view, int i3) {
        linearLayout2.addView(ka());
        this.u = new TextView(this.f3695ms);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i3;
        layoutParams.rightMargin = i3;
        this.u.setLayoutParams(layoutParams);
        this.u.setAlpha(0.75f);
        this.u.setTextColor(Color.parseColor("#66161823"));
        if (this.f3695ms.getResources().getConfiguration().orientation == 2) {
            this.u.setTextSize(10.0f);
        } else {
            this.u.setTextSize(12.0f);
        }
        this.u.setText("隐私");
        linearLayout2.addView(this.u);
        if (!TextUtils.isEmpty(this.i)) {
            linearLayout2.addView(ka());
            this.ub = new TextView(this.f3695ms);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = i3;
            layoutParams2.rightMargin = i3;
            this.ub.setLayoutParams(layoutParams2);
            this.ub.setAlpha(0.75f);
            this.ub.setTextColor(Color.parseColor("#66161823"));
            if (this.f3695ms.getResources().getConfiguration().orientation == 2) {
                this.ub.setTextSize(10.0f);
            } else {
                this.ub.setTextSize(12.0f);
            }
            this.ub.setText("备案");
            linearLayout2.addView(this.ub);
        }
        this.cv.addView(linearLayout2);
        if (i == 0) {
            return linearLayout;
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, ul.ah(this.f3695ms, 1.0f));
        layoutParams3.topMargin = ul.ah(this.f3695ms, 12.0f);
        layoutParams3.addRule(2, this.h.getId());
        view.setLayoutParams(layoutParams3);
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        this.cv.addView(view);
        ms(i2, i);
        return linearLayout;
    }

    private LinearLayout xr(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.f3695ms);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(Color.parseColor("#99000000"));
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.f3695ms);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        this.cv = new RelativeLayout(this.f3695ms);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(ul.ah(this.f3695ms, 8.0f));
        this.cv.setBackground(gradientDrawable);
        this.cv.setLayoutParams(layoutParams2);
        linearLayout.addView(this.cv);
        return ms(i, linearLayout);
    }

    private LinearLayout ms(int i, LinearLayout linearLayout) {
        if (i == 0) {
            this.ah = new ImageView(this.f3695ms);
            int iAh = ul.ah(this.f3695ms, 28.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iAh, iAh);
            int iAh2 = ul.ah(this.f3695ms, 36.0f);
            layoutParams.topMargin = iAh2;
            layoutParams.rightMargin = iAh2;
            layoutParams.leftMargin = iAh2;
            layoutParams.bottomMargin = iAh2;
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.addRule(11);
            this.ah.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.ah.setLayoutParams(layoutParams);
            this.ah.setMaxHeight(iAh);
            this.ah.setMaxWidth(iAh);
            this.ah.setMinimumHeight(iAh);
            this.ah.setMinimumWidth(iAh);
            com.bytedance.sdk.openadsdk.res.xr xrVar = new com.bytedance.sdk.openadsdk.res.xr(ul.ah(this.f3695ms, 28.0f));
            xrVar.ms(Color.parseColor("#66161823"));
            float fAh = ul.ah(this.f3695ms, 2.0f);
            xrVar.ms(fAh);
            com.bytedance.sdk.openadsdk.res.ah ahVar = new com.bytedance.sdk.openadsdk.res.ah(ul.ah(this.f3695ms, 12.0f));
            ahVar.ms(-1);
            ahVar.ms(fAh);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{xrVar, ahVar});
            layerDrawable.setLayerInset(0, 0, 0, 0, 0);
            int iAh3 = ul.ah(this.f3695ms, 8.0f);
            layerDrawable.setLayerInset(1, iAh3, iAh3, iAh3, iAh3);
            this.ah.setImageDrawable(layerDrawable);
            this.cv.addView(this.ah);
        }
        return linearLayout;
    }

    private void ms(int i, ViewGroup viewGroup) {
        this.sl = new TextView(this.f3695ms);
        if (i == 1) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(2, this.zb.getId());
            int iAh = ul.ah(this.f3695ms, 16.0f);
            layoutParams.leftMargin = iAh;
            layoutParams.rightMargin = iAh;
            layoutParams.topMargin = ul.ah(this.f3695ms, 30.0f);
            this.sl.setLayoutParams(layoutParams);
            this.sl.setGravity(17);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = GravityCompat.START;
            this.sl.setLayoutParams(layoutParams2);
        }
        this.sl.setEllipsize(TextUtils.TruncateAt.END);
        this.sl.setTextColor(Color.parseColor("#57161823"));
        if (i == 0) {
            this.sl.setTextSize(10.0f);
        } else {
            this.sl.setTextSize(12.0f);
        }
        viewGroup.addView(this.sl);
    }

    private void ms(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        if (i2 == 1) {
            layoutParams.topMargin = ul.ah(this.f3695ms, 14.0f);
            layoutParams.bottomMargin = ul.ah(this.f3695ms, 46.0f);
            layoutParams.addRule(12);
        } else {
            layoutParams.topMargin = ul.ah(this.f3695ms, 10.0f);
            layoutParams.bottomMargin = ul.ah(this.f3695ms, 24.0f);
            layoutParams.addRule(2, this.zb.getId());
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(ul.ah(this.f3695ms, 3.0f));
        this.h.setBackground(gradientDrawable);
        this.h.setGravity(17);
        this.h.setText("立即下载");
        int iAh = ul.ah(this.f3695ms, 13.0f);
        this.h.setPadding(0, iAh, 0, iAh);
        this.h.setTextColor(-1);
        this.h.setLayoutParams(layoutParams);
        this.h.setTextSize(15.0f);
        this.cv.addView(this.h);
        if (i2 != 1 || TextUtils.isEmpty(this.yu)) {
            return;
        }
        int iAh2 = ul.ah(this.f3695ms, 60.0f);
        com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xr xrVar = new com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xr(this.f3695ms);
        this.qv = xrVar;
        xrVar.ms("src", this.yu);
        this.qv.ms("loop", "true");
        this.qv.ms("autoPlay", "true");
        this.qv.ms("width", String.valueOf(iAh2));
        this.qv.ms("height", String.valueOf(iAh2));
        this.qv.ms("scaleType", "fitXY");
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iAh2, iAh2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, this.h.getId());
        layoutParams2.rightMargin = ul.ah(this.f3695ms, 73.0f);
        layoutParams2.topMargin = -ul.ah(this.f3695ms, 85.0f);
        this.qv.ms(layoutParams2);
        UgenLottieView ugenLottieViewNy = this.qv.ny();
        if (ugenLottieViewNy == null) {
            return;
        }
        this.qv.xr();
        this.cv.addView(ugenLottieViewNy);
    }

    private View c() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f3695ms);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        relativeLayout.setId(View.generateViewId());
        ImageView imageView = new ImageView(this.f3695ms);
        this.ah = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int iAh = ul.ah(this.f3695ms, 46.0f);
        this.ah.setMaxHeight(iAh);
        this.ah.setMaxWidth(iAh);
        this.ah.setMinimumHeight(iAh);
        this.ah.setMinimumWidth(iAh);
        com.bytedance.sdk.openadsdk.res.ah ahVar = new com.bytedance.sdk.openadsdk.res.ah(ul.ah(this.f3695ms, 14.0f));
        ahVar.ms(ViewCompat.MEASURED_STATE_MASK);
        ahVar.ms(ul.ah(this.f3695ms, 2.0f));
        this.ah.setImageDrawable(ahVar);
        relativeLayout.addView(this.ah);
        TextView textView = new TextView(this.f3695ms);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("应用详情");
        textView.setLayoutParams(layoutParams);
        relativeLayout.addView(textView);
        this.cv.addView(relativeLayout);
        return ms(relativeLayout);
    }

    private View ms(RelativeLayout relativeLayout) {
        View view = new View(this.f3695ms);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ul.ah(this.f3695ms, 1.0f));
        layoutParams.addRule(3, relativeLayout.getId());
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        view.setId(View.generateViewId());
        this.cv.addView(view);
        return view;
    }

    protected void xr() {
        if (this.f3695ms == null) {
            this.f3695ms = re.getContext();
        }
        this.xr.clear();
        this.xr.push(this.d);
        this.xr.push(this.ka);
        this.xr.push(this.c);
        this.xr.push(this.x);
        this.xr.push(this.ny);
        ab();
        this.ao.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ah.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ah.this.of == null) {
                    return;
                }
                ah.this.of.ka(ah.this);
            }
        });
        if (this.ub != null && !TextUtils.isEmpty(this.i)) {
            this.ub.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ah.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ah.this.of != null) {
                        ah.this.of.c(ah.this);
                    }
                }
            });
        }
        this.ab.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ah.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ah.this.of != null) {
                    ah.this.of.xr(ah.this);
                }
            }
        });
        this.ah.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ah.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ah.this.of != null) {
                    ah.this.of.ah(ah.this);
                }
            }
        });
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ah.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ah.this.of != null) {
                    ah.this.of.d(ah.this);
                }
            }
        });
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ah.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ah.this.of != null) {
                    ah.this.of.ms(ah.this);
                }
            }
        });
    }

    private void ab() {
        RelativeLayout relativeLayout;
        if (this.g == null || (relativeLayout = this.cv) == null) {
            return;
        }
        final int childCount = relativeLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.cv.getChildAt(i).setVisibility(4);
        }
        this.g.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.ah.7
            @Override // java.lang.Runnable
            public void run() {
                ah.this.ah(childCount);
            }
        }, 10L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(int i) {
        try {
            Rect rect = new Rect();
            if (this.f3695ms.getResources().getConfiguration().orientation == 1) {
                this.sl.getGlobalVisibleRect(rect);
            } else {
                this.h.getGlobalVisibleRect(rect);
            }
            while (!this.xr.isEmpty()) {
                Rect rect2 = new Rect();
                View viewPop = this.xr.pop();
                if (viewPop != null && viewPop.getVisibility() != 8) {
                    viewPop.getGlobalVisibleRect(rect2);
                    if (rect2.top != 0 && rect.top >= rect2.bottom) {
                        break;
                    }
                    if (viewPop == this.ka) {
                        View viewPop2 = this.xr.pop();
                        if (viewPop2 != null) {
                            viewPop2.setVisibility(8);
                        }
                    } else {
                        viewPop.setVisibility(8);
                    }
                }
            }
            if (this.xr.isEmpty()) {
                x();
            }
        } catch (Throwable unused) {
        }
        this.cv.setVisibility(0);
        for (int i2 = 0; i2 < i; i2++) {
            this.cv.getChildAt(i2).setVisibility(0);
        }
    }

    private void x() {
        RelativeLayout.LayoutParams layoutParams;
        Button button = this.h;
        if (button != null) {
            ViewGroup.LayoutParams layoutParams2 = button.getLayoutParams();
            if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
                layoutParams3.bottomMargin = layoutParams3.topMargin;
                this.h.setLayoutParams(layoutParams3);
            } else if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams2;
                layoutParams4.bottomMargin = layoutParams4.topMargin;
                this.h.setLayoutParams(layoutParams4);
            }
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xr xrVar = this.qv;
        if (xrVar != null) {
            UgenLottieView ugenLottieViewNy = xrVar.ny();
            if (ugenLottieViewNy != null) {
                layoutParams = (RelativeLayout.LayoutParams) ugenLottieViewNy.getLayoutParams();
            } else {
                int iAh = ul.ah(this.f3695ms, 60.0f);
                layoutParams = new RelativeLayout.LayoutParams(iAh, iAh);
            }
            layoutParams.topMargin = -ul.ah(this.f3695ms, 53.0f);
            this.qv.ms(layoutParams);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        ms msVar = this.of;
        if (msVar != null) {
            msVar.ah(this);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        ah();
    }

    protected void ah() {
        String str;
        int iD;
        if (this.f3695ms == null) {
            this.f3695ms = re.getContext();
        }
        int i = this.f3695ms.getResources().getConfiguration().orientation;
        TextView textView = this.ka;
        if (textView != null) {
            textView.setText(this.y);
        } else {
            TTRoundRectImageView tTRoundRectImageView = this.d;
            if (tTRoundRectImageView != null) {
                tTRoundRectImageView.setVisibility(8);
            }
        }
        if (this.d != null && !TextUtils.isEmpty(this.t)) {
            com.bytedance.sdk.openadsdk.x.xr.ms(this.t).ms(this.d);
        } else {
            TTRoundRectImageView tTRoundRectImageView2 = this.d;
            if (tTRoundRectImageView2 != null) {
                tTRoundRectImageView2.setVisibility(8);
            }
        }
        if (this.c != null) {
            if (TextUtils.isEmpty(this.nw)) {
                this.c.setVisibility(8);
            } else {
                this.c.setText(this.nw);
            }
        }
        if (this.x != null) {
            JSONArray jSONArray = this.op;
            if (jSONArray == null || jSONArray.length() <= 0) {
                this.x.setVisibility(8);
            } else {
                WindowManager windowManager = (WindowManager) this.f3695ms.getSystemService("window");
                Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
                if (defaultDisplay != null) {
                    int width = defaultDisplay.getWidth();
                    if (width > defaultDisplay.getHeight()) {
                        double d = ul.d(this.f3695ms, width);
                        iD = ((int) (d - (0.38d * d))) - 80;
                    } else {
                        iD = ul.d(this.f3695ms, width) - 36;
                    }
                } else {
                    iD = 0;
                }
                int length = this.op.length() <= 3 ? this.op.length() : 3;
                for (int i2 = 0; i2 < length; i2++) {
                    String strOptString = this.op.optString(i2);
                    if (!TextUtils.isEmpty(strOptString)) {
                        TextView textView2 = new TextView(this.f3695ms);
                        textView2.setText(strOptString);
                        textView2.setTextSize(12.0f);
                        textView2.setTextColor(Color.parseColor("#161823"));
                        textView2.setAlpha(0.75f);
                        textView2.setBackgroundColor(Color.parseColor("#0F161823"));
                        int iAh = ul.ah(this.f3695ms, 6.0f);
                        textView2.setPadding(iAh, 0, iAh, 0);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        int iAh2 = ul.ah(this.f3695ms, 3.0f);
                        layoutParams.leftMargin = iAh2;
                        layoutParams.rightMargin = iAh2;
                        textView2.setLayoutParams(layoutParams);
                        TextPaint paint = textView2.getPaint();
                        Rect rect = new Rect();
                        paint.getTextBounds(strOptString, 0, strOptString.length(), rect);
                        iD -= ul.d(this.f3695ms, rect.width()) + 20;
                        if (iD >= 0) {
                            this.x.addView(textView2);
                        } else {
                            if (this.x.getChildCount() > 0) {
                                break;
                            }
                            this.x.setVisibility(8);
                            break;
                        }
                    }
                }
            }
        }
        if (this.ch != null && this.hi != null) {
            float f = this.le;
            if (f <= 0.0f) {
                LinearLayout linearLayout = this.ny;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                this.ch.setVisibility(8);
                this.hi.setVisibility(8);
            } else {
                if (f > 5.0f) {
                    f = 5.0f;
                }
                this.le = f;
                this.hi.setText(new DecimalFormat(".0").format(this.le));
                this.ch.setRating(this.le);
                this.ch.ms(ul.ah(this.f3695ms, 16.0f), ul.ah(this.f3695ms, 15.0f));
                this.ch.ms(ul.ah(this.f3695ms, 3.0f), 0, ul.ah(this.f3695ms, 3.0f), 0);
                this.ch.ms();
            }
        }
        if (this.sl != null) {
            str = TextUtils.isEmpty(this.b) ? String.format("版本号：%1$s", "暂无") : String.format("版本号：%1$s", this.b);
            if (i == 2) {
                TextPaint paint2 = this.sl.getPaint();
                Rect rect2 = new Rect();
                paint2.getTextBounds(str, 0, str.length(), rect2);
                double dCh = ul.ch(this.f3695ms);
                int iWidth = (((int) (dCh - (0.4d * dCh))) - rect2.width()) - ul.ah(this.f3695ms, 106.0f);
                TextView textView3 = this.u;
                if (textView3 != null) {
                    TextPaint paint3 = textView3.getPaint();
                    String string = this.u.getText().toString();
                    paint3.getTextBounds(string, 0, string.length(), rect2);
                    iWidth -= rect2.width();
                }
                TextView textView4 = this.ab;
                if (textView4 != null) {
                    TextPaint paint4 = textView4.getPaint();
                    String string2 = this.ab.getText().toString();
                    paint4.getTextBounds(string2, 0, string2.length(), rect2);
                    iWidth -= rect2.width();
                }
                TextView textView5 = this.ao;
                if (textView5 != null) {
                    TextPaint paint5 = textView5.getPaint();
                    String string3 = this.ao.getText().toString();
                    paint5.getTextBounds(string3, 0, string3.length(), rect2);
                    iWidth -= rect2.width();
                }
                if (this.ub != null && !TextUtils.isEmpty(this.i)) {
                    TextPaint paint6 = this.ub.getPaint();
                    String string4 = this.ub.getText().toString();
                    paint6.getTextBounds(string4, 0, TextUtils.isEmpty(string4) ? 0 : string4.length(), rect2);
                    iWidth -= rect2.width();
                }
                if (iWidth <= 0) {
                    ((LinearLayout.LayoutParams) this.sl.getLayoutParams()).weight = 1.0f;
                }
            }
            if (i == 1) {
                this.sl.setText(str);
            }
        } else {
            str = "";
        }
        TextView textView6 = this.zb;
        if (textView6 != null) {
            textView6.setSelected(true);
            String str2 = TextUtils.isEmpty(this.w) ? String.format("开发者：%1$s", "补充中，可于应用官网查看") : String.format("开发者：%1$s", this.w);
            if (i == 2) {
                str2 = str2 + "  " + str;
            }
            this.zb.setText(str2);
        }
    }

    public ah ms(String str) {
        this.y = str;
        return this;
    }

    public ah xr(String str) {
        this.t = str;
        return this;
    }

    public ah ah(String str) {
        this.yu = str;
        return this;
    }

    public ah d(String str) {
        this.nw = str;
        return this;
    }

    public ah ka(String str) {
        this.b = str;
        return this;
    }

    public ah c(String str) {
        this.re = str;
        return this;
    }

    public ah ab(String str) {
        this.i = str;
        return this;
    }

    public ah x(String str) {
        this.w = str;
        return this;
    }

    public ah ms(JSONArray jSONArray) {
        this.op = jSONArray;
        return this;
    }

    public ah ms(float f) {
        this.le = f;
        return this;
    }

    public ah ms(ms msVar) {
        this.of = msVar;
        return this;
    }

    public String d() {
        return this.p;
    }

    public ah ny(String str) {
        this.p = str;
        return this;
    }
}
