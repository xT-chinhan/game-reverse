package com.byazt.ta;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.byazt.je.IDownloadFileUriProvider;
import com.byazt.je.IDownloadInterceptor;
import com.byazt.je.IDownloadListener;
import com.byazt.je.a;
import com.byazt.je.ae;
import com.byazt.je.cd;
import com.byazt.je.cy;
import com.byazt.je.d;
import com.byazt.je.f;
import com.byazt.je.h;
import com.byazt.je.hd;
import com.byazt.je.hu;
import com.byazt.je.j;
import com.byazt.je.k;
import com.byazt.je.lh;
import com.byazt.je.ln;
import com.byazt.je.m;
import com.byazt.je.oa;
import com.byazt.je.ou;
import com.byazt.je.py;
import com.byazt.je.sz;
import com.byazt.je.um;
import com.byazt.je.wm;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import com.byazt.wm.DownloadTask;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 21})
public class x {
    public static Handler n = new Handler(Looper.getMainLooper());

    public static com.byazt.wm.n n(final DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        return new com.byazt.wm.n.AbstractBinderC0387n() { // from class: com.byazt.ta.x.1
            @Override // com.byazt.wm.n
            public DownloadInfo n() throws RemoteException {
                return downloadTask.getDownloadInfo();
            }

            @Override // com.byazt.wm.n
            public com.byazt.je.l qg() throws RemoteException {
                return x.n(downloadTask.getChunkStrategy());
            }

            @Override // com.byazt.wm.n
            public com.byazt.je.rv qg(int i) throws RemoteException {
                return x.n(downloadTask.getSingleDownloadListener(w.l(i)), i != com.byazt.sk.w.SUB.ordinal());
            }

            @Override // com.byazt.wm.n
            public int n(int i) throws RemoteException {
                return downloadTask.getDownloadListenerSize(w.l(i));
            }

            @Override // com.byazt.wm.n
            public com.byazt.je.rv n(int i, int i2) throws RemoteException {
                return x.n(downloadTask.getDownloadListenerByIndex(w.l(i), i2), i != com.byazt.sk.w.SUB.ordinal());
            }

            @Override // com.byazt.wm.n
            public hu s() throws RemoteException {
                return x.n(downloadTask.getNotificationEventListener());
            }

            @Override // com.byazt.wm.n
            public ln q() throws RemoteException {
                return x.n(downloadTask.getNotificationClickCallback());
            }

            @Override // com.byazt.wm.n
            public com.byazt.je.fs l() throws RemoteException {
                return x.n(downloadTask.getInterceptor());
            }

            @Override // com.byazt.wm.n
            public com.byazt.je.w w() throws RemoteException {
                return x.n(downloadTask.getDepend());
            }

            @Override // com.byazt.wm.n
            public com.byazt.je.tj tj() throws RemoteException {
                return x.n(downloadTask.getMonitorDepend());
            }

            @Override // com.byazt.wm.n
            public py x() throws RemoteException {
                return x.n(downloadTask.getForbiddenHandler());
            }

            @Override // com.byazt.wm.n
            public j fs() throws RemoteException {
                return x.n(downloadTask.getRetryDelayTimeCalculator());
            }

            @Override // com.byazt.wm.n
            public cy rv() throws RemoteException {
                return x.n(downloadTask.getDiskSpaceHandler());
            }

            @Override // com.byazt.wm.n
            public com.byazt.je.x cp() throws RemoteException {
                return x.n(downloadTask.getFileUriProvider());
            }

            @Override // com.byazt.wm.n
            public int d() throws RemoteException {
                return downloadTask.getDownloadCompleteHandlers().size();
            }

            @Override // com.byazt.wm.n
            public d s(int i) throws RemoteException {
                return x.n(downloadTask.getDownloadCompleteHandlerByIndex(i));
            }
        };
    }

    public static com.byazt.je.rv n(final IDownloadListener iDownloadListener, final boolean z) {
        if (iDownloadListener == null) {
            return null;
        }
        return new com.byazt.je.rv.n() { // from class: com.byazt.ta.x.12
            @Override // com.byazt.je.rv
            public int n() throws RemoteException {
                return iDownloadListener.hashCode();
            }

            @Override // com.byazt.je.rv
            public void n(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    x.n.post(new Runnable() { // from class: com.byazt.ta.x.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onPrepare(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onPrepare(downloadInfo);
                }
            }

            @Override // com.byazt.je.rv
            public void qg(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    x.n.post(new Runnable() { // from class: com.byazt.ta.x.12.5
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onStart(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onStart(downloadInfo);
                }
            }

            @Override // com.byazt.je.rv
            public void s(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    x.n.post(new Runnable() { // from class: com.byazt.ta.x.12.6
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onProgress(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onProgress(downloadInfo);
                }
            }

            @Override // com.byazt.je.rv
            public void q(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    x.n.post(new Runnable() { // from class: com.byazt.ta.x.12.7
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onPause(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onPause(downloadInfo);
                }
            }

            @Override // com.byazt.je.rv
            public void l(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    x.n.post(new Runnable() { // from class: com.byazt.ta.x.12.8
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onSuccessed(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onSuccessed(downloadInfo);
                }
            }

            @Override // com.byazt.je.rv
            public void n(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    x.n.post(new Runnable() { // from class: com.byazt.ta.x.12.9
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFailed(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onFailed(downloadInfo, baseException);
                }
            }

            @Override // com.byazt.je.rv
            public void w(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    x.n.post(new Runnable() { // from class: com.byazt.ta.x.12.10
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onCanceled(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onCanceled(downloadInfo);
                }
            }

            @Override // com.byazt.je.rv
            public void x(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    x.n.post(new Runnable() { // from class: com.byazt.ta.x.12.11
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFirstStart(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onFirstStart(downloadInfo);
                }
            }

            @Override // com.byazt.je.rv
            public void fs(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    x.n.post(new Runnable() { // from class: com.byazt.ta.x.12.12
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFirstSuccess(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onFirstSuccess(downloadInfo);
                }
            }

            @Override // com.byazt.je.rv
            public void qg(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    x.n.post(new Runnable() { // from class: com.byazt.ta.x.12.2
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onRetry(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onRetry(downloadInfo, baseException);
                }
            }

            @Override // com.byazt.je.rv
            public void s(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    x.n.post(new Runnable() { // from class: com.byazt.ta.x.12.3
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onRetryDelay(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onRetryDelay(downloadInfo, baseException);
                }
            }

            @Override // com.byazt.je.rv
            public void rv(final DownloadInfo downloadInfo) throws RemoteException {
                IDownloadListener iDownloadListener2 = iDownloadListener;
                if (iDownloadListener2 instanceof um) {
                    if (z) {
                        x.n.post(new Runnable() { // from class: com.byazt.ta.x.12.4
                            @Override // java.lang.Runnable
                            public void run() {
                                ((um) iDownloadListener).n(downloadInfo);
                            }
                        });
                    } else {
                        ((um) iDownloadListener2).n(downloadInfo);
                    }
                }
            }
        };
    }

    public static hu n(final h hVar) {
        if (hVar == null) {
            return null;
        }
        return new hu.n() { // from class: com.byazt.ta.x.23
            @Override // com.byazt.je.hu
            public void n(int i, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                hVar.n(i, downloadInfo, str, str2);
            }

            @Override // com.byazt.je.hu
            public boolean n(boolean z) throws RemoteException {
                return hVar.n(z);
            }

            @Override // com.byazt.je.hu
            public String n() throws RemoteException {
                return hVar.n();
            }
        };
    }

    public static ln n(final lh lhVar) {
        if (lhVar == null) {
            return null;
        }
        return new ln.n() { // from class: com.byazt.ta.x.26
            @Override // com.byazt.je.ln
            public boolean n(DownloadInfo downloadInfo) throws RemoteException {
                return lhVar.n(downloadInfo);
            }

            @Override // com.byazt.je.ln
            public boolean qg(DownloadInfo downloadInfo) throws RemoteException {
                return lhVar.qg(downloadInfo);
            }

            @Override // com.byazt.je.ln
            public boolean s(DownloadInfo downloadInfo) throws RemoteException {
                return lhVar.s(downloadInfo);
            }
        };
    }

    public static j n(final com.byazt.xv.um umVar) {
        if (umVar == null) {
            return null;
        }
        return new j.n() { // from class: com.byazt.ta.x.27
            @Override // com.byazt.je.j
            public long n(int i, int i2) throws RemoteException {
                return umVar.n(i, i2);
            }
        };
    }

    public static py n(final wm wmVar) {
        if (wmVar == null) {
            return null;
        }
        return new py.n() { // from class: com.byazt.ta.x.28
            @Override // com.byazt.je.py
            public boolean n(a aVar) throws RemoteException {
                return wmVar.n(x.n(aVar));
            }
        };
    }

    public static com.byazt.je.x n(final IDownloadFileUriProvider iDownloadFileUriProvider) {
        if (iDownloadFileUriProvider == null) {
            return null;
        }
        return new com.byazt.je.x.n() { // from class: com.byazt.ta.x.29
            @Override // com.byazt.je.x
            public Uri n(String str, String str2) throws RemoteException {
                return iDownloadFileUriProvider.getUriForFile(str, str2);
            }
        };
    }

    public static ou n(final a aVar) {
        if (aVar == null) {
            return null;
        }
        return new ou() { // from class: com.byazt.ta.x.30
            @Override // com.byazt.je.ou
            public void n(List<String> list) {
                try {
                    aVar.n(list);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.byazt.je.ou
            public boolean n() {
                try {
                    return aVar.n();
                } catch (RemoteException unused) {
                    return false;
                }
            }
        };
    }

    public static cy n(final cd cdVar) {
        if (cdVar == null) {
            return null;
        }
        return new cy.n() { // from class: com.byazt.ta.x.31
            @Override // com.byazt.je.cy
            public boolean n(long j, long j2, k kVar) throws RemoteException {
                return cdVar.n(j, j2, x.n(kVar));
            }
        };
    }

    public static hd n(final k kVar) {
        if (kVar == null) {
            return null;
        }
        return new hd() { // from class: com.byazt.ta.x.2
            @Override // com.byazt.je.hd
            public void n() {
                try {
                    kVar.n();
                } catch (RemoteException unused) {
                }
            }
        };
    }

    public static com.byazt.je.w n(final sz szVar) {
        if (szVar == null) {
            return null;
        }
        return new com.byazt.je.w.n() { // from class: com.byazt.ta.x.3
            @Override // com.byazt.je.w
            public void n(DownloadInfo downloadInfo, BaseException baseException, int i) throws RemoteException {
                szVar.n(downloadInfo, baseException, i);
            }
        };
    }

    public static com.byazt.je.tj n(final m mVar) {
        if (mVar == null) {
            return null;
        }
        return new com.byazt.je.tj.n() { // from class: com.byazt.ta.x.4
            @Override // com.byazt.je.tj
            public void n(String str) throws RemoteException {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    mVar.n(new JSONObject(str));
                } catch (JSONException unused) {
                }
            }

            @Override // com.byazt.je.tj
            public String n() throws RemoteException {
                return mVar.qg();
            }

            @Override // com.byazt.je.tj
            public int[] qg() throws RemoteException {
                m mVar2 = mVar;
                if (mVar2 instanceof com.byazt.je.s) {
                    return ((com.byazt.je.s) mVar2).n();
                }
                return null;
            }
        };
    }

    public static com.byazt.je.l n(final com.byazt.xv.fs fsVar) {
        if (fsVar == null) {
            return null;
        }
        return new com.byazt.je.l.n() { // from class: com.byazt.ta.x.5
            @Override // com.byazt.je.l
            public int n(long j) throws RemoteException {
                return fsVar.n(j);
            }
        };
    }

    public static com.byazt.je.fs n(final IDownloadInterceptor iDownloadInterceptor) {
        if (iDownloadInterceptor == null) {
            return null;
        }
        return new com.byazt.je.fs.n() { // from class: com.byazt.ta.x.6
            @Override // com.byazt.je.fs
            public boolean n() throws RemoteException {
                return iDownloadInterceptor.intercepte();
            }
        };
    }

    public static DownloadTask n(com.byazt.wm.n nVar) {
        if (nVar == null) {
            return null;
        }
        try {
            DownloadTask downloadTask = new DownloadTask(nVar.n());
            downloadTask.chunkStategy(n(nVar.qg())).notificationEventListener(n(nVar.s())).interceptor(n(nVar.l())).depend(n(nVar.w())).monitorDepend(n(nVar.tj())).forbiddenHandler(n(nVar.x())).diskSpaceHandler(n(nVar.rv())).fileUriProvider(n(nVar.cp())).notificationClickCallback(n(nVar.q())).retryDelayTimeCalculator(n(nVar.fs()));
            com.byazt.je.rv rvVarQg = nVar.qg(com.byazt.sk.w.MAIN.ordinal());
            if (rvVarQg != null) {
                downloadTask.mainThreadListenerWithHashCode(rvVarQg.hashCode(), n(rvVarQg));
            }
            com.byazt.je.rv rvVarQg2 = nVar.qg(com.byazt.sk.w.SUB.ordinal());
            if (rvVarQg2 != null) {
                downloadTask.subThreadListenerWithHashCode(rvVarQg2.hashCode(), n(rvVarQg2));
            }
            com.byazt.je.rv rvVarQg3 = nVar.qg(com.byazt.sk.w.NOTIFICATION.ordinal());
            if (rvVarQg3 != null) {
                downloadTask.notificationListenerWithHashCode(rvVarQg3.hashCode(), n(rvVarQg3));
            }
            n(downloadTask, nVar, com.byazt.sk.w.MAIN);
            n(downloadTask, nVar, com.byazt.sk.w.SUB);
            n(downloadTask, nVar, com.byazt.sk.w.NOTIFICATION);
            n(downloadTask, nVar);
            return downloadTask;
        } catch (RemoteException unused) {
            return null;
        }
    }

    private static void n(DownloadTask downloadTask, com.byazt.wm.n nVar, com.byazt.sk.w wVar) throws RemoteException {
        SparseArray<IDownloadListener> sparseArray = new SparseArray<>();
        for (int i = 0; i < nVar.n(wVar.ordinal()); i++) {
            com.byazt.je.rv rvVarN = nVar.n(wVar.ordinal(), i);
            if (rvVarN != null) {
                sparseArray.put(rvVarN.n(), n(rvVarN));
            }
        }
        downloadTask.setDownloadListeners(sparseArray, wVar);
    }

    private static void n(DownloadTask downloadTask, com.byazt.wm.n nVar) throws RemoteException {
        for (int i = 0; i < nVar.d(); i++) {
            d dVarS = nVar.s(i);
            if (dVarS != null) {
                downloadTask.addDownloadCompleteHandler(n(dVarS));
            }
        }
    }

    public static h n(final hu huVar) {
        if (huVar == null) {
            return null;
        }
        return new h() { // from class: com.byazt.ta.x.7
            @Override // com.byazt.je.h
            public void n(int i, DownloadInfo downloadInfo, String str, String str2) {
                try {
                    huVar.n(i, downloadInfo, str, str2);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.byazt.je.h
            public boolean n(boolean z) {
                try {
                    return huVar.n(z);
                } catch (RemoteException unused) {
                    return false;
                }
            }

            @Override // com.byazt.je.h
            public String n() {
                try {
                    return huVar.n();
                } catch (RemoteException unused) {
                    return null;
                }
            }
        };
    }

    public static oa n(final d dVar) {
        if (dVar == null) {
            return null;
        }
        return new oa() { // from class: com.byazt.ta.x.8
            @Override // com.byazt.je.oa
            public void n(DownloadInfo downloadInfo) throws BaseException {
                try {
                    dVar.n(downloadInfo);
                } catch (RemoteException e) {
                    throw new BaseException(PointerIconCompat.TYPE_TEXT, e);
                }
            }

            @Override // com.byazt.je.oa
            public boolean qg(DownloadInfo downloadInfo) {
                try {
                    return dVar.qg(downloadInfo);
                } catch (RemoteException unused) {
                    return false;
                }
            }
        };
    }

    public static d n(final oa oaVar) {
        if (oaVar == null) {
            return null;
        }
        return new d.n() { // from class: com.byazt.ta.x.9
            @Override // com.byazt.je.d
            public void n(DownloadInfo downloadInfo) throws RemoteException {
                try {
                    oaVar.n(downloadInfo);
                } catch (BaseException e) {
                    throw new IllegalArgumentException(e);
                }
            }

            @Override // com.byazt.je.d
            public boolean qg(DownloadInfo downloadInfo) throws RemoteException {
                return oaVar.qg(downloadInfo);
            }
        };
    }

    public static lh n(final ln lnVar) {
        if (lnVar == null) {
            return null;
        }
        return new lh() { // from class: com.byazt.ta.x.10
            @Override // com.byazt.je.lh
            public boolean n(DownloadInfo downloadInfo) {
                try {
                    return lnVar.n(downloadInfo);
                } catch (RemoteException unused) {
                    return false;
                }
            }

            @Override // com.byazt.je.lh
            public boolean qg(DownloadInfo downloadInfo) {
                try {
                    return lnVar.qg(downloadInfo);
                } catch (RemoteException unused) {
                    return false;
                }
            }

            @Override // com.byazt.je.lh
            public boolean s(DownloadInfo downloadInfo) {
                try {
                    return lnVar.s(downloadInfo);
                } catch (RemoteException unused) {
                    return false;
                }
            }
        };
    }

    public static com.byazt.xv.fs n(final com.byazt.je.l lVar) {
        if (lVar == null) {
            return null;
        }
        return new com.byazt.xv.fs() { // from class: com.byazt.ta.x.11
            @Override // com.byazt.xv.fs
            public int n(long j) {
                try {
                    return lVar.n(j);
                } catch (RemoteException unused) {
                    return 0;
                }
            }
        };
    }

    public static sz n(final com.byazt.je.w wVar) {
        if (wVar == null) {
            return null;
        }
        return new sz() { // from class: com.byazt.ta.x.13
            @Override // com.byazt.je.sz
            public void n(DownloadInfo downloadInfo, BaseException baseException, int i) {
                if (downloadInfo == null) {
                    return;
                }
                try {
                    wVar.n(downloadInfo, baseException, i);
                } catch (RemoteException unused) {
                }
            }
        };
    }

    public static m n(final com.byazt.je.tj tjVar) {
        if (tjVar == null) {
            return null;
        }
        return new com.byazt.je.s() { // from class: com.byazt.ta.x.14
            @Override // com.byazt.je.m
            public void n(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                try {
                    tjVar.n(jSONObject.toString());
                } catch (RemoteException unused) {
                }
            }

            @Override // com.byazt.je.m
            public String qg() {
                try {
                    return tjVar.n();
                } catch (RemoteException unused) {
                    return "";
                }
            }

            @Override // com.byazt.je.s
            public int[] n() {
                try {
                    return tjVar.qg();
                } catch (RemoteException unused) {
                    return null;
                }
            }
        };
    }

    public static wm n(final py pyVar) {
        if (pyVar == null) {
            return null;
        }
        return new wm() { // from class: com.byazt.ta.x.15
            @Override // com.byazt.je.wm
            public boolean n(ou ouVar) {
                try {
                    return pyVar.n(x.n(ouVar));
                } catch (RemoteException unused) {
                    return false;
                }
            }
        };
    }

    public static a n(final ou ouVar) {
        if (ouVar == null) {
            return null;
        }
        return new a.n() { // from class: com.byazt.ta.x.16
            @Override // com.byazt.je.a
            public void n(List<String> list) {
                ouVar.n(list);
            }

            @Override // com.byazt.je.a
            public boolean n() {
                return ouVar.n();
            }
        };
    }

    public static ae n(final f fVar) {
        if (fVar == null) {
            return null;
        }
        return new ae.n() { // from class: com.byazt.ta.x.17
            @Override // com.byazt.je.ae
            public void n(int i, int i2) {
                fVar.n(i, i2);
            }
        };
    }

    public static f n(final ae aeVar) {
        if (aeVar == null) {
            return null;
        }
        return new f() { // from class: com.byazt.ta.x.18
            @Override // com.byazt.je.f
            public void n(int i, int i2) {
                try {
                    aeVar.n(i, i2);
                } catch (RemoteException unused) {
                }
            }
        };
    }

    public static cd n(final cy cyVar) {
        if (cyVar == null) {
            return null;
        }
        return new cd() { // from class: com.byazt.ta.x.19
            @Override // com.byazt.je.cd
            public boolean n(long j, long j2, hd hdVar) {
                try {
                    return cyVar.n(j, j2, x.n(hdVar));
                } catch (RemoteException unused) {
                    return false;
                }
            }
        };
    }

    public static k n(final hd hdVar) {
        if (hdVar == null) {
            return null;
        }
        return new k.n() { // from class: com.byazt.ta.x.20
            @Override // com.byazt.je.k
            public void n() throws RemoteException {
                hdVar.n();
            }
        };
    }

    public static com.byazt.xv.um n(final j jVar) {
        if (jVar == null) {
            return null;
        }
        return new com.byazt.xv.um() { // from class: com.byazt.ta.x.21
            @Override // com.byazt.xv.um
            public long n(int i, int i2) {
                try {
                    return jVar.n(i, i2);
                } catch (RemoteException unused) {
                    return 0L;
                }
            }
        };
    }

    public static IDownloadInterceptor n(final com.byazt.je.fs fsVar) {
        if (fsVar == null) {
            return null;
        }
        return new IDownloadInterceptor() { // from class: com.byazt.ta.x.22
            @Override // com.byazt.je.IDownloadInterceptor
            public boolean intercepte() {
                try {
                    return fsVar.n();
                } catch (RemoteException unused) {
                    return false;
                }
            }
        };
    }

    public static IDownloadFileUriProvider n(final com.byazt.je.x xVar) {
        if (xVar == null) {
            return null;
        }
        return new IDownloadFileUriProvider() { // from class: com.byazt.ta.x.24
            @Override // com.byazt.je.IDownloadFileUriProvider
            public Uri getUriForFile(String str, String str2) {
                try {
                    return xVar.n(str, str2);
                } catch (RemoteException unused) {
                    return null;
                }
            }
        };
    }

    public static IDownloadListener n(final com.byazt.je.rv rvVar) {
        if (rvVar == null) {
            return null;
        }
        return new um() { // from class: com.byazt.ta.x.25
            @Override // com.byazt.je.um
            public void n(DownloadInfo downloadInfo) {
                try {
                    rvVar.rv(downloadInfo);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.byazt.je.IDownloadListener
            public void onPrepare(DownloadInfo downloadInfo) {
                try {
                    rvVar.n(downloadInfo);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.byazt.je.IDownloadListener
            public void onStart(DownloadInfo downloadInfo) {
                try {
                    rvVar.qg(downloadInfo);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.byazt.je.IDownloadListener
            public void onProgress(DownloadInfo downloadInfo) {
                try {
                    rvVar.s(downloadInfo);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.byazt.je.IDownloadListener
            public void onPause(DownloadInfo downloadInfo) {
                try {
                    rvVar.q(downloadInfo);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.byazt.je.IDownloadListener
            public void onSuccessed(DownloadInfo downloadInfo) {
                try {
                    rvVar.l(downloadInfo);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.byazt.je.IDownloadListener
            public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    rvVar.n(downloadInfo, baseException);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.byazt.je.IDownloadListener
            public void onCanceled(DownloadInfo downloadInfo) {
                try {
                    rvVar.w(downloadInfo);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.byazt.je.IDownloadListener
            public void onFirstStart(DownloadInfo downloadInfo) {
                try {
                    rvVar.x(downloadInfo);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.byazt.je.IDownloadListener
            public void onFirstSuccess(DownloadInfo downloadInfo) {
                try {
                    rvVar.fs(downloadInfo);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.byazt.je.IDownloadListener
            public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    rvVar.qg(downloadInfo, baseException);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.byazt.je.IDownloadListener
            public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    rvVar.s(downloadInfo, baseException);
                } catch (RemoteException unused) {
                }
            }
        };
    }
}
