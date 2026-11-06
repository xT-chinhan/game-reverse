package com.byazt.tkz;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pk;
import com.byazt.mr.EmptyView;
import com.byazt.pmn.AppDownloadListener;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.udb.sz;
import com.byazt.xk.FullRewardExpressView;
import com.byazt.za.NativeExpressView;
import com.byazt.za.d;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 403, 18})
public class l {
    public ViewGroup fs;
    public final TTBaseVideoActivity l;
    public ITTInnerDownloadAdapter n;
    public FullRewardExpressView rv;
    public pk w;
    public String x;
    public boolean qg = false;
    public boolean s = false;
    public boolean q = false;

    public l(TTBaseVideoActivity tTBaseVideoActivity) {
        this.l = tTBaseVideoActivity;
    }

    public void n(pk pkVar, com.byazt.zq.qg qgVar, String str, boolean z, String str2) {
        if (this.q) {
            return;
        }
        this.q = true;
        this.w = pkVar;
        this.x = str;
        this.rv = new FullRewardExpressView(this.l, pkVar, qgVar, str, z, str2);
        FrameLayout expressFrameContainer = this.l.an().getExpressFrameContainer();
        this.fs = expressFrameContainer;
        expressFrameContainer.addView(this.rv, new FrameLayout.LayoutParams(-2, -1));
        this.rv.setEasyPlayableContainer(this.l.an().getEasyPlayableContainer());
    }

    public void n(CharSequence charSequence, int i, int i2, boolean z) {
        if (this.rv == null || !l()) {
            return;
        }
        this.rv.n(charSequence, i, i2, z);
    }

    public FrameLayout n() {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getVideoFrameLayout();
        }
        return null;
    }

    public boolean qg() {
        return this.qg;
    }

    public void n(boolean z) {
        this.qg = z;
    }

    public boolean s() {
        return this.s;
    }

    public void qg(boolean z) {
        this.s = z;
    }

    public void n(com.byazt.za.x xVar, com.byazt.za.w wVar) {
        pk pkVar;
        if (this.rv == null || (pkVar = this.w) == null) {
            return;
        }
        ITTInnerDownloadAdapter iTTInnerDownloadAdapterN = n(pkVar);
        this.n = iTTInnerDownloadAdapterN;
        if (iTTInnerDownloadAdapterN instanceof com.byazt.oh.n) {
            ((com.byazt.oh.n) iTTInnerDownloadAdapterN).n().n(new com.byazt.pma.n() { // from class: com.byazt.tkz.l.1
                @Override // com.byazt.pma.n
                public void s() {
                }

                @Override // com.byazt.pma.n
                public void n() {
                    l.this.l.q(true);
                }

                @Override // com.byazt.pma.n
                public void qg() {
                    l.this.l.q(false);
                }
            });
        }
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.n;
        if (iTTInnerDownloadAdapter != null) {
            iTTInnerDownloadAdapter.onResume();
            if (this.rv.getContext() != null && (this.rv.getContext() instanceof Activity)) {
                this.n.setActivity((Activity) this.rv.getContext(), false);
            }
        }
        EmptyView emptyViewN = n((ViewGroup) this.rv);
        if (emptyViewN == null) {
            pk pkVar2 = this.w;
            EmptyView emptyView = new EmptyView(this.l, this.rv, pkVar2 != null ? pkVar2.yq() : 1000);
            emptyView.n(this.w, this.x);
            this.rv.addView(emptyView);
            emptyViewN = emptyView;
        }
        emptyViewN.setNeedCheckingShow(false);
        emptyViewN.setCallback(new EmptyView.n() { // from class: com.byazt.tkz.l.2
            @Override // com.byazt.mr.EmptyView.n
            public void n(View view, Map<String, Object> map) {
            }

            @Override // com.byazt.mr.EmptyView.n
            public void n(boolean z) {
                if (l.this.n != null) {
                    if (z) {
                        l.this.n.onResume();
                    } else {
                        l.this.n.onPause();
                    }
                }
            }

            @Override // com.byazt.mr.EmptyView.n
            public void n() {
                if (l.this.n != null) {
                    l.this.n.init();
                }
            }

            @Override // com.byazt.mr.EmptyView.n
            public void qg() {
                if (l.this.n != null) {
                    l.this.n.onDestroy();
                }
            }
        });
        xVar.n(this.rv);
        ((com.byazt.zct.n) xVar.n(com.byazt.zct.n.class)).n(this.n);
        this.rv.setClickListener(xVar);
        wVar.n(this.rv);
        ((com.byazt.zct.n) wVar.n(com.byazt.zct.n.class)).n(this.n);
        this.rv.setClickCreativeListener(wVar);
        emptyViewN.setNeedCheckingShow(false);
        n(this.n, this.rv);
    }

    private void n(ITTInnerDownloadAdapter iTTInnerDownloadAdapter, NativeExpressView nativeExpressView) {
        if (iTTInnerDownloadAdapter == null || nativeExpressView == null) {
            return;
        }
        pk pkVar = this.w;
        final String strQ = pkVar != null ? pkVar.q() : "";
        iTTInnerDownloadAdapter.addAppDownloadListener(new AppDownloadListener() { // from class: com.byazt.tkz.l.3
            @Override // com.byazt.pmn.AppDownloadListener
            public void onIdle() {
                l.this.l.n("点击开始下载");
                com.byazt.ll.n.n(strQ);
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadActive(long j, long j2, String str, String str2) {
                if (j > 0) {
                    l.this.l.n("已下载" + ((int) ((100 * j2) / j)) + "%");
                }
                com.byazt.ll.n.n(strQ, j, j2);
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadPaused(long j, long j2, String str, String str2) {
                l.this.l.n("下载暂停");
                com.byazt.ll.n.qg(strQ, j, j2);
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadFailed(long j, long j2, String str, String str2) {
                l.this.l.n("下载失败");
                com.byazt.ll.n.s(strQ, j, j2);
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadFinished(long j, String str, String str2) {
                l.this.l.n("点击安装");
                com.byazt.ll.n.qg(strQ);
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onInstalled(String str, String str2) {
                l.this.l.n("点击打开");
                com.byazt.ll.n.s(strQ);
            }
        });
    }

    private ITTInnerDownloadAdapter n(pk pkVar) {
        if (pkVar.rv() == 4) {
            return com.byazt.iz.fs.n(this.l, pkVar, this.x);
        }
        return null;
    }

    private EmptyView n(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void n(d dVar) {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressVideoListenerProxy(dVar);
    }

    public void n(com.byazt.za.n nVar) {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressInteractionListener(nVar);
    }

    public void s(boolean z) {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.s(z);
        }
    }

    public void q() {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.hd();
        }
    }

    public boolean l() {
        FullRewardExpressView fullRewardExpressView = this.rv;
        return (fullRewardExpressView == null || fullRewardExpressView.py()) ? false : true;
    }

    public void w() {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.k();
    }

    public void x() {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.cy();
            this.rv.hd();
        }
    }

    public int fs() {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getDynamicShowType();
        }
        return 0;
    }

    public byte rv() {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getShowDLFactorsEventParams();
        }
        return (byte) -1;
    }

    public void n(com.byazt.iag.s sVar) {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.setVideoController(sVar);
        }
    }

    public void q(boolean z) {
        ViewGroup viewGroup = this.fs;
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 8);
        }
    }

    public void n(String str, JSONObject jSONObject) {
        com.byazt.gcl.s jsObject;
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView == null || (jsObject = fullRewardExpressView.getJsObject()) == null || this.l.isFinishing()) {
            return;
        }
        jsObject.qg(str, jSONObject);
    }

    public void n(com.byazt.cs.n.InterfaceC0149n interfaceC0149n) {
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.n;
        if (iTTInnerDownloadAdapter != null) {
            iTTInnerDownloadAdapter.setVideoDataListener(interfaceC0149n);
        }
    }

    public boolean tj() {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView == null) {
            return true;
        }
        return fullRewardExpressView.cp();
    }

    public sz cp() {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView == null) {
            return null;
        }
        return fullRewardExpressView.getRenderResult();
    }

    public FullRewardExpressView d() {
        return this.rv;
    }

    public void n(String str) {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.qg(str);
        }
    }

    public void n(long j, long j2) {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.n(j, j2);
        }
    }

    public void n(int i, long j) {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.n(i, j);
        }
    }

    public void n(com.byazt.ce.s sVar) {
        if (this.rv != null) {
            this.rv.n((int) (sVar.n() / 1000), sVar.l(), sVar.qg(), sVar.q());
        }
    }

    public void oa() {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView != null && fullRewardExpressView.getJsObject() != null) {
            this.rv.getJsObject().x(true);
        }
        n("isVerifyReward", (JSONObject) null);
    }

    public void sz() {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.d();
        }
    }

    public void k() {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.cd();
        }
    }

    public void l(boolean z) {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.qg(z);
        }
    }

    public void n(com.byazt.mkl.n nVar) {
        FullRewardExpressView fullRewardExpressView = this.rv;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.n(nVar);
        }
    }
}
