package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.d.ah;
import com.bytedance.sdk.component.utils.op;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.ao.d;
import com.bytedance.sdk.openadsdk.core.az;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.dislike.ui.ms;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.hi.ah.ub;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.c;
import com.bytedance.sdk.openadsdk.core.nw.e;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.nw;
import com.bytedance.sdk.openadsdk.core.pc;
import com.bytedance.sdk.openadsdk.core.playable.xr.xr;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.xr.ms.xr.ab;
import com.bytedance.sdk.openadsdk.core.yu;
import com.bytedance.sdk.openadsdk.res.ka;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTVideoWebPageActivity extends BaseLandingPageActivity implements ah.InterfaceC0177ah, d {
    protected NativeVideoTsView ab;
    private TextView ao;
    private FrameLayout b;
    ms c;
    private ImageView ch;
    private TextView cv;
    private TTProgressBar f;
    private int fm;
    private RoundImageView g;
    private TextView h;
    private ImageView hi;
    private com.bytedance.sdk.openadsdk.core.zb.d il;
    private Button jw;
    private RelativeLayout le;
    private RelativeLayout nw;
    private SSWebView ny;
    private TextView of;
    private TextView p;
    private TTViewStub pc;
    private com.bytedance.sdk.openadsdk.sl.d qf;
    private LinearLayout qv;
    private long re;
    private boolean s;
    private Activity sa;
    private TextView sl;
    private pc t;
    private xr ti;
    private boolean tz;
    private TextView u;
    private TextView ub;
    private com.bytedance.sdk.openadsdk.core.hi.xr.ah ul;
    protected ah x;
    private com.bytedance.sdk.openadsdk.core.multipro.xr.ms xn;
    private Context y;
    private TextView zb;
    private int i = 0;
    private int w = 0;
    private int yu = 0;
    private int op = 0;
    private final Map<String, com.bytedance.sdk.openadsdk.core.hi.xr.ah> az = Collections.synchronizedMap(new HashMap());
    private boolean m = false;
    private boolean lm = false;
    private boolean e = true;
    private boolean k = false;
    private String eg = null;
    private AtomicBoolean l = new AtomicBoolean(true);
    private JSONArray am = null;
    private String v = "立即下载";
    private com.bytedance.sdk.openadsdk.core.hi.xr.ms qk = new com.bytedance.sdk.openadsdk.core.hi.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.16
        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ms() {
            TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
            tTVideoWebPageActivity.xr(tTVideoWebPageActivity.u());
            com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(TTVideoWebPageActivity.this.f1893ms, 1, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ms(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.xr("下载中...");
            if (j > 0) {
                com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(TTVideoWebPageActivity.this.f1893ms, 3, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void xr(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.xr("暂停");
            if (j > 0) {
                com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(TTVideoWebPageActivity.this.f1893ms, 2, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ah(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.xr("下载失败");
            if (j > 0) {
                com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(TTVideoWebPageActivity.this.f1893ms, 4, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ms(long j, String str, String str2) {
            TTVideoWebPageActivity.this.xr("点击安装");
            com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(TTVideoWebPageActivity.this.f1893ms, 5, 100);
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ms(String str, String str2) {
            TTVideoWebPageActivity.this.xr("点击打开");
            com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(TTVideoWebPageActivity.this.f1893ms, 6, 100);
        }
    };
    private com.bytedance.sdk.openadsdk.core.xr.ms vm = null;
    private final ah.xr zf = new ah.xr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.5
        @Override // com.bykv.vk.openvk.component.video.api.d.ah.xr
        public void ms(boolean z) {
            TTVideoWebPageActivity.this.m = z;
            if (TTVideoWebPageActivity.this.isFinishing()) {
                return;
            }
            if (z) {
                ul.ms((View) TTVideoWebPageActivity.this.ny, 8);
                ul.ms((View) TTVideoWebPageActivity.this.nw, 8);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.b.getLayoutParams();
                TTVideoWebPageActivity.this.w = marginLayoutParams.leftMargin;
                TTVideoWebPageActivity.this.i = marginLayoutParams.topMargin;
                TTVideoWebPageActivity.this.yu = marginLayoutParams.width;
                TTVideoWebPageActivity.this.op = marginLayoutParams.height;
                marginLayoutParams.width = -1;
                marginLayoutParams.height = -1;
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
                TTVideoWebPageActivity.this.b.setLayoutParams(marginLayoutParams);
                return;
            }
            ul.ms((View) TTVideoWebPageActivity.this.ny, 0);
            ul.ms((View) TTVideoWebPageActivity.this.nw, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.b.getLayoutParams();
            marginLayoutParams2.width = TTVideoWebPageActivity.this.yu;
            marginLayoutParams2.height = TTVideoWebPageActivity.this.op;
            marginLayoutParams2.leftMargin = TTVideoWebPageActivity.this.w;
            marginLayoutParams2.topMargin = TTVideoWebPageActivity.this.i;
            TTVideoWebPageActivity.this.b.setLayoutParams(marginLayoutParams2);
        }
    };
    private boolean rt = false;
    private final w.ms vy = new w.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.7
        @Override // com.bytedance.sdk.component.utils.w.ms
        public void ms(Context context, Intent intent, boolean z, int i) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                if (TTVideoWebPageActivity.this.fm == 0 && i != 0 && TTVideoWebPageActivity.this.ny != null && TTVideoWebPageActivity.this.eg != null) {
                    x.xr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TTVideoWebPageActivity.this.ny != null) {
                                TTVideoWebPageActivity.this.ny.loadUrl(TTVideoWebPageActivity.this.eg);
                            }
                        }
                    });
                }
                if (TTVideoWebPageActivity.this.ab != null && TTVideoWebPageActivity.this.ab.getNativeVideoController() != null && !TTVideoWebPageActivity.this.w() && TTVideoWebPageActivity.this.fm != i) {
                    ((com.bytedance.sdk.openadsdk.core.video.nativevideo.d) TTVideoWebPageActivity.this.ab.getNativeVideoController()).ms(context, i);
                }
                TTVideoWebPageActivity.this.fm = i;
            }
        }
    };

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void C_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void o_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void p_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void q_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ka == null) {
            return;
        }
        this.sa = this;
        try {
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
        try {
            re.ms(this.sa);
        } catch (Throwable unused2) {
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.fm = u.ah(getApplicationContext());
        setContentView(ka.ms(this.sa, this.ka));
        this.y = this.sa;
        Intent intent = getIntent();
        this.tz = intent.getBooleanExtra("is_outer_click", false);
        this.s = intent.getBooleanExtra("has_phone_num_status", false);
        String stringExtra = intent.getStringExtra("title");
        this.k = intent.getBooleanExtra("video_is_auto_play", true);
        if (bundle != null && bundle.getLong("video_play_position") > 0) {
            this.re = bundle.getLong("video_play_position", 0L);
        }
        String stringExtra2 = intent.getStringExtra("multi_process_data");
        if (stringExtra2 != null) {
            try {
                this.xn = com.bytedance.sdk.openadsdk.core.multipro.xr.ms.ms(new JSONObject(stringExtra2));
            } catch (Exception unused3) {
            }
            com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVar = this.xn;
            if (msVar != null) {
                this.re = msVar.ab;
            }
        }
        if (bundle != null) {
            String string = bundle.getString("material_meta");
            if (this.ka == null) {
                try {
                    this.ka = com.bytedance.sdk.openadsdk.core.ms.ms(new JSONObject(string));
                } catch (Throwable unused4) {
                }
            }
            long j = bundle.getLong("video_play_position");
            if (j > 0) {
                this.re = j;
            }
        }
        this.eg = intent.getStringExtra("url");
        this.eg = f.xr(this.ka, this.eg);
        ub();
        ms(this.ka);
        nw();
        re();
        ms(4);
        SSWebView sSWebView = this.ny;
        if (sSWebView != null) {
            sSWebView.addJavascriptInterface(new com.bytedance.sdk.openadsdk.core.p.xr.ms(this.ny, getApplicationContext(), (this.ka != null && this.ka.ah()) || this.s), "CCWifiJSBridge");
            com.bytedance.sdk.openadsdk.core.widget.ms.xr.ms(this.y).ms(true).xr(false).ms(this.ny);
            this.il = new com.bytedance.sdk.openadsdk.core.zb.d(this.ka, this.ny).xr(true).xr(jCurrentTimeMillis).d(this.ny.getCreateDuration());
            sl();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adid", this.f1893ms);
            jSONObject.put("url", this.eg);
            jSONObject.put("web_title", stringExtra);
            jSONObject.put("is_multi_process", com.bytedance.sdk.openadsdk.core.multipro.xr.ah());
            jSONObject.put("event_tag", this.ah);
        } catch (JSONException unused5) {
        }
        this.il.ms(jSONObject);
        this.ny.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.ms.d(this.y, this.t, this.f1893ms, this.il, this.qf) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTVideoWebPageActivity.this.f == null || TTVideoWebPageActivity.this.isFinishing()) {
                        return;
                    }
                    TTVideoWebPageActivity.this.f.setVisibility(8);
                } catch (Throwable unused6) {
                }
            }
        });
        SSWebView sSWebView2 = this.ny;
        if (sSWebView2 != null) {
            t.ms(sSWebView2, g.xr, lm.d(this.ka));
            this.ny.setMixedContentMode(0);
        }
        this.ny.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.ms.ah(this.t, this.il) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.10
            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.ah, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTVideoWebPageActivity.this.f == null || TTVideoWebPageActivity.this.isFinishing()) {
                    return;
                }
                if (i != 100 || !TTVideoWebPageActivity.this.f.isShown()) {
                    TTVideoWebPageActivity.this.f.setProgress(i);
                } else {
                    TTVideoWebPageActivity.this.f.setVisibility(8);
                }
            }
        });
        this.ny.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.11
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                if (TTVideoWebPageActivity.this.az.containsKey(str)) {
                    com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = (com.bytedance.sdk.openadsdk.core.hi.xr.ah) TTVideoWebPageActivity.this.az.get(str);
                    if (ahVar != null) {
                        ahVar.xr(f.y(TTVideoWebPageActivity.this.ka), false);
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVarMs = com.bytedance.sdk.openadsdk.core.hi.ka.ms(TTVideoWebPageActivity.this.sa, str, TTVideoWebPageActivity.this.ka, TTVideoWebPageActivity.this.ah);
                ahVarMs.ms(ub.ms(TTVideoWebPageActivity.this.ka));
                TTVideoWebPageActivity.this.az.put(str, ahVarMs);
                ahVarMs.xr(f.y(TTVideoWebPageActivity.this.ka), false);
            }
        });
        TextView textView = this.sl;
        if (textView != null) {
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = com.bytedance.sdk.component.utils.t.ms(this.sa, "tt_web_title_default");
            }
            textView.setText(stringExtra);
        }
        TextView textView2 = this.ao;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                    tTVideoWebPageActivity.xr(tTVideoWebPageActivity.ka);
                }
            });
        }
        TextView textView3 = this.h;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                    tTVideoWebPageActivity.ah(tTVideoWebPageActivity.ka);
                }
            });
        }
        ka();
        h();
        zb();
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.ka, getClass().getName());
        this.ny.setVisibility(0);
        this.il.ah(System.currentTimeMillis());
        this.ny.loadUrl(this.eg);
        com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.ka);
        this.ti = new xr(this.il.ms());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        xr xrVar = this.ti;
        if (xrVar != null) {
            xrVar.ms(this.sa, this.ka);
        }
    }

    private void sl() {
        lm lmVar = this.ka;
        if (lmVar == null) {
            return;
        }
        this.qf = com.bytedance.sdk.openadsdk.sl.d.ms(this.y, lmVar, this.eg);
    }

    private void ms(lm lmVar) {
        LinearLayout linearLayout = this.qv;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            return;
        }
        if (lmVar == null) {
            return;
        }
        String strZx = lmVar.zx();
        if (TextUtils.isEmpty(strZx)) {
            LinearLayout linearLayout2 = this.qv;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
                return;
            }
            return;
        }
        try {
            if (TextUtils.isEmpty(strZx)) {
                return;
            }
            c cVarKa = com.bytedance.sdk.openadsdk.core.ms.ka(new JSONObject(strZx));
            if (cVarKa == null) {
                LinearLayout linearLayout3 = this.qv;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(cVarKa.zb())) {
                LinearLayout linearLayout4 = this.qv;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                    return;
                }
                return;
            }
            LinearLayout linearLayout5 = this.qv;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(0);
            }
            String strKa = cVarKa.ka();
            String strAb = cVarKa.ab();
            String strU = cVarKa.u();
            if (TextUtils.isEmpty(strU)) {
                strU = ub.xr(lmVar);
            }
            if (this.u != null) {
                this.u.setText(String.format(com.bytedance.sdk.component.utils.t.ms(this.y, "tt_open_app_detail_developer"), strAb));
            }
            if (this.ub != null) {
                this.ub.setText(String.format(com.bytedance.sdk.component.utils.t.ms(this.y, "tt_open_landing_page_app_name"), strU, strKa));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(lm lmVar) {
        if (lmVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jw.c.ms(this.y, lmVar.df(), lmVar.zx(), new com.bytedance.sdk.openadsdk.core.jw.c.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.14
            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ah() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void xr() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ms() {
                TTVideoWebPageActivity.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(lm lmVar) {
        if (lmVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jw.c.ms(this.y, lmVar.df(), new com.bytedance.sdk.openadsdk.core.jw.c.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.15
            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ah() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void xr() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ms() {
                TTVideoWebPageActivity.this.b();
            }
        }, lmVar.zx());
    }

    private void zb() {
        if (this.ka == null || this.ka.jr() != 4) {
            return;
        }
        this.pc.setVisibility(0);
        Button button = (Button) findViewById(2114387735);
        this.jw = button;
        if (button != null) {
            xr(u());
            com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = this.ul;
            if (ahVar != null) {
                ahVar.ms(this.qk, false);
            }
            this.jw.setOnClickListener(this.vm);
            this.jw.setOnTouchListener(this.vm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String u() {
        if (this.ka != null && !TextUtils.isEmpty(this.ka.bn())) {
            this.v = this.ka.bn();
        }
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.jw) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.17
            @Override // java.lang.Runnable
            public void run() {
                if (TTVideoWebPageActivity.this.jw == null || TTVideoWebPageActivity.this.isFinishing()) {
                    return;
                }
                TTVideoWebPageActivity.this.jw.setText(str);
            }
        });
    }

    private void ub() {
        this.f = (TTProgressBar) findViewById(2114387928);
        this.pc = (TTViewStub) findViewById(2114387956);
        this.ny = (SSWebView) findViewById(2114387739);
        this.ch = (ImageView) findViewById(2114387711);
        if (this.ka != null && this.ka.ca() != null) {
            this.ka.ca().ms("landing_page");
        }
        ImageView imageView = this.ch;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ul.ms(TTVideoWebPageActivity.this.ny)) {
                        return;
                    }
                    if (TTVideoWebPageActivity.this.ti != null) {
                        TTVideoWebPageActivity.this.ti.ms(0);
                    }
                    TTVideoWebPageActivity.this.onBackPressed();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387710);
        this.hi = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.ms("detail_skip");
                    TTVideoWebPageActivity.this.finish();
                }
            });
        }
        TextView textView = (TextView) findViewById(2114387633);
        this.zb = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.ab();
                }
            });
        }
        this.sl = (TextView) findViewById(2114387952);
        this.u = (TextView) findViewById(2114387892);
        this.ub = (TextView) findViewById(2114387751);
        this.ao = (TextView) findViewById(2114387653);
        this.h = (TextView) findViewById(2114387618);
        this.qv = (LinearLayout) findViewById(2114387896);
        this.b = (FrameLayout) findViewById(2114387714);
        this.nw = (RelativeLayout) findViewById(2114387949);
        this.le = (RelativeLayout) findViewById(2114387661);
        this.cv = (TextView) findViewById(2114387957);
        this.of = (TextView) findViewById(2114387770);
        this.p = (TextView) findViewById(2114387692);
        this.g = (RoundImageView) findViewById(2114387670);
        t();
        ao();
    }

    private void ao() {
        if (this.ka == null || this.nw == null || !this.ka.hi()) {
            return;
        }
        this.nw.setVisibility(8);
    }

    public void ms(String str) {
        NativeVideoTsView nativeVideoTsView = this.ab;
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.ka, "embeded_ad", str, qv(), y(), (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) ? null : f.ms(this.ka, this.ab.getNativeVideoController().sl(), this.ab.getNativeVideoController().h()));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        zb();
    }

    private void h() {
        if (lm.xr(this.ka)) {
            try {
                if (this instanceof TTVideoScrollWebPageActivity) {
                    this.ab = new NativeVideoTsView(this.y, this.ka, true, true);
                } else {
                    this.ab = new NativeVideoTsView(this.y, this.ka, true, false);
                }
                if (this.ab.getNativeVideoController() != null) {
                    this.ab.getNativeVideoController().ms(false);
                    if (this.xn != null) {
                        this.ab.getNativeVideoController().ah(this.xn.f2932ms);
                    }
                }
                this.ab.setVideoAdInteractionListener(this);
                if (!this.k) {
                    this.re = 0L;
                }
                if (this.xn != null && this.ab.getNativeVideoController() != null) {
                    this.ab.getNativeVideoController().ah(this.xn.ab);
                    this.ab.getNativeVideoController().d(this.xn.ka);
                }
                if (this.ab.getNativeVideoController() != null) {
                    this.ab.getNativeVideoController().ms(false);
                    this.ab.getNativeVideoController().ms(this.zf);
                    this.ab.setIsQuiet(re.xr().d(f.ny(this.ka)));
                }
                if (this.ab.ms(this.re, this.e, w())) {
                    this.b.setVisibility(0);
                    this.b.removeAllViews();
                    this.b.addView(this.ab);
                }
                if (w()) {
                    this.ab.d(true);
                }
                this.x = this.ab.getNativeVideoController();
            } catch (Exception e) {
                sl.ms(e);
            }
            if (u.ah(this.sa.getApplicationContext()) == 0) {
                try {
                    Activity activity = this.sa;
                    op.ms(activity, com.bytedance.sdk.component.utils.t.ms(activity, "tt_no_network"), 0);
                } catch (Exception unused) {
                }
            }
        }
    }

    private long qv() {
        NativeVideoTsView nativeVideoTsView = this.ab;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0L;
        }
        return this.ab.getNativeVideoController().u();
    }

    private int y() {
        NativeVideoTsView nativeVideoTsView = this.ab;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.ab.getNativeVideoController().ub();
    }

    private void t() {
        String strNq;
        if (this.ka == null || this.ka.jr() != 4) {
            return;
        }
        ul.ms((View) this.le, 0);
        if (!TextUtils.isEmpty(this.ka.eh())) {
            strNq = this.ka.eh();
        } else if (!TextUtils.isEmpty(this.ka.fs())) {
            strNq = this.ka.fs();
        } else {
            strNq = !TextUtils.isEmpty(this.ka.nq()) ? this.ka.nq() : "";
        }
        com.bytedance.sdk.openadsdk.core.nw.g gVarQd = this.ka.qd();
        if (gVarQd != null && gVarQd.ms() != null) {
            ul.ms((View) this.g, 0);
            ul.ms((View) this.cv, 4);
            com.bytedance.sdk.openadsdk.x.xr.ms(gVarQd).ms(this.g);
        } else if (!TextUtils.isEmpty(strNq)) {
            ul.ms((View) this.g, 4);
            ul.ms((View) this.cv, 0);
            this.cv.setText(strNq.substring(0, 1));
        }
        if (this.of != null && !TextUtils.isEmpty(strNq)) {
            this.of.setText(strNq);
        }
        if (!TextUtils.isEmpty(this.ka.bn())) {
            this.p.setText(this.ka.bn());
        }
        ul.ms((View) this.of, 0);
        if (yu()) {
            ul.ms((View) this.p, 8);
        } else {
            ul.ms((View) this.p, 0);
        }
    }

    private void nw() {
        if (this.ka == null || this.ka.jr() != 4) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVarMs = com.bytedance.sdk.openadsdk.core.hi.ka.ms((Context) this.sa, this.ka, this.ah, false);
        this.ul = ahVarMs;
        ahVarMs.ms(this.sa);
        this.ul.ms(ub.ms(this.ka));
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = this.ul;
        if (ahVar instanceof com.bytedance.sdk.openadsdk.core.hi.ah.x) {
            ((com.bytedance.sdk.openadsdk.core.hi.ah.x) ahVar).ah(true);
        }
        com.bytedance.sdk.openadsdk.core.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.xr.ms(this.sa, this.ka, "embeded_ad_landingpage", this.d);
        this.vm = msVar;
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ah(true);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.vm.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(true);
        ((ab) this.vm.ms(ab.class)).xr(true);
        this.p.setOnClickListener(this.vm);
        this.p.setOnTouchListener(this.vm);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.vm.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.ul);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int iQv = nw.qv(this.ka);
        if (this.ka != null) {
            if (this.ka.jr() == 4 || iQv != 0) {
                com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVarMs = com.bytedance.sdk.openadsdk.core.hi.ka.ms((Context) this.sa, this.ka, this.ah, false);
                this.ul = ahVarMs;
                ahVarMs.ms(this.sa);
                com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = this.ul;
                if (ahVar instanceof com.bytedance.sdk.openadsdk.core.hi.ah.x) {
                    ((com.bytedance.sdk.openadsdk.core.hi.ah.x) ahVar).ah(true);
                    ((com.bytedance.sdk.openadsdk.core.hi.ah.x) this.ul).hi().ms(false);
                }
                com.bytedance.sdk.openadsdk.core.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.xr.ms(this.sa, this.ka, "embeded_ad_landingpage", this.d);
                this.vm = msVar;
                ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ah(true);
                ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.vm.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(true);
                ((ab) this.vm.ms(ab.class)).xr(true);
                this.ul.ms(this.ka, false);
                ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.vm.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.ul);
            }
        }
    }

    private void re() {
        if (this.ny == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.ka);
        pc pcVar = new pc(this.sa);
        this.t = pcVar;
        pcVar.d(this.tz);
        this.t.xr(this.ny).ms(this.ka).ah(arrayList).xr(this.f1893ms).ms(this.ah).ah(this.xr).xr(ub.ms(this.ka)).ah(this.d).ms(this.ny).ms(true).d(f.ao(this.ka));
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        xr xrVar = this.ti;
        if (xrVar != null) {
            xrVar.ms(i);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        NativeVideoTsView nativeVideoTsView;
        if ((lm.ah(this.ka) || com.bytedance.sdk.openadsdk.core.nw.pc.ms(this.ka)) && ul.ms(this.ny)) {
            return;
        }
        if (this.m && (nativeVideoTsView = this.ab) != null && nativeVideoTsView.getNativeVideoController() != null) {
            ((com.bykv.vk.openvk.component.video.api.d.ms) this.ab.getNativeVideoController()).ka(null, null);
            this.m = false;
            return;
        }
        xr xrVar = this.ti;
        if (xrVar == null || !xrVar.xr(this.sa, this.ka)) {
            ms("detail_back");
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("material_meta", this.ka != null ? this.ka.rm().toString() : null);
        bundle.putLong("video_play_position", this.re);
        bundle.putBoolean("is_complete", w());
        long jHi = this.re;
        NativeVideoTsView nativeVideoTsView = this.ab;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            jHi = this.ab.getNativeVideoController().hi();
        }
        bundle.putLong("video_play_position", jHi);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.e = false;
        if (this.lm && ch() && !hi()) {
            this.lm = false;
            this.x.x();
        }
        pc pcVar = this.t;
        if (pcVar != null) {
            pcVar.yu();
            this.t.ms(new SSWebView.xr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.6
                @Override // com.bytedance.sdk.component.widget.SSWebView.xr
                public void ms(int i) {
                    TTVideoWebPageActivity.this.t.ms(i);
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = this.ul;
        if (ahVar != null) {
            ahVar.x();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.hi.xr.ah> map = this.az;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.hi.xr.ah> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().x();
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.il;
        if (dVar != null) {
            dVar.d();
        }
        i();
    }

    @Override // android.app.Activity
    protected void onPause() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2;
        super.onPause();
        try {
            if (!this.lm && !hi()) {
                this.lm = true;
                this.x.c();
            }
        } catch (Throwable th) {
            sl.d("TTVideoWebPageActivity", "onPause throw Exception :" + th.getMessage());
        }
        pc pcVar = this.t;
        if (pcVar != null) {
            pcVar.op();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.hi.xr.ah> map = this.az;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.hi.xr.ah> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue();
                }
            }
        }
        if (w() || ((nativeVideoTsView2 = this.ab) != null && nativeVideoTsView2.getNativeVideoController() != null && this.ab.getNativeVideoController().t())) {
            com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.jw.g.ms("sp_multi_native_video_data");
            xrVarMs.ms("key_video_is_update_flag", true);
            xrVarMs.ms("key_native_video_complete", true);
            xrVarMs.ms("key_video_isfromvideodetailpage", true);
        }
        if (w() || (nativeVideoTsView = this.ab) == null || nativeVideoTsView.getNativeVideoController() == null) {
            return;
        }
        ms(this.ab.getNativeVideoController());
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.il;
        if (dVar != null) {
            dVar.ka();
        }
    }

    private void ms(ah ahVar) {
        sl.d("mutilproces", "initFeedNaitiveControllerData-isComplete=" + ahVar.t() + ",position=" + ahVar.hi() + ",totalPlayDuration=" + (ahVar.u() + ahVar.sl()) + ",duration=" + ahVar.u());
        com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.jw.g.ms("sp_multi_native_video_data");
        xrVarMs.ms("key_video_is_update_flag", true);
        xrVarMs.ms("key_video_isfromvideodetailpage", true);
        xrVarMs.ms("key_native_video_complete", ahVar.t());
        xrVarMs.ms("key_video_current_play_position", ahVar.hi());
        xrVarMs.ms("key_video_total_play_duration", ahVar.u() + ahVar.sl());
        xrVarMs.ms("key_video_duration", ahVar.u());
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        c();
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.il;
        if (dVar != null) {
            dVar.ab();
        }
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        SSWebView sSWebView = this.ny;
        if (sSWebView != null) {
            az.ms(this.y, sSWebView);
            az.ms(this.ny);
        }
        this.ny = null;
        com.bytedance.sdk.openadsdk.sl.d dVar2 = this.qf;
        if (dVar2 != null) {
            dVar2.d();
        }
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = this.ul;
        if (ahVar != null) {
            ahVar.ny();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.hi.xr.ah> map = this.az;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.hi.xr.ah> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().ny();
                }
            }
            this.az.clear();
        }
        pc pcVar = this.t;
        if (pcVar != null) {
            pcVar.le();
        }
        NativeVideoTsView nativeVideoTsView = this.ab;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            this.ab.getNativeVideoController().ch();
        }
        NativeVideoTsView nativeVideoTsView2 = this.ab;
        if (nativeVideoTsView2 != null) {
            nativeVideoTsView2.y();
            this.ab = null;
        }
        this.ka = null;
        com.bytedance.sdk.openadsdk.core.zb.d dVar3 = this.il;
        if (dVar3 != null) {
            dVar3.c();
        }
    }

    protected void ka() {
        w.ms(this.vy, this.y);
    }

    protected void c() {
        try {
            w.ms(this.vy);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i) {
        if (lm.ah(this.ka)) {
            ul.ms((View) this.hi, 4);
        } else if (lm.ah(this.ka)) {
            ul.ms((View) this.hi, i);
        }
    }

    private void i() {
        if (this.ka == null) {
            return;
        }
        JSONArray jSONArrayAh = ah(this.eg);
        int iNy = f.ny(this.ka);
        int iX = f.x(this.ka);
        yu<com.bytedance.sdk.openadsdk.core.zb.ms> yuVarMs = re.ms();
        if (jSONArrayAh == null || yuVarMs == null || iNy <= 0 || iX <= 0) {
            return;
        }
        e eVar = new e();
        eVar.ka = jSONArrayAh;
        com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVarRt = this.ka.rt();
        if (xrVarRt == null) {
            return;
        }
        yuVarMs.ms(com.bytedance.sdk.openadsdk.core.jw.op.xr(xrVarRt).ah(6).ms(), eVar, iX, new yu.xr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.8
            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
            public void ms(int i, String str, com.bytedance.sdk.openadsdk.core.nw.xr xrVar) {
                TTVideoWebPageActivity.this.ms(0);
                xrVar.ms(i);
                com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
            public void ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar, com.bytedance.sdk.openadsdk.core.nw.xr xrVar) {
                if (msVar != null) {
                    try {
                        TTVideoWebPageActivity.this.l.set(false);
                        TTVideoWebPageActivity.this.t.ms(msVar.ah());
                    } catch (Exception unused) {
                        TTVideoWebPageActivity.this.ms(0);
                    }
                }
            }
        });
    }

    private JSONArray ah(String str) {
        int i;
        JSONArray jSONArray = this.am;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.am;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("?id=");
        int iIndexOf2 = str.indexOf("&");
        if (iIndexOf == -1 || iIndexOf2 == -1 || (i = iIndexOf + 4) >= iIndexOf2) {
            return null;
        }
        String strSubstring = str.substring(i, iIndexOf2);
        if (TextUtils.isEmpty(strSubstring)) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(strSubstring);
        return jSONArray2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ao.d
    public void ms(boolean z, JSONArray jSONArray) {
        if (!z || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.am = jSONArray;
        i();
    }

    protected void ab() {
        if (isFinishing() || this.ka == null) {
            return;
        }
        if (this.c == null) {
            x();
        }
        this.c.ms();
    }

    void x() {
        ms msVar = new ms(this.sa, this.ka.ca(), this.ah, true);
        this.c = msVar;
        com.bytedance.sdk.openadsdk.core.dislike.ah.ms(this.sa, msVar, this.ka);
        this.c.ms(new ms.InterfaceC0288ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.9
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms
            public void ms() {
                if (TTVideoWebPageActivity.this.ny()) {
                    TTVideoWebPageActivity.this.x.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms
            public void ms(int i, String str, boolean z) {
                if (TTVideoWebPageActivity.this.ch()) {
                    TTVideoWebPageActivity.this.x.x();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms
            public void xr() {
                if (TTVideoWebPageActivity.this.ch()) {
                    TTVideoWebPageActivity.this.x.x();
                }
            }
        });
    }

    boolean ny() {
        ah ahVar = this.x;
        return (ahVar == null || ahVar.h() == null || !this.x.h().zb()) ? false : true;
    }

    protected boolean ch() {
        ah ahVar = this.x;
        return (ahVar == null || ahVar.h() == null || !this.x.h().u()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        NativeVideoTsView nativeVideoTsView = this.ab;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return true;
        }
        return this.ab.getNativeVideoController().t();
    }

    protected boolean hi() {
        ms msVar = this.c;
        if (msVar != null) {
            return msVar.ah();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void ms(long j, long j2) {
        if (yu()) {
            ch.ub().ms(j);
        }
    }

    private boolean yu() {
        if (this.ka == null) {
            return false;
        }
        int iS = this.ka.s();
        return this.d == 1 && "embeded_ad_landingpage".equals(this.ah) && (iS == 1 || iS == 2);
    }
}
