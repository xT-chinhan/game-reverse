package com.bytedance.sdk.component.adexpress.ms.xr;

import com.bytedance.sdk.component.utils.sl;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static com.bytedance.sdk.component.adexpress.ms.ah.ms f903ms;

    public static void ms() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(ka.ab(), "temp_pkg_info.json");
            Long lValueOf = Long.valueOf(file.length());
            if (lValueOf.longValue() > 0 && file.exists() && file.isFile()) {
                byte[] bArr = new byte[lValueOf.intValue()];
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    com.bytedance.sdk.component.adexpress.ms.ah.ms msVarMs = com.bytedance.sdk.component.adexpress.ms.ah.ms.ms(new JSONObject(new String(bArr, "utf-8")));
                    if (msVarMs != null) {
                        f903ms = msVarMs;
                    }
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        sl.ah("Version", "version init error", th);
                        if (fileInputStream != null) {
                            try {
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        return;
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused3) {
                }
            }
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    public static synchronized com.bytedance.sdk.component.adexpress.ms.ah.ms xr() {
        return f903ms;
    }

    public static synchronized void ms(com.bytedance.sdk.component.adexpress.ms.ah.ms msVar) {
        if (msVar != null) {
            if (msVar.c()) {
                f903ms = msVar;
            }
        }
    }

    public static void ah() {
        ka.ms(ka.ab(), xr(), "temp_pkg_info.json");
    }

    public static boolean ms(String str) {
        return ka.ms(xr(), str);
    }

    public static boolean xr(com.bytedance.sdk.component.adexpress.ms.ah.ms msVar) {
        return ka.ah(xr(), msVar);
    }

    public static void d() {
        ka.xr(ka.ab(), xr(), "temp_pkg_info.json");
        f903ms = null;
    }
}
