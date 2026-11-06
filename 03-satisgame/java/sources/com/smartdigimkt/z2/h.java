package com.smartdigimkt.z2;

import android.database.Cursor;
import com.smartdigimkt.t2.s;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends b {
    public static volatile h b;

    public h(d dVar) {
        super(dVar);
    }

    public static h a(d dVar) {
        if (b == null) {
            synchronized (h.class) {
                if (b == null) {
                    b = new h(dVar);
                }
            }
        }
        return b;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0040 A[Catch: all -> 0x0044, PHI: r1
      0x0040: PHI (r1v5 android.database.Cursor) = 
      (r1v2 android.database.Cursor)
      (r1v3 android.database.Cursor)
      (r1v4 android.database.Cursor)
      (r1v6 android.database.Cursor)
     binds: [B:14:0x002e, B:17:0x0034, B:23:0x003e, B:12:0x002b] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {, blocks: (B:9:0x0026, B:24:0x0040, B:21:0x003a, B:22:0x003d, B:16:0x0031), top: B:31:0x0003, inners: #2 }] */
    public final synchronized boolean a(String str, String str2) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = a().query("dsp_offer_install_record", null, "dsp_id = ?  AND dsp_offer_id = ? ", new String[]{str, str2}, null, null, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    cursorQuery.close();
                    cursorQuery.close();
                    return true;
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
        } catch (Exception unused) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (OutOfMemoryError unused2) {
            System.gc();
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable unused3) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        return false;
    }

    public final synchronized ArrayList a(Cursor cursor) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                try {
                    s sVar = new s();
                    sVar.a = cursor.getString(cursor.getColumnIndex("dsp_id"));
                    sVar.b = cursor.getString(cursor.getColumnIndex("dsp_offer_id"));
                    cursor.getString(cursor.getColumnIndex("package_name"));
                    arrayList.add(sVar);
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }
}
