package com.byazt.qx;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.hg.ie;
import com.byazt.hg.of;
import com.byazt.sd.nl;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 62})
public class fw extends com.byazt.lz.x {
    public final com.byazt.eq.zo aj;
    public com.byazt.mq.m k;
    public ArrayList<Integer> pr;
    public of vk;
    public boolean w;

    public fw(Context context, nl nlVar, of ofVar, com.byazt.pj.hn hnVar, boolean z, com.byazt.eq.zo zoVar, com.byazt.mq.m mVar) {
        super(context, nlVar, ofVar.x(), hnVar);
        this.pr = new ArrayList<>();
        this.vk = ofVar;
        this.w = z;
        this.aj = zoVar;
        this.k = mVar;
    }

    @Override // com.byazt.lz.x, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th) {
            com.byazt.ca.ho.pr("ExpressClient", "shouldInterceptRequest error1", th);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    public int pr() {
        for (Integer num : this.pr) {
            if (num.intValue() == 3 || num.intValue() == 2 || num.intValue() == -1) {
                return num.intValue();
            }
        }
        return TextUtils.isEmpty(x()) ? -1 : 1;
    }

    @Override // com.byazt.lz.x, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            com.byazt.eq.zo zoVar = this.aj;
            if (zoVar != null) {
                zoVar.zo(str);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.byazt.ce.pr prVarPr = com.byazt.hc.pr.pr(webView, this.vk, str, new com.byazt.hc.pr.InterfaceC0083pr() { // from class: com.byazt.qx.fw.1
                @Override // com.byazt.hc.pr.InterfaceC0083pr
                public com.byazt.ce.pr pr(String str2, com.byazt.js.vk.pr prVar, String str3) {
                    return com.byazt.ce.hw.pr(str2, prVar, str3, fw.this.x());
                }

                @Override // com.byazt.hc.pr.InterfaceC0083pr
                public boolean pr() {
                    return true;
                }
            });
            pr(jCurrentTimeMillis, System.currentTimeMillis(), str, (prVarPr == null || prVarPr.pr() == null) ? 2 : 1);
            if (prVarPr != null && prVarPr.getType() != 5) {
                this.pr.add(Integer.valueOf(prVarPr.getType()));
            }
            if (prVarPr != null && prVarPr.pr() != null) {
                com.byazt.eq.zo zoVar2 = this.aj;
                if (zoVar2 != null) {
                    zoVar2.aj(str);
                }
                return prVarPr.pr();
            }
        } catch (Throwable th) {
            com.byazt.ca.ho.pr("ExpressClient", "shouldInterceptRequest error2", th);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String x() {
        if (ie.fw(this.vk) != null) {
            return ie.fw(this.vk).w();
        }
        if (ie.zo(this.vk) != null) {
            return "v3";
        }
        return null;
    }

    @Override // com.byazt.lz.x, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.uc = false;
        super.onPageFinished(webView, str);
    }

    @Override // com.byazt.lz.x, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.fw = false;
        super.onPageStarted(webView, str, bitmap);
        com.byazt.mq.m mVar = this.k;
        if (mVar != null && mVar.z()) {
            com.byazt.ca.m.pr(webView, "javascript:window.SDK_INJECT_DATA=" + this.k.c());
        }
    }

    private void pr(long j, long j2, String str, int i) {
        if (this.c == null || this.c.hn() == null) {
            return;
        }
        com.byazt.js.vk.pr prVarPr = com.byazt.js.vk.pr(str);
        if (prVarPr == com.byazt.js.vk.pr.HTML) {
            this.c.hn().pr(str, j, j2, i);
        } else if (prVarPr == com.byazt.js.vk.pr.JS) {
            this.c.hn().hw(str, j, j2, i);
        }
    }
}
