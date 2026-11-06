package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.depend.of;
import com.ss.android.socialbase.downloader.depend.op;
import com.ss.android.socialbase.downloader.depend.ul;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ah {
    private static volatile ub ab;
    private static volatile hi ah;
    private static boolean am;
    private static volatile ExecutorService ao;
    private static volatile ExecutorService b;
    private static volatile com.ss.android.socialbase.downloader.impls.ms c;
    private static volatile IDownloadHttpService ch;
    private static volatile op cv;
    private static volatile x d;
    private static final int e;
    private static final int eg;
    private static volatile nw f;
    private static int fm;
    private static volatile ExecutorService h;
    private static volatile com.ss.android.socialbase.downloader.network.x hi;
    private static volatile ab i;
    private static final List<com.ss.android.socialbase.downloader.depend.hi> il;
    private static volatile com.ss.android.socialbase.downloader.network.c jw;
    private static final int k;
    private static volatile of ka;
    private static int l;
    private static volatile com.ss.android.socialbase.downloader.d.xr le;
    private static final int lm;
    private static int m;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile Context f4658ms;
    private static volatile ExecutorService nw;
    private static volatile ms ny;
    private static volatile h op;
    private static volatile com.ss.android.socialbase.downloader.network.c pc;
    private static final List<Object> qf;
    private static volatile ExecutorService qv;
    private static volatile ScheduledExecutorService re;
    private static volatile boolean s;
    private static boolean sa;
    private static volatile IDownloadHttpService sl;
    private static volatile ExecutorService t;
    private static com.ss.android.socialbase.downloader.d.ah ti;
    private static qv tz;
    private static volatile sl u;
    private static volatile ExecutorService ub;
    private static volatile DownloadReceiver w;
    private static volatile ub x;
    private static boolean xn;
    private static volatile ch xr;
    private static volatile ExecutorService y;
    private static volatile y yu;
    private static volatile com.ss.android.socialbase.downloader.network.x zb;
    private static volatile List<ul> g = new ArrayList();
    private static volatile boolean of = false;
    private static volatile OkHttpClient p = null;
    private static final List<com.ss.android.socialbase.downloader.depend.zb> ul = new ArrayList();
    private static boolean az = false;

    public interface ms {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.downloader.ah$ms$ms, reason: collision with other inner class name */
        public interface InterfaceC0564ms {
            void ms();
        }

        t ms(InterfaceC0564ms interfaceC0564ms);

        ub ms();

        zb xr();
    }

    public static void ms(qv qvVar) {
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        lm = iAvailableProcessors;
        e = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        k = iAvailableProcessors;
        eg = iAvailableProcessors;
        fm = 8192;
        il = new ArrayList();
        qf = new ArrayList();
        am = true;
        sa = false;
        s = false;
    }

    private ah() {
    }

    static synchronized void ms(DownloaderBuilder downloaderBuilder) {
        if (s) {
            com.ss.android.socialbase.downloader.ah.ms.ka("DownloadComponentManager", "component has init");
            return;
        }
        boolean z = of;
        ah(downloaderBuilder);
        if (xr == null) {
            xr = new com.ss.android.socialbase.downloader.impls.d();
        }
        if (ab == null) {
            ab = new com.ss.android.socialbase.downloader.impls.x();
        }
        if (x == null && ny != null) {
            x = ny.ms();
        }
        if (ah == null) {
            ah = new com.ss.android.socialbase.downloader.impls.ny();
        }
        if (c == null) {
            c = new com.ss.android.socialbase.downloader.impls.ka();
        }
        if (d == null) {
            d = new com.ss.android.socialbase.downloader.impls.ah();
        }
        if (i == null) {
            i = new com.ss.android.socialbase.downloader.impls.xr();
        }
        if (yu == null) {
            yu = new com.ss.android.socialbase.downloader.impls.ch();
        }
        int i2 = m;
        if (i2 <= 0 || i2 > lm) {
            m = lm;
        }
        am();
        if (of && !z && !com.ss.android.socialbase.downloader.ny.c.ah()) {
            com.ss.android.socialbase.downloader.impls.sl.ms(true).startService();
        } else if (com.ss.android.socialbase.downloader.ny.c.d()) {
            ExecutorService executorServiceZb = zb();
            if (executorServiceZb != null) {
                executorServiceZb.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.ah.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Context contextK = ah.k();
                        if (contextK != null) {
                            com.ss.android.socialbase.downloader.ny.c.d(contextK);
                        }
                    }
                });
            }
        } else {
            Context contextK = k();
            if (contextK != null) {
                com.ss.android.socialbase.downloader.ny.c.d(contextK);
            }
        }
        pc();
        s = true;
    }

    static synchronized void xr(DownloaderBuilder downloaderBuilder) {
        ah(downloaderBuilder);
    }

    private static void ah(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder != null) {
            if (downloaderBuilder.getContext() != null) {
                ms(downloaderBuilder.getContext());
            }
            if (downloaderBuilder.getDownloadCache() != null) {
                ms(downloaderBuilder.getDownloadCache());
            }
            if (downloaderBuilder.getIdGenerator() != null) {
                ms(downloaderBuilder.getIdGenerator());
            }
            if (downloaderBuilder.getChunkCntCalculator() != null) {
                ms(downloaderBuilder.getChunkCntCalculator());
            }
            if (downloaderBuilder.getNotificationClickCallback() != null) {
                ms(downloaderBuilder.getNotificationClickCallback());
            }
            if (downloaderBuilder.getMaxDownloadPoolSize() != 0) {
                xr(downloaderBuilder.getMaxDownloadPoolSize());
            }
            if (downloaderBuilder.getHttpService() != null) {
                ms(downloaderBuilder.getHttpService());
            }
            if (downloaderBuilder.getHeadHttpService() != null) {
                ms(downloaderBuilder.getHeadHttpService());
            }
            if (downloaderBuilder.getDownloadLaunchHandler() != null) {
                ms(downloaderBuilder.getDownloadLaunchHandler());
            }
            if (downloaderBuilder.getCPUThreadExecutor() != null) {
                ah(downloaderBuilder.getCPUThreadExecutor());
            }
            if (downloaderBuilder.getIOThreadExecutor() != null) {
                d(downloaderBuilder.getIOThreadExecutor());
            }
            if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
                ka(downloaderBuilder.getMixDefaultDownloadExecutor());
            }
            if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
                c(downloaderBuilder.getMixFrequentDownloadExecutor());
            }
            if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
                ab(downloaderBuilder.getMixApkDownloadExecutor());
            }
            if (downloaderBuilder.getDBThreadExecutor() != null) {
                x(downloaderBuilder.getDBThreadExecutor());
            }
            if (downloaderBuilder.getChunkThreadExecutor() != null) {
                ms(downloaderBuilder.getChunkThreadExecutor());
            }
            if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
                xr(downloaderBuilder.getOkHttpDispatcherExecutor());
            }
            if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
                ms(downloaderBuilder.getDownloadCompleteHandlers());
            }
            if (downloaderBuilder.getMonitorConfig() != null) {
                op = downloaderBuilder.getMonitorConfig();
            }
            if (downloaderBuilder.getWriteBufferSize() > 1024) {
                fm = downloaderBuilder.getWriteBufferSize();
            }
            if (downloaderBuilder.getChunkAdjustCalculator() != null) {
                ms(downloaderBuilder.getChunkAdjustCalculator());
            }
            if (downloaderBuilder.isDownloadInMultiProcess()) {
                of = true;
            }
            if (downloaderBuilder.getDownloadExpSwitch() != 0) {
                l = downloaderBuilder.getDownloadExpSwitch();
            }
            if (downloaderBuilder.getDownloadSetting() != null) {
                ms(downloaderBuilder.getDownloadSetting());
            }
            if (downloaderBuilder.getDownloadDns() != null) {
                pc = downloaderBuilder.getDownloadDns();
            }
            if (downloaderBuilder.getTTNetHandler() != null) {
                nw tTNetHandler = downloaderBuilder.getTTNetHandler();
                f = tTNetHandler;
                if (tTNetHandler.ms()) {
                    ms(f.xr());
                    ms(f.ah());
                } else {
                    ms(x());
                    ms(ny());
                }
            }
            xr(downloaderBuilder.needAutoRefreshUnSuccessTask());
            if (downloaderBuilder.getDownloadMonitorListener() != null) {
                ms(downloaderBuilder.getDownloadMonitorListener());
            }
        }
    }

    private static void am() {
        if (w == null) {
            w = new DownloadReceiver();
        }
        if (az) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            f4658ms.registerReceiver(w, intentFilter);
            az = true;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    static synchronized void ms() {
        try {
            if (az && w != null && f4658ms != null) {
                f4658ms.unregisterReceiver(w);
                az = false;
            }
        } catch (Exception e2) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e2);
        }
    }

    public static synchronized void xr() {
        if (of) {
            return;
        }
        of = true;
        try {
            Intent intent = new Intent(k(), (Class<?>) DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
            k().startService(intent);
            if (!com.ss.android.socialbase.downloader.ny.c.ah()) {
                com.ss.android.socialbase.downloader.impls.sl.ms(true).startService();
            }
        } catch (Throwable th) {
            of = false;
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    public static synchronized boolean ah() {
        return of;
    }

    public static IDownloadHttpService d() {
        return ch;
    }

    public static void ms(ul ulVar) {
        if (ulVar == null) {
            return;
        }
        synchronized (g) {
            g.add(ulVar);
        }
    }

    public static List<ul> ka() {
        List<ul> list;
        synchronized (g) {
            list = g;
        }
        return list;
    }

    public static void ms(com.ss.android.socialbase.downloader.depend.hi hiVar) {
        List<com.ss.android.socialbase.downloader.depend.hi> list = il;
        synchronized (list) {
            if (hiVar != null) {
                if (!list.contains(hiVar)) {
                    list.add(hiVar);
                }
            }
        }
    }

    public static void xr(com.ss.android.socialbase.downloader.depend.hi hiVar) {
        List<com.ss.android.socialbase.downloader.depend.hi> list = il;
        synchronized (list) {
            if (hiVar != null) {
                if (list.contains(hiVar)) {
                    list.remove(hiVar);
                }
            }
        }
    }

    public static void ms(com.ss.android.socialbase.downloader.constants.d dVar) {
        List<com.ss.android.socialbase.downloader.depend.hi> list = il;
        synchronized (list) {
            for (com.ss.android.socialbase.downloader.depend.hi hiVar : list) {
                if (hiVar != null && dVar != com.ss.android.socialbase.downloader.constants.d.SYNC_START && dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS) {
                    hiVar.ms();
                }
            }
            if (dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS) {
                il.clear();
            }
        }
    }

    public static void ms(DownloadTask downloadTask, int i2) {
        List<Object> list = qf;
        synchronized (list) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public static void xr(DownloadTask downloadTask, int i2) {
        List<Object> list = qf;
        synchronized (list) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public static com.ss.android.socialbase.downloader.network.x c() {
        return hi;
    }

    public static com.ss.android.socialbase.downloader.d.xr ab() {
        return le;
    }

    public static com.ss.android.socialbase.downloader.network.ny ms(boolean z, int i2, String str, List<com.ss.android.socialbase.downloader.model.ah> list) throws Exception {
        return ms(z, i2, str, null, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.ny ms(boolean z, int i2, String str, String str2, List<com.ss.android.socialbase.downloader.model.ah> list, int i3, boolean z2, DownloadInfo downloadInfo) throws Exception {
        List<com.ss.android.socialbase.downloader.model.ah> list2;
        int i4;
        if (!TextUtils.isEmpty(str2)) {
            List<com.ss.android.socialbase.downloader.model.ah> arrayList = list == null ? new ArrayList<>() : list;
            arrayList.add(new com.ss.android.socialbase.downloader.model.ah("ss_d_request_host_ip_114", str2));
            list2 = arrayList;
            i4 = 1;
        } else if (z) {
            list2 = list;
            i4 = i3;
        } else {
            i4 = 2;
            list2 = list;
        }
        int[] iArrMs = ms(i4);
        Exception exc = null;
        for (int i5 : iArrMs) {
            try {
                com.ss.android.socialbase.downloader.network.ny nyVarMs = ms(i2, str, str2, list2, i5, z2, downloadInfo);
                if (nyVarMs != null) {
                    return nyVarMs;
                }
            } catch (Exception e2) {
                if (downloadInfo.isExpiredRedownload() && com.ss.android.socialbase.downloader.ny.c.ab(e2) && com.ss.android.socialbase.downloader.ny.c.ah(list2)) {
                    com.ss.android.socialbase.downloader.ah.ms.ms("dcach::http exception 304, throw excepiton, not retry " + e2);
                    throw e2;
                }
                exc = e2;
            }
        }
        if (exc == null) {
            return null;
        }
        throw exc;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0046  */
    private static com.ss.android.socialbase.downloader.network.ny ms(int i2, String str, String str2, List<com.ss.android.socialbase.downloader.model.ah> list, int i3, boolean z, DownloadInfo downloadInfo) throws Throwable {
        IOException iOException;
        IDownloadHttpService iDownloadHttpServiceD = i3 == 1 ? d() : x();
        if (iDownloadHttpServiceD == null) {
            throw new BaseException(1022, new IOException("httpService not exist, netLib = " + i3));
        }
        IOException iOException2 = null;
        long jCurrentTimeMillis = 0;
        if (z) {
            try {
                jCurrentTimeMillis = System.currentTimeMillis();
            } catch (IOException e2) {
                e = e2;
                iOException2 = e;
                throw iOException2;
            } catch (Throwable th) {
                th = th;
                iOException = iOException2;
                if (z) {
                    com.ss.android.socialbase.downloader.d.ms.ms(null, str, str2, System.currentTimeMillis() - jCurrentTimeMillis, "get", i3, iOException, downloadInfo);
                }
                throw th;
            }
        }
        try {
            try {
                com.ss.android.socialbase.downloader.network.ny nyVarDownloadWithConnection = iDownloadHttpServiceD.downloadWithConnection(i2, str, list);
                if (z) {
                    com.ss.android.socialbase.downloader.d.ms.ms(nyVarDownloadWithConnection, str, str2, System.currentTimeMillis() - jCurrentTimeMillis, "get", i3, null, downloadInfo);
                }
                return nyVarDownloadWithConnection;
            } catch (IOException e3) {
                e = e3;
                iOException2 = e;
                throw iOException2;
            }
        } catch (Throwable th2) {
            th = th2;
            iOException = iOException2;
            if (z) {
                com.ss.android.socialbase.downloader.d.ms.ms(null, str, str2, System.currentTimeMillis() - jCurrentTimeMillis, "get", i3, iOException, downloadInfo);
            }
            throw th;
        }
    }

    public static com.ss.android.socialbase.downloader.network.ab ms(String str, List<com.ss.android.socialbase.downloader.model.ah> list) throws Exception {
        return ms(str, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.ab ms(String str, List<com.ss.android.socialbase.downloader.model.ah> list, int i2, boolean z, DownloadInfo downloadInfo) throws Exception {
        Exception e2 = null;
        for (int i3 : ms(i2)) {
            try {
                com.ss.android.socialbase.downloader.network.ab abVarXr = xr(str, list, i3, z, downloadInfo);
                if (abVarXr != null) {
                    return abVarXr;
                }
            } catch (Exception e3) {
                e2 = e3;
            }
        }
        if (e2 == null) {
            return null;
        }
        throw e2;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0047  */
    private static com.ss.android.socialbase.downloader.network.ab xr(String str, List<com.ss.android.socialbase.downloader.model.ah> list, int i2, boolean z, DownloadInfo downloadInfo) throws Throwable {
        IOException iOException;
        com.ss.android.socialbase.downloader.network.x xVarC = i2 == 1 ? c() : ny();
        if (xVarC == null) {
            throw new BaseException(1022, new IOException("httpService not exist, netLib = " + i2));
        }
        IOException iOException2 = null;
        long jCurrentTimeMillis = 0;
        if (z) {
            try {
                jCurrentTimeMillis = System.currentTimeMillis();
            } catch (IOException e2) {
                e = e2;
                iOException2 = e;
                throw iOException2;
            } catch (Throwable th) {
                th = th;
                iOException = iOException2;
                if (z) {
                    com.ss.android.socialbase.downloader.d.ms.ms(null, str, null, System.currentTimeMillis() - jCurrentTimeMillis, "head", i2, iOException, downloadInfo);
                }
                throw th;
            }
        }
        try {
            try {
                com.ss.android.socialbase.downloader.network.ab abVarMs = xVarC.ms(str, list);
                if (z) {
                    com.ss.android.socialbase.downloader.d.ms.ms(abVarMs, str, null, System.currentTimeMillis() - jCurrentTimeMillis, "head", i2, null, downloadInfo);
                }
                return abVarMs;
            } catch (IOException e3) {
                e = e3;
                iOException2 = e;
                throw iOException2;
            }
        } catch (Throwable th2) {
            th = th2;
            iOException = iOException2;
            if (z) {
                com.ss.android.socialbase.downloader.d.ms.ms(null, str, null, System.currentTimeMillis() - jCurrentTimeMillis, "head", i2, iOException, downloadInfo);
            }
            throw th;
        }
    }

    private static int[] ms(int i2) {
        if (i2 == 1) {
            return new int[]{0};
        }
        if (i2 != 2) {
            return i2 != 3 ? new int[]{1, 0} : new int[]{0, 1};
        }
        return new int[]{1};
    }

    public static IDownloadHttpService x() {
        if (sl == null) {
            synchronized (ah.class) {
                if (sl == null) {
                    sl = new com.ss.android.socialbase.downloader.impls.ab();
                }
            }
        }
        return sl;
    }

    public static com.ss.android.socialbase.downloader.network.x ny() {
        if (zb == null) {
            synchronized (ah.class) {
                if (zb == null) {
                    zb = new com.ss.android.socialbase.downloader.impls.c();
                }
            }
        }
        return zb;
    }

    public static synchronized void ms(sl slVar) {
        if (slVar != null) {
            u = slVar;
            if (xr instanceof com.ss.android.socialbase.downloader.impls.d) {
                ((com.ss.android.socialbase.downloader.impls.d) xr).x();
            }
        }
    }

    private static void ah(ExecutorService executorService) {
        if (executorService != null) {
            ub = executorService;
        }
    }

    private static void d(ExecutorService executorService) {
        if (executorService != null) {
            ao = executorService;
        }
    }

    private static void ka(ExecutorService executorService) {
        if (executorService != null) {
            h = executorService;
        }
    }

    private static void c(ExecutorService executorService) {
        if (executorService != null) {
            qv = executorService;
        }
    }

    private static void ab(ExecutorService executorService) {
        if (executorService != null) {
            y = executorService;
        }
    }

    private static void x(ExecutorService executorService) {
        if (executorService != null) {
            t = executorService;
        }
    }

    public static void ms(ExecutorService executorService) {
        if (executorService != null) {
            nw = executorService;
        }
    }

    public static void xr(ExecutorService executorService) {
        if (executorService != null) {
            b = executorService;
        }
    }

    private static void ms(List<com.ss.android.socialbase.downloader.depend.zb> list) {
        List<com.ss.android.socialbase.downloader.depend.zb> list2 = ul;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    public static void ms(boolean z) {
        sa = z;
    }

    public static boolean ch() {
        return com.ss.android.socialbase.downloader.ab.ms.ah().ms("switch_not_auto_boot_service", sa ? 1 : 0) > 0;
    }

    public static synchronized h hi() {
        return op;
    }

    public static void ms(Runnable runnable) {
        ms(runnable, false);
    }

    public static void xr(Runnable runnable) {
        xr(runnable, false);
    }

    public static void ms(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !com.ss.android.socialbase.downloader.ny.c.d()) {
            runnable.run();
        } else {
            sl().execute(runnable);
        }
    }

    public static void xr(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !com.ss.android.socialbase.downloader.ny.c.d()) {
            runnable.run();
        } else {
            zb().execute(runnable);
        }
    }

    public static void ah(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.ny.c.d()) {
            runnable.run();
        } else {
            qv().execute(runnable);
        }
    }

    public static Future ms(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            return null;
        }
        return t().schedule(runnable, j, timeUnit);
    }

    public static ExecutorService sl() {
        if (ub == null) {
            synchronized (ah.class) {
                if (ub == null) {
                    int i2 = lm;
                    com.bytedance.sdk.component.ch.d.d dVar = new com.bytedance.sdk.component.ch.d.d(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.x.ms("DownloadThreadPool-cpu-fixed", true));
                    try {
                        dVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.api.ab.ms(th);
                    }
                    ub = dVar;
                }
            }
        }
        return ub;
    }

    public static ExecutorService zb() {
        return ao != null ? ao : sl();
    }

    public static ExecutorService u() {
        return qv != null ? qv : ao();
    }

    public static ExecutorService ub() {
        return y != null ? y : ao();
    }

    public static ExecutorService ao() {
        if (h == null) {
            synchronized (ah.class) {
                if (h == null) {
                    int i2 = k;
                    com.bytedance.sdk.component.ch.d.d dVar = new com.bytedance.sdk.component.ch.d.d(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.x.ms("DownloadThreadPool-mix-fixed", true));
                    try {
                        dVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.api.ab.ms(th);
                    }
                    h = dVar;
                }
            }
        }
        return h;
    }

    public static ExecutorService h() {
        if (nw == null) {
            synchronized (ah.class) {
                if (nw == null) {
                    int i2 = e;
                    com.bytedance.sdk.component.ch.d.d dVar = new com.bytedance.sdk.component.ch.d.d(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.x.ms("DownloadThreadPool-chunk-fixed", true));
                    try {
                        dVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.api.ab.ms(th);
                    }
                    nw = dVar;
                }
            }
        }
        return nw;
    }

    public static ExecutorService qv() {
        if (t == null) {
            synchronized (ah.class) {
                if (t == null) {
                    int i2 = eg;
                    com.bytedance.sdk.component.ch.d.d dVar = new com.bytedance.sdk.component.ch.d.d(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.x.ms("DownloadThreadPool-db-fixed", true));
                    try {
                        dVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.api.ab.ms(th);
                    }
                    t = dVar;
                }
            }
        }
        return t;
    }

    public static OkHttpClient y() {
        if (p == null) {
            synchronized (ah.class) {
                if (p == null) {
                    p = nw().build();
                }
            }
        }
        return p;
    }

    public static ScheduledExecutorService t() {
        if (re == null) {
            synchronized (ah.class) {
                if (re == null) {
                    re = new com.bytedance.sdk.component.ch.d.ka(1, new com.ss.android.socialbase.downloader.x.ms("DownloadThreadPool-Schedule", true));
                }
            }
        }
        return re;
    }

    public static OkHttpClient.Builder nw() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (b != null) {
            builder.dispatcher(new Dispatcher(b));
        }
        return builder;
    }

    public static com.ss.android.socialbase.downloader.network.c b() {
        return pc;
    }

    public static com.ss.android.socialbase.downloader.network.c re() {
        if (jw == null) {
            synchronized (ah.class) {
                if (jw == null) {
                    jw = new com.ss.android.socialbase.downloader.network.c() { // from class: com.ss.android.socialbase.downloader.downloader.ah.2
                        @Override // com.ss.android.socialbase.downloader.network.c
                        public List<InetAddress> ms(String str) throws UnknownHostException {
                            return Dns.SYSTEM.lookup(str);
                        }
                    };
                }
            }
        }
        return jw;
    }

    public static synchronized sl i() {
        return u;
    }

    public static void ms(IDownloadHttpService iDownloadHttpService) {
        if (iDownloadHttpService != null) {
            ch = iDownloadHttpService;
        }
        xn = ch != null;
    }

    public static void ms(com.ss.android.socialbase.downloader.network.x xVar) {
        if (xVar != null) {
            hi = xVar;
        }
    }

    public static ch w() {
        if (xr == null) {
            synchronized (ah.class) {
                if (xr == null) {
                    xr = new com.ss.android.socialbase.downloader.impls.d();
                }
            }
        }
        return xr;
    }

    private static void ms(ch chVar) {
        if (chVar != null) {
            xr = chVar;
        }
    }

    public static ub yu() {
        if (ab == null) {
            synchronized (ah.class) {
                if (ab == null) {
                    ab = new com.ss.android.socialbase.downloader.impls.x();
                }
            }
        }
        return ab;
    }

    public static ub op() {
        if (x == null) {
            synchronized (ah.class) {
                if (x == null) {
                    x = ny.ms();
                }
            }
        }
        return x;
    }

    public static List<com.ss.android.socialbase.downloader.depend.zb> le() {
        return ul;
    }

    public static hi cv() {
        if (ah == null) {
            synchronized (ah.class) {
                if (ah == null) {
                    ah = new com.ss.android.socialbase.downloader.impls.ny();
                }
            }
        }
        return ah;
    }

    public static com.ss.android.socialbase.downloader.impls.ms g() {
        if (c == null) {
            synchronized (ah.class) {
                if (c == null) {
                    c = new com.ss.android.socialbase.downloader.impls.ka();
                }
            }
        }
        return c;
    }

    private static void ms(hi hiVar) {
        if (hiVar != null) {
            ah = hiVar;
        }
    }

    private static void xr(int i2) {
        if (i2 > 0) {
            m = i2;
        }
    }

    private static void ms(com.ss.android.socialbase.downloader.d.xr xrVar) {
        if (xrVar != null) {
            le = xrVar;
        }
    }

    public static int of() {
        return l;
    }

    public static JSONObject p() {
        if (cv == null || cv.ms() == null) {
            return com.ss.android.socialbase.downloader.constants.ka.ny;
        }
        return cv.ms();
    }

    public static void pc() {
        if (TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.ka.ah)) {
            com.ss.android.socialbase.downloader.constants.ka.ah = "oppo";
            com.ss.android.socialbase.downloader.constants.ka.xr = "oppo".toUpperCase();
        }
    }

    public static void ms(op opVar) {
        cv = opVar;
        com.ss.android.socialbase.downloader.ab.ms.ms();
    }

    private static void xr(boolean z) {
        am = z;
    }

    public static boolean jw() {
        return am;
    }

    public static synchronized int f() {
        return fm;
    }

    public static x ul() {
        if (d == null) {
            synchronized (ah.class) {
                if (d == null) {
                    d = new com.ss.android.socialbase.downloader.impls.ah();
                }
            }
        }
        return d;
    }

    private static void ms(x xVar) {
        if (xVar != null) {
            d = xVar;
        }
    }

    public static void ms(of ofVar) {
        if (ofVar != null) {
            ka = ofVar;
        }
    }

    public static of az() {
        return ka;
    }

    public static ab m() {
        if (i == null) {
            synchronized (ah.class) {
                if (i == null) {
                    i = new com.ss.android.socialbase.downloader.impls.xr();
                }
            }
        }
        return i;
    }

    private static void ms(ab abVar) {
        if (abVar != null) {
            i = abVar;
        }
    }

    public static y lm() {
        if (yu == null) {
            synchronized (ah.class) {
                if (yu == null) {
                    yu = new com.ss.android.socialbase.downloader.impls.ch();
                }
            }
        }
        return yu;
    }

    public static nw e() {
        if (f == null) {
            synchronized (ah.class) {
                if (f == null) {
                    f = new nw.ms();
                }
            }
        }
        return f;
    }

    public static synchronized Context k() {
        return f4658ms;
    }

    public static synchronized void ms(Context context) {
        if (context != null) {
            if (f4658ms == null) {
                f4658ms = context.getApplicationContext();
                com.ss.android.socialbase.downloader.ms.ms.ms().ms(f4658ms);
            }
        }
    }

    public static int ms(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        String taskKey = downloadInfo.getTaskKey();
        if (TextUtils.isEmpty(taskKey)) {
            taskKey = downloadInfo.getUrl();
        }
        return ms(taskKey, downloadInfo.getSavePath());
    }

    public static int ms(String str, String str2) {
        hi hiVarCv = cv();
        if (hiVarCv == null) {
            return 0;
        }
        return hiVarCv.ms(str, str2);
    }

    public static synchronized boolean eg() {
        return xn;
    }

    public static com.ss.android.socialbase.downloader.d.ah fm() {
        if (ti == null) {
            ti = new com.ss.android.socialbase.downloader.d.ah() { // from class: com.ss.android.socialbase.downloader.downloader.ah.3
                @Override // com.ss.android.socialbase.downloader.d.ah
                public void ms(int i2, String str, JSONObject jSONObject) {
                }

                @Override // com.ss.android.socialbase.downloader.d.ah
                public void xr(int i2, String str, JSONObject jSONObject) {
                }
            };
        }
        return ti;
    }

    public static qv xn() {
        return tz;
    }

    public static void ms(com.ss.android.socialbase.downloader.d.ah ahVar) {
        ti = ahVar;
    }

    public static boolean il() {
        return s;
    }

    public static void ms(ms msVar) {
        com.ss.android.socialbase.downloader.ah.ms.ms("wjd", "setIndependentServiceCreator::creator=" + msVar);
        ny = msVar;
    }

    public static boolean qf() {
        com.ss.android.socialbase.downloader.ah.ms.ms("wjd", "supportMultiProc::=" + (ny != null));
        return ny != null;
    }

    public static ms l() {
        return ny;
    }
}
