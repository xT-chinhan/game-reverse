package com.taptap.sdk.update.download;

import android.net.Uri;
import android.util.SparseArray;
import com.taptap.sdk.update.download.core.IdentifiedTask;
import com.taptap.sdk.update.download.core.Util;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.download.DownloadStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadTask extends IdentifiedTask implements Comparable<DownloadTask> {
    private final boolean autoCallbackToUIThread;
    private final Integer connectionCount;
    private final File directoryFile;
    private final boolean filenameFromResponse;
    private final DownloadStrategy.FilenameHolder filenameHolder;
    private final int flushBufferSize;
    private final Map<String, List<String>> headerMapFields;
    private final int id;
    private BreakpointInfo info;
    private final Boolean isPreAllocateLength;
    private volatile SparseArray<Object> keyTagMap;
    private final AtomicLong lastCallbackProcessTimestamp = new AtomicLong();
    private volatile DownloadListener listener;
    private final int minIntervalMillisCallbackProcess;
    private final boolean passIfAlreadyCompleted;
    private final int priority;
    private final File providedPathFile;
    private final int readBufferSize;
    private String redirectLocation;
    private final int syncBufferIntervalMills;
    private final int syncBufferSize;
    private Object tag;
    private File targetFile;
    private final Uri uri;
    private final String url;
    private final boolean wifiRequired;

    public DownloadTask(String url, Uri uri, int priority, int readBufferSize, int flushBufferSize, int syncBufferSize, int syncBufferIntervalMills, boolean autoCallbackToUIThread, int minIntervalMillisCallbackProcess, Map<String, List<String>> headerMapFields, String filename, boolean passIfAlreadyCompleted, boolean wifiRequired, Boolean filenameFromResponse, Integer connectionCount, Boolean isPreAllocateLength) {
        Boolean filenameFromResponse2;
        String filename2 = filename;
        this.url = url;
        this.uri = uri;
        this.priority = priority;
        this.readBufferSize = readBufferSize;
        this.flushBufferSize = flushBufferSize;
        this.syncBufferSize = syncBufferSize;
        this.syncBufferIntervalMills = syncBufferIntervalMills;
        this.autoCallbackToUIThread = autoCallbackToUIThread;
        this.minIntervalMillisCallbackProcess = minIntervalMillisCallbackProcess;
        this.headerMapFields = headerMapFields;
        this.passIfAlreadyCompleted = passIfAlreadyCompleted;
        this.wifiRequired = wifiRequired;
        this.connectionCount = connectionCount;
        this.isPreAllocateLength = isPreAllocateLength;
        if (!Util.isUriFileScheme(uri)) {
            this.filenameFromResponse = false;
            this.directoryFile = new File(uri.getPath());
        } else {
            File file = new File(uri.getPath());
            if (filenameFromResponse != null) {
                if (filenameFromResponse.booleanValue()) {
                    if (file.exists() && file.isFile()) {
                        throw new IllegalArgumentException("If you want filename from response please make sure you provide path is directory " + file.getPath());
                    }
                    if (!Util.isEmpty(filename)) {
                        Util.w("DownloadTask", "Discard filename[" + filename2 + "] because you set filenameFromResponse=true");
                        filename2 = null;
                    }
                    this.directoryFile = file;
                    filenameFromResponse2 = filenameFromResponse;
                } else {
                    if (file.exists() && file.isDirectory() && Util.isEmpty(filename)) {
                        throw new IllegalArgumentException("If you don't want filename from response please make sure you have already provided valid filename or not directory path " + file.getPath());
                    }
                    if (Util.isEmpty(filename)) {
                        filename2 = file.getName();
                        this.directoryFile = Util.getParentFile(file);
                        filenameFromResponse2 = filenameFromResponse;
                    } else {
                        this.directoryFile = file;
                        filenameFromResponse2 = filenameFromResponse;
                    }
                }
            } else if (file.exists() && file.isDirectory()) {
                filenameFromResponse2 = true;
                this.directoryFile = file;
            } else {
                filenameFromResponse2 = false;
                if (file.exists()) {
                    if (!Util.isEmpty(filename) && !file.getName().equals(filename2)) {
                        throw new IllegalArgumentException("Uri already provided filename!");
                    }
                    filename2 = file.getName();
                    this.directoryFile = Util.getParentFile(file);
                } else if (Util.isEmpty(filename)) {
                    filename2 = file.getName();
                    this.directoryFile = Util.getParentFile(file);
                } else {
                    this.directoryFile = file;
                }
            }
            this.filenameFromResponse = filenameFromResponse2.booleanValue();
        }
        if (Util.isEmpty(filename2)) {
            this.filenameHolder = new DownloadStrategy.FilenameHolder();
            this.providedPathFile = this.directoryFile;
        } else {
            this.filenameHolder = new DownloadStrategy.FilenameHolder(filename2);
            File file2 = new File(this.directoryFile, filename2);
            this.targetFile = file2;
            this.providedPathFile = file2;
        }
        this.id = OkDownload.with().breakpointStore().findOrCreateId(this);
    }

    public boolean isFilenameFromResponse() {
        return this.filenameFromResponse;
    }

    public Map<String, List<String>> getHeaderMapFields() {
        return this.headerMapFields;
    }

    @Override // com.taptap.sdk.update.download.core.IdentifiedTask
    public int getId() {
        return this.id;
    }

    @Override // com.taptap.sdk.update.download.core.IdentifiedTask
    public String getFilename() {
        return this.filenameHolder.get();
    }

    public boolean isPassIfAlreadyCompleted() {
        return this.passIfAlreadyCompleted;
    }

    public boolean isWifiRequired() {
        return this.wifiRequired;
    }

    public DownloadStrategy.FilenameHolder getFilenameHolder() {
        return this.filenameHolder;
    }

    public Uri getUri() {
        return this.uri;
    }

    @Override // com.taptap.sdk.update.download.core.IdentifiedTask
    public String getUrl() {
        return this.url;
    }

    public void setRedirectLocation(String redirectUrl) {
        this.redirectLocation = redirectUrl;
    }

    public String getRedirectLocation() {
        return this.redirectLocation;
    }

    @Override // com.taptap.sdk.update.download.core.IdentifiedTask
    protected File getProvidedPathFile() {
        return this.providedPathFile;
    }

    @Override // com.taptap.sdk.update.download.core.IdentifiedTask
    public File getParentFile() {
        return this.directoryFile;
    }

    public File getFile() {
        String filename = this.filenameHolder.get();
        if (filename == null) {
            return null;
        }
        if (this.targetFile == null) {
            this.targetFile = new File(this.directoryFile, filename);
        }
        return this.targetFile;
    }

    public int getReadBufferSize() {
        return this.readBufferSize;
    }

    public int getFlushBufferSize() {
        return this.flushBufferSize;
    }

    public int getSyncBufferSize() {
        return this.syncBufferSize;
    }

    public int getSyncBufferIntervalMills() {
        return this.syncBufferIntervalMills;
    }

    public boolean isAutoCallbackToUIThread() {
        return this.autoCallbackToUIThread;
    }

    public int getMinIntervalMillisCallbackProcess() {
        return this.minIntervalMillisCallbackProcess;
    }

    public Integer getSetConnectionCount() {
        return this.connectionCount;
    }

    public Boolean getSetPreAllocateLength() {
        return this.isPreAllocateLength;
    }

    public int getConnectionCount() {
        BreakpointInfo breakpointInfo = this.info;
        if (breakpointInfo == null) {
            return 0;
        }
        return breakpointInfo.getBlockCount();
    }

    public Object getTag(int key) {
        if (this.keyTagMap == null) {
            return null;
        }
        return this.keyTagMap.get(key);
    }

    public Object getTag() {
        return this.tag;
    }

    public BreakpointInfo getInfo() {
        if (this.info == null) {
            this.info = OkDownload.with().breakpointStore().get(this.id);
        }
        return this.info;
    }

    long getLastCallbackProcessTs() {
        return this.lastCallbackProcessTimestamp.get();
    }

    void setLastCallbackProcessTs(long lastCallbackProcessTimestamp) {
        this.lastCallbackProcessTimestamp.set(lastCallbackProcessTimestamp);
    }

    void setBreakpointInfo(BreakpointInfo info) {
        this.info = info;
    }

    public synchronized DownloadTask addTag(int key, Object value) {
        if (this.keyTagMap == null) {
            synchronized (this) {
                try {
                    if (this.keyTagMap == null) {
                        this.keyTagMap = new SparseArray<>();
                    }
                } catch (Throwable th) {
                    th = th;
                    while (true) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
            }
        }
        this.keyTagMap.put(key, value);
        return this;
    }

    public synchronized void removeTag(int key) {
        if (this.keyTagMap != null) {
            this.keyTagMap.remove(key);
        }
    }

    public synchronized void removeTag() {
        this.tag = null;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public void replaceListener(DownloadListener listener) {
        this.listener = listener;
    }

    public static void enqueue(DownloadTask[] tasks, DownloadListener listener) {
        for (DownloadTask task : tasks) {
            task.listener = listener;
        }
        OkDownload.with().downloadDispatcher().enqueue(tasks);
    }

    public void enqueue(DownloadListener listener) {
        this.listener = listener;
        OkDownload.with().downloadDispatcher().enqueue(this);
    }

    public void execute(DownloadListener listener) {
        this.listener = listener;
        OkDownload.with().downloadDispatcher().execute(this);
    }

    public void cancel() {
        OkDownload.with().downloadDispatcher().cancel(this);
    }

    public static void cancel(DownloadTask[] tasks) {
        OkDownload.with().downloadDispatcher().cancel(tasks);
    }

    public DownloadListener getListener() {
        return this.listener;
    }

    public int getPriority() {
        return this.priority;
    }

    public Builder toBuilder(String anotherUrl, Uri anotherUri) {
        Builder builder = new Builder(anotherUrl, anotherUri).setPriority(this.priority).setReadBufferSize(this.readBufferSize).setFlushBufferSize(this.flushBufferSize).setSyncBufferSize(this.syncBufferSize).setSyncBufferIntervalMillis(this.syncBufferIntervalMills).setAutoCallbackToUIThread(this.autoCallbackToUIThread).setMinIntervalMillisCallbackProcess(this.minIntervalMillisCallbackProcess).setHeaderMapFields(this.headerMapFields).setPassIfAlreadyCompleted(this.passIfAlreadyCompleted);
        if (Util.isUriFileScheme(anotherUri) && !new File(anotherUri.getPath()).isFile() && Util.isUriFileScheme(this.uri) && this.filenameHolder.get() != null && !new File(this.uri.getPath()).getName().equals(this.filenameHolder.get())) {
            builder.setFilename(this.filenameHolder.get());
        }
        return builder;
    }

    public Builder toBuilder() {
        return toBuilder(this.url, this.uri);
    }

    public void setTags(DownloadTask oldTask) {
        this.tag = oldTask.tag;
        this.keyTagMap = oldTask.keyTagMap;
    }

    @Override // java.lang.Comparable
    public int compareTo(DownloadTask o) {
        return o.getPriority() - getPriority();
    }

    public static class Builder {
        public static final boolean DEFAULT_AUTO_CALLBACK_TO_UI_THREAD = true;
        public static final int DEFAULT_FLUSH_BUFFER_SIZE = 16384;
        public static final boolean DEFAULT_IS_WIFI_REQUIRED = false;
        public static final int DEFAULT_MIN_INTERVAL_MILLIS_CALLBACK_PROCESS = 3000;
        public static final boolean DEFAULT_PASS_IF_ALREADY_COMPLETED = true;
        public static final int DEFAULT_READ_BUFFER_SIZE = 4096;
        public static final int DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS = 2000;
        public static final int DEFAULT_SYNC_BUFFER_SIZE = 65536;
        private boolean autoCallbackToUIThread;
        private Integer connectionCount;
        private String filename;
        private int flushBufferSize;
        private volatile Map<String, List<String>> headerMapFields;
        private Boolean isFilenameFromResponse;
        private Boolean isPreAllocateLength;
        private boolean isWifiRequired;
        private int minIntervalMillisCallbackProcess;
        private boolean passIfAlreadyCompleted;
        private int priority;
        private int readBufferSize;
        private int syncBufferIntervalMillis;
        private int syncBufferSize;
        final Uri uri;
        final String url;

        public Builder(String url, String parentPath, String filename) {
            this(url, Uri.fromFile(new File(parentPath)));
            if (Util.isEmpty(filename)) {
                this.isFilenameFromResponse = true;
            } else {
                this.filename = filename;
            }
        }

        public Builder(String url, File file) {
            this.readBufferSize = 4096;
            this.flushBufferSize = 16384;
            this.syncBufferSize = 65536;
            this.syncBufferIntervalMillis = DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS;
            this.autoCallbackToUIThread = true;
            this.minIntervalMillisCallbackProcess = 3000;
            this.passIfAlreadyCompleted = true;
            this.isWifiRequired = false;
            this.url = url;
            this.uri = Uri.fromFile(file);
        }

        public Builder(String url, Uri uri) {
            this.readBufferSize = 4096;
            this.flushBufferSize = 16384;
            this.syncBufferSize = 65536;
            this.syncBufferIntervalMillis = DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS;
            this.autoCallbackToUIThread = true;
            this.minIntervalMillisCallbackProcess = 3000;
            this.passIfAlreadyCompleted = true;
            this.isWifiRequired = false;
            this.url = url;
            this.uri = uri;
            if (Util.isUriContentScheme(uri)) {
                this.filename = Util.getFilenameFromContentUri(uri);
            }
        }

        public Builder setPreAllocateLength(boolean preAllocateLength) {
            this.isPreAllocateLength = Boolean.valueOf(preAllocateLength);
            return this;
        }

        public Builder setConnectionCount(int connectionCount) {
            this.connectionCount = Integer.valueOf(connectionCount);
            return this;
        }

        public Builder setFilenameFromResponse(Boolean filenameFromResponse) {
            if (!Util.isUriFileScheme(this.uri)) {
                throw new IllegalArgumentException("Uri isn't file scheme we can't let filename from response");
            }
            this.isFilenameFromResponse = filenameFromResponse;
            return this;
        }

        public Builder setAutoCallbackToUIThread(boolean autoCallbackToUIThread) {
            this.autoCallbackToUIThread = autoCallbackToUIThread;
            return this;
        }

        public Builder setMinIntervalMillisCallbackProcess(int minIntervalMillisCallbackProcess) {
            this.minIntervalMillisCallbackProcess = minIntervalMillisCallbackProcess;
            return this;
        }

        public Builder setHeaderMapFields(Map<String, List<String>> headerMapFields) {
            this.headerMapFields = headerMapFields;
            return this;
        }

        public synchronized void addHeader(String key, String value) {
            if (this.headerMapFields == null) {
                this.headerMapFields = new HashMap();
            }
            List<String> valueList = this.headerMapFields.get(key);
            if (valueList == null) {
                valueList = new ArrayList();
                this.headerMapFields.put(key, valueList);
            }
            valueList.add(value);
        }

        public Builder setPriority(int priority) {
            this.priority = priority;
            return this;
        }

        public Builder setReadBufferSize(int readBufferSize) {
            if (readBufferSize < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.readBufferSize = readBufferSize;
            return this;
        }

        public Builder setFlushBufferSize(int flushBufferSize) {
            if (flushBufferSize < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.flushBufferSize = flushBufferSize;
            return this;
        }

        public Builder setSyncBufferSize(int syncBufferSize) {
            if (syncBufferSize < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.syncBufferSize = syncBufferSize;
            return this;
        }

        public Builder setSyncBufferIntervalMillis(int syncBufferIntervalMillis) {
            if (syncBufferIntervalMillis < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.syncBufferIntervalMillis = syncBufferIntervalMillis;
            return this;
        }

        public Builder setFilename(String filename) {
            this.filename = filename;
            return this;
        }

        public Builder setPassIfAlreadyCompleted(boolean passIfAlreadyCompleted) {
            this.passIfAlreadyCompleted = passIfAlreadyCompleted;
            return this;
        }

        public Builder setWifiRequired(boolean wifiRequired) {
            this.isWifiRequired = wifiRequired;
            return this;
        }

        public DownloadTask build() {
            return new DownloadTask(this.url, this.uri, this.priority, this.readBufferSize, this.flushBufferSize, this.syncBufferSize, this.syncBufferIntervalMillis, this.autoCallbackToUIThread, this.minIntervalMillisCallbackProcess, this.headerMapFields, this.filename, this.passIfAlreadyCompleted, this.isWifiRequired, this.isFilenameFromResponse, this.connectionCount, this.isPreAllocateLength);
        }
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj instanceof DownloadTask) {
            DownloadTask another = (DownloadTask) obj;
            if (getTag() != null && another.getTag() != null) {
                return getTag().equals(another.getTag());
            }
            if (another.id == this.id) {
                return true;
            }
            return compareIgnoreId(another);
        }
        return false;
    }

    public int hashCode() {
        return (this.url + this.providedPathFile.toString() + this.filenameHolder.get()).hashCode();
    }

    public String toString() {
        return super.toString() + "@" + this.id + "@" + this.url + "@" + this.directoryFile.toString() + "/" + this.filenameHolder.get();
    }

    public static MockTaskForCompare mockTaskForCompare(int id) {
        return new MockTaskForCompare(id);
    }

    public MockTaskForCompare mock(int id) {
        return new MockTaskForCompare(id, this);
    }

    public static class TaskHideWrapper {
        public static long getLastCallbackProcessTs(DownloadTask task) {
            return task.getLastCallbackProcessTs();
        }

        public static void setLastCallbackProcessTs(DownloadTask task, long lastCallbackProcessTimestamp) {
            task.setLastCallbackProcessTs(lastCallbackProcessTimestamp);
        }

        public static void setBreakpointInfo(DownloadTask task, BreakpointInfo info) {
            task.setBreakpointInfo(info);
        }
    }

    public static class MockTaskForCompare extends IdentifiedTask {
        final String filename;
        final int id;
        final File parentFile;
        final File providedPathFile;
        final String url;

        public MockTaskForCompare(int id) {
            this.id = id;
            this.url = "";
            this.providedPathFile = EMPTY_FILE;
            this.filename = null;
            this.parentFile = EMPTY_FILE;
        }

        public MockTaskForCompare(int id, DownloadTask task) {
            this.id = id;
            this.url = task.url;
            this.parentFile = task.getParentFile();
            this.providedPathFile = task.providedPathFile;
            this.filename = task.getFilename();
        }

        @Override // com.taptap.sdk.update.download.core.IdentifiedTask
        public int getId() {
            return this.id;
        }

        @Override // com.taptap.sdk.update.download.core.IdentifiedTask
        public String getUrl() {
            return this.url;
        }

        @Override // com.taptap.sdk.update.download.core.IdentifiedTask
        protected File getProvidedPathFile() {
            return this.providedPathFile;
        }

        @Override // com.taptap.sdk.update.download.core.IdentifiedTask
        public File getParentFile() {
            return this.parentFile;
        }

        @Override // com.taptap.sdk.update.download.core.IdentifiedTask
        public String getFilename() {
            return this.filename;
        }
    }
}
