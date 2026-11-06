package com.taptap.sdk.update.download.core.breakpoint;

import android.content.Context;
import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.core.Util;
import com.taptap.sdk.update.download.core.cause.EndCause;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class BreakpointStoreOnSQLite implements DownloadStore {
    private static final String TAG = "BreakpointStoreOnSQLite";
    protected final BreakpointSQLiteHelper helper;
    protected final BreakpointStoreOnCache onCache;

    BreakpointStoreOnSQLite(BreakpointSQLiteHelper helper, BreakpointStoreOnCache onCache) {
        this.helper = helper;
        this.onCache = onCache;
    }

    public BreakpointStoreOnSQLite(Context context) {
        BreakpointSQLiteHelper breakpointSQLiteHelper = new BreakpointSQLiteHelper(context.getApplicationContext());
        this.helper = breakpointSQLiteHelper;
        this.onCache = new BreakpointStoreOnCache(breakpointSQLiteHelper.loadToCache(), breakpointSQLiteHelper.loadDirtyFileList(), breakpointSQLiteHelper.loadResponseFilenameToMap());
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public BreakpointInfo get(int id) {
        return this.onCache.get(id);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public BreakpointInfo createAndInsert(DownloadTask task) throws IOException {
        BreakpointInfo info = this.onCache.createAndInsert(task);
        this.helper.insert(info);
        return info;
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.DownloadStore
    public void onTaskStart(int id) {
        this.onCache.onTaskStart(id);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.DownloadStore
    public void onSyncToFilesystemSuccess(BreakpointInfo info, int blockIndex, long increaseLength) throws IOException {
        this.onCache.onSyncToFilesystemSuccess(info, blockIndex, increaseLength);
        long newCurrentOffset = info.getBlock(blockIndex).getCurrentOffset();
        this.helper.updateBlockIncrease(info, blockIndex, newCurrentOffset);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public boolean update(BreakpointInfo breakpointInfo) throws IOException {
        boolean result = this.onCache.update(breakpointInfo);
        this.helper.updateInfo(breakpointInfo);
        String filename = breakpointInfo.getFilename();
        Util.d(TAG, "update " + breakpointInfo);
        if (breakpointInfo.isTaskOnlyProvidedParentPath() && filename != null) {
            this.helper.updateFilename(breakpointInfo.getUrl(), filename);
        }
        return result;
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.DownloadStore
    public void onTaskEnd(int id, EndCause cause, Exception exception) {
        this.onCache.onTaskEnd(id, cause, exception);
        if (cause == EndCause.COMPLETED) {
            this.helper.removeInfo(id);
        }
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.DownloadStore
    public BreakpointInfo getAfterCompleted(int id) {
        return null;
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.DownloadStore
    public boolean markFileDirty(int id) {
        if (this.onCache.markFileDirty(id)) {
            this.helper.markFileDirty(id);
            return true;
        }
        return false;
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.DownloadStore
    public boolean markFileClear(int id) {
        if (this.onCache.markFileClear(id)) {
            this.helper.markFileClear(id);
            return true;
        }
        return false;
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public void remove(int id) {
        this.onCache.remove(id);
        this.helper.removeInfo(id);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public int findOrCreateId(DownloadTask task) {
        int id = this.onCache.findOrCreateId(task);
        try {
            BreakpointInfo breakpointInfo = this.onCache.get(id);
            if (breakpointInfo != null && !breakpointInfo.getUrl().equals(task.getUrl())) {
                breakpointInfo.setUrl(task.getUrl());
                update(breakpointInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public BreakpointInfo findAnotherInfoFromCompare(DownloadTask task, BreakpointInfo ignored) {
        return this.onCache.findAnotherInfoFromCompare(task, ignored);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public boolean isOnlyMemoryCache() {
        return false;
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public boolean isFileDirty(int id) {
        return this.onCache.isFileDirty(id);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public String getResponseFilename(String url) {
        return this.onCache.getResponseFilename(url);
    }

    void close() {
        this.helper.close();
    }

    public DownloadStore createRemitSelf() {
        return new RemitStoreOnSQLite(this);
    }
}
