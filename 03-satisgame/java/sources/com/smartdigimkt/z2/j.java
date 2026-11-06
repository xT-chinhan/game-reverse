package com.smartdigimkt.z2;

import android.database.Cursor;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends b {
    public static j b;

    public j(d dVar) {
        super(dVar);
    }

    public static j a(d dVar) {
        if (b == null) {
            synchronized (j.class) {
                if (b == null) {
                    b = new j(dVar);
                }
            }
        }
        return b;
    }

    public final synchronized void c() {
        try {
            if (b() == null) {
            } else {
                b().delete("request_info", null, null);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00ad A[Catch: all -> 0x00b1, PHI: r1
      0x00ad: PHI (r1v5 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v4 android.database.Cursor), (r1v6 android.database.Cursor) binds: [B:21:0x0099, B:25:0x00a0, B:32:0x00ab] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {, blocks: (B:13:0x008c, B:17:0x0093, B:33:0x00ad, B:29:0x00a6, B:30:0x00a9, B:24:0x009d), top: B:43:0x0002, inners: #1 }] */
    public final synchronized ArrayList d() {
        Cursor cursorQuery;
        try {
            cursorQuery = a().query("request_info", null, null, null, null, null, "time", String.valueOf(10));
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        ArrayList arrayList = new ArrayList();
                        while (cursorQuery.moveToNext()) {
                            com.smartdigimkt.f3.d dVar = new com.smartdigimkt.f3.d();
                            dVar.a = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                            dVar.b = cursorQuery.getInt(cursorQuery.getColumnIndex(com.anythink.core.common.f.h.b.c));
                            dVar.d = cursorQuery.getString(cursorQuery.getColumnIndex(com.anythink.core.common.f.h.b.d));
                            dVar.c = cursorQuery.getString(cursorQuery.getColumnIndex(com.anythink.core.common.f.h.b.e));
                            dVar.e = cursorQuery.getString(cursorQuery.getColumnIndex("req_content"));
                            dVar.f = cursorQuery.getLong(cursorQuery.getColumnIndex("time"));
                            dVar.g = cursorQuery.getString(cursorQuery.getColumnIndex("extra"));
                            arrayList.add(dVar);
                        }
                        cursorQuery.close();
                        cursorQuery.close();
                        return arrayList;
                    }
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
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Exception unused4) {
            cursorQuery = null;
        } catch (OutOfMemoryError unused5) {
            cursorQuery = null;
        } catch (Throwable unused6) {
            cursorQuery = null;
        }
    }

    public final synchronized void a(com.smartdigimkt.f3.d dVar) {
        if (b() == null || dVar == null) {
            return;
        }
        try {
            b().delete("request_info", "id=?", new String[]{dVar.a});
        } catch (Throwable unused) {
        }
    }
}
