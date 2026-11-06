package com.byazt.su;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.gs.ClipImageView;
import com.byazt.rz.oa;
import com.byazt.ug.d;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 726, 19})
public class n extends Dialog {
    public long cp;
    public final com.byazt.vl.qg d;
    public LinearLayout fs;
    public TextView l;
    public TextView n;
    public TextView q;
    public TextView qg;
    public Activity rv;
    public TextView s;
    public final long tj;
    public TextView w;
    public ClipImageView x;

    public n(Activity activity, long j) {
        super(activity);
        this.rv = activity;
        this.tj = j;
        this.d = (com.byazt.vl.qg) s.n().get(Long.valueOf(j));
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.d == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(n());
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.cp = this.d.qg;
        qg();
        x.qg("lp_app_dialog_show", this.cp);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.byazt.su.n.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                x.n("lp_app_dialog_cancel", n.this.cp);
            }
        });
    }

    private View n() {
        LinearLayout linearLayout = new LinearLayout(this.rv);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(oa.n(this.rv, 6.0f));
        linearLayout.setBackgroundDrawable(gradientDrawable);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(oa.n(this.rv, 300.0f), -2));
        this.x = new ClipImageView(this.rv);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(oa.n(this.rv, 60.0f), oa.n(this.rv, 60.0f));
        layoutParams.topMargin = oa.n(this.rv, 32.0f);
        this.x.setScaleType(ImageView.ScaleType.CENTER_CROP);
        linearLayout.addView(this.x, layoutParams);
        this.n = new TextView(this.rv);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = oa.n(this.rv, 8.0f);
        this.n.setTextSize(1, 18.0f);
        this.n.setTextColor(Color.parseColor("#161823"));
        this.n.getPaint().setFakeBoldText(true);
        linearLayout.addView(this.n, layoutParams2);
        this.qg = new TextView(this.rv);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = oa.n(this.rv, 8.0f);
        this.qg.setTextSize(1, 12.0f);
        this.qg.setTextColor(Color.parseColor("#4D161823"));
        linearLayout.addView(this.qg, layoutParams3);
        this.s = new TextView(this.rv);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = oa.n(this.rv, 4.0f);
        this.s.setTextSize(1, 12.0f);
        this.s.setTextColor(Color.parseColor("#4D161823"));
        linearLayout.addView(this.s, layoutParams4);
        LinearLayout linearLayout2 = new LinearLayout(this.rv);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        linearLayout2.setPadding(0, oa.n(this.rv, 4.0f), 0, oa.n(this.rv, 4.0f));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = oa.n(this.rv, 14.0f);
        TextView textView = new TextView(this.rv);
        this.q = textView;
        textView.setText("权限详情");
        this.q.setTextSize(1, 12.0f);
        this.q.setTextColor(Color.parseColor("#4E90FF"));
        linearLayout2.addView(this.q);
        View view = new View(this.rv);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) ((((double) this.rv.getResources().getDisplayMetrics().density) * 0.5d) + 0.5d), oa.n(this.rv, 9.0f));
        layoutParams6.leftMargin = oa.n(this.rv, 32.0f);
        layoutParams6.rightMargin = oa.n(this.rv, 32.0f);
        view.setBackgroundColor(Color.parseColor("#D8D8D8"));
        linearLayout2.addView(view, layoutParams6);
        TextView textView2 = new TextView(this.rv);
        this.l = textView2;
        textView2.setText("隐私政策");
        this.l.setTextSize(1, 12.0f);
        this.l.setTextColor(Color.parseColor("#4E90FF"));
        linearLayout2.addView(this.l);
        linearLayout.addView(linearLayout2, layoutParams5);
        LinearLayout linearLayout3 = new LinearLayout(this.rv);
        this.fs = linearLayout3;
        linearLayout3.setOrientation(0);
        this.fs.setGravity(17);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#4E90FF"));
        gradientDrawable2.setCornerRadius(oa.n(this.rv, 2.0f));
        this.fs.setBackgroundDrawable(gradientDrawable2);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(oa.n(this.rv, 276.0f), oa.n(this.rv, 36.0f));
        layoutParams7.topMargin = oa.n(this.rv, 16.0f);
        ImageView imageView = new ImageView(this.rv);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(oa.n(this.rv, 16.0f), oa.n(this.rv, 16.0f));
        layoutParams8.rightMargin = oa.n(this.rv, 4.0f);
        this.fs.addView(imageView, layoutParams8);
        TextView textView3 = new TextView(this.rv);
        textView3.setText("立即下载");
        textView3.setTextColor(-1);
        textView3.setTextSize(1, 14.0f);
        this.fs.addView(textView3);
        linearLayout.addView(this.fs, layoutParams7);
        TextView textView4 = new TextView(this.rv);
        this.w = textView4;
        textView4.setText("放弃下载");
        this.w.setTextSize(1, 12.0f);
        this.w.setTextColor(Color.parseColor("#4D161823"));
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.topMargin = oa.n(this.rv, 11.0f);
        layoutParams9.bottomMargin = oa.n(this.rv, 15.0f);
        linearLayout.addView(this.w, layoutParams9);
        imageView.setImageDrawable(new com.byazt.pz.n());
        return linearLayout;
    }

    private void qg() {
        this.n.setText(oa.n(this.d.l, "--"));
        this.qg.setText("版本号：" + oa.n(this.d.w, "--"));
        this.s.setText("开发者：" + oa.n(this.d.x, "应用信息正在完善中"));
        this.x.setRoundRadius(oa.n(d.getContext(), 8.0f));
        this.x.setBackgroundColor(Color.parseColor("#EBEBEB"));
        q.n().n(this.tj, new q.n() { // from class: com.byazt.su.n.2
            @Override // com.byazt.su.q.n
            public void n(Bitmap bitmap) {
                if (bitmap != null) {
                    n.this.x.setImageBitmap(bitmap);
                } else {
                    x.n(8, n.this.cp);
                }
            }
        });
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.su.n.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                qg.n().n(n.this.rv);
                x.n("lp_app_dialog_click_detail", n.this.cp);
            }
        });
        this.l.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.su.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                qg.n().n(n.this.rv);
                x.n("lp_app_dialog_click_privacy", n.this.cp);
            }
        });
        this.w.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.su.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.this.dismiss();
                x.n("lp_app_dialog_click_giveup", n.this.cp);
            }
        });
        this.fs.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.su.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x.n("lp_app_dialog_click_download", n.this.cp);
                qg.n().qg(n.this.cp);
                n.this.dismiss();
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.byazt.e.s.n(this.rv);
    }
}
