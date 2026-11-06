package com.bytedance.sdk.openadsdk.core;

import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.Initializer;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class AdSdkInitializerHolder {
    private static String MEDIATION_CLASS_NAME = "com.bytedance.sdk.gromore.init.DispatchAdSdkInitializerHolder";
    private static String PACKAGE_NAME = "com.byted.pangle";
    private static volatile Initializer mDispatchAdSdkInitializer;
    private static volatile ah mInitializer;

    public static Object getNewInstance(Bundle bundle) {
        if (mInitializer == null) {
            synchronized (AdSdkInitializerHolder.class) {
                if (mInitializer == null) {
                    mInitializer = new ah(bundle);
                    mDispatchAdSdkInitializer = getDispatchAdSdkInitializer(bundle, mInitializer);
                }
            }
        }
        return mDispatchAdSdkInitializer != null ? mDispatchAdSdkInitializer : mInitializer;
    }

    public static boolean hasDispatchAdSdkInitializer() {
        return mDispatchAdSdkInitializer != null;
    }

    private static Initializer getDispatchAdSdkInitializer(Bundle bundle, Initializer initializer) {
        try {
            return (Initializer) Class.forName(MEDIATION_CLASS_NAME).getDeclaredMethod("getInstance", Bundle.class, Initializer.class).invoke(null, bundle, initializer);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean isSdkInitSuccess() {
        if (mInitializer != null) {
            return mInitializer.isInitSuccess();
        }
        return false;
    }
}
