package com.byazt.mr;

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
import com.byazt.kru.UgenLottieView;
import com.byazt.ndr.TTRatingBar2;
import com.byazt.ndr.TTRoundRectImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.text.DecimalFormat;
import java.util.Stack;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 8})
public class s extends AlertDialog {
    public String a;
    public RelativeLayout bb;
    public com.byazt.kru.qg cd;
    public TextView cp;
    public TextView cy;
    public TextView d;
    public LinearLayout fs;
    public String h;
    public Button hd;
    public String hu;
    public TextView k;
    public TextView l;
    public n lh;
    public View ln;
    public String m;
    public Context n;
    public TextView oa;
    public String ou;
    public String py;
    public TTRoundRectImageView q;
    public Stack<View> qg;
    public LinearLayout rv;
    public ImageView s;
    public TextView sz;
    public JSONArray t;
    public TTRatingBar2 tj;
    public String um;
    public float ur;
    public String v;
    public TextView w;
    public String wm;
    public TextView x;

    public interface n {
        void l(Dialog dialog);

        void n(Dialog dialog);

        void q(Dialog dialog);

        void qg(Dialog dialog);

        void s(Dialog dialog);

        void w(Dialog dialog);
    }

    public s(Context context) {
        super(context);
        this.qg = new Stack<>();
        this.n = context;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.cb.s.qg(this);
        n();
        setCanceledOnTouchOutside(false);
        qg();
    }

    public void n() {
        if (this.n == null) {
            this.n = com.byazt.nf.rv.getContext();
        }
        if (this.n.getResources().getConfiguration().orientation == 1) {
            this.ln = n(1);
        } else {
            this.ln = n(0);
        }
        setContentView(this.ln);
    }

    private View n(int i) {
        int iS;
        LinearLayout linearLayoutQg = qg(i);
        LinearLayout linearLayout = new LinearLayout(this.n);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (i == 0) {
            iS = com.byazt.okk.s.s(this.n, 40.0f);
        } else {
            layoutParams.addRule(3, w().getId());
            iS = com.byazt.okk.s.s(this.n, 16.0f);
        }
        layoutParams.leftMargin = iS;
        layoutParams.rightMargin = iS;
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        this.bb.addView(linearLayout);
        this.q = new TTRoundRectImageView(this.n);
        int iS2 = com.byazt.okk.s.s(this.n, 64.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iS2, iS2);
        layoutParams2.gravity = 1;
        if (i == 0) {
            layoutParams2.topMargin = com.byazt.okk.s.s(this.n, 40.0f);
        } else {
            layoutParams2.topMargin = com.byazt.okk.s.s(this.n, 36.0f);
        }
        this.q.setMaxHeight(iS2);
        this.q.setMaxWidth(iS2);
        this.q.setMinimumHeight(iS2);
        this.q.setMinimumWidth(iS2);
        this.q.setLayoutParams(layoutParams2);
        linearLayout.addView(this.q);
        return n(i, linearLayoutQg, linearLayout, iS);
    }

    private LinearLayout n(int i, LinearLayout linearLayout, LinearLayout linearLayout2, int i2) {
        this.l = new TextView(this.n);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        if (i == 0) {
            layoutParams.topMargin = com.byazt.okk.s.s(this.n, 16.0f);
            int iS = com.byazt.okk.s.s(this.n, 25.0f);
            layoutParams.leftMargin = iS;
            layoutParams.rightMargin = iS;
        } else {
            layoutParams.topMargin = com.byazt.okk.s.s(this.n, 14.0f);
        }
        this.l.setLayoutParams(layoutParams);
        this.l.setEllipsize(TextUtils.TruncateAt.END);
        this.l.setTextColor(Color.parseColor("#161823"));
        this.l.setTextSize(18.0f);
        this.l.setGravity(17);
        this.l.setTypeface(null, 1);
        linearLayout2.addView(this.l);
        this.w = new TextView(this.n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = com.byazt.okk.s.s(this.n, 5.0f);
        this.w.setLayoutParams(layoutParams2);
        this.w.setEllipsize(TextUtils.TruncateAt.END);
        this.w.setSingleLine(true);
        this.w.setAlpha(0.5f);
        this.w.setTextColor(Color.parseColor("#161823"));
        this.w.setTextSize(14.0f);
        this.w.setGravity(17);
        linearLayout2.addView(this.w);
        return qg(i, linearLayout, linearLayout2, i2);
    }

    private LinearLayout qg(int i, LinearLayout linearLayout, LinearLayout linearLayout2, int i2) {
        this.fs = new LinearLayout(this.n);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = com.byazt.okk.s.s(this.n, 10.0f);
        this.fs.setLayoutParams(layoutParams);
        this.fs.setOrientation(0);
        linearLayout2.addView(this.fs);
        this.rv = new LinearLayout(this.n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = com.byazt.okk.s.s(this.n, 10.0f);
        if (i == 0) {
            layoutParams2.topMargin = com.byazt.okk.s.s(this.n, 16.0f);
        } else {
            layoutParams2.topMargin = com.byazt.okk.s.s(this.n, 10.0f);
        }
        this.rv.setLayoutParams(layoutParams2);
        this.rv.setOrientation(0);
        this.tj = new TTRatingBar2(this.n, null);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        this.tj.setLayoutParams(layoutParams3);
        this.rv.addView(this.tj);
        this.cp = new TextView(this.n);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = com.byazt.okk.s.s(this.n, 3.0f);
        this.cp.setTextSize(16.0f);
        this.cp.setTextColor(Color.parseColor("#161823"));
        this.cp.setLayoutParams(layoutParams4);
        this.rv.addView(this.cp);
        linearLayout2.addView(this.rv);
        return n(i, linearLayout, i2);
    }

    private LinearLayout n(int i, LinearLayout linearLayout, int i2) {
        int iDi = com.byazt.nf.rv.qg().di();
        boolean zC = com.byazt.nf.rv.qg().c();
        if (zC && iDi == 1) {
            this.hd = new ShakeButton(this.n);
        } else if (zC && iDi == 2) {
            this.hd = new ShineButton(this.n);
        } else {
            this.hd = new Button(this.n);
        }
        this.hd.setId(View.generateViewId());
        LinearLayout linearLayout2 = new LinearLayout(this.n);
        linearLayout2.setId(View.generateViewId());
        View view = new View(this.n);
        view.setId(View.generateViewId());
        TextView textView = new TextView(this.n);
        this.oa = textView;
        textView.setId(View.generateViewId());
        if (i == 1) {
            n(i, this.bb);
        } else {
            n(com.byazt.okk.s.s(this.n, 89.0f), i);
        }
        return n(i, linearLayout, i2, linearLayout2, view);
    }

    private LinearLayout n(int i, LinearLayout linearLayout, int i2, LinearLayout linearLayout2, View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(2, linearLayout2.getId());
        if (i == 1) {
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
        } else {
            int iS = com.byazt.okk.s.s(this.n, 16.0f);
            layoutParams.leftMargin = iS;
            layoutParams.rightMargin = iS;
        }
        layoutParams.topMargin = com.byazt.okk.s.s(this.n, 3.0f);
        this.oa.setEllipsize(TextUtils.TruncateAt.END);
        this.oa.setGravity(17);
        this.oa.setTextColor(Color.parseColor("#4D161823"));
        if (i == 0) {
            this.oa.setTextSize(10.0f);
        } else {
            this.oa.setTextSize(12.0f);
        }
        this.oa.setLayoutParams(layoutParams);
        this.bb.addView(this.oa);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.leftMargin = i2;
        layoutParams2.rightMargin = i2;
        if (i == 1) {
            layoutParams2.topMargin = com.byazt.okk.s.s(this.n, 9.0f);
        } else {
            layoutParams2.topMargin = com.byazt.okk.s.s(this.n, 2.0f);
            layoutParams2.bottomMargin = com.byazt.okk.s.s(this.n, 20.0f);
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
        return qg(i, linearLayout, i2, linearLayout2, view);
    }

    private LinearLayout qg(int i, LinearLayout linearLayout, int i2, LinearLayout linearLayout2, View view) {
        if (i == 0) {
            n(i, (ViewGroup) linearLayout2);
            if (!TextUtils.isEmpty(this.wm)) {
                ImageView imageView = new ImageView(this.n);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.byazt.okk.s.s(this.n, 0.5f), com.byazt.okk.s.s(this.n, 9.0f));
                layoutParams.leftMargin = com.byazt.okk.s.s(this.n, 8.0f);
                layoutParams.gravity = 17;
                imageView.setLayoutParams(layoutParams);
                imageView.setBackgroundColor(Color.parseColor("#D8D8D8"));
                linearLayout2.addView(imageView);
            }
        }
        int iS = com.byazt.okk.s.s(this.n, 8.0f);
        n(linearLayout2, iS);
        qg(linearLayout2, iS);
        return n(i, linearLayout, i2, linearLayout2, view, iS);
    }

    private void n(LinearLayout linearLayout, int i) {
        this.cy = new TextView(this.n);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.cy.setLayoutParams(layoutParams);
        this.cy.setAlpha(0.75f);
        this.cy.setTextColor(Color.parseColor("#66161823"));
        if (this.n.getResources().getConfiguration().orientation == 2) {
            this.cy.setTextSize(10.0f);
        } else {
            this.cy.setTextSize(12.0f);
        }
        this.cy.setText("功能");
        linearLayout.addView(this.cy);
    }

    private void qg(LinearLayout linearLayout, int i) {
        linearLayout.addView(l());
        this.x = new TextView(this.n);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.x.setLayoutParams(layoutParams);
        this.x.setAlpha(0.75f);
        this.x.setTextColor(Color.parseColor("#66161823"));
        if (this.n.getResources().getConfiguration().orientation == 2) {
            this.x.setTextSize(10.0f);
        } else {
            this.x.setTextSize(12.0f);
        }
        this.x.setText("权限");
        linearLayout.addView(this.x);
    }

    private ImageView l() {
        ImageView imageView = new ImageView(this.n);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.byazt.okk.s.s(this.n, 0.5f), com.byazt.okk.s.s(this.n, 9.0f));
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundColor(Color.parseColor("#D8D8D8"));
        return imageView;
    }

    private LinearLayout n(int i, LinearLayout linearLayout, int i2, LinearLayout linearLayout2, View view, int i3) {
        linearLayout2.addView(l());
        this.sz = new TextView(this.n);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i3;
        layoutParams.rightMargin = i3;
        this.sz.setLayoutParams(layoutParams);
        this.sz.setAlpha(0.75f);
        this.sz.setTextColor(Color.parseColor("#66161823"));
        if (this.n.getResources().getConfiguration().orientation == 2) {
            this.sz.setTextSize(10.0f);
        } else {
            this.sz.setTextSize(12.0f);
        }
        this.sz.setText("隐私");
        linearLayout2.addView(this.sz);
        if (!TextUtils.isEmpty(this.m)) {
            linearLayout2.addView(l());
            this.k = new TextView(this.n);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = i3;
            layoutParams2.rightMargin = i3;
            this.k.setLayoutParams(layoutParams2);
            this.k.setAlpha(0.75f);
            this.k.setTextColor(Color.parseColor("#66161823"));
            if (this.n.getResources().getConfiguration().orientation == 2) {
                this.k.setTextSize(10.0f);
            } else {
                this.k.setTextSize(12.0f);
            }
            this.k.setText("备案");
            linearLayout2.addView(this.k);
        }
        this.bb.addView(linearLayout2);
        if (i == 0) {
            return linearLayout;
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.byazt.okk.s.s(this.n, 1.0f));
        layoutParams3.topMargin = com.byazt.okk.s.s(this.n, 12.0f);
        layoutParams3.addRule(2, this.hd.getId());
        view.setLayoutParams(layoutParams3);
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        this.bb.addView(view);
        n(i2, i);
        return linearLayout;
    }

    private LinearLayout qg(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.n);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(Color.parseColor("#99000000"));
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.n);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        this.bb = new RelativeLayout(this.n);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(com.byazt.okk.s.s(this.n, 8.0f));
        this.bb.setBackground(gradientDrawable);
        this.bb.setLayoutParams(layoutParams2);
        linearLayout.addView(this.bb);
        return n(i, linearLayout);
    }

    private LinearLayout n(int i, LinearLayout linearLayout) {
        if (i == 0) {
            this.s = new ImageView(this.n);
            int iS = com.byazt.okk.s.s(this.n, 28.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iS, iS);
            int iS2 = com.byazt.okk.s.s(this.n, 36.0f);
            layoutParams.topMargin = iS2;
            layoutParams.rightMargin = iS2;
            layoutParams.leftMargin = iS2;
            layoutParams.bottomMargin = iS2;
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.addRule(11);
            this.s.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.s.setLayoutParams(layoutParams);
            this.s.setMaxHeight(iS);
            this.s.setMaxWidth(iS);
            this.s.setMinimumHeight(iS);
            this.s.setMinimumWidth(iS);
            com.byazt.xn.n nVar = new com.byazt.xn.n(com.byazt.okk.s.s(this.n, 28.0f));
            nVar.n(Color.parseColor("#66161823"));
            float fS = com.byazt.okk.s.s(this.n, 2.0f);
            nVar.n(fS);
            com.byazt.xn.qg qgVar = new com.byazt.xn.qg(com.byazt.okk.s.s(this.n, 12.0f));
            qgVar.n(-1);
            qgVar.n(fS);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{nVar, qgVar});
            layerDrawable.setLayerInset(0, 0, 0, 0, 0);
            int iS3 = com.byazt.okk.s.s(this.n, 8.0f);
            layerDrawable.setLayerInset(1, iS3, iS3, iS3, iS3);
            this.s.setImageDrawable(layerDrawable);
            this.bb.addView(this.s);
        }
        return linearLayout;
    }

    private void n(int i, ViewGroup viewGroup) {
        this.d = new TextView(this.n);
        if (i == 1) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(2, this.oa.getId());
            int iS = com.byazt.okk.s.s(this.n, 16.0f);
            layoutParams.leftMargin = iS;
            layoutParams.rightMargin = iS;
            layoutParams.topMargin = com.byazt.okk.s.s(this.n, 30.0f);
            this.d.setLayoutParams(layoutParams);
            this.d.setGravity(17);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = GravityCompat.START;
            this.d.setLayoutParams(layoutParams2);
        }
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        this.d.setTextColor(Color.parseColor("#57161823"));
        if (i == 0) {
            this.d.setTextSize(10.0f);
        } else {
            this.d.setTextSize(12.0f);
        }
        viewGroup.addView(this.d);
    }

    private void n(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        if (i2 == 1) {
            layoutParams.topMargin = com.byazt.okk.s.s(this.n, 14.0f);
            layoutParams.bottomMargin = com.byazt.okk.s.s(this.n, 46.0f);
            layoutParams.addRule(12);
        } else {
            layoutParams.topMargin = com.byazt.okk.s.s(this.n, 10.0f);
            layoutParams.bottomMargin = com.byazt.okk.s.s(this.n, 24.0f);
            layoutParams.addRule(2, this.oa.getId());
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(com.byazt.okk.s.s(this.n, 3.0f));
        this.hd.setBackground(gradientDrawable);
        this.hd.setGravity(17);
        this.hd.setText("立即下载");
        int iS = com.byazt.okk.s.s(this.n, 13.0f);
        this.hd.setPadding(0, iS, 0, iS);
        this.hd.setTextColor(-1);
        this.hd.setLayoutParams(layoutParams);
        this.hd.setTextSize(15.0f);
        this.bb.addView(this.hd);
        if (i2 != 1 || TextUtils.isEmpty(this.h)) {
            return;
        }
        int iS2 = com.byazt.okk.s.s(this.n, 60.0f);
        com.byazt.kru.qg qgVar = new com.byazt.kru.qg(this.n);
        this.cd = qgVar;
        qgVar.n("src", this.h);
        this.cd.n("loop", "true");
        this.cd.n("autoPlay", "true");
        this.cd.n("width", String.valueOf(iS2));
        this.cd.n("height", String.valueOf(iS2));
        this.cd.n("scaleType", "fitXY");
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iS2, iS2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, this.hd.getId());
        layoutParams2.rightMargin = com.byazt.okk.s.s(this.n, 73.0f);
        layoutParams2.topMargin = -com.byazt.okk.s.s(this.n, 85.0f);
        this.cd.n(layoutParams2);
        UgenLottieView ugenLottieViewRv = this.cd.rv();
        if (ugenLottieViewRv == null) {
            return;
        }
        this.cd.qg();
        this.bb.addView(ugenLottieViewRv);
    }

    private View w() {
        RelativeLayout relativeLayout = new RelativeLayout(this.n);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        relativeLayout.setId(View.generateViewId());
        ImageView imageView = new ImageView(this.n);
        this.s = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int iS = com.byazt.okk.s.s(this.n, 46.0f);
        this.s.setMaxHeight(iS);
        this.s.setMaxWidth(iS);
        this.s.setMinimumHeight(iS);
        this.s.setMinimumWidth(iS);
        com.byazt.xn.qg qgVar = new com.byazt.xn.qg(com.byazt.okk.s.s(this.n, 14.0f));
        qgVar.n(ViewCompat.MEASURED_STATE_MASK);
        qgVar.n(com.byazt.okk.s.s(this.n, 2.0f));
        this.s.setImageDrawable(qgVar);
        relativeLayout.addView(this.s);
        TextView textView = new TextView(this.n);
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
        this.bb.addView(relativeLayout);
        return n(relativeLayout);
    }

    private View n(RelativeLayout relativeLayout) {
        View view = new View(this.n);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.byazt.okk.s.s(this.n, 1.0f));
        layoutParams.addRule(3, relativeLayout.getId());
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        view.setId(View.generateViewId());
        this.bb.addView(view);
        return view;
    }

    public void qg() {
        if (this.n == null) {
            this.n = com.byazt.nf.rv.getContext();
        }
        this.qg.clear();
        this.qg.push(this.q);
        this.qg.push(this.l);
        this.qg.push(this.w);
        this.qg.push(this.fs);
        this.qg.push(this.rv);
        x();
        this.cy.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.s.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.lh == null) {
                    return;
                }
                s.this.lh.l(s.this);
            }
        });
        if (this.k != null && !TextUtils.isEmpty(this.m)) {
            this.k.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.s.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (s.this.lh != null) {
                        s.this.lh.w(s.this);
                    }
                }
            });
        }
        this.x.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.s.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.lh != null) {
                    s.this.lh.qg(s.this);
                }
            }
        });
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.s.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.lh != null) {
                    s.this.lh.s(s.this);
                }
            }
        });
        this.sz.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.s.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.lh != null) {
                    s.this.lh.q(s.this);
                }
            }
        });
        this.hd.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.s.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.lh != null) {
                    s.this.lh.n(s.this);
                }
            }
        });
    }

    private void x() {
        RelativeLayout relativeLayout;
        if (this.ln == null || (relativeLayout = this.bb) == null) {
            return;
        }
        final int childCount = relativeLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.bb.getChildAt(i).setVisibility(4);
        }
        this.ln.postDelayed(new Runnable() { // from class: com.byazt.mr.s.7
            @Override // java.lang.Runnable
            public void run() {
                s.this.s(childCount);
            }
        }, 10L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i) {
        try {
            Rect rect = new Rect();
            if (this.n.getResources().getConfiguration().orientation == 1) {
                this.d.getGlobalVisibleRect(rect);
            } else {
                this.hd.getGlobalVisibleRect(rect);
            }
            while (!this.qg.isEmpty()) {
                Rect rect2 = new Rect();
                View viewPop = this.qg.pop();
                if (viewPop != null && viewPop.getVisibility() != 8) {
                    viewPop.getGlobalVisibleRect(rect2);
                    if (rect2.top != 0 && rect.top >= rect2.bottom) {
                        break;
                    }
                    if (viewPop == this.l) {
                        View viewPop2 = this.qg.pop();
                        if (viewPop2 != null) {
                            viewPop2.setVisibility(8);
                        }
                    } else {
                        viewPop.setVisibility(8);
                    }
                }
            }
            if (this.qg.isEmpty()) {
                fs();
            }
        } catch (Throwable unused) {
        }
        this.bb.setVisibility(0);
        for (int i2 = 0; i2 < i; i2++) {
            this.bb.getChildAt(i2).setVisibility(0);
        }
    }

    private void fs() {
        RelativeLayout.LayoutParams layoutParams;
        Button button = this.hd;
        if (button != null) {
            ViewGroup.LayoutParams layoutParams2 = button.getLayoutParams();
            if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
                layoutParams3.bottomMargin = layoutParams3.topMargin;
                this.hd.setLayoutParams(layoutParams3);
            } else if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams2;
                layoutParams4.bottomMargin = layoutParams4.topMargin;
                this.hd.setLayoutParams(layoutParams4);
            }
        }
        com.byazt.kru.qg qgVar = this.cd;
        if (qgVar != null) {
            UgenLottieView ugenLottieViewRv = qgVar.rv();
            if (ugenLottieViewRv != null) {
                layoutParams = (RelativeLayout.LayoutParams) ugenLottieViewRv.getLayoutParams();
            } else {
                int iS = com.byazt.okk.s.s(this.n, 60.0f);
                layoutParams = new RelativeLayout.LayoutParams(iS, iS);
            }
            layoutParams.topMargin = -com.byazt.okk.s.s(this.n, 53.0f);
            this.cd.n(layoutParams);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        n nVar = this.lh;
        if (nVar != null) {
            nVar.s(this);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        s();
    }

    public void s() {
        String str;
        int iQ;
        if (this.n == null) {
            this.n = com.byazt.nf.rv.getContext();
        }
        int i = this.n.getResources().getConfiguration().orientation;
        TextView textView = this.l;
        if (textView != null) {
            textView.setText(this.um);
        } else {
            TTRoundRectImageView tTRoundRectImageView = this.q;
            if (tTRoundRectImageView != null) {
                tTRoundRectImageView.setVisibility(8);
            }
        }
        if (this.q != null && !TextUtils.isEmpty(this.a)) {
            com.byazt.imu.s.n(this.a).n(this.q);
        } else {
            TTRoundRectImageView tTRoundRectImageView2 = this.q;
            if (tTRoundRectImageView2 != null) {
                tTRoundRectImageView2.setVisibility(8);
            }
        }
        if (this.w != null) {
            if (TextUtils.isEmpty(this.py)) {
                this.w.setVisibility(8);
            } else {
                this.w.setText(this.py);
            }
        }
        if (this.fs != null) {
            JSONArray jSONArray = this.t;
            if (jSONArray == null || jSONArray.length() <= 0) {
                this.fs.setVisibility(8);
            } else {
                WindowManager windowManager = (WindowManager) this.n.getSystemService("window");
                Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
                if (defaultDisplay != null) {
                    int width = defaultDisplay.getWidth();
                    if (width > defaultDisplay.getHeight()) {
                        double dQ = com.byazt.okk.s.q(this.n, width);
                        iQ = ((int) (dQ - (0.38d * dQ))) - 80;
                    } else {
                        iQ = com.byazt.okk.s.q(this.n, width) - 36;
                    }
                } else {
                    iQ = 0;
                }
                int length = this.t.length() <= 3 ? this.t.length() : 3;
                for (int i2 = 0; i2 < length; i2++) {
                    String strOptString = this.t.optString(i2);
                    if (!TextUtils.isEmpty(strOptString)) {
                        TextView textView2 = new TextView(this.n);
                        textView2.setText(strOptString);
                        textView2.setTextSize(12.0f);
                        textView2.setTextColor(Color.parseColor("#161823"));
                        textView2.setAlpha(0.75f);
                        textView2.setBackgroundColor(Color.parseColor("#0F161823"));
                        int iS = com.byazt.okk.s.s(this.n, 6.0f);
                        textView2.setPadding(iS, 0, iS, 0);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        int iS2 = com.byazt.okk.s.s(this.n, 3.0f);
                        layoutParams.leftMargin = iS2;
                        layoutParams.rightMargin = iS2;
                        textView2.setLayoutParams(layoutParams);
                        TextPaint paint = textView2.getPaint();
                        Rect rect = new Rect();
                        paint.getTextBounds(strOptString, 0, strOptString.length(), rect);
                        iQ -= com.byazt.okk.s.q(this.n, rect.width()) + 20;
                        if (iQ >= 0) {
                            this.fs.addView(textView2);
                        } else {
                            if (this.fs.getChildCount() > 0) {
                                break;
                            }
                            this.fs.setVisibility(8);
                            break;
                        }
                    }
                }
            }
        }
        if (this.tj != null && this.cp != null) {
            float f = this.ur;
            if (f <= 0.0f) {
                LinearLayout linearLayout = this.rv;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                this.tj.setVisibility(8);
                this.cp.setVisibility(8);
            } else {
                if (f > 5.0f) {
                    f = 5.0f;
                }
                this.ur = f;
                this.cp.setText(new DecimalFormat(".0").format(this.ur));
                this.tj.setRating(this.ur);
                this.tj.n(com.byazt.okk.s.s(this.n, 16.0f), com.byazt.okk.s.s(this.n, 15.0f));
                this.tj.n(com.byazt.okk.s.s(this.n, 3.0f), 0, com.byazt.okk.s.s(this.n, 3.0f), 0);
                this.tj.n();
            }
        }
        if (this.d != null) {
            str = TextUtils.isEmpty(this.ou) ? String.format("版本号：%1$s", "暂无") : String.format("版本号：%1$s", this.ou);
            if (i == 2) {
                TextPaint paint2 = this.d.getPaint();
                Rect rect2 = new Rect();
                paint2.getTextBounds(str, 0, str.length(), rect2);
                double dTj = com.byazt.okk.s.tj(this.n);
                int iWidth = (((int) (dTj - (0.4d * dTj))) - rect2.width()) - com.byazt.okk.s.s(this.n, 106.0f);
                TextView textView3 = this.sz;
                if (textView3 != null) {
                    TextPaint paint3 = textView3.getPaint();
                    String string = this.sz.getText().toString();
                    paint3.getTextBounds(string, 0, string.length(), rect2);
                    iWidth -= rect2.width();
                }
                TextView textView4 = this.x;
                if (textView4 != null) {
                    TextPaint paint4 = textView4.getPaint();
                    String string2 = this.x.getText().toString();
                    paint4.getTextBounds(string2, 0, string2.length(), rect2);
                    iWidth -= rect2.width();
                }
                TextView textView5 = this.cy;
                if (textView5 != null) {
                    TextPaint paint5 = textView5.getPaint();
                    String string3 = this.cy.getText().toString();
                    paint5.getTextBounds(string3, 0, string3.length(), rect2);
                    iWidth -= rect2.width();
                }
                if (this.k != null && !TextUtils.isEmpty(this.m)) {
                    TextPaint paint6 = this.k.getPaint();
                    String string4 = this.k.getText().toString();
                    paint6.getTextBounds(string4, 0, TextUtils.isEmpty(string4) ? 0 : string4.length(), rect2);
                    iWidth -= rect2.width();
                }
                if (iWidth <= 0) {
                    ((LinearLayout.LayoutParams) this.d.getLayoutParams()).weight = 1.0f;
                }
            }
            if (i == 1) {
                this.d.setText(str);
            }
        } else {
            str = "";
        }
        TextView textView6 = this.oa;
        if (textView6 != null) {
            textView6.setSelected(true);
            String str2 = TextUtils.isEmpty(this.hu) ? String.format("开发者：%1$s", "补充中，可于应用官网查看") : String.format("开发者：%1$s", this.hu);
            if (i == 2) {
                str2 = str2 + "  " + str;
            }
            this.oa.setText(str2);
        }
    }

    public s n(String str) {
        this.um = str;
        return this;
    }

    public s qg(String str) {
        this.a = str;
        return this;
    }

    public s s(String str) {
        this.h = str;
        return this;
    }

    public s q(String str) {
        this.py = str;
        return this;
    }

    public s l(String str) {
        this.ou = str;
        return this;
    }

    public s w(String str) {
        this.wm = str;
        return this;
    }

    public s x(String str) {
        this.m = str;
        return this;
    }

    public s fs(String str) {
        this.hu = str;
        return this;
    }

    public s n(JSONArray jSONArray) {
        this.t = jSONArray;
        return this;
    }

    public s n(float f) {
        this.ur = f;
        return this;
    }

    public s n(n nVar) {
        this.lh = nVar;
        return this;
    }

    public String q() {
        return this.v;
    }

    public s rv(String str) {
        this.v = str;
        return this;
    }
}
