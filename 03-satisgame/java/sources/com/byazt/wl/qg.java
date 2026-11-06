package com.byazt.wl;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.byazt.ehw.fs;
import com.byazt.nf.rv;
import com.byazt.tk.k;
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
@com.byazt.cp.n(n = {0, 1, 888, 26})
public class qg {
    public static String n;
    public static String qg;
    public static Map<String, Integer> s = new HashMap();

    static {
        if (fs.n()) {
            qg = Build.SUPPORTED_ABIS[0];
        } else {
            qg = Build.CPU_ABI;
        }
        s.put("arm64-v8a", 64);
        s.put("armeabi-v7a", 32);
        s.put("armeabi", 32);
        s.put("x86_64", 64);
        s.put("x86", 32);
        s.put("mips64", 64);
        s.put("mips", 32);
        n = qg();
    }

    private static Map<String, List<ZipEntry>> n(ZipFile zipFile) {
        String[] strArrSplit;
        HashMap map = new HashMap();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        Pattern patternCompile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (!zipEntryNextElement.isDirectory() && patternCompile.matcher(zipEntryNextElement.getName()).matches() && (strArrSplit = zipEntryNextElement.getName().split(File.separator)) != null && strArrSplit.length >= 2) {
                String str = strArrSplit[strArrSplit.length - 2];
                if (s.containsKey(str)) {
                    if (map.get(str) == null) {
                        map.put(str, new LinkedList());
                    }
                    ((List) map.get(str)).add(zipEntryNextElement);
                }
            }
        }
        zipFile.getName();
        return map;
    }

    public static String n() {
        String str = n;
        if (str != null) {
            return str;
        }
        String strQg = qg();
        n = strQg;
        return strQg;
    }

    private static String qg() {
        JSONObject jSONObjectS = s();
        String strN = n(jSONObjectS);
        return strN == null ? qg(jSONObjectS) : strN;
    }

    private static String n(JSONObject jSONObject) {
        int i;
        if (!fs.n()) {
            return null;
        }
        try {
            String str = (String) n.n(rv.getContext().getApplicationInfo(), "primaryCpuAbi");
            n(jSONObject, "primaryCpuAbi", str);
            if (str == null) {
                return null;
            }
            if (fs.qg()) {
                try {
                    i = Process.is64Bit() ? 64 : 32;
                } catch (Exception unused) {
                    i = 0;
                }
            } else {
                i = 0;
            }
            n(jSONObject, "processMode", String.valueOf(i));
            if (i == 0 || s.get(str).intValue() == i) {
                return str;
            }
            return null;
        } catch (Exception e) {
            k.n("NativeLibHelper", "NativeLibHelper inferHostAbiAuto failed!", e);
            n(jSONObject, "autoError", "1");
            return null;
        }
    }

    private static String qg(JSONObject jSONObject) {
        try {
            Context context = rv.getContext();
            ZipFile zipFile = new ZipFile(new File(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir));
            HashSet hashSet = new HashSet(n(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
            String[] strArr = fs.n() ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
            if (hashSet.isEmpty()) {
                n(jSONObject, "supportedABI0", strArr[0]);
                return strArr[0];
            }
            for (String str : strArr) {
                if (hashSet.contains(str)) {
                    n(jSONObject, "matchCpuAbi", str);
                    return str;
                }
            }
            if (fs.n()) {
                n(jSONObject, "defaultABI0", Build.SUPPORTED_ABIS[0]);
                return Build.SUPPORTED_ABIS[0];
            }
            n(jSONObject, "defaultABI", Build.CPU_ABI);
            return Build.CPU_ABI;
        } catch (Throwable th) {
            k.n("NativeLibHelper", "NativeLibHelper inferHostAbiManual failed!", th);
            n(jSONObject, "manualError", "1");
        }
    }

    private static void n(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException unused) {
        }
    }

    private static JSONObject s() {
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
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
