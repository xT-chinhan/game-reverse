package com.tapsdk.tapad.internal.runtime;

import android.R;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.byazt.fi.BaseConstants;
import com.byazt.mg.PluginConstants;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.C;
import com.tapsdk.tapad.a;
import com.tapsdk.tapad.c;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.observability.AdnTelemetryHost;
import com.tapsdk.tapad.internal.platform.AndroidEnvironmentHost;
import com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost;
import com.tapsdk.tapad.internal.runtime.download.AndroidDownloadRequest;
import com.tapsdk.tapad.internal.runtime.download.DownloadUtils;
import com.tapsdk.tapad.internal.runtime.file.WasmPrivateFileApi;
import com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader;
import com.tapsdk.tapad.internal.runtime.install.AndroidInstallHost;
import com.tapsdk.tapad.internal.runtime.plugin.AdCallbackListener;
import com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer;
import com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity;
import com.tapsdk.tapad.internal.runtime.plugin.stub.WasmAdSurfaceHost;
import com.tapsdk.tapad.internal.runtime.shake.ShakeManager;
import com.tapsdk.tapad.internal.runtime.storage.WasmSharedPreferenceApi;
import com.tapsdk.tapad.internal.shortcut.ShortcutPinCallback;
import com.tapsdk.tapad.internal.shortcut.ShortcutPinHandle;
import com.tapsdk.tapad.internal.shortcut.ShortcutPinIcon;
import com.tapsdk.tapad.internal.shortcut.ShortcutPinManager;
import com.tapsdk.tapad.internal.shortcut.ShortcutPinOptions;
import com.tapsdk.tapad.internal.shortcut.ShortcutPinRequest;
import com.tapsdk.tapad.internal.shortcut.ShortcutPinResult;
import com.tapsdk.tapad.internal.shortcut.ShortcutPinSource;
import com.tapsdk.tapad.internal.shortcut.ShortcutPinStatus;
import com.tapsdk.tapad.internal.utils.AdnDeviceManager;
import com.tapsdk.tapad.internal.utils.WXUtil;
import com.taptap.sdk.compliance.bean.IdentityVerifyStateKt;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.LongCompanionObject;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class HostAPIImpl {
    private static final long APK_RELATIVE_EXPIRY_CUTOFF_SECONDS = 946656000;
    private static final String CALLBACK_ADN_DEVICE_UPDATED = "onAdnDidUpdated";
    private static final String DOWNLOAD_EXECUTION_PLAN_FIELD = "downloadExecutionPlan";
    private static final int DOWNLOAD_EXECUTION_PLAN_VERSION = 1;
    static final int DOWNLOAD_POLICY_REJECTED = -2;
    private static final int HAPTIC_FEEDBACK = 0;
    private static final int HAPTIC_VIBRATE = 1;
    private static final int HAPTIC_VIBRATE_CANCEL = 2;
    private static final int MAX_ADVANCED_DOWNLOAD_CONFIG_CHARS = 524288;
    private static final int NAV_GET_FEATURE_FLAG_I32 = 8;
    private static final int NAV_IS_INSTALLED = 5;
    private static final int NAV_OPEN_AD_INTERACTION = 6;
    private static final int NAV_OPEN_APP = 4;
    private static final int NAV_OPEN_APP_STORE = 1;
    private static final int NAV_OPEN_DEEP_LINK = 2;
    private static final int NAV_OPEN_MINI_PROGRAM = 9;
    private static final int NAV_OPEN_URL = 0;
    private static final int NAV_PIN_SHORTCUT = 10;
    private static final int NAV_SHOW_TOAST = 7;
    private static final int NEGOTIATED_DOWNLOAD_CONNECT_TIMEOUT_MS = 30000;
    private static final int NEGOTIATED_DOWNLOAD_READ_TIMEOUT_MS = 60000;
    private static final int SHAKE_CONFIG = 0;
    private static final int SHAKE_IS_ACTIVE = 4;
    private static final int SHAKE_RESET = 3;
    private static final int SHAKE_START = 1;
    private static final int SHAKE_STOP = 2;
    private static final String SHORTCUT_ERROR_CANNOT_CREATE = "Shortcut cannot be created.";
    private static final String SHORTCUT_ERROR_PIN_NOT_COMPLETED = "Shortcut pinning was not completed.";
    private static final long SHORTCUT_FOCUS_FALLBACK_DELAY_MS = 1500;
    private static final int SHORTCUT_PIN_ATTEMPT = 1;
    private static final String TAG = "HostAPI";
    private static final int VIDEO_RETRY_PROGRESS_SENTINEL = -1;
    private static final long VIEW_QUERY_CACHE_TTL_MS = 16;
    private final SparseArray<AdSurfaceBinding> mAdSurfaceBindings;
    private final AssetTransferExecutor mAssetTransferExecutor;
    private final CallbackRegistry mCallbackRegistry;
    private final Context mContext;
    private final AndroidDownloadHost mDownloadHost;
    private final DownloadInteractionReporter mDownloadInteractionReporter;
    private final AndroidEnvironmentHost mEnvironmentHost;
    private Runnable mHapticCancelRunnable;
    private Vibrator mHapticVibrator;
    private final HttpClient mHttpClient;
    private final AndroidInstallHost mInstallHost;
    private int mLastTouchXDp10;
    private int mLastTouchYDp10;
    private final Handler mMainHandler;
    private int mNextOverlayId;
    private volatile Set<String> mPreviewHttpAllowedHosts;
    private final Runnable mPrivacyChanged;
    private ShakeManager mShakeManager;
    private final Object mShortcutIconTargetLock;
    private final List<MechanicalImageLoader.Request> mShortcutIconTargets;
    private final Object mShortcutPinSessionLock;
    private final List<ShortcutPinSession> mShortcutPinSessions;
    private final SurfaceSessionRegistry mSurfaceSessions;
    private final Object mVideoOwnerLock;
    private final SparseArray<VideoOwner> mVideoOwnersByHandle;
    private final VideoPlayer mVideoPlayer;
    private int mViewQueryCacheHandle;
    private final float[] mViewQueryCachePayload;
    private ViewRenderer mViewQueryCacheRenderer;
    private int mViewQueryCacheSurfaceId;
    private long mViewQueryCacheTimeMs;

    public static final class AdSurfaceBinding {
        final Object adImpl;
        final AdCallbackListener callbackListener;
        final WeakReference<Activity> callerActivity;
        final boolean callerActivityRequired;
        final WasmModule module;

        public AdSurfaceBinding(WasmModule wasmModule, Object obj, AdCallbackListener adCallbackListener, Activity activity) {
            this.module = wasmModule;
            this.adImpl = obj;
            this.callbackListener = adCallbackListener;
            this.callerActivityRequired = activity != null;
            this.callerActivity = new WeakReference<>(activity);
        }
    }

    public static final class AdvancedDownloadUrls {
        final boolean rawExpiryProvided;
        final boolean rawList;
        final List<String> urls = new ArrayList();
        final List<Long> deadlines = new ArrayList();

        public AdvancedDownloadUrls(boolean z, boolean z2) {
            this.rawList = z;
            this.rawExpiryProvided = z2;
        }
    }

    public interface DownloadInteractionReporter {
        void report(JSONObject jSONObject, int i);
    }

    public static final class InteractionOwner {
        final int instanceId;
        final int sessionId;
        final int surfaceId;

        public InteractionOwner(int i, int i2, int i3) {
            this.sessionId = i;
            this.instanceId = i2;
            this.surfaceId = i3;
        }
    }

    public interface RendererOperation {
        void run(ViewRenderer viewRenderer);
    }

    public static final class RendererSnapshot {
        final int instanceId;
        final ViewRenderer renderer;
        final int surfaceId;

        public RendererSnapshot(int i, ViewRenderer viewRenderer, int i2) {
            this.surfaceId = i;
            this.renderer = viewRenderer;
            this.instanceId = i2;
        }
    }

    public static final class ShortcutPinSession {
        boolean dispatched;
        Runnable focusFallbackRunnable;
        ShortcutPinHandle handle;
        final InteractionOwner owner;
        final JSONObject payload;
        final String shortcutId;
        final long startedAtMs;

        public ShortcutPinSession(JSONObject jSONObject, InteractionOwner interactionOwner, String str, long j) {
            this.payload = jSONObject;
            this.owner = interactionOwner;
            this.shortcutId = str;
            this.startedAtMs = j;
        }
    }

    public static final class UnsupportedDownloadPlanException extends Exception {
        public UnsupportedDownloadPlanException(String str) {
            super(str);
        }
    }

    public static final class VideoOwner {
        final ViewRenderer renderer;
        final int surfaceId;

        public VideoOwner(int i, ViewRenderer viewRenderer) {
            this.surfaceId = i;
            this.renderer = viewRenderer;
        }
    }

    public HostAPIImpl(Context context, SurfaceSessionRegistry surfaceSessionRegistry) {
        this(context, surfaceSessionRegistry, null);
    }

    private int allocateOverlayId() {
        if (this.mNextOverlayId == Integer.MAX_VALUE) {
            this.mNextOverlayId = 1;
        }
        int i = this.mNextOverlayId;
        this.mNextOverlayId = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: attachVideo, reason: merged with bridge method [inline-methods] */
    public void m231lambda$videoAttachToView$30$comtapsdktapadinternalruntimeHostAPIImpl(final int i, int i2, RendererSnapshot rendererSnapshot) {
        boolean z;
        View.OnTouchListener onTouchListener;
        View.OnClickListener onClickListener;
        if (isRendererAlive(rendererSnapshot)) {
            final ViewRenderer viewRenderer = rendererSnapshot.renderer;
            if (isVideoOwnedBySnapshot(i, rendererSnapshot)) {
                final View view = viewRenderer.getView(i2);
                View viewAcquireViewForMount = this.mVideoPlayer.acquireViewForMount(i);
                if (!(view instanceof ViewGroup) || viewAcquireViewForMount == null) {
                    m210lambda$attachVideo$33$comtapsdktapadinternalruntimeHostAPIImpl(i, viewRenderer);
                    return;
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
                if (view.isClickable()) {
                    final float f = view.getResources().getDisplayMetrics().density;
                    View.OnTouchListener onTouchListener2 = new View.OnTouchListener() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda4
                        @Override // android.view.View.OnTouchListener
                        public final boolean onTouch(View view2, MotionEvent motionEvent) {
                            return this.f$0.m209lambda$attachVideo$31$comtapsdktapadinternalruntimeHostAPIImpl(f, view2, motionEvent);
                        }
                    };
                    z = true;
                    onClickListener = new View.OnClickListener() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            view.performClick();
                        }
                    };
                    onTouchListener = onTouchListener2;
                } else {
                    z = false;
                    onTouchListener = null;
                    onClickListener = null;
                }
                if (viewRenderer.attachVideoView(i2, i, viewAcquireViewForMount, layoutParams, onTouchListener, onClickListener, z, new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m210lambda$attachVideo$33$comtapsdktapadinternalruntimeHostAPIImpl(i, viewRenderer);
                    }
                })) {
                    return;
                }
                m210lambda$attachVideo$33$comtapsdktapadinternalruntimeHostAPIImpl(i, viewRenderer);
            }
        }
    }

    private static int boundedPositiveTimeout(int i, int i2) {
        return i > 0 ? Math.min(i, i2) : i2;
    }

    private JSONObject buildHostEnvSnapshot(JSONObject jSONObject) {
        return this.mEnvironmentHost.snapshot(jSONObject);
    }

    private ShortcutPinRequest buildShortcutPinRequest(JSONObject jSONObject, Intent intent, ShortcutPinIcon shortcutPinIcon) {
        ShortcutPinRequest.Builder builder = new ShortcutPinRequest.Builder(jSONObject.optString("id", ""), jSONObject.optString("shortLabel", ""), intent, shortcutPinIcon);
        String strOptString = jSONObject.optString("longLabel", "");
        if (!TextUtils.isEmpty(strOptString)) {
            builder.setLongLabel(strOptString);
        }
        String strOptString2 = jSONObject.optString("disabledMessage", "");
        if (!TextUtils.isEmpty(strOptString2)) {
            builder.setDisabledMessage(strOptString2);
        }
        return builder.build();
    }

    private void cancelHapticVibration() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            cancelHapticVibrationNow();
        } else {
            this.mMainHandler.post(new HostAPIImpl$$ExternalSyntheticLambda59(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelHapticVibrationNow() {
        Runnable runnable = this.mHapticCancelRunnable;
        if (runnable != null) {
            this.mMainHandler.removeCallbacks(runnable);
            this.mHapticCancelRunnable = null;
        }
        Vibrator vibrator = this.mHapticVibrator;
        if (vibrator != null) {
            try {
                vibrator.cancel();
            } catch (Throwable th) {
            }
            this.mHapticVibrator = null;
        }
    }

    private void cancelShortcutPinSessions() {
        ShortcutPinHandle shortcutPinHandle;
        Runnable runnable;
        synchronized (this.mShortcutPinSessionLock) {
            if (this.mShortcutPinSessions.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.mShortcutPinSessions);
            this.mShortcutPinSessions.clear();
            int i = 0;
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ShortcutPinSession shortcutPinSession = (ShortcutPinSession) obj;
                synchronized (shortcutPinSession) {
                    shortcutPinSession.dispatched = true;
                    shortcutPinHandle = shortcutPinSession.handle;
                    shortcutPinSession.handle = null;
                    runnable = shortcutPinSession.focusFallbackRunnable;
                    shortcutPinSession.focusFallbackRunnable = null;
                }
                if (runnable != null) {
                    this.mMainHandler.removeCallbacks(runnable);
                }
                if (shortcutPinHandle != null) {
                    shortcutPinHandle.cancel();
                }
            }
        }
    }

    private void clearPendingShortcutIconLoads() {
        synchronized (this.mShortcutIconTargetLock) {
            if (this.mShortcutIconTargets.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.mShortcutIconTargets);
            this.mShortcutIconTargets.clear();
            int i = 0;
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((MechanicalImageLoader.Request) obj).cancel();
            }
        }
    }

    private void clearViewQueryCache() {
        this.mViewQueryCacheSurfaceId = -1;
        this.mViewQueryCacheHandle = -1;
        this.mViewQueryCacheRenderer = null;
        this.mViewQueryCacheTimeMs = 0L;
    }

    private void clearViewQueryCacheForSurface(int i, ViewRenderer viewRenderer) {
        if (this.mViewQueryCacheSurfaceId != i) {
            return;
        }
        if (viewRenderer == null || this.mViewQueryCacheRenderer == viewRenderer) {
            clearViewQueryCache();
        }
    }

    private void completeShortcutPinFailure(ShortcutPinSession shortcutPinSession, String str, String str2, int i) {
        synchronized (shortcutPinSession) {
            if (shortcutPinSession.dispatched) {
                return;
            }
            shortcutPinSession.dispatched = true;
            ShortcutPinHandle shortcutPinHandle = shortcutPinSession.handle;
            shortcutPinSession.handle = null;
            Runnable runnable = shortcutPinSession.focusFallbackRunnable;
            shortcutPinSession.focusFallbackRunnable = null;
            if (runnable != null) {
                this.mMainHandler.removeCallbacks(runnable);
            }
            if (shortcutPinHandle != null) {
                shortcutPinHandle.cancel();
            }
            releaseShortcutPinSession(shortcutPinSession);
            trackShortcutPinFallbackResult(shortcutPinSession.payload, str, str2, Long.valueOf(System.currentTimeMillis() - shortcutPinSession.startedAtMs));
            dispatchInteraction(shortcutPinSession.owner, 1, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeShortcutPinSession(ShortcutPinSession shortcutPinSession, ShortcutPinResult shortcutPinResult) {
        synchronized (shortcutPinSession) {
            if (shortcutPinSession.dispatched) {
                return;
            }
            shortcutPinSession.dispatched = true;
            ShortcutPinHandle shortcutPinHandle = shortcutPinSession.handle;
            shortcutPinSession.handle = null;
            Runnable runnable = shortcutPinSession.focusFallbackRunnable;
            shortcutPinSession.focusFallbackRunnable = null;
            if (runnable != null) {
                this.mMainHandler.removeCallbacks(runnable);
            }
            if (shortcutPinHandle != null) {
                shortcutPinHandle.cancel();
            }
            releaseShortcutPinSession(shortcutPinSession);
            trackShortcutPinResult(shortcutPinSession.payload, shortcutPinResult, System.currentTimeMillis() - shortcutPinSession.startedAtMs);
            dispatchInteraction(shortcutPinSession.owner, shortcutPinResult.isSuccess() ? 4 : 1, shortcutPinResult.getStatus().ordinal());
        }
    }

    private int copyEnvResult(JSONObject jSONObject, byte[] bArr) {
        byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
        if (bArr == null || bArr.length == 0) {
            return bytes.length;
        }
        if (bArr.length < bytes.length) {
            return bytes.length;
        }
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        return bytes.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: destroyVideoForRenderer, reason: merged with bridge method [inline-methods] */
    public void m210lambda$attachVideo$33$comtapsdktapadinternalruntimeHostAPIImpl(final int i, final ViewRenderer viewRenderer) {
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda45
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m212lambda$destroyVideoForRenderer$34$comtapsdktapadinternalruntimeHostAPIImpl(i, viewRenderer);
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.mMainHandler.post(runnable);
        }
    }

    private void destroyVideoHandleAndDetachView(int i, ViewRenderer viewRenderer) {
        destroyVideoHandleNow(i);
        if (viewRenderer != null) {
            viewRenderer.detachVideoView(i);
        }
    }

    private void destroyVideoHandleNow(int i) {
        this.mVideoPlayer.destroy(i);
        this.mCallbackRegistry.unregisterAll(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchHttpResponse(int i, int i2, int i3, String str, byte[] bArr) {
        if (i <= 0) {
            return;
        }
        DirichletRuntime.getInstance().dispatchHttpResponse(i, i2, i3, str != null ? str : "", bArr != null ? bArr : new byte[0]);
    }

    private void dispatchInteraction(InteractionOwner interactionOwner, int i, int i2) {
        int i3;
        if (interactionOwner == null || interactionOwner.sessionId <= 0) {
            return;
        }
        DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        int i4 = interactionOwner.instanceId;
        if (i4 <= 0 || (i3 = interactionOwner.surfaceId) <= 0) {
            dirichletRuntime.triggerInteractionEvent(i, interactionOwner.sessionId, i2);
        } else {
            dirichletRuntime.triggerInteractionEvent(i4, i3, i, interactionOwner.sessionId, i2);
        }
    }

    private void dispatchInteractionOpenResult(String str, int i) {
        int i2;
        InteractionOwner interactionOwnerExtractInteractionOwner = extractInteractionOwner(str);
        int i3 = interactionOwnerExtractInteractionOwner.sessionId;
        if (i3 <= 0) {
            return;
        }
        DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        int i4 = i > 0 ? 0 : 1;
        int i5 = interactionOwnerExtractInteractionOwner.instanceId;
        if (i5 > 0 && (i2 = interactionOwnerExtractInteractionOwner.surfaceId) > 0) {
            dirichletRuntime.triggerInteractionEvent(i5, i2, i4, i3, i > 0 ? 1 : i);
            return;
        }
        if (i > 0) {
            i = 1;
        }
        dirichletRuntime.triggerInteractionEvent(i4, i3, i);
    }

    private int downloadStartAdvanced(String str, int i) {
        String str2 = "headers";
        if (str != null && str.length() <= 524288) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                AdvancedDownloadUrls advancedDownloadUrlsNormalizeAdvancedDownloadUrls = normalizeAdvancedDownloadUrls(jSONObject);
                if (!hasSafeAdvancedDownloadFileName(jSONObject)) {
                    return -1;
                }
                int downloadCompletionToken = parseDownloadCompletionToken(jSONObject);
                AndroidDownloadRequest.Builder builderTargetDirectory = new AndroidDownloadRequest.Builder().targetDirectory(this.mDownloadHost.getDefaultDirectory().getAbsolutePath());
                int i2 = 0;
                while (i2 < advancedDownloadUrlsNormalizeAdvancedDownloadUrls.urls.size()) {
                    try {
                        builderTargetDirectory.url(advancedDownloadUrlsNormalizeAdvancedDownloadUrls.urls.get(i2), advancedDownloadUrlsNormalizeAdvancedDownloadUrls.deadlines.get(i2).longValue());
                        i2++;
                        downloadCompletionToken = downloadCompletionToken;
                        str2 = str2;
                    } catch (UnsupportedDownloadPlanException e) {
                        e = e;
                    } catch (Exception e2) {
                        e = e2;
                        e.getMessage();
                        return -1;
                    }
                }
                String str3 = str2;
                int i3 = downloadCompletionToken;
                if (advancedDownloadUrlsNormalizeAdvancedDownloadUrls.rawList) {
                    builderTargetDirectory.resumable(false);
                }
                if (jSONObject.has("fileName")) {
                    builderTargetDirectory.fileName(jSONObject.getString("fileName"));
                }
                if (jSONObject.has("md5")) {
                    builderTargetDirectory.md5(jSONObject.getString("md5"));
                }
                if (jSONObject.has("expectedSize")) {
                    builderTargetDirectory.expectedSize(jSONObject.getLong("expectedSize"));
                }
                if (jSONObject.has("apkVerifyType")) {
                    builderTargetDirectory.apkVerifyType(jSONObject.getInt("apkVerifyType"));
                }
                if (jSONObject.has("resumable") && !advancedDownloadUrlsNormalizeAdvancedDownloadUrls.rawList) {
                    builderTargetDirectory.resumable(jSONObject.getBoolean("resumable"));
                }
                if (jSONObject.has("connectTimeout")) {
                    builderTargetDirectory.connectTimeout(jSONObject.getInt("connectTimeout"));
                }
                if (jSONObject.has("readTimeout")) {
                    builderTargetDirectory.readTimeout(jSONObject.getInt("readTimeout"));
                }
                if (jSONObject.has("maxRetries")) {
                    builderTargetDirectory.maxRetries(jSONObject.getInt("maxRetries"));
                }
                if (jSONObject.has(str3)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str3);
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        builderTargetDirectory.header(next, jSONObject2.getString(next));
                    }
                }
                if (advancedDownloadUrlsNormalizeAdvancedDownloadUrls.rawExpiryProvided) {
                    builderTargetDirectory.connectTimeout(boundedPositiveTimeout(jSONObject.optInt("connectTimeout", NEGOTIATED_DOWNLOAD_CONNECT_TIMEOUT_MS), NEGOTIATED_DOWNLOAD_CONNECT_TIMEOUT_MS));
                    builderTargetDirectory.readTimeout(boundedPositiveTimeout(jSONObject.optInt("readTimeout", 60000), 60000));
                }
                int iStart = this.mDownloadHost.start(builderTargetDirectory.build(), i, new AndroidDownloadHost.NotificationSpec(jSONObject.optString(BundleKey.TITLE, "下载中"), jSONObject.optString("iconUrl", "")), runtimeDownloadObserver(i3));
                reportDownloadInteractionSafely(jSONObject, iStart);
                return iStart;
            } catch (UnsupportedDownloadPlanException e3) {
                e = e3;
            } catch (Exception e4) {
                e = e4;
            }
            e.getMessage();
            return -2;
        }
        return -1;
    }

    private String extractDeepLinkTargetPackage(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strOptString = new JSONObject(str).optString("targetPackageName", "");
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            return strOptString;
        } catch (Throwable th) {
            return null;
        }
    }

    private InteractionOwner extractInteractionOwner(String str) {
        if (TextUtils.isEmpty(str)) {
            return new InteractionOwner(-1, -1, -1);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new InteractionOwner(jSONObject.optInt("sessionId", -1), jSONObject.optInt("instanceId", -1), jSONObject.optInt("surfaceId", -1));
        } catch (Throwable th) {
            return new InteractionOwner(-1, -1, -1);
        }
    }

    private boolean hasPermission(String str) {
        try {
            return Build.VERSION.SDK_INT < 23 || this.mContext.checkSelfPermission(str) == 0;
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean hasSafeAdvancedDownloadFileName(JSONObject jSONObject) {
        String strExtractFileName;
        try {
            String string = null;
            if (jSONObject.has("fileName")) {
                Object obj = jSONObject.get("fileName");
                if (!(obj instanceof String)) {
                    return false;
                }
                strExtractFileName = (String) obj;
            } else {
                strExtractFileName = null;
            }
            if (TextUtils.isEmpty(strExtractFileName)) {
                if (jSONObject.has("urls")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("urls");
                    if (jSONArray.length() > 0) {
                        string = jSONArray.getString(0);
                    }
                } else if (jSONObject.has(BreakpointSQLiteKey.URL)) {
                    string = jSONObject.getString(BreakpointSQLiteKey.URL);
                }
                if (TextUtils.isEmpty(string)) {
                    return true;
                }
                strExtractFileName = DownloadUtils.extractFileName(string);
            }
            if (!strExtractFileName.contains("/") && !strExtractFileName.contains("\\") && !strExtractFileName.contains("\u0000") && !".".equals(strExtractFileName) && !"..".equals(strExtractFileName)) {
                File canonicalFile = this.mDownloadHost.getDefaultDirectory().getCanonicalFile();
                File canonicalFile2 = new File(canonicalFile, strExtractFileName).getCanonicalFile();
                if (canonicalFile.equals(canonicalFile2.getParentFile()) && strExtractFileName.equals(canonicalFile2.getName())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean hasShortcutSurfaceWindowFocus(InteractionOwner interactionOwner) {
        int i;
        if (interactionOwner != null && (i = interactionOwner.surfaceId) > 0) {
            try {
                SurfaceSession live = this.mSurfaceSessions.getLive(i);
                if (live == null) {
                    return true;
                }
                ViewRenderer viewRendererRenderer = live.renderer();
                if (viewRendererRenderer == null) {
                    return false;
                }
                if (viewRendererRenderer instanceof DefaultViewRenderer) {
                    return ((DefaultViewRenderer) viewRendererRenderer).hasActiveWindowFocus();
                }
                int viewByID = viewRendererRenderer.getViewByID("root");
                View view = viewByID >= 0 ? viewRendererRenderer.getView(viewByID) : null;
                if (view == null) {
                    return false;
                }
                if (view.hasWindowFocus()) {
                    return true;
                }
                View rootView = view.getRootView();
                return (rootView == null || rootView == view || !rootView.hasWindowFocus()) ? false : true;
            } catch (Throwable th) {
            }
        }
        return true;
    }

    private boolean hasVibratePermission() {
        try {
            return this.mContext.checkCallingOrSelfPermission("android.permission.VIBRATE") == 0;
        } catch (Throwable th) {
            return false;
        }
    }

    private int hostFeatureBitset() {
        return 57343;
    }

    private void initHttpClient() {
        this.mHttpClient.setCallback(new HttpClient.ResponseCallback() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl.1
            @Override // com.tapsdk.tapad.internal.runtime.HttpClient.ResponseCallback
            public void onComplete(int i, int i2, int i3, String str, byte[] bArr) {
                HostAPIImpl.this.dispatchHttpResponse(i, i2, i3, str, bArr);
            }
        });
    }

    private void initVideoPlayer() {
        this.mVideoPlayer.setProgressCallback(new VideoPlayer.ProgressCallback() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda46
            @Override // com.tapsdk.tapad.internal.runtime.VideoPlayer.ProgressCallback
            public final void onProgress(int i, float f, float f2) {
                this.f$0.m213lambda$initVideoPlayer$3$comtapsdktapadinternalruntimeHostAPIImpl(i, f, f2);
            }
        });
        this.mVideoPlayer.setCompleteCallback(new VideoPlayer.CompleteCallback() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda47
            @Override // com.tapsdk.tapad.internal.runtime.VideoPlayer.CompleteCallback
            public final void onComplete(int i) {
                this.f$0.m214lambda$initVideoPlayer$4$comtapsdktapadinternalruntimeHostAPIImpl(i);
            }
        });
        this.mVideoPlayer.setErrorCallback(new VideoPlayer.ErrorCallback() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda48
            @Override // com.tapsdk.tapad.internal.runtime.VideoPlayer.ErrorCallback
            public final void onError(int i, int i2, String str) {
                this.f$0.m215lambda$initVideoPlayer$5$comtapsdktapadinternalruntimeHostAPIImpl(i, i2, str);
            }
        });
        this.mVideoPlayer.setRetryCallback(new VideoPlayer.RetryCallback() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda49
            @Override // com.tapsdk.tapad.internal.runtime.VideoPlayer.RetryCallback
            public final void onRetry(int i, int i2, String str) {
                this.f$0.m216lambda$initVideoPlayer$6$comtapsdktapadinternalruntimeHostAPIImpl(i, i2, str);
            }
        });
        this.mVideoPlayer.setPreparedCallback(new VideoPlayer.PreparedCallback() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda50
            @Override // com.tapsdk.tapad.internal.runtime.VideoPlayer.PreparedCallback
            public final void onPrepared(int i) {
                this.f$0.m217lambda$initVideoPlayer$7$comtapsdktapadinternalruntimeHostAPIImpl(i);
            }
        });
        this.mVideoPlayer.setSizeCallback(new VideoPlayer.SizeCallback() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda51
            @Override // com.tapsdk.tapad.internal.runtime.VideoPlayer.SizeCallback
            public final void onSize(int i, int i2, int i3) {
                this.f$0.m218lambda$initVideoPlayer$8$comtapsdktapadinternalruntimeHostAPIImpl(i, i2, i3);
            }
        });
        this.mVideoPlayer.setFirstFrameCallback(new VideoPlayer.FirstFrameCallback() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda52
            @Override // com.tapsdk.tapad.internal.runtime.VideoPlayer.FirstFrameCallback
            public final void onFirstFrame(int i) {
                this.f$0.m219lambda$initVideoPlayer$9$comtapsdktapadinternalruntimeHostAPIImpl(i);
            }
        });
    }

    private boolean isPackageInstalled(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return this.mContext.getPackageManager().getLaunchIntentForPackage(str) != null;
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean isRendererAlive(RendererSnapshot rendererSnapshot) {
        return (rendererSnapshot == null || rendererSnapshot.renderer == null || this.mSurfaceSessions.rendererForSurface(rendererSnapshot.surfaceId) != rendererSnapshot.renderer) ? false : true;
    }

    private static boolean isRuntimeAffineInstanceCallback(String str) {
        return "onAdnPlatformEffects".equals(str);
    }

    private boolean isVideoOwnedBySnapshot(int i, RendererSnapshot rendererSnapshot) {
        boolean z = false;
        if (rendererSnapshot == null) {
            return false;
        }
        synchronized (this.mVideoOwnerLock) {
            VideoOwner videoOwner = this.mVideoOwnersByHandle.get(i);
            if (videoOwner != null && videoOwner.surfaceId == rendererSnapshot.surfaceId && videoOwner.renderer == rendererSnapshot.renderer) {
                z = true;
            }
        }
        return z;
    }

    private boolean isVideoOwnerAlive(int i) {
        VideoOwner videoOwner;
        synchronized (this.mVideoOwnerLock) {
            videoOwner = this.mVideoOwnersByHandle.get(i);
        }
        return isVideoOwnerAlive(videoOwner, i);
    }

    static /* synthetic */ void lambda$callbackNative$39(DirichletRuntime dirichletRuntime, String str, DirichletRuntime.NativeCallback nativeCallback, String str2) {
        if (dirichletRuntime.getControlCallback(str) == nativeCallback) {
            nativeCallback.onCallback(str, str2);
        }
    }

    static /* synthetic */ void lambda$callbackNative$40(DirichletRuntime dirichletRuntime, int i, DirichletRuntime.NativeCallback nativeCallback, String str, String str2) {
        if (dirichletRuntime.getCallbackForInstance(i) == nativeCallback) {
            nativeCallback.onCallback(str, str2);
        }
    }

    static /* synthetic */ void lambda$popup$48(int i, int i2, int i3, int i4, int i5, int i6, ViewRenderer viewRenderer) {
        if (i == 0) {
            viewRenderer.popupShow(i2, i3, i4, i5, i6);
        } else if (i == 1) {
            viewRenderer.popupDismiss(i2);
        }
    }

    static /* synthetic */ Boolean lambda$release$10(ShakeManager shakeManager) {
        shakeManager.release();
        return Boolean.TRUE;
    }

    static /* synthetic */ void lambda$retainFallbackDisplaySpecAsync$43(SurfaceSession surfaceSession) {
        if (surfaceSession.isAlive()) {
            surfaceSession.refreshFallbackDisplaySpecFromCore();
        }
    }

    static /* synthetic */ void lambda$runOnMainSync$56(Object[] objArr, Callable callable, boolean[] zArr) {
        try {
            objArr[0] = callable.call();
        } catch (Exception e) {
        }
        synchronized (zArr) {
            zArr[0] = true;
            zArr.notifyAll();
        }
    }

    private void loadShortcutIconAndRequest(final JSONObject jSONObject, final InteractionOwner interactionOwner, final Intent intent, final ShortcutPinIcon shortcutPinIcon, String str) {
        try {
            retainShortcutIconTarget(MechanicalImageLoader.loadBitmap(this.mContext, str, MechanicalImageLoader.Options.builder().targetSize(256, 256).build(), new MechanicalImageLoader.BitmapCallback() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda16
                @Override // com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader.BitmapCallback
                public final void onResult(MechanicalImageLoader.Request request, Bitmap bitmap, Exception exc) {
                    this.f$0.m220lambda$loadShortcutIconAndRequest$36$comtapsdktapadinternalruntimeHostAPIImpl(jSONObject, interactionOwner, intent, shortcutPinIcon, request, bitmap, exc);
                }
            }));
        } catch (Throwable th) {
            startShortcutPinRequest(jSONObject, interactionOwner, intent, shortcutPinIcon);
        }
    }

    private boolean matchesSurface(VideoOwner videoOwner, int i) {
        return videoOwner != null && i >= 0 && videoOwner.surfaceId == i;
    }

    private AdvancedDownloadUrls normalizeAdvancedDownloadUrls(JSONObject jSONObject) throws JSONException {
        boolean zHas = jSONObject.has("urls");
        boolean zHas2 = jSONObject.has("urlExpire");
        AdvancedDownloadUrls advancedDownloadUrls = new AdvancedDownloadUrls(zHas, zHas || zHas2);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        if (!zHas) {
            Object obj = jSONObject.get(BreakpointSQLiteKey.URL);
            if (obj instanceof String) {
                String str = (String) obj;
                if (!str.isEmpty()) {
                    long jNormalizeApkExpiry = LongCompanionObject.MAX_VALUE;
                    if (zHas2) {
                        Object obj2 = jSONObject.get("urlExpire");
                        if (!(obj2 instanceof Integer) && !(obj2 instanceof Long)) {
                            throw new JSONException("urlExpire must be an integer");
                        }
                        jNormalizeApkExpiry = normalizeApkExpiry(((Number) obj2).longValue(), jCurrentTimeMillis);
                    }
                    if (jNormalizeApkExpiry > jCurrentTimeMillis) {
                        advancedDownloadUrls.urls.add(str);
                        advancedDownloadUrls.deadlines.add(Long.valueOf(jNormalizeApkExpiry));
                    }
                }
            }
            throw new JSONException("url must be a non-empty string");
        }
        Object obj3 = jSONObject.get("urls");
        Object obj4 = jSONObject.get("urlExpires");
        if (!(obj3 instanceof JSONArray) || !(obj4 instanceof JSONArray)) {
            throw new JSONException("urls and urlExpires must be arrays");
        }
        JSONArray jSONArray = (JSONArray) obj3;
        JSONArray jSONArray2 = (JSONArray) obj4;
        if (jSONArray.length() == 0 || jSONArray2.length() != jSONArray.length()) {
            throw new JSONException("urls must be non-empty with aligned expiries");
        }
        Object obj5 = jSONObject.get(BreakpointSQLiteKey.URL);
        if (!(obj5 instanceof String) || ((String) obj5).isEmpty()) {
            throw new JSONException("url must be a non-empty string");
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj6 = jSONArray.get(i);
            Object obj7 = jSONArray2.get(i);
            if (obj6 instanceof String) {
                String str2 = (String) obj6;
                if (!str2.isEmpty()) {
                    if (!(obj7 instanceof Integer) && !(obj7 instanceof Long)) {
                        throw new JSONException("urlExpires entries must be integers");
                    }
                    if (i == 0 && !obj5.equals(obj6)) {
                        throw new JSONException("url must equal urls[0]");
                    }
                    long jNormalizeApkExpiry2 = normalizeApkExpiry(((Number) obj7).longValue(), jCurrentTimeMillis);
                    if (jNormalizeApkExpiry2 > jCurrentTimeMillis) {
                        advancedDownloadUrls.urls.add(str2);
                        advancedDownloadUrls.deadlines.add(Long.valueOf(jNormalizeApkExpiry2));
                    }
                }
            }
            throw new JSONException("urls entries must be non-empty strings");
        }
        if (advancedDownloadUrls.urls.isEmpty()) {
            throw new JSONException("no valid download URL at Host start time");
        }
        return advancedDownloadUrls;
    }

    private static long normalizeApkExpiry(long j, long j2) {
        if (j >= APK_RELATIVE_EXPIRY_CUTOFF_SECONDS) {
            return j;
        }
        if (j > 0 && j2 > LongCompanionObject.MAX_VALUE - j) {
            return LongCompanionObject.MAX_VALUE;
        }
        if (j >= 0 || j2 >= Long.MIN_VALUE - j) {
            return j2 + j;
        }
        return Long.MIN_VALUE;
    }

    private boolean openApp(String str) {
        try {
            Intent launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            launchIntentForPackage.addFlags(C.ENCODING_PCM_MU_LAW);
            this.mContext.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean openAppStore(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + str));
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            this.mContext.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            return openUrl(c.a("https://play.google.com/store/apps/details?id=", str));
        } catch (Exception e2) {
            return false;
        }
    }

    private boolean openDeepLink(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (DirichletRuntime.getInstance().invokeMediaPreConversionHook("dp", str)) {
                return true;
            }
        } catch (Throwable th) {
        }
        return startSchemeIntent(str, extractDeepLinkTargetPackage(str2));
    }

    private boolean openMiniProgram(String str) {
        try {
            if (str == null) {
                str = "{}";
            }
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("wxAppId", "");
            String strOptString2 = jSONObject.optString("wxMiniProgramId", "");
            return !TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && TextUtils.equals(this.mContext.getApplicationContext().getPackageName(), jSONObject.optString(BillingClientConstants.PACKAGE_NAME, "")) && WXUtil.launchMiniProgram(this.mContext, strOptString, strOptString2, jSONObject.optString("wxMiniProgramPath", ""), 0);
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean openUrl(String str) {
        return startSchemeIntent(str);
    }

    private static int parseDownloadCompletionToken(JSONObject jSONObject) throws JSONException, UnsupportedDownloadPlanException {
        if (!jSONObject.has(DOWNLOAD_EXECUTION_PLAN_FIELD)) {
            return 0;
        }
        Object obj = jSONObject.get(DOWNLOAD_EXECUTION_PLAN_FIELD);
        if (!(obj instanceof JSONObject)) {
            throw new JSONException("download execution plan must be an object");
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        if (requireJsonInteger(jSONObject2, "version") != 1) {
            throw new UnsupportedDownloadPlanException("unsupported version");
        }
        long jRequireJsonInteger = requireJsonInteger(jSONObject2, "completionToken");
        if (jRequireJsonInteger <= 0 || jRequireJsonInteger > 2147483647L) {
            throw new JSONException("download completion token is out of range");
        }
        return (int) jRequireJsonInteger;
    }

    private int parseOverlayDismissReason(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable th) {
            return 0;
        }
    }

    private static Map<String, Object> parseTrackPayload(String str) {
        if (str == null || str.isEmpty()) {
            return new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap map = new HashMap(jSONObject.length());
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objOpt = jSONObject.opt(next);
                if (objOpt != null && objOpt != JSONObject.NULL) {
                    if (objOpt instanceof Float) {
                        map.put(next, Double.valueOf(((Float) objOpt).doubleValue()));
                    } else if ((objOpt instanceof JSONArray) || (objOpt instanceof JSONObject)) {
                        map.put(next, objOpt.toString());
                    } else {
                        map.put(next, objOpt);
                    }
                }
            }
            return map;
        } catch (Throwable th) {
            th.getMessage();
            return new HashMap();
        }
    }

    private boolean performHapticFeedback(String str) {
        try {
            if (str == null) {
                str = "{}";
            }
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt(BaseAdActivity.EXTRA_SURFACE_ID, -1);
            final int iOptInt2 = jSONObject.optInt("handle", -1);
            int iMax = Math.max(0, jSONObject.optInt("delay_ms", 0));
            final int iOptInt3 = jSONObject.optInt("feedback", 3);
            final RendererSnapshot rendererSnapshot = rendererSnapshot(iOptInt);
            if (rendererSnapshot != null && iOptInt2 >= 0) {
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda20
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m223lambda$performHapticFeedback$46$comtapsdktapadinternalruntimeHostAPIImpl(rendererSnapshot, iOptInt2, iOptInt3);
                    }
                }, iMax);
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private void persistAdnDid(String str) {
        try {
            if (str == null) {
                str = "{}";
            }
            String strOptString = new JSONObject(str).optString("adn_did", "");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            AdnDeviceManager.getInstance(this.mContext).saveAdnDid(strOptString);
        } catch (Throwable th) {
        }
    }

    private int pinShortcut(String str, String str2) {
        JSONObject jSONObject;
        String str3 = "reward_floating_layer";
        InteractionOwner interactionOwnerExtractInteractionOwner = extractInteractionOwner(str2);
        try {
            jSONObject = new JSONObject(str);
            try {
                String strOptString = jSONObject.optString("id", "");
                String strOptString2 = jSONObject.optString("shortLabel", "");
                String strOptString3 = jSONObject.optString("targetUrl", "");
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3)) {
                    String strOptString4 = jSONObject.optString("source", "reward_floating_layer");
                    if (!TextUtils.isEmpty(strOptString4)) {
                        str3 = strOptString4;
                    }
                    String strOptString5 = jSONObject.optString("trackId", "");
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(strOptString3));
                    intent.addFlags(C.ENCODING_PCM_MU_LAW);
                    intent.putExtra("tapad_shortcut_source", str3);
                    intent.putExtra("tapad_shortcut_request_id", jSONObject.optString("requestId", ""));
                    intent.putExtra("tapad_shortcut_track_id", strOptString5);
                    intent.putExtra("tapad_track_id", strOptString5);
                    intent.putExtra("tapad_shortcut_interaction_type", jSONObject.optInt("interactionType", 0));
                    if (intent.resolveActivity(this.mContext.getPackageManager()) == null) {
                        trackShortcutPinFallbackResult(jSONObject, "target_unresolvable", SHORTCUT_ERROR_CANNOT_CREATE, null);
                        dispatchInteraction(interactionOwnerExtractInteractionOwner, 1, -3);
                        return 1;
                    }
                    ShortcutPinIcon shortcutPinIconResolveShortcutFallbackIcon = resolveShortcutFallbackIcon();
                    String strOptString6 = jSONObject.optString("iconUrl", "");
                    if (TextUtils.isEmpty(strOptString6)) {
                        startShortcutPinRequest(jSONObject, interactionOwnerExtractInteractionOwner, intent, shortcutPinIconResolveShortcutFallbackIcon);
                    } else {
                        loadShortcutIconAndRequest(jSONObject, interactionOwnerExtractInteractionOwner, intent, shortcutPinIconResolveShortcutFallbackIcon, strOptString6);
                    }
                    return 1;
                }
                trackShortcutPinFallbackResult(jSONObject, "invalid_payload", SHORTCUT_ERROR_CANNOT_CREATE, null);
                dispatchInteraction(interactionOwnerExtractInteractionOwner, 1, -2);
                return 1;
            } catch (Throwable th) {
                th = th;
                if (jSONObject != null) {
                    trackShortcutPinFallbackResult(jSONObject, "exception", shortcutErrorMessage(th), null);
                }
                dispatchInteraction(interactionOwnerExtractInteractionOwner, 1, -1);
                return 1;
            }
        } catch (Throwable th2) {
            th = th2;
            jSONObject = null;
        }
    }

    private void postAcceptedTeardownToRenderer(final RendererSnapshot rendererSnapshot, final RendererOperation rendererOperation) {
        this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                rendererOperation.run(rendererSnapshot.renderer);
            }
        });
    }

    private void postToRenderer(final RendererSnapshot rendererSnapshot, final RendererOperation rendererOperation) {
        this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m224lambda$postToRenderer$54$comtapsdktapadinternalruntimeHostAPIImpl(rendererSnapshot, rendererOperation);
            }
        });
    }

    private boolean prefetchHostEnv(JSONObject jSONObject) {
        return this.mEnvironmentHost.prefetch(jSONObject);
    }

    private void putIfPresent(Map<String, Object> map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    private void releaseShortcutIconTarget(MechanicalImageLoader.Request request) {
        synchronized (this.mShortcutIconTargetLock) {
            this.mShortcutIconTargets.remove(request);
        }
    }

    private void releaseShortcutPinSession(ShortcutPinSession shortcutPinSession) {
        synchronized (this.mShortcutPinSessionLock) {
            this.mShortcutPinSessions.remove(shortcutPinSession);
        }
    }

    private VideoOwner removeVideoOwnerForSurface(int i, int i2) {
        synchronized (this.mVideoOwnerLock) {
            VideoOwner videoOwner = this.mVideoOwnersByHandle.get(i2);
            if (!matchesSurface(videoOwner, i)) {
                return null;
            }
            this.mVideoOwnersByHandle.remove(i2);
            return videoOwner;
        }
    }

    private boolean removeVideoOwnerIfMatches(int i, RendererSnapshot rendererSnapshot) {
        if (rendererSnapshot == null) {
            return false;
        }
        return removeVideoOwnerIfMatches(i, rendererSnapshot.surfaceId, rendererSnapshot.renderer);
    }

    private boolean removeVideoOwnerIfMatchesRenderer(int i, ViewRenderer viewRenderer) {
        synchronized (this.mVideoOwnerLock) {
            VideoOwner videoOwner = this.mVideoOwnersByHandle.get(i);
            if (videoOwner != null && videoOwner.renderer == viewRenderer) {
                this.mVideoOwnersByHandle.remove(i);
                return true;
            }
            return false;
        }
    }

    private RendererSnapshot rendererSnapshot(int i) {
        SurfaceSession live;
        ViewRenderer viewRendererRenderer;
        if (i < 0 || (live = this.mSurfaceSessions.getLive(i)) == null || (viewRendererRenderer = live.renderer()) == null) {
            return null;
        }
        return new RendererSnapshot(i, viewRendererRenderer, live.instanceId());
    }

    private void reportDownloadInteractionSafely(JSONObject jSONObject, int i) {
        int iOptInt = jSONObject.optInt("sessionId", -1);
        if (iOptInt <= 0) {
            return;
        }
        try {
            DownloadInteractionReporter downloadInteractionReporter = this.mDownloadInteractionReporter;
            if (downloadInteractionReporter != null) {
                downloadInteractionReporter.report(jSONObject, i);
                return;
            }
            DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
            int i2 = i > 0 ? 0 : 1;
            int iOptInt2 = jSONObject.optInt("instanceId", -1);
            int iOptInt3 = jSONObject.optInt("surfaceId", -1);
            if (iOptInt2 <= 0 || iOptInt3 <= 0) {
                dirichletRuntime.triggerInteractionEvent(i2, iOptInt, i);
            } else {
                dirichletRuntime.triggerInteractionEvent(iOptInt2, iOptInt3, i2, iOptInt, i);
            }
        } catch (Throwable th) {
        }
    }

    private static long requireJsonInteger(JSONObject jSONObject, String str) throws JSONException {
        Object obj = jSONObject.get(str);
        if ((obj instanceof Integer) || (obj instanceof Long)) {
            return ((Number) obj).longValue();
        }
        throw new JSONException(a.a(str, " must be an integer"));
    }

    private ShortcutPinIcon resolveShortcutFallbackIcon() {
        ApplicationInfo applicationInfo = this.mContext.getApplicationInfo();
        int i = applicationInfo.icon;
        if (i == 0) {
            i = applicationInfo.logo;
        }
        return i != 0 ? ShortcutPinIcon.resource(i) : ShortcutPinIcon.resource("android", R.drawable.sym_def_app_icon);
    }

    private void retainFallbackDisplaySpecAsync(final SurfaceSession surfaceSession) {
        if (DirichletRuntime.getInstance().runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                HostAPIImpl.lambda$retainFallbackDisplaySpecAsync$43(surfaceSession);
            }
        })) {
            return;
        }
        surfaceSession.surfaceId();
    }

    private void retainShortcutIconTarget(MechanicalImageLoader.Request request) {
        synchronized (this.mShortcutIconTargetLock) {
            if (!request.isComplete()) {
                this.mShortcutIconTargets.add(request);
            }
        }
    }

    private void retainShortcutPinSession(ShortcutPinSession shortcutPinSession) {
        synchronized (this.mShortcutPinSessionLock) {
            this.mShortcutPinSessions.add(shortcutPinSession);
        }
    }

    private <T> T runOnMainSync(final Callable<T> callable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                return callable.call();
            } catch (Exception e) {
                return null;
            }
        }
        final Object[] objArr = new Object[1];
        final boolean[] zArr = {false};
        this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                HostAPIImpl.lambda$runOnMainSync$56(objArr, callable, zArr);
            }
        });
        synchronized (zArr) {
            while (!zArr[0]) {
                try {
                    zArr.wait();
                } catch (InterruptedException e2) {
                }
            }
        }
        return (T) objArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runShortcutFocusFallback(ShortcutPinSession shortcutPinSession) {
        synchronized (shortcutPinSession) {
            if (shortcutPinSession.dispatched) {
                return;
            }
            shortcutPinSession.focusFallbackRunnable = null;
            if (!hasShortcutSurfaceWindowFocus(shortcutPinSession.owner)) {
                scheduleShortcutFocusFallback(shortcutPinSession);
            } else if (ShortcutPinManager.isPinnedShortcut(this.mContext, shortcutPinSession.shortcutId)) {
                completeShortcutPinSession(shortcutPinSession, new ShortcutPinResult(shortcutPinSession.shortcutId, ShortcutPinStatus.SUCCESS, ShortcutPinSource.PINNED_SHORTCUTS_QUERY, true, "Shortcut was found in pinned shortcuts after focus fallback."));
            } else {
                completeShortcutPinFailure(shortcutPinSession, "unconfirmed_after_focus", SHORTCUT_ERROR_PIN_NOT_COMPLETED, ShortcutPinStatus.CANCELLED_OR_TIMEOUT.ordinal());
            }
        }
    }

    private AndroidDownloadHost.Observer runtimeDownloadObserver(final int i) {
        return new AndroidDownloadHost.Observer() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl.4
            @Override // com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost.Observer
            public void onCanceled(int i2, int i3) {
                DirichletRuntime.getInstance().triggerDownloadEvent(5, i2, i3, 0, 0);
            }

            @Override // com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost.Observer
            public void onComplete(int i2, int i3, File file) {
                DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
                String absolutePath = file.getAbsolutePath();
                int i4 = i;
                if (i4 > 0) {
                    try {
                        dirichletRuntime.triggerInstallEvent(5, i4, 0, -1, -1, absolutePath);
                    } catch (Throwable th) {
                    }
                }
                dirichletRuntime.setDownloadFilePath(i3, absolutePath);
                dirichletRuntime.triggerDownloadEvent(1, i2, i3, 100, 0);
            }

            @Override // com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost.Observer
            public void onError(int i2, int i3, int i4, String str) {
                DirichletRuntime.getInstance().triggerDownloadEvent(2, i2, i3, 0, i4);
            }

            @Override // com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost.Observer
            public void onPaused(int i2, int i3, float f) {
                DirichletRuntime.getInstance().triggerDownloadEvent(3, i2, i3, (int) (f * 100.0f), 0);
            }

            @Override // com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost.Observer
            public void onProgress(int i2, int i3, float f, long j, long j2) {
                DirichletRuntime.getInstance().triggerDownloadEvent(0, i2, i3, (int) (f * 100.0f), 0);
            }

            @Override // com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost.Observer
            public void onResumed(int i2, int i3, float f) {
                DirichletRuntime.getInstance().triggerDownloadEvent(4, i2, i3, (int) (f * 100.0f), 0);
            }
        };
    }

    private void scheduleShortcutFocusFallback(final ShortcutPinSession shortcutPinSession) {
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl.3
            @Override // java.lang.Runnable
            public void run() {
                HostAPIImpl.this.runShortcutFocusFallback(shortcutPinSession);
            }
        };
        synchronized (shortcutPinSession) {
            if (shortcutPinSession.dispatched) {
                return;
            }
            shortcutPinSession.focusFallbackRunnable = runnable;
            this.mMainHandler.postDelayed(runnable, SHORTCUT_FOCUS_FALLBACK_DELAY_MS);
        }
    }

    private void setVideoOwner(int i, RendererSnapshot rendererSnapshot) {
        if (i < 0 || rendererSnapshot == null || rendererSnapshot.renderer == null) {
            return;
        }
        synchronized (this.mVideoOwnerLock) {
            this.mVideoOwnersByHandle.put(i, new VideoOwner(rendererSnapshot.surfaceId, rendererSnapshot.renderer));
        }
    }

    private void shakeConfigImpl(final String str, final int i) {
        this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m226lambda$shakeConfigImpl$44$comtapsdktapadinternalruntimeHostAPIImpl(str, i);
            }
        });
    }

    private boolean shakeStartSync() {
        Boolean bool = (Boolean) runOnMainSync(new Callable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda56
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m227lambda$shakeStartSync$45$comtapsdktapadinternalruntimeHostAPIImpl();
            }
        });
        return bool != null && bool.booleanValue();
    }

    private String shortcutErrorMessage(Throwable th) {
        String message = th.getMessage();
        return !TextUtils.isEmpty(message) ? message : th.getClass().getSimpleName();
    }

    private Map<String, Object> shortcutTrackingBaseParams(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("template_id", Integer.valueOf(jSONObject.optInt("templateId", 0)));
        putIfPresent(map, Constants.Bidding.REQUEST_ID, jSONObject.optString("requestId", ""));
        putIfPresent(map, "track_id", jSONObject.optString("trackId", ""));
        putIfPresent(map, "shortcut_id", jSONObject.optString("id", ""));
        putIfPresent(map, "shortcut_target_url", jSONObject.optString("targetUrl", ""));
        putIfPresent(map, "shortcut_label", jSONObject.optString("shortLabel", ""));
        putIfPresent(map, "shortcut_icon_url", jSONObject.optString("iconUrl", ""));
        map.put("timeout_ms", Long.valueOf(Math.max(0L, jSONObject.optLong("timeoutMs", ShortcutPinOptions.DEFAULT_TIMEOUT_MILLIS))));
        return map;
    }

    private boolean showToast(final String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda57
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m228lambda$showToast$37$comtapsdktapadinternalruntimeHostAPIImpl(str);
            }
        });
        return true;
    }

    private boolean startOptionalVibration(String str) {
        if (!hasVibratePermission()) {
            return false;
        }
        try {
            if (str == null) {
                str = "{}";
            }
            JSONObject jSONObject = new JSONObject(str);
            final int iOptInt = jSONObject.optInt("duration_ms", 0);
            int iMax = Math.max(0, jSONObject.optInt("delay_ms", 0));
            if (iOptInt <= 0) {
                return false;
            }
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda60
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m229lambda$startOptionalVibration$47$comtapsdktapadinternalruntimeHostAPIImpl(iOptInt);
                }
            }, iMax);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean startSchemeIntent(String str) {
        return startSchemeIntent(str, null);
    }

    private void startShortcutPinRequest(JSONObject jSONObject, InteractionOwner interactionOwner, Intent intent, ShortcutPinIcon shortcutPinIcon) {
        final ShortcutPinSession shortcutPinSession;
        try {
            ShortcutPinRequest shortcutPinRequestBuildShortcutPinRequest = buildShortcutPinRequest(jSONObject, intent, shortcutPinIcon);
            shortcutPinSession = new ShortcutPinSession(jSONObject, interactionOwner, shortcutPinRequestBuildShortcutPinRequest.getId(), System.currentTimeMillis());
            try {
                retainShortcutPinSession(shortcutPinSession);
                trackShortcutPinRequest(jSONObject, shortcutPinRequestBuildShortcutPinRequest);
                ShortcutPinHandle shortcutPinHandleRequestPinShortcut = ShortcutPinManager.requestPinShortcut(this.mContext, shortcutPinRequestBuildShortcutPinRequest, new ShortcutPinCallback() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl.2
                    @Override // com.tapsdk.tapad.internal.shortcut.ShortcutPinCallback
                    public void onResult(ShortcutPinResult shortcutPinResult) {
                        HostAPIImpl.this.completeShortcutPinSession(shortcutPinSession, shortcutPinResult);
                    }
                }, new ShortcutPinOptions.Builder().setTimeoutMillis(Math.max(0L, jSONObject.optLong("timeoutMs", ShortcutPinOptions.DEFAULT_TIMEOUT_MILLIS))).build());
                boolean z = false;
                synchronized (shortcutPinSession) {
                    if (shortcutPinSession.dispatched) {
                        z = true;
                    } else {
                        shortcutPinSession.handle = shortcutPinHandleRequestPinShortcut;
                    }
                }
                if (z) {
                    shortcutPinHandleRequestPinShortcut.cancel();
                } else {
                    scheduleShortcutFocusFallback(shortcutPinSession);
                }
            } catch (Throwable th) {
                th = th;
                if (shortcutPinSession != null) {
                    completeShortcutPinFailure(shortcutPinSession, "exception", shortcutErrorMessage(th), ShortcutPinStatus.ERROR.ordinal());
                } else {
                    trackShortcutPinFallbackResult(jSONObject, "exception", shortcutErrorMessage(th), null);
                    dispatchInteraction(interactionOwner, 1, -1);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            shortcutPinSession = null;
        }
    }

    private void trackShortcutPinFallbackResult(JSONObject jSONObject, String str, String str2, Long l) {
        Map<String, Object> mapShortcutTrackingBaseParams = shortcutTrackingBaseParams(jSONObject);
        mapShortcutTrackingBaseParams.put("shortcut_attempt", 1);
        mapShortcutTrackingBaseParams.put("shortcut_result", IdentityVerifyStateKt.VERIFY_STATE_FAILED);
        if (!TextUtils.isEmpty(str)) {
            mapShortcutTrackingBaseParams.put("shortcut_status", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            mapShortcutTrackingBaseParams.put("error_message", str2);
        }
        if (l != null) {
            mapShortcutTrackingBaseParams.put("shortcut_elapsed_ms", Long.valueOf(Math.max(0L, l.longValue())));
        }
        AdnTelemetryHost.reportFact(8, mapShortcutTrackingBaseParams);
    }

    private void trackShortcutPinRequest(JSONObject jSONObject, ShortcutPinRequest shortcutPinRequest) {
        Map<String, Object> mapShortcutTrackingBaseParams = shortcutTrackingBaseParams(jSONObject);
        mapShortcutTrackingBaseParams.put("shortcut_id", shortcutPinRequest.getId());
        mapShortcutTrackingBaseParams.put("shortcut_attempt", 1);
        mapShortcutTrackingBaseParams.put("shortcut_is_retry", Boolean.FALSE);
        mapShortcutTrackingBaseParams.put("supports_pin_shortcut", Boolean.valueOf(ShortcutPinManager.isRequestPinShortcutSupported(this.mContext)));
        AdnTelemetryHost.reportFact(7, mapShortcutTrackingBaseParams);
    }

    private void trackShortcutPinResult(JSONObject jSONObject, ShortcutPinResult shortcutPinResult, long j) {
        Map<String, Object> mapShortcutTrackingBaseParams = shortcutTrackingBaseParams(jSONObject);
        mapShortcutTrackingBaseParams.put("shortcut_id", shortcutPinResult.getId());
        mapShortcutTrackingBaseParams.put("shortcut_attempt", 1);
        mapShortcutTrackingBaseParams.put("shortcut_elapsed_ms", Long.valueOf(Math.max(0L, j)));
        mapShortcutTrackingBaseParams.put("shortcut_result", shortcutPinResult.isSuccess() ? TrackAction.SUCCESS : IdentityVerifyStateKt.VERIFY_STATE_FAILED);
        mapShortcutTrackingBaseParams.put("shortcut_status", shortcutPinResult.getStatus().name().toLowerCase());
        mapShortcutTrackingBaseParams.put("shortcut_source", shortcutPinResult.getSource().name().toLowerCase());
        mapShortcutTrackingBaseParams.put("shortcut_verified_pinned", Boolean.valueOf(shortcutPinResult.isVerifiedPinned()));
        if (!TextUtils.isEmpty(shortcutPinResult.getMessage())) {
            mapShortcutTrackingBaseParams.put("error_message", shortcutPinResult.getMessage());
        }
        AdnTelemetryHost.reportFact(8, mapShortcutTrackingBaseParams);
    }

    private void triggerRegisteredCallback(int i, CallbackRegistry.CallbackType callbackType, String str) {
        Integer num = this.mCallbackRegistry.get(i, callbackType);
        if (num != null) {
            DirichletRuntime.getInstance().triggerCallback(num.intValue(), str);
        }
    }

    private static String videoCallbackPayload(int i, Integer num) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("handle", i);
            if (num != null) {
                jSONObject.put(PluginConstants.KEY_ERROR_CODE, num);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            return "{}";
        }
    }

    private VideoOwner videoOwnerForSurface(int i, int i2) {
        synchronized (this.mVideoOwnerLock) {
            VideoOwner videoOwner = this.mVideoOwnersByHandle.get(i2);
            if (matchesSurface(videoOwner, i)) {
                return videoOwner;
            }
            return null;
        }
    }

    public void assetExecute(byte[] bArr) {
        this.mAssetTransferExecutor.execute(bArr);
    }

    public void assetRuntimeShutdown() {
        this.mAssetTransferExecutor.release();
    }

    public void callbackNative(final int i, int i2, final String str, final String str2) {
        final DirichletRuntime.NativeCallback callbackForInstance;
        final DirichletRuntime.NativeCallback controlCallback;
        if (i == -1 && i2 < 0 && "onCoreAdnPrivacyCollection".equals(str)) {
            try {
                AndroidPrivacyPolicy.applyAdnCollectionPolicy(new JSONObject(str2));
                return;
            } catch (Throwable th) {
                AndroidPrivacyPolicy.applyAdnCollectionPolicy(null);
                return;
            }
        }
        if (i == -1 && i2 < 0 && "onCoreMediationPlatformEffects".equals(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.optInt("schema_version", 0) == 1 && "shared_rust".equals(jSONObject.optString("owner")) && "mediation_platform_effects".equals(jSONObject.optString("kind")) && jSONObject.has("privacy_collection")) {
                    AndroidPrivacyPolicy.applyMediationCollectionPolicy(jSONObject.optJSONObject("privacy_collection"));
                }
            } catch (Throwable th2) {
            }
        }
        if (CALLBACK_ADN_DEVICE_UPDATED.equals(str)) {
            persistAdnDid(str2);
            return;
        }
        if (i2 >= 0) {
            DirichletRuntime.getInstance().dispatchSurfaceCallback(i2, str, str2);
            return;
        }
        if ("onCoreAdnTelemetryEvents".equals(str)) {
            DirichletRuntime.getInstance().runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    CoreAdnTelemetryBridge.reportEvents(str2);
                }
            });
            return;
        }
        final DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        if (i == -1 && (controlCallback = dirichletRuntime.getControlCallback(str)) != null) {
            dirichletRuntime.runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    HostAPIImpl.lambda$callbackNative$39(dirichletRuntime, str, controlCallback, str2);
                }
            });
        } else if (i >= -1 && (callbackForInstance = dirichletRuntime.getCallbackForInstance(i)) != null) {
            dirichletRuntime.runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m211lambda$callbackNative$41$comtapsdktapadinternalruntimeHostAPIImpl(dirichletRuntime, i, callbackForInstance, str, str2);
                }
            });
        }
    }

    public int capability(int i, String str) {
        if (i == 1) {
            return hostFeatureBitset();
        }
        if (i == 2) {
            return 0;
        }
        switch (i) {
            case 10:
                return 1;
            case 11:
                return hasPermission("android.permission.VIBRATE") ? 1 : 0;
            case 12:
                if (Build.VERSION.SDK_INT < 33) {
                    return 1;
                }
                return hasPermission("android.permission.POST_NOTIFICATIONS") ? 1 : 0;
            case 13:
            case 14:
                return 1;
            case 15:
                return this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.accelerometer") ? 1 : 0;
            case 16:
                return 1;
            case 17:
                return this.mInstallHost.canRequestPackageInstalls() ? 1 : 0;
            case 18:
                return 1;
            case 19:
                return Build.VERSION.SDK_INT;
            case 20:
                return 1;
            default:
                return -1;
        }
    }

    public boolean configurePreviewHttpAllowedHosts(List<String> list) {
        return false;
    }

    public void destroySurfacesForInstance(int i) {
        for (SurfaceSession surfaceSession : this.mSurfaceSessions.sessionsForInstance(i)) {
            if (surfaceSession != null) {
                releaseOverlaysForSurface(surfaceSession.surfaceId(), surfaceSession.renderer());
                releaseVideosForSurface(surfaceSession.surfaceId(), surfaceSession.renderer());
            }
        }
        this.mSurfaceSessions.destroySurfacesForInstance(i);
    }

    public int download(int i, String str, int i2) {
        switch (i) {
            case 0:
                return this.mDownloadHost.start(str, i2, new AndroidDownloadHost.NotificationSpec("下载中"), runtimeDownloadObserver(0));
            case 1:
                return downloadStartAdvanced(str, i2);
            case 2:
                this.mDownloadHost.pause(i2);
                return 0;
            case 3:
                this.mDownloadHost.resume(i2);
                return 0;
            case 4:
                this.mDownloadHost.cancel(i2);
                return 0;
            default:
                return -1;
        }
    }

    public int env(int i, String str, byte[] bArr, int i2) {
        try {
            if (str == null) {
                str = "{}";
            }
            JSONObject jSONObject = new JSONObject(str);
            if (i == 0) {
                return prefetchHostEnv(jSONObject) ? 1 : -1;
            }
            if (i != 1) {
                return -1;
            }
            return copyEnvResult(buildHostEnvSnapshot(jSONObject), bArr);
        } catch (Throwable th) {
            return -1;
        }
    }

    public int file(int i, String str, int i2) {
        return WasmPrivateFileApi.call(this.mContext, i, str, i2);
    }

    public int haptic(int i, String str, int i2) {
        if (i == 0) {
            return performHapticFeedback(str) ? 1 : 0;
        }
        if (i == 1) {
            return startOptionalVibration(str) ? 1 : 0;
        }
        if (i != 2) {
            return -1;
        }
        cancelHapticVibration();
        return 0;
    }

    public int httpCancel(int i) {
        return this.mHttpClient.cancel(i);
    }

    public int httpRequest(int i, String str, String str2, byte[] bArr, int i2) {
        Set<String> set = this.mPreviewHttpAllowedHosts;
        if (!set.isEmpty()) {
            HttpUrl httpUrl = HttpUrl.parse(str);
            String lowerCase = httpUrl == null ? "" : httpUrl.host().toLowerCase(Locale.US);
            if (httpUrl == null || !BaseConstants.SCHEME_HTTPS.equals(httpUrl.scheme()) || !set.contains(lowerCase)) {
                dispatchHttpResponse(i2, 6, 0, "", new byte[0]);
                return i2;
            }
        }
        this.mHttpClient.request(i2, i, str, str2, bArr);
        return i2;
    }

    public int install(int i, int i2, String str, String str2) {
        return this.mInstallHost.execute(i, i2, str, str2);
    }

    /* JADX INFO: renamed from: lambda$attachVideo$31$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ boolean m209lambda$attachVideo$31$comtapsdktapadinternalruntimeHostAPIImpl(float f, View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        this.mLastTouchXDp10 = (int) (((motionEvent.getX() + view.getLeft()) / f) * 10.0f);
        this.mLastTouchYDp10 = (int) (((motionEvent.getY() + view.getTop()) / f) * 10.0f);
        return false;
    }

    /* JADX INFO: renamed from: lambda$callbackNative$41$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m211lambda$callbackNative$41$comtapsdktapadinternalruntimeHostAPIImpl(final DirichletRuntime dirichletRuntime, final int i, final DirichletRuntime.NativeCallback nativeCallback, final String str, final String str2) {
        if (dirichletRuntime.getCallbackForInstance(i) != nativeCallback) {
            return;
        }
        if (isRuntimeAffineInstanceCallback(str)) {
            nativeCallback.onCallback(str, str2);
        } else {
            this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    HostAPIImpl.lambda$callbackNative$40(dirichletRuntime, i, nativeCallback, str, str2);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$destroyVideoForRenderer$34$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m212lambda$destroyVideoForRenderer$34$comtapsdktapadinternalruntimeHostAPIImpl(int i, ViewRenderer viewRenderer) {
        if (removeVideoOwnerIfMatchesRenderer(i, viewRenderer)) {
            destroyVideoHandleNow(i);
        }
    }

    /* JADX INFO: renamed from: lambda$initVideoPlayer$3$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m213lambda$initVideoPlayer$3$comtapsdktapadinternalruntimeHostAPIImpl(int i, float f, float f2) {
        Integer num;
        if (isVideoOwnerAlive(i) && (num = this.mCallbackRegistry.get(i, CallbackRegistry.CallbackType.VIDEO_PROGRESS)) != null) {
            DirichletRuntime.getInstance().triggerCallbackWithCoords(num.intValue(), (int) (f * 1000.0f), (int) (f2 * 1000.0f));
        }
    }

    /* JADX INFO: renamed from: lambda$initVideoPlayer$4$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m214lambda$initVideoPlayer$4$comtapsdktapadinternalruntimeHostAPIImpl(int i) {
        if (isVideoOwnerAlive(i)) {
            triggerRegisteredCallback(i, CallbackRegistry.CallbackType.VIDEO_COMPLETE, videoCallbackPayload(i, null));
        }
    }

    /* JADX INFO: renamed from: lambda$initVideoPlayer$5$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m215lambda$initVideoPlayer$5$comtapsdktapadinternalruntimeHostAPIImpl(int i, int i2, String str) {
        if (isVideoOwnerAlive(i)) {
            triggerRegisteredCallback(i, CallbackRegistry.CallbackType.VIDEO_ERROR, videoCallbackPayload(i, Integer.valueOf(i2)));
        }
    }

    /* JADX INFO: renamed from: lambda$initVideoPlayer$6$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m216lambda$initVideoPlayer$6$comtapsdktapadinternalruntimeHostAPIImpl(int i, int i2, String str) {
        Integer num;
        if (isVideoOwnerAlive(i) && (num = this.mCallbackRegistry.get(i, CallbackRegistry.CallbackType.VIDEO_PROGRESS)) != null) {
            DirichletRuntime.getInstance().triggerCallbackWithCoords(num.intValue(), -1, -1);
        }
    }

    /* JADX INFO: renamed from: lambda$initVideoPlayer$7$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m217lambda$initVideoPlayer$7$comtapsdktapadinternalruntimeHostAPIImpl(int i) {
        if (isVideoOwnerAlive(i)) {
            triggerRegisteredCallback(i, CallbackRegistry.CallbackType.VIDEO_READY, videoCallbackPayload(i, null));
        }
    }

    /* JADX INFO: renamed from: lambda$initVideoPlayer$8$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m218lambda$initVideoPlayer$8$comtapsdktapadinternalruntimeHostAPIImpl(int i, int i2, int i3) {
        Integer num;
        if (isVideoOwnerAlive(i) && (num = this.mCallbackRegistry.get(i, CallbackRegistry.CallbackType.VIDEO_SIZE_CHANGED)) != null) {
            DirichletRuntime.getInstance().triggerCallbackWithCoords(num.intValue(), i2, i3);
        }
    }

    /* JADX INFO: renamed from: lambda$initVideoPlayer$9$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m219lambda$initVideoPlayer$9$comtapsdktapadinternalruntimeHostAPIImpl(int i) {
        if (isVideoOwnerAlive(i)) {
            triggerRegisteredCallback(i, CallbackRegistry.CallbackType.VIDEO_FIRST_FRAME, videoCallbackPayload(i, null));
        }
    }

    /* JADX INFO: renamed from: lambda$loadShortcutIconAndRequest$36$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m220lambda$loadShortcutIconAndRequest$36$comtapsdktapadinternalruntimeHostAPIImpl(JSONObject jSONObject, InteractionOwner interactionOwner, Intent intent, ShortcutPinIcon shortcutPinIcon, MechanicalImageLoader.Request request, Bitmap bitmap, Exception exc) {
        releaseShortcutIconTarget(request);
        if (bitmap != null) {
            shortcutPinIcon = ShortcutPinIcon.bitmap(bitmap);
        }
        startShortcutPinRequest(jSONObject, interactionOwner, intent, shortcutPinIcon);
    }

    /* JADX INFO: renamed from: lambda$new$0$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m221lambda$new$0$comtapsdktapadinternalruntimeHostAPIImpl() {
        ShakeManager shakeManager;
        if (AndroidPrivacyPolicy.allowsSensor() || (shakeManager = this.mShakeManager) == null) {
            return;
        }
        shakeManager.stop();
    }

    /* JADX INFO: renamed from: lambda$new$1$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m222lambda$new$1$comtapsdktapadinternalruntimeHostAPIImpl() {
        this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda44
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m221lambda$new$0$comtapsdktapadinternalruntimeHostAPIImpl();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$performHapticFeedback$46$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m223lambda$performHapticFeedback$46$comtapsdktapadinternalruntimeHostAPIImpl(RendererSnapshot rendererSnapshot, int i, int i2) {
        View view;
        if (isRendererAlive(rendererSnapshot) && (view = rendererSnapshot.renderer.getView(i)) != null) {
            try {
                view.performHapticFeedback(i2);
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: renamed from: lambda$postToRenderer$54$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m224lambda$postToRenderer$54$comtapsdktapadinternalruntimeHostAPIImpl(RendererSnapshot rendererSnapshot, RendererOperation rendererOperation) {
        if (isRendererAlive(rendererSnapshot)) {
            rendererOperation.run(rendererSnapshot.renderer);
        }
    }

    /* JADX INFO: renamed from: lambda$releaseVideosForSurface$35$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m225lambda$releaseVideosForSurface$35$comtapsdktapadinternalruntimeHostAPIImpl(Integer num, ViewRenderer viewRenderer) {
        destroyVideoHandleAndDetachView(num.intValue(), viewRenderer);
    }

    /* JADX INFO: renamed from: lambda$shakeConfigImpl$44$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m226lambda$shakeConfigImpl$44$comtapsdktapadinternalruntimeHostAPIImpl(String str, int i) {
        if (AndroidPrivacyPolicy.allowsSensor()) {
            if (this.mShakeManager == null) {
                this.mShakeManager = new ShakeManager(this.mContext);
            }
            this.mShakeManager.configureFromJson(str, i);
        } else {
            ShakeManager shakeManager = this.mShakeManager;
            if (shakeManager != null) {
                shakeManager.stop();
            }
        }
    }

    /* JADX INFO: renamed from: lambda$shakeStartSync$45$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ Boolean m227lambda$shakeStartSync$45$comtapsdktapadinternalruntimeHostAPIImpl() {
        ShakeManager shakeManager;
        return Boolean.valueOf(AndroidPrivacyPolicy.allowsSensor() && (shakeManager = this.mShakeManager) != null && shakeManager.start());
    }

    /* JADX INFO: renamed from: lambda$showToast$37$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m228lambda$showToast$37$comtapsdktapadinternalruntimeHostAPIImpl(String str) {
        try {
            Toast.makeText(this.mContext, str, 0).show();
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: renamed from: lambda$startOptionalVibration$47$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m229lambda$startOptionalVibration$47$comtapsdktapadinternalruntimeHostAPIImpl(int i) {
        Vibrator vibrator;
        if (hasVibratePermission() && (vibrator = (Vibrator) this.mContext.getSystemService("vibrator")) != null) {
            cancelHapticVibrationNow();
            this.mHapticVibrator = vibrator;
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    vibrator.vibrate(VibrationEffect.createWaveform(new long[]{0, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT}, 0));
                } else {
                    vibrator.vibrate(new long[]{0, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT}, 0);
                }
                HostAPIImpl$$ExternalSyntheticLambda59 hostAPIImpl$$ExternalSyntheticLambda59 = new HostAPIImpl$$ExternalSyntheticLambda59(this);
                this.mHapticCancelRunnable = hostAPIImpl$$ExternalSyntheticLambda59;
                this.mMainHandler.postDelayed(hostAPIImpl$$ExternalSyntheticLambda59, i);
            } catch (Throwable th) {
                cancelHapticVibrationNow();
            }
        }
    }

    /* JADX INFO: renamed from: lambda$surfaceAttach$42$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ Integer m230lambda$surfaceAttach$42$comtapsdktapadinternalruntimeHostAPIImpl(int i, int i2, String str) {
        AdSurfaceBinding adSurfaceBinding;
        Context context;
        Activity activity;
        try {
            SurfaceSession live = this.mSurfaceSessions.getLive(i);
            if (live == null) {
                return -3;
            }
            synchronized (this.mAdSurfaceBindings) {
                adSurfaceBinding = this.mAdSurfaceBindings.get(live.instanceId());
            }
            if (adSurfaceBinding == null) {
                live.instanceId();
                return -3;
            }
            Context context2 = this.mContext;
            if (adSurfaceBinding.callerActivityRequired) {
                activity = adSurfaceBinding.callerActivity.get();
                if (!WasmAdSurfaceHost.isActivityUsable(activity)) {
                    context = context2;
                    context = activity;
                    live.instanceId();
                    return -3;
                }
            }
            context = context2;
            context = activity;
            context = context2;
            return Integer.valueOf(WasmAdSurfaceHost.attach(context, i, i2, str) ? 0 : -3);
        } catch (Throwable th) {
            return -4;
        }
    }

    /* JADX INFO: renamed from: lambda$videoControl$28$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m232lambda$videoControl$28$comtapsdktapadinternalruntimeHostAPIImpl(VideoOwner videoOwner, int i, int i2, float f) {
        if (isVideoOwnerAlive(videoOwner, i)) {
            switch (i2) {
                case 0:
                    this.mVideoPlayer.play(i);
                    break;
                case 1:
                    this.mVideoPlayer.pause(i);
                    break;
                case 2:
                    this.mVideoPlayer.stop(i);
                    break;
                case 3:
                    this.mVideoPlayer.seek(i, f);
                    break;
                case 4:
                    this.mVideoPlayer.setVolume(i, f);
                    break;
                case 5:
                    this.mVideoPlayer.setVolume(i, f > 0.5f ? 0.0f : 1.0f);
                    break;
                case 6:
                    this.mVideoPlayer.setLooping(i, f > 0.5f);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: lambda$videoCreate$26$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m233lambda$videoCreate$26$comtapsdktapadinternalruntimeHostAPIImpl(RendererSnapshot rendererSnapshot, int i, String str, boolean z) {
        if (isRendererAlive(rendererSnapshot)) {
            this.mVideoPlayer.createForHandle(i, str, z);
        } else {
            removeVideoOwnerIfMatches(i, rendererSnapshot);
            this.mCallbackRegistry.unregisterAll(i);
        }
    }

    /* JADX INFO: renamed from: lambda$videoDestroy$27$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m234lambda$videoDestroy$27$comtapsdktapadinternalruntimeHostAPIImpl(VideoOwner videoOwner, int i) {
        if (videoOwner != null) {
            destroyVideoHandleAndDetachView(i, videoOwner.renderer);
        }
    }

    /* JADX INFO: renamed from: lambda$videoQuery$29$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ Float m235lambda$videoQuery$29$comtapsdktapadinternalruntimeHostAPIImpl(VideoOwner videoOwner, int i, int i2) {
        boolean zIsVideoOwnerAlive = isVideoOwnerAlive(videoOwner, i);
        Float fValueOf = Float.valueOf(0.0f);
        if (!zIsVideoOwnerAlive) {
            return fValueOf;
        }
        switch (i2) {
            case 0:
                return Float.valueOf(this.mVideoPlayer.getDuration(i));
            case 1:
                return Float.valueOf(this.mVideoPlayer.getPosition(i));
            case 2:
                return Float.valueOf(this.mVideoPlayer.getVideoWidth(i));
            case 3:
                return Float.valueOf(this.mVideoPlayer.getVideoHeight(i));
            default:
                return fValueOf;
        }
    }

    /* JADX INFO: renamed from: lambda$viewOnClick$21$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ boolean m236lambda$viewOnClick$21$comtapsdktapadinternalruntimeHostAPIImpl(float f, View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        this.mLastTouchXDp10 = (int) ((motionEvent.getX() / f) * 10.0f);
        this.mLastTouchYDp10 = (int) ((motionEvent.getY() / f) * 10.0f);
        return false;
    }

    /* JADX INFO: renamed from: lambda$viewOnClick$22$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m237lambda$viewOnClick$22$comtapsdktapadinternalruntimeHostAPIImpl(int i) {
        int i2 = this.mLastTouchXDp10;
        int i3 = this.mLastTouchYDp10;
        this.mLastTouchXDp10 = -1;
        this.mLastTouchYDp10 = -1;
        DirichletRuntime.getInstance().triggerCallbackWithCoords(i, i2, i3);
    }

    /* JADX INFO: renamed from: lambda$viewOnClick$23$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m238lambda$viewOnClick$23$comtapsdktapadinternalruntimeHostAPIImpl(final int i, int i2, ViewRenderer viewRenderer) {
        if (i < 0) {
            viewRenderer.setOnClick(i2, null);
            return;
        }
        View view = viewRenderer.getView(i2);
        if (view == null) {
            return;
        }
        final float f = view.getResources().getDisplayMetrics().density;
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda18
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return this.f$0.m236lambda$viewOnClick$21$comtapsdktapadinternalruntimeHostAPIImpl(f, view2, motionEvent);
            }
        });
        viewRenderer.setOnClick(i2, new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m237lambda$viewOnClick$22$comtapsdktapadinternalruntimeHostAPIImpl(i);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$viewOnTouch$24$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m239lambda$viewOnTouch$24$comtapsdktapadinternalruntimeHostAPIImpl(float f, int i, int i2, float f2, float f3, float f4, float f5, int i3, int i4, int i5, long j) {
        int i6 = (int) ((f2 / f) * 10.0f);
        this.mLastTouchXDp10 = i6;
        int i7 = (int) ((f3 / f) * 10.0f);
        this.mLastTouchYDp10 = i7;
        DirichletRuntime.getInstance().triggerTouch(i, i2, i6, i7, (int) ((f4 / f) * 10.0f), (int) ((f5 / f) * 10.0f), i3, i4, i5, j);
    }

    /* JADX INFO: renamed from: lambda$viewOnTouch$25$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ void m240lambda$viewOnTouch$25$comtapsdktapadinternalruntimeHostAPIImpl(final int i, int i2, int i3, ViewRenderer viewRenderer) {
        if (i < 0) {
            viewRenderer.setOnTouch(i2, null, i3);
            return;
        }
        View view = viewRenderer.getView(i2);
        if (view == null) {
            return;
        }
        final float f = view.getResources().getDisplayMetrics().density;
        viewRenderer.setOnTouch(i2, new ViewRenderer.TouchCallback() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda42
            @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer.TouchCallback
            public final void onTouch(int i4, float f2, float f3, float f4, float f5, int i5, int i6, int i7, long j) {
                this.f$0.m239lambda$viewOnTouch$24$comtapsdktapadinternalruntimeHostAPIImpl(f, i, i4, f2, f3, f4, f5, i5, i6, i7, j);
            }
        }, i3);
    }

    /* JADX INFO: renamed from: lambda$viewQuery$19$com-tapsdk-tapad-internal-runtime-HostAPIImpl, reason: not valid java name */
    /* synthetic */ Boolean m241lambda$viewQuery$19$comtapsdktapadinternalruntimeHostAPIImpl(RendererSnapshot rendererSnapshot, int i, float[] fArr) {
        if (!isRendererAlive(rendererSnapshot)) {
            return Boolean.FALSE;
        }
        rendererSnapshot.renderer.queryViewAll(i, fArr);
        return Boolean.TRUE;
    }

    public float[] measureText(int i, String str, float f, float f2, boolean z) {
        RendererSnapshot rendererSnapshot = rendererSnapshot(i);
        return rendererSnapshot != null ? rendererSnapshot.renderer.measureText(str, f, f2, z) : new float[]{0.0f, 0.0f};
    }

    public int navigate(int i, String str, String str2) {
        int iOpenUrl;
        switch (i) {
            case 0:
                iOpenUrl = openUrl(str);
                break;
            case 1:
                iOpenUrl = openAppStore(str);
                break;
            case 2:
                iOpenUrl = openDeepLink(str, str2);
                break;
            case 3:
            case 6:
            default:
                iOpenUrl = -1;
                break;
            case 4:
                iOpenUrl = openApp(str);
                break;
            case 5:
                return isPackageInstalled(str) ? 1 : 0;
            case 7:
                return showToast(str) ? 1 : 0;
            case 8:
                try {
                    return Integer.parseInt(str2);
                } catch (Throwable th) {
                    return 0;
                }
            case 9:
                iOpenUrl = openMiniProgram(str);
                break;
            case 10:
                return pinShortcut(str, str2);
        }
        dispatchInteractionOpenResult(str2, iOpenUrl);
        return iOpenUrl;
    }

    public int overlay(int i, int i2, final int i3, final int i4, final int i5, final String str, final int i6) {
        RendererSnapshot rendererSnapshot = rendererSnapshot(i);
        if (rendererSnapshot == null) {
            return -2;
        }
        switch (i2) {
            case 0:
                final int iAllocateOverlayId = allocateOverlayId();
                postToRenderer(rendererSnapshot, new RendererOperation() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda31
                    @Override // com.tapsdk.tapad.internal.runtime.HostAPIImpl.RendererOperation
                    public final void run(ViewRenderer viewRenderer) {
                        viewRenderer.overlayCreate(iAllocateOverlayId, str, i6);
                    }
                });
                return iAllocateOverlayId;
            case 1:
                postToRenderer(rendererSnapshot, new RendererOperation() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda30
                    @Override // com.tapsdk.tapad.internal.runtime.HostAPIImpl.RendererOperation
                    public final void run(ViewRenderer viewRenderer) {
                        viewRenderer.overlayShow(i3, i4, i5);
                    }
                });
                return 0;
            case 2:
                postToRenderer(rendererSnapshot, new RendererOperation() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda29
                    @Override // com.tapsdk.tapad.internal.runtime.HostAPIImpl.RendererOperation
                    public final void run(ViewRenderer viewRenderer) {
                        viewRenderer.overlayUpdate(i3, str);
                    }
                });
                return 0;
            case 3:
                final int overlayDismissReason = parseOverlayDismissReason(str);
                postToRenderer(rendererSnapshot, new RendererOperation() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda28
                    @Override // com.tapsdk.tapad.internal.runtime.HostAPIImpl.RendererOperation
                    public final void run(ViewRenderer viewRenderer) {
                        viewRenderer.overlayDismiss(i3, overlayDismissReason);
                    }
                });
                return 0;
            case 4:
                postToRenderer(rendererSnapshot, new RendererOperation() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda27
                    @Override // com.tapsdk.tapad.internal.runtime.HostAPIImpl.RendererOperation
                    public final void run(ViewRenderer viewRenderer) {
                        viewRenderer.overlayDestroy(i3);
                    }
                });
                return 0;
            default:
                return -1;
        }
    }

    public void pauseAllVideos() {
        Handler handler = this.mMainHandler;
        final VideoPlayer videoPlayer = this.mVideoPlayer;
        Objects.requireNonNull(videoPlayer);
        handler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda40
            @Override // java.lang.Runnable
            public final void run() {
                videoPlayer.pauseAll();
            }
        });
    }

    public void popup(int i, final int i2, final int i3, final int i4, final int i5, final int i6, final int i7) {
        RendererSnapshot rendererSnapshot = rendererSnapshot(i);
        if (rendererSnapshot == null) {
            return;
        }
        postToRenderer(rendererSnapshot, new RendererOperation() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda43
            @Override // com.tapsdk.tapad.internal.runtime.HostAPIImpl.RendererOperation
            public final void run(ViewRenderer viewRenderer) {
                HostAPIImpl.lambda$popup$48(i2, i3, i4, i5, i6, i7, viewRenderer);
            }
        });
    }

    public void registerAdSurface(int i, WasmModule wasmModule, Object obj, AdCallbackListener adCallbackListener) {
        registerAdSurface(i, wasmModule, obj, adCallbackListener, null);
    }

    public void release() {
        AndroidPrivacyPolicy.removeListener(this.mPrivacyChanged);
        assetRuntimeShutdown();
        this.mVideoPlayer.releaseAll();
        synchronized (this.mVideoOwnerLock) {
            this.mVideoOwnersByHandle.clear();
        }
        clearViewQueryCache();
        this.mHttpClient.shutdown();
        this.mInstallHost.release();
        this.mEnvironmentHost.release();
        cancelHapticVibration();
        clearPendingShortcutIconLoads();
        cancelShortcutPinSessions();
        final ShakeManager shakeManager = this.mShakeManager;
        if (shakeManager != null) {
            this.mShakeManager = null;
            runOnMainSync(new Callable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda37
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return HostAPIImpl.lambda$release$10(shakeManager);
                }
            });
        }
        synchronized (this.mAdSurfaceBindings) {
            this.mAdSurfaceBindings.clear();
        }
        this.mNextOverlayId = 1;
    }

    public void releaseOverlaysForSurface(int i, final ViewRenderer viewRenderer) {
        if (viewRenderer == null) {
            viewRenderer = this.mSurfaceSessions.rendererForSurface(i);
        }
        if (viewRenderer == null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                viewRenderer.overlayDestroyAll();
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.mMainHandler.post(runnable);
        }
    }

    public void releaseVideosForSurface(int i, ViewRenderer viewRenderer) {
        clearViewQueryCacheForSurface(i, viewRenderer);
        ArrayList arrayList = new ArrayList();
        synchronized (this.mVideoOwnerLock) {
            for (int size = this.mVideoOwnersByHandle.size() - 1; size >= 0; size--) {
                VideoOwner videoOwnerValueAt = this.mVideoOwnersByHandle.valueAt(size);
                if (videoOwnerValueAt != null && videoOwnerValueAt.surfaceId == i && (viewRenderer == null || videoOwnerValueAt.renderer == viewRenderer)) {
                    arrayList.add(Integer.valueOf(this.mVideoOwnersByHandle.keyAt(size)));
                    this.mVideoOwnersByHandle.removeAt(size);
                }
            }
        }
        int i2 = 0;
        int size2 = arrayList.size();
        while (i2 < size2) {
            Object obj = arrayList.get(i2);
            i2++;
            final Integer num = (Integer) obj;
            if (num != null) {
                final ViewRenderer viewRendererRendererForSurface = viewRenderer == null ? this.mSurfaceSessions.rendererForSurface(i) : viewRenderer;
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    destroyVideoHandleAndDetachView(num.intValue(), viewRendererRendererForSurface);
                } else {
                    this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda62
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m225lambda$releaseVideosForSurface$35$comtapsdktapadinternalruntimeHostAPIImpl(num, viewRendererRendererForSurface);
                        }
                    });
                }
            }
        }
    }

    public void resumeAllVideos() {
        Handler handler = this.mMainHandler;
        final VideoPlayer videoPlayer = this.mVideoPlayer;
        Objects.requireNonNull(videoPlayer);
        handler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                videoPlayer.resumeAll();
            }
        });
    }

    public int shake(int i, String str, int i2) {
        switch (i) {
            case 0:
                shakeConfigImpl(str, i2);
                return 0;
            case 1:
                return shakeStartSync() ? 1 : 0;
            case 2:
                final ShakeManager shakeManager = this.mShakeManager;
                if (shakeManager != null) {
                    Handler handler = this.mMainHandler;
                    Objects.requireNonNull(shakeManager);
                    handler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda54
                        @Override // java.lang.Runnable
                        public final void run() {
                            shakeManager.stop();
                        }
                    });
                }
                return 0;
            case 3:
                final ShakeManager shakeManager2 = this.mShakeManager;
                if (shakeManager2 != null) {
                    Handler handler2 = this.mMainHandler;
                    Objects.requireNonNull(shakeManager2);
                    handler2.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda53
                        @Override // java.lang.Runnable
                        public final void run() {
                            shakeManager2.reset();
                        }
                    });
                }
                return 0;
            case 4:
                ShakeManager shakeManager3 = this.mShakeManager;
                return (shakeManager3 == null || !shakeManager3.isStarted()) ? 0 : 1;
            default:
                return -1;
        }
    }

    public int storage(int i, String str, byte[] bArr) {
        int iHandleAssignmentStorage = RuntimeDeliveryStore.handleAssignmentStorage(this.mContext, i, str, bArr);
        return iHandleAssignmentStorage != Integer.MIN_VALUE ? iHandleAssignmentStorage : WasmSharedPreferenceApi.call(this.mContext, i, str, bArr);
    }

    public int surfaceAttach(final int i, final int i2, final String str) {
        SurfaceSession live;
        if (i < 0) {
            return -2;
        }
        Integer num = (Integer) runOnMainSync(new Callable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda11
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m230lambda$surfaceAttach$42$comtapsdktapadinternalruntimeHostAPIImpl(i, i2, str);
            }
        });
        int iIntValue = num != null ? num.intValue() : -4;
        if (iIntValue == 0 && (live = this.mSurfaceSessions.getLive(i)) != null) {
            retainFallbackDisplaySpecAsync(live);
        }
        return iIntValue;
    }

    public int surfaceCreate(int i, String str) {
        AdSurfaceBinding adSurfaceBinding;
        WasmModule wasmModule;
        if (i < 0) {
            return -2;
        }
        synchronized (this.mAdSurfaceBindings) {
            adSurfaceBinding = this.mAdSurfaceBindings.get(i);
        }
        if (adSurfaceBinding == null || (wasmModule = adSurfaceBinding.module) == null) {
            return -3;
        }
        try {
            return WasmAdSurfaceHost.create(this.mContext, i, wasmModule, adSurfaceBinding.adImpl, adSurfaceBinding.callbackListener, str);
        } catch (Throwable th) {
            return -4;
        }
    }

    public int surfaceDestroy(int i) {
        if (i < 0) {
            return -2;
        }
        SurfaceSession surfaceSession = this.mSurfaceSessions.get(i);
        ViewRenderer viewRendererRenderer = surfaceSession != null ? surfaceSession.renderer() : null;
        if (this.mSurfaceSessions.destroySurface(i, true) == null) {
            return -3;
        }
        releaseOverlaysForSurface(i, viewRendererRenderer);
        releaseVideosForSurface(i, viewRendererRenderer);
        return 0;
    }

    public int surfaceUpdate(int i, String str) {
        return this.mSurfaceSessions.isLive(i) ? 0 : -2;
    }

    public void track(int i, String str, String str2) {
        if (str == null || str.isEmpty() || i != 0) {
            return;
        }
        try {
            AdnTelemetryHost.report(str, parseTrackPayload(str2));
        } catch (Throwable th) {
        }
    }

    public void unregisterAdSurface(int i) {
        synchronized (this.mAdSurfaceBindings) {
            this.mAdSurfaceBindings.remove(i);
        }
    }

    public void videoAttachToView(int i, final int i2, final int i3) {
        final RendererSnapshot rendererSnapshot = rendererSnapshot(i);
        if (rendererSnapshot == null) {
            return;
        }
        this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda38
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m231lambda$videoAttachToView$30$comtapsdktapadinternalruntimeHostAPIImpl(i2, i3, rendererSnapshot);
            }
        });
    }

    public void videoControl(int i, final int i2, final int i3, final float f) {
        final VideoOwner videoOwnerVideoOwnerForSurface = videoOwnerForSurface(i, i2);
        if (videoOwnerVideoOwnerForSurface == null) {
            return;
        }
        this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m232lambda$videoControl$28$comtapsdktapadinternalruntimeHostAPIImpl(videoOwnerVideoOwnerForSurface, i2, i3, f);
            }
        });
    }

    public int videoCreate(int i, final String str, int i2) {
        final RendererSnapshot rendererSnapshot;
        if (this.mVideoPlayer == null || (rendererSnapshot = rendererSnapshot(i)) == null) {
            return -1;
        }
        final int iAllocateHandle = this.mVideoPlayer.allocateHandle();
        final boolean z = i2 == 1;
        setVideoOwner(iAllocateHandle, rendererSnapshot);
        this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda36
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m233lambda$videoCreate$26$comtapsdktapadinternalruntimeHostAPIImpl(rendererSnapshot, iAllocateHandle, str, z);
            }
        });
        return iAllocateHandle;
    }

    public void videoDestroy(int i, final int i2) {
        final VideoOwner videoOwnerRemoveVideoOwnerForSurface = removeVideoOwnerForSurface(i, i2);
        this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m234lambda$videoDestroy$27$comtapsdktapadinternalruntimeHostAPIImpl(videoOwnerRemoveVideoOwnerForSurface, i2);
            }
        });
    }

    public void videoOnEvent(int i, int i2, int i3, int i4) {
        CallbackRegistry.CallbackType callbackType;
        if (videoOwnerForSurface(i, i2) == null) {
            return;
        }
        switch (i3) {
            case 0:
                callbackType = CallbackRegistry.CallbackType.VIDEO_PROGRESS;
                break;
            case 1:
                callbackType = CallbackRegistry.CallbackType.VIDEO_COMPLETE;
                break;
            case 2:
                callbackType = CallbackRegistry.CallbackType.VIDEO_ERROR;
                break;
            case 3:
                callbackType = CallbackRegistry.CallbackType.VIDEO_READY;
                break;
            case 4:
                callbackType = CallbackRegistry.CallbackType.VIDEO_FIRST_FRAME;
                break;
            case 5:
                callbackType = CallbackRegistry.CallbackType.VIDEO_SIZE_CHANGED;
                break;
            default:
                return;
        }
        this.mCallbackRegistry.register(i2, callbackType, i4);
        if (callbackType == CallbackRegistry.CallbackType.VIDEO_SIZE_CHANGED) {
            int videoWidth = (int) this.mVideoPlayer.getVideoWidth(i2);
            int videoHeight = (int) this.mVideoPlayer.getVideoHeight(i2);
            if (videoWidth <= 0 || videoHeight <= 0) {
                return;
            }
            DirichletRuntime.getInstance().triggerCallbackWithCoords(i4, videoWidth, videoHeight);
        }
    }

    public float videoQuery(int i, final int i2, final int i3) {
        Float f;
        final VideoOwner videoOwnerVideoOwnerForSurface = videoOwnerForSurface(i, i2);
        if (videoOwnerVideoOwnerForSurface == null || (f = (Float) runOnMainSync(new Callable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda61
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m235lambda$videoQuery$29$comtapsdktapadinternalruntimeHostAPIImpl(videoOwnerVideoOwnerForSurface, i2, i3);
            }
        })) == null) {
            return 0.0f;
        }
        return f.floatValue();
    }

    public void viewAddChild(int i, final int i2, final int i3) {
        RendererSnapshot rendererSnapshot = rendererSnapshot(i);
        if (rendererSnapshot == null) {
            return;
        }
        postToRenderer(rendererSnapshot, new RendererOperation() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda25
            @Override // com.tapsdk.tapad.internal.runtime.HostAPIImpl.RendererOperation
            public final void run(ViewRenderer viewRenderer) {
                viewRenderer.addChild(i2, i3);
            }
        });
    }

    public int viewCreate(int i, final int i2, final String str) {
        RendererSnapshot rendererSnapshot = rendererSnapshot(i);
        if (rendererSnapshot == null) {
            return -1;
        }
        final int iAllocateHandle = rendererSnapshot.renderer.allocateHandle();
        postToRenderer(rendererSnapshot, new RendererOperation() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda55
            @Override // com.tapsdk.tapad.internal.runtime.HostAPIImpl.RendererOperation
            public final void run(ViewRenderer viewRenderer) {
                viewRenderer.createViewForHandle(iAllocateHandle, i2, str);
            }
        });
        return iAllocateHandle;
    }

    public void viewDestroy(int i, final int i2) {
        RendererSnapshot rendererSnapshot = rendererSnapshot(i);
        if (rendererSnapshot == null) {
            return;
        }
        postAcceptedTeardownToRenderer(rendererSnapshot, new RendererOperation() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda32
            @Override // com.tapsdk.tapad.internal.runtime.HostAPIImpl.RendererOperation
            public final void run(ViewRenderer viewRenderer) {
                viewRenderer.destroyView(i2);
            }
        });
    }

    public void viewHide(int i, final int i2) {
        RendererSnapshot rendererSnapshot = rendererSnapshot(i);
        if (rendererSnapshot == null) {
            return;
        }
        postToRenderer(rendererSnapshot, new RendererOperation() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda41
            @Override // com.tapsdk.tapad.internal.runtime.HostAPIImpl.RendererOperation
            public final void run(ViewRenderer viewRenderer) {
                viewRenderer.hideView(i2);
            }
        });
    }

    public void viewOnClick(int i, final int i2, final int i3) {
        RendererSnapshot rendererSnapshot = rendererSnapshot(i);
        if (rendererSnapshot == null) {
            return;
        }
        postToRenderer(rendererSnapshot, new RendererOperation() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.internal.runtime.HostAPIImpl.RendererOperation
            public final void run(ViewRenderer viewRenderer) {
                this.f$0.m238lambda$viewOnClick$23$comtapsdktapadinternalruntimeHostAPIImpl(i3, i2, viewRenderer);
            }
        });
    }

    public void viewOnTouch(int i, final int i2, final int i3, final int i4) {
        RendererSnapshot rendererSnapshot = rendererSnapshot(i);
        if (rendererSnapshot == null) {
            return;
        }
        postToRenderer(rendererSnapshot, new RendererOperation() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda39
            @Override // com.tapsdk.tapad.internal.runtime.HostAPIImpl.RendererOperation
            public final void run(ViewRenderer viewRenderer) {
                this.f$0.m240lambda$viewOnTouch$25$comtapsdktapadinternalruntimeHostAPIImpl(i3, i2, i4, viewRenderer);
            }
        });
    }

    public float viewQuery(int i, final int i2, int i3) {
        final RendererSnapshot rendererSnapshot;
        if (i3 < 0 || i3 >= 7 || (rendererSnapshot = rendererSnapshot(i)) == null) {
            return 0.0f;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.mViewQueryCacheSurfaceId == i && this.mViewQueryCacheHandle == i2 && this.mViewQueryCacheRenderer == rendererSnapshot.renderer && jUptimeMillis - this.mViewQueryCacheTimeMs < 16) {
            return this.mViewQueryCachePayload[i3];
        }
        final float[] fArr = new float[7];
        Boolean bool = (Boolean) runOnMainSync(new Callable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda26
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m241lambda$viewQuery$19$comtapsdktapadinternalruntimeHostAPIImpl(rendererSnapshot, i2, fArr);
            }
        });
        if (bool != null && bool.booleanValue()) {
            this.mViewQueryCacheSurfaceId = i;
            this.mViewQueryCacheHandle = i2;
            this.mViewQueryCacheRenderer = rendererSnapshot.renderer;
            this.mViewQueryCacheTimeMs = jUptimeMillis;
            System.arraycopy(fArr, 0, this.mViewQueryCachePayload, 0, 7);
            return fArr[i3];
        }
        return 0.0f;
    }

    public void viewSetImage(int i, final int i2, final String str) {
        RendererSnapshot rendererSnapshot = rendererSnapshot(i);
        if (rendererSnapshot == null) {
            return;
        }
        postToRenderer(rendererSnapshot, new RendererOperation() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda21
            @Override // com.tapsdk.tapad.internal.runtime.HostAPIImpl.RendererOperation
            public final void run(ViewRenderer viewRenderer) {
                viewRenderer.setImage(i2, str);
            }
        });
    }

    public void viewSetLayout(int i, final int i2, final float f, final float f2, final float f3, final float f4) {
        RendererSnapshot rendererSnapshot = rendererSnapshot(i);
        if (rendererSnapshot == null) {
            return;
        }
        postToRenderer(rendererSnapshot, new RendererOperation() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda7
            @Override // com.tapsdk.tapad.internal.runtime.HostAPIImpl.RendererOperation
            public final void run(ViewRenderer viewRenderer) {
                viewRenderer.setLayout(i2, f, f2, f3, f4);
            }
        });
    }

    public void viewSetStyle(int i, final int i2, final String str, final String str2) {
        RendererSnapshot rendererSnapshot = rendererSnapshot(i);
        if (rendererSnapshot == null) {
            return;
        }
        postToRenderer(rendererSnapshot, new RendererOperation() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda58
            @Override // com.tapsdk.tapad.internal.runtime.HostAPIImpl.RendererOperation
            public final void run(ViewRenderer viewRenderer) {
                viewRenderer.setStyle(i2, str, str2);
            }
        });
    }

    public void viewSetText(int i, final int i2, final String str) {
        RendererSnapshot rendererSnapshot = rendererSnapshot(i);
        if (rendererSnapshot == null) {
            return;
        }
        postToRenderer(rendererSnapshot, new RendererOperation() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda22
            @Override // com.tapsdk.tapad.internal.runtime.HostAPIImpl.RendererOperation
            public final void run(ViewRenderer viewRenderer) {
                viewRenderer.setText(i2, str);
            }
        });
    }

    public void viewShow(int i, final int i2) {
        RendererSnapshot rendererSnapshot = rendererSnapshot(i);
        if (rendererSnapshot == null) {
            return;
        }
        postToRenderer(rendererSnapshot, new RendererOperation() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda8
            @Override // com.tapsdk.tapad.internal.runtime.HostAPIImpl.RendererOperation
            public final void run(ViewRenderer viewRenderer) {
                viewRenderer.showView(i2);
            }
        });
    }

    public HostAPIImpl(Context context, SurfaceSessionRegistry surfaceSessionRegistry, DownloadInteractionReporter downloadInteractionReporter) {
        Handler handler = new Handler(Looper.getMainLooper());
        this.mMainHandler = handler;
        this.mAdSurfaceBindings = new SparseArray<>();
        this.mVideoOwnerLock = new Object();
        this.mVideoOwnersByHandle = new SparseArray<>();
        this.mShortcutIconTargetLock = new Object();
        this.mShortcutIconTargets = new ArrayList();
        this.mShortcutPinSessionLock = new Object();
        this.mShortcutPinSessions = new ArrayList();
        this.mNextOverlayId = 1;
        this.mHttpClient = HttpClient.getInstance();
        this.mCallbackRegistry = CallbackRegistry.getInstance();
        this.mPreviewHttpAllowedHosts = Collections.EMPTY_SET;
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda33
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m222lambda$new$1$comtapsdktapadinternalruntimeHostAPIImpl();
            }
        };
        this.mPrivacyChanged = runnable;
        this.mLastTouchXDp10 = -1;
        this.mLastTouchYDp10 = -1;
        this.mViewQueryCacheSurfaceId = -1;
        this.mViewQueryCacheHandle = -1;
        this.mViewQueryCacheTimeMs = 0L;
        this.mViewQueryCachePayload = new float[7];
        this.mContext = context;
        this.mSurfaceSessions = surfaceSessionRegistry;
        this.mVideoPlayer = new VideoPlayer(context);
        this.mDownloadHost = AndroidDownloadHost.get(context);
        this.mDownloadInteractionReporter = downloadInteractionReporter;
        this.mInstallHost = new AndroidInstallHost(context, handler);
        this.mEnvironmentHost = new AndroidEnvironmentHost(context);
        AndroidPrivacyPolicy.addListener(runnable);
        this.mAssetTransferExecutor = new AssetTransferExecutor(context, new AssetTransferExecutor.FactSink() { // from class: com.tapsdk.tapad.internal.runtime.HostAPIImpl$$ExternalSyntheticLambda34
            @Override // com.tapsdk.tapad.internal.runtime.AssetTransferExecutor.FactSink
            public final void submit(byte[] bArr) {
                DirichletRuntime.getInstance().submitAssetFact(bArr);
            }
        });
        initVideoPlayer();
        initHttpClient();
    }

    private boolean removeVideoOwnerIfMatches(int i, int i2, ViewRenderer viewRenderer) {
        synchronized (this.mVideoOwnerLock) {
            VideoOwner videoOwner = this.mVideoOwnersByHandle.get(i);
            if (videoOwner != null && videoOwner.surfaceId == i2 && videoOwner.renderer == viewRenderer) {
                this.mVideoOwnersByHandle.remove(i);
                return true;
            }
            return false;
        }
    }

    private boolean startSchemeIntent(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent uri = (str.startsWith("intent:") || str.startsWith("intent://")) ? Intent.parseUri(str, 1) : new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (!TextUtils.isEmpty(str2)) {
                uri.setPackage(str2);
            }
            uri.addFlags(C.ENCODING_PCM_MU_LAW);
            this.mContext.startActivity(uri);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void registerAdSurface(int i, WasmModule wasmModule, Object obj, AdCallbackListener adCallbackListener, Activity activity) {
        if (i < 0 || wasmModule == null) {
            return;
        }
        synchronized (this.mAdSurfaceBindings) {
            this.mAdSurfaceBindings.put(i, new AdSurfaceBinding(wasmModule, obj, adCallbackListener, activity));
        }
    }

    private boolean isVideoOwnerAlive(VideoOwner videoOwner, int i) {
        if (videoOwner == null) {
            return false;
        }
        synchronized (this.mVideoOwnerLock) {
            if (this.mVideoOwnersByHandle.get(i) != videoOwner) {
                return false;
            }
            return this.mSurfaceSessions.rendererForSurface(videoOwner.surfaceId) == videoOwner.renderer;
        }
    }
}
