package com.bytedance.sdk.openadsdk.api.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private DownloadModel f1802ms;

    public ah(DownloadModel downloadModel) {
        this.f1802ms = downloadModel;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ms.ms.ms.ms.xr.ms().ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_DOWNLOAD_URL, ms()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_BACKUP_URLS, xr()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_NOTIFICATION_JUMP_URL, ah()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_ID, d()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_MD5, ka()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_EXPECT_FILE_LENGTH, c()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_EXTRA_VALUE, ab()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_NAME, x()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_MIME_TYPE, ny()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_HEADERS, ch()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_SHOW_TOAST, hi()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_SHOW_NOTIFICATION, sl()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_NEED_WIFI, zb()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_IN_EXTERNAL_PUBLIC_DIR, u()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_VISIBLE_IN_DOWNLOADS_UI, ub()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_FILE_PATH, ao()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_FILE_NAME, h()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_DOWNLOAD_SETTINGS, y()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_NEED_INDEPENDENT_PROCESS, b()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_VERSION_CODE, re()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_VERSION_NAME, i()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_AD, w()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_LOG_EXTRA, yu()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_PACKAGE_NAME, op()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_APP_ICON, le()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_DEEP_LINK, cv()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_CLICK_TRACK_URL, g()).ms(223430, of()).ms(223431, p()).ms(223432, pc()).ms(223433, jw()).ms(223434, f()).ms(223435, ul()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_EXECUTOR_GROUP, az()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_FUNNEL_TYPE, m()).ms(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_START_TOAST, lm()).ms(223432, e()).ms(223433, k()).ms(223434, eg()).ms(223435, fm()).xr();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_WIFI /* 223417 */:
                qv();
                return null;
            case ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_HIDE_TOAST /* 223419 */:
                t();
                return null;
            case ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_HIDE_NOTIFICATION /* 223420 */:
                nw();
                return null;
            case 223430:
                if (valueSet != null) {
                    return (T) ms((String) valueSet.objectValue(223431, String.class));
                }
                return null;
            default:
                return null;
        }
    }

    public String ms() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getDownloadUrl();
        }
        return null;
    }

    public List<String> xr() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getBackupUrls();
        }
        return null;
    }

    public String ah() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getNotificationJumpUrl();
        }
        return null;
    }

    public long d() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getId();
        }
        return 0L;
    }

    public String ka() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getMd5();
        }
        return null;
    }

    public long c() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getExpectFileLength();
        }
        return 0L;
    }

    public long ab() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getExtraValue();
        }
        return 0L;
    }

    public String x() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getName();
        }
        return null;
    }

    public String ny() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getMimeType();
        }
        return null;
    }

    public Map<String, String> ch() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getHeaders();
        }
        return null;
    }

    public boolean hi() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.isShowToast();
        }
        return false;
    }

    public boolean sl() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.isShowNotification();
        }
        return false;
    }

    public boolean zb() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.isNeedWifi();
        }
        return false;
    }

    public boolean u() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.isInExternalPublicDir();
        }
        return false;
    }

    public boolean ub() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.isVisibleInDownloadsUi();
        }
        return false;
    }

    public String ao() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getFilePath();
        }
        return null;
    }

    public String h() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getFileName();
        }
        return null;
    }

    public void qv() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            downloadModel.forceWifi();
        }
    }

    public JSONObject y() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getDownloadSettings();
        }
        return null;
    }

    public void t() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            downloadModel.forceHideToast();
        }
    }

    public void nw() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            downloadModel.forceHideNotification();
        }
    }

    public boolean b() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.needIndependentProcess();
        }
        return false;
    }

    public int re() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getVersionCode();
        }
        return 0;
    }

    public String i() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getVersionName();
        }
        return null;
    }

    public boolean w() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.isAd();
        }
        return false;
    }

    public String yu() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getLogExtra();
        }
        return null;
    }

    public String op() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getPackageName();
        }
        return null;
    }

    public String le() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getAppIcon();
        }
        return null;
    }

    public DeepLink cv() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getDeepLink();
        }
        return null;
    }

    public List<String> g() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getClickTrackUrl();
        }
        return null;
    }

    public JSONObject of() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getExtra();
        }
        return null;
    }

    public int p() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getModelType();
        }
        return 0;
    }

    public com.ss.android.download.api.model.d pc() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getQuickAppModel();
        }
        return null;
    }

    public boolean jw() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.autoInstallWithoutNotification();
        }
        return false;
    }

    public IDownloadFileUriProvider f() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getDownloadFileUriProvider();
        }
        return null;
    }

    public boolean ul() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.shouldDownloadWithPatchApply();
        }
        return false;
    }

    public int az() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getExecutorGroup();
        }
        return 0;
    }

    public int m() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getFunnelType();
        }
        return 0;
    }

    public String lm() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getStartToast();
        }
        return null;
    }

    public DownloadModel ms(String str) {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.setFilePath(str);
        }
        return null;
    }

    public String e() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.getSdkMonitorScene();
        }
        return null;
    }

    public boolean k() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.isAutoInstall();
        }
        return false;
    }

    public boolean eg() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.distinctDir();
        }
        return false;
    }

    public boolean fm() {
        DownloadModel downloadModel = this.f1802ms;
        if (downloadModel != null) {
            return downloadModel.enablePause();
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        switch (valueSetXr.intValue(-99999987)) {
            case -99999986:
                return values().sparseArray();
            case ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_WIFI /* 223417 */:
                qv();
                return null;
            case ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_HIDE_TOAST /* 223419 */:
                t();
                return null;
            case ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_HIDE_NOTIFICATION /* 223420 */:
                nw();
                return null;
            case 223430:
                if (valueSetXr != null) {
                    return ms((String) valueSetXr.objectValue(223431, String.class));
                }
                return null;
            default:
                return null;
        }
    }
}
