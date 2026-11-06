package com.byazt.mw;

import android.content.Context;
import android.os.Build;
import android.util.SparseArray;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import com.byazt.ch.g;
import com.byazt.dp.c;
import com.byazt.fj.SSWebView;
import com.byazt.hg.of;
import com.byazt.lz.hw;
import com.byazt.lz.x;
import com.byazt.pj.hn;
import com.byazt.sd.iu;
import com.byazt.sd.nl;
import com.byazt.wt.cz;
import com.byazt.wt.e;
import com.byazt.wt.ls;
import com.byazt.zp.zo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1133, 1711})
public class PageWebView extends FrameLayout implements c {
    public static final SparseArray<WeakReference<DownloadListener>> pr = new SparseArray<>();
    public nl c;
    public Context hn;
    public SSWebView hw;
    public g uc;
    public of x;

    public static void pr(JSONObject jSONObject, DownloadListener downloadListener) {
        if (downloadListener != null && jSONObject != null) {
            pr.put(jSONObject.hashCode(), new WeakReference<>(downloadListener));
        }
    }

    public static void pr(JSONObject jSONObject) {
        if (jSONObject != null) {
            pr.remove(jSONObject.hashCode());
        }
    }

    public PageWebView(Context context) {
        super(context);
        this.hn = context;
        SSWebView sSWebView = new SSWebView(context);
        this.hw = sSWebView;
        sSWebView.setMaterialMeta(e.pr(this.x));
        addView(this.hw);
    }

    public void setUGenContext(g gVar) {
        this.uc = gVar;
    }

    public void setMeta(of ofVar) {
        this.x = ofVar;
        SSWebView sSWebView = this.hw;
        if (sSWebView != null) {
            sSWebView.setMaterialMeta(e.pr(ofVar));
        }
    }

    public void pr() {
        Map<String, Object> mapHw;
        if (this.hw == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.x);
        this.c = new nl(this.hn);
        g gVar = this.uc;
        if (gVar != null && (mapHw = gVar.hw()) != null && mapHw.containsKey("key_reward_page")) {
            Object obj = mapHw.get("key_reward_page");
            if (obj instanceof Map) {
                this.c.pr((Map<String, Object>) obj);
            }
        }
        this.c.hw(this.hw).pr(this.x).hn(arrayList).hw(this.x.x()).x(this.x.B_()).hn(7).pr(ls.hw(this.x)).c(ls.a(this.x)).pr(this.hw).pr(true).hw(com.byazt.ri.c.pr(this.x)).pr((c) this);
        this.hw.setWebViewClient(new x(this.hn, this.c, this.x.x(), new hn(this.x, this.hw), null));
        this.hw.setWebChromeClient(new com.byazt.lz.hn(this.c));
    }

    public void hw(final JSONObject jSONObject) {
        zo.pr(new Runnable() { // from class: com.byazt.mw.PageWebView.1
            @Override // java.lang.Runnable
            public void run() {
                PageWebView.this.hn(jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(JSONObject jSONObject) {
        WeakReference<DownloadListener> weakReference;
        hw.pr(this.hn).pr(false).hw(false).pr(this.hw);
        SSWebView sSWebView = this.hw;
        if (sSWebView != null) {
            cz.pr(sSWebView, iu.x, of.c(this.x));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.hw.setMixedContentMode(0);
        }
        if (jSONObject != null && (weakReference = pr.get(jSONObject.hashCode())) != null && weakReference.get() != null) {
            this.hw.setDownloadListener(weakReference.get());
        }
    }

    public void pr(String str) {
        SSWebView sSWebView = this.hw;
        if (sSWebView != null) {
            sSWebView.loadUrl(str);
        }
    }

    @Override // com.byazt.dp.c
    public void pr(boolean z, JSONArray jSONArray) {
    }
}
