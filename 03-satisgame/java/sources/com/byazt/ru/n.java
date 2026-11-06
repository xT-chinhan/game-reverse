package com.byazt.ru;

import android.content.Context;
import android.view.View;
import com.byazt.gct.pk;
import com.byazt.gct.tj;
import com.byazt.ikv.qg;
import com.byazt.iz.fs;
import com.byazt.nf.rv;
import com.byazt.pmn.AppDownloadListener;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.vgx.w;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1333, 19})
public class n {
    public static void n(View view, pk pkVar, Context context) {
        if (pkVar == null) {
            return;
        }
        if (context == null) {
            context = rv.getContext();
        }
        String strQg = w.qg(pkVar);
        com.byazt.ys.n nVar = new com.byazt.ys.n(context, pkVar, strQg, w.q(strQg));
        ITTInnerDownloadAdapter iTTInnerDownloadAdapterN = n(pkVar, context, strQg);
        if (iTTInnerDownloadAdapterN != null) {
            ((com.byazt.zct.n) nVar.n(com.byazt.zct.n.class)).n(iTTInnerDownloadAdapterN);
        }
        ((com.byazt.zct.n) nVar.n(com.byazt.zct.n.class)).n((com.byazt.zct.n.InterfaceC0409n) qg.s(pkVar.ih(), com.byazt.zct.n.InterfaceC0409n.class));
        nVar.n(view, new tj());
    }

    private static ITTInnerDownloadAdapter n(pk pkVar, Context context, String str) {
        if (pkVar == null) {
            return null;
        }
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter = (ITTInnerDownloadAdapter) qg.s(pkVar.ih(), ITTInnerDownloadAdapter.class);
        if (iTTInnerDownloadAdapter != null) {
            pkVar.ih();
        }
        if (iTTInnerDownloadAdapter != null) {
            return iTTInnerDownloadAdapter;
        }
        ITTInnerDownloadAdapter iTTInnerDownloadAdapterQg = qg(pkVar, context, str);
        qg.qg(pkVar.ih(), iTTInnerDownloadAdapterQg, ITTInnerDownloadAdapter.class);
        pkVar.ih();
        return iTTInnerDownloadAdapterQg;
    }

    private static ITTInnerDownloadAdapter qg(pk pkVar, Context context, String str) {
        if (pkVar.rv() != 4) {
            return null;
        }
        com.byazt.oh.n nVarN = fs.n(context, pkVar, str);
        final String strQ = pkVar.q();
        nVarN.addAppDownloadListener(new AppDownloadListener() { // from class: com.byazt.ru.n.1
            @Override // com.byazt.pmn.AppDownloadListener
            public void onIdle() {
                com.byazt.ll.n.n(strQ);
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadActive(long j, long j2, String str2, String str3) {
                com.byazt.ll.n.n(strQ, j, j2);
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadPaused(long j, long j2, String str2, String str3) {
                com.byazt.ll.n.qg(strQ, j, j2);
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadFailed(long j, long j2, String str2, String str3) {
                com.byazt.ll.n.s(strQ, j, j2);
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadFinished(long j, String str2, String str3) {
                com.byazt.ll.n.qg(strQ);
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onInstalled(String str2, String str3) {
                com.byazt.ll.n.s(strQ);
            }
        });
        nVarN.init();
        return nVarN;
    }
}
