package com.tapsdk.tapad.internal.runtime.download;

import com.tapsdk.tapad.group.ads.DirichletAd$$ExternalSyntheticBackportWithForwarding0;
import com.taptap.sdk.update.download.core.Util;
import com.umeng.analytics.pro.cc;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class AndroidRangeTransfer {
    private static final int BUFFER_SIZE = 16384;
    private static final int CHECKPOINT_MAGIC = 1146242865;
    private static final int CHECKPOINT_VERSION = 2;
    private static final long MAX_PARALLEL_SIZE = 2147483648L;
    private static final int MAX_SEGMENT_COUNT = 5;
    private static final int MAX_VALIDATOR_LENGTH = 1024;
    private static final long MIN_PARALLEL_SIZE = 2097152;
    private static final long MIN_SEGMENT_SIZE = 1048576;
    private static final String TAG = "AndroidRangeTransfer";
    private volatile Plan activePlan;
    private final AtomicBoolean canceled;
    private final File checkpointFile;
    private final ConnectionFactory connectionFactory;
    private final Listener listener;
    private final String ownerToken;
    private final AtomicBoolean paused;
    private volatile Thread probeThread;
    private final AndroidDownloadRequest request;
    private final String sourceUrl;
    private final File tempFile;
    private final String threadLabel;
    private final AtomicBoolean stopWorkers = new AtomicBoolean(false);
    private final AtomicBoolean rangeRejected = new AtomicBoolean(false);
    private final AtomicReference<Failure> firstFailure = new AtomicReference<>();
    private final Object checkpointLock = new Object();
    private volatile SegmentWorker[] activeWorkers = new SegmentWorker[0];

    public interface ConnectionFactory {
        HttpURLConnection open(String str, String str2, String str3, ConnectionTracker connectionTracker);
    }

    public interface ConnectionTracker {
        boolean track(HttpURLConnection httpURLConnection);
    }

    public static final class ContentRange {
        final long end;
        final long start;
        final long total;

        public ContentRange(long j, long j2, long j3) {
            this.start = j;
            this.end = j2;
            this.total = j3;
        }
    }

    public static final class Failure {
        final int errorCode;
        final String message;

        public Failure(int i, String str) {
            this.errorCode = i;
            this.message = str;
        }
    }

    public interface Listener {
        void onBytesDownloaded(long j);

        void onConnected();

        void onPrepared(long j, long j2, int i);
    }

    public enum Outcome {
        COMPLETED,
        UNSUPPORTED,
        INTERRUPTED,
        FAILED
    }

    public static final class Plan {
        final String ownerToken;
        final List<Segment> segments;
        final String sourceFingerprint;
        final long totalBytes;
        final String validator;

        public Plan(String str, String str2, long j, String str3, List<Segment> list) {
            this.sourceFingerprint = str;
            this.ownerToken = str2;
            this.totalBytes = j;
            this.validator = str3;
            this.segments = list;
        }

        public long downloadedBytes() {
            Iterator<Segment> it = this.segments.iterator();
            long j = 0;
            while (it.hasNext()) {
                j += it.next().downloaded.get();
            }
            return j;
        }

        public boolean isComplete() {
            Iterator<Segment> it = this.segments.iterator();
            while (it.hasNext()) {
                if (!it.next().isComplete()) {
                    return false;
                }
            }
            return true;
        }
    }

    public static final class Probe {
        final String finalUrl;
        final ProbeOutcome outcome;
        final long totalBytes;
        final String validator;

        public Probe(ProbeOutcome probeOutcome, String str, long j, String str2) {
            this.outcome = probeOutcome;
            this.finalUrl = str;
            this.totalBytes = j;
            this.validator = str2;
        }
    }

    public enum ProbeOutcome {
        SUPPORTED,
        UNSUPPORTED,
        INTERRUPTED
    }

    public static final class Result {
        final int errorCode;
        final String errorMessage;
        final Outcome outcome;
        final long totalBytes;

        private Result(Outcome outcome, long j, int i, String str) {
            this.outcome = outcome;
            this.totalBytes = j;
            this.errorCode = i;
            this.errorMessage = str;
        }

        public static Result completed(long j) {
            return new Result(Outcome.COMPLETED, j, 0, null);
        }

        public static Result failed(long j, int i, String str) {
            return new Result(Outcome.FAILED, j, i, str);
        }

        public static Result interrupted(long j) {
            return new Result(Outcome.INTERRUPTED, j, 0, null);
        }

        public static Result unsupported(long j) {
            return new Result(Outcome.UNSUPPORTED, j, 0, null);
        }
    }

    public static final class Segment {
        final AtomicLong downloaded;
        final AtomicLong durableDownloaded;
        final long end;
        final long start;

        public Segment(long j, long j2, long j3) {
            this.start = j;
            this.end = j2;
            this.downloaded = new AtomicLong(j3);
            this.durableDownloaded = new AtomicLong(j3);
        }

        public boolean isComplete() {
            return this.downloaded.get() == length();
        }

        public long length() {
            return (this.end - this.start) + 1;
        }
    }

    public static final class SegmentThreadFactory implements ThreadFactory {
        private final String label;
        private final AtomicLong sequence = new AtomicLong(1);

        public SegmentThreadFactory(String str) {
            this.label = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "DirichletSegment-" + this.label + "-" + this.sequence.getAndIncrement());
            thread.setPriority(4);
            return thread;
        }
    }

    public final class SegmentWorker {
        private final int index;
        private volatile Thread ownerThread;
        private final Segment segment;
        private final String url;

        public SegmentWorker(int i, Segment segment, String str) {
            this.index = i;
            this.segment = segment;
            this.url = str;
        }

        /* JADX WARN: Code duplicated, block: B:441:0x059c A[Catch: all -> 0x0675, TRY_LEAVE, TryCatch #59 {all -> 0x0675, blocks: (B:439:0x0594, B:441:0x059c), top: B:837:0x0594 }] */
        /* JADX WARN: Code duplicated, block: B:465:0x05e8 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:521:0x068c A[Catch: all -> 0x0851, TRY_LEAVE, TryCatch #32 {all -> 0x0851, blocks: (B:519:0x0684, B:521:0x068c, B:597:0x076b, B:599:0x0773), top: B:793:0x0015 }] */
        /* JADX WARN: Code duplicated, block: B:545:0x06d8 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:599:0x0773 A[Catch: all -> 0x0851, TRY_LEAVE, TryCatch #32 {all -> 0x0851, blocks: (B:519:0x0684, B:521:0x068c, B:597:0x076b, B:599:0x0773), top: B:793:0x0015 }] */
        /* JADX WARN: Code duplicated, block: B:601:0x0784  */
        /* JADX WARN: Code duplicated, block: B:625:0x07c1 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:700:0x0895 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:711:0x08bc  */
        /* JADX WARN: Code duplicated, block: B:761:0x06da A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:769:0x05ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:815:0x085f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:829:0x0897 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:843:0x07c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:857:0x078b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:870:0x06a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:885:0x05b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 10, insn: 0x0854: MOVE (r5 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:676:0x0852 */
        /* JADX WARN: Not initialized variable reg: 5, insn: 0x0853: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:676:0x0852 */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v101, types: [java.util.concurrent.atomic.AtomicLong] */
        /* JADX WARN: Type inference failed for: r2v102 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v111 */
        /* JADX WARN: Type inference failed for: r2v113 */
        /* JADX WARN: Type inference failed for: r2v116, types: [java.util.concurrent.atomic.AtomicLong] */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v126 */
        /* JADX WARN: Type inference failed for: r2v127 */
        /* JADX WARN: Type inference failed for: r2v13, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r2v130, types: [java.util.concurrent.atomic.AtomicLong] */
        /* JADX WARN: Type inference failed for: r2v137 */
        /* JADX WARN: Type inference failed for: r2v138 */
        /* JADX WARN: Type inference failed for: r2v139 */
        /* JADX WARN: Type inference failed for: r2v140 */
        /* JADX WARN: Type inference failed for: r2v141 */
        /* JADX WARN: Type inference failed for: r2v142 */
        /* JADX WARN: Type inference failed for: r2v143 */
        /* JADX WARN: Type inference failed for: r2v144 */
        /* JADX WARN: Type inference failed for: r2v145 */
        /* JADX WARN: Type inference failed for: r2v146 */
        /* JADX WARN: Type inference failed for: r2v147 */
        /* JADX WARN: Type inference failed for: r2v148 */
        /* JADX WARN: Type inference failed for: r2v149 */
        /* JADX WARN: Type inference failed for: r2v150 */
        /* JADX WARN: Type inference failed for: r2v151 */
        /* JADX WARN: Type inference failed for: r2v152 */
        /* JADX WARN: Type inference failed for: r2v153 */
        /* JADX WARN: Type inference failed for: r2v154 */
        /* JADX WARN: Type inference failed for: r2v155 */
        /* JADX WARN: Type inference failed for: r2v156 */
        /* JADX WARN: Type inference failed for: r2v157 */
        /* JADX WARN: Type inference failed for: r2v158 */
        /* JADX WARN: Type inference failed for: r2v159 */
        /* JADX WARN: Type inference failed for: r2v160 */
        /* JADX WARN: Type inference failed for: r2v161 */
        /* JADX WARN: Type inference failed for: r2v162 */
        /* JADX WARN: Type inference failed for: r2v163 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v26 */
        /* JADX WARN: Type inference failed for: r2v27, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v40, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v53, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v72, types: [java.net.HttpURLConnection, java.net.URLConnection] */
        /* JADX WARN: Type inference failed for: r2v73 */
        /* JADX WARN: Type inference failed for: r2v74 */
        /* JADX WARN: Type inference failed for: r2v75 */
        /* JADX WARN: Type inference failed for: r2v76 */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r2v87 */
        /* JADX WARN: Type inference failed for: r2v9 */
        /* JADX WARN: Type inference failed for: r2v96 */
        /* JADX WARN: Type inference failed for: r2v98 */
        /* JADX WARN: Type inference failed for: r3v11, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r3v219 */
        /* JADX WARN: Type inference failed for: r3v220 */
        /* JADX WARN: Type inference failed for: r3v221 */
        /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
        public boolean download() throws Throwable {
            Throwable th;
            ?? r2;
            SocketTimeoutException socketTimeoutException;
            ?? r3;
            RuntimeException runtimeException;
            ?? r4;
            IOException iOException;
            ?? r5;
            RandomAccessFile randomAccessFile;
            RandomAccessFile randomAccessFile2;
            boolean z;
            boolean z2;
            InputStream inputStream;
            InputStream inputStream2;
            InputStream inputStream3;
            InputStream inputStream4;
            ?? r6;
            ?? r7;
            RandomAccessFile randomAccessFile3;
            boolean z3;
            ?? r8;
            RandomAccessFile randomAccessFile4;
            boolean z4;
            ?? r9;
            RandomAccessFile randomAccessFile5;
            RandomAccessFile randomAccessFile6;
            ?? r10;
            ?? r11;
            Thread thread;
            Thread thread2;
            Thread thread3;
            Thread thread4;
            Object obj;
            ?? r12;
            InputStream inputStream5;
            ?? r13;
            Thread thread5;
            Thread thread6;
            Thread thread7;
            boolean z5;
            InputStream inputStream6;
            ?? r14;
            Thread thread8;
            Thread thread9;
            Thread thread10;
            boolean z6;
            InputStream inputStream7;
            ?? r15;
            Thread thread11;
            Thread thread12;
            Thread thread13;
            InputStream inputStream8;
            Thread thread14;
            Thread thread15;
            Thread thread16;
            Thread thread17;
            Thread thread18;
            Thread thread19;
            Thread thread20;
            Thread thread21;
            Thread thread22;
            Thread thread23;
            Thread thread24;
            Thread thread25;
            String str = "bytes=";
            boolean z7 = true;
            if (this.segment.isComplete()) {
                return true;
            }
            Thread threadCurrentThread = Thread.currentThread();
            this.ownerThread = threadCurrentThread;
            Thread thread26 = null;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            boolean z13 = false;
            boolean z14 = false;
            boolean z15 = false;
            boolean z16 = false;
            boolean z17 = false;
            boolean z18 = false;
            boolean z19 = false;
            boolean z20 = false;
            boolean z21 = false;
            boolean z22 = false;
            boolean z23 = false;
            boolean z24 = false;
            try {
                try {
                    if (AndroidRangeTransfer.this.shouldStop()) {
                        try {
                            AndroidRangeTransfer.closeQuietly(z24 ? 1 : 0);
                            z6 = false;
                        } finally {
                            this.ownerThread = thread26;
                        }
                    } else {
                        Segment segment = this.segment;
                        long j = segment.start + segment.downloaded.get();
                        long j2 = this.segment.end;
                        long j3 = (j2 - j) + 1;
                        Thread.currentThread().getName();
                        ?? Open = AndroidRangeTransfer.this.connectionFactory.open(this.url, "bytes=" + j + "-" + j2, AndroidRangeTransfer.this.activePlan == null ? "" : AndroidRangeTransfer.this.activePlan.validator, new ConnectionTracker() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidRangeTransfer$SegmentWorker$$ExternalSyntheticLambda0
                            @Override // com.tapsdk.tapad.internal.runtime.download.AndroidRangeTransfer.ConnectionTracker
                            public final boolean track(HttpURLConnection httpURLConnection) {
                                return this.f$0.m272lambda$download$0$comtapsdktapadinternalruntimedownloadAndroidRangeTransfer$SegmentWorker(httpURLConnection);
                            }
                        });
                        try {
                            if (AndroidRangeTransfer.this.shouldStop()) {
                                try {
                                    AndroidRangeTransfer.closeQuietly(z21 ? 1 : 0);
                                    if (Open != 0) {
                                        try {
                                            Open.disconnect();
                                        } finally {
                                            this.ownerThread = z20 ? 1 : 0;
                                        }
                                    }
                                    z5 = false;
                                    z6 = z5;
                                } catch (Throwable th2) {
                                    if (Open != 0) {
                                        try {
                                            Open.disconnect();
                                        } finally {
                                            this.ownerThread = z23 ? 1 : 0;
                                        }
                                    }
                                    throw th2;
                                }
                            } else {
                                int responseCode = Open.getResponseCode();
                                try {
                                    if (responseCode != 206) {
                                        AndroidRangeTransfer androidRangeTransfer = AndroidRangeTransfer.this;
                                        String str2 = "Range segment " + this.index + " returned HTTP " + responseCode;
                                        if (responseCode != 200) {
                                            z7 = false;
                                        }
                                        androidRangeTransfer.recordFailure(1007, str2, z7);
                                        try {
                                            AndroidRangeTransfer.closeQuietly(z9 ? 1 : 0);
                                            try {
                                                Open.disconnect();
                                                z6 = false;
                                            } finally {
                                                this.ownerThread = z8 ? 1 : 0;
                                            }
                                        } catch (Throwable th3) {
                                            try {
                                                Open.disconnect();
                                                throw th3;
                                            } finally {
                                                this.ownerThread = z11 ? 1 : 0;
                                            }
                                        }
                                    } else if (AndroidRangeTransfer.hasIdentityEncoding(Open)) {
                                        ContentRange contentRange = AndroidRangeTransfer.parseContentRange(Open.getHeaderField(Util.CONTENT_RANGE));
                                        if (contentRange == null || contentRange.start != j || contentRange.end != j2 || contentRange.total != AndroidRangeTransfer.this.activePlan.totalBytes) {
                                            AndroidRangeTransfer.this.recordFailure(1007, "Range segment " + this.index + " returned mismatched Content-Range", true);
                                            Thread thread27 = null;
                                            boolean z25 = false;
                                            boolean z26 = false;
                                            try {
                                                AndroidRangeTransfer.closeQuietly(false ? 1 : 0);
                                                try {
                                                    Open.disconnect();
                                                    z6 = false;
                                                } finally {
                                                    this.ownerThread = z25 ? 1 : 0;
                                                }
                                            } catch (Throwable th4) {
                                                try {
                                                    Open.disconnect();
                                                    throw th4;
                                                } finally {
                                                    this.ownerThread = thread27;
                                                }
                                            }
                                        } else if (AndroidRangeTransfer.hasExplicitValidatorMismatch(Open, AndroidRangeTransfer.this.activePlan.validator)) {
                                            AndroidRangeTransfer.this.recordFailure(1007, "Range segment " + this.index + " changed representation validator", true);
                                            Thread thread28 = null;
                                            boolean z27 = false;
                                            boolean z28 = false;
                                            try {
                                                AndroidRangeTransfer.closeQuietly(false ? 1 : 0);
                                                try {
                                                    Open.disconnect();
                                                    z6 = false;
                                                } finally {
                                                    this.ownerThread = z27 ? 1 : 0;
                                                }
                                            } catch (Throwable th5) {
                                                try {
                                                    Open.disconnect();
                                                    throw th5;
                                                } finally {
                                                    this.ownerThread = thread28;
                                                }
                                            }
                                        } else {
                                            long jPositiveContentLength = AndroidRangeTransfer.positiveContentLength(Open);
                                            long j4 = 0;
                                            if (jPositiveContentLength <= 0 || jPositiveContentLength == j3) {
                                                inputStream8 = Open.getInputStream();
                                                try {
                                                    RandomAccessFile randomAccessFile7 = new RandomAccessFile(AndroidRangeTransfer.this.tempFile, "rw");
                                                    try {
                                                        randomAccessFile7.seek(j);
                                                        int i = 16384;
                                                        byte[] bArr = new byte[16384];
                                                        while (true) {
                                                            if (j3 > j4) {
                                                                if (AndroidRangeTransfer.this.shouldStop()) {
                                                                    try {
                                                                        AndroidRangeTransfer.closeQuietly(inputStream8);
                                                                        try {
                                                                            Open.disconnect();
                                                                            try {
                                                                                try {
                                                                                    randomAccessFile7.getFD().sync();
                                                                                    Segment segment2 = this.segment;
                                                                                    AtomicLong atomicLong = segment2.durableDownloaded;
                                                                                    Open = segment2.downloaded;
                                                                                    atomicLong.set(Open.get());
                                                                                } catch (Throwable th6) {
                                                                                    this.ownerThread = null;
                                                                                    throw th6;
                                                                                }
                                                                            } catch (IOException e) {
                                                                            }
                                                                            try {
                                                                                randomAccessFile7.close();
                                                                            } catch (IOException e2) {
                                                                            }
                                                                        } catch (Throwable th7) {
                                                                            try {
                                                                                try {
                                                                                    randomAccessFile7.getFD().sync();
                                                                                    this.segment.durableDownloaded.set(this.segment.downloaded.get());
                                                                                } catch (Throwable th8) {
                                                                                    this.ownerThread = null;
                                                                                    throw th8;
                                                                                }
                                                                            } catch (IOException e3) {
                                                                            }
                                                                            try {
                                                                                randomAccessFile7.close();
                                                                                thread19 = null;
                                                                            } catch (IOException e4) {
                                                                                thread19 = null;
                                                                            }
                                                                            this.ownerThread = thread19;
                                                                            throw th7;
                                                                        }
                                                                    } catch (Throwable th9) {
                                                                        try {
                                                                            Open.disconnect();
                                                                            try {
                                                                                try {
                                                                                    randomAccessFile7.getFD().sync();
                                                                                    this.segment.durableDownloaded.set(this.segment.downloaded.get());
                                                                                } catch (Throwable th10) {
                                                                                    this.ownerThread = null;
                                                                                    throw th10;
                                                                                }
                                                                            } catch (IOException e5) {
                                                                            }
                                                                            try {
                                                                                randomAccessFile7.close();
                                                                                thread18 = null;
                                                                            } catch (IOException e6) {
                                                                                thread18 = null;
                                                                            }
                                                                            this.ownerThread = thread18;
                                                                            throw th9;
                                                                        } catch (Throwable th11) {
                                                                            try {
                                                                                try {
                                                                                    randomAccessFile7.getFD().sync();
                                                                                    this.segment.durableDownloaded.set(this.segment.downloaded.get());
                                                                                } catch (IOException e7) {
                                                                                }
                                                                                try {
                                                                                    randomAccessFile7.close();
                                                                                    thread17 = null;
                                                                                } catch (IOException e8) {
                                                                                    thread17 = null;
                                                                                }
                                                                                this.ownerThread = thread17;
                                                                                throw th11;
                                                                            } catch (Throwable th12) {
                                                                                this.ownerThread = null;
                                                                                throw th12;
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    int i2 = inputStream8.read(bArr, 0, (int) Math.min(i, j3));
                                                                    if (i2 < 0) {
                                                                        AndroidRangeTransfer.this.recordFailure(1006, "Range segment " + this.index + " ended early", false);
                                                                        try {
                                                                            AndroidRangeTransfer.closeQuietly(inputStream8);
                                                                            try {
                                                                                Open.disconnect();
                                                                                try {
                                                                                    try {
                                                                                        randomAccessFile7.getFD().sync();
                                                                                        Segment segment3 = this.segment;
                                                                                        AtomicLong atomicLong2 = segment3.durableDownloaded;
                                                                                        Open = segment3.downloaded;
                                                                                        atomicLong2.set(Open.get());
                                                                                    } catch (Throwable th13) {
                                                                                        this.ownerThread = null;
                                                                                        throw th13;
                                                                                    }
                                                                                } catch (IOException e9) {
                                                                                }
                                                                                try {
                                                                                    randomAccessFile7.close();
                                                                                } catch (IOException e10) {
                                                                                }
                                                                            } catch (Throwable th14) {
                                                                                try {
                                                                                    try {
                                                                                        randomAccessFile7.getFD().sync();
                                                                                        this.segment.durableDownloaded.set(this.segment.downloaded.get());
                                                                                    } catch (Throwable th15) {
                                                                                        this.ownerThread = null;
                                                                                        throw th15;
                                                                                    }
                                                                                } catch (IOException e11) {
                                                                                }
                                                                                try {
                                                                                    randomAccessFile7.close();
                                                                                    thread22 = null;
                                                                                } catch (IOException e12) {
                                                                                    thread22 = null;
                                                                                }
                                                                                this.ownerThread = thread22;
                                                                                throw th14;
                                                                            }
                                                                        } catch (Throwable th16) {
                                                                            try {
                                                                                Open.disconnect();
                                                                                try {
                                                                                    try {
                                                                                        randomAccessFile7.getFD().sync();
                                                                                        this.segment.durableDownloaded.set(this.segment.downloaded.get());
                                                                                    } catch (Throwable th17) {
                                                                                        this.ownerThread = null;
                                                                                        throw th17;
                                                                                    }
                                                                                } catch (IOException e13) {
                                                                                }
                                                                                try {
                                                                                    randomAccessFile7.close();
                                                                                    thread21 = null;
                                                                                } catch (IOException e14) {
                                                                                    thread21 = null;
                                                                                }
                                                                                this.ownerThread = thread21;
                                                                                throw th16;
                                                                            } catch (Throwable th18) {
                                                                                try {
                                                                                    try {
                                                                                        randomAccessFile7.getFD().sync();
                                                                                        this.segment.durableDownloaded.set(this.segment.downloaded.get());
                                                                                    } catch (IOException e15) {
                                                                                    }
                                                                                    try {
                                                                                        randomAccessFile7.close();
                                                                                        thread20 = null;
                                                                                    } catch (IOException e16) {
                                                                                        thread20 = null;
                                                                                    }
                                                                                    this.ownerThread = thread20;
                                                                                    throw th18;
                                                                                } catch (Throwable th19) {
                                                                                    this.ownerThread = null;
                                                                                    throw th19;
                                                                                }
                                                                            }
                                                                        }
                                                                    } else if (AndroidRangeTransfer.this.shouldStop()) {
                                                                        try {
                                                                            AndroidRangeTransfer.closeQuietly(inputStream8);
                                                                            try {
                                                                                Open.disconnect();
                                                                                try {
                                                                                    try {
                                                                                        randomAccessFile7.getFD().sync();
                                                                                        Segment segment4 = this.segment;
                                                                                        AtomicLong atomicLong3 = segment4.durableDownloaded;
                                                                                        Open = segment4.downloaded;
                                                                                        atomicLong3.set(Open.get());
                                                                                    } catch (IOException e17) {
                                                                                    }
                                                                                    try {
                                                                                        randomAccessFile7.close();
                                                                                    } catch (IOException e18) {
                                                                                    }
                                                                                } catch (Throwable th20) {
                                                                                    this.ownerThread = null;
                                                                                    throw th20;
                                                                                }
                                                                            } catch (Throwable th21) {
                                                                                try {
                                                                                    try {
                                                                                        randomAccessFile7.getFD().sync();
                                                                                        this.segment.durableDownloaded.set(this.segment.downloaded.get());
                                                                                    } catch (IOException e19) {
                                                                                    }
                                                                                    try {
                                                                                        randomAccessFile7.close();
                                                                                        thread25 = null;
                                                                                    } catch (IOException e20) {
                                                                                        thread25 = null;
                                                                                    }
                                                                                    this.ownerThread = thread25;
                                                                                    throw th21;
                                                                                } catch (Throwable th22) {
                                                                                    this.ownerThread = null;
                                                                                    throw th22;
                                                                                }
                                                                            }
                                                                        } catch (Throwable th23) {
                                                                            try {
                                                                                Open.disconnect();
                                                                                try {
                                                                                    try {
                                                                                        randomAccessFile7.getFD().sync();
                                                                                        this.segment.durableDownloaded.set(this.segment.downloaded.get());
                                                                                    } catch (Throwable th24) {
                                                                                        this.ownerThread = null;
                                                                                        throw th24;
                                                                                    }
                                                                                } catch (IOException e21) {
                                                                                }
                                                                                try {
                                                                                    randomAccessFile7.close();
                                                                                    thread24 = null;
                                                                                } catch (IOException e22) {
                                                                                    thread24 = null;
                                                                                }
                                                                                this.ownerThread = thread24;
                                                                                throw th23;
                                                                            } catch (Throwable th25) {
                                                                                try {
                                                                                    try {
                                                                                        randomAccessFile7.getFD().sync();
                                                                                        this.segment.durableDownloaded.set(this.segment.downloaded.get());
                                                                                    } catch (Throwable th26) {
                                                                                        this.ownerThread = null;
                                                                                        throw th26;
                                                                                    }
                                                                                } catch (IOException e23) {
                                                                                }
                                                                                try {
                                                                                    randomAccessFile7.close();
                                                                                    thread23 = null;
                                                                                } catch (IOException e24) {
                                                                                    thread23 = null;
                                                                                }
                                                                                this.ownerThread = thread23;
                                                                                throw th25;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        randomAccessFile7.write(bArr, 0, i2);
                                                                        long j5 = i2;
                                                                        this.segment.downloaded.addAndGet(j5);
                                                                        j3 -= j5;
                                                                        AndroidRangeTransfer.this.listener.onBytesDownloaded(j5);
                                                                        i = 16384;
                                                                        j4 = 0;
                                                                    }
                                                                }
                                                                z7 = false;
                                                                break;
                                                            }
                                                            randomAccessFile7.getFD().sync();
                                                            try {
                                                                Segment segment5 = this.segment;
                                                                segment5.durableDownloaded.set(segment5.downloaded.get());
                                                                AndroidRangeTransfer androidRangeTransfer2 = AndroidRangeTransfer.this;
                                                                androidRangeTransfer2.saveCheckpointBestEffort(androidRangeTransfer2.activePlan);
                                                                this.segment.length();
                                                                try {
                                                                    AndroidRangeTransfer.closeQuietly(inputStream8);
                                                                    try {
                                                                        Open.disconnect();
                                                                        try {
                                                                            randomAccessFile7.close();
                                                                            break;
                                                                        } catch (IOException e25) {
                                                                            break;
                                                                        } catch (Throwable th27) {
                                                                            this.ownerThread = null;
                                                                            throw th27;
                                                                        }
                                                                    } catch (Throwable th28) {
                                                                        try {
                                                                            randomAccessFile7.close();
                                                                            thread16 = null;
                                                                        } catch (IOException e26) {
                                                                            thread16 = null;
                                                                        } catch (Throwable th29) {
                                                                            this.ownerThread = null;
                                                                            throw th29;
                                                                        }
                                                                        this.ownerThread = thread16;
                                                                        throw th28;
                                                                    }
                                                                } catch (Throwable th30) {
                                                                    try {
                                                                        Open.disconnect();
                                                                        try {
                                                                            randomAccessFile7.close();
                                                                            thread15 = null;
                                                                        } catch (IOException e27) {
                                                                            thread15 = null;
                                                                        } catch (Throwable th31) {
                                                                            this.ownerThread = null;
                                                                            throw th31;
                                                                        }
                                                                        this.ownerThread = thread15;
                                                                        throw th30;
                                                                    } catch (Throwable th32) {
                                                                        try {
                                                                            randomAccessFile7.close();
                                                                            thread14 = null;
                                                                        } catch (IOException e28) {
                                                                            thread14 = null;
                                                                        } catch (Throwable th33) {
                                                                            this.ownerThread = null;
                                                                            throw th33;
                                                                        }
                                                                        this.ownerThread = thread14;
                                                                        throw th32;
                                                                    }
                                                                }
                                                            } catch (SocketTimeoutException e29) {
                                                                socketTimeoutException = e29;
                                                                z4 = z7;
                                                                r15 = Open;
                                                                inputStream7 = inputStream8;
                                                                randomAccessFile4 = randomAccessFile7;
                                                                if (AndroidRangeTransfer.this.shouldStop()) {
                                                                    z5 = false;
                                                                } else {
                                                                    z5 = false;
                                                                    AndroidRangeTransfer.this.recordFailure(1008, AndroidRangeTransfer.safeMessage(socketTimeoutException.getMessage()), false);
                                                                }
                                                                try {
                                                                    AndroidRangeTransfer.closeQuietly(inputStream7);
                                                                    if (r15 != 0) {
                                                                        try {
                                                                            r15.disconnect();
                                                                        } catch (Throwable th34) {
                                                                            if (randomAccessFile4 != null) {
                                                                                if (!z4) {
                                                                                    try {
                                                                                        try {
                                                                                            randomAccessFile4.getFD().sync();
                                                                                            Segment segment6 = this.segment;
                                                                                            segment6.durableDownloaded.set(segment6.downloaded.get());
                                                                                        } catch (Throwable th35) {
                                                                                            this.ownerThread = null;
                                                                                            throw th35;
                                                                                        }
                                                                                    } catch (IOException e30) {
                                                                                    }
                                                                                }
                                                                                try {
                                                                                    randomAccessFile4.close();
                                                                                    thread13 = null;
                                                                                } catch (IOException e31) {
                                                                                    thread13 = null;
                                                                                }
                                                                            } else {
                                                                                thread13 = null;
                                                                            }
                                                                            this.ownerThread = thread13;
                                                                            throw th34;
                                                                        }
                                                                    }
                                                                    if (randomAccessFile4 != null) {
                                                                        if (!z4) {
                                                                            try {
                                                                                try {
                                                                                    randomAccessFile4.getFD().sync();
                                                                                    Segment segment7 = this.segment;
                                                                                    segment7.durableDownloaded.set(segment7.downloaded.get());
                                                                                } catch (IOException e32) {
                                                                                }
                                                                            } finally {
                                                                                this.ownerThread = null;
                                                                            }
                                                                        }
                                                                        try {
                                                                            randomAccessFile4.close();
                                                                        } catch (IOException e33) {
                                                                        }
                                                                    }
                                                                    z6 = z5;
                                                                } catch (Throwable th36) {
                                                                    if (r15 != 0) {
                                                                        try {
                                                                            r15.disconnect();
                                                                        } catch (Throwable th37) {
                                                                            if (randomAccessFile4 != null) {
                                                                                if (!z4) {
                                                                                    try {
                                                                                        try {
                                                                                            randomAccessFile4.getFD().sync();
                                                                                            Segment segment8 = this.segment;
                                                                                            segment8.durableDownloaded.set(segment8.downloaded.get());
                                                                                        } catch (IOException e34) {
                                                                                        }
                                                                                    } catch (Throwable th38) {
                                                                                        this.ownerThread = null;
                                                                                        throw th38;
                                                                                    }
                                                                                }
                                                                                try {
                                                                                    randomAccessFile4.close();
                                                                                    thread11 = null;
                                                                                } catch (IOException e35) {
                                                                                    thread11 = null;
                                                                                }
                                                                            } else {
                                                                                thread11 = null;
                                                                            }
                                                                            this.ownerThread = thread11;
                                                                            throw th37;
                                                                        }
                                                                    }
                                                                    if (randomAccessFile4 != null) {
                                                                        if (!z4) {
                                                                            try {
                                                                                try {
                                                                                    randomAccessFile4.getFD().sync();
                                                                                    Segment segment9 = this.segment;
                                                                                    segment9.durableDownloaded.set(segment9.downloaded.get());
                                                                                } catch (Throwable th39) {
                                                                                    this.ownerThread = null;
                                                                                    throw th39;
                                                                                }
                                                                            } catch (IOException e36) {
                                                                            }
                                                                        }
                                                                        try {
                                                                            randomAccessFile4.close();
                                                                            thread12 = null;
                                                                        } catch (IOException e37) {
                                                                            thread12 = null;
                                                                        }
                                                                    } else {
                                                                        thread12 = null;
                                                                    }
                                                                    this.ownerThread = thread12;
                                                                    throw th36;
                                                                }
                                                            } catch (IOException e38) {
                                                                iOException = e38;
                                                                z3 = z7;
                                                                r14 = Open;
                                                                inputStream6 = inputStream8;
                                                                randomAccessFile3 = randomAccessFile7;
                                                                if (!AndroidRangeTransfer.this.shouldStop()) {
                                                                    AndroidRangeTransfer.this.recordFailure(1006, AndroidRangeTransfer.safeMessage(iOException.getMessage()), false);
                                                                }
                                                                try {
                                                                    AndroidRangeTransfer.closeQuietly(inputStream6);
                                                                    if (r14 != 0) {
                                                                        try {
                                                                            r14.disconnect();
                                                                        } catch (Throwable th40) {
                                                                            if (randomAccessFile3 != null) {
                                                                                if (!z3) {
                                                                                    try {
                                                                                        try {
                                                                                            randomAccessFile3.getFD().sync();
                                                                                            Segment segment10 = this.segment;
                                                                                            segment10.durableDownloaded.set(segment10.downloaded.get());
                                                                                        } catch (IOException e39) {
                                                                                        }
                                                                                    } catch (Throwable th41) {
                                                                                        this.ownerThread = null;
                                                                                        throw th41;
                                                                                    }
                                                                                }
                                                                                try {
                                                                                    randomAccessFile3.close();
                                                                                    thread10 = null;
                                                                                } catch (IOException e40) {
                                                                                    thread10 = null;
                                                                                }
                                                                            } else {
                                                                                thread10 = null;
                                                                            }
                                                                            this.ownerThread = thread10;
                                                                            throw th40;
                                                                        }
                                                                    }
                                                                    if (randomAccessFile3 != null) {
                                                                        if (!z3) {
                                                                            try {
                                                                                try {
                                                                                    randomAccessFile3.getFD().sync();
                                                                                    Segment segment11 = this.segment;
                                                                                    segment11.durableDownloaded.set(segment11.downloaded.get());
                                                                                } catch (IOException e41) {
                                                                                }
                                                                            } finally {
                                                                                this.ownerThread = null;
                                                                            }
                                                                        }
                                                                        try {
                                                                            randomAccessFile3.close();
                                                                        } catch (IOException e42) {
                                                                        }
                                                                    }
                                                                    z5 = false;
                                                                    z6 = z5;
                                                                } catch (Throwable th42) {
                                                                    if (r14 != 0) {
                                                                        try {
                                                                            r14.disconnect();
                                                                        } catch (Throwable th43) {
                                                                            if (randomAccessFile3 != null) {
                                                                                if (!z3) {
                                                                                    try {
                                                                                        try {
                                                                                            randomAccessFile3.getFD().sync();
                                                                                            Segment segment12 = this.segment;
                                                                                            segment12.durableDownloaded.set(segment12.downloaded.get());
                                                                                        } catch (Throwable th44) {
                                                                                            this.ownerThread = null;
                                                                                            throw th44;
                                                                                        }
                                                                                    } catch (IOException e43) {
                                                                                    }
                                                                                }
                                                                                try {
                                                                                    randomAccessFile3.close();
                                                                                    thread8 = null;
                                                                                } catch (IOException e44) {
                                                                                    thread8 = null;
                                                                                }
                                                                            } else {
                                                                                thread8 = null;
                                                                            }
                                                                            this.ownerThread = thread8;
                                                                            throw th43;
                                                                        }
                                                                    }
                                                                    if (randomAccessFile3 != null) {
                                                                        if (!z3) {
                                                                            try {
                                                                                try {
                                                                                    randomAccessFile3.getFD().sync();
                                                                                    Segment segment13 = this.segment;
                                                                                    segment13.durableDownloaded.set(segment13.downloaded.get());
                                                                                } catch (Throwable th45) {
                                                                                    this.ownerThread = null;
                                                                                    throw th45;
                                                                                }
                                                                            } catch (IOException e45) {
                                                                            }
                                                                        }
                                                                        try {
                                                                            randomAccessFile3.close();
                                                                            thread9 = null;
                                                                        } catch (IOException e46) {
                                                                            thread9 = null;
                                                                        }
                                                                    } else {
                                                                        thread9 = null;
                                                                    }
                                                                    this.ownerThread = thread9;
                                                                    throw th42;
                                                                }
                                                            } catch (RuntimeException e47) {
                                                                runtimeException = e47;
                                                                r13 = Open;
                                                                inputStream5 = inputStream8;
                                                                randomAccessFile5 = randomAccessFile7;
                                                                try {
                                                                    if (!AndroidRangeTransfer.this.shouldStop()) {
                                                                        AndroidRangeTransfer.this.recordFailure(DownloadUtils.ErrorCode.ERROR_UNKNOWN, AndroidRangeTransfer.safeMessage(runtimeException.getMessage()), false);
                                                                    }
                                                                    try {
                                                                        AndroidRangeTransfer.closeQuietly(inputStream5);
                                                                        if (r13 != 0) {
                                                                            try {
                                                                                r13.disconnect();
                                                                            } catch (Throwable th46) {
                                                                                if (randomAccessFile5 != null) {
                                                                                    if (!z7) {
                                                                                        try {
                                                                                            try {
                                                                                                randomAccessFile5.getFD().sync();
                                                                                                Segment segment14 = this.segment;
                                                                                                segment14.durableDownloaded.set(segment14.downloaded.get());
                                                                                            } catch (IOException e48) {
                                                                                            }
                                                                                        } catch (Throwable th47) {
                                                                                            this.ownerThread = null;
                                                                                            throw th47;
                                                                                        }
                                                                                    }
                                                                                    try {
                                                                                        randomAccessFile5.close();
                                                                                        thread7 = null;
                                                                                    } catch (IOException e49) {
                                                                                        thread7 = null;
                                                                                    }
                                                                                } else {
                                                                                    thread7 = null;
                                                                                }
                                                                                this.ownerThread = thread7;
                                                                                throw th46;
                                                                            }
                                                                        }
                                                                        if (randomAccessFile5 != null) {
                                                                            if (!z7) {
                                                                                try {
                                                                                    try {
                                                                                        randomAccessFile5.getFD().sync();
                                                                                        Segment segment15 = this.segment;
                                                                                        segment15.durableDownloaded.set(segment15.downloaded.get());
                                                                                    } catch (IOException e50) {
                                                                                    }
                                                                                } finally {
                                                                                    this.ownerThread = null;
                                                                                }
                                                                            }
                                                                            try {
                                                                                randomAccessFile5.close();
                                                                            } catch (IOException e51) {
                                                                            }
                                                                        }
                                                                        z5 = false;
                                                                        z6 = z5;
                                                                    } catch (Throwable th48) {
                                                                        if (r13 != 0) {
                                                                            try {
                                                                                r13.disconnect();
                                                                            } catch (Throwable th49) {
                                                                                if (randomAccessFile5 != null) {
                                                                                    if (!z7) {
                                                                                        try {
                                                                                            try {
                                                                                                randomAccessFile5.getFD().sync();
                                                                                                Segment segment16 = this.segment;
                                                                                                segment16.durableDownloaded.set(segment16.downloaded.get());
                                                                                            } catch (Throwable th50) {
                                                                                                this.ownerThread = null;
                                                                                                throw th50;
                                                                                            }
                                                                                        } catch (IOException e52) {
                                                                                        }
                                                                                    }
                                                                                    try {
                                                                                        randomAccessFile5.close();
                                                                                        thread5 = null;
                                                                                    } catch (IOException e53) {
                                                                                        thread5 = null;
                                                                                    }
                                                                                } else {
                                                                                    thread5 = null;
                                                                                }
                                                                                this.ownerThread = thread5;
                                                                                throw th49;
                                                                            }
                                                                        }
                                                                        if (randomAccessFile5 != null) {
                                                                            if (!z7) {
                                                                                try {
                                                                                    try {
                                                                                        randomAccessFile5.getFD().sync();
                                                                                        Segment segment17 = this.segment;
                                                                                        segment17.durableDownloaded.set(segment17.downloaded.get());
                                                                                    } catch (Throwable th51) {
                                                                                        this.ownerThread = null;
                                                                                        throw th51;
                                                                                    }
                                                                                } catch (IOException e54) {
                                                                                    randomAccessFile5.close();
                                                                                    thread6 = null;
                                                                                    this.ownerThread = thread6;
                                                                                    throw th48;
                                                                                }
                                                                            }
                                                                            try {
                                                                                randomAccessFile5.close();
                                                                                thread6 = null;
                                                                            } catch (IOException e55) {
                                                                                thread6 = null;
                                                                            }
                                                                        } else {
                                                                            thread6 = null;
                                                                        }
                                                                        this.ownerThread = thread6;
                                                                        throw th48;
                                                                    }
                                                                } catch (Throwable th52) {
                                                                    th = th52;
                                                                    RandomAccessFile randomAccessFile8 = randomAccessFile5;
                                                                    z2 = z7;
                                                                    randomAccessFile2 = randomAccessFile8;
                                                                    r12 = r13;
                                                                    obj = inputStream5;
                                                                    boolean z29 = z2;
                                                                    randomAccessFile6 = randomAccessFile2;
                                                                    z7 = z29;
                                                                    r11 = r12;
                                                                    r10 = obj;
                                                                    try {
                                                                        AndroidRangeTransfer.closeQuietly(r10);
                                                                        if (r11 != 0) {
                                                                            try {
                                                                                r11.disconnect();
                                                                            } catch (Throwable th53) {
                                                                                if (randomAccessFile6 != null) {
                                                                                    if (!z7) {
                                                                                        try {
                                                                                            try {
                                                                                                randomAccessFile6.getFD().sync();
                                                                                                Segment segment18 = this.segment;
                                                                                                segment18.durableDownloaded.set(segment18.downloaded.get());
                                                                                            } catch (Throwable th54) {
                                                                                                this.ownerThread = null;
                                                                                                throw th54;
                                                                                            }
                                                                                        } catch (IOException e56) {
                                                                                        }
                                                                                    }
                                                                                    try {
                                                                                        randomAccessFile6.close();
                                                                                        thread3 = null;
                                                                                    } catch (IOException e57) {
                                                                                        thread3 = null;
                                                                                    }
                                                                                } else {
                                                                                    thread3 = null;
                                                                                }
                                                                                this.ownerThread = thread3;
                                                                                throw th53;
                                                                            }
                                                                        }
                                                                        if (randomAccessFile6 != null) {
                                                                            if (!z7) {
                                                                                try {
                                                                                    try {
                                                                                        randomAccessFile6.getFD().sync();
                                                                                        Segment segment19 = this.segment;
                                                                                        segment19.durableDownloaded.set(segment19.downloaded.get());
                                                                                    } catch (IOException e58) {
                                                                                    }
                                                                                } catch (Throwable th55) {
                                                                                    this.ownerThread = null;
                                                                                    throw th55;
                                                                                }
                                                                            }
                                                                            try {
                                                                                randomAccessFile6.close();
                                                                                thread4 = null;
                                                                            } catch (IOException e59) {
                                                                                thread4 = null;
                                                                            }
                                                                        } else {
                                                                            thread4 = null;
                                                                        }
                                                                        this.ownerThread = thread4;
                                                                        throw th;
                                                                    } catch (Throwable th56) {
                                                                        if (r11 != 0) {
                                                                            try {
                                                                                r11.disconnect();
                                                                            } catch (Throwable th57) {
                                                                                if (randomAccessFile6 != null) {
                                                                                    if (!z7) {
                                                                                        try {
                                                                                            try {
                                                                                                randomAccessFile6.getFD().sync();
                                                                                                Segment segment20 = this.segment;
                                                                                                segment20.durableDownloaded.set(segment20.downloaded.get());
                                                                                            } catch (IOException e60) {
                                                                                            }
                                                                                        } catch (Throwable th58) {
                                                                                            this.ownerThread = null;
                                                                                            throw th58;
                                                                                        }
                                                                                    }
                                                                                    try {
                                                                                        randomAccessFile6.close();
                                                                                        thread = null;
                                                                                    } catch (IOException e61) {
                                                                                        thread = null;
                                                                                    }
                                                                                } else {
                                                                                    thread = null;
                                                                                }
                                                                                this.ownerThread = thread;
                                                                                throw th57;
                                                                            }
                                                                        }
                                                                        if (randomAccessFile6 != null) {
                                                                            if (!z7) {
                                                                                try {
                                                                                    try {
                                                                                        randomAccessFile6.getFD().sync();
                                                                                        Segment segment21 = this.segment;
                                                                                        segment21.durableDownloaded.set(segment21.downloaded.get());
                                                                                    } catch (IOException e62) {
                                                                                    }
                                                                                } catch (Throwable th59) {
                                                                                    this.ownerThread = null;
                                                                                    throw th59;
                                                                                }
                                                                            }
                                                                            try {
                                                                                randomAccessFile6.close();
                                                                                thread2 = null;
                                                                            } catch (IOException e63) {
                                                                                thread2 = null;
                                                                            }
                                                                        } else {
                                                                            thread2 = null;
                                                                        }
                                                                        this.ownerThread = thread2;
                                                                        throw th56;
                                                                    }
                                                                }
                                                            } catch (Throwable th60) {
                                                                th = th60;
                                                                r11 = Open;
                                                                r10 = inputStream8;
                                                                randomAccessFile6 = randomAccessFile7;
                                                                AndroidRangeTransfer.closeQuietly(r10);
                                                                if (r11 != 0) {
                                                                    r11.disconnect();
                                                                }
                                                                if (randomAccessFile6 != null) {
                                                                    if (!z7) {
                                                                        randomAccessFile6.getFD().sync();
                                                                        Segment segment110 = this.segment;
                                                                        segment110.durableDownloaded.set(segment110.downloaded.get());
                                                                    }
                                                                    randomAccessFile6.close();
                                                                    thread4 = null;
                                                                } else {
                                                                    thread4 = null;
                                                                }
                                                                this.ownerThread = thread4;
                                                                throw th;
                                                            }
                                                        }
                                                        z6 = z7;
                                                    } catch (SocketTimeoutException e64) {
                                                        socketTimeoutException = e64;
                                                        z7 = false;
                                                    } catch (IOException e65) {
                                                        iOException = e65;
                                                        z7 = false;
                                                    } catch (RuntimeException e66) {
                                                        runtimeException = e66;
                                                        z7 = false;
                                                        r13 = Open;
                                                        inputStream5 = inputStream8;
                                                        randomAccessFile5 = randomAccessFile7;
                                                    } catch (Throwable th61) {
                                                        th = th61;
                                                        z7 = false;
                                                        r11 = Open;
                                                        r10 = inputStream8;
                                                        randomAccessFile6 = randomAccessFile7;
                                                    }
                                                } catch (RuntimeException e67) {
                                                    e = e67;
                                                    runtimeException = e;
                                                    r9 = Open;
                                                    inputStream2 = inputStream8;
                                                    z7 = false;
                                                    randomAccessFile5 = null;
                                                    r13 = r9;
                                                    inputStream5 = inputStream2;
                                                    if (!AndroidRangeTransfer.this.shouldStop()) {
                                                        AndroidRangeTransfer.this.recordFailure(DownloadUtils.ErrorCode.ERROR_UNKNOWN, AndroidRangeTransfer.safeMessage(runtimeException.getMessage()), false);
                                                    }
                                                    AndroidRangeTransfer.closeQuietly(inputStream5);
                                                    if (r13 != 0) {
                                                        r13.disconnect();
                                                    }
                                                    if (randomAccessFile5 != null) {
                                                        if (!z7) {
                                                            randomAccessFile5.getFD().sync();
                                                            Segment segment111 = this.segment;
                                                            segment111.durableDownloaded.set(segment111.downloaded.get());
                                                        }
                                                        randomAccessFile5.close();
                                                    }
                                                    z5 = false;
                                                    z6 = z5;
                                                    return z6;
                                                } catch (SocketTimeoutException e68) {
                                                    e = e68;
                                                    socketTimeoutException = e;
                                                    r8 = Open;
                                                    inputStream4 = inputStream8;
                                                    randomAccessFile4 = null;
                                                    z4 = false;
                                                    r15 = r8;
                                                    inputStream7 = inputStream4;
                                                    if (AndroidRangeTransfer.this.shouldStop()) {
                                                        z5 = false;
                                                        AndroidRangeTransfer.this.recordFailure(1008, AndroidRangeTransfer.safeMessage(socketTimeoutException.getMessage()), false);
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    AndroidRangeTransfer.closeQuietly(inputStream7);
                                                    if (r15 != 0) {
                                                        r15.disconnect();
                                                    }
                                                    if (randomAccessFile4 != null) {
                                                        if (!z4) {
                                                            randomAccessFile4.getFD().sync();
                                                            Segment segment22 = this.segment;
                                                            segment22.durableDownloaded.set(segment22.downloaded.get());
                                                        }
                                                        randomAccessFile4.close();
                                                    }
                                                    z6 = z5;
                                                    return z6;
                                                } catch (IOException e69) {
                                                    e = e69;
                                                    iOException = e;
                                                    r7 = Open;
                                                    inputStream3 = inputStream8;
                                                    randomAccessFile3 = null;
                                                    z3 = false;
                                                    r14 = r7;
                                                    inputStream6 = inputStream3;
                                                    if (!AndroidRangeTransfer.this.shouldStop()) {
                                                        AndroidRangeTransfer.this.recordFailure(1006, AndroidRangeTransfer.safeMessage(iOException.getMessage()), false);
                                                    }
                                                    AndroidRangeTransfer.closeQuietly(inputStream6);
                                                    if (r14 != 0) {
                                                        r14.disconnect();
                                                    }
                                                    if (randomAccessFile3 != null) {
                                                        if (!z3) {
                                                            randomAccessFile3.getFD().sync();
                                                            Segment segment112 = this.segment;
                                                            segment112.durableDownloaded.set(segment112.downloaded.get());
                                                        }
                                                        randomAccessFile3.close();
                                                    }
                                                    z5 = false;
                                                    z6 = z5;
                                                    return z6;
                                                } catch (Throwable th62) {
                                                    th = th62;
                                                    r6 = Open;
                                                    inputStream = inputStream8;
                                                    randomAccessFile2 = null;
                                                    z2 = false;
                                                    r12 = r6;
                                                    obj = inputStream;
                                                    boolean z210 = z2;
                                                    randomAccessFile6 = randomAccessFile2;
                                                    z7 = z210;
                                                    r11 = r12;
                                                    r10 = obj;
                                                    AndroidRangeTransfer.closeQuietly(r10);
                                                    if (r11 != 0) {
                                                        r11.disconnect();
                                                    }
                                                    if (randomAccessFile6 != null) {
                                                        if (!z7) {
                                                            randomAccessFile6.getFD().sync();
                                                            Segment segment113 = this.segment;
                                                            segment113.durableDownloaded.set(segment113.downloaded.get());
                                                        }
                                                        randomAccessFile6.close();
                                                        thread4 = null;
                                                    } else {
                                                        thread4 = null;
                                                    }
                                                    this.ownerThread = thread4;
                                                    throw th;
                                                }
                                            } else {
                                                AndroidRangeTransfer.this.recordFailure(1007, "Range segment " + this.index + " returned mismatched Content-Length", true);
                                                Thread thread29 = null;
                                                boolean z30 = false;
                                                boolean z31 = false;
                                                try {
                                                    AndroidRangeTransfer.closeQuietly(false ? 1 : 0);
                                                    try {
                                                        Open.disconnect();
                                                        z6 = false;
                                                    } finally {
                                                        this.ownerThread = z30 ? 1 : 0;
                                                    }
                                                } catch (Throwable th63) {
                                                    try {
                                                        Open.disconnect();
                                                        throw th63;
                                                    } finally {
                                                        this.ownerThread = thread29;
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        AndroidRangeTransfer.this.recordFailure(1007, "Range segment " + this.index + " used content encoding", true);
                                        try {
                                            AndroidRangeTransfer.closeQuietly(z13 ? 1 : 0);
                                            try {
                                                Open.disconnect();
                                                z6 = false;
                                            } finally {
                                                this.ownerThread = z12 ? 1 : 0;
                                            }
                                        } catch (Throwable th64) {
                                            try {
                                                Open.disconnect();
                                                throw th64;
                                            } finally {
                                                this.ownerThread = z15 ? 1 : 0;
                                            }
                                        }
                                    }
                                } catch (SocketTimeoutException e70) {
                                    e = e70;
                                    inputStream8 = z16 ? 1 : 0;
                                } catch (IOException e71) {
                                    e = e71;
                                    inputStream8 = z17 ? 1 : 0;
                                } catch (RuntimeException e72) {
                                    e = e72;
                                    inputStream8 = z18 ? 1 : 0;
                                } catch (Throwable th65) {
                                    RandomAccessFile randomAccessFile9 = z19 ? 1 : 0;
                                    randomAccessFile2 = randomAccessFile9;
                                    z2 = false;
                                    th = th65;
                                    r12 = Open;
                                    obj = randomAccessFile9;
                                    boolean z211 = z2;
                                    randomAccessFile6 = randomAccessFile2;
                                    z7 = z211;
                                    r11 = r12;
                                    r10 = obj;
                                    AndroidRangeTransfer.closeQuietly(r10);
                                    if (r11 != 0) {
                                        r11.disconnect();
                                    }
                                    if (randomAccessFile6 != null) {
                                        if (!z7) {
                                            randomAccessFile6.getFD().sync();
                                            Segment segment114 = this.segment;
                                            segment114.durableDownloaded.set(segment114.downloaded.get());
                                        }
                                        randomAccessFile6.close();
                                        thread4 = null;
                                    } else {
                                        thread4 = null;
                                    }
                                    this.ownerThread = thread4;
                                    throw th;
                                }
                            }
                        } catch (SocketTimeoutException e73) {
                            socketTimeoutException = e73;
                            r3 = Open;
                            inputStream4 = null;
                            r8 = r3;
                            randomAccessFile4 = null;
                            z4 = false;
                            r15 = r8;
                            inputStream7 = inputStream4;
                            if (AndroidRangeTransfer.this.shouldStop()) {
                                z5 = false;
                                AndroidRangeTransfer.this.recordFailure(1008, AndroidRangeTransfer.safeMessage(socketTimeoutException.getMessage()), false);
                            } else {
                                z5 = false;
                            }
                            AndroidRangeTransfer.closeQuietly(inputStream7);
                            if (r15 != 0) {
                                r15.disconnect();
                            }
                            if (randomAccessFile4 != null) {
                                if (!z4) {
                                    randomAccessFile4.getFD().sync();
                                    Segment segment23 = this.segment;
                                    segment23.durableDownloaded.set(segment23.downloaded.get());
                                }
                                randomAccessFile4.close();
                            }
                            z6 = z5;
                            return z6;
                        } catch (IOException e74) {
                            iOException = e74;
                            r5 = Open;
                            inputStream3 = null;
                            r7 = r5;
                            randomAccessFile3 = null;
                            z3 = false;
                            r14 = r7;
                            inputStream6 = inputStream3;
                            if (!AndroidRangeTransfer.this.shouldStop()) {
                                AndroidRangeTransfer.this.recordFailure(1006, AndroidRangeTransfer.safeMessage(iOException.getMessage()), false);
                            }
                            AndroidRangeTransfer.closeQuietly(inputStream6);
                            if (r14 != 0) {
                                r14.disconnect();
                            }
                            if (randomAccessFile3 != null) {
                                if (!z3) {
                                    randomAccessFile3.getFD().sync();
                                    Segment segment115 = this.segment;
                                    segment115.durableDownloaded.set(segment115.downloaded.get());
                                }
                                randomAccessFile3.close();
                            }
                            z5 = false;
                            z6 = z5;
                            return z6;
                        } catch (RuntimeException e75) {
                            runtimeException = e75;
                            r4 = Open;
                            inputStream2 = null;
                            r9 = r4;
                            z7 = false;
                            randomAccessFile5 = null;
                            r13 = r9;
                            inputStream5 = inputStream2;
                            if (!AndroidRangeTransfer.this.shouldStop()) {
                                AndroidRangeTransfer.this.recordFailure(DownloadUtils.ErrorCode.ERROR_UNKNOWN, AndroidRangeTransfer.safeMessage(runtimeException.getMessage()), false);
                            }
                            AndroidRangeTransfer.closeQuietly(inputStream5);
                            if (r13 != 0) {
                                r13.disconnect();
                            }
                            if (randomAccessFile5 != null) {
                                if (!z7) {
                                    randomAccessFile5.getFD().sync();
                                    Segment segment116 = this.segment;
                                    segment116.durableDownloaded.set(segment116.downloaded.get());
                                }
                                randomAccessFile5.close();
                            }
                            z5 = false;
                            z6 = z5;
                            return z6;
                        } catch (Throwable th66) {
                            th = th66;
                            r2 = Open;
                            inputStream = null;
                            r6 = r2;
                            randomAccessFile2 = null;
                            z2 = false;
                            r12 = r6;
                            obj = inputStream;
                            boolean z212 = z2;
                            randomAccessFile6 = randomAccessFile2;
                            z7 = z212;
                            r11 = r12;
                            r10 = obj;
                            AndroidRangeTransfer.closeQuietly(r10);
                            if (r11 != 0) {
                                r11.disconnect();
                            }
                            if (randomAccessFile6 != null) {
                                if (!z7) {
                                    randomAccessFile6.getFD().sync();
                                    Segment segment117 = this.segment;
                                    segment117.durableDownloaded.set(segment117.downloaded.get());
                                }
                                randomAccessFile6.close();
                                thread4 = null;
                            } else {
                                thread4 = null;
                            }
                            this.ownerThread = thread4;
                            throw th;
                        }
                    }
                } catch (Throwable th67) {
                    th = th67;
                    randomAccessFile2 = randomAccessFile;
                    z2 = z;
                    r12 = str;
                    obj = threadCurrentThread;
                }
            } catch (IOException e76) {
                iOException = e76;
                r5 = 0;
            } catch (RuntimeException e77) {
                runtimeException = e77;
                r4 = 0;
            } catch (SocketTimeoutException e78) {
                socketTimeoutException = e78;
                r3 = 0;
            } catch (Throwable th68) {
                th = th68;
                r2 = 0;
            }
            return z6;
        }

        /* JADX INFO: renamed from: lambda$download$0$com-tapsdk-tapad-internal-runtime-download-AndroidRangeTransfer$SegmentWorker, reason: not valid java name */
        /* synthetic */ boolean m272lambda$download$0$comtapsdktapadinternalruntimedownloadAndroidRangeTransfer$SegmentWorker(HttpURLConnection httpURLConnection) {
            return !AndroidRangeTransfer.this.shouldStop();
        }

        public void requestStop(Thread thread) {
            Thread thread2 = this.ownerThread;
            if (thread2 == null || thread2 == thread) {
                return;
            }
            thread2.interrupt();
        }
    }

    public AndroidRangeTransfer(AndroidDownloadRequest androidDownloadRequest, String str, File file, File file2, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, ConnectionFactory connectionFactory, Listener listener, String str2, String str3) {
        this.request = androidDownloadRequest;
        this.sourceUrl = str;
        this.tempFile = file;
        this.checkpointFile = file2;
        this.paused = atomicBoolean;
        this.canceled = atomicBoolean2;
        this.connectionFactory = connectionFactory;
        this.listener = listener;
        this.ownerToken = str2;
        this.threadLabel = str3;
    }

    private File checkpointTempFile() {
        return new File(this.checkpointFile.getPath() + ".new");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void closeQuietly(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    private static Plan createPlan(String str, String str2, long j, String str3, int i) {
        ArrayList arrayList = new ArrayList(i);
        long j2 = i;
        long j3 = j / j2;
        long j4 = j % j2;
        int i2 = 0;
        long j5 = 0;
        while (i2 < i) {
            long j6 = (((long) i2) < j4 ? 1L : 0L) + j3 + j5;
            arrayList.add(new Segment(j5, j6 - 1, 0L));
            i2++;
            j5 = j6;
        }
        return new Plan(str, str2, j, str3, arrayList);
    }

    private static void deleteQuietly(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        file.delete();
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00a6  */
    private Result downloadSegments(Plan plan, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < plan.segments.size(); i++) {
            Segment segment = plan.segments.get(i);
            if (!segment.isComplete()) {
                arrayList.add(new SegmentWorker(i, segment, str));
            }
        }
        if (arrayList.isEmpty()) {
            return Result.completed(plan.totalBytes);
        }
        this.activeWorkers = (SegmentWorker[]) arrayList.toArray(new SegmentWorker[0]);
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(arrayList.size(), new SegmentThreadFactory(this.threadLabel));
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            final SegmentWorker segmentWorker = (SegmentWorker) obj;
            Objects.requireNonNull(segmentWorker);
            arrayList2.add(executorServiceNewFixedThreadPool.submit(new Callable() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidRangeTransfer$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Boolean.valueOf(segmentWorker.download());
                }
            }));
        }
        int size2 = arrayList2.size();
        int i3 = 0;
        boolean z = false;
        boolean z2 = true;
        while (true) {
            if (i3 >= size2) {
                break;
            }
            Object obj2 = arrayList2.get(i3);
            i3++;
            Future future = (Future) obj2;
            boolean z3 = false;
            while (!z3) {
                try {
                    if (!Boolean.TRUE.equals(future.get())) {
                        z2 = false;
                    }
                    z3 = true;
                } catch (InterruptedException e) {
                    this.stopWorkers.set(true);
                    interruptWorkers(Thread.currentThread());
                    z2 = false;
                    z = true;
                } catch (CancellationException e2) {
                    e = e2;
                    if (e.getCause() != null) {
                        e = e.getCause();
                    }
                    recordFailure(1006, safeMessage(e.getMessage()), false);
                    z2 = false;
                    z3 = true;
                } catch (ExecutionException e3) {
                    e = e3;
                    if (e.getCause() != null) {
                        e = e.getCause();
                    }
                    recordFailure(1006, safeMessage(e.getMessage()), false);
                    z2 = false;
                    z3 = true;
                }
            }
        }
        executorServiceNewFixedThreadPool.shutdown();
        while (!executorServiceNewFixedThreadPool.isTerminated()) {
            try {
                executorServiceNewFixedThreadPool.awaitTermination(1L, TimeUnit.SECONDS);
            } catch (InterruptedException e4) {
                this.stopWorkers.set(true);
                interruptWorkers(Thread.currentThread());
                z2 = false;
                z = true;
            }
        }
        this.activeWorkers = new SegmentWorker[0];
        if (z) {
            Thread.currentThread().interrupt();
        }
        saveCheckpointBestEffort(plan);
        if (this.paused.get() || this.canceled.get()) {
            return Result.interrupted(plan.totalBytes);
        }
        if (this.rangeRejected.get()) {
            return Result.unsupported(plan.totalBytes);
        }
        if (z2 && plan.isComplete()) {
            return Result.completed(plan.totalBytes);
        }
        Failure failure = this.firstFailure.get();
        return Result.failed(plan.totalBytes, failure != null ? failure.errorCode : 1006, failure == null ? "Segmented transfer did not complete" : failure.message);
    }

    private static String fingerprint(String str) throws IOException {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                sb.append(Character.forDigit((b >>> 4) & 15, 16));
                sb.append(Character.forDigit(b & cc.m, 16));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new IOException("Unable to bind Range checkpoint", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasExplicitValidatorMismatch(HttpURLConnection httpURLConnection, String str) {
        if (str.isEmpty()) {
            return false;
        }
        String strTrim = trim(httpURLConnection.getHeaderField(isStrongEtag(str) ? "ETag" : "Last-Modified"));
        return !strTrim.isEmpty() && (strTrim.length() > 1024 || !str.equals(strTrim));
    }

    public static boolean hasIdentityEncoding(HttpURLConnection httpURLConnection) {
        String strTrim = trim(httpURLConnection.getHeaderField("Content-Encoding"));
        return strTrim.isEmpty() || "identity".equalsIgnoreCase(strTrim);
    }

    private void interruptWorkers(Thread thread) {
        for (SegmentWorker segmentWorker : this.activeWorkers) {
            segmentWorker.requestStop(thread);
        }
    }

    private Probe interruptedOrUnsupported() {
        return (this.paused.get() || this.canceled.get()) ? new Probe(ProbeOutcome.INTERRUPTED, this.sourceUrl, -1L, "") : new Probe(ProbeOutcome.UNSUPPORTED, this.sourceUrl, -1L, "");
    }

    private static boolean isStrongEtag(String str) {
        return str.length() >= 2 && str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"';
    }

    private Plan loadCheckpoint(String str, long j, String str2, int i) {
        int i2;
        if (!this.checkpointFile.isFile()) {
            return null;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(this.checkpointFile));
            try {
                if (dataInputStream.readInt() == CHECKPOINT_MAGIC && dataInputStream.readInt() == 2 && str.equals(dataInputStream.readUTF())) {
                    String utf = dataInputStream.readUTF();
                    if (dataInputStream.readLong() == j && str2.equals(dataInputStream.readUTF()) && ((!str2.isEmpty() || this.ownerToken.equals(utf)) && (i2 = dataInputStream.readInt()) == i && i2 > 1 && i2 <= 5)) {
                        ArrayList arrayList = new ArrayList(i2);
                        long j2 = 0;
                        for (int i3 = 0; i3 < i2; i3++) {
                            long j3 = dataInputStream.readLong();
                            long j4 = dataInputStream.readLong();
                            long j5 = dataInputStream.readLong();
                            if (j3 == j2 && j4 >= j3 && j4 < j && j5 >= 0 && j5 <= (j4 - j3) + 1) {
                                arrayList.add(new Segment(j3, j4, j5));
                                j2 = j4 + 1;
                            }
                        }
                        if (j2 == j && dataInputStream.read() == -1) {
                            Plan plan = new Plan(str, this.ownerToken, j, str2, arrayList);
                            dataInputStream.close();
                            return plan;
                        }
                    }
                }
                dataInputStream.close();
                return null;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (IOException | RuntimeException e) {
            return null;
        }
    }

    private Plan loadOrCreatePlan(Probe probe, int i) throws IOException {
        String strFingerprint = fingerprint(this.sourceUrl);
        Plan planLoadCheckpoint = this.request.isResumable() ? loadCheckpoint(strFingerprint, probe.totalBytes, probe.validator, i) : null;
        if (planLoadCheckpoint != null && this.tempFile.isFile() && this.tempFile.length() == probe.totalBytes) {
            return planLoadCheckpoint;
        }
        deleteQuietly(this.checkpointFile);
        deleteQuietly(checkpointTempFile());
        truncateOrDelete(this.tempFile);
        return createPlan(strFingerprint, this.ownerToken, probe.totalBytes, probe.validator, i);
    }

    public static ContentRange parseContentRange(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.length() >= 10 && strTrim.regionMatches(true, 0, "bytes ", 0, 6)) {
            int iIndexOf = strTrim.indexOf(45, 6);
            int i = iIndexOf + 1;
            int iIndexOf2 = strTrim.indexOf(47, i);
            if (iIndexOf > 6 && iIndexOf2 > i && iIndexOf2 < strTrim.length() - 1) {
                try {
                    long j = Long.parseLong(strTrim.substring(6, iIndexOf).trim());
                    long j2 = Long.parseLong(strTrim.substring(i, iIndexOf2).trim());
                    long j3 = Long.parseLong(strTrim.substring(iIndexOf2 + 1).trim());
                    if (j >= 0 && j2 >= j && j3 > j2) {
                        return new ContentRange(j, j2, j3);
                    }
                    return null;
                } catch (NumberFormatException e) {
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long positiveContentLength(HttpURLConnection httpURLConnection) {
        String strTrim = trim(httpURLConnection.getHeaderField(Util.CONTENT_LENGTH));
        if (strTrim.isEmpty()) {
            return -1L;
        }
        try {
            long j = Long.parseLong(strTrim);
            if (j > 0) {
                return j;
            }
            return -1L;
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    private void prepareSparseFile(long j) throws IOException {
        File parentFile = this.tempFile.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Unable to create segmented transfer directory");
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.tempFile, "rw");
        try {
            if (randomAccessFile.length() != j) {
                randomAccessFile.setLength(j);
            }
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private Probe probe() throws Throwable {
        HttpURLConnection httpURLConnectionOpen;
        InputStream inputStream;
        InputStream inputStream2;
        Probe probeInterruptedOrUnsupported;
        this.probeThread = Thread.currentThread();
        try {
            try {
                httpURLConnectionOpen = this.connectionFactory.open(this.sourceUrl, "bytes=0-0", null, new ConnectionTracker() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidRangeTransfer$$ExternalSyntheticLambda0
                    @Override // com.tapsdk.tapad.internal.runtime.download.AndroidRangeTransfer.ConnectionTracker
                    public final boolean track(HttpURLConnection httpURLConnection) {
                        return this.f$0.m271lambda$probe$0$comtapsdktapadinternalruntimedownloadAndroidRangeTransfer(httpURLConnection);
                    }
                });
                try {
                    if (shouldStop()) {
                        probeInterruptedOrUnsupported = interruptedOrUnsupported();
                        try {
                            closeQuietly(null);
                            if (httpURLConnectionOpen != null) {
                                try {
                                    httpURLConnectionOpen.disconnect();
                                } finally {
                                    this.probeThread = null;
                                }
                            }
                        } catch (Throwable th) {
                            if (httpURLConnectionOpen != null) {
                                try {
                                    httpURLConnectionOpen.disconnect();
                                } finally {
                                    this.probeThread = null;
                                }
                            }
                            throw th;
                        }
                    } else {
                        int responseCode = httpURLConnectionOpen.getResponseCode();
                        this.listener.onConnected();
                        if (responseCode == 200) {
                            probeInterruptedOrUnsupported = new Probe(ProbeOutcome.UNSUPPORTED, this.sourceUrl, positiveContentLength(httpURLConnectionOpen), "");
                            try {
                                closeQuietly(null);
                                try {
                                    httpURLConnectionOpen.disconnect();
                                } finally {
                                    this.probeThread = null;
                                }
                            } catch (Throwable th2) {
                                try {
                                    httpURLConnectionOpen.disconnect();
                                    throw th2;
                                } finally {
                                    this.probeThread = null;
                                }
                            }
                        } else if (responseCode != 206) {
                            probeInterruptedOrUnsupported = new Probe(ProbeOutcome.UNSUPPORTED, this.sourceUrl, -1L, "");
                            try {
                                closeQuietly(null);
                                try {
                                    httpURLConnectionOpen.disconnect();
                                } finally {
                                    this.probeThread = null;
                                }
                            } catch (Throwable th3) {
                                try {
                                    httpURLConnectionOpen.disconnect();
                                    throw th3;
                                } finally {
                                    this.probeThread = null;
                                }
                            }
                        } else if (hasIdentityEncoding(httpURLConnectionOpen)) {
                            ContentRange contentRange = parseContentRange(httpURLConnectionOpen.getHeaderField(Util.CONTENT_RANGE));
                            if (contentRange == null || contentRange.start != 0 || contentRange.end != 0 || contentRange.total <= 0) {
                                probeInterruptedOrUnsupported = new Probe(ProbeOutcome.UNSUPPORTED, this.sourceUrl, -1L, "");
                                try {
                                    closeQuietly(null);
                                    try {
                                        httpURLConnectionOpen.disconnect();
                                    } finally {
                                        this.probeThread = null;
                                    }
                                } catch (Throwable th4) {
                                    try {
                                        httpURLConnectionOpen.disconnect();
                                        throw th4;
                                    } finally {
                                        this.probeThread = null;
                                    }
                                }
                            } else {
                                long jPositiveContentLength = positiveContentLength(httpURLConnectionOpen);
                                if (jPositiveContentLength <= 0 || jPositiveContentLength == 1) {
                                    inputStream2 = httpURLConnectionOpen.getInputStream();
                                    try {
                                        if (inputStream2.read() < 0 || inputStream2.read() != -1) {
                                            Probe probe = new Probe(ProbeOutcome.UNSUPPORTED, this.sourceUrl, contentRange.total, "");
                                            try {
                                                closeQuietly(inputStream2);
                                                try {
                                                    httpURLConnectionOpen.disconnect();
                                                    probeInterruptedOrUnsupported = probe;
                                                } finally {
                                                    this.probeThread = null;
                                                }
                                            } catch (Throwable th5) {
                                                try {
                                                    httpURLConnectionOpen.disconnect();
                                                    throw th5;
                                                } finally {
                                                    this.probeThread = null;
                                                }
                                            }
                                        } else {
                                            Probe probe2 = new Probe(ProbeOutcome.SUPPORTED, httpURLConnectionOpen.getURL() == null ? this.sourceUrl : httpURLConnectionOpen.getURL().toExternalForm(), contentRange.total, responseValidator(httpURLConnectionOpen));
                                            try {
                                                closeQuietly(inputStream2);
                                                try {
                                                    httpURLConnectionOpen.disconnect();
                                                    probeInterruptedOrUnsupported = probe2;
                                                } finally {
                                                    this.probeThread = null;
                                                }
                                            } catch (Throwable th6) {
                                                try {
                                                    httpURLConnectionOpen.disconnect();
                                                    throw th6;
                                                } finally {
                                                    this.probeThread = null;
                                                }
                                            }
                                        }
                                    } catch (IOException e) {
                                        probeInterruptedOrUnsupported = interruptedOrUnsupported();
                                        try {
                                            closeQuietly(inputStream2);
                                            if (httpURLConnectionOpen != null) {
                                                try {
                                                    httpURLConnectionOpen.disconnect();
                                                } finally {
                                                    this.probeThread = null;
                                                }
                                            }
                                        } catch (Throwable th7) {
                                            if (httpURLConnectionOpen != null) {
                                                try {
                                                    httpURLConnectionOpen.disconnect();
                                                } finally {
                                                    this.probeThread = null;
                                                }
                                            }
                                            throw th7;
                                        }
                                    } catch (RuntimeException e2) {
                                        probeInterruptedOrUnsupported = interruptedOrUnsupported();
                                        try {
                                            closeQuietly(inputStream2);
                                            if (httpURLConnectionOpen != null) {
                                                try {
                                                    httpURLConnectionOpen.disconnect();
                                                } finally {
                                                    this.probeThread = null;
                                                }
                                            }
                                        } catch (Throwable th8) {
                                            if (httpURLConnectionOpen != null) {
                                                try {
                                                    httpURLConnectionOpen.disconnect();
                                                } finally {
                                                    this.probeThread = null;
                                                }
                                            }
                                            throw th8;
                                        }
                                    } catch (SocketTimeoutException e3) {
                                        probeInterruptedOrUnsupported = interruptedOrUnsupported();
                                        try {
                                            closeQuietly(inputStream2);
                                            if (httpURLConnectionOpen != null) {
                                                try {
                                                    httpURLConnectionOpen.disconnect();
                                                } finally {
                                                    this.probeThread = null;
                                                }
                                            }
                                        } catch (Throwable th9) {
                                            if (httpURLConnectionOpen != null) {
                                                try {
                                                    httpURLConnectionOpen.disconnect();
                                                } finally {
                                                    this.probeThread = null;
                                                }
                                            }
                                            throw th9;
                                        }
                                    }
                                } else {
                                    Probe probe3 = new Probe(ProbeOutcome.UNSUPPORTED, this.sourceUrl, contentRange.total, "");
                                    try {
                                        closeQuietly(null);
                                        try {
                                            httpURLConnectionOpen.disconnect();
                                            probeInterruptedOrUnsupported = probe3;
                                        } finally {
                                            this.probeThread = null;
                                        }
                                    } catch (Throwable th10) {
                                        try {
                                            httpURLConnectionOpen.disconnect();
                                            throw th10;
                                        } finally {
                                            this.probeThread = null;
                                        }
                                    }
                                }
                            }
                        } else {
                            probeInterruptedOrUnsupported = new Probe(ProbeOutcome.UNSUPPORTED, this.sourceUrl, -1L, "");
                            try {
                                closeQuietly(null);
                                try {
                                    httpURLConnectionOpen.disconnect();
                                } finally {
                                    this.probeThread = null;
                                }
                            } catch (Throwable th11) {
                                try {
                                    httpURLConnectionOpen.disconnect();
                                    throw th11;
                                } finally {
                                    this.probeThread = null;
                                }
                            }
                        }
                    }
                } catch (SocketTimeoutException e4) {
                    inputStream2 = null;
                } catch (IOException e5) {
                    inputStream2 = null;
                } catch (RuntimeException e6) {
                    inputStream2 = null;
                } catch (Throwable th12) {
                    th = th12;
                    inputStream = null;
                    try {
                        closeQuietly(inputStream);
                        if (httpURLConnectionOpen != null) {
                            try {
                                httpURLConnectionOpen.disconnect();
                            } finally {
                                this.probeThread = null;
                            }
                        }
                        throw th;
                    } catch (Throwable th13) {
                        if (httpURLConnectionOpen != null) {
                            try {
                                httpURLConnectionOpen.disconnect();
                            } finally {
                                this.probeThread = null;
                            }
                        }
                        throw th13;
                    }
                }
            } catch (Throwable th14) {
                th = th14;
            }
        } catch (IOException e7) {
            httpURLConnectionOpen = null;
            inputStream2 = null;
        } catch (RuntimeException e8) {
            httpURLConnectionOpen = null;
            inputStream2 = null;
        } catch (SocketTimeoutException e9) {
            httpURLConnectionOpen = null;
            inputStream2 = null;
        } catch (Throwable th15) {
            th = th15;
            httpURLConnectionOpen = null;
            inputStream = null;
        }
        return probeInterruptedOrUnsupported;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordFailure(int i, String str, boolean z) {
        DirichletAd$$ExternalSyntheticBackportWithForwarding0.m(this.firstFailure, null, new Failure(i, safeMessage(str)));
        if (z) {
            this.rangeRejected.set(true);
        }
        this.stopWorkers.set(true);
        interruptWorkers(Thread.currentThread());
    }

    private static String responseValidator(HttpURLConnection httpURLConnection) {
        String strTrim = trim(httpURLConnection.getHeaderField("ETag"));
        if (strTrim.length() <= 1024 && isStrongEtag(strTrim)) {
            return strTrim;
        }
        String strTrim2 = trim(httpURLConnection.getHeaderField("Last-Modified"));
        return strTrim2.length() <= 1024 ? strTrim2 : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String safeMessage(String str) {
        return (str == null || str.isEmpty()) ? "Segmented transfer failed" : str;
    }

    private void saveCheckpoint(Plan plan) {
        if (!this.request.isResumable() || plan == null) {
            return;
        }
        synchronized (this.checkpointLock) {
            File fileCheckpointTempFile = checkpointTempFile();
            FileOutputStream fileOutputStream = new FileOutputStream(fileCheckpointTempFile);
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
                try {
                    dataOutputStream.writeInt(CHECKPOINT_MAGIC);
                    dataOutputStream.writeInt(2);
                    dataOutputStream.writeUTF(plan.sourceFingerprint);
                    dataOutputStream.writeUTF(plan.ownerToken);
                    dataOutputStream.writeLong(plan.totalBytes);
                    dataOutputStream.writeUTF(plan.validator);
                    dataOutputStream.writeInt(plan.segments.size());
                    for (Segment segment : plan.segments) {
                        dataOutputStream.writeLong(segment.start);
                        dataOutputStream.writeLong(segment.end);
                        dataOutputStream.writeLong(segment.durableDownloaded.get());
                    }
                    dataOutputStream.flush();
                    fileOutputStream.getFD().sync();
                    dataOutputStream.close();
                    fileOutputStream.close();
                    if (this.checkpointFile.exists() && !this.checkpointFile.delete()) {
                        throw new IOException("Unable to replace Range checkpoint");
                    }
                    if (!fileCheckpointTempFile.renameTo(this.checkpointFile)) {
                        throw new IOException("Unable to commit Range checkpoint");
                    }
                } catch (Throwable th) {
                    try {
                        dataOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveCheckpointBestEffort(Plan plan) {
        try {
            saveCheckpoint(plan);
        } catch (IOException e) {
        }
    }

    public static int segmentCount(long j) {
        int i;
        if (j < 2097152 || j > MAX_PARALLEL_SIZE) {
            return 1;
        }
        int iMin = (int) Math.min(5L, Math.max(1L, j / 1048576));
        if (j < 5242880) {
            i = 2;
        } else if (j < 52428800) {
            i = 3;
        } else {
            i = j < 104857600 ? 4 : 5;
        }
        return Math.max(1, Math.min(i, iMin));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldStop() {
        return this.stopWorkers.get() || this.paused.get() || this.canceled.get();
    }

    private static String trim(String str) {
        return str == null ? "" : str.trim();
    }

    private static void truncateOrDelete(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                randomAccessFile.setLength(0L);
                randomAccessFile.close();
            } catch (Throwable th) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
        }
    }

    public void discardPartialState() {
        deleteQuietly(this.checkpointFile);
        deleteQuietly(checkpointTempFile());
        truncateOrDelete(this.tempFile);
    }

    public Result execute() throws Throwable {
        Probe probe = probe();
        ProbeOutcome probeOutcome = probe.outcome;
        if (probeOutcome == ProbeOutcome.UNSUPPORTED) {
            return Result.unsupported(probe.totalBytes);
        }
        if (probeOutcome == ProbeOutcome.INTERRUPTED) {
            return Result.interrupted(probe.totalBytes);
        }
        if (shouldStop()) {
            return Result.interrupted(probe.totalBytes);
        }
        int iSegmentCount = segmentCount(probe.totalBytes);
        if (iSegmentCount <= 1) {
            return Result.unsupported(probe.totalBytes);
        }
        try {
            Plan planLoadOrCreatePlan = loadOrCreatePlan(probe, iSegmentCount);
            saveCheckpoint(planLoadOrCreatePlan);
            prepareSparseFile(planLoadOrCreatePlan.totalBytes);
            if (shouldStop()) {
                return Result.interrupted(planLoadOrCreatePlan.totalBytes);
            }
            this.activePlan = planLoadOrCreatePlan;
            try {
                this.listener.onPrepared(planLoadOrCreatePlan.downloadedBytes(), planLoadOrCreatePlan.totalBytes, planLoadOrCreatePlan.segments.size());
                return downloadSegments(planLoadOrCreatePlan, probe.finalUrl);
            } finally {
                this.activePlan = null;
            }
        } catch (IOException e) {
            return Result.unsupported(probe.totalBytes);
        }
    }

    /* JADX INFO: renamed from: lambda$probe$0$com-tapsdk-tapad-internal-runtime-download-AndroidRangeTransfer, reason: not valid java name */
    /* synthetic */ boolean m271lambda$probe$0$comtapsdktapadinternalruntimedownloadAndroidRangeTransfer(HttpURLConnection httpURLConnection) {
        return !shouldStop();
    }

    public void requestStop() {
        this.stopWorkers.set(true);
        Thread thread = this.probeThread;
        if (thread != null) {
            thread.interrupt();
        }
        interruptWorkers(Thread.currentThread());
    }
}
