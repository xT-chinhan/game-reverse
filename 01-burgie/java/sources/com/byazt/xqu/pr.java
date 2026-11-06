package com.byazt.xqu;

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
import com.byazt.eld.k;
import com.byazt.hja.ClipImageView;
import com.byazt.uk.m;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 432, 37})
public class pr extends Dialog {
    public Activity aj;
    public TextView c;
    public ClipImageView fw;
    public TextView hn;
    public TextView hw;
    public final com.byazt.shh.hw k;
    public TextView pr;
    public TextView uc;
    public final long vk;
    public long w;
    public TextView x;
    public LinearLayout zo;

    public pr(Activity activity, long j) {
        super(activity);
        this.aj = activity;
        this.vk = j;
        this.k = (com.byazt.shh.hw) hn.pr().get(Long.valueOf(j));
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.k == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(pr());
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.w = this.k.hw;
        hw();
        fw.hw("lp_app_dialog_show", this.w);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.byazt.xqu.pr.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                fw.pr("lp_app_dialog_cancel", pr.this.w);
            }
        });
    }

    private View pr() {
        LinearLayout linearLayout = new LinearLayout(this.aj);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(m.pr(this.aj, 6.0f));
        linearLayout.setBackgroundDrawable(gradientDrawable);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(m.pr(this.aj, 300.0f), -2));
        this.fw = new ClipImageView(this.aj);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m.pr(this.aj, 60.0f), m.pr(this.aj, 60.0f));
        layoutParams.topMargin = m.pr(this.aj, 32.0f);
        this.fw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        linearLayout.addView(this.fw, layoutParams);
        this.pr = new TextView(this.aj);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = m.pr(this.aj, 8.0f);
        this.pr.setTextSize(1, 18.0f);
        this.pr.setTextColor(Color.parseColor("#161823"));
        this.pr.getPaint().setFakeBoldText(true);
        linearLayout.addView(this.pr, layoutParams2);
        this.hw = new TextView(this.aj);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = m.pr(this.aj, 8.0f);
        this.hw.setTextSize(1, 12.0f);
        this.hw.setTextColor(Color.parseColor("#4D161823"));
        linearLayout.addView(this.hw, layoutParams3);
        this.hn = new TextView(this.aj);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = m.pr(this.aj, 4.0f);
        this.hn.setTextSize(1, 12.0f);
        this.hn.setTextColor(Color.parseColor("#4D161823"));
        linearLayout.addView(this.hn, layoutParams4);
        LinearLayout linearLayout2 = new LinearLayout(this.aj);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        linearLayout2.setPadding(0, m.pr(this.aj, 4.0f), 0, m.pr(this.aj, 4.0f));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = m.pr(this.aj, 14.0f);
        TextView textView = new TextView(this.aj);
        this.x = textView;
        textView.setText("权限详情");
        this.x.setTextSize(1, 12.0f);
        this.x.setTextColor(Color.parseColor("#4E90FF"));
        linearLayout2.addView(this.x);
        View view = new View(this.aj);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) ((((double) this.aj.getResources().getDisplayMetrics().density) * 0.5d) + 0.5d), m.pr(this.aj, 9.0f));
        layoutParams6.leftMargin = m.pr(this.aj, 32.0f);
        layoutParams6.rightMargin = m.pr(this.aj, 32.0f);
        view.setBackgroundColor(Color.parseColor("#D8D8D8"));
        linearLayout2.addView(view, layoutParams6);
        TextView textView2 = new TextView(this.aj);
        this.c = textView2;
        textView2.setText("隐私政策");
        this.c.setTextSize(1, 12.0f);
        this.c.setTextColor(Color.parseColor("#4E90FF"));
        linearLayout2.addView(this.c);
        linearLayout.addView(linearLayout2, layoutParams5);
        LinearLayout linearLayout3 = new LinearLayout(this.aj);
        this.zo = linearLayout3;
        linearLayout3.setOrientation(0);
        this.zo.setGravity(17);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#4E90FF"));
        gradientDrawable2.setCornerRadius(m.pr(this.aj, 2.0f));
        this.zo.setBackgroundDrawable(gradientDrawable2);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(m.pr(this.aj, 276.0f), m.pr(this.aj, 36.0f));
        layoutParams7.topMargin = m.pr(this.aj, 16.0f);
        ImageView imageView = new ImageView(this.aj);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(m.pr(this.aj, 16.0f), m.pr(this.aj, 16.0f));
        layoutParams8.rightMargin = m.pr(this.aj, 4.0f);
        this.zo.addView(imageView, layoutParams8);
        TextView textView3 = new TextView(this.aj);
        textView3.setText("立即下载");
        textView3.setTextColor(-1);
        textView3.setTextSize(1, 14.0f);
        this.zo.addView(textView3);
        linearLayout.addView(this.zo, layoutParams7);
        TextView textView4 = new TextView(this.aj);
        this.uc = textView4;
        textView4.setText("放弃下载");
        this.uc.setTextSize(1, 12.0f);
        this.uc.setTextColor(Color.parseColor("#4D161823"));
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.topMargin = m.pr(this.aj, 11.0f);
        layoutParams9.bottomMargin = m.pr(this.aj, 15.0f);
        linearLayout.addView(this.uc, layoutParams9);
        imageView.setImageDrawable(new com.byazt.kht.pr());
        return linearLayout;
    }

    private void hw() {
        this.pr.setText(m.pr(this.k.c, "--"));
        this.hw.setText("版本号：" + m.pr(this.k.uc, "--"));
        this.hn.setText("开发者：" + m.pr(this.k.fw, "应用信息正在完善中"));
        this.fw.setRoundRadius(m.pr(k.getContext(), 8.0f));
        this.fw.setBackgroundColor(Color.parseColor("#EBEBEB"));
        x.pr().pr(this.vk, new x.pr() { // from class: com.byazt.xqu.pr.2
            @Override // com.byazt.xqu.x.pr
            public void pr(Bitmap bitmap) {
                if (bitmap != null) {
                    pr.this.fw.setImageBitmap(bitmap);
                } else {
                    fw.pr(8, pr.this.w);
                }
            }
        });
        this.x.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.xqu.pr.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hw.pr().pr(pr.this.aj);
                fw.pr("lp_app_dialog_click_detail", pr.this.w);
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.xqu.pr.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hw.pr().pr(pr.this.aj);
                fw.pr("lp_app_dialog_click_privacy", pr.this.w);
            }
        });
        this.uc.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.xqu.pr.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pr.this.dismiss();
                fw.pr("lp_app_dialog_click_giveup", pr.this.w);
            }
        });
        this.zo.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.xqu.pr.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                fw.pr("lp_app_dialog_click_download", pr.this.w);
                hw.pr().hw(pr.this.w);
                pr.this.dismiss();
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.byazt.mdu.hn.pr(this.aj);
    }
}
