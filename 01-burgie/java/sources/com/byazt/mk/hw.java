package com.byazt.mk;

import android.content.ContentValues;
import android.database.Cursor;
import com.byazt.sd.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1191, 13})
public class hw {
    public static final hw pr = new hw();

    public void insert(pr prVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("dev1", Long.valueOf(prVar.aj()));
        contentValues.put("dev2", Long.valueOf(prVar.vk()));
        contentValues.put("dev3", Long.valueOf(prVar.w()));
        contentValues.put("dev4", Long.valueOf(prVar.k()));
        contentValues.put("dev5", Integer.valueOf(prVar.m()));
        contentValues.put("dev6", Long.valueOf(prVar.zo()));
        contentValues.put("dev7", Long.valueOf(prVar.pr()));
        contentValues.put("dev8", Long.valueOf(prVar.hw()));
        com.byazt.ad.pr.insert(a.getContext(), "sdk_launch", contentValues);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00c3 A[PHI: r1 r3
      0x00c3: PHI (r1v2 java.util.ArrayList) = (r1v3 java.util.ArrayList), (r1v5 java.util.ArrayList) binds: [B:27:0x00c1, B:21:0x00b7] A[DONT_GENERATE, DONT_INLINE]
      0x00c3: PHI (r3v3 android.database.Cursor) = (r3v4 android.database.Cursor), (r3v5 android.database.Cursor) binds: [B:27:0x00c1, B:21:0x00b7] A[DONT_GENERATE, DONT_INLINE]] */
    public List<pr> pr(long j) {
        ArrayList arrayList;
        long j2 = j - 518400000;
        ArrayList arrayList2 = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = com.byazt.ad.pr.query(a.getContext(), "sdk_launch", null, "dev1 > ?", new String[]{String.valueOf(j2)}, null, null, "dev1 DESC");
                if (cursorQuery == null) {
                    arrayList = arrayList2;
                } else {
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
                            pr prVar = new pr();
                            prVar.x(j3);
                            prVar.c(j4);
                            prVar.uc(j5);
                            prVar.fw(j6);
                            prVar.hw((int) j7);
                            prVar.hn(j8);
                            prVar.pr(j9);
                            prVar.hw(j10);
                            arrayList = arrayList3;
                            try {
                                arrayList.add(prVar);
                                arrayList2 = arrayList;
                            } catch (Exception e) {
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                return arrayList;
                            }
                        } catch (Exception e2) {
                            arrayList = arrayList3;
                        }
                    }
                    arrayList = arrayList2;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public void pr() {
        com.byazt.ad.pr.delete(a.getContext(), "sdk_launch", "dev1 < ?", new String[]{String.valueOf(hn.fw().w() - 2592000000L)});
    }
}
