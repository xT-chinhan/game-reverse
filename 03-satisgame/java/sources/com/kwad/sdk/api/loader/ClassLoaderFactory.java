package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.SDKApiHolder;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class ClassLoaderFactory {
    private static final String API_PACKAGE_PATH = "com.kwad.sdk.api";
    private static final boolean DEBUG = false;
    private static final List<String> DEFAULT_PACKAGE_PATH;
    private static final String LITE_API_PACKAGE_PATH = "com.kwad.sdk.liteapi";
    private static final String TAG = "ClassLoaderFactory";
    private static final String USE_CONTEXT_CLASS_LOADER = "useContextClassLoader";

    ClassLoaderFactory() {
    }

    static {
        ArrayList arrayList = new ArrayList();
        DEFAULT_PACKAGE_PATH = arrayList;
        arrayList.add("com.kwad.sdk");
        arrayList.add("com.ksad");
        arrayList.add("com.kwai");
        arrayList.add("kwad.support");
        arrayList.add("android.support.rastermill");
    }

    static ClassLoader createClassLoader(Context context, ClassLoader classLoader, String str, String str2, String str3, List<String> list) {
        if (ApiSpUtils.getBoolean(context, USE_CONTEXT_CLASS_LOADER, false)) {
            classLoader = context.getClassLoader();
        }
        return new CustomDexClassLoader(str, str2, str3, classLoader, list);
    }

    public static class CustomDexClassLoader extends DexClassLoader {
        private List<String> extHostPackage;
        private final ClassLoader mParentClassLoader;

        public CustomDexClassLoader(String str, String str2, String str3, ClassLoader classLoader, List<String> list) {
            super(str, str2, str3, classLoader);
            this.mParentClassLoader = classLoader;
            this.extHostPackage = list;
            ApiLogger.d(ClassLoaderFactory.TAG, "pcl" + classLoader.getClass().getName());
        }

        private boolean isClassNameHost(String str) {
            boolean z;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            boolean z2 = str.startsWith("com.kwad.sdk.api") || str.startsWith("com.kwad.sdk.liteapi");
            List<String> list = this.extHostPackage;
            if (list == null) {
                z = false;
                break;
            }
            Iterator<String> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (str.startsWith(it.next())) {
                    z = true;
                    break;
                }
            }
            return z2 || z;
        }

        private boolean isClassNameDefault(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Iterator it = ClassLoaderFactory.DEFAULT_PACKAGE_PATH.iterator();
            while (it.hasNext()) {
                if (str.startsWith((String) it.next())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.lang.ClassLoader
        protected Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if (isClassNameHost(str)) {
                return getParent().loadClass(str);
            }
            Class<?> clsFindLoadedClass = findLoadedClass(str);
            if (clsFindLoadedClass != null) {
                return clsFindLoadedClass;
            }
            try {
                clsFindLoadedClass = findClass(str);
            } catch (ClassNotFoundException unused) {
            }
            if (clsFindLoadedClass != null) {
                return clsFindLoadedClass;
            }
            try {
                clsFindLoadedClass = super.loadClass(str, z);
            } catch (ClassNotFoundException unused2) {
            }
            if (clsFindLoadedClass != null) {
                return clsFindLoadedClass;
            }
            try {
                clsFindLoadedClass = getParent().loadClass(str);
            } catch (ClassNotFoundException unused3) {
            }
            if (clsFindLoadedClass == null && SDKApiHolder.sThrowClassNotFoundSet != null && SDKApiHolder.sThrowClassNotFoundSet.contains(str)) {
                throw new ClassNotFoundException(str);
            }
            return clsFindLoadedClass;
        }
    }
}
