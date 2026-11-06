package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.BuildConfig;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SDKApiHolder;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class Loader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "Loader";
    private static Context mContext;
    private ExternalPackage mExternalPackage;
    private final AtomicBoolean mHasInit;
    private IKsAdSDK mSDKImpl;

    private static class Holder {
        private static final Loader sInstance = new Loader();

        private Holder() {
        }
    }

    public static Loader get() {
        return Holder.sInstance;
    }

    private Loader() {
        this.mExternalPackage = null;
        this.mHasInit = new AtomicBoolean(false);
    }

    public IKsAdSDK init(Context context, ClassLoader classLoader) {
        if (this.mHasInit.get()) {
            return this.mSDKImpl;
        }
        mContext = context.getApplicationContext();
        maybeDealWithOverwriteInstallation(context);
        if (checkIsExternal(context)) {
            this.mExternalPackage = ExternalPackage.create(context, classLoader, DVersionUtils.getCurrentDynamicVersion(context));
        }
        boolean zBooleanValue = BuildConfig.apiUseInnerDEX.booleanValue();
        ExternalPackage externalPackage = this.mExternalPackage;
        if (externalPackage == null && zBooleanValue) {
            ClassLoader classLoaderInitDex = DexLoader.initDex(context, classLoader);
            if (classLoaderInitDex == null) {
                ApiLogger.w(TAG, "IKsAdSDK init dexLoader is null");
                return null;
            }
            ApiLogger.w(TAG, "IKsAdSDK after dexClassLoader: " + classLoaderInitDex);
            this.mSDKImpl = initSdk(classLoaderInitDex);
            ApiLogger.w(TAG, "IKsAdSDK after mSDKImpl: " + this.mSDKImpl);
        } else if (externalPackage == null) {
            IKsAdSDK iKsAdSDKInitSdk = initSdk(getClass().getClassLoader());
            this.mSDKImpl = iKsAdSDKInitSdk;
            iKsAdSDKInitSdk.setIsExternal(false);
        } else {
            ApiLogger.w(TAG, "Loader init mExternalPackage not null ");
            IKsAdSDK ksSdk = this.mExternalPackage.getKsSdk();
            this.mSDKImpl = ksSdk;
            ksSdk.setIsExternal(true);
        }
        SDKApiHolder.holdSDK(this.mSDKImpl);
        if (this.mExternalPackage != null) {
            checkAutoRevert();
        }
        this.mHasInit.set(true);
        return this.mSDKImpl;
    }

    public void rest() {
        this.mHasInit.set(false);
        mContext = null;
        this.mSDKImpl = null;
        this.mExternalPackage = null;
    }

    private void checkAutoRevert() {
        try {
            int autoRevertTime = SDKApiHolder.getAutoRevertTime();
            if (autoRevertTime > 0) {
                try {
                    AutoRevertHandler.getInstance(mContext).setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
                    Thread.setDefaultUncaughtExceptionHandler(AutoRevertHandler.getInstance(mContext));
                    AutoRevertHandler.getInstance(mContext).startCheck(autoRevertTime);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private boolean checkIsExternal(Context context) {
        try {
            String currentDynamicVersion = DVersionUtils.getCurrentDynamicVersion(context);
            String newDynamicVersion = DVersionUtils.getNewDynamicVersion(context);
            if (TextUtils.isEmpty(currentDynamicVersion) && TextUtils.isEmpty(newDynamicVersion)) {
                return false;
            }
            if (!TextUtils.isEmpty(newDynamicVersion) && DVersionUtils.isGreaterThan(newDynamicVersion, currentDynamicVersion)) {
                DVersionUtils.setCurrentDynamicVersion(context, newDynamicVersion);
                deleteFile(context, currentDynamicVersion);
                DVersionUtils.setNewDynamicVersion(context, "");
                currentDynamicVersion = newDynamicVersion;
            }
            return !TextUtils.isEmpty(currentDynamicVersion);
        } catch (Throwable th) {
            SDKApiHolder.report(th);
            return false;
        }
    }

    private void deleteFile(Context context, String str) {
        Dir.maybeAsyncDeleteLowerVersion(context, str);
    }

    private void maybeDealWithOverwriteInstallation(Context context) {
        try {
            String apiVersion = DVersionUtils.getApiVersion(context);
            boolean z = ApiSpUtils.getBoolean(context, DVersionUtils.AUTOREVERT, false);
            if (TextUtils.isEmpty(apiVersion) || !apiVersion.equals("5.9.10.1") || z) {
                String currentDynamicVersion = DVersionUtils.getCurrentDynamicVersion(context);
                DVersionUtils.setCurrentDynamicVersion(context, "");
                DVersionUtils.setNewDynamicVersion(context, "");
                ApiSpUtils.setBoolean(context, DVersionUtils.AUTOREVERT, false);
                Dir.safeDeleteFile(Dir.getApkDirFile(context, currentDynamicVersion));
                DVersionUtils.setApiVersion(context, "5.9.10.1");
            }
        } catch (Throwable th) {
            SDKApiHolder.report(th);
        }
    }

    public boolean isExternalLoaded() {
        return this.mExternalPackage != null;
    }

    public Context getContext() {
        return mContext;
    }

    public ClassLoader getRealClassLoader() {
        ExternalPackage externalPackage = this.mExternalPackage;
        if (externalPackage != null) {
            return externalPackage.getClassLoader();
        }
        return getClass().getClassLoader();
    }

    public Resources getExternalResource() {
        ExternalPackage externalPackage = this.mExternalPackage;
        if (externalPackage != null) {
            return externalPackage.getResource();
        }
        return null;
    }

    public ClassLoader getExternalClassLoader() {
        ExternalPackage externalPackage = this.mExternalPackage;
        ClassLoader classLoader = externalPackage != null ? externalPackage.getClassLoader() : null;
        if (BuildConfig.apiUseInnerDEX.booleanValue()) {
            classLoader = this.mSDKImpl.getClass().getClassLoader();
            ApiLogger.w(TAG, "Loader getExternalClassLoader: " + classLoader);
        }
        ApiLogger.w(TAG, "Loader result: " + classLoader);
        return classLoader;
    }

    static synchronized IKsAdSDK initSdk(ClassLoader classLoader) {
        Object objInvoke;
        try {
            objInvoke = Class.forName(((KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class)).value(), true, classLoader).getDeclaredMethod("get", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke == null) {
                throw new RuntimeException("Can not get sdk form " + classLoader);
            }
        } catch (Exception e) {
            ApiLogger.printStackTrace(e);
            throw new RuntimeException(e);
        }
        return (IKsAdSDK) objInvoke;
    }

    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        checkInitSDK(context);
        return (T) this.mSDKImpl.newComponentProxy(cls, obj);
    }

    public <T> T newInstance(Class<T> cls) {
        checkInitSDK(mContext);
        return (T) this.mSDKImpl.newInstance(cls);
    }

    public static void checkInitSDK(Context context) {
        if (KsAdSDK.sHasInit.get() || get().mSDKImpl != null) {
            return;
        }
        if (context == null) {
            context = KSLifecycleObserver.getInstance().getApplication();
        }
        if (context == null) {
            context = ApiUtils.getApplicationByReflection();
        }
        KsAdSDK.init(context, SdkConfig.create(ApiSpUtils.getString(context, "sdkconfig")));
    }
}
