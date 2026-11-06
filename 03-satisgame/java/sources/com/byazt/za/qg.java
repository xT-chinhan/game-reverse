package com.byazt.za;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.byazt.gct.pk;
import com.byazt.pmn.AppDownloadListener;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 26})
public abstract class qg extends com.byazt.fvm.sz {
    public n n;
    public Dialog qg;
    public Integer[] s;

    public abstract pk cp();

    public com.byazt.cs.n d() {
        return null;
    }

    @Override // com.byazt.fvm.sz
    public Map<String, Object> fs() {
        return null;
    }

    @Override // com.byazt.fvm.sz
    public View n() {
        return null;
    }

    @Override // com.byazt.fvm.sz
    public com.byazt.fvm.x n(Activity activity) {
        return null;
    }

    @Override // com.byazt.fvm.sz
    public void n(int i) {
    }

    @Override // com.byazt.fvm.sz
    public void n(Activity activity, com.byazt.lr.n nVar) {
    }

    public void n(Dialog dialog) {
    }

    @Override // com.byazt.fvm.sz
    public void n(com.byazt.fx.n nVar) {
    }

    @Override // com.byazt.fvm.sz
    public void n(com.byazt.fx.qg qgVar) {
    }

    @Override // com.byazt.fvm.sz
    public void n(com.byazt.fx.s sVar) {
    }

    @Override // com.byazt.fvm.sz
    public void n(com.byazt.mi.s sVar) {
    }

    @Override // com.byazt.fvm.fs
    public void n(Double d) {
    }

    @Override // com.byazt.fvm.fs
    public void n(Double d, String str, String str2) {
    }

    @Override // com.byazt.fvm.sz
    public void n(boolean z) {
    }

    @Override // com.byazt.fvm.sz
    public void q() {
    }

    @Override // com.byazt.fvm.sz
    public int qg() {
        return 0;
    }

    @Override // com.byazt.fvm.fs
    public void qg(Double d) {
    }

    @Override // com.byazt.fvm.sz
    public int s() {
        return 0;
    }

    @Override // com.byazt.fvm.sz
    public com.byazt.fvm.q w() {
        return null;
    }

    @Override // com.byazt.fvm.sz
    public void l() {
        if (cp() != null) {
            com.byazt.ikv.qg.n(cp().py());
            com.byazt.ikv.qg.n(cp().ih());
        }
    }

    @Override // com.byazt.fvm.sz
    public void n(Dialog dialog, Integer[] numArr) {
        this.qg = dialog;
        this.s = numArr;
        try {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.za.qg.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    if (qg.this.cp() != null) {
                        qg qgVar = qg.this;
                        qgVar.n(qgVar.cp().pt());
                    }
                }
            });
        } catch (Throwable unused) {
        }
        n(this.qg);
    }

    public void n(com.byazt.oj.qg qgVar) {
        Dialog dialog;
        if (qgVar == null || (dialog = this.qg) == null) {
            return;
        }
        com.byazt.nnl.qg.n(qgVar, dialog, this.s);
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 48})
    protected static class n implements AppDownloadListener {
        public WeakReference<AppDownloadListener> n;
        public String qg;

        public n(AppDownloadListener appDownloadListener, String str) {
            this.qg = "";
            this.n = new WeakReference<>(appDownloadListener);
            this.qg = str;
        }

        public void n(AppDownloadListener appDownloadListener) {
            this.n = new WeakReference<>(appDownloadListener);
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onIdle() {
            WeakReference<AppDownloadListener> weakReference = this.n;
            if (weakReference != null && weakReference.get() != null) {
                this.n.get().onIdle();
            }
            com.byazt.ll.n.n(this.qg);
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onDownloadActive(long j, long j2, String str, String str2) {
            WeakReference<AppDownloadListener> weakReference = this.n;
            if (weakReference != null && weakReference.get() != null) {
                this.n.get().onDownloadActive(j, j2, str, str2);
            }
            com.byazt.ll.n.n(this.qg, j, j2);
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onDownloadPaused(long j, long j2, String str, String str2) {
            WeakReference<AppDownloadListener> weakReference = this.n;
            if (weakReference != null && weakReference.get() != null) {
                this.n.get().onDownloadPaused(j, j2, str, str2);
            }
            com.byazt.ll.n.qg(this.qg, j, j2);
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onDownloadFailed(long j, long j2, String str, String str2) {
            WeakReference<AppDownloadListener> weakReference = this.n;
            if (weakReference != null && weakReference.get() != null) {
                this.n.get().onDownloadFailed(j, j2, str, str2);
            }
            com.byazt.ll.n.s(this.qg, j, j2);
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onDownloadFinished(long j, String str, String str2) {
            WeakReference<AppDownloadListener> weakReference = this.n;
            if (weakReference != null && weakReference.get() != null) {
                this.n.get().onDownloadFinished(j, str, str2);
            }
            com.byazt.ll.n.qg(this.qg);
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onInstalled(String str, String str2) {
            WeakReference<AppDownloadListener> weakReference = this.n;
            if (weakReference != null && weakReference.get() != null) {
                this.n.get().onInstalled(str, str2);
            }
            com.byazt.ll.n.s(this.qg);
        }
    }

    @Override // com.byazt.fvm.fs
    public void n(com.byazt.mi.qg qgVar) {
        if (cp() != null) {
            com.byazt.ikv.qg.n(cp().py(), qgVar, com.byazt.mi.qg.class);
        }
    }
}
