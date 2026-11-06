package com.taptap.sdk.update.download.core.breakpoint;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.SparseArray;
import com.taptap.sdk.update.download.core.exception.SQLiteException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BreakpointSQLiteHelper extends SQLiteOpenHelper {
    private static final String BLOCK_TABLE_NAME = "block";
    private static final String BREAKPOINT_TABLE_NAME = "breakpoint";
    private static final String NAME = "okdownload-breakpoint.db";
    private static final String RESPONSE_FILENAME_TABLE_NAME = "okdownloadResponseFilename";
    static final String TASK_FILE_DIRTY_TABLE_NAME = "taskFileDirty";
    private static final int VERSION = 3;

    private interface CreateTable {
        public static final String BLOCK = "CREATE TABLE IF NOT EXISTS block( id INTEGER PRIMARY KEY AUTOINCREMENT, breakpoint_id INTEGER, block_index INTEGER, start_offset INTEGER, content_length INTEGER, current_offset INTEGER)";
        public static final String BREAKPOINT = "CREATE TABLE IF NOT EXISTS breakpoint( id INTEGER PRIMARY KEY, url VARCHAR NOT NULL, etag VARCHAR, parent_path VARCHAR NOT NULL, filename VARCHAR, task_only_parent_path TINYINT(1) DEFAULT 0, chunked TINYINT(1) DEFAULT 0)";
        public static final String RESPONSE_FILENAME = "CREATE TABLE IF NOT EXISTS okdownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)";
        public static final String TASK_FILE_DIRTY = "CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)";
    }

    private interface Migration {
        public static final String RESPONSE_FILENAME_1_TO_2 = "CREATE TABLE IF NOT EXISTS okdownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)";
        public static final String TASK_FILE_DIRTY_NONE_TO_2 = "CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)";
    }

    private interface Select {
        public static final String ALL_FROM_BLOCK = "SELECT * FROM block";
        public static final String ALL_FROM_BREAKPOINT = "SELECT * FROM breakpoint";
        public static final String ALL_FROM_RESPONSE_FILENAME = "SELECT * FROM okdownloadResponseFilename";
        public static final String ALL_FROM_TASK_FILE_DIRTY = "SELECT * FROM taskFileDirty";
        public static final String FILENAME_FROM_RESPONSE_FILENAME_BY_URL = "SELECT filename FROM okdownloadResponseFilename WHERE url = ?";
        public static final String ID_FROM_BREAKPOINT_BY_ID = "SELECT id FROM breakpoint WHERE id = ? LIMIT 1";
    }

    public BreakpointSQLiteHelper(Context context) {
        super(context, NAME, (SQLiteDatabase.CursorFactory) null, 3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (Build.VERSION.SDK_INT >= 16) {
            setWriteAheadLoggingEnabled(true);
        } else {
            db.enableWriteAheadLogging();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateTable.BREAKPOINT);
        db.execSQL(CreateTable.BLOCK);
        db.execSQL("CREATE TABLE IF NOT EXISTS okdownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1 && newVersion == 2) {
            db.execSQL("CREATE TABLE IF NOT EXISTS okdownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        }
        if (oldVersion <= 2) {
            db.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void markFileDirty(int id) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues(1);
        values.put("id", Integer.valueOf(id));
        db.insert(TASK_FILE_DIRTY_TABLE_NAME, null, values);
    }

    public void markFileClear(int id) {
        getWritableDatabase().delete(TASK_FILE_DIRTY_TABLE_NAME, "id = ?", new String[]{String.valueOf(id)});
    }

    public List<Integer> loadDirtyFileList() {
        List<Integer> dirtyFileList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(Select.ALL_FROM_TASK_FILE_DIRTY, null);
            while (cursor.moveToNext()) {
                dirtyFileList.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("id"))));
            }
            if (cursor != null) {
                cursor.close();
            }
            return dirtyFileList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public SparseArray<BreakpointInfo> loadToCache() {
        Cursor breakpointCursor = null;
        Cursor blockCursor = null;
        SQLiteDatabase db = getWritableDatabase();
        List<BreakpointInfoRow> breakpointInfoRows = new ArrayList<>();
        List<BlockInfoRow> blockInfoRows = new ArrayList<>();
        try {
            breakpointCursor = db.rawQuery(Select.ALL_FROM_BREAKPOINT, null);
            while (breakpointCursor.moveToNext()) {
                breakpointInfoRows.add(new BreakpointInfoRow(breakpointCursor));
            }
            blockCursor = db.rawQuery(Select.ALL_FROM_BLOCK, null);
            while (blockCursor.moveToNext()) {
                blockInfoRows.add(new BlockInfoRow(blockCursor));
            }
            if (breakpointCursor != null) {
                breakpointCursor.close();
            }
            if (blockCursor != null) {
                blockCursor.close();
            }
            SparseArray<BreakpointInfo> breakpointInfoMap = new SparseArray<>();
            for (BreakpointInfoRow infoRow : breakpointInfoRows) {
                BreakpointInfo info = infoRow.toInfo();
                Iterator<BlockInfoRow> blockIt = blockInfoRows.iterator();
                while (blockIt.hasNext()) {
                    BlockInfoRow blockInfoRow = blockIt.next();
                    if (blockInfoRow.getBreakpointId() == info.id) {
                        info.addBlock(blockInfoRow.toInfo());
                        blockIt.remove();
                    }
                }
                breakpointInfoMap.put(info.id, info);
            }
            return breakpointInfoMap;
        } catch (Throwable th) {
            if (breakpointCursor != null) {
                breakpointCursor.close();
            }
            if (blockCursor != null) {
                blockCursor.close();
            }
            throw th;
        }
    }

    public HashMap<String, String> loadResponseFilenameToMap() {
        Cursor cursor = null;
        SQLiteDatabase db = getWritableDatabase();
        HashMap<String, String> urlFilenameMap = new HashMap<>();
        try {
            cursor = db.rawQuery(Select.ALL_FROM_RESPONSE_FILENAME, null);
            while (cursor.moveToNext()) {
                String url = cursor.getString(cursor.getColumnIndex(BreakpointSQLiteKey.URL));
                String filename = cursor.getString(cursor.getColumnIndex(BreakpointSQLiteKey.FILENAME));
                urlFilenameMap.put(url, filename);
            }
            if (cursor != null) {
                cursor.close();
            }
            return urlFilenameMap;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void updateFilename(String url, String filename) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues(2);
        values.put(BreakpointSQLiteKey.URL, url);
        values.put(BreakpointSQLiteKey.FILENAME, filename);
        Cursor c = null;
        synchronized (url.intern()) {
            try {
                Cursor c2 = db.rawQuery(Select.FILENAME_FROM_RESPONSE_FILENAME_BY_URL, new String[]{url});
                if (c2.moveToFirst()) {
                    if (!filename.equals(c2.getString(c2.getColumnIndex(BreakpointSQLiteKey.FILENAME)))) {
                        db.replace(RESPONSE_FILENAME_TABLE_NAME, null, values);
                    }
                } else {
                    db.insert(RESPONSE_FILENAME_TABLE_NAME, null, values);
                }
                if (c2 != null) {
                    c2.close();
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    c.close();
                }
                throw th;
            }
        }
    }

    public void insert(BreakpointInfo info) throws IOException {
        int blockCount = info.getBlockCount();
        SQLiteDatabase db = getWritableDatabase();
        for (int i = 0; i < blockCount; i++) {
            BlockInfo blockInfo = info.getBlock(i);
            if (db.insert(BLOCK_TABLE_NAME, null, toValues(info.id, i, blockInfo)) == -1) {
                throw new SQLiteException("insert block " + blockInfo + " failed!");
            }
        }
        long result = db.insert(BREAKPOINT_TABLE_NAME, null, toValues(info));
        if (result == -1) {
            throw new SQLiteException("insert info " + info + " failed!");
        }
    }

    public void updateBlockIncrease(BreakpointInfo info, int blockIndex, long newCurrentOffset) {
        ContentValues values = new ContentValues();
        values.put(BreakpointSQLiteKey.CURRENT_OFFSET, Long.valueOf(newCurrentOffset));
        getWritableDatabase().update(BLOCK_TABLE_NAME, values, "breakpoint_id = ? AND block_index = ?", new String[]{Integer.toString(info.id), Integer.toString(blockIndex)});
    }

    public void updateInfo(BreakpointInfo info) throws IOException {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = null;
        db.beginTransaction();
        try {
            cursor = getWritableDatabase().rawQuery(Select.ID_FROM_BREAKPOINT_BY_ID, new String[]{Integer.toString(info.id)});
            if (!cursor.moveToNext()) {
                return;
            }
            removeInfo(info.id);
            insert(info);
            db.setTransactionSuccessful();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.endTransaction();
        }
    }

    public void removeInfo(int id) {
        getWritableDatabase().delete(BREAKPOINT_TABLE_NAME, "id = ?", new String[]{String.valueOf(id)});
        removeBlock(id);
    }

    public void removeBlock(int breakpointId) {
        getWritableDatabase().delete(BLOCK_TABLE_NAME, "breakpoint_id = ?", new String[]{String.valueOf(breakpointId)});
    }

    private static ContentValues toValues(BreakpointInfo breakpointInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(breakpointInfo.id));
        contentValues.put(BreakpointSQLiteKey.URL, breakpointInfo.getUrl());
        contentValues.put(BreakpointSQLiteKey.ETAG, breakpointInfo.getEtag());
        contentValues.put(BreakpointSQLiteKey.PARENT_PATH, breakpointInfo.parentFile.getAbsolutePath());
        contentValues.put(BreakpointSQLiteKey.FILENAME, breakpointInfo.getFilename());
        contentValues.put(BreakpointSQLiteKey.TASK_ONLY_PARENT_PATH, Integer.valueOf(breakpointInfo.isTaskOnlyProvidedParentPath() ? 1 : 0));
        contentValues.put("chunked", Integer.valueOf(breakpointInfo.isChunked() ? 1 : 0));
        return contentValues;
    }

    private static ContentValues toValues(int breakpointId, int index, BlockInfo info) {
        ContentValues values = new ContentValues();
        values.put(BreakpointSQLiteKey.HOST_ID, Integer.valueOf(breakpointId));
        values.put(BreakpointSQLiteKey.BLOCK_INDEX, Integer.valueOf(index));
        values.put(BreakpointSQLiteKey.START_OFFSET, Long.valueOf(info.getStartOffset()));
        values.put(BreakpointSQLiteKey.CONTENT_LENGTH, Long.valueOf(info.getContentLength()));
        values.put(BreakpointSQLiteKey.CURRENT_OFFSET, Long.valueOf(info.getCurrentOffset()));
        return values;
    }
}
