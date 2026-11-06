package com.anythink.core.basead.ui.web;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.anythink.core.api.IOfferClickHandler;
import com.anythink.core.basead.a.e;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.cc;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.q;
import com.anythink.core.common.v.y;
import com.bykv.vk.component.ttvideo.player.C;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class WebLandPageActivity extends Activity implements b {
    private static final int g = 343452;
    private w B;
    private x C;
    private String D;
    private IOfferClickHandler E;
    private c F;
    private int G;
    JSONArray b;
    long e;
    private WebProgressBarView l;
    private WebView m;
    private ImageView n;
    private ImageView o;
    private TextView p;
    private ValueAnimator q;
    private Random r;
    private int s;
    private long t;
    private Map<String, JSONArray> u;
    private WebLoadFailRefrshView x;
    private RelativeLayout y;
    private final int h = 1;
    private final int i = 2;
    private final int j = 3;
    private final int k = 0;
    int a = 8;
    private String v = "";
    private int w = 0;
    private boolean z = false;
    private boolean A = true;
    private ValueCallback<Uri[]> H = null;
    private final int I = 512;
    int c = 0;
    int d = 0;
    final long f = 2500;

    private static void b() {
    }

    private static void c() {
    }

    static /* synthetic */ int g(WebLandPageActivity webLandPageActivity) {
        webLandPageActivity.w = 2;
        return 2;
    }

    private static /* synthetic */ boolean o(WebLandPageActivity webLandPageActivity) {
        webLandPageActivity.z = true;
        return true;
    }

    public static void a(Context context, com.anythink.core.basead.b.c cVar) {
        Intent intent = new Intent();
        intent.setClass(context, WebLandPageActivity.class);
        intent.putExtra(com.anythink.core.basead.a.C0075a.c, cVar.c);
        intent.putExtra(com.anythink.core.basead.a.C0075a.e, cVar.h);
        intent.putExtra(com.anythink.core.basead.a.C0075a.i, cVar.f);
        intent.putExtra(com.anythink.core.basead.a.C0075a.p, cVar.i);
        intent.putExtra(com.anythink.core.basead.a.C0075a.q, cVar.k);
        if (cVar.g != null) {
            intent.putExtra(com.anythink.core.basead.a.C0075a.k, cVar.g);
        }
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        context.startActivity(intent);
    }

    public static void a(Context context, String str) {
        com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
        cVar.f = str;
        a(context, cVar);
    }

    private void a() {
        Intent intent = getIntent();
        if (intent != null) {
            try {
                Serializable serializableExtra = intent.getSerializableExtra(com.anythink.core.basead.a.C0075a.c);
                if (serializableExtra != null && (serializableExtra instanceof w)) {
                    this.B = (w) serializableExtra;
                    this.F = new c(this.B);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                Serializable serializableExtra2 = intent.getSerializableExtra(com.anythink.core.basead.a.C0075a.e);
                if (serializableExtra2 != null && (serializableExtra2 instanceof x)) {
                    this.C = (x) serializableExtra2;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            try {
                Serializable serializableExtra3 = intent.getSerializableExtra(com.anythink.core.basead.a.C0075a.k);
                if (serializableExtra3 != null && (serializableExtra3 instanceof IOfferClickHandler)) {
                    this.E = (IOfferClickHandler) serializableExtra3;
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            try {
                this.D = intent.getStringExtra(com.anythink.core.basead.a.C0075a.i);
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
            try {
                this.G = intent.getIntExtra(com.anythink.core.basead.a.C0075a.p, -1);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            this.A = true;
            try {
                this.A = intent.getBooleanExtra(com.anythink.core.basead.a.C0075a.q, true);
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
        }
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void onWebPageStart(WebView webView, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.equals(this.v, str)) {
                this.w = 1;
            }
            JSONArray jSONArray = this.u.get(str);
            if (jSONArray != null) {
                try {
                    jSONArray.put(0, new StringBuilder().append(System.currentTimeMillis()).toString());
                    jSONArray.put(1, "");
                    this.u.put(str, jSONArray);
                } catch (JSONException unused) {
                }
            }
        }
        WebLoadFailRefrshView webLoadFailRefrshView = this.x;
        if (webLoadFailRefrshView != null) {
            am.a(webLoadFailRefrshView);
        }
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void onWebPageFinish(WebView webView, String str) {
        WebView webView2;
        WebLoadFailRefrshView webLoadFailRefrshView = this.x;
        if (webLoadFailRefrshView != null && webLoadFailRefrshView.getParent() == null && (webView2 = this.m) != null) {
            webView2.setVisibility(0);
        }
        webView.canGoBack();
        webView.canGoForward();
        if (!TextUtils.isEmpty(str) && this.w != 3 && TextUtils.equals(this.v, str) && !isFinishing()) {
            this.w = 2;
            JSONArray jSONArray = this.u.get(str);
            if (jSONArray != null) {
                try {
                    jSONArray.put(1, new StringBuilder().append(System.currentTimeMillis()).toString());
                    this.u.put(str, jSONArray);
                } catch (JSONException unused) {
                }
            }
        }
        c cVar = this.F;
        if (cVar != null) {
            cVar.a(webView, str);
        }
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void onWebPageLoadError(WebView webView, String str) {
        if (TextUtils.equals(this.v, str)) {
            this.w = 3;
        }
        WebLoadFailRefrshView webLoadFailRefrshView = this.x;
        if (webLoadFailRefrshView != null) {
            am.a(webLoadFailRefrshView);
        } else {
            WebLoadFailRefrshView webLoadFailRefrshView2 = new WebLoadFailRefrshView(this);
            this.x = webLoadFailRefrshView2;
            WebView webView2 = this.m;
            if (webView2 != null) {
                webLoadFailRefrshView2.setLayoutParams(webView2.getLayoutParams());
            }
            this.x.setOnRefreshListener(new View.OnClickListener() { // from class: com.anythink.core.basead.ui.web.WebLandPageActivity.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    am.a(WebLandPageActivity.this.x);
                    if (WebLandPageActivity.this.m != null) {
                        WebLandPageActivity.this.m.reload();
                    }
                }
            });
        }
        WebView webView3 = this.m;
        if (webView3 != null) {
            webView3.setVisibility(8);
        }
        this.y.addView(this.x);
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void onWebFinish() {
        e();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.t = SystemClock.elapsedRealtime();
        this.u = new LinkedHashMap();
        setResult(-1);
        Intent intent = getIntent();
        if (intent != null) {
            try {
                Serializable serializableExtra = intent.getSerializableExtra(com.anythink.core.basead.a.C0075a.c);
                if (serializableExtra != null && (serializableExtra instanceof w)) {
                    this.B = (w) serializableExtra;
                    this.F = new c(this.B);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                Serializable serializableExtra2 = intent.getSerializableExtra(com.anythink.core.basead.a.C0075a.e);
                if (serializableExtra2 != null && (serializableExtra2 instanceof x)) {
                    this.C = (x) serializableExtra2;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            try {
                Serializable serializableExtra3 = intent.getSerializableExtra(com.anythink.core.basead.a.C0075a.k);
                if (serializableExtra3 != null && (serializableExtra3 instanceof IOfferClickHandler)) {
                    this.E = (IOfferClickHandler) serializableExtra3;
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            try {
                this.D = intent.getStringExtra(com.anythink.core.basead.a.C0075a.i);
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
            try {
                this.G = intent.getIntExtra(com.anythink.core.basead.a.C0075a.p, -1);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            this.A = true;
            try {
                this.A = intent.getBooleanExtra(com.anythink.core.basead.a.C0075a.q, true);
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
        }
        String strH = this.D;
        if (TextUtils.isEmpty(strH)) {
            w wVar = this.B;
            strH = wVar != null ? wVar.H() : "";
        }
        Context applicationContext = getApplicationContext();
        if (TextUtils.isEmpty(strH)) {
            Toast.makeText(applicationContext, q.a(applicationContext, "basead_click_empty", "string"), 0).show();
            this.w = 3;
            e();
            return;
        }
        if (this.A) {
            cc ccVarA = e.a(applicationContext, strH, getBaseAdContent());
            if (ccVarA.m) {
                callbackClickResult(ccVarA);
                return;
            }
            callbackClickResult(ccVarA);
        }
        RelativeLayout relativeLayoutF = f();
        this.y = relativeLayoutF;
        if (relativeLayoutF == null) {
            e.b(strH);
            e();
            return;
        }
        setContentView(relativeLayoutF);
        this.n.setOnClickListener(new AnonymousClass6());
        this.o.setOnClickListener(new AnonymousClass7());
        com.anythink.core.basead.ui.a.a.a(this);
        com.anythink.core.basead.ui.a.a.a(this.m, this, this);
        this.m.setDownloadListener(new AnonymousClass3());
        cc ccVarA2 = e.a(strH);
        this.a = ccVarA2.l;
        this.m.loadUrl(ccVarA2.o);
        recordRedirectUrl(this.m.getUrl());
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    private void a(String str) {
        com.anythink.core.basead.ui.a.a.a(this.m, this, this);
        this.m.setDownloadListener(new AnonymousClass3());
        cc ccVarA = e.a(str);
        this.a = ccVarA.l;
        this.m.loadUrl(ccVarA.o);
        recordRedirectUrl(this.m.getUrl());
    }

    /* JADX INFO: renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$3, reason: invalid class name */
    final class AnonymousClass3 implements DownloadListener {
        AnonymousClass3() {
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            t.b();
            if (WebLandPageActivity.this.B != null && WebLandPageActivity.this.C != null && !TextUtils.isEmpty(WebLandPageActivity.this.B.I())) {
                if (WebLandPageActivity.this.E == null || !(WebLandPageActivity.this.E instanceof IOfferClickHandler) || !WebLandPageActivity.this.E.startDataFetchApp(WebLandPageActivity.this.getApplicationContext(), WebLandPageActivity.this.B, WebLandPageActivity.this.C, str)) {
                    if (WebLandPageActivity.f(WebLandPageActivity.this)) {
                        WebLandPageActivity.a(WebLandPageActivity.this, str, 7);
                        return;
                    } else {
                        WebLandPageActivity.this.d = 2;
                        WebLandPageActivity.b(WebLandPageActivity.this, str, 7);
                    }
                } else {
                    WebLandPageActivity.this.a = 6;
                    WebLandPageActivity.this.d = 1;
                }
            } else {
                if (WebLandPageActivity.f(WebLandPageActivity.this)) {
                    WebLandPageActivity.a(WebLandPageActivity.this, str, 11);
                    return;
                }
                WebLandPageActivity.b(WebLandPageActivity.this, str, 11);
            }
            WebLandPageActivity.g(WebLandPageActivity.this);
            WebLandPageActivity.this.e();
        }
    }

    private void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this, q.a(this, "system_dialog", "style"));
        builder.setMessage(getString(q.a(this, "web_download_file_confirm_title", "string"))).setCancelable(true).setPositiveButton(getString(q.a(this, "web_download_file_confirm", "string")), new AnonymousClass5(i, str)).setNegativeButton(getString(q.a(this, "web_download_file_cancel", "string")), new AnonymousClass4(str));
        builder.create().show();
    }

    /* JADX INFO: renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$5, reason: invalid class name */
    final class AnonymousClass5 implements DialogInterface.OnClickListener {
        final /* synthetic */ int a;
        final /* synthetic */ String b;

        AnonymousClass5(int i, String str) {
            this.a = i;
            this.b = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            if (this.a == 7) {
                WebLandPageActivity.this.d = 2;
            }
            WebLandPageActivity.b(WebLandPageActivity.this, this.b, this.a);
            WebLandPageActivity.g(WebLandPageActivity.this);
            com.anythink.core.common.u.e.a(WebLandPageActivity.this.B, WebLandPageActivity.this.C, 3, WebLandPageActivity.this.e > 0, 1, this.b);
            WebLandPageActivity.this.e();
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$4, reason: invalid class name */
    final class AnonymousClass4 implements DialogInterface.OnClickListener {
        final /* synthetic */ String a;

        AnonymousClass4(String str) {
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            com.anythink.core.common.u.e.a(WebLandPageActivity.this.B, WebLandPageActivity.this.C, 3, WebLandPageActivity.this.e > 0, 2, this.a);
        }
    }

    private void b(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        y.a(str);
        this.a = i;
    }

    /* JADX INFO: renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$6, reason: invalid class name */
    final class AnonymousClass6 implements View.OnClickListener {
        AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (WebLandPageActivity.this.m != null && WebLandPageActivity.this.m.canGoBack()) {
                WebLandPageActivity.this.m.goBack();
            } else {
                WebLandPageActivity.this.finish();
            }
        }
    }

    private void d() {
        this.n.setOnClickListener(new AnonymousClass6());
        this.o.setOnClickListener(new AnonymousClass7());
    }

    /* JADX INFO: renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$7, reason: invalid class name */
    final class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WebLandPageActivity.this.finish();
        }
    }

    @Override // com.anythink.core.basead.ui.web.b
    public WebProgressBarView getWebProgressBarView() {
        return this.l;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
        WebView webView = this.m;
        if (webView != null) {
            webView.setWebChromeClient(null);
            com.anythink.core.basead.ui.a.a.a(this.m, isFinishing());
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
        WebView webView = this.m;
        if (webView != null) {
            webView.setWebChromeClient(new WebChromeClient() { // from class: com.anythink.core.basead.ui.web.WebLandPageActivity.8
                @Override // android.webkit.WebChromeClient
                public final boolean onShowFileChooser(WebView webView2, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                    try {
                        WebLandPageActivity.this.H = valueCallback;
                        Intent intent = new Intent("android.intent.action.GET_CONTENT");
                        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*", "audio/*"});
                        intent.addCategory("android.intent.category.OPENABLE");
                        intent.setType("image/* video/* audio/*");
                        WebLandPageActivity.this.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 512);
                        return true;
                    } catch (Throwable unused) {
                        return false;
                    }
                }

                @Override // android.webkit.WebChromeClient
                public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                    com.anythink.core.basead.ui.a.a.a(WebLandPageActivity.this, str, callback);
                    super.onGeolocationPermissionsShowPrompt(str, callback);
                }

                @Override // android.webkit.WebChromeClient
                public final void onProgressChanged(WebView webView2, int i) {
                    if (WebLandPageActivity.this.l != null) {
                        if (!WebLandPageActivity.this.q.isRunning()) {
                            WebLandPageActivity.this.l.setProgress(((i * 30) / 100) + 70);
                        }
                        if (i == 100) {
                            if (WebLandPageActivity.this.q.isRunning()) {
                                WebLandPageActivity.this.q.cancel();
                                WebLandPageActivity.this.l.setProgress(100);
                            }
                            t.b().a(new Runnable() { // from class: com.anythink.core.basead.ui.web.WebLandPageActivity.8.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    WebLandPageActivity.this.l.setVisibility(8);
                                }
                            }, 200L);
                        }
                    }
                }

                @Override // android.webkit.WebChromeClient
                public final void onReceivedTitle(WebView webView2, String str) {
                    super.onReceivedTitle(webView2, str);
                    if (TextUtils.isEmpty(str) || WebLandPageActivity.this.p == null || WebLandPageActivity.this.p.getText().toString().length() != 0) {
                        return;
                    }
                    WebLandPageActivity.this.p.setText(str);
                }
            });
            this.m.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Uri[] uriArr;
        if (i == 512) {
            try {
                if (this.H == null) {
                    return;
                }
                if (i2 != -1 || intent == null) {
                    uriArr = null;
                } else {
                    String dataString = intent.getDataString();
                    try {
                        ClipData clipData = intent.getClipData();
                        if (clipData != null) {
                            uriArr = new Uri[clipData.getItemCount()];
                            for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
                                try {
                                    uriArr[i3] = clipData.getItemAt(i3).getUri();
                                } catch (Throwable unused) {
                                }
                            }
                        } else {
                            uriArr = null;
                        }
                    } catch (Throwable unused2) {
                    }
                    if (dataString != null) {
                        uriArr = new Uri[]{Uri.parse(dataString)};
                    }
                }
                this.H.onReceiveValue(uriArr);
                this.H = null;
            } catch (Throwable unused3) {
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        x xVar = this.C;
        if (xVar != null && xVar.o != null && this.C.o.j() == 1) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(this, q.a(this, "system_dialog", "style"));
                builder.setMessage(getString(q.a(this, "web_land_page_dialog_title", "string"))).setCancelable(true).setPositiveButton(getString(q.a(this, "web_land_page_dialog_stay", "string")), new DialogInterface.OnClickListener() { // from class: com.anythink.core.basead.ui.web.WebLandPageActivity.10
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        com.anythink.core.common.u.e.a(WebLandPageActivity.this.C, WebLandPageActivity.this.B.b(), WebLandPageActivity.this.B.v(), WebLandPageActivity.this.b, WebLandPageActivity.this.v, 0);
                    }
                }).setNegativeButton(getString(q.a(this, "web_land_page_dialog_yes", "string")), new DialogInterface.OnClickListener() { // from class: com.anythink.core.basead.ui.web.WebLandPageActivity.9
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        com.anythink.core.common.u.e.a(WebLandPageActivity.this.C, WebLandPageActivity.this.B.b(), WebLandPageActivity.this.B.v(), WebLandPageActivity.this.b, WebLandPageActivity.this.v, 1);
                        WebLandPageActivity.this.e();
                    }
                });
                builder.create().show();
                return;
            } catch (Throwable unused) {
            }
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            ((ViewGroup) getWindow().getDecorView()).removeAllViews();
        } catch (Throwable unused) {
        }
        super.finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        WebView webView = this.m;
        if (webView != null && webView.canGoBack()) {
            this.m.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        x xVar;
        super.onDestroy();
        ValueAnimator valueAnimator = this.q;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.q = null;
        }
        WebView webView = this.m;
        if (webView != null) {
            webView.setDownloadListener(null);
            this.m.destroy();
        }
        this.m = null;
        w wVar = this.B;
        if (wVar == null || (xVar = this.C) == null) {
            return;
        }
        int iB = wVar.b();
        String strV = this.B.v();
        Map<String, JSONArray> map = this.u;
        int i = this.c;
        int i2 = this.d;
        int i3 = this.a;
        String str = this.D;
        int i4 = this.C.j;
        int i5 = this.G;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.t;
        String str2 = this.v;
        int i6 = this.w;
        if (i6 == 0) {
            i6 = 1;
        }
        com.anythink.core.common.u.e.a(xVar, iB, strV, map, i, i2, i3, str, i4, i5, jElapsedRealtime, str2, i6, this.z);
    }

    private RelativeLayout f() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(-1);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setId(g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, q.a((Context) this, 55.0f));
        layoutParams.addRule(10);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        int iA = q.a((Context) this, 16.0f);
        linearLayout.setPadding(iA, 0, iA, 0);
        relativeLayout.addView(linearLayout);
        this.n = a(getResources().getDrawable(q.a(this, "browser_left_icon", "drawable")));
        this.o = a(getResources().getDrawable(q.a(this, "browser_close_icon", "drawable")));
        linearLayout.addView(this.n);
        linearLayout.addView(this.o);
        TextView textView = new TextView(this);
        new LinearLayout.LayoutParams(0, -2, 1.0f);
        textView.setPadding(q.a((Context) this, 20.0f), 0, 0, q.a((Context) this, 2.0f));
        textView.setTextSize(1, 18.0f);
        textView.setTextColor(Color.parseColor("#666666"));
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        this.p = textView;
        linearLayout.addView(textView);
        try {
            this.m = new BaseWebView(getApplicationContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(3, g);
            this.m.setLayoutParams(layoutParams2);
            relativeLayout.addView(this.m);
            View view = new View(this);
            view.setBackgroundColor(-2434342);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, q.a((Context) this, 1.0f));
            layoutParams3.addRule(3, g);
            view.setLayoutParams(layoutParams3);
            relativeLayout.addView(view);
            WebProgressBarView webProgressBarView = new WebProgressBarView(this);
            this.l = webProgressBarView;
            webProgressBarView.setProgress(0);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, q.a((Context) this, 4.0f));
            layoutParams4.addRule(3, g);
            relativeLayout.addView(this.l, layoutParams4);
            Random random = new Random();
            this.r = random;
            this.s = random.nextInt(12) + 3;
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 70);
            this.q = valueAnimatorOfInt;
            valueAnimatorOfInt.setDuration(1000L);
            this.q.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.core.basead.ui.web.WebLandPageActivity.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (WebLandPageActivity.this.l == null || iIntValue % WebLandPageActivity.this.s != 0) {
                        return;
                    }
                    WebLandPageActivity webLandPageActivity = WebLandPageActivity.this;
                    webLandPageActivity.s = webLandPageActivity.r.nextInt(12) + 3;
                    WebLandPageActivity.this.l.setProgress(iIntValue);
                }
            });
            this.q.start();
            return relativeLayout;
        } catch (Throwable unused) {
            return null;
        }
    }

    private ImageView a(Drawable drawable) {
        ImageView imageView = new ImageView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(q.a((Context) this, 48.0f), q.a((Context) this, 48.0f));
        layoutParams.gravity = 16;
        layoutParams.rightMargin = q.a((Context) this, 6.0f);
        imageView.setLayoutParams(layoutParams);
        int iA = q.a((Context) this, 16.0f);
        imageView.setPadding(iA, iA, iA, iA);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageDrawable(drawable);
        return imageView;
    }

    private TextView g() {
        TextView textView = new TextView(this);
        new LinearLayout.LayoutParams(0, -2, 1.0f);
        textView.setPadding(q.a((Context) this, 20.0f), 0, 0, q.a((Context) this, 2.0f));
        textView.setTextSize(1, 18.0f);
        textView.setTextColor(Color.parseColor("#666666"));
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        return textView;
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void recordRedirectUrl(String str) {
        if (this.b == null) {
            this.b = new JSONArray();
        }
        this.b.put(str);
        if (this.u.size() > 0) {
            JSONArray jSONArray = this.u.get(this.v);
            try {
                if (this.w == 0 && jSONArray != null) {
                    if (TextUtils.isEmpty(jSONArray.getString(1))) {
                        jSONArray.put(1, new StringBuilder().append(System.currentTimeMillis()).toString());
                    }
                    this.u.put(this.v, jSONArray);
                }
            } catch (Throwable unused) {
            }
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(new StringBuilder().append(System.currentTimeMillis()).toString());
        jSONArray2.put("");
        this.u.put(str, jSONArray2);
        this.v = str;
        this.w = 0;
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void callbackClickResult(cc ccVar) {
        this.a = ccVar.l;
        if (ccVar.n) {
            if (ccVar.m) {
                this.c = 1;
                this.w = 2;
                e();
            } else {
                this.c = 2;
                if (ccVar.p) {
                    com.anythink.core.common.u.e.a(this.B, this.C, 2, this.e > 0, 0, ccVar.o);
                }
            }
        }
    }

    @Override // com.anythink.core.basead.ui.web.b
    public boolean supportDeeplinkJump() {
        return this.A;
    }

    @Override // com.anythink.core.basead.ui.web.b
    public w getBaseAdContent() {
        return this.B;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.e = System.currentTimeMillis();
            this.A = true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private boolean h() {
        return System.currentTimeMillis() - this.e > 2500;
    }

    static /* synthetic */ boolean f(WebLandPageActivity webLandPageActivity) {
        return System.currentTimeMillis() - webLandPageActivity.e > 2500;
    }

    static /* synthetic */ void a(WebLandPageActivity webLandPageActivity, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(webLandPageActivity, q.a(webLandPageActivity, "system_dialog", "style"));
        builder.setMessage(webLandPageActivity.getString(q.a(webLandPageActivity, "web_download_file_confirm_title", "string"))).setCancelable(true).setPositiveButton(webLandPageActivity.getString(q.a(webLandPageActivity, "web_download_file_confirm", "string")), webLandPageActivity.new AnonymousClass5(i, str)).setNegativeButton(webLandPageActivity.getString(q.a(webLandPageActivity, "web_download_file_cancel", "string")), webLandPageActivity.new AnonymousClass4(str));
        builder.create().show();
    }

    static /* synthetic */ void b(WebLandPageActivity webLandPageActivity, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        y.a(str);
        webLandPageActivity.a = i;
    }
}
