package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import com.anythink.core.common.e.m;
import com.kuaishou.weapon.p0.g;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class x implements com.ss.android.downloadlib.ab.u.ms {
    private boolean ah = false;
    private ka d;
    private xr ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public com.ss.android.downloadlib.addownload.xr.ka f4440ms;
    private long xr;

    public interface xr {
        void ms(DownloadInfo downloadInfo);
    }

    @Override // com.ss.android.downloadlib.ab.u.ms
    public void ms(Message message) {
    }

    public x(ka kaVar) {
        this.d = kaVar;
    }

    public void ms(long j) {
        this.xr = j;
        com.ss.android.downloadlib.addownload.xr.ka kaVarKa = com.ss.android.downloadlib.addownload.xr.c.ms().ka(j);
        this.f4440ms = kaVarKa;
        if (kaVarKa.i()) {
            com.ss.android.downloadlib.ka.ah.ms().ms("setAdId ModelBox notValid");
        }
    }

    public void ms(DownloadInfo downloadInfo) {
        this.ah = false;
        xr(downloadInfo);
    }

    public void xr(DownloadInfo downloadInfo) {
        xr xrVar = this.ka;
        if (xrVar != null) {
            xrVar.ms(downloadInfo);
            this.ka = null;
        }
    }

    boolean ms(Context context, int i, boolean z) {
        if (com.ss.android.downloadlib.ab.zb.ms(this.f4440ms.xr)) {
            com.ss.android.downloadad.api.ms.xr xrVarD = com.ss.android.downloadlib.addownload.xr.c.ms().d(this.f4440ms.f4454ms);
            if (xrVarD != null) {
                com.ss.android.socialbase.downloader.notification.xr.ms().c(xrVarD.y());
            }
            return com.ss.android.downloadlib.xr.ms.ms(this.f4440ms);
        }
        if (ms(i) && !TextUtils.isEmpty(this.f4440ms.xr.getPackageName()) && hi.ny().optInt("disable_market") != 1) {
            if (com.ss.android.downloadlib.xr.ms.ms(this.f4440ms, i)) {
                return true;
            }
            return this.d.ny() && this.d.d(true);
        }
        if (!z || this.f4440ms.d.getDownloadMode() != 4 || this.d.ka()) {
            return false;
        }
        this.d.ah(true);
        return true;
    }

    public boolean ms(int i) {
        if (this.f4440ms.d.getDownloadMode() == 2 && i == 2) {
            return true;
        }
        return this.f4440ms.d.getDownloadMode() == 2 && i == 1 && hi.ny().optInt("disable_lp_if_market", 0) == 1;
    }

    public boolean ms(int i, DownloadModel downloadModel) {
        return com.ss.android.socialbase.appdownloader.c.ka.ah() && ms(i) && !com.ss.android.downloadlib.ab.zb.ms(downloadModel);
    }

    boolean ms(boolean z) {
        return !z && this.f4440ms.d.getDownloadMode() == 1;
    }

    private boolean ah() {
        return d() && ka();
    }

    private boolean d() {
        return (this.f4440ms.xr == null || TextUtils.isEmpty(this.f4440ms.xr.getPackageName()) || TextUtils.isEmpty(this.f4440ms.xr.getDownloadUrl())) ? false : true;
    }

    private boolean ka() {
        return this.f4440ms.d.isAddToDownloadManage();
    }

    void ms(final t tVar) {
        if (!TextUtils.isEmpty(this.f4440ms.xr.getFilePath())) {
            String filePath = this.f4440ms.xr.getFilePath();
            if (filePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                tVar.ms();
                return;
            } else {
                try {
                    if (filePath.startsWith(hi.getContext().getExternalCacheDir().getParent())) {
                        tVar.ms();
                        return;
                    }
                } catch (Exception unused) {
                }
            }
        }
        xr(new t() { // from class: com.ss.android.downloadlib.addownload.x.1
            @Override // com.ss.android.download.api.config.t
            public void ms() {
                tVar.ms();
            }

            @Override // com.ss.android.download.api.config.t
            public void ms(String str) {
                hi.ah().ms(1, hi.getContext(), x.this.f4440ms.xr, "您已禁止使用存储权限，请授权后再下载", null, 1);
                com.ss.android.downloadlib.d.ms.ms().xr(x.this.xr, 1);
                tVar.ms(str);
            }
        });
    }

    private void xr(final t tVar) {
        String str;
        if (com.ss.android.downloadlib.ab.ch.xr("android.permission.WRITE_EXTERNAL_STORAGE")) {
            if (tVar != null) {
                tVar.ms();
                return;
            }
            return;
        }
        if (com.ss.android.downloadlib.ab.zb.ms()) {
            str = "android.permission.READ_MEDIA_IMAGES";
            if (com.ss.android.downloadlib.ab.ch.xr("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.ab.ch.xr("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.ab.ch.xr("android.permission.READ_MEDIA_VIDEO")) {
                if (tVar != null) {
                    tVar.ms();
                    return;
                }
                return;
            }
        } else {
            str = g.i;
        }
        com.ss.android.downloadlib.ab.ch.ms(new String[]{str}, new com.ss.android.downloadlib.ab.ch.ms() { // from class: com.ss.android.downloadlib.addownload.x.2
            @Override // com.ss.android.downloadlib.ab.ch.ms
            public void ms() {
                t tVar2 = tVar;
                if (tVar2 != null) {
                    tVar2.ms();
                }
            }

            @Override // com.ss.android.downloadlib.ab.ch.ms
            public void ms(String str2) {
                t tVar2 = tVar;
                if (tVar2 != null) {
                    tVar2.ms(str2);
                }
            }
        });
    }

    void ms(Message message, DownloadShortInfo downloadShortInfo, Map<Integer, Object> map) {
        xr xrVar;
        if (message == null || message.what != 3) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) message.obj;
        if (message.arg1 != 1 && message.arg1 != 6 && message.arg1 == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                com.ss.android.downloadlib.x.ms().ms(this.f4440ms.xr, this.f4440ms.d, this.f4440ms.ah);
                downloadInfo.setFirstDownload(false);
            }
            com.ss.android.downloadlib.d.ms.ms().ms(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        ch.ms(downloadShortInfo);
        int iMs = com.ss.android.socialbase.appdownloader.ah.ms(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int curBytes = totalBytes > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((totalBytes > 0 || com.ss.android.socialbase.downloader.ab.ms.ah().ms("fix_click_start")) && (xrVar = this.ka) != null) {
            xrVar.ms(downloadInfo);
            this.ka = null;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : ms(map)) {
            if (iMs != 1) {
                if (iMs == 2) {
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, ch.ms(downloadInfo.getId(), curBytes));
                } else if (iMs == 3) {
                    if (downloadInfo.getStatus() == -4) {
                        downloadStatusChangeListener.onIdle();
                    } else if (downloadInfo.getStatus() == -1) {
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    } else if (downloadInfo.getStatus() == -3) {
                        if (com.ss.android.downloadlib.ab.zb.ms(this.f4440ms.xr)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                    }
                }
            } else if (downloadInfo.getStatus() != 11) {
                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, ch.ms(downloadInfo.getId(), curBytes));
            } else {
                Iterator<com.ss.android.download.api.download.ms> it = xr(map).iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    void ah(DownloadInfo downloadInfo) {
        if (!ny.ms(this.f4440ms.xr) || this.ah) {
            return;
        }
        com.ss.android.downloadlib.d.ms.ms().ms("file_status", (downloadInfo == null || !com.ss.android.downloadlib.ab.zb.xr(downloadInfo.getTargetFilePath())) ? 2 : 1, this.f4440ms);
        this.ah = true;
    }

    void ms() {
        if (this.ka == null) {
            this.ka = new xr() { // from class: com.ss.android.downloadlib.addownload.x.3
                @Override // com.ss.android.downloadlib.addownload.x.xr
                public void ms(DownloadInfo downloadInfo) {
                    com.ss.android.downloadlib.d.ms.ms().ms(x.this.xr, 2, downloadInfo);
                }
            };
        }
    }

    boolean d(DownloadInfo downloadInfo) {
        return c() || ka(downloadInfo);
    }

    private boolean ka(DownloadInfo downloadInfo) {
        return !com.ss.android.downloadlib.ab.zb.ms(this.f4440ms.xr) && c(downloadInfo);
    }

    private boolean c() {
        return com.ss.android.downloadlib.ab.zb.ms(this.f4440ms.xr) && ny.ms(this.f4440ms.d.getLinkMode());
    }

    private boolean c(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && com.ss.android.socialbase.downloader.ny.c.d(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    int ms(Context context, IDownloadListener iDownloadListener) {
        com.ss.android.downloadlib.addownload.ah.ms msVar;
        com.ss.android.socialbase.downloader.model.ah ahVarMs;
        if (context == null) {
            return 0;
        }
        Map<String, String> headers = this.f4440ms.xr.getHeaders();
        ArrayList arrayList = new ArrayList();
        if (hi.ny().optInt("enable_send_click_id_in_apk", 1) == 1 && !TextUtils.isEmpty(this.f4440ms.xr.getLogExtra()) && (ahVarMs = ms(this.f4440ms.xr.getLogExtra())) != null) {
            arrayList.add(ahVarMs);
        }
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.ah(entry.getKey(), entry.getValue()));
                }
            }
        }
        String strMs = com.ss.android.downloadlib.ab.d.ms(String.valueOf(this.f4440ms.xr.getId()), this.f4440ms.xr.getNotificationJumpUrl(), this.f4440ms.xr.isShowToast(), String.valueOf(this.f4440ms.xr.getModelType()));
        com.ss.android.socialbase.downloader.ab.ms msVarXr = com.ss.android.downloadlib.ab.ka.xr(this.f4440ms.xr);
        JSONObject jSONObjectMs = com.ss.android.downloadlib.ab.ka.ms(this.f4440ms.xr);
        if (!this.f4440ms.d.enableAH()) {
            jSONObjectMs = com.ss.android.downloadlib.ab.zb.ms(jSONObjectMs);
            com.ss.android.downloadlib.ab.zb.ms(jSONObjectMs, "ah_plans", new JSONArray());
        }
        int executorGroup = this.f4440ms.xr.getExecutorGroup();
        if (this.f4440ms.xr.isAd() || ny.xr(this.f4440ms.xr)) {
            executorGroup = 4;
        }
        String strMs2 = ms(msVarXr);
        DownloadInfo downloadInfo = Downloader.getInstance(hi.getContext()).getDownloadInfo(com.ss.android.socialbase.downloader.downloader.ah.ms(this.f4440ms.xr.getDownloadUrl(), strMs2));
        if (downloadInfo != null && 3 == this.f4440ms.xr.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        com.ss.android.socialbase.appdownloader.c cVarUb = new com.ss.android.socialbase.appdownloader.c(context, this.f4440ms.xr.getDownloadUrl()).xr(this.f4440ms.xr.getBackupUrls()).ms(this.f4440ms.xr.getName()).ka(strMs).ms(arrayList).ms(this.f4440ms.xr.isShowNotification()).ah(this.f4440ms.xr.isNeedWifi()).xr(this.f4440ms.xr.getFileName()).ah(strMs2).hi(this.f4440ms.xr.getAppIcon()).x(this.f4440ms.xr.getMd5()).ch(this.f4440ms.xr.getSdkMonitorScene()).ms(this.f4440ms.xr.getExpectFileLength()).ms(iDownloadListener).sl(this.f4440ms.xr.needIndependentProcess() || msVarXr.ms("need_independent_process", 0) == 1).ms(this.f4440ms.xr.getDownloadFileUriProvider()).xr(this.f4440ms.xr.autoInstallWithoutNotification()).ab(this.f4440ms.xr.getPackageName()).d(1000).ka(100).ms(jSONObjectMs).ny(true).ch(true).xr(msVarXr.ms(m.b.h, 5)).ah(msVarXr.ms("backup_url_retry_count", 0)).ch(true).zb(msVarXr.ms("need_head_connection", 0) == 1).d(msVarXr.ms("need_https_to_http_retry", 0) == 1).x(msVarXr.ms("need_chunk_downgrade_retry", 1) == 1).ab(msVarXr.ms("need_retry_delay", 0) == 1).ny(msVarXr.ah("retry_delay_time_array")).hi(msVarXr.ms("need_reuse_runnable", 0) == 1).c(executorGroup).ao(this.f4440ms.xr.isAutoInstall()).ub(this.f4440ms.xr.distinctDir());
        if (!TextUtils.isEmpty(this.f4440ms.xr.getMimeType())) {
            cVarUb.c(this.f4440ms.xr.getMimeType());
        } else {
            cVarUb.c("application/vnd.android.package-archive");
        }
        if (msVarXr.ms("notification_opt_2", 0) == 1) {
            cVarUb.ms(false);
            cVarUb.xr(true);
        }
        if (msVarXr.ms("clear_space_use_disk_handler", 0) == 1) {
            msVar = new com.ss.android.downloadlib.addownload.ah.ms();
            cVarUb.ms(msVar);
        } else {
            msVar = null;
        }
        if ((this.f4440ms.xr instanceof AdDownloadModel) && !TextUtils.isEmpty(((AdDownloadModel) this.f4440ms.xr).getTaskKey())) {
            cVarUb.d(((AdDownloadModel) this.f4440ms.xr).getTaskKey());
        }
        int iMs = ny.ms(this.f4440ms, ah(), cVarUb);
        if (msVar != null) {
            msVar.ms(iMs);
        }
        return iMs;
    }

    private String ms(com.ss.android.socialbase.downloader.ab.ms msVar) {
        boolean zXr;
        String strXr;
        if (!TextUtils.isEmpty(this.f4440ms.xr.getFilePath())) {
            return this.f4440ms.xr.getFilePath();
        }
        DownloadInfo downloadInfoMs = com.ss.android.socialbase.appdownloader.d.ch().ms(hi.getContext(), this.f4440ms.xr.getDownloadUrl());
        if (!com.ss.android.downloadlib.ab.zb.ms()) {
            zXr = com.ss.android.downloadlib.ab.ch.xr("android.permission.WRITE_EXTERNAL_STORAGE");
        } else {
            zXr = com.ss.android.downloadlib.ab.ch.xr("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.ab.ch.xr("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.ab.ch.xr("android.permission.READ_MEDIA_VIDEO");
        }
        String strXr2 = xr();
        if (downloadInfoMs != null && !TextUtils.isEmpty(downloadInfoMs.getSavePath())) {
            String savePath = downloadInfoMs.getSavePath();
            if (zXr || savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return savePath;
            }
            try {
                if (!TextUtils.isEmpty(strXr2) && savePath.startsWith(strXr2)) {
                    return savePath;
                }
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.ah.k()).cancel(downloadInfoMs.getId());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(zXr ? 1 : 2));
        } catch (JSONException e2) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e2);
        }
        com.ss.android.downloadlib.d.ms.ms().ms("label_external_permission", jSONObject, this.f4440ms);
        try {
            strXr = com.ss.android.socialbase.appdownloader.ah.xr();
        } catch (Exception unused) {
            strXr = null;
        }
        int iMs = com.ss.android.downloadlib.ab.ka.ms(msVar);
        if (iMs != 0) {
            if (iMs == 4 || (!zXr && iMs == 2)) {
                File filesDir = hi.getContext().getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                if (filesDir.exists()) {
                    return filesDir.getAbsolutePath();
                }
            } else if ((iMs == 3 || (!zXr && iMs == 1)) && !TextUtils.isEmpty(strXr2)) {
                return strXr2;
            }
        }
        return strXr;
    }

    public String xr() {
        File externalFilesDir = hi.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir == null) {
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        if (externalFilesDir.exists()) {
            return externalFilesDir.getAbsolutePath();
        }
        return null;
    }

    void ms(DownloadInfo downloadInfo, boolean z) {
        if (this.f4440ms.xr == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status == -1 || status == -4 || ny.ms(this.f4440ms.xr) || (z && com.ss.android.downloadlib.d.ah.ms().ah() && (status == -2 || status == -3))) {
            com.ss.android.downloadlib.d.ms.ms().ms(this.xr, 2);
        }
        switch (status) {
            case -4:
            case -1:
                ms();
                com.ss.android.downloadlib.addownload.xr.c.ms().ms(new com.ss.android.downloadad.api.ms.xr(this.f4440ms.xr, this.f4440ms.ah, this.f4440ms.d, downloadInfo.getId()));
                break;
            case -3:
                if (com.ss.android.downloadlib.ab.zb.ms(this.f4440ms.xr)) {
                    com.ss.android.downloadlib.ka.ah.ms().xr("SUCCESSED isInstalledApp");
                    break;
                } else {
                    com.ss.android.downloadlib.d.ms.ms().ms(this.xr, 5, downloadInfo);
                    if (z && com.ss.android.downloadlib.d.ah.ms().xr() && !com.ss.android.downloadlib.d.ah.ms().xr(this.xr, this.f4440ms.xr.getLogExtra())) {
                        com.ss.android.downloadlib.d.ms.ms().ms(this.xr, 2);
                        break;
                    }
                }
                break;
            case -2:
                com.ss.android.downloadlib.d.ms.ms().ms(this.xr, 4, downloadInfo);
                if (z && com.ss.android.downloadlib.d.ah.ms().xr() && !com.ss.android.downloadlib.d.ah.ms().xr(this.xr, this.f4440ms.xr.getLogExtra())) {
                    com.ss.android.downloadlib.d.ms.ms().ms(this.xr, 2);
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                com.ss.android.downloadlib.d.ms.ms().ms(this.xr, 3, downloadInfo);
                break;
        }
    }

    void ms(DownloadInfo downloadInfo, DownloadShortInfo downloadShortInfo, List<DownloadStatusChangeListener> list, boolean z) {
        int curBytes;
        if (list.isEmpty()) {
            return;
        }
        if (downloadInfo == null || downloadShortInfo == null) {
            Iterator<DownloadStatusChangeListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onIdle();
            }
            return;
        }
        try {
            curBytes = downloadInfo.getTotalBytes() > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / downloadInfo.getTotalBytes()) : 0;
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        int i = curBytes >= 0 ? curBytes : 0;
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        ch.ms(downloadShortInfo);
        for (DownloadStatusChangeListener downloadStatusChangeListener : list) {
            switch (downloadInfo.getStatus()) {
                case -4:
                case 0:
                    if (com.ss.android.downloadlib.ab.zb.ms(this.f4440ms.xr)) {
                        downloadShortInfo.status = -3;
                        downloadStatusChangeListener.onInstalled(downloadShortInfo);
                    } else {
                        downloadStatusChangeListener.onIdle();
                    }
                    break;
                case -3:
                    if (z) {
                        downloadStatusChangeListener.onInstalled(downloadShortInfo);
                    } else {
                        downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                    }
                    break;
                case -2:
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, ch.ms(downloadInfo.getId(), i));
                    break;
                case -1:
                    downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    downloadStatusChangeListener.onDownloadActive(downloadShortInfo, ch.ms(downloadInfo.getId(), i));
                    break;
                case 11:
                    if (!(downloadStatusChangeListener instanceof com.ss.android.download.api.download.ms)) {
                        downloadStatusChangeListener.onDownloadActive(downloadShortInfo, ch.ms(downloadInfo.getId(), i));
                    }
                    break;
            }
        }
    }

    static class ms extends com.ss.android.socialbase.downloader.depend.ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private com.ss.android.downloadlib.ab.u f4444ms;

        ms(com.ss.android.downloadlib.ab.u uVar) {
            this.f4444ms = uVar;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            ms(downloadInfo, 1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            ms(downloadInfo, 2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            ms(downloadInfo, 4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            ms(downloadInfo, -2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            ms(downloadInfo, -3);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            ms(downloadInfo, -1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            ms(downloadInfo, -4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.ms, com.ss.android.socialbase.downloader.depend.y
        public void ms(DownloadInfo downloadInfo) {
            ms(downloadInfo, 11);
        }

        private void ms(DownloadInfo downloadInfo, int i) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            messageObtain.obj = downloadInfo;
            messageObtain.arg1 = i;
            this.f4444ms.sendMessage(messageObtain);
        }
    }

    public static List<DownloadStatusChangeListener> ms(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof DownloadStatusChangeListener) {
                    arrayList.add((DownloadStatusChangeListener) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof DownloadStatusChangeListener) {
                            arrayList.add((DownloadStatusChangeListener) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof DownloadStatusChangeListener) {
                            arrayList.add((DownloadStatusChangeListener) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<com.ss.android.download.api.download.ms> xr(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.download.api.download.ms) {
                    arrayList.add((com.ss.android.download.api.download.ms) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.ms) {
                            arrayList.add((com.ss.android.download.api.download.ms) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof com.ss.android.download.api.download.ms) {
                            arrayList.add((com.ss.android.download.api.download.ms) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private com.ss.android.socialbase.downloader.model.ah ms(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new com.ss.android.socialbase.downloader.model.ah("clickid", new JSONObject(str).optString("clickid"));
        } catch (JSONException e) {
            hi.t().ms(e, "parseLogExtra Error");
            return null;
        }
    }
}
