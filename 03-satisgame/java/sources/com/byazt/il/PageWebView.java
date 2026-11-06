package com.byazt.il;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.byazt.gcl.s;
import com.byazt.gct.pk;
import com.byazt.kfh.SSWebView;
import com.byazt.lew.q;
import com.byazt.ll.l;
import com.byazt.nf.tj;
import com.byazt.vgx.w;
import com.byazt.vh.sz;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 586, 1658})
public class PageWebView extends FrameLayout implements l {
    public static final SparseArray<WeakReference<DownloadListener>> n = new SparseArray<>();
    public String fs;
    public s l;
    public pk q;
    public SSWebView qg;
    public Context s;
    public sz w;
    public qg x;

    public interface qg {
        void n();

        void qg();
    }

    @Override // com.byazt.ll.l
    public void n(boolean z, JSONArray jSONArray) {
    }

    public static void n(JSONObject jSONObject, DownloadListener downloadListener) {
        if (downloadListener == null || jSONObject == null) {
            return;
        }
        n.put(jSONObject.hashCode(), new WeakReference<>(downloadListener));
    }

    public static void n(JSONObject jSONObject) {
        if (jSONObject != null) {
            n.remove(jSONObject.hashCode());
        }
    }

    public PageWebView(Context context) {
        super(context);
        this.s = context;
        SSWebView sSWebView = new SSWebView(context);
        this.qg = sSWebView;
        sSWebView.setMaterialMeta(com.byazt.cd.s.n(this.q));
        addView(this.qg);
    }

    public void setUGenContext(sz szVar) {
        this.w = szVar;
    }

    public void setWebViewLifeCycleListener(qg qgVar) {
        this.x = qgVar;
    }

    public void setMeta(pk pkVar) {
        this.q = pkVar;
        SSWebView sSWebView = this.qg;
        if (sSWebView != null) {
            sSWebView.setMaterialMeta(com.byazt.cd.s.n(pkVar));
        }
    }

    public void n() {
        Map<String, Object> mapQg;
        if (this.qg == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.q);
        this.l = new s(this.s);
        sz szVar = this.w;
        if (szVar != null && (mapQg = szVar.qg()) != null && mapQg.containsKey("key_reward_page")) {
            Object obj = mapQg.get("key_reward_page");
            if (obj instanceof Map) {
                this.l.n((Map<String, Object>) obj);
            }
        }
        this.l.qg(this.qg).n(this.q).s(arrayList).qg(this.q.q()).q(this.q.F_()).s(7).n(w.qg(this.q)).l(w.wm(this.q)).n(this.qg).n(true).qg(com.byazt.oh.l.n(this.q)).n((l) this);
        this.qg.setWebViewClient(new n(this.s, this.l, this.q.q(), new com.byazt.hm.s(this.q, this.qg), null));
        this.qg.setWebChromeClient(new com.byazt.dho.qg(this.l));
    }

    public void qg(final JSONObject jSONObject) {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.il.PageWebView.1
            @Override // java.lang.Runnable
            public void run() {
                PageWebView.this.s(jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(JSONObject jSONObject) {
        WeakReference<DownloadListener> weakReference;
        com.byazt.dho.n.n(this.s).n(false).qg(false).n(this.qg);
        SSWebView sSWebView = this.qg;
        if (sSWebView != null) {
            com.byazt.qq.n.n(sSWebView, tj.l, pk.l(this.q));
        }
        this.qg.setMixedContentMode(0);
        if (jSONObject == null || (weakReference = n.get(jSONObject.hashCode())) == null || weakReference.get() == null) {
            return;
        }
        this.qg.setDownloadListener(weakReference.get());
    }

    public void n(String str) {
        this.fs = str;
        SSWebView sSWebView = this.qg;
        if (sSWebView != null) {
            sSWebView.loadUrl(str);
        }
    }

    public void qg() {
        if (this.qg == null || TextUtils.isEmpty(this.fs)) {
            return;
        }
        this.qg.loadUrl(this.fs);
    }

    @com.byazt.cp.n(n = {0, 1, 586, 600})
    private class n extends com.byazt.dho.s {
        public n(Context context, s sVar, String str, com.byazt.hm.s sVar2, q qVar) {
            super(context, sVar, str, sVar2, qVar);
        }

        @Override // com.byazt.dho.s, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (PageWebView.this.x != null) {
                PageWebView.this.x.n();
            }
        }

        @Override // com.byazt.dho.s, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (PageWebView.this.x != null) {
                PageWebView.this.x.qg();
            }
        }
    }
}
