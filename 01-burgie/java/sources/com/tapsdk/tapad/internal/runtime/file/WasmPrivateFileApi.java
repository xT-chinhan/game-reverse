package com.tapsdk.tapad.internal.runtime.file;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tapsdk.tapad.internal.runtime.download.DownloadUtils;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class WasmPrivateFileApi {
    private static final int CMD_EXISTS = 0;
    private static final int CMD_IS_DIR = 2;
    private static final int CMD_IS_FILE = 1;
    private static final int CMD_LENGTH = 3;
    private static final String TAG = "WasmPrivateFileApi";

    private WasmPrivateFileApi() {
    }

    private static long absoluteDifference(long j, long j2) {
        return j >= j2 ? j - j2 : j2 - j;
    }

    private static void addCandidateArray(Set<String> set, JSONArray jSONArray, boolean z) {
        if (jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String strOptString = jSONArray.optString(i, "");
            if (z) {
                addUrlCandidateName(set, strOptString);
            } else {
                addSafeCandidateName(set, strOptString);
            }
        }
    }

    private static void addDownloadCacheRoot(List<File> list, Set<String> set, File file) throws IOException {
        if (file == null) {
            return;
        }
        File canonicalFile = file.getCanonicalFile();
        if (set.add(canonicalFile.getPath())) {
            list.add(canonicalFile);
        }
    }

    private static void addSafeCandidateName(Set<String> set, String str) {
        if (TextUtils.isEmpty(str) || str.contains("/") || str.contains("\\") || str.contains("\u0000") || ".".equals(str) || "..".equals(str)) {
            return;
        }
        set.add(str);
    }

    private static void addUrlCandidateName(Set<String> set, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        addSafeCandidateName(set, DownloadUtils.extractFileName(str));
    }

    private static Set<String> cacheCandidateNames(JSONObject jSONObject) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        addSafeCandidateName(linkedHashSet, jSONObject.optString("path", ""));
        addCandidateArray(linkedHashSet, jSONObject.optJSONArray("legacyFileNames"), false);
        addCandidateArray(linkedHashSet, jSONObject.optJSONArray("cacheUrls"), true);
        addCandidateArray(linkedHashSet, jSONObject.optJSONArray("urls"), true);
        addUrlCandidateName(linkedHashSet, jSONObject.optString(BreakpointSQLiteKey.URL, ""));
        return linkedHashSet;
    }

    private static boolean cachedApkMatchesPackage(Context context, File file, String str) {
        if (file.getName().startsWith(str + "_")) {
            return true;
        }
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0);
            return packageArchiveInfo != null && str.equals(packageArchiveInfo.packageName);
        } catch (Throwable th) {
            file.getName();
            return false;
        }
    }

    public static int call(Context context, int i, String str, int i2) {
        File fileResolve = resolve(context, str);
        if (fileResolve == null) {
            return i == 3 ? -1 : 0;
        }
        switch (i) {
            case 0:
                return fileResolve.exists() ? 1 : 0;
            case 1:
                return fileResolve.isFile() ? 1 : 0;
            case 2:
                return fileResolve.isDirectory() ? 1 : 0;
            case 3:
                if (!fileResolve.isFile()) {
                    return -1;
                }
                long length = fileResolve.length();
                if (length > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                return (int) length;
            default:
                return -1;
        }
    }

    private static List<File> downloadCacheRoots(Context context) throws IOException {
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        addDownloadCacheRoot(arrayList, linkedHashSet, DownloadUtils.getDefaultDownloadDir(context));
        for (File file : DownloadUtils.getLegacyDownloadDirs(context)) {
            addDownloadCacheRoot(arrayList, linkedHashSet, file);
        }
        return arrayList;
    }

    private static boolean isValidCachedApk(Context context, File file, JSONObject jSONObject) {
        if (file != null && file.isFile()) {
            String name = file.getName();
            Locale locale = Locale.US;
            if (name.toLowerCase(locale).endsWith(".apk")) {
                String strOptString = jSONObject.optString(BillingClientConstants.PACKAGE_NAME, "");
                if (!TextUtils.isEmpty(strOptString) && !cachedApkMatchesPackage(context, file, strOptString)) {
                    return false;
                }
                if (jSONObject.optInt("apkVerifyType", 0) == 1) {
                    return true;
                }
                long jOptLong = jSONObject.optLong("expectedSize", -1L);
                if (jOptLong >= 0 && absoluteDifference(file.length(), jOptLong) < 10) {
                    String strOptString2 = jSONObject.optString("md5", "");
                    if (TextUtils.isEmpty(strOptString2)) {
                        return true;
                    }
                    String lowerCase = file.getName().toLowerCase(locale);
                    String lowerCase2 = strOptString2.toLowerCase(locale);
                    if (lowerCase.contains("_" + lowerCase2 + "_") || lowerCase.endsWith("_" + lowerCase2 + ".apk")) {
                        return true;
                    }
                    return DownloadUtils.verifyMd5(file, strOptString2);
                }
            }
        }
        return false;
    }

    static /* synthetic */ boolean lambda$resolveCachedApk$0(File file) {
        return file != null && file.isFile() && file.getName().toLowerCase(Locale.US).endsWith(".apk");
    }

    private static File resolve(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            if (str == null) {
                str = "{}";
            }
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("scope", "");
            return ("download_cache".equals(strOptString) && jSONObject.optBoolean("cacheResolve", false)) ? resolveCachedApk(context, jSONObject) : resolvePrivateFile(context, strOptString, jSONObject.optString("path", ""));
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static File resolveCachedApk(Context context, JSONObject jSONObject) {
        if (context != null && jSONObject != null) {
            try {
                List<File> listDownloadCacheRoots = downloadCacheRoots(context);
                Set<String> setCacheCandidateNames = cacheCandidateNames(jSONObject);
                for (File file : listDownloadCacheRoots) {
                    Iterator<String> it = setCacheCandidateNames.iterator();
                    while (it.hasNext()) {
                        File fileResolveRelative = resolveRelative(file, it.next());
                        if (isValidCachedApk(context, fileResolveRelative, jSONObject)) {
                            return fileResolveRelative;
                        }
                    }
                }
                if (TextUtils.isEmpty(jSONObject.optString(BillingClientConstants.PACKAGE_NAME, ""))) {
                    return null;
                }
                Iterator<File> it2 = listDownloadCacheRoots.iterator();
                while (it2.hasNext()) {
                    File next = it2.next();
                    File[] fileArrListFiles = next != null ? next.listFiles(new FileFilter() { // from class: com.tapsdk.tapad.internal.runtime.file.WasmPrivateFileApi$$ExternalSyntheticLambda0
                        @Override // java.io.FileFilter
                        public final boolean accept(File file2) {
                            return WasmPrivateFileApi.lambda$resolveCachedApk$0(file2);
                        }
                    }) : null;
                    if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                        Arrays.sort(fileArrListFiles, new Comparator<File>() { // from class: com.tapsdk.tapad.internal.runtime.file.WasmPrivateFileApi.1
                            @Override // java.util.Comparator
                            public int compare(File file2, File file3) {
                                return Long.compare(file3.lastModified(), file2.lastModified());
                            }
                        });
                        for (File file2 : fileArrListFiles) {
                            if (isValidCachedApk(context, file2, jSONObject)) {
                                return file2;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return null;
    }

    private static File resolveDownloadCacheFile(Context context, String str) throws IOException {
        File fileResolveRelative = resolveRelative(DownloadUtils.getDefaultDownloadDir(context), str);
        if (fileResolveRelative != null && fileResolveRelative.exists()) {
            return fileResolveRelative;
        }
        for (File file : DownloadUtils.getLegacyDownloadDirs(context)) {
            File fileResolveRelative2 = resolveRelative(file, str);
            if (fileResolveRelative2 != null && fileResolveRelative2.exists()) {
                return fileResolveRelative2;
            }
        }
        return fileResolveRelative;
    }

    public static File resolvePrivateFile(Context context, String str, String str2) {
        try {
            return "download_cache".equals(str) ? resolveDownloadCacheFile(context, str2) : resolveRelative(rootForScope(context, str), str2);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    private static File resolveRelative(File file, String str) throws IOException {
        if (file == null || TextUtils.isEmpty(str) || new File(str).isAbsolute()) {
            return null;
        }
        File canonicalFile = file.getCanonicalFile();
        File canonicalFile2 = new File(canonicalFile, str).getCanonicalFile();
        String path = canonicalFile.getPath();
        String path2 = canonicalFile2.getPath();
        if (path2.equals(path) || path2.startsWith(path + File.separator)) {
            return canonicalFile2;
        }
        return null;
    }

    private static File rootForScope(Context context, String str) {
        if ("cache".equals(str)) {
            return context.getCacheDir();
        }
        if ("files".equals(str)) {
            return context.getFilesDir();
        }
        if ("external_cache".equals(str)) {
            return context.getExternalCacheDir();
        }
        if ("external_files".equals(str)) {
            return context.getExternalFilesDir(null);
        }
        if ("download_cache".equals(str)) {
            return DownloadUtils.getDefaultDownloadDir(context);
        }
        return null;
    }
}
