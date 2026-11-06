package com.ss.android.socialbase.downloader.impls;

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
import com.anythink.basead.exoplayer.i.a;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class qv implements Handler.Callback, com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile qv f4695ms;
    private static xr ny;
    private long c;
    private final boolean ka;
    private ConnectivityManager x;
    private final Handler ah = new Handler(Looper.getMainLooper(), this);
    private final SparseArray<ms> d = new SparseArray<>();
    private int ab = 0;
    private final Context xr = com.ss.android.socialbase.downloader.downloader.ah.k();

    public interface xr {
        void ms(DownloadInfo downloadInfo, long j, boolean z, int i);
    }

    private qv() {
        c();
        this.ka = com.ss.android.socialbase.downloader.ny.c.ah();
        com.ss.android.socialbase.downloader.ms.ms.ms().ms(this);
    }

    public static qv ms() {
        if (f4695ms == null) {
            synchronized (qv.class) {
                if (f4695ms == null) {
                    f4695ms = new qv();
                }
            }
        }
        return f4695ms;
    }

    public static void ms(xr xrVar) {
        ny = xrVar;
    }

    private void c() {
        if (com.ss.android.socialbase.downloader.ab.ms.ah().ms("use_network_callback", 0) != 1) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.ah.sl().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.qv.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (qv.this.xr != null) {
                        qv qvVar = qv.this;
                        qvVar.x = (ConnectivityManager) qvVar.xr.getApplicationContext().getSystemService("connectivity");
                        qv.this.x.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.ss.android.socialbase.downloader.impls.qv.1.1
                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public void onAvailable(Network network) {
                                com.ss.android.socialbase.downloader.ah.ms.xr("RetryScheduler", "network onAvailable: ");
                                qv.this.ms(1, true);
                            }
                        });
                    }
                } catch (Exception e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }
        });
    }

    public void ms(DownloadInfo downloadInfo) {
        if (downloadInfo == null || TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.ka.f4631ms) || !com.ss.android.socialbase.downloader.constants.ka.f4631ms.equals(downloadInfo.getMimeType())) {
            return;
        }
        ms(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), ab());
    }

    private void ms(DownloadInfo downloadInfo, boolean z, int i) {
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException == null) {
            return;
        }
        ms msVarXr = xr(downloadInfo.getId());
        if (msVarXr.ny > msVarXr.ah) {
            com.ss.android.socialbase.downloader.ah.ms.d("RetryScheduler", "tryStartScheduleRetry, id = " + msVarXr.f4700ms + ", mRetryCount = " + msVarXr.ny + ", maxCount = " + msVarXr.ah);
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!com.ss.android.socialbase.downloader.ny.c.x(failedException) && !com.ss.android.socialbase.downloader.ny.c.ny(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!ms(msVarXr, errorCode)) {
                return;
            } else {
                com.ss.android.socialbase.downloader.ah.ms.ah("RetryScheduler", "allow error code, id = " + msVarXr.f4700ms + ", error code = " + errorCode);
            }
        }
        msVarXr.ch = z;
        synchronized (this.d) {
            if (!msVarXr.sl) {
                msVarXr.sl = true;
                this.ab++;
            }
        }
        int iD = msVarXr.d();
        com.ss.android.socialbase.downloader.ah.ms.ah("RetryScheduler", "tryStartScheduleRetry: id = " + msVarXr.f4700ms + ", delayTimeMills = " + iD + ", mWaitingRetryTasks = " + this.ab);
        if (!msVarXr.c) {
            if (z) {
                return;
            }
            this.ah.removeMessages(downloadInfo.getId());
            this.ah.sendEmptyMessageDelayed(downloadInfo.getId(), iD);
            return;
        }
        if (i == 0) {
            msVarXr.ah();
        }
        xr xrVar = ny;
        if (xrVar != null) {
            xrVar.ms(downloadInfo, iD, z, i);
        }
        if (this.ka) {
            msVarXr.ms(System.currentTimeMillis());
            msVarXr.xr();
            msVarXr.ms();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            xr(message.arg1, message.arg2 == 1);
        } else {
            com.ss.android.socialbase.downloader.ah.ms.ah("RetryScheduler", "handleMessage, doSchedulerRetry, id = " + message.what);
            ms(message.what);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, boolean z) {
        if (this.ab <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                if (jCurrentTimeMillis - this.c < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    return;
                }
            }
            this.c = jCurrentTimeMillis;
            com.ss.android.socialbase.downloader.ah.ms.ah("RetryScheduler", "scheduleAllTaskRetry, level = [" + i + "], force = [" + z + "]");
            if (z) {
                this.ah.removeMessages(0);
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 0;
            messageObtain.arg1 = i;
            messageObtain.arg2 = z ? 1 : 0;
            this.ah.sendMessageDelayed(messageObtain, a.f);
        }
    }

    private void xr(final int i, final boolean z) {
        com.ss.android.socialbase.downloader.downloader.ah.sl().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.qv.2
            @Override // java.lang.Runnable
            public void run() {
                int iAb;
                try {
                    if (qv.this.ab > 0 && (iAb = qv.this.ab()) != 0) {
                        com.ss.android.socialbase.downloader.ah.ms.ah("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + qv.this.ab);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        synchronized (qv.this.d) {
                            for (int i2 = 0; i2 < qv.this.d.size(); i2++) {
                                ms msVar = (ms) qv.this.d.valueAt(i2);
                                if (msVar != null && msVar.ms(jCurrentTimeMillis, i, iAb, z)) {
                                    if (z) {
                                        msVar.ah();
                                    }
                                    arrayList.add(msVar);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                qv.this.ms(((ms) it.next()).f4700ms, iAb, false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    public void ms(final int i) {
        com.ss.android.socialbase.downloader.downloader.ah.sl().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.qv.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    qv qvVar = qv.this;
                    qvVar.ms(i, qvVar.ab(), true);
                } catch (Exception e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, int i2, boolean z) {
        com.ss.android.socialbase.downloader.downloader.qv reserveWifiStatusListener;
        boolean zMs;
        Context context = this.xr;
        if (context == null) {
            return;
        }
        synchronized (this.d) {
            ms msVar = this.d.get(i);
            if (msVar == null) {
                return;
            }
            boolean z2 = true;
            if (msVar.sl) {
                msVar.sl = false;
                int i3 = this.ab - 1;
                this.ab = i3;
                if (i3 < 0) {
                    this.ab = 0;
                }
            }
            com.ss.android.socialbase.downloader.ah.ms.ah("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i + ", retryCount = " + msVar.ny + ", mWaitingRetryTasksCount = " + this.ab);
            DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
            if (downloadInfo == null) {
                ah(i);
                return;
            }
            com.ss.android.socialbase.downloader.ah.ms.ka("RetryScheduler", "doSchedulerRetryInSubThread，id:".concat(String.valueOf(i)));
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus == -3 || realStatus == -4) {
                ah(i);
                return;
            }
            if (realStatus == -5 || (realStatus == -2 && downloadInfo.isPauseReserveOnWifi())) {
                if (realStatus == -2 && (reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.ah.k()).getReserveWifiStatusListener()) != null) {
                    reserveWifiStatusListener.ms(downloadInfo, 4, 3);
                }
                com.ss.android.socialbase.downloader.downloader.sl slVarI = com.ss.android.socialbase.downloader.downloader.ah.i();
                if (slVarI != null) {
                    slVarI.ms(Collections.singletonList(downloadInfo), 3);
                }
                ah(i);
                return;
            }
            if (realStatus != -1) {
                return;
            }
            if (i2 != 0) {
                zMs = true;
            } else if (!msVar.c) {
                return;
            } else {
                zMs = false;
            }
            BaseException failedException = downloadInfo.getFailedException();
            if (zMs && com.ss.android.socialbase.downloader.ny.c.x(failedException)) {
                zMs = ms(downloadInfo, failedException);
            }
            msVar.xr();
            if (zMs) {
                com.ss.android.socialbase.downloader.ah.ms.ah("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + msVar.f4700ms);
                msVar.ms(System.currentTimeMillis());
                if (z) {
                    msVar.ms();
                }
                downloadInfo.setRetryScheduleCount(msVar.ny);
                if (downloadInfo.getStatus() == -1) {
                    Downloader.getInstance(context).restart(downloadInfo.getId());
                    return;
                }
                return;
            }
            if (z) {
                msVar.ms();
            }
            if (!downloadInfo.isOnlyWifi() && !downloadInfo.isPauseReserveOnWifi()) {
                z2 = false;
            }
            ms(downloadInfo, z2, i2);
        }
    }

    private boolean ms(ms msVar, int i) {
        int[] iArr = msVar.ab;
        if (iArr != null && iArr.length != 0) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    private ms xr(int i) {
        ms msVarD = this.d.get(i);
        if (msVarD == null) {
            synchronized (this.d) {
                msVarD = this.d.get(i);
                if (msVarD == null) {
                    msVarD = d(i);
                }
                this.d.put(i, msVarD);
            }
        }
        return msVarD;
    }

    private void ah(int i) {
        synchronized (this.d) {
            this.d.remove(i);
        }
    }

    private ms d(int i) {
        int[] iArrMs;
        int i2;
        int i3;
        boolean z;
        com.ss.android.socialbase.downloader.ab.ms msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(i);
        boolean z2 = false;
        int iMs = msVarMs.ms("retry_schedule", 0);
        JSONObject jSONObjectD = msVarMs.d("retry_schedule_config");
        int i4 = 60;
        if (jSONObjectD != null) {
            int iOptInt = jSONObjectD.optInt("max_count", 60);
            int iOptInt2 = jSONObjectD.optInt("interval_sec", 60);
            int iOptInt3 = jSONObjectD.optInt("interval_sec_acceleration", 60);
            if (ny != null && jSONObjectD.optInt("use_job_scheduler", 0) == 1) {
                z2 = true;
            }
            iArrMs = ms(jSONObjectD.optString("allow_error_code"));
            i2 = iOptInt3;
            z = z2;
            i3 = iOptInt;
            i4 = iOptInt2;
        } else {
            iArrMs = null;
            i2 = 60;
            i3 = 60;
            z = false;
        }
        return new ms(i, iMs, i3, i4 * 1000, i2 * 1000, z, iArrMs);
    }

    private int[] ms(String str) {
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

    @Override // com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms
    public void xr() {
        ms(4, false);
    }

    @Override // com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms
    public void ah() {
        ms(3, false);
    }

    public void d() {
        ms(2, true);
    }

    public void ka() {
        ms(5, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ab() {
        try {
            if (this.x == null) {
                this.x = (ConnectivityManager) this.xr.getApplicationContext().getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.x.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private boolean ms(DownloadInfo downloadInfo, BaseException baseException) {
        long jD;
        long totalBytes;
        try {
            jD = com.ss.android.socialbase.downloader.ny.c.d(downloadInfo.getTempPath());
        } catch (BaseException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            jD = 0;
        }
        if (baseException instanceof com.ss.android.socialbase.downloader.exception.d) {
            totalBytes = ((com.ss.android.socialbase.downloader.exception.d) baseException).xr();
        } else {
            totalBytes = downloadInfo.getTotalBytes() - downloadInfo.getCurBytes();
        }
        if (jD < totalBytes) {
            com.ss.android.socialbase.downloader.ab.ms msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId());
            if (msVarMs.ms("space_fill_part_download", 0) == 1) {
                if (jD > 0) {
                    int iMs = msVarMs.ms("space_fill_min_keep_mb", 100);
                    if (iMs > 0) {
                        long j = jD - (((long) iMs) * BaseConstants.MB_VALUE);
                        com.ss.android.socialbase.downloader.ah.ms.ah("RetryScheduler", "retry schedule: available = " + com.ss.android.socialbase.downloader.ny.c.ms(jD) + "MB, minKeep = " + iMs + "MB, canDownload = " + com.ss.android.socialbase.downloader.ny.c.ms(j) + "MB");
                        if (j <= 0) {
                            com.ss.android.socialbase.downloader.ah.ms.d("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                            return false;
                        }
                    }
                } else if (msVarMs.ms("download_when_space_negative", 0) != 1) {
                }
            }
            return false;
        }
        return true;
    }

    private static class ms {
        final int[] ab;
        final int ah;
        final boolean c;
        private boolean ch;
        final int d;
        private long hi;
        final int ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final int f4700ms;
        private int ny;
        private boolean sl;
        private int x;
        final int xr;

        ms(int i, int i2, int i3, int i4, int i5, boolean z, int[] iArr) {
            i4 = i4 < 3000 ? 3000 : i4;
            i5 = i5 < 5000 ? 5000 : i5;
            this.f4700ms = i;
            this.xr = i2;
            this.ah = i3;
            this.d = i4;
            this.ka = i5;
            this.c = z;
            this.ab = iArr;
            this.x = i4;
        }

        boolean ms(long j, int i, int i2, boolean z) {
            if (!this.sl) {
                com.ss.android.socialbase.downloader.ah.ms.ah("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            }
            if (this.xr < i || this.ny >= this.ah) {
                return false;
            }
            if (!this.ch || i2 == 2) {
                return z || j - this.hi >= ((long) this.d);
            }
            return false;
        }

        synchronized void ms() {
            this.x += this.ka;
        }

        synchronized void ms(long j) {
            this.hi = j;
        }

        synchronized void xr() {
            this.ny++;
        }

        void ah() {
            this.x = this.d;
        }

        int d() {
            return this.x;
        }
    }
}
