package com.ss.android.socialbase.downloader.xr;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.c.ny;
import com.ss.android.socialbase.downloader.downloader.hi;
import com.ss.android.socialbase.downloader.downloader.t;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.bz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public class ka extends ah.ms implements t {
    private static volatile SQLiteDatabase xr;
    private ab ah;
    private volatile boolean c;
    private ab d;
    private ab ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    xr f4813ms;

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public DownloadInfo ab(int i) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public List<DownloadInfo> ah(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public List<DownloadInfo> d(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public boolean ka() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public void ms(int i, List<com.ss.android.socialbase.downloader.model.xr> list) {
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public List<DownloadInfo> xr() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public List<DownloadInfo> xr(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public void xr(DownloadInfo downloadInfo) {
    }

    public ka() {
        this(false);
    }

    public ka(boolean z) {
        this.f4813ms = null;
        if (z) {
            this.c = false;
            ms();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (xr == null) {
            synchronized (ka.class) {
                if (xr == null) {
                    try {
                        xr = ms.ms().getWritableDatabase();
                        this.ah = new ab(xr, "downloader", com.ss.android.socialbase.downloader.constants.ah.f4628ms, com.ss.android.socialbase.downloader.constants.ah.xr);
                        this.d = new ab(xr, "downloadChunk", com.ss.android.socialbase.downloader.constants.ah.ah, com.ss.android.socialbase.downloader.constants.ah.d);
                        this.ka = new ab(xr, "segments", com.ss.android.socialbase.downloader.constants.ah.ka, com.ss.android.socialbase.downloader.constants.ah.c);
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.api.ab.ms(th);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public void ms() {
        ms(new SparseArray<>(), new SparseArray<>(), (d) null);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void ms(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.model.xr>> sparseArray2, final d dVar) {
        try {
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.xr.ka.1
                /* JADX WARN: Code duplicated, block: B:170:0x0349 A[PHI: r0
                  0x0349: PHI (r0v14 com.ss.android.socialbase.downloader.xr.d) = (r0v13 com.ss.android.socialbase.downloader.xr.d), (r0v18 com.ss.android.socialbase.downloader.xr.d) binds: [B:169:0x0347, B:164:0x033e] A[DONT_GENERATE, DONT_INLINE]] */
                @Override // java.lang.Runnable
                public void run() {
                    d dVar2;
                    d dVar3;
                    boolean z;
                    int iMs;
                    ka.this.x();
                    if (ka.xr == null) {
                        return;
                    }
                    hi hiVarCv = com.ss.android.socialbase.downloader.downloader.ah.cv();
                    SparseArray sparseArray3 = new SparseArray();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    Cursor cursorRawQuery = null;
                    int i = 0;
                    try {
                        cursorRawQuery = ka.xr.rawQuery("SELECT * FROM downloader", null);
                        while (cursorRawQuery.moveToNext()) {
                            DownloadInfo downloadInfo = new DownloadInfo(cursorRawQuery);
                            downloadInfo.setStatusAtDbInit(downloadInfo.getRealStatus());
                            if (downloadInfo.isCanResumeFromBreakPointStatus()) {
                                downloadInfo.setStatus(-5);
                                if (com.ss.android.socialbase.downloader.ab.ms.ah().xr("status_not_update_to_db", true)) {
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
                                if (com.ss.android.socialbase.downloader.ny.c.ms(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName())) {
                                    if (com.ss.android.socialbase.downloader.ny.ms.ms(33554432)) {
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
                                if (hiVarCv != null) {
                                    String taskKey = downloadInfo.getTaskKey();
                                    if (TextUtils.isEmpty(taskKey)) {
                                        taskKey = downloadInfo.getUrl();
                                    }
                                    iMs = hiVarCv.ms(taskKey, downloadInfo.getSavePath());
                                } else {
                                    iMs = 0;
                                }
                                if (iMs != id) {
                                    downloadInfo.setId(iMs);
                                    sparseArray3.put(id, downloadInfo);
                                }
                                sparseArray.put(downloadInfo.getId(), downloadInfo);
                            }
                        }
                        com.ss.android.socialbase.downloader.ny.c.ms(cursorRawQuery);
                        ka.this.ms(arrayList2);
                        ka.this.ms(arrayList2, arrayList, (SparseArray<DownloadInfo>) sparseArray3, (SparseArray<DownloadInfo>) sparseArray, (SparseArray<List<com.ss.android.socialbase.downloader.model.xr>>) sparseArray2);
                        try {
                            ArrayList arrayList3 = new ArrayList();
                            if (sparseArray != null) {
                                while (i < sparseArray.size()) {
                                    int iKeyAt = sparseArray.keyAt(i);
                                    if (iKeyAt != 0) {
                                        DownloadInfo downloadInfo2 = (DownloadInfo) sparseArray.get(iKeyAt);
                                        if (com.ss.android.socialbase.downloader.ny.ms.ms(8192)) {
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
                            dVar3 = dVar;
                            if (dVar3 != null) {
                                dVar3.ms();
                            }
                        } catch (Throwable th) {
                            try {
                                com.bytedance.sdk.openadsdk.api.ab.ms(th);
                                dVar3 = dVar;
                                if (dVar3 != null) {
                                }
                            } finally {
                                if (dVar != null) {
                                    dVar.ms();
                                    ka.this.c = true;
                                }
                                ka.this.ms(sparseArray, sparseArray2);
                            }
                        }
                    } catch (Throwable th2) {
                        try {
                            com.bytedance.sdk.openadsdk.api.ab.ms(th2);
                            com.ss.android.socialbase.downloader.ny.c.ms(cursorRawQuery);
                            ka.this.ms(arrayList2);
                            ka.this.ms(arrayList2, arrayList, (SparseArray<DownloadInfo>) sparseArray3, (SparseArray<DownloadInfo>) sparseArray, (SparseArray<List<com.ss.android.socialbase.downloader.model.xr>>) sparseArray2);
                            try {
                                ArrayList arrayList4 = new ArrayList();
                                if (sparseArray != null) {
                                    while (i < sparseArray.size()) {
                                        int iKeyAt2 = sparseArray.keyAt(i);
                                        if (iKeyAt2 != 0) {
                                            DownloadInfo downloadInfo3 = (DownloadInfo) sparseArray.get(iKeyAt2);
                                            if (com.ss.android.socialbase.downloader.ny.ms.ms(8192)) {
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
                                dVar3 = dVar;
                                if (dVar3 != null) {
                                }
                            } catch (Throwable th3) {
                                try {
                                    com.bytedance.sdk.openadsdk.api.ab.ms(th3);
                                    dVar3 = dVar;
                                    if (dVar3 != null) {
                                    }
                                } finally {
                                    if (dVar != null) {
                                        dVar.ms();
                                        ka.this.c = true;
                                    }
                                    ka.this.ms(sparseArray, sparseArray2);
                                }
                            }
                        } catch (Throwable th4) {
                            com.ss.android.socialbase.downloader.ny.c.ms(cursorRawQuery);
                            ka.this.ms(arrayList2);
                            ka.this.ms(arrayList2, arrayList, (SparseArray<DownloadInfo>) sparseArray3, (SparseArray<DownloadInfo>) sparseArray, (SparseArray<List<com.ss.android.socialbase.downloader.model.xr>>) sparseArray2);
                            try {
                                ArrayList arrayList5 = new ArrayList();
                                if (sparseArray != null) {
                                    while (i < sparseArray.size()) {
                                        int iKeyAt3 = sparseArray.keyAt(i);
                                        if (iKeyAt3 != 0) {
                                            DownloadInfo downloadInfo4 = (DownloadInfo) sparseArray.get(iKeyAt3);
                                            if (com.ss.android.socialbase.downloader.ny.ms.ms(8192)) {
                                                if (downloadInfo4 != null && !downloadInfo4.isChunkBreakpointAvailable() && downloadInfo4.getStatus() != -3) {
                                                    arrayList5.add(Integer.valueOf(downloadInfo4.getId()));
                                                    sparseArray2.remove(downloadInfo4.getId());
                                                }
                                            } else if (downloadInfo4 != null && !downloadInfo4.isChunkBreakpointAvailable()) {
                                                arrayList5.add(Integer.valueOf(downloadInfo4.getId()));
                                                sparseArray2.remove(downloadInfo4.getId());
                                            }
                                        }
                                        Iterator it3 = arrayList5.iterator();
                                        while (it3.hasNext()) {
                                            sparseArray.remove(((Integer) it3.next()).intValue());
                                        }
                                        i++;
                                    }
                                }
                                dVar2 = dVar;
                                if (dVar2 != null) {
                                    dVar2.ms();
                                }
                            } catch (Throwable th5) {
                                try {
                                    com.bytedance.sdk.openadsdk.api.ab.ms(th5);
                                    dVar2 = dVar;
                                    if (dVar2 != null) {
                                        dVar2.ms();
                                    }
                                } finally {
                                    if (dVar != null) {
                                        dVar.ms();
                                        ka.this.c = true;
                                    }
                                    ka.this.ms(sparseArray, sparseArray2);
                                }
                            }
                            throw th4;
                        }
                    }
                }
            };
            ExecutorService executorServiceQv = com.ss.android.socialbase.downloader.downloader.ah.qv();
            if (executorServiceQv != null) {
                executorServiceQv.execute(runnable);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        try {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    com.ss.android.socialbase.downloader.ny.c.xr(downloadInfo);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void ny() {
        xr.beginTransaction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<com.ss.android.socialbase.downloader.model.xr>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || xr == null) {
            return;
        }
        synchronized (xr) {
            try {
                try {
                    ny();
                    if (!list.isEmpty()) {
                        if (com.ss.android.socialbase.downloader.ab.ms.ah().ms("clear_invalid_task_error")) {
                            String[] strArr = new String[list.size()];
                            for (int i = 0; i < list.size(); i++) {
                                strArr[i] = String.valueOf(list.get(i));
                            }
                            String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                            xr.delete("downloader", str, strArr);
                            xr.delete("downloadChunk", str, strArr);
                        } else {
                            String strJoin = TextUtils.join(", ", list2);
                            xr.delete("downloader", "_id IN (?)", new String[]{strJoin});
                            xr.delete("downloadChunk", "_id IN (?)", new String[]{strJoin});
                        }
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        int iKeyAt = sparseArray.keyAt(i2);
                        DownloadInfo downloadInfo = sparseArray.get(iKeyAt);
                        xr.delete("downloader", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                        xr.insert("downloader", null, downloadInfo.toContentValues());
                        if (downloadInfo.getChunkCount() > 1) {
                            List<com.ss.android.socialbase.downloader.model.xr> listAh = ah(iKeyAt);
                            if (listAh.size() > 0) {
                                xr.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                                for (com.ss.android.socialbase.downloader.model.xr xrVar : listAh) {
                                    xrVar.xr(downloadInfo.getId());
                                    xr.insert("downloadChunk", null, xrVar.ms());
                                }
                            }
                        }
                    }
                    if (sparseArray2 != null && sparseArray3 != null) {
                        int size2 = sparseArray2.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            int id = sparseArray2.valueAt(i3).getId();
                            List<com.ss.android.socialbase.downloader.model.xr> listMs = com.ss.android.socialbase.downloader.ny.c.ms(ah(id));
                            if (listMs != null && listMs.size() > 0) {
                                sparseArray3.put(id, listMs);
                            }
                        }
                    }
                    xr.setTransactionSuccessful();
                } catch (Throwable th) {
                    try {
                        com.bytedance.sdk.openadsdk.api.ab.ms(th);
                    } catch (Throwable th2) {
                        ch();
                        throw th2;
                    }
                }
                ch();
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public boolean ms(int i) {
        try {
            return xr(i) != null;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public DownloadInfo xr(int i) {
        Cursor cursorRawQuery;
        x();
        if (xr != null) {
            try {
                cursorRawQuery = xr.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", bz.d), new String[]{Integer.toString(i)});
                try {
                    if (cursorRawQuery.moveToNext()) {
                        DownloadInfo downloadInfo = new DownloadInfo(cursorRawQuery);
                        com.ss.android.socialbase.downloader.ny.c.ms(cursorRawQuery);
                        return downloadInfo;
                    }
                    com.ss.android.socialbase.downloader.ny.c.ms(cursorRawQuery);
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.bytedance.sdk.openadsdk.api.ab.ms(th);
                        com.ss.android.socialbase.downloader.ny.c.ms(cursorRawQuery);
                    } catch (Throwable th2) {
                        com.ss.android.socialbase.downloader.ny.c.ms(cursorRawQuery);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                cursorRawQuery = null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public List<DownloadInfo> ms(String str) {
        x();
        ArrayList arrayList = new ArrayList();
        if (xr != null) {
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = xr.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "url"), new String[]{str});
                if (cursorRawQuery.moveToNext()) {
                    arrayList.add(new DownloadInfo(cursorRawQuery));
                }
                com.ss.android.socialbase.downloader.ny.c.ms(cursorRawQuery);
            } catch (Throwable th) {
                try {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                    com.ss.android.socialbase.downloader.ny.c.ms(cursorRawQuery);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.ny.c.ms(cursorRawQuery);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public List<com.ss.android.socialbase.downloader.model.xr> ah(int i) {
        ArrayList arrayList = new ArrayList();
        x();
        if (xr != null) {
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = xr.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", bz.d), new String[]{Integer.toString(i)});
                while (cursorRawQuery.moveToNext()) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.xr(cursorRawQuery));
                }
                com.ss.android.socialbase.downloader.ny.c.ms(cursorRawQuery);
            } catch (Throwable th) {
                try {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                    com.ss.android.socialbase.downloader.ny.c.ms(cursorRawQuery);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.ny.c.ms(cursorRawQuery);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public void d(final int i) {
        x();
        if (xr == null || this.d == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.ah.ah(new Runnable() { // from class: com.ss.android.socialbase.downloader.xr.ka.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ka.this.ms(i, ka.this.d.xr());
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i);
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public void ms(final com.ss.android.socialbase.downloader.model.xr xrVar) {
        x();
        if (xr == null || this.d == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.ah.ah(new Runnable() { // from class: com.ss.android.socialbase.downloader.xr.ka.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ka.this.ms(xrVar, ka.this.d.ms());
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public void xr(com.ss.android.socialbase.downloader.model.xr xrVar) {
        ms(xrVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.ss.android.socialbase.downloader.model.xr xrVar, SQLiteStatement sQLiteStatement) {
        if (xrVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                xrVar.ms(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public void ms(final int i, final int i2, final long j) {
        x();
        if (i == 0 || i2 < 0 || j < 0 || xr == null || this.d == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.ah.ah(new Runnable() { // from class: com.ss.android.socialbase.downloader.xr.ka.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ka.this.ms(i, i2, j, ka.this.d.ah());
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public void ms(final int i, final int i2, final int i3, final long j) {
        x();
        if (i == 0 || i2 < 0 || i3 < 0 || j < 0 || xr == null || this.d == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.ah.ah(new Runnable() { // from class: com.ss.android.socialbase.downloader.xr.ka.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ka.this.ms(i, i2, i3, j, ka.this.d.ah());
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public void ms(final int i, final int i2, final int i3, final int i4) {
        x();
        if (i == 0 || i3 < 0 || i4 == i2 || i4 < 0 || xr == null || this.d == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.ah.ah(new Runnable() { // from class: com.ss.android.socialbase.downloader.xr.ka.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ka.this.ms(i, i2, i3, i4, ka.this.d.ah());
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, int i2, int i3, int i4, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("chunkIndex", Integer.valueOf(i4));
                xr.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, int i2, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                xr.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, int i2, int i3, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                xr.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x001f */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void xr(com.ss.android.socialbase.downloader.model.DownloadInfo r4, android.database.sqlite.SQLiteStatement r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L23
            if (r5 != 0) goto L5
            goto L23
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
            r4 = move-exception
            com.bytedance.sdk.openadsdk.api.ab.ms(r4)
        L23:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.xr.ka.xr(com.ss.android.socialbase.downloader.model.DownloadInfo, android.database.sqlite.SQLiteStatement):void");
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public DownloadInfo ms(int i, int i2) {
        x();
        if (xr == null) {
            return null;
        }
        int i3 = 10;
        while (xr.isDbLockedByCurrentThread() && (i3 = i3 - 1) >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th2);
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("chunkCount", Integer.valueOf(i2));
        xr.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        return null;
    }

    private void ah(final DownloadInfo downloadInfo) {
        x();
        if (xr == null || this.ah == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.ah.ah(new Runnable() { // from class: com.ss.android.socialbase.downloader.xr.ka.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ka kaVar = ka.this;
                    kaVar.ms(downloadInfo, kaVar.ah.ms());
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public boolean ms(final DownloadInfo downloadInfo) {
        x();
        if (downloadInfo == null || xr == null) {
            return false;
        }
        com.ss.android.socialbase.downloader.downloader.ah.ah(new Runnable() { // from class: com.ss.android.socialbase.downloader.xr.ka.10
            @Override // java.lang.Runnable
            public void run() {
                ka.this.d(downloadInfo);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        try {
            if (!ms(downloadInfo.getId())) {
                ah(downloadInfo);
                return;
            }
            ab abVar = this.ah;
            if (abVar == null) {
                return;
            }
            try {
                xr(downloadInfo, abVar.ah());
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th2);
        }
    }

    private void ch() {
        try {
            if (xr == null || !xr.inTransaction()) {
                return;
            }
            xr.endTransaction();
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public boolean ka(int i) {
        ab abVar;
        x();
        if (xr != null && (abVar = this.ah) != null) {
            try {
                ms(i, abVar.xr());
                return true;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
            }
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public boolean c(final int i) {
        com.ss.android.socialbase.downloader.downloader.ah.ah(new Runnable() { // from class: com.ss.android.socialbase.downloader.xr.ka.11
            @Override // java.lang.Runnable
            public void run() {
                ka.this.ka(i);
                ka.this.d(i);
                ka.this.zb(i);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public void ah() {
        x();
        if (xr == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.ah.ah(new Runnable() { // from class: com.ss.android.socialbase.downloader.xr.ka.2
            @Override // java.lang.Runnable
            public void run() {
                ka.this.hi();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void hi() {
        try {
            ny();
            xr.delete("downloader", null, null);
            xr.delete("downloadChunk", null, null);
            xr.setTransactionSuccessful();
            ch();
        } catch (Throwable th) {
            try {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
            } finally {
                ch();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public DownloadInfo ms(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 3);
        contentValues.put("totalBytes", Long.valueOf(j));
        contentValues.put("eTag", str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put(Common.System.NAME, str2);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public DownloadInfo ms(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public DownloadInfo xr(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        contentValues.put("curBytes", Long.valueOf(j));
        if (j > 0) {
            contentValues.put("isFirstDownload", (Integer) 0);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public DownloadInfo x(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 5);
        contentValues.put("isFirstDownload", (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public DownloadInfo ah(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-3));
        contentValues.put("curBytes", Long.valueOf(j));
        contentValues.put("isFirstDownload", (Integer) 0);
        contentValues.put("isFirstSuccess", (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public DownloadInfo d(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-2));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public DownloadInfo ka(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-4));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public DownloadInfo ny(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public DownloadInfo ch(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-7));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public boolean d() {
        return this.c;
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public void xr(int i, List<com.ss.android.socialbase.downloader.model.xr> list) {
        try {
            d(i);
            if (list != null) {
                for (com.ss.android.socialbase.downloader.model.xr xrVar : list) {
                    if (xrVar != null) {
                        ms(xrVar);
                        if (xrVar.c()) {
                            Iterator<com.ss.android.socialbase.downloader.model.xr> it = xrVar.ab().iterator();
                            while (it.hasNext()) {
                                ms(it.next());
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    /* JADX INFO: renamed from: hi, reason: merged with bridge method [inline-methods] */
    public ArrayList<ny> u(int i) {
        Map<Long, ny> mapSl = sl(i);
        if (mapSl == null || mapSl.isEmpty()) {
            return null;
        }
        return new ArrayList<>(mapSl.values());
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public Map<Long, ny> sl(int i) {
        Cursor cursorRawQuery;
        x();
        if (xr != null) {
            try {
                cursorRawQuery = xr.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "segments", bz.d), new String[]{Integer.toString(i)});
                try {
                    if (cursorRawQuery.moveToNext()) {
                        int columnIndex = cursorRawQuery.getColumnIndex("info");
                        String string = columnIndex >= 0 ? cursorRawQuery.getString(columnIndex) : null;
                        HashMap map = new HashMap();
                        JSONArray jSONArray = new JSONArray(string);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            ny nyVar = new ny(jSONArray.getJSONObject(i2));
                            map.put(Long.valueOf(nyVar.ah()), nyVar);
                        }
                        com.ss.android.socialbase.downloader.ny.c.ms(cursorRawQuery);
                        return map;
                    }
                    com.ss.android.socialbase.downloader.ny.c.ms(cursorRawQuery);
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.bytedance.sdk.openadsdk.api.ab.ms(th);
                        com.ss.android.socialbase.downloader.ny.c.ms(cursorRawQuery);
                    } catch (Throwable th2) {
                        com.ss.android.socialbase.downloader.ny.c.ms(cursorRawQuery);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                cursorRawQuery = null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public boolean ms(int i, Map<Long, ny> map) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        x();
        if (xr == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<Long> it = map.keySet().iterator();
            while (it.hasNext()) {
                jSONArray.put(map.get(Long.valueOf(it.next().longValue())).hi());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
        com.bytedance.sdk.openadsdk.api.ab.xr("SqlDownloadCache", "json=".concat(String.valueOf(jSONArray)));
        SQLiteStatement sQLiteStatementD = this.ka.d();
        synchronized (sQLiteStatementD) {
            sQLiteStatementD.clearBindings();
            sQLiteStatementD.bindLong(1, i);
            sQLiteStatementD.bindString(2, jSONArray.toString());
            sQLiteStatementD.execute();
        }
        com.ss.android.socialbase.downloader.ah.ms.xr("SqlDownloadCache", "updateSegments cost=" + com.ss.android.socialbase.downloader.ny.c.ah(jCurrentTimeMillis));
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void zb(int i) {
        x();
        if (xr == null) {
            return;
        }
        try {
            ms(i, this.ka.xr());
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    private void update(final int i, final ContentValues contentValues) {
        x();
        if (xr == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.ah.ah(new Runnable() { // from class: com.ss.android.socialbase.downloader.xr.ka.3
            @Override // java.lang.Runnable
            public void run() {
                ka.this.ms(i, contentValues);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, ContentValues contentValues) {
        int i2 = 10;
        while (xr.isDbLockedByCurrentThread() && (i2 = i2 - 1) >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th2);
                return;
            }
        }
        try {
            xr.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
        } catch (Throwable th3) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th3);
        }
    }

    @Override // com.ss.android.socialbase.downloader.xr.ah
    public void ms(xr xrVar) {
        this.f4813ms = xrVar;
    }

    public void ms(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.model.xr>> sparseArray2) {
        try {
            HashMap mapMs = com.ss.android.socialbase.downloader.ny.c.ms(sparseArray);
            HashMap mapMs2 = com.ss.android.socialbase.downloader.ny.c.ms(sparseArray2);
            xr xrVar = this.f4813ms;
            if (xrVar != null) {
                xrVar.ms(mapMs, mapMs2);
            }
        } catch (Throwable unused) {
        }
    }
}
