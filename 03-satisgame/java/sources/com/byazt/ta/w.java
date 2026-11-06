package com.byazt.ta;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.anythink.china.a.c;
import com.byazt.i.d;
import com.byazt.je.an;
import com.byazt.je.m;
import com.byazt.qx.BaseException;
import com.byazt.tk.k;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.taptap.sdk.compilance.constants.ComplianceMessage;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.UByte;
import okhttp3.internal.http2.StreamResetException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 13})
public class w {
    public static Boolean cp = null;
    public static final String n = "w";
    public static ConnectivityManager rv;
    public static Boolean tj;
    public static final Pattern qg = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    public static String s = null;
    public static volatile SparseArray<Boolean> q = new SparseArray<>();
    public static volatile SparseArray<List<an>> l = new SparseArray<>();
    public static final char[] w = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static Pattern x = null;
    public static Pattern fs = null;

    public static double n(long j) {
        return j / 1048576.0d;
    }

    public static boolean n(int i) {
        return i == 0 || i == 2;
    }

    public static boolean q(int i) {
        return i == 206 || i == 200;
    }

    public static boolean qg(long j) {
        return j == -1;
    }

    public static boolean s(int i) {
        return i == 200 || i == 201 || i == 0;
    }

    public static String n(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        return n(bArr, 0, bArr.length);
    }

    public static String n(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2 * 2;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i5 + i] & UByte.MAX_VALUE;
            int i7 = i4 + 1;
            char[] cArr2 = w;
            cArr[i4] = cArr2[i6 >> 4];
            i4 = i7 + 1;
            cArr[i7] = cArr2[i6 & 15];
        }
        return new String(cArr, 0, i3);
    }

    public static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            try {
                bArr[i] = (byte) (Integer.parseInt(str.substring(i2, i2 + 2), 16) & 255);
            } catch (Exception unused) {
            }
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Exception unused2) {
            return str;
        }
    }

    public static long n(com.byazt.m.x xVar) {
        if (xVar == null) {
            return -1L;
        }
        String strQg = qg(xVar, "Content-Length");
        if (TextUtils.isEmpty(strQg) && n.n(1)) {
            return qg(xVar);
        }
        try {
            return Long.parseLong(strQg);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static long qg(com.byazt.m.x xVar) {
        if (xVar == null) {
            return -1L;
        }
        String strQg = qg(xVar, "Content-Range");
        if (TextUtils.isEmpty(strQg)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(strQg);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e) {
            com.byazt.fe.n.q(n, "parse content-length from content-range failed " + e);
        }
        return -1L;
    }

    public static long qg(String str) {
        if (str == null) {
            return -1L;
        }
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length >= 2) {
            try {
                return Long.parseLong(strArrSplit[1]);
            } catch (NumberFormatException unused) {
                com.byazt.fe.n.q(n, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    private static String tj(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (x == null) {
                x = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            Matcher matcher = x.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            if (fs == null) {
                fs = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
            }
            Matcher matcher2 = fs.matcher(str);
            if (matcher2.find()) {
                return matcher2.group(1);
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public static String n(com.byazt.m.x xVar, String str) {
        String strTj = tj(xVar.n("Content-Disposition"));
        return TextUtils.isEmpty(strTj) ? l(str) : strTj;
    }

    public static com.byazt.wm.l n(DownloadInfo downloadInfo, String str, String str2, int i) throws BaseException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new BaseException(PointerIconCompat.TYPE_GRABBING, new IOException("path must be not empty"));
        }
        File file = new File(str, str2);
        boolean zMkdirs = false;
        if (file.exists() && file.isDirectory()) {
            throw new BaseException(1035, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
        }
        if (!file.exists()) {
            try {
                File file2 = new File(str);
                if (!file2.exists() || !file2.isDirectory()) {
                    if (!file2.exists()) {
                        if (!file2.mkdirs() && !file2.exists()) {
                            if (com.byazt.f.n.n(downloadInfo).n("opt_mkdir_failed", 0) != 1) {
                                throw new BaseException(1030, "download savePath directory can not created:" + str);
                            }
                            int i2 = 0;
                            while (!zMkdirs) {
                                int i3 = i2 + 1;
                                if (i2 >= 3) {
                                    break;
                                }
                                try {
                                    Thread.sleep(10L);
                                    zMkdirs = file2.mkdirs();
                                    i2 = i3;
                                } catch (InterruptedException unused) {
                                }
                            }
                            if (!zMkdirs) {
                                if (q(downloadInfo.getSavePath()) < c.o) {
                                    throw new BaseException(1006, "download savePath directory can not created:" + str);
                                }
                                throw new BaseException(1030, "download savePath directory can not created:" + str);
                            }
                        }
                    } else {
                        file2.delete();
                        if (!file2.mkdirs() && !file2.exists()) {
                            throw new BaseException(1031, "download savePath is not directory:path=" + str);
                        }
                        throw new BaseException(1031, "download savePath is not directory:" + str);
                    }
                }
                file.createNewFile();
            } catch (IOException e) {
                throw new BaseException(1036, e);
            }
        }
        return new com.byazt.wm.l(file, i);
    }

    public static List<com.byazt.wm.qg> n(List<com.byazt.wm.qg> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (com.byazt.wm.qg qgVar : list) {
            if (qgVar != null) {
                if (qgVar.q()) {
                    sparseArray.put(qgVar.um(), qgVar);
                    List<com.byazt.wm.qg> list2 = (List) sparseArray2.get(qgVar.um());
                    if (list2 != null) {
                        Iterator<com.byazt.wm.qg> it = list2.iterator();
                        while (it.hasNext()) {
                            it.next().n(qgVar);
                        }
                        qgVar.n(list2);
                    }
                } else {
                    com.byazt.wm.qg qgVar2 = (com.byazt.wm.qg) sparseArray.get(qgVar.qg());
                    if (qgVar2 != null) {
                        List<com.byazt.wm.qg> listX = qgVar2.x();
                        if (listX == null) {
                            listX = new ArrayList<>();
                            qgVar2.n(listX);
                        }
                        qgVar.n(qgVar2);
                        listX.add(qgVar);
                    } else {
                        List arrayList = (List) sparseArray2.get(qgVar.qg());
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            sparseArray2.put(qgVar.qg(), arrayList);
                        }
                        arrayList.add(qgVar);
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList2.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList2.isEmpty() ? list : arrayList2;
    }

    public static String n(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    public static String n(String str, String str2, String str3) {
        String strN;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            strN = n(str2, str3);
        } else {
            strN = n(str, str3);
        }
        if (TextUtils.isEmpty(strN)) {
            return null;
        }
        return String.format("%s.tp", strN);
    }

    public static String qg(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public static String s(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    public static long qg(List<com.byazt.wm.qg> list) {
        Iterator<com.byazt.wm.qg> it = list.iterator();
        long jK = 0;
        while (it.hasNext()) {
            jK += it.next().k();
        }
        return jK;
    }

    public static void n(DownloadInfo downloadInfo) {
        n(downloadInfo, true);
    }

    public static void n(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (z) {
            try {
                s(downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (Throwable unused) {
                return;
            }
        }
        s(downloadInfo.getTempPath(), downloadInfo.getTempName());
        if (downloadInfo.isSavePathRedirected()) {
            qg(downloadInfo);
        }
        if (z) {
            String strL = l(downloadInfo.getUrl());
            if (TextUtils.isEmpty(strL) || TextUtils.isEmpty(downloadInfo.getSavePath()) || !downloadInfo.getSavePath().contains(strL)) {
                return;
            }
            cp(downloadInfo.getSavePath());
        }
    }

    public static void qg(DownloadInfo downloadInfo) {
        com.byazt.f.n nVarN;
        JSONObject jSONObjectQ;
        if (downloadInfo == null || (jSONObjectQ = (nVarN = com.byazt.f.n.n(downloadInfo.getId())).q("download_dir")) == null) {
            return;
        }
        String strOptString = jSONObjectQ.optString("ins_desc");
        if (!TextUtils.isEmpty(strOptString)) {
            s(downloadInfo.getSavePath(), strOptString);
        }
        String title = downloadInfo.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = downloadInfo.getName();
        }
        String strN = n(title, nVarN);
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(strN) || TextUtils.isEmpty(savePath)) {
            return;
        }
        File file = new File(strN);
        for (File file2 = new File(savePath); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            cp(file2.getPath());
            file = file.getParentFile();
        }
    }

    private static boolean cp(String str) {
        Thread.currentThread();
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            return file.isDirectory() && file.delete();
        }
        return false;
    }

    public static void s(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            k.qg(n, "deleteFile: " + str + "/" + str2);
            file.delete();
        }
    }

    public static boolean n(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static boolean s(DownloadInfo downloadInfo) {
        return n(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5());
    }

    public static boolean n(DownloadInfo downloadInfo, boolean z, String str) {
        if (!z && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            try {
                if (new File(downloadInfo.getSavePath(), downloadInfo.getName()).exists() && s(downloadInfo.getSavePath(), downloadInfo.getName(), str)) {
                    return true;
                }
            } catch (OutOfMemoryError unused) {
            }
        }
        return false;
    }

    public static boolean q(DownloadInfo downloadInfo) {
        boolean z = false;
        if (!downloadInfo.isDeleteCacheIfCheckFailed() && TextUtils.isEmpty(downloadInfo.getLastModified())) {
            com.byazt.fe.n.qg(n, "dcache::last modify is emtpy, so just return cache");
        } else {
            com.byazt.fe.n.qg(n, "dcache::curt=" + System.currentTimeMillis() + " expired=" + downloadInfo.getCacheExpiredTime());
            if (System.currentTimeMillis() > downloadInfo.getCacheExpiredTime()) {
                z = true;
            }
        }
        com.byazt.fe.n.qg(n, "cacheExpired::dcache::name=" + downloadInfo.getName() + " expired=" + z);
        return z;
    }

    public static int qg(String str, String str2, String str3) {
        return com.byazt.v.s.n(str3, new File(str, str2));
    }

    public static boolean s(String str, String str2, String str3) {
        return n(qg(str, str2, str3));
    }

    public static int n(File file, String str) {
        return com.byazt.v.s.n(str, file);
    }

    public static String qg(int i) {
        String str = "ttmd5 check code = " + i + ", ";
        if (i != 99) {
            switch (i) {
                case 0:
                    return str + "md5 match";
                case 1:
                    return str + "md5 not match";
                case 2:
                    return str + "md5 empty";
                case 3:
                    return str + "ttmd5 version not support";
                case 4:
                    return str + "ttmd5 tag parser error";
                case 5:
                    return str + "file not exist";
                case 6:
                    return str + "get file md5 error";
                default:
                    return str;
            }
        }
        return str + "unknown error";
    }

    public static long q(String str) throws BaseException {
        try {
            return new StatFs(str).getAvailableBytes();
        } catch (IllegalArgumentException e) {
            throw new BaseException(ComplianceMessage.DURATION_LIMIT, e);
        } catch (Throwable th) {
            throw new BaseException(1052, th);
        }
    }

    public static void n(DownloadInfo downloadInfo, m mVar, an anVar) {
        boolean z;
        BaseException baseException;
        boolean z2;
        String str = n;
        com.byazt.fe.n.qg(str, "saveFileAsTargetName targetName is " + downloadInfo.getTargetFilePath());
        try {
            synchronized (q) {
                if (q.get(downloadInfo.getId()) == Boolean.TRUE) {
                    com.byazt.fe.n.qg(str, "has another same task is saving temp file");
                    if (anVar != null) {
                        List<an> arrayList = l.get(downloadInfo.getId());
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            l.put(downloadInfo.getId(), arrayList);
                        }
                        arrayList.add(anVar);
                    }
                    return;
                }
                com.byazt.fe.n.qg(str, "saveTempFileStatusMap put id:" + downloadInfo.getId());
                q.put(downloadInfo.getId(), Boolean.TRUE);
                File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
                File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                boolean zFs = fs(downloadInfo.getSavePath());
                if (file2.exists()) {
                    com.byazt.fe.n.qg(str, "targetFile exist");
                    int iN = n(file2, downloadInfo.getMd5());
                    if (n(iN)) {
                        com.byazt.fe.n.qg(str, "tempFile not exist , targetFile exists and md5 check valid");
                        downloadInfo.setTTMd5CheckStatus(iN);
                        if (anVar != null) {
                            anVar.n();
                        }
                        n(downloadInfo.getId(), true, (BaseException) null);
                    } else {
                        if (file.exists()) {
                            z = true;
                        } else {
                            BaseException baseException2 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName(), qg(iN)));
                            if (anVar != null) {
                                anVar.n(baseException2);
                            }
                            n(downloadInfo.getId(), false, baseException2);
                            z = false;
                        }
                        if (zFs && !file2.delete()) {
                            if (z) {
                                BaseException baseException3 = new BaseException(1037, "delete targetPath file existed with md5 check invalid status:" + qg(iN));
                                if (anVar != null) {
                                    anVar.n(baseException3);
                                }
                                n(downloadInfo.getId(), false, baseException3);
                            } else if (mVar != null) {
                                com.byazt.g.n.n(mVar, downloadInfo, new BaseException(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), downloadInfo.getStatus());
                            }
                        }
                    }
                    z = false;
                } else if (file.exists()) {
                    z = true;
                } else {
                    BaseException baseException4 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                    if (anVar != null) {
                        anVar.n(baseException4);
                    }
                    n(downloadInfo.getId(), false, baseException4);
                    z = false;
                }
                if (z) {
                    try {
                        int iN2 = com.byazt.f.n.n(downloadInfo.getId()).n("download_finish_check_ttmd5", 2);
                        if (iN2 > 0) {
                            int iN3 = n(file, downloadInfo.getMd5());
                            downloadInfo.setTTMd5CheckStatus(iN3);
                            if (iN2 >= 2 && !n(iN3)) {
                                BaseException baseException5 = new BaseException(1034, qg(iN3));
                                if (anVar != null) {
                                    anVar.n(baseException5);
                                }
                                n(downloadInfo.getId(), false, baseException5);
                                n(downloadInfo, zFs);
                                return;
                            }
                        }
                        z2 = !qg(file, file2);
                        baseException = null;
                    } catch (BaseException e) {
                        if (com.byazt.f.n.n(downloadInfo.getId()).n("fix_file_rename_failed")) {
                            baseException = e;
                            z2 = true;
                        } else {
                            baseException = e;
                            z2 = false;
                        }
                    }
                    if (z2) {
                        if (baseException == null) {
                            baseException = new BaseException(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                        }
                        if (anVar != null) {
                            anVar.n(baseException);
                        }
                        n(downloadInfo.getId(), false, baseException);
                        return;
                    }
                    if (anVar != null) {
                        anVar.n();
                    }
                    n(downloadInfo.getId(), true, (BaseException) null);
                }
            }
        } catch (Throwable th) {
            com.byazt.fe.n.qg(n, "saveFileAsTargetName throwable " + th.getMessage());
            if (anVar != null) {
                anVar.n(new BaseException(1038, qg(th, "saveFileAsTargetName")));
            }
        }
    }

    private static void n(int i, boolean z, BaseException baseException) {
        synchronized (q) {
            List<an> list = l.get(i);
            if (list != null) {
                for (an anVar : list) {
                    if (anVar != null) {
                        if (z) {
                            anVar.n();
                        } else {
                            anVar.n(baseException);
                        }
                    }
                }
            }
            com.byazt.fe.n.qg(n, "handleTempSaveCallback id:" + i);
            q.remove(i);
        }
    }

    public static void n(DownloadInfo downloadInfo, String str) throws BaseException {
        if (downloadInfo == null || TextUtils.isEmpty(str) || str.equals(downloadInfo.getName())) {
            return;
        }
        File file = new File(downloadInfo.getSavePath(), str);
        File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        k.qg(n, "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath());
        if (file2.exists() && !file2.canWrite()) {
            throw new BaseException(1001, "targetPath file exists but read-only");
        }
        if (!n(file, file2)) {
            throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.getSavePath(), str, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
    }

    public static boolean n(File file, File file2) throws BaseException {
        return n(file, file2, true);
    }

    public static boolean n(File file, File file2, boolean z) throws BaseException {
        if (file != null && file2 != null) {
            try {
                if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new BaseException(1053, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    k.qg(n, "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath());
                    if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    }
                    qg(file, file2, z);
                    return true;
                }
            } catch (BaseException e) {
                throw e;
            } catch (Throwable th) {
                n(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    private static void qg(File file, File file2, boolean z) throws IOException {
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel2 = fileOutputStream.getChannel();
                    try {
                        long size = channel.size();
                        long j = 0;
                        while (j < size) {
                            long j2 = size - j;
                            long jTransferFrom = channel2.transferFrom(channel, j, j2 > 31457280 ? 31457280L : j2);
                            if (jTransferFrom == 0) {
                                break;
                            } else {
                                j += jTransferFrom;
                            }
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        fileOutputStream.close();
                        if (channel != null) {
                            channel.close();
                        }
                        fileInputStream.close();
                        long length = file.length();
                        long length2 = file2.length();
                        if (length != length2) {
                            throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                        }
                        if (z) {
                            file2.setLastModified(file.lastModified());
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (channel2 == null) {
                                throw th2;
                            }
                            try {
                                channel2.close();
                                throw th2;
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                                throw th2;
                            }
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                if (channel == null) {
                                    throw th4;
                                }
                                try {
                                    channel.close();
                                    throw th4;
                                } catch (Throwable th5) {
                                    th.addSuppressed(th5);
                                    throw th4;
                                }
                            }
                        }
                    }
                } catch (Throwable th6) {
                    try {
                        throw th6;
                    } catch (Throwable th7) {
                        try {
                            fileOutputStream.close();
                            throw th7;
                        } catch (Throwable th8) {
                            th6.addSuppressed(th8);
                            throw th7;
                        }
                    }
                }
            } catch (Throwable th9) {
                throw th9;
            }
        } catch (Throwable th10) {
            try {
                throw th10;
            } catch (Throwable th11) {
                try {
                    fileInputStream.close();
                    throw th11;
                } catch (Throwable th12) {
                    th10.addSuppressed(th12);
                    throw th11;
                }
            }
        }
    }

    public static boolean qg(File file, File file2) throws BaseException {
        String str = n;
        k.qg(str, "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath());
        boolean zRenameTo = file.renameTo(file2);
        if (!zRenameTo) {
            zRenameTo = n(file, file2);
            try {
                k.qg(str, "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath());
                file.delete();
            } catch (Throwable unused) {
            }
        }
        return zRenameTo;
    }

    public static boolean q(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static boolean n(int i, String str) {
        if (n.n(16777216)) {
            return i == 206 || i == 1;
        }
        if (i >= 400) {
            return false;
        }
        return i == 206 || i == 1 || "bytes".equals(str);
    }

    public static boolean s(com.byazt.m.x xVar) {
        if (xVar == null) {
            return false;
        }
        if (n.n(8)) {
            return "chunked".equals(xVar.n("Transfer-Encoding")) || n(xVar) == -1;
        }
        return n(xVar) == -1;
    }

    public static List<com.byazt.wm.s> n(List<com.byazt.wm.s> list, String str, com.byazt.wm.qg qgVar) {
        return n(list, str, qgVar.oa(), qgVar.cy());
    }

    public static List<com.byazt.wm.s> n(List<com.byazt.wm.s> list, String str, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (com.byazt.wm.s sVar : list) {
                if (sVar != null) {
                    arrayList.add(sVar);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new com.byazt.wm.s("If-Match", str));
        }
        arrayList.add(new com.byazt.wm.s("Accept-Encoding", "identity"));
        String str2 = j2 <= 0 ? String.format("bytes=%s-", String.valueOf(j)) : String.format("bytes=%s-%s", String.valueOf(j), String.valueOf(j2));
        arrayList.add(new com.byazt.wm.s("Range", str2));
        com.byazt.fe.n.qg(n, " range CurrentOffset:" + j + " EndOffset:" + j2 + ", range = " + str2);
        return arrayList;
    }

    public static boolean n(int i, String str, String str2) {
        return i == -3 && !q(str, str2);
    }

    public static ConnectivityManager n(Context context) {
        ConnectivityManager connectivityManager = rv;
        if (connectivityManager != null) {
            return connectivityManager;
        }
        ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
        rv = connectivityManager2;
        return connectivityManager2;
    }

    public static boolean qg(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerN = n(context);
            return connectivityManagerN != null && (activeNetworkInfo = connectivityManagerN.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable() && 1 == activeNetworkInfo.getType();
        } catch (Exception unused) {
        }
    }

    public static boolean s(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerN = n(context);
            if (connectivityManagerN == null || (activeNetworkInfo = connectivityManagerN.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String l(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance(com.anythink.core.common.u.n.a);
                    messageDigest.update(str.getBytes("UTF-8"));
                    return n(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String q(Context context) {
        String str = s;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String strTj = tj();
        s = strTj;
        if (!TextUtils.isEmpty(strTj)) {
            return s;
        }
        String strCp = cp();
        s = strCp;
        if (!TextUtils.isEmpty(strCp)) {
            return s;
        }
        String strL = l(context);
        s = strL;
        if (!TextUtils.isEmpty(strL)) {
            return s;
        }
        String strRv = rv();
        s = strRv;
        return strRv;
    }

    private static String rv() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i = bufferedReader.read();
                    if (i <= 0) {
                        break;
                    }
                    sb.append((char) i);
                }
                if (com.byazt.fe.n.n()) {
                    com.byazt.fe.n.qg("Process", "get processName = " + sb.toString());
                }
                String string = sb.toString();
                n(bufferedReader);
                return string;
            } catch (Throwable unused) {
                n(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    private static String tj() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            String processName = Application.getProcessName();
            if (!TextUtils.isEmpty(processName) && com.byazt.fe.n.n()) {
                com.byazt.fe.n.qg("Process", "processName = " + processName);
            }
            return processName;
        } catch (Exception unused) {
            return null;
        }
    }

    private static String cp() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (!(objInvoke instanceof String)) {
                return null;
            }
            String str = (String) objInvoke;
            try {
                if (!TextUtils.isEmpty(str) && com.byazt.fe.n.n()) {
                    com.byazt.fe.n.qg("Process", "processName = " + str);
                }
            } catch (Throwable unused) {
            }
            return str;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static String l(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        if (com.byazt.fe.n.n()) {
                            com.byazt.fe.n.qg("Process", "processName = " + runningAppProcessInfo.processName);
                        }
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static boolean n() {
        Boolean bool = tj;
        if (bool != null) {
            return bool.booleanValue();
        }
        String strQ = q(com.byazt.xv.s.u());
        Boolean boolValueOf = Boolean.valueOf((strQ == null || !strQ.contains(":")) && strQ != null && strQ.equals(com.byazt.xv.s.u().getPackageName()));
        tj = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public static boolean qg() {
        return !s() && com.byazt.xv.s.s() && d.n(true).x();
    }

    public static boolean s() {
        Boolean bool = cp;
        if (bool != null) {
            return bool.booleanValue();
        }
        String strQ = q(com.byazt.xv.s.u());
        if (strQ != null && strQ.equals(com.byazt.xv.s.u().getPackageName() + ":downloader")) {
            cp = Boolean.TRUE;
        } else {
            cp = Boolean.FALSE;
        }
        return cp.booleanValue();
    }

    public static boolean w(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String strQ = q(com.byazt.xv.s.u());
        return strQ != null && strQ.equals(str);
    }

    public static boolean q() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static String x(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static boolean n(Throwable th) {
        if (th == null) {
            return false;
        }
        String strTj = tj(th);
        if (th instanceof SocketTimeoutException) {
            return true;
        }
        return !TextUtils.isEmpty(strTj) && (strTj.contains("time out") || strTj.contains("Time-out"));
    }

    public static boolean qg(Throwable th) {
        com.byazt.qx.qg qgVar;
        if (th == null) {
            return false;
        }
        String strTj = tj(th);
        if (!(th instanceof com.byazt.qx.qg) || (((qgVar = (com.byazt.qx.qg) th) == null || qgVar.n() != 403) && (TextUtils.isEmpty(strTj) || !strTj.contains("403")))) {
            return !TextUtils.isEmpty(strTj) && strTj.contains("Forbidden");
        }
        return true;
    }

    public static boolean s(Throwable th) {
        if (th == null) {
            return false;
        }
        String strTj = tj(th);
        return !TextUtils.isEmpty(strTj) && strTj.contains("network not available");
    }

    public static boolean q(Throwable th) {
        if (th == null) {
            return false;
        }
        String strTj = tj(th);
        return !TextUtils.isEmpty(strTj) && strTj.contains("Exception in connect");
    }

    public static boolean l(Throwable th) {
        if (th == null) {
            return false;
        }
        String strTj = tj(th);
        return !TextUtils.isEmpty(strTj) && strTj.contains("Precondition Failed");
    }

    public static boolean w(Throwable th) {
        if (th == null) {
            return false;
        }
        String strTj = tj(th);
        return !TextUtils.isEmpty(strTj) && strTj.contains("Requested Range Not Satisfiable");
    }

    public static boolean x(Throwable th) {
        return com.byazt.xv.s.dg().n(th);
    }

    public static boolean n(BaseException baseException) {
        return baseException != null && baseException.getErrorCode() == 1051;
    }

    public static boolean qg(BaseException baseException) {
        if (!(baseException instanceof com.byazt.qx.qg)) {
            return false;
        }
        com.byazt.qx.qg qgVar = (com.byazt.qx.qg) baseException;
        return qgVar.n() == 412 || qgVar.n() == 416;
    }

    public static boolean s(BaseException baseException) {
        if (baseException == null) {
            return false;
        }
        if (baseException.getErrorCode() != 1011) {
            return baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException);
        }
        return true;
    }

    public static void n(Throwable th, String str) throws BaseException {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (th instanceof BaseException) {
            BaseException baseException = (BaseException) th;
            baseException.setErrorMsg(str2 + "-" + baseException.getErrorMessage());
            throw baseException;
        }
        if (th instanceof SSLHandshakeException) {
            throw new BaseException(1011, qg(th, str2));
        }
        if (n(th)) {
            throw new BaseException(1048, qg(th, str2));
        }
        if (l(th)) {
            throw new com.byazt.qx.qg(1004, TTAdConstant.IMAGE_URL_CODE, qg(th, str2));
        }
        if (w(th)) {
            throw new com.byazt.qx.qg(1004, TTAdConstant.LIVE_AD_CODE, qg(th, str2));
        }
        if (qg(th)) {
            throw new BaseException(1047, qg(th, str2));
        }
        if (s(th)) {
            throw new BaseException(1049, qg(th, str2));
        }
        if (q(th)) {
            throw new BaseException(1041, qg(th, str2));
        }
        if (th instanceof IOException) {
            s(th, str);
            n((IOException) th, str);
            return;
        }
        throw new BaseException(1000, qg(th, str2));
    }

    private static void s(Throwable th, String str) throws com.byazt.qx.x {
        com.byazt.qx.x xVarN = com.byazt.xv.s.dg().n(th, null);
        if (xVarN == null) {
            xVarN = com.byazt.xv.s.dg().n(th.getCause(), null);
        }
        if (xVarN == null) {
            return;
        }
        throw new com.byazt.qx.x(xVarN.getErrorCode(), qg(xVarN, str)).n(xVarN.n());
    }

    public static void n(IOException iOException, String str) throws BaseException {
        if (str == null) {
            str = "";
        }
        String strQg = qg(iOException, str);
        if (iOException instanceof ConnectException) {
            throw new BaseException(1041, strQg);
        }
        if (iOException instanceof UnknownHostException) {
            throw new BaseException(1055, strQg);
        }
        if (iOException instanceof NoRouteToHostException) {
            throw new BaseException(1056, strQg);
        }
        if (iOException instanceof UnknownServiceException) {
            throw new BaseException(1057, strQg);
        }
        if (iOException instanceof PortUnreachableException) {
            throw new BaseException(1058, strQg);
        }
        if (iOException instanceof SocketTimeoutException) {
            throw new BaseException(1048, strQg);
        }
        if (iOException instanceof SocketException) {
            throw new BaseException(1059, strQg);
        }
        if (iOException instanceof HttpRetryException) {
            throw new BaseException(1060, strQg);
        }
        if (iOException instanceof ProtocolException) {
            throw new BaseException(1061, strQg);
        }
        if (iOException instanceof MalformedURLException) {
            throw new BaseException(1062, strQg);
        }
        if (iOException instanceof FileNotFoundException) {
            throw new BaseException(1063, strQg);
        }
        if (iOException instanceof InterruptedIOException) {
            throw new BaseException(1064, strQg);
        }
        if (iOException instanceof UnsupportedEncodingException) {
            throw new BaseException(1065, strQg);
        }
        if (iOException instanceof EOFException) {
            throw new BaseException(1066, strQg);
        }
        if (iOException instanceof StreamResetException) {
            throw new BaseException(1067, strQg);
        }
        if (iOException instanceof SSLException) {
            throw new BaseException(1011, strQg);
        }
        if (fs(iOException)) {
            throw new BaseException(1006, strQg);
        }
        throw new BaseException(1023, strQg);
    }

    public static boolean fs(Throwable th) {
        if (th == null) {
            return false;
        }
        if (th instanceof BaseException) {
            BaseException baseException = (BaseException) th;
            int errorCode = baseException.getErrorCode();
            if (errorCode == 1006) {
                return true;
            }
            if (errorCode == 1023 || errorCode == 1039 || errorCode == 1040 || errorCode == 1054 || errorCode == 1064) {
                String message = baseException.getMessage();
                return !TextUtils.isEmpty(message) && message.contains("ENOSPC");
            }
        } else if (th instanceof IOException) {
            String strTj = tj(th);
            if (!TextUtils.isEmpty(strTj) && strTj.contains("ENOSPC")) {
                return true;
            }
        }
        return false;
    }

    public static boolean rv(Throwable th) {
        if (!(th instanceof BaseException)) {
            return false;
        }
        int errorCode = ((BaseException) th).getErrorCode();
        return errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
    }

    public static boolean n(BaseException baseException, DownloadInfo downloadInfo) {
        if (baseException == null) {
            return false;
        }
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
            return true;
        }
        return (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.getCurBytes() >= c.x) ? false : true;
    }

    public static String qg(Throwable th, String str) {
        if (str == null) {
            return tj(th);
        }
        return str + "-" + tj(th);
    }

    public static String tj(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (Throwable unused) {
            return "throwable getMsg error";
        }
    }

    public static com.byazt.sk.w l(int i) {
        com.byazt.sk.w wVar = com.byazt.sk.w.MAIN;
        if (i == com.byazt.sk.w.SUB.ordinal()) {
            return com.byazt.sk.w.SUB;
        }
        return i == com.byazt.sk.w.NOTIFICATION.ordinal() ? com.byazt.sk.w.NOTIFICATION : wVar;
    }

    public static <K> HashMap<Integer, K> n(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> map = new HashMap<>();
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = sparseArray.keyAt(i);
            map.put(Integer.valueOf(iKeyAt), sparseArray.valueAt(i));
        }
        return map;
    }

    public static <K> void n(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static long l(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -1L;
        }
        List<com.byazt.wm.qg> listS = com.byazt.xv.s.hu().s(downloadInfo.getId());
        if (downloadInfo.getChunkCount() == 1) {
            return downloadInfo.getCurBytes();
        }
        if (listS != null && listS.size() > 1) {
            long jQ = q(listS);
            if (jQ >= 0) {
                return jQ;
            }
        }
        return 0L;
    }

    private static long q(List<com.byazt.wm.qg> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long jSz = -1;
        for (com.byazt.wm.qg qgVar : list) {
            if (qgVar != null && (qgVar.sz() <= qgVar.cy() || qgVar.cy() == 0)) {
                if (jSz == -1 || jSz > qgVar.sz()) {
                    jSz = qgVar.sz();
                }
            }
        }
        return jSz;
    }

    public static long w(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0L;
        }
        List<com.byazt.wm.qg> listS = com.byazt.xv.s.hu().s(downloadInfo.getId());
        int chunkCount = downloadInfo.getChunkCount();
        boolean z = chunkCount > 1;
        if (!downloadInfo.isBreakpointAvailable()) {
            return 0L;
        }
        if (z) {
            if (listS == null || chunkCount != listS.size()) {
                return 0L;
            }
            return qg(listS);
        }
        return downloadInfo.getCurBytes();
    }

    public static boolean n(List<com.byazt.wm.s> list, List<com.byazt.wm.s> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static void n(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void n(Cursor... cursorArr) {
        if (cursorArr == null) {
            return;
        }
        for (Cursor cursor : cursorArr) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static String n(String str, int i) {
        if (i == 0) {
            return "";
        }
        return (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public static String n(String str, com.byazt.f.n nVar) {
        JSONObject jSONObjectQ;
        String str2;
        if (nVar == null || (jSONObjectQ = nVar.q("download_dir")) == null) {
            return "";
        }
        String strOptString = jSONObjectQ.optString("dir_name");
        if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("/")) {
            strOptString = strOptString.substring(1);
        }
        if (TextUtils.isEmpty(strOptString)) {
            return strOptString;
        }
        if (!strOptString.contains("%s")) {
            str2 = strOptString + str;
        } else {
            try {
                str2 = String.format(strOptString, str);
            } catch (Throwable unused) {
            }
        }
        strOptString = str2;
        return strOptString.length() > 255 ? strOptString.substring(strOptString.length() - 255) : strOptString;
    }

    public static String l() {
        return n(Downloader.getInstance(com.byazt.xv.s.u()).getGlobalSaveDir(), true);
    }

    public static String w() {
        return n(Downloader.getInstance(com.byazt.xv.s.u()).getGlobalSaveTempDir(), false);
    }

    private static String n(File file, boolean z) {
        Context contextU = com.byazt.xv.s.u();
        if (n(file)) {
            return file.getAbsolutePath();
        }
        int i = contextU.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
            if (com.byazt.f.n.s().qg("fix_save_external_dir") <= 0) {
                File fileN = com.byazt.qyu.qg.n(contextU, Environment.DIRECTORY_DOWNLOADS);
                if (n(fileN)) {
                    return fileN.getAbsolutePath();
                }
            }
        } else {
            if (z) {
                File fileX = x();
                if (n(fileX)) {
                    return fileX.getAbsolutePath();
                }
            }
            if (com.byazt.f.n.s().qg("fix_save_external_dir") <= 0) {
                File fileN2 = com.byazt.qyu.qg.n(contextU, Environment.DIRECTORY_DOWNLOADS);
                if (n(fileN2)) {
                    return fileN2.getAbsolutePath();
                }
            }
        }
        return com.byazt.qyu.qg.n(contextU).getAbsolutePath();
    }

    public static boolean fs(String str) {
        Context contextU;
        return com.byazt.f.n.s().qg("save_path_security") <= 0 || (contextU = com.byazt.xv.s.u()) == null || TextUtils.isEmpty(str) || str.startsWith("/data") || str.contains(new StringBuilder("Android/data/").append(contextU.getPackageName()).toString());
    }

    public static boolean n(File file) {
        if (file == null) {
            return false;
        }
        try {
            return (file.exists() || file.mkdirs()) && file.isDirectory();
        } catch (Exception unused) {
            return false;
        }
    }

    public static File x() {
        String externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (Exception unused) {
            externalStorageState = "";
        }
        if ("mounted".equals(externalStorageState)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return null;
    }

    public static void n(List<com.byazt.wm.s> list, DownloadInfo downloadInfo) {
        long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
        if (throttleNetSpeed > 0) {
            list.add(new com.byazt.wm.s("extra_throttle_net_speed", String.valueOf(throttleNetSpeed)));
        }
    }

    public static void qg(List<com.byazt.wm.s> list, DownloadInfo downloadInfo) {
        long ttnetProtectTimeout = downloadInfo.getTtnetProtectTimeout();
        if (ttnetProtectTimeout > 300) {
            list.add(new com.byazt.wm.s("extra_ttnet_protect_timeout", String.valueOf(ttnetProtectTimeout)));
        }
    }

    public static long s(long j) {
        return System.currentTimeMillis() - j;
    }

    public static String qg(com.byazt.m.x xVar, String str) {
        if (xVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String strN = xVar.n(str);
        if (!com.byazt.f.n.s().qg("fix_get_http_resp_head_ignore_case", true)) {
            return strN;
        }
        if (TextUtils.isEmpty(strN)) {
            strN = xVar.n(str.toLowerCase());
        }
        return TextUtils.isEmpty(strN) ? xVar.n(str.toUpperCase()) : strN;
    }

    public static int n(Object obj, int i) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return i;
        }
    }

    public static String n(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }

    public static boolean n(Object obj, boolean z) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return z;
        }
    }

    public static boolean qg(BaseException baseException, DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.isOnlyWifi() && s(com.byazt.xv.s.u());
    }

    public static boolean fs() {
        Context contextU = com.byazt.xv.s.u();
        return (contextU == null || qg(contextU) || !s(contextU)) ? false : true;
    }

    public static long rv(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
            if (matcher.find()) {
                return Long.parseLong(matcher.group(1));
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String l(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strL = l(str2);
        return (TextUtils.isEmpty(strL) || str.contains(strL)) ? str : new File(str, strL).getAbsolutePath();
    }

    public static boolean s(List<com.byazt.wm.s> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.byazt.wm.s sVar : list) {
            if (sVar != null && !TextUtils.isEmpty(sVar.n()) && !TextUtils.isEmpty(sVar.qg()) && "download-tc21-1-15".equals(sVar.n()) && "download-tc21-1-15".equals(sVar.qg())) {
                return true;
            }
        }
        return false;
    }
}
