package com.byazt.xu;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.f.k;
import com.byazt.nf.rv;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.varbto.utils.api.UtilConst;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 91, 19})
public class n {
    public static final String[] n = {".tp", ".temp", ".part", ".0", ".1", ".2", ".3", ".4", ".5", ".6", ".7", ".8", ".9"};

    public static JSONObject n() throws Exception {
        long j;
        int i;
        boolean z;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Map<String, Map<String, qg>> mapQg = qg();
        JSONArray jSONArray = new JSONArray();
        boolean z2 = false;
        int[] iArr = {0};
        long j2 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (Map.Entry<String, Map<String, qg>> entry : mapQg.entrySet()) {
            String key = entry.getKey();
            if (TextUtils.isEmpty(key)) {
                j = jElapsedRealtime;
                z = z2;
            } else {
                File file = new File(key);
                if (file.exists() && file.isDirectory()) {
                    C0395n c0395nN = n(file, entry.getValue(), iArr);
                    i2++;
                    j = jElapsedRealtime;
                    j2 += c0395nN.n;
                    i3 += c0395nN.qg;
                    i4 = (i4 != 0 || c0395nN.s) ? 1 : 0;
                    i5 += c0395nN.q;
                    i6 += c0395nN.l;
                    i7 += c0395nN.w;
                    jSONArray.put(c0395nN.x);
                    z = false;
                    if (iArr[0] >= 1000) {
                        i = 1;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("scan_ts", System.currentTimeMillis());
                        jSONObject.put("dir_count", i2);
                        jSONObject.put(k.a.f, j2);
                        jSONObject.put("total_size_str", n(j2));
                        jSONObject.put("total_file_count", i3);
                        jSONObject.put("truncated", i);
                        jSONObject.put("orphan_file_count", i5);
                        jSONObject.put("dangling_task_count", i6);
                        jSONObject.put("temp_file_count", i7);
                        jSONObject.put("dirs", jSONArray);
                        n(jSONObject);
                        jSONObject.put("scan_cost_ms", SystemClock.elapsedRealtime() - j);
                        return jSONObject;
                    }
                } else {
                    j = jElapsedRealtime;
                    z = false;
                }
            }
            z2 = z;
            jElapsedRealtime = j;
        }
        j = jElapsedRealtime;
        i = i4;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("scan_ts", System.currentTimeMillis());
        jSONObject2.put("dir_count", i2);
        jSONObject2.put(k.a.f, j2);
        jSONObject2.put("total_size_str", n(j2));
        jSONObject2.put("total_file_count", i3);
        jSONObject2.put("truncated", i);
        jSONObject2.put("orphan_file_count", i5);
        jSONObject2.put("dangling_task_count", i6);
        jSONObject2.put("temp_file_count", i7);
        jSONObject2.put("dirs", jSONArray);
        n(jSONObject2);
        jSONObject2.put("scan_cost_ms", SystemClock.elapsedRealtime() - j);
        return jSONObject2;
    }

    private static Map<String, Map<String, qg>> qg() {
        List<DownloadInfo> listQg;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        tj tjVarHu = com.byazt.xv.s.hu();
        if (tjVarHu == null || (listQg = tjVarHu.qg()) == null) {
            return linkedHashMap;
        }
        for (DownloadInfo downloadInfo : listQg) {
            if (downloadInfo != null) {
                String savePath = downloadInfo.getSavePath();
                if (!TextUtils.isEmpty(savePath)) {
                    Map linkedHashMap2 = (Map) linkedHashMap.get(savePath);
                    if (linkedHashMap2 == null) {
                        linkedHashMap2 = new LinkedHashMap();
                        linkedHashMap.put(savePath, linkedHashMap2);
                    }
                    String name = downloadInfo.getName();
                    linkedHashMap2.put(TextUtils.isEmpty(name) ? "__no_name__" + downloadInfo.getUrl() : name, new qg(name, downloadInfo.getUrl(), downloadInfo.getTitle()));
                }
            }
        }
        return linkedHashMap;
    }

    private static C0395n n(File file, Map<String, qg> map, int[] iArr) throws Exception {
        JSONArray jSONArray = new JSONArray();
        LinkedHashSet linkedHashSet = map == null ? new LinkedHashSet() : new LinkedHashSet(map.keySet());
        C0395n c0395n = new C0395n();
        n(file, jSONArray, c0395n, map, linkedHashSet, iArr, 0);
        if (map != null) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                qg qgVar = map.get((String) it.next());
                if (qgVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(TapEventParamConstants.PARAM_NAME, qgVar.n == null ? "" : qgVar.n);
                    jSONObject.put("size", 0);
                    jSONObject.put("size_str", "0B");
                    jSONObject.put("on_disk", 0);
                    jSONObject.put("has_task", 1);
                    jSONObject.put(ImagesContract.URL, qgVar.qg == null ? "" : qgVar.qg);
                    jSONObject.put("title", qgVar.s != null ? qgVar.s : "");
                    jSONArray.put(jSONObject);
                    c0395n.l++;
                }
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("path", file.getAbsolutePath());
        jSONObject2.put("size", c0395n.n);
        jSONObject2.put("size_str", n(c0395n.n));
        jSONObject2.put("file_count", c0395n.qg);
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            long jN = c0395n.n + n(parentFile, file, iArr, 0, c0395n);
            jSONObject2.put("parent_path", parentFile.getAbsolutePath());
            jSONObject2.put("parent_size", jN);
            jSONObject2.put("parent_size_str", n(jN));
        }
        jSONObject2.put("entries", jSONArray);
        c0395n.x = jSONObject2;
        return c0395n;
    }

    private static void n(File file, JSONArray jSONArray, C0395n c0395n, Map<String, qg> map, Set<String> set, int[] iArr, int i) throws Exception {
        boolean z;
        String strN;
        if (file == null || i > 8) {
            c0395n.s = true;
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2 != null) {
                if (iArr[0] >= 1000) {
                    c0395n.s = true;
                    return;
                }
                if (file2.isDirectory()) {
                    n(file2, jSONArray, c0395n, map, set, iArr, i + 1);
                } else {
                    long length = file2.length();
                    String name = file2.getName();
                    c0395n.n += length;
                    c0395n.qg++;
                    iArr[0] = iArr[0] + 1;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(TapEventParamConstants.PARAM_NAME, name);
                    jSONObject.put("size", length);
                    jSONObject.put("size_str", n(length));
                    jSONObject.put("on_disk", 1);
                    qg qgVar = map == null ? null : map.get(name);
                    if (qgVar != null || map == null || (strN = n(name)) == null || (qgVar = map.get(strN)) == null) {
                        z = false;
                    } else {
                        name = strN;
                        z = true;
                    }
                    if (qgVar != null) {
                        jSONObject.put("has_task", 1);
                        jSONObject.put(ImagesContract.URL, qgVar.qg == null ? "" : qgVar.qg);
                        jSONObject.put("title", qgVar.s != null ? qgVar.s : "");
                        if (z) {
                            jSONObject.put("is_temp", 1);
                            c0395n.w++;
                        }
                        set.remove(name);
                    } else {
                        jSONObject.put("has_task", 0);
                        c0395n.q++;
                    }
                    jSONArray.put(jSONObject);
                }
            }
        }
    }

    private static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (String str2 : n) {
            if (str.endsWith(str2) && str.length() > str2.length()) {
                return str.substring(0, str.length() - str2.length());
            }
        }
        return null;
    }

    private static long n(File file, File file2, int[] iArr, int i, C0395n c0395n) {
        long length = 0;
        if (file == null || i > 8) {
            if (c0395n != null) {
                c0395n.s = true;
            }
            return 0L;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file3 : fileArrListFiles) {
            if (file3 != null && (file2 == null || !file3.equals(file2))) {
                if (iArr[0] >= 1000) {
                    if (c0395n != null) {
                        c0395n.s = true;
                    }
                    return length;
                }
                if (file3.isDirectory()) {
                    length += n(file3, null, iArr, i + 1, c0395n);
                } else {
                    length += file3.length();
                    iArr[0] = iArr[0] + 1;
                }
            }
        }
        return length;
    }

    private static void n(JSONObject jSONObject) {
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                StatFs statFs = new StatFs(externalStorageDirectory.getAbsolutePath());
                long totalBytes = statFs.getTotalBytes();
                long availableBytes = statFs.getAvailableBytes();
                jSONObject.put("ext_total_size", totalBytes);
                jSONObject.put("ext_total_size_str", n(totalBytes));
                jSONObject.put("ext_avail_size", availableBytes);
                jSONObject.put("ext_avail_size_str", n(availableBytes));
            }
            Context context = rv.getContext();
            if (context == null) {
                return;
            }
            File fileN = com.byazt.qyu.qg.n(context, null);
            if (fileN == null) {
                return;
            }
            File fileN2 = com.byazt.qyu.qg.n(context, Environment.DIRECTORY_DOWNLOADS);
            int i = 1;
            int[] iArr = {0};
            C0395n c0395n = new C0395n();
            long[] jArr = {0, 0};
            n(fileN, fileN2, iArr, 0, c0395n, jArr);
            jSONObject.put("ext_files_path", fileN.getAbsolutePath());
            jSONObject.put("ext_files_size", jArr[0]);
            jSONObject.put("ext_files_size_str", n(jArr[0]));
            jSONObject.put("ext_files_scanned_count", iArr[0]);
            jSONObject.put("ext_files_truncated", c0395n.s ? 1 : 0);
            if (fileN2 != null) {
                jSONObject.put("ext_files_download_path", fileN2.getAbsolutePath());
                jSONObject.put("ext_files_download_size", jArr[1]);
                jSONObject.put("ext_files_download_size_str", n(jArr[1]));
                if (!c0395n.s) {
                    i = 0;
                }
                jSONObject.put("ext_files_download_truncated", i);
            }
        } catch (Throwable unused) {
        }
    }

    private static void n(File file, File file2, int[] iArr, int i, C0395n c0395n, long[] jArr) {
        if (file == null || i > 8) {
            c0395n.s = true;
            return;
        }
        boolean z = file2 != null && n(file, file2);
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file3 : fileArrListFiles) {
            if (file3 != null) {
                if (iArr[0] >= 1000) {
                    c0395n.s = true;
                    return;
                } else if (file3.isDirectory()) {
                    n(file3, file2, iArr, i + 1, c0395n, jArr);
                } else {
                    long length = file3.length();
                    jArr[0] = jArr[0] + length;
                    if (z) {
                        jArr[1] = jArr[1] + length;
                    }
                    iArr[0] = iArr[0] + 1;
                }
            }
        }
    }

    private static boolean n(File file, File file2) {
        try {
            String canonicalPath = file.getCanonicalPath();
            String canonicalPath2 = file2.getCanonicalPath();
            return canonicalPath.equals(canonicalPath2) || canonicalPath.startsWith(new StringBuilder().append(canonicalPath2).append(File.separator).toString());
        } catch (Exception unused) {
            String absolutePath = file.getAbsolutePath();
            String absolutePath2 = file2.getAbsolutePath();
            return absolutePath.equals(absolutePath2) || absolutePath.startsWith(new StringBuilder().append(absolutePath2).append(File.separator).toString());
        }
    }

    private static String n(long j) {
        if (j <= 0) {
            return "0B";
        }
        String[] strArr = {UtilConst.CRASH_CAT_B, "KB", "MB", "GB", "TB"};
        double d = j;
        int i = 0;
        while (d >= 1024.0d && i < 4) {
            d /= 1024.0d;
            i++;
        }
        return String.format(Locale.US, "%.1f%s", Double.valueOf(d), strArr[i]);
    }

    /* JADX INFO: renamed from: com.byazt.xu.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 91, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static class C0395n {
        public int l;
        public long n;
        public int q;
        public int qg;
        public boolean s;
        public int w;
        public JSONObject x;

        private C0395n() {
            this.n = 0L;
            this.qg = 0;
            this.s = false;
            this.q = 0;
            this.l = 0;
            this.w = 0;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 91, 226})
    private static class qg {
        public final String n;
        public final String qg;
        public final String s;

        public qg(String str, String str2, String str3) {
            this.n = str;
            this.qg = str2;
            this.s = str3;
        }
    }
}
