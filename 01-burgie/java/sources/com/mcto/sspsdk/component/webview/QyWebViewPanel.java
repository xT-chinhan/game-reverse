package com.mcto.sspsdk.component.webview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.button.DownloadButtonView;
import com.mcto.sspsdk.internal.c1;
import com.mcto.sspsdk.internal.e1;
import com.mcto.sspsdk.internal.fc;
import com.mcto.sspsdk.internal.gd;
import com.mcto.sspsdk.internal.gj;
import com.mcto.sspsdk.internal.h;
import com.mcto.sspsdk.internal.hk;
import com.mcto.sspsdk.internal.j1;
import com.mcto.sspsdk.internal.t0;
import com.mcto.sspsdk.internal.u0;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class QyWebViewPanel extends ConstraintLayout implements View.OnClickListener {
    private QyWebViewDataBean a;
    private final Context b;
    private QyWebViewCore c;
    private ProgressBar d;
    private DownloadButtonView e;
    private u0 f;
    private String g;
    private String h;
    private boolean i;
    private volatile boolean j;
    private final ArrayList k;
    private gd l;
    private JSONObject m;

    public QyWebViewPanel(Context context) {
        this(context, null);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.e) {
            a(2);
            gd gdVar = this.l;
            if (gdVar != null) {
                gdVar.f();
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.j = true;
        return super.onInterceptTouchEvent(motionEvent);
    }

    public QyWebViewPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final boolean b() {
        QyWebViewCore qyWebViewCore = this.c;
        if (qyWebViewCore != null) {
            return qyWebViewCore.canGoBack();
        }
        return true;
    }

    public final void c() {
        if (this.c != null) {
            removeAllViews();
            this.c.destroy();
        }
        this.c = null;
        this.d = null;
    }

    public final QyWebViewCore d() {
        return this.c;
    }

    public final void e() {
        QyWebViewCore qyWebViewCore = this.c;
        if (qyWebViewCore != null) {
            qyWebViewCore.goBack();
        }
    }

    public final void f() {
        QyWebViewCore qyWebViewCore = this.c;
        if (qyWebViewCore != null) {
            qyWebViewCore.getSettings().setJavaScriptEnabled(true);
        }
    }

    public final void g() {
        QyWebViewCore qyWebViewCore = this.c;
        if (qyWebViewCore != null) {
            qyWebViewCore.getSettings().setJavaScriptEnabled(false);
        }
    }

    public QyWebViewPanel(Context context, AttributeSet attributeSet, int i) {
        super(context.getApplicationContext(), attributeSet, i);
        this.e = null;
        this.f = null;
        this.i = true;
        this.j = false;
        this.k = new ArrayList();
        this.b = context;
    }

    static boolean a(QyWebViewPanel qyWebViewPanel, Uri uri) {
        qyWebViewPanel.getClass();
        String scheme = uri.getScheme();
        if (scheme == null) {
            return false;
        }
        gd gdVar = qyWebViewPanel.l;
        if (gdVar != null) {
            uri.toString();
            if (gdVar.n[0] == 1) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long[] jArr = gdVar.n;
                if (jCurrentTimeMillis - jArr[1] <= 500) {
                    jArr[1] = 0;
                    jArr[0] = 0;
                    gdVar.f();
                }
            }
        }
        String lowerCase = scheme.toLowerCase();
        if (lowerCase.equals("tel")) {
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(uri);
            intent.setFlags(805306368);
            qyWebViewPanel.b.startActivity(intent);
            return true;
        }
        if (lowerCase.startsWith("http")) {
            return false;
        }
        if (!qyWebViewPanel.j && qyWebViewPanel.a.m()) {
            return true;
        }
        try {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(uri);
            intent2.setFlags(805306368);
            qyWebViewPanel.b.startActivity(intent2);
        } catch (Exception e) {
        }
        return true;
    }

    public final void a(QyWebViewDataBean qyWebViewDataBean) {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        this.a = qyWebViewDataBean;
        this.h = qyWebViewDataBean.e();
        this.g = qyWebViewDataBean.a();
        try {
            this.k.add(this.a.g());
            this.m = new JSONObject(qyWebViewDataBean.f());
        } catch (Exception e) {
        }
        LayoutInflater.from(getContext()).inflate(R.layout.qy_layout_web_view, (ViewGroup) this, true);
        this.d = (ProgressBar) findViewById(R.id.qy_web_view_progressbar);
        this.c = (QyWebViewCore) findViewById(R.id.qy_web_view_core);
        e eVar = new e(this, this.b);
        this.c.setWebChromeClient(new d(this, this.b));
        JSONObject jSONObject2 = this.m;
        if (jSONObject2 != null && jSONObject2.optInt("chooseDialog", 0) == 1) {
            eVar.d = true;
        }
        this.c.setWebViewClient(eVar);
        this.c.setDownloadListener(new b(this));
        this.c.loadUrl(gj.c(this.a.h()));
        if (this.a.l() && (jSONObject = this.m) != null) {
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("landingPageBtn");
                if (this.a.n()) {
                    if (((jSONObjectOptJSONObject2 == null || !jSONObjectOptJSONObject2.has("showType")) ? 1 : jSONObjectOptJSONObject2.optInt("showType", 1)) == 1) {
                        a();
                    }
                }
                JSONArray jSONArrayOptJSONArray = this.m.optJSONArray("lpSdks");
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        try {
                            this.k.add(jSONArrayOptJSONArray.optString(i));
                        } catch (Exception e2) {
                        }
                    }
                }
                this.i = this.m.optBoolean("canDownloadApk", true);
                if (1 == this.m.optInt("landingPageAppInfo", 1) && (jSONObjectOptJSONObject = this.m.optJSONObject("appInfo")) != null) {
                    TextView textView = (TextView) findViewById(R.id.qy_web_view_app_info);
                    if (j1.a(this.b, jSONObjectOptJSONObject, textView)) {
                        textView.setVisibility(0);
                        textView.setGravity(17);
                    }
                }
            } catch (Exception e3) {
            }
        }
        if (this.a.i()) {
            if (this.e == null) {
                a();
            }
            DownloadButtonView downloadButtonView = this.e;
            if (downloadButtonView == null || downloadButtonView.c() == 1) {
                return;
            }
            this.e.performClick();
        }
    }

    public final void a(gd gdVar) {
        this.l = gdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.a.n() && this.e == null && !TextUtils.isEmpty(this.h)) {
            DownloadButtonView downloadButtonView = (DownloadButtonView) findViewById(R.id.qy_web_view_download_btn);
            this.e = downloadButtonView;
            downloadButtonView.b(hk.a(this.b, 8.0f));
            this.e.setOnClickListener(this);
            this.e.setVisibility(0);
            h hVar = new h(this.e);
            hVar.a(this.h, this.g);
            this.e.a(hVar);
            hVar.a();
            return;
        }
        this.a.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i == 1 && !this.i) {
            fc.a(this.b, "请点击最底部的【下载按钮】进行下载。");
            return;
        }
        String strA = this.e.a();
        if (TextUtils.isEmpty(strA)) {
            strA = this.g;
        }
        if (e1.c(strA)) {
            if (e1.a(true, this.b, this.a.d(), strA) || e1.a(this.b, strA)) {
                return;
            }
            fc.a(this.b, "发生未知错误。");
            return;
        }
        if (this.f == null) {
            t0 t0Var = new t0();
            t0Var.i = this.g;
            t0Var.g = this.a.c();
            t0Var.h = this.a.b();
            t0Var.d = this.h;
            t0Var.p = this.a.d();
            this.f = new u0(t0Var.a(this.a.j()));
        }
        if (this.e.c() != 1) {
            if (i == 1) {
                new AlertDialog.Builder(this.b).setTitle("是否下载该应用？").setNegativeButton("取消", (DialogInterface.OnClickListener) null).setPositiveButton("确定", new c(this)).create().show();
                return;
            } else {
                c1.a().a(this.f);
                return;
            }
        }
        if (1 == i) {
            fc.a(this.b, "已添加下载管理器中");
        } else if (2 == i) {
            c1.a().a(this.f);
        }
    }
}
