package com.bytedance.sdk.openadsdk.core.widget;

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
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends AlertDialog {
    protected static volatile AtomicInteger ah = new AtomicInteger(0);
    private Button ab;
    private ImageView c;
    private SSWebView d;
    private Context ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected String f3721ms;
    private ms ny;
    private Button x;
    protected String xr;

    public interface ms {
        void ah(Dialog dialog);

        void ms(Dialog dialog);

        void xr(Dialog dialog);
    }

    public ka(Context context, String str, String str2, String str3) {
        super(context, t.ab(context, "tt_dialog_full"));
        this.ka = context;
        this.f3721ms = str;
        this.xr = str3;
        if (TextUtils.isEmpty(str) || !(this.f3721ms.startsWith("https") || this.f3721ms.startsWith("http"))) {
            this.f3721ms = str2;
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ka == null) {
            this.ka = re.getContext();
        }
        ms();
    }

    private View ms(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.ka);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.ka);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this.ka);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(ul.ah(this.ka, 8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        RelativeLayout relativeLayout = new RelativeLayout(this.ka);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.ka);
        this.c = imageView;
        imageView.setMaxHeight(ul.ah(this.ka, 46.0f));
        this.c.setMaxWidth(ul.ah(this.ka, 46.0f));
        this.c.setMinimumHeight(ul.ah(this.ka, 46.0f));
        this.c.setMinimumWidth(ul.ah(this.ka, 46.0f));
        this.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.bytedance.sdk.openadsdk.res.ah ahVar = new com.bytedance.sdk.openadsdk.res.ah(ul.ah(this.ka, 14.0f));
        ahVar.ms(ViewCompat.MEASURED_STATE_MASK);
        ahVar.ms(ul.ah(this.ka, 2.0f));
        this.c.setImageDrawable(ahVar);
        relativeLayout.addView(this.c);
        TextView textView = new TextView(this.ka);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams4.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText(this.xr);
        textView.setLayoutParams(layoutParams4);
        relativeLayout.addView(textView);
        linearLayout2.addView(relativeLayout);
        View view2 = new View(this.ka);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, ul.ah(this.ka, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view2);
        this.d = new SSWebView(this.ka);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams5.weight = 1.0f;
        this.d.setLayoutParams(layoutParams5);
        linearLayout2.addView(this.d);
        View view3 = new View(this.ka);
        view3.setLayoutParams(new LinearLayout.LayoutParams(-1, ul.ah(this.ka, 1.0f)));
        view3.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view3);
        LinearLayout linearLayout3 = new LinearLayout(this.ka);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setOrientation(0);
        int iAh = ul.ah(this.ka, 16.0f);
        linearLayout3.setPadding(iAh, iAh, iAh, iAh);
        linearLayout3.setLayoutParams(layoutParams6);
        linearLayout2.addView(linearLayout3);
        this.x = new Button(this.ka);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -2);
        int iAh2 = ul.ah(this.ka, 7.0f);
        layoutParams7.leftMargin = iAh2;
        layoutParams7.rightMargin = iAh2;
        layoutParams7.weight = 1.0f;
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(ul.ah(this.ka, 3.0f));
        gradientDrawable2.setStroke(ul.ah(this.ka, 0.5f), Color.parseColor("#E0161823"));
        this.x.setBackground(gradientDrawable2);
        int iAh3 = ul.ah(this.ka, 12.0f);
        this.x.setText("上一步");
        this.x.setPadding(0, iAh3, 0, iAh3);
        this.x.setTextColor(Color.parseColor("#A8161823"));
        this.x.setLayoutParams(layoutParams7);
        linearLayout3.addView(this.x);
        this.ab = new Button(this.ka);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -2);
        layoutParams8.leftMargin = iAh2;
        layoutParams8.rightMargin = iAh2;
        layoutParams8.weight = 1.0f;
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable3.setCornerRadius(ul.ah(this.ka, 3.0f));
        this.ab.setBackground(gradientDrawable3);
        this.ab.setText("立即下载");
        this.ab.setPadding(0, iAh3, 0, iAh3);
        this.ab.setTextColor(-1);
        this.ab.setLayoutParams(layoutParams8);
        linearLayout3.addView(this.ab);
        if (i == 0) {
            return linearLayout;
        }
        View view4 = new View(this.ka);
        view4.setLayoutParams(new LinearLayout.LayoutParams(-1, ul.ah(this.ka, 34.0f)));
        linearLayout2.addView(view4);
        return linearLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void ms() {
        if (this.ka.getResources().getConfiguration().orientation == 1) {
            setContentView(ms(1));
        } else {
            setContentView(ms(0));
        }
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ka.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ka.ah.set(0);
                if (ka.this.ny != null) {
                    ka.this.ny.xr(ka.this);
                }
            }
        });
        this.x.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ka.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ka.ah.set(0);
                if (ka.this.ny != null) {
                    ka.this.ny.ah(ka.this);
                }
            }
        });
        this.ab.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ka.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ka.ah.set(0);
                if (ka.this.ny != null) {
                    ka.this.ny.ms(ka.this);
                }
            }
        });
        this.d.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.ms.d(this.ka, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.ka.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
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
                    if (!lowerCase.contains("http") && !lowerCase.contains("https")) {
                        return true;
                    }
                    webView.loadUrl(str);
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d
            protected boolean ms(WebView webView, WebResourceRequest webResourceRequest) {
                this.x = ka.ah;
                return super.ms(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d
            public boolean ms(WebView webView, String str) {
                this.x = ka.ah;
                return super.ms(webView, str);
            }
        });
        this.d.setJavaScriptEnabled(true);
        this.d.setDisplayZoomControls(false);
        this.d.setCacheMode(2);
        this.d.loadUrl(this.f3721ms);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        ah.set(0);
        ms msVar = this.ny;
        if (msVar != null) {
            msVar.xr(this);
        }
    }

    public ka ms(ms msVar) {
        this.ny = msVar;
        return this;
    }
}
