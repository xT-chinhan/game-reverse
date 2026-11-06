package com.mcto.sspsdk.internal;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.ssp.taskpage.QyTaskPageActivity;

/* JADX INFO: loaded from: classes2.dex */
public final class sk extends hd implements View.OnClickListener {
    public final TextView a;
    public final TextView b;
    public final boolean c;
    public final ie d;

    public sk(QyTaskPageActivity qyTaskPageActivity, rk rkVar) {
        super(qyTaskPageActivity);
        this.c = true;
        this.d = rkVar.f;
        setContentView(R.layout.qy_layout_task_page_vip_dialog);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.qy_dialog_content);
        TextView textView = (TextView) findViewById(R.id.qy_dialog_title);
        String str = rkVar.b;
        if (str != null) {
            textView.setText(str);
        }
        if (rkVar.a) {
            TextView textView2 = (TextView) findViewById(R.id.qy_dialog_negative_btn);
            this.b = textView2;
            textView2.setVisibility(0);
            textView2.setText(rkVar.e);
            textView2.setOnClickListener(this);
        }
        TextView textView3 = (TextView) findViewById(R.id.qy_dialog_positive_btn);
        this.a = textView3;
        textView3.setText(rkVar.d);
        textView3.setOnClickListener(this);
        String str2 = rkVar.c;
        if (str2 == null) {
            return;
        }
        if (str2.startsWith("http")) {
            WebView webView = new WebView(getContext());
            webView.setBackgroundColor(0);
            webView.loadUrl(str2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, hk.a(getContext(), 230.0f));
            frameLayout.setVisibility(0);
            frameLayout.addView(webView, layoutParams);
            return;
        }
        TextView textView4 = new TextView(getContext());
        textView4.setText(str2);
        textView4.setTextSize(1, 13.0f);
        textView4.setTextColor(-1728053248);
        textView4.setGravity(17);
        frameLayout.setVisibility(0);
        frameLayout.addView(textView4, new ViewGroup.LayoutParams(-1, -2));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.a) {
            if (this.c) {
                dismiss();
            }
        } else if (view == this.b) {
            ie ieVar = this.d;
            if (ieVar != null) {
                ieVar.a.finish();
            }
            if (this.c) {
                dismiss();
            }
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
