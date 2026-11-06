package com.tapsdk.tapad.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.mg.PluginConstants;
import com.mar.sdk.IAction;
import com.tapsdk.tapad.AdRequest;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.TapRewardVideoAd;
import com.tapsdk.tapad.a;
import com.tapsdk.tapad.constants.ErrorCodeEnum;
import com.tapsdk.tapad.exceptions.ClientException;
import com.tapsdk.tapad.group.ads.DirichletAd$$ExternalSyntheticBackportWithForwarding0;
import com.tapsdk.tapad.internal.ionia.IoniaIdentityManager;
import com.tapsdk.tapad.internal.runtime.CoreModuleSelector;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.PublisherSettingsBridge;
import com.tapsdk.tapad.internal.runtime.ShowHostFacts;
import com.tapsdk.tapad.internal.runtime.WasmAdInstance;
import com.tapsdk.tapad.internal.runtime.WasmModule;
import com.tapsdk.tapad.internal.runtime.plugin.AdCallbackListener;
import com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class WasmRewardPresenter implements AdCallbackListener, IoniaPlaybackSource {
    private static final long CHANGE_AD_OLD_ACTIVITY_FINISH_DELAY_MS = 300;
    private static final long CHANGE_AD_OLD_DISPOSE_DELAY_MS = 450;
    private static final String EXTRA_ADN_TRACK_ID = "adn_track_id";
    private static final String EXTRA_BID_PRICE = "bid_price";
    private static final String EXTRA_REQUEST_ID = "request_id";
    private static final String EXTRA_REQ_UUID = "req_uuid";
    private static final String EXTRA_TRACE_ID = "trace_id";
    private static final String EXTRA_TRACK_ID = "track_id";
    private static final String FN_CHANGE_AD_RESULT_SURFACE_INSTANCE = "on_change_ad_result_surface_instance";
    private static final String TAG = "WasmRewardPresenter";
    private TapRewardVideoAd mCallbackAd;
    private boolean mChangeAdDisposeScheduled;
    private int mChangeAdTimes;
    private boolean mChangingAd;
    private final Context mContext;
    private volatile boolean mDisposed;
    private boolean mFallbackTakeoverPending;
    private TapRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    private LoadCallback mLoadCallback;
    private volatile boolean mLoadFinished;
    private WasmRewardPresenter mNextPresenter;
    private boolean mPendingDispose;
    private boolean mPreparing;
    private long mPrice;
    private volatile boolean mReady;
    private final AdRequest mRequest;
    private volatile boolean mShowing;
    private boolean mTerminalPresentationErrorHandled;
    private volatile String mTrackId;
    private static final String FN_AD_LOAD_INSTANCE = "ad_load_instance";
    private static final String FN_AD_PRESENT_INSTANCE = "ad_present_instance_v2";
    private static final String FN_AD_IS_READY_INSTANCE = "ad_is_ready_instance";
    private static final String FN_AD_SEND_WIN_INSTANCE = "ad_send_win_notification_instance";
    private static final String FN_AD_SEND_LOSS_INSTANCE = "ad_send_loss_notification_instance";
    private static final String FN_CHANGE_AD_RESULT_INSTANCE = "on_change_ad_result_instance";
    private static final String[] REQUIRED_INSTANCE_EXPORTS = {FN_AD_LOAD_INSTANCE, FN_AD_PRESENT_INSTANCE, FN_AD_IS_READY_INSTANCE, FN_AD_SEND_WIN_INSTANCE, FN_AD_SEND_LOSS_INSTANCE, FN_CHANGE_AD_RESULT_INSTANCE};
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private final Map<String, Object> mMediaExtraInfo = new HashMap();
    private final WasmAdnLoadAttempt mLoadAttempt = new WasmAdnLoadAttempt();
    private final Object mInstanceLock = new Object();
    private final Object mChangeAdLock = new Object();
    private WeakReference<WasmAdInstance> mInstanceRef = new WeakReference<>(null);
    private WeakReference<Activity> mActivityRef = new WeakReference<>(null);

    public static final class AdapterRewardVideoAd implements TapRewardVideoAd {
        private final AtomicReference<WasmRewardPresenter> mActive;
        private final AtomicBoolean mDisposed = new AtomicBoolean(false);

        public AdapterRewardVideoAd(WasmRewardPresenter wasmRewardPresenter) {
            this.mActive = new AtomicReference<>(wasmRewardPresenter);
        }

        private WasmRewardPresenter active() {
            return this.mActive.get();
        }

        @Override // com.tapsdk.tapad.TapRewardVideoAd
        public void dispose() {
            WasmRewardPresenter andSet;
            if (this.mDisposed.compareAndSet(false, true) && (andSet = this.mActive.getAndSet(null)) != null) {
                andSet.dispose();
            }
        }

        @Override // com.tapsdk.tapad.TapRewardVideoAd
        public Map<String, Object> getMediaExtraInfo() {
            WasmRewardPresenter wasmRewardPresenterActive = active();
            return wasmRewardPresenterActive != null ? wasmRewardPresenterActive.getMediaExtraInfo() : Collections.EMPTY_MAP;
        }

        @Override // com.tapsdk.tapad.TapRewardVideoAd
        public long getPrice() {
            WasmRewardPresenter wasmRewardPresenterActive = active();
            if (wasmRewardPresenterActive != null) {
                return wasmRewardPresenterActive.getPrice();
            }
            return 0L;
        }

        @Override // com.tapsdk.tapad.TapRewardVideoAd
        public boolean isValid() {
            WasmRewardPresenter wasmRewardPresenterActive = active();
            return wasmRewardPresenterActive != null && wasmRewardPresenterActive.isReady();
        }

        public boolean rebind(WasmRewardPresenter wasmRewardPresenter) {
            if (wasmRewardPresenter == null || this.mDisposed.get()) {
                if (wasmRewardPresenter != null) {
                    wasmRewardPresenter.dispose();
                }
                return false;
            }
            this.mActive.set(wasmRewardPresenter);
            if (!this.mDisposed.get()) {
                return true;
            }
            if (DirichletAd$$ExternalSyntheticBackportWithForwarding0.m(this.mActive, wasmRewardPresenter, null)) {
                wasmRewardPresenter.dispose();
            }
            return false;
        }

        @Override // com.tapsdk.tapad.TapRewardVideoAd
        public void sendLossNotification(Map<String, Object> map) {
            WasmRewardPresenter wasmRewardPresenterActive = active();
            if (wasmRewardPresenterActive != null) {
                wasmRewardPresenterActive.reportBiddingResult(false, map);
            }
        }

        @Override // com.tapsdk.tapad.TapRewardVideoAd
        public void sendWinNotification(Map<String, Object> map) {
            WasmRewardPresenter wasmRewardPresenterActive = active();
            if (wasmRewardPresenterActive != null) {
                wasmRewardPresenterActive.reportBiddingResult(true, map);
            }
        }

        @Override // com.tapsdk.tapad.TapRewardVideoAd
        public void setRewardAdInteractionListener(TapRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            WasmRewardPresenter wasmRewardPresenterActive = active();
            if (wasmRewardPresenterActive != null) {
                wasmRewardPresenterActive.setInteractionListener(rewardAdInteractionListener, this);
            }
        }

        @Override // com.tapsdk.tapad.TapRewardVideoAd
        public void showRewardVideoAd(Activity activity) {
            WasmRewardPresenter wasmRewardPresenterActive = active();
            if (wasmRewardPresenterActive != null && wasmRewardPresenterActive.tryShowRewardVideoAd(activity) == ShowOutcome.FAILED_TO_START) {
                wasmRewardPresenterActive.notifyVideoError(this);
            }
        }
    }

    public interface LoadCallback {
        void onError(Exception exc, boolean z);

        void onReady(WasmRewardPresenter wasmRewardPresenter);
    }

    public enum ShowOutcome {
        STARTED,
        REJECTED,
        FAILED_TO_START
    }

    public WasmRewardPresenter(Context context, AdRequest adRequest) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mRequest = adRequest;
        DirichletRuntime.getInstance().init(applicationContext);
    }

    public static String aotModuleEntryForAbi(String str) {
        return CoreModuleSelector.aotEntryForAbi(str);
    }

    private void appendDebugRewardTemplateOverride(JSONObject jSONObject) {
    }

    public static JSONObject appendSdkVersion(JSONObject jSONObject) throws JSONException {
        jSONObject.put("sdk_version_code", 50300001);
        jSONObject.put("sdk_version_name", safe("5.3.0.1"));
        return jSONObject;
    }

    private static String asString(Object obj) {
        return (obj == null || obj == JSONObject.NULL) ? "" : String.valueOf(obj);
    }

    private void callAdLoad(WasmModule wasmModule, int i) throws JSONException {
        if (!wasmModule.hasFunction(FN_AD_LOAD_INSTANCE)) {
            notifyLoadError(new IllegalStateException("ad_load_instance not found"));
            return;
        }
        JSONObject jSONObjectCreate = WasmAdnLoadRequest.create(this.mRequest);
        jSONObjectCreate.put("media_global_settings", PublisherSettingsBridge.snapshot());
        appendDebugRewardTemplateOverride(jSONObjectCreate);
        if (this.mLoadAttempt.tryMarkAdLoadDispatched()) {
            wasmModule.callVoidSync(FN_AD_LOAD_INSTANCE, Integer.valueOf(i), "reward", jSONObjectCreate.toString());
        }
    }

    private void cleanupFailedLoadInstance() {
        WasmAdInstance wasmAdInstanceDetachInstance = detachInstance();
        this.mReady = false;
        this.mShowing = false;
        if (wasmAdInstanceDetachInstance != null) {
            wasmAdInstanceDetachInstance.dispose();
        }
    }

    private WasmAdInstance detachInstance() {
        WasmAdInstance wasmAdInstance;
        synchronized (this.mInstanceLock) {
            wasmAdInstance = this.mInstanceRef.get();
            this.mInstanceRef = new WeakReference<>(null);
        }
        return wasmAdInstance;
    }

    private static String firstMissingInstanceExport(WasmModule wasmModule) {
        for (String str : REQUIRED_INSTANCE_EXPORTS) {
            if (!wasmModule.hasFunction(str)) {
                return str;
            }
        }
        return null;
    }

    private static String firstNonEmpty(String... strArr) {
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    private void forwardRewardVerify(TapRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, TapRewardVideoAd tapRewardVideoAd, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str == null ? "{}" : str);
            Object objOpt = jSONObject.opt(TrackAction.SUCCESS);
            Object objOpt2 = jSONObject.opt(IAction.BuyKey.CostAmount);
            Object objOpt3 = jSONObject.opt(Common.System.NAME);
            Object objOpt4 = jSONObject.opt(PluginConstants.KEY_ERROR_CODE);
            Object objOpt5 = jSONObject.opt("message");
            if ((objOpt instanceof Boolean) && (objOpt2 instanceof Number) && (objOpt3 instanceof String) && (objOpt4 instanceof Number) && (objOpt5 instanceof String)) {
                long jLongValue = ((Number) objOpt2).longValue();
                long jLongValue2 = ((Number) objOpt4).longValue();
                if (jLongValue < -2147483648L || jLongValue > 2147483647L || jLongValue2 < -2147483648L || jLongValue2 > 2147483647L) {
                    return;
                }
                rewardAdInteractionListener.onRewardVerify(tapRewardVideoAd, ((Boolean) objOpt).booleanValue(), (int) jLongValue, (String) objOpt3, (int) jLongValue2, (String) objOpt5);
            }
        } catch (Throwable th) {
        }
    }

    private void handleAdClose() {
        if (this.mPendingDispose) {
            this.mPendingDispose = false;
            this.mChangeAdDisposeScheduled = true;
            WasmAdInstance wasmAdInstanceInstance = instance();
            if (wasmAdInstanceInstance != null) {
                final int iInstanceId = wasmAdInstanceInstance.instanceId();
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmRewardPresenter$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseAdActivity.finishActivitiesForInstance(iInstanceId);
                    }
                }, CHANGE_AD_OLD_ACTIVITY_FINISH_DELAY_MS);
            }
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmRewardPresenter$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.dispose();
                }
            }, CHANGE_AD_OLD_DISPOSE_DELAY_MS);
            return;
        }
        if (this.mChangeAdDisposeScheduled) {
            return;
        }
        this.mShowing = false;
        this.mReady = false;
        TapRewardVideoAd tapRewardVideoAd = this.mCallbackAd;
        TapRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.mInteractionListener;
        if (rewardAdInteractionListener != null && tapRewardVideoAd != null) {
            try {
                rewardAdInteractionListener.onAdClose(tapRewardVideoAd);
            } finally {
                dispose();
            }
        }
    }

    private void handleChangeAd() {
        boolean z;
        synchronized (this.mChangeAdLock) {
            if (!this.mDisposed && !this.mChangingAd && !this.mPendingDispose && !this.mChangeAdDisposeScheduled) {
                boolean z2 = true;
                this.mChangingAd = true;
                if (this.mActivityRef.get() == null) {
                    synchronized (this.mChangeAdLock) {
                        this.mChangingAd = false;
                    }
                    reportChangeAdResult(false, -1, "");
                    return;
                }
                this.mChangeAdTimes++;
                AdRequest.Builder builderWithQuery = new AdRequest.Builder().withSpaceId(this.mRequest.spaceId).withExtra1(this.mRequest.extra1).withRewardName(this.mRequest.rewardName).withRewardAmount(this.mRequest.rewardAmount).withUserId(this.mRequest.userId).withQuery(this.mRequest.query);
                AdRequest adRequest = this.mRequest;
                final WasmRewardPresenter wasmRewardPresenter = new WasmRewardPresenter(this.mContext, builderWithQuery.withExpressViewAcceptedSize(adRequest.expressViewAcceptedWidth, adRequest.expressViewAcceptedHeight).withFromChangeAd(true).withChangeAdTimes(this.mChangeAdTimes).withMinaId(this.mRequest.minaId).build());
                wasmRewardPresenter.setInteractionListener(this.mInteractionListener, this.mCallbackAd);
                LoadCallback loadCallback = new LoadCallback() { // from class: com.tapsdk.tapad.internal.WasmRewardPresenter.3
                    @Override // com.tapsdk.tapad.internal.WasmRewardPresenter.LoadCallback
                    public void onError(Exception exc, boolean z3) {
                        WasmRewardPresenter.this.handleChangeAdLoadError(wasmRewardPresenter, exc);
                    }

                    @Override // com.tapsdk.tapad.internal.WasmRewardPresenter.LoadCallback
                    public void onReady(WasmRewardPresenter wasmRewardPresenter2) {
                        WasmRewardPresenter.this.handleChangeAdReady(wasmRewardPresenter, wasmRewardPresenter2);
                    }
                };
                try {
                    synchronized (this.mChangeAdLock) {
                        try {
                            if (this.mDisposed || !this.mChangingAd) {
                                z = false;
                            } else {
                                this.mNextPresenter = wasmRewardPresenter;
                                wasmRewardPresenter.prepare(loadCallback);
                                z = true;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (z) {
                        return;
                    }
                    wasmRewardPresenter.dispose();
                } catch (Throwable th2) {
                    synchronized (this.mChangeAdLock) {
                        if (this.mNextPresenter == wasmRewardPresenter) {
                            this.mNextPresenter = null;
                            this.mChangingAd = false;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            wasmRewardPresenter.dispose();
                        }
                        if (!z2 || this.mDisposed) {
                            return;
                        }
                        reportChangeAdResult(false, ErrorCodeEnum.INTERNAL_ERROR.getCode(), loadErrorMessage(new RuntimeException("change-ad prepare failed", th2)));
                    }
                }
            }
        }
    }

    private void handleChangeAdDispatchFailure(boolean z) {
        synchronized (this.mChangeAdLock) {
            this.mChangingAd = false;
            if (!z) {
                this.mPendingDispose = false;
            } else if (!this.mChangeAdDisposeScheduled) {
                this.mPendingDispose = true;
            }
        }
        handleAdClose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChangeAdLoadError(WasmRewardPresenter wasmRewardPresenter, Exception exc) {
        if (releasePendingChangeAd(wasmRewardPresenter)) {
            wasmRewardPresenter.dispose();
            reportChangeAdResult(false, resolvePublicLoadErrorCode(exc, ErrorCodeEnum.INTERNAL_ERROR.getCode()), loadErrorMessage(exc));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChangeAdReady(WasmRewardPresenter wasmRewardPresenter, WasmRewardPresenter wasmRewardPresenter2) {
        WasmAdInstance wasmAdInstanceInstance;
        boolean z;
        boolean z2;
        if (wasmRewardPresenter2 == wasmRewardPresenter && ownsPendingChangeAd(wasmRewardPresenter)) {
            Activity activity = this.mActivityRef.get();
            if ((activity != null ? wasmRewardPresenter2.tryShowRewardVideoAd(activity) : ShowOutcome.REJECTED) != ShowOutcome.STARTED) {
                if (releasePendingChangeAd(wasmRewardPresenter)) {
                    wasmRewardPresenter2.dispose();
                    reportChangeAdResult(false, -1, "");
                    return;
                }
                return;
            }
            synchronized (this.mChangeAdLock) {
                wasmAdInstanceInstance = null;
                if (this.mDisposed || this.mNextPresenter != wasmRewardPresenter) {
                    z = false;
                    z2 = false;
                } else {
                    TapRewardVideoAd tapRewardVideoAd = this.mCallbackAd;
                    if (!(tapRewardVideoAd instanceof AdapterRewardVideoAd) || ((AdapterRewardVideoAd) tapRewardVideoAd).rebind(wasmRewardPresenter2)) {
                        this.mNextPresenter = null;
                        this.mInteractionListener = null;
                        this.mCallbackAd = null;
                        this.mPendingDispose = true;
                        wasmAdInstanceInstance = instance();
                        z2 = false;
                        z = true;
                    } else {
                        this.mNextPresenter = null;
                        this.mChangingAd = false;
                        z = false;
                        z2 = true;
                    }
                }
            }
            if (z) {
                if (wasmAdInstanceInstance != null) {
                    DirichletRuntime.getInstance().registerCallback(wasmAdInstanceInstance.instanceId(), new WasmRewardPresenter$$ExternalSyntheticLambda5(this));
                }
                reportChangeAdResult(true, 0, "");
            } else if (z2) {
                wasmRewardPresenter2.dispose();
            }
        }
    }

    private void handleFallbackTerminal(String str) {
        if (this.mDisposed || this.mTerminalPresentationErrorHandled) {
            return;
        }
        int iOptInt = 2;
        try {
            if (str == null) {
                str = "{}";
            }
            iOptInt = new JSONObject(str).optInt("outcome", 2);
        } catch (Exception e) {
        }
        this.mFallbackTakeoverPending = false;
        if (iOptInt == 1 || iOptInt == 3) {
            handleAdClose();
        } else {
            handleTerminalPresentationError();
        }
    }

    private void handleRewardLoaded(String str) {
        try {
            if (str == null) {
                str = "{}";
            }
            JSONObject jSONObject = new JSONObject(str);
            this.mPrice = jSONObject.optLong(IAction.PurchaseKey.Price, 0L);
            this.mTrackId = jSONObject.optString(EXTRA_ADN_TRACK_ID, "");
            if (TextUtils.isEmpty(this.mTrackId)) {
                this.mTrackId = jSONObject.optString(EXTRA_TRACK_ID, "");
            }
            updateMediaExtraInfo(jSONObject);
            notifyIoniaGetAdsEnrich();
        } catch (Throwable th) {
        }
        this.mReady = true;
        notifyLoadReady();
    }

    private void handleTerminalPresentationError() {
        if (this.mTerminalPresentationErrorHandled) {
            return;
        }
        this.mTerminalPresentationErrorHandled = true;
        this.mShowing = false;
        this.mReady = false;
        TapRewardVideoAd tapRewardVideoAd = this.mCallbackAd;
        TapRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.mInteractionListener;
        if (rewardAdInteractionListener != null && tapRewardVideoAd != null) {
            try {
                rewardAdInteractionListener.onVideoError(tapRewardVideoAd);
            } finally {
                if (this.mPendingDispose || this.mChangeAdDisposeScheduled) {
                    handleAdClose();
                } else {
                    dispose();
                }
            }
        }
    }

    private WasmAdInstance instance() {
        WasmAdInstance wasmAdInstance;
        synchronized (this.mInstanceLock) {
            wasmAdInstance = this.mInstanceRef.get();
        }
        if (wasmAdInstance == null || wasmAdInstance.isDisposed()) {
            return null;
        }
        return wasmAdInstance;
    }

    public static String loadErrorMessage(Exception exc) {
        return (exc == null || TextUtils.isEmpty(exc.getMessage())) ? ErrorCodeEnum.LOAD_FAILED.getDesc() : exc.getMessage();
    }

    private void loadPreferredRewardModule(final DirichletRuntime dirichletRuntime) {
        WasmCoreModuleLoader.load(dirichletRuntime, new WasmCoreModuleLoader.Callback() { // from class: com.tapsdk.tapad.internal.WasmRewardPresenter.1
            @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
            public void onError(Exception exc) {
                WasmRewardPresenter.this.notifyLoadError(exc);
            }

            @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
            public void onLoaded(WasmModule wasmModule) {
                WasmRewardPresenter.this.onRewardModuleLoaded(dirichletRuntime, wasmModule);
            }
        });
    }

    private static int normalizeCoreLoadErrorCode(int i) {
        if (i > 0) {
            return i;
        }
        if (i == 0) {
            return ErrorCodeEnum.NETWORK_ERROR.getCode();
        }
        return i == -2 ? ErrorCodeEnum.NO_AD_FILL.getCode() : ErrorCodeEnum.LOAD_FAILED.getCode();
    }

    private void notifyIoniaGetAdsEnrich() {
        String strAsString;
        synchronized (this.mMediaExtraInfo) {
            strAsString = asString(this.mMediaExtraInfo.get("req_uuid"));
        }
        IoniaIdentityManager.getInstance().enrichAfterGetAds(strAsString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLoadError(Exception exc) {
        WasmAdnLoadAttempt.FailureTiming failureTimingMarkFailed = this.mLoadAttempt.markFailed();
        if (failureTimingMarkFailed == WasmAdnLoadAttempt.FailureTiming.ALREADY_FAILED) {
            return;
        }
        m144lambda$notifyLoadErrorOnMain$5$comtapsdktapadinternalWasmRewardPresenter(exc, failureTimingMarkFailed == WasmAdnLoadAttempt.FailureTiming.BEFORE_AD_LOAD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: notifyLoadErrorOnMain, reason: merged with bridge method [inline-methods] */
    public void m144lambda$notifyLoadErrorOnMain$5$comtapsdktapadinternalWasmRewardPresenter(final Exception exc, final boolean z) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmRewardPresenter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m144lambda$notifyLoadErrorOnMain$5$comtapsdktapadinternalWasmRewardPresenter(exc, z);
                }
            });
            return;
        }
        if (this.mLoadFinished || this.mDisposed) {
            return;
        }
        this.mLoadFinished = true;
        this.mPreparing = false;
        cleanupFailedLoadInstance();
        LoadCallback loadCallback = this.mLoadCallback;
        this.mLoadCallback = null;
        if (loadCallback != null) {
            loadCallback.onError(exc, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLoadReady() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmRewardPresenter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.notifyLoadReady();
                }
            });
            return;
        }
        if (this.mLoadFinished || this.mDisposed) {
            return;
        }
        this.mLoadFinished = true;
        this.mPreparing = false;
        LoadCallback loadCallback = this.mLoadCallback;
        this.mLoadCallback = null;
        if (loadCallback != null) {
            loadCallback.onReady(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRewardModuleLoaded(final DirichletRuntime dirichletRuntime, final WasmModule wasmModule) {
        if (this.mDisposed || this.mLoadFinished || dirichletRuntime.runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmRewardPresenter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m145lambda$onRewardModuleLoaded$1$comtapsdktapadinternalWasmRewardPresenter(dirichletRuntime, wasmModule);
            }
        })) {
            return;
        }
        notifyLoadError(new IllegalStateException("wasm runtime queue unavailable"));
    }

    private boolean ownsPendingChangeAd(WasmRewardPresenter wasmRewardPresenter) {
        boolean z;
        synchronized (this.mChangeAdLock) {
            z = !this.mDisposed && this.mNextPresenter == wasmRewardPresenter;
        }
        return z;
    }

    public static ClientException parseLoadError(String str) {
        String strOptString;
        String desc;
        String str2 = "";
        int code = ErrorCodeEnum.LOAD_FAILED.getCode();
        try {
            if (str == null) {
                str = "{}";
            }
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(PluginConstants.KEY_ERROR_CODE)) {
                code = normalizeCoreLoadErrorCode(jSONObject.optInt(PluginConstants.KEY_ERROR_CODE, Integer.MIN_VALUE));
            }
            desc = jSONObject.optString("message", "");
            try {
                strOptString = jSONObject.optString("request_id", "");
                try {
                    if (TextUtils.isEmpty(desc)) {
                        String strOptString2 = jSONObject.optString("kind", "");
                        String strOptString3 = jSONObject.optString("function", "");
                        if (!TextUtils.isEmpty(strOptString2)) {
                            desc = TextUtils.isEmpty(strOptString3) ? strOptString2 : strOptString2 + " at " + strOptString3;
                        }
                    }
                } catch (Throwable th) {
                    str2 = desc;
                    desc = str2;
                }
            } catch (Throwable th2) {
                strOptString = "";
            }
        } catch (Throwable th3) {
            strOptString = "";
        }
        if (TextUtils.isEmpty(desc)) {
            desc = ErrorCodeEnum.fromCode(code).getDesc();
        }
        ClientException clientException = new ClientException(code, desc);
        clientException.requestId = strOptString;
        return clientException;
    }

    public static String preferredProcessAotAbi(String[] strArr) {
        return CoreModuleSelector.preferredProcessAotAbi(strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: prepareLoadedModule, reason: merged with bridge method [inline-methods] */
    public void m145lambda$onRewardModuleLoaded$1$comtapsdktapadinternalWasmRewardPresenter(DirichletRuntime dirichletRuntime, WasmModule wasmModule) {
        try {
            if (!this.mDisposed && !this.mLoadFinished) {
                String strFirstMissingInstanceExport = firstMissingInstanceExport(wasmModule);
                if (strFirstMissingInstanceExport != null) {
                    notifyLoadError(new IllegalStateException("required wasm instance export not found: ".concat(strFirstMissingInstanceExport)));
                    return;
                }
                WeakReference<WasmAdInstance> weakReferenceCreate = WasmAdInstance.create(wasmModule, new WasmRewardPresenter$$ExternalSyntheticLambda5(this));
                WasmAdInstance wasmAdInstance = weakReferenceCreate.get();
                if (wasmAdInstance == null) {
                    notifyLoadError(new RuntimeException("ad_create_instance failed"));
                    return;
                }
                synchronized (this.mInstanceLock) {
                    if (!this.mDisposed && !this.mLoadFinished) {
                        this.mInstanceRef = weakReferenceCreate;
                        dirichletRuntime.registerAdSurface(wasmAdInstance.instanceId(), wasmModule, this, this);
                        if (!AdnRuntimeBootstrap.getInstance().ensurePublisherInstalled(this.mContext, dirichletRuntime, wasmModule)) {
                            notifyLoadError(new IllegalStateException("ADN publisher is not initialized"));
                            return;
                        }
                        if (!this.mDisposed && !this.mLoadFinished) {
                            callAdLoad(wasmModule, wasmAdInstance.instanceId());
                            return;
                        }
                        return;
                    }
                    wasmAdInstance.dispose();
                }
            }
        } catch (Throwable th) {
            notifyLoadError(new RuntimeException("wasm reward prepare failed", th));
        }
    }

    private static void putIfAbsent(Map<String, Object> map, String str, Object obj) {
        if (map.containsKey(str)) {
            return;
        }
        map.put(str, obj);
    }

    private boolean releasePendingChangeAd(WasmRewardPresenter wasmRewardPresenter) {
        synchronized (this.mChangeAdLock) {
            if (!this.mDisposed && this.mNextPresenter == wasmRewardPresenter) {
                this.mNextPresenter = null;
                this.mChangingAd = false;
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Throwable] */
    private void reportChangeAdResult(boolean z, int i, String str) {
        int iActiveSurfaceIdForInstance;
        WasmAdInstance wasmAdInstanceInstance = instance();
        if (wasmAdInstanceInstance == null) {
            handleChangeAdDispatchFailure(z);
            return;
        }
        WasmModule wasmModuleModule = wasmAdInstanceInstance.module();
        boolean zHasFunction = wasmModuleModule.hasFunction(FN_CHANGE_AD_RESULT_SURFACE_INSTANCE);
        boolean zHasFunction2 = wasmModuleModule.hasFunction(FN_CHANGE_AD_RESULT_INSTANCE);
        if (!zHasFunction && !zHasFunction2) {
            handleChangeAdDispatchFailure(z);
            return;
        }
        if (zHasFunction) {
            try {
                iActiveSurfaceIdForInstance = DirichletRuntime.getInstance().surfaceSessions().activeSurfaceIdForInstance(wasmAdInstanceInstance.instanceId());
            } catch (Throwable th) {
                handleChangeAdDispatchFailure(z);
                return;
            }
        } else {
            iActiveSurfaceIdForInstance = -1;
        }
        if (iActiveSurfaceIdForInstance > 0) {
            wasmAdInstanceInstance.instanceId();
            wasmModuleModule.callVoid(FN_CHANGE_AD_RESULT_SURFACE_INSTANCE, Integer.valueOf(wasmAdInstanceInstance.instanceId()), Integer.valueOf(iActiveSurfaceIdForInstance), Integer.valueOf(z ? 1 : 0), Integer.valueOf(i), safe(str));
        } else if (!zHasFunction2) {
            handleChangeAdDispatchFailure(z);
        } else {
            wasmAdInstanceInstance.instanceId();
            wasmModuleModule.callVoid(FN_CHANGE_AD_RESULT_INSTANCE, Integer.valueOf(wasmAdInstanceInstance.instanceId()), Integer.valueOf(z ? 1 : 0), Integer.valueOf(i), safe(str));
        }
    }

    public static int resolvePublicLoadErrorCode(Exception exc, int i) {
        int i2;
        return (!(exc instanceof ClientException) || (i2 = ((ClientException) exc).code) <= 0) ? i : i2;
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    private void updateMediaExtraInfo(JSONObject jSONObject) {
        Map<? extends String, ? extends Object> mapFromLoadPayload = WasmAdMediaExtraInfo.fromLoadPayload(jSONObject);
        if (jSONObject.has(IAction.PurchaseKey.Price)) {
            mapFromLoadPayload.put(EXTRA_BID_PRICE, Long.valueOf(this.mPrice));
        }
        String strFirstNonEmpty = firstNonEmpty(asString(mapFromLoadPayload.get(EXTRA_ADN_TRACK_ID)), asString(mapFromLoadPayload.get(EXTRA_TRACK_ID)), jSONObject.optString(EXTRA_ADN_TRACK_ID, jSONObject.optString(EXTRA_TRACK_ID, "")));
        if (!TextUtils.isEmpty(strFirstNonEmpty)) {
            mapFromLoadPayload.put(EXTRA_ADN_TRACK_ID, strFirstNonEmpty);
        }
        String strFirstNonEmpty2 = firstNonEmpty(asString(mapFromLoadPayload.get("request_id")), jSONObject.optString("request_id", safe(this.mRequest.requestId)));
        if (!TextUtils.isEmpty(strFirstNonEmpty2)) {
            mapFromLoadPayload.put("request_id", strFirstNonEmpty2);
        }
        String strFirstNonEmpty3 = firstNonEmpty(asString(mapFromLoadPayload.get("req_uuid")), jSONObject.optString("req_uuid", ""));
        if (!TextUtils.isEmpty(strFirstNonEmpty3)) {
            mapFromLoadPayload.put("req_uuid", strFirstNonEmpty3);
            putIfAbsent(mapFromLoadPayload, EXTRA_TRACE_ID, strFirstNonEmpty3);
        } else if (!TextUtils.isEmpty(strFirstNonEmpty2)) {
            putIfAbsent(mapFromLoadPayload, EXTRA_TRACE_ID, strFirstNonEmpty2);
        }
        synchronized (this.mMediaExtraInfo) {
            this.mMediaExtraInfo.clear();
            this.mMediaExtraInfo.putAll(mapFromLoadPayload);
        }
    }

    public void dispose() {
        synchronized (this.mChangeAdLock) {
            if (this.mDisposed) {
                return;
            }
            this.mDisposed = true;
            this.mChangingAd = false;
            WasmRewardPresenter wasmRewardPresenter = this.mNextPresenter;
            this.mNextPresenter = null;
            if (wasmRewardPresenter != null && wasmRewardPresenter != this) {
                wasmRewardPresenter.dispose();
            }
            WasmAdInstance wasmAdInstanceDetachInstance = detachInstance();
            if (wasmAdInstanceDetachInstance != null) {
                wasmAdInstanceDetachInstance.dispose();
            }
            this.mLoadCallback = null;
            this.mInteractionListener = null;
            this.mCallbackAd = null;
            this.mReady = false;
            this.mShowing = false;
            this.mPreparing = false;
            this.mFallbackTakeoverPending = false;
        }
    }

    public Map<String, Object> getMediaExtraInfo() {
        HashMap map;
        synchronized (this.mMediaExtraInfo) {
            map = new HashMap(this.mMediaExtraInfo);
        }
        return map;
    }

    public long getPrice() {
        return this.mPrice;
    }

    @Override // com.tapsdk.tapad.internal.IoniaPlaybackSource
    public String ioniaTriggerCorrelationId() {
        String strSafe;
        synchronized (this.mMediaExtraInfo) {
            strSafe = safe(asString(this.mMediaExtraInfo.get("req_uuid")));
        }
        return strSafe;
    }

    @Override // com.tapsdk.tapad.internal.IoniaPlaybackSource
    public String ioniaWindowKey() {
        String strIoniaTriggerCorrelationId = ioniaTriggerCorrelationId();
        if (TextUtils.isEmpty(strIoniaTriggerCorrelationId)) {
            return "";
        }
        return !TextUtils.isEmpty(this.mTrackId) ? this.mTrackId : a.a(strIoniaTriggerCorrelationId, "#wasm_reward");
    }

    public boolean isReady() {
        WasmAdInstance wasmAdInstanceInstance = instance();
        if (!this.mShowing && !this.mDisposed && wasmAdInstanceInstance != null) {
            try {
                return wasmAdInstanceInstance.module().callIntSync(FN_AD_IS_READY_INSTANCE, Integer.valueOf(wasmAdInstanceInstance.instanceId())) == 1;
            } catch (Throwable th) {
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: lambda$prepare$0$com-tapsdk-tapad-internal-WasmRewardPresenter, reason: not valid java name */
    /* synthetic */ void m146lambda$prepare$0$comtapsdktapadinternalWasmRewardPresenter(LoadCallback loadCallback) {
        loadCallback.onReady(this);
    }

    /* JADX INFO: renamed from: lambda$tryShowRewardVideoAd$2$com-tapsdk-tapad-internal-WasmRewardPresenter, reason: not valid java name */
    /* synthetic */ void m147lambda$tryShowRewardVideoAd$2$comtapsdktapadinternalWasmRewardPresenter(int i) {
        this.mReady = i == 1;
    }

    /* JADX INFO: renamed from: lambda$tryShowRewardVideoAd$3$com-tapsdk-tapad-internal-WasmRewardPresenter, reason: not valid java name */
    /* synthetic */ void m148lambda$tryShowRewardVideoAd$3$comtapsdktapadinternalWasmRewardPresenter(WasmAdInstance wasmAdInstance, WasmModule wasmModule, int i) {
        if (i > 0) {
            return;
        }
        DirichletRuntime.getInstance().unregisterAdSurface(wasmAdInstance.instanceId());
        this.mShowing = false;
        wasmModule.callInt(FN_AD_IS_READY_INSTANCE, new WasmModule.IntCallback() { // from class: com.tapsdk.tapad.internal.WasmRewardPresenter$$ExternalSyntheticLambda2
            @Override // com.tapsdk.tapad.internal.runtime.WasmModule.IntCallback
            public final void onResult(int i2) {
                this.f$0.m147lambda$tryShowRewardVideoAd$2$comtapsdktapadinternalWasmRewardPresenter(i2);
            }
        }, Integer.valueOf(wasmAdInstance.instanceId()));
    }

    public void load(final TapAdNative.RewardVideoAdListener rewardVideoAdListener) {
        prepare(new LoadCallback() { // from class: com.tapsdk.tapad.internal.WasmRewardPresenter.2
            @Override // com.tapsdk.tapad.internal.WasmRewardPresenter.LoadCallback
            public void onError(Exception exc, boolean z) {
                TapAdNative.RewardVideoAdListener rewardVideoAdListener2 = rewardVideoAdListener;
                if (rewardVideoAdListener2 != null) {
                    rewardVideoAdListener2.onError(WasmRewardPresenter.resolvePublicLoadErrorCode(exc, ErrorCodeEnum.INTERNAL_ERROR.getCode()), WasmRewardPresenter.loadErrorMessage(exc));
                }
            }

            @Override // com.tapsdk.tapad.internal.WasmRewardPresenter.LoadCallback
            public void onReady(WasmRewardPresenter wasmRewardPresenter) {
                if (rewardVideoAdListener == null) {
                    return;
                }
                AdapterRewardVideoAd adapterRewardVideoAd = new AdapterRewardVideoAd(wasmRewardPresenter);
                WasmRewardPresenter.this.mCallbackAd = adapterRewardVideoAd;
                rewardVideoAdListener.onRewardVideoAdLoad(adapterRewardVideoAd);
                rewardVideoAdListener.onRewardVideoCached(adapterRewardVideoAd);
            }
        });
    }

    public void notifyVideoError(TapRewardVideoAd tapRewardVideoAd) {
        TapRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.mInteractionListener;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onVideoError(tapRewardVideoAd);
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.AdCallbackListener
    /* JADX INFO: renamed from: onCallback */
    public void m136lambda$onCallback$2$comtapsdktapadinternalWasmNativeFeedPresenter(String str, String str2) {
        if (this.mDisposed) {
            return;
        }
        if ("onRewardAdLoaded".equals(str)) {
            handleRewardLoaded(str2);
        }
        if ("onCorePresentationCommitted".equals(str)) {
            return;
        }
        if ("onCoreRuntimeFatal".equals(str)) {
            if (this.mDisposed || this.mTerminalPresentationErrorHandled) {
                return;
            }
            this.mFallbackTakeoverPending = true;
            return;
        }
        if ("onFallbackTakeoverStarted".equals(str)) {
            if (this.mDisposed || this.mTerminalPresentationErrorHandled) {
                return;
            }
            this.mFallbackTakeoverPending = true;
            return;
        }
        if ("onFallbackTerminal".equals(str)) {
            handleFallbackTerminal(str2);
            return;
        }
        if ("onRewardAdError".equals(str)) {
            notifyLoadError(parseLoadError(str2));
            return;
        }
        if ("onChangeAd".equals(str)) {
            handleChangeAd();
            return;
        }
        if ("onAdClose".equals(str)) {
            handleAdClose();
            return;
        }
        if ("onError".equals(str)) {
            if (this.mFallbackTakeoverPending) {
                return;
            }
            handleTerminalPresentationError();
            return;
        }
        TapRewardVideoAd tapRewardVideoAd = this.mCallbackAd;
        TapRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.mInteractionListener;
        if (rewardAdInteractionListener == null || tapRewardVideoAd == null) {
            return;
        }
        str.getClass();
        switch (str) {
            case "onRewardVerify":
                forwardRewardVerify(rewardAdInteractionListener, tapRewardVideoAd, str2);
                break;
            case "onVideoComplete":
                rewardAdInteractionListener.onVideoComplete(tapRewardVideoAd);
                break;
            case "onAdClick":
                rewardAdInteractionListener.onAdClick(tapRewardVideoAd);
                break;
            case "onAdValidShow":
                rewardAdInteractionListener.onAdValidShow(tapRewardVideoAd);
                break;
            case "onSkippedVideo":
                rewardAdInteractionListener.onSkippedVideo(tapRewardVideoAd);
                break;
            case "onAdShow":
                rewardAdInteractionListener.onAdShow(tapRewardVideoAd);
                break;
            case "onVideoError":
                this.mShowing = false;
                this.mReady = false;
                rewardAdInteractionListener.onVideoError(tapRewardVideoAd);
                break;
        }
    }

    public void prepare(final LoadCallback loadCallback) {
        this.mLoadCallback = loadCallback;
        if (this.mReady) {
            this.mLoadCallback = null;
            if (loadCallback != null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    loadCallback.onReady(this);
                    return;
                } else {
                    this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmRewardPresenter$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m146lambda$prepare$0$comtapsdktapadinternalWasmRewardPresenter(loadCallback);
                        }
                    });
                    return;
                }
            }
            return;
        }
        if (this.mLoadFinished) {
            this.mLoadCallback = null;
            if (loadCallback != null) {
                loadCallback.onError(new IllegalStateException("wasm reward load already finished"), false);
                return;
            }
            return;
        }
        if (this.mPreparing) {
            return;
        }
        this.mPreparing = true;
        loadPreferredRewardModule(DirichletRuntime.getInstance());
    }

    public boolean recordSynchronousLoadFailure() {
        return (this.mLoadFinished || this.mLoadAttempt.markFailed() == WasmAdnLoadAttempt.FailureTiming.ALREADY_FAILED) ? false : true;
    }

    public void reportBiddingResult(boolean z, Map<String, Object> map) {
        WasmAdInstance wasmAdInstanceInstance = instance();
        if (wasmAdInstanceInstance == null) {
            return;
        }
        WasmModule wasmModuleModule = wasmAdInstanceInstance.module();
        String str = z ? FN_AD_SEND_WIN_INSTANCE : FN_AD_SEND_LOSS_INSTANCE;
        try {
            if (wasmModuleModule.hasFunction(str)) {
                wasmModuleModule.callVoid(str, Integer.valueOf(wasmAdInstanceInstance.instanceId()), (map == null ? new JSONObject() : new JSONObject(map)).toString());
            }
        } catch (Throwable th) {
        }
    }

    public void setInteractionListener(TapRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, TapRewardVideoAd tapRewardVideoAd) {
        this.mInteractionListener = rewardAdInteractionListener;
        this.mCallbackAd = tapRewardVideoAd;
    }

    public boolean showRewardVideoAd(Activity activity) {
        return tryShowRewardVideoAd(activity) == ShowOutcome.STARTED;
    }

    public ShowOutcome tryShowRewardVideoAd(Activity activity) {
        if (!isReady()) {
            return ShowOutcome.REJECTED;
        }
        if (activity != null && (activity.isFinishing() || activity.isDestroyed())) {
            return ShowOutcome.FAILED_TO_START;
        }
        final WasmAdInstance wasmAdInstanceInstance = instance();
        if (wasmAdInstanceInstance == null) {
            return ShowOutcome.REJECTED;
        }
        final WasmModule wasmModuleModule = wasmAdInstanceInstance.module();
        try {
            if (!wasmModuleModule.hasFunction(FN_AD_PRESENT_INSTANCE)) {
                return ShowOutcome.FAILED_TO_START;
            }
            this.mActivityRef = new WeakReference<>(activity);
            DirichletRuntime.getInstance().registerAdSurface(wasmAdInstanceInstance.instanceId(), wasmModuleModule, this, this, activity);
            this.mShowing = true;
            this.mReady = false;
            wasmModuleModule.callInt(FN_AD_PRESENT_INSTANCE, new WasmModule.IntCallback() { // from class: com.tapsdk.tapad.internal.WasmRewardPresenter$$ExternalSyntheticLambda6
                @Override // com.tapsdk.tapad.internal.runtime.WasmModule.IntCallback
                public final void onResult(int i) {
                    this.f$0.m148lambda$tryShowRewardVideoAd$3$comtapsdktapadinternalWasmRewardPresenter(wasmAdInstanceInstance, wasmModuleModule, i);
                }
            }, Integer.valueOf(wasmAdInstanceInstance.instanceId()), Integer.valueOf(ShowHostFacts.forFullscreen(activity, true)));
            return ShowOutcome.STARTED;
        } catch (Throwable th) {
            this.mShowing = false;
            this.mReady = true;
            return ShowOutcome.FAILED_TO_START;
        }
    }

    public static String preferredProcessAotAbi(String[] strArr, Boolean bool) {
        return CoreModuleSelector.preferredProcessAotAbi(strArr, bool);
    }
}
