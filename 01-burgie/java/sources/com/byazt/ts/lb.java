package com.byazt.ts;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.auw.DownloadInfo;
import com.byazt.lhc.BaseException;
import com.byazt.lj.Downloader;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 48})
public class lb implements Handler.Callback, com.byazt.wel.pr.InterfaceC0223pr {
    public static hw aj;
    public static volatile lb pr;
    public final boolean c;
    public long uc;
    public ConnectivityManager zo;
    public final Handler hn = new Handler(Looper.getMainLooper(), this);
    public final SparseArray<pr> x = new SparseArray<>();
    public int fw = 0;
    public final Context hw = com.byazt.lj.hn.of();

    public interface hw {
        void pr(DownloadInfo downloadInfo, long j, boolean z, int i);
    }

    private lb() {
        uc();
        this.c = com.byazt.tuy.uc.hn();
        com.byazt.wel.pr.pr().pr(this);
    }

    public static lb pr() {
        if (pr == null) {
            synchronized (lb.class) {
                if (pr == null) {
                    pr = new lb();
                }
            }
        }
        return pr;
    }

    public static void pr(hw hwVar) {
        aj = hwVar;
    }

    private void uc() {
        if (com.byazt.ew.pr.hn().pr("use_network_callback", 0) != 1) {
            return;
        }
        com.byazt.lj.hn.k().execute(new Runnable() { // from class: com.byazt.ts.lb.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (lb.this.hw != null && Build.VERSION.SDK_INT >= 21) {
                        lb lbVar = lb.this;
                        lbVar.zo = (ConnectivityManager) lbVar.hw.getApplicationContext().getSystemService("connectivity");
                        lb.this.zo.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.byazt.ts.lb.1.1
                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public void onAvailable(Network network) {
                                com.byazt.p000do.pr.hw("RetryScheduler", "network onAvailable: ");
                                lb.this.pr(1, true);
                            }
                        });
                    }
                } catch (Exception e) {
                }
            }
        });
    }

    public void pr(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        pr(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), fw());
    }

    private void pr(DownloadInfo downloadInfo, boolean z, int i) {
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException == null) {
            return;
        }
        pr prVarHw = hw(downloadInfo.getId());
        if (prVarHw.aj > prVarHw.hn) {
            com.byazt.p000do.pr.x("RetryScheduler", "tryStartScheduleRetry, id = " + prVarHw.pr + ", mRetryCount = " + prVarHw.aj + ", maxCount = " + prVarHw.hn);
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!com.byazt.tuy.uc.zo(failedException) && !com.byazt.tuy.uc.aj(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!pr(prVarHw, errorCode)) {
                return;
            } else {
                com.byazt.p000do.pr.hn("RetryScheduler", "allow error code, id = " + prVarHw.pr + ", error code = " + errorCode);
            }
        }
        prVarHw.vk = z;
        synchronized (this.x) {
            if (!prVarHw.k) {
                prVarHw.k = true;
                this.fw++;
            }
        }
        int iX = prVarHw.x();
        com.byazt.p000do.pr.hn("RetryScheduler", "tryStartScheduleRetry: id = " + prVarHw.pr + ", delayTimeMills = " + iX + ", mWaitingRetryTasks = " + this.fw);
        if (prVarHw.uc) {
            if (i == 0) {
                prVarHw.hn();
            }
            hw hwVar = aj;
            if (hwVar != null) {
                hwVar.pr(downloadInfo, iX, z, i);
            }
            if (this.c) {
                prVarHw.pr(System.currentTimeMillis());
                prVarHw.hw();
                prVarHw.pr();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.hn.removeMessages(downloadInfo.getId());
        this.hn.sendEmptyMessageDelayed(downloadInfo.getId(), iX);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            hw(message.arg1, message.arg2 == 1);
        } else {
            com.byazt.p000do.pr.hn("RetryScheduler", "handleMessage, doSchedulerRetry, id = " + message.what);
            pr(message.what);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, boolean z) {
        if (this.fw <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                if (jCurrentTimeMillis - this.uc < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    return;
                }
            }
            this.uc = jCurrentTimeMillis;
            com.byazt.p000do.pr.hn("RetryScheduler", "scheduleAllTaskRetry, level = [" + i + "], force = [" + z + "]");
            if (z) {
                this.hn.removeMessages(0);
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 0;
            messageObtain.arg1 = i;
            messageObtain.arg2 = z ? 1 : 0;
            this.hn.sendMessageDelayed(messageObtain, 2000L);
        }
    }

    private void hw(final int i, final boolean z) {
        com.byazt.lj.hn.k().execute(new Runnable() { // from class: com.byazt.ts.lb.2
            @Override // java.lang.Runnable
            public void run() {
                int iFw;
                try {
                    if (lb.this.fw <= 0 || (iFw = lb.this.fw()) == 0) {
                        return;
                    }
                    com.byazt.p000do.pr.hn("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + lb.this.fw);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    ArrayList arrayList = new ArrayList();
                    synchronized (lb.this.x) {
                        for (int i2 = 0; i2 < lb.this.x.size(); i2++) {
                            pr prVar = (pr) lb.this.x.valueAt(i2);
                            if (prVar != null && prVar.pr(jCurrentTimeMillis, i, iFw, z)) {
                                if (z) {
                                    prVar.hn();
                                }
                                arrayList.add(prVar);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            lb.this.pr(((pr) it.next()).pr, iFw, false);
                        }
                    }
                } catch (Exception e) {
                }
            }
        });
    }

    public void pr(final int i) {
        com.byazt.lj.hn.k().execute(new Runnable() { // from class: com.byazt.ts.lb.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    lb lbVar = lb.this;
                    lbVar.pr(i, lbVar.fw(), true);
                } catch (Exception e) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, int i2, boolean z) {
        com.byazt.lj.lb reserveWifiStatusListener;
        boolean zPr;
        Context context = this.hw;
        if (context == null) {
            return;
        }
        synchronized (this.x) {
            pr prVar = this.x.get(i);
            if (prVar == null) {
                return;
            }
            boolean z2 = true;
            if (prVar.k) {
                prVar.k = false;
                int i3 = this.fw - 1;
                this.fw = i3;
                if (i3 < 0) {
                    this.fw = 0;
                }
            }
            com.byazt.p000do.pr.hn("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i + ", retryCount = " + prVar.aj + ", mWaitingRetryTasksCount = " + this.fw);
            DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
            if (downloadInfo == null) {
                hn(i);
                return;
            }
            com.byazt.p000do.pr.c("RetryScheduler", "doSchedulerRetryInSubThread，id:".concat(String.valueOf(i)));
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus == -3 || realStatus == -4) {
                hn(i);
                return;
            }
            if (realStatus == -5 || (realStatus == -2 && downloadInfo.isPauseReserveOnWifi())) {
                if (realStatus == -2 && (reserveWifiStatusListener = Downloader.getInstance(com.byazt.lj.hn.of()).getReserveWifiStatusListener()) != null) {
                    reserveWifiStatusListener.pr(downloadInfo, 4, 3);
                }
                com.byazt.lj.k kVarRc = com.byazt.lj.hn.rc();
                if (kVarRc != null) {
                    kVarRc.pr(Collections.singletonList(downloadInfo), 3);
                }
                hn(i);
                return;
            }
            if (realStatus != -1) {
                return;
            }
            if (i2 != 0) {
                zPr = true;
            } else if (prVar.uc) {
                zPr = false;
            } else {
                return;
            }
            BaseException failedException = downloadInfo.getFailedException();
            if (zPr && com.byazt.tuy.uc.zo(failedException)) {
                zPr = pr(downloadInfo, failedException);
            }
            prVar.hw();
            if (zPr) {
                com.byazt.p000do.pr.hn("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + prVar.pr);
                prVar.pr(System.currentTimeMillis());
                if (z) {
                    prVar.pr();
                }
                downloadInfo.setRetryScheduleCount(prVar.aj);
                if (downloadInfo.getStatus() == -1) {
                    Downloader.getInstance(context).restart(downloadInfo.getId());
                    return;
                }
                return;
            }
            if (z) {
                prVar.pr();
            }
            if (!downloadInfo.isOnlyWifi() && !downloadInfo.isPauseReserveOnWifi()) {
                z2 = false;
            }
            pr(downloadInfo, z2, i2);
        }
    }

    private boolean pr(pr prVar, int i) {
        int[] iArr = prVar.fw;
        if (iArr == null || iArr.length == 0) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private pr hw(int i) {
        pr prVarX = this.x.get(i);
        if (prVarX == null) {
            synchronized (this.x) {
                prVarX = this.x.get(i);
                if (prVarX == null) {
                    prVarX = x(i);
                }
                this.x.put(i, prVarX);
            }
        }
        return prVarX;
    }

    private void hn(int i) {
        synchronized (this.x) {
            this.x.remove(i);
        }
    }

    private pr x(int i) {
        int[] iArrPr;
        int i2;
        int i3;
        boolean z;
        com.byazt.ew.pr prVarPr = com.byazt.ew.pr.pr(i);
        boolean z2 = false;
        int iPr = prVarPr.pr("retry_schedule", 0);
        JSONObject jSONObjectX = prVarPr.x("retry_schedule_config");
        int i4 = 60;
        if (jSONObjectX != null) {
            int iOptInt = jSONObjectX.optInt("max_count", 60);
            int iOptInt2 = jSONObjectX.optInt("interval_sec", 60);
            int iOptInt3 = jSONObjectX.optInt("interval_sec_acceleration", 60);
            if (Build.VERSION.SDK_INT >= 21 && aj != null && jSONObjectX.optInt("use_job_scheduler", 0) == 1) {
                z2 = true;
            }
            iArrPr = pr(jSONObjectX.optString("allow_error_code"));
            i2 = iOptInt3;
            z = z2;
            i3 = iOptInt;
            i4 = iOptInt2;
        } else {
            iArrPr = null;
            i2 = 60;
            i3 = 60;
            z = false;
        }
        return new pr(i, iPr, i3, i4 * 1000, i2 * 1000, z, iArrPr);
    }

    private int[] pr(String str) {
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
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.byazt.wel.pr.InterfaceC0223pr
    public void hw() {
        pr(4, false);
    }

    @Override // com.byazt.wel.pr.InterfaceC0223pr
    public void hn() {
        pr(3, false);
    }

    public void x() {
        pr(2, true);
    }

    public void c() {
        pr(5, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fw() {
        try {
            if (this.zo == null) {
                this.zo = (ConnectivityManager) this.hw.getApplicationContext().getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.zo.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    private boolean pr(DownloadInfo downloadInfo, BaseException baseException) {
        long jX;
        long totalBytes;
        try {
            jX = com.byazt.tuy.uc.x(downloadInfo.getTempPath());
        } catch (BaseException e) {
            jX = 0;
        }
        if (baseException instanceof com.byazt.lhc.x) {
            totalBytes = ((com.byazt.lhc.x) baseException).hw();
        } else {
            totalBytes = downloadInfo.getTotalBytes() - downloadInfo.getCurBytes();
        }
        if (jX < totalBytes) {
            com.byazt.ew.pr prVarPr = com.byazt.ew.pr.pr(downloadInfo.getId());
            if (prVarPr.pr("space_fill_part_download", 0) != 1) {
                return false;
            }
            if (jX > 0) {
                int iPr = prVarPr.pr("space_fill_min_keep_mb", 100);
                if (iPr > 0) {
                    long j = jX - (((long) iPr) * 1048576);
                    com.byazt.p000do.pr.hn("RetryScheduler", "retry schedule: available = " + com.byazt.tuy.uc.pr(jX) + "MB, minKeep = " + iPr + "MB, canDownload = " + com.byazt.tuy.uc.pr(j) + "MB");
                    if (j <= 0) {
                        com.byazt.p000do.pr.x("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                        return false;
                    }
                }
            } else if (prVarPr.pr("download_when_space_negative", 0) != 1) {
                return false;
            }
        }
        return true;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 855})
    private static class pr {
        public int aj;
        public final int c;
        public final int[] fw;
        public final int hn;
        public final int hw;
        public boolean k;
        public final int pr;
        public final boolean uc;
        public boolean vk;
        public long w;
        public final int x;
        public int zo;

        public pr(int i, int i2, int i3, int i4, int i5, boolean z, int[] iArr) {
            i4 = i4 < 3000 ? 3000 : i4;
            i5 = i5 < 5000 ? 5000 : i5;
            this.pr = i;
            this.hw = i2;
            this.hn = i3;
            this.x = i4;
            this.c = i5;
            this.uc = z;
            this.fw = iArr;
            this.zo = i4;
        }

        public boolean pr(long j, int i, int i2, boolean z) {
            if (!this.k) {
                com.byazt.p000do.pr.hn("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            }
            if (this.hw < i || this.aj >= this.hn) {
                return false;
            }
            if (!this.vk || i2 == 2) {
                return z || j - this.w >= ((long) this.x);
            }
            return false;
        }

        public synchronized void pr() {
            this.zo += this.c;
        }

        public synchronized void pr(long j) {
            this.w = j;
        }

        public synchronized void hw() {
            this.aj++;
        }

        public void hn() {
            this.zo = this.x;
        }

        public int x() {
            return this.zo;
        }
    }
}
