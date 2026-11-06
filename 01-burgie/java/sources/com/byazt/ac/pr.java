package com.byazt.ac;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.hcx.aj;
import com.byazt.hcx.m;
import com.byazt.hg.ls;
import com.byazt.sd.a;
import com.byazt.tf.hn;
import com.byazt.wt.y;
import com.byazt.xlm.c;
import com.byazt.xlm.fw;
import com.mar.sdk.MARCode;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1185, 37})
public class pr {
    public static String pr = "";
    public static String hw = "";

    public static void pr(final RunnableC0007pr runnableC0007pr) {
        ls lsVarPj = a.hw().pj();
        final String strPr = lsVarPj == null ? null : lsVarPj.pr();
        if (TextUtils.isEmpty(strPr)) {
            return;
        }
        if (TextUtils.isEmpty(hw)) {
            hw = strPr;
        }
        c.hw(new fw("loadPfJs") { // from class: com.byazt.ac.pr.1
            @Override // java.lang.Runnable
            public void run() {
                RunnableC0007pr runnableC0007pr2;
                String str = strPr;
                if (str != null && str.equalsIgnoreCase(pr.hw)) {
                    if (TextUtils.isEmpty(pr.pr)) {
                        pr.pr = y.pr("js_pform").hw(com.byazt.ca.c.hw(strPr), "");
                    }
                    if (!TextUtils.isEmpty(pr.pr) && (runnableC0007pr2 = runnableC0007pr) != null) {
                        runnableC0007pr2.run();
                        return;
                    }
                }
                aj ajVarHw = hn.hw(strPr);
                ajVarHw.pr("content-type", "application/json; charset=utf-8");
                ajVarHw.pr(new com.byazt.hcx.fw() { // from class: com.byazt.ac.pr.1.1
                    @Override // com.byazt.hcx.fw
                    public void pr(m mVar) {
                        try {
                            pr.pr = mVar.zo();
                            pr.hw = strPr;
                            if (runnableC0007pr != null) {
                                runnableC0007pr.run();
                            }
                            y.pr("js_pform").pr();
                            y.pr("js_pform").pr(com.byazt.ca.c.hw(strPr), pr.pr);
                        } catch (Throwable th) {
                            ho.pr("performanceH5", "TTWebViewClient : onPageFinished", th);
                        }
                    }

                    @Override // com.byazt.hcx.fw
                    public void pr(int i, String str2, Throwable th) {
                    }
                });
            }
        });
    }

    public static void pr(StringBuilder sb, String str, String str2) {
        int iIndexOf;
        if (sb != null && !TextUtils.isEmpty(str) && (iIndexOf = sb.indexOf(str)) > 0) {
            sb.replace(iIndexOf, str.length() + iIndexOf, str2);
        }
    }

    /* JADX INFO: renamed from: com.byazt.ac.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1185, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static class RunnableC0007pr implements Runnable {
        public WeakReference<Runnable> pr;

        public RunnableC0007pr(Runnable runnable) {
            if (runnable != null) {
                this.pr = new WeakReference<>(runnable);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<Runnable> weakReference = this.pr;
            Runnable runnable = weakReference != null ? weakReference.get() : null;
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
