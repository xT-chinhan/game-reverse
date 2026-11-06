package com.bytedance.sdk.openadsdk.core.ugeno.webview;

import android.content.Context;
import android.util.SparseArray;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.ah.hi;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.ao.d;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.hi.ah.ub;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.t;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.pc;
import com.bytedance.sdk.openadsdk.core.widget.ms.ah;
import com.bytedance.sdk.openadsdk.core.widget.ms.xr;
import com.bytedance.sdk.openadsdk.op.ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PageWebView extends FrameLayout implements d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final SparseArray<WeakReference<DownloadListener>> f3569ms = new SparseArray<>();
    private Context ah;
    private hi c;
    private lm d;
    private pc ka;
    private SSWebView xr;

    @Override // com.bytedance.sdk.openadsdk.core.ao.d
    public void ms(boolean z, JSONArray jSONArray) {
    }

    public static void ms(JSONObject jSONObject, DownloadListener downloadListener) {
        if (downloadListener == null || jSONObject == null) {
            return;
        }
        f3569ms.put(jSONObject.hashCode(), new WeakReference<>(downloadListener));
    }

    public static void ms(JSONObject jSONObject) {
        if (jSONObject != null) {
            f3569ms.remove(jSONObject.hashCode());
        }
    }

    public PageWebView(Context context) {
        super(context);
        this.ah = context;
        SSWebView sSWebView = new SSWebView(context);
        this.xr = sSWebView;
        sSWebView.setMaterialMeta(com.bytedance.sdk.openadsdk.core.jw.pc.ms(this.d));
        addView(this.xr);
    }

    public void setUGenContext(hi hiVar) {
        this.c = hiVar;
    }

    public void setMeta(lm lmVar) {
        this.d = lmVar;
        SSWebView sSWebView = this.xr;
        if (sSWebView != null) {
            sSWebView.setMaterialMeta(com.bytedance.sdk.openadsdk.core.jw.pc.ms(lmVar));
        }
    }

    public void ms() {
        Map<String, Object> mapXr;
        if (this.xr == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.d);
        this.ka = new pc(this.ah);
        hi hiVar = this.c;
        if (hiVar != null && (mapXr = hiVar.xr()) != null && mapXr.containsKey("key_reward_page")) {
            Object obj = mapXr.get("key_reward_page");
            if (obj instanceof Map) {
                this.ka.ms((Map<String, Object>) obj);
            }
        }
        this.ka.xr(this.xr).ms(this.d).ah(arrayList).xr(this.d.df()).ah(this.d.lx()).ah(7).ms(f.xr(this.d)).d(f.ao(this.d)).ms(this.xr).ms(true).xr(ub.ms(this.d)).ms((d) this);
        this.xr.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.ms.d(this.ah, this.ka, this.d.df(), new com.bytedance.sdk.openadsdk.core.zb.d(this.d, this.xr), null));
        this.xr.setWebChromeClient(new ah(this.ka));
    }

    public void xr(final JSONObject jSONObject) {
        ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.webview.PageWebView.1
            @Override // java.lang.Runnable
            public void run() {
                PageWebView.this.ah(jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(JSONObject jSONObject) {
        WeakReference<DownloadListener> weakReference;
        xr.ms(this.ah).ms(false).xr(false).ms(this.xr);
        SSWebView sSWebView = this.xr;
        if (sSWebView != null) {
            t.ms(sSWebView, g.xr, lm.d(this.d));
        }
        this.xr.setMixedContentMode(0);
        if (jSONObject == null || (weakReference = f3569ms.get(jSONObject.hashCode())) == null || weakReference.get() == null) {
            return;
        }
        this.xr.setDownloadListener(weakReference.get());
    }

    public void ms(String str) {
        SSWebView sSWebView = this.xr;
        if (sSWebView != null) {
            sSWebView.loadUrl(str);
        }
    }
}
