package com.byazt.vu;

import android.text.TextUtils;
import com.byazt.gct.fi;
import com.byazt.gwu.s;
import com.byazt.lk.l;
import com.byazt.nf.rv;
import com.byazt.qit.x;
import com.byazt.qk.oa;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1144, 19})
public class n {
    public static String n = "";
    public static String qg = "";

    /* JADX INFO: Access modifiers changed from: private */
    public static s qg() {
        return l.qg(com.byazt.vgx.s.q(), "js_pform", 0, com.byazt.p001if.n.n());
    }

    public static void n(final RunnableC0377n runnableC0377n) {
        fi fiVarWv = rv.qg().wv();
        final String strN = fiVarWv == null ? null : fiVarWv.n();
        if (TextUtils.isEmpty(strN)) {
            return;
        }
        if (TextUtils.isEmpty(qg)) {
            qg = strN;
        }
        com.byazt.qit.l.qg(new x("loadPfJs") { // from class: com.byazt.vu.n.1
            @Override // java.lang.Runnable
            public void run() {
                RunnableC0377n runnableC0377n2;
                String str = strN;
                if (str != null && str.equalsIgnoreCase(n.qg)) {
                    if (TextUtils.isEmpty(n.n)) {
                        n.n = n.qg().qg(com.byazt.tk.l.qg(strN), "");
                    }
                    if (!TextUtils.isEmpty(n.n) && (runnableC0377n2 = runnableC0377n) != null) {
                        runnableC0377n2.run();
                        return;
                    }
                }
                com.byazt.qk.rv rvVarQg = com.byazt.phf.s.qg(strN);
                rvVarQg.n("content-type", "application/json; charset=utf-8");
                rvVarQg.n(new com.byazt.qk.x() { // from class: com.byazt.vu.n.1.1
                    @Override // com.byazt.qk.x
                    public void n(int i, String str2, Throwable th) {
                    }

                    @Override // com.byazt.qk.x
                    public void n(oa oaVar) {
                        try {
                            n.n = oaVar.fs();
                            n.qg = strN;
                            if (runnableC0377n != null) {
                                runnableC0377n.run();
                            }
                            s sVarQg = n.qg();
                            sVarQg.n();
                            sVarQg.n(com.byazt.tk.l.qg(strN), n.n);
                        } catch (Throwable th) {
                            k.n("performanceH5", "TTWebViewClient : onPageFinished", th);
                        }
                    }
                });
            }
        });
    }

    public static void n(StringBuilder sb, String str, String str2) {
        int iIndexOf;
        if (sb == null || TextUtils.isEmpty(str) || (iIndexOf = sb.indexOf(str)) <= 0) {
            return;
        }
        sb.replace(iIndexOf, str.length() + iIndexOf, str2);
    }

    /* JADX INFO: renamed from: com.byazt.vu.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1144, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class RunnableC0377n implements Runnable {
        public WeakReference<Runnable> n;

        public RunnableC0377n(Runnable runnable) {
            if (runnable != null) {
                this.n = new WeakReference<>(runnable);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<Runnable> weakReference = this.n;
            Runnable runnable = weakReference != null ? weakReference.get() : null;
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
