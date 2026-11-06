package com.taptap.sdk.update.download.core;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.StatFs;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.OkDownload;
import com.taptap.sdk.update.download.core.breakpoint.BlockInfo;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointStoreOnCache;
import com.taptap.sdk.update.download.core.breakpoint.DownloadStore;
import com.taptap.sdk.update.download.core.connection.DownloadConnection;
import com.taptap.sdk.update.download.core.connection.DownloadUrlConnection;
import com.umeng.analytics.pro.an;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public class Util {
    public static final String ACCEPT_RANGES = "Accept-Ranges";
    public static final int CHUNKED_CONTENT_LENGTH = -1;
    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_RANGE = "Content-Range";
    public static final String ETAG = "Etag";
    public static final String IF_MATCH = "If-Match";
    public static final String METHOD_HEAD = "HEAD";
    public static final String RANGE = "Range";
    public static final int RANGE_NOT_SATISFIABLE = 416;
    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
    public static final String USER_AGENT = "User-Agent";
    public static final String VALUE_CHUNKED = "chunked";
    private static Logger logger = new EmptyLogger();

    public interface Logger {
        void d(String str, String str2);

        void e(String str, String str2, Exception exc);

        void i(String str, String str2);

        void w(String str, String str2);
    }

    public static class EmptyLogger implements Logger {
        @Override // com.taptap.sdk.update.download.core.Util.Logger
        public void e(String tag, String msg, Exception e) {
        }

        @Override // com.taptap.sdk.update.download.core.Util.Logger
        public void w(String tag, String msg) {
        }

        @Override // com.taptap.sdk.update.download.core.Util.Logger
        public void d(String tag, String msg) {
        }

        @Override // com.taptap.sdk.update.download.core.Util.Logger
        public void i(String tag, String msg) {
        }
    }

    public static void enableConsoleLog() {
        logger = null;
    }

    public static void setLogger(Logger l) {
        logger = l;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void e(String tag, String msg, Exception e) {
        Logger logger2 = logger;
        if (logger2 != null) {
            logger2.e(tag, msg, e);
        } else {
            Log.e(tag, msg, e);
        }
    }

    public static void w(String tag, String msg) {
        Logger logger2 = logger;
        if (logger2 != null) {
            logger2.w(tag, msg);
        } else {
            Log.w(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        Logger logger2 = logger;
        if (logger2 != null) {
            logger2.d(tag, msg);
        } else {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        Logger logger2 = logger;
        if (logger2 != null) {
            logger2.i(tag, msg);
        } else {
            Log.i(tag, msg);
        }
    }

    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

    public static ThreadFactory threadFactory(final String name, final boolean daemon) {
        return new ThreadFactory() { // from class: com.taptap.sdk.update.download.core.Util.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread result = new Thread(runnable, name);
                result.setDaemon(daemon);
                return result;
            }
        };
    }

    public static String md5(String string) {
        byte[] hash = null;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes(Key.STRING_CHARSET_NAME));
        } catch (UnsupportedEncodingException e) {
        } catch (NoSuchAlgorithmException e2) {
        }
        if (hash != null) {
            StringBuilder hex = new StringBuilder(hash.length * 2);
            for (byte b : hash) {
                if ((b & UByte.MAX_VALUE) < 16) {
                    hex.append('0');
                }
                hex.append(Integer.toHexString(b & UByte.MAX_VALUE));
            }
            return hex.toString();
        }
        return null;
    }

    public static boolean isCorrectFull(long fetchedLength, long contentLength) {
        return fetchedLength == contentLength;
    }

    public static void resetBlockIfDirty(BlockInfo info) {
        boolean isDirty = false;
        if (info.getCurrentOffset() < 0 || info.getCurrentOffset() > info.getContentLength()) {
            isDirty = true;
        }
        if (isDirty) {
            w("resetBlockIfDirty", "block is dirty so have to reset: " + info);
            info.resetBlock();
        }
    }

    public static long getFreeSpaceBytes(StatFs statFs) {
        if (Build.VERSION.SDK_INT >= 18) {
            long freeSpaceBytes = statFs.getAvailableBytes();
            return freeSpaceBytes;
        }
        long freeSpaceBytes2 = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        return freeSpaceBytes2;
    }

    public static String humanReadableBytes(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) {
            return bytes + " B";
        }
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : an.aC);
        return String.format(Locale.ENGLISH, "%.1f %sB", Double.valueOf(bytes / Math.pow(unit, exp)), pre);
    }

    public static DownloadStore createDefaultDatabase(Context context) {
        try {
            return (DownloadStore) Class.forName("com.taptap.sdk.update.download.core.breakpoint.BreakpointStoreOnSQLite").getDeclaredConstructor(Context.class).newInstance(context);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            return new BreakpointStoreOnCache();
        }
    }

    public static DownloadStore createRemitDatabase(DownloadStore originStore) {
        DownloadStore finalStore = originStore;
        try {
            Method createRemitSelf = originStore.getClass().getMethod("createRemitSelf", new Class[0]);
            finalStore = (DownloadStore) createRemitSelf.invoke(originStore, new Object[0]);
        } catch (IllegalAccessException e) {
        } catch (NoSuchMethodException e2) {
        } catch (InvocationTargetException e3) {
        }
        d("Util", "Get final download store is " + finalStore);
        return finalStore;
    }

    public static DownloadConnection.Factory createDefaultConnectionFactory() {
        try {
            return (DownloadConnection.Factory) Class.forName("com.taptap.sdk.update.download.core.connection.DownloadOkHttp3Connection$Factory").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            return new DownloadUrlConnection.Factory();
        }
    }

    public static void assembleBlock(DownloadTask task, BreakpointInfo info, long instanceLength, boolean isAcceptRange) {
        int blockCount;
        if (OkDownload.with().downloadStrategy().isUseMultiBlock(isAcceptRange)) {
            blockCount = OkDownload.with().downloadStrategy().determineBlockCount(task, instanceLength);
        } else {
            blockCount = 1;
        }
        info.resetBlockInfos();
        long eachLength = instanceLength / ((long) blockCount);
        long startOffset = 0;
        long contentLength = 0;
        for (int i = 0; i < blockCount; i++) {
            startOffset += contentLength;
            if (i == 0) {
                long remainLength = instanceLength % ((long) blockCount);
                long contentLength2 = remainLength + eachLength;
                contentLength = contentLength2;
            } else {
                contentLength = eachLength;
            }
            BlockInfo blockInfo = new BlockInfo(startOffset, contentLength);
            info.addBlock(blockInfo);
        }
    }

    public static long parseContentLength(String contentLength) {
        if (contentLength == null) {
            return -1L;
        }
        try {
            return Long.parseLong(contentLength);
        } catch (NumberFormatException e) {
            d("Util", "parseContentLength failed parse for '" + contentLength + "'");
            return -1L;
        }
    }

    public static boolean isNetworkNotOnWifiType(ConnectivityManager manager) {
        if (manager == null) {
            w("Util", "failed to get connectivity manager!");
            return true;
        }
        NetworkInfo info = manager.getActiveNetworkInfo();
        return info == null || info.getType() != 1;
    }

    public static boolean checkPermission(String permission) {
        int perm = OkDownload.with().context().checkCallingOrSelfPermission(permission);
        return perm == 0;
    }

    public static long parseContentLengthFromContentRange(String contentRange) {
        if (contentRange == null || contentRange.length() == 0) {
            return -1L;
        }
        try {
            Pattern r = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+");
            Matcher m = r.matcher(contentRange);
            if (m.find()) {
                long rangeStart = Long.parseLong(m.group(1));
                long rangeEnd = Long.parseLong(m.group(2));
                return (rangeEnd - rangeStart) + 1;
            }
        } catch (Exception e) {
            w("Util", "parse content-length from content-range failed " + e);
        }
        return -1L;
    }

    public static boolean isUriContentScheme(Uri uri) {
        return uri.getScheme().equals("content");
    }

    public static boolean isUriFileScheme(Uri uri) {
        return uri.getScheme().equals("file");
    }

    public static String getFilenameFromContentUri(Uri contentUri) {
        ContentResolver resolver = OkDownload.with().context().getContentResolver();
        Cursor cursor = resolver.query(contentUri, null, null, null, null);
        if (cursor != null) {
            try {
                cursor.moveToFirst();
                return cursor.getString(cursor.getColumnIndex("_display_name"));
            } finally {
                cursor.close();
            }
        }
        return null;
    }

    public static File getParentFile(File file) {
        File candidate = file.getParentFile();
        return candidate == null ? new File("/") : candidate;
    }

    public static long getSizeFromContentUri(Uri contentUri) {
        ContentResolver resolver = OkDownload.with().context().getContentResolver();
        Cursor cursor = resolver.query(contentUri, null, null, null, null);
        if (cursor != null) {
            try {
                cursor.moveToFirst();
                return cursor.getLong(cursor.getColumnIndex("_size"));
            } finally {
                cursor.close();
            }
        }
        return 0L;
    }

    public static boolean isNetworkAvailable(ConnectivityManager manager) {
        if (manager == null) {
            w("Util", "failed to get connectivity manager!");
            return true;
        }
        NetworkInfo info = manager.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

    public static void inspectUserHeader(Map<String, List<String>> headerField) throws IOException {
        if (headerField.containsKey(IF_MATCH) || headerField.containsKey(RANGE)) {
            throw new IOException("If-Match and Range only can be handle by internal!");
        }
    }

    public static void addUserRequestHeaderField(Map<String, List<String>> userHeaderField, DownloadConnection connection) throws IOException {
        inspectUserHeader(userHeaderField);
        addRequestHeaderFields(userHeaderField, connection);
    }

    public static void addRequestHeaderFields(Map<String, List<String>> headerFields, DownloadConnection connection) {
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            String key = entry.getKey();
            List<String> values = entry.getValue();
            for (String value : values) {
                connection.addHeader(key, value);
            }
        }
    }

    public static void addDefaultUserAgent(DownloadConnection connection) {
        connection.addHeader("User-Agent", "OkDownload/4.10.9");
    }
}
