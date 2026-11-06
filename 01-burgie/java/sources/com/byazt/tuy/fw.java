package com.byazt.tuy;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.auw.DownloadInfo;
import com.byazt.auw.DownloadTask;
import com.byazt.fn.IDownloadFileUriProvider;
import com.byazt.fn.IDownloadInterceptor;
import com.byazt.fn.IDownloadListener;
import com.byazt.fn.a;
import com.byazt.fn.b;
import com.byazt.fn.cz;
import com.byazt.fn.fo;
import com.byazt.fn.g;
import com.byazt.fn.ho;
import com.byazt.fn.k;
import com.byazt.fn.lb;
import com.byazt.fn.ls;
import com.byazt.fn.m;
import com.byazt.fn.n;
import com.byazt.fn.nl;
import com.byazt.fn.nt;
import com.byazt.fn.ny;
import com.byazt.fn.qa;
import com.byazt.fn.rc;
import com.byazt.fn.s;
import com.byazt.fn.y;
import com.byazt.fn.yb;
import com.byazt.fn.z;
import com.byazt.lhc.BaseException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_OUTFPS_LIST, 62})
public class fw {
    public static Handler pr = new Handler(Looper.getMainLooper());

    public static com.byazt.auw.pr pr(final DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        return new com.byazt.auw.pr.AbstractBinderC0018pr() { // from class: com.byazt.tuy.fw.1
            @Override // com.byazt.auw.pr
            public DownloadInfo pr() throws RemoteException {
                return downloadTask.getDownloadInfo();
            }

            @Override // com.byazt.auw.pr
            public com.byazt.fn.c hw() throws RemoteException {
                return fw.pr(downloadTask.getChunkStrategy());
            }

            @Override // com.byazt.auw.pr
            public com.byazt.fn.aj hw(int i) throws RemoteException {
                return fw.pr(downloadTask.getSingleDownloadListener(uc.c(i)), i != com.byazt.mrs.uc.SUB.ordinal());
            }

            @Override // com.byazt.auw.pr
            public int pr(int i) throws RemoteException {
                return downloadTask.getDownloadListenerSize(uc.c(i));
            }

            @Override // com.byazt.auw.pr
            public com.byazt.fn.aj pr(int i, int i2) throws RemoteException {
                return fw.pr(downloadTask.getDownloadListenerByIndex(uc.c(i), i2), i != com.byazt.mrs.uc.SUB.ordinal());
            }

            @Override // com.byazt.auw.pr
            public z hn() throws RemoteException {
                return fw.pr(downloadTask.getNotificationEventListener());
            }

            @Override // com.byazt.auw.pr
            public nl x() throws RemoteException {
                return fw.pr(downloadTask.getNotificationClickCallback());
            }

            @Override // com.byazt.auw.pr
            public com.byazt.fn.zo c() throws RemoteException {
                return fw.pr(downloadTask.getInterceptor());
            }

            @Override // com.byazt.auw.pr
            public com.byazt.fn.uc uc() throws RemoteException {
                return fw.pr(downloadTask.getDepend());
            }

            @Override // com.byazt.auw.pr
            public com.byazt.fn.vk vk() throws RemoteException {
                return fw.pr(downloadTask.getMonitorDepend());
            }

            @Override // com.byazt.auw.pr
            public cz fw() throws RemoteException {
                return fw.pr(downloadTask.getForbiddenHandler());
            }

            @Override // com.byazt.auw.pr
            public n zo() throws RemoteException {
                return fw.pr(downloadTask.getRetryDelayTimeCalculator());
            }

            @Override // com.byazt.auw.pr
            public nt aj() throws RemoteException {
                return fw.pr(downloadTask.getDiskSpaceHandler());
            }

            @Override // com.byazt.auw.pr
            public com.byazt.fn.fw w() throws RemoteException {
                return fw.pr(downloadTask.getFileUriProvider());
            }

            @Override // com.byazt.auw.pr
            public int k() throws RemoteException {
                return downloadTask.getDownloadCompleteHandlers().size();
            }

            @Override // com.byazt.auw.pr
            public k hn(int i) throws RemoteException {
                return fw.pr(downloadTask.getDownloadCompleteHandlerByIndex(i));
            }
        };
    }

    public static com.byazt.fn.aj pr(final IDownloadListener iDownloadListener, final boolean z) {
        if (iDownloadListener == null) {
            return null;
        }
        return new com.byazt.fn.aj.pr() { // from class: com.byazt.tuy.fw.12
            @Override // com.byazt.fn.aj
            public int pr() throws RemoteException {
                return iDownloadListener.hashCode();
            }

            @Override // com.byazt.fn.aj
            public void pr(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    fw.pr.post(new Runnable() { // from class: com.byazt.tuy.fw.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onPrepare(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onPrepare(downloadInfo);
                }
            }

            @Override // com.byazt.fn.aj
            public void hw(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    fw.pr.post(new Runnable() { // from class: com.byazt.tuy.fw.12.5
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onStart(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onStart(downloadInfo);
                }
            }

            @Override // com.byazt.fn.aj
            public void hn(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    fw.pr.post(new Runnable() { // from class: com.byazt.tuy.fw.12.6
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onProgress(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onProgress(downloadInfo);
                }
            }

            @Override // com.byazt.fn.aj
            public void x(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    fw.pr.post(new Runnable() { // from class: com.byazt.tuy.fw.12.7
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onPause(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onPause(downloadInfo);
                }
            }

            @Override // com.byazt.fn.aj
            public void c(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    fw.pr.post(new Runnable() { // from class: com.byazt.tuy.fw.12.8
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onSuccessed(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onSuccessed(downloadInfo);
                }
            }

            @Override // com.byazt.fn.aj
            public void pr(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    fw.pr.post(new Runnable() { // from class: com.byazt.tuy.fw.12.9
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFailed(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onFailed(downloadInfo, baseException);
                }
            }

            @Override // com.byazt.fn.aj
            public void uc(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    fw.pr.post(new Runnable() { // from class: com.byazt.tuy.fw.12.10
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onCanceled(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onCanceled(downloadInfo);
                }
            }

            @Override // com.byazt.fn.aj
            public void fw(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    fw.pr.post(new Runnable() { // from class: com.byazt.tuy.fw.12.11
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFirstStart(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onFirstStart(downloadInfo);
                }
            }

            @Override // com.byazt.fn.aj
            public void zo(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    fw.pr.post(new Runnable() { // from class: com.byazt.tuy.fw.12.12
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFirstSuccess(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onFirstSuccess(downloadInfo);
                }
            }

            @Override // com.byazt.fn.aj
            public void hw(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    fw.pr.post(new Runnable() { // from class: com.byazt.tuy.fw.12.2
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onRetry(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onRetry(downloadInfo, baseException);
                }
            }

            @Override // com.byazt.fn.aj
            public void hn(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    fw.pr.post(new Runnable() { // from class: com.byazt.tuy.fw.12.3
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onRetryDelay(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onRetryDelay(downloadInfo, baseException);
                }
            }

            @Override // com.byazt.fn.aj
            public void aj(final DownloadInfo downloadInfo) throws RemoteException {
                IDownloadListener iDownloadListener2 = iDownloadListener;
                if (iDownloadListener2 instanceof qa) {
                    if (z) {
                        fw.pr.post(new Runnable() { // from class: com.byazt.tuy.fw.12.4
                            @Override // java.lang.Runnable
                            public void run() {
                                ((qa) iDownloadListener).pr(downloadInfo);
                            }
                        });
                    } else {
                        ((qa) iDownloadListener2).pr(downloadInfo);
                    }
                }
            }
        };
    }

    public static z pr(final b bVar) {
        if (bVar == null) {
            return null;
        }
        return new z.pr() { // from class: com.byazt.tuy.fw.23
            @Override // com.byazt.fn.z
            public void pr(int i, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                bVar.pr(i, downloadInfo, str, str2);
            }

            @Override // com.byazt.fn.z
            public boolean pr(boolean z) throws RemoteException {
                return bVar.pr(z);
            }

            @Override // com.byazt.fn.z
            public String pr() throws RemoteException {
                return bVar.pr();
            }
        };
    }

    public static nl pr(final y yVar) {
        if (yVar == null) {
            return null;
        }
        return new nl.pr() { // from class: com.byazt.tuy.fw.26
            @Override // com.byazt.fn.nl
            public boolean pr(DownloadInfo downloadInfo) throws RemoteException {
                return yVar.pr(downloadInfo);
            }

            @Override // com.byazt.fn.nl
            public boolean hw(DownloadInfo downloadInfo) throws RemoteException {
                return yVar.hw(downloadInfo);
            }

            @Override // com.byazt.fn.nl
            public boolean hn(DownloadInfo downloadInfo) throws RemoteException {
                return yVar.hn(downloadInfo);
            }
        };
    }

    public static n pr(final com.byazt.lj.qa qaVar) {
        if (qaVar == null) {
            return null;
        }
        return new n.pr() { // from class: com.byazt.tuy.fw.27
            @Override // com.byazt.fn.n
            public long pr(int i, int i2) throws RemoteException {
                return qaVar.pr(i, i2);
            }
        };
    }

    public static cz pr(final fo foVar) {
        if (foVar == null) {
            return null;
        }
        return new cz.pr() { // from class: com.byazt.tuy.fw.28
            @Override // com.byazt.fn.cz
            public boolean pr(a aVar) throws RemoteException {
                return foVar.pr(fw.pr(aVar));
            }
        };
    }

    public static com.byazt.fn.fw pr(final IDownloadFileUriProvider iDownloadFileUriProvider) {
        if (iDownloadFileUriProvider == null) {
            return null;
        }
        return new com.byazt.fn.fw.pr() { // from class: com.byazt.tuy.fw.29
            @Override // com.byazt.fn.fw
            public Uri pr(String str, String str2) throws RemoteException {
                return iDownloadFileUriProvider.getUriForFile(str, str2);
            }
        };
    }

    public static ny pr(final a aVar) {
        if (aVar == null) {
            return null;
        }
        return new ny() { // from class: com.byazt.tuy.fw.30
            @Override // com.byazt.fn.ny
            public void pr(List<String> list) {
                try {
                    aVar.pr(list);
                } catch (RemoteException e) {
                }
            }

            @Override // com.byazt.fn.ny
            public boolean pr() {
                try {
                    return aVar.pr();
                } catch (RemoteException e) {
                    return false;
                }
            }
        };
    }

    public static nt pr(final lb lbVar) {
        if (lbVar == null) {
            return null;
        }
        return new nt.pr() { // from class: com.byazt.tuy.fw.31
            @Override // com.byazt.fn.nt
            public boolean pr(long j, long j2, ho hoVar) throws RemoteException {
                return lbVar.pr(j, j2, fw.pr(hoVar));
            }
        };
    }

    public static yb pr(final ho hoVar) {
        if (hoVar == null) {
            return null;
        }
        return new yb() { // from class: com.byazt.tuy.fw.2
            @Override // com.byazt.fn.yb
            public void pr() {
                try {
                    hoVar.pr();
                } catch (RemoteException e) {
                }
            }
        };
    }

    public static com.byazt.fn.uc pr(final g gVar) {
        if (gVar == null) {
            return null;
        }
        return new com.byazt.fn.uc.pr() { // from class: com.byazt.tuy.fw.3
            @Override // com.byazt.fn.uc
            public void pr(DownloadInfo downloadInfo, BaseException baseException, int i) throws RemoteException {
                gVar.pr(downloadInfo, baseException, i);
            }
        };
    }

    public static com.byazt.fn.vk pr(final rc rcVar) {
        if (rcVar == null) {
            return null;
        }
        return new com.byazt.fn.vk.pr() { // from class: com.byazt.tuy.fw.4
            @Override // com.byazt.fn.vk
            public void pr(String str) throws RemoteException {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    rcVar.pr(new JSONObject(str));
                } catch (JSONException e) {
                }
            }

            @Override // com.byazt.fn.vk
            public String pr() throws RemoteException {
                return rcVar.hw();
            }

            @Override // com.byazt.fn.vk
            public int[] hw() throws RemoteException {
                rc rcVar2 = rcVar;
                if (rcVar2 instanceof com.byazt.fn.hn) {
                    return ((com.byazt.fn.hn) rcVar2).pr();
                }
                return null;
            }
        };
    }

    public static com.byazt.fn.c pr(final com.byazt.lj.zo zoVar) {
        if (zoVar == null) {
            return null;
        }
        return new com.byazt.fn.c.pr() { // from class: com.byazt.tuy.fw.5
            @Override // com.byazt.fn.c
            public int pr(long j) throws RemoteException {
                return zoVar.pr(j);
            }
        };
    }

    public static com.byazt.fn.zo pr(final IDownloadInterceptor iDownloadInterceptor) {
        if (iDownloadInterceptor == null) {
            return null;
        }
        return new com.byazt.fn.zo.pr() { // from class: com.byazt.tuy.fw.6
            @Override // com.byazt.fn.zo
            public boolean pr() throws RemoteException {
                return iDownloadInterceptor.intercepte();
            }
        };
    }

    public static DownloadTask pr(com.byazt.auw.pr prVar) {
        if (prVar == null) {
            return null;
        }
        try {
            DownloadTask downloadTask = new DownloadTask(prVar.pr());
            downloadTask.chunkStategy(pr(prVar.hw())).notificationEventListener(pr(prVar.hn())).interceptor(pr(prVar.c())).depend(pr(prVar.uc())).monitorDepend(pr(prVar.vk())).forbiddenHandler(pr(prVar.fw())).diskSpaceHandler(pr(prVar.aj())).fileUriProvider(pr(prVar.w())).notificationClickCallback(pr(prVar.x())).retryDelayTimeCalculator(pr(prVar.zo()));
            com.byazt.fn.aj ajVarHw = prVar.hw(com.byazt.mrs.uc.MAIN.ordinal());
            if (ajVarHw != null) {
                downloadTask.mainThreadListenerWithHashCode(ajVarHw.hashCode(), pr(ajVarHw));
            }
            com.byazt.fn.aj ajVarHw2 = prVar.hw(com.byazt.mrs.uc.SUB.ordinal());
            if (ajVarHw2 != null) {
                downloadTask.subThreadListenerWithHashCode(ajVarHw2.hashCode(), pr(ajVarHw2));
            }
            com.byazt.fn.aj ajVarHw3 = prVar.hw(com.byazt.mrs.uc.NOTIFICATION.ordinal());
            if (ajVarHw3 != null) {
                downloadTask.notificationListenerWithHashCode(ajVarHw3.hashCode(), pr(ajVarHw3));
            }
            pr(downloadTask, prVar, com.byazt.mrs.uc.MAIN);
            pr(downloadTask, prVar, com.byazt.mrs.uc.SUB);
            pr(downloadTask, prVar, com.byazt.mrs.uc.NOTIFICATION);
            pr(downloadTask, prVar);
            return downloadTask;
        } catch (RemoteException e) {
            return null;
        }
    }

    private static void pr(DownloadTask downloadTask, com.byazt.auw.pr prVar, com.byazt.mrs.uc ucVar) throws RemoteException {
        SparseArray<IDownloadListener> sparseArray = new SparseArray<>();
        for (int i = 0; i < prVar.pr(ucVar.ordinal()); i++) {
            com.byazt.fn.aj ajVarPr = prVar.pr(ucVar.ordinal(), i);
            if (ajVarPr != null) {
                sparseArray.put(ajVarPr.pr(), pr(ajVarPr));
            }
        }
        downloadTask.setDownloadListeners(sparseArray, ucVar);
    }

    private static void pr(DownloadTask downloadTask, com.byazt.auw.pr prVar) throws RemoteException {
        for (int i = 0; i < prVar.k(); i++) {
            k kVarHn = prVar.hn(i);
            if (kVarHn != null) {
                downloadTask.addDownloadCompleteHandler(pr(kVarHn));
            }
        }
    }

    public static b pr(final z zVar) {
        if (zVar == null) {
            return null;
        }
        return new b() { // from class: com.byazt.tuy.fw.7
            @Override // com.byazt.fn.b
            public void pr(int i, DownloadInfo downloadInfo, String str, String str2) {
                try {
                    zVar.pr(i, downloadInfo, str, str2);
                } catch (RemoteException e) {
                }
            }

            @Override // com.byazt.fn.b
            public boolean pr(boolean z) {
                try {
                    return zVar.pr(z);
                } catch (RemoteException e) {
                    return false;
                }
            }

            @Override // com.byazt.fn.b
            public String pr() {
                try {
                    return zVar.pr();
                } catch (RemoteException e) {
                    return null;
                }
            }
        };
    }

    public static m pr(final k kVar) {
        if (kVar == null) {
            return null;
        }
        return new m() { // from class: com.byazt.tuy.fw.8
            @Override // com.byazt.fn.m
            public void pr(DownloadInfo downloadInfo) throws BaseException {
                try {
                    kVar.pr(downloadInfo);
                } catch (RemoteException e) {
                    throw new BaseException(1008, e);
                }
            }

            @Override // com.byazt.fn.m
            public boolean hw(DownloadInfo downloadInfo) {
                try {
                    return kVar.hw(downloadInfo);
                } catch (RemoteException e) {
                    return false;
                }
            }
        };
    }

    public static k pr(final m mVar) {
        if (mVar == null) {
            return null;
        }
        return new k.pr() { // from class: com.byazt.tuy.fw.9
            @Override // com.byazt.fn.k
            public void pr(DownloadInfo downloadInfo) throws RemoteException {
                try {
                    mVar.pr(downloadInfo);
                } catch (BaseException e) {
                    throw new IllegalArgumentException(e);
                }
            }

            @Override // com.byazt.fn.k
            public boolean hw(DownloadInfo downloadInfo) throws RemoteException {
                return mVar.hw(downloadInfo);
            }
        };
    }

    public static y pr(final nl nlVar) {
        if (nlVar == null) {
            return null;
        }
        return new y() { // from class: com.byazt.tuy.fw.10
            @Override // com.byazt.fn.y
            public boolean pr(DownloadInfo downloadInfo) {
                try {
                    return nlVar.pr(downloadInfo);
                } catch (RemoteException e) {
                    return false;
                }
            }

            @Override // com.byazt.fn.y
            public boolean hw(DownloadInfo downloadInfo) {
                try {
                    return nlVar.hw(downloadInfo);
                } catch (RemoteException e) {
                    return false;
                }
            }

            @Override // com.byazt.fn.y
            public boolean hn(DownloadInfo downloadInfo) {
                try {
                    return nlVar.hn(downloadInfo);
                } catch (RemoteException e) {
                    return false;
                }
            }
        };
    }

    public static com.byazt.lj.zo pr(final com.byazt.fn.c cVar) {
        if (cVar == null) {
            return null;
        }
        return new com.byazt.lj.zo() { // from class: com.byazt.tuy.fw.11
            @Override // com.byazt.lj.zo
            public int pr(long j) {
                try {
                    return cVar.pr(j);
                } catch (RemoteException e) {
                    return 0;
                }
            }
        };
    }

    public static g pr(final com.byazt.fn.uc ucVar) {
        if (ucVar == null) {
            return null;
        }
        return new g() { // from class: com.byazt.tuy.fw.13
            @Override // com.byazt.fn.g
            public void pr(DownloadInfo downloadInfo, BaseException baseException, int i) {
                if (downloadInfo == null) {
                    return;
                }
                try {
                    ucVar.pr(downloadInfo, baseException, i);
                } catch (RemoteException e) {
                }
            }
        };
    }

    public static rc pr(final com.byazt.fn.vk vkVar) {
        if (vkVar == null) {
            return null;
        }
        return new com.byazt.fn.hn() { // from class: com.byazt.tuy.fw.14
            @Override // com.byazt.fn.rc
            public void pr(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                try {
                    vkVar.pr(jSONObject.toString());
                } catch (RemoteException e) {
                }
            }

            @Override // com.byazt.fn.rc
            public String hw() {
                try {
                    return vkVar.pr();
                } catch (RemoteException e) {
                    return "";
                }
            }

            @Override // com.byazt.fn.hn
            public int[] pr() {
                try {
                    return vkVar.hw();
                } catch (RemoteException e) {
                    return null;
                }
            }
        };
    }

    public static fo pr(final cz czVar) {
        if (czVar == null) {
            return null;
        }
        return new fo() { // from class: com.byazt.tuy.fw.15
            @Override // com.byazt.fn.fo
            public boolean pr(ny nyVar) {
                try {
                    return czVar.pr(fw.pr(nyVar));
                } catch (RemoteException e) {
                    return false;
                }
            }
        };
    }

    public static a pr(final ny nyVar) {
        if (nyVar == null) {
            return null;
        }
        return new a.pr() { // from class: com.byazt.tuy.fw.16
            @Override // com.byazt.fn.a
            public void pr(List<String> list) {
                nyVar.pr(list);
            }

            @Override // com.byazt.fn.a
            public boolean pr() {
                return nyVar.pr();
            }
        };
    }

    public static s pr(final ls lsVar) {
        if (lsVar == null) {
            return null;
        }
        return new s.pr() { // from class: com.byazt.tuy.fw.17
            @Override // com.byazt.fn.s
            public void pr(int i, int i2) {
                lsVar.pr(i, i2);
            }
        };
    }

    public static ls pr(final s sVar) {
        if (sVar == null) {
            return null;
        }
        return new ls() { // from class: com.byazt.tuy.fw.18
            @Override // com.byazt.fn.ls
            public void pr(int i, int i2) {
                try {
                    sVar.pr(i, i2);
                } catch (RemoteException e) {
                }
            }
        };
    }

    public static lb pr(final nt ntVar) {
        if (ntVar == null) {
            return null;
        }
        return new lb() { // from class: com.byazt.tuy.fw.19
            @Override // com.byazt.fn.lb
            public boolean pr(long j, long j2, yb ybVar) {
                try {
                    return ntVar.pr(j, j2, fw.pr(ybVar));
                } catch (RemoteException e) {
                    return false;
                }
            }
        };
    }

    public static ho pr(final yb ybVar) {
        if (ybVar == null) {
            return null;
        }
        return new ho.pr() { // from class: com.byazt.tuy.fw.20
            @Override // com.byazt.fn.ho
            public void pr() throws RemoteException {
                ybVar.pr();
            }
        };
    }

    public static com.byazt.lj.qa pr(final n nVar) {
        if (nVar == null) {
            return null;
        }
        return new com.byazt.lj.qa() { // from class: com.byazt.tuy.fw.21
            @Override // com.byazt.lj.qa
            public long pr(int i, int i2) {
                try {
                    return nVar.pr(i, i2);
                } catch (RemoteException e) {
                    return 0L;
                }
            }
        };
    }

    public static IDownloadInterceptor pr(final com.byazt.fn.zo zoVar) {
        if (zoVar == null) {
            return null;
        }
        return new IDownloadInterceptor() { // from class: com.byazt.tuy.fw.22
            @Override // com.byazt.fn.IDownloadInterceptor
            public boolean intercepte() {
                try {
                    return zoVar.pr();
                } catch (RemoteException e) {
                    return false;
                }
            }
        };
    }

    public static IDownloadFileUriProvider pr(final com.byazt.fn.fw fwVar) {
        if (fwVar == null) {
            return null;
        }
        return new IDownloadFileUriProvider() { // from class: com.byazt.tuy.fw.24
            @Override // com.byazt.fn.IDownloadFileUriProvider
            public Uri getUriForFile(String str, String str2) {
                try {
                    return fwVar.pr(str, str2);
                } catch (RemoteException e) {
                    return null;
                }
            }
        };
    }

    public static IDownloadListener pr(final com.byazt.fn.aj ajVar) {
        if (ajVar == null) {
            return null;
        }
        return new qa() { // from class: com.byazt.tuy.fw.25
            @Override // com.byazt.fn.qa
            public void pr(DownloadInfo downloadInfo) {
                try {
                    ajVar.aj(downloadInfo);
                } catch (RemoteException e) {
                }
            }

            @Override // com.byazt.fn.IDownloadListener
            public void onPrepare(DownloadInfo downloadInfo) {
                try {
                    ajVar.pr(downloadInfo);
                } catch (RemoteException e) {
                }
            }

            @Override // com.byazt.fn.IDownloadListener
            public void onStart(DownloadInfo downloadInfo) {
                try {
                    ajVar.hw(downloadInfo);
                } catch (RemoteException e) {
                }
            }

            @Override // com.byazt.fn.IDownloadListener
            public void onProgress(DownloadInfo downloadInfo) {
                try {
                    ajVar.hn(downloadInfo);
                } catch (RemoteException e) {
                }
            }

            @Override // com.byazt.fn.IDownloadListener
            public void onPause(DownloadInfo downloadInfo) {
                try {
                    ajVar.x(downloadInfo);
                } catch (RemoteException e) {
                }
            }

            @Override // com.byazt.fn.IDownloadListener
            public void onSuccessed(DownloadInfo downloadInfo) {
                try {
                    ajVar.c(downloadInfo);
                } catch (RemoteException e) {
                }
            }

            @Override // com.byazt.fn.IDownloadListener
            public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    ajVar.pr(downloadInfo, baseException);
                } catch (RemoteException e) {
                }
            }

            @Override // com.byazt.fn.IDownloadListener
            public void onCanceled(DownloadInfo downloadInfo) {
                try {
                    ajVar.uc(downloadInfo);
                } catch (RemoteException e) {
                }
            }

            @Override // com.byazt.fn.IDownloadListener
            public void onFirstStart(DownloadInfo downloadInfo) {
                try {
                    ajVar.fw(downloadInfo);
                } catch (RemoteException e) {
                }
            }

            @Override // com.byazt.fn.IDownloadListener
            public void onFirstSuccess(DownloadInfo downloadInfo) {
                try {
                    ajVar.zo(downloadInfo);
                } catch (RemoteException e) {
                }
            }

            @Override // com.byazt.fn.IDownloadListener
            public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    ajVar.hw(downloadInfo, baseException);
                } catch (RemoteException e) {
                }
            }

            @Override // com.byazt.fn.IDownloadListener
            public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    ajVar.hn(downloadInfo, baseException);
                } catch (RemoteException e) {
                }
            }
        };
    }
}
