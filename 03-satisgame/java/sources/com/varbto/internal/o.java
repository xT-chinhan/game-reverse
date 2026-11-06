package com.varbto.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import com.kwad.sdk.api.loader.ApiSpUtils;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.core.internal.event.iap.lib2plus.BillingClientConstants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o {
    public static volatile String a;
    public static final AtomicBoolean b = new AtomicBoolean(false);

    public static String a(long j) {
        StringBuilder sb = new StringBuilder(2048);
        sb.append("===== VerbAnr Report =====\n");
        a(sb, TapEventParamConstants.PARAM_SUB_TIMESTAMP, String.valueOf(j));
        a(sb, "triggerTime", b(j));
        a(sb, "triggerSource", "native");
        try {
            a(sb, "pid", String.valueOf(Process.myPid()));
        } catch (Throwable unused) {
        }
        try {
            a(sb, "tid", String.valueOf(Process.myTid()));
        } catch (Throwable unused2) {
        }
        try {
            a(sb);
        } catch (Throwable unused3) {
        }
        sb.append("\n----- Static Info -----\n");
        String str = a;
        if (str == null || str.length() <= 0) {
            sb.append("(static info not ready)\n");
        } else {
            sb.append(str);
        }
        sb.append("===== End Header =====\n");
        if (sb.length() > 8192) {
            String strSubstring = sb.substring(0, 8128);
            sb.setLength(0);
            sb.append(strSubstring).append("\n[... header truncated ...]\n===== End Header =====\n");
        }
        return sb.toString();
    }

    public static void b(StringBuilder sb, String str, String str2) {
        if (str2 == null) {
            str2 = "unknown";
        }
        a(sb, str, str2);
    }

    public static String b(long j) {
        if (j <= 0) {
            return "0";
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US).format(new Date(j));
        } catch (Throwable unused) {
            return String.valueOf(j);
        }
    }

    public static String a(Context context) {
        String str;
        String packageName;
        PackageManager packageManager;
        long longVersionCode;
        boolean zExists;
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        int i;
        String id = "unknown";
        StringBuilder sb = new StringBuilder(1536);
        a(sb, "sdkVersion", "1.1.5");
        try {
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr == null || strArr.length <= 0 || (str = strArr[0]) == null) {
                str = "unknown";
            }
        } catch (Throwable unused) {
        }
        a(sb, "abiCurrent", str);
        String strSubstring = null;
        if (context != null) {
            try {
                packageName = context.getPackageName();
            } catch (Throwable unused2) {
                packageName = null;
            }
            a(sb, BillingClientConstants.PACKAGE_NAME, packageName);
            try {
                packageManager = context.getPackageManager();
            } catch (Throwable unused3) {
                packageManager = null;
            }
            if (packageManager != null && packageName != null) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                    if (packageInfo != null) {
                        b(sb, "appVersionName", packageInfo.versionName);
                        try {
                            longVersionCode = Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
                        } catch (Throwable unused4) {
                            longVersionCode = -1;
                        }
                        a(sb, "appVersionCode", String.valueOf(longVersionCode));
                        b(sb, "firstInstallTime", b(packageInfo.firstInstallTime));
                        b(sb, ApiSpUtils.SP_LASTUPDATE_TIME, b(packageInfo.lastUpdateTime));
                    }
                } catch (Throwable th) {
                    a("appendPackageInfo getPackageInfo failed", th);
                }
            }
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                if (applicationInfo != null) {
                    a(sb, "targetSdk", String.valueOf(applicationInfo.targetSdkVersion));
                    if ((applicationInfo.flags & 2) != 0) {
                        a(sb, "appDebuggable", "true");
                    }
                }
            } catch (Throwable unused5) {
            }
        }
        b(sb, "brand", Build.BRAND);
        b(sb, "manufacturer", Build.MANUFACTURER);
        b(sb, "model", Build.MODEL);
        b(sb, "device", Build.DEVICE);
        b(sb, "product", Build.PRODUCT);
        b(sb, "hardware", Build.HARDWARE);
        b(sb, "board", Build.BOARD);
        b(sb, "fingerprint", Build.FINGERPRINT);
        b(sb, "osVersion", Build.VERSION.RELEASE);
        a(sb, "apiLevel", String.valueOf(Build.VERSION.SDK_INT));
        b(sb, "buildId", Build.ID);
        b(sb, "incremental", Build.VERSION.INCREMENTAL);
        try {
            b(sb, "securityPatch", Build.VERSION.SECURITY_PATCH);
        } catch (Throwable unused6) {
        }
        try {
            String[] strArr2 = Build.SUPPORTED_ABIS;
            if (strArr2 != null && strArr2.length > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (int i2 = 0; i2 < strArr2.length; i2++) {
                    if (i2 > 0) {
                        sb2.append(AbstractJsonLexerKt.COMMA);
                    }
                    String str2 = strArr2[i2];
                    if (str2 == null) {
                        str2 = AbstractJsonLexerKt.NULL;
                    }
                    sb2.append(str2);
                }
                a(sb, "supportedAbis", sb2.toString());
            }
        } catch (Throwable unused7) {
        }
        try {
            a(sb, "cpuCores", String.valueOf(Runtime.getRuntime().availableProcessors()));
        } catch (Throwable unused8) {
        }
        File file = new File("/proc/cpuinfo");
        try {
            zExists = file.exists();
        } catch (Throwable unused9) {
            zExists = false;
        }
        if (zExists) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), 4096);
                    int i3 = 0;
                    int length = 0;
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line != null) {
                                i3++;
                                length += line.length();
                                if (i3 > 256 || length > 16384) {
                                    break;
                                }
                                if (line.startsWith("Hardware")) {
                                    int iIndexOf = line.indexOf(58);
                                    if (iIndexOf > 0 && (i = iIndexOf + 1) < line.length()) {
                                        line = line.substring(i).trim();
                                    }
                                    strSubstring = line.length() > 256 ? line.substring(0, 256) : line;
                                    a(bufferedReader);
                                    a(fileInputStream);
                                    break;
                                }
                            }
                            a(bufferedReader);
                            a(fileInputStream);
                            break;
                        } catch (Throwable unused10) {
                            a(bufferedReader);
                            a(fileInputStream);
                        }
                    }
                } catch (Throwable unused11) {
                    bufferedReader = null;
                }
            } catch (Throwable unused12) {
                bufferedReader = null;
                fileInputStream = null;
            }
        }
        if (strSubstring != null) {
            a(sb, "cpuHardware", strSubstring);
        }
        try {
            a(sb, "vmMaxMemoryMB", String.valueOf(Runtime.getRuntime().maxMemory() / 1048576));
        } catch (Throwable unused13) {
        }
        if (context != null) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager != null) {
                    try {
                        a(sb, "amMemoryClassMB", String.valueOf(activityManager.getMemoryClass()));
                    } catch (Throwable unused14) {
                    }
                    try {
                        a(sb, "amLargeMemoryClassMB", String.valueOf(activityManager.getLargeMemoryClass()));
                    } catch (Throwable unused15) {
                    }
                    try {
                        a(sb, "isLowRamDevice", String.valueOf(activityManager.isLowRamDevice()));
                    } catch (Throwable unused16) {
                    }
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    a(sb, "totalMemMB", String.valueOf(memoryInfo.totalMem / 1048576));
                    a(sb, "memoryThresholdMB", String.valueOf(memoryInfo.threshold / 1048576));
                }
            } catch (Throwable unused17) {
            }
        }
        try {
            Locale locale = Locale.getDefault();
            a(sb, "locale", locale == null ? "unknown" : locale.toString());
        } catch (Throwable unused18) {
        }
        try {
            TimeZone timeZone = TimeZone.getDefault();
            if (timeZone != null) {
                id = timeZone.getID();
            }
            a(sb, "timezone", id);
        } catch (Throwable unused19) {
        }
        a(sb, "collectorInitTime", b(System.currentTimeMillis()));
        return sb.toString();
    }

    public static void a(StringBuilder sb) {
        boolean zExists;
        BufferedReader bufferedReader;
        try {
            Runtime runtime = Runtime.getRuntime();
            long j = runtime.totalMemory();
            long jFreeMemory = runtime.freeMemory();
            a(sb, "vmUsedMemoryMB", String.valueOf((j - jFreeMemory) / 1048576));
            a(sb, "vmTotalMemoryMB", String.valueOf(j / 1048576));
            a(sb, "vmFreeMemoryMB", String.valueOf(jFreeMemory / 1048576));
        } catch (Throwable unused) {
        }
        File file = new File("/proc/self/status");
        int i = 0;
        try {
            zExists = file.exists();
        } catch (Throwable unused2) {
            zExists = false;
        }
        if (!zExists) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2), 4096);
                String strTrim = null;
                String strTrim2 = null;
                String strTrim3 = null;
                int length = 0;
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        i++;
                        length += line.length();
                        if (i > 256 || length > 16384) {
                            break;
                            break;
                        }
                        if (strTrim == null && line.startsWith("VmRSS:")) {
                            strTrim = line.substring(6).trim();
                        } else if (strTrim2 == null && line.startsWith("Threads:")) {
                            strTrim2 = line.substring(8).trim();
                        } else if (strTrim3 == null && line.startsWith("FDSize:")) {
                            strTrim3 = line.substring(7).trim();
                        }
                        if (strTrim != null && strTrim2 != null && strTrim3 != null) {
                            break;
                        }
                    } catch (Throwable unused3) {
                        fileInputStream = fileInputStream2;
                        a(bufferedReader);
                        a(fileInputStream);
                        return;
                    }
                }
                if (strTrim != null) {
                    a(sb, "procVmRSS", strTrim);
                }
                if (strTrim2 != null) {
                    a(sb, "procThreads", strTrim2);
                }
                if (strTrim3 != null) {
                    a(sb, "procFDSize", strTrim3);
                }
                a(bufferedReader);
                a(fileInputStream2);
            } catch (Throwable unused4) {
                bufferedReader = null;
            }
        } catch (Throwable unused5) {
            bufferedReader = null;
        }
    }

    public static void a(StringBuilder sb, String str, String str2) {
        try {
            sb.append(str).append('=');
            if (str2 != null) {
                sb.append(str2);
            }
            sb.append('\n');
        } catch (Throwable unused) {
        }
    }

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, Throwable th) {
        try {
            m.a("SystemInfoCollector", str, th, new Object[0]);
        } catch (Throwable unused) {
        }
    }
}
