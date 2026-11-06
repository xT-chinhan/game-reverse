package com.byazt.il;

import android.content.Context;
import android.view.View;
import com.byazt.ih.s;
import com.byazt.vgx.qg;
import com.byazt.xz.cy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 586, 19})
public class n extends s<PageWebView> {
    public String n;

    public n(Context context) {
        super(context);
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public PageWebView n() {
        return new PageWebView(this.qg);
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
        ((PageWebView) this.l).setMeta(qg.n(tj()));
        ((PageWebView) this.l).qg(tj());
        ((PageWebView) this.l).setUGenContext(this.rv);
        ((PageWebView) this.l).setWebViewLifeCycleListener(new PageWebView.qg() { // from class: com.byazt.il.n.1
            @Override // com.byazt.il.PageWebView.qg
            public void n() {
                n.this.d("pageStart");
            }

            @Override // com.byazt.il.PageWebView.qg
            public void qg() {
                n.this.d("pageFinish");
            }
        });
        ((PageWebView) this.l).n();
        ((PageWebView) this.l).n(this.n);
    }

    public void fs() {
        if (this.l != 0) {
            ((PageWebView) this.l).qg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        cy cyVarS = this.rv == null ? null : this.rv.s();
        if (cyVarS != null) {
            String strQ = this.rv.q();
            HashMap map = new HashMap();
            map.put("status", str);
            cyVarS.n(strQ, "webViewLifeCycle", map);
            return;
        }
        n(qg(this), "webViewLifeCycle", str);
    }

    private void n(s sVar, String str, Object... objArr) {
        List<s<View>> listX;
        if (sVar == null) {
            return;
        }
        sVar.n(str, objArr);
        if (!(sVar instanceof com.byazt.ih.n) || (listX = ((com.byazt.ih.n) sVar).x()) == null || listX.isEmpty()) {
            return;
        }
        Iterator<s<View>> it = listX.iterator();
        while (it.hasNext()) {
            n(it.next(), str, objArr);
        }
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        str.hashCode();
        if (str.equals("src")) {
            this.n = str2;
        }
    }
}
