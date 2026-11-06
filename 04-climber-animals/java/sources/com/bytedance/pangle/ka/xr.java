package com.bytedance.pangle.ka;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.ab;
import com.bytedance.pangle.util.ny;
import com.bytedance.pangle.util.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f646ms;
    private static Map<String, Integer> xr;

    static {
        HashMap map = new HashMap();
        xr = map;
        map.put("arm64-v8a", 64);
        xr.put("armeabi-v7a", 32);
        xr.put("armeabi", 32);
        xr.put("x86_64", 64);
        xr.put("x86", 32);
        xr.put("mips64", 64);
        xr.put("mips", 32);
        f646ms = ah();
    }

    public static void ms(File file, File file2, String str, Map<String, List<ZipEntry>> map) throws Throwable {
        ZipFile zipFile = null;
        try {
            ms(str, file2);
            ZipFile zipFile2 = new ZipFile(file);
            if (map == null) {
                try {
                    map = ms(zipFile2);
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    throw th;
                }
            }
            boolean zMs = ms(map, f646ms);
            ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper copyNativeLib pre-verify-matchHostAbi[" + zMs + "], pkg=" + str);
            if (zMs) {
                List<ZipEntry> listMs = ms(map);
                if (listMs != null && !listMs.isEmpty()) {
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    Iterator<ZipEntry> it = listMs.iterator();
                    while (it.hasNext()) {
                        ms(zipFile2, it.next(), file2);
                    }
                }
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copyNativeLib, supportedSoEntries empty, pkg=".concat(String.valueOf(str)));
                zipFile2.close();
                return;
            }
            zipFile2.close();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void ms(String str, File file) throws IOException {
        Plugin plugin = Zeus.getPlugin(str);
        if (plugin.mSharedHostSos.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(plugin.mSharedHostSos);
        String str2 = Zeus.getAppApplication().getApplicationInfo().nativeLibraryDir;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String[] strArrSplit = str2.split(File.pathSeparator);
        for (String str3 : plugin.mSharedHostSos) {
            for (String str4 : strArrSplit) {
                File file2 = new File(str4, str3);
                if (arrayList.contains(str3) && file2.exists()) {
                    x.ms(file2.getAbsolutePath(), new File(file, str3).getAbsolutePath());
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copySoFromHost, hostSoPath=" + file2.getAbsolutePath());
                    arrayList.remove(str3);
                }
            }
        }
    }

    private static Map<String, List<ZipEntry>> ms(ZipFile zipFile) {
        String[] strArrSplit;
        HashMap map = new HashMap();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        Pattern patternCompile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (!zipEntryNextElement.isDirectory() && !zipEntryNextElement.getName().contains("../") && zipEntryNextElement.getName().startsWith("lib/") && patternCompile.matcher(zipEntryNextElement.getName()).matches() && (strArrSplit = zipEntryNextElement.getName().split(File.separator)) != null && strArrSplit.length >= 2) {
                String str = strArrSplit[strArrSplit.length - 2];
                if (xr.containsKey(str)) {
                    if (map.get(str) == null) {
                        map.put(str, new LinkedList());
                    }
                    ((List) map.get(str)).add(zipEntryNextElement);
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper getAllSoZipEntries, zipFile=" + zipFile.getName() + ", soEntries=" + map.toString());
        return map;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static List<ZipEntry> ms(Map<String, List<ZipEntry>> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        HashSet hashSet = new HashSet();
        String str = f646ms;
        str.hashCode();
        switch (str) {
            case "mips64":
                ms(map, "mips64", linkedList, hashSet);
                return linkedList;
            case "x86_64":
                ms(map, "x86_64", linkedList, hashSet);
                return linkedList;
            case "armeabi":
                ms(map, "armeabi", linkedList, hashSet);
                ms(map, "armeabi-v7a", linkedList, hashSet);
                return linkedList;
            case "x86":
                ms(map, "x86", linkedList, hashSet);
                return linkedList;
            case "mips":
                ms(map, "mips", linkedList, hashSet);
                return linkedList;
            case "armeabi-v7a":
                ms(map, "armeabi-v7a", linkedList, hashSet);
                ms(map, "armeabi", linkedList, hashSet);
                return linkedList;
            case "arm64-v8a":
                ms(map, "arm64-v8a", linkedList, hashSet);
                return linkedList;
            default:
                return linkedList;
        }
    }

    private static void ms(Map<String, List<ZipEntry>> map, String str, List<ZipEntry> list, Set<String> set) {
        List<ZipEntry> list2 = map.get(str);
        if (list2 == null || list2.size() == 0) {
            return;
        }
        for (ZipEntry zipEntry : list2) {
            String strSubstring = zipEntry.getName().substring(zipEntry.getName().lastIndexOf(File.separator) + 1);
            if (!set.contains(strSubstring)) {
                list.add(zipEntry);
                set.add(strSubstring);
            }
        }
    }

    private static void ms(ZipFile zipFile, ZipEntry zipEntry, File file) throws IOException {
        String name = zipEntry.getName();
        if (name.contains("..")) {
            return;
        }
        File file2 = new File(file, name.substring(name.lastIndexOf(File.separator) + 1));
        int i = 0;
        boolean z = false;
        do {
            if (file2.exists()) {
                file2.delete();
            }
            try {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copySoZipEntry, soZipEntry=" + zipEntry + ", targetSoFile=" + file2);
                ab.ms(zipFile.getInputStream(zipEntry), new FileOutputStream(file2));
                z = true;
            } catch (IOException e) {
                if (i >= 3) {
                    throw e;
                }
                i++;
            }
        } while (!z);
    }

    public static String ms() {
        String str = f646ms;
        if (str != null) {
            return str;
        }
        String strAh = ah();
        f646ms = strAh;
        return strAh;
    }

    public static int xr() {
        return xr.get(ms()).intValue();
    }

    private static String ah() {
        JSONObject jSONObjectD = d();
        String strMs = ms(jSONObjectD);
        return strMs == null ? xr(jSONObjectD) : strMs;
    }

    private static String ms(JSONObject jSONObject) {
        if (!ny.ms()) {
            return null;
        }
        try {
            String str = (String) FieldUtils.readField(Zeus.getAppApplication().getApplicationInfo(), "primaryCpuAbi");
            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=".concat(String.valueOf(str)));
            ms(jSONObject, "primaryCpuAbi", str);
            if (str == null) {
                return null;
            }
            int i = 0;
            if (ny.ch()) {
                try {
                    i = Process.is64Bit() ? 64 : 32;
                    ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode=".concat(String.valueOf(i)));
                } catch (Exception unused) {
                    ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode exception default=".concat(String.valueOf(i)));
                }
            } else {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode default=0");
            }
            ms(jSONObject, "processMode", String.valueOf(i));
            if (i != 0) {
                if (xr.get(str).intValue() != i) {
                    return null;
                }
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto2, sHostAbi=".concat(String.valueOf(str)));
                return str;
            }
            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto1, sHostAbi=".concat(String.valueOf(str)));
            return str;
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto failed!", e);
            ms(jSONObject, "autoError", "1");
            return null;
        }
    }

    private static String xr(JSONObject jSONObject) {
        try {
            ZipFile zipFile = new ZipFile(new File(Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0).applicationInfo.sourceDir));
            HashSet hashSet = new HashSet(ms(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException unused) {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");
            }
            String[] strArr = ny.ms() ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
            if (hashSet.isEmpty()) {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + strArr[0]);
                ms(jSONObject, "supportedABI0", strArr[0]);
                return strArr[0];
            }
            for (String str : strArr) {
                if (hashSet.contains(str)) {
                    ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, match cpuAbi=".concat(String.valueOf(str)));
                    ms(jSONObject, "matchCpuAbi", str);
                    return str;
                }
            }
            if (ny.ms()) {
                ms(jSONObject, "defaultABI0", Build.SUPPORTED_ABIS[0]);
                return Build.SUPPORTED_ABIS[0];
            }
            ms(jSONObject, "defaultABI", Build.CPU_ABI);
            return Build.CPU_ABI;
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual failed!", th);
            ms(jSONObject, "manualError", "1");
        }
    }

    public static com.bytedance.pangle.util.ka<Boolean, Map<String, List<ZipEntry>>> ms(File file) throws Throwable {
        boolean z;
        HashMap map = new HashMap();
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    map.putAll(ms(zipFile2));
                    if (map.isEmpty()) {
                        ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [true] soEntries empty, ".concat(String.valueOf(file)));
                        z = true;
                    } else {
                        boolean zMs = ms(map, f646ms);
                        if (zMs) {
                            ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + zMs + "], " + file);
                        } else {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + zMs + "], " + file);
                        }
                        z = zMs;
                    }
                    com.bytedance.pangle.util.ka<Boolean, Map<String, List<ZipEntry>>> kaVar = new com.bytedance.pangle.util.ka<>(Boolean.valueOf(z), map);
                    try {
                        zipFile2.close();
                    } catch (IOException unused) {
                        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                    }
                    return kaVar;
                } catch (IOException e) {
                    e = e;
                    zipFile = zipFile2;
                    ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, get sourceApk ZipFile failed!", e);
                    com.bytedance.pangle.util.ka<Boolean, Map<String, List<ZipEntry>>> kaVar2 = new com.bytedance.pangle.util.ka<>(Boolean.FALSE, map);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused2) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                        }
                    }
                    return kaVar2;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused3) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    private static boolean ms(Map<String, List<ZipEntry>> map, String str) {
        if (TextUtils.equals(str, "armeabi") || TextUtils.equals(str, "armeabi-v7a")) {
            return map.containsKey("armeabi") || map.containsKey("armeabi-v7a");
        }
        return map.containsKey(str);
    }

    public static boolean xr(File file) throws Throwable {
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                    Pattern patternCompile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
                    while (enumerationEntries.hasMoreElements()) {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        if (!zipEntryNextElement.isDirectory() && patternCompile.matcher(zipEntryNextElement.getName()).matches()) {
                            try {
                                zipFile2.close();
                                return true;
                            } catch (IOException unused) {
                                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                                return true;
                            }
                        }
                    }
                    try {
                        zipFile2.close();
                    } catch (IOException unused2) {
                        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                    }
                    return false;
                } catch (IOException e) {
                    e = e;
                    zipFile = zipFile2;
                    ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, get sourceApk ZipFile failed!", e);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused3) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused4) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    private static void ms(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    private static JSONObject d() {
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
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        return jSONObject;
    }
}
