package com.bytedance.sdk.openadsdk.op;

import android.content.Context;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.nw;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.kwad.sdk.collector.AppStatusRules;
import dalvik.system.BaseDexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static boolean ah = ms().exists();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Boolean f4075ms;
    private static Method xr;

    public static File ms() {
        return new File(com.bytedance.sdk.openadsdk.api.plugin.xr.ms(re.getContext()), ".csj_so");
    }

    public static void ms(String str) {
        try {
            if (ah && xr(str)) {
                return;
            }
            System.loadLibrary(str);
        } catch (Throwable th) {
            ms(str, th);
        }
    }

    private static boolean xr(String str) {
        try {
            if (xr == null) {
                Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class);
                xr = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            BaseDexClassLoader baseDexClassLoader = (BaseDexClassLoader) c.class.getClassLoader();
            if (xr != null && baseDexClassLoader != null) {
                String strFindLibrary = baseDexClassLoader.findLibrary(str);
                synchronized (c.class) {
                    xr.invoke(null, strFindLibrary, baseDexClassLoader);
                }
                return true;
            }
        } catch (Throwable th) {
            ah = false;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("lib", str);
                jSONObject.putOpt("msg", "lock load failed!");
            } catch (JSONException unused) {
            }
            u.ms().ms("so_load_fail", jSONObject, th);
        }
        return false;
    }

    private static boolean ms(String str, Throwable th) {
        String strMs = g.ms(re.getContext());
        String str2 = "lib" + str + ".so";
        File file = new File(strMs, "/lib/".concat(String.valueOf(str2)));
        if (file.exists() && file.length() > 0) {
            return ms(str, file.getAbsolutePath());
        }
        File file2 = new File(strMs, "apk/base-1.apk");
        if (file2.exists() && file2.length() > 0) {
            ms(file2, file, str2);
            File file3 = new File(strMs, "/lib/".concat(String.valueOf(str2)));
            if (file3.exists() && file3.length() > 0) {
                try {
                    System.loadLibrary(str);
                    return true;
                } catch (Throwable unused) {
                    return ms(str, file3.getAbsolutePath());
                }
            }
            ms(str, str2 + " unzip failed !", th);
            return false;
        }
        ms(str, "load so filed! apk not exist! ", th);
        return false;
    }

    private static boolean ms(String str, String str2) {
        try {
            System.load(str2);
            return true;
        } catch (Throwable th) {
            new File(str2).delete();
            ms(str, "load so " + str + " filed! ", th);
            throw th;
        }
    }

    private static void ms(File file, File file2, String str) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        try {
            ZipFile zipFile = new ZipFile(file);
            ZipEntry entry = zipFile.getEntry("lib/" + com.bytedance.sdk.openadsdk.core.yu.xr.xr.ms() + "/" + str);
            if (entry == null) {
                entry = zipFile.getEntry("lib/armeabi/".concat(String.valueOf(str)));
            }
            if (entry == null) {
                return;
            }
            file2.getParentFile().mkdirs();
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(entry));
                    try {
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        try {
                            byte[] bArr = new byte[AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE];
                            while (true) {
                                int i = bufferedInputStream.read(bArr);
                                if (i != -1) {
                                    bufferedOutputStream.write(bArr, 0, i);
                                } else {
                                    com.bytedance.sdk.component.c.ah.ah.xr.ms(bufferedInputStream);
                                    com.bytedance.sdk.component.c.ah.ah.xr.ms(bufferedOutputStream);
                                    com.bytedance.sdk.component.c.ah.ah.xr.ms(fileOutputStream);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            com.bytedance.sdk.component.c.ah.ah.xr.ms(bufferedInputStream);
                            com.bytedance.sdk.component.c.ah.ah.xr.ms(bufferedOutputStream);
                            com.bytedance.sdk.component.c.ah.ah.xr.ms(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedOutputStream = null;
                    }
                } catch (Throwable th4) {
                    bufferedInputStream = null;
                    th = th4;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th5) {
                bufferedInputStream = null;
                fileOutputStream = null;
                th = th5;
                bufferedOutputStream = null;
            }
        } catch (Throwable th6) {
            sl.xr("SoLoaderUtil", th6);
        }
    }

    private static void ms(String str, String str2, Throwable th) {
        if ("maparmor".equals(str)) {
            nw.f3028ms = false;
        }
        if (xr()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("lib", str);
            jSONObject.putOpt("msg", str2);
        } catch (JSONException unused) {
        }
        u.ms().ms("so_load_fail", jSONObject, th);
    }

    public static boolean xr() {
        Boolean bool = f4075ms;
        if (bool != null) {
            return bool.booleanValue();
        }
        f4075ms = Boolean.FALSE;
        try {
            Context context = re.getContext();
            if ((context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).applicationInfo.flags & 1) != 0) {
                f4075ms = Boolean.TRUE;
            }
        } catch (Exception e) {
            sl.xr("SoLoaderUtil", e);
        }
        return f4075ms.booleanValue();
    }
}
