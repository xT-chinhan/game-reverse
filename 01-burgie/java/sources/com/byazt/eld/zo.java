package com.byazt.eld;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.bek.DownloadModel;
import com.byazt.bek.DownloadStatusChangeListener;
import com.byazt.cxa.DownloadShortInfo;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.fn.IDownloadListener;
import com.byazt.km.AdDownloadModel;
import com.byazt.lhc.BaseException;
import com.byazt.lj.Downloader;
import com.byazt.zv.cz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 128, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo implements com.byazt.uk.g.pr {
    public hw c;
    public boolean hn = false;
    public long hw;
    public com.byazt.shh.c pr;
    public c x;

    public interface hw {
        void pr(DownloadInfo downloadInfo);
    }

    public zo(c cVar) {
        this.x = cVar;
    }

    public void pr(long j) {
        this.hw = j;
        com.byazt.shh.c cVarC = com.byazt.shh.uc.pr().c(j);
        this.pr = cVarC;
        if (cVarC.rc()) {
            com.byazt.vi.hn.pr().pr("setAdId ModelBox notValid");
        }
    }

    public void pr(DownloadInfo downloadInfo) {
        this.hn = false;
        hw(downloadInfo);
    }

    public void hw(DownloadInfo downloadInfo) {
        hw hwVar = this.c;
        if (hwVar != null) {
            hwVar.pr(downloadInfo);
            this.c = null;
        }
    }

    public boolean pr(Context context, int i, boolean z) {
        if (com.byazt.uk.m.pr(this.pr.hw)) {
            com.byazt.tia.hw hwVarX = com.byazt.shh.uc.pr().x(this.pr.pr);
            if (hwVarX != null) {
                com.byazt.lxs.hw.pr().uc(hwVarX.qa());
            }
            return com.byazt.ds.pr.pr(this.pr);
        }
        if (pr(i) && !TextUtils.isEmpty(this.pr.hw.getPackageName()) && k.aj().optInt("disable_market") != 1) {
            if (com.byazt.ds.pr.pr(this.pr, i)) {
                return true;
            }
            return this.x.aj() && this.x.x(true);
        }
        if (!z || this.pr.x.getDownloadMode() != 4 || this.x.c()) {
            return false;
        }
        this.x.hn(true);
        return true;
    }

    public boolean pr(int i) {
        if (this.pr.x.getDownloadMode() == 2 && i == 2) {
            return true;
        }
        return this.pr.x.getDownloadMode() == 2 && i == 1 && k.aj().optInt("disable_lp_if_market", 0) == 1;
    }

    public boolean pr(int i, DownloadModel downloadModel) {
        return com.byazt.now.c.hn() && pr(i) && !com.byazt.uk.m.pr(downloadModel);
    }

    public boolean pr(boolean z) {
        return !z && this.pr.x.getDownloadMode() == 1;
    }

    private boolean hn() {
        return x() && c();
    }

    private boolean x() {
        return (this.pr.hw == null || TextUtils.isEmpty(this.pr.hw.getPackageName()) || TextUtils.isEmpty(this.pr.hw.getDownloadUrl())) ? false : true;
    }

    private boolean c() {
        return this.pr.x.isAddToDownloadManage();
    }

    public void pr(final cz czVar) {
        if (!TextUtils.isEmpty(this.pr.hw.getFilePath())) {
            String filePath = this.pr.hw.getFilePath();
            if (filePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                czVar.pr();
                return;
            }
            try {
                String parent = k.getContext().getExternalCacheDir().getParent();
                if (parent.endsWith("/cache")) {
                    parent = parent.substring(0, parent.indexOf("/cache"));
                }
                if (filePath.startsWith(parent)) {
                    czVar.pr();
                    return;
                }
            } catch (Exception e) {
            }
        }
        hw(new cz() { // from class: com.byazt.eld.zo.1
            @Override // com.byazt.zv.cz
            public void pr() {
                czVar.pr();
            }

            @Override // com.byazt.zv.cz
            public void pr(String str) {
                k.hn().pr(1, k.getContext(), zo.this.pr.hw, "您已禁止使用存储权限，请授权后再下载", null, 1);
                com.byazt.mf.pr.pr().hw(zo.this.hw, 1);
                czVar.pr(str);
            }
        });
    }

    private void hw(final cz czVar) {
        if (com.byazt.uk.vk.hw("android.permission.WRITE_EXTERNAL_STORAGE")) {
            if (czVar != null) {
                czVar.pr();
                return;
            }
            return;
        }
        String str = "android.permission.READ_MEDIA_IMAGES";
        if (com.byazt.uk.m.pr()) {
            if (com.byazt.uk.vk.hw("android.permission.READ_MEDIA_IMAGES") || com.byazt.uk.vk.hw("android.permission.READ_MEDIA_AUDIO") || com.byazt.uk.vk.hw("android.permission.READ_MEDIA_VIDEO")) {
                if (czVar != null) {
                    czVar.pr();
                    return;
                }
                return;
            }
        } else {
            str = "android.permission.READ_EXTERNAL_STORAGE";
        }
        com.byazt.uk.vk.pr(new String[]{str}, new com.byazt.uk.vk.pr() { // from class: com.byazt.eld.zo.2
            @Override // com.byazt.uk.vk.pr
            public void pr() {
                cz czVar2 = czVar;
                if (czVar2 != null) {
                    czVar2.pr();
                }
            }

            @Override // com.byazt.uk.vk.pr
            public void pr(String str2) {
                cz czVar2 = czVar;
                if (czVar2 != null) {
                    czVar2.pr(str2);
                }
            }
        });
    }

    public void pr(Message message, DownloadShortInfo downloadShortInfo, Map<Integer, Object> map) {
        hw hwVar;
        if (message == null || message.what != 3) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) message.obj;
        if (message.arg1 != 1 && message.arg1 != 6 && message.arg1 == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                com.byazt.cvl.zo.pr().pr(this.pr.hw, this.pr.x, this.pr.hn);
                downloadInfo.setFirstDownload(false);
            }
            com.byazt.mf.pr.pr().pr(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        vk.pr(downloadShortInfo);
        int iPr = com.byazt.mdu.hn.pr(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int curBytes = totalBytes > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((totalBytes > 0 || com.byazt.ew.pr.hn().pr("fix_click_start")) && (hwVar = this.c) != null) {
            hwVar.pr(downloadInfo);
            this.c = null;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : pr(map)) {
            switch (iPr) {
                case 1:
                    if (downloadInfo.getStatus() != 11) {
                        downloadStatusChangeListener.onDownloadActive(downloadShortInfo, vk.pr(downloadInfo.getId(), curBytes));
                    } else {
                        Iterator<com.byazt.bek.pr> it = hw(map).iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                    }
                    break;
                case 2:
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, vk.pr(downloadInfo.getId(), curBytes));
                    break;
                case 3:
                    if (downloadInfo.getStatus() == -4) {
                        downloadStatusChangeListener.onIdle();
                    } else if (downloadInfo.getStatus() == -1) {
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    } else if (downloadInfo.getStatus() == -3) {
                        if (com.byazt.uk.m.pr(this.pr.hw)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                    }
                    break;
            }
        }
    }

    public void hn(DownloadInfo downloadInfo) {
        if (aj.pr(this.pr.hw) && !this.hn) {
            com.byazt.mf.pr.pr().pr("file_status", (downloadInfo == null || !com.byazt.uk.m.hw(downloadInfo.getTargetFilePath())) ? 2 : 1, this.pr);
            this.hn = true;
        }
    }

    public void pr() {
        if (this.c == null) {
            this.c = new hw() { // from class: com.byazt.eld.zo.3
                @Override // com.byazt.eld.zo.hw
                public void pr(DownloadInfo downloadInfo) {
                    com.byazt.mf.pr.pr().pr(zo.this.hw, 2, downloadInfo);
                }
            };
        }
    }

    public boolean x(DownloadInfo downloadInfo) {
        return uc() || c(downloadInfo);
    }

    private boolean c(DownloadInfo downloadInfo) {
        return !com.byazt.uk.m.pr(this.pr.hw) && uc(downloadInfo);
    }

    private boolean uc() {
        return com.byazt.uk.m.pr(this.pr.hw) && aj.pr(this.pr.x.getLinkMode());
    }

    private boolean uc(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && com.byazt.tuy.uc.x(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    public int pr(Context context, IDownloadListener iDownloadListener) {
        com.byazt.auw.hn hnVarPr;
        if (context == null) {
            return 0;
        }
        Map<String, String> headers = this.pr.hw.getHeaders();
        ArrayList arrayList = new ArrayList();
        if (k.aj().optInt("enable_send_click_id_in_apk", 1) == 1 && !TextUtils.isEmpty(this.pr.hw.getLogExtra()) && (hnVarPr = pr(this.pr.hw.getLogExtra())) != null) {
            arrayList.add(hnVarPr);
        }
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new com.byazt.auw.hn(entry.getKey(), entry.getValue()));
                }
            }
        }
        String strPr = com.byazt.uk.x.pr(String.valueOf(this.pr.hw.getId()), this.pr.hw.getNotificationJumpUrl(), this.pr.hw.isShowToast(), String.valueOf(this.pr.hw.getModelType()));
        com.byazt.ew.pr prVarHw = com.byazt.uk.c.hw(this.pr.hw);
        JSONObject jSONObjectPr = com.byazt.uk.c.pr(this.pr.hw);
        if (!this.pr.x.enableAH()) {
            jSONObjectPr = com.byazt.uk.m.pr(jSONObjectPr);
            com.byazt.uk.m.pr(jSONObjectPr, "ah_plans", new JSONArray());
        }
        int executorGroup = this.pr.hw.getExecutorGroup();
        if (this.pr.hw.isAd() || aj.hw(this.pr.hw)) {
            executorGroup = 4;
        }
        String strPr2 = pr(prVarHw);
        DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(com.byazt.lj.hn.pr(this.pr.hw.getDownloadUrl(), strPr2));
        if (downloadInfo != null && 3 == this.pr.hw.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        com.byazt.mdu.c cVarHo = new com.byazt.mdu.c(context, this.pr.hw.getDownloadUrl()).hw(this.pr.hw.getBackupUrls()).pr(this.pr.hw.getName()).c(strPr).pr(arrayList).pr(this.pr.hw.isShowNotification()).hn(this.pr.hw.isNeedWifi()).hw(this.pr.hw.getFileName()).hn(strPr2).w(this.pr.hw.getAppIcon()).zo(this.pr.hw.getMd5()).vk(this.pr.hw.getSdkMonitorScene()).pr(this.pr.hw.getExpectFileLength()).pr(iDownloadListener).k(this.pr.hw.needIndependentProcess() || prVarHw.pr("need_independent_process", 0) == 1).pr(this.pr.hw.getDownloadFileUriProvider()).hw(this.pr.hw.autoInstallWithoutNotification()).fw(this.pr.hw.getPackageName()).x(1000).c(100).pr(jSONObjectPr).aj(true).vk(true).hw(prVarHw.pr("retry_count", 5)).hn(prVarHw.pr("backup_url_retry_count", 0)).vk(true).m(prVarHw.pr("need_head_connection", 0) == 1).x(prVarHw.pr("need_https_to_http_retry", 0) == 1).zo(prVarHw.pr("need_chunk_downgrade_retry", 1) == 1).fw(prVarHw.pr("need_retry_delay", 0) == 1).aj(prVarHw.hn("retry_delay_time_array")).w(prVarHw.pr("need_reuse_runnable", 0) == 1).uc(executorGroup).nt(this.pr.hw.isAutoInstall()).ho(this.pr.hw.distinctDir());
        if (!TextUtils.isEmpty(this.pr.hw.getMimeType())) {
            cVarHo.uc(this.pr.hw.getMimeType());
        } else {
            cVarHo.uc(AdBaseConstants.MIME_APK);
        }
        if (prVarHw.pr("notification_opt_2", 0) == 1) {
            cVarHo.pr(false);
            cVarHo.hw(true);
        }
        com.byazt.ute.pr prVar = null;
        if (prVarHw.pr("clear_space_use_disk_handler", 0) == 1) {
            prVar = new com.byazt.ute.pr();
            cVarHo.pr(prVar);
        }
        if ((this.pr.hw instanceof AdDownloadModel) && !TextUtils.isEmpty(((AdDownloadModel) this.pr.hw).getTaskKey())) {
            cVarHo.x(((AdDownloadModel) this.pr.hw).getTaskKey());
        }
        int iPr = aj.pr(this.pr, hn(), cVarHo);
        if (prVar != null) {
            prVar.pr(iPr);
        }
        return iPr;
    }

    private String pr(com.byazt.ew.pr prVar) {
        boolean zHw;
        int i;
        if (!TextUtils.isEmpty(this.pr.hw.getFilePath())) {
            return this.pr.hw.getFilePath();
        }
        DownloadInfo downloadInfoPr = com.byazt.mdu.x.w().pr(k.getContext(), this.pr.hw.getDownloadUrl());
        if (!com.byazt.uk.m.pr()) {
            zHw = com.byazt.uk.vk.hw("android.permission.WRITE_EXTERNAL_STORAGE");
        } else {
            zHw = com.byazt.uk.vk.hw("android.permission.READ_MEDIA_IMAGES") || com.byazt.uk.vk.hw("android.permission.READ_MEDIA_AUDIO") || com.byazt.uk.vk.hw("android.permission.READ_MEDIA_VIDEO");
        }
        String strHw = hw();
        if (downloadInfoPr != null && !TextUtils.isEmpty(downloadInfoPr.getSavePath())) {
            String savePath = downloadInfoPr.getSavePath();
            if (zHw || savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return savePath;
            }
            try {
                if (!TextUtils.isEmpty(strHw) && savePath.startsWith(strHw)) {
                    return savePath;
                }
            } catch (Exception e) {
            }
            Downloader.getInstance(com.byazt.lj.hn.of()).cancel(downloadInfoPr.getId());
        }
        JSONObject jSONObject = new JSONObject();
        if (zHw) {
            i = 1;
        } else {
            i = 2;
        }
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(i));
        } catch (JSONException e2) {
        }
        com.byazt.mf.pr.pr().pr("label_external_permission", jSONObject, this.pr);
        String strHw2 = null;
        try {
            strHw2 = com.byazt.mdu.hn.hw();
        } catch (Exception e3) {
        }
        int iPr = com.byazt.uk.c.pr(prVar);
        if (iPr != 0) {
            if (iPr == 4 || (!zHw && iPr == 2)) {
                File filesDir = k.getContext().getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                if (!filesDir.exists()) {
                    return strHw2;
                }
                return filesDir.getAbsolutePath();
            }
            if ((iPr == 3 || (!zHw && iPr == 1)) && !TextUtils.isEmpty(strHw)) {
                return strHw;
            }
        }
        return strHw2;
    }

    public String hw() {
        File externalFilesDir = k.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir != null) {
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            if (externalFilesDir.exists()) {
                return externalFilesDir.getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    public void pr(DownloadInfo downloadInfo, boolean z) {
        if (this.pr.hw == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status == -1 || status == -4 || aj.pr(this.pr.hw) || (z && com.byazt.mf.hn.pr().hn() && (status == -2 || status == -3))) {
            com.byazt.mf.pr.pr().pr(this.hw, 2);
        }
        switch (status) {
            case -4:
            case -1:
                pr();
                com.byazt.shh.uc.pr().pr(new com.byazt.tia.hw(this.pr.hw, this.pr.hn, this.pr.x, downloadInfo.getId()));
                break;
            case -3:
                if (com.byazt.uk.m.pr(this.pr.hw)) {
                    com.byazt.vi.hn.pr().hw("SUCCESSED isInstalledApp");
                    break;
                } else {
                    com.byazt.mf.pr.pr().pr(this.hw, 5, downloadInfo);
                    if (z && com.byazt.mf.hn.pr().hw() && !com.byazt.mf.hn.pr().hw(this.hw, this.pr.hw.getLogExtra())) {
                        com.byazt.mf.pr.pr().pr(this.hw, 2);
                        break;
                    }
                }
                break;
            case -2:
                com.byazt.mf.pr.pr().pr(this.hw, 4, downloadInfo);
                if (z && com.byazt.mf.hn.pr().hw() && !com.byazt.mf.hn.pr().hw(this.hw, this.pr.hw.getLogExtra())) {
                    com.byazt.mf.pr.pr().pr(this.hw, 2);
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
                com.byazt.mf.pr.pr().pr(this.hw, 3, downloadInfo);
                break;
        }
    }

    public void pr(DownloadInfo downloadInfo, DownloadShortInfo downloadShortInfo, List<DownloadStatusChangeListener> list, boolean z) {
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
        int i = 0;
        try {
            curBytes = downloadInfo.getTotalBytes() > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / downloadInfo.getTotalBytes()) : 0;
        } catch (Exception e) {
            curBytes = 0;
        }
        if (curBytes >= 0) {
            i = curBytes;
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        vk.pr(downloadShortInfo);
        for (DownloadStatusChangeListener downloadStatusChangeListener : list) {
            switch (downloadInfo.getStatus()) {
                case -4:
                case 0:
                    if (com.byazt.uk.m.pr(this.pr.hw)) {
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
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, vk.pr(downloadInfo.getId(), i));
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
                    downloadStatusChangeListener.onDownloadActive(downloadShortInfo, vk.pr(downloadInfo.getId(), i));
                    break;
                case 11:
                    if (!(downloadStatusChangeListener instanceof com.byazt.bek.pr)) {
                        downloadStatusChangeListener.onDownloadActive(downloadShortInfo, vk.pr(downloadInfo.getId(), i));
                    }
                    break;
            }
        }
    }

    @Override // com.byazt.uk.g.pr
    public void pr(Message message) {
    }

    @com.byazt.vzx.pr(pr = {0, 1, 128, 673})
    static class pr extends com.byazt.fn.pr {
        public com.byazt.uk.g pr;

        public pr(com.byazt.uk.g gVar) {
            this.pr = gVar;
        }

        @Override // com.byazt.fn.AbsDownloadListener, com.byazt.fn.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            pr(downloadInfo, 1);
        }

        @Override // com.byazt.fn.AbsDownloadListener, com.byazt.fn.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            pr(downloadInfo, 2);
        }

        @Override // com.byazt.fn.AbsDownloadListener, com.byazt.fn.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            pr(downloadInfo, 4);
        }

        @Override // com.byazt.fn.AbsDownloadListener, com.byazt.fn.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            pr(downloadInfo, -2);
        }

        @Override // com.byazt.fn.AbsDownloadListener, com.byazt.fn.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            pr(downloadInfo, -3);
        }

        @Override // com.byazt.fn.AbsDownloadListener, com.byazt.fn.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            pr(downloadInfo, -1);
        }

        @Override // com.byazt.fn.AbsDownloadListener, com.byazt.fn.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            pr(downloadInfo, -4);
        }

        @Override // com.byazt.fn.pr, com.byazt.fn.qa
        public void pr(DownloadInfo downloadInfo) {
            pr(downloadInfo, 11);
        }

        private void pr(DownloadInfo downloadInfo, int i) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            messageObtain.obj = downloadInfo;
            messageObtain.arg1 = i;
            this.pr.sendMessage(messageObtain);
        }
    }

    public static List<DownloadStatusChangeListener> pr(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map == null || map.isEmpty()) {
            return arrayList;
        }
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
        return arrayList;
    }

    public static List<com.byazt.bek.pr> hw(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map == null || map.isEmpty()) {
            return arrayList;
        }
        for (Object obj : map.values()) {
            if (obj instanceof com.byazt.bek.pr) {
                arrayList.add((com.byazt.bek.pr) obj);
            } else {
                if (obj instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) obj;
                    if (softReference.get() instanceof com.byazt.bek.pr) {
                        arrayList.add((com.byazt.bek.pr) softReference.get());
                    }
                }
                if (obj instanceof WeakReference) {
                    WeakReference weakReference = (WeakReference) obj;
                    if (weakReference.get() instanceof com.byazt.bek.pr) {
                        arrayList.add((com.byazt.bek.pr) weakReference.get());
                    }
                }
            }
        }
        return arrayList;
    }

    private com.byazt.auw.hn pr(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return new com.byazt.auw.hn("clickid", new JSONObject(str).optString("clickid"));
            }
            return null;
        } catch (JSONException e) {
            k.a().pr(e, "parseLogExtra Error");
            return null;
        }
    }
}
