package com.byazt.mr;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.byazt.ho.BaseConstants;
import com.byazt.kfh.SSWebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 18})
public class l extends AlertDialog {
    public static volatile AtomicInteger s = new AtomicInteger(0);
    public Button fs;
    public Context l;
    public String n;
    public SSWebView q;
    public String qg;
    public n rv;
    public ImageView w;
    public Button x;

    public interface n {
        void n(Dialog dialog);

        void qg(Dialog dialog);

        void s(Dialog dialog);
    }

    public l(Context context, String str, String str2, String str3) {
        super(context);
        this.l = context;
        this.n = str;
        this.qg = str3;
        if (TextUtils.isEmpty(str) || !(this.n.startsWith(BaseConstants.SCHEME_HTTPS) || this.n.startsWith("http"))) {
            this.n = str2;
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.cb.s.qg(this);
        if (this.l == null) {
            this.l = com.byazt.nf.rv.getContext();
        }
        n();
    }

    private View n(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.l);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.l);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this.l);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(com.byazt.okk.s.s(this.l, 8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        RelativeLayout relativeLayout = new RelativeLayout(this.l);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.l);
        this.w = imageView;
        imageView.setMaxHeight(com.byazt.okk.s.s(this.l, 46.0f));
        this.w.setMaxWidth(com.byazt.okk.s.s(this.l, 46.0f));
        this.w.setMinimumHeight(com.byazt.okk.s.s(this.l, 46.0f));
        this.w.setMinimumWidth(com.byazt.okk.s.s(this.l, 46.0f));
        this.w.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.byazt.xn.qg qgVar = new com.byazt.xn.qg(com.byazt.okk.s.s(this.l, 14.0f));
        qgVar.n(ViewCompat.MEASURED_STATE_MASK);
        qgVar.n(com.byazt.okk.s.s(this.l, 2.0f));
        this.w.setImageDrawable(qgVar);
        relativeLayout.addView(this.w);
        TextView textView = new TextView(this.l);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams4.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText(this.qg);
        textView.setLayoutParams(layoutParams4);
        relativeLayout.addView(textView);
        linearLayout2.addView(relativeLayout);
        View view2 = new View(this.l);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, com.byazt.okk.s.s(this.l, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view2);
        this.q = new SSWebView(this.l);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams5.weight = 1.0f;
        this.q.setLayoutParams(layoutParams5);
        linearLayout2.addView(this.q);
        View view3 = new View(this.l);
        view3.setLayoutParams(new LinearLayout.LayoutParams(-1, com.byazt.okk.s.s(this.l, 1.0f)));
        view3.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view3);
        LinearLayout linearLayout3 = new LinearLayout(this.l);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setOrientation(0);
        int iS = com.byazt.okk.s.s(this.l, 16.0f);
        linearLayout3.setPadding(iS, iS, iS, iS);
        linearLayout3.setLayoutParams(layoutParams6);
        linearLayout2.addView(linearLayout3);
        this.fs = new Button(this.l);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -2);
        int iS2 = com.byazt.okk.s.s(this.l, 7.0f);
        layoutParams7.leftMargin = iS2;
        layoutParams7.rightMargin = iS2;
        layoutParams7.weight = 1.0f;
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(com.byazt.okk.s.s(this.l, 3.0f));
        gradientDrawable2.setStroke(com.byazt.okk.s.s(this.l, 0.5f), Color.parseColor("#E0161823"));
        this.fs.setBackground(gradientDrawable2);
        int iS3 = com.byazt.okk.s.s(this.l, 12.0f);
        this.fs.setText("上一步");
        this.fs.setPadding(0, iS3, 0, iS3);
        this.fs.setTextColor(Color.parseColor("#A8161823"));
        this.fs.setLayoutParams(layoutParams7);
        linearLayout3.addView(this.fs);
        this.x = new Button(this.l);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -2);
        layoutParams8.leftMargin = iS2;
        layoutParams8.rightMargin = iS2;
        layoutParams8.weight = 1.0f;
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable3.setCornerRadius(com.byazt.okk.s.s(this.l, 3.0f));
        this.x.setBackground(gradientDrawable3);
        this.x.setText("立即下载");
        this.x.setPadding(0, iS3, 0, iS3);
        this.x.setTextColor(-1);
        this.x.setLayoutParams(layoutParams8);
        linearLayout3.addView(this.x);
        if (i == 0) {
            return linearLayout;
        }
        View view4 = new View(this.l);
        view4.setLayoutParams(new LinearLayout.LayoutParams(-1, com.byazt.okk.s.s(this.l, 34.0f)));
        linearLayout2.addView(view4);
        return linearLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n() {
        if (this.l.getResources().getConfiguration().orientation == 1) {
            setContentView(n(1));
        } else {
            setContentView(n(0));
        }
        this.w.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.s.set(0);
                if (l.this.rv != null) {
                    l.this.rv.qg(l.this);
                }
            }
        });
        this.fs.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.s.set(0);
                if (l.this.rv != null) {
                    l.this.rv.s(l.this);
                }
            }
        });
        this.x.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.s.set(0);
                if (l.this.rv != null) {
                    l.this.rv.n(l.this);
                }
            }
        });
        this.q.setWebViewClient(new com.byazt.dho.s(this.l, null, 0 == true ? 1 : 0) { // from class: com.byazt.mr.l.4
            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (webView == null) {
                    return true;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        return true;
                    }
                    String scheme = Uri.parse(str).getScheme();
                    if (TextUtils.isEmpty(scheme)) {
                        return true;
                    }
                    String lowerCase = scheme.toLowerCase(Locale.ROOT);
                    if (!lowerCase.contains("http") && !lowerCase.contains(BaseConstants.SCHEME_HTTPS)) {
                        return true;
                    }
                    webView.loadUrl(str);
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }

            @Override // com.byazt.dho.s
            public boolean n(WebView webView, WebResourceRequest webResourceRequest) {
                this.fs = l.s;
                return super.n(webView, webResourceRequest);
            }

            @Override // com.byazt.dho.s
            public boolean n(WebView webView, String str) {
                this.fs = l.s;
                return super.n(webView, str);
            }
        });
        this.q.setJavaScriptEnabled(true);
        this.q.setDisplayZoomControls(false);
        this.q.setCacheMode(2);
        this.q.loadUrl(this.n);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        s.set(0);
        n nVar = this.rv;
        if (nVar != null) {
            nVar.qg(this);
        }
    }

    public l n(n nVar) {
        this.rv = nVar;
        return this;
    }
}
