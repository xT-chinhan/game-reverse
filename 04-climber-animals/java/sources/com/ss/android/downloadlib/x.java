package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class x {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile x f4520ms;
    private long c;
    private final List<com.ss.android.downloadlib.addownload.ab> ah = new CopyOnWriteArrayList();
    private final Map<String, com.ss.android.downloadlib.addownload.ab> d = new ConcurrentHashMap();
    private final CopyOnWriteArrayList<Object> ka = new CopyOnWriteArrayList<>();
    private final Handler xr = new Handler(Looper.getMainLooper());

    private x() {
    }

    public static x ms() {
        if (f4520ms == null) {
            synchronized (x.class) {
                if (f4520ms == null) {
                    f4520ms = new x();
                }
            }
        }
        return f4520ms;
    }

    public void ms(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        com.ss.android.downloadlib.addownload.ab abVar;
        if (downloadModel == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return;
        }
        boolean z = hi.ny().optInt("filter_download_url_key", 0) == 1;
        String strMs = com.ss.android.downloadlib.addownload.c.ms().ms(downloadModel.getDownloadUrl());
        if (z && !TextUtils.isEmpty(strMs)) {
            abVar = this.d.get(strMs);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel.getTaskKey())) {
                    adDownloadModel.setTaskKey(strMs);
                }
            }
        } else {
            abVar = this.d.get(downloadModel.getDownloadUrl());
        }
        if (abVar != null) {
            abVar.xr(context).xr(i, downloadStatusChangeListener).xr(downloadModel).ms();
            return;
        }
        if (this.ah.isEmpty()) {
            if (z) {
                if (!TextUtils.isEmpty(strMs)) {
                    xr(context, i, downloadStatusChangeListener, downloadModel, strMs);
                    return;
                }
                String strMs2 = com.ss.android.downloadlib.addownload.c.ms().ms(downloadModel);
                if (!TextUtils.isEmpty(strMs2)) {
                    xr(context, i, downloadStatusChangeListener, downloadModel, strMs2);
                    if (downloadModel instanceof AdDownloadModel) {
                        AdDownloadModel adDownloadModel2 = (AdDownloadModel) downloadModel;
                        if (TextUtils.isEmpty(adDownloadModel2.getTaskKey())) {
                            adDownloadModel2.setTaskKey(strMs2);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            ah(context, i, downloadStatusChangeListener, downloadModel);
            return;
        }
        if (z) {
            if (!TextUtils.isEmpty(strMs)) {
                ms(context, i, downloadStatusChangeListener, downloadModel, strMs);
                return;
            }
            String strMs3 = com.ss.android.downloadlib.addownload.c.ms().ms(downloadModel);
            if (TextUtils.isEmpty(strMs3)) {
                xr(context, i, downloadStatusChangeListener, downloadModel);
                return;
            }
            ms(context, i, downloadStatusChangeListener, downloadModel, strMs3);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel3 = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel3.getTaskKey())) {
                    adDownloadModel3.setTaskKey(strMs3);
                    return;
                }
                return;
            }
            return;
        }
        xr(context, i, downloadStatusChangeListener, downloadModel);
    }

    public com.ss.android.downloadlib.addownload.ka ms(String str) {
        com.ss.android.downloadlib.addownload.ab abVar;
        Map<String, com.ss.android.downloadlib.addownload.ab> map = this.d;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            if (hi.ny().optInt("filter_download_url_key", 0) == 1) {
                abVar = this.d.get(com.ss.android.downloadlib.addownload.c.ms().ms(str));
            } else {
                abVar = this.d.get(str);
            }
            if (abVar instanceof com.ss.android.downloadlib.addownload.ka) {
                return (com.ss.android.downloadlib.addownload.ka) abVar;
            }
        }
        return null;
    }

    private synchronized void xr(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (this.ah.size() <= 0) {
            ah(context, i, downloadStatusChangeListener, downloadModel);
            return;
        }
        com.ss.android.downloadlib.addownload.ab abVarRemove = this.ah.remove(0);
        abVarRemove.xr(context).xr(i, downloadStatusChangeListener).xr(downloadModel).ms();
        this.d.put(downloadModel.getDownloadUrl(), abVarRemove);
    }

    private synchronized void ms(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (this.ah.size() <= 0) {
            xr(context, i, downloadStatusChangeListener, downloadModel, str);
            return;
        }
        com.ss.android.downloadlib.addownload.ab abVarRemove = this.ah.remove(0);
        abVarRemove.xr(context).xr(i, downloadStatusChangeListener).xr(downloadModel).ms(str).ms();
        this.d.put(str, abVarRemove);
        com.ss.android.downloadlib.addownload.c.ms().ms(str, downloadModel.getDownloadUrl());
    }

    private void ah(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.ka kaVar = new com.ss.android.downloadlib.addownload.ka();
        kaVar.xr(context).xr(i, downloadStatusChangeListener).xr(downloadModel).ms();
        this.d.put(downloadModel.getDownloadUrl(), kaVar);
    }

    private void xr(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.ka kaVar = new com.ss.android.downloadlib.addownload.ka();
        kaVar.xr(context).xr(i, downloadStatusChangeListener).xr(downloadModel).ms(str).ms();
        this.d.put(str, kaVar);
        com.ss.android.downloadlib.addownload.c.ms().ms(str, downloadModel.getDownloadUrl());
    }

    public void ms(String str, int i) {
        com.ss.android.downloadlib.addownload.ab abVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = hi.ny().optInt("filter_download_url_key", 0) == 1;
        String strMs = com.ss.android.downloadlib.addownload.c.ms().ms(str);
        if (z && !TextUtils.isEmpty(strMs)) {
            abVar = this.d.get(strMs);
        } else {
            abVar = this.d.get(str);
        }
        if (abVar != null) {
            if (abVar.ms(i)) {
                this.ah.add(abVar);
                if (z && !TextUtils.isEmpty(strMs)) {
                    this.d.remove(strMs);
                    com.ss.android.downloadlib.addownload.c.ms().xr(strMs);
                } else {
                    this.d.remove(str);
                }
            }
            ah();
        }
    }

    public void ms(String str, boolean z) {
        com.ss.android.downloadlib.addownload.ab abVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = hi.ny().optInt("filter_download_url_key", 0) == 1;
        String strMs = com.ss.android.downloadlib.addownload.c.ms().ms(str);
        if (z2 && !TextUtils.isEmpty(strMs)) {
            abVar = this.d.get(strMs);
        } else {
            abVar = this.d.get(str);
        }
        if (abVar != null) {
            abVar.ms(z);
        }
    }

    public void ms(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        ms(str, j, i, downloadEventConfig, downloadController, null, null);
    }

    public void ms(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        ms(str, j, i, downloadEventConfig, downloadController, null, iDownloadButtonClickListener);
    }

    public void ms(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.addownload.ab abVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = hi.ny().optInt("filter_download_url_key", 0) == 1;
        String strMs = com.ss.android.downloadlib.addownload.c.ms().ms(str);
        if (z && !TextUtils.isEmpty(strMs)) {
            abVar = this.d.get(strMs);
        } else {
            abVar = this.d.get(str);
        }
        if (abVar != null) {
            abVar.ms(j).xr(downloadEventConfig).xr(downloadController).ms(onItemClickListener).ms(iDownloadButtonClickListener).xr(i);
        }
    }

    public void ms(com.ss.android.download.api.download.ms.ms msVar) {
        if (msVar != null) {
            if (com.ss.android.socialbase.downloader.ab.ms.ah().xr("fix_listener_oom", false)) {
                this.ka.add(new SoftReference(msVar));
            } else {
                this.ka.add(msVar);
            }
        }
    }

    private void ah() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.c < 300000) {
            return;
        }
        this.c = jCurrentTimeMillis;
        if (this.ah.isEmpty()) {
            return;
        }
        d();
    }

    private void d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.ss.android.downloadlib.addownload.ab abVar : this.ah) {
            if (!abVar.xr() && jCurrentTimeMillis - abVar.d() > 300000) {
                abVar.x();
                arrayList.add(abVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.ah.removeAll(arrayList);
    }

    public void ms(final DownloadModel downloadModel, final DownloadController downloadController, final DownloadEventConfig downloadEventConfig) {
        this.xr.post(new Runnable() { // from class: com.ss.android.downloadlib.x.1
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : x.this.ka) {
                    if (obj instanceof com.ss.android.download.api.download.ms.ms) {
                        ((com.ss.android.download.api.download.ms.ms) obj).ms(downloadModel, downloadController, downloadEventConfig);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.ms.ms) {
                            ((com.ss.android.download.api.download.ms.ms) softReference.get()).ms(downloadModel, downloadController, downloadEventConfig);
                        }
                    }
                }
            }
        });
    }

    public void ms(final DownloadInfo downloadInfo, final BaseException baseException, final String str) {
        this.xr.post(new Runnable() { // from class: com.ss.android.downloadlib.x.2
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : x.this.ka) {
                    if (obj instanceof com.ss.android.download.api.download.ms.ms) {
                        ((com.ss.android.download.api.download.ms.ms) obj).ms(downloadInfo, baseException, str);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.ms.ms) {
                            ((com.ss.android.download.api.download.ms.ms) softReference.get()).ms(downloadInfo, baseException, str);
                        }
                    }
                }
            }
        });
    }

    public void ms(final DownloadInfo downloadInfo, final String str) {
        this.xr.post(new Runnable() { // from class: com.ss.android.downloadlib.x.3
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : x.this.ka) {
                    if (obj instanceof com.ss.android.download.api.download.ms.ms) {
                        ((com.ss.android.download.api.download.ms.ms) obj).ms(downloadInfo, str);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.ms.ms) {
                            ((com.ss.android.download.api.download.ms.ms) softReference.get()).ms(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public void xr(final DownloadInfo downloadInfo, final String str) {
        this.xr.post(new Runnable() { // from class: com.ss.android.downloadlib.x.4
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : x.this.ka) {
                    if (obj instanceof com.ss.android.download.api.download.ms.ms) {
                        ((com.ss.android.download.api.download.ms.ms) obj).xr(downloadInfo, str);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.ms.ms) {
                            ((com.ss.android.download.api.download.ms.ms) softReference.get()).xr(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public void ms(final DownloadInfo downloadInfo) {
        this.xr.post(new Runnable() { // from class: com.ss.android.downloadlib.x.5
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : x.this.ka) {
                    if (obj instanceof com.ss.android.download.api.download.ms.ms) {
                        ((com.ss.android.download.api.download.ms.ms) obj).ms(downloadInfo);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.ms.ms) {
                            ((com.ss.android.download.api.download.ms.ms) softReference.get()).ms(downloadInfo);
                        }
                    }
                }
            }
        });
    }

    public Handler xr() {
        return this.xr;
    }
}
