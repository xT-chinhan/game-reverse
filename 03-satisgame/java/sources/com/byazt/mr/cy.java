package com.byazt.mr;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy extends AlertDialog {
    public Context n;
    public n q;
    public String qg;
    public boolean s;

    public interface n {
        void n(String str);

        void qg(String str);
    }

    public cy(Context context, String str) {
        super(context);
        this.n = context;
        this.qg = str;
        this.s = TextUtils.isEmpty(str);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.cb.s.qg(this);
        setCanceledOnTouchOutside(false);
        if (this.n == null) {
            this.n = com.byazt.nf.rv.getContext();
        }
        n();
    }

    private void n() {
        setContentView(qg());
    }

    private View qg() {
        LinearLayout linearLayout = new LinearLayout(this.n);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        linearLayout.setGravity(17);
        TextView textView = new TextView(this.n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        textView.setLayoutParams(layoutParams2);
        textView.setText("您要访问的网站存在风险");
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        linearLayout.addView(textView);
        int iS = com.byazt.okk.s.s(this.n, 10.0f) * 2;
        TextView textView2 = new TextView(this.n);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = iS;
        layoutParams3.gravity = 17;
        textView2.setLayoutParams(layoutParams3);
        textView2.setText("继续访问可能导致个人隐私泄漏、账号被盗用等危害");
        textView2.setTextColor(-1);
        textView2.setTextSize(15.0f);
        linearLayout.addView(textView2);
        int iS2 = com.byazt.okk.s.s(this.n, 25.0f);
        int iS3 = com.byazt.okk.s.s(this.n, 8.0f);
        if (!this.s) {
            Button button = new Button(this.n);
            button.setBackgroundColor(-7829368);
            button.setText("继续访问");
            button.setTextColor(-1);
            button.setPadding(iS2, iS3, iS2, iS3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.byazt.okk.s.s(this.n, 230.0f), -2);
            layoutParams4.topMargin = iS;
            layoutParams4.gravity = 17;
            button.setLayoutParams(layoutParams4);
            button.setTextSize(25.0f);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.cy.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    cy.this.dismiss();
                    if (cy.this.q == null) {
                        return;
                    }
                    cy.this.q.n(cy.this.qg);
                }
            });
            linearLayout.addView(button);
        }
        Button button2 = new Button(this.n);
        button2.setBackgroundColor(SupportMenu.CATEGORY_MASK);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(com.byazt.okk.s.s(this.n, 230.0f), -2);
        layoutParams5.topMargin = iS;
        layoutParams5.gravity = 17;
        button2.setLayoutParams(layoutParams5);
        button2.setText("返回安全链接");
        button2.setTextColor(-1);
        button2.setTextSize(25.0f);
        button2.setTypeface(null, 1);
        button2.setPadding(iS2, iS3, iS2, iS3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.cy.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                cy.this.dismiss();
                if (cy.this.q == null) {
                    return;
                }
                cy.this.q.qg(cy.this.qg);
            }
        });
        linearLayout.addView(button2);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        n nVar = this.q;
        if (nVar == null) {
            return;
        }
        nVar.qg(this.qg);
    }

    public void n(n nVar) {
        this.q = nVar;
    }
}
