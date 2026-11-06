package com.anythink.basead.mraid;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.v.q;
import com.anythink.core.common.v.z;
import com.anythink.network.tap.TapATInitManager;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class g extends Dialog {
    private final String a;
    private String b;
    private boolean c;
    private FrameLayout d;
    private MraidBaseWebView e;
    private TextView f;
    private e g;
    private com.anythink.core.express.b.b h;

    public g(Context context, Bundle bundle, e eVar) {
        super(context);
        this.a = "BannerExpandDialog";
        this.h = new com.anythink.core.express.b.b() { // from class: com.anythink.basead.mraid.g.4
            @Override // com.anythink.core.express.b.b
            public final void expand(String str, boolean z) {
            }

            @Override // com.anythink.core.express.b.b
            public final void open(String str) {
                try {
                    if (g.this.g != null) {
                        g.this.g.open(str);
                    }
                } catch (Throwable unused) {
                }
            }

            @Override // com.anythink.core.express.b.b
            public final void close() {
                g.this.dismiss();
            }

            @Override // com.anythink.core.express.b.b
            public final void unload() {
                close();
            }

            @Override // com.anythink.core.express.b.b
            public final void useCustomClose(boolean z) {
                try {
                    g.this.f.setVisibility(z ? 4 : 0);
                } catch (Throwable unused) {
                }
            }
        };
        this.b = bundle.getString("url");
        this.c = bundle.getBoolean("shouldUseCustomClose");
        this.g = eVar;
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.d = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        MraidBaseWebView mraidBaseWebView = new MraidBaseWebView(getContext().getApplicationContext());
        this.e = mraidBaseWebView;
        mraidBaseWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.d.addView(this.e);
        TextView textView = new TextView(getContext());
        this.f = textView;
        textView.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = 8388661;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f.setLayoutParams(layoutParams);
        this.f.setVisibility(this.c ? 4 : 0);
        this.f.setOnClickListener(new AnonymousClass1());
        this.d.addView(this.f);
        setContentView(this.d);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            getWindow().getDecorView().setSystemUiVisibility(4615);
        }
        this.e.setWebViewListener(new AnonymousClass2());
        this.e.setObject(this.h);
        this.e.loadUrl(this.b);
        setOnDismissListener(new AnonymousClass3());
    }

    private void a() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.d = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        MraidBaseWebView mraidBaseWebView = new MraidBaseWebView(getContext().getApplicationContext());
        this.e = mraidBaseWebView;
        mraidBaseWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.d.addView(this.e);
        TextView textView = new TextView(getContext());
        this.f = textView;
        textView.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = 8388661;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f.setLayoutParams(layoutParams);
        this.f.setVisibility(this.c ? 4 : 0);
        this.f.setOnClickListener(new AnonymousClass1());
        this.d.addView(this.f);
        setContentView(this.d);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            getWindow().getDecorView().setSystemUiVisibility(4615);
        }
        this.e.setWebViewListener(new AnonymousClass2());
        this.e.setObject(this.h);
        this.e.loadUrl(this.b);
        setOnDismissListener(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: com.anythink.basead.mraid.g$1, reason: invalid class name */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            g.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.mraid.g$2, reason: invalid class name */
    final class AnonymousClass2 extends b {
        AnonymousClass2() {
        }

        @Override // com.anythink.basead.mraid.b, com.anythink.core.express.web.c
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            webView.evaluateJavascript("javascript:" + z.a().b(), new ValueCallback<String>() { // from class: com.anythink.basead.mraid.g.2.1
                private static void a() {
                }

                @Override // android.webkit.ValueCallback
                public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                }
            });
            g.a(g.this);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.mraid.g$3, reason: invalid class name */
    final class AnonymousClass3 implements DialogInterface.OnDismissListener {
        AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            g.this.e.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            g.this.d.removeView(g.this.e);
            g.this.e.release();
            g.this.e = null;
            g.this.g = null;
        }
    }

    private void b() {
        String str;
        try {
            int i = t.b().g().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            if (i == 2) {
                str = "landscape";
            } else {
                str = i == 1 ? "portrait" : "undefined";
            }
            jSONObject.put(TapATInitManager.ORIENTATION_KEY, str);
            jSONObject.put("locked", "true");
            float fE = q.e(t.b().g());
            float f = q.f(t.b().g());
            HashMap mapG = q.g(t.b().g());
            int iIntValue = ((Integer) mapG.get("width")).intValue();
            int iIntValue2 = ((Integer) mapG.get("height")).intValue();
            HashMap map = new HashMap();
            map.put(com.anythink.core.express.b.a.a, "Interstitial");
            map.put("state", com.anythink.core.express.b.a.g);
            map.put(com.anythink.core.express.b.a.c, "true");
            map.put(com.anythink.core.express.b.a.d, jSONObject);
            int[] iArr = new int[2];
            this.e.getLocationInWindow(iArr);
            com.anythink.core.express.b.a.a();
            MraidBaseWebView mraidBaseWebView = this.e;
            com.anythink.core.express.b.a.a(mraidBaseWebView, iArr[0], iArr[1], mraidBaseWebView.getWidth(), this.e.getHeight());
            com.anythink.core.express.b.a.a();
            MraidBaseWebView mraidBaseWebView2 = this.e;
            com.anythink.core.express.b.a.b(mraidBaseWebView2, iArr[0], iArr[1], mraidBaseWebView2.getWidth(), this.e.getHeight());
            com.anythink.core.express.b.a.a();
            com.anythink.core.express.b.a.b(this.e, fE, f);
            com.anythink.core.express.b.a.a();
            com.anythink.core.express.b.a.c(this.e, iIntValue, iIntValue2);
            com.anythink.core.express.b.a.a();
            com.anythink.core.express.b.a.a(this.e, map);
            com.anythink.core.express.b.a.a();
            com.anythink.core.express.b.a.a(this.e);
        } catch (Throwable unused) {
        }
    }

    static /* synthetic */ void a(g gVar) {
        String str;
        try {
            int i = t.b().g().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            if (i == 2) {
                str = "landscape";
            } else {
                str = i == 1 ? "portrait" : "undefined";
            }
            jSONObject.put(TapATInitManager.ORIENTATION_KEY, str);
            jSONObject.put("locked", "true");
            float fE = q.e(t.b().g());
            float f = q.f(t.b().g());
            HashMap mapG = q.g(t.b().g());
            int iIntValue = ((Integer) mapG.get("width")).intValue();
            int iIntValue2 = ((Integer) mapG.get("height")).intValue();
            HashMap map = new HashMap();
            map.put(com.anythink.core.express.b.a.a, "Interstitial");
            map.put("state", com.anythink.core.express.b.a.g);
            map.put(com.anythink.core.express.b.a.c, "true");
            map.put(com.anythink.core.express.b.a.d, jSONObject);
            int[] iArr = new int[2];
            gVar.e.getLocationInWindow(iArr);
            com.anythink.core.express.b.a.a();
            MraidBaseWebView mraidBaseWebView = gVar.e;
            com.anythink.core.express.b.a.a(mraidBaseWebView, iArr[0], iArr[1], mraidBaseWebView.getWidth(), gVar.e.getHeight());
            com.anythink.core.express.b.a.a();
            MraidBaseWebView mraidBaseWebView2 = gVar.e;
            com.anythink.core.express.b.a.b(mraidBaseWebView2, iArr[0], iArr[1], mraidBaseWebView2.getWidth(), gVar.e.getHeight());
            com.anythink.core.express.b.a.a();
            com.anythink.core.express.b.a.b(gVar.e, fE, f);
            com.anythink.core.express.b.a.a();
            com.anythink.core.express.b.a.c(gVar.e, iIntValue, iIntValue2);
            com.anythink.core.express.b.a.a();
            com.anythink.core.express.b.a.a(gVar.e, map);
            com.anythink.core.express.b.a.a();
            com.anythink.core.express.b.a.a(gVar.e);
        } catch (Throwable unused) {
        }
    }
}
