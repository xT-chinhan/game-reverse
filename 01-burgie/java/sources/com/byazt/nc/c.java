package com.byazt.nc;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
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
import com.byazt.fi.BaseConstants;
import com.byazt.fj.SSWebView;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 52, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends AlertDialog {
    public static volatile AtomicInteger hn = new AtomicInteger(0);
    public pr aj;
    public Context c;
    public Button fw;
    public String hw;
    public String pr;
    public ImageView uc;
    public SSWebView x;
    public Button zo;

    public interface pr {
        void hn(Dialog dialog);

        void hw(Dialog dialog);

        void pr(Dialog dialog);
    }

    public c(Context context, String str, String str2, String str3) {
        super(context);
        this.c = context;
        this.pr = str;
        this.hw = str3;
        if (TextUtils.isEmpty(str) || (!this.pr.startsWith(BaseConstants.SCHEME_HTTPS) && !this.pr.startsWith("http"))) {
            this.pr = str2;
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.sdv.uc.hw(this);
        if (this.c == null) {
            this.c = a.getContext();
        }
        pr();
    }

    private View pr(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.c);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.c);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this.c);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(er.hn(this.c, 8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        RelativeLayout relativeLayout = new RelativeLayout(this.c);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.c);
        this.uc = imageView;
        imageView.setMaxHeight(er.hn(this.c, 46.0f));
        this.uc.setMaxWidth(er.hn(this.c, 46.0f));
        this.uc.setMinimumHeight(er.hn(this.c, 46.0f));
        this.uc.setMinimumWidth(er.hn(this.c, 46.0f));
        this.uc.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.byazt.sdv.hw hwVar = new com.byazt.sdv.hw(er.hn(this.c, 14.0f));
        hwVar.pr(ViewCompat.MEASURED_STATE_MASK);
        hwVar.pr(er.hn(this.c, 2.0f));
        this.uc.setImageDrawable(hwVar);
        relativeLayout.addView(this.uc);
        TextView textView = new TextView(this.c);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams4.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText(this.hw);
        textView.setLayoutParams(layoutParams4);
        relativeLayout.addView(textView);
        linearLayout2.addView(relativeLayout);
        View view2 = new View(this.c);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, er.hn(this.c, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view2);
        this.x = new SSWebView(this.c);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams5.weight = 1.0f;
        this.x.setLayoutParams(layoutParams5);
        linearLayout2.addView(this.x);
        View view3 = new View(this.c);
        view3.setLayoutParams(new LinearLayout.LayoutParams(-1, er.hn(this.c, 1.0f)));
        view3.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view3);
        LinearLayout linearLayout3 = new LinearLayout(this.c);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setOrientation(0);
        int iHn = er.hn(this.c, 16.0f);
        linearLayout3.setPadding(iHn, iHn, iHn, iHn);
        linearLayout3.setLayoutParams(layoutParams6);
        linearLayout2.addView(linearLayout3);
        this.zo = new Button(this.c);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -2);
        int iHn2 = er.hn(this.c, 7.0f);
        layoutParams7.leftMargin = iHn2;
        layoutParams7.rightMargin = iHn2;
        layoutParams7.weight = 1.0f;
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(er.hn(this.c, 3.0f));
        gradientDrawable2.setStroke(er.hn(this.c, 0.5f), Color.parseColor("#E0161823"));
        this.zo.setBackground(gradientDrawable2);
        int iHn3 = er.hn(this.c, 12.0f);
        this.zo.setText("上一步");
        this.zo.setPadding(0, iHn3, 0, iHn3);
        this.zo.setTextColor(Color.parseColor("#A8161823"));
        this.zo.setLayoutParams(layoutParams7);
        linearLayout3.addView(this.zo);
        this.fw = new Button(this.c);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -2);
        layoutParams8.leftMargin = iHn2;
        layoutParams8.rightMargin = iHn2;
        layoutParams8.weight = 1.0f;
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable3.setCornerRadius(er.hn(this.c, 3.0f));
        this.fw.setBackground(gradientDrawable3);
        this.fw.setText("立即下载");
        this.fw.setPadding(0, iHn3, 0, iHn3);
        this.fw.setTextColor(-1);
        this.fw.setLayoutParams(layoutParams8);
        linearLayout3.addView(this.fw);
        if (i == 0) {
            return linearLayout;
        }
        View view4 = new View(this.c);
        view4.setLayoutParams(new LinearLayout.LayoutParams(-1, er.hn(this.c, 34.0f)));
        linearLayout2.addView(view4);
        return linearLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pr() {
        if (this.c.getResources().getConfiguration().orientation == 1) {
            setContentView(pr(1));
        } else {
            setContentView(pr(0));
        }
        this.uc.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.hn.set(0);
                if (c.this.aj != null) {
                    c.this.aj.hw(c.this);
                }
            }
        });
        this.zo.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.hn.set(0);
                if (c.this.aj != null) {
                    c.this.aj.hn(c.this);
                }
            }
        });
        this.fw.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.hn.set(0);
                if (c.this.aj != null) {
                    c.this.aj.pr(c.this);
                }
            }
        });
        this.x.setWebViewClient(new com.byazt.lz.x(this.c, null, 0 == true ? 1 : 0) { // from class: com.byazt.nc.c.4
            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (webView != null) {
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            String scheme = Uri.parse(str).getScheme();
                            if (!TextUtils.isEmpty(scheme)) {
                                String lowerCase = scheme.toLowerCase(Locale.ROOT);
                                if (lowerCase.contains("http") || lowerCase.contains(BaseConstants.SCHEME_HTTPS)) {
                                    webView.loadUrl(str);
                                    return true;
                                }
                                return true;
                            }
                            return true;
                        }
                        return true;
                    } catch (Exception e) {
                        return true;
                    }
                }
                return true;
            }

            @Override // com.byazt.lz.x
            public boolean pr(WebView webView, WebResourceRequest webResourceRequest) {
                this.zo = c.hn;
                return super.pr(webView, webResourceRequest);
            }

            @Override // com.byazt.lz.x
            public boolean pr(WebView webView, String str) {
                this.zo = c.hn;
                return super.pr(webView, str);
            }
        });
        this.x.setJavaScriptEnabled(true);
        this.x.setDisplayZoomControls(false);
        this.x.setCacheMode(2);
        this.x.loadUrl(this.pr);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        hn.set(0);
        pr prVar = this.aj;
        if (prVar != null) {
            prVar.hw(this);
        }
    }

    public c pr(pr prVar) {
        this.aj = prVar;
        return this;
    }
}
