package com.smartdigimkt.z2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends b {
    public static m b;

    public m(d dVar) {
        super(dVar);
    }

    public static m a(d dVar) {
        if (b == null) {
            synchronized (m.class) {
                if (b == null) {
                    b = new m(dVar);
                }
            }
        }
        return b;
    }

    public final synchronized void b(com.smartdigimkt.h0.e eVar) {
        if (b() == null || eVar == null) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", eVar.a);
            contentValues.put(com.anythink.core.common.f.h.b.c, Integer.valueOf(eVar.b));
            contentValues.put(com.anythink.core.common.f.h.b.d, eVar.d);
            contentValues.put(com.anythink.core.common.f.h.b.e, eVar.c);
            contentValues.put(com.anythink.core.common.f.h.b.f, Long.valueOf(eVar.e));
            contentValues.put(com.anythink.core.common.f.h.b.g, Long.valueOf(eVar.f));
            contentValues.put(com.anythink.core.common.f.h.b.h, Integer.valueOf(eVar.g));
            if (a(eVar.a)) {
                b().update(com.anythink.core.common.f.h.b.a, contentValues, "id = ? ", new String[]{eVar.a});
            } else {
                b().insert(com.anythink.core.common.f.h.b.a, null, contentValues);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00ea A[Catch: all -> 0x00ef, PHI: r2
      0x00ea: PHI (r2v6 android.database.Cursor) = 
      (r2v3 android.database.Cursor)
      (r2v4 android.database.Cursor)
      (r2v5 android.database.Cursor)
      (r2v7 android.database.Cursor)
     binds: [B:28:0x00d8, B:31:0x00de, B:37:0x00e8, B:26:0x00d5] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {, blocks: (B:3:0x0001, B:23:0x00d0, B:38:0x00ea, B:35:0x00e4, B:36:0x00e7, B:30:0x00db), top: B:44:0x0001, inners: #0 }] */
    public final synchronized l c() {
        l lVar = new l();
        List listSynchronizedList = Collections.synchronizedList(new ArrayList(8));
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(8);
        lVar.a = listSynchronizedList;
        lVar.b = concurrentHashMap;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = a().query(com.anythink.core.common.f.h.b.a, null, null, null, null, null, com.anythink.core.common.f.h.b.f);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    ArrayList<com.smartdigimkt.h0.e> arrayList = new ArrayList(4);
                    while (cursorQuery.moveToNext()) {
                        com.smartdigimkt.h0.e eVar = new com.smartdigimkt.h0.e();
                        eVar.a = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        eVar.b = cursorQuery.getInt(cursorQuery.getColumnIndex(com.anythink.core.common.f.h.b.c));
                        eVar.d = cursorQuery.getString(cursorQuery.getColumnIndex(com.anythink.core.common.f.h.b.d));
                        eVar.c = cursorQuery.getString(cursorQuery.getColumnIndex(com.anythink.core.common.f.h.b.e));
                        eVar.e = cursorQuery.getLong(cursorQuery.getColumnIndex(com.anythink.core.common.f.h.b.f));
                        eVar.f = cursorQuery.getLong(cursorQuery.getColumnIndex(com.anythink.core.common.f.h.b.g));
                        eVar.g = cursorQuery.getInt(cursorQuery.getColumnIndex(com.anythink.core.common.f.h.b.h));
                        if (System.currentTimeMillis() < eVar.f) {
                            listSynchronizedList.add(eVar);
                            concurrentHashMap.put(eVar.a, eVar);
                        } else {
                            arrayList.add(eVar);
                        }
                    }
                    cursorQuery.close();
                    if (arrayList.size() > 0) {
                        for (com.smartdigimkt.h0.e eVar2 : arrayList) {
                            eVar2.getClass();
                            a(eVar2);
                        }
                    }
                    cursorQuery.close();
                    return lVar;
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
        return lVar;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0038 A[PHI: r11
      0x0038: PHI (r11v3 android.database.Cursor) = (r11v2 android.database.Cursor), (r11v5 android.database.Cursor) binds: [B:19:0x0036, B:13:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    public final boolean a(String str) {
        Cursor cursorQuery;
        SQLiteDatabase sQLiteDatabaseA;
        try {
            synchronized (this) {
                sQLiteDatabaseA = this.a.a();
            }
            cursorQuery = sQLiteDatabaseA.query(com.anythink.core.common.f.h.b.a, new String[]{"id"}, "id=?", new String[]{str}, "id", null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.close();
                        cursorQuery.close();
                        return true;
                    }
                } catch (Throwable unused) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        return false;
    }

    public final synchronized void a(com.smartdigimkt.h0.e eVar) {
        if (b() == null || eVar == null) {
            return;
        }
        try {
            b().delete(com.anythink.core.common.f.h.b.a, "id=?", new String[]{eVar.a});
        } catch (Throwable unused) {
        }
    }
}
