package com.byazt.nc;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
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
import com.byazt.pi.TTRatingBar2;
import com.byazt.pi.TTRoundRectImageView;
import com.byazt.qs.UgenLottieView;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import java.text.DecimalFormat;
import java.util.Stack;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 52, 20})
public class hn extends AlertDialog {
    public String a;
    public LinearLayout aj;
    public String b;
    public TextView c;
    public String cz;
    public String fo;
    public TextView fw;
    public TextView g;
    public RelativeLayout gz;
    public ImageView hn;
    public TextView ho;
    public Stack<View> hw;
    public JSONArray iu;
    public TextView k;
    public com.byazt.qs.hw lb;
    public TextView m;
    public View nl;
    public TextView nt;
    public String ny;
    public Context pr;
    public String qa;
    public String rc;
    public TextView uc;
    public float ve;
    public TTRatingBar2 vk;
    public TextView w;
    public String ww;
    public TTRoundRectImageView x;
    public pr y;
    public Button yb;
    public String z;
    public LinearLayout zo;

    public interface pr {
        void c(Dialog dialog);

        void hn(Dialog dialog);

        void hw(Dialog dialog);

        void pr(Dialog dialog);

        void uc(Dialog dialog);

        void x(Dialog dialog);
    }

    public hn(Context context) {
        super(context);
        this.hw = new Stack<>();
        this.pr = context;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.sdv.uc.hw(this);
        pr();
        setCanceledOnTouchOutside(false);
        hw();
    }

    public void pr() {
        if (this.pr == null) {
            this.pr = a.getContext();
        }
        if (this.pr.getResources().getConfiguration().orientation == 1) {
            this.nl = pr(1);
        } else {
            this.nl = pr(0);
        }
        setContentView(this.nl);
    }

    private View pr(int i) {
        int iHn;
        LinearLayout linearLayoutHw = hw(i);
        LinearLayout linearLayout = new LinearLayout(this.pr);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (i == 0) {
            iHn = er.hn(this.pr, 40.0f);
        } else {
            layoutParams.addRule(3, uc().getId());
            iHn = er.hn(this.pr, 16.0f);
        }
        layoutParams.leftMargin = iHn;
        layoutParams.rightMargin = iHn;
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        this.gz.addView(linearLayout);
        this.x = new TTRoundRectImageView(this.pr);
        int iHn2 = er.hn(this.pr, 64.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iHn2, iHn2);
        layoutParams2.gravity = 1;
        if (i == 0) {
            layoutParams2.topMargin = er.hn(this.pr, 40.0f);
        } else {
            layoutParams2.topMargin = er.hn(this.pr, 36.0f);
        }
        this.x.setMaxHeight(iHn2);
        this.x.setMaxWidth(iHn2);
        this.x.setMinimumHeight(iHn2);
        this.x.setMinimumWidth(iHn2);
        this.x.setLayoutParams(layoutParams2);
        linearLayout.addView(this.x);
        return pr(i, linearLayoutHw, linearLayout, iHn);
    }

    private LinearLayout pr(int i, LinearLayout linearLayout, LinearLayout linearLayout2, int i2) {
        this.c = new TextView(this.pr);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        if (i != 0) {
            layoutParams.topMargin = er.hn(this.pr, 14.0f);
        } else {
            layoutParams.topMargin = er.hn(this.pr, 16.0f);
            int iHn = er.hn(this.pr, 25.0f);
            layoutParams.leftMargin = iHn;
            layoutParams.rightMargin = iHn;
        }
        this.c.setLayoutParams(layoutParams);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        this.c.setTextColor(Color.parseColor("#161823"));
        this.c.setTextSize(18.0f);
        this.c.setGravity(17);
        this.c.setTypeface(null, 1);
        linearLayout2.addView(this.c);
        this.uc = new TextView(this.pr);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = er.hn(this.pr, 5.0f);
        this.uc.setLayoutParams(layoutParams2);
        this.uc.setEllipsize(TextUtils.TruncateAt.END);
        this.uc.setSingleLine(true);
        this.uc.setAlpha(0.5f);
        this.uc.setTextColor(Color.parseColor("#161823"));
        this.uc.setTextSize(14.0f);
        this.uc.setGravity(17);
        linearLayout2.addView(this.uc);
        return hw(i, linearLayout, linearLayout2, i2);
    }

    private LinearLayout hw(int i, LinearLayout linearLayout, LinearLayout linearLayout2, int i2) {
        this.zo = new LinearLayout(this.pr);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = er.hn(this.pr, 10.0f);
        this.zo.setLayoutParams(layoutParams);
        this.zo.setOrientation(0);
        linearLayout2.addView(this.zo);
        this.aj = new LinearLayout(this.pr);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = er.hn(this.pr, 10.0f);
        if (i == 0) {
            layoutParams2.topMargin = er.hn(this.pr, 16.0f);
        } else {
            layoutParams2.topMargin = er.hn(this.pr, 10.0f);
        }
        this.aj.setLayoutParams(layoutParams2);
        this.aj.setOrientation(0);
        this.vk = new TTRatingBar2(this.pr, null);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        this.vk.setLayoutParams(layoutParams3);
        this.aj.addView(this.vk);
        this.w = new TextView(this.pr);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = er.hn(this.pr, 3.0f);
        this.w.setTextSize(16.0f);
        this.w.setTextColor(Color.parseColor("#161823"));
        this.w.setLayoutParams(layoutParams4);
        this.aj.addView(this.w);
        linearLayout2.addView(this.aj);
        return pr(i, linearLayout, i2);
    }

    private LinearLayout pr(int i, LinearLayout linearLayout, int i2) {
        int iWm = a.hw().wm();
        boolean zOm = a.hw().om();
        if (zOm && iWm == 1) {
            this.yb = new ShakeButton(this.pr);
        } else if (zOm && iWm == 2) {
            this.yb = new ShineButton(this.pr);
        } else {
            this.yb = new Button(this.pr);
        }
        this.yb.setId(View.generateViewId());
        LinearLayout linearLayout2 = new LinearLayout(this.pr);
        linearLayout2.setId(View.generateViewId());
        View view = new View(this.pr);
        view.setId(View.generateViewId());
        TextView textView = new TextView(this.pr);
        this.m = textView;
        textView.setId(View.generateViewId());
        if (i == 1) {
            pr(i, this.gz);
        } else {
            pr(er.hn(this.pr, 89.0f), i);
        }
        return pr(i, linearLayout, i2, linearLayout2, view);
    }

    private LinearLayout pr(int i, LinearLayout linearLayout, int i2, LinearLayout linearLayout2, View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(2, linearLayout2.getId());
        if (i == 1) {
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
        } else {
            int iHn = er.hn(this.pr, 16.0f);
            layoutParams.leftMargin = iHn;
            layoutParams.rightMargin = iHn;
        }
        layoutParams.topMargin = er.hn(this.pr, 3.0f);
        this.m.setEllipsize(TextUtils.TruncateAt.END);
        this.m.setGravity(17);
        this.m.setTextColor(Color.parseColor("#4D161823"));
        if (i == 0) {
            this.m.setTextSize(10.0f);
        } else {
            this.m.setTextSize(12.0f);
        }
        this.m.setLayoutParams(layoutParams);
        this.gz.addView(this.m);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.leftMargin = i2;
        layoutParams2.rightMargin = i2;
        if (i == 1) {
            layoutParams2.topMargin = er.hn(this.pr, 9.0f);
        } else {
            layoutParams2.topMargin = er.hn(this.pr, 2.0f);
            layoutParams2.bottomMargin = er.hn(this.pr, 20.0f);
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
        return hw(i, linearLayout, i2, linearLayout2, view);
    }

    private LinearLayout hw(int i, LinearLayout linearLayout, int i2, LinearLayout linearLayout2, View view) {
        if (i == 0) {
            pr(i, (ViewGroup) linearLayout2);
            if (!TextUtils.isEmpty(this.fo)) {
                ImageView imageView = new ImageView(this.pr);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(er.hn(this.pr, 0.5f), er.hn(this.pr, 9.0f));
                layoutParams.leftMargin = er.hn(this.pr, 8.0f);
                layoutParams.gravity = 17;
                imageView.setLayoutParams(layoutParams);
                imageView.setBackgroundColor(Color.parseColor("#D8D8D8"));
                linearLayout2.addView(imageView);
            }
        }
        int iHn = er.hn(this.pr, 8.0f);
        pr(linearLayout2, iHn);
        hw(linearLayout2, iHn);
        return pr(i, linearLayout, i2, linearLayout2, view, iHn);
    }

    private void pr(LinearLayout linearLayout, int i) {
        this.nt = new TextView(this.pr);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.nt.setLayoutParams(layoutParams);
        this.nt.setAlpha(0.75f);
        this.nt.setTextColor(Color.parseColor("#66161823"));
        if (this.pr.getResources().getConfiguration().orientation == 2) {
            this.nt.setTextSize(10.0f);
        } else {
            this.nt.setTextSize(12.0f);
        }
        this.nt.setText("功能");
        linearLayout.addView(this.nt);
    }

    private void hw(LinearLayout linearLayout, int i) {
        linearLayout.addView(c());
        this.fw = new TextView(this.pr);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.fw.setLayoutParams(layoutParams);
        this.fw.setAlpha(0.75f);
        this.fw.setTextColor(Color.parseColor("#66161823"));
        if (this.pr.getResources().getConfiguration().orientation == 2) {
            this.fw.setTextSize(10.0f);
        } else {
            this.fw.setTextSize(12.0f);
        }
        this.fw.setText("权限");
        linearLayout.addView(this.fw);
    }

    private ImageView c() {
        ImageView imageView = new ImageView(this.pr);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(er.hn(this.pr, 0.5f), er.hn(this.pr, 9.0f));
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundColor(Color.parseColor("#D8D8D8"));
        return imageView;
    }

    private LinearLayout pr(int i, LinearLayout linearLayout, int i2, LinearLayout linearLayout2, View view, int i3) {
        linearLayout2.addView(c());
        this.g = new TextView(this.pr);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i3;
        layoutParams.rightMargin = i3;
        this.g.setLayoutParams(layoutParams);
        this.g.setAlpha(0.75f);
        this.g.setTextColor(Color.parseColor("#66161823"));
        if (this.pr.getResources().getConfiguration().orientation == 2) {
            this.g.setTextSize(10.0f);
        } else {
            this.g.setTextSize(12.0f);
        }
        this.g.setText("隐私");
        linearLayout2.addView(this.g);
        if (!TextUtils.isEmpty(this.rc)) {
            linearLayout2.addView(c());
            this.ho = new TextView(this.pr);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = i3;
            layoutParams2.rightMargin = i3;
            this.ho.setLayoutParams(layoutParams2);
            this.ho.setAlpha(0.75f);
            this.ho.setTextColor(Color.parseColor("#66161823"));
            if (this.pr.getResources().getConfiguration().orientation == 2) {
                this.ho.setTextSize(10.0f);
            } else {
                this.ho.setTextSize(12.0f);
            }
            this.ho.setText("备案");
            linearLayout2.addView(this.ho);
        }
        this.gz.addView(linearLayout2);
        if (i == 0) {
            return linearLayout;
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, er.hn(this.pr, 1.0f));
        layoutParams3.topMargin = er.hn(this.pr, 12.0f);
        layoutParams3.addRule(2, this.yb.getId());
        view.setLayoutParams(layoutParams3);
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        this.gz.addView(view);
        pr(i2, i);
        return linearLayout;
    }

    private LinearLayout hw(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.pr);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(Color.parseColor("#99000000"));
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.pr);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        this.gz = new RelativeLayout(this.pr);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(er.hn(this.pr, 8.0f));
        this.gz.setBackground(gradientDrawable);
        this.gz.setLayoutParams(layoutParams2);
        linearLayout.addView(this.gz);
        return pr(i, linearLayout);
    }

    private LinearLayout pr(int i, LinearLayout linearLayout) {
        if (i == 0) {
            this.hn = new ImageView(this.pr);
            int iHn = er.hn(this.pr, 28.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iHn, iHn);
            int iHn2 = er.hn(this.pr, 36.0f);
            layoutParams.topMargin = iHn2;
            layoutParams.rightMargin = iHn2;
            layoutParams.leftMargin = iHn2;
            layoutParams.bottomMargin = iHn2;
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.addRule(11);
            this.hn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.hn.setLayoutParams(layoutParams);
            this.hn.setMaxHeight(iHn);
            this.hn.setMaxWidth(iHn);
            this.hn.setMinimumHeight(iHn);
            this.hn.setMinimumWidth(iHn);
            com.byazt.sdv.pr prVar = new com.byazt.sdv.pr(er.hn(this.pr, 28.0f));
            prVar.pr(Color.parseColor("#66161823"));
            float fHn = er.hn(this.pr, 2.0f);
            prVar.pr(fHn);
            com.byazt.sdv.hw hwVar = new com.byazt.sdv.hw(er.hn(this.pr, 12.0f));
            hwVar.pr(-1);
            hwVar.pr(fHn);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{prVar, hwVar});
            layerDrawable.setLayerInset(0, 0, 0, 0, 0);
            int iHn3 = er.hn(this.pr, 8.0f);
            layerDrawable.setLayerInset(1, iHn3, iHn3, iHn3, iHn3);
            this.hn.setImageDrawable(layerDrawable);
            this.gz.addView(this.hn);
        }
        return linearLayout;
    }

    private void pr(int i, ViewGroup viewGroup) {
        this.k = new TextView(this.pr);
        if (i == 1) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(2, this.m.getId());
            int iHn = er.hn(this.pr, 16.0f);
            layoutParams.leftMargin = iHn;
            layoutParams.rightMargin = iHn;
            layoutParams.topMargin = er.hn(this.pr, 30.0f);
            this.k.setLayoutParams(layoutParams);
            this.k.setGravity(17);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = GravityCompat.START;
            this.k.setLayoutParams(layoutParams2);
        }
        this.k.setEllipsize(TextUtils.TruncateAt.END);
        this.k.setTextColor(Color.parseColor("#57161823"));
        if (i == 0) {
            this.k.setTextSize(10.0f);
        } else {
            this.k.setTextSize(12.0f);
        }
        viewGroup.addView(this.k);
    }

    private void pr(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        if (i2 == 1) {
            layoutParams.topMargin = er.hn(this.pr, 14.0f);
            layoutParams.bottomMargin = er.hn(this.pr, 46.0f);
            layoutParams.addRule(12);
        } else {
            layoutParams.topMargin = er.hn(this.pr, 10.0f);
            layoutParams.bottomMargin = er.hn(this.pr, 24.0f);
            layoutParams.addRule(2, this.m.getId());
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(er.hn(this.pr, 3.0f));
        this.yb.setBackground(gradientDrawable);
        this.yb.setGravity(17);
        this.yb.setText("立即下载");
        int iHn = er.hn(this.pr, 13.0f);
        this.yb.setPadding(0, iHn, 0, iHn);
        this.yb.setTextColor(-1);
        this.yb.setLayoutParams(layoutParams);
        this.yb.setTextSize(15.0f);
        this.gz.addView(this.yb);
        if (i2 == 1 && !TextUtils.isEmpty(this.b)) {
            int iHn2 = er.hn(this.pr, 60.0f);
            com.byazt.qs.hw hwVar = new com.byazt.qs.hw(this.pr);
            this.lb = hwVar;
            hwVar.pr("src", this.b);
            this.lb.pr("loop", "true");
            this.lb.pr("autoPlay", "true");
            this.lb.pr("width", String.valueOf(iHn2));
            this.lb.pr("height", String.valueOf(iHn2));
            this.lb.pr("scaleType", ImageViewManager.SCALE_TYPE_FIT_XY);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iHn2, iHn2);
            layoutParams2.addRule(11);
            layoutParams2.addRule(3, this.yb.getId());
            layoutParams2.rightMargin = er.hn(this.pr, 73.0f);
            layoutParams2.topMargin = -er.hn(this.pr, 85.0f);
            this.lb.pr(layoutParams2);
            UgenLottieView ugenLottieViewAj = this.lb.aj();
            if (ugenLottieViewAj == null) {
                return;
            }
            this.lb.hw();
            this.gz.addView(ugenLottieViewAj);
        }
    }

    private View uc() {
        RelativeLayout relativeLayout = new RelativeLayout(this.pr);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        relativeLayout.setId(View.generateViewId());
        ImageView imageView = new ImageView(this.pr);
        this.hn = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int iHn = er.hn(this.pr, 46.0f);
        this.hn.setMaxHeight(iHn);
        this.hn.setMaxWidth(iHn);
        this.hn.setMinimumHeight(iHn);
        this.hn.setMinimumWidth(iHn);
        com.byazt.sdv.hw hwVar = new com.byazt.sdv.hw(er.hn(this.pr, 14.0f));
        hwVar.pr(ViewCompat.MEASURED_STATE_MASK);
        hwVar.pr(er.hn(this.pr, 2.0f));
        this.hn.setImageDrawable(hwVar);
        relativeLayout.addView(this.hn);
        TextView textView = new TextView(this.pr);
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
        this.gz.addView(relativeLayout);
        return pr(relativeLayout);
    }

    private View pr(RelativeLayout relativeLayout) {
        View view = new View(this.pr);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, er.hn(this.pr, 1.0f));
        layoutParams.addRule(3, relativeLayout.getId());
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        view.setId(View.generateViewId());
        this.gz.addView(view);
        return view;
    }

    public void hw() {
        if (this.pr == null) {
            this.pr = a.getContext();
        }
        this.hw.clear();
        this.hw.push(this.x);
        this.hw.push(this.c);
        this.hw.push(this.uc);
        this.hw.push(this.zo);
        this.hw.push(this.aj);
        fw();
        this.nt.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.hn.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (hn.this.y != null) {
                    hn.this.y.c(hn.this);
                }
            }
        });
        if (this.ho != null && !TextUtils.isEmpty(this.rc)) {
            this.ho.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.hn.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (hn.this.y != null) {
                        hn.this.y.uc(hn.this);
                    }
                }
            });
        }
        this.fw.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.hn.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (hn.this.y != null) {
                    hn.this.y.hw(hn.this);
                }
            }
        });
        this.hn.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.hn.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (hn.this.y != null) {
                    hn.this.y.hn(hn.this);
                }
            }
        });
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.hn.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (hn.this.y != null) {
                    hn.this.y.x(hn.this);
                }
            }
        });
        this.yb.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.hn.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (hn.this.y != null) {
                    hn.this.y.pr(hn.this);
                }
            }
        });
    }

    private void fw() {
        RelativeLayout relativeLayout;
        if (this.nl == null || (relativeLayout = this.gz) == null) {
            return;
        }
        final int childCount = relativeLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.gz.getChildAt(i).setVisibility(4);
        }
        this.nl.postDelayed(new Runnable() { // from class: com.byazt.nc.hn.7
            @Override // java.lang.Runnable
            public void run() {
                hn.this.hn(childCount);
            }
        }, 10L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(int i) {
        try {
            Rect rect = new Rect();
            if (this.pr.getResources().getConfiguration().orientation == 1) {
                this.k.getGlobalVisibleRect(rect);
            } else {
                this.yb.getGlobalVisibleRect(rect);
            }
            while (!this.hw.isEmpty()) {
                Rect rect2 = new Rect();
                View viewPop = this.hw.pop();
                if (viewPop != null && viewPop.getVisibility() != 8) {
                    viewPop.getGlobalVisibleRect(rect2);
                    if (rect2.top != 0 && rect.top >= rect2.bottom) {
                        break;
                    }
                    if (viewPop == this.c) {
                        View viewPop2 = this.hw.pop();
                        if (viewPop2 != null) {
                            viewPop2.setVisibility(8);
                        }
                    } else {
                        viewPop.setVisibility(8);
                    }
                }
            }
            if (this.hw.isEmpty()) {
                zo();
            }
        } catch (Throwable th) {
        }
        this.gz.setVisibility(0);
        for (int i2 = 0; i2 < i; i2++) {
            this.gz.getChildAt(i2).setVisibility(0);
        }
    }

    private void zo() {
        RelativeLayout.LayoutParams layoutParams;
        Button button = this.yb;
        if (button != null) {
            ViewGroup.LayoutParams layoutParams2 = button.getLayoutParams();
            if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
                layoutParams3.bottomMargin = layoutParams3.topMargin;
                this.yb.setLayoutParams(layoutParams3);
            } else if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams2;
                layoutParams4.bottomMargin = layoutParams4.topMargin;
                this.yb.setLayoutParams(layoutParams4);
            }
        }
        com.byazt.qs.hw hwVar = this.lb;
        if (hwVar != null) {
            UgenLottieView ugenLottieViewAj = hwVar.aj();
            if (ugenLottieViewAj != null) {
                layoutParams = (RelativeLayout.LayoutParams) ugenLottieViewAj.getLayoutParams();
            } else {
                int iHn = er.hn(this.pr, 60.0f);
                layoutParams = new RelativeLayout.LayoutParams(iHn, iHn);
            }
            layoutParams.topMargin = -er.hn(this.pr, 53.0f);
            this.lb.pr(layoutParams);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        pr prVar = this.y;
        if (prVar != null) {
            prVar.hn(this);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        hn();
    }

    public void hn() {
        String str;
        String str2;
        int iX;
        if (this.pr == null) {
            this.pr = a.getContext();
        }
        int i = this.pr.getResources().getConfiguration().orientation;
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(this.qa);
        } else {
            TTRoundRectImageView tTRoundRectImageView = this.x;
            if (tTRoundRectImageView != null) {
                tTRoundRectImageView.setVisibility(8);
            }
        }
        if (this.x != null && !TextUtils.isEmpty(this.a)) {
            com.byazt.ub.hw.pr(this.a).pr(this.x);
        } else {
            TTRoundRectImageView tTRoundRectImageView2 = this.x;
            if (tTRoundRectImageView2 != null) {
                tTRoundRectImageView2.setVisibility(8);
            }
        }
        if (this.uc != null) {
            if (TextUtils.isEmpty(this.cz)) {
                this.uc.setVisibility(8);
            } else {
                this.uc.setText(this.cz);
            }
        }
        if (this.zo != null) {
            JSONArray jSONArray = this.iu;
            if (jSONArray == null || jSONArray.length() <= 0) {
                this.zo.setVisibility(8);
            } else {
                Display defaultDisplay = null;
                WindowManager windowManager = (WindowManager) this.pr.getSystemService("window");
                if (windowManager != null) {
                    defaultDisplay = windowManager.getDefaultDisplay();
                }
                if (defaultDisplay == null) {
                    iX = 0;
                } else {
                    int width = defaultDisplay.getWidth();
                    if (width > defaultDisplay.getHeight()) {
                        double dX = er.x(this.pr, width);
                        iX = ((int) (dX - (0.38d * dX))) - 80;
                    } else {
                        iX = er.x(this.pr, width) - 36;
                    }
                }
                int length = this.iu.length() <= 3 ? this.iu.length() : 3;
                for (int i2 = 0; i2 < length; i2++) {
                    String strOptString = this.iu.optString(i2);
                    if (!TextUtils.isEmpty(strOptString)) {
                        TextView textView2 = new TextView(this.pr);
                        textView2.setText(strOptString);
                        textView2.setTextSize(12.0f);
                        textView2.setTextColor(Color.parseColor("#161823"));
                        textView2.setAlpha(0.75f);
                        textView2.setBackgroundColor(Color.parseColor("#0F161823"));
                        int iHn = er.hn(this.pr, 6.0f);
                        textView2.setPadding(iHn, 0, iHn, 0);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        int iHn2 = er.hn(this.pr, 3.0f);
                        layoutParams.leftMargin = iHn2;
                        layoutParams.rightMargin = iHn2;
                        textView2.setLayoutParams(layoutParams);
                        TextPaint paint = textView2.getPaint();
                        Rect rect = new Rect();
                        paint.getTextBounds(strOptString, 0, strOptString.length(), rect);
                        iX -= er.x(this.pr, rect.width()) + 20;
                        if (iX >= 0) {
                            this.zo.addView(textView2);
                        } else {
                            if (this.zo.getChildCount() > 0) {
                                break;
                            }
                            this.zo.setVisibility(8);
                            break;
                        }
                    }
                }
            }
        }
        if (this.vk != null && this.w != null) {
            float f = this.ve;
            if (f <= 0.0f) {
                LinearLayout linearLayout = this.aj;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                this.vk.setVisibility(8);
                this.w.setVisibility(8);
            } else {
                if (f > 5.0f) {
                    f = 5.0f;
                }
                this.ve = f;
                this.w.setText(new DecimalFormat(".0").format(this.ve));
                this.vk.setRating(this.ve);
                this.vk.pr(er.hn(this.pr, 16.0f), er.hn(this.pr, 15.0f));
                this.vk.pr(er.hn(this.pr, 3.0f), 0, er.hn(this.pr, 3.0f), 0);
                this.vk.pr();
            }
        }
        if (this.k == null) {
            str = "";
        } else {
            if (TextUtils.isEmpty(this.ny)) {
                str = String.format("版本号：%1$s", "暂无");
            } else {
                str = String.format("版本号：%1$s", this.ny);
            }
            if (i == 2) {
                TextPaint paint2 = this.k.getPaint();
                Rect rect2 = new Rect();
                paint2.getTextBounds(str, 0, str.length(), rect2);
                double dVk = er.vk(this.pr);
                int iWidth = (((int) (dVk - (0.4d * dVk))) - rect2.width()) - er.hn(this.pr, 106.0f);
                TextView textView3 = this.g;
                if (textView3 != null) {
                    TextPaint paint3 = textView3.getPaint();
                    String string = this.g.getText().toString();
                    paint3.getTextBounds(string, 0, string.length(), rect2);
                    iWidth -= rect2.width();
                }
                TextView textView4 = this.fw;
                if (textView4 != null) {
                    TextPaint paint4 = textView4.getPaint();
                    String string2 = this.fw.getText().toString();
                    paint4.getTextBounds(string2, 0, string2.length(), rect2);
                    iWidth -= rect2.width();
                }
                TextView textView5 = this.nt;
                if (textView5 != null) {
                    TextPaint paint5 = textView5.getPaint();
                    String string3 = this.nt.getText().toString();
                    paint5.getTextBounds(string3, 0, string3.length(), rect2);
                    iWidth -= rect2.width();
                }
                if (this.ho != null && !TextUtils.isEmpty(this.rc)) {
                    TextPaint paint6 = this.ho.getPaint();
                    String string4 = this.ho.getText().toString();
                    paint6.getTextBounds(string4, 0, TextUtils.isEmpty(string4) ? 0 : string4.length(), rect2);
                    iWidth -= rect2.width();
                }
                if (iWidth <= 0) {
                    ((LinearLayout.LayoutParams) this.k.getLayoutParams()).weight = 1.0f;
                }
            }
            if (i == 1) {
                this.k.setText(str);
            }
        }
        TextView textView6 = this.m;
        if (textView6 != null) {
            textView6.setSelected(true);
            if (TextUtils.isEmpty(this.z)) {
                str2 = String.format("开发者：%1$s", "补充中，可于应用官网查看");
            } else {
                str2 = String.format("开发者：%1$s", this.z);
            }
            if (i == 2) {
                str2 = str2 + "  " + str;
            }
            this.m.setText(str2);
        }
    }

    public hn pr(String str) {
        this.qa = str;
        return this;
    }

    public hn hw(String str) {
        this.a = str;
        return this;
    }

    public hn hn(String str) {
        this.b = str;
        return this;
    }

    public hn x(String str) {
        this.cz = str;
        return this;
    }

    public hn c(String str) {
        this.ny = str;
        return this;
    }

    public hn uc(String str) {
        this.fo = str;
        return this;
    }

    public hn fw(String str) {
        this.rc = str;
        return this;
    }

    public hn zo(String str) {
        this.z = str;
        return this;
    }

    public hn pr(JSONArray jSONArray) {
        this.iu = jSONArray;
        return this;
    }

    public hn pr(float f) {
        this.ve = f;
        return this;
    }

    public hn pr(pr prVar) {
        this.y = prVar;
        return this;
    }

    public String x() {
        return this.ww;
    }

    public hn aj(String str) {
        this.ww = str;
        return this;
    }
}
