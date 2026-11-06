package com.taptap.sdk.update.download.core.breakpoint;

import android.database.sqlite.SQLiteDatabase;
import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.OkDownload;
import com.taptap.sdk.update.download.core.cause.EndCause;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RemitStoreOnSQLite implements RemitSyncExecutor.RemitAgent, DownloadStore {
    private static final String TAG = "RemitStoreOnSQLite";
    private final BreakpointStoreOnSQLite onSQLiteWrapper;
    private final RemitSyncToDBHelper remitHelper;
    private final BreakpointSQLiteHelper sqLiteHelper;
    private final DownloadStore sqliteCache;

    RemitStoreOnSQLite(BreakpointStoreOnSQLite sqlite) {
        this.remitHelper = new RemitSyncToDBHelper(this);
        this.onSQLiteWrapper = sqlite;
        this.sqliteCache = sqlite.onCache;
        this.sqLiteHelper = sqlite.helper;
    }

    RemitStoreOnSQLite(RemitSyncToDBHelper helper, BreakpointStoreOnSQLite sqlite, DownloadStore sqliteCache, BreakpointSQLiteHelper sqLiteHelper) {
        this.remitHelper = helper;
        this.onSQLiteWrapper = sqlite;
        this.sqliteCache = sqliteCache;
        this.sqLiteHelper = sqLiteHelper;
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public BreakpointInfo get(int id) {
        return this.onSQLiteWrapper.get(id);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public BreakpointInfo createAndInsert(DownloadTask task) throws IOException {
        return this.remitHelper.isNotFreeToDatabase(task.getId()) ? this.sqliteCache.createAndInsert(task) : this.onSQLiteWrapper.createAndInsert(task);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.DownloadStore
    public void onTaskStart(int id) {
        this.onSQLiteWrapper.onTaskStart(id);
        this.remitHelper.onTaskStart(id);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.DownloadStore
    public void onSyncToFilesystemSuccess(BreakpointInfo info, int blockIndex, long increaseLength) throws IOException {
        if (this.remitHelper.isNotFreeToDatabase(info.getId())) {
            this.sqliteCache.onSyncToFilesystemSuccess(info, blockIndex, increaseLength);
        } else {
            this.onSQLiteWrapper.onSyncToFilesystemSuccess(info, blockIndex, increaseLength);
        }
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public boolean update(BreakpointInfo info) throws IOException {
        return this.remitHelper.isNotFreeToDatabase(info.getId()) ? this.sqliteCache.update(info) : this.onSQLiteWrapper.update(info);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.DownloadStore
    public void onTaskEnd(int id, EndCause cause, Exception exception) {
        this.sqliteCache.onTaskEnd(id, cause, exception);
        if (cause == EndCause.COMPLETED) {
            this.remitHelper.discard(id);
        } else {
            this.remitHelper.endAndEnsureToDB(id);
        }
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.DownloadStore
    public BreakpointInfo getAfterCompleted(int id) {
        return null;
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.DownloadStore
    public boolean markFileDirty(int id) {
        return this.onSQLiteWrapper.markFileDirty(id);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.DownloadStore
    public boolean markFileClear(int id) {
        return this.onSQLiteWrapper.markFileClear(id);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public void remove(int id) {
        this.sqliteCache.remove(id);
        this.remitHelper.discard(id);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public int findOrCreateId(DownloadTask task) {
        return this.onSQLiteWrapper.findOrCreateId(task);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public BreakpointInfo findAnotherInfoFromCompare(DownloadTask task, BreakpointInfo ignored) {
        return this.onSQLiteWrapper.findAnotherInfoFromCompare(task, ignored);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public boolean isOnlyMemoryCache() {
        return false;
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public boolean isFileDirty(int id) {
        return this.onSQLiteWrapper.isFileDirty(id);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public String getResponseFilename(String url) {
        return this.onSQLiteWrapper.getResponseFilename(url);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.RemitSyncExecutor.RemitAgent
    public void syncCacheToDB(List<Integer> idList) throws IOException {
        SQLiteDatabase database = this.sqLiteHelper.getWritableDatabase();
        database.beginTransaction();
        try {
            for (Integer id : idList) {
                syncCacheToDB(id.intValue());
            }
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.RemitSyncExecutor.RemitAgent
    public void syncCacheToDB(int id) throws IOException {
        this.sqLiteHelper.removeInfo(id);
        BreakpointInfo info = this.sqliteCache.get(id);
        if (info == null || info.getFilename() == null || info.getTotalOffset() <= 0) {
            return;
        }
        this.sqLiteHelper.insert(info);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.RemitSyncExecutor.RemitAgent
    public void removeInfo(int id) {
        this.sqLiteHelper.removeInfo(id);
    }

    public static void setRemitToDBDelayMillis(int delayMillis) {
        BreakpointStore store = OkDownload.with().breakpointStore();
        if (!(store instanceof RemitStoreOnSQLite)) {
            throw new IllegalStateException("The current store is " + store + " not RemitStoreOnSQLite!");
        }
        ((RemitStoreOnSQLite) store).remitHelper.delayMillis = Math.max(0, delayMillis);
    }
}
