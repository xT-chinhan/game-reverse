package com.tapsdk.tapad.internal.runtime;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.PlaybackStateCompat;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bumptech.glide.load.Key;
import com.byazt.fi.BaseConstants;
import com.tapsdk.tapad.internal.ionia.IoniaAdWindowTracker;
import com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader;
import com.taptap.sdk.update.download.core.Util;
import com.umeng.analytics.pro.an;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class AssetTransferExecutor {
    private static final int ACTION_HEADER_BYTES = 48;
    private static final int BUFFER_BYTES = 32768;
    private static final int FACT_HEADER_BYTES = 52;
    private static final int MAX_LOCATION_BYTES = 4096;
    private static final int MAX_MIME_BYTES = 128;
    private static final long MAX_PLATFORM_TIMEOUT_MS = 300000;
    private static final int MAX_URI_BYTES = 8192;
    private static final String TAG = "AssetTransferExecutor";
    private final OkHttpClient baseClient;
    private final Context context;
    private final FactSink factSink;
    private boolean released;
    private final ExecutorService workers;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final ConcurrentHashMap<Long, TaskState> tasks = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.runtime.AssetTransferExecutor$1, reason: invalid class name */
    public class AnonymousClass1 extends WebViewClient {
        final /* synthetic */ CountDownLatch val$done;
        final /* synthetic */ AtomicBoolean val$ready;
        final /* synthetic */ TaskState val$state;
        final /* synthetic */ WebView val$webView;

        public AnonymousClass1(CountDownLatch countDownLatch, AtomicBoolean atomicBoolean, TaskState taskState, WebView webView) {
            this.val$done = countDownLatch;
            this.val$ready = atomicBoolean;
            this.val$state = taskState;
            this.val$webView = webView;
        }

        private void finish(boolean z) {
            if (this.val$done.getCount() == 0) {
                return;
            }
            this.val$ready.set(z);
            this.val$done.countDown();
            Handler handler = AssetTransferExecutor.this.mainHandler;
            final TaskState taskState = this.val$state;
            final WebView webView = this.val$webView;
            handler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.AssetTransferExecutor$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AssetTransferExecutor.AnonymousClass1.lambda$finish$0(taskState, webView);
                }
            });
        }

        static /* synthetic */ void lambda$finish$0(TaskState taskState, WebView webView) {
            if (taskState.clearWebView(webView)) {
                webView.stopLoading();
                webView.destroy();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            finish(true);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            finish(false);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (webResourceRequest == null || webResourceRequest.isForMainFrame()) {
                finish(false);
            }
        }
    }

    public static final class Fact {
        final long durationMs;
        final int height;
        final int httpStatus;
        final String location;
        final String mime;
        final long observedBytes;
        final int outcome;
        final long token;
        final int width;

        public Fact(int i, long j, int i2, int i3, int i4, long j2, long j3, String str, String str2) {
            this.outcome = i;
            this.token = j;
            this.httpStatus = Math.max(0, i2);
            this.width = i3;
            this.height = i4;
            this.observedBytes = j2;
            this.durationMs = j3;
            this.location = str;
            this.mime = str2;
        }

        public static Fact failed(long j, int i, int i2) {
            return new Fact(i, j, i2, 0, 0, 0L, 0L, "", "");
        }

        public static Fact ready(long j, int i, int i2, int i3, long j2, long j3, String str) {
            return new Fact(1, j, i, i2, i3, j2, j3, "", AssetTransferExecutor.canonicalMime(str));
        }

        public static Fact redirect(long j, int i, String str) {
            return new Fact(2, j, i, 0, 0, 0L, 0L, str, "");
        }

        public byte[] encode() {
            String str = this.location;
            Charset charset = StandardCharsets.UTF_8;
            byte[] bytes = str.getBytes(charset);
            byte[] bytes2 = this.mime.getBytes(charset);
            ByteBuffer byteBufferOrder = ByteBuffer.allocate(bytes.length + 52 + bytes2.length).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put((byte) 68).put((byte) 82).put((byte) 65).put((byte) 70);
            byteBufferOrder.putShort((short) 1);
            byteBufferOrder.put((byte) this.outcome).put((byte) 0);
            byteBufferOrder.putLong(this.token).putInt(this.httpStatus).putInt(this.width).putInt(this.height);
            byteBufferOrder.putLong(this.observedBytes).putLong(this.durationMs);
            byteBufferOrder.putInt(bytes.length).putInt(bytes2.length);
            byteBufferOrder.put(bytes).put(bytes2);
            return byteBufferOrder.array();
        }
    }

    public interface FactSink {
        void submit(byte[] bArr);
    }

    public static final class Probe {
        final long durationMs;
        final int height;
        final String mime;
        final boolean ready;
        final int width;

        public Probe(boolean z, int i, int i2, long j, String str) {
            this.ready = z;
            this.width = i;
            this.height = i2;
            this.durationMs = j;
            this.mime = str;
        }
    }

    public static final class TaskState {
        volatile Call call;
        volatile MediaMetadataRetriever retriever;
        final long token;
        volatile CountDownLatch waitLatch;
        volatile WebView webView;
        volatile Thread worker;
        final AtomicBoolean cancelled = new AtomicBoolean(false);
        final AtomicBoolean terminal = new AtomicBoolean(false);

        public TaskState(long j) {
            this.token = j;
        }

        static /* synthetic */ void lambda$cancel$0(WebView webView) {
            webView.stopLoading();
            webView.destroy();
        }

        public void cancel() {
            Call call;
            Thread thread;
            CountDownLatch countDownLatch;
            MediaMetadataRetriever mediaMetadataRetriever;
            final WebView webView;
            synchronized (this) {
                this.cancelled.set(true);
                call = this.call;
                this.call = null;
                thread = this.worker;
                this.worker = null;
                countDownLatch = this.waitLatch;
                this.waitLatch = null;
                mediaMetadataRetriever = this.retriever;
                this.retriever = null;
                webView = this.webView;
                this.webView = null;
            }
            if (call != null) {
                call.cancel();
            }
            if (thread != null) {
                thread.interrupt();
            }
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            if (mediaMetadataRetriever != null) {
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e) {
                }
            }
            if (webView != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.AssetTransferExecutor$TaskState$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AssetTransferExecutor.TaskState.lambda$cancel$0(webView);
                    }
                });
            }
        }

        public synchronized void clearCall(Call call) {
            if (this.call == call) {
                this.call = null;
            }
        }

        public synchronized void clearRetriever(MediaMetadataRetriever mediaMetadataRetriever) {
            if (this.retriever == mediaMetadataRetriever) {
                this.retriever = null;
            }
        }

        public synchronized void clearWaitLatch(CountDownLatch countDownLatch) {
            if (this.waitLatch == countDownLatch) {
                this.waitLatch = null;
            }
        }

        public synchronized boolean clearWebView(WebView webView) {
            if (this.webView != webView) {
                return false;
            }
            this.webView = null;
            return true;
        }

        public synchronized void clearWorker(Thread thread) {
            if (this.worker == thread) {
                this.worker = null;
            }
        }

        public synchronized boolean installCall(Call call) {
            if (this.cancelled.get()) {
                return false;
            }
            this.call = call;
            return true;
        }

        public synchronized boolean installRetriever(MediaMetadataRetriever mediaMetadataRetriever) {
            if (this.cancelled.get()) {
                return false;
            }
            this.retriever = mediaMetadataRetriever;
            return true;
        }

        public synchronized boolean installWaitLatch(CountDownLatch countDownLatch) {
            if (this.cancelled.get()) {
                return false;
            }
            this.waitLatch = countDownLatch;
            return true;
        }

        public synchronized boolean installWebView(WebView webView) {
            if (this.cancelled.get()) {
                return false;
            }
            this.webView = webView;
            return true;
        }

        public synchronized boolean installWorker(Thread thread) {
            if (this.cancelled.get()) {
                return false;
            }
            this.worker = thread;
            return true;
        }
    }

    public static final class TooLargeException extends Exception {
        private TooLargeException() {
        }

        public /* synthetic */ TooLargeException(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public AssetTransferExecutor(Context context, FactSink factSink) {
        this.context = context.getApplicationContext();
        this.factSink = factSink;
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        this.workers = Executors.newFixedThreadPool(4, new ThreadFactory() { // from class: com.tapsdk.tapad.internal.runtime.AssetTransferExecutor$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return AssetTransferExecutor.lambda$new$0(atomicInteger, runnable);
            }
        });
        this.baseClient = new OkHttpClient.Builder().retryOnConnectionFailure(false).followRedirects(false).followSslRedirects(false).build();
    }

    private static long boundedTimeout(long j) {
        return Math.max(1L, Math.min(j, MAX_PLATFORM_TIMEOUT_MS));
    }

    private void cancel(long j) {
        TaskState taskStateRemove = this.tasks.remove(Long.valueOf(j));
        if (taskStateRemove != null) {
            taskStateRemove.cancel();
        }
    }

    private static String canonicalLocation(String str) {
        return (str == null || str.isEmpty() || str.getBytes(StandardCharsets.UTF_8).length > 4096 || hasControl(str)) ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String canonicalMime(String str) {
        if (str == null) {
            return "";
        }
        String lowerCase = str.split(";", 2)[0].trim().toLowerCase(Locale.US);
        return (lowerCase.isEmpty() || hasControl(lowerCase) || lowerCase.getBytes(StandardCharsets.UTF_8).length > 128) ? "" : lowerCase;
    }

    private static String decodeUtf8(byte[] bArr) {
        CharsetDecoder charsetDecoderNewDecoder = StandardCharsets.UTF_8.newDecoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        return charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(bArr)).toString();
    }

    private static String exceptionTypes(Throwable th) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (th != null && i < 4) {
            if (sb.length() > 0) {
                sb.append("->");
            }
            String simpleName = th.getClass().getSimpleName();
            if (simpleName.isEmpty()) {
                simpleName = th.getClass().getName();
            }
            sb.append(simpleName);
            Throwable cause = th.getCause();
            if (cause == th) {
                break;
            }
            i++;
            th = cause;
        }
        return sb.toString();
    }

    private Fact fetchAndProbe(Action action, TaskState taskState) {
        if (!isHttpsUri(action.sourceUri)) {
            return Fact.failed(action.transferToken, 3, 0);
        }
        long jBoundedTimeout = boundedTimeout(action.remainingDeadlineMs);
        OkHttpClient.Builder builderNewBuilder = this.baseClient.newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Call callNewCall = builderNewBuilder.callTimeout(jBoundedTimeout, timeUnit).connectTimeout(Math.min(jBoundedTimeout, 20000L), timeUnit).readTimeout(Math.min(jBoundedTimeout, 60000L), timeUnit).build().newCall(new Request.Builder().url(action.sourceUri).get().build());
        if (!taskState.installCall(callNewCall)) {
            callNewCall.cancel();
            return Fact.failed(action.transferToken, 5, 0);
        }
        try {
            Response responseExecute = callNewCall.execute();
            try {
                int iCode = responseExecute.code();
                if (isRedirect(iCode)) {
                    String strCanonicalLocation = canonicalLocation(responseExecute.header("Location", ""));
                    if (strCanonicalLocation.isEmpty()) {
                        Fact factFailed = Fact.failed(action.transferToken, 8, iCode);
                        responseExecute.close();
                        taskState.clearCall(callNewCall);
                        return factFailed;
                    }
                    Fact factRedirect = Fact.redirect(action.transferToken, iCode, strCanonicalLocation);
                    responseExecute.close();
                    taskState.clearCall(callNewCall);
                    return factRedirect;
                }
                if (iCode < 200 || iCode > 299) {
                    Fact factFailed2 = Fact.failed(action.transferToken, 8, iCode);
                    responseExecute.close();
                    taskState.clearCall(callNewCall);
                    return factFailed2;
                }
                ResponseBody responseBodyBody = responseExecute.body();
                if (responseBodyBody == null) {
                    Fact factFailed3 = Fact.failed(action.transferToken, 3, iCode);
                    responseExecute.close();
                    taskState.clearCall(callNewCall);
                    return factFailed3;
                }
                if (responseBodyBody.contentLength() > action.maximumBytes) {
                    throw new TooLargeException(null);
                }
                File fileFileFromUri = fileFromUri(action.stagingUri);
                long jStreamToFile = streamToFile(responseBodyBody.byteStream(), fileFileFromUri, action.maximumBytes, taskState);
                Probe probeProbeFile = probeFile(action.kind, fileFileFromUri, action.stagingUri, action.remainingDeadlineMs, taskState);
                if (!probeProbeFile.ready) {
                    Fact factFailed4 = Fact.failed(action.transferToken, 4, iCode);
                    responseExecute.close();
                    taskState.clearCall(callNewCall);
                    return factFailed4;
                }
                Fact yVar = Fact.ready(action.transferToken, iCode, probeProbeFile.width, probeProbeFile.height, jStreamToFile, probeProbeFile.durationMs, canonicalMime(responseExecute.header("Content-Type", probeProbeFile.mime)));
                responseExecute.close();
                taskState.clearCall(callNewCall);
                return yVar;
            } catch (Throwable th) {
                if (responseExecute == null) {
                    throw th;
                }
                try {
                    responseExecute.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            taskState.clearCall(callNewCall);
            throw th3;
        }
    }

    private static File fileFromUri(String str) {
        return RustResolvedAsset.requireLocalFile(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasControl(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt == 127) {
                return true;
            }
        }
        return false;
    }

    private static String hostForLog(String str) {
        try {
            String host = Uri.parse(str).getHost();
            if (host != null && !host.isEmpty()) {
                return host.toLowerCase(Locale.US);
            }
            return "<relative-or-invalid>";
        } catch (RuntimeException e) {
            return "<invalid>";
        }
    }

    public static boolean isCanonicalActionForTesting(byte[] bArr) {
        try {
            Action.decode(bArr);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    private static boolean isDiskFull(Throwable th) {
        while (th != null) {
            String message = th.getMessage();
            if (message != null && (message.contains("ENOSPC") || message.toLowerCase(Locale.US).contains("no space left"))) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    private static boolean isHttpsUri(String str) {
        return BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(Uri.parse(str).getScheme());
    }

    private static boolean isRedirect(int i) {
        return i == 301 || i == 302 || i == 303 || i == 307 || i == 308;
    }

    static /* synthetic */ Thread lambda$new$0(AtomicInteger atomicInteger, Runnable runnable) {
        Thread thread = new Thread(runnable, "DirichletAsset-" + atomicInteger.getAndIncrement());
        thread.setDaemon(true);
        return thread;
    }

    static /* synthetic */ void lambda$probeHtml$3(TaskState taskState, WebView webView) {
        if (taskState.clearWebView(webView)) {
            webView.stopLoading();
            webView.destroy();
        }
    }

    private static void logFact(Action action, Fact fact) {
        int i = fact.outcome;
        if (i == 1) {
            return;
        }
        if (i != 2) {
            int i2 = action.operation;
            hostForLog(action.sourceUri);
        } else {
            int i3 = action.operation;
            hostForLog(action.sourceUri);
            hostForLog(fact.location);
        }
    }

    private static int parsePositiveInt(String str) {
        try {
            return Math.max(0, Integer.parseInt(str));
        } catch (Exception e) {
            return 0;
        }
    }

    private static long parsePositiveLong(String str) {
        try {
            return Math.max(0L, Long.parseLong(str));
        } catch (Exception e) {
            return 0L;
        }
    }

    private Probe probeFile(int i, File file, String str, long j, TaskState taskState) {
        switch (i) {
            case 1:
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                int i2 = options.outWidth;
                return new Probe(i2 > 0 && options.outHeight > 0, Math.max(0, i2), Math.max(0, options.outHeight), 0L, canonicalMime(options.outMimeType));
            case 2:
                return probeVideo(file.getAbsolutePath(), taskState);
            case 3:
            default:
                return new Probe(false, 0, 0, 0L, "");
            case 4:
                return probeLottie(file);
            case 5:
                return probeHtml(file, str, j, taskState);
            case 6:
                return new Probe(true, 0, 0, 0L, "application/zip");
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x004e  */
    private Probe probeHtml(File file, final String str, long j, final TaskState taskState) {
        boolean z;
        final WebView webView;
        final String strDecodeUtf8 = decodeUtf8(readBounded(file, RustResolvedAsset.MAX_HTML_BYTES));
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.AssetTransferExecutor$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m198lambda$probeHtml$2$comtapsdktapadinternalruntimeAssetTransferExecutor(taskState, countDownLatch, atomicBoolean, str, strDecodeUtf8);
            }
        });
        long jMin = Math.min(boundedTimeout(j), IoniaAdWindowTracker.BANNER_WINDOW_IDLE_TIMEOUT_MS);
        if (taskState.installWaitLatch(countDownLatch)) {
            try {
                if (countDownLatch.await(jMin, TimeUnit.MILLISECONDS)) {
                    z = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                taskState.clearWaitLatch(countDownLatch);
                throw th;
            }
        } else {
            z = false;
        }
        taskState.clearWaitLatch(countDownLatch);
        if (!z && (webView = taskState.webView) != null) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.AssetTransferExecutor$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    AssetTransferExecutor.lambda$probeHtml$3(taskState, webView);
                }
            });
        }
        return new Probe(z && atomicBoolean.get(), 0, 0, 0L, "text/html");
    }

    private Fact probeLocal(Action action, TaskState taskState) {
        File fileFileFromUri = fileFromUri(action.sourceUri);
        if (!fileFileFromUri.isFile() || fileFileFromUri.length() <= 0 || fileFileFromUri.length() > action.maximumBytes) {
            return Fact.failed(action.transferToken, 4, 0);
        }
        Probe probeProbeFile = probeFile(action.kind, fileFileFromUri, action.sourceUri, action.remainingDeadlineMs, taskState);
        return !probeProbeFile.ready ? Fact.failed(action.transferToken, 4, 0) : Fact.ready(action.transferToken, 0, probeProbeFile.width, probeProbeFile.height, 0L, probeProbeFile.durationMs, probeProbeFile.mime);
    }

    private Probe probeLottie(File file) {
        try {
            JSONObject jSONObject = new JSONObject(decodeUtf8(readBounded(file, 4194304)));
            boolean z = false;
            int iOptInt = jSONObject.optInt("w", 0);
            int iOptInt2 = jSONObject.optInt(an.aG, 0);
            if (iOptInt > 0 && iOptInt2 > 0) {
                z = true;
            }
            return new Probe(z, iOptInt, iOptInt2, 0L, "application/json");
        } catch (Exception e) {
            return new Probe(false, 0, 0, 0L, "");
        }
    }

    private Fact probeStream(Action action, TaskState taskState) {
        if (!isHttpsUri(action.sourceUri)) {
            return Fact.failed(action.transferToken, 4, 0);
        }
        long jBoundedTimeout = boundedTimeout(action.remainingDeadlineMs);
        OkHttpClient.Builder builderNewBuilder = this.baseClient.newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Call callNewCall = builderNewBuilder.callTimeout(jBoundedTimeout, timeUnit).connectTimeout(Math.min(jBoundedTimeout, 20000L), timeUnit).readTimeout(Math.min(jBoundedTimeout, 60000L), timeUnit).build().newCall(streamPreflightRequest(action.sourceUri));
        if (!taskState.installCall(callNewCall)) {
            callNewCall.cancel();
            return Fact.failed(action.transferToken, 5, 0);
        }
        try {
            Response responseExecute = callNewCall.execute();
            try {
                int iCode = responseExecute.code();
                if (isRedirect(iCode)) {
                    String strCanonicalLocation = canonicalLocation(responseExecute.header("Location", ""));
                    if (strCanonicalLocation.isEmpty()) {
                        Fact factFailed = Fact.failed(action.transferToken, 8, iCode);
                        responseExecute.close();
                        taskState.clearCall(callNewCall);
                        return factFailed;
                    }
                    Fact factRedirect = Fact.redirect(action.transferToken, iCode, strCanonicalLocation);
                    responseExecute.close();
                    taskState.clearCall(callNewCall);
                    return factRedirect;
                }
                if (iCode < 200 || iCode > 299) {
                    Fact factFailed2 = Fact.failed(action.transferToken, 8, iCode);
                    responseExecute.close();
                    taskState.clearCall(callNewCall);
                    return factFailed2;
                }
                String strCanonicalMime = canonicalMime(responseExecute.header("Content-Type", ""));
                responseExecute.close();
                taskState.clearCall(callNewCall);
                return taskState.cancelled.get() ? Fact.failed(action.transferToken, 5, iCode) : Fact.ready(action.transferToken, iCode, 0, 0, 0L, 0L, strCanonicalMime);
            } catch (Throwable th) {
                if (responseExecute == null) {
                    throw th;
                }
                try {
                    responseExecute.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            taskState.clearCall(callNewCall);
            throw th3;
        }
    }

    private Probe probeVideo(String str, TaskState taskState) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        if (!taskState.installRetriever(mediaMetadataRetriever)) {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e) {
            }
            return new Probe(false, 0, 0, 0L, "");
        }
        try {
            if (str.startsWith("https://")) {
                mediaMetadataRetriever.setDataSource(str, new HashMap());
            } else {
                mediaMetadataRetriever.setDataSource(str);
            }
            int positiveInt = parsePositiveInt(mediaMetadataRetriever.extractMetadata(18));
            int positiveInt2 = parsePositiveInt(mediaMetadataRetriever.extractMetadata(19));
            long positiveLong = parsePositiveLong(mediaMetadataRetriever.extractMetadata(9));
            Probe probe = new Probe(positiveInt > 0 && positiveInt2 > 0 && positiveLong > 0, positiveInt, positiveInt2, positiveLong, "video/*");
            try {
                return probe;
            } catch (Exception e2) {
                return probe;
            }
        } catch (RuntimeException e3) {
            return new Probe(false, 0, 0, 0L, "");
        } finally {
            taskState.clearRetriever(mediaMetadataRetriever);
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e4) {
            }
        }
    }

    private static byte[] readBounded(File file, int i) throws IOException {
        if (!file.isFile() || file.length() <= 0 || file.length() > i) {
            throw new IOException("invalid local asset");
        }
        int length = (int) file.length();
        byte[] bArr = new byte[length];
        int i2 = 0;
        FileInputStream fileInputStream = new FileInputStream(file);
        while (i2 < length) {
            try {
                int i3 = fileInputStream.read(bArr, i2, length - i2);
                if (i3 < 0) {
                    throw new IOException("truncated local asset");
                }
                i2 += i3;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        fileInputStream.close();
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: run, reason: merged with bridge method [inline-methods] */
    public void m197lambda$execute$1$comtapsdktapadinternalruntimeAssetTransferExecutor(Action action, TaskState taskState) {
        Fact factFetchAndProbe;
        if (taskState.installWorker(Thread.currentThread())) {
            try {
                try {
                    try {
                        int i = action.operation;
                        if (i == 1) {
                            factFetchAndProbe = fetchAndProbe(action, taskState);
                        } else if (i != 2) {
                            factFetchAndProbe = i != 3 ? Fact.failed(action.transferToken, 4, 0) : probeStream(action, taskState);
                        } else {
                            factFetchAndProbe = probeLocal(action, taskState);
                        }
                        if (!taskState.cancelled.get() && taskState.terminal.compareAndSet(false, true)) {
                            logFact(action, factFetchAndProbe);
                            this.factSink.submit(factFetchAndProbe.encode());
                        }
                        taskState.clearWorker(Thread.currentThread());
                        if (taskState.cancelled.get() && !action.stagingUri.isEmpty()) {
                            fileFromUri(action.stagingUri).delete();
                        }
                    } catch (Throwable th) {
                        taskState.clearWorker(Thread.currentThread());
                        if (taskState.cancelled.get() && !action.stagingUri.isEmpty()) {
                            try {
                                fileFromUri(action.stagingUri).delete();
                            } catch (IOException e) {
                            }
                        }
                        this.tasks.remove(Long.valueOf(action.transferToken), taskState);
                        throw th;
                    }
                } catch (TooLargeException e2) {
                    int i2 = action.operation;
                    hostForLog(action.sourceUri);
                    submitFailure(taskState, action.transferToken, 7, 0);
                    taskState.clearWorker(Thread.currentThread());
                    if (taskState.cancelled.get() && !action.stagingUri.isEmpty()) {
                        fileFromUri(action.stagingUri).delete();
                    }
                } catch (Throwable th2) {
                    int i3 = isDiskFull(th2) ? 6 : 3;
                    int i4 = action.operation;
                    hostForLog(action.sourceUri);
                    exceptionTypes(th2);
                    submitFailure(taskState, action.transferToken, i3, 0);
                    taskState.clearWorker(Thread.currentThread());
                    if (taskState.cancelled.get() && !action.stagingUri.isEmpty()) {
                        fileFromUri(action.stagingUri).delete();
                    }
                }
            } catch (IOException e3) {
            }
            this.tasks.remove(Long.valueOf(action.transferToken), taskState);
        }
    }

    private static Request streamPreflightRequest(String str) {
        return new Request.Builder().url(str).header(Util.RANGE, "bytes=0-0").get().build();
    }

    public static Request streamPreflightRequestForTesting(String str) {
        return streamPreflightRequest(str);
    }

    private static long streamToFile(InputStream inputStream, File file, long j, TaskState taskState) throws IOException {
        File parentFile = file.getParentFile();
        if (parentFile == null || !parentFile.isDirectory()) {
            throw new IOException("missing staging root");
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                try {
                    byte[] bArr = new byte[32768];
                    long j2 = 0;
                    while (!taskState.cancelled.get()) {
                        int i = bufferedInputStream.read(bArr);
                        if (i < 0) {
                            fileOutputStream.flush();
                            fileOutputStream.getFD().sync();
                            fileOutputStream.close();
                            bufferedInputStream.close();
                            if (j2 > 0) {
                                return j2;
                            }
                            throw new IOException("empty asset");
                        }
                        j2 += (long) i;
                        if (j2 > j) {
                            throw new TooLargeException(null);
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                    throw new IOException("cancelled");
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (TooLargeException | IOException e) {
            file.delete();
            throw e;
        }
    }

    private void submitFailure(TaskState taskState, long j, int i, int i2) {
        if (taskState.cancelled.get() || !taskState.terminal.compareAndSet(false, true)) {
            return;
        }
        this.factSink.submit(Fact.failed(j, i, i2).encode());
    }

    public synchronized void execute(byte[] bArr) {
        if (!this.released) {
            try {
                final Action actionDecode = Action.decode(bArr);
                int i = actionDecode.operation;
                if (i == 4) {
                    cancel(actionDecode.transferToken);
                } else {
                    if (i == 5) {
                        MechanicalImageLoader.dropDecoded(actionDecode.sourceUri);
                        return;
                    }
                    final TaskState taskState = new TaskState(actionDecode.transferToken);
                    if (this.tasks.putIfAbsent(Long.valueOf(actionDecode.transferToken), taskState) == null) {
                        this.workers.execute(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.AssetTransferExecutor$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.m197lambda$execute$1$comtapsdktapadinternalruntimeAssetTransferExecutor(actionDecode, taskState);
                            }
                        });
                    }
                }
            } catch (RuntimeException e) {
            }
        }
    }

    /* JADX INFO: renamed from: lambda$probeHtml$2$com-tapsdk-tapad-internal-runtime-AssetTransferExecutor, reason: not valid java name */
    /* synthetic */ void m198lambda$probeHtml$2$comtapsdktapadinternalruntimeAssetTransferExecutor(TaskState taskState, CountDownLatch countDownLatch, AtomicBoolean atomicBoolean, String str, String str2) {
        if (taskState.cancelled.get()) {
            countDownLatch.countDown();
            return;
        }
        WebView webView = new WebView(this.context);
        if (!taskState.installWebView(webView)) {
            webView.destroy();
            countDownLatch.countDown();
            return;
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(false);
        webView.getSettings().setAllowFileAccessFromFileURLs(false);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
        webView.setWebViewClient(new AnonymousClass1(countDownLatch, atomicBoolean, taskState, webView));
        webView.loadDataWithBaseURL(str, str2, "text/html", Key.STRING_CHARSET_NAME, null);
    }

    public synchronized void release() {
        if (this.released) {
            return;
        }
        this.released = true;
        Iterator<TaskState> it = this.tasks.values().iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        this.tasks.clear();
        this.workers.shutdownNow();
    }

    public static final class Action {
        final int kind;
        final long maximumBytes;
        final int operation;
        final long remainingDeadlineMs;
        final String sourceUri;
        final String stagingUri;
        final long transferToken;

        public Action(int i, int i2, long j, long j2, long j3, String str, String str2) {
            this.operation = i;
            this.kind = i2;
            this.transferToken = j;
            this.maximumBytes = j2;
            this.remainingDeadlineMs = j3;
            this.sourceUri = str;
            this.stagingUri = str2;
        }

        public static Action decode(byte[] bArr) {
            if (bArr != null && bArr.length >= 48) {
                if (bArr[0] == 68 && bArr[1] == 82 && bArr[2] == 65 && bArr[3] == 65) {
                    ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                    byteBufferOrder.position(4);
                    if (Short.toUnsignedInt(byteBufferOrder.getShort()) != 1) {
                        throw new IllegalArgumentException("bad DRAA version");
                    }
                    int unsignedInt = Byte.toUnsignedInt(byteBufferOrder.get());
                    int unsignedInt2 = Byte.toUnsignedInt(byteBufferOrder.get());
                    long j = byteBufferOrder.getLong();
                    long j2 = byteBufferOrder.getLong();
                    long j3 = byteBufferOrder.getLong();
                    long j4 = byteBufferOrder.getLong();
                    long unsignedLong = Integer.toUnsignedLong(byteBufferOrder.getInt());
                    long unsignedLong2 = Integer.toUnsignedLong(byteBufferOrder.getInt());
                    boolean z = unsignedInt == 5;
                    if (unsignedInt < 1 || unsignedInt > 5 || unsignedInt2 < 1 || unsignedInt2 > 6 || unsignedLong > PlaybackStateCompat.ACTION_PLAY_FROM_URI || unsignedLong2 > PlaybackStateCompat.ACTION_PLAY_FROM_URI || 48 + unsignedLong + unsignedLong2 != bArr.length || ((!z && (j == 0 || j2 == 0)) || ((z && j != 0) || j3 < 0 || j4 < 0))) {
                        throw new IllegalArgumentException("invalid DRAA shape");
                    }
                    int i = ((int) unsignedLong) + 48;
                    String strDecode = decode(bArr, 48, i);
                    String strDecode2 = decode(bArr, i, bArr.length);
                    if (AssetTransferExecutor.hasControl(strDecode) || AssetTransferExecutor.hasControl(strDecode2) || !validOperationShape(unsignedInt, unsignedInt2, j, j3, j4, strDecode, strDecode2)) {
                        throw new IllegalArgumentException("invalid DRAA operation shape");
                    }
                    return new Action(unsignedInt, unsignedInt2, j, j3, j4, strDecode, strDecode2);
                }
            }
            throw new IllegalArgumentException("bad DRAA");
        }

        private static boolean validOperationShape(int i, int i2, long j, long j2, long j3, String str, String str2) {
            switch (i) {
                case 1:
                    return (j == 0 || j2 <= 0 || j3 <= 0 || str.isEmpty() || str2.isEmpty() || i2 == 3) ? false : true;
                case 2:
                    return j != 0 && j2 > 0 && j3 > 0 && !str.isEmpty() && str2.isEmpty() && i2 != 3;
                case 3:
                    return j != 0 && j2 == 0 && j3 > 0 && !str.isEmpty() && str2.isEmpty() && i2 == 3;
                case 4:
                    return j != 0 && j2 == 0 && j3 == 0 && str.isEmpty() && str2.isEmpty();
                case 5:
                    return j == 0 && j2 == 0 && j3 == 0 && !str.isEmpty() && str2.isEmpty();
                default:
                    return false;
            }
        }

        private static String decode(byte[] bArr, int i, int i2) {
            try {
                CharsetDecoder charsetDecoderNewDecoder = StandardCharsets.UTF_8.newDecoder();
                CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
                return charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(bArr, i, i2 - i)).toString();
            } catch (CharacterCodingException e) {
                throw new IllegalArgumentException("invalid DRAA UTF-8", e);
            }
        }
    }
}
