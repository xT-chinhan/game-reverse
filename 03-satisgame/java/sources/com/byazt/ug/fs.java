package com.byazt.ug;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import com.anythink.china.b.c;
import com.anythink.core.common.f.h;
import com.byazt.hj.DownloadModel;
import com.byazt.hj.DownloadStatusChangeListener;
import com.byazt.je.IDownloadListener;
import com.byazt.ky.py;
import com.byazt.os.DownloadShortInfo;
import com.byazt.q.AdBaseConstants;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.byazt.y.AdDownloadModel;
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

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 101})
public class fs implements com.byazt.rz.sz.n {
    public qg l;
    public com.byazt.vl.l n;
    public l q;
    public long qg;
    public boolean s = false;

    public interface qg {
        void n(DownloadInfo downloadInfo);
    }

    @Override // com.byazt.rz.sz.n
    public void n(Message message) {
    }

    public fs(l lVar) {
        this.q = lVar;
    }

    public void n(long j) {
        this.qg = j;
        com.byazt.vl.l lVarL = com.byazt.vl.w.n().l(j);
        this.n = lVarL;
        if (lVarL.m()) {
            com.byazt.ch.s.n().n("setAdId ModelBox notValid");
        }
    }

    public void n(DownloadInfo downloadInfo) {
        this.s = false;
        qg(downloadInfo);
    }

    public void qg(DownloadInfo downloadInfo) {
        qg qgVar = this.l;
        if (qgVar != null) {
            qgVar.n(downloadInfo);
            this.l = null;
        }
    }

    public boolean n(Context context, int i, boolean z) {
        if (com.byazt.rz.oa.n(this.n.qg)) {
            com.byazt.h.qg qgVarQ = com.byazt.vl.w.n().q(this.n.n);
            if (qgVarQ != null) {
                com.byazt.av.qg.n().w(qgVarQ.um());
            }
            return com.byazt.t.n.n(this.n);
        }
        if (n(i) && !TextUtils.isEmpty(this.n.qg.getPackageName()) && d.rv().optInt("disable_market") != 1) {
            if (com.byazt.t.n.n(this.n, i)) {
                return true;
            }
            return this.q.rv() && this.q.q(true);
        }
        if (!z || this.n.q.getDownloadMode() != 4 || this.q.l()) {
            return false;
        }
        this.q.s(true);
        return true;
    }

    public boolean n(int i) {
        if (this.n.q.getDownloadMode() == 2 && i == 2) {
            return true;
        }
        return this.n.q.getDownloadMode() == 2 && i == 1 && d.rv().optInt("disable_lp_if_market", 0) == 1;
    }

    public boolean n(int i, DownloadModel downloadModel) {
        return com.byazt.bk.l.s() && n(i) && !com.byazt.rz.oa.n(downloadModel);
    }

    public boolean n(boolean z) {
        return !z && this.n.q.getDownloadMode() == 1;
    }

    private boolean s() {
        return q() && l();
    }

    private boolean q() {
        return (this.n.qg == null || TextUtils.isEmpty(this.n.qg.getPackageName()) || TextUtils.isEmpty(this.n.qg.getDownloadUrl())) ? false : true;
    }

    private boolean l() {
        return this.n.q.isAddToDownloadManage();
    }

    public void n(final py pyVar) {
        if (!TextUtils.isEmpty(this.n.qg.getFilePath())) {
            String filePath = this.n.qg.getFilePath();
            if (filePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                pyVar.n();
                return;
            }
            try {
                String parent = d.getContext().getExternalCacheDir().getParent();
                if (parent.endsWith("/cache")) {
                    parent = parent.substring(0, parent.indexOf("/cache"));
                }
                if (filePath.startsWith(parent)) {
                    pyVar.n();
                    return;
                }
            } catch (Exception unused) {
            }
        }
        qg(new py() { // from class: com.byazt.ug.fs.1
            @Override // com.byazt.ky.py
            public void n() {
                pyVar.n();
            }

            @Override // com.byazt.ky.py
            public void n(String str) {
                d.s().n(1, d.getContext(), fs.this.n.qg, "您已禁止使用存储权限，请授权后再下载", null, 1);
                com.byazt.vj.n.n().qg(fs.this.qg, 1);
                pyVar.n(str);
            }
        });
    }

    private void qg(final py pyVar) {
        String str;
        if (com.byazt.rz.tj.qg(c.b)) {
            if (pyVar != null) {
                pyVar.n();
                return;
            }
            return;
        }
        if (com.byazt.rz.oa.n()) {
            str = "android.permission.READ_MEDIA_IMAGES";
            if (com.byazt.rz.tj.qg("android.permission.READ_MEDIA_IMAGES") || com.byazt.rz.tj.qg("android.permission.READ_MEDIA_AUDIO") || com.byazt.rz.tj.qg("android.permission.READ_MEDIA_VIDEO")) {
                if (pyVar != null) {
                    pyVar.n();
                    return;
                }
                return;
            }
        } else {
            str = "android.permission.READ_EXTERNAL_STORAGE";
        }
        com.byazt.rz.tj.n(new String[]{str}, new com.byazt.rz.tj.n() { // from class: com.byazt.ug.fs.2
            @Override // com.byazt.rz.tj.n
            public void n() {
                py pyVar2 = pyVar;
                if (pyVar2 != null) {
                    pyVar2.n();
                }
            }

            @Override // com.byazt.rz.tj.n
            public void n(String str2) {
                py pyVar2 = pyVar;
                if (pyVar2 != null) {
                    pyVar2.n(str2);
                }
            }
        });
    }

    public void n(Message message, DownloadShortInfo downloadShortInfo, Map<Integer, Object> map) {
        qg qgVar;
        if (message == null || message.what != 3) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) message.obj;
        if (message.arg1 != 1 && message.arg1 != 6 && message.arg1 == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                com.byazt.s.fs.n().n(this.n.qg, this.n.q, this.n.s);
                downloadInfo.setFirstDownload(false);
            }
            com.byazt.vj.n.n().n(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        tj.n(downloadShortInfo);
        int iN = com.byazt.e.s.n(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int curBytes = totalBytes > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((totalBytes > 0 || com.byazt.f.n.s().n("fix_click_start")) && (qgVar = this.l) != null) {
            qgVar.n(downloadInfo);
            this.l = null;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : n(map)) {
            if (iN != 1) {
                if (iN == 2) {
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, tj.n(downloadInfo.getId(), curBytes));
                } else if (iN == 3) {
                    if (downloadInfo.getStatus() == -4) {
                        downloadStatusChangeListener.onIdle();
                    } else if (downloadInfo.getStatus() == -1) {
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    } else if (downloadInfo.getStatus() == -3) {
                        if (com.byazt.rz.oa.n(this.n.qg)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                    }
                }
            } else if (downloadInfo.getStatus() != 11) {
                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, tj.n(downloadInfo.getId(), curBytes));
            } else {
                Iterator<com.byazt.hj.n> it = qg(map).iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    public void s(DownloadInfo downloadInfo) {
        if (!rv.n(this.n.qg) || this.s) {
            return;
        }
        com.byazt.vj.n.n().n("file_status", (downloadInfo == null || !com.byazt.rz.oa.qg(downloadInfo.getTargetFilePath())) ? 2 : 1, this.n);
        this.s = true;
    }

    public void n() {
        if (this.l == null) {
            this.l = new qg() { // from class: com.byazt.ug.fs.3
                @Override // com.byazt.ug.fs.qg
                public void n(DownloadInfo downloadInfo) {
                    com.byazt.vj.n.n().n(fs.this.qg, 2, downloadInfo);
                }
            };
        }
    }

    public boolean q(DownloadInfo downloadInfo) {
        return w() || l(downloadInfo);
    }

    private boolean l(DownloadInfo downloadInfo) {
        return !com.byazt.rz.oa.n(this.n.qg) && w(downloadInfo);
    }

    private boolean w() {
        return com.byazt.rz.oa.n(this.n.qg) && rv.n(this.n.q.getLinkMode());
    }

    private boolean w(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && com.byazt.ta.w.q(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    public int n(Context context, IDownloadListener iDownloadListener) {
        com.byazt.nb.n nVar;
        com.byazt.wm.s sVarN;
        if (context == null) {
            return 0;
        }
        Map<String, String> headers = this.n.qg.getHeaders();
        ArrayList arrayList = new ArrayList();
        if (d.rv().optInt("enable_send_click_id_in_apk", 1) == 1 && !TextUtils.isEmpty(this.n.qg.getLogExtra()) && (sVarN = n(this.n.qg.getLogExtra())) != null) {
            arrayList.add(sVarN);
        }
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new com.byazt.wm.s(entry.getKey(), entry.getValue()));
                }
            }
        }
        String strN = com.byazt.rz.q.n(String.valueOf(this.n.qg.getId()), this.n.qg.getNotificationJumpUrl(), this.n.qg.isShowToast(), String.valueOf(this.n.qg.getModelType()));
        com.byazt.f.n nVarQg = com.byazt.rz.l.qg(this.n.qg);
        JSONObject jSONObjectN = com.byazt.rz.l.n(this.n.qg);
        if (!this.n.q.enableAH()) {
            jSONObjectN = com.byazt.rz.oa.n(jSONObjectN);
            com.byazt.rz.oa.n(jSONObjectN, "ah_plans", new JSONArray());
        }
        int executorGroup = this.n.qg.getExecutorGroup();
        if (this.n.qg.isAd() || rv.qg(this.n.qg)) {
            executorGroup = 4;
        }
        String strN2 = n(nVarQg);
        DownloadInfo downloadInfo = Downloader.getInstance(d.getContext()).getDownloadInfo(com.byazt.xv.s.n(this.n.qg.getDownloadUrl(), strN2));
        if (downloadInfo != null && 3 == this.n.qg.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        com.byazt.e.l lVarK = new com.byazt.e.l(context, this.n.qg.getDownloadUrl()).qg(this.n.qg.getBackupUrls()).n(this.n.qg.getName()).l(strN).n(arrayList).n(this.n.qg.isShowNotification()).s(this.n.qg.isNeedWifi()).qg(this.n.qg.getFileName()).s(strN2).cp(this.n.qg.getAppIcon()).fs(this.n.qg.getMd5()).tj(this.n.qg.getSdkMonitorScene()).n(this.n.qg.getExpectFileLength()).n(iDownloadListener).d(this.n.qg.needIndependentProcess() || nVarQg.n("need_independent_process", 0) == 1).n(this.n.qg.getDownloadFileUriProvider()).qg(this.n.qg.autoInstallWithoutNotification()).x(this.n.qg.getPackageName()).q(1000).l(100).n(jSONObjectN).rv(true).tj(true).qg(nVarQg.n(h.b.h, 5)).s(nVarQg.n("backup_url_retry_count", 0)).tj(true).oa(nVarQg.n("need_head_connection", 0) == 1).q(nVarQg.n("need_https_to_http_retry", 0) == 1).fs(nVarQg.n("need_chunk_downgrade_retry", 1) == 1).x(nVarQg.n("need_retry_delay", 0) == 1).rv(nVarQg.s("retry_delay_time_array")).cp(nVarQg.n("need_reuse_runnable", 0) == 1).w(executorGroup).cy(this.n.qg.isAutoInstall()).k(this.n.qg.distinctDir());
        if (!TextUtils.isEmpty(this.n.qg.getMimeType())) {
            lVarK.w(this.n.qg.getMimeType());
        } else {
            lVarK.w(AdBaseConstants.MIME_APK);
        }
        if (nVarQg.n("notification_opt_2", 0) == 1) {
            lVarK.n(false);
            lVarK.qg(true);
        }
        if (nVarQg.n("clear_space_use_disk_handler", 0) == 1) {
            nVar = new com.byazt.nb.n();
            lVarK.n(nVar);
        } else {
            nVar = null;
        }
        if ((this.n.qg instanceof AdDownloadModel) && !TextUtils.isEmpty(((AdDownloadModel) this.n.qg).getTaskKey())) {
            lVarK.q(((AdDownloadModel) this.n.qg).getTaskKey());
        }
        int iN = rv.n(this.n, s(), lVarK);
        if (nVar != null) {
            nVar.n(iN);
        }
        return iN;
    }

    private String n(com.byazt.f.n nVar) {
        boolean zQg;
        String strQg;
        if (!TextUtils.isEmpty(this.n.qg.getFilePath())) {
            return this.n.qg.getFilePath();
        }
        DownloadInfo downloadInfoN = com.byazt.e.q.cp().n(d.getContext(), this.n.qg.getDownloadUrl());
        if (!com.byazt.rz.oa.n()) {
            zQg = com.byazt.rz.tj.qg(c.b);
        } else {
            zQg = com.byazt.rz.tj.qg("android.permission.READ_MEDIA_IMAGES") || com.byazt.rz.tj.qg("android.permission.READ_MEDIA_AUDIO") || com.byazt.rz.tj.qg("android.permission.READ_MEDIA_VIDEO");
        }
        String strQg2 = qg();
        if (downloadInfoN != null && !TextUtils.isEmpty(downloadInfoN.getSavePath())) {
            String savePath = downloadInfoN.getSavePath();
            if (zQg || savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return savePath;
            }
            try {
                if (!TextUtils.isEmpty(strQg2) && savePath.startsWith(strQg2)) {
                    return savePath;
                }
            } catch (Exception unused) {
            }
            Downloader.getInstance(com.byazt.xv.s.u()).cancel(downloadInfoN.getId());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(zQg ? 1 : 2));
        } catch (JSONException unused2) {
        }
        com.byazt.vj.n.n().n("label_external_permission", jSONObject, this.n);
        try {
            strQg = com.byazt.e.s.qg();
        } catch (Exception unused3) {
            strQg = null;
        }
        int iN = com.byazt.rz.l.n(nVar);
        if (iN != 0) {
            if (iN == 4 || (!zQg && iN == 2)) {
                File filesDir = d.getContext().getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                if (filesDir.exists()) {
                    return filesDir.getAbsolutePath();
                }
            } else if ((iN == 3 || (!zQg && iN == 1)) && !TextUtils.isEmpty(strQg2)) {
                return strQg2;
            }
        }
        return strQg;
    }

    public String qg() {
        File externalFilesDir = d.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
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

    public void n(DownloadInfo downloadInfo, boolean z) {
        if (this.n.qg == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status == -1 || status == -4 || rv.n(this.n.qg) || (z && com.byazt.vj.s.n().s() && (status == -2 || status == -3))) {
            com.byazt.vj.n.n().n(this.qg, 2);
        }
        switch (status) {
            case -4:
            case -1:
                n();
                com.byazt.vl.w.n().n(new com.byazt.h.qg(this.n.qg, this.n.s, this.n.q, downloadInfo.getId()));
                break;
            case -3:
                if (com.byazt.rz.oa.n(this.n.qg)) {
                    com.byazt.ch.s.n().qg("SUCCESSED isInstalledApp");
                    break;
                } else {
                    com.byazt.vj.n.n().n(this.qg, 5, downloadInfo);
                    if (z && com.byazt.vj.s.n().qg() && !com.byazt.vj.s.n().qg(this.qg, this.n.qg.getLogExtra())) {
                        com.byazt.vj.n.n().n(this.qg, 2);
                        break;
                    }
                }
                break;
            case -2:
                com.byazt.vj.n.n().n(this.qg, 4, downloadInfo);
                if (z && com.byazt.vj.s.n().qg() && !com.byazt.vj.s.n().qg(this.qg, this.n.qg.getLogExtra())) {
                    com.byazt.vj.n.n().n(this.qg, 2);
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
                com.byazt.vj.n.n().n(this.qg, 3, downloadInfo);
                break;
        }
    }

    public void n(DownloadInfo downloadInfo, DownloadShortInfo downloadShortInfo, List<DownloadStatusChangeListener> list, boolean z) {
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
        } catch (Exception unused) {
        }
        int i = curBytes >= 0 ? curBytes : 0;
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        tj.n(downloadShortInfo);
        for (DownloadStatusChangeListener downloadStatusChangeListener : list) {
            switch (downloadInfo.getStatus()) {
                case -4:
                case 0:
                    if (com.byazt.rz.oa.n(this.n.qg)) {
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
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, tj.n(downloadInfo.getId(), i));
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
                    downloadStatusChangeListener.onDownloadActive(downloadShortInfo, tj.n(downloadInfo.getId(), i));
                    break;
                case 11:
                    if (!(downloadStatusChangeListener instanceof com.byazt.hj.n)) {
                        downloadStatusChangeListener.onDownloadActive(downloadShortInfo, tj.n(downloadInfo.getId(), i));
                    }
                    break;
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO})
    static class n extends com.byazt.je.n {
        public com.byazt.rz.sz n;

        public n(com.byazt.rz.sz szVar) {
            this.n = szVar;
        }

        @Override // com.byazt.je.AbsDownloadListener, com.byazt.je.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            n(downloadInfo, 1);
        }

        @Override // com.byazt.je.AbsDownloadListener, com.byazt.je.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            n(downloadInfo, 2);
        }

        @Override // com.byazt.je.AbsDownloadListener, com.byazt.je.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            n(downloadInfo, 4);
        }

        @Override // com.byazt.je.AbsDownloadListener, com.byazt.je.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            n(downloadInfo, -2);
        }

        @Override // com.byazt.je.AbsDownloadListener, com.byazt.je.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            n(downloadInfo, -3);
        }

        @Override // com.byazt.je.AbsDownloadListener, com.byazt.je.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            n(downloadInfo, -1);
        }

        @Override // com.byazt.je.AbsDownloadListener, com.byazt.je.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            n(downloadInfo, -4);
        }

        @Override // com.byazt.je.n, com.byazt.je.um
        public void n(DownloadInfo downloadInfo) {
            n(downloadInfo, 11);
        }

        private void n(DownloadInfo downloadInfo, int i) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            messageObtain.obj = downloadInfo;
            messageObtain.arg1 = i;
            this.n.sendMessage(messageObtain);
        }
    }

    public static List<DownloadStatusChangeListener> n(Map<Integer, Object> map) {
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

    public static List<com.byazt.hj.n> qg(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.byazt.hj.n) {
                    arrayList.add((com.byazt.hj.n) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.byazt.hj.n) {
                            arrayList.add((com.byazt.hj.n) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof com.byazt.hj.n) {
                            arrayList.add((com.byazt.hj.n) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private com.byazt.wm.s n(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new com.byazt.wm.s("clickid", new JSONObject(str).optString("clickid"));
        } catch (JSONException e) {
            d.a().n(e, "parseLogExtra Error");
            return null;
        }
    }
}
