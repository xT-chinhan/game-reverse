package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends AlertDialog {
    protected static volatile AtomicInteger xr = new AtomicInteger(0);
    private SSWebView ab;
    private Button ah;
    private ListView c;
    private String ch;
    private Button d;
    private HashMap<String, String> hi;
    private ImageView ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected Context f3747ms;
    private ms ny;
    private List<ah> sl;
    private String x;
    private boolean zb;

    public interface ms {
        void ah(Dialog dialog);

        void ms(Dialog dialog);

        void xr(Dialog dialog);
    }

    public xr(Context context, String str) {
        super(context, t.ab(context, "tt_dialog_full"));
        this.sl = new ArrayList();
        this.zb = false;
        this.f3747ms = context;
        this.ch = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        xr();
        if (!this.zb) {
            d();
        } else {
            ka();
        }
        ah();
    }

    private void d() {
        if (this.f3747ms == null) {
            this.f3747ms = re.getContext();
        }
        if (this.f3747ms.getResources().getConfiguration().orientation == 1) {
            setContentView(ms(1));
        } else {
            setContentView(ms(0));
        }
    }

    private void ka() {
        if (this.f3747ms == null) {
            this.f3747ms = re.getContext();
        }
        if (this.f3747ms.getResources().getConfiguration().orientation == 1) {
            setContentView(xr(1));
        } else {
            setContentView(xr(0));
        }
    }

    private View ms(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.f3747ms);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.f3747ms);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this.f3747ms);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(ul.ah(this.f3747ms, 8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        RelativeLayout relativeLayout = new RelativeLayout(this.f3747ms);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        return ms(i, linearLayout, linearLayout2, relativeLayout);
    }

    private LinearLayout ms(int i, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout) {
        ImageView imageView = new ImageView(this.f3747ms);
        this.ka = imageView;
        imageView.setMaxHeight(ul.ah(this.f3747ms, 46.0f));
        this.ka.setMaxWidth(ul.ah(this.f3747ms, 46.0f));
        this.ka.setMinimumHeight(ul.ah(this.f3747ms, 46.0f));
        this.ka.setMinimumWidth(ul.ah(this.f3747ms, 46.0f));
        this.ka.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.bytedance.sdk.openadsdk.res.ah ahVar = new com.bytedance.sdk.openadsdk.res.ah(ul.ah(this.f3747ms, 14.0f));
        ahVar.ms(ViewCompat.MEASURED_STATE_MASK);
        ahVar.ms(ul.ah(this.f3747ms, 2.0f));
        this.ka.setImageDrawable(ahVar);
        relativeLayout.addView(this.ka);
        TextView textView = new TextView(this.f3747ms);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("权限列表");
        textView.setLayoutParams(layoutParams);
        relativeLayout.addView(textView);
        linearLayout2.addView(relativeLayout);
        View view = new View(this.f3747ms);
        view.setId(View.generateViewId());
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, ul.ah(this.f3747ms, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view);
        return ms(i, linearLayout, ms(linearLayout2, view));
    }

    private LinearLayout ms(LinearLayout linearLayout, View view) {
        LinearLayout linearLayout2 = new LinearLayout(this.f3747ms);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, view.getId());
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2);
        this.c = new ListView(this.f3747ms);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        layoutParams2.topMargin = ul.ah(this.f3747ms, 20.0f);
        int iAh = ul.ah(this.f3747ms, 16.0f);
        this.c.setPadding(iAh, 0, iAh, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setShape(2);
        gradientDrawable.setStroke(ul.ah(this.f3747ms, 1.0f), Color.parseColor("#F0F0F0"));
        this.c.setDivider(gradientDrawable);
        this.c.setDividerHeight(ul.ah(this.f3747ms, 24.0f));
        this.c.setSelector(new ColorDrawable(0));
        this.c.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.c);
        View view2 = new View(this.f3747ms);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, ul.ah(this.f3747ms, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view2);
        return linearLayout2;
    }

    private LinearLayout ms(int i, LinearLayout linearLayout, LinearLayout linearLayout2) {
        LinearLayout linearLayout3 = new LinearLayout(this.f3747ms);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setOrientation(0);
        int iAh = ul.ah(this.f3747ms, 16.0f);
        linearLayout3.setPadding(iAh, iAh, iAh, iAh);
        linearLayout3.setLayoutParams(layoutParams);
        linearLayout2.addView(linearLayout3);
        this.d = new Button(this.f3747ms);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        int iAh2 = ul.ah(this.f3747ms, 7.0f);
        layoutParams2.leftMargin = iAh2;
        layoutParams2.rightMargin = iAh2;
        layoutParams2.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(ul.ah(this.f3747ms, 3.0f));
        gradientDrawable.setStroke(ul.ah(this.f3747ms, 0.5f), Color.parseColor("#E0161823"));
        this.d.setBackground(gradientDrawable);
        int iAh3 = ul.ah(this.f3747ms, 12.0f);
        this.d.setText("上一步");
        this.d.setPadding(0, iAh3, 0, iAh3);
        this.d.setTextColor(Color.parseColor("#A8161823"));
        this.d.setLayoutParams(layoutParams2);
        linearLayout3.addView(this.d);
        return ms(iAh2, iAh3, linearLayout3, xr(i, linearLayout, linearLayout2));
    }

    private LinearLayout ms(int i, int i2, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.ah = new Button(this.f3747ms);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        layoutParams.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(ul.ah(this.f3747ms, 3.0f));
        this.ah.setBackground(gradientDrawable);
        this.ah.setText("立即下载");
        this.ah.setPadding(0, i2, 0, i2);
        this.ah.setTextColor(-1);
        this.ah.setLayoutParams(layoutParams);
        linearLayout.addView(this.ah);
        return linearLayout2;
    }

    private LinearLayout xr(int i, LinearLayout linearLayout, LinearLayout linearLayout2) {
        if (i == 0) {
            return linearLayout;
        }
        View view = new View(this.f3747ms);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, ul.ah(this.f3747ms, 34.0f)));
        linearLayout2.addView(view);
        return linearLayout;
    }

    private View xr(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.f3747ms);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.f3747ms);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        RelativeLayout relativeLayout = new RelativeLayout(this.f3747ms);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(ul.ah(this.f3747ms, 8.0f));
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(relativeLayout);
        return ms(i, linearLayout, relativeLayout);
    }

    private LinearLayout ms(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f3747ms);
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.f3747ms);
        this.ka = imageView;
        imageView.setMaxHeight(ul.ah(this.f3747ms, 46.0f));
        this.ka.setMaxWidth(ul.ah(this.f3747ms, 46.0f));
        this.ka.setMinimumHeight(ul.ah(this.f3747ms, 46.0f));
        this.ka.setMinimumWidth(ul.ah(this.f3747ms, 46.0f));
        this.ka.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.bytedance.sdk.openadsdk.res.ah ahVar = new com.bytedance.sdk.openadsdk.res.ah(ul.ah(this.f3747ms, 14.0f));
        ahVar.ms(ViewCompat.MEASURED_STATE_MASK);
        ahVar.ms(ul.ah(this.f3747ms, 2.0f));
        this.ka.setImageDrawable(ahVar);
        relativeLayout2.addView(this.ka);
        TextView textView = new TextView(this.f3747ms);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("权限列表");
        textView.setLayoutParams(layoutParams);
        relativeLayout2.addView(textView);
        relativeLayout.addView(relativeLayout2);
        return xr(i, linearLayout, relativeLayout);
    }

    private LinearLayout xr(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        View view = new View(this.f3747ms);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, ul.ah(this.f3747ms, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        relativeLayout.addView(view);
        this.ab = new SSWebView(this.f3747ms);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        this.ab.setLayoutParams(layoutParams);
        relativeLayout.addView(this.ab);
        View view2 = new View(this.f3747ms);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, ul.ah(this.f3747ms, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        relativeLayout.addView(view2);
        return ah(i, linearLayout, relativeLayout);
    }

    private LinearLayout ah(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        LinearLayout linearLayout2 = new LinearLayout(this.f3747ms);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout2.setOrientation(0);
        int iAh = ul.ah(this.f3747ms, 16.0f);
        linearLayout2.setPadding(iAh, iAh, iAh, iAh);
        linearLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(linearLayout2);
        this.d = new Button(this.f3747ms);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        int iAh2 = ul.ah(this.f3747ms, 7.0f);
        layoutParams2.leftMargin = iAh2;
        layoutParams2.rightMargin = iAh2;
        layoutParams2.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(ul.ah(this.f3747ms, 3.0f));
        gradientDrawable.setStroke(ul.ah(this.f3747ms, 0.5f), Color.parseColor("#E0161823"));
        this.d.setBackground(gradientDrawable);
        int iAh3 = ul.ah(this.f3747ms, 12.0f);
        this.d.setText("上一步");
        this.d.setPadding(0, iAh3, 0, iAh3);
        this.d.setTextColor(Color.parseColor("#A8161823"));
        this.d.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.d);
        return ms(i, linearLayout, relativeLayout, linearLayout2, iAh2, iAh3);
    }

    private LinearLayout ms(int i, LinearLayout linearLayout, RelativeLayout relativeLayout, LinearLayout linearLayout2, int i2, int i3) {
        return ms(i2, i3, linearLayout2, d(i, linearLayout, relativeLayout));
    }

    private LinearLayout d(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        if (i == 0) {
            return linearLayout;
        }
        View view = new View(this.f3747ms);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, ul.ah(this.f3747ms, 34.0f)));
        relativeLayout.addView(view);
        return linearLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void ms() {
        this.ab.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.ms.d(this.f3747ms, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.xr.1
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
                this.x = xr.xr;
                return super.ms(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d
            public boolean ms(WebView webView, String str) {
                this.x = xr.xr;
                return super.ms(webView, str);
            }
        });
        this.ab.setJavaScriptEnabled(true);
        this.ab.setDisplayZoomControls(false);
        this.ab.setCacheMode(2);
        this.ab.loadUrl(this.x);
    }

    protected void xr() {
        if (TextUtils.isEmpty(this.ch)) {
            ms(this.hi);
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.nw.c cVarKa = com.bytedance.sdk.openadsdk.core.ms.ka(new JSONObject(this.ch));
            if (cVarKa != null) {
                HashMap<String, String> mapMs = cVarKa.ms();
                this.hi = mapMs;
                if (!mapMs.isEmpty()) {
                    this.zb = false;
                    ms(this.hi);
                } else if (!TextUtils.isEmpty(cVarKa.xr())) {
                    this.x = cVarKa.xr();
                    this.zb = true;
                } else {
                    ms(this.hi);
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }

    private void ms(HashMap<String, String> map) {
        List<ah> list = this.sl;
        if (list != null && list.size() > 0) {
            this.sl.clear();
        }
        if (this.sl == null) {
            this.sl = new ArrayList();
        }
        if (map == null || map.size() <= 0) {
            this.sl.add(new ah("补充中，可于应用官网查看", ""));
            return;
        }
        for (String str : map.keySet()) {
            this.sl.add(new ah(str, map.get(str)));
        }
    }

    protected void ah() {
        if (this.zb) {
            ms();
        } else {
            SSWebView sSWebView = this.ab;
            if (sSWebView != null) {
                sSWebView.setWebViewClient(new SSWebView.ms());
            }
        }
        this.ah.setVisibility(0);
        this.ah.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.xr.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xr.xr.set(0);
                if (xr.this.ny != null) {
                    xr.this.ny.ms(xr.this);
                }
            }
        });
        this.ka.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.xr.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xr.xr.set(0);
                if (xr.this.ny != null) {
                    xr.this.ny.xr(xr.this);
                }
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.xr.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xr.xr.set(0);
                if (xr.this.ny != null) {
                    xr.this.ny.ah(xr.this);
                }
            }
        });
        List<ah> list = this.sl;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.c.setAdapter((ListAdapter) new C0326xr(this.f3747ms, 0, this.sl));
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    public xr ms(ms msVar) {
        this.ny = msVar;
        return this;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        xr.set(0);
        ms msVar = this.ny;
        if (msVar != null) {
            msVar.xr(this);
        }
    }

    class ah {
        private String ah;
        private String xr;

        ah(String str, String str2) {
            this.xr = str;
            this.ah = str2;
        }

        public String ms() {
            return this.xr;
        }

        public String xr() {
            return this.ah;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.widget.xr$xr, reason: collision with other inner class name */
    class C0326xr extends ArrayAdapter<ah> {
        C0326xr(Context context, int i, List<ah> list) {
            super(context, i, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ms msVar;
            View view2;
            ah item = getItem(i);
            if (view == null) {
                RelativeLayout relativeLayout = new RelativeLayout(xr.this.f3747ms);
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                relativeLayout.setPadding(0, 0, 0, ul.ah(xr.this.f3747ms, 17.0f));
                TextView textView = new TextView(xr.this.f3747ms);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                int iAh = ul.ah(xr.this.f3747ms, 16.0f);
                layoutParams.leftMargin = iAh;
                layoutParams.rightMargin = iAh;
                textView.setGravity(16);
                textView.setId(View.generateViewId());
                textView.setTextColor(Color.parseColor("#161823"));
                textView.setTextSize(16.0f);
                textView.setTypeface(null, 1);
                textView.setPadding(0, ul.ah(xr.this.f3747ms, 19.0f), 0, 0);
                textView.setLayoutParams(layoutParams);
                relativeLayout.addView(textView);
                ImageView imageView = new ImageView(xr.this.f3747ms);
                imageView.setId(View.generateViewId());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iAh, iAh);
                layoutParams2.topMargin = ul.ah(xr.this.f3747ms, 7.0f);
                layoutParams2.addRule(3, textView.getId());
                layoutParams2.addRule(5, textView.getId());
                t.ms(xr.this.f3747ms, "tt_open_app_detail_list_item", (View) imageView);
                imageView.setLayoutParams(layoutParams2);
                relativeLayout.addView(imageView);
                TextView textView2 = new TextView(xr.this.f3747ms);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams3.leftMargin = ul.ah(xr.this.f3747ms, 8.0f);
                layoutParams3.topMargin = ul.ah(xr.this.f3747ms, 6.0f);
                layoutParams3.addRule(3, textView.getId());
                layoutParams3.addRule(1, imageView.getId());
                textView2.setLayoutParams(layoutParams3);
                textView2.setTextColor(Color.parseColor("#161823"));
                textView2.setTextSize(13.0f);
                textView2.setAlpha(0.5f);
                textView2.setGravity(16);
                relativeLayout.addView(textView2);
                msVar = new ms();
                msVar.xr = textView;
                msVar.ah = textView2;
                msVar.d = imageView;
                relativeLayout.setTag(msVar);
                view2 = relativeLayout;
            } else {
                msVar = (ms) view.getTag();
                view2 = view;
            }
            msVar.d.setVisibility(0);
            if ("补充中，可于应用官网查看".equals(item.ms())) {
                msVar.d.setVisibility(4);
            }
            msVar.xr.setText(item.ms());
            msVar.ah.setText(item.xr());
            return view2;
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.widget.xr$xr$ms */
        class ms {
            private TextView ah;
            private ImageView d;
            private TextView xr;

            ms() {
            }
        }
    }
}
