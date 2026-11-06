package com.bytedance.sdk.openadsdk.core.jw;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

/* JADX INFO: loaded from: classes2.dex */
public class cv {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f2691ms;

    public static cv ms() {
        return new cv();
    }

    private cv() {
        xr();
    }

    private void xr() {
        File fileMs;
        Context context = com.bytedance.sdk.openadsdk.core.re.getContext();
        if (context == null) {
            return;
        }
        try {
            if ("mounted".equals(com.bytedance.sdk.openadsdk.op.ah.ms()) && (fileMs = com.bytedance.sdk.openadsdk.api.plugin.xr.ms(context, "TTCache")) != null) {
                fileMs.mkdirs();
                this.f2691ms = fileMs.getPath();
            }
            if (TextUtils.isEmpty(this.f2691ms)) {
                File file = new File(com.bytedance.sdk.openadsdk.api.plugin.xr.ms(context), "TTCache");
                file.mkdirs();
                this.f2691ms = file.getPath();
            }
        } catch (Throwable unused) {
        }
    }

    public void ms(Thread thread, Throwable th) {
        boolean zContains = false;
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String string = stringWriter.toString();
            zContains = string != null ? string.contains(TTAdConstant.class.getPackage().getName()) : false;
            com.bytedance.sdk.openadsdk.core.ab.d.ms().ms(thread, th);
        } catch (Throwable unused) {
        }
        if (zContains) {
            xr(thread, th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x010f A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x010a A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private void xr(Thread thread, Throwable th) {
        FileOutputStream fileOutputStream;
        boolean z;
        int i;
        FileInputStream fileInputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        fileInputStream = null;
        try {
            if (TextUtils.isEmpty(this.f2691ms)) {
                xr();
            }
            if (TextUtils.isEmpty(this.f2691ms)) {
                return;
            }
            File file = new File(this.f2691ms, "tt_crash_count.properties");
            if (file.exists() && file.isFile() && file.canRead()) {
                Properties properties = new Properties();
                FileInputStream fileInputStream3 = new FileInputStream(file);
                try {
                    properties.load(fileInputStream3);
                    String property = properties.getProperty("crash_count", "0");
                    String property2 = properties.getProperty("crash_last_time", "0");
                    int iIntValue = Integer.valueOf(property).intValue();
                    int i2 = 0;
                    boolean z2 = true;
                    if (System.currentTimeMillis() - Long.valueOf(property2).longValue() < 300000) {
                        i = iIntValue + 1;
                        z = false;
                    } else {
                        z = true;
                        i = 1;
                    }
                    if (i < 3) {
                        z2 = false;
                    }
                    if (!z2) {
                        i2 = i;
                    }
                    com.bytedance.sdk.component.utils.sl.d("TTCrashHandler", "==" + i2 + ", " + z2 + ", " + z);
                    if (z2) {
                        try {
                            file.delete();
                        } catch (Throwable unused) {
                        }
                    } else {
                        properties.setProperty("crash_count", String.valueOf(i2));
                        if (z) {
                            properties.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
                        }
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            properties.store(fileOutputStream, "tt_crash_info");
                            fileOutputStream2 = fileOutputStream;
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream3;
                            com.bytedance.sdk.component.utils.sl.ah("TTCrashHandler", "crash count error", th);
                        }
                    }
                    if (z2) {
                        ah();
                    }
                    fileOutputStream = fileOutputStream2;
                    fileInputStream2 = fileInputStream3;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                }
            } else {
                Properties properties2 = new Properties();
                properties2.setProperty("crash_count", "1");
                properties2.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
                fileOutputStream = new FileOutputStream(file);
                try {
                    properties2.store(fileOutputStream, "tt_crash_info");
                    com.bytedance.sdk.component.utils.sl.d("TTCrashHandler", "==first");
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        com.bytedance.sdk.component.utils.sl.ah("TTCrashHandler", "crash count error", th);
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable unused4) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable unused5) {
                            }
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
        }
    }

    private void ah() {
        try {
            com.bytedance.sdk.openadsdk.core.component.splash.ms.ms.ms().ah();
        } catch (Throwable unused) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.ms.ms.xr.ms().xr();
        } catch (Throwable unused2) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.g.x.ah();
        } catch (Throwable unused3) {
        }
        try {
            com.bytedance.sdk.component.adexpress.ms.xr.xr.xr();
            com.bytedance.sdk.openadsdk.core.ugeno.ka.ms.xr().c();
        } catch (Throwable unused4) {
        }
        try {
            Bridge bridgeUl = com.bytedance.sdk.openadsdk.core.ch.ub().ul();
            if (bridgeUl != null) {
                bridgeUl.call(7, com.bykv.ms.ms.ms.ms.xr.f12ms, Void.class);
            }
        } catch (Throwable unused5) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.ah.ah.ms().ch();
            com.bytedance.sdk.openadsdk.core.ah.d.ms().re();
            com.bytedance.sdk.openadsdk.core.ah.ka.ms().ao();
        } catch (Throwable unused6) {
        }
    }
}
