package com.byazt.lj;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.auw.DownloadTask;
import com.byazt.edb.IDownloadHttpService;
import com.byazt.fn.iu;
import com.byazt.fn.ls;
import com.byazt.fn.y;
import com.byazt.lhc.BaseException;
import com.byazt.ts.DownloadHandleService;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 20})
public class hn {
    public static volatile ExecutorService a;
    public static volatile pr aj;
    public static volatile qa b;
    public static lb bm;
    public static volatile y c;
    public static volatile ExecutorService cz;
    public static volatile com.byazt.edb.uc e;
    public static boolean f;
    public static volatile ScheduledExecutorService fo;
    public static volatile ho fw;
    public static volatile k g;
    public static volatile iu gz;
    public static volatile w hn;
    public static volatile ExecutorService ho;
    public static final List<com.byazt.fn.w> hs;
    public static volatile vk hw;
    public static int i;
    public static int ie;
    public static final int ii;
    public static volatile yb iu;
    public static com.byazt.cha.hn jn;
    public static volatile IDownloadHttpService k;
    public static volatile boolean l;
    public static volatile ExecutorService lb;
    public static volatile com.byazt.edb.zo m;
    public static volatile com.byazt.edb.uc n;
    public static volatile ExecutorService nt;
    public static final List<Object> nw;
    public static volatile ExecutorService ny;
    public static boolean o;
    public static final int of;
    public static volatile Context pr;
    public static volatile ExecutorService qa;
    public static final int qi;
    public static final int qn;
    public static boolean r;
    public static volatile fw rc;
    public static volatile cz s;
    public static volatile com.byazt.ts.pr uc;
    public static int v;
    public static volatile com.byazt.cha.hw ve;
    public static volatile IDownloadHttpService vk;
    public static volatile com.byazt.edb.zo w;
    public static volatile zo x;
    public static volatile ExecutorService yb;
    public static volatile DownloadReceiver z;
    public static volatile ho zo;
    public static volatile List<ls> nl = new ArrayList();
    public static volatile boolean y = false;
    public static volatile OkHttpClient ww = null;
    public static final List<com.byazt.fn.m> ls = new ArrayList();
    public static boolean er = false;

    public interface pr {

        /* JADX INFO: renamed from: com.byazt.lj.hn$pr$pr, reason: collision with other inner class name */
        public interface InterfaceC0121pr {
            void pr();
        }

        m hw();

        a pr(InterfaceC0121pr interfaceC0121pr);

        ho pr();
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        qi = iAvailableProcessors;
        qn = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        of = iAvailableProcessors;
        ii = iAvailableProcessors;
        i = 8192;
        hs = new ArrayList();
        nw = new ArrayList();
        o = true;
        f = false;
        l = false;
    }

    private hn() {
    }

    public static synchronized void pr(DownloaderBuilder downloaderBuilder) {
        if (l) {
            com.byazt.p000do.pr.c("DownloadComponentManager", "component has init");
            return;
        }
        boolean z2 = y;
        hn(downloaderBuilder);
        if (hw == null) {
            hw = new com.byazt.ts.x();
        }
        if (fw == null) {
            fw = new com.byazt.ts.zo();
        }
        if (zo == null && aj != null) {
            zo = aj.pr();
        }
        if (hn == null) {
            hn = new com.byazt.ts.aj();
        }
        if (uc == null) {
            uc = new com.byazt.ts.c();
        }
        if (x == null) {
            x = new com.byazt.ts.hn();
        }
        if (rc == null) {
            rc = new com.byazt.ts.hw();
        }
        if (b == null) {
            b = new com.byazt.ts.vk();
        }
        int i2 = v;
        if (i2 <= 0 || i2 > qi) {
            v = qi;
        }
        o();
        if (y && !z2 && !com.byazt.tuy.uc.hn()) {
            com.byazt.ts.k.pr(true).startService();
        } else if (com.byazt.tuy.uc.x()) {
            ExecutorService executorServiceM = m();
            if (executorServiceM != null) {
                executorServiceM.execute(new Runnable() { // from class: com.byazt.lj.hn.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Context contextOf = hn.of();
                        if (contextOf != null) {
                            com.byazt.tuy.uc.x(contextOf);
                        }
                    }
                });
            }
        } else {
            Context contextOf = of();
            if (contextOf != null) {
                com.byazt.tuy.uc.x(contextOf);
            }
        }
        n();
        l = true;
    }

    public static synchronized void hw(DownloaderBuilder downloaderBuilder) {
        hn(downloaderBuilder);
    }

    private static void hn(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder != null) {
            if (downloaderBuilder.getContext() != null) {
                pr(downloaderBuilder.getContext());
            }
            if (downloaderBuilder.getDownloadCache() != null) {
                pr(downloaderBuilder.getDownloadCache());
            }
            if (downloaderBuilder.getIdGenerator() != null) {
                pr(downloaderBuilder.getIdGenerator());
            }
            if (downloaderBuilder.getChunkCntCalculator() != null) {
                pr(downloaderBuilder.getChunkCntCalculator());
            }
            if (downloaderBuilder.getNotificationClickCallback() != null) {
                pr(downloaderBuilder.getNotificationClickCallback());
            }
            if (downloaderBuilder.getMaxDownloadPoolSize() != 0) {
                hw(downloaderBuilder.getMaxDownloadPoolSize());
            }
            if (downloaderBuilder.getHttpService() != null) {
                pr(downloaderBuilder.getHttpService());
            }
            if (downloaderBuilder.getHeadHttpService() != null) {
                pr(downloaderBuilder.getHeadHttpService());
            }
            if (downloaderBuilder.getDownloadLaunchHandler() != null) {
                pr(downloaderBuilder.getDownloadLaunchHandler());
            }
            if (downloaderBuilder.getCPUThreadExecutor() != null) {
                hn(downloaderBuilder.getCPUThreadExecutor());
            }
            if (downloaderBuilder.getIOThreadExecutor() != null) {
                x(downloaderBuilder.getIOThreadExecutor());
            }
            if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
                c(downloaderBuilder.getMixDefaultDownloadExecutor());
            }
            if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
                uc(downloaderBuilder.getMixFrequentDownloadExecutor());
            }
            if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
                fw(downloaderBuilder.getMixApkDownloadExecutor());
            }
            if (downloaderBuilder.getDBThreadExecutor() != null) {
                zo(downloaderBuilder.getDBThreadExecutor());
            }
            if (downloaderBuilder.getChunkThreadExecutor() != null) {
                pr(downloaderBuilder.getChunkThreadExecutor());
            }
            if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
                hw(downloaderBuilder.getOkHttpDispatcherExecutor());
            }
            if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
                pr(downloaderBuilder.getDownloadCompleteHandlers());
            }
            if (downloaderBuilder.getMonitorConfig() != null) {
                iu = downloaderBuilder.getMonitorConfig();
            }
            if (downloaderBuilder.getWriteBufferSize() > 1024) {
                i = downloaderBuilder.getWriteBufferSize();
            }
            if (downloaderBuilder.getChunkAdjustCalculator() != null) {
                pr(downloaderBuilder.getChunkAdjustCalculator());
            }
            if (downloaderBuilder.isDownloadInMultiProcess()) {
                y = true;
            }
            if (downloaderBuilder.getDownloadExpSwitch() != 0) {
                ie = downloaderBuilder.getDownloadExpSwitch();
            }
            if (downloaderBuilder.getDownloadSetting() != null) {
                pr(downloaderBuilder.getDownloadSetting());
            }
            if (downloaderBuilder.getDownloadDns() != null) {
                n = downloaderBuilder.getDownloadDns();
            }
            if (downloaderBuilder.getTTNetHandler() != null) {
                cz tTNetHandler = downloaderBuilder.getTTNetHandler();
                s = tTNetHandler;
                if (tTNetHandler.pr()) {
                    pr(s.hw());
                    pr(s.hn());
                } else {
                    pr(zo());
                    pr(aj());
                }
            }
            hw(downloaderBuilder.needAutoRefreshUnSuccessTask());
            if (downloaderBuilder.getDownloadMonitorListener() != null) {
                pr(downloaderBuilder.getDownloadMonitorListener());
            }
        }
    }

    private static void o() {
        if (z == null) {
            z = new DownloadReceiver();
        }
        if (er) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            pr.registerReceiver(z, intentFilter);
            er = true;
        } catch (Throwable th) {
        }
    }

    public static synchronized void pr() {
        try {
            if (er && z != null && pr != null) {
                pr.unregisterReceiver(z);
                er = false;
            }
        } catch (Exception e2) {
        }
    }

    public static synchronized void hw() {
        if (y) {
            return;
        }
        y = true;
        try {
            Intent intent = new Intent(of(), (Class<?>) DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
            of().startService(intent);
            if (!com.byazt.tuy.uc.hn()) {
                com.byazt.ts.k.pr(true).startService();
            }
        } catch (Throwable th) {
            y = false;
        }
    }

    public static synchronized boolean hn() {
        return y;
    }

    public static IDownloadHttpService x() {
        return vk;
    }

    public static void pr(ls lsVar) {
        if (lsVar == null) {
            return;
        }
        synchronized (nl) {
            nl.add(lsVar);
        }
    }

    public static List<ls> c() {
        List<ls> list;
        synchronized (nl) {
            list = nl;
        }
        return list;
    }

    public static void pr(com.byazt.fn.w wVar) {
        List<com.byazt.fn.w> list = hs;
        synchronized (list) {
            if (wVar != null) {
                if (!list.contains(wVar)) {
                    list.add(wVar);
                }
            }
        }
    }

    public static void hw(com.byazt.fn.w wVar) {
        List<com.byazt.fn.w> list = hs;
        synchronized (list) {
            if (wVar != null) {
                if (list.contains(wVar)) {
                    list.remove(wVar);
                }
            }
        }
    }

    public static void pr(com.byazt.mrs.x xVar) {
        List<com.byazt.fn.w> list = hs;
        synchronized (list) {
            for (com.byazt.fn.w wVar : list) {
                if (wVar != null && xVar != com.byazt.mrs.x.SYNC_START && xVar == com.byazt.mrs.x.SYNC_SUCCESS) {
                    wVar.pr();
                }
            }
            if (xVar == com.byazt.mrs.x.SYNC_SUCCESS) {
                hs.clear();
            }
        }
    }

    public static void pr(DownloadTask downloadTask, int i2) {
        List<Object> list = nw;
        synchronized (list) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public static void hw(DownloadTask downloadTask, int i2) {
        List<Object> list = nw;
        synchronized (list) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public static com.byazt.edb.zo uc() {
        return w;
    }

    public static com.byazt.cha.hw fw() {
        return ve;
    }

    public static com.byazt.edb.aj pr(boolean z2, int i2, String str, List<com.byazt.auw.hn> list) throws Exception {
        return pr(z2, i2, str, null, list, 0, false, null);
    }

    public static com.byazt.edb.aj pr(boolean z2, int i2, String str, String str2, List<com.byazt.auw.hn> list, int i3, boolean z3, DownloadInfo downloadInfo) throws Exception {
        List<com.byazt.auw.hn> list2;
        int i4;
        List<com.byazt.auw.hn> arrayList;
        if (!TextUtils.isEmpty(str2)) {
            if (list != null) {
                arrayList = list;
            } else {
                arrayList = new ArrayList<>();
            }
            arrayList.add(new com.byazt.auw.hn("ss_d_request_host_ip_114", str2));
            list2 = arrayList;
            i4 = 1;
        } else if (z2) {
            list2 = list;
            i4 = i3;
        } else {
            i4 = 2;
            list2 = list;
        }
        int[] iArrPr = pr(i4);
        Exception exc = null;
        for (int i5 : iArrPr) {
            try {
                com.byazt.edb.aj ajVarPr = pr(i2, str, str2, list2, i5, z3, downloadInfo);
                if (ajVarPr != null) {
                    return ajVarPr;
                }
            } catch (Exception e2) {
                if (downloadInfo.isExpiredRedownload() && com.byazt.tuy.uc.fw(e2) && com.byazt.tuy.uc.hn(list2)) {
                    com.byazt.p000do.pr.pr("dcach::http exception 304, throw excepiton, not retry " + e2);
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

    /* JADX WARN: Code duplicated, block: B:26:0x0047  */
    private static com.byazt.edb.aj pr(int i2, String str, String str2, List<com.byazt.auw.hn> list, int i3, boolean z2, DownloadInfo downloadInfo) throws Throwable {
        IOException iOException;
        IDownloadHttpService iDownloadHttpServiceX = i3 == 1 ? x() : zo();
        if (iDownloadHttpServiceX == null) {
            throw new BaseException(1022, new IOException("httpService not exist, netLib = " + i3));
        }
        IOException iOException2 = null;
        long jCurrentTimeMillis = 0;
        if (z2) {
            try {
                jCurrentTimeMillis = System.currentTimeMillis();
            } catch (IOException e2) {
                e = e2;
                iOException2 = e;
                throw iOException2;
            } catch (Throwable th) {
                th = th;
                iOException = iOException2;
                if (z2) {
                    com.byazt.cha.pr.pr(null, str, str2, System.currentTimeMillis() - jCurrentTimeMillis, "get", i3, iOException, downloadInfo);
                }
                throw th;
            }
        }
        try {
            try {
                com.byazt.edb.aj ajVarDownloadWithConnection = iDownloadHttpServiceX.downloadWithConnection(i2, str, list);
                if (z2) {
                    com.byazt.cha.pr.pr(ajVarDownloadWithConnection, str, str2, System.currentTimeMillis() - jCurrentTimeMillis, "get", i3, null, downloadInfo);
                }
                return ajVarDownloadWithConnection;
            } catch (IOException e3) {
                e = e3;
                iOException2 = e;
                throw iOException2;
            }
        } catch (Throwable th2) {
            th = th2;
            iOException = iOException2;
            if (z2) {
                com.byazt.cha.pr.pr(null, str, str2, System.currentTimeMillis() - jCurrentTimeMillis, "get", i3, iOException, downloadInfo);
            }
            throw th;
        }
    }

    public static com.byazt.edb.fw pr(String str, List<com.byazt.auw.hn> list) throws Exception {
        return pr(str, list, 0, false, null);
    }

    public static com.byazt.edb.fw pr(String str, List<com.byazt.auw.hn> list, int i2, boolean z2, DownloadInfo downloadInfo) throws Exception {
        Exception e2 = null;
        for (int i3 : pr(i2)) {
            try {
                com.byazt.edb.fw fwVarHw = hw(str, list, i3, z2, downloadInfo);
                if (fwVarHw != null) {
                    return fwVarHw;
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

    private static com.byazt.edb.fw hw(String str, List<com.byazt.auw.hn> list, int i2, boolean z2, DownloadInfo downloadInfo) throws Throwable {
        com.byazt.edb.zo zoVarUc = i2 == 1 ? uc() : aj();
        if (zoVarUc == null) {
            throw new BaseException(1022, new IOException("httpService not exist, netLib = " + i2));
        }
        long jCurrentTimeMillis = 0;
        try {
            if (z2) {
                try {
                    jCurrentTimeMillis = System.currentTimeMillis();
                } catch (IOException e2) {
                    e = e2;
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    if (z2) {
                        com.byazt.cha.pr.pr(null, str, null, System.currentTimeMillis() - 0, "head", i2, null, downloadInfo);
                    }
                    throw th;
                }
            }
            try {
                com.byazt.edb.fw fwVarPr = zoVarUc.pr(str, list);
                if (z2) {
                    com.byazt.cha.pr.pr(fwVarPr, str, null, System.currentTimeMillis() - jCurrentTimeMillis, "head", i2, null, downloadInfo);
                }
                return fwVarPr;
            } catch (IOException e3) {
                e = e3;
                throw e;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static int[] pr(int i2) {
        switch (i2) {
            case 1:
                return new int[]{0};
            case 2:
                return new int[]{1};
            case 3:
                return new int[]{0, 1};
            default:
                return new int[]{1, 0};
        }
    }

    public static IDownloadHttpService zo() {
        if (k == null) {
            synchronized (hn.class) {
                if (k == null) {
                    k = new com.byazt.ts.fw();
                }
            }
        }
        return k;
    }

    public static com.byazt.edb.zo aj() {
        if (m == null) {
            synchronized (hn.class) {
                if (m == null) {
                    m = new com.byazt.ts.uc();
                }
            }
        }
        return m;
    }

    public static synchronized void pr(k kVar) {
        if (kVar != null) {
            g = kVar;
            if (hw instanceof com.byazt.ts.x) {
                ((com.byazt.ts.x) hw).zo();
            }
        }
    }

    private static void hn(ExecutorService executorService) {
        if (executorService != null) {
            ho = executorService;
        }
    }

    private static void x(ExecutorService executorService) {
        if (executorService != null) {
            nt = executorService;
        }
    }

    private static void c(ExecutorService executorService) {
        if (executorService != null) {
            yb = executorService;
        }
    }

    private static void uc(ExecutorService executorService) {
        if (executorService != null) {
            lb = executorService;
        }
    }

    private static void fw(ExecutorService executorService) {
        if (executorService != null) {
            qa = executorService;
        }
    }

    private static void zo(ExecutorService executorService) {
        if (executorService != null) {
            a = executorService;
        }
    }

    public static void pr(ExecutorService executorService) {
        if (executorService != null) {
            cz = executorService;
        }
    }

    public static void hw(ExecutorService executorService) {
        if (executorService != null) {
            ny = executorService;
        }
    }

    private static void pr(List<com.byazt.fn.m> list) {
        List<com.byazt.fn.m> list2 = ls;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    public static void pr(boolean z2) {
        f = z2;
    }

    public static boolean vk() {
        return com.byazt.ew.pr.hn().pr("switch_not_auto_boot_service", f ? 1 : 0) > 0;
    }

    public static synchronized yb w() {
        return iu;
    }

    public static void pr(Runnable runnable) {
        pr(runnable, false);
    }

    public static void hw(Runnable runnable) {
        hw(runnable, false);
    }

    public static void pr(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.byazt.tuy.uc.x()) {
            runnable.run();
        } else {
            k().execute(runnable);
        }
    }

    public static void hw(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.byazt.tuy.uc.x()) {
            runnable.run();
        } else {
            m().execute(runnable);
        }
    }

    public static void hn(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!com.byazt.tuy.uc.x()) {
            runnable.run();
        } else {
            lb().execute(runnable);
        }
    }

    public static Future pr(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            return null;
        }
        return a().schedule(runnable, j, timeUnit);
    }

    public static ExecutorService k() {
        if (ho == null) {
            synchronized (hn.class) {
                if (ho == null) {
                    int i2 = qi;
                    com.byazt.fr.x xVar = new com.byazt.fr.x(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.byazt.gi.pr("DownloadThreadPool-cpu-fixed", true));
                    try {
                        xVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                    }
                    ho = xVar;
                }
            }
        }
        return ho;
    }

    public static ExecutorService m() {
        return nt != null ? nt : k();
    }

    public static ExecutorService g() {
        return lb != null ? lb : nt();
    }

    public static ExecutorService ho() {
        return qa != null ? qa : nt();
    }

    public static ExecutorService nt() {
        if (yb == null) {
            synchronized (hn.class) {
                if (yb == null) {
                    int i2 = of;
                    com.byazt.fr.x xVar = new com.byazt.fr.x(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.byazt.gi.pr("DownloadThreadPool-mix-fixed", true));
                    try {
                        xVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                    }
                    yb = xVar;
                }
            }
        }
        return yb;
    }

    public static ExecutorService yb() {
        if (cz == null) {
            synchronized (hn.class) {
                if (cz == null) {
                    int i2 = qn;
                    com.byazt.fr.x xVar = new com.byazt.fr.x(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.byazt.gi.pr("DownloadThreadPool-chunk-fixed", true));
                    try {
                        xVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                    }
                    cz = xVar;
                }
            }
        }
        return cz;
    }

    public static ExecutorService lb() {
        if (a == null) {
            synchronized (hn.class) {
                if (a == null) {
                    int i2 = ii;
                    com.byazt.fr.x xVar = new com.byazt.fr.x(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.byazt.gi.pr("DownloadThreadPool-db-fixed", true));
                    try {
                        xVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                    }
                    a = xVar;
                }
            }
        }
        return a;
    }

    public static OkHttpClient qa() {
        if (ww == null) {
            synchronized (hn.class) {
                if (ww == null) {
                    ww = cz().build();
                }
            }
        }
        return ww;
    }

    public static ScheduledExecutorService a() {
        if (fo == null) {
            synchronized (hn.class) {
                if (fo == null) {
                    fo = new com.byazt.fr.c(1, new com.byazt.gi.pr("DownloadThreadPool-Schedule", true));
                }
            }
        }
        return fo;
    }

    public static OkHttpClient.Builder cz() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (ny != null) {
            builder.dispatcher(new Dispatcher(ny));
        }
        return builder;
    }

    public static com.byazt.edb.uc ny() {
        return n;
    }

    public static com.byazt.edb.uc fo() {
        if (e == null) {
            synchronized (hn.class) {
                if (e == null) {
                    e = new com.byazt.edb.uc() { // from class: com.byazt.lj.hn.2
                        @Override // com.byazt.edb.uc
                        public List<InetAddress> pr(String str) throws UnknownHostException {
                            return Dns.SYSTEM.lookup(str);
                        }
                    };
                }
            }
        }
        return e;
    }

    public static synchronized k rc() {
        return g;
    }

    public static void pr(IDownloadHttpService iDownloadHttpService) {
        if (iDownloadHttpService != null) {
            vk = iDownloadHttpService;
        }
        r = vk != null;
    }

    public static void pr(com.byazt.edb.zo zoVar) {
        if (zoVar != null) {
            w = zoVar;
        }
    }

    public static vk z() {
        if (hw == null) {
            synchronized (hn.class) {
                if (hw == null) {
                    hw = new com.byazt.ts.x();
                }
            }
        }
        return hw;
    }

    private static void pr(vk vkVar) {
        if (vkVar != null) {
            hw = vkVar;
        }
    }

    public static ho b() {
        if (fw == null) {
            synchronized (hn.class) {
                if (fw == null) {
                    fw = new com.byazt.ts.zo();
                }
            }
        }
        return fw;
    }

    public static ho iu() {
        if (zo == null) {
            synchronized (hn.class) {
                if (zo == null) {
                    zo = aj.pr();
                }
            }
        }
        return zo;
    }

    public static List<com.byazt.fn.m> ve() {
        return ls;
    }

    public static w gz() {
        if (hn == null) {
            synchronized (hn.class) {
                if (hn == null) {
                    hn = new com.byazt.ts.aj();
                }
            }
        }
        return hn;
    }

    public static com.byazt.ts.pr nl() {
        if (uc == null) {
            synchronized (hn.class) {
                if (uc == null) {
                    uc = new com.byazt.ts.c();
                }
            }
        }
        return uc;
    }

    private static void pr(w wVar) {
        if (wVar != null) {
            hn = wVar;
        }
    }

    private static void hw(int i2) {
        if (i2 > 0) {
            v = i2;
        }
    }

    private static void pr(com.byazt.cha.hw hwVar) {
        if (hwVar != null) {
            ve = hwVar;
        }
    }

    public static int y() {
        return ie;
    }

    public static JSONObject ww() {
        if (gz == null || gz.pr() == null) {
            return com.byazt.mrs.c.aj;
        }
        return gz.pr();
    }

    public static void n() {
        if (TextUtils.isEmpty(com.byazt.mrs.c.hn)) {
            com.byazt.mrs.c.hn = "oppo";
            com.byazt.mrs.c.hw = "oppo".toUpperCase();
        }
    }

    public static void pr(iu iuVar) {
        gz = iuVar;
        com.byazt.ew.pr.pr();
    }

    private static void hw(boolean z2) {
        o = z2;
    }

    public static boolean e() {
        return o;
    }

    public static synchronized int s() {
        return i;
    }

    public static zo ls() {
        if (x == null) {
            synchronized (hn.class) {
                if (x == null) {
                    x = new com.byazt.ts.hn();
                }
            }
        }
        return x;
    }

    private static void pr(zo zoVar) {
        if (zoVar != null) {
            x = zoVar;
        }
    }

    public static void pr(y yVar) {
        if (yVar != null) {
            c = yVar;
        }
    }

    public static y er() {
        return c;
    }

    public static fw v() {
        if (rc == null) {
            synchronized (hn.class) {
                if (rc == null) {
                    rc = new com.byazt.ts.hw();
                }
            }
        }
        return rc;
    }

    private static void pr(fw fwVar) {
        if (fwVar != null) {
            rc = fwVar;
        }
    }

    public static qa qi() {
        if (b == null) {
            synchronized (hn.class) {
                if (b == null) {
                    b = new com.byazt.ts.vk();
                }
            }
        }
        return b;
    }

    public static cz qn() {
        if (s == null) {
            synchronized (hn.class) {
                if (s == null) {
                    s = new cz.pr();
                }
            }
        }
        return s;
    }

    public static synchronized Context of() {
        return pr;
    }

    public static synchronized void pr(Context context) {
        if (context != null) {
            if (pr == null) {
                pr = context.getApplicationContext();
                com.byazt.wel.pr.pr().pr(pr);
            }
        }
    }

    public static int pr(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        String taskKey = downloadInfo.getTaskKey();
        if (TextUtils.isEmpty(taskKey)) {
            taskKey = downloadInfo.getUrl();
        }
        return pr(taskKey, downloadInfo.getSavePath());
    }

    public static int pr(String str, String str2) {
        w wVarGz = gz();
        if (wVarGz == null) {
            return 0;
        }
        return wVarGz.pr(str, str2);
    }

    public static synchronized boolean ii() {
        return r;
    }

    public static com.byazt.cha.hn i() {
        if (jn == null) {
            jn = new com.byazt.cha.hn() { // from class: com.byazt.lj.hn.3
                @Override // com.byazt.cha.hn
                public void hw(int i2, String str, JSONObject jSONObject) {
                }

                @Override // com.byazt.cha.hn
                public void pr(int i2, String str, JSONObject jSONObject) {
                }
            };
        }
        return jn;
    }

    public static lb r() {
        return bm;
    }

    public static void pr(com.byazt.cha.hn hnVar) {
        jn = hnVar;
    }

    public static void pr(lb lbVar) {
    }

    public static boolean hs() {
        return l;
    }

    public static void pr(pr prVar) {
        com.byazt.p000do.pr.pr("wjd", "setIndependentServiceCreator::creator=" + prVar);
        aj = prVar;
    }

    public static boolean nw() {
        com.byazt.p000do.pr.pr("wjd", "supportMultiProc::=" + (aj != null));
        return aj != null;
    }

    public static pr ie() {
        return aj;
    }
}
