package com.byazt.sp;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.byazt.ca.ho;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS, 13})
public class hw {
    public static Map<String, Integer> hn = new HashMap();
    public static String hw;
    public static String pr;

    static {
        if (x.pr()) {
            hw = Build.SUPPORTED_ABIS[0];
        } else {
            hw = Build.CPU_ABI;
        }
        hn.put("arm64-v8a", 64);
        hn.put("armeabi-v7a", 32);
        hn.put("armeabi", 32);
        hn.put("x86_64", 64);
        hn.put("x86", 32);
        hn.put("mips64", 64);
        hn.put("mips", 32);
        pr = hw();
    }

    private static Map<String, List<ZipEntry>> pr(ZipFile zipFile) {
        String[] strArrSplit;
        HashMap map = new HashMap();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        Pattern patternCompile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (!zipEntryNextElement.isDirectory() && patternCompile.matcher(zipEntryNextElement.getName()).matches() && (strArrSplit = zipEntryNextElement.getName().split(File.separator)) != null && strArrSplit.length >= 2) {
                String str = strArrSplit[strArrSplit.length - 2];
                if (hn.containsKey(str)) {
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

    public static String pr() {
        String str = pr;
        if (str != null) {
            return str;
        }
        String strHw = hw();
        pr = strHw;
        return strHw;
    }

    private static String hw() {
        JSONObject jSONObjectHn = hn();
        String strPr = pr(jSONObjectHn);
        if (strPr == null) {
            return hw(jSONObjectHn);
        }
        return strPr;
    }

    private static String pr(JSONObject jSONObject) {
        if (x.pr()) {
            try {
                String str = (String) pr.pr(a.getContext().getApplicationInfo(), "primaryCpuAbi");
                pr(jSONObject, "primaryCpuAbi", str);
                if (str != null) {
                    int i = 0;
                    if (x.hw()) {
                        try {
                            i = Process.is64Bit() ? 64 : 32;
                        } catch (Exception e) {
                        }
                    }
                    pr(jSONObject, "processMode", String.valueOf(i));
                    if (i == 0 || hn.get(str).intValue() == i) {
                        return str;
                    }
                    return null;
                }
                return null;
            } catch (Exception e2) {
                ho.pr("NativeLibHelper", "NativeLibHelper inferHostAbiAuto failed!", e2);
                pr(jSONObject, "autoError", "1");
                return null;
            }
        }
        return null;
    }

    private static String hw(JSONObject jSONObject) {
        String[] strArr;
        try {
            Context context = a.getContext();
            ZipFile zipFile = new ZipFile(new File(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir));
            HashSet hashSet = new HashSet(pr(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException e) {
            }
            if (x.pr()) {
                strArr = Build.SUPPORTED_ABIS;
            } else {
                strArr = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
            }
            if (hashSet.isEmpty()) {
                pr(jSONObject, "supportedABI0", strArr[0]);
                return strArr[0];
            }
            for (String str : strArr) {
                if (hashSet.contains(str)) {
                    pr(jSONObject, "matchCpuAbi", str);
                    return str;
                }
            }
            if (x.pr()) {
                pr(jSONObject, "defaultABI0", Build.SUPPORTED_ABIS[0]);
                return Build.SUPPORTED_ABIS[0];
            }
            pr(jSONObject, "defaultABI", Build.CPU_ABI);
            return Build.CPU_ABI;
        } catch (Throwable th) {
            ho.pr("NativeLibHelper", "NativeLibHelper inferHostAbiManual failed!", th);
            pr(jSONObject, "manualError", "1");
        }
    }

    private static void pr(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
        }
    }

    private static JSONObject hn() {
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
        }
        return jSONObject;
    }
}
