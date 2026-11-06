package com.ss.android.socialbase.downloader.ny;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ao;
import com.ss.android.socialbase.downloader.depend.b;
import com.ss.android.socialbase.downloader.depend.f;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.nw;
import com.ss.android.socialbase.downloader.depend.of;
import com.ss.android.socialbase.downloader.depend.pc;
import com.ss.android.socialbase.downloader.depend.qv;
import com.ss.android.socialbase.downloader.depend.re;
import com.ss.android.socialbase.downloader.depend.sl;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.depend.u;
import com.ss.android.socialbase.downloader.depend.ub;
import com.ss.android.socialbase.downloader.depend.ul;
import com.ss.android.socialbase.downloader.depend.w;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.depend.yu;
import com.ss.android.socialbase.downloader.depend.zb;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Handler f4744ms = new Handler(Looper.getMainLooper());

    public static com.ss.android.socialbase.downloader.model.ms ms(final DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.model.ms.AbstractBinderC0568ms() { // from class: com.ss.android.socialbase.downloader.ny.ab.1
            @Override // com.ss.android.socialbase.downloader.model.ms
            public DownloadInfo ms() throws RemoteException {
                return downloadTask.getDownloadInfo();
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public com.ss.android.socialbase.downloader.depend.ka xr() throws RemoteException {
                return ab.ms(downloadTask.getChunkStrategy());
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public com.ss.android.socialbase.downloader.depend.ny xr(int i) throws RemoteException {
                return ab.ms(downloadTask.getSingleDownloadListener(c.ka(i)), i != com.ss.android.socialbase.downloader.constants.c.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public int ms(int i) throws RemoteException {
                return downloadTask.getDownloadListenerSize(c.ka(i));
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public com.ss.android.socialbase.downloader.depend.ny ms(int i, int i2) throws RemoteException {
                return ab.ms(downloadTask.getDownloadListenerByIndex(c.ka(i), i2), i != com.ss.android.socialbase.downloader.constants.c.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public w ah() throws RemoteException {
                return ab.ms(downloadTask.getNotificationEventListener());
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public g d() throws RemoteException {
                return ab.ms(downloadTask.getNotificationClickCallback());
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public com.ss.android.socialbase.downloader.depend.x ka() throws RemoteException {
                return ab.ms(downloadTask.getInterceptor());
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public com.ss.android.socialbase.downloader.depend.c c() throws RemoteException {
                return ab.ms(downloadTask.getDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public com.ss.android.socialbase.downloader.depend.ch ch() throws RemoteException {
                return ab.ms(downloadTask.getMonitorDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public nw ab() throws RemoteException {
                return ab.ms(downloadTask.getForbiddenHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public pc x() throws RemoteException {
                return ab.ms(downloadTask.getRetryDelayTimeCalculator());
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public ao ny() throws RemoteException {
                return ab.ms(downloadTask.getDiskSpaceHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public com.ss.android.socialbase.downloader.depend.ab hi() throws RemoteException {
                return ab.ms(downloadTask.getFileUriProvider());
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public int sl() throws RemoteException {
                return downloadTask.getDownloadCompleteHandlers().size();
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public sl ah(int i) throws RemoteException {
                return ab.ms(downloadTask.getDownloadCompleteHandlerByIndex(i));
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.ny ms(final IDownloadListener iDownloadListener, final boolean z) {
        if (iDownloadListener == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.depend.ny.ms() { // from class: com.ss.android.socialbase.downloader.ny.ab.12
            @Override // com.ss.android.socialbase.downloader.depend.ny
            public int ms() throws RemoteException {
                return iDownloadListener.hashCode();
            }

            @Override // com.ss.android.socialbase.downloader.depend.ny
            public void ms(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    ab.f4744ms.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.ny.ab.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onPrepare(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onPrepare(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ny
            public void xr(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    ab.f4744ms.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.ny.ab.12.5
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onStart(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onStart(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ny
            public void ah(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    ab.f4744ms.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.ny.ab.12.6
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onProgress(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onProgress(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ny
            public void d(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    ab.f4744ms.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.ny.ab.12.7
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onPause(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onPause(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ny
            public void ka(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    ab.f4744ms.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.ny.ab.12.8
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onSuccessed(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onSuccessed(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ny
            public void ms(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    ab.f4744ms.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.ny.ab.12.9
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFailed(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onFailed(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ny
            public void c(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    ab.f4744ms.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.ny.ab.12.10
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onCanceled(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onCanceled(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ny
            public void ab(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    ab.f4744ms.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.ny.ab.12.11
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFirstStart(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onFirstStart(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ny
            public void x(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    ab.f4744ms.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.ny.ab.12.12
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFirstSuccess(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onFirstSuccess(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ny
            public void xr(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    ab.f4744ms.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.ny.ab.12.2
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onRetry(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onRetry(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ny
            public void ah(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    ab.f4744ms.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.ny.ab.12.3
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onRetryDelay(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onRetryDelay(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ny
            public void ny(final DownloadInfo downloadInfo) throws RemoteException {
                IDownloadListener iDownloadListener2 = iDownloadListener;
                if (iDownloadListener2 instanceof y) {
                    if (z) {
                        ab.f4744ms.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.ny.ab.12.4
                            @Override // java.lang.Runnable
                            public void run() {
                                ((y) iDownloadListener).ms(downloadInfo);
                            }
                        });
                    } else {
                        ((y) iDownloadListener2).ms(downloadInfo);
                    }
                }
            }
        };
    }

    public static w ms(final yu yuVar) {
        if (yuVar == null) {
            return null;
        }
        return new w.ms() { // from class: com.ss.android.socialbase.downloader.ny.ab.23
            @Override // com.ss.android.socialbase.downloader.depend.w
            public void ms(int i, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                yuVar.ms(i, downloadInfo, str, str2);
            }

            @Override // com.ss.android.socialbase.downloader.depend.w
            public boolean ms(boolean z) throws RemoteException {
                return yuVar.ms(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.w
            public String ms() throws RemoteException {
                return yuVar.ms();
            }
        };
    }

    public static g ms(final of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return new g.ms() { // from class: com.ss.android.socialbase.downloader.ny.ab.26
            @Override // com.ss.android.socialbase.downloader.depend.g
            public boolean ms(DownloadInfo downloadInfo) throws RemoteException {
                return ofVar.ms(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public boolean xr(DownloadInfo downloadInfo) throws RemoteException {
                return ofVar.xr(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public boolean ah(DownloadInfo downloadInfo) throws RemoteException {
                return ofVar.ah(downloadInfo);
            }
        };
    }

    public static pc ms(final com.ss.android.socialbase.downloader.downloader.y yVar) {
        if (yVar == null) {
            return null;
        }
        return new pc.ms() { // from class: com.ss.android.socialbase.downloader.ny.ab.27
            @Override // com.ss.android.socialbase.downloader.depend.pc
            public long ms(int i, int i2) throws RemoteException {
                return yVar.ms(i, i2);
            }
        };
    }

    public static nw ms(final re reVar) {
        if (reVar == null) {
            return null;
        }
        return new nw.ms() { // from class: com.ss.android.socialbase.downloader.ny.ab.28
            @Override // com.ss.android.socialbase.downloader.depend.nw
            public boolean ms(t tVar) throws RemoteException {
                return reVar.ms(ab.ms(tVar));
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.ab ms(final IDownloadFileUriProvider iDownloadFileUriProvider) {
        if (iDownloadFileUriProvider == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.depend.ab.ms() { // from class: com.ss.android.socialbase.downloader.ny.ab.29
            @Override // com.ss.android.socialbase.downloader.depend.ab
            public Uri ms(String str, String str2) throws RemoteException {
                return iDownloadFileUriProvider.getUriForFile(str, str2);
            }
        };
    }

    public static b ms(final t tVar) {
        if (tVar == null) {
            return null;
        }
        return new b() { // from class: com.ss.android.socialbase.downloader.ny.ab.30
            @Override // com.ss.android.socialbase.downloader.depend.b
            public void ms(List<String> list) {
                try {
                    tVar.ms(list);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.b
            public boolean ms() {
                try {
                    return tVar.ms();
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    return false;
                }
            }
        };
    }

    public static ao ms(final qv qvVar) {
        if (qvVar == null) {
            return null;
        }
        return new ao.ms() { // from class: com.ss.android.socialbase.downloader.ny.ab.31
            @Override // com.ss.android.socialbase.downloader.depend.ao
            public boolean ms(long j, long j2, ub ubVar) throws RemoteException {
                return qvVar.ms(j, j2, ab.ms(ubVar));
            }
        };
    }

    public static h ms(final ub ubVar) {
        if (ubVar == null) {
            return null;
        }
        return new h() { // from class: com.ss.android.socialbase.downloader.ny.ab.2
            @Override // com.ss.android.socialbase.downloader.depend.h
            public void ms() {
                try {
                    ubVar.ms();
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.c ms(final u uVar) {
        if (uVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.depend.c.ms() { // from class: com.ss.android.socialbase.downloader.ny.ab.3
            @Override // com.ss.android.socialbase.downloader.depend.c
            public void ms(DownloadInfo downloadInfo, BaseException baseException, int i) throws RemoteException {
                uVar.ms(downloadInfo, baseException, i);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.ch ms(final i iVar) {
        if (iVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.depend.ch.ms() { // from class: com.ss.android.socialbase.downloader.ny.ab.4
            @Override // com.ss.android.socialbase.downloader.depend.ch
            public void ms(String str) throws RemoteException {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    iVar.ms(new JSONObject(str));
                } catch (JSONException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ch
            public String ms() throws RemoteException {
                return iVar.xr();
            }

            @Override // com.ss.android.socialbase.downloader.depend.ch
            public int[] xr() throws RemoteException {
                i iVar2 = iVar;
                if (iVar2 instanceof com.ss.android.socialbase.downloader.depend.ah) {
                    return ((com.ss.android.socialbase.downloader.depend.ah) iVar2).ms();
                }
                return null;
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.ka ms(final com.ss.android.socialbase.downloader.downloader.x xVar) {
        if (xVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.depend.ka.ms() { // from class: com.ss.android.socialbase.downloader.ny.ab.5
            @Override // com.ss.android.socialbase.downloader.depend.ka
            public int ms(long j) throws RemoteException {
                return xVar.ms(j);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.x ms(final IDownloadInterceptor iDownloadInterceptor) {
        if (iDownloadInterceptor == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.depend.x.ms() { // from class: com.ss.android.socialbase.downloader.ny.ab.6
            @Override // com.ss.android.socialbase.downloader.depend.x
            public boolean ms() throws RemoteException {
                return iDownloadInterceptor.intercepte();
            }
        };
    }

    public static DownloadTask ms(com.ss.android.socialbase.downloader.model.ms msVar) {
        if (msVar == null) {
            return null;
        }
        try {
            DownloadTask downloadTask = new DownloadTask(msVar.ms());
            downloadTask.chunkStategy(ms(msVar.xr())).notificationEventListener(ms(msVar.ah())).interceptor(ms(msVar.ka())).depend(ms(msVar.c())).monitorDepend(ms(msVar.ch())).forbiddenHandler(ms(msVar.ab())).diskSpaceHandler(ms(msVar.ny())).fileUriProvider(ms(msVar.hi())).notificationClickCallback(ms(msVar.d())).retryDelayTimeCalculator(ms(msVar.x()));
            com.ss.android.socialbase.downloader.depend.ny nyVarXr = msVar.xr(com.ss.android.socialbase.downloader.constants.c.MAIN.ordinal());
            if (nyVarXr != null) {
                downloadTask.mainThreadListenerWithHashCode(nyVarXr.hashCode(), ms(nyVarXr));
            }
            com.ss.android.socialbase.downloader.depend.ny nyVarXr2 = msVar.xr(com.ss.android.socialbase.downloader.constants.c.SUB.ordinal());
            if (nyVarXr2 != null) {
                downloadTask.subThreadListenerWithHashCode(nyVarXr2.hashCode(), ms(nyVarXr2));
            }
            com.ss.android.socialbase.downloader.depend.ny nyVarXr3 = msVar.xr(com.ss.android.socialbase.downloader.constants.c.NOTIFICATION.ordinal());
            if (nyVarXr3 != null) {
                downloadTask.notificationListenerWithHashCode(nyVarXr3.hashCode(), ms(nyVarXr3));
            }
            ms(downloadTask, msVar, com.ss.android.socialbase.downloader.constants.c.MAIN);
            ms(downloadTask, msVar, com.ss.android.socialbase.downloader.constants.c.SUB);
            ms(downloadTask, msVar, com.ss.android.socialbase.downloader.constants.c.NOTIFICATION);
            ms(downloadTask, msVar);
            return downloadTask;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    private static void ms(DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.ms msVar, com.ss.android.socialbase.downloader.constants.c cVar) throws RemoteException {
        SparseArray<IDownloadListener> sparseArray = new SparseArray<>();
        for (int i = 0; i < msVar.ms(cVar.ordinal()); i++) {
            com.ss.android.socialbase.downloader.depend.ny nyVarMs = msVar.ms(cVar.ordinal(), i);
            if (nyVarMs != null) {
                sparseArray.put(nyVarMs.ms(), ms(nyVarMs));
            }
        }
        downloadTask.setDownloadListeners(sparseArray, cVar);
    }

    private static void ms(DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.ms msVar) throws RemoteException {
        for (int i = 0; i < msVar.sl(); i++) {
            sl slVarAh = msVar.ah(i);
            if (slVarAh != null) {
                downloadTask.addDownloadCompleteHandler(ms(slVarAh));
            }
        }
    }

    public static yu ms(final w wVar) {
        if (wVar == null) {
            return null;
        }
        return new yu() { // from class: com.ss.android.socialbase.downloader.ny.ab.7
            @Override // com.ss.android.socialbase.downloader.depend.yu
            public void ms(int i, DownloadInfo downloadInfo, String str, String str2) {
                try {
                    wVar.ms(i, downloadInfo, str, str2);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.yu
            public boolean ms(boolean z) {
                try {
                    return wVar.ms(z);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.yu
            public String ms() {
                try {
                    return wVar.ms();
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    return null;
                }
            }
        };
    }

    public static zb ms(final sl slVar) {
        if (slVar == null) {
            return null;
        }
        return new zb() { // from class: com.ss.android.socialbase.downloader.ny.ab.8
            @Override // com.ss.android.socialbase.downloader.depend.zb
            public void ms(DownloadInfo downloadInfo) throws BaseException {
                try {
                    slVar.ms(downloadInfo);
                } catch (RemoteException e) {
                    throw new BaseException(PointerIconCompat.TYPE_TEXT, e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.zb
            public boolean xr(DownloadInfo downloadInfo) {
                try {
                    return slVar.xr(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    return false;
                }
            }
        };
    }

    public static sl ms(final zb zbVar) {
        if (zbVar == null) {
            return null;
        }
        return new sl.ms() { // from class: com.ss.android.socialbase.downloader.ny.ab.9
            @Override // com.ss.android.socialbase.downloader.depend.sl
            public void ms(DownloadInfo downloadInfo) throws RemoteException {
                try {
                    zbVar.ms(downloadInfo);
                } catch (BaseException e) {
                    throw new IllegalArgumentException(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.sl
            public boolean xr(DownloadInfo downloadInfo) throws RemoteException {
                return zbVar.xr(downloadInfo);
            }
        };
    }

    public static of ms(final g gVar) {
        if (gVar == null) {
            return null;
        }
        return new of() { // from class: com.ss.android.socialbase.downloader.ny.ab.10
            @Override // com.ss.android.socialbase.downloader.depend.of
            public boolean ms(DownloadInfo downloadInfo) {
                try {
                    return gVar.ms(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.of
            public boolean xr(DownloadInfo downloadInfo) {
                try {
                    return gVar.xr(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.of
            public boolean ah(DownloadInfo downloadInfo) {
                try {
                    return gVar.ah(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    return false;
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.x ms(final com.ss.android.socialbase.downloader.depend.ka kaVar) {
        if (kaVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.x() { // from class: com.ss.android.socialbase.downloader.ny.ab.11
            @Override // com.ss.android.socialbase.downloader.downloader.x
            public int ms(long j) {
                try {
                    return kaVar.ms(j);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    return 0;
                }
            }
        };
    }

    public static u ms(final com.ss.android.socialbase.downloader.depend.c cVar) {
        if (cVar == null) {
            return null;
        }
        return new u() { // from class: com.ss.android.socialbase.downloader.ny.ab.13
            @Override // com.ss.android.socialbase.downloader.depend.u
            public void ms(DownloadInfo downloadInfo, BaseException baseException, int i) {
                if (downloadInfo == null) {
                    return;
                }
                try {
                    cVar.ms(downloadInfo, baseException, i);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }
        };
    }

    public static i ms(final com.ss.android.socialbase.downloader.depend.ch chVar) {
        if (chVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.depend.ah() { // from class: com.ss.android.socialbase.downloader.ny.ab.14
            @Override // com.ss.android.socialbase.downloader.depend.i
            public void ms(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                try {
                    chVar.ms(jSONObject.toString());
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public String xr() {
                try {
                    return chVar.ms();
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    return "";
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ah
            public int[] ms() {
                try {
                    return chVar.xr();
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    return null;
                }
            }
        };
    }

    public static re ms(final nw nwVar) {
        if (nwVar == null) {
            return null;
        }
        return new re() { // from class: com.ss.android.socialbase.downloader.ny.ab.15
            @Override // com.ss.android.socialbase.downloader.depend.re
            public boolean ms(b bVar) {
                try {
                    return nwVar.ms(ab.ms(bVar));
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    return false;
                }
            }
        };
    }

    public static t ms(final b bVar) {
        if (bVar == null) {
            return null;
        }
        return new t.ms() { // from class: com.ss.android.socialbase.downloader.ny.ab.16
            @Override // com.ss.android.socialbase.downloader.depend.t
            public void ms(List<String> list) {
                bVar.ms(list);
            }

            @Override // com.ss.android.socialbase.downloader.depend.t
            public boolean ms() {
                return bVar.ms();
            }
        };
    }

    public static f ms(final ul ulVar) {
        if (ulVar == null) {
            return null;
        }
        return new f.ms() { // from class: com.ss.android.socialbase.downloader.ny.ab.17
            @Override // com.ss.android.socialbase.downloader.depend.f
            public void ms(int i, int i2) {
                ulVar.ms(i, i2);
            }
        };
    }

    public static ul ms(final f fVar) {
        if (fVar == null) {
            return null;
        }
        return new ul() { // from class: com.ss.android.socialbase.downloader.ny.ab.18
            @Override // com.ss.android.socialbase.downloader.depend.ul
            public void ms(int i, int i2) {
                try {
                    fVar.ms(i, i2);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }
        };
    }

    public static qv ms(final ao aoVar) {
        if (aoVar == null) {
            return null;
        }
        return new qv() { // from class: com.ss.android.socialbase.downloader.ny.ab.19
            @Override // com.ss.android.socialbase.downloader.depend.qv
            public boolean ms(long j, long j2, h hVar) {
                try {
                    return aoVar.ms(j, j2, ab.ms(hVar));
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    return false;
                }
            }
        };
    }

    public static ub ms(final h hVar) {
        if (hVar == null) {
            return null;
        }
        return new ub.ms() { // from class: com.ss.android.socialbase.downloader.ny.ab.20
            @Override // com.ss.android.socialbase.downloader.depend.ub
            public void ms() throws RemoteException {
                hVar.ms();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.y ms(final pc pcVar) {
        if (pcVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.y() { // from class: com.ss.android.socialbase.downloader.ny.ab.21
            @Override // com.ss.android.socialbase.downloader.downloader.y
            public long ms(int i, int i2) {
                try {
                    return pcVar.ms(i, i2);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    return 0L;
                }
            }
        };
    }

    public static IDownloadInterceptor ms(final com.ss.android.socialbase.downloader.depend.x xVar) {
        if (xVar == null) {
            return null;
        }
        return new IDownloadInterceptor() { // from class: com.ss.android.socialbase.downloader.ny.ab.22
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
            public boolean intercepte() {
                try {
                    return xVar.ms();
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    return false;
                }
            }
        };
    }

    public static IDownloadFileUriProvider ms(final com.ss.android.socialbase.downloader.depend.ab abVar) {
        if (abVar == null) {
            return null;
        }
        return new IDownloadFileUriProvider() { // from class: com.ss.android.socialbase.downloader.ny.ab.24
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str, String str2) {
                try {
                    return abVar.ms(str, str2);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    return null;
                }
            }
        };
    }

    public static IDownloadListener ms(final com.ss.android.socialbase.downloader.depend.ny nyVar) {
        if (nyVar == null) {
            return null;
        }
        return new y() { // from class: com.ss.android.socialbase.downloader.ny.ab.25
            @Override // com.ss.android.socialbase.downloader.depend.y
            public void ms(DownloadInfo downloadInfo) {
                try {
                    nyVar.ny(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPrepare(DownloadInfo downloadInfo) {
                try {
                    nyVar.ms(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onStart(DownloadInfo downloadInfo) {
                try {
                    nyVar.xr(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onProgress(DownloadInfo downloadInfo) {
                try {
                    nyVar.ah(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPause(DownloadInfo downloadInfo) {
                try {
                    nyVar.d(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onSuccessed(DownloadInfo downloadInfo) {
                try {
                    nyVar.ka(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    nyVar.ms(downloadInfo, baseException);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onCanceled(DownloadInfo downloadInfo) {
                try {
                    nyVar.c(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstStart(DownloadInfo downloadInfo) {
                try {
                    nyVar.ab(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstSuccess(DownloadInfo downloadInfo) {
                try {
                    nyVar.x(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    nyVar.xr(downloadInfo, baseException);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    nyVar.ah(downloadInfo, baseException);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }
        };
    }
}
