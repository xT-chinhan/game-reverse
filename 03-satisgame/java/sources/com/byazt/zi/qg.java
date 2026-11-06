package com.byazt.zi;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.byazt.gx.fs;
import com.byazt.gx.rv;
import com.byazt.gx.x;
import com.byazt.vx.w;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.util.FieldUtils;
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
@com.byazt.cp.n(n = {0, 1, 1948, 26})
public class qg {
    public static String n;
    public static Map<String, Integer> qg;

    static {
        HashMap map = new HashMap();
        qg = map;
        map.put("arm64-v8a", 64);
        qg.put("armeabi-v7a", 32);
        qg.put("armeabi", 32);
        qg.put("x86_64", 64);
        qg.put("x86", 32);
        qg.put("mips64", 64);
        qg.put("mips", 32);
        n = s();
    }

    public static void n(File file, File file2, String str, Map<String, List<ZipEntry>> map) throws Throwable {
        ZipFile zipFile = null;
        try {
            n(str, file2);
            ZipFile zipFile2 = new ZipFile(file);
            if (map == null) {
                try {
                    map = n(zipFile2);
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    throw th;
                }
            }
            boolean zN = n(map, n);
            ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper copyNativeLib pre-verify-matchHostAbi[" + zN + "], pkg=" + str);
            if (zN) {
                List<ZipEntry> listN = n(map);
                if (listN != null && !listN.isEmpty()) {
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    Iterator<ZipEntry> it = listN.iterator();
                    while (it.hasNext()) {
                        n(zipFile2, it.next(), file2);
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

    private static void n(String str, File file) throws IOException {
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
                    fs.n(file2.getAbsolutePath(), new File(file, str3).getAbsolutePath());
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copySoFromHost, hostSoPath=" + file2.getAbsolutePath());
                    arrayList.remove(str3);
                }
            }
        }
    }

    private static Map<String, List<ZipEntry>> n(ZipFile zipFile) {
        String[] strArrSplit;
        HashMap map = new HashMap();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        Pattern patternCompile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (!zipEntryNextElement.isDirectory() && !zipEntryNextElement.getName().contains("../") && zipEntryNextElement.getName().startsWith("lib/") && patternCompile.matcher(zipEntryNextElement.getName()).matches() && (strArrSplit = zipEntryNextElement.getName().split(File.separator)) != null && strArrSplit.length >= 2) {
                String str = strArrSplit[strArrSplit.length - 2];
                if (qg.containsKey(str)) {
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
    private static List<ZipEntry> n(Map<String, List<ZipEntry>> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        HashSet hashSet = new HashSet();
        String str = n;
        str.hashCode();
        switch (str) {
            case "mips64":
                n(map, "mips64", linkedList, hashSet);
                return linkedList;
            case "x86_64":
                n(map, "x86_64", linkedList, hashSet);
                return linkedList;
            case "armeabi":
                n(map, "armeabi", linkedList, hashSet);
                n(map, "armeabi-v7a", linkedList, hashSet);
                return linkedList;
            case "x86":
                n(map, "x86", linkedList, hashSet);
                return linkedList;
            case "mips":
                n(map, "mips", linkedList, hashSet);
                return linkedList;
            case "armeabi-v7a":
                n(map, "armeabi-v7a", linkedList, hashSet);
                n(map, "armeabi", linkedList, hashSet);
                return linkedList;
            case "arm64-v8a":
                n(map, "arm64-v8a", linkedList, hashSet);
                return linkedList;
            default:
                return linkedList;
        }
    }

    private static void n(Map<String, List<ZipEntry>> map, String str, List<ZipEntry> list, Set<String> set) {
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

    private static void n(ZipFile zipFile, ZipEntry zipEntry, File file) throws IOException {
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
                x.n(zipFile.getInputStream(zipEntry), new FileOutputStream(file2));
                z = true;
            } catch (IOException e) {
                if (i >= 3) {
                    throw e;
                }
                i++;
            }
        } while (!z);
    }

    public static String n() {
        String str = n;
        if (str != null) {
            return str;
        }
        String strS = s();
        n = strS;
        return strS;
    }

    public static int qg() {
        return qg.get(n()).intValue();
    }

    private static String s() {
        JSONObject jSONObjectQ = q();
        String strN = n(jSONObjectQ);
        return strN == null ? qg(jSONObjectQ) : strN;
    }

    private static String n(JSONObject jSONObject) {
        if (!rv.n()) {
            return null;
        }
        try {
            String str = (String) FieldUtils.readField(Zeus.getAppApplication().getApplicationInfo(), "primaryCpuAbi");
            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=".concat(String.valueOf(str)));
            n(jSONObject, "primaryCpuAbi", str);
            if (str == null) {
                return null;
            }
            int i = 0;
            if (rv.rv()) {
                try {
                    i = Process.is64Bit() ? 64 : 32;
                    ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode=".concat(String.valueOf(i)));
                } catch (Exception unused) {
                    ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode exception default=".concat(String.valueOf(i)));
                }
            } else {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode default=0");
            }
            n(jSONObject, "processMode", String.valueOf(i));
            if (i != 0) {
                if (qg.get(str).intValue() != i) {
                    return null;
                }
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto2, sHostAbi=".concat(String.valueOf(str)));
                return str;
            }
            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto1, sHostAbi=".concat(String.valueOf(str)));
            return str;
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto failed!", e);
            n(jSONObject, "autoError", "1");
            return null;
        }
    }

    private static String qg(JSONObject jSONObject) {
        try {
            ZipFile zipFile = new ZipFile(new File(Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0).applicationInfo.sourceDir));
            HashSet hashSet = new HashSet(n(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException unused) {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");
            }
            String[] strArr = rv.n() ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
            if (hashSet.isEmpty()) {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + strArr[0]);
                n(jSONObject, "supportedABI0", strArr[0]);
                return strArr[0];
            }
            for (String str : strArr) {
                if (hashSet.contains(str)) {
                    ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, match cpuAbi=".concat(String.valueOf(str)));
                    n(jSONObject, "matchCpuAbi", str);
                    return str;
                }
            }
            if (rv.n()) {
                n(jSONObject, "defaultABI0", Build.SUPPORTED_ABIS[0]);
                return Build.SUPPORTED_ABIS[0];
            }
            n(jSONObject, "defaultABI", Build.CPU_ABI);
            return Build.CPU_ABI;
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual failed!", th);
            n(jSONObject, "manualError", "1");
        }
    }

    public static com.byazt.gx.l<Boolean, Map<String, List<ZipEntry>>> n(File file) throws Throwable {
        boolean z;
        HashMap map = new HashMap();
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    map.putAll(n(zipFile2));
                    if (map.isEmpty()) {
                        ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [true] soEntries empty, ".concat(String.valueOf(file)));
                        z = true;
                    } else {
                        boolean zN = n(map, n);
                        if (zN) {
                            ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + zN + "], " + file);
                        } else {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + zN + "], " + file);
                        }
                        z = zN;
                    }
                    com.byazt.gx.l<Boolean, Map<String, List<ZipEntry>>> lVar = new com.byazt.gx.l<>(Boolean.valueOf(z), map);
                    try {
                        zipFile2.close();
                    } catch (IOException unused) {
                        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                    }
                    return lVar;
                } catch (IOException e) {
                    e = e;
                    zipFile = zipFile2;
                    ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, get sourceApk ZipFile failed!", e);
                    com.byazt.gx.l<Boolean, Map<String, List<ZipEntry>>> lVar2 = new com.byazt.gx.l<>(Boolean.FALSE, map);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused2) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                        }
                    }
                    return lVar2;
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

    private static boolean n(Map<String, List<ZipEntry>> map, String str) {
        if (TextUtils.equals(str, "armeabi") || TextUtils.equals(str, "armeabi-v7a")) {
            return map.containsKey("armeabi") || map.containsKey("armeabi-v7a");
        }
        return map.containsKey(str);
    }

    public static boolean qg(File file) throws Throwable {
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

    private static void n(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            w.n(e);
        }
    }

    private static JSONObject q() {
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
            w.n(e);
        }
        return jSONObject;
    }
}
