package com.byazt.ki;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.anythink.core.common.res.d;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.ew.fs;
import com.byazt.ew.x;
import com.byazt.gct.cd;
import com.byazt.gct.cx;
import com.byazt.gct.pk;
import com.byazt.oh.l;
import com.byazt.pt.BaseLandingPageActivity;
import com.byazt.tk.k;
import com.byazt.tk.rv;
import com.byazt.tk.t;
import com.byazt.uv.w;
import com.byazt.uz.RewardLpBottomView;
import com.byazt.vf.wo;
import com.byazt.xk.PlayableEndcardFrameLayout;
import com.byazt.yyw.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 715, 8})
public class s extends com.byazt.ki.n implements wo.n, com.byazt.hm.s.qg {
    public static final x.n wo = new x.n() { // from class: com.byazt.ki.s.2
        @Override // com.byazt.ew.x.n
        public void n(String str, String str2, Throwable th) {
            k.n(str, str2, th);
        }
    };
    public boolean ae;
    public fs an;
    public com.byazt.ys.qg b;
    public long bb;
    public RewardLpBottomView df;
    public com.byazt.cs.n dg;
    public DownloadListener dh;
    public com.byazt.re.qg.InterfaceC0323qg f;
    public PlayableEndcardFrameLayout fi;
    public final AtomicBoolean h;
    public final AtomicBoolean hu;
    public com.byazt.hm.q j;
    public FrameLayout lh;
    public final AtomicBoolean ln;
    public final com.byazt.bsb.n oj;
    public com.byazt.re.qg.n pk;
    public final com.byazt.uv.s rf;
    public String ri;
    public final w sh;
    public final AtomicBoolean t;
    public final n u;
    public final t ur;
    public com.byazt.fj.s v;
    public final com.byazt.uv.qg y;

    public interface n {
        void n(WebView webView, String str);

        void n(WebView webView, String str, Bitmap bitmap);
    }

    @Override // com.byazt.ki.n
    public String m() {
        return "playable";
    }

    public s(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar, String str, int i, int i2, boolean z, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        super(tTBaseVideoActivity, pkVar, str, i, i2, z);
        this.hu = new AtomicBoolean(false);
        this.h = new AtomicBoolean(false);
        this.t = new AtomicBoolean(false);
        this.ln = new AtomicBoolean(false);
        this.ur = new t(Looper.getMainLooper(), this);
        this.bb = 0L;
        this.u = new n() { // from class: com.byazt.ki.s.1
            @Override // com.byazt.ki.s.n
            public void n(WebView webView, String str2) {
                if (s.this.n.nf() instanceof com.byazt.has.fs) {
                    return;
                }
                s.this.ur.removeMessages(101);
                if (s.this.hu.getAndSet(true)) {
                    return;
                }
                if (com.byazt.qq.qg.s(s.this.qg) || s.this.ae) {
                    if (!s.this.ou()) {
                        if (s.this.pk != null) {
                            s.this.pk.n();
                            return;
                        }
                        return;
                    }
                    s.this.n(0);
                }
            }

            @Override // com.byazt.ki.s.n
            public void n(WebView webView, String str2, Bitmap bitmap) {
                if (com.byazt.qq.qg.s(s.this.qg)) {
                    if (s.this.qg.ts() == 1 || cd.oa(s.this.qg)) {
                        s.this.s(1);
                        s.this.ur.sendEmptyMessageDelayed(101, 10000L);
                    }
                    if (s.this.h.getAndSet(true)) {
                        return;
                    }
                    s.this.bb = System.currentTimeMillis();
                    s.this.f.n();
                }
            }
        };
        this.sh = new w() { // from class: com.byazt.ki.s.3
            @Override // com.byazt.uv.w
            public void n(int i3) {
                s.this.fs.rv(true);
                if (cd.oa(s.this.qg)) {
                    s.this.f.qg();
                }
                s.this.n.s(i3);
            }

            @Override // com.byazt.uv.w
            public void n() {
                if (cx.cp(s.this.qg)) {
                    s.this.n.q(3);
                }
            }

            @Override // com.byazt.uv.w
            public void qg() {
                if (!cd.n(s.this.qg) || cd.oa(s.this.qg)) {
                    return;
                }
                s.this.n.n(1);
            }
        };
        this.y = new com.byazt.uv.qg() { // from class: com.byazt.ki.s.4
            @Override // com.byazt.uv.qg
            public void n(boolean z2, int i3, String str2) {
                if (z2) {
                    s.this.cy = true;
                }
            }
        };
        this.rf = new com.byazt.uv.s() { // from class: com.byazt.ki.s.5
            @Override // com.byazt.uv.s
            public void n() {
                s.this.ur.removeMessages(101);
            }
        };
        this.x = abstractEndCardFrameLayout.getPlayableWebView();
        this.lh = (FrameLayout) this.n.findViewById(2114387919);
        this.fi = (PlayableEndcardFrameLayout) this.n.findViewById(2114387675);
        this.df = (RewardLpBottomView) this.n.findViewById(2114387824);
        this.oj = new com.byazt.bsb.n(this.s, tTBaseVideoActivity, pkVar, com.byazt.qq.qg.s(this.qg) ? 2 : 1, tTBaseVideoActivity.nf().f(), abstractEndCardFrameLayout.getVideoArea());
        n();
    }

    public void n(com.byazt.cs.n nVar) {
        this.dg = nVar;
    }

    @Override // com.byazt.ki.n
    public void n(boolean z, Map<String, Object> map, View view) {
        if (com.byazt.vgx.w.t(this.qg) && this.lh != null) {
            n(map, view);
        } else {
            qg(z, map, view);
        }
    }

    private void n(final Map<String, Object> map, final View view) {
        com.byazt.hm.q qVar = new com.byazt.hm.q(this.qg);
        this.j = qVar;
        qVar.n(true);
        this.j.n();
        this.lh.setVisibility(0);
        com.byazt.fj.s sVar = new com.byazt.fj.s(this.n, this.lh, this.j, this.qg, this.s, com.byazt.vgx.w.q(this.s), this.dg);
        this.v = sVar;
        sVar.n();
        this.v.n(new com.byazt.au.n() { // from class: com.byazt.ki.s.6
            @Override // com.byazt.au.n
            public void n(View view2) {
                s.this.an();
            }

            @Override // com.byazt.au.n
            public void n(int i) {
                s.this.v = null;
                rv.qg().post(new Runnable() { // from class: com.byazt.ki.s.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (s.this.lh != null) {
                            s.this.lh.setVisibility(8);
                        }
                        s.this.k = false;
                        s.this.qg(s.this.q, map, view);
                        s.this.qg(s.this.dh, s.this.b);
                        s.this.dh = null;
                        s.this.t();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an() {
        this.cy = true;
        this.t.set(true);
        this.ur.sendMessage(qg(4));
        if (this.n != null) {
            this.n.oa(8);
        }
        com.byazt.re.qg.InterfaceC0323qg interfaceC0323qg = this.f;
        if (interfaceC0323qg != null) {
            interfaceC0323qg.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(boolean z, Map<String, Object> map, View view) {
        if (this.x == null) {
            return;
        }
        this.d = new com.byazt.hm.s(this.qg, this.x).qg(true);
        this.d.n(this);
        this.d.n(true);
        this.d.n(z ? "reward_endcard" : "fullscreen_endcard");
        this.fs = new com.byazt.gcl.s(this.n);
        this.fs.qg(this.x).n(this.qg).qg(this.qg.q()).q(this.qg.F_()).s(z ? 7 : 5).n(this.wm).l(com.byazt.vgx.w.wm(this.qg)).n(this.x).qg(l.n(this.qg)).n(this.s).n(map).n(this.m).n(view).s(this.n.n()).n(this.sh);
        if (!com.byazt.qq.qg.s(this.qg)) {
            this.fs.fs(true);
        }
        this.fs.n(this.y);
        this.fs.n(this.rf);
        ae();
        f();
        j();
    }

    private void ae() {
        RewardLpBottomView rewardLpBottomView;
        if (!com.byazt.qq.qg.x(this.qg)) {
            this.df = null;
            return;
        }
        if (cd.q(this.qg)) {
            this.df = null;
            return;
        }
        if (!cd.x(this.qg)) {
            this.df = null;
        } else {
            if (this.fi == null || (rewardLpBottomView = this.df) == null) {
                return;
            }
            rewardLpBottomView.n(this.qg, this.s);
            this.fi.n(new PlayableEndcardFrameLayout.n() { // from class: com.byazt.ki.s.7
                @Override // com.byazt.xk.PlayableEndcardFrameLayout.n
                public void n() {
                    if (s.this.df != null) {
                        s.this.df.qg();
                    }
                    if (s.this.n != null) {
                        s.this.n.tj(1);
                    }
                }
            });
        }
    }

    private void f() {
        this.tj = com.byazt.qq.qg.n(this.qg);
        float fSl = this.qg.sl();
        if (TextUtils.isEmpty(this.tj)) {
            return;
        }
        this.tj = this.tj.trim();
        Uri.Builder builderBuildUpon = Uri.parse(this.tj).buildUpon();
        if (this.um == 1) {
            builderBuildUpon.appendQueryParameter("orientation", "portrait");
        }
        this.tj = builderBuildUpon.appendQueryParameter("height", String.valueOf(this.py)).appendQueryParameter("width", String.valueOf(this.a)).appendQueryParameter("aspect_ratio", String.valueOf(fSl)).toString();
    }

    @Override // com.byazt.ki.n
    public void n(DownloadListener downloadListener, com.byazt.ys.qg qgVar) {
        this.dh = downloadListener;
        this.b = qgVar;
        qg(downloadListener, qgVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(DownloadListener downloadListener, com.byazt.ys.qg qgVar) {
        if (this.x == null) {
            return;
        }
        this.b = null;
        this.cp = new com.byazt.dho.s(this.n, this.fs, this.qg.q(), this.d) { // from class: com.byazt.ki.s.8
            public final long rv = System.currentTimeMillis();

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                return super.shouldInterceptRequest(webView, str);
            }

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String string = webResourceRequest.getUrl().toString();
                    if (s.this.qg == null) {
                        return super.shouldInterceptRequest(webView, string);
                    }
                    if (TextUtils.isEmpty(s.this.qg.s())) {
                        return super.shouldInterceptRequest(webView, string);
                    }
                    s.this.l++;
                    return super.shouldInterceptRequest(webView, string);
                } catch (Throwable th) {
                    k.n("PlayableEndCard", "shouldInterceptRequest error1", th);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                s.this.hd.set(false);
                s.this.cd = this.fs;
                s.this.oa = i;
                s.this.sz = str;
                if (s.this.an != null) {
                    s.this.an.n(i, str, str2);
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    s.this.hd.set(false);
                    s.this.cd = this.fs;
                }
                s.this.oa = webResourceError.getErrorCode();
                s.this.sz = String.valueOf(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (s.this.an != null) {
                    try {
                        s.this.an.n(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                    } catch (Throwable unused) {
                    }
                }
                if (s.this.tj.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        s.this.hd.set(false);
                        s.this.cd = this.fs;
                    }
                    if (webResourceResponse != null) {
                        s.this.oa = webResourceResponse.getStatusCode();
                        s.this.sz = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (s.this.an != null && str != null && !str.contains(d.a)) {
                    s.this.an.x(str);
                }
                super.onPageFinished(webView, str);
                s.this.u.n(webView, str);
                if (s.this.df != null) {
                    s.this.df.n();
                }
                if (webView == null || !cd.n(s.this.qg)) {
                    return;
                }
                webView.evaluateJavascript(BaseLandingPageActivity.n(this.rv), null);
            }

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                s.this.t.set(true);
                s.this.u.n(webView, str, bitmap);
            }
        };
        this.x.setWebViewClient(this.cp);
        this.x.setWebChromeClient(new com.byazt.dho.qg(this.fs, this.d));
        n(this.x);
        this.x.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.x.setDisplayZoomControls(false);
        this.x.setDownloadListener(downloadListener);
        n(qgVar);
    }

    private void n(com.byazt.ys.qg qgVar) {
        RewardLpBottomView rewardLpBottomView;
        if (!com.byazt.qq.qg.x(this.qg) || (rewardLpBottomView = this.df) == null) {
            return;
        }
        rewardLpBottomView.setDownLoadClickListener(qgVar);
    }

    public void t() {
        if (this.k || this.x == null || this.x.getWebView() == null) {
            return;
        }
        this.x.loadUrl(this.tj);
        this.k = true;
        fs fsVar = this.an;
        if (fsVar != null) {
            fsVar.w(this.tj);
        }
    }

    @Override // com.byazt.ki.n
    public void oa() {
        super.oa();
        fs fsVar = this.an;
        if (fsVar != null) {
            fsVar.qg(false);
        }
        com.byazt.fj.s sVar = this.v;
        if (sVar != null) {
            sVar.qg();
        }
    }

    @Override // com.byazt.ki.n
    public void d() {
        super.d();
        if (this.an != null && com.byazt.okk.s.q(this.x)) {
            this.an.qg(true);
        }
        com.byazt.fj.s sVar = this.v;
        if (sVar != null) {
            sVar.s();
        }
        com.byazt.hm.q qVar = this.j;
        if (qVar != null) {
            qVar.s();
        }
    }

    @Override // com.byazt.ki.n
    public void sz() {
        super.sz();
        com.byazt.hm.q qVar = this.j;
        if (qVar != null) {
            qVar.n(0);
        }
    }

    @Override // com.byazt.ki.n
    public void k() {
        super.k();
        fs fsVar = this.an;
        if (fsVar != null) {
            fsVar.j();
        }
        if (this.d != null) {
            this.d.n((com.byazt.hm.s.qg) null);
        }
        this.oj.q();
        com.byazt.fj.s sVar = this.v;
        if (sVar != null) {
            sVar.q();
        }
        com.byazt.hm.q qVar = this.j;
        if (qVar != null) {
            qVar.q();
        }
        this.dh = null;
    }

    @Override // com.byazt.ki.n
    public void n(int i) {
        super.n(i);
        oj();
    }

    @Override // com.byazt.ki.n
    public void hu() {
        super.hu();
        this.oj.s();
        com.byazt.fj.s sVar = this.v;
        if (sVar != null) {
            sVar.s();
        }
    }

    @Override // com.byazt.ki.n
    public void q(boolean z) {
        super.q(z);
        if (!z) {
            this.oj.qg();
        }
        com.byazt.fj.s sVar = this.v;
        if (sVar != null) {
            sVar.qg();
        }
    }

    public void ur() {
        n(true);
        fs fsVar = this.an;
        if (fsVar != null) {
            fsVar.qg(true);
        }
        s(true);
        n(false, true);
        if (this.cp != null) {
            this.cp.qg(false);
        }
    }

    public void l(boolean z) {
        if (this.fs == null || this.n.isFinishing()) {
            return;
        }
        try {
            this.fs.x(z);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isReward", z);
            this.fs.qg("isVerifyReward", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void qg(int i, int i2) {
        if (this.fs == null || this.n.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("skip_remain_time", i);
            if (this.q) {
                jSONObject.put("reward_remain_time", i2);
            }
            this.fs.qg("reward_button_status", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void n(com.byazt.re.qg.InterfaceC0323qg interfaceC0323qg) {
        this.f = interfaceC0323qg;
    }

    public long bb() {
        return System.currentTimeMillis() - this.bb;
    }

    public boolean ln() {
        if (this.fs != null) {
            return this.fs.cp();
        }
        return true;
    }

    public com.byazt.gcl.s lh() {
        return this.fs;
    }

    public boolean v() {
        return !this.t.get();
    }

    @Override // com.byazt.ki.n
    public void qg(boolean z) {
        fs fsVar = this.an;
        if (fsVar != null) {
            fsVar.n(z);
        }
        this.oj.n(z);
    }

    @Override // com.byazt.ki.n
    public void w() {
        if (this.x != null && this.x.getVisibility() == 0) {
            this.f.s().n(true);
        }
        super.w();
        this.oj.n();
        fs fsVar = this.an;
        if (fsVar != null) {
            fsVar.qg(false);
        }
        n(true, false);
    }

    public void j() {
        if (this.x == null || this.an != null) {
            return;
        }
        if (com.byazt.vyf.s.cy().pk()) {
            x.n(wo);
        }
        com.byazt.pb.n nVar = new com.byazt.pb.n();
        q qVar = new q(this.sh);
        com.byazt.pb.s sVar = new com.byazt.pb.s(this.fs);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.qg.q());
            jSONObject.put("log_extra", this.qg.F_());
        } catch (Throwable unused) {
        }
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        fs fsVarN = nVar.n(com.byazt.nf.rv.getContext(), this.x, sVar, qVar, hashSet, fs.n.LAND_PAGE).l(this.tj).q(com.byazt.ges.qg.fs()).n(com.byazt.ges.qg.n()).l(jSONObject).n("sdkEdition", com.byazt.ges.qg.s()).qg(com.byazt.ges.qg.w()).s(com.byazt.ges.qg.l()).n(10L).qg(10L).s(false).n(false);
        this.an = fsVarN;
        Set<String> setTj = fsVarN.tj();
        if (this.fs == null || setTj == null || setTj.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.an);
        Iterator<String> it = setTj.iterator();
        while (it.hasNext()) {
            this.fs.w().n(it.next(), (com.byazt.cf.l<?, ?>) new com.byazt.cf.l<JSONObject, JSONObject>() { // from class: com.byazt.ki.s.9
                @Override // com.byazt.cf.l
                public JSONObject n(JSONObject jSONObject2, com.byazt.cf.w wVar) throws Exception {
                    try {
                        fs fsVar = (fs) weakReference.get();
                        if (fsVar == null) {
                            return null;
                        }
                        return fsVar.q(n(), jSONObject2);
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            });
        }
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        int i = message.what;
        if (i == 101) {
            df();
            return;
        }
        if (i != 102) {
            return;
        }
        this.ur.removeMessages(102);
        this.f.s().n(true);
        this.n.yw();
        if (message.arg1 == 2) {
            fi();
        } else if (message.arg1 == 0 || message.arg1 == 1) {
            ur();
        }
    }

    private void fi() {
        com.byazt.re.qg.n nVar = this.pk;
        if (nVar != null) {
            nVar.n();
            s(2);
        }
    }

    @Override // com.byazt.hm.s.qg
    public void n(String str) {
        if (TextUtils.isEmpty(this.ri)) {
            this.ri = str;
        }
        if (TextUtils.equals(this.ri, str)) {
            return;
        }
        this.ri = str;
        this.n.tj(1);
    }

    private void df() {
        this.ur.sendMessage(qg(3));
        fi();
        this.n.s(0);
    }

    public void w(boolean z) {
        if (this.fs == null || this.n.isFinishing()) {
            return;
        }
        this.ae = z;
    }

    private Message qg(int i) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 102;
        messageObtain.arg1 = i;
        return messageObtain;
    }

    public void n(com.byazt.re.qg.n nVar) {
        this.pk = nVar;
    }

    @Override // com.byazt.ki.n
    public void n(Map<String, Object> map) {
        if (this.rv != null) {
            this.rv.sz();
        }
        if (map == null || !com.byazt.qq.qg.s(this.qg)) {
            return;
        }
        map.put(MediationConstant.EXTRA_DURATION, Long.valueOf(bb()));
    }

    private void oj() {
        if (this.n.b() == null) {
            return;
        }
        long jCy = !this.n.b().n() ? this.n.b().cy() : 0L;
        boolean zOa = this.n.b().oa();
        if (!(this.n.nf() instanceof com.byazt.has.fs)) {
            fs fsVar = this.an;
            zOa = fsVar != null && fsVar.x();
        }
        this.oj.n(jCy, zOa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
        } catch (Exception unused) {
        }
        com.byazt.eji.s.n().l(jSONObject);
    }
}
