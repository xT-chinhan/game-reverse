package com.byazt.i;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, 86})
public class cd implements Handler.Callback, com.byazt.b.n.InterfaceC0133n {
    public static volatile cd n;
    public static qg rv;
    public ConnectivityManager fs;
    public final boolean l;
    public long w;
    public final Handler s = new Handler(Looper.getMainLooper(), this);
    public final SparseArray<n> q = new SparseArray<>();
    public int x = 0;
    public final Context qg = com.byazt.xv.s.u();

    public interface qg {
        void n(DownloadInfo downloadInfo, long j, boolean z, int i);
    }

    private cd() {
        w();
        this.l = com.byazt.ta.w.s();
        com.byazt.b.n.n().n(this);
    }

    public static cd n() {
        if (n == null) {
            synchronized (cd.class) {
                if (n == null) {
                    n = new cd();
                }
            }
        }
        return n;
    }

    public static void n(qg qgVar) {
        rv = qgVar;
    }

    private void w() {
        if (com.byazt.f.n.s().n("use_network_callback", 0) != 1) {
            return;
        }
        com.byazt.xv.s.d().execute(new Runnable() { // from class: com.byazt.i.cd.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (cd.this.qg != null) {
                        cd cdVar = cd.this;
                        cdVar.fs = (ConnectivityManager) cdVar.qg.getApplicationContext().getSystemService("connectivity");
                        cd.this.fs.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.byazt.i.cd.1.1
                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public void onAvailable(Network network) {
                                com.byazt.fe.n.qg("RetryScheduler", "network onAvailable: ");
                                cd.this.n(1, true);
                            }
                        });
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    public void n(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        n(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), x());
    }

    private void n(DownloadInfo downloadInfo, boolean z, int i) {
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException == null) {
            return;
        }
        n nVarQg = qg(downloadInfo.getId());
        if (nVarQg.rv > nVarQg.s) {
            com.byazt.fe.n.q("RetryScheduler", "tryStartScheduleRetry, id = " + nVarQg.n + ", mRetryCount = " + nVarQg.rv + ", maxCount = " + nVarQg.s);
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!com.byazt.ta.w.fs(failedException) && !com.byazt.ta.w.rv(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!n(nVarQg, errorCode)) {
                return;
            } else {
                com.byazt.fe.n.s("RetryScheduler", "allow error code, id = " + nVarQg.n + ", error code = " + errorCode);
            }
        }
        nVarQg.tj = z;
        synchronized (this.q) {
            if (!nVarQg.d) {
                nVarQg.d = true;
                this.x++;
            }
        }
        int iQ = nVarQg.q();
        com.byazt.fe.n.s("RetryScheduler", "tryStartScheduleRetry: id = " + nVarQg.n + ", delayTimeMills = " + iQ + ", mWaitingRetryTasks = " + this.x);
        if (!nVarQg.w) {
            if (z) {
                return;
            }
            this.s.removeMessages(downloadInfo.getId());
            this.s.sendEmptyMessageDelayed(downloadInfo.getId(), iQ);
            return;
        }
        if (i == 0) {
            nVarQg.s();
        }
        qg qgVar = rv;
        if (qgVar != null) {
            qgVar.n(downloadInfo, iQ, z, i);
        }
        if (this.l) {
            nVarQg.n(System.currentTimeMillis());
            nVarQg.qg();
            nVarQg.n();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            qg(message.arg1, message.arg2 == 1);
        } else {
            com.byazt.fe.n.s("RetryScheduler", "handleMessage, doSchedulerRetry, id = " + message.what);
            n(message.what);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, boolean z) {
        if (this.x <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                if (jCurrentTimeMillis - this.w < 10000) {
                    return;
                }
            }
            this.w = jCurrentTimeMillis;
            com.byazt.fe.n.s("RetryScheduler", "scheduleAllTaskRetry, level = [" + i + "], force = [" + z + "]");
            if (z) {
                this.s.removeMessages(0);
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 0;
            messageObtain.arg1 = i;
            messageObtain.arg2 = z ? 1 : 0;
            this.s.sendMessageDelayed(messageObtain, 2000L);
        }
    }

    private void qg(final int i, final boolean z) {
        com.byazt.xv.s.d().execute(new Runnable() { // from class: com.byazt.i.cd.2
            @Override // java.lang.Runnable
            public void run() {
                int iX;
                try {
                    if (cd.this.x > 0 && (iX = cd.this.x()) != 0) {
                        com.byazt.fe.n.s("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + cd.this.x);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        synchronized (cd.this.q) {
                            for (int i2 = 0; i2 < cd.this.q.size(); i2++) {
                                n nVar = (n) cd.this.q.valueAt(i2);
                                if (nVar != null && nVar.n(jCurrentTimeMillis, i, iX, z)) {
                                    if (z) {
                                        nVar.s();
                                    }
                                    arrayList.add(nVar);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                cd.this.n(((n) it.next()).n, iX, false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    public void n(final int i) {
        com.byazt.xv.s.d().execute(new Runnable() { // from class: com.byazt.i.cd.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cd cdVar = cd.this;
                    cdVar.n(i, cdVar.x(), true);
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2, boolean z) {
        com.byazt.xv.cd reserveWifiStatusListener;
        boolean zN;
        Context context = this.qg;
        if (context == null) {
            return;
        }
        synchronized (this.q) {
            n nVar = this.q.get(i);
            if (nVar == null) {
                return;
            }
            boolean z2 = true;
            if (nVar.d) {
                nVar.d = false;
                int i3 = this.x - 1;
                this.x = i3;
                if (i3 < 0) {
                    this.x = 0;
                }
            }
            com.byazt.fe.n.s("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i + ", retryCount = " + nVar.rv + ", mWaitingRetryTasksCount = " + this.x);
            DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
            if (downloadInfo == null) {
                s(i);
                return;
            }
            com.byazt.fe.n.l("RetryScheduler", "doSchedulerRetryInSubThread，id:".concat(String.valueOf(i)));
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus == -3 || realStatus == -4) {
                s(i);
                return;
            }
            if (realStatus == -5 || (realStatus == -2 && downloadInfo.isPauseReserveOnWifi())) {
                if (realStatus == -2 && (reserveWifiStatusListener = Downloader.getInstance(com.byazt.xv.s.u()).getReserveWifiStatusListener()) != null) {
                    reserveWifiStatusListener.n(downloadInfo, 4, 3);
                }
                com.byazt.xv.d dVarM = com.byazt.xv.s.m();
                if (dVarM != null) {
                    dVarM.n(Collections.singletonList(downloadInfo), 3);
                }
                s(i);
                return;
            }
            if (realStatus != -1) {
                return;
            }
            if (i2 != 0) {
                zN = true;
            } else if (!nVar.w) {
                return;
            } else {
                zN = false;
            }
            BaseException failedException = downloadInfo.getFailedException();
            if (zN && com.byazt.ta.w.fs(failedException)) {
                zN = n(downloadInfo, failedException);
            }
            nVar.qg();
            if (zN) {
                com.byazt.fe.n.s("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + nVar.n);
                nVar.n(System.currentTimeMillis());
                if (z) {
                    nVar.n();
                }
                downloadInfo.setRetryScheduleCount(nVar.rv);
                if (downloadInfo.getStatus() == -1) {
                    Downloader.getInstance(context).restart(downloadInfo.getId());
                    return;
                }
                return;
            }
            if (z) {
                nVar.n();
            }
            if (!downloadInfo.isOnlyWifi() && !downloadInfo.isPauseReserveOnWifi()) {
                z2 = false;
            }
            n(downloadInfo, z2, i2);
        }
    }

    private boolean n(n nVar, int i) {
        int[] iArr = nVar.x;
        if (iArr != null && iArr.length != 0) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    private n qg(int i) {
        n nVarQ = this.q.get(i);
        if (nVarQ == null) {
            synchronized (this.q) {
                nVarQ = this.q.get(i);
                if (nVarQ == null) {
                    nVarQ = q(i);
                }
                this.q.put(i, nVarQ);
            }
        }
        return nVarQ;
    }

    private void s(int i) {
        synchronized (this.q) {
            this.q.remove(i);
        }
    }

    private n q(int i) {
        int[] iArrN;
        int i2;
        int i3;
        boolean z;
        com.byazt.f.n nVarN = com.byazt.f.n.n(i);
        boolean z2 = false;
        int iN = nVarN.n("retry_schedule", 0);
        JSONObject jSONObjectQ = nVarN.q("retry_schedule_config");
        int i4 = 60;
        if (jSONObjectQ != null) {
            int iOptInt = jSONObjectQ.optInt("max_count", 60);
            int iOptInt2 = jSONObjectQ.optInt("interval_sec", 60);
            int iOptInt3 = jSONObjectQ.optInt("interval_sec_acceleration", 60);
            if (rv != null && jSONObjectQ.optInt("use_job_scheduler", 0) == 1) {
                z2 = true;
            }
            iArrN = n(jSONObjectQ.optString("allow_error_code"));
            i2 = iOptInt3;
            z = z2;
            i3 = iOptInt;
            i4 = iOptInt2;
        } else {
            iArrN = null;
            i2 = 60;
            i3 = 60;
            z = false;
        }
        return new n(i, iN, i3, i4 * 1000, i2 * 1000, z, iArrN);
    }

    private int[] n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length <= 0) {
                return null;
            }
            int[] iArr = new int[strArrSplit.length];
            for (int i = 0; i < strArrSplit.length; i++) {
                iArr[i] = Integer.parseInt(strArrSplit[i]);
            }
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.byazt.b.n.InterfaceC0133n
    public void qg() {
        n(4, false);
    }

    @Override // com.byazt.b.n.InterfaceC0133n
    public void s() {
        n(3, false);
    }

    public void q() {
        n(2, true);
    }

    public void l() {
        n(5, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int x() {
        try {
            if (this.fs == null) {
                this.fs = (ConnectivityManager) this.qg.getApplicationContext().getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.fs.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private boolean n(DownloadInfo downloadInfo, BaseException baseException) {
        long jQ;
        long totalBytes;
        try {
            jQ = com.byazt.ta.w.q(downloadInfo.getTempPath());
        } catch (BaseException unused) {
            jQ = 0;
        }
        if (baseException instanceof com.byazt.qx.q) {
            totalBytes = ((com.byazt.qx.q) baseException).qg();
        } else {
            totalBytes = downloadInfo.getTotalBytes() - downloadInfo.getCurBytes();
        }
        if (jQ < totalBytes) {
            com.byazt.f.n nVarN = com.byazt.f.n.n(downloadInfo.getId());
            if (nVarN.n("space_fill_part_download", 0) == 1) {
                if (jQ > 0) {
                    int iN = nVarN.n("space_fill_min_keep_mb", 100);
                    if (iN > 0) {
                        long j = jQ - (((long) iN) * 1048576);
                        com.byazt.fe.n.s("RetryScheduler", "retry schedule: available = " + com.byazt.ta.w.n(jQ) + "MB, minKeep = " + iN + "MB, canDownload = " + com.byazt.ta.w.n(j) + "MB");
                        if (j <= 0) {
                            com.byazt.fe.n.q("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                            return false;
                        }
                    }
                } else if (nVarN.n("download_when_space_negative", 0) != 1) {
                }
            }
            return false;
        }
        return true;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, 1424})
    private static class n {
        public long cp;
        public boolean d;
        public int fs;
        public final int l;
        public final int n;
        public final int q;
        public final int qg;
        public int rv;
        public final int s;
        public boolean tj;
        public final boolean w;
        public final int[] x;

        public n(int i, int i2, int i3, int i4, int i5, boolean z, int[] iArr) {
            i4 = i4 < 3000 ? 3000 : i4;
            i5 = i5 < 5000 ? 5000 : i5;
            this.n = i;
            this.qg = i2;
            this.s = i3;
            this.q = i4;
            this.l = i5;
            this.w = z;
            this.x = iArr;
            this.fs = i4;
        }

        public boolean n(long j, int i, int i2, boolean z) {
            if (!this.d) {
                com.byazt.fe.n.s("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            }
            if (this.qg < i || this.rv >= this.s) {
                return false;
            }
            if (!this.tj || i2 == 2) {
                return z || j - this.cp >= ((long) this.q);
            }
            return false;
        }

        public synchronized void n() {
            this.fs += this.l;
        }

        public synchronized void n(long j) {
            this.cp = j;
        }

        public synchronized void qg() {
            this.rv++;
        }

        public void s() {
            this.fs = this.q;
        }

        public int q() {
            return this.fs;
        }
    }
}
