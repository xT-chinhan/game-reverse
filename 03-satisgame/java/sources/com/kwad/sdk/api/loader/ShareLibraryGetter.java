package com.kwad.sdk.api.loader;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class ShareLibraryGetter {
    private static final String TAG = "ShareLibraryGetter";

    ShareLibraryGetter() {
    }

    public static Field findField(Object obj, String str) throws NoSuchFieldException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static synchronized String getNativeLibraryPath(ClassLoader classLoader) throws Throwable {
        String strInstall;
        if ((Build.VERSION.SDK_INT != 25 || Build.VERSION.PREVIEW_SDK_INT == 0) && Build.VERSION.SDK_INT <= 25) {
            if (Build.VERSION.SDK_INT != 24) {
                try {
                    strInstall = V23.install(classLoader);
                } catch (Throwable th) {
                    Log.e(TAG, String.format("installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14", Integer.valueOf(Build.VERSION.SDK_INT), th.getMessage()));
                    try {
                        strInstall = V14.install(classLoader);
                    } catch (Throwable unused) {
                        throw th;
                    }
                }
            } else {
                try {
                    strInstall = V24.install(classLoader);
                } catch (Throwable th2) {
                    Log.e(TAG, String.format("installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14", Integer.valueOf(Build.VERSION.SDK_INT), th2.getMessage()));
                    try {
                        strInstall = V14.install(classLoader);
                    } catch (Throwable unused2) {
                        throw th2;
                    }
                }
            }
        } else {
            try {
                strInstall = V25.get(classLoader);
            } catch (Throwable th3) {
                Log.e(TAG, String.format("installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23", Integer.valueOf(Build.VERSION.SDK_INT), th3.getMessage()));
                strInstall = V23.install(classLoader);
            }
        }
        return strInstall;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getPathListString(List<File> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).getAbsolutePath());
            if (i < list.size() - 1) {
                sb.append(File.pathSeparator);
            }
        }
        return sb.toString();
    }

    private static final class V4 {
        private V4() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String install(ClassLoader classLoader) throws Throwable {
            return String.valueOf(ShareLibraryGetter.findField(classLoader, "libPath").get(classLoader));
        }
    }

    private static final class V14 {
        private V14() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String install(ClassLoader classLoader) throws Throwable {
            Object obj = ShareLibraryGetter.findField(classLoader, "pathList").get(classLoader);
            return ShareLibraryGetter.getPathListString(Arrays.asList((File[]) ShareLibraryGetter.findField(obj, "nativeLibraryDirectories").get(obj)));
        }
    }

    private static final class V23 {
        private V23() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String install(ClassLoader classLoader) throws Throwable {
            Object obj = ShareLibraryGetter.findField(classLoader, "pathList").get(classLoader);
            return ShareLibraryGetter.getPathListString((List) ShareLibraryGetter.findField(obj, "nativeLibraryDirectories").get(obj));
        }
    }

    private static final class V24 {
        private V24() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String install(ClassLoader classLoader) throws Throwable {
            Object obj = ShareLibraryGetter.findField(classLoader, "pathList").get(classLoader);
            return ShareLibraryGetter.getPathListString((List) ShareLibraryGetter.findField(obj, "nativeLibraryDirectories").get(obj));
        }
    }

    private static final class V25 {
        private V25() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String get(ClassLoader classLoader) throws Throwable {
            Object obj = ShareLibraryGetter.findField(classLoader, "pathList").get(classLoader);
            return ShareLibraryGetter.getPathListString((List) ShareLibraryGetter.findField(obj, "nativeLibraryDirectories").get(obj));
        }
    }
}
