package com.byazt.wc;

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
import com.byazt.uk.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1487, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends Dialog {
    public String aj;
    public Activity c;
    public String fw;
    public boolean hn;
    public hn hw;
    public x pr;
    public String uc;
    public boolean x;
    public String zo;

    public c(Activity activity, String str, String str2, String str3, String str4, boolean z, x xVar, hn hnVar) {
        super(activity);
        this.c = activity;
        this.pr = xVar;
        this.uc = str;
        this.fw = str2;
        this.zo = str3;
        this.aj = str4;
        this.hw = hnVar;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCanceledOnTouchOutside(z);
        pr(this.c);
    }

    private void pr(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(pr(context, 290), -2);
        linearLayout2.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setBackground(pr(context, "#ffffff", 4));
        linearLayout2.setOrientation(1);
        int iPr = pr(context, 16);
        TextView textView = new TextView(context);
        textView.setTextSize(2, 16.0f);
        textView.setText("是否在WiFi环境下恢复下载？");
        textView.setTextColor(Color.parseColor("#222222"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(iPr, iPr, iPr, iPr);
        textView.setLayoutParams(layoutParams3);
        if (!TextUtils.isEmpty(this.uc)) {
            textView.setText(this.uc);
        }
        linearLayout2.addView(textView);
        LinearLayout linearLayout3 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = pr(context, 26);
        layoutParams4.bottomMargin = iPr;
        linearLayout3.setOrientation(0);
        linearLayout3.setLayoutParams(layoutParams4);
        TextView textView2 = new TextView(context);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(pr(context, 70), pr(context, 33)));
        textView2.setText("管理");
        textView2.setTextColor(Color.parseColor("#CFCFCF"));
        textView2.setTextSize(2, 13.0f);
        textView2.setGravity(17);
        if (!TextUtils.isEmpty(this.aj)) {
            textView2.setText(this.aj);
            linearLayout3.addView(textView2);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.wc.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.delete();
                }
            });
        }
        LinearLayout linearLayout4 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout4.setOrientation(0);
        layoutParams5.rightMargin = pr(context, 16);
        linearLayout4.setGravity(5);
        linearLayout4.setLayoutParams(layoutParams5);
        TextView textView3 = new TextView(context);
        textView3.setLayoutParams(new LinearLayout.LayoutParams(pr(context, 70), pr(context, 33)));
        textView3.setTextColor(Color.parseColor("#CFCFCF"));
        textView3.setText("不，谢谢");
        textView3.setTextSize(2, 13.0f);
        textView3.setGravity(17);
        if (!TextUtils.isEmpty(this.zo)) {
            textView3.setText(this.zo);
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.wc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hw();
            }
        });
        linearLayout4.addView(textView3);
        TextView textView4 = new TextView(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(pr(context, 70), pr(context, 33));
        layoutParams6.leftMargin = pr(context, 8);
        layoutParams6.gravity = 5;
        textView4.setLayoutParams(layoutParams6);
        textView4.setTextColor(Color.parseColor("#ffffff"));
        textView4.setTextSize(2, 13.0f);
        textView4.setText("好的");
        textView4.setGravity(17);
        if (!TextUtils.isEmpty(this.fw)) {
            textView4.setText(this.fw);
        }
        textView4.setBackground(pr(context, "#2A90D7", 2));
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.wc.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.pr();
            }
        });
        linearLayout4.addView(textView4);
        linearLayout3.addView(linearLayout4);
        linearLayout2.addView(linearLayout3);
        linearLayout.addView(linearLayout2);
        setContentView(linearLayout);
    }

    private static GradientDrawable pr(Context context, String str, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius(pr(context, i));
        return gradientDrawable;
    }

    private static int pr(Context context, int i) {
        return m.pr(context, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr() {
        this.hn = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        this.x = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw() {
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.c.isFinishing()) {
            this.c.finish();
        }
        if (this.hn) {
            this.pr.pr();
        } else if (this.x) {
            this.hw.delete();
        } else {
            this.pr.hw();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1487, 169})
    public static class pr {
        public String c;
        public x fw;
        public String hn;
        public String hw;
        public Activity pr;
        public boolean uc;
        public String x;
        public hn zo;

        public pr(Activity activity) {
            this.pr = activity;
        }

        public pr pr(String str) {
            this.hw = str;
            return this;
        }

        public pr hw(String str) {
            this.hn = str;
            return this;
        }

        public pr hn(String str) {
            this.x = str;
            return this;
        }

        public pr x(String str) {
            this.c = str;
            return this;
        }

        public pr pr(boolean z) {
            this.uc = z;
            return this;
        }

        public pr pr(x xVar) {
            this.fw = xVar;
            return this;
        }

        public pr pr(hn hnVar) {
            this.zo = hnVar;
            return this;
        }

        public c pr() {
            return new c(this.pr, this.hw, this.hn, this.x, this.c, this.uc, this.fw, this.zo);
        }
    }
}
