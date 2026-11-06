package com.smartdigimkt.z2;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends b {
    public static volatile a b;

    public a(d dVar) {
        super(dVar);
    }

    public static long c() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public final synchronized ArrayList a(Cursor cursor) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                try {
                    com.smartdigimkt.t2.p pVar = new com.smartdigimkt.t2.p();
                    int columnIndex = cursor.getColumnIndex("placement_id");
                    if (columnIndex >= 0) {
                        pVar.a = cursor.getString(columnIndex);
                    }
                    int columnIndex2 = cursor.getColumnIndex("dsp_id");
                    if (columnIndex2 >= 0) {
                        pVar.b = cursor.getString(columnIndex2);
                    }
                    int columnIndex3 = cursor.getColumnIndex("offer_id");
                    if (columnIndex3 >= 0) {
                        pVar.c = cursor.getString(columnIndex3);
                    }
                    int columnIndex4 = cursor.getColumnIndex("tk_type");
                    if (columnIndex4 >= 0) {
                        pVar.d = cursor.getInt(columnIndex4);
                    }
                    int columnIndex5 = cursor.getColumnIndex("extra_info");
                    if (columnIndex5 >= 0) {
                        pVar.e = cursor.getString(columnIndex5);
                    }
                    arrayList.add(pVar);
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0048 A[Catch: all -> 0x004c, PHI: r1
      0x0048: PHI (r1v5 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v4 android.database.Cursor), (r1v6 android.database.Cursor) binds: [B:10:0x0034, B:14:0x003b, B:21:0x0046] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #6 {, blocks: (B:6:0x002e, B:22:0x0048, B:18:0x0041, B:19:0x0044, B:13:0x0038), top: B:32:0x0002, inners: #7 }] */
    public final synchronized ArrayList d() {
        Cursor cursorQuery;
        try {
            cursorQuery = a().query("adx_offer_tracking", null, "create_time >= ? ", new String[]{String.valueOf(c())}, null, null, null);
            try {
                ArrayList arrayListA = a(cursorQuery);
                cursorQuery.close();
                arrayListA.size();
                cursorQuery.close();
                return arrayListA;
            } catch (Exception unused) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            } catch (OutOfMemoryError unused2) {
                try {
                    System.gc();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                } catch (Throwable th) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            } catch (Throwable unused3) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            }
        } catch (Exception unused4) {
            cursorQuery = null;
        } catch (OutOfMemoryError unused5) {
            cursorQuery = null;
        } catch (Throwable unused6) {
            cursorQuery = null;
        }
    }
}
