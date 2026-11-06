package com.smartdigimkt.z2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends b {
    public static volatile k b;

    public k(d dVar) {
        super(dVar);
    }

    public static k a(d dVar) {
        if (b == null) {
            synchronized (k.class) {
                if (b == null) {
                    b = new k(dVar);
                }
            }
        }
        return b;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0048 A[Catch: all -> 0x007a, PHI: r0 r1
      0x0048: PHI (r0v6 android.database.Cursor) = 
      (r0v2 android.database.Cursor)
      (r0v3 android.database.Cursor)
      (r0v4 android.database.Cursor)
      (r0v12 android.database.Cursor)
     binds: [B:11:0x0036, B:14:0x003c, B:20:0x0046, B:9:0x0033] A[DONT_GENERATE, DONT_INLINE]
      0x0048: PHI (r1v5 long) = (r1v2 long), (r1v3 long), (r1v4 long), (r1v10 long) binds: [B:11:0x0036, B:14:0x003c, B:20:0x0046, B:9:0x0033] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {, blocks: (B:22:0x004b, B:21:0x0048, B:18:0x0042, B:19:0x0045, B:13:0x0039), top: B:39:0x0004, inners: #5 }] */
    public final synchronized void c() {
        Cursor cursorQuery = null;
        long j = -1;
        try {
            try {
                cursorQuery = a().query("inspect_info", null, null, null, null, null, "update_time DESC", String.valueOf(500));
                if (cursorQuery != null && cursorQuery.getCount() >= 500) {
                    cursorQuery.moveToLast();
                    j = cursorQuery.getLong(cursorQuery.getColumnIndex(com.anythink.core.common.f.k.a.g));
                    cursorQuery.close();
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
        long jCurrentTimeMillis = System.currentTimeMillis() - ((long) (-1627869184));
        if (j == 0 || j > jCurrentTimeMillis) {
            j = jCurrentTimeMillis;
        }
        if (j > 0) {
            try {
                b().delete("inspect_info", "update_time<?", new String[]{String.valueOf(j)});
            } catch (Throwable unused4) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0086 A[Catch: all -> 0x008a, PHI: r1
      0x0086: PHI (r1v6 android.database.Cursor) = 
      (r1v3 android.database.Cursor)
      (r1v4 android.database.Cursor)
      (r1v5 android.database.Cursor)
      (r1v8 android.database.Cursor)
     binds: [B:23:0x0072, B:27:0x0079, B:34:0x0084, B:20:0x006e] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #5 {, blocks: (B:17:0x0069, B:35:0x0086, B:31:0x007f, B:32:0x0082, B:26:0x0076), top: B:48:0x0002, inners: #6 }] */
    public final synchronized ArrayList d() {
        Cursor cursorQuery;
        try {
            cursorQuery = a().query("inspect_info", null, null, null, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        ArrayList arrayList = new ArrayList();
                        while (cursorQuery.moveToNext()) {
                            try {
                                com.smartdigimkt.a3.b bVar = new com.smartdigimkt.a3.b();
                                String string = cursorQuery.getString(cursorQuery.getColumnIndex("inspect_id"));
                                if (!TextUtils.isEmpty(string)) {
                                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("inspect_result"));
                                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("inspect_name"));
                                    long j = cursorQuery.getLong(cursorQuery.getColumnIndex(com.anythink.core.common.f.k.a.g));
                                    bVar.a = string;
                                    bVar.c = i;
                                    bVar.b = string2;
                                    bVar.d = j;
                                    arrayList.add(bVar);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                        cursorQuery.close();
                        cursorQuery.close();
                        return arrayList;
                    }
                } catch (Exception unused2) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (OutOfMemoryError unused3) {
                    try {
                        System.gc();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    } catch (Throwable th) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                } catch (Throwable unused4) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception unused5) {
            cursorQuery = null;
        } catch (OutOfMemoryError unused6) {
            cursorQuery = null;
        } catch (Throwable unused7) {
            cursorQuery = null;
        }
        return null;
    }

    public final synchronized void a(List list) {
        if (list != null) {
            if (!list.isEmpty()) {
                SQLiteDatabase sQLiteDatabaseB = b();
                if (sQLiteDatabaseB == null) {
                    return;
                }
                try {
                    sQLiteDatabaseB.beginTransaction();
                    for (int i = 0; i < list.size(); i++) {
                        com.smartdigimkt.a3.b bVar = (com.smartdigimkt.a3.b) list.get(i);
                        if (bVar != null && !TextUtils.isEmpty(bVar.a)) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("inspect_id", bVar.a);
                            contentValues.put("inspect_name", bVar.b);
                            contentValues.put("inspect_result", Integer.valueOf(bVar.c));
                            contentValues.put(com.anythink.core.common.f.k.a.g, Long.valueOf(bVar.d));
                            int iUpdate = sQLiteDatabaseB.update("inspect_info", contentValues, "inspect_id = ? ", new String[]{bVar.a});
                            if (iUpdate <= 0 && iUpdate == 0) {
                                sQLiteDatabaseB.insert("inspect_info", null, contentValues);
                            }
                        }
                    }
                    sQLiteDatabaseB.setTransactionSuccessful();
                    if (sQLiteDatabaseB.inTransaction()) {
                        sQLiteDatabaseB.endTransaction();
                    }
                } catch (Throwable unused) {
                    if (sQLiteDatabaseB.inTransaction()) {
                        sQLiteDatabaseB.endTransaction();
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0036 A[Catch: all -> 0x003a, PHI: r11
      0x0036: PHI (r11v4 android.database.Cursor) = (r11v3 android.database.Cursor), (r11v5 android.database.Cursor) binds: [B:18:0x0034, B:15:0x0030] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x003a, blocks: (B:12:0x002b, B:19:0x0036), top: B:31:0x0002 }] */
    public final synchronized boolean a(String str) {
        Cursor cursorQuery;
        try {
            if (str == null) {
                return false;
            }
            try {
                cursorQuery = a().query("inspect_info", new String[]{"inspect_id"}, "inspect_id=?", new String[]{str}, null, null, null);
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
        } catch (Throwable th) {
            throw th;
        }
    }
}
