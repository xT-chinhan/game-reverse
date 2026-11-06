package com.bykv.vk.component.ttvideo.mediakit.medialoader;

import android.text.TextUtils;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.fi.BaseConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AVMDLDataLoaderConfigure {
    public static final int ALLOW_PRELOAD_WHEN_PLAY = 0;
    public static final int DEFAULT_CHECK_SUM_LEVEL = 0;
    public static final int DEFAULT_MAX_CACHE_AGE = 1209600;
    public static final int DEFAULT_MAX_CACHE_SIZE = 314572800;
    public static final int DEFAULT_MAX_FACTORY_CACHE_SIZE = 209715200;
    public static final int DEFAULT_MAX_FACTORY_MEMORY_SIZE = 5242880;
    public static final int DEFAULT_P2P_PREDOWN_PEER_COUNT = 5;
    public static final int DEFAULT_PRELOAD_PARALLEL_NUM = 1;
    public static final int DEFAULT_SOCKET_IDLE_TIMEOUT = 120;
    public static final int DISABLE_EXTERN_DNS = 0;
    public static final int DISABLE_SOCKET_REUSE = 0;
    public static final int ENABLE_EXTERN_DNS = 1;
    public static final int ENABLE_SOCKET_REUSE = 1;
    public static final int ENCRYPT_VERSION_0 = 0;
    public static final int ENCRYPT_VERSION_1 = 1;
    public static final int IsCheckAfterAll = 1;
    public static final int IsCheckAfterPreloadTask = 0;
    public static final int NOT_ALLOW_PLAY_TASK_KEY_PRELOAD = 1;
    public static final int NOT_ALLOW_PRELOAD_WHEN_PLAY = 2;
    private static final String TAG = "AVMDLDataLoaderConfigure";
    public static final int TEST_SPEED_TYPE_VERSION_1 = 1;
    public static final int TEST_SPEED_TYPE_VERSION_2 = 2;
    public static final int WAIT_LIST_IS_QUEUE = 1;
    public static final int WAIT_LIST_IS_STACK = 0;
    public static final int XY_DY_LIB = 1;
    public static final int XY_XG_LIB = 0;
    public int mAccessCheckLevel;
    public String mCacheDir;
    public int mCheckPreloadLevel;
    public long mConnectPoolStragetyValue;
    public int mDNSBackType;
    public int mDNSMainType;
    public int mDefaultExpiredTime;
    public String mDmDomain;
    public String mDomains;
    public String mDownloadDir;
    public int mEnableDownloaderLog;
    public int mEnableDynamicTimeout;
    public int mEnableEventInfo;
    public int mEnableFileCacheV2;
    public int mEnableFileRingBuffer;
    public int mEnableIOManager;
    public int mEnableIpBucket;
    public int mEnableLazyBufferpool;
    public int mEnableLoaderPreempt;
    public int mEnableLoaderSeek;
    public int mEnableNewBufferpool;
    public int mEnableOwnVDPPreloadNotify;
    public int mEnableP2PPreDown;
    public int mEnablePlayInfoCache;
    public int mEnablePreconnect;
    public int mEnableReportTaskLog;
    public int mEnableSessionReuse;
    public int mEnableSyncDnsForPcdn;
    public int mEnableUseFileExtendLoaderBuffer;
    public int mErrorStateTrustTime;
    public int mFileExtendSizeKB;
    public int mForbidByPassCookie;
    public String mForesightDomain;
    public int mGlobalSpeedSampleInterval;
    public int mIgnorePlayInfo;
    public int mIsAllowTryTheLastUrl;
    public int mIsCloseFileCache;
    public String mKeyDomain;
    public String mKeyToken;
    public int mLoaderFactoryP2PLevel;
    public int mMainToBackUpDelayedTime;
    public int mMaxAliveHostNum;
    public int mMaxCacheSize;
    public int mMaxFileMemCacheSize;
    public int mMaxIpCountEachDomain;
    public int mMaxSocketReuseCount;
    public int mMaxTlsVersion;
    public int mMinAllowSpeed;
    public int mNewBufferPoolBlockSize;
    public int mNewBufferPoolGrowBlockCount;
    public int mNewBufferPoolResidentSize;
    public int mNextDownloadThreshold;
    public int mOnlyUseCdn;
    public int mOpenTimeOut;
    public long mP2PStragetyLevel;
    public int mPreconnectNum;
    public int mRWTimeOut;
    public int mRingBufferSizeKB;
    public int mSessionTimeout;
    public String mSettingsDomain;
    public int mSocketInitialTimeout;
    public int mSocketSendBufferKB;
    public int mSpeedSampleInterval;
    public int mTryCount;
    public String mVdpABTestId;
    public String mVdpGroupId;
    public int mWriteFileNotifyIntervalMS;
    public int mXYLibValue;
    public int mAlogEnable = 0;
    public int mMaxIPV6Num = Integer.MAX_VALUE;
    public int mMaxIPV4Num = Integer.MAX_VALUE;
    public int mEnablePlayLog = 0;
    public int mEnableNetScheduler = 0;
    public int mEnableCacheReqRange = 0;
    public int mEnableTTNetLoader = 0;
    public int mTTNetLoaderCronetBufSizeKB = 0;
    public int mNetSchedulerBlockAllNetErr = 0;
    public int mNetSchedulerBlockErrCount = 0;
    public int mNetSchedulerBlockHostIpErrCount = 0;
    public int mNetSChedulerBlockDurationMs = 0;
    public int mFirstRangeLeftThreshold = 0;
    public int mP2PPreDownPeerCount = 5;
    public int mP2PFirstRangeLoaderType = 1;
    public int mEnableStorageModule = 0;
    public int mStoPlayDldWinSizeKBNM = 0;
    public int mStoPlayDldWinSizeKBLS = 0;
    public int mStoRingBufferSizeKB = 0;
    public int mStoIoWriteLimitKBTh1 = 0;
    public int mStoIoWriteLimitKBTh2 = 0;
    public int mStoMaxIdleTimeSec = 0;
    public int mLoaderType = 0;
    public String mLoaderFactoryDir = null;
    public int mLoaderFactoryMaxCacheSize = DEFAULT_MAX_FACTORY_CACHE_SIZE;
    public int mLoaderFactoryMaxMemorySize = DEFAULT_MAX_FACTORY_MEMORY_SIZE;
    public int mPreloadParallelNum = 1;
    public int mMaxCacheAge = DEFAULT_MAX_CACHE_AGE;
    public int mPreloadStrategy = 1;
    public int mPreloadWaitListType = 1;
    public int mEnablePreloadReUse = 0;
    public int mEnableExternDNS = 0;
    public int mEnableSocketReuse = 0;
    public int mControlCDNRangeType = 0;
    public int mSocketIdleTimeOut = 120;
    public int mTestSpeedTypeVersion = 1;
    public int mCheckSumLevel = 0;
    public String mAppInfo = null;
    public int mEncryptVersion = 0;
    public int mSpeedCoefficientValue = 0;
    public int mEnableBenchMarkIOSpeed = 0;
    public int mLiveP2pAllow = 0;
    public int mLiveLoaderType = 10000;
    public int mLiveLoaderEnable = 0;
    public int mLiveWatchDurationThreshold = AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS;
    public int mLiveCacheThresholdHttpToP2p = 3500;
    public int mLiveCacheThresholdP2pToHttp = 1000;
    public int mLiveMaxTrySwitchP2pTimes = 3;
    public int mLiveWaitP2pReadyThreshold = BaseConstants.Time.MINUTE;
    public int mLiveMobileUploadAllow = 0;
    public int mLiveMobileDownloadAllow = 0;
    public int mLiveRecvDataTimeout = 5000;
    public String mLiveContainerString = null;
    public int mLiveEnableMdlProto = 0;
    public String mNetCacheDir = null;
    public int mMaxFileMemCacheNum = 0;
    public long mMonitorTimeInternal = 0;
    public long mMonitorMinAllowLoadSize = 0;
    public String mSocketTraingCenterConfigStr = null;
    public String mCacheDirListsStr = null;
    public int mEnableEarlyData = 0;

    public static AVMDLDataLoaderConfigure getDefaultonfigure() {
        return new AVMDLDataLoaderConfigure(DEFAULT_MAX_CACHE_SIZE, 5, 5, 0, null);
    }

    public AVMDLDataLoaderConfigure(int i, int i2, int i3, int i4, String str) {
        this.mDNSMainType = 0;
        this.mDNSBackType = 2;
        this.mMainToBackUpDelayedTime = 0;
        this.mDefaultExpiredTime = 60;
        this.mLoaderFactoryP2PLevel = 3;
        this.mMaxIpCountEachDomain = 0;
        this.mEnableIpBucket = 0;
        this.mErrorStateTrustTime = 0;
        this.mOnlyUseCdn = 0;
        this.mEnablePreconnect = 0;
        this.mPreconnectNum = 3;
        this.mEnableLoaderPreempt = 0;
        this.mAccessCheckLevel = 0;
        this.mNextDownloadThreshold = 0;
        this.mSocketSendBufferKB = -1;
        this.mMaxTlsVersion = 2;
        this.mEnableSessionReuse = 0;
        this.mRingBufferSizeKB = -1;
        this.mEnableFileCacheV2 = 0;
        this.mVdpABTestId = null;
        this.mVdpGroupId = null;
        this.mEnableSyncDnsForPcdn = 0;
        this.mIgnorePlayInfo = 0;
        this.mSettingsDomain = null;
        this.mDmDomain = null;
        this.mForesightDomain = null;
        this.mDomains = null;
        this.mCheckPreloadLevel = 0;
        this.mXYLibValue = 1;
        this.mWriteFileNotifyIntervalMS = 500;
        this.mEnableFileRingBuffer = 0;
        this.mEnableLazyBufferpool = 0;
        this.mEnableNewBufferpool = 0;
        this.mNewBufferPoolBlockSize = 0;
        this.mNewBufferPoolResidentSize = 0;
        this.mNewBufferPoolGrowBlockCount = 0;
        this.mEnableUseFileExtendLoaderBuffer = 0;
        this.mMaxFileMemCacheSize = 0;
        this.mDownloadDir = null;
        this.mKeyDomain = null;
        this.mKeyToken = null;
        this.mForbidByPassCookie = 0;
        this.mSessionTimeout = 3600;
        this.mEnablePlayInfoCache = 0;
        this.mEnableP2PPreDown = 0;
        this.mEnableDownloaderLog = 0;
        this.mIsAllowTryTheLastUrl = 0;
        this.mSpeedSampleInterval = 0;
        this.mEnableIOManager = 0;
        this.mEnableLoaderSeek = 0;
        this.mGlobalSpeedSampleInterval = 0;
        this.mEnableDynamicTimeout = 0;
        this.mSocketInitialTimeout = 3;
        this.mMaxSocketReuseCount = 0;
        this.mP2PStragetyLevel = 0L;
        this.mEnableOwnVDPPreloadNotify = 1;
        this.mConnectPoolStragetyValue = 0L;
        this.mMaxAliveHostNum = 0;
        this.mEnableReportTaskLog = 0;
        this.mFileExtendSizeKB = 8192;
        this.mMinAllowSpeed = 0;
        this.mEnableEventInfo = 0;
        this.mMaxCacheSize = i;
        this.mOpenTimeOut = i2;
        this.mRWTimeOut = i3;
        this.mTryCount = i4;
        this.mCacheDir = str;
        this.mIsCloseFileCache = 0;
        this.mIsCloseFileCache = 0;
        this.mDNSMainType = 0;
        this.mDNSBackType = 2;
        this.mMainToBackUpDelayedTime = 0;
        this.mDefaultExpiredTime = 60;
        this.mLoaderFactoryP2PLevel = 3;
        this.mDefaultExpiredTime = 120;
        this.mMaxIpCountEachDomain = 0;
        this.mEnableIpBucket = 0;
        this.mErrorStateTrustTime = 0;
        this.mOnlyUseCdn = 0;
        this.mSocketSendBufferKB = -1;
        this.mRingBufferSizeKB = -1;
        this.mEnableFileCacheV2 = 0;
        this.mVdpABTestId = null;
        this.mVdpGroupId = null;
        this.mEnableReportTaskLog = 0;
        this.mFileExtendSizeKB = 8192;
        this.mEnablePreconnect = 0;
        this.mPreconnectNum = 3;
        this.mEnableLoaderPreempt = 0;
        this.mNextDownloadThreshold = 0;
        this.mAccessCheckLevel = 0;
        this.mEnableP2PPreDown = 0;
        this.mMaxTlsVersion = 2;
        this.mEnableSessionReuse = 0;
        this.mEnableSyncDnsForPcdn = 0;
        this.mIgnorePlayInfo = 0;
        this.mSettingsDomain = null;
        this.mDmDomain = null;
        this.mForesightDomain = null;
        this.mDomains = null;
        this.mCheckPreloadLevel = 0;
        this.mXYLibValue = 1;
        this.mWriteFileNotifyIntervalMS = 500;
        this.mEnableFileRingBuffer = 0;
        this.mEnableLazyBufferpool = 0;
        this.mEnableNewBufferpool = 0;
        this.mNewBufferPoolBlockSize = 0;
        this.mNewBufferPoolResidentSize = 0;
        this.mNewBufferPoolGrowBlockCount = 0;
        this.mEnableUseFileExtendLoaderBuffer = 0;
        this.mMaxFileMemCacheSize = 0;
        this.mDownloadDir = null;
        this.mKeyDomain = null;
        this.mKeyToken = null;
        this.mForbidByPassCookie = 0;
        this.mSessionTimeout = 3600;
        this.mEnablePlayInfoCache = 0;
        this.mEnableDownloaderLog = 0;
        this.mIsAllowTryTheLastUrl = 0;
        this.mSpeedSampleInterval = 0;
        this.mEnableIOManager = 0;
        this.mEnableLoaderSeek = 0;
        this.mGlobalSpeedSampleInterval = 0;
        this.mEnableDynamicTimeout = 0;
        this.mSocketInitialTimeout = 3;
        this.mMaxSocketReuseCount = 0;
        this.mP2PStragetyLevel = 0L;
        this.mConnectPoolStragetyValue = 0L;
        this.mMaxAliveHostNum = 0;
        this.mMinAllowSpeed = 0;
        this.mEnableOwnVDPPreloadNotify = 1;
        this.mEnableEventInfo = 0;
    }

    public void ParseJsonConfig() {
        try {
            if (this.mLiveContainerString != null) {
                JSONObject jSONObject = new JSONObject(this.mLiveContainerString);
                if (!jSONObject.isNull("enable_mdl_proto")) {
                    this.mLiveEnableMdlProto = jSONObject.getInt("enable_mdl_proto");
                }
            }
        } catch (Exception e) {
            AVMDLLog.e("ttmn", "parse json config fail:" + e.toString());
        }
    }

    public void setCacheInfoList(String[] strArr, long[] jArr) {
        if (strArr.length == 0 || jArr.length == 0 || strArr.length != jArr.length) {
            return;
        }
        this.mCacheDirListsStr = null;
        for (int i = 0; i < strArr.length; i++) {
            if (!TextUtils.isEmpty(strArr[i])) {
                if (this.mCacheDirListsStr == null) {
                    this.mCacheDirListsStr = strArr[i] + "$" + Long.toString(jArr[i]);
                } else {
                    this.mCacheDirListsStr += "|" + strArr[i] + "$" + Long.toString(jArr[i]);
                }
            }
        }
        if (TextUtils.isEmpty(this.mCacheDirListsStr)) {
            AVMDLLog.e(TAG, "cache dir list str is null");
        }
    }
}
