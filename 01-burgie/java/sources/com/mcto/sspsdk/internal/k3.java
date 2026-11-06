package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.IQyAppDownloadListener;

/* JADX INFO: loaded from: classes2.dex */
public final class k3 implements Runnable {
    public final /* synthetic */ s0 a;
    public final /* synthetic */ n3 b;

    public k3(n3 n3Var, s0 s0Var) {
        this.b = n3Var;
        this.a = s0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            n3 n3Var = this.b;
            IQyAppDownloadListener iQyAppDownloadListener = n3Var.p;
            if (iQyAppDownloadListener != null) {
                s0 s0Var = this.a;
                switch (s0Var.a) {
                    case 0:
                        iQyAppDownloadListener.onIdle();
                        break;
                    case 1:
                        iQyAppDownloadListener.onDownloadActive(s0Var.b, n3Var.d.P);
                        break;
                    case 2:
                        iQyAppDownloadListener.onDownloadPaused(s0Var.b, n3Var.d.P);
                        break;
                    case 3:
                    case 4:
                    default:
                        break;
                    case 5:
                        iQyAppDownloadListener.onDownloadFinished(n3Var.d.P);
                        break;
                    case 6:
                        iQyAppDownloadListener.onDownloadFailed(n3Var.d.P);
                        break;
                    case 7:
                        iQyAppDownloadListener.onInstalled(n3Var.d.P);
                        break;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
