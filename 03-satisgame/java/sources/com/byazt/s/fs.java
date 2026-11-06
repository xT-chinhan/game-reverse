package com.byazt.s;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.hj.DownloadController;
import com.byazt.hj.DownloadEventConfig;
import com.byazt.hj.DownloadModel;
import com.byazt.hj.DownloadStatusChangeListener;
import com.byazt.ky.IDownloadButtonClickListener;
import com.byazt.ky.OnItemClickListener;
import com.byazt.qx.BaseException;
import com.byazt.ug.d;
import com.byazt.wm.DownloadInfo;
import com.byazt.y.AdDownloadModel;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 8, 101})
public class fs {
    public static volatile fs n;
    public long w;
    public final List<com.byazt.ug.x> s = new CopyOnWriteArrayList();
    public final Map<String, com.byazt.ug.x> q = new ConcurrentHashMap();
    public final CopyOnWriteArrayList<Object> l = new CopyOnWriteArrayList<>();
    public final Handler qg = new Handler(Looper.getMainLooper());

    private fs() {
    }

    public static fs n() {
        if (n == null) {
            synchronized (fs.class) {
                if (n == null) {
                    n = new fs();
                }
            }
        }
        return n;
    }

    public void n(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        com.byazt.ug.x xVar;
        if (downloadModel == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return;
        }
        boolean z = d.rv().optInt("filter_download_url_key", 0) == 1;
        String strN = com.byazt.ug.w.n().n(downloadModel.getDownloadUrl());
        if (z && !TextUtils.isEmpty(strN)) {
            xVar = this.q.get(strN);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel.getTaskKey())) {
                    adDownloadModel.setTaskKey(strN);
                }
            }
        } else {
            xVar = this.q.get(downloadModel.getDownloadUrl());
        }
        if (xVar != null) {
            xVar.qg(context).qg(i, downloadStatusChangeListener).qg(downloadModel).n();
            return;
        }
        if (this.s.isEmpty()) {
            if (z) {
                if (!TextUtils.isEmpty(strN)) {
                    qg(context, i, downloadStatusChangeListener, downloadModel, strN);
                    return;
                }
                String strN2 = com.byazt.ug.w.n().n(downloadModel);
                if (!TextUtils.isEmpty(strN2)) {
                    qg(context, i, downloadStatusChangeListener, downloadModel, strN2);
                    if (downloadModel instanceof AdDownloadModel) {
                        AdDownloadModel adDownloadModel2 = (AdDownloadModel) downloadModel;
                        if (TextUtils.isEmpty(adDownloadModel2.getTaskKey())) {
                            adDownloadModel2.setTaskKey(strN2);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            s(context, i, downloadStatusChangeListener, downloadModel);
            return;
        }
        if (z) {
            if (!TextUtils.isEmpty(strN)) {
                n(context, i, downloadStatusChangeListener, downloadModel, strN);
                return;
            }
            String strN3 = com.byazt.ug.w.n().n(downloadModel);
            if (TextUtils.isEmpty(strN3)) {
                qg(context, i, downloadStatusChangeListener, downloadModel);
                return;
            }
            n(context, i, downloadStatusChangeListener, downloadModel, strN3);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel3 = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel3.getTaskKey())) {
                    adDownloadModel3.setTaskKey(strN3);
                    return;
                }
                return;
            }
            return;
        }
        qg(context, i, downloadStatusChangeListener, downloadModel);
    }

    public com.byazt.ug.l n(String str) {
        com.byazt.ug.x xVar;
        Map<String, com.byazt.ug.x> map = this.q;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            if (d.rv().optInt("filter_download_url_key", 0) == 1) {
                xVar = this.q.get(com.byazt.ug.w.n().n(str));
            } else {
                xVar = this.q.get(str);
            }
            if (xVar instanceof com.byazt.ug.l) {
                return (com.byazt.ug.l) xVar;
            }
        }
        return null;
    }

    private synchronized void qg(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (this.s.size() <= 0) {
            s(context, i, downloadStatusChangeListener, downloadModel);
            return;
        }
        com.byazt.ug.x xVarRemove = this.s.remove(0);
        xVarRemove.qg(context).qg(i, downloadStatusChangeListener).qg(downloadModel).n();
        this.q.put(downloadModel.getDownloadUrl(), xVarRemove);
    }

    private synchronized void n(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (this.s.size() <= 0) {
            qg(context, i, downloadStatusChangeListener, downloadModel, str);
            return;
        }
        com.byazt.ug.x xVarRemove = this.s.remove(0);
        xVarRemove.qg(context).qg(i, downloadStatusChangeListener).qg(downloadModel).n(str).n();
        this.q.put(str, xVarRemove);
        com.byazt.ug.w.n().n(str, downloadModel.getDownloadUrl());
    }

    private void s(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null) {
            return;
        }
        com.byazt.ug.l lVar = new com.byazt.ug.l();
        lVar.qg(context).qg(i, downloadStatusChangeListener).qg(downloadModel).n();
        this.q.put(downloadModel.getDownloadUrl(), lVar);
    }

    private void qg(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (downloadModel == null) {
            return;
        }
        com.byazt.ug.l lVar = new com.byazt.ug.l();
        lVar.qg(context).qg(i, downloadStatusChangeListener).qg(downloadModel).n(str).n();
        this.q.put(str, lVar);
        com.byazt.ug.w.n().n(str, downloadModel.getDownloadUrl());
    }

    public void n(String str, int i) {
        com.byazt.ug.x xVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = d.rv().optInt("filter_download_url_key", 0) == 1;
        String strN = com.byazt.ug.w.n().n(str);
        if (z && !TextUtils.isEmpty(strN)) {
            xVar = this.q.get(strN);
        } else {
            xVar = this.q.get(str);
        }
        if (xVar != null) {
            if (xVar.n(i)) {
                this.s.add(xVar);
                if (z && !TextUtils.isEmpty(strN)) {
                    this.q.remove(strN);
                    com.byazt.ug.w.n().qg(strN);
                } else {
                    this.q.remove(str);
                }
            }
            s();
        }
    }

    public void n(String str, boolean z) {
        com.byazt.ug.x xVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = d.rv().optInt("filter_download_url_key", 0) == 1;
        String strN = com.byazt.ug.w.n().n(str);
        if (z2 && !TextUtils.isEmpty(strN)) {
            xVar = this.q.get(strN);
        } else {
            xVar = this.q.get(str);
        }
        if (xVar != null) {
            xVar.n(z);
        }
    }

    public void n(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        n(str, j, i, downloadEventConfig, downloadController, null, null);
    }

    public void n(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        n(str, j, i, downloadEventConfig, downloadController, null, iDownloadButtonClickListener);
    }

    public void n(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.byazt.ug.x xVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = d.rv().optInt("filter_download_url_key", 0) == 1;
        String strN = com.byazt.ug.w.n().n(str);
        if (z && !TextUtils.isEmpty(strN)) {
            xVar = this.q.get(strN);
        } else {
            xVar = this.q.get(str);
        }
        if (xVar != null) {
            xVar.n(j).qg(downloadEventConfig).qg(downloadController).n(onItemClickListener).n(iDownloadButtonClickListener).qg(i);
        }
    }

    public void n(com.byazt.rn.n nVar) {
        if (nVar != null) {
            if (com.byazt.f.n.s().qg("fix_listener_oom", false)) {
                this.l.add(new SoftReference(nVar));
            } else {
                this.l.add(nVar);
            }
        }
    }

    private void s() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.w < 300000) {
            return;
        }
        this.w = jCurrentTimeMillis;
        if (this.s.isEmpty()) {
            return;
        }
        q();
    }

    private void q() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.byazt.ug.x xVar : this.s) {
            if (!xVar.qg() && jCurrentTimeMillis - xVar.q() > 300000) {
                xVar.fs();
                arrayList.add(xVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.s.removeAll(arrayList);
    }

    public void n(final DownloadModel downloadModel, final DownloadController downloadController, final DownloadEventConfig downloadEventConfig) {
        this.qg.post(new Runnable() { // from class: com.byazt.s.fs.1
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : fs.this.l) {
                    if (!(obj instanceof com.byazt.rn.n) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.byazt.rn.n) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void n(final DownloadInfo downloadInfo, final BaseException baseException, final String str) {
        this.qg.post(new Runnable() { // from class: com.byazt.s.fs.2
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : fs.this.l) {
                    if (!(obj instanceof com.byazt.rn.n) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.byazt.rn.n) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void n(final DownloadInfo downloadInfo, final String str) {
        this.qg.post(new Runnable() { // from class: com.byazt.s.fs.3
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : fs.this.l) {
                    if (!(obj instanceof com.byazt.rn.n) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.byazt.rn.n) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void qg(final DownloadInfo downloadInfo, final String str) {
        this.qg.post(new Runnable() { // from class: com.byazt.s.fs.4
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : fs.this.l) {
                    if (obj instanceof com.byazt.rn.n) {
                        ((com.byazt.rn.n) obj).n(downloadInfo, str);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.byazt.rn.n) {
                            ((com.byazt.rn.n) softReference.get()).n(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public void n(final DownloadInfo downloadInfo) {
        this.qg.post(new Runnable() { // from class: com.byazt.s.fs.5
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : fs.this.l) {
                    if (!(obj instanceof com.byazt.rn.n) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.byazt.rn.n) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public Handler qg() {
        return this.qg;
    }
}
