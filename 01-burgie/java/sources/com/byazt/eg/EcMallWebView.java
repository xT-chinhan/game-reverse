package com.byazt.eg;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.ap.c;
import com.byazt.fj.SSWebView;
import com.byazt.hg.lb;
import com.byazt.hg.of;
import com.byazt.lz.x;
import com.byazt.sd.cz;
import com.byazt.sd.nl;
import com.byazt.wt.ls;
import com.byazt.wt.s;
import com.byazt.zp.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1609, 2240})
public class EcMallWebView extends SSWebView {
    public nl c;
    public c fw;
    public final of uc;

    public EcMallWebView(final Context context, of ofVar, final int i) {
        super(context);
        this.uc = ofVar;
        zo.pr(new Runnable() { // from class: com.byazt.eg.EcMallWebView.1
            @Override // java.lang.Runnable
            public void run() {
                EcMallWebView.this.pr(context, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Context context, int i) {
        this.c = new nl(context);
        final String strPr = ls.pr(i);
        this.fw = new c() { // from class: com.byazt.eg.EcMallWebView.2
            @Override // com.byazt.ap.c
            public void pr(int i2) {
                com.byazt.rkl.hw hwVar;
                if (EcMallWebView.this.uc != null && (hwVar = (com.byazt.rkl.hw) cz.pr(EcMallWebView.this.uc.cz(), com.byazt.rkl.hw.class)) != null) {
                    hwVar.pr(2, null);
                }
                com.byazt.pj.pr.pr(strPr, EcMallWebView.this.uc);
            }

            @Override // com.byazt.ap.c
            public void pr() {
            }

            @Override // com.byazt.ap.c
            public void hw() {
            }
        };
        this.c.hw(this).pr(this.uc).hw(this.uc.x()).x(this.uc.B_()).hn(i).c(ls.a(this.uc)).pr((SSWebView) this).pr(strPr).pr(this.fw).pr(true);
        setWebViewClient(new x(context, this.c, this.uc.x(), new com.byazt.pj.hn(this.uc, this).hw(true)));
        setWebChromeClient(new com.byazt.lz.hn(this.c));
        String strZo = lb.zo(this.uc);
        if (TextUtils.isEmpty(strZo)) {
            strZo = this.uc.zo();
        }
        if (TextUtils.isEmpty(strZo)) {
            return;
        }
        loadUrl(s.hn(strZo));
    }

    @Override // com.byazt.su.BizWebView, android.view.View, com.byazt.son.x
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        nl nlVar = this.c;
        if (nlVar != null) {
            nlVar.w(z);
        }
    }
}
