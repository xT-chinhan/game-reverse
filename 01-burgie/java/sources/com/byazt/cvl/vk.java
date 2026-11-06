package com.byazt.cvl;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.bek.DownloadController;
import com.byazt.bek.DownloadEventConfig;
import com.byazt.bek.DownloadModel;
import com.byazt.bek.DownloadStatusChangeListener;
import com.byazt.eld.g;
import com.byazt.eld.k;
import com.byazt.lj.Downloader;
import com.byazt.zv.IDownloadButtonClickListener;
import com.byazt.zv.OnItemClickListener;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CACHE_SEI, 50})
public class vk {
    public static volatile vk pr;
    public com.byazt.wqt.hw c;
    public final zo hn;
    public final com.byazt.vb.pr hw;
    public long uc;
    public final com.byazt.wqt.pr x;

    public static vk pr(final Context context) {
        if (pr == null) {
            synchronized (vk.class) {
                if (pr == null) {
                    com.byazt.vi.hw.pr(new Runnable() { // from class: com.byazt.cvl.vk.1
                        @Override // java.lang.Runnable
                        public void run() {
                            vk unused = vk.pr = new vk(context);
                        }
                    });
                }
            }
        }
        return pr;
    }

    private vk(Context context) {
        this.hn = zo.pr();
        this.hw = new uc();
        this.uc = System.currentTimeMillis();
        hw(context);
        this.x = pr.pr();
    }

    private void hw(Context context) {
        k.pr(context);
        Downloader.getInstance(k.getContext());
        com.byazt.shh.uc.pr().hw();
        com.byazt.mdu.x.w().pr(k.getContext(), "misc_config", new com.byazt.sxm.fw(), new com.byazt.sxm.uc(context), new hn());
        com.byazt.sxm.x xVar = new com.byazt.sxm.x();
        com.byazt.mdu.x.w().pr(xVar);
        Downloader.getInstance(context).registerDownloadCacheSyncListener(xVar);
        com.byazt.mdu.x.w().pr(new g());
        com.byazt.lj.hn.pr(new com.byazt.sxm.c());
        com.byazt.mdu.x.w().pr(com.byazt.bri.hn.pr());
    }

    public com.byazt.vb.pr pr() {
        return this.hw;
    }

    public com.byazt.vb.pr pr(String str) {
        com.byazt.zv.uc ucVarHw = fw.pr().hw();
        if (ucVarHw != null && ucVarHw.pr(str)) {
            return ucVarHw.hw(str);
        }
        return this.hw;
    }

    public long hw() {
        return this.uc;
    }

    public void hn() {
        this.uc = System.currentTimeMillis();
    }

    public com.byazt.wqt.pr x() {
        return this.x;
    }

    public com.byazt.wqt.hw c() {
        if (this.c == null) {
            this.c = hw.pr();
        }
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public zo zo() {
        return this.hn;
    }

    public void pr(final Context context, final int i, final DownloadStatusChangeListener downloadStatusChangeListener, final DownloadModel downloadModel) {
        com.byazt.vi.hw.pr(new Runnable() { // from class: com.byazt.cvl.vk.4
            @Override // java.lang.Runnable
            public void run() {
                vk.this.zo().pr(context, i, downloadStatusChangeListener, downloadModel);
            }
        });
    }

    public void pr(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final OnItemClickListener onItemClickListener, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.byazt.vi.hw.pr(new Runnable() { // from class: com.byazt.cvl.vk.5
            @Override // java.lang.Runnable
            public void run() {
                vk.this.zo().pr(str, j, i, downloadEventConfig, downloadController, onItemClickListener, iDownloadButtonClickListener);
            }
        });
    }

    public void pr(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController) {
        com.byazt.vi.hw.pr(new Runnable() { // from class: com.byazt.cvl.vk.6
            @Override // java.lang.Runnable
            public void run() {
                vk.this.zo().pr(str, j, i, downloadEventConfig, downloadController);
            }
        });
    }

    public void pr(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.byazt.vi.hw.pr(new Runnable() { // from class: com.byazt.cvl.vk.7
            @Override // java.lang.Runnable
            public void run() {
                vk.this.zo().pr(str, j, i, downloadEventConfig, downloadController, iDownloadButtonClickListener);
            }
        });
    }

    public void pr(final String str, final int i) {
        com.byazt.vi.hw.pr(new Runnable() { // from class: com.byazt.cvl.vk.2
            @Override // java.lang.Runnable
            public void run() {
                vk.this.zo().pr(str, i);
            }
        });
    }

    public void pr(final String str, final boolean z) {
        com.byazt.vi.hw.pr(new Runnable() { // from class: com.byazt.cvl.vk.3
            @Override // java.lang.Runnable
            public void run() {
                vk.this.zo().pr(str, z);
            }
        });
    }

    public void pr(com.byazt.mgh.pr prVar) {
        zo().pr(prVar);
    }

    public String uc() {
        return k.g();
    }

    public void fw() {
        c.pr().uc();
    }

    public DownloadInfo hw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.byazt.mdu.x.w().pr(k.getContext(), str);
    }

    public DownloadInfo pr(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2) && z) {
            return hw(str);
        }
        return Downloader.getInstance(k.getContext()).getDownloadInfo(str, str2);
    }
}
