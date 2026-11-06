package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.api.SDKApiHolder;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.io.File;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
class ExternalPackage {
    private final String mApk;
    private ClassLoader mClassLoader;
    private final String mDexDir;
    private IKsAdSDK mKsSdk;
    private final String mNativeLibDir;
    private Resources mResource;

    public String toString() {
        return "ExternalPackage{mApk='" + this.mApk + "', mDexDir='" + this.mDexDir + "', mNativeLibDir='" + this.mNativeLibDir + "', mResource=" + this.mResource + ", mClassLoader=" + this.mClassLoader + ", mKsSdk=" + this.mKsSdk + AbstractJsonLexerKt.END_OBJ;
    }

    String getApk() {
        return this.mApk;
    }

    Resources getResource() {
        return this.mResource;
    }

    ClassLoader getClassLoader() {
        return this.mClassLoader;
    }

    IKsAdSDK getKsSdk() {
        return this.mKsSdk;
    }

    private ExternalPackage(String str, String str2, String str3) {
        this.mApk = str;
        this.mDexDir = str2;
        this.mNativeLibDir = str3;
    }

    static synchronized ExternalPackage createDexPackage(Context context, ClassLoader classLoader) {
        return null;
    }

    static synchronized ExternalPackage create(Context context, ClassLoader classLoader, String str) {
        try {
        } catch (Throwable th) {
            SDKApiHolder.report(th);
            return null;
        }
        return create(context, classLoader, Dir.getApkFilePath(context, str), Dir.getDexDir(context, str), Dir.getNativeLibDir(context, str));
    }

    static ExternalPackage create(Context context, ClassLoader classLoader, String str, String str2, String str3) throws Exception {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            throw new RuntimeException("mApk not a file");
        }
        try {
            if (Build.VERSION.SDK_INT >= 34 && context != null && context.getApplicationInfo().targetSdkVersion >= 34) {
                file.setReadOnly();
            }
        } catch (Throwable unused) {
        }
        ExternalPackage externalPackage = new ExternalPackage(str, str2, str3);
        externalPackage.init(context, classLoader);
        return externalPackage;
    }

    private void init(Context context, ClassLoader classLoader) throws Exception {
        verify();
        Resources orCreateResources = ResourcesManager.getOrCreateResources(context, context.getResources(), this.mApk);
        ClassLoader classLoaderCreateClassLoader = ClassLoaderFactory.createClassLoader(context, classLoader, this.mApk, this.mDexDir, this.mNativeLibDir, null);
        IKsAdSDK iKsAdSDKInitSdk = Loader.initSdk(classLoaderCreateClassLoader);
        this.mResource = orCreateResources;
        this.mClassLoader = classLoaderCreateClassLoader;
        this.mKsSdk = iKsAdSDKInitSdk;
        if (!(iKsAdSDKInitSdk.getClass().getClassLoader() instanceof ClassLoaderFactory.CustomDexClassLoader)) {
            throw new RuntimeException("classLoader is not expect dynamic classloader:");
        }
        int sDKType = iKsAdSDKInitSdk.getSDKType();
        if (sDKType != 1) {
            throw new RuntimeException("sdkType error apiType: 1 , sdkType:" + sDKType);
        }
    }

    private void verify() {
        if (TextUtils.isEmpty(this.mApk)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(this.mApk);
        if (!file.isFile() || !file.exists()) {
            throw new RuntimeException("mApk not a file");
        }
    }
}
