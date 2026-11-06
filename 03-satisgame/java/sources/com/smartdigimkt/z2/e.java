package com.smartdigimkt.z2;

import android.database.Cursor;
import com.anythink.core.common.d.t;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends b {
    public static volatile e b;

    public e(d dVar) {
        super(dVar);
    }

    public static e a(d dVar) {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e(dVar);
                }
            }
        }
        return b;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003d A[Catch: all -> 0x0041, PHI: r10
      0x003d: PHI (r10v7 android.database.Cursor) = (r10v5 android.database.Cursor), (r10v6 android.database.Cursor), (r10v8 android.database.Cursor) binds: [B:11:0x0029, B:15:0x0030, B:22:0x003b] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x0023, B:23:0x003d, B:19:0x0036, B:20:0x0039, B:14:0x002d), top: B:33:0x0002, inners: #1 }] */
    public final synchronized ArrayList b(String str) {
        Cursor cursorQuery;
        try {
            cursorQuery = a().query("sdkconfig", null, "key = ? and type = ?", new String[]{str, t.a.k}, null, null, null);
            try {
                ArrayList arrayListA = a(cursorQuery);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
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

    public final synchronized boolean a(String str) {
        Cursor cursorQuery = a().query("sdkconfig", new String[]{com.anythink.core.common.f.e.a.b}, "key=? AND type=?", new String[]{str, t.a.k}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }

    public final synchronized ArrayList a(Cursor cursor) {
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    com.smartdigimkt.a3.c cVar = new com.smartdigimkt.a3.c();
                    cursor.getString(cursor.getColumnIndex(com.anythink.core.common.f.e.a.b));
                    cursor.getString(cursor.getColumnIndex("type"));
                    cVar.a = cursor.getString(cursor.getColumnIndex(com.anythink.core.common.f.e.a.d));
                    cVar.b = cursor.getString(cursor.getColumnIndex(com.anythink.core.common.f.e.a.e));
                    arrayList.add(cVar);
                }
                cursor.close();
                return arrayList;
            }
        }
        return null;
    }
}
