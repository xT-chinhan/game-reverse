package com.anythink.basead.e;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.basead.e;
import com.anythink.core.basead.ui.web.BaseWebView;
import com.anythink.core.basead.ui.web.WebProgressBarView;
import com.anythink.core.basead.ui.web.b;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.cc;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.q;
import com.anythink.core.common.v.y;
import com.anythink.core.express.d.d;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes.dex */
public class a extends Dialog {
    private final String A;
    private final String B;
    private View.OnClickListener C;
    public w a;
    public x b;
    String c;
    private final String d;
    private e.a e;
    private RelativeLayout f;
    private EditText g;
    private ImageView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private String s;
    private TextView t;
    private FrameLayout u;
    private BaseWebView v;
    private boolean w;
    private final String x;
    private final String y;
    private final String z;

    static /* synthetic */ boolean c(a aVar) {
        aVar.w = true;
        return true;
    }

    private a(Context context) {
        super(context);
        this.d = "a";
        this.c = "";
        this.w = false;
        this.x = "HybridInteract";
        this.y = "HybridInteractCall";
        this.z = ILivePush.ClickType.CLOSE;
        this.A = "showfeedback";
        this.B = "browser";
        this.C = new View.OnClickListener() { // from class: com.anythink.basead.e.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (view instanceof TextView) {
                    TextView textView = (TextView) view;
                    a.a(a.this, textView, textView.getTag().toString());
                }
            }
        };
    }

    public a(Context context, int i) {
        super(context, i);
        this.d = "a";
        this.c = "";
        this.w = false;
        this.x = "HybridInteract";
        this.y = "HybridInteractCall";
        this.z = ILivePush.ClickType.CLOSE;
        this.A = "showfeedback";
        this.B = "browser";
        this.C = new View.OnClickListener() { // from class: com.anythink.basead.e.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (view instanceof TextView) {
                    TextView textView = (TextView) view;
                    a.a(a.this, textView, textView.getTag().toString());
                }
            }
        };
    }

    private a(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.d = "a";
        this.c = "";
        this.w = false;
        this.x = "HybridInteract";
        this.y = "HybridInteractCall";
        this.z = ILivePush.ClickType.CLOSE;
        this.A = "showfeedback";
        this.B = "browser";
        this.C = new View.OnClickListener() { // from class: com.anythink.basead.e.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (view instanceof TextView) {
                    TextView textView = (TextView) view;
                    a.a(a.this, textView, textView.getTag().toString());
                }
            }
        };
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context context = getContext();
        setContentView(q.a(context, "myoffer_feedback", "layout"));
        setCancelable(true);
        Window window = getWindow();
        if (window != null) {
            if (context.getResources().getDisplayMetrics().widthPixels > context.getResources().getDisplayMetrics().heightPixels) {
                window.setGravity(5);
                window.setLayout(q.a(context, 376.0f), -1);
            } else {
                window.setGravity(80);
                window.setLayout(-1, -2);
            }
        }
        Context context2 = getContext();
        this.h = (ImageView) findViewById(q.a(context2, "myoffer_feedback_iv_close", "id"));
        this.f = (RelativeLayout) findViewById(q.a(context2, "myoffer_feedback_container", "id"));
        this.u = (FrameLayout) findViewById(q.a(context2, "myoffer_feedback_privacy_web_container", "id"));
        this.g = (EditText) findViewById(q.a(context2, "myoffer_feedback_et", "id"));
        this.i = (TextView) findViewById(q.a(context2, "myoffer_feedback_tv_commit", "id"));
        this.j = (TextView) findViewById(q.a(context2, "myoffer_feedback_tv_1", "id"));
        this.k = (TextView) findViewById(q.a(context2, "myoffer_feedback_tv_2", "id"));
        this.l = (TextView) findViewById(q.a(context2, "myoffer_feedback_tv_3", "id"));
        this.m = (TextView) findViewById(q.a(context2, "myoffer_feedback_tv_4", "id"));
        this.n = (TextView) findViewById(q.a(context2, "myoffer_feedback_tv_5", "id"));
        this.o = (TextView) findViewById(q.a(context2, "myoffer_feedback_tv_6", "id"));
        this.p = (TextView) findViewById(q.a(context2, "myoffer_feedback_tv_7", "id"));
        this.q = (TextView) findViewById(q.a(context2, "myoffer_feedback_tv_8", "id"));
        this.r = (TextView) findViewById(q.a(context2, "myoffer_feedback_tv_9", "id"));
        this.h.setOnClickListener(new AnonymousClass5());
        this.j.setOnClickListener(this.C);
        this.k.setOnClickListener(this.C);
        this.l.setOnClickListener(this.C);
        this.m.setOnClickListener(this.C);
        this.n.setOnClickListener(this.C);
        this.o.setOnClickListener(this.C);
        this.p.setOnClickListener(this.C);
        this.q.setOnClickListener(this.C);
        this.r.setOnClickListener(this.C);
        this.g.addTextChangedListener(new AnonymousClass6());
        this.i.setOnClickListener(new AnonymousClass7());
        if (TextUtils.isEmpty(this.c)) {
            c();
            com.anythink.core.common.u.e.a(this.b, this.a, "");
        } else {
            this.f.setVisibility(8);
            this.u.setVisibility(0);
            BaseWebView baseWebView = new BaseWebView(context2);
            this.v = baseWebView;
            baseWebView.setBackgroundColor(-1);
            com.anythink.core.basead.ui.a.a.a(this.v, context2, new AnonymousClass3());
            com.anythink.core.basead.ui.a.a.a(this.v, new AnonymousClass4());
            this.v.loadUrl(this.c);
            this.u.addView(this.v);
        }
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.anythink.basead.e.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                a.this.a();
            }
        });
    }

    private void b() {
        Context context = getContext();
        this.h = (ImageView) findViewById(q.a(context, "myoffer_feedback_iv_close", "id"));
        this.f = (RelativeLayout) findViewById(q.a(context, "myoffer_feedback_container", "id"));
        this.u = (FrameLayout) findViewById(q.a(context, "myoffer_feedback_privacy_web_container", "id"));
        this.g = (EditText) findViewById(q.a(context, "myoffer_feedback_et", "id"));
        this.i = (TextView) findViewById(q.a(context, "myoffer_feedback_tv_commit", "id"));
        this.j = (TextView) findViewById(q.a(context, "myoffer_feedback_tv_1", "id"));
        this.k = (TextView) findViewById(q.a(context, "myoffer_feedback_tv_2", "id"));
        this.l = (TextView) findViewById(q.a(context, "myoffer_feedback_tv_3", "id"));
        this.m = (TextView) findViewById(q.a(context, "myoffer_feedback_tv_4", "id"));
        this.n = (TextView) findViewById(q.a(context, "myoffer_feedback_tv_5", "id"));
        this.o = (TextView) findViewById(q.a(context, "myoffer_feedback_tv_6", "id"));
        this.p = (TextView) findViewById(q.a(context, "myoffer_feedback_tv_7", "id"));
        this.q = (TextView) findViewById(q.a(context, "myoffer_feedback_tv_8", "id"));
        this.r = (TextView) findViewById(q.a(context, "myoffer_feedback_tv_9", "id"));
        this.h.setOnClickListener(new AnonymousClass5());
        this.j.setOnClickListener(this.C);
        this.k.setOnClickListener(this.C);
        this.l.setOnClickListener(this.C);
        this.m.setOnClickListener(this.C);
        this.n.setOnClickListener(this.C);
        this.o.setOnClickListener(this.C);
        this.p.setOnClickListener(this.C);
        this.q.setOnClickListener(this.C);
        this.r.setOnClickListener(this.C);
        this.g.addTextChangedListener(new AnonymousClass6());
        this.i.setOnClickListener(new AnonymousClass7());
        if (TextUtils.isEmpty(this.c)) {
            c();
            com.anythink.core.common.u.e.a(this.b, this.a, "");
            return;
        }
        this.f.setVisibility(8);
        this.u.setVisibility(0);
        BaseWebView baseWebView = new BaseWebView(context);
        this.v = baseWebView;
        baseWebView.setBackgroundColor(-1);
        com.anythink.core.basead.ui.a.a.a(this.v, context, new AnonymousClass3());
        com.anythink.core.basead.ui.a.a.a(this.v, new AnonymousClass4());
        this.v.loadUrl(this.c);
        this.u.addView(this.v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f.setVisibility(0);
        this.u.setVisibility(8);
    }

    private void a(Context context) {
        BaseWebView baseWebView = new BaseWebView(context);
        this.v = baseWebView;
        baseWebView.setBackgroundColor(-1);
        com.anythink.core.basead.ui.a.a.a(this.v, context, new AnonymousClass3());
        com.anythink.core.basead.ui.a.a.a(this.v, new AnonymousClass4());
        this.v.loadUrl(this.c);
        this.u.addView(this.v);
    }

    /* JADX INFO: renamed from: com.anythink.basead.e.a$3, reason: invalid class name */
    final class AnonymousClass3 implements b {
        @Override // com.anythink.core.basead.ui.web.b
        public final void callbackClickResult(cc ccVar) {
        }

        @Override // com.anythink.core.basead.ui.web.b
        public final w getBaseAdContent() {
            return null;
        }

        @Override // com.anythink.core.basead.ui.web.b
        public final WebProgressBarView getWebProgressBarView() {
            return null;
        }

        @Override // com.anythink.core.basead.ui.web.b
        public final void onWebFinish() {
        }

        @Override // com.anythink.core.basead.ui.web.b
        public final void onWebPageStart(WebView webView, String str) {
        }

        @Override // com.anythink.core.basead.ui.web.b
        public final void recordRedirectUrl(String str) {
        }

        @Override // com.anythink.core.basead.ui.web.b
        public final boolean supportDeeplinkJump() {
            return true;
        }

        AnonymousClass3() {
        }

        @Override // com.anythink.core.basead.ui.web.b
        public final void onWebPageFinish(WebView webView, String str) {
            String unused = a.this.d;
            if (a.this.w) {
                return;
            }
            a.c(a.this);
            a.d(a.this);
            com.anythink.core.common.u.e.a(a.this.b, a.this.a, "1");
        }

        @Override // com.anythink.core.basead.ui.web.b
        public final void onWebPageLoadError(WebView webView, String str) {
            if (a.this.w) {
                return;
            }
            a.c(a.this);
            a.this.c();
            com.anythink.core.common.u.e.a(a.this.b, a.this.a, "2");
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.e.a$4, reason: invalid class name */
    final class AnonymousClass4 extends WebChromeClient {
        AnonymousClass4() {
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (consoleMessage == null) {
                return false;
            }
            String unused = a.this.d;
            new StringBuilder("onConsoleMessage: [").append(consoleMessage.messageLevel());
            consoleMessage.message();
            if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.LOG) {
                return super.onConsoleMessage(consoleMessage);
            }
            a.this.a(consoleMessage.message());
            return false;
        }
    }

    private void d() {
        String str;
        w wVar = this.a;
        String strAj = wVar != null ? wVar.aj() : "";
        if (TextUtils.isEmpty(strAj)) {
            return;
        }
        BaseWebView baseWebView = this.v;
        String strEncodeToString = Base64.encodeToString(strAj.getBytes(), 2);
        if (baseWebView == null || baseWebView.isDestroyed()) {
            return;
        }
        if (TextUtils.isEmpty(strEncodeToString)) {
            str = String.format("javascript:window.HybridInteract.fireEvent('%s', '');", "setData");
        } else {
            str = String.format("javascript:window.HybridInteract.fireEvent('%s','%s');", "setData", d.c(strEncodeToString));
        }
        try {
            baseWebView.loadUrl(str);
        } catch (Throwable unused) {
        }
    }

    private static void a(BaseWebView baseWebView, String str, String str2) {
        String str3;
        if (baseWebView == null || baseWebView.isDestroyed()) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str3 = String.format("javascript:window.HybridInteract.fireEvent('%s', '');", str);
        } else {
            str3 = String.format("javascript:window.HybridInteract.fireEvent('%s','%s');", str, d.c(str2));
        }
        try {
            baseWebView.loadUrl(str3);
        } catch (Throwable unused) {
        }
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("HybridInteractCall")) {
            return;
        }
        String[] strArrSplit = str.split("_");
        if (strArrSplit.length >= 2) {
            String str2 = strArrSplit[1];
            if (TextUtils.isEmpty(str2)) {
            }
            str2.hashCode();
            switch (str2) {
                case "showfeedback":
                    c();
                    break;
                case "close":
                    g();
                    break;
                case "browser":
                    try {
                        String strSubstring = str.substring(27);
                        if (!TextUtils.isEmpty(strSubstring)) {
                            strSubstring = URLDecoder.decode(strSubstring);
                        }
                        if (!TextUtils.isEmpty(strSubstring)) {
                            y.a(strSubstring);
                        }
                        break;
                    } catch (Throwable unused) {
                        return;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.e.a$5, reason: invalid class name */
    final class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.this.g();
        }
    }

    private void e() {
        this.h.setOnClickListener(new AnonymousClass5());
        this.j.setOnClickListener(this.C);
        this.k.setOnClickListener(this.C);
        this.l.setOnClickListener(this.C);
        this.m.setOnClickListener(this.C);
        this.n.setOnClickListener(this.C);
        this.o.setOnClickListener(this.C);
        this.p.setOnClickListener(this.C);
        this.q.setOnClickListener(this.C);
        this.r.setOnClickListener(this.C);
        this.g.addTextChangedListener(new AnonymousClass6());
        this.i.setOnClickListener(new AnonymousClass7());
    }

    /* JADX INFO: renamed from: com.anythink.basead.e.a$6, reason: invalid class name */
    final class AnonymousClass6 implements TextWatcher {
        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        AnonymousClass6() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            a.this.f();
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.e.a$7, reason: invalid class name */
    final class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.anythink.core.common.u.e.a(a.this.a, a.this.b, TextUtils.isEmpty(a.this.s) ? "0" : a.this.s, a.this.g.getText().toString());
            if (a.this.e != null) {
                e.a unused = a.this.e;
            }
            a.this.g();
        }
    }

    public final void a(e.a aVar, w wVar, x xVar) {
        this.e = aVar;
        this.a = wVar;
        this.b = xVar;
        if (wVar != null) {
            this.c = wVar.ak();
        }
    }

    private void a(TextView textView, String str) {
        if (TextUtils.isEmpty(this.s)) {
            this.s = str;
            this.t = textView;
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#2265FF"));
                this.t.setBackgroundResource(q.a(textView.getContext(), "myoffer_bg_feedback_textview_pressed", "drawable"));
            }
        } else if (TextUtils.equals(this.s, str)) {
            TextView textView2 = this.t;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor("#84879D"));
                this.t.setBackgroundResource(q.a(textView.getContext(), "myoffer_bg_feedback_textview", "drawable"));
            }
            this.s = "";
            this.t = null;
        } else {
            TextView textView3 = this.t;
            if (textView3 != null) {
                textView3.setTextColor(Color.parseColor("#84879D"));
                this.t.setBackgroundResource(q.a(textView.getContext(), "myoffer_bg_feedback_textview", "drawable"));
            }
            this.s = str;
            this.t = textView;
            textView.setTextColor(Color.parseColor("#2265FF"));
            this.t.setBackgroundResource(q.a(textView.getContext(), "myoffer_bg_feedback_textview_pressed", "drawable"));
        }
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (TextUtils.isEmpty(this.s) && TextUtils.isEmpty(this.g.getText().toString())) {
            this.i.setEnabled(false);
        } else {
            this.i.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        t.b().a(new Runnable() { // from class: com.anythink.basead.e.a.8
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.dismiss();
                } catch (Throwable unused) {
                }
            }
        }, 30L);
    }

    public final void a() {
        e.a aVar = this.e;
        if (aVar != null) {
            aVar.b();
        }
        this.e = null;
        this.a = null;
        this.b = null;
        BaseWebView baseWebView = this.v;
        if (baseWebView != null) {
            baseWebView.destroy();
            this.v = null;
        }
    }

    static /* synthetic */ void a(a aVar, TextView textView, String str) {
        if (TextUtils.isEmpty(aVar.s)) {
            aVar.s = str;
            aVar.t = textView;
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#2265FF"));
                aVar.t.setBackgroundResource(q.a(textView.getContext(), "myoffer_bg_feedback_textview_pressed", "drawable"));
            }
        } else if (TextUtils.equals(aVar.s, str)) {
            TextView textView2 = aVar.t;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor("#84879D"));
                aVar.t.setBackgroundResource(q.a(textView.getContext(), "myoffer_bg_feedback_textview", "drawable"));
            }
            aVar.s = "";
            aVar.t = null;
        } else {
            TextView textView3 = aVar.t;
            if (textView3 != null) {
                textView3.setTextColor(Color.parseColor("#84879D"));
                aVar.t.setBackgroundResource(q.a(textView.getContext(), "myoffer_bg_feedback_textview", "drawable"));
            }
            aVar.s = str;
            aVar.t = textView;
            textView.setTextColor(Color.parseColor("#2265FF"));
            aVar.t.setBackgroundResource(q.a(textView.getContext(), "myoffer_bg_feedback_textview_pressed", "drawable"));
        }
        aVar.f();
    }

    static /* synthetic */ void d(a aVar) {
        String str;
        w wVar = aVar.a;
        String strAj = wVar != null ? wVar.aj() : "";
        if (TextUtils.isEmpty(strAj)) {
            return;
        }
        BaseWebView baseWebView = aVar.v;
        String strEncodeToString = Base64.encodeToString(strAj.getBytes(), 2);
        if (baseWebView == null || baseWebView.isDestroyed()) {
            return;
        }
        if (TextUtils.isEmpty(strEncodeToString)) {
            str = String.format("javascript:window.HybridInteract.fireEvent('%s', '');", "setData");
        } else {
            str = String.format("javascript:window.HybridInteract.fireEvent('%s','%s');", "setData", d.c(strEncodeToString));
        }
        try {
            baseWebView.loadUrl(str);
        } catch (Throwable unused) {
        }
    }
}
