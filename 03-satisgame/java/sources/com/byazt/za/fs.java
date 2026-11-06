package com.byazt.za;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 101})
public class fs extends com.byazt.dho.s {
    public boolean cp;
    public com.byazt.udb.oa d;
    public ArrayList<Integer> n;
    public final com.byazt.ew.fs rv;
    public pk tj;

    public fs(Context context, com.byazt.gcl.s sVar, pk pkVar, com.byazt.hm.s sVar2, boolean z, com.byazt.ew.fs fsVar, com.byazt.udb.oa oaVar) {
        super(context, sVar, pkVar.q(), sVar2);
        this.n = new ArrayList<>();
        this.tj = pkVar;
        this.cp = z;
        this.rv = fsVar;
        this.d = oaVar;
    }

    @Override // com.byazt.dho.s, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th) {
            com.byazt.tk.k.n("ExpressClient", "shouldInterceptRequest error1", th);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    public int n() {
        for (Integer num : this.n) {
            if (num.intValue() == 3 || num.intValue() == 2 || num.intValue() == -1) {
                return num.intValue();
            }
        }
        return TextUtils.isEmpty(q()) ? -1 : 1;
    }

    @Override // com.byazt.dho.s, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            com.byazt.ew.fs fsVar = this.rv;
            if (fsVar != null) {
                fsVar.fs(str);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.byazt.mzw.n nVarN = com.byazt.lu.n.n(webView, this.tj, str, new com.byazt.lu.n.InterfaceC0242n() { // from class: com.byazt.za.fs.1
                @Override // com.byazt.lu.n.InterfaceC0242n
                public boolean n() {
                    return true;
                }

                @Override // com.byazt.lu.n.InterfaceC0242n
                public com.byazt.mzw.n n(String str2, com.byazt.cq.tj.n nVar, String str3) {
                    return com.byazt.mzw.qg.n(str2, nVar, str3, fs.this.q());
                }
            });
            n(jCurrentTimeMillis, System.currentTimeMillis(), str, (nVarN == null || nVarN.n() == null) ? 2 : 1);
            if (nVarN != null && nVarN.getType() != 5) {
                this.n.add(Integer.valueOf(nVarN.getType()));
            }
            if (nVarN != null && nVarN.n() != null) {
                com.byazt.ew.fs fsVar2 = this.rv;
                if (fsVar2 != null) {
                    fsVar2.rv(str);
                }
                return nVarN.n();
            }
        } catch (Throwable th) {
            com.byazt.tk.k.n("ExpressClient", "shouldInterceptRequest error2", th);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String q() {
        if (nf.x(this.tj) != null) {
            return nf.x(this.tj).cp();
        }
        if (nf.fs(this.tj) != null) {
            return "v3";
        }
        return null;
    }

    @Override // com.byazt.dho.s, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.w = false;
        super.onPageFinished(webView, str);
    }

    @Override // com.byazt.dho.s, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.x = false;
        super.onPageStarted(webView, str, bitmap);
        com.byazt.udb.oa oaVar = this.d;
        if (oaVar == null || !oaVar.hu()) {
            return;
        }
        com.byazt.tk.oa.n(webView, "javascript:window.SDK_INJECT_DATA=" + this.d.l());
    }

    private void n(long j, long j2, String str, int i) {
        if (this.l == null || this.l.s() == null) {
            return;
        }
        com.byazt.cq.tj.n nVarN = com.byazt.cq.tj.n(str);
        if (nVarN == com.byazt.cq.tj.n.HTML) {
            this.l.s().n(str, j, j2, i);
        } else if (nVarN == com.byazt.cq.tj.n.JS) {
            this.l.s().qg(str, j, j2, i);
        }
    }
}
