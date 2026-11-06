package com.byazt.yr;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.byazt.ap.c;
import com.byazt.ar.RewardLpBottomView;
import com.byazt.ca.aj;
import com.byazt.ca.ho;
import com.byazt.ca.iu;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.ee.uc;
import com.byazt.eq.fw;
import com.byazt.eq.zo;
import com.byazt.hg.jn;
import com.byazt.hg.lb;
import com.byazt.hg.of;
import com.byazt.pg.PlayableEndcardFrameLayout;
import com.byazt.rg.BaseLandingPageActivity;
import com.byazt.sd.a;
import com.byazt.sd.nl;
import com.byazt.vkw.qi;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.wt.ny;
import com.byazt.xz.AbstractEndCardFrameLayout;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_BUFLEN, 20})
public class hn extends com.byazt.yr.pr implements qi.pr, com.byazt.pj.hn.hw {
    public static final fw.pr i = new fw.pr() { // from class: com.byazt.yr.hn.2
        @Override // com.byazt.eq.fw.pr
        public void pr(String str, String str2, Throwable th) {
            ho.pr(str, str2, th);
        }
    };
    public final AtomicBoolean b;
    public zo e;
    public PlayableEndcardFrameLayout er;
    public String f;
    public long gz;
    public final com.byazt.ap.hw hs;
    public DownloadListener ie;
    public com.byazt.ax.hw.pr ii;
    public final AtomicBoolean iu;
    public com.byazt.ax.hw.InterfaceC0020hw ls;
    public com.byazt.pj.x n;
    public final AtomicBoolean nl;
    public final com.byazt.ap.hn nw;
    public com.byazt.az.hw o;
    public final pr of;
    public final com.byazt.sb.pr qi;
    public com.byazt.mm.pr qn;
    public final c r;
    public boolean s;
    public RewardLpBottomView v;
    public final iu ve;
    public com.byazt.le.hn ww;
    public FrameLayout y;
    public final AtomicBoolean z;

    public interface pr {
        void pr(WebView webView, String str);

        void pr(WebView webView, String str, Bitmap bitmap);
    }

    public hn(TTBaseVideoActivity tTBaseVideoActivity, of ofVar, String str, int i2, int i3, boolean z, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        super(tTBaseVideoActivity, ofVar, str, i2, i3, z);
        this.z = new AtomicBoolean(false);
        this.b = new AtomicBoolean(false);
        this.iu = new AtomicBoolean(false);
        this.nl = new AtomicBoolean(false);
        this.ve = new iu(Looper.getMainLooper(), this);
        this.gz = 0L;
        this.of = new pr() { // from class: com.byazt.yr.hn.1
            @Override // com.byazt.yr.hn.pr
            public void pr(WebView webView, String str2) {
                if (hn.this.pr.bm() instanceof com.byazt.lu.zo) {
                    return;
                }
                hn.this.ve.removeMessages(101);
                if (hn.this.z.getAndSet(true)) {
                    return;
                }
                if (ny.hn(hn.this.hw) || hn.this.s) {
                    if (!hn.this.ny()) {
                        if (hn.this.ii != null) {
                            hn.this.ii.pr();
                            return;
                        }
                        return;
                    }
                    hn.this.pr(0);
                }
            }

            @Override // com.byazt.yr.hn.pr
            public void pr(WebView webView, String str2, Bitmap bitmap) {
                if (!ny.hn(hn.this.hw)) {
                    return;
                }
                if (hn.this.hw.ej() == 1 || lb.m(hn.this.hw)) {
                    hn.this.hn(1);
                    hn.this.ve.sendEmptyMessageDelayed(101, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                }
                if (!hn.this.b.getAndSet(true)) {
                    hn.this.gz = System.currentTimeMillis();
                    hn.this.ls.pr();
                }
            }
        };
        this.r = new c() { // from class: com.byazt.yr.hn.3
            @Override // com.byazt.ap.c
            public void pr(int i4) {
                hn.this.zo.aj(true);
                if (lb.m(hn.this.hw)) {
                    hn.this.ls.hw();
                }
                hn.this.pr.hn(i4);
            }

            @Override // com.byazt.ap.c
            public void pr() {
                if (jn.w(hn.this.hw)) {
                    hn.this.pr.x(3);
                }
            }

            @Override // com.byazt.ap.c
            public void hw() {
                if (lb.pr(hn.this.hw) && !lb.m(hn.this.hw)) {
                    hn.this.pr.pr(1);
                }
            }
        };
        this.hs = new com.byazt.ap.hw() { // from class: com.byazt.yr.hn.4
            @Override // com.byazt.ap.hw
            public void pr(boolean z2, int i4, String str2) {
                if (z2) {
                    hn.this.nt = true;
                }
            }
        };
        this.nw = new com.byazt.ap.hn() { // from class: com.byazt.yr.hn.5
            @Override // com.byazt.ap.hn
            public void pr() {
                hn.this.ve.removeMessages(101);
            }
        };
        this.fw = abstractEndCardFrameLayout.getPlayableWebView();
        this.y = (FrameLayout) this.pr.findViewById(2114387919);
        this.er = (PlayableEndcardFrameLayout) this.pr.findViewById(2114387675);
        this.v = (RewardLpBottomView) this.pr.findViewById(2114387824);
        this.qi = new com.byazt.sb.pr(this.hn, tTBaseVideoActivity, ofVar, ny.hn(this.hw) ? 2 : 1, tTBaseVideoActivity.bm().s(), abstractEndCardFrameLayout.getVideoArea());
        pr();
    }

    public void pr(com.byazt.mm.pr prVar) {
        this.qn = prVar;
    }

    @Override // com.byazt.yr.pr
    public void pr(boolean z, Map<String, Object> map, View view) {
        if (ls.rc(this.hw) && this.y != null) {
            pr(map, view);
        } else {
            hw(z, map, view);
        }
    }

    private void pr(final Map<String, Object> map, final View view) {
        com.byazt.pj.x xVar = new com.byazt.pj.x(this.hw);
        this.n = xVar;
        xVar.pr(true);
        this.n.pr();
        this.y.setVisibility(0);
        com.byazt.le.hn hnVar = new com.byazt.le.hn(this.pr, this.y, this.n, this.hw, this.hn, ls.x(this.hn), this.qn);
        this.ww = hnVar;
        hnVar.pr();
        this.ww.pr(new com.byazt.ql.pr() { // from class: com.byazt.yr.hn.6
            @Override // com.byazt.ql.pr
            public void pr(View view2) {
                hn.this.e();
            }

            @Override // com.byazt.ql.pr
            public void pr(int i2) {
                hn.this.ww = null;
                aj.hw().post(new Runnable() { // from class: com.byazt.yr.hn.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (hn.this.y != null) {
                            hn.this.y.setVisibility(8);
                        }
                        hn.this.ho = false;
                        hn.this.hw(hn.this.x, map, view);
                        hn.this.hw(hn.this.ie, hn.this.o);
                        hn.this.ie = null;
                        hn.this.iu();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.nt = true;
        this.iu.set(true);
        this.ve.sendMessage(hw(4));
        if (this.pr != null) {
            this.pr.m(8);
        }
        com.byazt.ax.hw.InterfaceC0020hw interfaceC0020hw = this.ls;
        if (interfaceC0020hw != null) {
            interfaceC0020hw.pr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(boolean z, Map<String, Object> map, View view) {
        if (this.fw == null) {
            return;
        }
        this.k = new com.byazt.pj.hn(this.hw, this.fw).hw(true);
        this.k.pr(this);
        this.k.pr(true);
        this.k.pr(z ? "reward_endcard" : "fullscreen_endcard");
        this.zo = new nl(this.pr);
        this.zo.hw(this.fw).pr(this.hw).hw(this.hw.x()).x(this.hw.B_()).hn(z ? 7 : 5).pr(this.fo).c(ls.a(this.hw)).pr(this.fw).hw(com.byazt.ri.c.pr(this.hw)).pr(this.hn).pr(map).pr(this.rc).pr(view).hn(this.pr.pr()).pr(this.r);
        if (!ny.hn(this.hw)) {
            this.zo.zo(true);
        }
        this.zo.pr(this.hs);
        this.zo.pr(this.nw);
        s();
        ls();
        n();
    }

    private void s() {
        RewardLpBottomView rewardLpBottomView;
        if (!ny.fw(this.hw)) {
            this.v = null;
            return;
        }
        if (lb.x(this.hw)) {
            this.v = null;
            return;
        }
        if (!lb.fw(this.hw)) {
            this.v = null;
        } else if (this.er != null && (rewardLpBottomView = this.v) != null) {
            rewardLpBottomView.pr(this.hw, this.hn);
            this.er.pr(new PlayableEndcardFrameLayout.pr() { // from class: com.byazt.yr.hn.7
                @Override // com.byazt.pg.PlayableEndcardFrameLayout.pr
                public void pr() {
                    if (hn.this.v != null) {
                        hn.this.v.hw();
                    }
                    if (hn.this.pr != null) {
                        hn.this.pr.vk(1);
                    }
                }
            });
        }
    }

    private void ls() {
        this.vk = ny.pr(this.hw);
        float fOq = this.hw.oq();
        if (TextUtils.isEmpty(this.vk)) {
            return;
        }
        this.vk = this.vk.trim();
        Uri.Builder builderBuildUpon = Uri.parse(this.vk).buildUpon();
        if (this.qa == 1) {
            builderBuildUpon.appendQueryParameter("orientation", "portrait");
        }
        this.vk = builderBuildUpon.appendQueryParameter("height", String.valueOf(this.cz)).appendQueryParameter("width", String.valueOf(this.a)).appendQueryParameter("aspect_ratio", String.valueOf(fOq)).toString();
    }

    @Override // com.byazt.yr.pr
    public void pr(DownloadListener downloadListener, com.byazt.az.hw hwVar) {
        this.ie = downloadListener;
        this.o = hwVar;
        hw(downloadListener, hwVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(DownloadListener downloadListener, com.byazt.az.hw hwVar) {
        if (this.fw == null) {
            return;
        }
        this.o = null;
        this.w = new com.byazt.lz.x(this.pr, this.zo, this.hw.x(), this.k) { // from class: com.byazt.yr.hn.8
            public final long aj = System.currentTimeMillis();

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                return super.shouldInterceptRequest(webView, str);
            }

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String string = webResourceRequest.getUrl().toString();
                    if (hn.this.hw == null) {
                        return super.shouldInterceptRequest(webView, string);
                    }
                    if (TextUtils.isEmpty(hn.this.hw.hn())) {
                        return super.shouldInterceptRequest(webView, string);
                    }
                    hn.this.c++;
                    return super.shouldInterceptRequest(webView, string);
                } catch (Throwable th) {
                    ho.pr("PlayableEndCard", "shouldInterceptRequest error1", th);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                hn.this.yb.set(false);
                hn.this.lb = this.zo;
                hn.this.m = i2;
                hn.this.g = str;
                if (hn.this.e != null) {
                    hn.this.e.pr(i2, str, str2);
                }
                super.onReceivedError(webView, i2, str, str2);
            }

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    hn.this.yb.set(false);
                    hn.this.lb = this.zo;
                }
                hn.this.m = webResourceError.getErrorCode();
                hn.this.g = String.valueOf(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (hn.this.e != null) {
                    try {
                        hn.this.e.pr(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                    } catch (Throwable th) {
                    }
                }
                if (hn.this.vk.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        hn.this.yb.set(false);
                        hn.this.lb = this.zo;
                    }
                    if (webResourceResponse != null) {
                        hn.this.m = webResourceResponse.getStatusCode();
                        hn.this.g = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (hn.this.e != null && str != null && !str.contains("about:blank")) {
                    hn.this.e.fw(str);
                }
                super.onPageFinished(webView, str);
                hn.this.of.pr(webView, str);
                if (hn.this.v != null) {
                    hn.this.v.pr();
                }
                if (webView != null && lb.pr(hn.this.hw)) {
                    webView.evaluateJavascript(BaseLandingPageActivity.pr(this.aj), null);
                }
            }

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                hn.this.iu.set(true);
                hn.this.of.pr(webView, str, bitmap);
            }
        };
        this.fw.setWebViewClient(this.w);
        this.fw.setWebChromeClient(new com.byazt.lz.hn(this.zo, this.k));
        pr(this.fw);
        this.fw.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.fw.setDisplayZoomControls(false);
        this.fw.setDownloadListener(downloadListener);
        pr(hwVar);
    }

    private void pr(com.byazt.az.hw hwVar) {
        RewardLpBottomView rewardLpBottomView;
        if (ny.fw(this.hw) && (rewardLpBottomView = this.v) != null) {
            rewardLpBottomView.setDownLoadClickListener(hwVar);
        }
    }

    public void iu() {
        if (!this.ho && this.fw != null && this.fw.getWebView() != null) {
            this.fw.loadUrl(this.vk);
            this.ho = true;
            zo zoVar = this.e;
            if (zoVar != null) {
                zoVar.uc(this.vk);
            }
        }
    }

    @Override // com.byazt.yr.pr
    public String rc() {
        return "playable";
    }

    @Override // com.byazt.yr.pr
    public void m() {
        super.m();
        zo zoVar = this.e;
        if (zoVar != null) {
            zoVar.hw(false);
        }
        com.byazt.le.hn hnVar = this.ww;
        if (hnVar != null) {
            hnVar.hw();
        }
    }

    @Override // com.byazt.yr.pr
    public void k() {
        super.k();
        if (this.e != null && er.x(this.fw)) {
            this.e.hw(true);
        }
        com.byazt.le.hn hnVar = this.ww;
        if (hnVar != null) {
            hnVar.hn();
        }
        com.byazt.pj.x xVar = this.n;
        if (xVar != null) {
            xVar.hn();
        }
    }

    @Override // com.byazt.yr.pr
    public void g() {
        super.g();
        com.byazt.pj.x xVar = this.n;
        if (xVar != null) {
            xVar.pr(0);
        }
    }

    @Override // com.byazt.yr.pr
    public void ho() {
        super.ho();
        zo zoVar = this.e;
        if (zoVar != null) {
            zoVar.n();
        }
        if (this.k != null) {
            this.k.pr((com.byazt.pj.hn.hw) null);
        }
        this.qi.x();
        com.byazt.le.hn hnVar = this.ww;
        if (hnVar != null) {
            hnVar.x();
        }
        com.byazt.pj.x xVar = this.n;
        if (xVar != null) {
            xVar.x();
        }
        this.ie = null;
    }

    @Override // com.byazt.yr.pr
    public void pr(int i2) {
        super.pr(i2);
        qi();
    }

    @Override // com.byazt.yr.pr
    public void z() {
        super.z();
        this.qi.hn();
        com.byazt.le.hn hnVar = this.ww;
        if (hnVar != null) {
            hnVar.hn();
        }
    }

    @Override // com.byazt.yr.pr
    public void x(boolean z) {
        super.x(z);
        if (!z) {
            this.qi.hw();
        }
        com.byazt.le.hn hnVar = this.ww;
        if (hnVar != null) {
            hnVar.hw();
        }
    }

    public void ve() {
        pr(true);
        zo zoVar = this.e;
        if (zoVar != null) {
            zoVar.hw(true);
        }
        hn(true);
        pr(false, true);
        if (this.w != null) {
            this.w.hw(false);
        }
    }

    public void c(boolean z) {
        if (this.zo == null || this.pr.isFinishing()) {
            return;
        }
        try {
            this.zo.fw(z);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isReward", z);
            this.zo.hw("isVerifyReward", jSONObject);
        } catch (Exception e) {
        }
    }

    public void hw(int i2, int i3) {
        if (this.zo == null || this.pr.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("skip_remain_time", i2);
            if (this.x) {
                jSONObject.put("reward_remain_time", i3);
            }
            this.zo.hw("reward_button_status", jSONObject);
        } catch (Exception e) {
        }
    }

    public void pr(com.byazt.ax.hw.InterfaceC0020hw interfaceC0020hw) {
        this.ls = interfaceC0020hw;
    }

    public long gz() {
        return System.currentTimeMillis() - this.gz;
    }

    public boolean nl() {
        if (this.zo != null) {
            return this.zo.w();
        }
        return true;
    }

    public nl y() {
        return this.zo;
    }

    public boolean ww() {
        return !this.iu.get();
    }

    @Override // com.byazt.yr.pr
    public void hw(boolean z) {
        zo zoVar = this.e;
        if (zoVar != null) {
            zoVar.pr(z);
        }
        this.qi.pr(z);
    }

    @Override // com.byazt.yr.pr
    public void uc() {
        if (this.fw != null && this.fw.getVisibility() == 0) {
            this.ls.hn().pr(true);
        }
        super.uc();
        this.qi.pr();
        zo zoVar = this.e;
        if (zoVar != null) {
            zoVar.hw(false);
        }
        pr(true, false);
    }

    public void n() {
        if (this.fw == null || this.e != null) {
            return;
        }
        if (com.byazt.sd.zo.nt().of()) {
            fw.pr(i);
        }
        com.byazt.ns.hn hnVar = new com.byazt.ns.hn();
        x xVar = new x(this.r);
        com.byazt.ns.c cVar = new com.byazt.ns.c(this.zo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.hw.x());
            jSONObject.put("log_extra", this.hw.B_());
        } catch (Throwable th) {
        }
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        zo zoVarPr = hnVar.pr(a.getContext(), this.fw, cVar, xVar, hashSet, zo.pr.LAND_PAGE).c(this.vk).x(com.byazt.hb.pr.zo()).pr(com.byazt.hb.pr.pr()).c(jSONObject).pr("sdkEdition", com.byazt.hb.pr.hn()).hw(com.byazt.hb.pr.uc()).hn(com.byazt.hb.pr.c()).pr(10L).hw(10L).hn(false).pr(false);
        this.e = zoVarPr;
        Set<String> setVk = zoVarPr.vk();
        if (this.zo == null || setVk == null || setVk.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.e);
        Iterator<String> it = setVk.iterator();
        while (it.hasNext()) {
            this.zo.uc().pr(it.next(), (com.byazt.ee.c<?, ?>) new com.byazt.ee.c<JSONObject, JSONObject>() { // from class: com.byazt.yr.hn.9
                @Override // com.byazt.ee.c
                public JSONObject pr(JSONObject jSONObject2, uc ucVar) throws Exception {
                    try {
                        zo zoVar = (zo) weakReference.get();
                        if (zoVar == null) {
                            return null;
                        }
                        return zoVar.x(pr(), jSONObject2);
                    } catch (Throwable th2) {
                        return null;
                    }
                }
            });
        }
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        switch (message.what) {
            case 101:
                v();
                break;
            case 102:
                this.ve.removeMessages(102);
                this.ls.hn().pr(true);
                this.pr.lv();
                if (message.arg1 == 2) {
                    er();
                } else if (message.arg1 == 0 || message.arg1 == 1) {
                    ve();
                }
                break;
        }
    }

    private void er() {
        com.byazt.ax.hw.pr prVar = this.ii;
        if (prVar != null) {
            prVar.pr();
            hn(2);
        }
    }

    @Override // com.byazt.pj.hn.hw
    public void pr(String str) {
        if (TextUtils.isEmpty(this.f)) {
            this.f = str;
        }
        if (!TextUtils.equals(this.f, str)) {
            this.f = str;
            this.pr.vk(1);
        }
    }

    private void v() {
        this.ve.sendMessage(hw(3));
        er();
        this.pr.hn(0);
    }

    public void uc(boolean z) {
        if (this.zo == null || this.pr.isFinishing()) {
            return;
        }
        this.s = z;
    }

    private Message hw(int i2) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 102;
        messageObtain.arg1 = i2;
        return messageObtain;
    }

    public void pr(com.byazt.ax.hw.pr prVar) {
        this.ii = prVar;
    }

    @Override // com.byazt.yr.pr
    public void pr(Map<String, Object> map) {
        if (this.aj != null) {
            this.aj.vk();
        }
        if (map != null && ny.hn(this.hw)) {
            map.put("duration", Long.valueOf(gz()));
        }
    }

    private void qi() {
        long jNt;
        if (this.pr.o() == null) {
            return;
        }
        if (this.pr.o().pr()) {
            jNt = 0;
        } else {
            jNt = this.pr.o().nt();
        }
        boolean zM = this.pr.o().m();
        if (!(this.pr.bm() instanceof com.byazt.lu.zo)) {
            zo zoVar = this.e;
            zM = zoVar != null && zoVar.fw();
        }
        this.qi.pr(jNt, zM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, i2);
        } catch (Exception e) {
        }
        com.byazt.xk.hw.pr().x(jSONObject);
    }
}
