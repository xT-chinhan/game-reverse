package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import com.taptap.sdk.compliance.bean.IdentityVerifyStateKt;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes.dex */
final class MultiDexExtractor {
    private static final int BUFFER_SIZE = 16384;
    private static final String DEX_PREFIX = "classes";
    private static final String DEX_SUFFIX = ".dex";
    private static final String EXTRACTED_NAME_EXT = ".classes";
    private static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_CRC = "crc";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String KEY_TIME_STAMP = "timestamp";
    private static final int MAX_EXTRACT_ATTEMPTS = 3;
    private static final long NO_VALUE = -1;
    private static final String PREFS_FILE = "multidex.version";
    private static final String TAG = "MultiDex";
    private static Method sApplyMethod;

    static {
        try {
            sApplyMethod = SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
        } catch (NoSuchMethodException unused) {
            sApplyMethod = null;
        }
    }

    MultiDexExtractor() {
    }

    private static void apply(SharedPreferences.Editor editor) {
        Method method = sApplyMethod;
        if (method != null) {
            try {
                method.invoke(editor, new Object[0]);
                return;
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        editor.commit();
    }

    private static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w(TAG, "Failed to close resource", e);
        }
    }

    private static void extract(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File fileCreateTempFile = File.createTempFile(str, EXTRACTED_SUFFIX, file.getParentFile());
        Log.i(TAG, "Extracting " + fileCreateTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(fileCreateTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                for (int i = inputStream.read(bArr); i != -1; i = inputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, i);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                Log.i(TAG, "Renaming to " + file.getPath());
                if (fileCreateTempFile.renameTo(file)) {
                    closeQuietly(inputStream);
                    fileCreateTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + fileCreateTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            closeQuietly(inputStream);
            fileCreateTempFile.delete();
            throw th2;
        }
    }

    private static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, 4);
    }

    private static long getTimeStamp(File file) {
        long jLastModified = file.lastModified();
        return jLastModified == -1 ? jLastModified - 1 : jLastModified;
    }

    private static long getZipCrc(File file) throws IOException {
        long zipCrc = ZipUtil.getZipCrc(file);
        return zipCrc == -1 ? zipCrc - 1 : zipCrc;
    }

    private static boolean isModified(Context context, File file, long j) {
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        return (multiDexPreferences.getLong("timestamp", -1L) == getTimeStamp(file) && multiDexPreferences.getLong(KEY_CRC, -1L) == j) ? false : true;
    }

    static List<File> load(Context context, ApplicationInfo applicationInfo, File file, boolean z) throws IOException {
        List<File> listPerformExtractions;
        List<File> listLoadExistingExtractions;
        Log.i(TAG, "MultiDexExtractor.load(" + applicationInfo.sourceDir + ", " + z + ")");
        File file2 = new File(applicationInfo.sourceDir);
        long zipCrc = getZipCrc(file2);
        if (!z && !isModified(context, file2, zipCrc)) {
            try {
                listLoadExistingExtractions = loadExistingExtractions(context, file2, file);
            } catch (IOException e) {
                Log.w(TAG, "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e);
                listPerformExtractions = performExtractions(file2, file);
                putStoredApkInfo(context, getTimeStamp(file2), zipCrc, listPerformExtractions.size() + 1);
                listLoadExistingExtractions = listPerformExtractions;
            }
            Log.i(TAG, "load found " + listLoadExistingExtractions.size() + " secondary dex files");
            return listLoadExistingExtractions;
        }
        Log.i(TAG, "Detected that extraction must be performed.");
        listPerformExtractions = performExtractions(file2, file);
        putStoredApkInfo(context, getTimeStamp(file2), zipCrc, listPerformExtractions.size() + 1);
        listLoadExistingExtractions = listPerformExtractions;
        Log.i(TAG, "load found " + listLoadExistingExtractions.size() + " secondary dex files");
        return listLoadExistingExtractions;
    }

    private static List<File> loadExistingExtractions(Context context, File file, File file2) throws IOException {
        Log.i(TAG, "loading existing secondary dex files");
        String str = file.getName() + EXTRACTED_NAME_EXT;
        int i = getMultiDexPreferences(context).getInt(KEY_DEX_NUMBER, 1);
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 2; i2 <= i; i2++) {
            File file3 = new File(file2, str + i2 + EXTRACTED_SUFFIX);
            if (!file3.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
            }
            arrayList.add(file3);
            if (!verifyZipFile(file3)) {
                Log.i(TAG, "Invalid zip file: " + file3);
                throw new IOException("Invalid ZIP file.");
            }
        }
        return arrayList;
    }

    private static void mkdirChecked(File file) throws IOException {
        file.mkdir();
        if (file.isDirectory()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            Log.e(TAG, "Failed to create dir " + file.getPath() + ". Parent file is null.");
        } else {
            Log.e(TAG, "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
        }
        throw new IOException("Failed to create cache directory " + file.getPath());
    }

    private static List<File> performExtractions(File file, File file2) throws IOException {
        String str = file.getName() + EXTRACTED_NAME_EXT;
        prepareDexDir(file2, str);
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        try {
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            int i = 2;
            while (entry != null) {
                File file3 = new File(file2, str + i + EXTRACTED_SUFFIX);
                arrayList.add(file3);
                Log.i(TAG, "Extraction is needed for file " + file3);
                int i2 = 0;
                boolean zVerifyZipFile = false;
                while (i2 < 3 && !zVerifyZipFile) {
                    i2++;
                    extract(zipFile, entry, file3, str);
                    zVerifyZipFile = verifyZipFile(file3);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(zVerifyZipFile ? TrackAction.SUCCESS : IdentityVerifyStateKt.VERIFY_STATE_FAILED);
                    sb.append(" - length ");
                    sb.append(file3.getAbsolutePath());
                    sb.append(": ");
                    sb.append(file3.length());
                    Log.i(TAG, sb.toString());
                    if (!zVerifyZipFile) {
                        file3.delete();
                        if (file3.exists()) {
                            Log.w(TAG, "Failed to delete corrupted secondary dex '" + file3.getPath() + "'");
                        }
                    }
                }
                if (!zVerifyZipFile) {
                    throw new IOException("Could not create zip file " + file3.getAbsolutePath() + " for secondary dex (" + i + ")");
                }
                i++;
                entry = zipFile.getEntry(DEX_PREFIX + i + DEX_SUFFIX);
            }
            try {
                zipFile.close();
            } catch (IOException e) {
                Log.w(TAG, "Failed to close resource", e);
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (IOException e2) {
                Log.w(TAG, "Failed to close resource", e2);
            }
            throw th;
        }
    }

    private static void prepareDexDir(File file, final String str) throws IOException {
        mkdirChecked(file.getParentFile());
        mkdirChecked(file);
        File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: androidx.multidex.MultiDexExtractor.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return !file2.getName().startsWith(str);
            }
        });
        if (fileArrListFiles == null) {
            Log.w(TAG, "Failed to list secondary dex dir content (" + file.getPath() + ").");
            return;
        }
        for (File file2 : fileArrListFiles) {
            Log.i(TAG, "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
            if (file2.delete()) {
                Log.i(TAG, "Deleted old file " + file2.getPath());
            } else {
                Log.w(TAG, "Failed to delete old file " + file2.getPath());
            }
        }
    }

    private static void putStoredApkInfo(Context context, long j, long j2, int i) {
        SharedPreferences.Editor editorEdit = getMultiDexPreferences(context).edit();
        editorEdit.putLong("timestamp", j);
        editorEdit.putLong(KEY_CRC, j2);
        editorEdit.putInt(KEY_DEX_NUMBER, i);
        apply(editorEdit);
    }

    static boolean verifyZipFile(File file) {
        try {
            try {
                try {
                    new ZipFile(file).close();
                    return true;
                } catch (IOException unused) {
                    Log.w(TAG, "Failed to close zip file: " + file.getAbsolutePath());
                    return false;
                }
            } catch (IOException e) {
                Log.w(TAG, "Got an IOException trying to open zip file: " + file.getAbsolutePath(), e);
                return false;
            }
        } catch (ZipException e2) {
            Log.w(TAG, "File " + file.getAbsolutePath() + " is not a valid zip file.", e2);
            return false;
        }
    }
}
