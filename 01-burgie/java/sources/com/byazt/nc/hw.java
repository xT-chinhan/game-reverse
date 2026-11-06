package com.byazt.nc;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
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
import com.byazt.fi.BaseConstants;
import com.byazt.fj.SSWebView;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 52, 13})
public class hw extends AlertDialog {
    public static volatile AtomicInteger hw = new AtomicInteger(0);
    public pr aj;
    public ImageView c;
    public SSWebView fw;
    public Button hn;
    public List<hn> k;
    public boolean m;
    public Context pr;
    public ListView uc;
    public String vk;
    public HashMap<String, String> w;
    public Button x;
    public String zo;

    public interface pr {
        void hn(Dialog dialog);

        void hw(Dialog dialog);

        void pr(Dialog dialog);
    }

    public hw(Context context, String str) {
        super(context);
        this.k = new ArrayList();
        this.m = false;
        this.pr = context;
        this.vk = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.sdv.uc.hw(this);
        hw();
        if (!this.m) {
            x();
        } else {
            c();
        }
        hn();
    }

    private void x() {
        if (this.pr == null) {
            this.pr = a.getContext();
        }
        if (this.pr.getResources().getConfiguration().orientation == 1) {
            setContentView(pr(1));
        } else {
            setContentView(pr(0));
        }
    }

    private void c() {
        if (this.pr == null) {
            this.pr = a.getContext();
        }
        if (this.pr.getResources().getConfiguration().orientation == 1) {
            setContentView(hw(1));
        } else {
            setContentView(hw(0));
        }
    }

    private View pr(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.pr);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.pr);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this.pr);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(er.hn(this.pr, 8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        RelativeLayout relativeLayout = new RelativeLayout(this.pr);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        return pr(i, linearLayout, linearLayout2, relativeLayout);
    }

    private LinearLayout pr(int i, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout) {
        ImageView imageView = new ImageView(this.pr);
        this.c = imageView;
        imageView.setMaxHeight(er.hn(this.pr, 46.0f));
        this.c.setMaxWidth(er.hn(this.pr, 46.0f));
        this.c.setMinimumHeight(er.hn(this.pr, 46.0f));
        this.c.setMinimumWidth(er.hn(this.pr, 46.0f));
        this.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.byazt.sdv.hw hwVar = new com.byazt.sdv.hw(er.hn(this.pr, 14.0f));
        hwVar.pr(ViewCompat.MEASURED_STATE_MASK);
        hwVar.pr(er.hn(this.pr, 2.0f));
        this.c.setImageDrawable(hwVar);
        relativeLayout.addView(this.c);
        TextView textView = new TextView(this.pr);
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
        View view = new View(this.pr);
        view.setId(View.generateViewId());
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, er.hn(this.pr, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view);
        return pr(i, linearLayout, pr(linearLayout2, view));
    }

    private LinearLayout pr(LinearLayout linearLayout, View view) {
        LinearLayout linearLayout2 = new LinearLayout(this.pr);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, view.getId());
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2);
        this.uc = new ListView(this.pr);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        layoutParams2.topMargin = er.hn(this.pr, 20.0f);
        int iHn = er.hn(this.pr, 16.0f);
        this.uc.setPadding(iHn, 0, iHn, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setShape(2);
        gradientDrawable.setStroke(er.hn(this.pr, 1.0f), Color.parseColor("#F0F0F0"));
        this.uc.setDivider(gradientDrawable);
        this.uc.setDividerHeight(er.hn(this.pr, 24.0f));
        this.uc.setSelector(new ColorDrawable(0));
        this.uc.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.uc);
        View view2 = new View(this.pr);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, er.hn(this.pr, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view2);
        return linearLayout2;
    }

    private LinearLayout pr(int i, LinearLayout linearLayout, LinearLayout linearLayout2) {
        LinearLayout linearLayout3 = new LinearLayout(this.pr);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setOrientation(0);
        int iHn = er.hn(this.pr, 16.0f);
        linearLayout3.setPadding(iHn, iHn, iHn, iHn);
        linearLayout3.setLayoutParams(layoutParams);
        linearLayout2.addView(linearLayout3);
        this.x = new Button(this.pr);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        int iHn2 = er.hn(this.pr, 7.0f);
        layoutParams2.leftMargin = iHn2;
        layoutParams2.rightMargin = iHn2;
        layoutParams2.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(er.hn(this.pr, 3.0f));
        gradientDrawable.setStroke(er.hn(this.pr, 0.5f), Color.parseColor("#E0161823"));
        this.x.setBackground(gradientDrawable);
        int iHn3 = er.hn(this.pr, 12.0f);
        this.x.setText("上一步");
        this.x.setPadding(0, iHn3, 0, iHn3);
        this.x.setTextColor(Color.parseColor("#A8161823"));
        this.x.setLayoutParams(layoutParams2);
        linearLayout3.addView(this.x);
        return pr(iHn2, iHn3, linearLayout3, hw(i, linearLayout, linearLayout2));
    }

    private LinearLayout pr(int i, int i2, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.hn = new Button(this.pr);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        layoutParams.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(er.hn(this.pr, 3.0f));
        this.hn.setBackground(gradientDrawable);
        this.hn.setText("立即下载");
        this.hn.setPadding(0, i2, 0, i2);
        this.hn.setTextColor(-1);
        this.hn.setLayoutParams(layoutParams);
        linearLayout.addView(this.hn);
        return linearLayout2;
    }

    private LinearLayout hw(int i, LinearLayout linearLayout, LinearLayout linearLayout2) {
        if (i == 0) {
            return linearLayout;
        }
        View view = new View(this.pr);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, er.hn(this.pr, 34.0f)));
        linearLayout2.addView(view);
        return linearLayout;
    }

    private View hw(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.pr);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.pr);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        RelativeLayout relativeLayout = new RelativeLayout(this.pr);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(er.hn(this.pr, 8.0f));
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(relativeLayout);
        return pr(i, linearLayout, relativeLayout);
    }

    private LinearLayout pr(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this.pr);
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.pr);
        this.c = imageView;
        imageView.setMaxHeight(er.hn(this.pr, 46.0f));
        this.c.setMaxWidth(er.hn(this.pr, 46.0f));
        this.c.setMinimumHeight(er.hn(this.pr, 46.0f));
        this.c.setMinimumWidth(er.hn(this.pr, 46.0f));
        this.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.byazt.sdv.hw hwVar = new com.byazt.sdv.hw(er.hn(this.pr, 14.0f));
        hwVar.pr(ViewCompat.MEASURED_STATE_MASK);
        hwVar.pr(er.hn(this.pr, 2.0f));
        this.c.setImageDrawable(hwVar);
        relativeLayout2.addView(this.c);
        TextView textView = new TextView(this.pr);
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
        return hw(i, linearLayout, relativeLayout);
    }

    private LinearLayout hw(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        View view = new View(this.pr);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, er.hn(this.pr, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        relativeLayout.addView(view);
        this.fw = new SSWebView(this.pr);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        this.fw.setLayoutParams(layoutParams);
        relativeLayout.addView(this.fw);
        View view2 = new View(this.pr);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, er.hn(this.pr, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        relativeLayout.addView(view2);
        return hn(i, linearLayout, relativeLayout);
    }

    private LinearLayout hn(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        LinearLayout linearLayout2 = new LinearLayout(this.pr);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout2.setOrientation(0);
        int iHn = er.hn(this.pr, 16.0f);
        linearLayout2.setPadding(iHn, iHn, iHn, iHn);
        linearLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(linearLayout2);
        this.x = new Button(this.pr);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        int iHn2 = er.hn(this.pr, 7.0f);
        layoutParams2.leftMargin = iHn2;
        layoutParams2.rightMargin = iHn2;
        layoutParams2.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(er.hn(this.pr, 3.0f));
        gradientDrawable.setStroke(er.hn(this.pr, 0.5f), Color.parseColor("#E0161823"));
        this.x.setBackground(gradientDrawable);
        int iHn3 = er.hn(this.pr, 12.0f);
        this.x.setText("上一步");
        this.x.setPadding(0, iHn3, 0, iHn3);
        this.x.setTextColor(Color.parseColor("#A8161823"));
        this.x.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.x);
        return pr(i, linearLayout, relativeLayout, linearLayout2, iHn2, iHn3);
    }

    private LinearLayout pr(int i, LinearLayout linearLayout, RelativeLayout relativeLayout, LinearLayout linearLayout2, int i2, int i3) {
        return pr(i2, i3, linearLayout2, x(i, linearLayout, relativeLayout));
    }

    private LinearLayout x(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        if (i == 0) {
            return linearLayout;
        }
        View view = new View(this.pr);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, er.hn(this.pr, 34.0f)));
        relativeLayout.addView(view);
        return linearLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pr() {
        this.fw.setWebViewClient(new com.byazt.lz.x(this.pr, null, 0 == true ? 1 : 0) { // from class: com.byazt.nc.hw.1
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
                this.zo = hw.hw;
                return super.pr(webView, webResourceRequest);
            }

            @Override // com.byazt.lz.x
            public boolean pr(WebView webView, String str) {
                this.zo = hw.hw;
                return super.pr(webView, str);
            }
        });
        this.fw.setJavaScriptEnabled(true);
        this.fw.setDisplayZoomControls(false);
        this.fw.setCacheMode(2);
        this.fw.loadUrl(this.zo);
    }

    public void hw() {
        if (TextUtils.isEmpty(this.vk)) {
            pr(this.w);
            return;
        }
        try {
            com.byazt.hg.uc ucVarC = com.byazt.sd.pr.c(new JSONObject(this.vk));
            if (ucVarC != null) {
                HashMap<String, String> mapPr = ucVarC.pr();
                this.w = mapPr;
                if (!mapPr.isEmpty()) {
                    this.m = false;
                    pr(this.w);
                } else if (!TextUtils.isEmpty(ucVarC.hw())) {
                    this.zo = ucVarC.hw();
                    this.m = true;
                } else {
                    pr(this.w);
                }
            }
        } catch (Throwable th) {
        }
    }

    private void pr(HashMap<String, String> map) {
        List<hn> list = this.k;
        if (list != null && list.size() > 0) {
            this.k.clear();
        }
        if (this.k == null) {
            this.k = new ArrayList();
        }
        if (map == null || map.size() <= 0) {
            this.k.add(new hn("补充中，可于应用官网查看", ""));
            return;
        }
        for (String str : map.keySet()) {
            this.k.add(new hn(str, map.get(str)));
        }
    }

    public void hn() {
        if (this.m) {
            pr();
        } else {
            SSWebView sSWebView = this.fw;
            if (sSWebView != null) {
                sSWebView.setWebViewClient(new SSWebView.pr());
            }
        }
        this.hn.setVisibility(0);
        this.hn.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.hw.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hw.hw.set(0);
                if (hw.this.aj != null) {
                    hw.this.aj.pr(hw.this);
                }
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.hw.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hw.hw.set(0);
                if (hw.this.aj != null) {
                    hw.this.aj.hw(hw.this);
                }
            }
        });
        this.x.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.hw.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hw.hw.set(0);
                if (hw.this.aj != null) {
                    hw.this.aj.hn(hw.this);
                }
            }
        });
        List<hn> list = this.k;
        if (list != null && list.size() > 0) {
            this.uc.setAdapter((ListAdapter) new C0138hw(this.pr, 0, this.k));
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    public hw pr(pr prVar) {
        this.aj = prVar;
        return this;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        hw.set(0);
        pr prVar = this.aj;
        if (prVar != null) {
            prVar.hw(this);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 52, MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_CREATE_TIME})
    class hn {
        public String hn;
        public String hw;

        public hn(String str, String str2) {
            this.hw = str;
            this.hn = str2;
        }

        public String pr() {
            return this.hw;
        }

        public String hw() {
            return this.hn;
        }
    }

    /* JADX INFO: renamed from: com.byazt.nc.hw$hw, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 52, 497})
    class C0138hw extends ArrayAdapter<hn> {
        public C0138hw(Context context, int i, List<hn> list) {
            super(context, i, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            pr prVar;
            View view2;
            hn item = getItem(i);
            if (view == null) {
                RelativeLayout relativeLayout = new RelativeLayout(hw.this.pr);
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                relativeLayout.setPadding(0, 0, 0, er.hn(hw.this.pr, 17.0f));
                TextView textView = new TextView(hw.this.pr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                int iHn = er.hn(hw.this.pr, 16.0f);
                layoutParams.leftMargin = iHn;
                layoutParams.rightMargin = iHn;
                textView.setGravity(16);
                textView.setId(View.generateViewId());
                textView.setTextColor(Color.parseColor("#161823"));
                textView.setTextSize(16.0f);
                textView.setTypeface(null, 1);
                textView.setPadding(0, er.hn(hw.this.pr, 19.0f), 0, 0);
                textView.setLayoutParams(layoutParams);
                relativeLayout.addView(textView);
                ImageView imageView = new ImageView(hw.this.pr);
                imageView.setId(View.generateViewId());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iHn, iHn);
                layoutParams2.topMargin = er.hn(hw.this.pr, 7.0f);
                layoutParams2.addRule(3, textView.getId());
                layoutParams2.addRule(5, textView.getId());
                com.byazt.ca.g.pr(hw.this.pr, "tt_open_app_detail_list_item", (View) imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                imageView.setLayoutParams(layoutParams2);
                relativeLayout.addView(imageView);
                TextView textView2 = new TextView(hw.this.pr);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams3.leftMargin = er.hn(hw.this.pr, 8.0f);
                layoutParams3.topMargin = er.hn(hw.this.pr, 6.0f);
                layoutParams3.addRule(3, textView.getId());
                layoutParams3.addRule(1, imageView.getId());
                textView2.setLayoutParams(layoutParams3);
                textView2.setTextColor(Color.parseColor("#161823"));
                textView2.setTextSize(13.0f);
                textView2.setAlpha(0.5f);
                textView2.setGravity(16);
                relativeLayout.addView(textView2);
                prVar = new pr();
                prVar.hw = textView;
                prVar.hn = textView2;
                prVar.x = imageView;
                relativeLayout.setTag(prVar);
                view2 = relativeLayout;
            } else {
                prVar = (pr) view.getTag();
                view2 = view;
            }
            prVar.x.setVisibility(0);
            if ("补充中，可于应用官网查看".equals(item.pr())) {
                prVar.x.setVisibility(4);
            }
            prVar.hw.setText(item.pr());
            prVar.hn.setText(item.hw());
            return view2;
        }

        /* JADX INFO: renamed from: com.byazt.nc.hw$hw$pr */
        @com.byazt.vzx.pr(pr = {0, 1, 52, 1853})
        class pr {
            public TextView hn;
            public TextView hw;
            public ImageView x;

            public pr() {
            }
        }
    }
}
