package com.byazt.bn;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.rz.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1240, 18})
public class l extends Dialog {
    public String fs;
    public Activity l;
    public q n;
    public boolean q;
    public s qg;
    public String rv;
    public boolean s;
    public String w;
    public String x;

    public l(Activity activity, String str, String str2, String str3, String str4, boolean z, q qVar, s sVar) {
        super(activity);
        this.l = activity;
        this.n = qVar;
        this.w = str;
        this.x = str2;
        this.fs = str3;
        this.rv = str4;
        this.qg = sVar;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCanceledOnTouchOutside(z);
        n(this.l);
    }

    private void n(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(n(context, 290), -2);
        linearLayout2.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setBackground(n(context, "#ffffff", 4));
        linearLayout2.setOrientation(1);
        int iN = n(context, 16);
        TextView textView = new TextView(context);
        textView.setTextSize(2, 16.0f);
        textView.setText("是否在WiFi环境下恢复下载？");
        textView.setTextColor(Color.parseColor("#222222"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(iN, iN, iN, iN);
        textView.setLayoutParams(layoutParams3);
        if (!TextUtils.isEmpty(this.w)) {
            textView.setText(this.w);
        }
        linearLayout2.addView(textView);
        LinearLayout linearLayout3 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = n(context, 26);
        layoutParams4.bottomMargin = iN;
        linearLayout3.setOrientation(0);
        linearLayout3.setLayoutParams(layoutParams4);
        TextView textView2 = new TextView(context);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(n(context, 70), n(context, 33)));
        textView2.setText("管理");
        textView2.setTextColor(Color.parseColor("#CFCFCF"));
        textView2.setTextSize(2, 13.0f);
        textView2.setGravity(17);
        if (!TextUtils.isEmpty(this.rv)) {
            textView2.setText(this.rv);
            linearLayout3.addView(textView2);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.bn.l.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    l.this.delete();
                }
            });
        }
        LinearLayout linearLayout4 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout4.setOrientation(0);
        layoutParams5.rightMargin = n(context, 16);
        linearLayout4.setGravity(5);
        linearLayout4.setLayoutParams(layoutParams5);
        TextView textView3 = new TextView(context);
        textView3.setLayoutParams(new LinearLayout.LayoutParams(n(context, 70), n(context, 33)));
        textView3.setTextColor(Color.parseColor("#CFCFCF"));
        textView3.setText("不，谢谢");
        textView3.setTextSize(2, 13.0f);
        textView3.setGravity(17);
        if (!TextUtils.isEmpty(this.fs)) {
            textView3.setText(this.fs);
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.bn.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.this.qg();
            }
        });
        linearLayout4.addView(textView3);
        TextView textView4 = new TextView(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(n(context, 70), n(context, 33));
        layoutParams6.leftMargin = n(context, 8);
        layoutParams6.gravity = 5;
        textView4.setLayoutParams(layoutParams6);
        textView4.setTextColor(Color.parseColor("#ffffff"));
        textView4.setTextSize(2, 13.0f);
        textView4.setText("好的");
        textView4.setGravity(17);
        if (!TextUtils.isEmpty(this.x)) {
            textView4.setText(this.x);
        }
        textView4.setBackground(n(context, "#2A90D7", 2));
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.bn.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.this.n();
            }
        });
        linearLayout4.addView(textView4);
        linearLayout3.addView(linearLayout4);
        linearLayout2.addView(linearLayout3);
        linearLayout.addView(linearLayout2);
        setContentView(linearLayout);
    }

    private static GradientDrawable n(Context context, String str, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius(n(context, i));
        return gradientDrawable;
    }

    private static int n(Context context, int i) {
        return oa.n(context, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.s = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        this.q = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg() {
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.l.isFinishing()) {
            this.l.finish();
        }
        if (this.s) {
            this.n.n();
        } else if (this.q) {
            this.qg.delete();
        } else {
            this.n.qg();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @com.byazt.cp.n(n = {0, 1, 1240, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static class n {
        public s fs;
        public String l;
        public Activity n;
        public String q;
        public String qg;
        public String s;
        public boolean w;
        public q x;

        public n(Activity activity) {
            this.n = activity;
        }

        public n n(String str) {
            this.qg = str;
            return this;
        }

        public n qg(String str) {
            this.s = str;
            return this;
        }

        public n s(String str) {
            this.q = str;
            return this;
        }

        public n q(String str) {
            this.l = str;
            return this;
        }

        public n n(boolean z) {
            this.w = z;
            return this;
        }

        public n n(q qVar) {
            this.x = qVar;
            return this;
        }

        public n n(s sVar) {
            this.fs = sVar;
            return this;
        }

        public l n() {
            return new l(this.n, this.qg, this.s, this.q, this.l, this.w, this.x, this.fs);
        }
    }
}
