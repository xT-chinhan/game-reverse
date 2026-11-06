package com.byazt.qx;

import android.view.ViewGroup;
import com.byazt.fj.SSWebView;
import com.byazt.hg.of;
import com.byazt.sd.nl;
import com.byazt.sd.ww;
import com.byazt.wt.ls;
import com.byazt.wt.n;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 166})
public class iu implements SSWebView.hw {
    public nl hn;
    public of hw;
    public SSWebView pr;

    public iu(SSWebView sSWebView, nl nlVar, of ofVar) {
        this.pr = sSWebView;
        this.hw = ofVar;
        this.hn = nlVar;
    }

    private boolean pr() {
        SSWebView sSWebView = this.pr;
        if (sSWebView == null) {
            return false;
        }
        return ww.hw(sSWebView, 50, ls.k(this.hw));
    }

    @Override // com.byazt.fj.SSWebView.hw
    public void pr(final int i) {
        if (!pr()) {
            return;
        }
        if (com.byazt.sd.a.hw().qa()) {
            SSWebView sSWebView = this.pr;
            if (sSWebView != null) {
                n.pr((WeakReference<ViewGroup>) new WeakReference((ViewGroup) sSWebView.getParent()), new com.byazt.az.hn() { // from class: com.byazt.qx.iu.1
                    @Override // com.byazt.az.hn
                    public void pr() {
                        if (iu.this.hn != null) {
                            iu.this.hn.pr(i);
                        }
                    }
                });
                return;
            }
            return;
        }
        nl nlVar = this.hn;
        if (nlVar != null) {
            nlVar.pr(i);
        }
    }
}
