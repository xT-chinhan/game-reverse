package com.tapsdk.tapad.internal.runtime.download;

import com.byazt.fi.BaseConstants;
import com.tapsdk.tapad.a;
import com.tapsdk.tapad.b;
import com.tapsdk.tapad.c;
import com.tapsdk.tapad.internal.network.utils.SecureConnectionUtil;
import com.taptap.sdk.update.download.core.Util;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class AndroidFileTransfer implements Runnable {
    private static final int BUFFER_SIZE = 8192;
    private static final int MAX_REDIRECTS = 10;
    private static final String TAG = "AndroidFileTransfer";
    private volatile AndroidRangeTransfer activeRangeTransfer;
    private Callback callback;
    private final AtomicInteger currentUrlIndex;
    private volatile int lastErrorCode;
    private volatile String lastErrorMessage;
    private final Object lifecycleLock;
    private final String nonResumableTempSuffix;
    private boolean pauseCallbackPending;
    private File rangeCheckpointFile;
    private final AndroidDownloadRequest request;
    private boolean resumeRequested;
    private final AtomicBoolean startCallbackFired;
    private File targetFile;
    private final long taskInstanceId;
    private File tempFile;
    private boolean workerRunning;
    private volatile Thread workerThread;
    private static final AtomicLong TASK_INSTANCE_SEQUENCE = new AtomicLong();
    private static final String PROCESS_INSTANCE_TOKEN = UUID.randomUUID().toString();
    private final AtomicLong downloadedBytes = new AtomicLong(0);
    private volatile long totalBytes = -1;
    private long speedStartTime = 0;
    private long speedStartBytes = 0;
    private volatile long currentSpeed = 0;
    private long lastProgressCallbackTime = 0;
    private final Object progressCallbackLock = new Object();
    private volatile State state = State.IDLE;
    private final AtomicBoolean paused = new AtomicBoolean(false);
    private final AtomicBoolean canceled = new AtomicBoolean(false);

    public interface Callback {
        void onCanceled(AndroidFileTransfer androidFileTransfer);

        void onComplete(AndroidFileTransfer androidFileTransfer, File file);

        void onError(AndroidFileTransfer androidFileTransfer, int i, String str);

        void onPaused(AndroidFileTransfer androidFileTransfer);

        void onProgress(AndroidFileTransfer androidFileTransfer, float f, long j, long j2, long j3);

        void onStart(AndroidFileTransfer androidFileTransfer);
    }

    public enum State {
        IDLE,
        RUNNING,
        PAUSED,
        COMPLETED,
        FAILED,
        CANCELED
    }

    public AndroidFileTransfer(AndroidDownloadRequest androidDownloadRequest) {
        long jIncrementAndGet = TASK_INSTANCE_SEQUENCE.incrementAndGet();
        this.taskInstanceId = jIncrementAndGet;
        this.nonResumableTempSuffix = "." + Long.toHexString(jIncrementAndGet);
        this.lifecycleLock = new Object();
        this.workerRunning = false;
        this.resumeRequested = false;
        this.pauseCallbackPending = false;
        this.lastErrorCode = 0;
        this.lastErrorMessage = null;
        this.startCallbackFired = new AtomicBoolean(false);
        this.request = androidDownloadRequest;
        this.currentUrlIndex = new AtomicInteger();
    }

    private static long contentLength(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField(Util.CONTENT_LENGTH);
        if (headerField != null && !headerField.trim().isEmpty()) {
            try {
                return Long.parseLong(headerField.trim());
            } catch (NumberFormatException e) {
            }
        }
        return -1L;
    }

    private boolean deleteOrTruncateTempFile() {
        deleteRangeCheckpoint();
        File file = this.tempFile;
        if (file == null || !file.exists() || this.tempFile.delete()) {
            return true;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.tempFile, "rw");
            try {
                randomAccessFile.setLength(0L);
                randomAccessFile.close();
                return true;
            } catch (Throwable th) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private void deleteRangeCheckpoint() {
        File file = this.rangeCheckpointFile;
        if (file == null) {
            return;
        }
        if (file.exists()) {
            this.rangeCheckpointFile.delete();
        }
        File file2 = new File(this.rangeCheckpointFile.getPath() + ".new");
        if (file2.exists()) {
            file2.delete();
        }
    }

    /* JADX WARN: Code duplicated, block: B:109:0x01fc A[Catch: IOException -> 0x01d9, all -> 0x0270, Exception -> 0x0274, SocketTimeoutException -> 0x028a, TRY_ENTER, TRY_LEAVE, TryCatch #48 {IOException -> 0x01d9, blocks: (B:100:0x01d2, B:109:0x01fc, B:121:0x0214, B:134:0x022d), top: B:358:0x01d2 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0214 A[Catch: IOException -> 0x01d9, all -> 0x0270, Exception -> 0x0274, SocketTimeoutException -> 0x028a, TRY_ENTER, TRY_LEAVE, TryCatch #48 {IOException -> 0x01d9, blocks: (B:100:0x01d2, B:109:0x01fc, B:121:0x0214, B:134:0x022d), top: B:358:0x01d2 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x022d A[Catch: IOException -> 0x01d9, all -> 0x0270, Exception -> 0x0274, SocketTimeoutException -> 0x028a, LOOP:0: B:106:0x01f5->B:134:0x022d, LOOP_END, TRY_ENTER, TRY_LEAVE, TryCatch #48 {IOException -> 0x01d9, blocks: (B:100:0x01d2, B:109:0x01fc, B:121:0x0214, B:134:0x022d), top: B:358:0x01d2 }] */
    /* JADX WARN: Code duplicated, block: B:188:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:18:0x0048 A[Catch: all -> 0x031a, Exception -> 0x0321, IOException -> 0x034c, SocketTimeoutException -> 0x0378, TRY_ENTER, TRY_LEAVE, TryCatch #49 {SocketTimeoutException -> 0x0378, IOException -> 0x034c, Exception -> 0x0321, all -> 0x031a, blocks: (B:3:0x0008, B:18:0x0048), top: B:308:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:306:0x036b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:311:0x0372 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:320:0x0364 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:326:0x02e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:328:0x01df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x00c6 A[Catch: all -> 0x02fb, Exception -> 0x0310, IOException -> 0x0313, SocketTimeoutException -> 0x0316, TRY_ENTER, TRY_LEAVE, TryCatch #45 {all -> 0x02fb, blocks: (B:42:0x00e9, B:45:0x00fb, B:51:0x011a, B:20:0x0091, B:22:0x009a, B:24:0x00a2, B:32:0x00c6, B:37:0x00cd, B:39:0x00d1, B:41:0x00da, B:220:0x030b, B:221:0x030d), top: B:355:0x0091 }] */
    /* JADX WARN: Code duplicated, block: B:335:0x038f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:339:0x0204 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:345:0x03af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:347:0x021c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:349:0x0396 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ca A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:356:0x039d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:358:0x01d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:364:0x0346 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:371:0x0338 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:373:0x03b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:375:0x033f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:378:0x03bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:380:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:387:0x0235 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:388:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d1 A[Catch: IOException -> 0x0111, all -> 0x02fb, Exception -> 0x02fd, SocketTimeoutException -> 0x0303, TRY_ENTER, TRY_LEAVE, TryCatch #21 {IOException -> 0x0111, blocks: (B:45:0x00fb, B:39:0x00d1), top: B:332:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00da A[Catch: all -> 0x02fb, Exception -> 0x02fd, IOException -> 0x02ff, SocketTimeoutException -> 0x0303, TRY_ENTER, TryCatch #15 {IOException -> 0x02ff, blocks: (B:42:0x00e9, B:51:0x011a, B:37:0x00cd, B:41:0x00da), top: B:324:0x00cd }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00fb A[Catch: IOException -> 0x0111, all -> 0x02fb, Exception -> 0x02fd, SocketTimeoutException -> 0x0303, TRY_ENTER, TRY_LEAVE, TryCatch #21 {IOException -> 0x0111, blocks: (B:45:0x00fb, B:39:0x00d1), top: B:332:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0119  */
    /* JADX WARN: Code duplicated, block: B:60:0x0144 A[Catch: IOException -> 0x0150, all -> 0x02e6, Exception -> 0x02eb, SocketTimeoutException -> 0x02f6, TRY_ENTER, TRY_LEAVE, TryCatch #53 {IOException -> 0x0150, blocks: (B:60:0x0144, B:69:0x0158, B:93:0x01af, B:95:0x01b9, B:83:0x0194, B:85:0x019b), top: B:368:0x0142 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0154  */
    /* JADX WARN: Code duplicated, block: B:69:0x0158 A[Catch: IOException -> 0x0150, all -> 0x02e6, Exception -> 0x02eb, SocketTimeoutException -> 0x02f6, TRY_ENTER, TRY_LEAVE, TryCatch #53 {IOException -> 0x0150, blocks: (B:60:0x0144, B:69:0x0158, B:93:0x01af, B:95:0x01b9, B:83:0x0194, B:85:0x019b), top: B:368:0x0142 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0164  */
    /* JADX WARN: Code duplicated, block: B:73:0x0168 A[Catch: all -> 0x02e6, Exception -> 0x02eb, IOException -> 0x02ef, SocketTimeoutException -> 0x02f6, TRY_ENTER, TryCatch #8 {IOException -> 0x02ef, blocks: (B:52:0x0123, B:54:0x012b, B:57:0x0135, B:90:0x01a9, B:96:0x01c1, B:73:0x0168, B:75:0x0174, B:77:0x017a, B:80:0x018a), top: B:313:0x0123 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x03a5: MOVE (r20 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:291:0x03a4 */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x03a7: MOVE (r11 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:291:0x03a4 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r15v13, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r15v14, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r15v16, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v28 */
    /* JADX WARN: Type inference failed for: r15v29 */
    /* JADX WARN: Type inference failed for: r15v40 */
    /* JADX WARN: Type inference failed for: r15v45 */
    /* JADX WARN: Type inference failed for: r15v46 */
    /* JADX WARN: Type inference failed for: r22v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v53, types: [java.util.concurrent.atomic.AtomicLong] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v73 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v42 */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r4v45 */
    /* JADX WARN: Type inference failed for: r4v46 */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v51 */
    /* JADX WARN: Type inference failed for: r4v52 */
    /* JADX WARN: Type inference failed for: r4v53 */
    /* JADX WARN: Type inference failed for: r4v54 */
    /* JADX WARN: Type inference failed for: r4v55 */
    /* JADX WARN: Type inference failed for: r4v56 */
    /* JADX WARN: Type inference failed for: r4v57 */
    /* JADX WARN: Type inference failed for: r4v58 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v60 */
    /* JADX WARN: Type inference failed for: r4v61 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v16, types: [long] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [int] */
    private boolean downloadFromUrl(String str) throws Throwable {
        HttpURLConnection httpURLConnection;
        int i;
        ?? r4;
        char c;
        String str2;
        Throwable th;
        String str3;
        HttpURLConnection httpURLConnection2;
        HttpURLConnection httpURLConnection3;
        String str4;
        String str5;
        Exception exc;
        String str6;
        SocketTimeoutException socketTimeoutException;
        String str7;
        IOException iOException;
        String str8;
        ?? r3;
        ?? r2;
        String str9;
        ?? r5;
        String str10;
        ?? r11;
        ?? r6;
        String str11;
        ?? r7;
        String str12;
        ?? r12;
        ?? r8;
        HttpURLConnection httpURLConnection4;
        ?? r15;
        ?? r9;
        ?? r16;
        ?? r10;
        String str13;
        ?? r13;
        ?? r14;
        String str14;
        ?? r17;
        ?? r18;
        ?? r19;
        ?? r20;
        ?? r21;
        String str15;
        String str16;
        ?? r22;
        String str17;
        ?? r23;
        String str18;
        HttpURLConnection httpURLConnectionOpenConnectionWithRedirects;
        int responseCode;
        AndroidRangeTransfer.ContentRange contentRange;
        InputStream inputStream;
        ?? randomAccessFile;
        char c2;
        byte[] bArr;
        int i2;
        AndroidRangeTransfer androidRangeTransfer;
        AndroidRangeTransfer.Result resultExecute;
        AndroidRangeTransfer.Outcome outcome;
        String str19 = "bytes=";
        try {
            try {
                prepareFiles();
                long j = this.downloadedBytes.get();
                i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                try {
                    try {
                        if (i == 0) {
                            String hexString = Long.toHexString(this.taskInstanceId);
                            str19 = null;
                            str2 = null;
                            str2 = null;
                            str11 = null;
                            str16 = null;
                            str9 = null;
                            str2 = null;
                            httpURLConnection = null;
                            str19 = null;
                            str2 = null;
                            androidRangeTransfer = new AndroidRangeTransfer(this.request, str, this.tempFile, this.rangeCheckpointFile, this.paused, this.canceled, new AndroidRangeTransfer.ConnectionFactory() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidFileTransfer$$ExternalSyntheticLambda0
                                @Override // com.tapsdk.tapad.internal.runtime.download.AndroidRangeTransfer.ConnectionFactory
                                public final HttpURLConnection open(String str20, String str21, String str22, AndroidRangeTransfer.ConnectionTracker connectionTracker) {
                                    return this.f$0.openConnectionWithRedirects(str20, str21, str22, connectionTracker);
                                }
                            }, new AndroidRangeTransfer.Listener() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidFileTransfer.1
                                @Override // com.tapsdk.tapad.internal.runtime.download.AndroidRangeTransfer.Listener
                                public void onBytesDownloaded(long j2) {
                                    AndroidFileTransfer.this.recordDownloadedBytes(j2);
                                }

                                @Override // com.tapsdk.tapad.internal.runtime.download.AndroidRangeTransfer.Listener
                                public void onConnected() {
                                    AndroidFileTransfer.this.fireStartCallbackOnce();
                                }

                                @Override // com.tapsdk.tapad.internal.runtime.download.AndroidRangeTransfer.Listener
                                public void onPrepared(long j2, long j3, int i3) {
                                    AndroidFileTransfer.this.downloadedBytes.set(j2);
                                    AndroidFileTransfer.this.totalBytes = j3;
                                    AndroidFileTransfer.this.resetSpeedWindow(j2);
                                }
                            }, PROCESS_INSTANCE_TOKEN + ":" + hexString, hexString);
                            this.activeRangeTransfer = androidRangeTransfer;
                            resultExecute = androidRangeTransfer.execute();
                            this.activeRangeTransfer = null;
                            outcome = resultExecute.outcome;
                            if (outcome == AndroidRangeTransfer.Outcome.COMPLETED) {
                                this.downloadedBytes.set(resultExecute.totalBytes);
                                this.totalBytes = resultExecute.totalBytes;
                                return finishDownloadedCandidate();
                            }
                            if (outcome == AndroidRangeTransfer.Outcome.INTERRUPTED) {
                                return false;
                            }
                            r4 = 0;
                            r4 = 0;
                            if (outcome == AndroidRangeTransfer.Outcome.FAILED) {
                                this.lastErrorCode = resultExecute.errorCode;
                                this.lastErrorMessage = resultExecute.errorMessage;
                                return false;
                            }
                            androidRangeTransfer.discardPartialState();
                            r23 = 0;
                            this.downloadedBytes.set(0L);
                            this.totalBytes = -1L;
                            j = 0;
                            str.substring(r4, Math.min(str.length(), 80));
                            if (j > r23) {
                                str18 = "bytes=" + j + "-";
                            } else {
                                str18 = str2;
                            }
                            httpURLConnectionOpenConnectionWithRedirects = openConnectionWithRedirects(str, str18, str2, new AndroidRangeTransfer.ConnectionTracker() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidFileTransfer$$ExternalSyntheticLambda1
                                @Override // com.tapsdk.tapad.internal.runtime.download.AndroidRangeTransfer.ConnectionTracker
                                public final boolean track(HttpURLConnection httpURLConnection5) {
                                    return this.f$0.m270lambda$downloadFromUrl$0$comtapsdktapadinternalruntimedownloadAndroidFileTransfer(httpURLConnection5);
                                }
                            });
                            if (!this.paused.get()) {
                                responseCode = httpURLConnectionOpenConnectionWithRedirects.getResponseCode();
                                fireStartCallbackOnce();
                                if (!AndroidRangeTransfer.hasIdentityEncoding(httpURLConnectionOpenConnectionWithRedirects)) {
                                    this.lastErrorCode = 1007;
                                    this.lastErrorMessage = "Download response used content encoding";
                                    httpURLConnectionOpenConnectionWithRedirects.disconnect();
                                    return r4;
                                }
                                if (responseCode != 200) {
                                    if (responseCode == 206) {
                                        this.lastErrorCode = 1007;
                                        this.lastErrorMessage = "HTTP error: " + responseCode;
                                        httpURLConnectionOpenConnectionWithRedirects.disconnect();
                                        return r4;
                                    }
                                    contentRange = AndroidRangeTransfer.parseContentRange(httpURLConnectionOpenConnectionWithRedirects.getHeaderField(Util.CONTENT_RANGE));
                                    if (contentRange == null) {
                                    }
                                    this.lastErrorCode = 1007;
                                    this.lastErrorMessage = "Mismatched Content-Range for resumed transfer";
                                    httpURLConnectionOpenConnectionWithRedirects.disconnect();
                                    return r4;
                                }
                                this.downloadedBytes.set(r23);
                                this.totalBytes = contentLength(httpURLConnectionOpenConnectionWithRedirects);
                                if (this.totalBytes <= r23) {
                                    this.totalBytes = this.request.getExpectedSize();
                                }
                                inputStream = httpURLConnectionOpenConnectionWithRedirects.getInputStream();
                                randomAccessFile = new RandomAccessFile(this.tempFile, "rw");
                                if (responseCode == 200) {
                                    randomAccessFile.setLength(r23);
                                    randomAccessFile.seek(r23);
                                } else {
                                    randomAccessFile.seek(this.downloadedBytes.get());
                                }
                                bArr = new byte[8192];
                                resetSpeedWindow(this.downloadedBytes.get());
                                while (true) {
                                    i2 = inputStream.read(bArr);
                                    if (i2 != -1) {
                                        randomAccessFile.close();
                                        if (this.totalBytes > r23) {
                                        }
                                        boolean zFinishDownloadedCandidate = finishDownloadedCandidate();
                                        inputStream.close();
                                        httpURLConnectionOpenConnectionWithRedirects.disconnect();
                                        return zFinishDownloadedCandidate;
                                    }
                                    if (this.canceled.get()) {
                                        inputStream.close();
                                        randomAccessFile.close();
                                        httpURLConnectionOpenConnectionWithRedirects.disconnect();
                                        return r4;
                                    }
                                    if (this.paused.get()) {
                                        inputStream.close();
                                        randomAccessFile.close();
                                        httpURLConnectionOpenConnectionWithRedirects.disconnect();
                                        return r4;
                                    }
                                    randomAccessFile.write(bArr, r4, i2);
                                    recordDownloadedBytes(i2);
                                }
                                iOException = e;
                                str14 = str2;
                                r14 = r4;
                                r13 = r23;
                                str8 = httpURLConnectionOpenConnectionWithRedirects;
                                str13 = str2;
                                String str20 = str8;
                                r17 = str14;
                                r18 = str20;
                                r21 = r14;
                                r20 = r13;
                                r19 = str13;
                            }
                            if (httpURLConnectionOpenConnectionWithRedirects != null) {
                                httpURLConnectionOpenConnectionWithRedirects.disconnect();
                                return r4;
                            }
                            return r4;
                            String str21 = str7;
                            r12 = str12;
                            r8 = str21;
                            r10 = r7;
                            r16 = str11;
                            this.lastErrorCode = 1008;
                            this.lastErrorMessage = socketTimeoutException.getMessage();
                            if (r12 != 0) {
                                r12.close();
                            }
                            if (r16 != 0) {
                                r16.close();
                            }
                            if (r8 != 0) {
                                r8.disconnect();
                            }
                            return r10;
                        }
                        try {
                            if (hasRangeCheckpoint()) {
                                String hexString2 = Long.toHexString(this.taskInstanceId);
                                str19 = null;
                                str2 = null;
                                str2 = null;
                                str11 = null;
                                str16 = null;
                                str9 = null;
                                str2 = null;
                                httpURLConnection = null;
                                str19 = null;
                                str2 = null;
                                try {
                                    try {
                                        androidRangeTransfer = new AndroidRangeTransfer(this.request, str, this.tempFile, this.rangeCheckpointFile, this.paused, this.canceled, new AndroidRangeTransfer.ConnectionFactory() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidFileTransfer$$ExternalSyntheticLambda0
                                            @Override // com.tapsdk.tapad.internal.runtime.download.AndroidRangeTransfer.ConnectionFactory
                                            public final HttpURLConnection open(String str22, String str23, String str24, AndroidRangeTransfer.ConnectionTracker connectionTracker) {
                                                return this.f$0.openConnectionWithRedirects(str22, str23, str24, connectionTracker);
                                            }
                                        }, new AndroidRangeTransfer.Listener() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidFileTransfer.1
                                            @Override // com.tapsdk.tapad.internal.runtime.download.AndroidRangeTransfer.Listener
                                            public void onBytesDownloaded(long j2) {
                                                AndroidFileTransfer.this.recordDownloadedBytes(j2);
                                            }

                                            @Override // com.tapsdk.tapad.internal.runtime.download.AndroidRangeTransfer.Listener
                                            public void onConnected() {
                                                AndroidFileTransfer.this.fireStartCallbackOnce();
                                            }

                                            @Override // com.tapsdk.tapad.internal.runtime.download.AndroidRangeTransfer.Listener
                                            public void onPrepared(long j2, long j3, int i3) {
                                                AndroidFileTransfer.this.downloadedBytes.set(j2);
                                                AndroidFileTransfer.this.totalBytes = j3;
                                                AndroidFileTransfer.this.resetSpeedWindow(j2);
                                            }
                                        }, PROCESS_INSTANCE_TOKEN + ":" + hexString2, hexString2);
                                        this.activeRangeTransfer = androidRangeTransfer;
                                        try {
                                            resultExecute = androidRangeTransfer.execute();
                                            this.activeRangeTransfer = null;
                                            outcome = resultExecute.outcome;
                                            if (outcome == AndroidRangeTransfer.Outcome.COMPLETED) {
                                                try {
                                                    this.downloadedBytes.set(resultExecute.totalBytes);
                                                    this.totalBytes = resultExecute.totalBytes;
                                                    return finishDownloadedCandidate();
                                                } catch (SocketTimeoutException e) {
                                                    socketTimeoutException = e;
                                                    str12 = null;
                                                    str7 = null;
                                                    r7 = 0;
                                                } catch (IOException e2) {
                                                    iOException = e2;
                                                    str17 = null;
                                                    str15 = null;
                                                    r22 = 0;
                                                    r13 = 1006;
                                                    str14 = str17;
                                                    r14 = r22;
                                                    str8 = str15;
                                                    str13 = str16;
                                                    String str22 = str8;
                                                    r17 = str14;
                                                    r18 = str22;
                                                    r21 = r14;
                                                    r20 = r13;
                                                    r19 = str13;
                                                    this.lastErrorCode = r20;
                                                    this.lastErrorMessage = iOException.getMessage();
                                                    if (r17 != 0) {
                                                        try {
                                                            r17.close();
                                                        } catch (Exception e3) {
                                                        }
                                                    }
                                                    if (r19 != 0) {
                                                        try {
                                                            r19.close();
                                                        } catch (Exception e4) {
                                                        }
                                                    }
                                                    if (r18 != 0) {
                                                        try {
                                                            r18.disconnect();
                                                        } catch (Exception e5) {
                                                        }
                                                    }
                                                    return r21;
                                                } catch (Exception e6) {
                                                    exc = e6;
                                                    str10 = null;
                                                    str6 = null;
                                                    r5 = 0;
                                                    String str23 = str6;
                                                    r11 = str10;
                                                    r6 = str23;
                                                    r9 = r5;
                                                    r15 = str9;
                                                    this.lastErrorCode = DownloadUtils.ErrorCode.ERROR_UNKNOWN;
                                                    this.lastErrorMessage = exc.getMessage();
                                                    if (r11 != 0) {
                                                        try {
                                                            r11.close();
                                                        } catch (Exception e7) {
                                                        }
                                                    }
                                                    if (r15 != 0) {
                                                        try {
                                                            r15.close();
                                                        } catch (Exception e8) {
                                                        }
                                                    }
                                                    if (r6 != 0) {
                                                        try {
                                                            r6.disconnect();
                                                        } catch (Exception e9) {
                                                        }
                                                    }
                                                    return r9;
                                                }
                                            } else {
                                                if (outcome == AndroidRangeTransfer.Outcome.INTERRUPTED) {
                                                    return false;
                                                }
                                                r4 = 0;
                                                r4 = 0;
                                                try {
                                                    if (outcome == AndroidRangeTransfer.Outcome.FAILED) {
                                                        this.lastErrorCode = resultExecute.errorCode;
                                                        this.lastErrorMessage = resultExecute.errorMessage;
                                                        return false;
                                                    }
                                                    androidRangeTransfer.discardPartialState();
                                                    r23 = 0;
                                                    this.downloadedBytes.set(0L);
                                                    this.totalBytes = -1L;
                                                    j = 0;
                                                } catch (IOException e10) {
                                                    e = e10;
                                                    c = 1006;
                                                    iOException = e;
                                                    String str24 = str2;
                                                    str8 = str24;
                                                    str14 = str24;
                                                    r14 = r4;
                                                    r13 = c;
                                                    str13 = str2;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            r4 = 0;
                                            c = 1006;
                                            try {
                                                this.activeRangeTransfer = null;
                                                throw th2;
                                            } catch (IOException e11) {
                                                e = e11;
                                                iOException = e;
                                                String str25 = str2;
                                                str8 = str25;
                                                str14 = str25;
                                                r14 = r4;
                                                r13 = c;
                                                str13 = str2;
                                                String str26 = str8;
                                                r17 = str14;
                                                r18 = str26;
                                                r21 = r14;
                                                r20 = r13;
                                                r19 = str13;
                                                this.lastErrorCode = r20;
                                                this.lastErrorMessage = iOException.getMessage();
                                                if (r17 != 0) {
                                                    r17.close();
                                                }
                                                if (r19 != 0) {
                                                    r19.close();
                                                }
                                                if (r18 != 0) {
                                                    r18.disconnect();
                                                }
                                                return r21;
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        th = th;
                                        HttpURLConnection httpURLConnection5 = httpURLConnection;
                                        httpURLConnection3 = httpURLConnection5;
                                        str4 = httpURLConnection5;
                                        str5 = httpURLConnection;
                                        r3 = str4;
                                        r2 = str5;
                                        httpURLConnection4 = httpURLConnection3;
                                        if (r2 != 0) {
                                            try {
                                                r2.close();
                                            } catch (Exception e12) {
                                            }
                                        }
                                        if (r3 != 0) {
                                            try {
                                                r3.close();
                                            } catch (Exception e13) {
                                            }
                                        }
                                        if (httpURLConnection4 != null) {
                                            throw th;
                                        }
                                        try {
                                            httpURLConnection4.disconnect();
                                            throw th;
                                        } catch (Exception e14) {
                                            throw th;
                                        }
                                    }
                                } catch (SocketTimeoutException e15) {
                                    e = e15;
                                    i = 0;
                                    socketTimeoutException = e;
                                    String str27 = str19;
                                    str7 = str27;
                                    str12 = str27;
                                    r7 = i;
                                    str11 = str19;
                                } catch (IOException e16) {
                                    e = e16;
                                    r4 = 0;
                                    c = 1006;
                                    iOException = e;
                                    String str28 = str2;
                                    str8 = str28;
                                    str14 = str28;
                                    r14 = r4;
                                    r13 = c;
                                    str13 = str2;
                                    String str29 = str8;
                                    r17 = str14;
                                    r18 = str29;
                                    r21 = r14;
                                    r20 = r13;
                                    r19 = str13;
                                    this.lastErrorCode = r20;
                                    this.lastErrorMessage = iOException.getMessage();
                                    if (r17 != 0) {
                                        r17.close();
                                    }
                                    if (r19 != 0) {
                                        r19.close();
                                    }
                                    if (r18 != 0) {
                                        r18.disconnect();
                                    }
                                    return r21;
                                } catch (Exception e17) {
                                    e = e17;
                                    i = 0;
                                    exc = e;
                                    String str30 = str19;
                                    str6 = str30;
                                    str10 = str30;
                                    r5 = i;
                                    str9 = str19;
                                    String str210 = str6;
                                    r11 = str10;
                                    r6 = str210;
                                    r9 = r5;
                                    r15 = str9;
                                    this.lastErrorCode = DownloadUtils.ErrorCode.ERROR_UNKNOWN;
                                    this.lastErrorMessage = exc.getMessage();
                                    if (r11 != 0) {
                                        r11.close();
                                    }
                                    if (r15 != 0) {
                                        r15.close();
                                    }
                                    if (r6 != 0) {
                                        r6.disconnect();
                                    }
                                    return r9;
                                }
                                String str211 = str7;
                                r12 = str12;
                                r8 = str211;
                                r10 = r7;
                                r16 = str11;
                                this.lastErrorCode = 1008;
                                this.lastErrorMessage = socketTimeoutException.getMessage();
                                if (r12 != 0) {
                                    try {
                                        r12.close();
                                    } catch (Exception e18) {
                                    }
                                }
                                if (r16 != 0) {
                                    try {
                                        r16.close();
                                    } catch (Exception e19) {
                                    }
                                }
                                if (r8 != 0) {
                                    try {
                                        r8.disconnect();
                                    } catch (Exception e20) {
                                    }
                                }
                                return r10;
                            }
                            r23 = 0;
                            r4 = 0;
                            str2 = null;
                            str.substring(r4, Math.min(str.length(), 80));
                            if (j > r23) {
                                str18 = "bytes=" + j + "-";
                            } else {
                                str18 = str2;
                            }
                            httpURLConnectionOpenConnectionWithRedirects = openConnectionWithRedirects(str, str18, str2, new AndroidRangeTransfer.ConnectionTracker() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidFileTransfer$$ExternalSyntheticLambda1
                                @Override // com.tapsdk.tapad.internal.runtime.download.AndroidRangeTransfer.ConnectionTracker
                                public final boolean track(HttpURLConnection httpURLConnection6) {
                                    return this.f$0.m270lambda$downloadFromUrl$0$comtapsdktapadinternalruntimedownloadAndroidFileTransfer(httpURLConnection6);
                                }
                            });
                            try {
                                try {
                                    if (!this.paused.get() && !this.canceled.get()) {
                                        responseCode = httpURLConnectionOpenConnectionWithRedirects.getResponseCode();
                                        fireStartCallbackOnce();
                                        try {
                                            if (!AndroidRangeTransfer.hasIdentityEncoding(httpURLConnectionOpenConnectionWithRedirects)) {
                                                this.lastErrorCode = 1007;
                                                this.lastErrorMessage = "Download response used content encoding";
                                                try {
                                                    httpURLConnectionOpenConnectionWithRedirects.disconnect();
                                                    return r4;
                                                } catch (Exception e21) {
                                                    return r4;
                                                }
                                            }
                                            if (responseCode != 200) {
                                                this.downloadedBytes.set(r23);
                                                this.totalBytes = contentLength(httpURLConnectionOpenConnectionWithRedirects);
                                            } else {
                                                try {
                                                    if (responseCode == 206) {
                                                        this.lastErrorCode = 1007;
                                                        this.lastErrorMessage = "HTTP error: " + responseCode;
                                                        try {
                                                            httpURLConnectionOpenConnectionWithRedirects.disconnect();
                                                            return r4;
                                                        } catch (Exception e22) {
                                                            return r4;
                                                        }
                                                    }
                                                    contentRange = AndroidRangeTransfer.parseContentRange(httpURLConnectionOpenConnectionWithRedirects.getHeaderField(Util.CONTENT_RANGE));
                                                    if (contentRange == null && contentRange.start == j) {
                                                        long j2 = contentRange.end;
                                                        long j3 = contentRange.total;
                                                        if (j2 == j3 - 1) {
                                                            this.totalBytes = j3;
                                                            long jContentLength = contentLength(httpURLConnectionOpenConnectionWithRedirects);
                                                            if (jContentLength > r23 && jContentLength != this.totalBytes - j) {
                                                                this.lastErrorCode = 1007;
                                                                this.lastErrorMessage = "Mismatched Content-Length for resumed transfer";
                                                                try {
                                                                    httpURLConnectionOpenConnectionWithRedirects.disconnect();
                                                                    return r4;
                                                                } catch (Exception e23) {
                                                                    return r4;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    this.lastErrorCode = 1007;
                                                    this.lastErrorMessage = "Mismatched Content-Range for resumed transfer";
                                                    try {
                                                        httpURLConnectionOpenConnectionWithRedirects.disconnect();
                                                        return r4;
                                                    } catch (Exception e24) {
                                                        return r4;
                                                    }
                                                } catch (IOException e25) {
                                                    e = e25;
                                                    iOException = e;
                                                    str14 = str2;
                                                    r14 = r4;
                                                    r13 = r23;
                                                    str8 = httpURLConnectionOpenConnectionWithRedirects;
                                                    str13 = str2;
                                                }
                                            }
                                            if (this.totalBytes <= r23 && this.request.getExpectedSize() > r23) {
                                                this.totalBytes = this.request.getExpectedSize();
                                            }
                                            inputStream = httpURLConnectionOpenConnectionWithRedirects.getInputStream();
                                            try {
                                                try {
                                                    randomAccessFile = new RandomAccessFile(this.tempFile, "rw");
                                                    try {
                                                        if (responseCode == 200) {
                                                            try {
                                                                randomAccessFile.setLength(r23);
                                                                randomAccessFile.seek(r23);
                                                            } catch (IOException e26) {
                                                                iOException = e26;
                                                                c2 = 1006;
                                                                r19 = randomAccessFile;
                                                                r17 = inputStream;
                                                                r18 = httpURLConnectionOpenConnectionWithRedirects;
                                                                r21 = r4;
                                                                r20 = c2;
                                                                this.lastErrorCode = r20;
                                                                this.lastErrorMessage = iOException.getMessage();
                                                                if (r17 != 0) {
                                                                    r17.close();
                                                                }
                                                                if (r19 != 0) {
                                                                    r19.close();
                                                                }
                                                                if (r18 != 0) {
                                                                    r18.disconnect();
                                                                }
                                                                return r21;
                                                            }
                                                        } else {
                                                            try {
                                                                randomAccessFile.seek(this.downloadedBytes.get());
                                                            } catch (IOException e27) {
                                                                c2 = 1006;
                                                                iOException = e27;
                                                                r19 = randomAccessFile;
                                                                r17 = inputStream;
                                                                r18 = httpURLConnectionOpenConnectionWithRedirects;
                                                                r21 = r4;
                                                                r20 = c2;
                                                                this.lastErrorCode = r20;
                                                                this.lastErrorMessage = iOException.getMessage();
                                                                if (r17 != 0) {
                                                                    r17.close();
                                                                }
                                                                if (r19 != 0) {
                                                                    r19.close();
                                                                }
                                                                if (r18 != 0) {
                                                                    r18.disconnect();
                                                                }
                                                                return r21;
                                                            }
                                                        }
                                                        bArr = new byte[8192];
                                                        resetSpeedWindow(this.downloadedBytes.get());
                                                        while (true) {
                                                            i2 = inputStream.read(bArr);
                                                            if (i2 != -1) {
                                                                randomAccessFile.close();
                                                                try {
                                                                    if (this.totalBytes > r23 || this.downloadedBytes.get() == this.totalBytes) {
                                                                        boolean zFinishDownloadedCandidate2 = finishDownloadedCandidate();
                                                                        try {
                                                                            inputStream.close();
                                                                        } catch (Exception e28) {
                                                                        }
                                                                        try {
                                                                            httpURLConnectionOpenConnectionWithRedirects.disconnect();
                                                                        } catch (Exception e29) {
                                                                        }
                                                                        return zFinishDownloadedCandidate2;
                                                                    }
                                                                    this.lastErrorCode = 1006;
                                                                    this.lastErrorMessage = "Download ended before the declared representation length";
                                                                    try {
                                                                        inputStream.close();
                                                                    } catch (Exception e30) {
                                                                    }
                                                                    try {
                                                                        httpURLConnectionOpenConnectionWithRedirects.disconnect();
                                                                    } catch (Exception e31) {
                                                                    }
                                                                    return r4;
                                                                } catch (IOException e32) {
                                                                    e = e32;
                                                                    iOException = e;
                                                                    str14 = inputStream;
                                                                    r14 = r4;
                                                                    r13 = r23;
                                                                    str8 = httpURLConnectionOpenConnectionWithRedirects;
                                                                    str13 = str2;
                                                                    String str212 = str8;
                                                                    r17 = str14;
                                                                    r18 = str212;
                                                                    r21 = r14;
                                                                    r20 = r13;
                                                                    r19 = str13;
                                                                    this.lastErrorCode = r20;
                                                                    this.lastErrorMessage = iOException.getMessage();
                                                                    if (r17 != 0) {
                                                                        r17.close();
                                                                    }
                                                                    if (r19 != 0) {
                                                                        r19.close();
                                                                    }
                                                                    if (r18 != 0) {
                                                                        r18.disconnect();
                                                                    }
                                                                    return r21;
                                                                }
                                                            }
                                                            if (this.canceled.get()) {
                                                                try {
                                                                    inputStream.close();
                                                                } catch (Exception e33) {
                                                                }
                                                                try {
                                                                    randomAccessFile.close();
                                                                } catch (Exception e34) {
                                                                }
                                                                try {
                                                                    httpURLConnectionOpenConnectionWithRedirects.disconnect();
                                                                } catch (Exception e35) {
                                                                }
                                                                return r4;
                                                            }
                                                            if (this.paused.get()) {
                                                                try {
                                                                    inputStream.close();
                                                                } catch (Exception e36) {
                                                                }
                                                                try {
                                                                    randomAccessFile.close();
                                                                } catch (Exception e37) {
                                                                }
                                                                try {
                                                                    httpURLConnectionOpenConnectionWithRedirects.disconnect();
                                                                } catch (Exception e38) {
                                                                }
                                                                return r4;
                                                            }
                                                            randomAccessFile.write(bArr, r4, i2);
                                                            recordDownloadedBytes(i2);
                                                        }
                                                    } catch (SocketTimeoutException e39) {
                                                        socketTimeoutException = e39;
                                                        r16 = randomAccessFile;
                                                        r12 = inputStream;
                                                        r8 = httpURLConnectionOpenConnectionWithRedirects;
                                                        r10 = r4;
                                                    } catch (Exception e40) {
                                                        exc = e40;
                                                        r15 = randomAccessFile;
                                                        r11 = inputStream;
                                                        r6 = httpURLConnectionOpenConnectionWithRedirects;
                                                        r9 = r4;
                                                        this.lastErrorCode = DownloadUtils.ErrorCode.ERROR_UNKNOWN;
                                                        this.lastErrorMessage = exc.getMessage();
                                                        if (r11 != 0) {
                                                            r11.close();
                                                        }
                                                        if (r15 != 0) {
                                                            r15.close();
                                                        }
                                                        if (r6 != 0) {
                                                            r6.disconnect();
                                                        }
                                                        return r9;
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                        r2 = inputStream;
                                                        r3 = randomAccessFile;
                                                        httpURLConnection4 = httpURLConnectionOpenConnectionWithRedirects;
                                                        if (r2 != 0) {
                                                            r2.close();
                                                        }
                                                        if (r3 != 0) {
                                                            r3.close();
                                                        }
                                                        if (httpURLConnection4 != null) {
                                                            throw th;
                                                        }
                                                        httpURLConnection4.disconnect();
                                                        throw th;
                                                    }
                                                } catch (IOException e41) {
                                                    e = e41;
                                                    r23 = 1006;
                                                }
                                            } catch (SocketTimeoutException e42) {
                                                socketTimeoutException = e42;
                                                str12 = inputStream;
                                                r7 = r4;
                                                str7 = httpURLConnectionOpenConnectionWithRedirects;
                                                str11 = str2;
                                                String str213 = str7;
                                                r12 = str12;
                                                r8 = str213;
                                                r10 = r7;
                                                r16 = str11;
                                            } catch (Exception e43) {
                                                exc = e43;
                                                str10 = inputStream;
                                                r5 = r4;
                                                str6 = httpURLConnectionOpenConnectionWithRedirects;
                                                str9 = str2;
                                                String str214 = str6;
                                                r11 = str10;
                                                r6 = str214;
                                                r9 = r5;
                                                r15 = str9;
                                                this.lastErrorCode = DownloadUtils.ErrorCode.ERROR_UNKNOWN;
                                                this.lastErrorMessage = exc.getMessage();
                                                if (r11 != 0) {
                                                    r11.close();
                                                }
                                                if (r15 != 0) {
                                                    r15.close();
                                                }
                                                if (r6 != 0) {
                                                    r6.disconnect();
                                                }
                                                return r9;
                                            } catch (Throwable th5) {
                                                th = th5;
                                                String str31 = str2;
                                                str5 = inputStream;
                                                str4 = str31;
                                                httpURLConnection3 = httpURLConnectionOpenConnectionWithRedirects;
                                                r3 = str4;
                                                r2 = str5;
                                                httpURLConnection4 = httpURLConnection3;
                                                if (r2 != 0) {
                                                    r2.close();
                                                }
                                                if (r3 != 0) {
                                                    r3.close();
                                                }
                                                if (httpURLConnection4 != null) {
                                                    throw th;
                                                }
                                                httpURLConnection4.disconnect();
                                                throw th;
                                            }
                                        } catch (IOException e44) {
                                            iOException = e44;
                                            str17 = str2;
                                            r22 = r4;
                                            str15 = httpURLConnectionOpenConnectionWithRedirects;
                                            str16 = str2;
                                            r13 = 1006;
                                            str14 = str17;
                                            r14 = r22;
                                            str8 = str15;
                                            str13 = str16;
                                        }
                                        iOException = e;
                                        str14 = str2;
                                        r14 = r4;
                                        r13 = r23;
                                        str8 = httpURLConnectionOpenConnectionWithRedirects;
                                        str13 = str2;
                                        String str215 = str8;
                                        r17 = str14;
                                        r18 = str215;
                                        r21 = r14;
                                        r20 = r13;
                                        r19 = str13;
                                    }
                                    if (httpURLConnectionOpenConnectionWithRedirects != null) {
                                        try {
                                            httpURLConnectionOpenConnectionWithRedirects.disconnect();
                                            return r4;
                                        } catch (Exception e45) {
                                        }
                                    }
                                    return r4;
                                } catch (IOException e46) {
                                    e = e46;
                                    r23 = 1006;
                                }
                            } catch (SocketTimeoutException e47) {
                                socketTimeoutException = e47;
                                str12 = str2;
                                r7 = r4;
                                str7 = httpURLConnectionOpenConnectionWithRedirects;
                                str11 = str2;
                            } catch (Exception e48) {
                                exc = e48;
                                str10 = str2;
                                r5 = r4;
                                str6 = httpURLConnectionOpenConnectionWithRedirects;
                                str9 = str2;
                            } catch (Throwable th6) {
                                th = th6;
                                str4 = str2;
                                httpURLConnection3 = httpURLConnectionOpenConnectionWithRedirects;
                                str5 = str2;
                            }
                        } catch (SocketTimeoutException e49) {
                            socketTimeoutException = e49;
                            str12 = null;
                            r7 = 0;
                            str7 = null;
                            str11 = null;
                        } catch (IOException e50) {
                            iOException = e50;
                            str14 = null;
                            r14 = 0;
                            r13 = 1006;
                            str8 = null;
                            str13 = null;
                        } catch (Exception e51) {
                            exc = e51;
                            str10 = null;
                            r5 = 0;
                            str6 = null;
                            str9 = null;
                            String str216 = str6;
                            r11 = str10;
                            r6 = str216;
                            r9 = r5;
                            r15 = str9;
                            this.lastErrorCode = DownloadUtils.ErrorCode.ERROR_UNKNOWN;
                            this.lastErrorMessage = exc.getMessage();
                            if (r11 != 0) {
                                r11.close();
                            }
                            if (r15 != 0) {
                                r15.close();
                            }
                            if (r6 != 0) {
                                r6.disconnect();
                            }
                            return r9;
                        } catch (Throwable th7) {
                            th = th7;
                            str4 = null;
                            httpURLConnection3 = null;
                            str5 = null;
                            r3 = str4;
                            r2 = str5;
                            httpURLConnection4 = httpURLConnection3;
                            if (r2 != 0) {
                                r2.close();
                            }
                            if (r3 != 0) {
                                r3.close();
                            }
                            if (httpURLConnection4 != null) {
                                throw th;
                            }
                            httpURLConnection4.disconnect();
                            throw th;
                        }
                    } catch (IOException e52) {
                        iOException = e52;
                        String str32 = "bytes=";
                        str15 = str32;
                        str17 = str32;
                        r22 = i;
                        str16 = str19;
                    }
                } catch (SocketTimeoutException e53) {
                    e = e53;
                } catch (Exception e54) {
                    e = e54;
                }
            } catch (Throwable th8) {
                th = th8;
                httpURLConnection3 = httpURLConnection2;
                str4 = "bytes=";
                str5 = str3;
            }
        } catch (SocketTimeoutException e55) {
            e = e55;
            i = 0;
            str19 = null;
        } catch (IOException e56) {
            e = e56;
            r4 = 0;
            c = 1006;
            str2 = null;
        } catch (Exception e57) {
            e = e57;
            i = 0;
            str19 = null;
        } catch (Throwable th9) {
            th = th9;
            httpURLConnection = null;
        }
        this.lastErrorCode = r20;
        this.lastErrorMessage = iOException.getMessage();
        if (r17 != 0) {
            r17.close();
        }
        if (r19 != 0) {
            r19.close();
        }
        if (r18 != 0) {
            r18.disconnect();
        }
        return r21;
    }

    private boolean finishDownloadedCandidate() {
        if (!validateDownloadedCandidate()) {
            return false;
        }
        synchronized (this.lifecycleLock) {
            if (!this.canceled.get() && !this.paused.get()) {
                if (this.tempFile.renameTo(this.targetFile)) {
                    deleteRangeCheckpoint();
                    this.state = State.COMPLETED;
                    return true;
                }
                if (!DownloadUtils.copyFile(this.tempFile, this.targetFile)) {
                    this.lastErrorCode = 1006;
                    this.lastErrorMessage = "Failed to commit downloaded file";
                    return false;
                }
                this.tempFile.delete();
                deleteRangeCheckpoint();
                this.state = State.COMPLETED;
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireStartCallbackOnce() {
        if (this.callback == null || !this.startCallbackFired.compareAndSet(false, true)) {
            return;
        }
        this.callback.onStart(this);
    }

    private boolean hasRangeCheckpoint() {
        File file = this.rangeCheckpointFile;
        if (file != null) {
            return file.isFile() || new File(new StringBuilder().append(this.rangeCheckpointFile.getPath()).append(".new").toString()).isFile();
        }
        return false;
    }

    private static boolean isRedirect(int i) {
        return i == 301 || i == 302 || i == 303 || i == 307 || i == 308;
    }

    private static boolean isTransferControlledHeader(String str) {
        if (str != null) {
            return Util.RANGE.equalsIgnoreCase(str) || "If-Range".equalsIgnoreCase(str) || "Accept-Encoding".equalsIgnoreCase(str);
        }
        return false;
    }

    private static boolean isTransientFailure(int i) {
        return i == 1008 || i == 1006 || i == 1099;
    }

    private int nextValidUrlIndex(int i, int i2) {
        for (int iMax = Math.max(0, i); iMax < i2; iMax++) {
            if (this.request.isUrlValidAt(iMax, System.currentTimeMillis() / 1000)) {
                return iMax;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpURLConnection openConnectionWithRedirects(String str, String str2, String str3, AndroidRangeTransfer.ConnectionTracker connectionTracker) throws IOException {
        URL url = new URL(str);
        HashSet hashSet = new HashSet();
        URL url2 = url;
        int i = 0;
        while (!this.paused.get() && !this.canceled.get()) {
            String protocol = url2.getProtocol();
            if (!"http".equalsIgnoreCase(protocol) && !BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(protocol)) {
                throw new ProtocolException(c.a("Unsupported download URL scheme: ", protocol));
            }
            if (!hashSet.add(url2.toExternalForm())) {
                throw new ProtocolException("Download redirect loop");
            }
            HttpURLConnection httpURLConnectionOpenConnection = SecureConnectionUtil.openConnection(url2);
            httpURLConnectionOpenConnection.setInstanceFollowRedirects(false);
            httpURLConnectionOpenConnection.setConnectTimeout(this.request.getConnectTimeout());
            httpURLConnectionOpenConnection.setReadTimeout(this.request.getReadTimeout());
            Map<String, List<String>> headers = this.request.getHeaders();
            if (headers != null) {
                for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                    if (!isTransferControlledHeader(entry.getKey())) {
                        Iterator<String> it = entry.getValue().iterator();
                        while (it.hasNext()) {
                            httpURLConnectionOpenConnection.addRequestProperty(entry.getKey(), it.next());
                        }
                    }
                }
            }
            httpURLConnectionOpenConnection.setRequestProperty("Accept-Encoding", "identity");
            if (str2 != null && !str2.isEmpty()) {
                httpURLConnectionOpenConnection.setRequestProperty(Util.RANGE, str2);
            }
            if (str3 != null && !str3.isEmpty()) {
                httpURLConnectionOpenConnection.setRequestProperty("If-Range", str3);
            }
            if (!connectionTracker.track(httpURLConnectionOpenConnection)) {
                httpURLConnectionOpenConnection.disconnect();
                throw new IOException("Download interrupted");
            }
            httpURLConnectionOpenConnection.connect();
            if (!isRedirect(httpURLConnectionOpenConnection.getResponseCode())) {
                return httpURLConnectionOpenConnection;
            }
            String headerField = httpURLConnectionOpenConnection.getHeaderField("Location");
            try {
                httpURLConnectionOpenConnection.getInputStream().close();
            } catch (Exception e) {
            }
            httpURLConnectionOpenConnection.disconnect();
            i++;
            if (i > 10) {
                throw new ProtocolException(b.a("Too many redirects: ", i));
            }
            if (headerField == null || headerField.isEmpty()) {
                throw new IOException("Redirect without Location header");
            }
            headerField.substring(0, Math.min(headerField.length(), 80));
            URL url3 = new URL(url2, headerField);
            String protocol2 = url3.getProtocol();
            if (!"http".equalsIgnoreCase(protocol2) && !BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(protocol2)) {
                throw new ProtocolException(c.a("Unsupported download redirect scheme: ", protocol2));
            }
            if (BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(url2.getProtocol()) && !BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(protocol2)) {
                throw new ProtocolException("Download redirect downgraded transport security");
            }
            url2 = url3;
        }
        throw new IOException("Download interrupted");
    }

    private void prepareFiles() throws IOException {
        File parentFile;
        String targetDirectory = this.request.getTargetDirectory();
        if (targetDirectory == null || targetDirectory.isEmpty()) {
            File file = this.tempFile;
            parentFile = file != null ? file.getParentFile() : null;
            if (parentFile == null) {
                throw new IllegalStateException("Target directory not set");
            }
        } else {
            parentFile = new File(targetDirectory);
        }
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Unable to create target directory");
        }
        File canonicalFile = parentFile.getCanonicalFile();
        String fileName = this.request.getFileName();
        if (fileName == null || fileName.isEmpty()) {
            fileName = DownloadUtils.extractFileName(this.request.getPrimaryUrl());
        }
        this.targetFile = new File(canonicalFile, fileName).getCanonicalFile();
        this.tempFile = new File(canonicalFile, temporaryFileName(fileName)).getCanonicalFile();
        this.rangeCheckpointFile = new File(canonicalFile, this.tempFile.getName() + ".ranges").getCanonicalFile();
        if (!canonicalFile.equals(this.targetFile.getParentFile()) || !canonicalFile.equals(this.tempFile.getParentFile()) || !canonicalFile.equals(this.rangeCheckpointFile.getParentFile())) {
            throw new IOException("Unsafe target file name");
        }
        if (this.request.isResumable() && this.tempFile.exists()) {
            this.downloadedBytes.set(hasRangeCheckpoint() ? 0L : this.tempFile.length());
            return;
        }
        this.downloadedBytes.set(0L);
        if (!deleteOrTruncateTempFile()) {
            throw new IllegalStateException("Unable to clear non-resumable partial download");
        }
    }

    private void prepareResumeLocked() {
        this.resumeRequested = false;
        this.paused.set(false);
        if (!this.request.isResumable()) {
            this.currentUrlIndex.set(0);
            resetPartialDownloadForMirrorSwitch();
        }
        this.state = State.IDLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordDownloadedBytes(long j) {
        long jAddAndGet = this.downloadedBytes.addAndGet(j);
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.progressCallbackLock) {
            if (jCurrentTimeMillis - this.lastProgressCallbackTime < 200) {
                return;
            }
            this.lastProgressCallbackTime = jCurrentTimeMillis;
            long j2 = jCurrentTimeMillis - this.speedStartTime;
            if (j2 > 0) {
                this.currentSpeed = (Math.max(0L, jAddAndGet - this.speedStartBytes) * 1000) / j2;
            }
            float fMin = this.totalBytes > 0 ? Math.min(1.0f, jAddAndGet / this.totalBytes) : 0.0f;
            Callback callback = this.callback;
            if (callback != null) {
                callback.onProgress(this, fMin, jAddAndGet, this.totalBytes, this.currentSpeed);
            }
        }
    }

    private boolean rejectDownloadedCandidate(int i, String str) {
        this.lastErrorCode = i;
        this.lastErrorMessage = str;
        this.downloadedBytes.set(0L);
        this.totalBytes = -1L;
        if (deleteOrTruncateTempFile()) {
            return false;
        }
        this.lastErrorCode = 1006;
        this.lastErrorMessage = "Failed to remove invalid partial download";
        return false;
    }

    private void requestStop() {
        AndroidRangeTransfer androidRangeTransfer = this.activeRangeTransfer;
        if (androidRangeTransfer != null) {
            androidRangeTransfer.requestStop();
        }
        Thread thread = this.workerThread;
        if (thread == null || thread == Thread.currentThread()) {
            return;
        }
        thread.interrupt();
    }

    private boolean resetPartialDownloadForMirrorSwitch() {
        this.downloadedBytes.set(0L);
        this.totalBytes = -1L;
        this.currentSpeed = 0L;
        this.speedStartTime = 0L;
        this.speedStartBytes = 0L;
        this.lastProgressCallbackTime = 0L;
        if (deleteOrTruncateTempFile()) {
            return true;
        }
        this.lastErrorCode = 1006;
        this.lastErrorMessage = "Failed to reset partial download before mirror fallback";
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetSpeedWindow(long j) {
        synchronized (this.progressCallbackLock) {
            this.speedStartTime = System.currentTimeMillis();
            this.speedStartBytes = j;
            this.lastProgressCallbackTime = 0L;
            this.currentSpeed = 0L;
        }
    }

    private String temporaryFileName(String str) {
        return this.request.isResumable() ? a.a(str, ".tmp") : str + this.nonResumableTempSuffix + ".tmp";
    }

    private boolean validateDownloadedCandidate() {
        int iValidateFile = DownloadUtils.validateFile(this.request, this.tempFile);
        if (iValidateFile == 0) {
            return true;
        }
        return rejectDownloadedCandidate(iValidateFile, iValidateFile == 1005 ? "MD5 verification failed" : "APK size verification failed");
    }

    public boolean canAttach() {
        State state = this.state;
        return (this.canceled.get() || state == State.COMPLETED || state == State.FAILED || state == State.CANCELED) ? false : true;
    }

    public void cancel() {
        synchronized (this.lifecycleLock) {
            if (this.state != State.COMPLETED && this.state != State.FAILED) {
                State state = this.state;
                State state2 = State.CANCELED;
                if (state != state2) {
                    this.canceled.set(true);
                    this.resumeRequested = false;
                    this.state = state2;
                    boolean z = this.workerRunning;
                    requestStop();
                    if (z) {
                        return;
                    }
                    if (!this.request.isResumable()) {
                        deleteOrTruncateTempFile();
                    }
                    Callback callback = this.callback;
                    if (callback != null) {
                        callback.onCanceled(this);
                    }
                }
            }
        }
    }

    public boolean completePauseCallbackAndConsumePendingResume() {
        synchronized (this.lifecycleLock) {
            this.pauseCallbackPending = false;
            if (!this.workerRunning && this.resumeRequested && !this.canceled.get() && this.state == State.PAUSED) {
                prepareResumeLocked();
                return true;
            }
            return false;
        }
    }

    public void discardPartialFile() {
        synchronized (this.lifecycleLock) {
            if (this.workerRunning) {
                return;
            }
            deleteOrTruncateTempFile();
        }
    }

    public long getDownloadedBytes() {
        return this.downloadedBytes.get();
    }

    public float getProgress() {
        if (this.totalBytes <= 0) {
            return 0.0f;
        }
        return this.downloadedBytes.get() / this.totalBytes;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public boolean isPausedOrPausing() {
        if (this.canceled.get()) {
            return false;
        }
        return this.paused.get() || this.state == State.PAUSED;
    }

    /* JADX INFO: renamed from: lambda$downloadFromUrl$0$com-tapsdk-tapad-internal-runtime-download-AndroidFileTransfer, reason: not valid java name */
    /* synthetic */ boolean m270lambda$downloadFromUrl$0$comtapsdktapadinternalruntimedownloadAndroidFileTransfer(HttpURLConnection httpURLConnection) {
        return (this.paused.get() || this.canceled.get()) ? false : true;
    }

    public void pause() {
        boolean z;
        synchronized (this.lifecycleLock) {
            z = true;
            if (this.state != State.RUNNING || this.canceled.get()) {
                z = false;
            } else {
                this.paused.set(true);
                this.resumeRequested = false;
            }
        }
        if (z) {
            requestStop();
        }
    }

    public boolean requestResume() {
        synchronized (this.lifecycleLock) {
            if (!this.canceled.get() && this.state != State.COMPLETED && this.state != State.FAILED && this.state != State.CANCELED) {
                this.resumeRequested = true;
                if (this.workerRunning || this.state != State.PAUSED || this.pauseCallbackPending) {
                    return false;
                }
                prepareResumeLocked();
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:122:0x0063 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:0x00e6 A[EDGE_INSN: B:129:0x00e6->B:59:0x00e6 BREAK  A[LOOP:0: B:12:0x0027->B:130:0x0027], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x0027 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x0061 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x006a  */
    @Override // java.lang.Runnable
    public void run() throws Throwable {
        boolean z;
        boolean z2;
        boolean z3;
        Callback callback;
        String url;
        synchronized (this.lifecycleLock) {
            if (!this.canceled.get() && !this.workerRunning) {
                boolean z4 = true;
                this.workerRunning = true;
                this.workerThread = Thread.currentThread();
                this.state = State.RUNNING;
                int urlCount = this.request.getUrlCount();
                boolean z5 = false;
                boolean zDownloadFromUrl = false;
                while (!zDownloadFromUrl && this.currentUrlIndex.get() < urlCount && !this.canceled.get() && !this.paused.get()) {
                    int i = this.currentUrlIndex.get();
                    int iNextValidUrlIndex = nextValidUrlIndex(i, urlCount);
                    if (iNextValidUrlIndex != i) {
                        this.currentUrlIndex.set(iNextValidUrlIndex);
                        if (!resetPartialDownloadForMirrorSwitch()) {
                            this.currentUrlIndex.set(urlCount);
                            break;
                        }
                        if (iNextValidUrlIndex < urlCount) {
                            this.currentUrlIndex.set(iNextValidUrlIndex);
                            url = this.request.getUrl(iNextValidUrlIndex);
                            int i2 = 0;
                            while (true) {
                                try {
                                    zDownloadFromUrl = downloadFromUrl(url);
                                } catch (Exception e) {
                                    e.getMessage();
                                }
                                if (!zDownloadFromUrl && !this.canceled.get() && !this.paused.get() && i2 < this.request.getMaxRetries() && isTransientFailure(this.lastErrorCode)) {
                                    i2++;
                                    if (!this.request.isResumable() && !resetPartialDownloadForMirrorSwitch()) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            if (zDownloadFromUrl && !this.canceled.get() && !this.paused.get()) {
                                int iNextValidUrlIndex2 = nextValidUrlIndex(iNextValidUrlIndex + 1, urlCount);
                                this.currentUrlIndex.set(iNextValidUrlIndex2);
                                if (iNextValidUrlIndex2 < urlCount && !resetPartialDownloadForMirrorSwitch()) {
                                    this.currentUrlIndex.set(urlCount);
                                    break;
                                }
                            } else if (this.paused.get()) {
                                break;
                            }
                        } else {
                            this.currentUrlIndex.set(urlCount);
                            break;
                        }
                    } else {
                        if (iNextValidUrlIndex < urlCount) {
                            this.currentUrlIndex.set(urlCount);
                            break;
                        }
                        this.currentUrlIndex.set(iNextValidUrlIndex);
                        url = this.request.getUrl(iNextValidUrlIndex);
                        int i3 = 0;
                        while (true) {
                            zDownloadFromUrl = downloadFromUrl(url);
                            if (!zDownloadFromUrl) {
                                break;
                            } else {
                                break;
                            }
                        }
                        if (zDownloadFromUrl) {
                        }
                        if (this.paused.get()) {
                            break;
                            break;
                        }
                    }
                }
                synchronized (this.lifecycleLock) {
                    this.workerRunning = false;
                    this.workerThread = null;
                    if (this.canceled.get()) {
                        this.pauseCallbackPending = false;
                        boolean z6 = !this.request.isResumable();
                        this.state = State.CANCELED;
                        z = z6;
                        z3 = true;
                        z2 = false;
                        z4 = false;
                    } else if (zDownloadFromUrl) {
                        this.resumeRequested = false;
                        this.paused.set(false);
                        this.state = State.COMPLETED;
                        z2 = false;
                        z3 = false;
                        z = false;
                    } else if (this.paused.get()) {
                        this.state = State.PAUSED;
                        this.pauseCallbackPending = true;
                        z2 = false;
                        z3 = false;
                        z = false;
                        z5 = true;
                        z4 = false;
                    } else {
                        boolean z7 = urlCount > 1 || !this.request.isResumable();
                        this.state = State.FAILED;
                        z = z7;
                        z2 = true;
                        z4 = false;
                        z3 = false;
                    }
                }
                if (z) {
                    resetPartialDownloadForMirrorSwitch();
                }
                if (z4) {
                    Callback callback2 = this.callback;
                    if (callback2 != null) {
                        callback2.onComplete(this, this.targetFile);
                        return;
                    }
                    return;
                }
                if (z5) {
                    Callback callback3 = this.callback;
                    if (callback3 != null) {
                        callback3.onPaused(this);
                        return;
                    }
                    return;
                }
                if (!z2) {
                    if (!z3 || (callback = this.callback) == null) {
                        return;
                    }
                    callback.onCanceled(this);
                    return;
                }
                int i4 = this.lastErrorCode != 0 ? this.lastErrorCode : DownloadUtils.ErrorCode.ERROR_UNKNOWN;
                String str = this.lastErrorMessage != null ? this.lastErrorMessage : "All URLs failed";
                Callback callback4 = this.callback;
                if (callback4 != null) {
                    callback4.onError(this, i4, str);
                }
            }
        }
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }
}
