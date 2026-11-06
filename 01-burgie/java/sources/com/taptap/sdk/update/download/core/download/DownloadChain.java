package com.taptap.sdk.update.download.core.download;

import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.OkDownload;
import com.taptap.sdk.update.download.core.Util;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.breakpoint.DownloadStore;
import com.taptap.sdk.update.download.core.connection.DownloadConnection;
import com.taptap.sdk.update.download.core.dispatcher.CallbackDispatcher;
import com.taptap.sdk.update.download.core.exception.InterruptException;
import com.taptap.sdk.update.download.core.file.MultiPointOutputStream;
import com.taptap.sdk.update.download.core.interceptor.BreakpointInterceptor;
import com.taptap.sdk.update.download.core.interceptor.FetchDataInterceptor;
import com.taptap.sdk.update.download.core.interceptor.Interceptor;
import com.taptap.sdk.update.download.core.interceptor.RetryInterceptor;
import com.taptap.sdk.update.download.core.interceptor.connect.CallServerInterceptor;
import com.taptap.sdk.update.download.core.interceptor.connect.HeaderInterceptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadChain implements Runnable {
    private static final ExecutorService EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkDownload Cancel Block", false));
    private static final String TAG = "DownloadChain";
    private final int blockIndex;
    private final DownloadCache cache;
    private volatile DownloadConnection connection;
    volatile Thread currentThread;
    private final BreakpointInfo info;
    long noCallbackIncreaseBytes;
    private long responseContentLength;
    private final DownloadStore store;
    private final DownloadTask task;
    final List<Interceptor.Connect> connectInterceptorList = new ArrayList();
    final List<Interceptor.Fetch> fetchInterceptorList = new ArrayList();
    int connectIndex = 0;
    int fetchIndex = 0;
    final AtomicBoolean finished = new AtomicBoolean(false);
    private final Runnable releaseConnectionRunnable = new Runnable() { // from class: com.taptap.sdk.update.download.core.download.DownloadChain$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.releaseConnection();
        }
    };
    private final CallbackDispatcher callbackDispatcher = OkDownload.with().callbackDispatcher();

    static DownloadChain createChain(int blockIndex, DownloadTask task, BreakpointInfo info, DownloadCache cache, DownloadStore store) {
        return new DownloadChain(blockIndex, task, info, cache, store);
    }

    private DownloadChain(int blockIndex, DownloadTask task, BreakpointInfo info, DownloadCache cache, DownloadStore store) {
        this.blockIndex = blockIndex;
        this.task = task;
        this.cache = cache;
        this.info = info;
        this.store = store;
    }

    public long getResponseContentLength() {
        return this.responseContentLength;
    }

    public void setResponseContentLength(long responseContentLength) {
        this.responseContentLength = responseContentLength;
    }

    public void cancel() {
        if (this.finished.get() || this.currentThread == null) {
            return;
        }
        this.currentThread.interrupt();
    }

    public DownloadTask getTask() {
        return this.task;
    }

    public BreakpointInfo getInfo() {
        return this.info;
    }

    public int getBlockIndex() {
        return this.blockIndex;
    }

    public synchronized void setConnection(DownloadConnection connection) {
        this.connection = connection;
    }

    public DownloadCache getCache() {
        return this.cache;
    }

    public void setRedirectLocation(String location) {
        this.cache.setRedirectLocation(location);
    }

    public MultiPointOutputStream getOutputStream() {
        return this.cache.getOutputStream();
    }

    public synchronized DownloadConnection getConnection() {
        return this.connection;
    }

    public synchronized DownloadConnection getConnectionOrCreate() throws IOException {
        String url;
        if (this.cache.isInterrupt()) {
            throw InterruptException.SIGNAL;
        }
        if (this.connection == null) {
            String redirectLocation = this.cache.getRedirectLocation();
            if (redirectLocation != null) {
                url = redirectLocation;
            } else {
                url = this.info.getUrl();
            }
            Util.d(TAG, "create connection on url: " + url);
            this.connection = OkDownload.with().connectionFactory().create(url);
        }
        return this.connection;
    }

    public void increaseCallbackBytes(long increaseBytes) {
        this.noCallbackIncreaseBytes += increaseBytes;
    }

    public void flushNoCallbackIncreaseBytes() {
        if (this.noCallbackIncreaseBytes == 0) {
            return;
        }
        this.callbackDispatcher.dispatch().fetchProgress(this.task, this.blockIndex, this.noCallbackIncreaseBytes);
        this.noCallbackIncreaseBytes = 0L;
    }

    void start() throws IOException {
        CallbackDispatcher dispatcher = OkDownload.with().callbackDispatcher();
        RetryInterceptor retryInterceptor = new RetryInterceptor();
        BreakpointInterceptor breakpointInterceptor = new BreakpointInterceptor();
        this.connectInterceptorList.add(retryInterceptor);
        this.connectInterceptorList.add(breakpointInterceptor);
        this.connectInterceptorList.add(new HeaderInterceptor());
        this.connectInterceptorList.add(new CallServerInterceptor());
        this.connectIndex = 0;
        DownloadConnection.Connected connected = processConnect();
        if (this.cache.isInterrupt()) {
            throw InterruptException.SIGNAL;
        }
        dispatcher.dispatch().fetchStart(this.task, this.blockIndex, getResponseContentLength());
        FetchDataInterceptor fetchDataInterceptor = new FetchDataInterceptor(this.blockIndex, connected.getInputStream(), getOutputStream(), this.task);
        this.fetchInterceptorList.add(retryInterceptor);
        this.fetchInterceptorList.add(breakpointInterceptor);
        this.fetchInterceptorList.add(fetchDataInterceptor);
        this.fetchIndex = 0;
        long totalFetchedBytes = processFetch();
        dispatcher.dispatch().fetchEnd(this.task, this.blockIndex, totalFetchedBytes);
    }

    public void resetConnectForRetry() {
        this.connectIndex = 1;
        releaseConnection();
    }

    public synchronized void releaseConnection() {
        if (this.connection != null) {
            this.connection.release();
            Util.d(TAG, "release connection " + this.connection + " task[" + this.task.getId() + "] block[" + this.blockIndex + "]");
        }
        this.connection = null;
    }

    public DownloadConnection.Connected processConnect() throws IOException {
        if (this.cache.isInterrupt()) {
            throw InterruptException.SIGNAL;
        }
        List<Interceptor.Connect> list = this.connectInterceptorList;
        int i = this.connectIndex;
        this.connectIndex = i + 1;
        return list.get(i).interceptConnect(this);
    }

    public long processFetch() throws IOException {
        if (this.cache.isInterrupt()) {
            throw InterruptException.SIGNAL;
        }
        List<Interceptor.Fetch> list = this.fetchInterceptorList;
        int i = this.fetchIndex;
        this.fetchIndex = i + 1;
        return list.get(i).interceptFetch(this);
    }

    public long loopFetch() throws IOException {
        if (this.fetchIndex == this.fetchInterceptorList.size()) {
            this.fetchIndex--;
        }
        return processFetch();
    }

    boolean isFinished() {
        return this.finished.get();
    }

    public DownloadStore getDownloadStore() {
        return this.store;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isFinished()) {
            throw new IllegalAccessError("The chain has been finished!");
        }
        this.currentThread = Thread.currentThread();
        try {
            start();
        } catch (IOException e) {
        } finally {
            this.finished.set(true);
            releaseConnectionAsync();
        }
    }

    void releaseConnectionAsync() {
        EXECUTOR.execute(this.releaseConnectionRunnable);
    }
}
