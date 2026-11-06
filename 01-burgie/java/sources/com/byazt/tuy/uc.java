package com.byazt.tuy;

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
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bumptech.glide.load.Key;
import com.byazt.auw.DownloadInfo;
import com.byazt.ca.ho;
import com.byazt.fn.e;
import com.byazt.fn.rc;
import com.byazt.lhc.BaseException;
import com.byazt.lj.Downloader;
import com.byazt.ol.TTDownloadField;
import com.byazt.ts.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.taptap.sdk.compliance.constants.ComplianceMessage;
import com.taptap.sdk.update.download.core.Util;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_OUTFPS_LIST, 5})
public class uc {
    public static ConnectivityManager aj;
    public static Boolean vk;
    public static Boolean w;
    public static final String pr = uc.class.getSimpleName();
    public static final Pattern hw = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    public static String hn = null;
    public static volatile SparseArray<Boolean> x = new SparseArray<>();
    public static volatile SparseArray<List<e>> c = new SparseArray<>();
    public static final char[] uc = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static Pattern fw = null;
    public static Pattern zo = null;

    public static String pr(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        return pr(bArr, 0, bArr.length);
    }

    public static String pr(byte[] bArr, int i, int i2) {
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
            char[] cArr2 = uc;
            cArr[i4] = cArr2[i6 >> 4];
            i4 = i7 + 1;
            cArr[i7] = cArr2[i6 & 15];
        }
        return new String(cArr, 0, i3);
    }

    public static String pr(String str) {
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
            }
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Exception e2) {
            return str;
        }
    }

    public static long pr(com.byazt.edb.fw fwVar) {
        if (fwVar == null) {
            return -1L;
        }
        String strHw = hw(fwVar, Util.CONTENT_LENGTH);
        if (TextUtils.isEmpty(strHw) && pr.pr(1)) {
            return hw(fwVar);
        }
        try {
            return Long.parseLong(strHw);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    public static long hw(com.byazt.edb.fw fwVar) {
        if (fwVar == null) {
            return -1L;
        }
        String strHw = hw(fwVar, Util.CONTENT_RANGE);
        if (TextUtils.isEmpty(strHw)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(strHw);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e) {
            com.byazt.p000do.pr.x(pr, "parse content-length from content-range failed " + e);
        }
        return -1L;
    }

    public static long hw(String str) {
        if (str == null) {
            return -1L;
        }
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length >= 2) {
            try {
                return Long.parseLong(strArrSplit[1]);
            } catch (NumberFormatException e) {
                com.byazt.p000do.pr.x(pr, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    private static String vk(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (fw == null) {
                fw = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            Matcher matcher = fw.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            if (zo == null) {
                zo = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
            }
            Matcher matcher2 = zo.matcher(str);
            if (matcher2.find()) {
                return matcher2.group(1);
            }
            return null;
        } catch (Exception e) {
        }
    }

    public static String pr(com.byazt.edb.fw fwVar, String str) {
        String strVk = vk(fwVar.pr(Util.CONTENT_DISPOSITION));
        if (TextUtils.isEmpty(strVk)) {
            return c(str);
        }
        return strVk;
    }

    public static com.byazt.auw.c pr(DownloadInfo downloadInfo, String str, String str2, int i) throws BaseException {
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
                            if (com.byazt.ew.pr.pr(downloadInfo).pr("opt_mkdir_failed", 0) == 1) {
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
                                    } catch (InterruptedException e) {
                                    }
                                }
                                if (!zMkdirs) {
                                    if (x(downloadInfo.getSavePath()) < PlaybackStateCompat.ACTION_PREPARE) {
                                        throw new BaseException(1006, "download savePath directory can not created:" + str);
                                    }
                                    throw new BaseException(1030, "download savePath directory can not created:" + str);
                                }
                            } else {
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
            } catch (IOException e2) {
                throw new BaseException(1036, e2);
            }
        }
        return new com.byazt.auw.c(file, i);
    }

    public static List<com.byazt.auw.hw> pr(List<com.byazt.auw.hw> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (com.byazt.auw.hw hwVar : list) {
            if (hwVar != null) {
                if (hwVar.x()) {
                    sparseArray.put(hwVar.qa(), hwVar);
                    List<com.byazt.auw.hw> list2 = (List) sparseArray2.get(hwVar.qa());
                    if (list2 != null) {
                        Iterator<com.byazt.auw.hw> it = list2.iterator();
                        while (it.hasNext()) {
                            it.next().pr(hwVar);
                        }
                        hwVar.pr(list2);
                    }
                } else {
                    com.byazt.auw.hw hwVar2 = (com.byazt.auw.hw) sparseArray.get(hwVar.hw());
                    if (hwVar2 != null) {
                        List<com.byazt.auw.hw> listFw = hwVar2.fw();
                        if (listFw == null) {
                            listFw = new ArrayList<>();
                            hwVar2.pr(listFw);
                        }
                        hwVar.pr(hwVar2);
                        listFw.add(hwVar);
                    } else {
                        List arrayList = (List) sparseArray2.get(hwVar.hw());
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            sparseArray2.put(hwVar.hw(), arrayList);
                        }
                        arrayList.add(hwVar);
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList2.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        if (!arrayList2.isEmpty()) {
            return arrayList2;
        }
        return list;
    }

    public static String pr(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    public static String pr(String str, String str2, String str3) {
        String strPr;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            strPr = pr(str2, str3);
        } else {
            strPr = pr(str, str3);
        }
        if (TextUtils.isEmpty(strPr)) {
            return null;
        }
        return String.format("%s.tp", strPr);
    }

    public static String hw(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        return str;
    }

    public static String hn(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    public static long hw(List<com.byazt.auw.hw> list) {
        Iterator<com.byazt.auw.hw> it = list.iterator();
        long jHo = 0;
        while (it.hasNext()) {
            jHo += it.next().ho();
        }
        return jHo;
    }

    public static void pr(DownloadInfo downloadInfo) {
        pr(downloadInfo, true);
    }

    public static void pr(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (z) {
            try {
                hn(downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (Throwable th) {
                return;
            }
        }
        hn(downloadInfo.getTempPath(), downloadInfo.getTempName());
        if (downloadInfo.isSavePathRedirected()) {
            hw(downloadInfo);
        }
        if (z) {
            String strC = c(downloadInfo.getUrl());
            if (!TextUtils.isEmpty(strC) && !TextUtils.isEmpty(downloadInfo.getSavePath()) && downloadInfo.getSavePath().contains(strC)) {
                w(downloadInfo.getSavePath());
            }
        }
    }

    public static void hw(DownloadInfo downloadInfo) {
        com.byazt.ew.pr prVarPr;
        JSONObject jSONObjectX;
        if (downloadInfo != null && (jSONObjectX = (prVarPr = com.byazt.ew.pr.pr(downloadInfo.getId())).x("download_dir")) != null) {
            String strOptString = jSONObjectX.optString("ins_desc");
            if (!TextUtils.isEmpty(strOptString)) {
                hn(downloadInfo.getSavePath(), strOptString);
            }
            String title = downloadInfo.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = downloadInfo.getName();
            }
            String strPr = pr(title, prVarPr);
            String savePath = downloadInfo.getSavePath();
            if (!TextUtils.isEmpty(strPr) && !TextUtils.isEmpty(savePath)) {
                File file = new File(strPr);
                for (File file2 = new File(savePath); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
                    w(file2.getPath());
                    file = file.getParentFile();
                }
            }
        }
    }

    private static boolean w(String str) {
        Thread.currentThread();
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            return file.isDirectory() && file.delete();
        }
        return false;
    }

    public static void hn(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str, str2);
            if (file.exists()) {
                ho.hw(pr, "deleteFile: " + str + "/" + str2);
                file.delete();
            }
        }
    }

    public static boolean pr(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static boolean hn(DownloadInfo downloadInfo) {
        return pr(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5());
    }

    public static boolean pr(DownloadInfo downloadInfo, boolean z, String str) {
        if (z || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        try {
            if (!new File(downloadInfo.getSavePath(), downloadInfo.getName()).exists() || !hn(downloadInfo.getSavePath(), downloadInfo.getName(), str)) {
                return false;
            }
            return true;
        } catch (OutOfMemoryError e) {
        }
    }

    public static boolean x(DownloadInfo downloadInfo) {
        boolean z = false;
        if (!downloadInfo.isDeleteCacheIfCheckFailed() && TextUtils.isEmpty(downloadInfo.getLastModified())) {
            com.byazt.p000do.pr.hw(pr, "dcache::last modify is emtpy, so just return cache");
        } else {
            com.byazt.p000do.pr.hw(pr, "dcache::curt=" + System.currentTimeMillis() + " expired=" + downloadInfo.getCacheExpiredTime());
            if (System.currentTimeMillis() > downloadInfo.getCacheExpiredTime()) {
                z = true;
            }
        }
        com.byazt.p000do.pr.hw(pr, "cacheExpired::dcache::name=" + downloadInfo.getName() + " expired=" + z);
        return z;
    }

    public static int hw(String str, String str2, String str3) {
        return com.byazt.bak.hn.pr(str3, new File(str, str2));
    }

    public static boolean hn(String str, String str2, String str3) {
        return pr(hw(str, str2, str3));
    }

    public static boolean pr(int i) {
        return i == 0 || i == 2;
    }

    public static int pr(File file, String str) {
        return com.byazt.bak.hn.pr(str, file);
    }

    public static String hw(int i) {
        String str = "ttmd5 check code = " + i + ", ";
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
            case 99:
                return str + "unknown error";
            default:
                return str;
        }
    }

    public static long x(String str) throws BaseException {
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getAvailableBytes();
            }
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (IllegalArgumentException e) {
            throw new BaseException(ComplianceMessage.DURATION_LIMIT, e);
        } catch (Throwable th) {
            throw new BaseException(1052, th);
        }
    }

    public static double pr(long j) {
        return j / 1048576.0d;
    }

    public static void pr(DownloadInfo downloadInfo, rc rcVar, e eVar) {
        boolean z;
        BaseException baseException;
        boolean z2;
        String str = pr;
        com.byazt.p000do.pr.hw(str, "saveFileAsTargetName targetName is " + downloadInfo.getTargetFilePath());
        try {
            synchronized (x) {
                if (x.get(downloadInfo.getId()) == Boolean.TRUE) {
                    com.byazt.p000do.pr.hw(str, "has another same task is saving temp file");
                    if (eVar != null) {
                        List<e> arrayList = c.get(downloadInfo.getId());
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            c.put(downloadInfo.getId(), arrayList);
                        }
                        arrayList.add(eVar);
                    }
                    return;
                }
                com.byazt.p000do.pr.hw(str, "saveTempFileStatusMap put id:" + downloadInfo.getId());
                x.put(downloadInfo.getId(), Boolean.TRUE);
                File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
                File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                boolean zZo = zo(downloadInfo.getSavePath());
                if (file2.exists()) {
                    com.byazt.p000do.pr.hw(str, "targetFile exist");
                    int iPr = pr(file2, downloadInfo.getMd5());
                    if (pr(iPr)) {
                        com.byazt.p000do.pr.hw(str, "tempFile not exist , targetFile exists and md5 check valid");
                        downloadInfo.setTTMd5CheckStatus(iPr);
                        if (eVar != null) {
                            eVar.pr();
                        }
                        pr(downloadInfo.getId(), true, (BaseException) null);
                        z = false;
                    } else {
                        if (!file.exists()) {
                            BaseException baseException2 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName(), hw(iPr)));
                            if (eVar != null) {
                                eVar.pr(baseException2);
                            }
                            pr(downloadInfo.getId(), false, baseException2);
                            z = false;
                        } else {
                            z = true;
                        }
                        if (zZo && !file2.delete()) {
                            if (!z) {
                                if (rcVar != null) {
                                    com.byazt.cha.pr.pr(rcVar, downloadInfo, new BaseException(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), downloadInfo.getStatus());
                                }
                            } else {
                                BaseException baseException3 = new BaseException(1037, "delete targetPath file existed with md5 check invalid status:" + hw(iPr));
                                if (eVar != null) {
                                    eVar.pr(baseException3);
                                }
                                pr(downloadInfo.getId(), false, baseException3);
                                z = false;
                            }
                        }
                    }
                } else if (!file.exists()) {
                    BaseException baseException4 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                    if (eVar != null) {
                        eVar.pr(baseException4);
                    }
                    pr(downloadInfo.getId(), false, baseException4);
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    try {
                        int iPr2 = com.byazt.ew.pr.pr(downloadInfo.getId()).pr("download_finish_check_ttmd5", 2);
                        if (iPr2 > 0) {
                            int iPr3 = pr(file, downloadInfo.getMd5());
                            downloadInfo.setTTMd5CheckStatus(iPr3);
                            if (iPr2 >= 2 && !pr(iPr3)) {
                                BaseException baseException5 = new BaseException(1034, hw(iPr3));
                                if (eVar != null) {
                                    eVar.pr(baseException5);
                                }
                                pr(downloadInfo.getId(), false, baseException5);
                                pr(downloadInfo, zZo);
                                return;
                            }
                        }
                        z2 = !hw(file, file2);
                        baseException = null;
                    } catch (BaseException e) {
                        if (!com.byazt.ew.pr.pr(downloadInfo.getId()).pr("fix_file_rename_failed")) {
                            baseException = e;
                            z2 = false;
                        } else {
                            baseException = e;
                            z2 = true;
                        }
                    }
                    if (z2) {
                        if (baseException == null) {
                            baseException = new BaseException(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                        }
                        if (eVar != null) {
                            eVar.pr(baseException);
                        }
                        pr(downloadInfo.getId(), false, baseException);
                        return;
                    }
                    if (eVar != null) {
                        eVar.pr();
                    }
                    pr(downloadInfo.getId(), true, (BaseException) null);
                }
            }
        } catch (Throwable th) {
            com.byazt.p000do.pr.hw(pr, "saveFileAsTargetName throwable " + th.getMessage());
            if (eVar != null) {
                eVar.pr(new BaseException(1038, hw(th, "saveFileAsTargetName")));
            }
        }
    }

    private static void pr(int i, boolean z, BaseException baseException) {
        synchronized (x) {
            List<e> list = c.get(i);
            if (list != null) {
                for (e eVar : list) {
                    if (eVar != null) {
                        if (z) {
                            eVar.pr();
                        } else {
                            eVar.pr(baseException);
                        }
                    }
                }
            }
            com.byazt.p000do.pr.hw(pr, "handleTempSaveCallback id:" + i);
            x.remove(i);
        }
    }

    public static void pr(DownloadInfo downloadInfo, String str) throws BaseException {
        if (downloadInfo == null || TextUtils.isEmpty(str) || str.equals(downloadInfo.getName())) {
            return;
        }
        File file = new File(downloadInfo.getSavePath(), str);
        File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        ho.hw(pr, "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath());
        if (file2.exists() && !file2.canWrite()) {
            throw new BaseException(1001, "targetPath file exists but read-only");
        }
        if (!pr(file, file2)) {
            throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.getSavePath(), str, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
    }

    public static boolean pr(File file, File file2) throws BaseException {
        return pr(file, file2, true);
    }

    public static boolean pr(File file, File file2, boolean z) throws BaseException {
        if (file != null && file2 != null) {
            try {
                if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new BaseException(1053, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    ho.hw(pr, "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath());
                    if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    }
                    hw(file, file2, z);
                    return true;
                }
            } catch (BaseException e) {
                throw e;
            } catch (Throwable th) {
                pr(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    private static void hw(File file, File file2, boolean z) throws IOException {
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

    public static boolean hw(File file, File file2) throws BaseException {
        String str = pr;
        ho.hw(str, "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath());
        boolean zRenameTo = file.renameTo(file2);
        if (!zRenameTo) {
            zRenameTo = pr(file, file2);
            try {
                ho.hw(str, "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath());
                file.delete();
            } catch (Throwable th) {
            }
        }
        return zRenameTo;
    }

    public static boolean x(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static boolean pr(int i, String str) {
        if (pr.pr(16777216)) {
            return i == 206 || i == 1;
        }
        if (i >= 400) {
            return false;
        }
        return i == 206 || i == 1 || "bytes".equals(str);
    }

    public static boolean hn(int i) {
        return i == 200 || i == 201 || i == 0;
    }

    public static boolean x(int i) {
        return i == 206 || i == 200;
    }

    public static boolean hw(long j) {
        return j == -1;
    }

    public static boolean hn(com.byazt.edb.fw fwVar) {
        if (fwVar == null) {
            return false;
        }
        if (pr.pr(8)) {
            return "chunked".equals(fwVar.pr(Util.TRANSFER_ENCODING)) || pr(fwVar) == -1;
        }
        return pr(fwVar) == -1;
    }

    public static List<com.byazt.auw.hn> pr(List<com.byazt.auw.hn> list, String str, com.byazt.auw.hw hwVar) {
        return pr(list, str, hwVar.m(), hwVar.nt());
    }

    public static List<com.byazt.auw.hn> pr(List<com.byazt.auw.hn> list, String str, long j, long j2) {
        String str2;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (com.byazt.auw.hn hnVar : list) {
                if (hnVar != null) {
                    arrayList.add(hnVar);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new com.byazt.auw.hn(Util.IF_MATCH, str));
        }
        arrayList.add(new com.byazt.auw.hn("Accept-Encoding", "identity"));
        if (j2 <= 0) {
            str2 = String.format("bytes=%s-", String.valueOf(j));
        } else {
            str2 = String.format("bytes=%s-%s", String.valueOf(j), String.valueOf(j2));
        }
        arrayList.add(new com.byazt.auw.hn(Util.RANGE, str2));
        com.byazt.p000do.pr.hw(pr, " range CurrentOffset:" + j + " EndOffset:" + j2 + ", range = " + str2);
        return arrayList;
    }

    public static boolean pr(int i, String str, String str2) {
        if (i == -3 && !x(str, str2)) {
            return true;
        }
        return false;
    }

    public static ConnectivityManager pr(Context context) {
        ConnectivityManager connectivityManager = aj;
        if (connectivityManager == null) {
            ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
            aj = connectivityManager2;
            return connectivityManager2;
        }
        return connectivityManager;
    }

    public static boolean hw(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerPr = pr(context);
            return connectivityManagerPr != null && (activeNetworkInfo = connectivityManagerPr.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable() && 1 == activeNetworkInfo.getType();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean hn(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerPr = pr(context);
            if (connectivityManagerPr == null || (activeNetworkInfo = connectivityManagerPr.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception e) {
            return false;
        }
    }

    public static String c(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes(Key.STRING_CHARSET_NAME));
                    return pr(messageDigest.digest());
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static String x(Context context) {
        String str = hn;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String strVk = vk();
        hn = strVk;
        if (!TextUtils.isEmpty(strVk)) {
            return hn;
        }
        String strW = w();
        hn = strW;
        if (!TextUtils.isEmpty(strW)) {
            return hn;
        }
        String strC = c(context);
        hn = strC;
        if (!TextUtils.isEmpty(strC)) {
            return hn;
        }
        String strAj = aj();
        hn = strAj;
        return strAj;
    }

    private static String aj() {
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
                if (com.byazt.p000do.pr.pr()) {
                    com.byazt.p000do.pr.hw("Process", "get processName = " + sb.toString());
                }
                String string = sb.toString();
                pr(bufferedReader);
                return string;
            } catch (Throwable th) {
                pr(bufferedReader);
                return null;
            }
        } catch (Throwable th2) {
            bufferedReader = null;
        }
    }

    private static String vk() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                String processName = Application.getProcessName();
                if (!TextUtils.isEmpty(processName) && com.byazt.p000do.pr.pr()) {
                    com.byazt.p000do.pr.hw("Process", "processName = " + processName);
                }
                return processName;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private static String w() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (!(objInvoke instanceof String)) {
                return null;
            }
            String str = (String) objInvoke;
            try {
                if (!TextUtils.isEmpty(str) && com.byazt.p000do.pr.pr()) {
                    com.byazt.p000do.pr.hw("Process", "processName = " + str);
                }
                return str;
            } catch (Throwable th) {
                return str;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    private static String c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        if (com.byazt.p000do.pr.pr()) {
                            com.byazt.p000do.pr.hw("Process", "processName = " + runningAppProcessInfo.processName);
                        }
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static boolean pr() {
        Boolean bool = vk;
        if (bool != null) {
            return bool.booleanValue();
        }
        String strX = x(com.byazt.lj.hn.of());
        Boolean boolValueOf = Boolean.valueOf((strX == null || !strX.contains(":")) && strX != null && strX.equals(com.byazt.lj.hn.of().getPackageName()));
        vk = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public static boolean hw() {
        return !hn() && com.byazt.lj.hn.hn() && k.pr(true).fw();
    }

    public static boolean hn() {
        Boolean bool = w;
        if (bool != null) {
            return bool.booleanValue();
        }
        String strX = x(com.byazt.lj.hn.of());
        if (strX != null && strX.equals(com.byazt.lj.hn.of().getPackageName() + ":downloader")) {
            w = Boolean.TRUE;
        } else {
            w = Boolean.FALSE;
        }
        return w.booleanValue();
    }

    public static boolean uc(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String strX = x(com.byazt.lj.hn.of());
        return strX != null && strX.equals(str);
    }

    public static boolean x() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static String fw(String str) {
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

    public static boolean pr(Throwable th) {
        if (th == null) {
            return false;
        }
        String strVk = vk(th);
        if (!(th instanceof SocketTimeoutException)) {
            if (TextUtils.isEmpty(strVk) || (!strVk.contains("time out") && !strVk.contains("Time-out"))) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static boolean hw(Throwable th) {
        com.byazt.lhc.hw hwVar;
        if (th == null) {
            return false;
        }
        String strVk = vk(th);
        if (!(th instanceof com.byazt.lhc.hw) || (((hwVar = (com.byazt.lhc.hw) th) == null || hwVar.pr() != 403) && (TextUtils.isEmpty(strVk) || !strVk.contains("403")))) {
            return !TextUtils.isEmpty(strVk) && strVk.contains("Forbidden");
        }
        return true;
    }

    public static boolean hn(Throwable th) {
        if (th == null) {
            return false;
        }
        String strVk = vk(th);
        return !TextUtils.isEmpty(strVk) && strVk.contains("network not available");
    }

    public static boolean x(Throwable th) {
        if (th == null) {
            return false;
        }
        String strVk = vk(th);
        return !TextUtils.isEmpty(strVk) && strVk.contains("Exception in connect");
    }

    public static boolean c(Throwable th) {
        if (th == null) {
            return false;
        }
        String strVk = vk(th);
        return !TextUtils.isEmpty(strVk) && strVk.contains("Precondition Failed");
    }

    public static boolean uc(Throwable th) {
        if (th == null) {
            return false;
        }
        String strVk = vk(th);
        return !TextUtils.isEmpty(strVk) && strVk.contains("Requested Range Not Satisfiable");
    }

    public static boolean fw(Throwable th) {
        return com.byazt.lj.hn.qn().pr(th);
    }

    public static boolean pr(BaseException baseException) {
        return baseException != null && baseException.getErrorCode() == 1051;
    }

    public static boolean hw(BaseException baseException) {
        if (!(baseException instanceof com.byazt.lhc.hw)) {
            return false;
        }
        com.byazt.lhc.hw hwVar = (com.byazt.lhc.hw) baseException;
        return hwVar.pr() == 412 || hwVar.pr() == 416;
    }

    public static boolean hn(BaseException baseException) {
        if (baseException == null) {
            return false;
        }
        if (baseException.getErrorCode() != 1011) {
            if (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static void pr(Throwable th, String str) throws BaseException {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (th instanceof BaseException) {
            BaseException baseException = (BaseException) th;
            baseException.setErrorMsg(str2 + "-" + baseException.getErrorMessage());
            throw baseException;
        }
        if (th instanceof SSLHandshakeException) {
            throw new BaseException(1011, hw(th, str2));
        }
        if (pr(th)) {
            throw new BaseException(1048, hw(th, str2));
        }
        if (c(th)) {
            throw new com.byazt.lhc.hw(1004, TTAdConstant.IMAGE_URL_CODE, hw(th, str2));
        }
        if (uc(th)) {
            throw new com.byazt.lhc.hw(1004, 416, hw(th, str2));
        }
        if (hw(th)) {
            throw new BaseException(1047, hw(th, str2));
        }
        if (hn(th)) {
            throw new BaseException(1049, hw(th, str2));
        }
        if (x(th)) {
            throw new BaseException(1041, hw(th, str2));
        }
        if (th instanceof IOException) {
            hn(th, str);
            pr((IOException) th, str);
            return;
        }
        throw new BaseException(1000, hw(th, str2));
    }

    private static void hn(Throwable th, String str) throws com.byazt.lhc.fw {
        com.byazt.lhc.fw fwVarPr = com.byazt.lj.hn.qn().pr(th, null);
        if (fwVarPr == null) {
            fwVarPr = com.byazt.lj.hn.qn().pr(th.getCause(), null);
        }
        if (fwVarPr != null) {
            throw new com.byazt.lhc.fw(fwVarPr.getErrorCode(), hw(fwVarPr, str)).pr(fwVarPr.pr());
        }
    }

    public static void pr(IOException iOException, String str) throws BaseException {
        if (str == null) {
            str = "";
        }
        String strHw = hw(iOException, str);
        if (iOException instanceof ConnectException) {
            throw new BaseException(1041, strHw);
        }
        if (iOException instanceof UnknownHostException) {
            throw new BaseException(1055, strHw);
        }
        if (iOException instanceof NoRouteToHostException) {
            throw new BaseException(1056, strHw);
        }
        if (iOException instanceof UnknownServiceException) {
            throw new BaseException(1057, strHw);
        }
        if (iOException instanceof PortUnreachableException) {
            throw new BaseException(1058, strHw);
        }
        if (iOException instanceof SocketTimeoutException) {
            throw new BaseException(1048, strHw);
        }
        if (iOException instanceof SocketException) {
            throw new BaseException(1059, strHw);
        }
        if (iOException instanceof HttpRetryException) {
            throw new BaseException(1060, strHw);
        }
        if (iOException instanceof ProtocolException) {
            throw new BaseException(1061, strHw);
        }
        if (iOException instanceof MalformedURLException) {
            throw new BaseException(1062, strHw);
        }
        if (iOException instanceof FileNotFoundException) {
            throw new BaseException(1063, strHw);
        }
        if (iOException instanceof InterruptedIOException) {
            throw new BaseException(1064, strHw);
        }
        if (iOException instanceof UnsupportedEncodingException) {
            throw new BaseException(1065, strHw);
        }
        if (iOException instanceof EOFException) {
            throw new BaseException(1066, strHw);
        }
        if (iOException instanceof StreamResetException) {
            throw new BaseException(1067, strHw);
        }
        if (iOException instanceof SSLException) {
            throw new BaseException(1011, strHw);
        }
        if (zo(iOException)) {
            throw new BaseException(1006, strHw);
        }
        throw new BaseException(1023, strHw);
    }

    public static boolean zo(Throwable th) {
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
            String strVk = vk(th);
            return !TextUtils.isEmpty(strVk) && strVk.contains("ENOSPC");
        }
        return false;
    }

    public static boolean aj(Throwable th) {
        if (!(th instanceof BaseException)) {
            return false;
        }
        int errorCode = ((BaseException) th).getErrorCode();
        return errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
    }

    public static boolean pr(BaseException baseException, DownloadInfo downloadInfo) {
        if (baseException == null) {
            return false;
        }
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
            return true;
        }
        return (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.getCurBytes() >= 8388608) ? false : true;
    }

    public static String hw(Throwable th, String str) {
        if (str == null) {
            return vk(th);
        }
        return str + "-" + vk(th);
    }

    public static String vk(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (Throwable th2) {
            return "throwable getMsg error";
        }
    }

    public static com.byazt.mrs.uc c(int i) {
        com.byazt.mrs.uc ucVar = com.byazt.mrs.uc.MAIN;
        if (i == com.byazt.mrs.uc.SUB.ordinal()) {
            return com.byazt.mrs.uc.SUB;
        }
        if (i == com.byazt.mrs.uc.NOTIFICATION.ordinal()) {
            return com.byazt.mrs.uc.NOTIFICATION;
        }
        return ucVar;
    }

    public static <K> HashMap<Integer, K> pr(SparseArray<K> sparseArray) {
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

    public static <K> void pr(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static long c(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -1L;
        }
        List<com.byazt.auw.hw> listHn = com.byazt.lj.hn.z().hn(downloadInfo.getId());
        if (downloadInfo.getChunkCount() == 1) {
            return downloadInfo.getCurBytes();
        }
        if (listHn == null || listHn.size() <= 1) {
            return 0L;
        }
        long jX = x(listHn);
        if (jX >= 0) {
            return jX;
        }
        return 0L;
    }

    private static long x(List<com.byazt.auw.hw> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long jG = -1;
        for (com.byazt.auw.hw hwVar : list) {
            if (hwVar != null && (hwVar.g() <= hwVar.nt() || hwVar.nt() == 0)) {
                if (jG == -1 || jG > hwVar.g()) {
                    jG = hwVar.g();
                }
            }
        }
        return jG;
    }

    public static long uc(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0L;
        }
        List<com.byazt.auw.hw> listHn = com.byazt.lj.hn.z().hn(downloadInfo.getId());
        int chunkCount = downloadInfo.getChunkCount();
        boolean z = chunkCount > 1;
        if (!downloadInfo.isBreakpointAvailable()) {
            return 0L;
        }
        if (z) {
            if (listHn == null || chunkCount != listHn.size()) {
                return 0L;
            }
            return hw(listHn);
        }
        return downloadInfo.getCurBytes();
    }

    public static boolean pr(List<com.byazt.auw.hn> list, List<com.byazt.auw.hn> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static void pr(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                }
            }
        }
    }

    public static void pr(Cursor... cursorArr) {
        if (cursorArr == null) {
            return;
        }
        for (Cursor cursor : cursorArr) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                }
            }
        }
    }

    public static String pr(String str, int i) {
        if (i == 0) {
            return "";
        }
        if (TextUtils.isEmpty(str) || str.length() <= i) {
            return str;
        }
        return str.substring(0, i);
    }

    public static String pr(String str, com.byazt.ew.pr prVar) {
        JSONObject jSONObjectX;
        if (prVar != null && (jSONObjectX = prVar.x("download_dir")) != null) {
            String strOptString = jSONObjectX.optString("dir_name");
            if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("/")) {
                strOptString = strOptString.substring(1);
            }
            if (TextUtils.isEmpty(strOptString)) {
                return strOptString;
            }
            if (!strOptString.contains("%s")) {
                strOptString = strOptString + str;
            } else {
                try {
                    strOptString = String.format(strOptString, str);
                } catch (Throwable th) {
                }
            }
            return strOptString.length() > 255 ? strOptString.substring(strOptString.length() - 255) : strOptString;
        }
        return "";
    }

    public static String c() {
        return pr(Downloader.getInstance(com.byazt.lj.hn.of()).getGlobalSaveDir(), true);
    }

    public static String uc() {
        return pr(Downloader.getInstance(com.byazt.lj.hn.of()).getGlobalSaveTempDir(), false);
    }

    private static String pr(File file, boolean z) {
        Context contextOf = com.byazt.lj.hn.of();
        if (pr(file)) {
            return file.getAbsolutePath();
        }
        int i = contextOf.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
            if (com.byazt.ew.pr.hn().hw("fix_save_external_dir") <= 0) {
                File filePr = com.byazt.mg.hw.pr(contextOf, Environment.DIRECTORY_DOWNLOADS);
                if (pr(filePr)) {
                    return filePr.getAbsolutePath();
                }
            }
        } else {
            if (z) {
                File fileFw = fw();
                if (pr(fileFw)) {
                    return fileFw.getAbsolutePath();
                }
            }
            if (com.byazt.ew.pr.hn().hw("fix_save_external_dir") <= 0) {
                File filePr2 = com.byazt.mg.hw.pr(contextOf, Environment.DIRECTORY_DOWNLOADS);
                if (pr(filePr2)) {
                    return filePr2.getAbsolutePath();
                }
            }
        }
        return com.byazt.mg.hw.pr(contextOf).getAbsolutePath();
    }

    public static boolean zo(String str) {
        Context contextOf;
        return com.byazt.ew.pr.hn().hw("save_path_security") <= 0 || (contextOf = com.byazt.lj.hn.of()) == null || TextUtils.isEmpty(str) || str.startsWith("/data") || str.contains(new StringBuilder("Android/data/").append(contextOf.getPackageName()).toString());
    }

    public static boolean pr(File file) {
        if (file == null) {
            return false;
        }
        try {
            if ((!file.exists() && !file.mkdirs()) || !file.isDirectory()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static File fw() {
        String externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (Exception e) {
            externalStorageState = "";
        }
        if ("mounted".equals(externalStorageState)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return null;
    }

    public static void pr(List<com.byazt.auw.hn> list, DownloadInfo downloadInfo) {
        long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
        if (throttleNetSpeed > 0) {
            list.add(new com.byazt.auw.hn("extra_throttle_net_speed", String.valueOf(throttleNetSpeed)));
        }
    }

    public static void hw(List<com.byazt.auw.hn> list, DownloadInfo downloadInfo) {
        long ttnetProtectTimeout = downloadInfo.getTtnetProtectTimeout();
        if (ttnetProtectTimeout > 300) {
            list.add(new com.byazt.auw.hn("extra_ttnet_protect_timeout", String.valueOf(ttnetProtectTimeout)));
        }
    }

    public static long hn(long j) {
        return System.currentTimeMillis() - j;
    }

    public static String hw(com.byazt.edb.fw fwVar, String str) {
        if (fwVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String strPr = fwVar.pr(str);
        if (!com.byazt.ew.pr.hn().hw("fix_get_http_resp_head_ignore_case", true)) {
            return strPr;
        }
        if (TextUtils.isEmpty(strPr)) {
            strPr = fwVar.pr(str.toLowerCase());
        }
        if (TextUtils.isEmpty(strPr)) {
            return fwVar.pr(str.toUpperCase());
        }
        return strPr;
    }

    public static int pr(Object obj, int i) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException e) {
            return i;
        }
    }

    public static String pr(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException e) {
            return str;
        }
    }

    public static boolean pr(Object obj, boolean z) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException e) {
            return z;
        }
    }

    public static boolean hw(BaseException baseException, DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.isOnlyWifi() && hn(com.byazt.lj.hn.of());
    }

    public static boolean zo() {
        Context contextOf = com.byazt.lj.hn.of();
        return (contextOf == null || hw(contextOf) || !hn(contextOf)) ? false : true;
    }

    public static long aj(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
            if (!matcher.find()) {
                return 0L;
            }
            try {
                return Long.parseLong(matcher.group(1));
            } catch (Throwable th) {
                return 0L;
            }
        } catch (Throwable th2) {
            return 0L;
        }
    }

    public static String c(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String strC = c(str2);
            if (!TextUtils.isEmpty(strC) && !str.contains(strC)) {
                return new File(str, strC).getAbsolutePath();
            }
        }
        return str;
    }

    public static boolean hn(List<com.byazt.auw.hn> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.byazt.auw.hn hnVar : list) {
            if (hnVar != null && !TextUtils.isEmpty(hnVar.pr()) && !TextUtils.isEmpty(hnVar.hw()) && "download-tc21-1-15".equals(hnVar.pr()) && "download-tc21-1-15".equals(hnVar.hw())) {
                return true;
            }
        }
        return false;
    }
}
