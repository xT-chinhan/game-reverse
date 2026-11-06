package com.ss.android.socialbase.downloader.ny;

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
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.jw;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.sl;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.taptap.sdk.compliance.constants.ComplianceMessage;
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

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static Boolean ch = null;
    private static Boolean hi = null;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4788ms = "c";
    private static ConnectivityManager ny;
    private static final Pattern xr = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    private static String ah = null;
    private static volatile SparseArray<Boolean> d = new SparseArray<>();
    private static volatile SparseArray<List<jw>> ka = new SparseArray<>();
    private static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static Pattern ab = null;
    private static Pattern x = null;

    public static boolean ah(int i) {
        return i == 200 || i == 201 || i == 0;
    }

    public static boolean d(int i) {
        return i == 206 || i == 200;
    }

    public static double ms(long j) {
        return j / 1048576.0d;
    }

    public static boolean ms(int i) {
        return i == 0 || i == 2;
    }

    public static boolean xr(long j) {
        return j == -1;
    }

    public static String ms(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        return ms(bArr, 0, bArr.length);
    }

    public static String ms(byte[] bArr, int i, int i2) {
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
            char[] cArr2 = c;
            cArr[i4] = cArr2[i6 >> 4];
            i4 = i7 + 1;
            cArr[i7] = cArr2[i6 & 15];
        }
        return new String(cArr, 0, i3);
    }

    public static String ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            try {
                bArr[i] = (byte) (Integer.parseInt(str.substring(i2, i2 + 2), 16) & 255);
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Exception e2) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e2);
            return str;
        }
    }

    public static long ms(com.ss.android.socialbase.downloader.network.ab abVar) {
        if (abVar == null) {
            return -1L;
        }
        String strXr = xr(abVar, "Content-Length");
        if (TextUtils.isEmpty(strXr) && ms.ms(1)) {
            return xr(abVar);
        }
        try {
            return Long.parseLong(strXr);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static long xr(com.ss.android.socialbase.downloader.network.ab abVar) {
        if (abVar == null) {
            return -1L;
        }
        String strXr = xr(abVar, "Content-Range");
        if (TextUtils.isEmpty(strXr)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(strXr);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e) {
            com.ss.android.socialbase.downloader.ah.ms.d(f4788ms, "parse content-length from content-range failed " + e);
        }
        return -1L;
    }

    public static long xr(String str) {
        if (str == null) {
            return -1L;
        }
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length >= 2) {
            try {
                return Long.parseLong(strArrSplit[1]);
            } catch (NumberFormatException unused) {
                com.ss.android.socialbase.downloader.ah.ms.d(f4788ms, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    private static String ch(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (ab == null) {
                ab = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            Matcher matcher = ab.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            if (x == null) {
                x = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
            }
            Matcher matcher2 = x.matcher(str);
            if (matcher2.find()) {
                return matcher2.group(1);
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public static String ms(com.ss.android.socialbase.downloader.network.ab abVar, String str) {
        String strCh = ch(abVar.ms("Content-Disposition"));
        return TextUtils.isEmpty(strCh) ? ka(str) : strCh;
    }

    public static com.ss.android.socialbase.downloader.model.ka ms(DownloadInfo downloadInfo, String str, String str2, int i) throws BaseException {
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
                            if (com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo).ms("opt_mkdir_failed", 0) != 1) {
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
                                if (d(downloadInfo.getSavePath()) < 16384) {
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
        return new com.ss.android.socialbase.downloader.model.ka(file, i);
    }

    public static List<com.ss.android.socialbase.downloader.model.xr> ms(List<com.ss.android.socialbase.downloader.model.xr> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (com.ss.android.socialbase.downloader.model.xr xrVar : list) {
            if (xrVar != null) {
                if (xrVar.d()) {
                    sparseArray.put(xrVar.y(), xrVar);
                    List<com.ss.android.socialbase.downloader.model.xr> list2 = (List) sparseArray2.get(xrVar.y());
                    if (list2 != null) {
                        Iterator<com.ss.android.socialbase.downloader.model.xr> it = list2.iterator();
                        while (it.hasNext()) {
                            it.next().ms(xrVar);
                        }
                        xrVar.ms(list2);
                    }
                } else {
                    com.ss.android.socialbase.downloader.model.xr xrVar2 = (com.ss.android.socialbase.downloader.model.xr) sparseArray.get(xrVar.xr());
                    if (xrVar2 != null) {
                        List<com.ss.android.socialbase.downloader.model.xr> listAb = xrVar2.ab();
                        if (listAb == null) {
                            listAb = new ArrayList<>();
                            xrVar2.ms(listAb);
                        }
                        xrVar.ms(xrVar2);
                        listAb.add(xrVar);
                    } else {
                        List arrayList = (List) sparseArray2.get(xrVar.xr());
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            sparseArray2.put(xrVar.xr(), arrayList);
                        }
                        arrayList.add(xrVar);
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

    public static String ms(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    public static String ms(String str, String str2, String str3) {
        String strMs;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            strMs = ms(str2, str3);
        } else {
            strMs = ms(str, str3);
        }
        if (TextUtils.isEmpty(strMs)) {
            return null;
        }
        return String.format("%s.tp", strMs);
    }

    public static String xr(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public static String ah(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    public static long xr(List<com.ss.android.socialbase.downloader.model.xr> list) {
        Iterator<com.ss.android.socialbase.downloader.model.xr> it = list.iterator();
        long jUb = 0;
        while (it.hasNext()) {
            jUb += it.next().ub();
        }
        return jUb;
    }

    public static void ms(DownloadInfo downloadInfo) {
        ms(downloadInfo, true);
    }

    public static void ms(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (z) {
            try {
                ah(downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
                return;
            }
        }
        ah(downloadInfo.getTempPath(), downloadInfo.getTempName());
        if (downloadInfo.isSavePathRedirected()) {
            xr(downloadInfo);
        }
        if (z) {
            String strKa = ka(downloadInfo.getUrl());
            if (TextUtils.isEmpty(strKa) || TextUtils.isEmpty(downloadInfo.getSavePath()) || !downloadInfo.getSavePath().contains(strKa)) {
                return;
            }
            hi(downloadInfo.getSavePath());
        }
    }

    public static void xr(DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.ab.ms msVarMs;
        JSONObject jSONObjectD;
        if (downloadInfo == null || (jSONObjectD = (msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId())).d("download_dir")) == null) {
            return;
        }
        String strOptString = jSONObjectD.optString("ins_desc");
        if (!TextUtils.isEmpty(strOptString)) {
            ah(downloadInfo.getSavePath(), strOptString);
        }
        String title = downloadInfo.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = downloadInfo.getName();
        }
        String strMs = ms(title, msVarMs);
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(strMs) || TextUtils.isEmpty(savePath)) {
            return;
        }
        File file = new File(strMs);
        for (File file2 = new File(savePath); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            hi(file2.getPath());
            file = file.getParentFile();
        }
    }

    private static boolean hi(String str) {
        String str2 = f4788ms;
        com.bytedance.sdk.openadsdk.api.ab.d(str2, "deleteDirIfEmpty on thread: " + Thread.currentThread());
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.isDirectory()) {
                if (file.delete()) {
                    return true;
                }
                com.bytedance.sdk.openadsdk.api.ab.d(str2, "deleteDirIfEmpty return false");
                return false;
            }
        }
        return false;
    }

    public static void ah(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            com.bytedance.sdk.openadsdk.api.ab.ka(f4788ms, "deleteFile: " + str + "/" + str2);
            file.delete();
        }
    }

    public static boolean ms(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static boolean ah(DownloadInfo downloadInfo) {
        return ms(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5());
    }

    public static boolean ms(DownloadInfo downloadInfo, boolean z, String str) {
        if (!z && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            try {
                if (new File(downloadInfo.getSavePath(), downloadInfo.getName()).exists() && ah(downloadInfo.getSavePath(), downloadInfo.getName(), str)) {
                    return true;
                }
            } catch (OutOfMemoryError e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
        }
        return false;
    }

    public static boolean d(DownloadInfo downloadInfo) {
        boolean z = false;
        if (!downloadInfo.isDeleteCacheIfCheckFailed() && TextUtils.isEmpty(downloadInfo.getLastModified())) {
            com.ss.android.socialbase.downloader.ah.ms.xr(f4788ms, "dcache::last modify is emtpy, so just return cache");
        } else {
            com.ss.android.socialbase.downloader.ah.ms.xr(f4788ms, "dcache::curt=" + System.currentTimeMillis() + " expired=" + downloadInfo.getCacheExpiredTime());
            if (System.currentTimeMillis() > downloadInfo.getCacheExpiredTime()) {
                z = true;
            }
        }
        com.ss.android.socialbase.downloader.ah.ms.xr(f4788ms, "cacheExpired::dcache::name=" + downloadInfo.getName() + " expired=" + z);
        return z;
    }

    public static int xr(String str, String str2, String str3) {
        return com.ss.android.ms.ah.ms(str3, new File(str, str2));
    }

    public static boolean ah(String str, String str2, String str3) {
        return ms(xr(str, str2, str3));
    }

    public static int ms(File file, String str) {
        return com.ss.android.ms.ah.ms(str, file);
    }

    public static String xr(int i) {
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

    public static long d(String str) throws BaseException {
        try {
            return new StatFs(str).getAvailableBytes();
        } catch (IllegalArgumentException e) {
            throw new BaseException(ComplianceMessage.DURATION_LIMIT, e);
        } catch (Throwable th) {
            throw new BaseException(1052, th);
        }
    }

    public static void ms(DownloadInfo downloadInfo, i iVar, jw jwVar) {
        boolean z;
        BaseException baseException;
        boolean z2;
        String str = f4788ms;
        com.ss.android.socialbase.downloader.ah.ms.xr(str, "saveFileAsTargetName targetName is " + downloadInfo.getTargetFilePath());
        try {
            synchronized (d) {
                if (d.get(downloadInfo.getId()) == Boolean.TRUE) {
                    com.ss.android.socialbase.downloader.ah.ms.xr(str, "has another same task is saving temp file");
                    if (jwVar != null) {
                        List<jw> arrayList = ka.get(downloadInfo.getId());
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            ka.put(downloadInfo.getId(), arrayList);
                        }
                        arrayList.add(jwVar);
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.ah.ms.xr(str, "saveTempFileStatusMap put id:" + downloadInfo.getId());
                d.put(downloadInfo.getId(), Boolean.TRUE);
                File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
                File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                boolean zX = x(downloadInfo.getSavePath());
                if (file2.exists()) {
                    com.ss.android.socialbase.downloader.ah.ms.xr(str, "targetFile exist");
                    int iMs = ms(file2, downloadInfo.getMd5());
                    if (ms(iMs)) {
                        com.ss.android.socialbase.downloader.ah.ms.xr(str, "tempFile not exist , targetFile exists and md5 check valid");
                        downloadInfo.setTTMd5CheckStatus(iMs);
                        if (jwVar != null) {
                            jwVar.ms();
                        }
                        ms(downloadInfo.getId(), true, (BaseException) null);
                    } else {
                        if (file.exists()) {
                            z = true;
                        } else {
                            BaseException baseException2 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName(), xr(iMs)));
                            if (jwVar != null) {
                                jwVar.ms(baseException2);
                            }
                            ms(downloadInfo.getId(), false, baseException2);
                            z = false;
                        }
                        if (zX && !file2.delete()) {
                            if (z) {
                                BaseException baseException3 = new BaseException(1037, "delete targetPath file existed with md5 check invalid status:" + xr(iMs));
                                if (jwVar != null) {
                                    jwVar.ms(baseException3);
                                }
                                ms(downloadInfo.getId(), false, baseException3);
                            } else if (iVar != null) {
                                com.ss.android.socialbase.downloader.d.ms.ms(iVar, downloadInfo, new BaseException(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), downloadInfo.getStatus());
                            }
                        }
                    }
                    z = false;
                } else if (file.exists()) {
                    z = true;
                } else {
                    BaseException baseException4 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                    if (jwVar != null) {
                        jwVar.ms(baseException4);
                    }
                    ms(downloadInfo.getId(), false, baseException4);
                    z = false;
                }
                if (z) {
                    try {
                        int iMs2 = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("download_finish_check_ttmd5", 2);
                        if (iMs2 > 0) {
                            int iMs3 = ms(file, downloadInfo.getMd5());
                            downloadInfo.setTTMd5CheckStatus(iMs3);
                            if (iMs2 >= 2 && !ms(iMs3)) {
                                BaseException baseException5 = new BaseException(1034, xr(iMs3));
                                if (jwVar != null) {
                                    jwVar.ms(baseException5);
                                }
                                ms(downloadInfo.getId(), false, baseException5);
                                ms(downloadInfo, zX);
                                return;
                            }
                        }
                        z2 = !xr(file, file2);
                        baseException = null;
                    } catch (BaseException e) {
                        if (com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("fix_file_rename_failed")) {
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
                        if (jwVar != null) {
                            jwVar.ms(baseException);
                        }
                        ms(downloadInfo.getId(), false, baseException);
                        return;
                    }
                    if (jwVar != null) {
                        jwVar.ms();
                    }
                    ms(downloadInfo.getId(), true, (BaseException) null);
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.ah.ms.xr(f4788ms, "saveFileAsTargetName throwable " + th.getMessage());
            if (jwVar != null) {
                jwVar.ms(new BaseException(1038, xr(th, "saveFileAsTargetName")));
            }
        }
    }

    private static void ms(int i, boolean z, BaseException baseException) {
        synchronized (d) {
            List<jw> list = ka.get(i);
            if (list != null) {
                for (jw jwVar : list) {
                    if (jwVar != null) {
                        if (z) {
                            jwVar.ms();
                        } else {
                            jwVar.ms(baseException);
                        }
                    }
                }
            }
            com.ss.android.socialbase.downloader.ah.ms.xr(f4788ms, "handleTempSaveCallback id:" + i);
            d.remove(i);
        }
    }

    public static void ms(DownloadInfo downloadInfo, String str) throws BaseException {
        if (downloadInfo == null || TextUtils.isEmpty(str) || str.equals(downloadInfo.getName())) {
            return;
        }
        File file = new File(downloadInfo.getSavePath(), str);
        File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        com.bytedance.sdk.openadsdk.api.ab.ka(f4788ms, "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath());
        if (file2.exists() && !file2.canWrite()) {
            throw new BaseException(1001, "targetPath file exists but read-only");
        }
        if (!ms(file, file2)) {
            throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.getSavePath(), str, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
    }

    public static boolean ms(File file, File file2) throws BaseException {
        return ms(file, file2, true);
    }

    public static boolean ms(File file, File file2, boolean z) throws BaseException {
        if (file != null && file2 != null) {
            try {
                if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new BaseException(1053, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    com.bytedance.sdk.openadsdk.api.ab.ka(f4788ms, "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath());
                    if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    }
                    xr(file, file2, z);
                    return true;
                }
            } catch (BaseException e) {
                throw e;
            } catch (Throwable th) {
                ms(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    private static void xr(File file, File file2, boolean z) throws IOException {
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

    public static boolean xr(File file, File file2) throws BaseException {
        String str = f4788ms;
        com.bytedance.sdk.openadsdk.api.ab.ka(str, "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath());
        boolean zRenameTo = file.renameTo(file2);
        if (!zRenameTo) {
            zRenameTo = ms(file, file2);
            try {
                com.bytedance.sdk.openadsdk.api.ab.ka(str, "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath());
                file.delete();
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
            }
        }
        return zRenameTo;
    }

    public static boolean d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static boolean ms(int i, String str) {
        if (ms.ms(16777216)) {
            return i == 206 || i == 1;
        }
        if (i >= 400) {
            return false;
        }
        return i == 206 || i == 1 || "bytes".equals(str);
    }

    public static boolean ah(com.ss.android.socialbase.downloader.network.ab abVar) {
        if (abVar == null) {
            return false;
        }
        if (ms.ms(8)) {
            return "chunked".equals(abVar.ms("Transfer-Encoding")) || ms(abVar) == -1;
        }
        return ms(abVar) == -1;
    }

    public static List<com.ss.android.socialbase.downloader.model.ah> ms(List<com.ss.android.socialbase.downloader.model.ah> list, String str, com.ss.android.socialbase.downloader.model.xr xrVar) {
        return ms(list, str, xrVar.zb(), xrVar.ao());
    }

    public static List<com.ss.android.socialbase.downloader.model.ah> ms(List<com.ss.android.socialbase.downloader.model.ah> list, String str, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.ah ahVar : list) {
                if (ahVar != null) {
                    arrayList.add(ahVar);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.ah("If-Match", str));
        }
        arrayList.add(new com.ss.android.socialbase.downloader.model.ah("Accept-Encoding", "identity"));
        String str2 = j2 <= 0 ? String.format("bytes=%s-", String.valueOf(j)) : String.format("bytes=%s-%s", String.valueOf(j), String.valueOf(j2));
        arrayList.add(new com.ss.android.socialbase.downloader.model.ah("Range", str2));
        com.ss.android.socialbase.downloader.ah.ms.xr(f4788ms, " range CurrentOffset:" + j + " EndOffset:" + j2 + ", range = " + str2);
        return arrayList;
    }

    public static boolean ms(int i, String str, String str2) {
        return i == -3 && !d(str, str2);
    }

    public static ConnectivityManager ms(Context context) {
        ConnectivityManager connectivityManager = ny;
        if (connectivityManager != null) {
            return connectivityManager;
        }
        ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
        ny = connectivityManager2;
        return connectivityManager2;
    }

    public static boolean xr(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerMs = ms(context);
            return connectivityManagerMs != null && (activeNetworkInfo = connectivityManagerMs.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable() && 1 == activeNetworkInfo.getType();
        } catch (Exception unused) {
        }
    }

    public static boolean ah(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerMs = ms(context);
            if (connectivityManagerMs == null || (activeNetworkInfo = connectivityManagerMs.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String ka(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return ms(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String d(Context context) {
        String str = ah;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String strCh = ch();
        ah = strCh;
        if (!TextUtils.isEmpty(strCh)) {
            return ah;
        }
        String strHi = hi();
        ah = strHi;
        if (!TextUtils.isEmpty(strHi)) {
            return ah;
        }
        String strKa = ka(context);
        ah = strKa;
        if (!TextUtils.isEmpty(strKa)) {
            return ah;
        }
        String strNy = ny();
        ah = strNy;
        return strNy;
    }

    private static String ny() {
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
                if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
                    com.ss.android.socialbase.downloader.ah.ms.xr("Process", "get processName = " + sb.toString());
                }
                String string = sb.toString();
                ms(bufferedReader);
                return string;
            } catch (Throwable unused) {
                ms(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    private static String ch() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            String processName = Application.getProcessName();
            if (!TextUtils.isEmpty(processName) && com.ss.android.socialbase.downloader.ah.ms.ms()) {
                com.ss.android.socialbase.downloader.ah.ms.xr("Process", "processName = " + processName);
            }
            return processName;
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    private static String hi() {
        String str;
        Throwable th;
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (!(objInvoke instanceof String)) {
                return null;
            }
            str = (String) objInvoke;
            try {
                if (!TextUtils.isEmpty(str) && com.ss.android.socialbase.downloader.ah.ms.ms()) {
                    com.ss.android.socialbase.downloader.ah.ms.xr("Process", "processName = " + str);
                }
            } catch (Throwable th2) {
                th = th2;
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
            }
            return str;
        } catch (Throwable th3) {
            str = null;
            th = th3;
        }
        com.bytedance.sdk.openadsdk.api.ab.ms(th);
        return str;
    }

    private static String ka(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
                            com.ss.android.socialbase.downloader.ah.ms.xr("Process", "processName = " + runningAppProcessInfo.processName);
                        }
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        return null;
    }

    public static boolean ms() {
        Boolean bool = ch;
        if (bool != null) {
            return bool.booleanValue();
        }
        String strD = d(com.ss.android.socialbase.downloader.downloader.ah.k());
        Boolean boolValueOf = Boolean.valueOf((strD == null || !strD.contains(":")) && strD != null && strD.equals(com.ss.android.socialbase.downloader.downloader.ah.k().getPackageName()));
        ch = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public static boolean xr() {
        return !ah() && com.ss.android.socialbase.downloader.downloader.ah.ah() && sl.ms(true).ab();
    }

    public static boolean ah() {
        Boolean bool = hi;
        if (bool != null) {
            return bool.booleanValue();
        }
        String strD = d(com.ss.android.socialbase.downloader.downloader.ah.k());
        if (strD != null && strD.equals(com.ss.android.socialbase.downloader.downloader.ah.k().getPackageName() + ":downloader")) {
            hi = Boolean.TRUE;
        } else {
            hi = Boolean.FALSE;
        }
        return hi.booleanValue();
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String strD = d(com.ss.android.socialbase.downloader.downloader.ah.k());
        return strD != null && strD.equals(str);
    }

    public static boolean d() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static String ab(String str) {
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

    public static boolean ms(Throwable th) {
        if (th == null) {
            return false;
        }
        String strCh = ch(th);
        if (th instanceof SocketTimeoutException) {
            return true;
        }
        return !TextUtils.isEmpty(strCh) && (strCh.contains("time out") || strCh.contains("Time-out"));
    }

    public static boolean xr(Throwable th) {
        com.ss.android.socialbase.downloader.exception.xr xrVar;
        if (th == null) {
            return false;
        }
        String strCh = ch(th);
        if (!(th instanceof com.ss.android.socialbase.downloader.exception.xr) || (((xrVar = (com.ss.android.socialbase.downloader.exception.xr) th) == null || xrVar.ms() != 403) && (TextUtils.isEmpty(strCh) || !strCh.contains("403")))) {
            return !TextUtils.isEmpty(strCh) && strCh.contains("Forbidden");
        }
        return true;
    }

    public static boolean ah(Throwable th) {
        if (th == null) {
            return false;
        }
        String strCh = ch(th);
        return !TextUtils.isEmpty(strCh) && strCh.contains("network not available");
    }

    public static boolean d(Throwable th) {
        if (th == null) {
            return false;
        }
        String strCh = ch(th);
        return !TextUtils.isEmpty(strCh) && strCh.contains("Exception in connect");
    }

    public static boolean ka(Throwable th) {
        if (th == null) {
            return false;
        }
        String strCh = ch(th);
        return !TextUtils.isEmpty(strCh) && strCh.contains("Precondition Failed");
    }

    public static boolean c(Throwable th) {
        if (th == null) {
            return false;
        }
        String strCh = ch(th);
        return !TextUtils.isEmpty(strCh) && strCh.contains("Requested Range Not Satisfiable");
    }

    public static boolean ab(Throwable th) {
        return com.ss.android.socialbase.downloader.downloader.ah.e().ms(th);
    }

    public static boolean ms(BaseException baseException) {
        return baseException != null && baseException.getErrorCode() == 1051;
    }

    public static boolean xr(BaseException baseException) {
        if (!(baseException instanceof com.ss.android.socialbase.downloader.exception.xr)) {
            return false;
        }
        com.ss.android.socialbase.downloader.exception.xr xrVar = (com.ss.android.socialbase.downloader.exception.xr) baseException;
        return xrVar.ms() == 412 || xrVar.ms() == 416;
    }

    public static boolean ah(BaseException baseException) {
        if (baseException == null) {
            return false;
        }
        if (baseException.getErrorCode() != 1011) {
            return baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException);
        }
        return true;
    }

    public static void ms(Throwable th, String str) throws BaseException {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (th instanceof BaseException) {
            BaseException baseException = (BaseException) th;
            baseException.setErrorMsg(str2 + "-" + baseException.getErrorMessage());
            throw baseException;
        }
        if (th instanceof SSLHandshakeException) {
            throw new BaseException(1011, xr(th, str2));
        }
        if (ms(th)) {
            throw new BaseException(1048, xr(th, str2));
        }
        if (ka(th)) {
            throw new com.ss.android.socialbase.downloader.exception.xr(1004, TTAdConstant.IMAGE_URL_CODE, xr(th, str2));
        }
        if (c(th)) {
            throw new com.ss.android.socialbase.downloader.exception.xr(1004, 416, xr(th, str2));
        }
        if (xr(th)) {
            throw new BaseException(1047, xr(th, str2));
        }
        if (ah(th)) {
            throw new BaseException(1049, xr(th, str2));
        }
        if (d(th)) {
            throw new BaseException(1041, xr(th, str2));
        }
        if (th instanceof IOException) {
            ah(th, str);
            ms((IOException) th, str);
            return;
        }
        throw new BaseException(1000, xr(th, str2));
    }

    private static void ah(Throwable th, String str) throws com.ss.android.socialbase.downloader.exception.ab {
        com.ss.android.socialbase.downloader.exception.ab abVarMs = com.ss.android.socialbase.downloader.downloader.ah.e().ms(th, null);
        if (abVarMs == null) {
            abVarMs = com.ss.android.socialbase.downloader.downloader.ah.e().ms(th.getCause(), null);
        }
        if (abVarMs == null) {
            return;
        }
        throw new com.ss.android.socialbase.downloader.exception.ab(abVarMs.getErrorCode(), xr(abVarMs, str)).ms(abVarMs.ms());
    }

    public static void ms(IOException iOException, String str) throws BaseException {
        if (str == null) {
            str = "";
        }
        String strXr = xr(iOException, str);
        if (iOException instanceof ConnectException) {
            throw new BaseException(1041, strXr);
        }
        if (iOException instanceof UnknownHostException) {
            throw new BaseException(1055, strXr);
        }
        if (iOException instanceof NoRouteToHostException) {
            throw new BaseException(1056, strXr);
        }
        if (iOException instanceof UnknownServiceException) {
            throw new BaseException(1057, strXr);
        }
        if (iOException instanceof PortUnreachableException) {
            throw new BaseException(1058, strXr);
        }
        if (iOException instanceof SocketTimeoutException) {
            throw new BaseException(1048, strXr);
        }
        if (iOException instanceof SocketException) {
            throw new BaseException(1059, strXr);
        }
        if (iOException instanceof HttpRetryException) {
            throw new BaseException(1060, strXr);
        }
        if (iOException instanceof ProtocolException) {
            throw new BaseException(1061, strXr);
        }
        if (iOException instanceof MalformedURLException) {
            throw new BaseException(1062, strXr);
        }
        if (iOException instanceof FileNotFoundException) {
            throw new BaseException(1063, strXr);
        }
        if (iOException instanceof InterruptedIOException) {
            throw new BaseException(1064, strXr);
        }
        if (iOException instanceof UnsupportedEncodingException) {
            throw new BaseException(1065, strXr);
        }
        if (iOException instanceof EOFException) {
            throw new BaseException(1066, strXr);
        }
        if (iOException instanceof StreamResetException) {
            throw new BaseException(1067, strXr);
        }
        if (iOException instanceof SSLException) {
            throw new BaseException(1011, strXr);
        }
        if (x(iOException)) {
            throw new BaseException(1006, strXr);
        }
        throw new BaseException(1023, strXr);
    }

    public static boolean x(Throwable th) {
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
            String strCh = ch(th);
            if (!TextUtils.isEmpty(strCh) && strCh.contains("ENOSPC")) {
                return true;
            }
        }
        return false;
    }

    public static boolean ny(Throwable th) {
        if (!(th instanceof BaseException)) {
            return false;
        }
        int errorCode = ((BaseException) th).getErrorCode();
        return errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
    }

    public static boolean ms(BaseException baseException, DownloadInfo downloadInfo) {
        if (baseException == null) {
            return false;
        }
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
            return true;
        }
        return (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.getCurBytes() >= 8388608) ? false : true;
    }

    public static String xr(Throwable th, String str) {
        if (str == null) {
            return ch(th);
        }
        return str + "-" + ch(th);
    }

    public static String ch(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th2);
            return "throwable getMsg error";
        }
    }

    public static com.ss.android.socialbase.downloader.constants.c ka(int i) {
        com.ss.android.socialbase.downloader.constants.c cVar = com.ss.android.socialbase.downloader.constants.c.MAIN;
        if (i == com.ss.android.socialbase.downloader.constants.c.SUB.ordinal()) {
            return com.ss.android.socialbase.downloader.constants.c.SUB;
        }
        return i == com.ss.android.socialbase.downloader.constants.c.NOTIFICATION.ordinal() ? com.ss.android.socialbase.downloader.constants.c.NOTIFICATION : cVar;
    }

    public static <K> HashMap<Integer, K> ms(SparseArray<K> sparseArray) {
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

    public static <K> void ms(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static long ka(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -1L;
        }
        List<com.ss.android.socialbase.downloader.model.xr> listAh = com.ss.android.socialbase.downloader.downloader.ah.w().ah(downloadInfo.getId());
        if (downloadInfo.getChunkCount() == 1) {
            return downloadInfo.getCurBytes();
        }
        if (listAh != null && listAh.size() > 1) {
            long jD = d(listAh);
            if (jD >= 0) {
                return jD;
            }
        }
        return 0L;
    }

    private static long d(List<com.ss.android.socialbase.downloader.model.xr> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long jU = -1;
        for (com.ss.android.socialbase.downloader.model.xr xrVar : list) {
            if (xrVar != null && (xrVar.u() <= xrVar.ao() || xrVar.ao() == 0)) {
                if (jU == -1 || jU > xrVar.u()) {
                    jU = xrVar.u();
                }
            }
        }
        return jU;
    }

    public static long c(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0L;
        }
        List<com.ss.android.socialbase.downloader.model.xr> listAh = com.ss.android.socialbase.downloader.downloader.ah.w().ah(downloadInfo.getId());
        int chunkCount = downloadInfo.getChunkCount();
        boolean z = chunkCount > 1;
        if (!downloadInfo.isBreakpointAvailable()) {
            return 0L;
        }
        if (z) {
            if (listAh == null || chunkCount != listAh.size()) {
                return 0L;
            }
            return xr(listAh);
        }
        return downloadInfo.getCurBytes();
    }

    public static boolean ms(List<com.ss.android.socialbase.downloader.model.ah> list, List<com.ss.android.socialbase.downloader.model.ah> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static void ms(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                }
            }
        }
    }

    public static void ms(Cursor... cursorArr) {
        if (cursorArr == null) {
            return;
        }
        for (Cursor cursor : cursorArr) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                }
            }
        }
    }

    public static String ms(String str, int i) {
        if (i == 0) {
            return "";
        }
        return (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public static String ms(String str, com.ss.android.socialbase.downloader.ab.ms msVar) {
        JSONObject jSONObjectD;
        String str2;
        if (msVar == null || (jSONObjectD = msVar.d("download_dir")) == null) {
            return "";
        }
        String strOptString = jSONObjectD.optString("dir_name");
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

    public static String ka() {
        return ms(Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.ah.k()).getGlobalSaveDir(), true);
    }

    public static String c() {
        return ms(Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.ah.k()).getGlobalSaveTempDir(), false);
    }

    private static String ms(File file, boolean z) {
        Context contextK = com.ss.android.socialbase.downloader.downloader.ah.k();
        if (ms(file)) {
            return file.getAbsolutePath();
        }
        int i = contextK.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
            if (com.ss.android.socialbase.downloader.ab.ms.ah().xr("fix_save_external_dir") <= 0) {
                File fileMs = com.bytedance.sdk.openadsdk.api.plugin.xr.ms(contextK, Environment.DIRECTORY_DOWNLOADS);
                if (ms(fileMs)) {
                    return fileMs.getAbsolutePath();
                }
            }
        } else {
            if (z) {
                File fileAb = ab();
                if (ms(fileAb)) {
                    return fileAb.getAbsolutePath();
                }
            }
            if (com.ss.android.socialbase.downloader.ab.ms.ah().xr("fix_save_external_dir") <= 0) {
                File fileMs2 = com.bytedance.sdk.openadsdk.api.plugin.xr.ms(contextK, Environment.DIRECTORY_DOWNLOADS);
                if (ms(fileMs2)) {
                    return fileMs2.getAbsolutePath();
                }
            }
        }
        return com.bytedance.sdk.openadsdk.api.plugin.xr.ms(contextK).getAbsolutePath();
    }

    public static boolean x(String str) {
        Context contextK;
        return com.ss.android.socialbase.downloader.ab.ms.ah().xr("save_path_security") <= 0 || (contextK = com.ss.android.socialbase.downloader.downloader.ah.k()) == null || TextUtils.isEmpty(str) || str.startsWith("/data") || str.contains(new StringBuilder("Android/data/").append(contextK.getPackageName()).toString());
    }

    public static boolean ms(File file) {
        if (file == null) {
            return false;
        }
        try {
            return (file.exists() || file.mkdirs()) && file.isDirectory();
        } catch (Exception unused) {
            return false;
        }
    }

    public static File ab() {
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

    public static void ms(List<com.ss.android.socialbase.downloader.model.ah> list, DownloadInfo downloadInfo) {
        long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
        if (throttleNetSpeed > 0) {
            list.add(new com.ss.android.socialbase.downloader.model.ah("extra_throttle_net_speed", String.valueOf(throttleNetSpeed)));
        }
    }

    public static void xr(List<com.ss.android.socialbase.downloader.model.ah> list, DownloadInfo downloadInfo) {
        long ttnetProtectTimeout = downloadInfo.getTtnetProtectTimeout();
        if (ttnetProtectTimeout > 300) {
            list.add(new com.ss.android.socialbase.downloader.model.ah("extra_ttnet_protect_timeout", String.valueOf(ttnetProtectTimeout)));
        }
    }

    public static long ah(long j) {
        return System.currentTimeMillis() - j;
    }

    public static String xr(com.ss.android.socialbase.downloader.network.ab abVar, String str) {
        if (abVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String strMs = abVar.ms(str);
        if (!com.ss.android.socialbase.downloader.ab.ms.ah().xr("fix_get_http_resp_head_ignore_case", true)) {
            return strMs;
        }
        if (TextUtils.isEmpty(strMs)) {
            strMs = abVar.ms(str.toLowerCase());
        }
        return TextUtils.isEmpty(strMs) ? abVar.ms(str.toUpperCase()) : strMs;
    }

    public static int ms(Object obj, int i) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return i;
        }
    }

    public static String ms(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }

    public static boolean ms(Object obj, boolean z) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return z;
        }
    }

    public static boolean xr(BaseException baseException, DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.isOnlyWifi() && ah(com.ss.android.socialbase.downloader.downloader.ah.k());
    }

    public static boolean x() {
        Context contextK = com.ss.android.socialbase.downloader.downloader.ah.k();
        return (contextK == null || xr(contextK) || !ah(contextK)) ? false : true;
    }

    public static long ny(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
        if (!matcher.find()) {
            return 0L;
        }
        try {
            return Long.parseLong(matcher.group(1));
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
            return 0L;
        }
    }

    public static String ka(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strKa = ka(str2);
        return (TextUtils.isEmpty(strKa) || str.contains(strKa)) ? str : new File(str, strKa).getAbsolutePath();
    }

    public static boolean ah(List<com.ss.android.socialbase.downloader.model.ah> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.model.ah ahVar : list) {
            if (ahVar != null && !TextUtils.isEmpty(ahVar.ms()) && !TextUtils.isEmpty(ahVar.xr()) && "download-tc21-1-15".equals(ahVar.ms()) && "download-tc21-1-15".equals(ahVar.xr())) {
                return true;
            }
        }
        return false;
    }
}
