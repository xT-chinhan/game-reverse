package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static File ms(Context context, boolean z, String str, String str2) {
        String strConcat;
        String strXr = xr(context);
        if (z) {
            strConcat = ms(context) + "-" + str;
        } else {
            strConcat = "/".concat(String.valueOf(str));
        }
        String str3 = ((strXr == null || strXr.endsWith(File.separator)) ? "" : strXr + File.separator) + strConcat;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str3, str2);
    }

    public static File xr(Context context, boolean z, String str, String str2) {
        String strAh = ah(context);
        if (z) {
            str = ms(context) + "-" + str;
        }
        if (strAh != null && !strAh.endsWith(File.separator)) {
            strAh = strAh + File.separator;
        }
        String str3 = strAh + str;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str3, str2);
    }

    public static File ms(Context context, boolean z, String str) {
        String strXr = xr(context);
        if (z) {
            str = ms(context) + "-" + str;
        }
        File file = new File(((strXr == null || strXr.endsWith(File.separator)) ? "" : strXr + File.separator) + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File xr(Context context, boolean z, String str) {
        String absolutePath = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(context).getAbsolutePath();
        if (z) {
            str = ms(context) + "-" + str;
        }
        if (absolutePath != null && !absolutePath.endsWith(File.separator)) {
            absolutePath = absolutePath + File.separator;
        }
        File file = new File(absolutePath + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static String xr(Context context) {
        File fileAh;
        if (context == null) {
            return null;
        }
        boolean z = false;
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
                z = true;
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
        if (z) {
            try {
                fileAh = com.bytedance.sdk.openadsdk.api.plugin.xr.ah(context);
            } catch (Throwable unused) {
                fileAh = null;
            }
        } else {
            fileAh = null;
        }
        if (fileAh == null) {
            try {
                fileAh = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(context);
            } catch (Throwable unused2) {
            }
        }
        if (fileAh == null) {
            return null;
        }
        return fileAh.getPath();
    }

    private static String ah(Context context) {
        File fileXr;
        if (context == null || (fileXr = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(context)) == null) {
            return null;
        }
        return fileXr.getPath();
    }

    public static List<File> ms(File file) {
        LinkedList linkedList = new LinkedList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return linkedList;
        }
        List<File> listAsList = Arrays.asList(fileArrListFiles);
        Collections.sort(listAsList, new ms(null));
        return listAsList;
    }

    public static void xr(File file) throws IOException {
        if (file.exists()) {
            sl.d("splashLoadAd", "update file modify time");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(jCurrentTimeMillis)) {
                return;
            }
            ka(file);
            if (file.lastModified() < jCurrentTimeMillis) {
                sl.xr("Files", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
            }
        }
    }

    public static void ah(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            try {
                file.delete();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    ah(file2);
                } else {
                    try {
                        file2.delete();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
        try {
            file.delete();
        } catch (Throwable unused3) {
        }
    }

    private static void ka(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        long length = file.length();
        if (length == 0) {
            c(file);
            return;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "rwd");
            long j = length - 1;
            try {
                randomAccessFile.seek(j);
                byte b = randomAccessFile.readByte();
                randomAccessFile.seek(j);
                randomAccessFile.write(b);
                randomAccessFile.close();
            } catch (Throwable unused) {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
    }

    private static void c(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file ".concat(String.valueOf(file)));
        }
    }

    private static final class ms implements Comparator<File> {
        private int ms(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        private ms() {
        }

        /* synthetic */ ms(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return ms(file.lastModified(), file2.lastModified());
        }
    }

    public static byte[] d(File file) {
        FileInputStream fileInputStream;
        if (file != null && file.isFile() && file.exists() && file.canRead() && file.length() > 0) {
            try {
                Long lValueOf = Long.valueOf(file.length());
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[lValueOf.intValue()];
                    if (fileInputStream.read(bArr) == lValueOf.longValue()) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused) {
                        }
                        return bArr;
                    }
                } catch (Throwable unused2) {
                    if (fileInputStream != null) {
                    }
                    return null;
                }
            } catch (Throwable unused3) {
                fileInputStream = null;
            }
            try {
                fileInputStream.close();
            } catch (Throwable unused4) {
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.utils.c$1, reason: invalid class name */
    static class AnonymousClass1 implements Comparator<File> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long jLastModified = file2.lastModified() - file.lastModified();
            if (jLastModified == 0) {
                return 0;
            }
            return jLastModified < 0 ? -1 : 1;
        }
    }

    public static String ms(Context context) {
        String strMs = qv.ms(context);
        return (TextUtils.isEmpty(strMs) || !strMs.contains(":")) ? strMs : strMs.replace(":", "-");
    }
}
