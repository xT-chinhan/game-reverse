package com.byazt.cvl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.bek.DownloadController;
import com.byazt.bek.DownloadEventConfig;
import com.byazt.bek.DownloadModel;
import com.byazt.bek.DownloadStatusChangeListener;
import com.byazt.eld.k;
import com.byazt.km.AdDownloadModel;
import com.byazt.lhc.BaseException;
import com.byazt.zv.IDownloadButtonClickListener;
import com.byazt.zv.OnItemClickListener;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CACHE_SEI, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public static volatile zo pr = null;
    public long uc;
    public final List<com.byazt.eld.fw> hn = new CopyOnWriteArrayList();
    public final Map<String, com.byazt.eld.fw> x = new ConcurrentHashMap();
    public final CopyOnWriteArrayList<Object> c = new CopyOnWriteArrayList<>();
    public final Handler hw = new Handler(Looper.getMainLooper());

    private zo() {
    }

    public static zo pr() {
        if (pr == null) {
            synchronized (zo.class) {
                if (pr == null) {
                    pr = new zo();
                }
            }
        }
        return pr;
    }

    public void pr(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        com.byazt.eld.fw fwVar;
        if (downloadModel == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return;
        }
        boolean z = k.aj().optInt("filter_download_url_key", 0) == 1;
        String strPr = com.byazt.eld.uc.pr().pr(downloadModel.getDownloadUrl());
        if (z && !TextUtils.isEmpty(strPr)) {
            fwVar = this.x.get(strPr);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel.getTaskKey())) {
                    adDownloadModel.setTaskKey(strPr);
                }
            }
        } else {
            fwVar = this.x.get(downloadModel.getDownloadUrl());
        }
        if (fwVar != null) {
            fwVar.hw(context).hw(i, downloadStatusChangeListener).hw(downloadModel).pr();
            return;
        }
        if (!this.hn.isEmpty()) {
            if (z) {
                if (!TextUtils.isEmpty(strPr)) {
                    pr(context, i, downloadStatusChangeListener, downloadModel, strPr);
                    return;
                }
                String strPr2 = com.byazt.eld.uc.pr().pr(downloadModel);
                if (TextUtils.isEmpty(strPr2)) {
                    hw(context, i, downloadStatusChangeListener, downloadModel);
                    return;
                }
                pr(context, i, downloadStatusChangeListener, downloadModel, strPr2);
                if (downloadModel instanceof AdDownloadModel) {
                    AdDownloadModel adDownloadModel2 = (AdDownloadModel) downloadModel;
                    if (TextUtils.isEmpty(adDownloadModel2.getTaskKey())) {
                        adDownloadModel2.setTaskKey(strPr2);
                        return;
                    }
                    return;
                }
                return;
            }
            hw(context, i, downloadStatusChangeListener, downloadModel);
            return;
        }
        if (z) {
            if (!TextUtils.isEmpty(strPr)) {
                hw(context, i, downloadStatusChangeListener, downloadModel, strPr);
                return;
            }
            String strPr3 = com.byazt.eld.uc.pr().pr(downloadModel);
            if (!TextUtils.isEmpty(strPr3)) {
                hw(context, i, downloadStatusChangeListener, downloadModel, strPr3);
                if (downloadModel instanceof AdDownloadModel) {
                    AdDownloadModel adDownloadModel3 = (AdDownloadModel) downloadModel;
                    if (TextUtils.isEmpty(adDownloadModel3.getTaskKey())) {
                        adDownloadModel3.setTaskKey(strPr3);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        hn(context, i, downloadStatusChangeListener, downloadModel);
    }

    public com.byazt.eld.c pr(String str) {
        com.byazt.eld.fw fwVar;
        Map<String, com.byazt.eld.fw> map = this.x;
        if (map == null || map.size() == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        if (k.aj().optInt("filter_download_url_key", 0) == 1) {
            fwVar = this.x.get(com.byazt.eld.uc.pr().pr(str));
        } else {
            fwVar = this.x.get(str);
        }
        if (fwVar instanceof com.byazt.eld.c) {
            return (com.byazt.eld.c) fwVar;
        }
        return null;
    }

    private synchronized void hw(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (this.hn.size() <= 0) {
            hn(context, i, downloadStatusChangeListener, downloadModel);
            return;
        }
        com.byazt.eld.fw fwVarRemove = this.hn.remove(0);
        fwVarRemove.hw(context).hw(i, downloadStatusChangeListener).hw(downloadModel).pr();
        this.x.put(downloadModel.getDownloadUrl(), fwVarRemove);
    }

    private synchronized void pr(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (this.hn.size() <= 0) {
            hw(context, i, downloadStatusChangeListener, downloadModel, str);
            return;
        }
        com.byazt.eld.fw fwVarRemove = this.hn.remove(0);
        fwVarRemove.hw(context).hw(i, downloadStatusChangeListener).hw(downloadModel).pr(str).pr();
        this.x.put(str, fwVarRemove);
        com.byazt.eld.uc.pr().pr(str, downloadModel.getDownloadUrl());
    }

    private void hn(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null) {
            return;
        }
        com.byazt.eld.c cVar = new com.byazt.eld.c();
        cVar.hw(context).hw(i, downloadStatusChangeListener).hw(downloadModel).pr();
        this.x.put(downloadModel.getDownloadUrl(), cVar);
    }

    private void hw(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (downloadModel == null) {
            return;
        }
        com.byazt.eld.c cVar = new com.byazt.eld.c();
        cVar.hw(context).hw(i, downloadStatusChangeListener).hw(downloadModel).pr(str).pr();
        this.x.put(str, cVar);
        com.byazt.eld.uc.pr().pr(str, downloadModel.getDownloadUrl());
    }

    public void pr(String str, int i) {
        com.byazt.eld.fw fwVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = k.aj().optInt("filter_download_url_key", 0) == 1;
        String strPr = com.byazt.eld.uc.pr().pr(str);
        if (z && !TextUtils.isEmpty(strPr)) {
            fwVar = this.x.get(strPr);
        } else {
            fwVar = this.x.get(str);
        }
        if (fwVar == null) {
            return;
        }
        if (fwVar.pr(i)) {
            this.hn.add(fwVar);
            if (z && !TextUtils.isEmpty(strPr)) {
                this.x.remove(strPr);
                com.byazt.eld.uc.pr().hw(strPr);
            } else {
                this.x.remove(str);
            }
        }
        hn();
    }

    public void pr(String str, boolean z) {
        com.byazt.eld.fw fwVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = k.aj().optInt("filter_download_url_key", 0) == 1;
        String strPr = com.byazt.eld.uc.pr().pr(str);
        if (z2 && !TextUtils.isEmpty(strPr)) {
            fwVar = this.x.get(strPr);
        } else {
            fwVar = this.x.get(str);
        }
        if (fwVar != null) {
            fwVar.pr(z);
        }
    }

    public void pr(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        pr(str, j, i, downloadEventConfig, downloadController, null, null);
    }

    public void pr(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        pr(str, j, i, downloadEventConfig, downloadController, null, iDownloadButtonClickListener);
    }

    public void pr(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.byazt.eld.fw fwVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = k.aj().optInt("filter_download_url_key", 0) == 1;
        String strPr = com.byazt.eld.uc.pr().pr(str);
        if (z && !TextUtils.isEmpty(strPr)) {
            fwVar = this.x.get(strPr);
        } else {
            fwVar = this.x.get(str);
        }
        if (fwVar != null) {
            fwVar.pr(j).hw(downloadEventConfig).hw(downloadController).pr(onItemClickListener).pr(iDownloadButtonClickListener).hw(i);
        }
    }

    public void pr(com.byazt.mgh.pr prVar) {
        if (prVar != null) {
            if (com.byazt.ew.pr.hn().hw("fix_listener_oom", false)) {
                this.c.add(new SoftReference(prVar));
            } else {
                this.c.add(prVar);
            }
        }
    }

    private void hn() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.uc < 300000) {
            return;
        }
        this.uc = jCurrentTimeMillis;
        if (!this.hn.isEmpty()) {
            x();
        }
    }

    private void x() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.byazt.eld.fw fwVar : this.hn) {
            if (!fwVar.hw() && jCurrentTimeMillis - fwVar.x() > 300000) {
                fwVar.zo();
                arrayList.add(fwVar);
            }
        }
        if (!arrayList.isEmpty()) {
            this.hn.removeAll(arrayList);
        }
    }

    public void pr(final DownloadModel downloadModel, final DownloadController downloadController, final DownloadEventConfig downloadEventConfig) {
        this.hw.post(new Runnable() { // from class: com.byazt.cvl.zo.1
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : zo.this.c) {
                    if (!(obj instanceof com.byazt.mgh.pr) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.byazt.mgh.pr) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void pr(final DownloadInfo downloadInfo, final BaseException baseException, final String str) {
        this.hw.post(new Runnable() { // from class: com.byazt.cvl.zo.2
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : zo.this.c) {
                    if (!(obj instanceof com.byazt.mgh.pr) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.byazt.mgh.pr) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void pr(final DownloadInfo downloadInfo, final String str) {
        this.hw.post(new Runnable() { // from class: com.byazt.cvl.zo.3
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : zo.this.c) {
                    if (!(obj instanceof com.byazt.mgh.pr) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.byazt.mgh.pr) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void hw(final DownloadInfo downloadInfo, final String str) {
        this.hw.post(new Runnable() { // from class: com.byazt.cvl.zo.4
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : zo.this.c) {
                    if (obj instanceof com.byazt.mgh.pr) {
                        ((com.byazt.mgh.pr) obj).pr(downloadInfo, str);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.byazt.mgh.pr) {
                            ((com.byazt.mgh.pr) softReference.get()).pr(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public void pr(final DownloadInfo downloadInfo) {
        this.hw.post(new Runnable() { // from class: com.byazt.cvl.zo.5
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : zo.this.c) {
                    if (!(obj instanceof com.byazt.mgh.pr) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.byazt.mgh.pr) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public Handler hw() {
        return this.hw;
    }
}
