package com.byazt.nc;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.sd.a;
import com.byazt.wt.er;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 52, 74})
public class nt extends AlertDialog {
    public boolean hn;
    public String hw;
    public Context pr;
    public pr x;

    public interface pr {
        void hw(String str);

        void pr(String str);
    }

    public nt(Context context, String str) {
        super(context);
        this.pr = context;
        this.hw = str;
        this.hn = TextUtils.isEmpty(str);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.sdv.uc.hw(this);
        setCanceledOnTouchOutside(false);
        if (this.pr == null) {
            this.pr = a.getContext();
        }
        pr();
    }

    private void pr() {
        setContentView(hw());
    }

    private View hw() {
        LinearLayout linearLayout = new LinearLayout(this.pr);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        linearLayout.setGravity(17);
        TextView textView = new TextView(this.pr);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        textView.setLayoutParams(layoutParams2);
        textView.setText("您要访问的网站存在风险");
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        linearLayout.addView(textView);
        int iHn = er.hn(this.pr, 10.0f) * 2;
        TextView textView2 = new TextView(this.pr);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = iHn;
        layoutParams3.gravity = 17;
        textView2.setLayoutParams(layoutParams3);
        textView2.setText("继续访问可能导致个人隐私泄漏、账号被盗用等危害");
        textView2.setTextColor(-1);
        textView2.setTextSize(15.0f);
        linearLayout.addView(textView2);
        int iHn2 = er.hn(this.pr, 25.0f);
        int iHn3 = er.hn(this.pr, 8.0f);
        if (!this.hn) {
            Button button = new Button(this.pr);
            button.setBackgroundColor(-7829368);
            button.setText("继续访问");
            button.setTextColor(-1);
            button.setPadding(iHn2, iHn3, iHn2, iHn3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(er.hn(this.pr, 230.0f), -2);
            layoutParams4.topMargin = iHn;
            layoutParams4.gravity = 17;
            button.setLayoutParams(layoutParams4);
            button.setTextSize(25.0f);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.nt.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    nt.this.dismiss();
                    if (nt.this.x != null) {
                        nt.this.x.pr(nt.this.hw);
                    }
                }
            });
            linearLayout.addView(button);
        }
        Button button2 = new Button(this.pr);
        button2.setBackgroundColor(SupportMenu.CATEGORY_MASK);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(er.hn(this.pr, 230.0f), -2);
        layoutParams5.topMargin = iHn;
        layoutParams5.gravity = 17;
        button2.setLayoutParams(layoutParams5);
        button2.setText("返回安全链接");
        button2.setTextColor(-1);
        button2.setTextSize(25.0f);
        button2.setTypeface(null, 1);
        button2.setPadding(iHn2, iHn3, iHn2, iHn3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.nt.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                nt.this.dismiss();
                if (nt.this.x != null) {
                    nt.this.x.hw(nt.this.hw);
                }
            }
        });
        linearLayout.addView(button2);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        pr prVar = this.x;
        if (prVar == null) {
            return;
        }
        prVar.hw(this.hw);
    }

    public void pr(pr prVar) {
        this.x = prVar;
    }
}
