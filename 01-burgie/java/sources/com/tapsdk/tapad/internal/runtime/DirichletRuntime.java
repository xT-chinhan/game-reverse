package com.tapsdk.tapad.internal.runtime;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseArray;
import com.tapsdk.tapad.MediaPreConversionHook;
import com.tapsdk.tapad.c;
import com.tapsdk.tapad.internal.observability.AdnTelemetryHost;
import com.tapsdk.tapad.internal.runtime.bundle.BundleId;
import com.tapsdk.tapad.internal.runtime.bundle.BundleManifest;
import com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry;
import com.tapsdk.tapad.internal.runtime.bundle.BundleUpdater;
import com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader;
import com.tapsdk.tapad.internal.runtime.plugin.AdCallbackListener;
import com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity;
import com.umeng.analytics.pro.d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class DirichletRuntime {
    private static final int BUNDLE_SOURCE_PREVIEW = 6;
    private static final int CORE_LOADER_ABI = 1;
    private static final List<String> EAGER_BUNDLES = Collections.singletonList("core");
    private static final String IONIA_DEX_ASSET = "dirichlet/security/ionia_dex_v1.dat";
    private static final String TAG = "DirichletRuntime";
    private static volatile DirichletRuntime sInstance;
    private final SparseArray<NativeCallback> mCallbackMap;
    private Context mContext;
    private final Map<String, NativeCallback> mControlCallbackMap;
    private Set<String> mForceEmbeddedBundleIds;
    private HostAPIImpl mHostAPI;
    private final SparseArray<WasmAdInstance> mInstances;
    private volatile MediaPreConversionHook mMediaPreConversionHook;
    private volatile Map<String, byte[]> mPreviewAssets;
    private Set<String> mRecoveryBaselineBundleIds;
    private Handler mRuntimeQueueHandler;
    private HandlerThread mRuntimeQueueThread;
    private final SurfaceSessionRegistry mSurfaceSessions;
    private long mNativePtr = 0;
    private volatile boolean mInitialized = false;
    private boolean mEagerBundlesInstalled = false;
    private volatile boolean mPricingPolicyStoreInitialized = false;
    private volatile boolean mSchedulerPolicyStoreInitialized = false;
    private volatile boolean mAssetRuntimeInitialized = false;
    private volatile boolean mSecurityHostInitialized = false;
    private volatile boolean mPricingPolicyModulePreparing = false;
    private final ModuleStore mModules = new ModuleStore();
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private final Object mRuntimeQueueLock = new Object();
    private final Map<String, BundleManager> mBundles = new HashMap();
    private final Set<String> mInstalled = Collections.synchronizedSet(new LinkedHashSet());

    public static final class IoniaSecurityPackage {
        public final byte[] dex;
        public final long version;
        public final byte[] wasm;

        private IoniaSecurityPackage(long j, byte[] bArr, byte[] bArr2) {
            this.version = j;
            this.wasm = bArr;
            this.dex = bArr2;
        }
    }

    public interface ModuleLoadCallback {
        void onError(Exception exc);

        void onSuccess(WasmModule wasmModule);
    }

    public interface NativeCallback {
        void onCallback(String str, String str2);
    }

    static {
        NativeLibraryLoader.load();
    }

    private DirichletRuntime() {
        Set<String> set = Collections.EMPTY_SET;
        this.mForceEmbeddedBundleIds = set;
        this.mRecoveryBaselineBundleIds = set;
        this.mPreviewAssets = Collections.EMPTY_MAP;
        this.mCallbackMap = new SparseArray<>();
        this.mControlCallbackMap = new HashMap();
        this.mSurfaceSessions = new SurfaceSessionRegistry();
        this.mInstances = new SparseArray<>();
    }

    private void activatePendingStyleBundle() {
        if (this.mForceEmbeddedBundleIds.contains(BundleId.STYLE)) {
            return;
        }
        activateStyleBundle();
        BundleUpdater.ActivationResult activationResult = BundleUpdater.ActivationResult.ACTIVATED;
    }

    private BundleUpdater.ActivationResult activateStyleBundle() {
        boolean zActivateCurrent;
        synchronized (this) {
            if (this.mInitialized && this.mNativePtr != 0) {
                BundleManager bundleManager = this.mBundles.get(BundleId.STYLE);
                if (bundleManager == null) {
                    bundleManager = new BundleManager(this.mContext, BundleId.STYLE);
                    this.mBundles.put(BundleId.STYLE, bundleManager);
                }
                if (this.mInstalled.contains(BundleId.STYLE)) {
                    return bundleManager.cacheFile().isFile() ? BundleUpdater.ActivationResult.DEFERRED : BundleUpdater.ActivationResult.ACTIVATED;
                }
                if (bundleManager.cacheFile().isFile()) {
                    zActivateCurrent = bundleManager.activateCandidate(loaderFor(BundleId.STYLE));
                } else {
                    if (!bundleManager.currentFile().isFile()) {
                        return BundleUpdater.ActivationResult.DEFERRED;
                    }
                    zActivateCurrent = bundleManager.activateCurrent(loaderFor(BundleId.STYLE));
                }
                if (!zActivateCurrent) {
                    return BundleUpdater.ActivationResult.FAILED;
                }
                this.mInstalled.add(BundleId.STYLE);
                return BundleUpdater.ActivationResult.ACTIVATED;
            }
            return BundleUpdater.ActivationResult.DEFERRED;
        }
    }

    private static void deleteLegacyLottieCache(Context context) {
        File file = new File(context.getCacheDir(), "tapad_resources/lottie");
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    file2.delete();
                }
            }
        }
        file.delete();
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.delete();
        }
    }

    private void dispatchEvent(int i, int[] iArr, String str) {
        long j = this.mNativePtr;
        if (j != 0) {
            nativeDispatchEvent(j, i, iArr, str);
        }
    }

    private Handler ensureRuntimeQueueHandler() {
        Handler handler;
        synchronized (this.mRuntimeQueueLock) {
            HandlerThread handlerThread = this.mRuntimeQueueThread;
            if (handlerThread == null || !handlerThread.isAlive()) {
                HandlerThread handlerThread2 = new HandlerThread("dirichlet-wasm-runtime");
                this.mRuntimeQueueThread = handlerThread2;
                handlerThread2.start();
                this.mRuntimeQueueHandler = new Handler(this.mRuntimeQueueThread.getLooper());
            }
            handler = this.mRuntimeQueueHandler;
        }
        return handler;
    }

    public static DirichletRuntime getInstance() {
        if (sInstance == null) {
            synchronized (DirichletRuntime.class) {
                if (sInstance == null) {
                    sInstance = new DirichletRuntime();
                }
            }
        }
        return sInstance;
    }

    private void initInternal(Context context, boolean z, byte[] bArr) {
        if (!this.mInitialized) {
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext;
            this.mHostAPI = new HostAPIImpl(applicationContext, this.mSurfaceSessions);
            long jNativeInit = nativeInit(65536);
            this.mNativePtr = jNativeInit;
            if (jNativeInit == 0) {
                return;
            }
            deleteLegacyLottieCache(this.mContext);
            this.mAssetRuntimeInitialized = nativeInitAssetRuntime(this.mNativePtr, new File(this.mContext.getCacheDir(), "dirichlet/assets-v1").getAbsolutePath());
            nativeSetHostAPI(this.mNativePtr, this.mHostAPI);
            if (bArr == null || bArr.length == 0) {
                try {
                    bArr = readAsset(IONIA_DEX_ASSET);
                } catch (IOException e) {
                }
            }
            this.mSecurityHostInitialized = bArr != null && bArr.length > 0 && nativeInitSecurityHost(this.mNativePtr, this.mContext, bArr);
            this.mInitialized = true;
        }
        if (z) {
            installEagerBundles();
        }
    }

    private void initializePricingPolicyStore() {
        if (this.mNativePtr == 0 || this.mContext == null) {
            return;
        }
        if (!this.mPricingPolicyStoreInitialized) {
            this.mPricingPolicyStoreInitialized = nativeInitPricingPolicyStore(this.mNativePtr, new File(this.mContext.getNoBackupFilesDir(), "dirichlet/pricing-policy").getAbsolutePath());
        }
        if (this.mSchedulerPolicyStoreInitialized) {
            return;
        }
        this.mSchedulerPolicyStoreInitialized = nativeInitSchedulerPolicyStore(this.mNativePtr, new File(this.mContext.getNoBackupFilesDir(), "dirichlet/scheduler-policy").getAbsolutePath());
    }

    private boolean installBundle(String str) {
        if (this.mNativePtr == 0) {
            return false;
        }
        if (this.mInstalled.contains(str)) {
            return true;
        }
        BundleManager bundleManager = this.mBundles.get(str);
        if (bundleManager == null) {
            bundleManager = new BundleManager(this.mContext, str);
            this.mBundles.put(str, bundleManager);
        }
        boolean zInstall = bundleManager.install(loaderFor(str), this.mForceEmbeddedBundleIds.contains(str), this.mRecoveryBaselineBundleIds.contains(str));
        if (zInstall) {
            this.mInstalled.add(str);
        }
        return zInstall;
    }

    private void installEagerBundles() {
        if (this.mEagerBundlesInstalled) {
            if (this.mInstalled.contains("core") && shouldPrepareAuctionCore()) {
                preparePricingPolicyModule();
                return;
            }
            return;
        }
        boolean zInstallBundle = true;
        Iterator<String> it = EAGER_BUNDLES.iterator();
        while (it.hasNext()) {
            zInstallBundle &= installBundle(it.next());
        }
        this.mEagerBundlesInstalled = zInstallBundle;
        Objects.toString(this.mInstalled);
        if (this.mInstalled.contains("core") && shouldPrepareAuctionCore()) {
            preparePricingPolicyModule();
        }
        if (this.mInstalled.contains("core")) {
            activatePendingStyleBundle();
        }
    }

    private static boolean isPricingPolicyModule(String str) {
        return shouldPrepareAuctionCore() && pricingPolicyModuleName().equals(str);
    }

    private /* synthetic */ void lambda$loadPreviewModule$4(String str, final ModuleLoadCallback moduleLoadCallback, byte[] bArr) {
        try {
            final WasmModule wasmModule = this.mModules.get(str);
            if (wasmModule != null) {
                if (moduleLoadCallback != null) {
                    this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            moduleLoadCallback.onSuccess(wasmModule);
                        }
                    });
                    return;
                }
                return;
            }
            long jNativeLoadPreviewModule = nativeLoadPreviewModule(this.mNativePtr, bArr, str, CoreModuleSelector.domainForModuleName(str));
            if (jNativeLoadPreviewModule == 0) {
                if (moduleLoadCallback != null) {
                    this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            moduleLoadCallback.onError(new RuntimeException("Preview WASM load failed"));
                        }
                    });
                }
            } else {
                final WasmModule wasmModule2 = new WasmModule(str, jNativeLoadPreviewModule);
                this.mModules.put(str, wasmModule2);
                this.mInstalled.add("core");
                if (moduleLoadCallback != null) {
                    this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            moduleLoadCallback.onSuccess(wasmModule2);
                        }
                    });
                }
            }
        } catch (Throwable th) {
            if (moduleLoadCallback != null) {
                this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        moduleLoadCallback.onError(new RuntimeException("Preview WASM load failed", th));
                    }
                });
            }
        }
    }

    private void loadPricingPolicyModule(final String str) {
        loadModuleFromBundle("core", str, pricingPolicyModuleName(), new ModuleLoadCallback() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime.1
            @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.ModuleLoadCallback
            public void onError(Exception exc) {
                DirichletRuntime.this.mPricingPolicyModulePreparing = false;
            }

            @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.ModuleLoadCallback
            public void onSuccess(WasmModule wasmModule) {
                DirichletRuntime.this.mPricingPolicyModulePreparing = false;
            }
        });
    }

    private BundleManager.Loader loaderFor(final String str) {
        return new BundleManager.Loader() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda7
            @Override // com.tapsdk.tapad.internal.runtime.BundleManager.Loader
            public final boolean load(byte[] bArr, long j, int i) {
                return this.f$0.m207lambda$loaderFor$5$comtapsdktapadinternalruntimeDirichletRuntime(str, bArr, j, i);
            }
        };
    }

    private native boolean nativeAssetMemoryPressure(long j);

    private native byte[] nativeBundleReadAsset(long j, String str, String str2);

    private native boolean nativeClearAssetCache(long j);

    private native void nativeDestroy(long j);

    private native void nativeDispatchEvent(long j, int i, int[] iArr, String str);

    private native boolean nativeDispatchHttpResponse(long j, int i, int i2, int i3, String str, byte[] bArr);

    private static native byte[] nativeExtractIoniaSecurityPackage(byte[] bArr, long j);

    private native long nativeInit(int i);

    private native boolean nativeInitAssetRuntime(long j, String str);

    private native boolean nativeInitPricingPolicyStore(long j, String str);

    private native boolean nativeInitSchedulerPolicyStore(long j, String str);

    private native boolean nativeInitSecurityHost(long j, Context context, byte[] bArr);

    private native boolean nativeLoadBundle(long j, String str, byte[] bArr, long j2, int i, int i2, int i3);

    private native long nativeLoadModuleFromBundle(long j, String str, String str2, String str3, int i);

    private native long nativeLoadPreviewModule(long j, byte[] bArr, String str, int i);

    private native long nativeLoadSecurityModule(long j, byte[] bArr, String str);

    private static native String nativePublisherSettingsSnapshot();

    private static native boolean nativePutPublisherSetting(String str, String str2);

    private native void nativeSetHostAPI(long j, HostAPIImpl hostAPIImpl);

    private native boolean nativeSubmitAssetFact(long j, byte[] bArr);

    private native void nativeUnloadModule(long j, String str);

    private void preparePricingPolicyModule() {
        if (this.mModules.get(pricingPolicyModuleName()) != null) {
            initializePricingPolicyStore();
        } else {
            if (this.mPricingPolicyModulePreparing || !this.mInstalled.contains("core")) {
                return;
            }
            this.mPricingPolicyModulePreparing = true;
            loadPricingPolicyModule(CoreModuleSelector.WASM_ENTRY);
        }
    }

    private static String pricingPolicyModuleName() {
        return "core";
    }

    public static String publisherSettingsSnapshot() {
        return nativePublisherSettingsSnapshot();
    }

    public static boolean putPublisherSetting(String str, String str2) {
        return nativePutPublisherSetting(str, str2);
    }

    private byte[] readAsset(String str) throws IOException {
        InputStream inputStreamOpen = this.mContext.getAssets().open(str);
        try {
            byte[] bArr = new byte[16384];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    inputStreamOpen.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private static long readLe32(byte[] bArr, int i) {
        return ((((long) bArr[i + 3]) & 255) << 24) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16);
    }

    private static long readLe64(byte[] bArr, int i) {
        return (readLe32(bArr, i + 4) << 32) | readLe32(bArr, i);
    }

    private static boolean shouldPrepareAuctionCore() {
        return CoreProductPolicy.auctionCoreEnabled(2);
    }

    private void stopRuntimeQueue() {
        HandlerThread handlerThread;
        synchronized (this.mRuntimeQueueLock) {
            handlerThread = this.mRuntimeQueueThread;
            this.mRuntimeQueueThread = null;
            this.mRuntimeQueueHandler = null;
        }
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
    }

    private void trackRuntimeQueueThrowable(Throwable th) {
        try {
            HashMap map = new HashMap();
            map.put(d.Q, "wasm_runtime_queue");
            map.put("error_type", "java_throwable");
            AdnTelemetryHost.reportThrowable("wasm_runtime_queue_task_failed", th, map);
        } catch (Throwable th2) {
        }
    }

    public BundleUpdater.ActivationResult activateDownloadedBundle(BundleManifest bundleManifest) {
        return (bundleManifest == null || !BundleId.STYLE.equals(bundleManifest.id)) ? BundleUpdater.ActivationResult.FAILED : activateStyleBundle();
    }

    public boolean attachSurfaceRenderer(int i, ViewRenderer viewRenderer) {
        return this.mSurfaceSessions.attachRenderer(i, viewRenderer);
    }

    public boolean clearAssetCache() {
        long j = this.mNativePtr;
        return j != 0 && this.mAssetRuntimeInitialized && nativeClearAssetCache(j);
    }

    public synchronized boolean configurePreviewHttpAllowedHosts(List<String> list) {
        return false;
    }

    public int createSurfaceSession(int i, WasmModule wasmModule, Object obj, String str, BaseAdActivity.AdActivityConfig adActivityConfig, AdCallbackListener adCallbackListener) {
        return this.mSurfaceSessions.createSurface(i, wasmModule, obj, str, adActivityConfig, adCallbackListener);
    }

    public synchronized void destroy() {
        this.mModules.invalidateAllAndClear();
        HostAPIImpl hostAPIImpl = this.mHostAPI;
        if (hostAPIImpl != null) {
            hostAPIImpl.assetRuntimeShutdown();
        }
        long j = this.mNativePtr;
        if (j != 0) {
            nativeDestroy(j);
            this.mNativePtr = 0L;
        }
        HostAPIImpl hostAPIImpl2 = this.mHostAPI;
        if (hostAPIImpl2 != null) {
            hostAPIImpl2.release();
            this.mHostAPI = null;
        }
        this.mSurfaceSessions.clear();
        this.mInstalled.clear();
        this.mBundles.clear();
        this.mPreviewAssets = Collections.EMPTY_MAP;
        synchronized (this.mInstances) {
            this.mInstances.clear();
        }
        synchronized (this.mCallbackMap) {
            this.mCallbackMap.clear();
        }
        stopRuntimeQueue();
        this.mInitialized = false;
        this.mEagerBundlesInstalled = false;
        this.mPricingPolicyStoreInitialized = false;
        this.mSchedulerPolicyStoreInitialized = false;
        this.mAssetRuntimeInitialized = false;
        this.mPricingPolicyModulePreparing = false;
    }

    public void destroySurfaceSession(int i) {
        HostAPIImpl hostAPIImpl = this.mHostAPI;
        if (hostAPIImpl != null) {
            hostAPIImpl.surfaceDestroy(i);
        } else {
            this.mSurfaceSessions.destroySurface(i, true);
        }
    }

    public void destroySurfaceSessionFromActivity(int i) {
        HostAPIImpl hostAPIImpl;
        SurfaceSession surfaceSession = this.mSurfaceSessions.get(i);
        ViewRenderer viewRendererRenderer = surfaceSession != null ? surfaceSession.renderer() : null;
        if (this.mSurfaceSessions.destroySurface(i, false) == null || (hostAPIImpl = this.mHostAPI) == null) {
            return;
        }
        hostAPIImpl.releaseOverlaysForSurface(i, viewRendererRenderer);
        this.mHostAPI.releaseVideosForSurface(i, viewRendererRenderer);
    }

    public void detachSurfaceRenderer(int i, ViewRenderer viewRenderer) {
        this.mSurfaceSessions.detachRenderer(i, viewRenderer);
        HostAPIImpl hostAPIImpl = this.mHostAPI;
        if (hostAPIImpl != null) {
            hostAPIImpl.releaseOverlaysForSurface(i, viewRenderer);
            this.mHostAPI.releaseVideosForSurface(i, viewRenderer);
        }
    }

    public boolean dispatchAndroidWebViewFact(final int i, final int i2, final int i3, final String str) {
        if (this.mNativePtr == 0 || i < 0 || i2 < 0 || i3 <= 0 || str == null || str.length() == 0) {
            return false;
        }
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m203lambda$dispatchAndroidWebViewFact$20$comtapsdktapadinternalruntimeDirichletRuntime(i, i2, i3, str);
            }
        };
        if (!isOnRuntimeQueue()) {
            return runOnRuntimeQueue(runnable);
        }
        runnable.run();
        return true;
    }

    public boolean dispatchCreativeWebEvent(final int i, final int i2, final String str) {
        if (this.mNativePtr == 0 || i < 0 || i2 < 0 || str == null || str.length() == 0) {
            return false;
        }
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m204lambda$dispatchCreativeWebEvent$19$comtapsdktapadinternalruntimeDirichletRuntime(i, i2, str);
            }
        };
        if (!isOnRuntimeQueue()) {
            return runOnRuntimeQueue(runnable);
        }
        runnable.run();
        return true;
    }

    public void dispatchHttpResponse(int i, int i2, int i3, String str, byte[] bArr) {
        long j = this.mNativePtr;
        if (j != 0) {
            nativeDispatchHttpResponse(j, i, i2, i3, str != null ? str : "", bArr != null ? bArr : new byte[0]);
        }
    }

    public boolean dispatchSurfaceCallback(int i, String str, String str2) {
        return this.mSurfaceSessions.dispatchSurfaceCallback(i, str, str2);
    }

    public IoniaSecurityPackage extractIoniaSecurityPackage(byte[] bArr, long j) {
        if (bArr != null && bArr.length != 0) {
            try {
                byte[] bArrNativeExtractIoniaSecurityPackage = nativeExtractIoniaSecurityPackage(bArr, j);
                if (bArrNativeExtractIoniaSecurityPackage != null && bArrNativeExtractIoniaSecurityPackage.length >= 20 && bArrNativeExtractIoniaSecurityPackage[0] == 73 && bArrNativeExtractIoniaSecurityPackage[1] == 83 && bArrNativeExtractIoniaSecurityPackage[2] == 66 && bArrNativeExtractIoniaSecurityPackage[3] == 49) {
                    long le64 = readLe64(bArrNativeExtractIoniaSecurityPackage, 4);
                    long le32 = readLe32(bArrNativeExtractIoniaSecurityPackage, 12);
                    long le33 = readLe32(bArrNativeExtractIoniaSecurityPackage, 16);
                    long j2 = 20 + le32 + le33;
                    if (le64 > 0 && le32 > 0 && le33 > 0 && j2 == bArrNativeExtractIoniaSecurityPackage.length && le32 <= 2147483647L && le33 <= 2147483647L) {
                        int i = (int) le32;
                        byte[] bArr2 = new byte[i];
                        int i2 = (int) le33;
                        byte[] bArr3 = new byte[i2];
                        System.arraycopy(bArrNativeExtractIoniaSecurityPackage, 20, bArr2, 0, i);
                        System.arraycopy(bArrNativeExtractIoniaSecurityPackage, i + 20, bArr3, 0, i2);
                        return new IoniaSecurityPackage(le64, bArr2, bArr3);
                    }
                }
                return null;
            } catch (Throwable th) {
            }
        }
        return null;
    }

    public NativeCallback getCallbackForInstance(int i) {
        NativeCallback nativeCallback;
        synchronized (this.mCallbackMap) {
            nativeCallback = this.mCallbackMap.get(i);
        }
        return nativeCallback;
    }

    public NativeCallback getControlCallback(String str) {
        NativeCallback nativeCallback;
        synchronized (this.mControlCallbackMap) {
            nativeCallback = this.mControlCallbackMap.get(str);
        }
        return nativeCallback;
    }

    public long getInstalledBundleVersionCode(String str) {
        Context context = this.mContext;
        if (context == null) {
            return 0L;
        }
        return BundleRegistry.get(context).getActiveBundleVersionCode(str);
    }

    public WasmModule getModule(String str) {
        return this.mModules.get(str);
    }

    public synchronized void init(Context context) {
        initInternal(context, true, null);
    }

    public synchronized void initRuntimeOnly(Context context) {
        initInternal(context, false, null);
    }

    public synchronized boolean installPreviewAssets(Map<String, byte[]> map) {
        return false;
    }

    public synchronized boolean installPreviewBundle(byte[] bArr) {
        return false;
    }

    public boolean invokeMediaPreConversionHook(String str, String str2) {
        MediaPreConversionHook mediaPreConversionHook = this.mMediaPreConversionHook;
        Context context = this.mContext;
        if (mediaPreConversionHook == null || context == null) {
            return false;
        }
        HashMap map = new HashMap();
        map.put("intermediate_page_required", 1);
        if (str == null) {
            str = "";
        }
        map.put("src", str);
        if (str2 != null && !str2.isEmpty()) {
            map.put("link", str2);
        }
        return mediaPreConversionHook.handleNavigationIfEligible(context, map);
    }

    public boolean isBundleInstalled(String str) {
        return this.mInstalled.contains(str);
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public boolean isInstanceLive(int i) {
        boolean z;
        synchronized (this.mInstances) {
            z = this.mInstances.get(i) != null;
        }
        return z;
    }

    public boolean isOnRuntimeQueue() {
        boolean z;
        synchronized (this.mRuntimeQueueLock) {
            z = this.mRuntimeQueueThread != null && Looper.myLooper() == this.mRuntimeQueueThread.getLooper();
        }
        return z;
    }

    public boolean isReady() {
        return this.mInitialized && this.mNativePtr != 0 && this.mInstalled.contains("core");
    }

    public boolean isSecurityHostInitialized() {
        return this.mSecurityHostInitialized;
    }

    /* JADX INFO: renamed from: lambda$dispatchAndroidWebViewFact$20$com-tapsdk-tapad-internal-runtime-DirichletRuntime, reason: not valid java name */
    /* synthetic */ void m203lambda$dispatchAndroidWebViewFact$20$comtapsdktapadinternalruntimeDirichletRuntime(int i, int i2, int i3, String str) {
        dispatchEvent(23, new int[]{i, i2, i3}, str);
    }

    /* JADX INFO: renamed from: lambda$dispatchCreativeWebEvent$19$com-tapsdk-tapad-internal-runtime-DirichletRuntime, reason: not valid java name */
    /* synthetic */ void m204lambda$dispatchCreativeWebEvent$19$comtapsdktapadinternalruntimeDirichletRuntime(int i, int i2, String str) {
        dispatchEvent(19, new int[]{i, i2}, str);
    }

    /* JADX INFO: renamed from: lambda$loadModuleFromBundle$12$com-tapsdk-tapad-internal-runtime-DirichletRuntime, reason: not valid java name */
    /* synthetic */ void m205lambda$loadModuleFromBundle$12$comtapsdktapadinternalruntimeDirichletRuntime(String str, final ModuleLoadCallback moduleLoadCallback, final String str2, final String str3) {
        try {
            final WasmModule wasmModule = this.mModules.get(str);
            if (wasmModule != null) {
                if (moduleLoadCallback != null) {
                    this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda10
                        @Override // java.lang.Runnable
                        public final void run() {
                            moduleLoadCallback.onSuccess(wasmModule);
                        }
                    });
                    return;
                }
                return;
            }
            long jNativeLoadModuleFromBundle = nativeLoadModuleFromBundle(this.mNativePtr, str2, str3, str, CoreModuleSelector.domainForModuleName(str));
            if (jNativeLoadModuleFromBundle == 0) {
                if (moduleLoadCallback != null) {
                    this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda11
                        @Override // java.lang.Runnable
                        public final void run() {
                            moduleLoadCallback.onError(new RuntimeException("nativeLoadModuleFromBundle failed: " + str2 + ":" + str3));
                        }
                    });
                    return;
                }
                return;
            }
            final WasmModule wasmModule2 = new WasmModule(str, jNativeLoadModuleFromBundle);
            this.mModules.put(str, wasmModule2);
            if (isPricingPolicyModule(str)) {
                initializePricingPolicyStore();
            }
            if (moduleLoadCallback != null) {
                this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda12
                    @Override // java.lang.Runnable
                    public final void run() {
                        moduleLoadCallback.onSuccess(wasmModule2);
                    }
                });
            }
        } catch (Throwable th) {
            if (moduleLoadCallback != null) {
                this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda13
                    @Override // java.lang.Runnable
                    public final void run() {
                        moduleLoadCallback.onError(new RuntimeException("nativeLoadModuleFromBundle failed: " + str2 + ":" + str3, th));
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: lambda$loadSecurityModule$18$com-tapsdk-tapad-internal-runtime-DirichletRuntime, reason: not valid java name */
    /* synthetic */ void m206lambda$loadSecurityModule$18$comtapsdktapadinternalruntimeDirichletRuntime(String str, final ModuleLoadCallback moduleLoadCallback, byte[] bArr, final String str2) {
        try {
            final WasmModule wasmModule = this.mModules.get(str);
            if (wasmModule != null) {
                if (moduleLoadCallback != null) {
                    this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda16
                        @Override // java.lang.Runnable
                        public final void run() {
                            moduleLoadCallback.onSuccess(wasmModule);
                        }
                    });
                    return;
                }
                return;
            }
            long jNativeLoadSecurityModule = nativeLoadSecurityModule(this.mNativePtr, bArr, str);
            if (jNativeLoadSecurityModule == 0) {
                if (moduleLoadCallback != null) {
                    this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda17
                        @Override // java.lang.Runnable
                        public final void run() {
                            moduleLoadCallback.onError(new RuntimeException(c.a("nativeLoadSecurityModule failed: ", str2)));
                        }
                    });
                }
            } else {
                final WasmModule wasmModule2 = new WasmModule(str, jNativeLoadSecurityModule);
                this.mModules.put(str, wasmModule2);
                if (moduleLoadCallback != null) {
                    this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda18
                        @Override // java.lang.Runnable
                        public final void run() {
                            moduleLoadCallback.onSuccess(wasmModule2);
                        }
                    });
                }
            }
        } catch (Throwable th) {
            if (moduleLoadCallback != null) {
                this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda19
                    @Override // java.lang.Runnable
                    public final void run() {
                        moduleLoadCallback.onError(new RuntimeException(c.a("nativeLoadSecurityModule failed: ", str2), th));
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: lambda$loaderFor$5$com-tapsdk-tapad-internal-runtime-DirichletRuntime, reason: not valid java name */
    /* synthetic */ boolean m207lambda$loaderFor$5$comtapsdktapadinternalruntimeDirichletRuntime(String str, byte[] bArr, long j, int i) {
        return nativeLoadBundle(this.mNativePtr, str, bArr, j, i, 1, 2);
    }

    /* JADX INFO: renamed from: lambda$runOnRuntimeQueue$6$com-tapsdk-tapad-internal-runtime-DirichletRuntime, reason: not valid java name */
    /* synthetic */ void m208lambda$runOnRuntimeQueue$6$comtapsdktapadinternalruntimeDirichletRuntime(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            trackRuntimeQueueThrowable(th);
        }
    }

    public int liveInstanceCount() {
        int size;
        synchronized (this.mInstances) {
            size = this.mInstances.size();
        }
        return size;
    }

    public void loadModuleFromBundle(final String str, final String str2, final String str3, final ModuleLoadCallback moduleLoadCallback) {
        if (!this.mInitialized) {
            if (moduleLoadCallback != null) {
                moduleLoadCallback.onError(new IllegalStateException("Runtime not initialized"));
                return;
            }
            return;
        }
        if (!this.mInstalled.contains(str)) {
            if (moduleLoadCallback != null) {
                moduleLoadCallback.onError(new IllegalStateException(c.a("Bundle not installed: ", str)));
                return;
            }
            return;
        }
        final WasmModule wasmModule = this.mModules.get(str3);
        if (wasmModule == null) {
            if (runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m205lambda$loadModuleFromBundle$12$comtapsdktapadinternalruntimeDirichletRuntime(str3, moduleLoadCallback, str, str2);
                }
            }) || moduleLoadCallback == null) {
                return;
            }
            moduleLoadCallback.onError(new IllegalStateException("Runtime queue unavailable"));
            return;
        }
        if (isPricingPolicyModule(str3)) {
            initializePricingPolicyStore();
        }
        if (moduleLoadCallback != null) {
            this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    moduleLoadCallback.onSuccess(wasmModule);
                }
            });
        }
    }

    public void loadPreviewModule(byte[] bArr, String str, ModuleLoadCallback moduleLoadCallback) {
        if (moduleLoadCallback != null) {
            moduleLoadCallback.onError(new IllegalStateException("Preview-only WASM loader is unavailable"));
        }
    }

    public void loadSecurityModule(final byte[] bArr, final String str, String str2, final ModuleLoadCallback moduleLoadCallback) {
        if (!this.mInitialized) {
            if (moduleLoadCallback != null) {
                moduleLoadCallback.onError(new IllegalStateException("Runtime not initialized"));
                return;
            }
            return;
        }
        if (bArr == null || bArr.length == 0 || str == null || str.length() == 0) {
            if (moduleLoadCallback != null) {
                moduleLoadCallback.onError(new IllegalArgumentException("bytes/moduleName is empty"));
                return;
            }
            return;
        }
        final WasmModule wasmModule = this.mModules.get(str);
        if (wasmModule != null) {
            if (moduleLoadCallback != null) {
                this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        moduleLoadCallback.onSuccess(wasmModule);
                    }
                });
            }
        } else {
            final String str3 = str2 == null ? "memory" : str2;
            if (runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m206lambda$loadSecurityModule$18$comtapsdktapadinternalruntimeDirichletRuntime(str, moduleLoadCallback, bArr, str3);
                }
            }) || moduleLoadCallback == null) {
                return;
            }
            moduleLoadCallback.onError(new IllegalStateException("Runtime queue unavailable"));
        }
    }

    public void loadSecurityModuleFromAsset(String str, String str2, ModuleLoadCallback moduleLoadCallback) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            if (moduleLoadCallback != null) {
                moduleLoadCallback.onError(new IllegalArgumentException("assetPath/moduleName is empty"));
                return;
            }
            return;
        }
        try {
            loadSecurityModule(readAsset(str), str2, "assets/".concat(str), moduleLoadCallback);
        } catch (IOException e) {
            if (moduleLoadCallback != null) {
                moduleLoadCallback.onError(e);
            }
        }
    }

    public void pauseAllVideos() {
        HostAPIImpl hostAPIImpl = this.mHostAPI;
        if (hostAPIImpl != null) {
            hostAPIImpl.pauseAllVideos();
        }
    }

    public byte[] readBundleAsset(String str, String str2) {
        if (this.mNativePtr == 0 || str2 == null || !this.mInstalled.contains(str)) {
            return null;
        }
        return nativeBundleReadAsset(this.mNativePtr, str, str2);
    }

    public void registerAdSurface(int i, WasmModule wasmModule, Object obj, AdCallbackListener adCallbackListener) {
        registerAdSurface(i, wasmModule, obj, adCallbackListener, null);
    }

    public void registerCallback(int i, NativeCallback nativeCallback) {
        synchronized (this.mCallbackMap) {
            this.mCallbackMap.put(i, nativeCallback);
        }
    }

    public void registerControlCallback(String str, NativeCallback nativeCallback) {
        if (str == null || str.isEmpty() || nativeCallback == null) {
            return;
        }
        synchronized (this.mControlCallbackMap) {
            this.mControlCallbackMap.put(str, nativeCallback);
        }
    }

    public synchronized boolean reinitializeSecurityHost(byte[] bArr) {
        if (this.mInitialized && this.mNativePtr != 0 && this.mContext != null) {
            if (bArr == null || bArr.length == 0) {
                try {
                    bArr = readAsset(IONIA_DEX_ASSET);
                } catch (IOException e) {
                }
            }
            this.mSecurityHostInitialized = nativeInitSecurityHost(this.mNativePtr, this.mContext, bArr);
            return this.mSecurityHostInitialized;
        }
        return false;
    }

    public void releaseInstance(int i) {
        synchronized (this.mInstances) {
            this.mInstances.remove(i);
        }
        synchronized (this.mCallbackMap) {
            this.mCallbackMap.remove(i);
        }
        HostAPIImpl hostAPIImpl = this.mHostAPI;
        if (hostAPIImpl != null) {
            hostAPIImpl.destroySurfacesForInstance(i);
            this.mHostAPI.unregisterAdSurface(i);
        }
    }

    public void resumeAllVideos() {
        HostAPIImpl hostAPIImpl = this.mHostAPI;
        if (hostAPIImpl != null) {
            hostAPIImpl.resumeAllVideos();
        }
    }

    public void retainInstance(WasmAdInstance wasmAdInstance) {
        int iInstanceId = wasmAdInstance.instanceId();
        synchronized (this.mInstances) {
            this.mInstances.put(iInstanceId, wasmAdInstance);
        }
        synchronized (this.mCallbackMap) {
            this.mCallbackMap.put(iInstanceId, wasmAdInstance.callback());
        }
    }

    public boolean runOnRuntimeQueue(final Runnable runnable) {
        if (runnable == null || !this.mInitialized) {
            return false;
        }
        return ensureRuntimeQueueHandler().post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.DirichletRuntime$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m208lambda$runOnRuntimeQueue$6$comtapsdktapadinternalruntimeDirichletRuntime(runnable);
            }
        });
    }

    public void setDownloadFilePath(String str) {
        setDownloadFilePath(-1, str);
    }

    public synchronized void setForceEmbeddedBundleIds(Set<String> set) {
        if (set != null) {
            if (!set.isEmpty()) {
                this.mForceEmbeddedBundleIds = Collections.unmodifiableSet(new LinkedHashSet(set));
                return;
            }
        }
        this.mForceEmbeddedBundleIds = Collections.EMPTY_SET;
    }

    public void setMediaPreConversionHook(MediaPreConversionHook mediaPreConversionHook) {
        this.mMediaPreConversionHook = mediaPreConversionHook;
    }

    public synchronized void setRecoveryBaselineBundleIds(Set<String> set) {
        if (set != null) {
            if (!set.isEmpty()) {
                this.mRecoveryBaselineBundleIds = Collections.unmodifiableSet(new LinkedHashSet(set));
                return;
            }
        }
        this.mRecoveryBaselineBundleIds = Collections.EMPTY_SET;
    }

    public void submitAssetFact(byte[] bArr) {
        long j = this.mNativePtr;
        if (j == 0 || !this.mAssetRuntimeInitialized || bArr == null) {
            return;
        }
        nativeSubmitAssetFact(j, bArr);
    }

    public SurfaceSessionRegistry surfaceSessions() {
        return this.mSurfaceSessions;
    }

    public void triggerActivityResult(int i, int i2, String str) {
        dispatchEvent(9, new int[]{i, i2}, str);
    }

    public void triggerAnimationFrameCallback(int i, long j) {
        dispatchEvent(2, new int[]{i, (int) (j & 4294967295L), (int) ((j >> 32) & 4294967295L)}, null);
    }

    public void triggerCallback(int i, String str) {
        dispatchEvent(1, new int[]{i, -1, -1}, null);
    }

    public void triggerCallbackWithCoords(int i, int i2, int i3) {
        dispatchEvent(1, new int[]{i, i2, i3}, null);
    }

    public void triggerConfigurationChanged(int i, int i2, int i3) {
        dispatchEvent(13, new int[]{i, i2, i3}, null);
    }

    public void triggerDestroy() {
        dispatchEvent(8, null, null);
    }

    public void triggerDownloadEvent(int i, int i2, int i3, int i4) {
        triggerDownloadEvent(i, i2, -1, i3, i4);
    }

    public void triggerInstallEvent(int i, int i2, int i3, int i4, int i5, String str) {
        dispatchEvent(22, new int[]{i, i2, i3, i4, i5}, str);
    }

    public void triggerInteractionEvent(int i, int i2, int i3) {
        triggerInteractionEvent(i, i2, i3, null);
    }

    public void triggerMemoryPressure(int i) {
        MechanicalImageLoader.onTrimMemory(i);
        if (this.mNativePtr != 0 && this.mAssetRuntimeInitialized) {
            nativeAssetMemoryPressure(this.mNativePtr);
        }
        dispatchEvent(14, new int[]{i}, null);
    }

    public void triggerNewIntent(String str) {
        dispatchEvent(10, null, str);
    }

    public void triggerOverlayDismiss(int i, int i2, int i3) {
        dispatchEvent(17, new int[]{i, i2, i3}, null);
    }

    public void triggerPause() {
        dispatchEvent(6, null, null);
    }

    public void triggerPermissionResult(int i, String str) {
        dispatchEvent(11, new int[]{i}, str);
    }

    public void triggerResume() {
        dispatchEvent(7, null, null);
    }

    public void triggerSurfaceWindowFocusChanged(int i, int i2, boolean z) {
        dispatchEvent(12, new int[]{i, i2, z ? 3 : 2}, null);
    }

    public void triggerTimer(int i) {
        dispatchEvent(5, new int[]{i}, null);
    }

    public void triggerTouch(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j) {
        dispatchEvent(15, new int[]{i, i2, i3, i4, i5, i6, i7, i8, i9, (int) (j & 4294967295L), (int) ((j >> 32) & 4294967295L)}, null);
    }

    public void triggerWindowFocusChanged(int i, int i2, boolean z) {
        dispatchEvent(12, new int[]{i, i2, z ? 1 : 0}, null);
    }

    public void unloadModule(String str) {
        WasmModule wasmModuleRemove = this.mModules.remove(str);
        if (wasmModuleRemove != null) {
            wasmModuleRemove.markUnloaded();
            long j = this.mNativePtr;
            if (j != 0) {
                nativeUnloadModule(j, str);
            }
        }
    }

    public void unregisterAdSurface(int i) {
        HostAPIImpl hostAPIImpl = this.mHostAPI;
        if (hostAPIImpl != null) {
            hostAPIImpl.unregisterAdSurface(i);
        }
    }

    public void unregisterCallback(int i) {
        synchronized (this.mCallbackMap) {
            this.mCallbackMap.remove(i);
        }
    }

    public void unregisterControlCallback(String str, NativeCallback nativeCallback) {
        if (str == null || str.isEmpty()) {
            return;
        }
        synchronized (this.mControlCallbackMap) {
            if (this.mControlCallbackMap.get(str) == nativeCallback) {
                this.mControlCallbackMap.remove(str);
            }
        }
    }

    public synchronized boolean initRuntimeOnly(Context context, byte[] bArr) {
        if (!this.mInitialized) {
            initInternal(context, false, bArr);
            return this.mInitialized && this.mSecurityHostInitialized;
        }
        if (bArr != null && bArr.length > 0) {
            this.mSecurityHostInitialized = nativeInitSecurityHost(this.mNativePtr, this.mContext, bArr);
        }
        return this.mSecurityHostInitialized;
    }

    public void registerAdSurface(int i, WasmModule wasmModule, Object obj, AdCallbackListener adCallbackListener, Activity activity) {
        HostAPIImpl hostAPIImpl = this.mHostAPI;
        if (hostAPIImpl != null) {
            hostAPIImpl.registerAdSurface(i, wasmModule, obj, adCallbackListener, activity);
        }
    }

    public void setDownloadFilePath(int i, String str) {
        dispatchEvent(4, new int[]{i}, str);
    }

    public void triggerDestroy(int i) {
        dispatchEvent(8, new int[]{i}, null);
    }

    public void triggerDownloadEvent(int i, int i2, int i3, int i4, int i5) {
        dispatchEvent(3, new int[]{i, i2, i3, i4, i5}, null);
    }

    public void triggerInteractionEvent(int i, int i2, int i3, String str) {
        dispatchEvent(16, new int[]{i, i2, i3}, str);
    }

    public void triggerPause(int i) {
        dispatchEvent(6, new int[]{i}, null);
    }

    public void triggerResume(int i) {
        dispatchEvent(7, new int[]{i}, null);
    }

    public void triggerDestroy(int i, int i2) {
        dispatchEvent(8, new int[]{i, i2}, null);
    }

    public void triggerInteractionEvent(int i, int i2, int i3, int i4, int i5) {
        triggerInteractionEvent(i, i2, i3, i4, i5, null);
    }

    public void triggerPause(int i, int i2) {
        dispatchEvent(6, new int[]{i, i2}, null);
    }

    public void triggerResume(int i, int i2) {
        dispatchEvent(7, new int[]{i, i2}, null);
    }

    public void triggerInteractionEvent(int i, int i2, int i3, int i4, int i5, String str) {
        dispatchEvent(16, new int[]{i3, i4, i5, i, i2}, str);
    }
}
