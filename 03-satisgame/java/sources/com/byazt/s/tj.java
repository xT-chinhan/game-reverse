package com.byazt.s;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.hj.DownloadController;
import com.byazt.hj.DownloadEventConfig;
import com.byazt.hj.DownloadModel;
import com.byazt.hj.DownloadStatusChangeListener;
import com.byazt.ky.IDownloadButtonClickListener;
import com.byazt.ky.OnItemClickListener;
import com.byazt.ug.d;
import com.byazt.ug.sz;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj {
    public static volatile tj n;
    public com.byazt.w.qg l;
    public final com.byazt.w.n q;
    public final com.byazt.cc.n qg;
    public final fs s;
    public long w;

    public static tj n(final Context context) {
        if (n == null) {
            synchronized (tj.class) {
                if (n == null) {
                    com.byazt.ch.qg.n(new Runnable() { // from class: com.byazt.s.tj.1
                        @Override // java.lang.Runnable
                        public void run() {
                            tj unused = tj.n = new tj(context);
                        }
                    });
                }
            }
        }
        return n;
    }

    private tj(Context context) {
        this.s = fs.n();
        this.qg = new w();
        this.w = System.currentTimeMillis();
        qg(context);
        this.q = n.n();
    }

    private void qg(Context context) {
        d.n(context);
        Downloader.getInstance(d.getContext());
        com.byazt.vl.w.n().qg();
        com.byazt.e.q.cp().n(d.getContext(), "misc_config", new com.byazt.ht.x(), new com.byazt.ht.w(context), new s());
        com.byazt.ht.q qVar = new com.byazt.ht.q();
        com.byazt.e.q.cp().n(qVar);
        Downloader.getInstance(context).registerDownloadCacheSyncListener(qVar);
        com.byazt.e.q.cp().n(new sz());
        com.byazt.xv.s.n(new com.byazt.ht.l());
        com.byazt.e.q.cp().n(com.byazt.ue.s.n());
    }

    public com.byazt.cc.n n() {
        return this.qg;
    }

    public com.byazt.cc.n n(String str) {
        com.byazt.ky.w wVarQg = x.n().qg();
        if (wVarQg != null && wVarQg.n(str)) {
            return wVarQg.qg(str);
        }
        return this.qg;
    }

    public long qg() {
        return this.w;
    }

    public void s() {
        this.w = System.currentTimeMillis();
    }

    public com.byazt.w.n q() {
        return this.q;
    }

    public com.byazt.w.qg l() {
        if (this.l == null) {
            this.l = qg.n();
        }
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public fs fs() {
        return this.s;
    }

    public void n(final Context context, final int i, final DownloadStatusChangeListener downloadStatusChangeListener, final DownloadModel downloadModel) {
        com.byazt.ch.qg.n(new Runnable() { // from class: com.byazt.s.tj.4
            @Override // java.lang.Runnable
            public void run() {
                tj.this.fs().n(context, i, downloadStatusChangeListener, downloadModel);
            }
        });
    }

    public void n(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final OnItemClickListener onItemClickListener, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.byazt.ch.qg.n(new Runnable() { // from class: com.byazt.s.tj.5
            @Override // java.lang.Runnable
            public void run() {
                tj.this.fs().n(str, j, i, downloadEventConfig, downloadController, onItemClickListener, iDownloadButtonClickListener);
            }
        });
    }

    public void n(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController) {
        com.byazt.ch.qg.n(new Runnable() { // from class: com.byazt.s.tj.6
            @Override // java.lang.Runnable
            public void run() {
                tj.this.fs().n(str, j, i, downloadEventConfig, downloadController);
            }
        });
    }

    public void n(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.byazt.ch.qg.n(new Runnable() { // from class: com.byazt.s.tj.7
            @Override // java.lang.Runnable
            public void run() {
                tj.this.fs().n(str, j, i, downloadEventConfig, downloadController, iDownloadButtonClickListener);
            }
        });
    }

    public void n(final String str, final int i) {
        com.byazt.ch.qg.n(new Runnable() { // from class: com.byazt.s.tj.2
            @Override // java.lang.Runnable
            public void run() {
                tj.this.fs().n(str, i);
            }
        });
    }

    public void n(final String str, final boolean z) {
        com.byazt.ch.qg.n(new Runnable() { // from class: com.byazt.s.tj.3
            @Override // java.lang.Runnable
            public void run() {
                tj.this.fs().n(str, z);
            }
        });
    }

    public void n(com.byazt.rn.n nVar) {
        fs().n(nVar);
    }

    public String w() {
        return d.sz();
    }

    public void x() {
        l.n().w();
    }

    public DownloadInfo qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.byazt.e.q.cp().n(d.getContext(), str);
    }

    public DownloadInfo n(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2) && z) {
            return qg(str);
        }
        return Downloader.getInstance(d.getContext()).getDownloadInfo(str, str2);
    }
}
