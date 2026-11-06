package com.byazt.mef;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.auw.DownloadInfo;
import com.byazt.lj.a;
import com.byazt.lj.w;
import com.byazt.stx.aj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.internal.runtime.RustResolvedAsset;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import com.umeng.analytics.pro.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 798, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends hn.pr implements a {
    public static volatile SQLiteDatabase hw = null;
    public fw c;
    public fw hn;
    public hw pr;
    public volatile boolean uc;
    public fw x;

    public c() {
        this(false);
    }

    public c(boolean z) {
        this.pr = null;
        if (!z) {
            return;
        }
        this.uc = false;
        pr();
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public DownloadInfo fw(int i) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zo() {
        if (hw == null) {
            synchronized (c.class) {
                if (hw == null) {
                    try {
                        hw = pr.pr().getWritableDatabase();
                        this.hn = new fw(hw, "downloader", com.byazt.mrs.hn.pr, com.byazt.mrs.hn.hw);
                        this.x = new fw(hw, "downloadChunk", com.byazt.mrs.hn.hn, com.byazt.mrs.hn.x);
                        this.c = new fw(hw, "segments", com.byazt.mrs.hn.c, com.byazt.mrs.hn.uc);
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }

    @Override // com.byazt.mef.hn
    public void pr() {
        pr(new SparseArray<>(), new SparseArray<>(), (x) null);
    }

    @Override // com.byazt.lj.a
    public void pr(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.byazt.auw.hw>> sparseArray2, final x xVar) {
        try {
            Runnable runnable = new Runnable() { // from class: com.byazt.mef.c.1
                @Override // java.lang.Runnable
                public void run() {
                    x xVar2;
                    boolean z;
                    int iPr;
                    c.this.zo();
                    if (c.hw == null) {
                        return;
                    }
                    w wVarGz = com.byazt.lj.hn.gz();
                    SparseArray sparseArray3 = new SparseArray();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    Cursor cursorRawQuery = null;
                    int i = 0;
                    try {
                        cursorRawQuery = c.hw.rawQuery("SELECT * FROM downloader", null);
                        while (cursorRawQuery.moveToNext()) {
                            DownloadInfo downloadInfo = new DownloadInfo(cursorRawQuery);
                            downloadInfo.setStatusAtDbInit(downloadInfo.getRealStatus());
                            if (downloadInfo.isCanResumeFromBreakPointStatus()) {
                                downloadInfo.setStatus(-5);
                                if (com.byazt.ew.pr.hn().hw("status_not_update_to_db", true)) {
                                    sparseArray3.put(downloadInfo.getId(), downloadInfo);
                                }
                            }
                            if (TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
                                z = true;
                            } else {
                                if (downloadInfo.getStatus() != 1 || downloadInfo.getCurBytes() > 0) {
                                    if (downloadInfo.getStatus() != -3 && downloadInfo.getStatus() != 11 && !downloadInfo.isFileDataValid()) {
                                        downloadInfo.reset();
                                    }
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (downloadInfo.getStatus() == 11) {
                                    downloadInfo.setStatus(-5);
                                }
                                if (com.byazt.tuy.uc.pr(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName())) {
                                    if (com.byazt.tuy.pr.pr(RustResolvedAsset.MAX_HTML_BYTES)) {
                                        z = true;
                                    } else {
                                        downloadInfo.erase();
                                    }
                                }
                            }
                            if (z) {
                                arrayList.add(Integer.valueOf(downloadInfo.getId()));
                                arrayList2.add(downloadInfo);
                            } else {
                                int id = downloadInfo.getId();
                                if (wVarGz != null) {
                                    String taskKey = downloadInfo.getTaskKey();
                                    if (TextUtils.isEmpty(taskKey)) {
                                        taskKey = downloadInfo.getUrl();
                                    }
                                    iPr = wVarGz.pr(taskKey, downloadInfo.getSavePath());
                                } else {
                                    iPr = 0;
                                }
                                if (iPr != id) {
                                    downloadInfo.setId(iPr);
                                    sparseArray3.put(id, downloadInfo);
                                }
                                sparseArray.put(downloadInfo.getId(), downloadInfo);
                            }
                        }
                        com.byazt.tuy.uc.pr(cursorRawQuery);
                        c.this.pr(arrayList2);
                        c.this.pr(arrayList2, arrayList, (SparseArray<DownloadInfo>) sparseArray3, (SparseArray<DownloadInfo>) sparseArray, (SparseArray<List<com.byazt.auw.hw>>) sparseArray2);
                        try {
                            ArrayList arrayList3 = new ArrayList();
                            if (sparseArray != null) {
                                while (i < sparseArray.size()) {
                                    int iKeyAt = sparseArray.keyAt(i);
                                    if (iKeyAt != 0) {
                                        DownloadInfo downloadInfo2 = (DownloadInfo) sparseArray.get(iKeyAt);
                                        if (com.byazt.tuy.pr.pr(8192)) {
                                            if (downloadInfo2 != null && !downloadInfo2.isChunkBreakpointAvailable() && downloadInfo2.getStatus() != -3) {
                                                arrayList3.add(Integer.valueOf(downloadInfo2.getId()));
                                                sparseArray2.remove(downloadInfo2.getId());
                                            }
                                        } else if (downloadInfo2 != null && !downloadInfo2.isChunkBreakpointAvailable()) {
                                            arrayList3.add(Integer.valueOf(downloadInfo2.getId()));
                                            sparseArray2.remove(downloadInfo2.getId());
                                        }
                                    }
                                    Iterator it = arrayList3.iterator();
                                    while (it.hasNext()) {
                                        sparseArray.remove(((Integer) it.next()).intValue());
                                    }
                                    i++;
                                }
                            }
                            xVar2 = xVar;
                            if (xVar2 != null) {
                                xVar2.pr();
                                c.this.uc = true;
                            }
                        } catch (Throwable th) {
                            xVar2 = xVar;
                            if (xVar2 != null) {
                            }
                        }
                    } catch (Throwable th2) {
                        com.byazt.tuy.uc.pr(cursorRawQuery);
                        c.this.pr(arrayList2);
                        c.this.pr(arrayList2, arrayList, (SparseArray<DownloadInfo>) sparseArray3, (SparseArray<DownloadInfo>) sparseArray, (SparseArray<List<com.byazt.auw.hw>>) sparseArray2);
                        try {
                            ArrayList arrayList4 = new ArrayList();
                            if (sparseArray != null) {
                                while (i < sparseArray.size()) {
                                    int iKeyAt2 = sparseArray.keyAt(i);
                                    if (iKeyAt2 != 0) {
                                        DownloadInfo downloadInfo3 = (DownloadInfo) sparseArray.get(iKeyAt2);
                                        if (com.byazt.tuy.pr.pr(8192)) {
                                            if (downloadInfo3 != null && !downloadInfo3.isChunkBreakpointAvailable() && downloadInfo3.getStatus() != -3) {
                                                arrayList4.add(Integer.valueOf(downloadInfo3.getId()));
                                                sparseArray2.remove(downloadInfo3.getId());
                                            }
                                        } else if (downloadInfo3 != null && !downloadInfo3.isChunkBreakpointAvailable()) {
                                            arrayList4.add(Integer.valueOf(downloadInfo3.getId()));
                                            sparseArray2.remove(downloadInfo3.getId());
                                        }
                                    }
                                    Iterator it2 = arrayList4.iterator();
                                    while (it2.hasNext()) {
                                        sparseArray.remove(((Integer) it2.next()).intValue());
                                    }
                                    i++;
                                }
                            }
                            xVar2 = xVar;
                            if (xVar2 != null) {
                            }
                        } catch (Throwable th3) {
                            xVar2 = xVar;
                            if (xVar2 != null) {
                            }
                        }
                    }
                    c.this.pr(sparseArray, sparseArray2);
                }
            };
            ExecutorService executorServiceLb = com.byazt.lj.hn.lb();
            if (executorServiceLb != null) {
                executorServiceLb.execute(runnable);
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        try {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    com.byazt.tuy.uc.hw(downloadInfo);
                }
            }
        } catch (Throwable th) {
        }
    }

    private void aj() {
        hw.beginTransaction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<com.byazt.auw.hw>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || hw == null) {
            return;
        }
        synchronized (hw) {
            try {
                aj();
                if (!list.isEmpty()) {
                    if (com.byazt.ew.pr.hn().pr("clear_invalid_task_error")) {
                        String[] strArr = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            strArr[i] = String.valueOf(list.get(i));
                        }
                        String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                        hw.delete("downloader", str, strArr);
                        hw.delete("downloadChunk", str, strArr);
                    } else {
                        String strJoin = TextUtils.join(", ", list2);
                        hw.delete("downloader", "_id IN (?)", new String[]{strJoin});
                        hw.delete("downloadChunk", "_id IN (?)", new String[]{strJoin});
                    }
                }
                for (int i2 = 0; i2 < size; i2++) {
                    int iKeyAt = sparseArray.keyAt(i2);
                    DownloadInfo downloadInfo = sparseArray.get(iKeyAt);
                    hw.delete("downloader", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                    hw.insert("downloader", null, downloadInfo.toContentValues());
                    if (downloadInfo.getChunkCount() > 1) {
                        List<com.byazt.auw.hw> listHn = hn(iKeyAt);
                        if (listHn.size() > 0) {
                            hw.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                            for (com.byazt.auw.hw hwVar : listHn) {
                                hwVar.hw(downloadInfo.getId());
                                hw.insert("downloadChunk", null, hwVar.pr());
                            }
                        }
                    }
                }
                if (sparseArray2 != null && sparseArray3 != null) {
                    int size2 = sparseArray2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        int id = sparseArray2.valueAt(i3).getId();
                        List<com.byazt.auw.hw> listPr = com.byazt.tuy.uc.pr(hn(id));
                        if (listPr != null && listPr.size() > 0) {
                            sparseArray3.put(id, listPr);
                        }
                    }
                }
                hw.setTransactionSuccessful();
                vk();
            } catch (Throwable th) {
                vk();
            }
        }
    }

    @Override // com.byazt.mef.hn
    public boolean pr(int i) {
        try {
            return hw(i) != null;
        } catch (Throwable th) {
            return false;
        }
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public DownloadInfo hw(int i) {
        Cursor cursorRawQuery;
        zo();
        if (hw != null) {
            try {
                cursorRawQuery = hw.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", ar.d), new String[]{Integer.toString(i)});
                try {
                    if (cursorRawQuery.moveToNext()) {
                        DownloadInfo downloadInfo = new DownloadInfo(cursorRawQuery);
                        com.byazt.tuy.uc.pr(cursorRawQuery);
                        return downloadInfo;
                    }
                    com.byazt.tuy.uc.pr(cursorRawQuery);
                } catch (Throwable th) {
                    com.byazt.tuy.uc.pr(cursorRawQuery);
                }
            } catch (Throwable th2) {
                cursorRawQuery = null;
            }
        }
        return null;
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public List<DownloadInfo> pr(String str) {
        zo();
        ArrayList arrayList = new ArrayList();
        if (hw != null) {
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = hw.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", BreakpointSQLiteKey.URL), new String[]{str});
                if (cursorRawQuery.moveToNext()) {
                    arrayList.add(new DownloadInfo(cursorRawQuery));
                }
                com.byazt.tuy.uc.pr(cursorRawQuery);
            } catch (Throwable th) {
                com.byazt.tuy.uc.pr(cursorRawQuery);
            }
        }
        return arrayList;
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public List<DownloadInfo> hw(String str) {
        return null;
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public List<DownloadInfo> hn(String str) {
        return null;
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public List<DownloadInfo> x(String str) {
        return null;
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public List<DownloadInfo> hw() {
        return null;
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public List<com.byazt.auw.hw> hn(int i) {
        ArrayList arrayList = new ArrayList();
        zo();
        if (hw != null) {
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = hw.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", ar.d), new String[]{Integer.toString(i)});
                while (cursorRawQuery.moveToNext()) {
                    arrayList.add(new com.byazt.auw.hw(cursorRawQuery));
                }
                com.byazt.tuy.uc.pr(cursorRawQuery);
            } catch (Throwable th) {
                com.byazt.tuy.uc.pr(cursorRawQuery);
            }
        }
        return arrayList;
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public void x(final int i) {
        zo();
        if (hw == null || this.x == null) {
            return;
        }
        com.byazt.lj.hn.hn(new Runnable() { // from class: com.byazt.mef.c.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.pr(i, c.this.x.hw());
                } catch (Throwable th) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i);
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public void pr(final com.byazt.auw.hw hwVar) {
        zo();
        if (hw == null || this.x == null) {
            return;
        }
        com.byazt.lj.hn.hn(new Runnable() { // from class: com.byazt.mef.c.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.pr(hwVar, c.this.x.pr());
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public void hw(com.byazt.auw.hw hwVar) {
        pr(hwVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.auw.hw hwVar, SQLiteStatement sQLiteStatement) {
        if (hwVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                hwVar.pr(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public void pr(final int i, final int i2, final long j) {
        zo();
        if (i == 0 || i2 < 0 || j < 0 || hw == null || this.x == null) {
            return;
        }
        com.byazt.lj.hn.hn(new Runnable() { // from class: com.byazt.mef.c.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.pr(i, i2, j, c.this.x.hn());
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public void pr(final int i, final int i2, final int i3, final long j) {
        zo();
        if (i == 0 || i2 < 0 || i3 < 0 || j < 0 || hw == null || this.x == null) {
            return;
        }
        com.byazt.lj.hn.hn(new Runnable() { // from class: com.byazt.mef.c.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.pr(i, i2, i3, j, c.this.x.hn());
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public void pr(final int i, final int i2, final int i3, final int i4) {
        zo();
        if (i == 0 || i3 < 0 || i4 == i2 || i4 < 0 || hw == null || this.x == null) {
            return;
        }
        com.byazt.lj.hn.hn(new Runnable() { // from class: com.byazt.mef.c.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.pr(i, i2, i3, i4, c.this.x.hn());
                } catch (Throwable th) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, int i2, int i3, int i4, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("chunkIndex", Integer.valueOf(i4));
                hw.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, int i2, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                hw.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, int i2, int i3, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                hw.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
        }
    }

    private void hw(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                try {
                    downloadInfo.bindValue(sQLiteStatement);
                    sQLiteStatement.bindLong(downloadInfo.getBindValueCount() + 1, downloadInfo.getId());
                    sQLiteStatement.execute();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
        }
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public DownloadInfo pr(int i, int i2) {
        zo();
        if (hw == null) {
            return null;
        }
        int i3 = 10;
        while (hw.isDbLockedByCurrentThread() && (i3 = i3 - 1) >= 0) {
            try {
                Thread.sleep(5L);
            } catch (Throwable th) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("chunkCount", Integer.valueOf(i2));
        hw.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        return null;
    }

    private void hn(final DownloadInfo downloadInfo) {
        zo();
        if (hw == null || this.hn == null) {
            return;
        }
        com.byazt.lj.hn.hn(new Runnable() { // from class: com.byazt.mef.c.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c cVar = c.this;
                    cVar.pr(downloadInfo, cVar.hn.pr());
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public boolean pr(final DownloadInfo downloadInfo) {
        zo();
        if (downloadInfo == null || hw == null) {
            return false;
        }
        com.byazt.lj.hn.hn(new Runnable() { // from class: com.byazt.mef.c.10
            @Override // java.lang.Runnable
            public void run() {
                c.this.x(downloadInfo);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void x(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        try {
            if (!pr(downloadInfo.getId())) {
                hn(downloadInfo);
                return;
            }
            fw fwVar = this.hn;
            if (fwVar == null) {
                return;
            }
            try {
                hw(downloadInfo, fwVar.hn());
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
        }
    }

    private void vk() {
        try {
            if (hw != null && hw.inTransaction()) {
                hw.endTransaction();
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public boolean c(int i) {
        fw fwVar;
        zo();
        if (hw == null || (fwVar = this.hn) == null) {
            return false;
        }
        try {
            pr(i, fwVar.hw());
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public boolean uc(final int i) {
        com.byazt.lj.hn.hn(new Runnable() { // from class: com.byazt.mef.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.c(i);
                c.this.x(i);
                c.this.m(i);
            }
        });
        return true;
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public void hn() {
        zo();
        if (hw == null) {
            return;
        }
        com.byazt.lj.hn.hn(new Runnable() { // from class: com.byazt.mef.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.w();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void w() {
        try {
            aj();
            hw.delete("downloader", null, null);
            hw.delete("downloadChunk", null, null);
            hw.setTransactionSuccessful();
            vk();
        } catch (Throwable th) {
            vk();
        }
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public DownloadInfo pr(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 3);
        contentValues.put("totalBytes", Long.valueOf(j));
        contentValues.put("eTag", str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put(Common.System.NAME, str2);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public DownloadInfo pr(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 4);
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public DownloadInfo hw(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-1));
        contentValues.put("curBytes", Long.valueOf(j));
        if (j > 0) {
            contentValues.put("isFirstDownload", (Integer) 0);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public DownloadInfo zo(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 5);
        contentValues.put("isFirstDownload", (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public DownloadInfo hn(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-3));
        contentValues.put("curBytes", Long.valueOf(j));
        contentValues.put("isFirstDownload", (Integer) 0);
        contentValues.put("isFirstSuccess", (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public DownloadInfo x(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-2));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.byazt.mef.hn
    public DownloadInfo c(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-4));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public DownloadInfo aj(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 1);
        update(i, contentValues);
        return null;
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public DownloadInfo vk(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-7));
        update(i, contentValues);
        return null;
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public boolean x() {
        return this.uc;
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public boolean c() {
        return false;
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public void hw(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public void pr(int i, List<com.byazt.auw.hw> list) {
    }

    @Override // com.byazt.mef.hn, com.byazt.lj.vk
    public void hw(int i, List<com.byazt.auw.hw> list) {
        try {
            x(i);
            if (list != null) {
                for (com.byazt.auw.hw hwVar : list) {
                    if (hwVar != null) {
                        pr(hwVar);
                        if (hwVar.uc()) {
                            Iterator<com.byazt.auw.hw> it = hwVar.fw().iterator();
                            while (it.hasNext()) {
                                pr(it.next());
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.lj.vk
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public ArrayList<aj> g(int i) {
        Map<Long, aj> mapK = k(i);
        if (mapK == null || mapK.isEmpty()) {
            return null;
        }
        return new ArrayList<>(mapK.values());
    }

    @Override // com.byazt.lj.vk
    public Map<Long, aj> k(int i) {
        Cursor cursorRawQuery;
        String string;
        zo();
        if (hw != null) {
            try {
                cursorRawQuery = hw.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "segments", ar.d), new String[]{Integer.toString(i)});
                try {
                    if (cursorRawQuery.moveToNext()) {
                        int columnIndex = cursorRawQuery.getColumnIndex("info");
                        if (columnIndex < 0) {
                            string = null;
                        } else {
                            string = cursorRawQuery.getString(columnIndex);
                        }
                        HashMap map = new HashMap();
                        JSONArray jSONArray = new JSONArray(string);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            aj ajVar = new aj(jSONArray.getJSONObject(i2));
                            map.put(Long.valueOf(ajVar.hn()), ajVar);
                        }
                        com.byazt.tuy.uc.pr(cursorRawQuery);
                        return map;
                    }
                    com.byazt.tuy.uc.pr(cursorRawQuery);
                } catch (Throwable th) {
                    com.byazt.tuy.uc.pr(cursorRawQuery);
                }
            } catch (Throwable th2) {
                cursorRawQuery = null;
            }
        }
        return null;
    }

    @Override // com.byazt.lj.vk
    public boolean pr(int i, Map<Long, aj> map) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        zo();
        if (hw == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<Long> it = map.keySet().iterator();
            while (it.hasNext()) {
                jSONArray.put(map.get(Long.valueOf(it.next().longValue())).w());
            }
        } catch (Throwable th) {
        }
        SQLiteStatement sQLiteStatementX = this.c.x();
        synchronized (sQLiteStatementX) {
            sQLiteStatementX.clearBindings();
            sQLiteStatementX.bindLong(1, i);
            sQLiteStatementX.bindString(2, jSONArray.toString());
            sQLiteStatementX.execute();
        }
        com.byazt.p000do.pr.hw("SqlDownloadCache", "updateSegments cost=" + com.byazt.tuy.uc.hn(jCurrentTimeMillis));
        return false;
    }

    @Override // com.byazt.lj.vk
    public void m(int i) {
        zo();
        if (hw == null) {
            return;
        }
        try {
            pr(i, this.c.hw());
        } catch (Throwable th) {
        }
    }

    private void update(final int i, final ContentValues contentValues) {
        zo();
        if (hw == null) {
            return;
        }
        com.byazt.lj.hn.hn(new Runnable() { // from class: com.byazt.mef.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.pr(i, contentValues);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, ContentValues contentValues) {
        int i2 = 10;
        while (hw.isDbLockedByCurrentThread() && (i2 = i2 - 1) >= 0) {
            try {
                Thread.sleep(5L);
            } catch (Throwable th) {
                return;
            }
        }
        try {
            hw.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
        } catch (Throwable th2) {
        }
    }

    @Override // com.byazt.mef.hn
    public void pr(hw hwVar) {
        this.pr = hwVar;
    }

    public void pr(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.byazt.auw.hw>> sparseArray2) {
        try {
            HashMap mapPr = com.byazt.tuy.uc.pr(sparseArray);
            HashMap mapPr2 = com.byazt.tuy.uc.pr(sparseArray2);
            hw hwVar = this.pr;
            if (hwVar != null) {
                hwVar.pr(mapPr, mapPr2);
            }
        } catch (Throwable th) {
        }
    }
}
