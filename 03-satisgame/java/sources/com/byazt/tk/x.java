package com.byazt.tk;

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

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, 21})
public class x {
    public static File n(Context context, boolean z, String str, String str2) {
        String strConcat;
        String strQg = qg(context);
        if (z) {
            strConcat = n(context) + "-" + str;
        } else {
            strConcat = "/".concat(String.valueOf(str));
        }
        String str3 = ((strQg == null || strQg.endsWith(File.separator)) ? "" : strQg + File.separator) + strConcat;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str3, str2);
    }

    public static File qg(Context context, boolean z, String str, String str2) {
        String strS = s(context);
        if (z) {
            str = n(context) + "-" + str;
        }
        if (strS != null && !strS.endsWith(File.separator)) {
            strS = strS + File.separator;
        }
        String str3 = strS + str;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str3, str2);
    }

    public static File n(Context context, boolean z, String str) {
        String strQg = qg(context);
        if (z) {
            str = n(context) + "-" + str;
        }
        File file = new File(((strQg == null || strQg.endsWith(File.separator)) ? "" : strQg + File.separator) + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File qg(Context context, boolean z, String str) {
        String absolutePath = w.qg(context, false, null).getAbsolutePath();
        if (z) {
            str = n(context) + "-" + str;
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

    private static String qg(Context context) {
        boolean z;
        File fileQ;
        if (context == null) {
            return null;
        }
        try {
            z = "mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable();
        } catch (Throwable unused) {
        }
        if (z) {
            try {
                fileQ = w.q(context, false, null);
            } catch (Throwable unused2) {
                fileQ = null;
            }
        } else {
            fileQ = null;
        }
        if (fileQ == null) {
            try {
                fileQ = w.qg(context, false, null);
            } catch (Throwable unused3) {
            }
        }
        if (fileQ == null) {
            return null;
        }
        return fileQ.getPath();
    }

    private static String s(Context context) {
        File fileQg;
        if (context == null || (fileQg = w.qg(context, false, null)) == null) {
            return null;
        }
        return fileQg.getPath();
    }

    public static List<File> n(File file) {
        LinkedList linkedList = new LinkedList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return linkedList;
        }
        List<File> listAsList = Arrays.asList(fileArrListFiles);
        Collections.sort(listAsList, new n(null));
        return listAsList;
    }

    public static void qg(File file) throws IOException {
        if (file.exists()) {
            k.qg("splashLoadAd", "update file modify time");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(jCurrentTimeMillis)) {
                return;
            }
            l(file);
            if (file.lastModified() < jCurrentTimeMillis) {
                new Date(file.lastModified());
                file.getAbsolutePath();
            }
        }
    }

    public static void s(File file) {
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
                    s(file2);
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

    private static void l(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        long length = file.length();
        if (length == 0) {
            w(file);
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

    private static void w(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file ".concat(String.valueOf(file)));
        }
    }

    @com.byazt.cp.n(n = {0, 1, 350, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    private static final class n implements Comparator<File> {
        private int n(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        private n() {
        }

        public /* synthetic */ n(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return n(file.lastModified(), file2.lastModified());
        }
    }

    public static byte[] q(File file) {
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

    /* JADX INFO: renamed from: com.byazt.tk.x$1, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 350, 105})
    static class AnonymousClass1 implements Comparator<File> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long jLastModified = file2.lastModified() - file.lastModified();
            if (jLastModified == 0) {
                return 0;
            }
            return jLastModified < 0 ? -1 : 1;
        }
    }

    public static String n(Context context) {
        String strQg = ((com.byazt.vf.l) com.byazt.qp.q.n("app_process")).qg();
        return (TextUtils.isEmpty(strQg) || !strQg.contains(":")) ? strQg : strQg.replace(":", "-");
    }
}
