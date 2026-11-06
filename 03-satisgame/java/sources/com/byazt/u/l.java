package com.byazt.u;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.kl.rv;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.a;
import com.byazt.xv.cp;
import com.google.android.gms.common.internal.ImagesContract;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 745, 18})
public class l extends s.n implements a {
    public static volatile SQLiteDatabase qg;
    public x l;
    public qg n;
    public x q;
    public x s;
    public volatile boolean w;

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public boolean l() {
        return false;
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public void n(int i, List<com.byazt.wm.qg> list) {
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public List<DownloadInfo> q(String str) {
        return null;
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public List<DownloadInfo> qg() {
        return null;
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public List<DownloadInfo> qg(String str) {
        return null;
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public void qg(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public List<DownloadInfo> s(String str) {
        return null;
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public DownloadInfo x(int i) {
        return null;
    }

    public l() {
        this(false);
    }

    public l(boolean z) {
        this.n = null;
        if (z) {
            this.w = false;
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs() {
        if (qg == null) {
            synchronized (l.class) {
                if (qg == null) {
                    try {
                        qg = n.n().getWritableDatabase();
                        this.s = new x(qg, "downloader", com.byazt.sk.s.n, com.byazt.sk.s.qg);
                        this.q = new x(qg, "downloadChunk", com.byazt.sk.s.s, com.byazt.sk.s.q);
                        this.l = new x(qg, "segments", com.byazt.sk.s.l, com.byazt.sk.s.w);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    @Override // com.byazt.u.s
    public void n() {
        n(new SparseArray<>(), new SparseArray<>(), (q) null);
    }

    @Override // com.byazt.xv.a
    public void n(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.byazt.wm.qg>> sparseArray2, final q qVar) {
        try {
            Runnable runnable = new Runnable() { // from class: com.byazt.u.l.1
                @Override // java.lang.Runnable
                public void run() {
                    q qVar2;
                    boolean z;
                    int iN;
                    l.this.fs();
                    if (l.qg == null) {
                        return;
                    }
                    cp cpVarBb = com.byazt.xv.s.bb();
                    SparseArray sparseArray3 = new SparseArray();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    Cursor cursorRawQuery = null;
                    int i = 0;
                    try {
                        cursorRawQuery = l.qg.rawQuery("SELECT * FROM downloader", null);
                        while (cursorRawQuery.moveToNext()) {
                            DownloadInfo downloadInfo = new DownloadInfo(cursorRawQuery);
                            downloadInfo.setStatusAtDbInit(downloadInfo.getRealStatus());
                            if (downloadInfo.isCanResumeFromBreakPointStatus()) {
                                downloadInfo.setStatus(-5);
                                if (com.byazt.f.n.s().qg("status_not_update_to_db", true)) {
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
                                if (com.byazt.ta.w.n(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName())) {
                                    if (com.byazt.ta.n.n(33554432)) {
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
                                if (cpVarBb != null) {
                                    String taskKey = downloadInfo.getTaskKey();
                                    if (TextUtils.isEmpty(taskKey)) {
                                        taskKey = downloadInfo.getUrl();
                                    }
                                    iN = cpVarBb.n(taskKey, downloadInfo.getSavePath());
                                } else {
                                    iN = 0;
                                }
                                if (iN != id) {
                                    downloadInfo.setId(iN);
                                    sparseArray3.put(id, downloadInfo);
                                }
                                sparseArray.put(downloadInfo.getId(), downloadInfo);
                            }
                        }
                        com.byazt.ta.w.n(cursorRawQuery);
                        l.this.n(arrayList2);
                        l.this.n(arrayList2, arrayList, (SparseArray<DownloadInfo>) sparseArray3, (SparseArray<DownloadInfo>) sparseArray, (SparseArray<List<com.byazt.wm.qg>>) sparseArray2);
                        try {
                            ArrayList arrayList3 = new ArrayList();
                            if (sparseArray != null) {
                                while (i < sparseArray.size()) {
                                    int iKeyAt = sparseArray.keyAt(i);
                                    if (iKeyAt != 0) {
                                        DownloadInfo downloadInfo2 = (DownloadInfo) sparseArray.get(iKeyAt);
                                        if (com.byazt.ta.n.n(8192)) {
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
                            qVar2 = qVar;
                            if (qVar2 != null) {
                                qVar2.n();
                                l.this.w = true;
                            }
                        } catch (Throwable unused) {
                            qVar2 = qVar;
                            if (qVar2 != null) {
                            }
                        }
                    } catch (Throwable unused2) {
                        com.byazt.ta.w.n(cursorRawQuery);
                        l.this.n(arrayList2);
                        l.this.n(arrayList2, arrayList, (SparseArray<DownloadInfo>) sparseArray3, (SparseArray<DownloadInfo>) sparseArray, (SparseArray<List<com.byazt.wm.qg>>) sparseArray2);
                        try {
                            ArrayList arrayList4 = new ArrayList();
                            if (sparseArray != null) {
                                while (i < sparseArray.size()) {
                                    int iKeyAt2 = sparseArray.keyAt(i);
                                    if (iKeyAt2 != 0) {
                                        DownloadInfo downloadInfo3 = (DownloadInfo) sparseArray.get(iKeyAt2);
                                        if (com.byazt.ta.n.n(8192)) {
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
                            qVar2 = qVar;
                            if (qVar2 != null) {
                            }
                        } catch (Throwable unused3) {
                            qVar2 = qVar;
                            if (qVar2 != null) {
                            }
                        }
                    }
                    l.this.n(sparseArray, sparseArray2);
                }
            };
            ExecutorService executorServiceCd = com.byazt.xv.s.cd();
            if (executorServiceCd != null) {
                executorServiceCd.execute(runnable);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        try {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    com.byazt.ta.w.qg(downloadInfo);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void rv() {
        qg.beginTransaction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<com.byazt.wm.qg>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || qg == null) {
            return;
        }
        synchronized (qg) {
            try {
                rv();
                if (!list.isEmpty()) {
                    if (com.byazt.f.n.s().n("clear_invalid_task_error")) {
                        String[] strArr = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            strArr[i] = String.valueOf(list.get(i));
                        }
                        String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                        qg.delete("downloader", str, strArr);
                        qg.delete("downloadChunk", str, strArr);
                    } else {
                        String strJoin = TextUtils.join(", ", list2);
                        qg.delete("downloader", "_id IN (?)", new String[]{strJoin});
                        qg.delete("downloadChunk", "_id IN (?)", new String[]{strJoin});
                    }
                }
                for (int i2 = 0; i2 < size; i2++) {
                    int iKeyAt = sparseArray.keyAt(i2);
                    DownloadInfo downloadInfo = sparseArray.get(iKeyAt);
                    qg.delete("downloader", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                    qg.insert("downloader", null, downloadInfo.toContentValues());
                    if (downloadInfo.getChunkCount() > 1) {
                        List<com.byazt.wm.qg> listS = s(iKeyAt);
                        if (listS.size() > 0) {
                            qg.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                            for (com.byazt.wm.qg qgVar : listS) {
                                qgVar.qg(downloadInfo.getId());
                                qg.insert("downloadChunk", null, qgVar.n());
                            }
                        }
                    }
                }
                if (sparseArray2 != null && sparseArray3 != null) {
                    int size2 = sparseArray2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        int id = sparseArray2.valueAt(i3).getId();
                        List<com.byazt.wm.qg> listN = com.byazt.ta.w.n(s(id));
                        if (listN != null && listN.size() > 0) {
                            sparseArray3.put(id, listN);
                        }
                    }
                }
                qg.setTransactionSuccessful();
            } catch (Throwable unused) {
            }
            tj();
        }
    }

    @Override // com.byazt.u.s
    public boolean n(int i) {
        try {
            return qg(i) != null;
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public DownloadInfo qg(int i) {
        Cursor cursorRawQuery;
        fs();
        if (qg != null) {
            try {
                cursorRawQuery = qg.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "_id"), new String[]{Integer.toString(i)});
                try {
                    if (cursorRawQuery.moveToNext()) {
                        DownloadInfo downloadInfo = new DownloadInfo(cursorRawQuery);
                        com.byazt.ta.w.n(cursorRawQuery);
                        return downloadInfo;
                    }
                    com.byazt.ta.w.n(cursorRawQuery);
                } catch (Throwable unused) {
                    com.byazt.ta.w.n(cursorRawQuery);
                }
            } catch (Throwable unused2) {
                cursorRawQuery = null;
            }
        }
        return null;
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public List<DownloadInfo> n(String str) {
        Cursor cursorRawQuery;
        fs();
        ArrayList arrayList = new ArrayList();
        if (qg != null) {
            try {
                cursorRawQuery = qg.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", ImagesContract.URL), new String[]{str});
                try {
                    if (cursorRawQuery.moveToNext()) {
                        arrayList.add(new DownloadInfo(cursorRawQuery));
                    }
                    com.byazt.ta.w.n(cursorRawQuery);
                } catch (Throwable unused) {
                    com.byazt.ta.w.n(cursorRawQuery);
                }
            } catch (Throwable unused2) {
                cursorRawQuery = null;
            }
        }
        return arrayList;
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public List<com.byazt.wm.qg> s(int i) {
        Cursor cursorRawQuery;
        ArrayList arrayList = new ArrayList();
        fs();
        if (qg != null) {
            try {
                cursorRawQuery = qg.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", "_id"), new String[]{Integer.toString(i)});
                while (cursorRawQuery.moveToNext()) {
                    try {
                        arrayList.add(new com.byazt.wm.qg(cursorRawQuery));
                    } catch (Throwable unused) {
                        com.byazt.ta.w.n(cursorRawQuery);
                    }
                }
                com.byazt.ta.w.n(cursorRawQuery);
            } catch (Throwable unused2) {
                cursorRawQuery = null;
            }
        }
        return arrayList;
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public void q(final int i) {
        fs();
        if (qg == null || this.q == null) {
            return;
        }
        com.byazt.xv.s.s(new Runnable() { // from class: com.byazt.u.l.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    l.this.n(i, l.this.q.qg());
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i);
                sQLiteStatement.execute();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public void n(final com.byazt.wm.qg qgVar) {
        fs();
        if (qg == null || this.q == null) {
            return;
        }
        com.byazt.xv.s.s(new Runnable() { // from class: com.byazt.u.l.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    l.this.n(qgVar, l.this.q.n());
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public void qg(com.byazt.wm.qg qgVar) {
        n(qgVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.wm.qg qgVar, SQLiteStatement sQLiteStatement) {
        if (qgVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                qgVar.n(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public void n(final int i, final int i2, final long j) {
        fs();
        if (i == 0 || i2 < 0 || j < 0 || qg == null || this.q == null) {
            return;
        }
        com.byazt.xv.s.s(new Runnable() { // from class: com.byazt.u.l.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    l.this.n(i, i2, j, l.this.q.s());
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public void n(final int i, final int i2, final int i3, final long j) {
        fs();
        if (i == 0 || i2 < 0 || i3 < 0 || j < 0 || qg == null || this.q == null) {
            return;
        }
        com.byazt.xv.s.s(new Runnable() { // from class: com.byazt.u.l.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    l.this.n(i, i2, i3, j, l.this.q.s());
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public void n(final int i, final int i2, final int i3, final int i4) {
        fs();
        if (i == 0 || i3 < 0 || i4 == i2 || i4 < 0 || qg == null || this.q == null) {
            return;
        }
        com.byazt.xv.s.s(new Runnable() { // from class: com.byazt.u.l.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    l.this.n(i, i2, i3, i4, l.this.q.s());
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2, int i3, int i4, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("chunkIndex", Integer.valueOf(i4));
                qg.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                qg.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2, int i3, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                qg.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void qg(com.byazt.wm.DownloadInfo r4, android.database.sqlite.SQLiteStatement r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L1f
            if (r5 != 0) goto L5
            goto L1f
        L5:
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L1f
            r4.bindValue(r5)     // Catch: java.lang.Throwable -> L1c
            int r0 = r4.getBindValueCount()     // Catch: java.lang.Throwable -> L1c
            int r0 = r0 + 1
            int r4 = r4.getId()     // Catch: java.lang.Throwable -> L1c
            long r1 = (long) r4     // Catch: java.lang.Throwable -> L1c
            r5.bindLong(r0, r1)     // Catch: java.lang.Throwable -> L1c
            r5.execute()     // Catch: java.lang.Throwable -> L1c
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L1c
            return
        L1c:
            r4 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L1c
            throw r4     // Catch: java.lang.Throwable -> L1f
        L1f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.u.l.qg(com.byazt.wm.DownloadInfo, android.database.sqlite.SQLiteStatement):void");
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public DownloadInfo n(int i, int i2) {
        fs();
        if (qg == null) {
            return null;
        }
        int i3 = 10;
        while (qg.isDbLockedByCurrentThread() && (i3 = i3 - 1) >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("chunkCount", Integer.valueOf(i2));
        qg.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        return null;
    }

    private void s(final DownloadInfo downloadInfo) {
        fs();
        if (qg == null || this.s == null) {
            return;
        }
        com.byazt.xv.s.s(new Runnable() { // from class: com.byazt.u.l.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    l lVar = l.this;
                    lVar.n(downloadInfo, lVar.s.n());
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public boolean n(final DownloadInfo downloadInfo) {
        fs();
        if (downloadInfo == null || qg == null) {
            return false;
        }
        com.byazt.xv.s.s(new Runnable() { // from class: com.byazt.u.l.10
            @Override // java.lang.Runnable
            public void run() {
                l.this.q(downloadInfo);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        try {
            if (!n(downloadInfo.getId())) {
                s(downloadInfo);
                return;
            }
            x xVar = this.s;
            if (xVar == null) {
                return;
            }
            try {
                qg(downloadInfo, xVar.s());
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
        }
    }

    private void tj() {
        try {
            if (qg == null || !qg.inTransaction()) {
                return;
            }
            qg.endTransaction();
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public boolean l(int i) {
        x xVar;
        fs();
        if (qg != null && (xVar = this.s) != null) {
            try {
                n(i, xVar.qg());
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public boolean w(final int i) {
        com.byazt.xv.s.s(new Runnable() { // from class: com.byazt.u.l.11
            @Override // java.lang.Runnable
            public void run() {
                l.this.l(i);
                l.this.q(i);
                l.this.oa(i);
            }
        });
        return true;
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public void s() {
        fs();
        if (qg == null) {
            return;
        }
        com.byazt.xv.s.s(new Runnable() { // from class: com.byazt.u.l.2
            @Override // java.lang.Runnable
            public void run() {
                l.this.cp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cp() {
        try {
            rv();
            qg.delete("downloader", null, null);
            qg.delete("downloadChunk", null, null);
            qg.setTransactionSuccessful();
            tj();
        } catch (Throwable unused) {
            tj();
        }
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public DownloadInfo n(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 3);
        contentValues.put("totalBytes", Long.valueOf(j));
        contentValues.put("eTag", str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put(TapEventParamConstants.PARAM_NAME, str2);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public DownloadInfo n(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public DownloadInfo qg(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        contentValues.put("curBytes", Long.valueOf(j));
        if (j > 0) {
            contentValues.put("isFirstDownload", (Integer) 0);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public DownloadInfo fs(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 5);
        contentValues.put("isFirstDownload", (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public DownloadInfo s(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-3));
        contentValues.put("curBytes", Long.valueOf(j));
        contentValues.put("isFirstDownload", (Integer) 0);
        contentValues.put("isFirstSuccess", (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public DownloadInfo q(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-2));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.byazt.u.s
    public DownloadInfo l(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-4));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public DownloadInfo rv(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        update(i, contentValues);
        return null;
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public DownloadInfo tj(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-7));
        update(i, contentValues);
        return null;
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public boolean q() {
        return this.w;
    }

    @Override // com.byazt.u.s, com.byazt.xv.tj
    public void qg(int i, List<com.byazt.wm.qg> list) {
        try {
            q(i);
            if (list != null) {
                for (com.byazt.wm.qg qgVar : list) {
                    if (qgVar != null) {
                        n(qgVar);
                        if (qgVar.w()) {
                            Iterator<com.byazt.wm.qg> it = qgVar.x().iterator();
                            while (it.hasNext()) {
                                n(it.next());
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.xv.tj
    /* JADX INFO: renamed from: cp, reason: merged with bridge method [inline-methods] */
    public ArrayList<rv> sz(int i) {
        Map<Long, rv> mapD = d(i);
        if (mapD == null || mapD.isEmpty()) {
            return null;
        }
        return new ArrayList<>(mapD.values());
    }

    @Override // com.byazt.xv.tj
    public Map<Long, rv> d(int i) {
        Cursor cursorRawQuery;
        fs();
        if (qg != null) {
            try {
                cursorRawQuery = qg.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "segments", "_id"), new String[]{Integer.toString(i)});
                try {
                    if (cursorRawQuery.moveToNext()) {
                        int columnIndex = cursorRawQuery.getColumnIndex("info");
                        String string = columnIndex >= 0 ? cursorRawQuery.getString(columnIndex) : null;
                        HashMap map = new HashMap();
                        JSONArray jSONArray = new JSONArray(string);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            rv rvVar = new rv(jSONArray.getJSONObject(i2));
                            map.put(Long.valueOf(rvVar.s()), rvVar);
                        }
                        com.byazt.ta.w.n(cursorRawQuery);
                        return map;
                    }
                    com.byazt.ta.w.n(cursorRawQuery);
                } catch (Throwable unused) {
                    com.byazt.ta.w.n(cursorRawQuery);
                }
            } catch (Throwable unused2) {
                cursorRawQuery = null;
            }
        }
        return null;
    }

    @Override // com.byazt.xv.tj
    public boolean n(int i, Map<Long, rv> map) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        fs();
        if (qg == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<Long> it = map.keySet().iterator();
            while (it.hasNext()) {
                jSONArray.put(map.get(Long.valueOf(it.next().longValue())).cp());
            }
        } catch (Throwable unused) {
        }
        SQLiteStatement sQLiteStatementQ = this.l.q();
        synchronized (sQLiteStatementQ) {
            sQLiteStatementQ.clearBindings();
            sQLiteStatementQ.bindLong(1, i);
            sQLiteStatementQ.bindString(2, jSONArray.toString());
            sQLiteStatementQ.execute();
        }
        com.byazt.fe.n.qg("SqlDownloadCache", "updateSegments cost=" + com.byazt.ta.w.s(jCurrentTimeMillis));
        return false;
    }

    @Override // com.byazt.xv.tj
    public void oa(int i) {
        fs();
        if (qg == null) {
            return;
        }
        try {
            n(i, this.l.qg());
        } catch (Throwable unused) {
        }
    }

    private void update(final int i, final ContentValues contentValues) {
        fs();
        if (qg == null) {
            return;
        }
        com.byazt.xv.s.s(new Runnable() { // from class: com.byazt.u.l.3
            @Override // java.lang.Runnable
            public void run() {
                l.this.n(i, contentValues);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, ContentValues contentValues) {
        int i2 = 10;
        while (qg.isDbLockedByCurrentThread() && (i2 = i2 - 1) >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                return;
            }
        }
        qg.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
    }

    @Override // com.byazt.u.s
    public void n(qg qgVar) {
        this.n = qgVar;
    }

    public void n(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.byazt.wm.qg>> sparseArray2) {
        try {
            HashMap mapN = com.byazt.ta.w.n(sparseArray);
            HashMap mapN2 = com.byazt.ta.w.n(sparseArray2);
            qg qgVar = this.n;
            if (qgVar != null) {
                qgVar.n(mapN, mapN2);
            }
        } catch (Throwable unused) {
        }
    }
}
