package com.byazt.xv;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.byazt.i.DownloadHandleService;
import com.byazt.je.f;
import com.byazt.je.lh;
import com.byazt.je.t;
import com.byazt.m.IDownloadHttpService;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import com.byazt.wm.DownloadTask;
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

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 41, 8})
public class s {
    public static volatile ExecutorService a;
    public static volatile py ae;
    public static volatile com.byazt.m.w an;
    public static boolean b;
    public static volatile t bb;
    public static volatile ExecutorService cd;
    public static volatile com.byazt.m.fs cp;
    public static volatile ExecutorService cy;
    public static volatile IDownloadHttpService d;
    public static int df;
    public static final int dg;
    public static int dh;
    public static volatile boolean e;
    public static volatile k fs;
    public static volatile um h;
    public static volatile ExecutorService hd;
    public static volatile DownloadReceiver hu;
    public static volatile com.byazt.m.w j;
    public static volatile ExecutorService k;
    public static volatile lh l;
    public static volatile x m;
    public static volatile Context n;
    public static cd nf;
    public static volatile com.byazt.m.fs oa;
    public static final int oj;
    public static volatile ExecutorService ou;
    public static com.byazt.g.s pe;
    public static final int pk;
    public static volatile ExecutorService py;
    public static volatile fs q;
    public static volatile tj qg;
    public static final List<Object> rf;
    public static boolean ri;
    public static volatile n rv;
    public static volatile cp s;
    public static boolean sh;
    public static volatile d sz;
    public static volatile hd t;
    public static volatile IDownloadHttpService tj;
    public static final int u;
    public static volatile ExecutorService um;
    public static volatile com.byazt.g.qg ur;
    public static volatile com.byazt.i.n w;
    public static volatile ScheduledExecutorService wm;
    public static int wo;
    public static volatile k x;
    public static final List<com.byazt.je.cp> y;
    public static volatile List<f> ln = new ArrayList();
    public static volatile boolean lh = false;
    public static volatile OkHttpClient v = null;
    public static final List<com.byazt.je.oa> f = new ArrayList();
    public static boolean fi = false;

    public interface n {

        /* JADX INFO: renamed from: com.byazt.xv.s$n$n, reason: collision with other inner class name */
        public interface InterfaceC0397n {
            void n();
        }

        a n(InterfaceC0397n interfaceC0397n);

        k n();

        oa qg();
    }

    public static void n(cd cdVar) {
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        oj = iAvailableProcessors;
        dg = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        u = iAvailableProcessors;
        pk = iAvailableProcessors;
        wo = 8192;
        y = new ArrayList();
        rf = new ArrayList();
        b = true;
        ri = false;
        e = false;
    }

    private s() {
    }

    public static synchronized void n(DownloaderBuilder downloaderBuilder) {
        if (e) {
            com.byazt.fe.n.l("DownloadComponentManager", "component has init");
            return;
        }
        boolean z = lh;
        s(downloaderBuilder);
        if (qg == null) {
            qg = new com.byazt.i.q();
        }
        if (x == null) {
            x = new com.byazt.i.fs();
        }
        if (fs == null && rv != null) {
            fs = rv.n();
        }
        if (s == null) {
            s = new com.byazt.i.rv();
        }
        if (w == null) {
            w = new com.byazt.i.l();
        }
        if (q == null) {
            q = new com.byazt.i.s();
        }
        if (m == null) {
            m = new com.byazt.i.qg();
        }
        if (h == null) {
            h = new com.byazt.i.tj();
        }
        int i = df;
        if (i <= 0 || i > oj) {
            df = oj;
        }
        b();
        if (lh && !z && !com.byazt.ta.w.s()) {
            com.byazt.i.d.n(true).startService();
        } else if (com.byazt.ta.w.q()) {
            ExecutorService executorServiceOa = oa();
            if (executorServiceOa != null) {
                executorServiceOa.execute(new Runnable() { // from class: com.byazt.xv.s.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Context contextU = s.u();
                        if (contextU != null) {
                            com.byazt.ta.w.q(contextU);
                        }
                    }
                });
            }
        } else {
            Context contextU = u();
            if (contextU != null) {
                com.byazt.ta.w.q(contextU);
            }
        }
        j();
        e = true;
    }

    public static synchronized void qg(DownloaderBuilder downloaderBuilder) {
        s(downloaderBuilder);
    }

    private static void s(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder != null) {
            if (downloaderBuilder.getContext() != null) {
                n(downloaderBuilder.getContext());
            }
            if (downloaderBuilder.getDownloadCache() != null) {
                n(downloaderBuilder.getDownloadCache());
            }
            if (downloaderBuilder.getIdGenerator() != null) {
                n(downloaderBuilder.getIdGenerator());
            }
            if (downloaderBuilder.getChunkCntCalculator() != null) {
                n(downloaderBuilder.getChunkCntCalculator());
            }
            if (downloaderBuilder.getNotificationClickCallback() != null) {
                n(downloaderBuilder.getNotificationClickCallback());
            }
            if (downloaderBuilder.getMaxDownloadPoolSize() != 0) {
                qg(downloaderBuilder.getMaxDownloadPoolSize());
            }
            if (downloaderBuilder.getHttpService() != null) {
                n(downloaderBuilder.getHttpService());
            }
            if (downloaderBuilder.getHeadHttpService() != null) {
                n(downloaderBuilder.getHeadHttpService());
            }
            if (downloaderBuilder.getDownloadLaunchHandler() != null) {
                n(downloaderBuilder.getDownloadLaunchHandler());
            }
            if (downloaderBuilder.getCPUThreadExecutor() != null) {
                s(downloaderBuilder.getCPUThreadExecutor());
            }
            if (downloaderBuilder.getIOThreadExecutor() != null) {
                q(downloaderBuilder.getIOThreadExecutor());
            }
            if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
                l(downloaderBuilder.getMixDefaultDownloadExecutor());
            }
            if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
                w(downloaderBuilder.getMixFrequentDownloadExecutor());
            }
            if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
                x(downloaderBuilder.getMixApkDownloadExecutor());
            }
            if (downloaderBuilder.getDBThreadExecutor() != null) {
                fs(downloaderBuilder.getDBThreadExecutor());
            }
            if (downloaderBuilder.getChunkThreadExecutor() != null) {
                n(downloaderBuilder.getChunkThreadExecutor());
            }
            if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
                qg(downloaderBuilder.getOkHttpDispatcherExecutor());
            }
            if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
                n(downloaderBuilder.getDownloadCompleteHandlers());
            }
            if (downloaderBuilder.getMonitorConfig() != null) {
                t = downloaderBuilder.getMonitorConfig();
            }
            if (downloaderBuilder.getWriteBufferSize() > 1024) {
                wo = downloaderBuilder.getWriteBufferSize();
            }
            if (downloaderBuilder.getChunkAdjustCalculator() != null) {
                n(downloaderBuilder.getChunkAdjustCalculator());
            }
            if (downloaderBuilder.isDownloadInMultiProcess()) {
                lh = true;
            }
            if (downloaderBuilder.getDownloadExpSwitch() != 0) {
                dh = downloaderBuilder.getDownloadExpSwitch();
            }
            if (downloaderBuilder.getDownloadSetting() != null) {
                n(downloaderBuilder.getDownloadSetting());
            }
            if (downloaderBuilder.getDownloadDns() != null) {
                j = downloaderBuilder.getDownloadDns();
            }
            if (downloaderBuilder.getTTNetHandler() != null) {
                py tTNetHandler = downloaderBuilder.getTTNetHandler();
                ae = tTNetHandler;
                if (tTNetHandler.n()) {
                    n(ae.qg());
                    n(ae.s());
                } else {
                    n(fs());
                    n(rv());
                }
            }
            qg(downloaderBuilder.needAutoRefreshUnSuccessTask());
            if (downloaderBuilder.getDownloadMonitorListener() != null) {
                n(downloaderBuilder.getDownloadMonitorListener());
            }
        }
    }

    private static void b() {
        if (hu == null) {
            hu = new DownloadReceiver();
        }
        if (fi) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            n.registerReceiver(hu, intentFilter);
            fi = true;
        } catch (Throwable unused) {
        }
    }

    public static synchronized void n() {
        try {
            if (fi && hu != null && n != null) {
                n.unregisterReceiver(hu);
                fi = false;
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void qg() {
        if (lh) {
            return;
        }
        lh = true;
        try {
            Intent intent = new Intent(u(), (Class<?>) DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
            u().startService(intent);
            if (!com.byazt.ta.w.s()) {
                com.byazt.i.d.n(true).startService();
            }
        } catch (Throwable unused) {
            lh = false;
        }
    }

    public static synchronized boolean s() {
        return lh;
    }

    public static IDownloadHttpService q() {
        return tj;
    }

    public static void n(f fVar) {
        if (fVar == null) {
            return;
        }
        synchronized (ln) {
            ln.add(fVar);
        }
    }

    public static List<f> l() {
        List<f> list;
        synchronized (ln) {
            list = ln;
        }
        return list;
    }

    public static void n(com.byazt.je.cp cpVar) {
        List<com.byazt.je.cp> list = y;
        synchronized (list) {
            if (cpVar != null) {
                if (!list.contains(cpVar)) {
                    list.add(cpVar);
                }
            }
        }
    }

    public static void qg(com.byazt.je.cp cpVar) {
        List<com.byazt.je.cp> list = y;
        synchronized (list) {
            if (cpVar != null) {
                if (list.contains(cpVar)) {
                    list.remove(cpVar);
                }
            }
        }
    }

    public static void n(com.byazt.sk.q qVar) {
        List<com.byazt.je.cp> list = y;
        synchronized (list) {
            for (com.byazt.je.cp cpVar : list) {
                if (cpVar != null && qVar != com.byazt.sk.q.SYNC_START && qVar == com.byazt.sk.q.SYNC_SUCCESS) {
                    cpVar.n();
                }
            }
            if (qVar == com.byazt.sk.q.SYNC_SUCCESS) {
                y.clear();
            }
        }
    }

    public static void n(DownloadTask downloadTask, int i) {
        List<Object> list = rf;
        synchronized (list) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public static void qg(DownloadTask downloadTask, int i) {
        List<Object> list = rf;
        synchronized (list) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public static com.byazt.m.fs w() {
        return cp;
    }

    public static com.byazt.g.qg x() {
        return ur;
    }

    public static com.byazt.m.rv n(boolean z, int i, String str, List<com.byazt.wm.s> list) throws Exception {
        return n(z, i, str, null, list, 0, false, null);
    }

    public static com.byazt.m.rv n(boolean z, int i, String str, String str2, List<com.byazt.wm.s> list, int i2, boolean z2, DownloadInfo downloadInfo) throws Exception {
        List<com.byazt.wm.s> list2;
        int i3;
        if (!TextUtils.isEmpty(str2)) {
            List<com.byazt.wm.s> arrayList = list == null ? new ArrayList<>() : list;
            arrayList.add(new com.byazt.wm.s("ss_d_request_host_ip_114", str2));
            list2 = arrayList;
            i3 = 1;
        } else if (z) {
            list2 = list;
            i3 = i2;
        } else {
            i3 = 2;
            list2 = list;
        }
        int[] iArrN = n(i3);
        Exception exc = null;
        for (int i4 : iArrN) {
            try {
                com.byazt.m.rv rvVarN = n(i, str, str2, list2, i4, z2, downloadInfo);
                if (rvVarN != null) {
                    return rvVarN;
                }
            } catch (Exception e2) {
                if (downloadInfo.isExpiredRedownload() && com.byazt.ta.w.x(e2) && com.byazt.ta.w.s(list2)) {
                    com.byazt.fe.n.n("dcach::http exception 304, throw excepiton, not retry " + e2);
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
    private static com.byazt.m.rv n(int i, String str, String str2, List<com.byazt.wm.s> list, int i2, boolean z, DownloadInfo downloadInfo) throws Throwable {
        IOException iOException;
        IDownloadHttpService iDownloadHttpServiceQ = i2 == 1 ? q() : fs();
        if (iDownloadHttpServiceQ == null) {
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
                    com.byazt.g.n.n(null, str, str2, System.currentTimeMillis() - jCurrentTimeMillis, "get", i2, iOException, downloadInfo);
                }
                throw th;
            }
        }
        try {
            try {
                com.byazt.m.rv rvVarDownloadWithConnection = iDownloadHttpServiceQ.downloadWithConnection(i, str, list);
                if (z) {
                    com.byazt.g.n.n(rvVarDownloadWithConnection, str, str2, System.currentTimeMillis() - jCurrentTimeMillis, "get", i2, null, downloadInfo);
                }
                return rvVarDownloadWithConnection;
            } catch (IOException e3) {
                e = e3;
                iOException2 = e;
                throw iOException2;
            }
        } catch (Throwable th2) {
            th = th2;
            iOException = iOException2;
            if (z) {
                com.byazt.g.n.n(null, str, str2, System.currentTimeMillis() - jCurrentTimeMillis, "get", i2, iOException, downloadInfo);
            }
            throw th;
        }
    }

    public static com.byazt.m.x n(String str, List<com.byazt.wm.s> list) throws Exception {
        return n(str, list, 0, false, null);
    }

    public static com.byazt.m.x n(String str, List<com.byazt.wm.s> list, int i, boolean z, DownloadInfo downloadInfo) throws Exception {
        Exception e2 = null;
        for (int i2 : n(i)) {
            try {
                com.byazt.m.x xVarQg = qg(str, list, i2, z, downloadInfo);
                if (xVarQg != null) {
                    return xVarQg;
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
    private static com.byazt.m.x qg(String str, List<com.byazt.wm.s> list, int i, boolean z, DownloadInfo downloadInfo) throws Throwable {
        IOException iOException;
        com.byazt.m.fs fsVarW = i == 1 ? w() : rv();
        if (fsVarW == null) {
            throw new BaseException(1022, new IOException("httpService not exist, netLib = " + i));
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
                    com.byazt.g.n.n(null, str, null, System.currentTimeMillis() - jCurrentTimeMillis, "head", i, iOException, downloadInfo);
                }
                throw th;
            }
        }
        try {
            try {
                com.byazt.m.x xVarN = fsVarW.n(str, list);
                if (z) {
                    com.byazt.g.n.n(xVarN, str, null, System.currentTimeMillis() - jCurrentTimeMillis, "head", i, null, downloadInfo);
                }
                return xVarN;
            } catch (IOException e3) {
                e = e3;
                iOException2 = e;
                throw iOException2;
            }
        } catch (Throwable th2) {
            th = th2;
            iOException = iOException2;
            if (z) {
                com.byazt.g.n.n(null, str, null, System.currentTimeMillis() - jCurrentTimeMillis, "head", i, iOException, downloadInfo);
            }
            throw th;
        }
    }

    private static int[] n(int i) {
        if (i == 1) {
            return new int[]{0};
        }
        if (i != 2) {
            return i != 3 ? new int[]{1, 0} : new int[]{0, 1};
        }
        return new int[]{1};
    }

    public static IDownloadHttpService fs() {
        if (d == null) {
            synchronized (s.class) {
                if (d == null) {
                    d = new com.byazt.i.x();
                }
            }
        }
        return d;
    }

    public static com.byazt.m.fs rv() {
        if (oa == null) {
            synchronized (s.class) {
                if (oa == null) {
                    oa = new com.byazt.i.w();
                }
            }
        }
        return oa;
    }

    public static synchronized void n(d dVar) {
        if (dVar != null) {
            sz = dVar;
            if (qg instanceof com.byazt.i.q) {
                ((com.byazt.i.q) qg).fs();
            }
        }
    }

    private static void s(ExecutorService executorService) {
        if (executorService != null) {
            k = executorService;
        }
    }

    private static void q(ExecutorService executorService) {
        if (executorService != null) {
            cy = executorService;
        }
    }

    private static void l(ExecutorService executorService) {
        if (executorService != null) {
            hd = executorService;
        }
    }

    private static void w(ExecutorService executorService) {
        if (executorService != null) {
            cd = executorService;
        }
    }

    private static void x(ExecutorService executorService) {
        if (executorService != null) {
            um = executorService;
        }
    }

    private static void fs(ExecutorService executorService) {
        if (executorService != null) {
            a = executorService;
        }
    }

    public static void n(ExecutorService executorService) {
        if (executorService != null) {
            py = executorService;
        }
    }

    public static void qg(ExecutorService executorService) {
        if (executorService != null) {
            ou = executorService;
        }
    }

    private static void n(List<com.byazt.je.oa> list) {
        List<com.byazt.je.oa> list2 = f;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    public static void n(boolean z) {
        ri = z;
    }

    public static boolean tj() {
        return com.byazt.f.n.s().n("switch_not_auto_boot_service", ri ? 1 : 0) > 0;
    }

    public static synchronized hd cp() {
        return t;
    }

    public static void n(Runnable runnable) {
        n(runnable, false);
    }

    public static void qg(Runnable runnable) {
        qg(runnable, false);
    }

    public static void n(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !com.byazt.ta.w.q()) {
            runnable.run();
        } else {
            d().execute(runnable);
        }
    }

    public static void qg(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !com.byazt.ta.w.q()) {
            runnable.run();
        } else {
            oa().execute(runnable);
        }
    }

    public static void s(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!com.byazt.ta.w.q()) {
            runnable.run();
        } else {
            cd().execute(runnable);
        }
    }

    public static Future n(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (runnable == null) {
            return null;
        }
        return a().schedule(runnable, j2, timeUnit);
    }

    public static ExecutorService d() {
        if (k == null) {
            synchronized (s.class) {
                if (k == null) {
                    int i = oj;
                    com.byazt.xis.q qVar = new com.byazt.xis.q(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.byazt.l.n("DownloadThreadPool-cpu-fixed", true));
                    try {
                        qVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable unused) {
                    }
                    k = qVar;
                }
            }
        }
        return k;
    }

    public static ExecutorService oa() {
        return cy != null ? cy : d();
    }

    public static ExecutorService sz() {
        return cd != null ? cd : cy();
    }

    public static ExecutorService k() {
        return um != null ? um : cy();
    }

    public static ExecutorService cy() {
        if (hd == null) {
            synchronized (s.class) {
                if (hd == null) {
                    int i = u;
                    com.byazt.xis.q qVar = new com.byazt.xis.q(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.byazt.l.n("DownloadThreadPool-mix-fixed", true));
                    try {
                        qVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable unused) {
                    }
                    hd = qVar;
                }
            }
        }
        return hd;
    }

    public static ExecutorService hd() {
        if (py == null) {
            synchronized (s.class) {
                if (py == null) {
                    int i = dg;
                    com.byazt.xis.q qVar = new com.byazt.xis.q(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.byazt.l.n("DownloadThreadPool-chunk-fixed", true));
                    try {
                        qVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable unused) {
                    }
                    py = qVar;
                }
            }
        }
        return py;
    }

    public static ExecutorService cd() {
        if (a == null) {
            synchronized (s.class) {
                if (a == null) {
                    int i = pk;
                    com.byazt.xis.q qVar = new com.byazt.xis.q(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.byazt.l.n("DownloadThreadPool-db-fixed", true));
                    try {
                        qVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable unused) {
                    }
                    a = qVar;
                }
            }
        }
        return a;
    }

    public static OkHttpClient um() {
        if (v == null) {
            synchronized (s.class) {
                if (v == null) {
                    v = py().build();
                }
            }
        }
        return v;
    }

    public static ScheduledExecutorService a() {
        if (wm == null) {
            synchronized (s.class) {
                if (wm == null) {
                    wm = new com.byazt.xis.l(1, new com.byazt.l.n("DownloadThreadPool-Schedule", true));
                }
            }
        }
        return wm;
    }

    public static OkHttpClient.Builder py() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (ou != null) {
            builder.dispatcher(new Dispatcher(ou));
        }
        return builder;
    }

    public static com.byazt.m.w ou() {
        return j;
    }

    public static com.byazt.m.w wm() {
        if (an == null) {
            synchronized (s.class) {
                if (an == null) {
                    an = new com.byazt.m.w() { // from class: com.byazt.xv.s.2
                        @Override // com.byazt.m.w
                        public List<InetAddress> n(String str) throws UnknownHostException {
                            return Dns.SYSTEM.lookup(str);
                        }
                    };
                }
            }
        }
        return an;
    }

    public static synchronized d m() {
        return sz;
    }

    public static void n(IDownloadHttpService iDownloadHttpService) {
        if (iDownloadHttpService != null) {
            tj = iDownloadHttpService;
        }
        sh = tj != null;
    }

    public static void n(com.byazt.m.fs fsVar) {
        if (fsVar != null) {
            cp = fsVar;
        }
    }

    public static tj hu() {
        if (qg == null) {
            synchronized (s.class) {
                if (qg == null) {
                    qg = new com.byazt.i.q();
                }
            }
        }
        return qg;
    }

    private static void n(tj tjVar) {
        if (tjVar != null) {
            qg = tjVar;
        }
    }

    public static k h() {
        if (x == null) {
            synchronized (s.class) {
                if (x == null) {
                    x = new com.byazt.i.fs();
                }
            }
        }
        return x;
    }

    public static k t() {
        if (fs == null) {
            synchronized (s.class) {
                if (fs == null) {
                    fs = rv.n();
                }
            }
        }
        return fs;
    }

    public static List<com.byazt.je.oa> ur() {
        return f;
    }

    public static cp bb() {
        if (s == null) {
            synchronized (s.class) {
                if (s == null) {
                    s = new com.byazt.i.rv();
                }
            }
        }
        return s;
    }

    public static com.byazt.i.n ln() {
        if (w == null) {
            synchronized (s.class) {
                if (w == null) {
                    w = new com.byazt.i.l();
                }
            }
        }
        return w;
    }

    private static void n(cp cpVar) {
        if (cpVar != null) {
            s = cpVar;
        }
    }

    private static void qg(int i) {
        if (i > 0) {
            df = i;
        }
    }

    private static void n(com.byazt.g.qg qgVar) {
        if (qgVar != null) {
            ur = qgVar;
        }
    }

    public static int lh() {
        return dh;
    }

    public static JSONObject v() {
        if (bb == null || bb.n() == null) {
            return com.byazt.sk.l.rv;
        }
        return bb.n();
    }

    public static void j() {
        if (TextUtils.isEmpty(com.byazt.sk.l.s)) {
            com.byazt.sk.l.s = "oppo";
            com.byazt.sk.l.qg = "oppo".toUpperCase();
        }
    }

    public static void n(t tVar) {
        bb = tVar;
        com.byazt.f.n.n();
    }

    private static void qg(boolean z) {
        b = z;
    }

    public static boolean an() {
        return b;
    }

    public static synchronized int ae() {
        return wo;
    }

    public static fs f() {
        if (q == null) {
            synchronized (s.class) {
                if (q == null) {
                    q = new com.byazt.i.s();
                }
            }
        }
        return q;
    }

    private static void n(fs fsVar) {
        if (fsVar != null) {
            q = fsVar;
        }
    }

    public static void n(lh lhVar) {
        if (lhVar != null) {
            l = lhVar;
        }
    }

    public static lh fi() {
        return l;
    }

    public static x df() {
        if (m == null) {
            synchronized (s.class) {
                if (m == null) {
                    m = new com.byazt.i.qg();
                }
            }
        }
        return m;
    }

    private static void n(x xVar) {
        if (xVar != null) {
            m = xVar;
        }
    }

    public static um oj() {
        if (h == null) {
            synchronized (s.class) {
                if (h == null) {
                    h = new com.byazt.i.tj();
                }
            }
        }
        return h;
    }

    public static py dg() {
        if (ae == null) {
            synchronized (s.class) {
                if (ae == null) {
                    ae = new py.n();
                }
            }
        }
        return ae;
    }

    public static synchronized Context u() {
        return n;
    }

    public static synchronized void n(Context context) {
        if (context != null) {
            if (n == null) {
                n = context.getApplicationContext();
                com.byazt.b.n.n().n(n);
            }
        }
    }

    public static int n(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        String taskKey = downloadInfo.getTaskKey();
        if (TextUtils.isEmpty(taskKey)) {
            taskKey = downloadInfo.getUrl();
        }
        return n(taskKey, downloadInfo.getSavePath());
    }

    public static int n(String str, String str2) {
        cp cpVarBb = bb();
        if (cpVarBb == null) {
            return 0;
        }
        return cpVarBb.n(str, str2);
    }

    public static synchronized boolean pk() {
        return sh;
    }

    public static com.byazt.g.s wo() {
        if (pe == null) {
            pe = new com.byazt.g.s() { // from class: com.byazt.xv.s.3
                @Override // com.byazt.g.s
                public void n(int i, String str, JSONObject jSONObject) {
                }

                @Override // com.byazt.g.s
                public void qg(int i, String str, JSONObject jSONObject) {
                }
            };
        }
        return pe;
    }

    public static cd sh() {
        return nf;
    }

    public static void n(com.byazt.g.s sVar) {
        pe = sVar;
    }

    public static boolean y() {
        return e;
    }

    public static void n(n nVar) {
        com.byazt.fe.n.n("wjd", "setIndependentServiceCreator::creator=" + nVar);
        rv = nVar;
    }

    public static boolean rf() {
        com.byazt.fe.n.n("wjd", "supportMultiProc::=" + (rv != null));
        return rv != null;
    }

    public static n dh() {
        return rv;
    }
}
