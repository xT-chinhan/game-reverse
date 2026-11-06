package com.byazt.ca;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 62})
public class fw {
    public static File pr(Context context, boolean z, String str, String str2) {
        String strConcat;
        String str3;
        String strHw = hw(context);
        if (z) {
            strConcat = pr(context) + "-" + str;
        } else {
            strConcat = "/".concat(String.valueOf(str));
        }
        if (strHw != null && !strHw.endsWith(File.separator)) {
            str3 = strHw + File.separator;
        } else {
            str3 = "";
        }
        String str4 = str3 + strConcat;
        File file = new File(str4);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str4, str2);
    }

    public static File hw(Context context, boolean z, String str, String str2) {
        String strHn = hn(context);
        if (z) {
            str = pr(context) + "-" + str;
        }
        if (strHn != null && !strHn.endsWith(File.separator)) {
            strHn = strHn + File.separator;
        }
        String str3 = strHn + str;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str3, str2);
    }

    public static File pr(Context context, boolean z, String str) {
        String str2;
        String strHw = hw(context);
        if (z) {
            str = pr(context) + "-" + str;
        }
        if (strHw != null && !strHw.endsWith(File.separator)) {
            str2 = strHw + File.separator;
        } else {
            str2 = "";
        }
        File file = new File(str2 + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File hw(Context context, boolean z, String str) {
        String absolutePath = uc.hw(context, false, null).getAbsolutePath();
        if (z) {
            str = pr(context) + "-" + str;
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

    private static String hw(Context context) {
        boolean z;
        File fileX;
        if (context == null) {
            return null;
        }
        try {
            z = "mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable();
        } catch (Throwable th) {
            z = false;
        }
        if (!z) {
            fileX = null;
        } else {
            try {
                fileX = uc.x(context, false, null);
            } catch (Throwable th2) {
                fileX = null;
            }
        }
        if (fileX == null) {
            try {
                fileX = uc.hw(context, false, null);
            } catch (Throwable th3) {
            }
        }
        if (fileX == null) {
            return null;
        }
        return fileX.getPath();
    }

    private static String hn(Context context) {
        File fileHw;
        if (context == null || (fileHw = uc.hw(context, false, null)) == null) {
            return null;
        }
        return fileHw.getPath();
    }

    public static List<File> pr(File file) {
        LinkedList linkedList = new LinkedList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            List<File> listAsList = Arrays.asList(fileArrListFiles);
            Collections.sort(listAsList, new pr(null));
            return listAsList;
        }
        return linkedList;
    }

    public static void hw(File file) throws IOException {
        if (file.exists()) {
            ho.hw("splashLoadAd", "update file modify time");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!file.setLastModified(jCurrentTimeMillis)) {
                c(file);
                if (file.lastModified() < jCurrentTimeMillis) {
                    new Date(file.lastModified());
                    file.getAbsolutePath();
                }
            }
        }
    }

    public static void hn(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            try {
                file.delete();
                return;
            } catch (Throwable th) {
                return;
            }
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    hn(file2);
                } else {
                    try {
                        file2.delete();
                    } catch (Throwable th2) {
                    }
                }
            }
        }
        try {
            file.delete();
        } catch (Throwable th3) {
        }
    }

    private static void c(File file) throws IOException {
        long length = file.length();
        if (length == 0) {
            uc(file);
            return;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
            long j = length - 1;
            try {
                randomAccessFile2.seek(j);
                byte b = randomAccessFile2.readByte();
                randomAccessFile2.seek(j);
                randomAccessFile2.write(b);
                randomAccessFile2.close();
            } catch (Throwable th) {
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            }
        } catch (Throwable th2) {
        }
    }

    private static void uc(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file ".concat(String.valueOf(file)));
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 766})
    private static final class pr implements Comparator<File> {
        private pr() {
        }

        public /* synthetic */ pr(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return pr(file.lastModified(), file2.lastModified());
        }

        private int pr(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }
    }

    public static byte[] x(File file) {
        FileInputStream fileInputStream;
        if (file != null && file.isFile() && file.exists() && file.canRead()) {
            try {
                if (file.length() > 0) {
                    try {
                        Long lValueOf = Long.valueOf(file.length());
                        fileInputStream = new FileInputStream(file);
                        try {
                            byte[] bArr = new byte[lValueOf.intValue()];
                            if (fileInputStream.read(bArr) == lValueOf.longValue()) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th) {
                                }
                                return bArr;
                            }
                            fileInputStream.close();
                        } catch (Throwable th2) {
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return null;
                        }
                    } catch (Throwable th3) {
                        fileInputStream = null;
                    }
                }
            } catch (Throwable th4) {
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: com.byazt.ca.fw$1, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO})
    static class AnonymousClass1 implements Comparator<File> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long jLastModified = file2.lastModified() - file.lastModified();
            if (jLastModified == 0) {
                return 0;
            }
            if (jLastModified < 0) {
                return -1;
            }
            return 1;
        }
    }

    public static String pr(Context context) {
        String strHw = ((com.byazt.vkw.c) com.byazt.zs.uc.pr("app_process")).hw();
        if (!TextUtils.isEmpty(strHw) && strHw.contains(":")) {
            return strHw.replace(":", "-");
        }
        return strHw;
    }
}
