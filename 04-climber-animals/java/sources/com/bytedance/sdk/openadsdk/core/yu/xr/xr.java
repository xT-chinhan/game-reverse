package com.bytedance.sdk.openadsdk.core.yu.xr;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.re;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private static Map<String, Integer> ah = new HashMap();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f3812ms;
    private static String xr;

    static {
        if (ah.ms()) {
            xr = Build.SUPPORTED_ABIS[0];
        } else {
            xr = Build.CPU_ABI;
        }
        ah.put("arm64-v8a", 64);
        ah.put("armeabi-v7a", 32);
        ah.put("armeabi", 32);
        ah.put("x86_64", 64);
        ah.put("x86", 32);
        ah.put("mips64", 64);
        ah.put("mips", 32);
        f3812ms = xr();
    }

    private static Map<String, List<ZipEntry>> ms(ZipFile zipFile) {
        String[] strArrSplit;
        HashMap map = new HashMap();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        Pattern patternCompile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (!zipEntryNextElement.isDirectory() && patternCompile.matcher(zipEntryNextElement.getName()).matches() && (strArrSplit = zipEntryNextElement.getName().split(File.separator)) != null && strArrSplit.length >= 2) {
                String str = strArrSplit[strArrSplit.length - 2];
                if (ah.containsKey(str)) {
                    if (map.get(str) == null) {
                        map.put(str, new LinkedList());
                    }
                    ((List) map.get(str)).add(zipEntryNextElement);
                }
            }
        }
        sl.ms("NativeLibHelper", "NativeLibHelper getAllSoZipEntries, zipFile=" + zipFile.getName() + ", soEntries=" + map.toString());
        return map;
    }

    public static String ms() {
        String str = f3812ms;
        if (str != null) {
            return str;
        }
        String strXr = xr();
        f3812ms = strXr;
        return strXr;
    }

    private static String xr() {
        JSONObject jSONObjectAh = ah();
        String strMs = ms(jSONObjectAh);
        return strMs == null ? xr(jSONObjectAh) : strMs;
    }

    private static String ms(JSONObject jSONObject) {
        if (!ah.ms()) {
            return null;
        }
        try {
            String str = (String) ms.ms(re.getContext().getApplicationInfo(), "primaryCpuAbi");
            sl.xr("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=".concat(String.valueOf(str)));
            ms(jSONObject, "primaryCpuAbi", str);
            if (str == null) {
                return null;
            }
            int i = 0;
            if (ah.xr()) {
                try {
                    i = Process.is64Bit() ? 64 : 32;
                    sl.xr("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode=".concat(String.valueOf(i)));
                } catch (Exception unused) {
                    sl.xr("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode exception default=".concat(String.valueOf(i)));
                }
            } else {
                sl.xr("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode default=0");
            }
            ms(jSONObject, "processMode", String.valueOf(i));
            if (i != 0) {
                if (ah.get(str).intValue() != i) {
                    return null;
                }
                sl.xr("NativeLibHelper", "NativeLibHelper inferHostAbiAuto2, sHostAbi=".concat(String.valueOf(str)));
                return str;
            }
            sl.xr("NativeLibHelper", "NativeLibHelper inferHostAbiAuto1, sHostAbi=".concat(String.valueOf(str)));
            return str;
        } catch (Exception e) {
            sl.ah("NativeLibHelper", "NativeLibHelper inferHostAbiAuto failed!", e);
            ms(jSONObject, "autoError", "1");
            return null;
        }
    }

    private static String xr(JSONObject jSONObject) {
        try {
            Context context = re.getContext();
            ZipFile zipFile = new ZipFile(new File(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir));
            HashSet hashSet = new HashSet(ms(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException unused) {
                sl.xr("NativeLibHelper", "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");
            }
            String[] strArr = ah.ms() ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
            if (hashSet.isEmpty()) {
                sl.xr("NativeLibHelper", "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + strArr[0]);
                ms(jSONObject, "supportedABI0", strArr[0]);
                return strArr[0];
            }
            for (String str : strArr) {
                if (hashSet.contains(str)) {
                    sl.xr("NativeLibHelper", "NativeLibHelper inferHostAbiManual, match cpuAbi=".concat(String.valueOf(str)));
                    ms(jSONObject, "matchCpuAbi", str);
                    return str;
                }
            }
            if (ah.ms()) {
                ms(jSONObject, "defaultABI0", Build.SUPPORTED_ABIS[0]);
                return Build.SUPPORTED_ABIS[0];
            }
            ms(jSONObject, "defaultABI", Build.CPU_ABI);
            return Build.CPU_ABI;
        } catch (Throwable th) {
            sl.ah("NativeLibHelper", "NativeLibHelper inferHostAbiManual failed!", th);
            ms(jSONObject, "manualError", "1");
        }
    }

    private static void ms(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            sl.ms(e);
        }
    }

    private static JSONObject ah() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("primaryCpuAbi", "0");
            jSONObject.put("processMode", "0");
            jSONObject.put("supportedABI0", "0");
            jSONObject.put("matchCpuAbi", "0");
            jSONObject.put("defaultABI0", "0");
            jSONObject.put("defaultABI", "0");
            jSONObject.put("autoError", "0");
            jSONObject.put("manualError", "0");
        } catch (JSONException e) {
            sl.ms(e);
        }
        return jSONObject;
    }
}
