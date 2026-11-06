package com.byazt.wb;

import android.content.ContentValues;
import android.database.Cursor;
import com.byazt.nf.rv;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1324, 26})
public class qg {
    public static final qg n = new qg();

    public void insert(n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("dev1", Long.valueOf(nVar.rv()));
        contentValues.put("dev2", Long.valueOf(nVar.tj()));
        contentValues.put("dev3", Long.valueOf(nVar.cp()));
        contentValues.put("dev4", Long.valueOf(nVar.d()));
        contentValues.put("dev5", Integer.valueOf(nVar.oa()));
        contentValues.put("dev6", Long.valueOf(nVar.fs()));
        contentValues.put("dev7", Long.valueOf(nVar.n()));
        contentValues.put("dev8", Long.valueOf(nVar.qg()));
        com.byazt.xp.n.insert(rv.getContext(), "sdk_launch", contentValues);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00bc A[PHI: r0 r3
      0x00bc: PHI (r0v5 java.util.ArrayList) = (r0v6 java.util.ArrayList), (r0v8 java.util.ArrayList) binds: [B:22:0x00ba, B:16:0x00b0] A[DONT_GENERATE, DONT_INLINE]
      0x00bc: PHI (r3v3 android.database.Cursor) = (r3v4 android.database.Cursor), (r3v5 android.database.Cursor) binds: [B:22:0x00ba, B:16:0x00b0] A[DONT_GENERATE, DONT_INLINE]] */
    public List<n> n(long j) {
        ArrayList arrayList;
        long j2 = j - 518400000;
        ArrayList arrayList2 = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = com.byazt.xp.n.query(rv.getContext(), "sdk_launch", null, "dev1 > ?", new String[]{String.valueOf(j2)}, null, null, "dev1 DESC");
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        long j3 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev1"));
                        long j4 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev2"));
                        long j5 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev3"));
                        long j6 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev4"));
                        long j7 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev5"));
                        long j8 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev6"));
                        long j9 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev7"));
                        ArrayList arrayList3 = arrayList2;
                        try {
                            long j10 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev8"));
                            n nVar = new n();
                            nVar.q(j3);
                            nVar.l(j4);
                            nVar.w(j5);
                            nVar.x(j6);
                            nVar.qg((int) j7);
                            nVar.s(j8);
                            nVar.n(j9);
                            nVar.qg(j10);
                            arrayList = arrayList3;
                            try {
                                arrayList.add(nVar);
                                arrayList2 = arrayList;
                            } catch (Exception unused) {
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                return arrayList;
                            }
                        } catch (Exception unused2) {
                            arrayList = arrayList3;
                        }
                    }
                }
                arrayList = arrayList2;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Exception unused3) {
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public void n() {
        com.byazt.xp.n.delete(rv.getContext(), "sdk_launch", "dev1 < ?", new String[]{String.valueOf(s.x().cp() - 2592000000L)});
    }
}
