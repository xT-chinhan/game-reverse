package com.byazt.wq;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.gcl.s;
import com.byazt.gct.cd;
import com.byazt.gct.pk;
import com.byazt.kfh.SSWebView;
import com.byazt.lq.l;
import com.byazt.uv.w;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1099, 2140})
public class EcMallWebView extends SSWebView {
    public s l;
    public final pk w;
    public w x;

    public EcMallWebView(final Context context, pk pkVar, final int i) {
        super(context);
        this.w = pkVar;
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.wq.EcMallWebView.1
            @Override // java.lang.Runnable
            public void run() {
                EcMallWebView.this.n(context, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Context context, int i) {
        this.l = new s(context);
        final String strN = com.byazt.vgx.w.n(i);
        this.x = new w() { // from class: com.byazt.wq.EcMallWebView.2
            @Override // com.byazt.uv.w
            public void n() {
            }

            @Override // com.byazt.uv.w
            public void qg() {
            }

            @Override // com.byazt.uv.w
            public void n(int i2) {
                com.byazt.mi.qg qgVar;
                if (EcMallWebView.this.w != null && (qgVar = (com.byazt.mi.qg) com.byazt.ikv.qg.n(EcMallWebView.this.w.py(), com.byazt.mi.qg.class)) != null) {
                    qgVar.n(2, null);
                }
                com.byazt.hm.n.n(strN, EcMallWebView.this.w);
            }
        };
        this.l.qg(this).n(this.w).qg(this.w.q()).q(this.w.F_()).s(i).l(com.byazt.vgx.w.wm(this.w)).n((SSWebView) this).n(strN).n(this.x).n(true);
        setWebViewClient(new com.byazt.dho.s(context, this.l, this.w.q(), new com.byazt.hm.s(this.w, this).qg(true)));
        setWebChromeClient(new com.byazt.dho.qg(this.l));
        pk pkVar = this.w;
        if (pkVar != null && !TextUtils.isEmpty(pkVar.py())) {
            com.byazt.uad.n.n(this.w.py(), getInnerIWebView());
        }
        String strFs = cd.fs(this.w);
        if (TextUtils.isEmpty(strFs)) {
            strFs = this.w.fs();
        }
        if (TextUtils.isEmpty(strFs)) {
            return;
        }
        loadUrl(l.s(strFs));
    }

    @Override // com.byazt.qza.BizWebView, android.view.View, com.byazt.uad.q
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        s sVar = this.l;
        if (sVar != null) {
            sVar.cp(z);
        }
    }

    @Override // com.byazt.kfh.SSWebView, com.byazt.qza.BizWebView, com.byazt.qza.MultiWebview, com.byazt.uad.q
    public void destroy() {
        s sVar = this.l;
        if (sVar != null) {
            sVar.lh();
        }
        super.destroy();
    }
}
