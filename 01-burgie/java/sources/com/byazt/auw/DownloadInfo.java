package com.byazt.auw;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.byazt.fi.BaseConstants;
import com.byazt.fn.e;
import com.byazt.lhc.BaseException;
import com.byazt.lj.vk;
import com.byazt.mrs.DownloadStatus;
import com.byazt.mrs.EnqueueType;
import com.byazt.mrs.fw;
import com.byazt.tuy.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import com.umeng.analytics.pro.ar;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME, 1943})
public class DownloadInfo implements Parcelable {
    public static final Parcelable.Creator<DownloadInfo> CREATOR = new Parcelable.Creator<DownloadInfo>() { // from class: com.byazt.auw.DownloadInfo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public DownloadInfo createFromParcel(Parcel parcel) {
            return new DownloadInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public DownloadInfo[] newArray(int i) {
            return new DownloadInfo[i];
        }
    };
    public static final int DEFAULT_MAX_PROCESS_POST_COUNT = 100;
    public static final long DEFAULT_MIN_BYTES_INTERVAL = 1048576;
    public static final int RESERVE_STATUS_NEVER = 0;
    public static final int RESERVE_STATUS_NOW = 2;
    public static final int RESERVE_STATUS_ONCE = 1;
    public static final String TAG = "DownloadInfo";
    public boolean addListenerToSameTask;
    public AtomicLong allConnectTime;
    public int appVersionCode;
    public com.byazt.mrs.pr asyncHandleStatus;
    public boolean autoResumed;
    public int backUpUrlRetryCount;
    public boolean backUpUrlUsed;
    public List<String> backUpUrls;
    public String backUpUrlsStr;
    public int bindValueCount;
    public com.byazt.mrs.hw byteInvalidRetryStatus;
    public int chunkCount;
    public boolean chunkDowngradeRetryUsed;
    public int curBackUpUrlIndex;
    public AtomicLong curBytes;
    public int curRetryTime;
    public JSONObject dbJsonData;
    public String dbJsonDataString;
    public boolean deleteCacheIfCheckFailed;
    public boolean distinctDirectory;
    public long downloadTime;
    public String eTag;
    public EnqueueType enqueueType;
    public StringBuffer errorBytesLog;
    public boolean expiredRedownload;
    public String extra;
    public List<hn> extraHeaders;
    public int[] extraMonitorStatus;
    public BaseException failedException;
    public String filePackageName;
    public List<String> forbiddenBackupUrls;
    public boolean force;
    public boolean forceIgnoreRecommendSize;
    public boolean headConnectionAvailable;
    public String headConnectionException;
    public int httpStatusCode;
    public String httpStatusMessage;
    public boolean httpsToHttpRetryUsed;
    public String iconUrl;
    public int id;
    public boolean ignoreDataVerify;
    public Boolean isAutoInstallWithoutNotification;
    public boolean isFirstDownload;
    public boolean isFirstSuccess;
    public boolean isForbiddenRetryed;
    public volatile boolean isSaveTempFile;
    public AtomicLong lastNotifyProgressTime;
    public boolean mDownloadFromReserveWifi;
    public int maxBytes;
    public int maxProgressCount;
    public String md5;
    public String mimeType;
    public int minProgressTimeMsInterval;
    public String monitorScene;
    public String name;
    public boolean needChunkDowngradeRetry;
    public boolean needDefaultHttpServiceBackUp;
    public boolean needHttpsToHttpRetry;
    public boolean needIndependentProcess;
    public boolean needPostProgress;
    public boolean needRetryDelay;
    public boolean needReuseChunkRunnable;
    public boolean needReuseFirstConnection;
    public boolean needSDKMonitor;
    public String networkQuality;
    public int notificationVisibility;
    public boolean onlyWifi;
    public boolean openLimitSpeed;
    public String[] outIp;
    public int[] outSize;
    public SoftReference<PackageInfo> packageInfoRef;
    public String packageName;
    public long realDownloadTime;
    public long realStartDownloadTime;
    public int retryCount;
    public fw retryDelayStatus;
    public String retryDelayTimeArray;

    @Deprecated
    public int retryScheduleMinutes;
    public String savePath;
    public boolean showNotification;
    public boolean showNotificationForAutoResumed;
    public boolean showNotificationForNetworkResumed;
    public JSONObject spData;
    public long startDownloadTime;
    public AtomicInteger status;
    public int statusAtDbInit;
    public boolean successByCache;
    public boolean supportPartial;
    public String taskId;
    public ConcurrentHashMap<String, Object> tempCacheData;
    public volatile List<e> tempFileSaveCompleteCallbacks;
    public String tempPath;
    public long throttleNetSpeed;
    public String title;
    public long totalBytes;
    public long ttnetProtectTimeout;
    public String url;

    public DownloadInfo() {
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = fw.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.byazt.mrs.pr.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.byazt.mrs.hw.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Throwable] */
    private DownloadInfo(pr prVar) {
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = fw.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.byazt.mrs.pr.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.byazt.mrs.hw.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
        if (prVar == null) {
            return;
        }
        this.name = prVar.pr;
        this.title = prVar.hw;
        this.url = prVar.hn;
        String strC = prVar.x;
        if (TextUtils.isEmpty(strC)) {
            try {
                strC = uc.c();
            } catch (Throwable th) {
            }
        }
        this.savePath = strC;
        String str = prVar.c;
        this.tempPath = str;
        if (TextUtils.isEmpty(str) && !uc.zo(strC)) {
            this.tempPath = uc.uc();
        }
        safePutToDBJsonData("task_key", prVar.jn);
        if (prVar.bm) {
            if (com.byazt.lj.hn.z().hw(getId()) == null) {
                this.savePath = uc.c(this.savePath, this.url);
                this.tempPath = uc.c(this.tempPath, this.url);
            }
        } else {
            com.byazt.p000do.pr.c(TAG, "The distinct directory option is not set, which may cause 1005 problems and file downloads being covered");
        }
        this.status = new AtomicInteger(0);
        this.curBytes = new AtomicLong(0L);
        this.extra = prVar.fw;
        this.onlyWifi = prVar.uc;
        this.extraHeaders = prVar.zo;
        this.maxBytes = prVar.aj;
        this.retryCount = prVar.k;
        this.backUpUrlRetryCount = prVar.m;
        this.force = prVar.g;
        this.outIp = prVar.vk;
        this.outSize = prVar.w;
        this.needPostProgress = prVar.ho;
        this.maxProgressCount = prVar.nt;
        this.minProgressTimeMsInterval = prVar.yb;
        this.backUpUrls = prVar.lb;
        this.showNotification = prVar.qa;
        this.mimeType = prVar.cz;
        this.needHttpsToHttpRetry = prVar.ny;
        this.needRetryDelay = prVar.nl;
        this.retryDelayTimeArray = prVar.y;
        this.autoResumed = prVar.fo;
        this.showNotificationForAutoResumed = prVar.rc;
        this.needDefaultHttpServiceBackUp = prVar.z;
        this.needReuseChunkRunnable = prVar.b;
        this.packageName = prVar.iu;
        this.md5 = prVar.ve;
        this.needReuseFirstConnection = prVar.ww;
        this.needIndependentProcess = prVar.n;
        this.enqueueType = prVar.e;
        this.headConnectionAvailable = prVar.s;
        this.ignoreDataVerify = prVar.ls;
        this.addListenerToSameTask = prVar.of;
        this.needChunkDowngradeRetry = prVar.er;
        this.iconUrl = prVar.v;
        this.throttleNetSpeed = prVar.qi;
        this.openLimitSpeed = prVar.qn;
        JSONObject jSONObject = prVar.ii;
        if (jSONObject != null) {
            safePutToDBJsonData("download_setting", jSONObject.toString());
        }
        safePutToDBJsonData("dbjson_key_expect_file_length", Long.valueOf(prVar.gz));
        safePutToDBJsonData("executor_group", Integer.valueOf(prVar.nw));
        safePutToDBJsonData("auto_install", Integer.valueOf(prVar.a ? 1 : 0));
        this.needSDKMonitor = prVar.i;
        this.monitorScene = prVar.r;
        this.extraMonitorStatus = prVar.hs;
        this.expiredRedownload = prVar.ie;
        this.deleteCacheIfCheckFailed = prVar.o;
        this.ttnetProtectTimeout = prVar.f;
        this.distinctDirectory = prVar.bm;
        if (this.expiredRedownload && this.retryCount <= 0) {
            this.retryCount = 1;
        }
        putMonitorSetting();
    }

    public void setAddListenerToSameTask(boolean z) {
        this.addListenerToSameTask = z;
    }

    private void putMonitorSetting() {
        safePutToDBJsonData("need_sdk_monitor", Boolean.valueOf(this.needSDKMonitor));
        safePutToDBJsonData("monitor_scene", this.monitorScene);
        try {
            JSONArray jSONArray = new JSONArray();
            int[] iArr = this.extraMonitorStatus;
            if (iArr != null && iArr.length > 0) {
                int i = 0;
                while (true) {
                    int[] iArr2 = this.extraMonitorStatus;
                    if (i >= iArr2.length) {
                        break;
                    }
                    jSONArray.put(iArr2[i]);
                    i++;
                }
            }
            safePutToDBJsonData("extra_monitor_status", jSONArray);
        } catch (Throwable th) {
        }
    }

    private void parseMonitorSetting() {
        ensureDBJsonData();
        this.needSDKMonitor = this.dbJsonData.optBoolean("need_sdk_monitor", false);
        this.monitorScene = this.dbJsonData.optString("monitor_scene", "");
        JSONArray jSONArrayOptJSONArray = this.dbJsonData.optJSONArray("extra_monitor_status");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            this.extraMonitorStatus = new int[jSONArrayOptJSONArray.length()];
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                this.extraMonitorStatus[i] = jSONArrayOptJSONArray.optInt(i);
            }
        }
    }

    public void readFromParcel(Parcel parcel) {
        this.id = parcel.readInt();
        this.name = parcel.readString();
        this.title = parcel.readString();
        this.url = parcel.readString();
        this.savePath = parcel.readString();
        this.tempPath = parcel.readString();
        this.onlyWifi = parcel.readByte() != 0;
        this.extra = parcel.readString();
        this.extraHeaders = parcel.createTypedArrayList(hn.CREATOR);
        this.maxBytes = parcel.readInt();
        this.outIp = parcel.createStringArray();
        this.outSize = parcel.createIntArray();
        this.retryCount = parcel.readInt();
        this.backUpUrlRetryCount = parcel.readInt();
        this.force = parcel.readByte() != 0;
        this.needPostProgress = parcel.readByte() != 0;
        this.maxProgressCount = parcel.readInt();
        this.minProgressTimeMsInterval = parcel.readInt();
        this.backUpUrls = parcel.createStringArrayList();
        this.showNotification = parcel.readByte() != 0;
        this.mimeType = parcel.readString();
        this.needHttpsToHttpRetry = parcel.readByte() != 0;
        this.packageName = parcel.readString();
        this.md5 = parcel.readString();
        this.needRetryDelay = parcel.readByte() != 0;
        this.needDefaultHttpServiceBackUp = parcel.readByte() != 0;
        this.needReuseChunkRunnable = parcel.readByte() != 0;
        this.retryDelayTimeArray = parcel.readString();
        this.eTag = parcel.readString();
        this.curRetryTime = parcel.readInt();
        convertRetryDelayStatus(parcel.readInt());
        this.needReuseFirstConnection = parcel.readByte() != 0;
        this.forceIgnoreRecommendSize = parcel.readByte() != 0;
        this.networkQuality = parcel.readString();
        this.curBackUpUrlIndex = parcel.readInt();
        this.notificationVisibility = parcel.readInt();
        this.chunkCount = parcel.readInt();
        setCurBytes(parcel.readLong());
        this.totalBytes = parcel.readLong();
        setStatus(parcel.readInt());
        this.downloadTime = parcel.readLong();
        this.realDownloadTime = parcel.readLong();
        this.backUpUrlUsed = parcel.readByte() != 0;
        this.httpsToHttpRetryUsed = parcel.readByte() != 0;
        try {
            StringBuffer stringBuffer = this.errorBytesLog;
            if (stringBuffer == null) {
                this.errorBytesLog = new StringBuffer(parcel.readString());
            } else {
                stringBuffer.delete(0, stringBuffer.length()).append(parcel.readString());
            }
        } catch (Exception e) {
        }
        this.autoResumed = parcel.readByte() != 0;
        this.showNotificationForAutoResumed = parcel.readByte() != 0;
        this.showNotificationForNetworkResumed = parcel.readByte() != 0;
        this.forbiddenBackupUrls = parcel.createStringArrayList();
        this.needIndependentProcess = parcel.readByte() != 0;
        convertEnqueueType(parcel.readInt());
        this.headConnectionAvailable = parcel.readByte() != 0;
        this.httpStatusCode = parcel.readInt();
        this.httpStatusMessage = parcel.readString();
        this.isSaveTempFile = parcel.readByte() != 0;
        this.isForbiddenRetryed = parcel.readByte() != 0;
        this.addListenerToSameTask = parcel.readByte() != 0;
        this.needChunkDowngradeRetry = parcel.readByte() != 0;
        this.chunkDowngradeRetryUsed = parcel.readByte() != 0;
        this.failedException = (BaseException) parcel.readParcelable(BaseException.class.getClassLoader());
        this.retryScheduleMinutes = parcel.readInt();
        this.dbJsonDataString = parcel.readString();
        this.supportPartial = parcel.readByte() != 0;
        this.iconUrl = parcel.readString();
        this.appVersionCode = parcel.readInt();
        this.taskId = parcel.readString();
        this.expiredRedownload = parcel.readByte() != 0;
        this.deleteCacheIfCheckFailed = parcel.readByte() != 0;
        this.successByCache = parcel.readByte() != 0;
        parseMonitorSetting();
    }

    private JSONObject convertStrToJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return new JSONObject(str);
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private String getBackUpUrlsStr() {
        List<String> list;
        if (this.backUpUrlsStr == null && (list = this.backUpUrls) != null && !list.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String str : this.backUpUrls) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                this.backUpUrlsStr = jSONArray.toString();
            } catch (Exception e) {
            }
        }
        if (this.backUpUrlsStr == null) {
            this.backUpUrlsStr = "";
        }
        return this.backUpUrlsStr;
    }

    private void setBackUpUrlsStr(String str) {
        if (TextUtils.isEmpty(str) || getStatus() == -3) {
            return;
        }
        this.backUpUrlsStr = str;
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    String strOptString = jSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString)) {
                        arrayList.add(strOptString);
                    }
                }
                this.backUpUrls = arrayList;
            }
        } catch (Exception e) {
        }
    }

    public boolean isWaitingWifiStatus() {
        BaseException baseException = this.failedException;
        return baseException != null && baseException.getErrorCode() == 1013;
    }

    public boolean canNotifyProgress() {
        long j = this.lastNotifyProgressTime.get();
        return j == 0 || SystemClock.uptimeMillis() - j > 20;
    }

    public void setLastNotifyProgressTime() {
        this.lastNotifyProgressTime.set(SystemClock.uptimeMillis());
    }

    public String getHeadConnectionException() {
        return this.headConnectionException;
    }

    public void setHeadConnectionException(String str) {
        this.headConnectionException = str;
    }

    public DownloadInfo(Parcel parcel) {
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = fw.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.byazt.mrs.pr.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.byazt.mrs.hw.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
        readFromParcel(parcel);
    }

    private void convertEnqueueType(int i) {
        if (i == EnqueueType.ENQUEUE_HEAD.ordinal()) {
            this.enqueueType = EnqueueType.ENQUEUE_HEAD;
        } else if (i == EnqueueType.ENQUEUE_TAIL.ordinal()) {
            this.enqueueType = EnqueueType.ENQUEUE_TAIL;
        } else {
            this.enqueueType = EnqueueType.ENQUEUE_NONE;
        }
    }

    private void convertRetryDelayStatus(int i) {
        if (i == fw.DELAY_RETRY_WAITING.ordinal()) {
            this.retryDelayStatus = fw.DELAY_RETRY_WAITING;
            return;
        }
        if (i == fw.DELAY_RETRY_DOWNLOADING.ordinal()) {
            this.retryDelayStatus = fw.DELAY_RETRY_DOWNLOADING;
        } else if (i == fw.DELAY_RETRY_DOWNLOADED.ordinal()) {
            this.retryDelayStatus = fw.DELAY_RETRY_DOWNLOADED;
        } else {
            this.retryDelayStatus = fw.DELAY_RETRY_NONE;
        }
    }

    public int getDownloadProcess() {
        if (this.totalBytes <= 0) {
            return 0;
        }
        if (getCurBytes() > this.totalBytes) {
            return 100;
        }
        return (int) ((getCurBytes() * 100) / this.totalBytes);
    }

    public void addErrorBytesLog(long j, int i, String str) {
        try {
            if (com.byazt.p000do.pr.pr()) {
                if (this.errorBytesLog == null) {
                    this.errorBytesLog = new StringBuffer();
                }
                if (this.errorBytesLog.length() != 0) {
                    this.errorBytesLog.append(",");
                }
                this.errorBytesLog.append("[type:").append(i).append(",bytes:").append(j).append(",method:").append(str).append("]");
            }
        } catch (Exception e) {
        }
    }

    public String getErrorBytesLog() {
        StringBuffer stringBuffer = this.errorBytesLog;
        if (stringBuffer == null || stringBuffer.length() == 0) {
            return "";
        }
        return this.errorBytesLog.toString();
    }

    public DownloadInfo(Cursor cursor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11 = true;
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = fw.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.byazt.mrs.pr.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.byazt.mrs.hw.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
        if (cursor == null) {
            return;
        }
        try {
            int columnIndex = cursor.getColumnIndex(ar.d);
            if (columnIndex != -1) {
                this.id = cursor.getInt(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex(Common.System.NAME);
            if (columnIndex2 != -1) {
                this.name = cursor.getString(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex(BundleKey.TITLE);
            if (columnIndex3 != -1) {
                this.title = cursor.getString(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex(BreakpointSQLiteKey.URL);
            if (columnIndex4 != -1) {
                this.url = cursor.getString(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex("savePath");
            if (columnIndex5 != -1) {
                this.savePath = cursor.getString(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex("tempPath");
            if (columnIndex6 != -1) {
                this.tempPath = cursor.getString(columnIndex6);
            }
            int columnIndex7 = cursor.getColumnIndex("chunkCount");
            if (columnIndex7 != -1) {
                this.chunkCount = cursor.getInt(columnIndex7);
            }
            int columnIndex8 = cursor.getColumnIndex(NotificationCompat.CATEGORY_STATUS);
            if (columnIndex8 != -1) {
                this.status = new AtomicInteger(cursor.getInt(columnIndex8));
            } else {
                this.status = new AtomicInteger(0);
            }
            int columnIndex9 = cursor.getColumnIndex("curBytes");
            if (columnIndex9 != -1) {
                this.curBytes = new AtomicLong(cursor.getLong(columnIndex9));
            } else {
                this.curBytes = new AtomicLong(0L);
            }
            int columnIndex10 = cursor.getColumnIndex("totalBytes");
            if (columnIndex10 != -1) {
                this.totalBytes = cursor.getLong(columnIndex10);
            }
            int columnIndex11 = cursor.getColumnIndex("eTag");
            if (columnIndex11 != -1) {
                this.eTag = cursor.getString(columnIndex11);
            }
            int columnIndex12 = cursor.getColumnIndex("onlyWifi");
            if (columnIndex12 != -1) {
                if (cursor.getInt(columnIndex12) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.onlyWifi = z10;
            }
            int columnIndex13 = cursor.getColumnIndex("force");
            if (columnIndex13 != -1) {
                if (cursor.getInt(columnIndex13) != 0) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                this.force = z9;
            }
            int columnIndex14 = cursor.getColumnIndex("retryCount");
            if (columnIndex14 != -1) {
                this.retryCount = cursor.getInt(columnIndex14);
            }
            int columnIndex15 = cursor.getColumnIndex("extra");
            if (columnIndex15 != -1) {
                this.extra = cursor.getString(columnIndex15);
            }
            int columnIndex16 = cursor.getColumnIndex("mimeType");
            if (columnIndex16 != -1) {
                this.mimeType = cursor.getString(columnIndex16);
            }
            int columnIndex17 = cursor.getColumnIndex("notificationEnable");
            if (columnIndex17 != -1) {
                if (cursor.getInt(columnIndex17) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                this.showNotification = z8;
            }
            int columnIndex18 = cursor.getColumnIndex("notificationVisibility");
            if (columnIndex18 != -1) {
                this.notificationVisibility = cursor.getInt(columnIndex18);
            }
            int columnIndex19 = cursor.getColumnIndex("isFirstDownload");
            if (columnIndex19 != -1) {
                if (cursor.getInt(columnIndex19) == 1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                this.isFirstDownload = z7;
            }
            int columnIndex20 = cursor.getColumnIndex("isFirstSuccess");
            if (columnIndex20 != -1) {
                if (cursor.getInt(columnIndex20) == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                this.isFirstSuccess = z6;
            }
            int columnIndex21 = cursor.getColumnIndex("needHttpsToHttpRetry");
            if (columnIndex21 != -1) {
                if (cursor.getInt(columnIndex21) == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                this.needHttpsToHttpRetry = z5;
            }
            int columnIndex22 = cursor.getColumnIndex("downloadTime");
            if (columnIndex22 != -1) {
                this.downloadTime = cursor.getLong(columnIndex22);
            }
            int columnIndex23 = cursor.getColumnIndex(BillingClientConstants.PACKAGE_NAME);
            if (columnIndex23 != -1) {
                this.packageName = cursor.getString(columnIndex23);
            }
            int columnIndex24 = cursor.getColumnIndex("md5");
            if (columnIndex24 != -1) {
                this.md5 = cursor.getString(columnIndex24);
            }
            int columnIndex25 = cursor.getColumnIndex("retryDelay");
            if (columnIndex25 != -1) {
                if (cursor.getInt(columnIndex25) == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.needRetryDelay = z4;
            }
            int columnIndex26 = cursor.getColumnIndex("curRetryTime");
            if (columnIndex26 != -1) {
                this.curRetryTime = cursor.getInt(columnIndex26);
            }
            int columnIndex27 = cursor.getColumnIndex("retryDelayStatus");
            if (columnIndex27 != -1) {
                int i = cursor.getInt(columnIndex27);
                if (i == fw.DELAY_RETRY_WAITING.ordinal()) {
                    this.retryDelayStatus = fw.DELAY_RETRY_WAITING;
                } else if (i == fw.DELAY_RETRY_DOWNLOADING.ordinal()) {
                    this.retryDelayStatus = fw.DELAY_RETRY_DOWNLOADING;
                } else if (i == fw.DELAY_RETRY_DOWNLOADED.ordinal()) {
                    this.retryDelayStatus = fw.DELAY_RETRY_DOWNLOADED;
                } else {
                    this.retryDelayStatus = fw.DELAY_RETRY_NONE;
                }
            }
            int columnIndex28 = cursor.getColumnIndex("defaultHttpServiceBackUp");
            if (columnIndex28 != -1) {
                if (cursor.getInt(columnIndex28) == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.needDefaultHttpServiceBackUp = z3;
            }
            int columnIndex29 = cursor.getColumnIndex("chunkRunnableReuse");
            if (columnIndex29 != -1) {
                if (cursor.getInt(columnIndex29) == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.needReuseChunkRunnable = z2;
            }
            int columnIndex30 = cursor.getColumnIndex("retryDelayTimeArray");
            if (columnIndex30 != -1) {
                this.retryDelayTimeArray = cursor.getString(columnIndex30);
            }
            int columnIndex31 = cursor.getColumnIndex("chunkDowngradeRetry");
            if (columnIndex31 != -1) {
                if (cursor.getInt(columnIndex31) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                this.needChunkDowngradeRetry = z;
            }
            int columnIndex32 = cursor.getColumnIndex("backUpUrlsStr");
            if (columnIndex32 != -1) {
                setBackUpUrlsStr(cursor.getString(columnIndex32));
            }
            int columnIndex33 = cursor.getColumnIndex("backUpUrlRetryCount");
            if (columnIndex33 != -1) {
                this.backUpUrlRetryCount = cursor.getInt(columnIndex33);
            }
            int columnIndex34 = cursor.getColumnIndex("realDownloadTime");
            if (columnIndex34 != -1) {
                this.realDownloadTime = cursor.getLong(columnIndex34);
            }
            int columnIndex35 = cursor.getColumnIndex("retryScheduleMinutes");
            if (columnIndex35 != -1) {
                this.retryScheduleMinutes = cursor.getInt(columnIndex35);
            }
            int columnIndex36 = cursor.getColumnIndex("independentProcess");
            if (columnIndex36 != -1) {
                if (cursor.getInt(columnIndex36) != 1) {
                    z11 = false;
                }
                this.needIndependentProcess = z11;
            }
            int columnIndex37 = cursor.getColumnIndex("auxiliaryJsonobjectString");
            if (columnIndex37 != -1) {
                this.dbJsonDataString = cursor.getString(columnIndex37);
            }
            int columnIndex38 = cursor.getColumnIndex("iconUrl");
            if (columnIndex38 != -1) {
                this.iconUrl = cursor.getString(columnIndex38);
            }
            int columnIndex39 = cursor.getColumnIndex("appVersionCode");
            if (columnIndex39 != -1) {
                this.appVersionCode = cursor.getInt(columnIndex39);
            }
            int columnIndex40 = cursor.getColumnIndex("taskId");
            if (columnIndex40 != -1) {
                this.taskId = cursor.getString(columnIndex40);
            }
            parseMonitorSetting();
        } catch (Exception e) {
        }
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ar.d, Integer.valueOf(this.id));
        contentValues.put(BreakpointSQLiteKey.URL, this.url);
        contentValues.put("savePath", this.savePath);
        contentValues.put("tempPath", this.tempPath);
        contentValues.put(Common.System.NAME, this.name);
        contentValues.put("chunkCount", Integer.valueOf(this.chunkCount));
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(getStatus()));
        contentValues.put("curBytes", Long.valueOf(getCurBytes()));
        contentValues.put("totalBytes", Long.valueOf(this.totalBytes));
        contentValues.put("eTag", this.eTag);
        contentValues.put("onlyWifi", Integer.valueOf(this.onlyWifi ? 1 : 0));
        contentValues.put("force", Integer.valueOf(this.force ? 1 : 0));
        contentValues.put("retryCount", Integer.valueOf(this.retryCount));
        contentValues.put("extra", this.extra);
        contentValues.put("mimeType", this.mimeType);
        contentValues.put(BundleKey.TITLE, this.title);
        contentValues.put("notificationEnable", Integer.valueOf(this.showNotification ? 1 : 0));
        contentValues.put("notificationVisibility", Integer.valueOf(this.notificationVisibility));
        contentValues.put("isFirstDownload", Integer.valueOf(this.isFirstDownload ? 1 : 0));
        contentValues.put("isFirstSuccess", Integer.valueOf(this.isFirstSuccess ? 1 : 0));
        contentValues.put("needHttpsToHttpRetry", Integer.valueOf(this.needHttpsToHttpRetry ? 1 : 0));
        contentValues.put("downloadTime", Long.valueOf(this.downloadTime));
        contentValues.put(BillingClientConstants.PACKAGE_NAME, this.packageName);
        contentValues.put("md5", this.md5);
        contentValues.put("retryDelay", Integer.valueOf(this.needRetryDelay ? 1 : 0));
        contentValues.put("curRetryTime", Integer.valueOf(this.curRetryTime));
        contentValues.put("retryDelayStatus", Integer.valueOf(this.retryDelayStatus.ordinal()));
        contentValues.put("defaultHttpServiceBackUp", Integer.valueOf(this.needDefaultHttpServiceBackUp ? 1 : 0));
        contentValues.put("chunkRunnableReuse", Integer.valueOf(this.needReuseChunkRunnable ? 1 : 0));
        contentValues.put("retryDelayTimeArray", this.retryDelayTimeArray);
        contentValues.put("chunkDowngradeRetry", Integer.valueOf(this.needChunkDowngradeRetry ? 1 : 0));
        contentValues.put("backUpUrlsStr", getBackUpUrlsStr());
        contentValues.put("backUpUrlRetryCount", Integer.valueOf(this.backUpUrlRetryCount));
        contentValues.put("realDownloadTime", Long.valueOf(this.realDownloadTime));
        contentValues.put("retryScheduleMinutes", Integer.valueOf(this.retryScheduleMinutes));
        contentValues.put("independentProcess", Integer.valueOf(this.needIndependentProcess ? 1 : 0));
        contentValues.put("auxiliaryJsonobjectString", getDBJsonDataString());
        contentValues.put("iconUrl", this.iconUrl);
        contentValues.put("appVersionCode", Integer.valueOf(this.appVersionCode));
        contentValues.put("taskId", this.taskId);
        return contentValues;
    }

    private String getDBJsonDataString() {
        String string;
        String str = this.dbJsonDataString;
        if (str != null) {
            return str;
        }
        ensureDBJsonData();
        synchronized (this.dbJsonData) {
            string = this.dbJsonData.toString();
            this.dbJsonDataString = string;
        }
        return string;
    }

    public void bindValue(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.bindValueCount = 0;
        sQLiteStatement.clearBindings();
        int i = this.bindValueCount + 1;
        this.bindValueCount = i;
        sQLiteStatement.bindLong(i, this.id);
        int i2 = this.bindValueCount + 1;
        this.bindValueCount = i2;
        String str = this.url;
        if (str == null) {
            str = "";
        }
        sQLiteStatement.bindString(i2, str);
        int i3 = this.bindValueCount + 1;
        this.bindValueCount = i3;
        String str2 = this.savePath;
        if (str2 == null) {
            str2 = "";
        }
        sQLiteStatement.bindString(i3, str2);
        int i4 = this.bindValueCount + 1;
        this.bindValueCount = i4;
        String str3 = this.tempPath;
        if (str3 == null) {
            str3 = "";
        }
        sQLiteStatement.bindString(i4, str3);
        int i5 = this.bindValueCount + 1;
        this.bindValueCount = i5;
        String str4 = this.name;
        if (str4 == null) {
            str4 = "";
        }
        sQLiteStatement.bindString(i5, str4);
        int i6 = this.bindValueCount + 1;
        this.bindValueCount = i6;
        sQLiteStatement.bindLong(i6, this.chunkCount);
        int i7 = this.bindValueCount + 1;
        this.bindValueCount = i7;
        sQLiteStatement.bindLong(i7, getStatus());
        int i8 = this.bindValueCount + 1;
        this.bindValueCount = i8;
        sQLiteStatement.bindLong(i8, getCurBytes());
        int i9 = this.bindValueCount + 1;
        this.bindValueCount = i9;
        sQLiteStatement.bindLong(i9, this.totalBytes);
        int i10 = this.bindValueCount + 1;
        this.bindValueCount = i10;
        String str5 = this.eTag;
        if (str5 == null) {
            str5 = "";
        }
        sQLiteStatement.bindString(i10, str5);
        int i11 = this.bindValueCount + 1;
        this.bindValueCount = i11;
        sQLiteStatement.bindLong(i11, this.onlyWifi ? 1L : 0L);
        int i12 = this.bindValueCount + 1;
        this.bindValueCount = i12;
        sQLiteStatement.bindLong(i12, this.force ? 1L : 0L);
        int i13 = this.bindValueCount + 1;
        this.bindValueCount = i13;
        sQLiteStatement.bindLong(i13, this.retryCount);
        int i14 = this.bindValueCount + 1;
        this.bindValueCount = i14;
        String str6 = this.extra;
        if (str6 == null) {
            str6 = "";
        }
        sQLiteStatement.bindString(i14, str6);
        int i15 = this.bindValueCount + 1;
        this.bindValueCount = i15;
        String str7 = this.mimeType;
        if (str7 == null) {
            str7 = "";
        }
        sQLiteStatement.bindString(i15, str7);
        int i16 = this.bindValueCount + 1;
        this.bindValueCount = i16;
        String str8 = this.title;
        if (str8 == null) {
            str8 = "";
        }
        sQLiteStatement.bindString(i16, str8);
        int i17 = this.bindValueCount + 1;
        this.bindValueCount = i17;
        sQLiteStatement.bindLong(i17, this.showNotification ? 1L : 0L);
        int i18 = this.bindValueCount + 1;
        this.bindValueCount = i18;
        sQLiteStatement.bindLong(i18, this.notificationVisibility);
        int i19 = this.bindValueCount + 1;
        this.bindValueCount = i19;
        sQLiteStatement.bindLong(i19, this.isFirstDownload ? 1L : 0L);
        int i20 = this.bindValueCount + 1;
        this.bindValueCount = i20;
        sQLiteStatement.bindLong(i20, this.isFirstSuccess ? 1L : 0L);
        int i21 = this.bindValueCount + 1;
        this.bindValueCount = i21;
        sQLiteStatement.bindLong(i21, this.needHttpsToHttpRetry ? 1L : 0L);
        int i22 = this.bindValueCount + 1;
        this.bindValueCount = i22;
        sQLiteStatement.bindLong(i22, this.downloadTime);
        int i23 = this.bindValueCount + 1;
        this.bindValueCount = i23;
        String str9 = this.packageName;
        if (str9 == null) {
            str9 = "";
        }
        sQLiteStatement.bindString(i23, str9);
        int i24 = this.bindValueCount + 1;
        this.bindValueCount = i24;
        String str10 = this.md5;
        if (str10 == null) {
            str10 = "";
        }
        sQLiteStatement.bindString(i24, str10);
        int i25 = this.bindValueCount + 1;
        this.bindValueCount = i25;
        sQLiteStatement.bindLong(i25, this.needRetryDelay ? 1L : 0L);
        int i26 = this.bindValueCount + 1;
        this.bindValueCount = i26;
        sQLiteStatement.bindLong(i26, this.curRetryTime);
        int i27 = this.bindValueCount + 1;
        this.bindValueCount = i27;
        sQLiteStatement.bindLong(i27, this.retryDelayStatus.ordinal());
        int i28 = this.bindValueCount + 1;
        this.bindValueCount = i28;
        sQLiteStatement.bindLong(i28, this.needDefaultHttpServiceBackUp ? 1L : 0L);
        int i29 = this.bindValueCount + 1;
        this.bindValueCount = i29;
        sQLiteStatement.bindLong(i29, this.needReuseChunkRunnable ? 1L : 0L);
        int i30 = this.bindValueCount + 1;
        this.bindValueCount = i30;
        String str11 = this.retryDelayTimeArray;
        if (str11 == null) {
            str11 = "";
        }
        sQLiteStatement.bindString(i30, str11);
        int i31 = this.bindValueCount + 1;
        this.bindValueCount = i31;
        sQLiteStatement.bindLong(i31, this.needChunkDowngradeRetry ? 1L : 0L);
        int i32 = this.bindValueCount + 1;
        this.bindValueCount = i32;
        sQLiteStatement.bindString(i32, getBackUpUrlsStr());
        int i33 = this.bindValueCount + 1;
        this.bindValueCount = i33;
        sQLiteStatement.bindLong(i33, this.backUpUrlRetryCount);
        int i34 = this.bindValueCount + 1;
        this.bindValueCount = i34;
        sQLiteStatement.bindLong(i34, this.realDownloadTime);
        int i35 = this.bindValueCount + 1;
        this.bindValueCount = i35;
        sQLiteStatement.bindLong(i35, this.retryScheduleMinutes);
        int i36 = this.bindValueCount + 1;
        this.bindValueCount = i36;
        sQLiteStatement.bindLong(i36, this.needIndependentProcess ? 1L : 0L);
        int i37 = this.bindValueCount + 1;
        this.bindValueCount = i37;
        sQLiteStatement.bindString(i37, getDBJsonDataString());
        int i38 = this.bindValueCount + 1;
        this.bindValueCount = i38;
        String str12 = this.iconUrl;
        if (str12 == null) {
            str12 = "";
        }
        sQLiteStatement.bindString(i38, str12);
        int i39 = this.bindValueCount + 1;
        this.bindValueCount = i39;
        sQLiteStatement.bindLong(i39, this.appVersionCode);
        int i40 = this.bindValueCount + 1;
        this.bindValueCount = i40;
        String str13 = this.taskId;
        sQLiteStatement.bindString(i40, str13 != null ? str13 : "");
    }

    public int getBindValueCount() {
        return this.bindValueCount;
    }

    public int getId() {
        if (this.id == 0) {
            this.id = com.byazt.lj.hn.pr(this);
        }
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getTitle() {
        if (TextUtils.isEmpty(this.title)) {
            return this.name;
        }
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public String getTempPath() {
        return uc.hw(this.savePath, this.tempPath);
    }

    public String getTempName() {
        return uc.hn(this.name);
    }

    public String getTargetFilePath() {
        return uc.pr(this.savePath, this.name);
    }

    public String getTempFilePath() {
        return uc.pr(this.savePath, this.tempPath, this.name);
    }

    public boolean isNeedDefaultHttpServiceBackUp() {
        return this.needDefaultHttpServiceBackUp;
    }

    public boolean isNeedReuseChunkRunnable() {
        return this.needReuseChunkRunnable;
    }

    public int getStatus() {
        AtomicInteger atomicInteger = this.status;
        if (atomicInteger != null) {
            int i = atomicInteger.get();
            if (i == -5) {
                return -2;
            }
            return i;
        }
        return 0;
    }

    public EnqueueType getEnqueueType() {
        return this.enqueueType;
    }

    public int getCurBackUpUrlIndex() {
        return this.curBackUpUrlIndex;
    }

    public boolean isHttpsToHttpRetryUsed() {
        return this.httpsToHttpRetryUsed;
    }

    public boolean isAutoResumed() {
        return this.autoResumed;
    }

    public void setAutoResumed(boolean z) {
        this.autoResumed = z;
    }

    public boolean isShowNotificationForAutoResumed() {
        return this.showNotificationForAutoResumed;
    }

    public void setShowNotificationForAutoResumed(boolean z) {
        this.showNotificationForAutoResumed = z;
    }

    public boolean isShowNotificationForNetworkResumed() {
        return this.showNotificationForNetworkResumed;
    }

    public void setShowNotificationForNetworkResumed(boolean z) {
        this.showNotificationForNetworkResumed = z;
    }

    public int getRealStatus() {
        AtomicInteger atomicInteger = this.status;
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        return 0;
    }

    public boolean isOnlyWifi() {
        return this.onlyWifi;
    }

    public void setOnlyWifi(boolean z) {
        this.onlyWifi = z;
    }

    public long getFirstSpeedTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("dbjson_key_first_speed_time");
    }

    public void setFirstSpeedTime(long j) {
        safePutToDBJsonData("dbjson_key_first_speed_time", Long.valueOf(j));
    }

    public String getTaskKey() {
        ensureDBJsonData();
        return this.dbJsonData.optString("task_key");
    }

    public int getTTMd5CheckStatus() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("ttmd5_check_status", -1);
    }

    public void setTTMd5CheckStatus(int i) {
        safePutToDBJsonData("ttmd5_check_status", Integer.valueOf(i));
    }

    public long getAllConnectTime() {
        ensureDBJsonData();
        if (this.allConnectTime == null) {
            this.allConnectTime = new AtomicLong(this.dbJsonData.optLong("dbjson_key_all_connect_time"));
        }
        return this.allConnectTime.get();
    }

    public void increaseAllConnectTime(long j) {
        if (j > 0) {
            getAllConnectTime();
            safePutToDBJsonData("dbjson_key_all_connect_time", Long.valueOf(this.allConnectTime.addAndGet(j)));
        }
    }

    public long getDownloadPrepareTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("dbjson_key_download_prepare_time");
    }

    public void increaseDownloadPrepareTime(long j) {
        if (j > 0) {
            safePutToDBJsonData("dbjson_key_download_prepare_time", Long.valueOf(getDownloadPrepareTime() + j));
        }
    }

    public String getExtra() {
        return this.extra;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getFilePackageName() {
        return this.filePackageName;
    }

    public void setFilePackageName(String str) {
        this.filePackageName = str;
    }

    public String getMd5() {
        return this.md5;
    }

    public long getExpectFileLength() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("dbjson_key_expect_file_length");
    }

    public List<hn> getExtraHeaders() {
        return this.extraHeaders;
    }

    public int getMaxBytes() {
        return this.maxBytes;
    }

    public String[] getOutIp() {
        return this.outIp;
    }

    public int[] getOutSize() {
        return this.outSize;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public int getBackUpUrlRetryCount() {
        return this.backUpUrlRetryCount;
    }

    public int getTotalRetryCount() {
        int i = this.retryCount;
        List<String> list = this.backUpUrls;
        if (list != null && !list.isEmpty()) {
            return i + (this.backUpUrlRetryCount * this.backUpUrls.size());
        }
        return i;
    }

    public int getCurRetryTimeInTotal() {
        int i = this.curRetryTime;
        if (this.backUpUrlUsed) {
            int i2 = i + this.retryCount;
            int i3 = this.curBackUpUrlIndex;
            if (i3 > 0) {
                return i2 + (i3 * this.backUpUrlRetryCount);
            }
            return i2;
        }
        return i;
    }

    public List<String> getForbiddenBackupUrls() {
        return this.forbiddenBackupUrls;
    }

    public void setForbiddenBackupUrls(List<String> list, boolean z) {
        this.forbiddenBackupUrls = list;
        refreshBackupUrls(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    private void refreshBackupUrls(boolean z) {
        List<String> list = this.forbiddenBackupUrls;
        if (list != null && list.size() > z) {
            List<String> list2 = this.backUpUrls;
            if (list2 == null) {
                this.backUpUrls = new ArrayList();
            } else {
                list2.clear();
            }
            this.backUpUrlUsed = false;
            this.curBackUpUrlIndex = 0;
            for (?? r3 = z; r3 < this.forbiddenBackupUrls.size(); r3++) {
                this.backUpUrls.add(this.forbiddenBackupUrls.get(r3));
            }
        }
    }

    public String getConnectionUrl() {
        List<String> list;
        int i;
        List<String> list2;
        String str = this.url;
        if (getStatus() == 8 && (list2 = this.forbiddenBackupUrls) != null && !list2.isEmpty() && !this.backUpUrlUsed) {
            return this.forbiddenBackupUrls.get(0);
        }
        if (this.backUpUrlUsed && (list = this.backUpUrls) != null && list.size() > 0 && (i = this.curBackUpUrlIndex) >= 0 && i < this.backUpUrls.size()) {
            String str2 = this.backUpUrls.get(this.curBackUpUrlIndex);
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            return str;
        }
        if (!TextUtils.isEmpty(this.url) && this.url.startsWith(BaseConstants.SCHEME_HTTPS) && this.needHttpsToHttpRetry && this.httpsToHttpRetryUsed) {
            return this.url.replaceFirst(BaseConstants.SCHEME_HTTPS, "http");
        }
        return str;
    }

    public boolean isBackUpUrlUsed() {
        return this.backUpUrlUsed;
    }

    public String getBackUpUrl() {
        List<String> list;
        int i;
        if (this.backUpUrlUsed && (list = this.backUpUrls) != null && list.size() > 0 && (i = this.curBackUpUrlIndex) >= 0 && i < this.backUpUrls.size()) {
            String str = this.backUpUrls.get(this.curBackUpUrlIndex);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    public void updateStartDownloadTime() {
        this.startDownloadTime = SystemClock.uptimeMillis();
        safePutToDBJsonData("dbjson_last_start_download_time", Long.valueOf(System.currentTimeMillis()));
    }

    public void safePutToDBJsonData(String str, Object obj) {
        ensureDBJsonData();
        synchronized (this.dbJsonData) {
            try {
                this.dbJsonData.put(str, obj);
            } catch (Exception e) {
            }
            this.dbJsonDataString = null;
        }
    }

    public String getDownloadSettingString() {
        ensureDBJsonData();
        return this.dbJsonData.optString("download_setting");
    }

    public int getRetryScheduleCount() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("retry_schedule_count", 0);
    }

    public void setRetryScheduleCount(int i) {
        safePutToDBJsonData("retry_schedule_count", Integer.valueOf(i));
    }

    public boolean isDownloadFromReserveWifi() {
        return this.mDownloadFromReserveWifi;
    }

    public void setDownloadFromReserveWifi(boolean z) {
        this.mDownloadFromReserveWifi = z;
    }

    public int getLinkMode() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("link_mode");
    }

    public void setLinkMode(int i) {
        safePutToDBJsonData("link_mode", Integer.valueOf(i));
    }

    public boolean isPauseReserveOnWifi() {
        return (getReserveWifiStatus() & 2) > 0;
    }

    public boolean hasPauseReservedOnWifi() {
        return (getReserveWifiStatus() & 1) > 0;
    }

    public boolean statusInPause() {
        return getRealStatus() == -2 || getRealStatus() == -5;
    }

    private int getReserveWifiStatus() {
        ensureSpData();
        try {
            return this.spData.optInt("pause_reserve_on_wifi", 0);
        } catch (Exception e) {
            return 0;
        }
    }

    public void startPauseReserveOnWifi() {
        ensureSpData();
        try {
            this.spData.put("pause_reserve_on_wifi", 3);
            updateSpData();
        } catch (Exception e) {
        }
    }

    public void stopPauseReserveOnWifi() {
        ensureSpData();
        try {
            this.spData.put("pause_reserve_on_wifi", 1);
            updateSpData();
        } catch (Exception e) {
        }
    }

    public void setCacheExpiredTime(long j) {
        ensureSpData();
        try {
            this.spData.put("cache-control/expired_time", j);
            updateSpData();
        } catch (Exception e) {
        }
    }

    public long getCacheExpiredTime() {
        ensureSpData();
        try {
            return this.spData.optLong("cache-control/expired_time", -1L);
        } catch (Exception e) {
            return -1L;
        }
    }

    public void setCacheControl(String str) {
        ensureSpData();
        try {
            this.spData.put("cache-control", str);
            updateSpData();
        } catch (Exception e) {
        }
    }

    public String getCacheControl() {
        ensureSpData();
        try {
            return this.spData.optString("cache-control", null);
        } catch (Exception e) {
            return null;
        }
    }

    public void setLastModified(String str) {
        ensureSpData();
        try {
            this.spData.put("last-modified", str);
            updateSpData();
        } catch (Exception e) {
        }
    }

    public String getLastModified() {
        ensureSpData();
        try {
            return this.spData.optString("last-modified", null);
        } catch (Exception e) {
            return null;
        }
    }

    public void setIsRwConcurrent(boolean z) {
        safePutToDBJsonData("rw_concurrent", Integer.valueOf(z ? 1 : 0));
    }

    public boolean isRwConcurrent() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("rw_concurrent", 0) == 1;
    }

    public boolean isNeedSDKMonitor() {
        return this.needSDKMonitor;
    }

    public String getMonitorScene() {
        return this.monitorScene;
    }

    public int[] getExtraMonitorStatus() {
        return this.extraMonitorStatus;
    }

    public void updateDownloadTime() {
        if (this.startDownloadTime == 0) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() - this.startDownloadTime;
        if (this.downloadTime < 0) {
            this.downloadTime = 0L;
        }
        if (jUptimeMillis > 0) {
            this.downloadTime = jUptimeMillis;
        }
    }

    public void updateRealStartDownloadTime() {
        if (this.realStartDownloadTime == 0) {
            this.realStartDownloadTime = System.nanoTime();
        }
    }

    public void resetRealStartDownloadTime() {
        this.realStartDownloadTime = 0L;
    }

    public void updateRealDownloadTime(boolean z) {
        long jNanoTime = System.nanoTime();
        long j = this.realStartDownloadTime;
        if (j <= 0) {
            if (z) {
                this.realStartDownloadTime = jNanoTime;
                return;
            }
            return;
        }
        long j2 = jNanoTime - j;
        if (z) {
            this.realStartDownloadTime = jNanoTime;
        } else {
            this.realStartDownloadTime = 0L;
        }
        if (j2 > 0) {
            this.realDownloadTime += j2;
        }
    }

    public void setDownloadTime(long j) {
        if (j >= 0) {
            this.downloadTime = j;
        }
    }

    public boolean isNeedReuseFirstConnection() {
        return this.needReuseFirstConnection;
    }

    public boolean isNeedIndependentProcess() {
        return this.needIndependentProcess;
    }

    public boolean isDeleteCacheIfCheckFailed() {
        return this.deleteCacheIfCheckFailed;
    }

    public void setDeleteCacheIfCheckFailed() {
        this.deleteCacheIfCheckFailed = true;
    }

    public boolean isHeadConnectionAvailable() {
        return this.headConnectionAvailable;
    }

    public boolean isIgnoreDataVerify() {
        return this.ignoreDataVerify;
    }

    public boolean isAddListenerToSameTask() {
        return this.addListenerToSameTask;
    }

    public boolean isForce() {
        return this.force;
    }

    public boolean isExpiredRedownload() {
        if (com.byazt.ew.pr.hn().pr("force_close_download_cache_check", 0) == 1) {
            com.byazt.p000do.pr.hn("isExpiredRedownload force to false, reason(global setting) id=" + getId() + " name=" + getName());
            return false;
        }
        return this.expiredRedownload;
    }

    public boolean isSuccessByCache() {
        return this.successByCache;
    }

    public void setSuccessByCache(boolean z) {
        this.successByCache = z;
    }

    public long getCurBytes() {
        AtomicLong atomicLong = this.curBytes;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public void setCurBytes(long j) {
        AtomicLong atomicLong = this.curBytes;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.curBytes = new AtomicLong(j);
        }
    }

    public void setCurBytes(long j, boolean z) {
        if (z) {
            setCurBytes(j);
        } else if (j > getCurBytes()) {
            setCurBytes(j);
        }
    }

    public com.byazt.mrs.hw getByteInvalidRetryStatus() {
        return this.byteInvalidRetryStatus;
    }

    public void setByteInvalidRetryStatus(com.byazt.mrs.hw hwVar) {
        this.byteInvalidRetryStatus = hwVar;
    }

    public void setFirstDownload(boolean z) {
        this.isFirstDownload = z;
    }

    public void setFirstSuccess(boolean z) {
        this.isFirstSuccess = z;
    }

    public void increaseCurBytes(long j) {
        this.curBytes.addAndGet(j);
    }

    public void seteTag(String str) {
        this.eTag = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setTotalBytes(long j) {
        this.totalBytes = j;
    }

    public void setStatus(int i) {
        AtomicInteger atomicInteger = this.status;
        if (atomicInteger != null) {
            atomicInteger.set(i);
        } else {
            this.status = new AtomicInteger(i);
        }
    }

    public void setSupportPartial(boolean z) {
        this.supportPartial = z;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public String geteTag() {
        return this.eTag;
    }

    public String getNetworkQuality() {
        return this.networkQuality;
    }

    public void setNetworkQuality(String str) {
        this.networkQuality = str;
    }

    public void setChunkCount(int i) {
        this.chunkCount = i;
    }

    public int getNotificationVisibility() {
        return this.notificationVisibility;
    }

    public void setNotificationVisibility(int i) {
        this.notificationVisibility = i;
    }

    public boolean isForceIgnoreRecommendSize() {
        return this.forceIgnoreRecommendSize;
    }

    public void setForceIgnoreRecommendSize(boolean z) {
        this.forceIgnoreRecommendSize = z;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public void setHttpStatusCode(int i) {
        this.httpStatusCode = i;
    }

    public String getHttpStatusMessage() {
        return this.httpStatusMessage;
    }

    public void setHttpStatusMessage(String str) {
        this.httpStatusMessage = str;
    }

    public boolean canShowNotification() {
        boolean z = this.autoResumed;
        if (!z && this.showNotification) {
            return true;
        }
        if (z) {
            return this.showNotificationForAutoResumed || this.showNotificationForNetworkResumed;
        }
        return false;
    }

    public void setShowNotification(boolean z) {
        this.showNotification = z;
    }

    public boolean isShowNotification() {
        return this.showNotification;
    }

    public boolean isAutoInstallWithoutNotification() {
        if (this.isAutoInstallWithoutNotification == null) {
            if (!TextUtils.isEmpty(this.extra)) {
                try {
                    this.isAutoInstallWithoutNotification = Boolean.valueOf(new JSONObject(this.extra).optBoolean("auto_install_without_notification", false));
                } catch (JSONException e) {
                    this.isAutoInstallWithoutNotification = Boolean.FALSE;
                }
            } else {
                this.isAutoInstallWithoutNotification = Boolean.FALSE;
            }
        }
        return this.isAutoInstallWithoutNotification.booleanValue();
    }

    public boolean isAutoInstall() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("auto_install", 1) == 1;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public boolean isNeedHttpsToHttpRetry() {
        return this.needHttpsToHttpRetry;
    }

    public boolean isNeedRetryDelay() {
        return false;
    }

    public String getRetryDelayTimeArray() {
        return this.retryDelayTimeArray;
    }

    public int getCurRetryTime() {
        return this.curRetryTime;
    }

    public boolean isForbiddenRetryed() {
        return this.isForbiddenRetryed;
    }

    public void setForbiddenRetryed() {
        this.isForbiddenRetryed = true;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setAppVersionCode(int i) {
        this.appVersionCode = i;
    }

    public int getAppVersionCode() {
        return this.appVersionCode;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void generateTaskId() {
        this.taskId = UUID.randomUUID().toString();
    }

    public boolean isNeedChunkDowngradeRetry() {
        return this.needChunkDowngradeRetry;
    }

    public boolean isChunkDowngradeRetryUsed() {
        return this.chunkDowngradeRetryUsed;
    }

    public fw getRetryDelayStatus() {
        return this.retryDelayStatus;
    }

    public com.byazt.mrs.pr getAsyncHandleStatus() {
        return this.asyncHandleStatus;
    }

    public boolean canSkipStatusHandler() {
        int status = getStatus();
        return status == 7 || this.retryDelayStatus == fw.DELAY_RETRY_WAITING || status == 8 || this.asyncHandleStatus == com.byazt.mrs.pr.ASYNC_HANDLE_WAITING || this.asyncHandleStatus == com.byazt.mrs.pr.ASYNC_HANDLE_RESTART || this.byteInvalidRetryStatus == com.byazt.mrs.hw.BYTE_INVALID_RETRY_STATUS_RESTART;
    }

    public void changeSkipStatus() {
        int status = getStatus();
        if (status == 7 || this.retryDelayStatus == fw.DELAY_RETRY_WAITING) {
            setRetryDelayStatus(fw.DELAY_RETRY_DOWNLOADING);
        }
        if (status == 8 || this.asyncHandleStatus == com.byazt.mrs.pr.ASYNC_HANDLE_WAITING || this.asyncHandleStatus == com.byazt.mrs.pr.ASYNC_HANDLE_RESTART) {
            setAsyncHandleStatus(com.byazt.mrs.pr.ASYNC_HANDLE_DOWNLOADING);
        }
        if (this.byteInvalidRetryStatus == com.byazt.mrs.hw.BYTE_INVALID_RETRY_STATUS_RESTART) {
            setByteInvalidRetryStatus(com.byazt.mrs.hw.BYTE_INVALID_RETRY_STATUS_DOWNLOADING);
        }
    }

    public boolean canStartRetryDelayTask() {
        return isNeedRetryDelay() && getStatus() != -3 && this.retryDelayStatus == fw.DELAY_RETRY_WAITING;
    }

    public void setRetryDelayStatus(fw fwVar) {
        this.retryDelayStatus = fwVar;
    }

    public boolean canReStartAsyncTask() {
        return getStatus() != -3 && this.asyncHandleStatus == com.byazt.mrs.pr.ASYNC_HANDLE_WAITING;
    }

    public void setAsyncHandleStatus(com.byazt.mrs.pr prVar) {
        this.asyncHandleStatus = prVar;
    }

    public void updateCurRetryTime(int i) {
        int i2 = (this.backUpUrlUsed ? this.backUpUrlRetryCount : this.retryCount) - i;
        this.curRetryTime = i2;
        if (i2 < 0) {
            this.curRetryTime = 0;
        }
    }

    public long getDownloadTime() {
        return this.downloadTime;
    }

    public long getRealDownloadTime() {
        return TimeUnit.NANOSECONDS.toMillis(this.realDownloadTime);
    }

    public void copyFromCacheData(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        setChunkCount(downloadInfo.getChunkCount());
        setTotalBytes(downloadInfo.getTotalBytes());
        setCurBytes(downloadInfo.getCurBytes(), true);
        this.realDownloadTime = downloadInfo.realDownloadTime;
        if (!downloadInfo.canSkipStatusHandler() && !canSkipStatusHandler()) {
            this.curRetryTime = 0;
            this.isForbiddenRetryed = false;
            this.backUpUrlUsed = false;
            this.curBackUpUrlIndex = 0;
            this.httpsToHttpRetryUsed = false;
        } else {
            this.curRetryTime = downloadInfo.getCurRetryTime();
        }
        seteTag(downloadInfo.geteTag());
        if (z) {
            setStatus(downloadInfo.getStatus());
        }
        this.isFirstDownload = downloadInfo.getIsFirstDownload();
        this.isFirstSuccess = downloadInfo.isFirstSuccess();
        this.retryDelayStatus = downloadInfo.getRetryDelayStatus();
        mergeAuxiliaryJSONObject(downloadInfo.dbJsonData);
    }

    public void copyTaskIdFromCacheData(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.taskId = downloadInfo.getTaskId();
    }

    private void ensureDBJsonData() {
        if (this.dbJsonData == null) {
            synchronized (this) {
                if (this.dbJsonData == null) {
                    try {
                        if (!TextUtils.isEmpty(this.dbJsonDataString)) {
                            this.dbJsonData = new JSONObject(this.dbJsonDataString);
                            this.dbJsonDataString = null;
                        } else {
                            this.dbJsonData = new JSONObject();
                        }
                    } catch (Throwable th) {
                        this.dbJsonData = new JSONObject();
                    }
                }
            }
        }
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    private void mergeAuxiliaryJSONObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        ensureDBJsonData();
        synchronized (this.dbJsonData) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object objOpt = jSONObject.opt(next);
                    if (!this.dbJsonData.has(next) && objOpt != null) {
                        this.dbJsonData.put(next, objOpt);
                    }
                }
            } catch (Exception e) {
            }
            this.dbJsonDataString = null;
        }
        parseMonitorSetting();
    }

    public boolean getIsFirstDownload() {
        return this.isFirstDownload;
    }

    public boolean isFirstSuccess() {
        return this.isFirstSuccess;
    }

    public boolean equalsTask(DownloadInfo downloadInfo) {
        String str;
        String str2;
        return (downloadInfo == null || (str = this.url) == null || !str.equals(downloadInfo.getUrl()) || (str2 = this.savePath) == null || !str2.equals(downloadInfo.getSavePath())) ? false : true;
    }

    public void setId(int i) {
        this.id = i;
    }

    public boolean isDownloadWithWifiValid() {
        return !isOnlyWifi() || uc.hw(com.byazt.lj.hn.of());
    }

    public boolean isPauseReserveWithWifiValid() {
        if (this.mDownloadFromReserveWifi) {
            return isPauseReserveOnWifi() && uc.hw(com.byazt.lj.hn.of());
        }
        return true;
    }

    public boolean isDownloadingStatus() {
        return DownloadStatus.isDownloading(getStatus());
    }

    public boolean isDownloadOverStatus() {
        return DownloadStatus.isDownloadOver(getStatus());
    }

    public List<String> getBackUpUrls() {
        return this.backUpUrls;
    }

    public boolean isChunked() {
        return uc.hw(this.totalBytes);
    }

    public boolean isNeedPostProgress() {
        return this.needPostProgress;
    }

    public int getMaxProgressCount() {
        return this.maxProgressCount;
    }

    public long getMinByteIntervalForPostToMainThread(long j) {
        int i = this.maxProgressCount;
        if (i <= 0) {
            i = 100;
        }
        long j2 = j / ((long) (i + 1));
        if (j2 <= 0) {
            return 1048576L;
        }
        return j2;
    }

    public int getMinProgressTimeMsInterval() {
        int i = this.minProgressTimeMsInterval;
        if (i < 1000) {
            return 1000;
        }
        return i;
    }

    public boolean isEntityInvalid() {
        return TextUtils.isEmpty(this.url) || TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.savePath);
    }

    public boolean isDownloaded() {
        return uc.hn(this);
    }

    public boolean trySwitchToNextBackupUrl() {
        if (this.backUpUrlUsed) {
            this.curBackUpUrlIndex++;
        }
        List<String> list = this.backUpUrls;
        if (list == null || list.size() == 0 || this.curBackUpUrlIndex < 0) {
            return false;
        }
        while (this.curBackUpUrlIndex < this.backUpUrls.size()) {
            if (!TextUtils.isEmpty(this.backUpUrls.get(this.curBackUpUrlIndex))) {
                this.backUpUrlUsed = true;
                return true;
            }
            this.curBackUpUrlIndex++;
        }
        return false;
    }

    public boolean hasNextBackupUrl() {
        int i;
        List<String> list = this.backUpUrls;
        if (list == null || list.size() <= 0) {
            return false;
        }
        return !this.backUpUrlUsed || ((i = this.curBackUpUrlIndex) >= 0 && i < this.backUpUrls.size() - 1);
    }

    public boolean canReplaceHttpForRetry() {
        return !TextUtils.isEmpty(this.url) && this.url.startsWith(BaseConstants.SCHEME_HTTPS) && this.needHttpsToHttpRetry && !this.httpsToHttpRetryUsed;
    }

    public void setHttpsToHttpRetryUsed(boolean z) {
        this.httpsToHttpRetryUsed = z;
    }

    public void setSavePath(String str) {
        this.savePath = str;
    }

    public synchronized void registerTempFileSaveCallback(e eVar) {
        if (eVar == null) {
            return;
        }
        try {
            com.byazt.p000do.pr.hw(TAG, "registerTempFileSaveCallback");
            if (this.tempFileSaveCompleteCallbacks == null) {
                this.tempFileSaveCompleteCallbacks = new ArrayList();
            }
            if (!this.tempFileSaveCompleteCallbacks.contains(eVar)) {
                this.tempFileSaveCompleteCallbacks.add(eVar);
            }
        } catch (Throwable th) {
            eVar.pr(new BaseException(1038, uc.hw(th, "registerTempFileSaveCallback")));
        }
    }

    public void resetDataForEtagEndure(String str) {
        setCurBytes(0L, true);
        setTotalBytes(0L);
        seteTag(str);
        setChunkCount(1);
        this.downloadTime = 0L;
        this.realStartDownloadTime = 0L;
        this.realDownloadTime = 0L;
    }

    public void reset() {
        setCurBytes(0L, true);
        this.totalBytes = 0L;
        this.chunkCount = 1;
        this.downloadTime = 0L;
        this.realStartDownloadTime = 0L;
        this.realDownloadTime = 0L;
    }

    public void erase() {
        setCurBytes(0L, true);
        this.totalBytes = 0L;
        this.chunkCount = 1;
        this.downloadTime = 0L;
        this.realStartDownloadTime = 0L;
        this.realDownloadTime = 0L;
        this.curRetryTime = 0;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.backUpUrlUsed = false;
        this.httpsToHttpRetryUsed = false;
        this.eTag = null;
        this.failedException = null;
        this.tempCacheData = null;
        this.packageInfoRef = null;
    }

    public boolean isFileDataValid() {
        if (isEntityInvalid()) {
            return false;
        }
        File file = new File(getTempPath(), getTempName());
        boolean zExists = file.exists();
        boolean zIsDirectory = file.isDirectory();
        if (!zExists || zIsDirectory) {
            return false;
        }
        long length = file.length();
        long curBytes = getCurBytes();
        if (com.byazt.ew.pr.hn().pr("fix_file_data_valid")) {
            if (curBytes > 0) {
                long j = this.totalBytes;
                if (j > 0 && this.chunkCount > 0 && length >= curBytes && length <= j) {
                    return true;
                }
            }
            com.byazt.p000do.pr.x(TAG, "isFileDataValid: cur = " + curBytes + ",totalBytes =" + this.totalBytes + ",fileLength=" + length);
            return false;
        }
        if (length > 0 && curBytes > 0) {
            long j2 = this.totalBytes;
            if (j2 > 0 && this.chunkCount > 0 && length >= curBytes && length <= j2 && curBytes < j2) {
                return true;
            }
        }
        com.byazt.p000do.pr.x(TAG, "isFileDataValid: cur = " + curBytes + ",totalBytes =" + this.totalBytes + ",fileLength=" + length);
        return false;
    }

    public boolean isFileDataExists() {
        if (isEntityInvalid()) {
            return false;
        }
        File file = new File(getTempPath(), getTempName());
        return file.exists() && !file.isDirectory();
    }

    public boolean isChunkBreakpointAvailable() {
        vk vkVarZ;
        if (this.chunkCount > 1 && (vkVarZ = com.byazt.lj.hn.z()) != null) {
            List<hw> listHn = vkVarZ.hn(getId());
            if (listHn == null || listHn.size() != this.chunkCount) {
                return false;
            }
            long jHo = 0;
            for (hw hwVar : listHn) {
                if (hwVar != null) {
                    jHo += hwVar.ho();
                }
            }
            if (jHo != getCurBytes()) {
                setCurBytes(jHo);
            }
        }
        return true;
    }

    public synchronized boolean isSaveTempFile() {
        return this.isSaveTempFile;
    }

    public synchronized void setIsSaveTempFile(boolean z) {
        this.isSaveTempFile = z;
    }

    public synchronized void handleTempSaveCallback(boolean z, BaseException baseException) {
        this.isSaveTempFile = false;
        if (this.tempFileSaveCompleteCallbacks == null) {
            return;
        }
        com.byazt.p000do.pr.hw(TAG, "handleTempSaveCallback isSuccess " + z + " callback size:" + this.tempFileSaveCompleteCallbacks.size());
        for (e eVar : this.tempFileSaveCompleteCallbacks) {
            if (eVar != null) {
                if (z) {
                    eVar.pr();
                } else {
                    eVar.pr(baseException);
                }
            }
        }
    }

    public void setChunkDowngradeRetryUsed(boolean z) {
        this.chunkDowngradeRetryUsed = z;
    }

    public boolean isBreakpointAvailable() {
        if (!isFileDataValid()) {
            return false;
        }
        return isChunkBreakpointAvailable();
    }

    public boolean isFirstDownload() {
        return (!this.isFirstDownload || TextUtils.isEmpty(getTempPath()) || TextUtils.isEmpty(getTempName()) || new File(getTempPath(), getTempName()).exists()) ? false : true;
    }

    public boolean checkMd5Valid() {
        return uc.hn(getSavePath(), getName(), this.md5);
    }

    public int checkMd5Status() {
        return uc.hw(getSavePath(), getName(), this.md5);
    }

    public boolean isCanResumeFromBreakPointStatus() {
        int status = getStatus();
        return status == 4 || status == 3 || status == -1 || status == 5 || status == 8 || ((status == 1 || status == 2) && getCurBytes() > 0);
    }

    public boolean isNewTask() {
        return getStatus() == 0;
    }

    public int getChunkCount() {
        return this.chunkCount;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.title);
        parcel.writeString(this.url);
        parcel.writeString(this.savePath);
        parcel.writeString(this.tempPath);
        parcel.writeByte(this.onlyWifi ? (byte) 1 : (byte) 0);
        parcel.writeString(this.extra);
        parcel.writeTypedList(this.extraHeaders);
        parcel.writeInt(this.maxBytes);
        parcel.writeStringArray(this.outIp);
        parcel.writeIntArray(this.outSize);
        parcel.writeInt(this.retryCount);
        parcel.writeInt(this.backUpUrlRetryCount);
        parcel.writeByte(this.force ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needPostProgress ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.maxProgressCount);
        parcel.writeInt(this.minProgressTimeMsInterval);
        parcel.writeStringList(this.backUpUrls);
        parcel.writeByte(this.showNotification ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mimeType);
        parcel.writeByte(this.needHttpsToHttpRetry ? (byte) 1 : (byte) 0);
        parcel.writeString(this.packageName);
        parcel.writeString(this.md5);
        parcel.writeByte(this.needRetryDelay ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needDefaultHttpServiceBackUp ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needReuseChunkRunnable ? (byte) 1 : (byte) 0);
        parcel.writeString(this.retryDelayTimeArray);
        parcel.writeString(this.eTag);
        parcel.writeInt(this.curRetryTime);
        parcel.writeInt(this.retryDelayStatus.ordinal());
        parcel.writeByte(this.needReuseFirstConnection ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.forceIgnoreRecommendSize ? (byte) 1 : (byte) 0);
        parcel.writeString(this.networkQuality);
        parcel.writeInt(this.curBackUpUrlIndex);
        parcel.writeInt(this.notificationVisibility);
        parcel.writeInt(this.chunkCount);
        parcel.writeLong(getCurBytes());
        parcel.writeLong(this.totalBytes);
        parcel.writeInt(getRealStatus());
        parcel.writeLong(this.downloadTime);
        parcel.writeLong(this.realDownloadTime);
        parcel.writeByte(this.backUpUrlUsed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.httpsToHttpRetryUsed ? (byte) 1 : (byte) 0);
        StringBuffer stringBuffer = this.errorBytesLog;
        parcel.writeString(stringBuffer != null ? stringBuffer.toString() : "");
        parcel.writeByte(this.autoResumed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.showNotificationForAutoResumed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.showNotificationForNetworkResumed ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.forbiddenBackupUrls);
        parcel.writeByte(this.needIndependentProcess ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.enqueueType.ordinal());
        parcel.writeByte(this.headConnectionAvailable ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.httpStatusCode);
        parcel.writeString(this.httpStatusMessage);
        parcel.writeByte(this.isSaveTempFile ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isForbiddenRetryed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.addListenerToSameTask ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needChunkDowngradeRetry ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.chunkDowngradeRetryUsed ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.failedException, i);
        parcel.writeInt(this.retryScheduleMinutes);
        parcel.writeString(getDBJsonDataString());
        parcel.writeByte(this.supportPartial ? (byte) 1 : (byte) 0);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.appVersionCode);
        parcel.writeString(this.taskId);
        parcel.writeByte(this.expiredRedownload ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.deleteCacheIfCheckFailed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.successByCache ? (byte) 1 : (byte) 0);
    }

    public BaseException getFailedException() {
        return this.failedException;
    }

    public void setFailedException(BaseException baseException) {
        this.failedException = baseException;
    }

    private void ensureSpData() {
        if (this.spData == null) {
            Context contextOf = com.byazt.lj.hn.of();
            if (contextOf != null) {
                String string = com.byazt.mg.hw.hw(contextOf, "sp_download_info", 0).getString(Long.toString(getId()), "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.spData = new JSONObject(string);
                    } catch (JSONException e) {
                    }
                }
            }
            if (this.spData == null) {
                this.spData = new JSONObject();
            }
        }
    }

    public void updateSpData() {
        Context contextOf;
        if (this.spData != null && (contextOf = com.byazt.lj.hn.of()) != null) {
            com.byazt.mg.hw.hw(contextOf, "sp_download_info", 0).edit().putString(Integer.toString(getId()), this.spData.toString()).apply();
        }
    }

    public void clearSpData() {
        Context contextOf = com.byazt.lj.hn.of();
        if (contextOf != null) {
            try {
                com.byazt.mg.hw.hw(contextOf, "sp_download_info", 0).edit().remove(Integer.toString(getId())).apply();
            } catch (Throwable th) {
            }
        }
    }

    public int getFailedResumeCount() {
        ensureSpData();
        return this.spData.optInt("failed_resume_count", 0);
    }

    public void setFailedResumeCount(int i) {
        ensureSpData();
        try {
            this.spData.put("failed_resume_count", i);
        } catch (Exception e) {
        }
    }

    public long getLastFailedResumeTime() {
        ensureSpData();
        return this.spData.optLong("last_failed_resume_time", 0L);
    }

    public void setLastFailedResumeTime(long j) {
        ensureSpData();
        try {
            this.spData.put("last_failed_resume_time", j);
        } catch (Exception e) {
        }
    }

    public int getUninstallResumeCount() {
        ensureSpData();
        return this.spData.optInt("unins_resume_count", 0);
    }

    public void setUninstallResumeCount(int i) {
        ensureSpData();
        try {
            this.spData.put("unins_resume_count", i);
        } catch (Exception e) {
        }
    }

    public long getLastUninstallResumeTime() {
        ensureSpData();
        return this.spData.optLong("last_unins_resume_time", 0L);
    }

    public void setLastUninstallResumeTime(long j) {
        ensureSpData();
        try {
            this.spData.put("last_unins_resume_time", j);
        } catch (Exception e) {
        }
    }

    public String getSpStringVal(String str) {
        ensureSpData();
        return this.spData.optString(str, null);
    }

    public int getSpIntVal(String str) {
        ensureSpData();
        return this.spData.optInt(str, 0);
    }

    public long getSpLongVal(String str) {
        ensureSpData();
        return this.spData.optLong(str, 0L);
    }

    public void setSpValue(String str, String str2) {
        ensureSpData();
        try {
            this.spData.put(str, str2);
            updateSpData();
        } catch (Exception e) {
        }
    }

    public long getLastDownloadTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("dbjson_last_start_download_time", 0L);
    }

    public int getAntiHijackErrorCode(int i) {
        ensureDBJsonData();
        return this.dbJsonData.optInt("anti_hijack_error_code", i);
    }

    public void setAntiHijackErrorCode(int i) {
        safePutToDBJsonData("anti_hijack_error_code", Integer.valueOf(i));
    }

    public boolean isSavePathRedirected() {
        ensureDBJsonData();
        return this.dbJsonData.optBoolean("is_save_path_redirected", false);
    }

    public void setSavePathRedirected(boolean z) {
        safePutToDBJsonData("is_save_path_redirected", Boolean.valueOf(z));
    }

    public String toString() {
        return "DownloadInfo{id=" + this.id + ", name='" + this.name + "', title='" + this.title + "', url='" + this.url + "', savePath='" + this.savePath + '\'' + AbstractJsonLexerKt.END_OBJ;
    }

    public int getPreconnectLevel() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("dbjson_key_preconnect_level", 0);
    }

    public void setPreconnectLevel(int i) {
        ensureDBJsonData();
        safePutToDBJsonData("dbjson_key_preconnect_level", Integer.valueOf(i));
    }

    private void ensureTempCacheData() {
        if (this.tempCacheData == null) {
            synchronized (this) {
                if (this.tempCacheData == null) {
                    this.tempCacheData = new ConcurrentHashMap<>();
                }
            }
        }
    }

    public ConcurrentHashMap<String, Object> getTempCacheData() {
        ensureTempCacheData();
        return this.tempCacheData;
    }

    public boolean isSupportPartial() {
        return this.supportPartial;
    }

    public int getExecutorGroup() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("executor_group", 2);
    }

    public String getDBJsonString(String str) {
        ensureDBJsonData();
        return this.dbJsonData.optString(str);
    }

    public int getDBJsonInt(String str) {
        ensureDBJsonData();
        return this.dbJsonData.optInt(str);
    }

    public void setThrottleNetSpeed(long j) {
        this.throttleNetSpeed = j;
    }

    public void setOpenLimitSpeed(boolean z) {
        this.openLimitSpeed = z;
    }

    public boolean getOpenLimitSpeed() {
        return this.openLimitSpeed;
    }

    public long getThrottleNetSpeed() {
        return this.throttleNetSpeed;
    }

    public int getStatusAtDbInit() {
        return this.statusAtDbInit;
    }

    public void setStatusAtDbInit(int i) {
        this.statusAtDbInit = i;
    }

    public void setPackageInfo(PackageInfo packageInfo) {
        this.packageInfoRef = new SoftReference<>(packageInfo);
    }

    public PackageInfo getPackageInfo() {
        SoftReference<PackageInfo> softReference = this.packageInfoRef;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public double getDownloadSpeed() {
        double curBytes = getCurBytes() / 1048576.0d;
        double realDownloadTime = getRealDownloadTime() / 1000.0d;
        if (curBytes > 0.0d && realDownloadTime > 0.0d) {
            return curBytes / realDownloadTime;
        }
        return -1.0d;
    }

    public long getTtnetProtectTimeout() {
        return this.ttnetProtectTimeout;
    }

    public int getPausedResumeCount() {
        ensureSpData();
        return this.spData.optInt("paused_resume_count", 0);
    }

    public void setPausedResumeCount(int i) {
        ensureSpData();
        try {
            this.spData.put("paused_resume_count", i);
        } catch (Exception e) {
        }
    }

    public boolean cacheExpierd() {
        if (!isDownloaded()) {
            return true;
        }
        return uc.x(this);
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME, 1143})
    public static class pr {
        public int aj;
        public boolean b;
        public boolean bm;
        public String c;
        public String cz;
        public boolean er;
        public long f;
        public boolean fo;
        public String fw;
        public boolean g;
        public long gz;
        public String hn;
        public int[] hs;
        public String hw;
        public boolean ie;
        public JSONObject ii;
        public String iu;
        public String jn;
        public int k;
        public List<String> lb;
        public boolean ls;
        public int m;
        public boolean n;
        public boolean nl;
        public int nt;
        public int nw;
        public boolean ny;
        public boolean o;
        public boolean of;
        public String pr;
        public boolean qa;
        public long qi;
        public boolean qn;
        public String r;
        public boolean rc;
        public boolean s;
        public boolean uc;
        public String v;
        public String ve;
        public String[] vk;
        public int[] w;
        public boolean ww;
        public String x;
        public String y;
        public int yb;
        public List<hn> zo;
        public boolean ho = true;
        public boolean a = true;
        public boolean z = true;
        public EnqueueType e = EnqueueType.ENQUEUE_NONE;
        public boolean i = true;

        public pr() {
        }

        public pr(String str) {
            this.hn = str;
        }

        public pr pr(String str) {
            this.pr = str;
            return this;
        }

        public pr hw(String str) {
            this.hw = str;
            return this;
        }

        public pr hn(String str) {
            this.hn = str;
            return this;
        }

        public pr x(String str) {
            this.jn = str;
            return this;
        }

        public pr c(String str) {
            this.x = str;
            return this;
        }

        public pr uc(String str) {
            this.c = str;
            return this;
        }

        public pr fw(String str) {
            this.fw = str;
            return this;
        }

        public pr pr(boolean z) {
            this.uc = z;
            return this;
        }

        public pr pr(List<hn> list) {
            this.zo = list;
            return this;
        }

        public pr pr(int i) {
            this.aj = i;
            return this;
        }

        public pr pr(String[] strArr) {
            this.vk = strArr;
            return this;
        }

        public pr pr(int[] iArr) {
            this.w = iArr;
            return this;
        }

        public pr hw(int i) {
            this.k = i;
            return this;
        }

        public pr hn(int i) {
            this.m = i;
            return this;
        }

        public pr hw(boolean z) {
            this.g = z;
            return this;
        }

        public pr hn(boolean z) {
            this.ho = z;
            return this;
        }

        public pr x(int i) {
            this.nt = i;
            return this;
        }

        public pr c(int i) {
            this.yb = i;
            return this;
        }

        public pr hw(List<String> list) {
            this.lb = list;
            return this;
        }

        public pr zo(String str) {
            this.cz = str;
            return this;
        }

        public pr x(boolean z) {
            this.ny = z;
            return this;
        }

        public pr c(boolean z) {
            this.qa = z;
            return this;
        }

        public pr uc(boolean z) {
            this.fo = z;
            return this;
        }

        public pr fw(boolean z) {
            this.rc = z;
            return this;
        }

        public pr zo(boolean z) {
            this.z = z;
            return this;
        }

        public pr aj(boolean z) {
            this.b = z;
            return this;
        }

        public pr aj(String str) {
            this.iu = str;
            return this;
        }

        public pr vk(String str) {
            this.ve = str;
            return this;
        }

        public pr pr(long j) {
            this.gz = j;
            return this;
        }

        public pr vk(boolean z) {
            this.nl = z;
            return this;
        }

        public pr w(String str) {
            this.y = str;
            return this;
        }

        public pr w(boolean z) {
            this.ww = z;
            return this;
        }

        public pr k(boolean z) {
            this.n = z;
            return this;
        }

        public pr pr(EnqueueType enqueueType) {
            this.e = enqueueType;
            return this;
        }

        public pr m(boolean z) {
            this.s = z;
            return this;
        }

        public pr g(boolean z) {
            this.ls = z;
            return this;
        }

        public pr ho(boolean z) {
            this.er = z;
            return this;
        }

        public pr nt(boolean z) {
            this.of = z;
            return this;
        }

        public pr pr(JSONObject jSONObject) {
            this.ii = jSONObject;
            return this;
        }

        public pr yb(boolean z) {
            this.i = z;
            return this;
        }

        public pr k(String str) {
            this.r = str;
            return this;
        }

        public pr hw(int[] iArr) {
            this.hs = iArr;
            return this;
        }

        public pr m(String str) {
            this.v = str;
            return this;
        }

        public pr uc(int i) {
            this.nw = i;
            return this;
        }

        public pr hw(long j) {
            this.qi = j;
            return this;
        }

        public pr lb(boolean z) {
            this.qn = z;
            return this;
        }

        public pr qa(boolean z) {
            this.ie = z;
            return this;
        }

        public pr a(boolean z) {
            this.o = z;
            return this;
        }

        public pr hn(long j) {
            this.f = j;
            return this;
        }

        public pr cz(boolean z) {
            this.bm = z;
            return this;
        }

        public pr ny(boolean z) {
            this.a = z;
            return this;
        }

        public DownloadInfo pr() {
            return new DownloadInfo(this);
        }
    }
}
