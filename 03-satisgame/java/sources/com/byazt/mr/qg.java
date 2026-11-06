package com.byazt.mr;

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
import com.byazt.ho.BaseConstants;
import com.byazt.kfh.SSWebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 26})
public class qg extends AlertDialog {
    public static volatile AtomicInteger qg = new AtomicInteger(0);
    public HashMap<String, String> cp;
    public List<s> d;
    public String fs;
    public ImageView l;
    public Context n;
    public boolean oa;
    public Button q;
    public n rv;
    public Button s;
    public String tj;
    public ListView w;
    public SSWebView x;

    public interface n {
        void n(Dialog dialog);

        void qg(Dialog dialog);

        void s(Dialog dialog);
    }

    public qg(Context context, String str) {
        super(context);
        this.d = new ArrayList();
        this.oa = false;
        this.n = context;
        this.tj = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.cb.s.qg(this);
        qg();
        if (!this.oa) {
            q();
        } else {
            l();
        }
        s();
    }

    private void q() {
        if (this.n == null) {
            this.n = com.byazt.nf.rv.getContext();
        }
        if (this.n.getResources().getConfiguration().orientation == 1) {
            setContentView(n(1));
        } else {
            setContentView(n(0));
        }
    }

    private void l() {
        if (this.n == null) {
            this.n = com.byazt.nf.rv.getContext();
        }
        if (this.n.getResources().getConfiguration().orientation == 1) {
            setContentView(qg(1));
        } else {
            setContentView(qg(0));
        }
    }

    private View n(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.n);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.n);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this.n);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(com.byazt.okk.s.s(this.n, 8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        RelativeLayout relativeLayout = new RelativeLayout(this.n);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        return n(i, linearLayout, linearLayout2, relativeLayout);
    }

    private LinearLayout n(int i, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout) {
        ImageView imageView = new ImageView(this.n);
        this.l = imageView;
        imageView.setMaxHeight(com.byazt.okk.s.s(this.n, 46.0f));
        this.l.setMaxWidth(com.byazt.okk.s.s(this.n, 46.0f));
        this.l.setMinimumHeight(com.byazt.okk.s.s(this.n, 46.0f));
        this.l.setMinimumWidth(com.byazt.okk.s.s(this.n, 46.0f));
        this.l.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.byazt.xn.qg qgVar = new com.byazt.xn.qg(com.byazt.okk.s.s(this.n, 14.0f));
        qgVar.n(ViewCompat.MEASURED_STATE_MASK);
        qgVar.n(com.byazt.okk.s.s(this.n, 2.0f));
        this.l.setImageDrawable(qgVar);
        relativeLayout.addView(this.l);
        TextView textView = new TextView(this.n);
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
        View view = new View(this.n);
        view.setId(View.generateViewId());
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.byazt.okk.s.s(this.n, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view);
        return n(i, linearLayout, n(linearLayout2, view));
    }

    private LinearLayout n(LinearLayout linearLayout, View view) {
        LinearLayout linearLayout2 = new LinearLayout(this.n);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, view.getId());
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2);
        this.w = new ListView(this.n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        layoutParams2.topMargin = com.byazt.okk.s.s(this.n, 20.0f);
        int iS = com.byazt.okk.s.s(this.n, 16.0f);
        this.w.setPadding(iS, 0, iS, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setShape(2);
        gradientDrawable.setStroke(com.byazt.okk.s.s(this.n, 1.0f), Color.parseColor("#F0F0F0"));
        this.w.setDivider(gradientDrawable);
        this.w.setDividerHeight(com.byazt.okk.s.s(this.n, 24.0f));
        this.w.setSelector(new ColorDrawable(0));
        this.w.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.w);
        View view2 = new View(this.n);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, com.byazt.okk.s.s(this.n, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view2);
        return linearLayout2;
    }

    private LinearLayout n(int i, LinearLayout linearLayout, LinearLayout linearLayout2) {
        LinearLayout linearLayout3 = new LinearLayout(this.n);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setOrientation(0);
        int iS = com.byazt.okk.s.s(this.n, 16.0f);
        linearLayout3.setPadding(iS, iS, iS, iS);
        linearLayout3.setLayoutParams(layoutParams);
        linearLayout2.addView(linearLayout3);
        this.q = new Button(this.n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        int iS2 = com.byazt.okk.s.s(this.n, 7.0f);
        layoutParams2.leftMargin = iS2;
        layoutParams2.rightMargin = iS2;
        layoutParams2.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(com.byazt.okk.s.s(this.n, 3.0f));
        gradientDrawable.setStroke(com.byazt.okk.s.s(this.n, 0.5f), Color.parseColor("#E0161823"));
        this.q.setBackground(gradientDrawable);
        int iS3 = com.byazt.okk.s.s(this.n, 12.0f);
        this.q.setText("上一步");
        this.q.setPadding(0, iS3, 0, iS3);
        this.q.setTextColor(Color.parseColor("#A8161823"));
        this.q.setLayoutParams(layoutParams2);
        linearLayout3.addView(this.q);
        return n(iS2, iS3, linearLayout3, qg(i, linearLayout, linearLayout2));
    }

    private LinearLayout n(int i, int i2, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.s = new Button(this.n);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        layoutParams.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(com.byazt.okk.s.s(this.n, 3.0f));
        this.s.setBackground(gradientDrawable);
        this.s.setText("立即下载");
        this.s.setPadding(0, i2, 0, i2);
        this.s.setTextColor(-1);
        this.s.setLayoutParams(layoutParams);
        linearLayout.addView(this.s);
        return linearLayout2;
    }

    private LinearLayout qg(int i, LinearLayout linearLayout, LinearLayout linearLayout2) {
        if (i == 0) {
            return linearLayout;
        }
        View view = new View(this.n);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.byazt.okk.s.s(this.n, 34.0f)));
        linearLayout2.addView(view);
        return linearLayout;
    }

    private View qg(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.n);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.n);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        RelativeLayout relativeLayout = new RelativeLayout(this.n);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(com.byazt.okk.s.s(this.n, 8.0f));
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(relativeLayout);
        return n(i, linearLayout, relativeLayout);
    }

    private LinearLayout n(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this.n);
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.n);
        this.l = imageView;
        imageView.setMaxHeight(com.byazt.okk.s.s(this.n, 46.0f));
        this.l.setMaxWidth(com.byazt.okk.s.s(this.n, 46.0f));
        this.l.setMinimumHeight(com.byazt.okk.s.s(this.n, 46.0f));
        this.l.setMinimumWidth(com.byazt.okk.s.s(this.n, 46.0f));
        this.l.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.byazt.xn.qg qgVar = new com.byazt.xn.qg(com.byazt.okk.s.s(this.n, 14.0f));
        qgVar.n(ViewCompat.MEASURED_STATE_MASK);
        qgVar.n(com.byazt.okk.s.s(this.n, 2.0f));
        this.l.setImageDrawable(qgVar);
        relativeLayout2.addView(this.l);
        TextView textView = new TextView(this.n);
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
        return qg(i, linearLayout, relativeLayout);
    }

    private LinearLayout qg(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        View view = new View(this.n);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.byazt.okk.s.s(this.n, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        relativeLayout.addView(view);
        this.x = new SSWebView(this.n);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        this.x.setLayoutParams(layoutParams);
        relativeLayout.addView(this.x);
        View view2 = new View(this.n);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, com.byazt.okk.s.s(this.n, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        relativeLayout.addView(view2);
        return s(i, linearLayout, relativeLayout);
    }

    private LinearLayout s(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        LinearLayout linearLayout2 = new LinearLayout(this.n);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout2.setOrientation(0);
        int iS = com.byazt.okk.s.s(this.n, 16.0f);
        linearLayout2.setPadding(iS, iS, iS, iS);
        linearLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(linearLayout2);
        this.q = new Button(this.n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        int iS2 = com.byazt.okk.s.s(this.n, 7.0f);
        layoutParams2.leftMargin = iS2;
        layoutParams2.rightMargin = iS2;
        layoutParams2.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(com.byazt.okk.s.s(this.n, 3.0f));
        gradientDrawable.setStroke(com.byazt.okk.s.s(this.n, 0.5f), Color.parseColor("#E0161823"));
        this.q.setBackground(gradientDrawable);
        int iS3 = com.byazt.okk.s.s(this.n, 12.0f);
        this.q.setText("上一步");
        this.q.setPadding(0, iS3, 0, iS3);
        this.q.setTextColor(Color.parseColor("#A8161823"));
        this.q.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.q);
        return n(i, linearLayout, relativeLayout, linearLayout2, iS2, iS3);
    }

    private LinearLayout n(int i, LinearLayout linearLayout, RelativeLayout relativeLayout, LinearLayout linearLayout2, int i2, int i3) {
        return n(i2, i3, linearLayout2, q(i, linearLayout, relativeLayout));
    }

    private LinearLayout q(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        if (i == 0) {
            return linearLayout;
        }
        View view = new View(this.n);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.byazt.okk.s.s(this.n, 34.0f)));
        relativeLayout.addView(view);
        return linearLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n() {
        this.x.setWebViewClient(new com.byazt.dho.s(this.n, null, 0 == true ? 1 : 0) { // from class: com.byazt.mr.qg.1
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
                this.fs = qg.qg;
                return super.n(webView, webResourceRequest);
            }

            @Override // com.byazt.dho.s
            public boolean n(WebView webView, String str) {
                this.fs = qg.qg;
                return super.n(webView, str);
            }
        });
        this.x.setJavaScriptEnabled(true);
        this.x.setDisplayZoomControls(false);
        this.x.setCacheMode(2);
        this.x.loadUrl(this.fs);
    }

    public void qg() {
        if (TextUtils.isEmpty(this.tj)) {
            n(this.cp);
            return;
        }
        try {
            com.byazt.gct.w wVarL = com.byazt.vgx.qg.l(new JSONObject(this.tj));
            if (wVarL != null) {
                HashMap<String, String> mapN = wVarL.n();
                this.cp = mapN;
                if (!mapN.isEmpty()) {
                    this.oa = false;
                    n(this.cp);
                } else if (!TextUtils.isEmpty(wVarL.qg())) {
                    this.fs = wVarL.qg();
                    this.oa = true;
                } else {
                    n(this.cp);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void n(HashMap<String, String> map) {
        List<s> list = this.d;
        if (list != null && list.size() > 0) {
            this.d.clear();
        }
        if (this.d == null) {
            this.d = new ArrayList();
        }
        if (map == null || map.size() <= 0) {
            this.d.add(new s("补充中，可于应用官网查看", ""));
            return;
        }
        for (String str : map.keySet()) {
            this.d.add(new s(str, map.get(str)));
        }
    }

    public void s() {
        if (this.oa) {
            n();
        } else {
            SSWebView sSWebView = this.x;
            if (sSWebView != null) {
                sSWebView.setWebViewClient(new SSWebView.n());
            }
        }
        this.s.setVisibility(0);
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.qg.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                qg.qg.set(0);
                if (qg.this.rv != null) {
                    qg.this.rv.n(qg.this);
                }
            }
        });
        this.l.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.qg.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                qg.qg.set(0);
                if (qg.this.rv != null) {
                    qg.this.rv.qg(qg.this);
                }
            }
        });
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.qg.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                qg.qg.set(0);
                if (qg.this.rv != null) {
                    qg.this.rv.s(qg.this);
                }
            }
        });
        List<s> list = this.d;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.w.setAdapter((ListAdapter) new C0248qg(this.n, 0, this.d));
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    public qg n(n nVar) {
        this.rv = nVar;
        return this;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        qg.set(0);
        n nVar = this.rv;
        if (nVar != null) {
            nVar.qg(this);
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 47})
    class s {
        public String qg;
        public String s;

        public s(String str, String str2) {
            this.qg = str;
            this.s = str2;
        }

        public String n() {
            return this.qg;
        }

        public String qg() {
            return this.s;
        }
    }

    /* JADX INFO: renamed from: com.byazt.mr.qg$qg, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 201})
    class C0248qg extends ArrayAdapter<s> {
        public C0248qg(Context context, int i, List<s> list) {
            super(context, i, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            n nVar;
            View view2;
            s item = getItem(i);
            if (view == null) {
                RelativeLayout relativeLayout = new RelativeLayout(qg.this.n);
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                relativeLayout.setPadding(0, 0, 0, com.byazt.okk.s.s(qg.this.n, 17.0f));
                TextView textView = new TextView(qg.this.n);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                int iS = com.byazt.okk.s.s(qg.this.n, 16.0f);
                layoutParams.leftMargin = iS;
                layoutParams.rightMargin = iS;
                textView.setGravity(16);
                textView.setId(View.generateViewId());
                textView.setTextColor(Color.parseColor("#161823"));
                textView.setTextSize(16.0f);
                textView.setTypeface(null, 1);
                textView.setPadding(0, com.byazt.okk.s.s(qg.this.n, 19.0f), 0, 0);
                textView.setLayoutParams(layoutParams);
                relativeLayout.addView(textView);
                ImageView imageView = new ImageView(qg.this.n);
                imageView.setId(View.generateViewId());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iS, iS);
                layoutParams2.topMargin = com.byazt.okk.s.s(qg.this.n, 7.0f);
                layoutParams2.addRule(3, textView.getId());
                layoutParams2.addRule(5, textView.getId());
                com.byazt.tk.sz.n(qg.this.n, "tt_open_app_detail_list_item", (View) imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                imageView.setLayoutParams(layoutParams2);
                relativeLayout.addView(imageView);
                TextView textView2 = new TextView(qg.this.n);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams3.leftMargin = com.byazt.okk.s.s(qg.this.n, 8.0f);
                layoutParams3.topMargin = com.byazt.okk.s.s(qg.this.n, 6.0f);
                layoutParams3.addRule(3, textView.getId());
                layoutParams3.addRule(1, imageView.getId());
                textView2.setLayoutParams(layoutParams3);
                textView2.setTextColor(Color.parseColor("#161823"));
                textView2.setTextSize(13.0f);
                textView2.setAlpha(0.5f);
                textView2.setGravity(16);
                relativeLayout.addView(textView2);
                nVar = new n();
                nVar.qg = textView;
                nVar.s = textView2;
                nVar.q = imageView;
                relativeLayout.setTag(nVar);
                view2 = relativeLayout;
            } else {
                nVar = (n) view.getTag();
                view2 = view;
            }
            nVar.q.setVisibility(0);
            if ("补充中，可于应用官网查看".equals(item.n())) {
                nVar.q.setVisibility(4);
            }
            nVar.qg.setText(item.n());
            nVar.s.setText(item.qg());
            return view2;
        }

        /* JADX INFO: renamed from: com.byazt.mr.qg$qg$n */
        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 1616})
        class n {
            public ImageView q;
            public TextView qg;
            public TextView s;

            public n() {
            }
        }
    }
}
