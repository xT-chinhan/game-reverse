package com.taptap.sdk.update.download.core.file;

import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.OkDownload;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.breakpoint.DownloadStore;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class ProcessFileStrategy {
    private final FileLock fileLock = new FileLock();

    public MultiPointOutputStream createProcessStream(DownloadTask task, BreakpointInfo info, DownloadStore store) {
        return new MultiPointOutputStream(task, info, store);
    }

    public void completeProcessStream(MultiPointOutputStream processOutputStream, DownloadTask task) {
    }

    public void discardProcess(DownloadTask task) throws IOException {
        File file = task.getFile();
        if (file != null && file.exists() && !file.delete()) {
            throw new IOException("Delete file failed!");
        }
    }

    public FileLock getFileLock() {
        return this.fileLock;
    }

    public boolean isPreAllocateLength(DownloadTask task) {
        boolean supportSeek = OkDownload.with().outputStreamFactory().supportSeek();
        if (!supportSeek) {
            return false;
        }
        if (task.getSetPreAllocateLength() != null) {
            return task.getSetPreAllocateLength().booleanValue();
        }
        return true;
    }
}
