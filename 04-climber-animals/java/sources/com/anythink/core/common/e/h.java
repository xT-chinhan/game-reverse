package com.anythink.core.common.e;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h extends c<com.anythink.core.common.a.k> {
    private static volatile h b;
    private final String a;

    public static class a {
        public static final String a = "dsp_offer_install_record";
        public static final String b = "dsp_id";
        public static final String c = "dsp_offer_id";
        public static final String d = "package_name";
        public static final String e = "last_update_time";
        public static final String f = "CREATE TABLE IF NOT EXISTS dsp_offer_install_record(dsp_id TEXT ,dsp_offer_id TEXT ,package_name TEXT ,last_update_time INTEGER)";
    }

    private h(d dVar) {
        super(dVar);
        this.a = h.class.getName();
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

    public final synchronized long a(com.anythink.core.common.a.k kVar) {
        if (d() == null) {
            return -1L;
        }
        if (!a(kVar.a(), kVar.b())) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("dsp_id", kVar.a());
                contentValues.put("dsp_offer_id", kVar.b());
                contentValues.put("package_name", kVar.c());
                contentValues.put("last_update_time", Long.valueOf(System.currentTimeMillis()));
                kVar.a();
                kVar.b();
                kVar.c();
                return d().insert(a.a, null, contentValues);
            } catch (Exception unused) {
            }
        } else {
            kVar.a();
            kVar.b();
            kVar.c();
        }
        return -1L;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0032 A[Catch: all -> 0x0046, PHI: r1
      0x0032: PHI (r1v5 android.database.Cursor) = 
      (r1v2 android.database.Cursor)
      (r1v3 android.database.Cursor)
      (r1v4 android.database.Cursor)
      (r1v6 android.database.Cursor)
     binds: [B:15:0x0030, B:19:0x0039, B:25:0x0043, B:13:0x002d] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:10:0x0028, B:16:0x0032, B:23:0x003f, B:24:0x0042, B:18:0x0036), top: B:32:0x0003, inners: #3 }] */
    private synchronized boolean a(String str, String str2) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = c().query(a.a, null, "dsp_id = ?  AND dsp_offer_id = ? ", new String[]{str, str2}, null, null, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    cursorQuery.close();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
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

    public final synchronized List<com.anythink.core.common.a.j> a(int i) {
        ArrayList arrayList = new ArrayList();
        if (i <= 0) {
            return arrayList;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = c().query(a.a, null, null, null, null, null, "last_update_time DESC", String.valueOf(i));
                List<com.anythink.core.common.a.k> listA = a(cursorQuery);
                cursorQuery.close();
                listA.size();
                arrayList.addAll(listA);
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
            }
        } catch (OutOfMemoryError unused2) {
            System.gc();
            if (cursorQuery != null) {
            }
        } catch (Throwable unused3) {
            if (cursorQuery != null) {
            }
        }
        return arrayList;
    }

    private synchronized List<com.anythink.core.common.a.k> a(Cursor cursor) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                try {
                    com.anythink.core.common.a.k kVar = new com.anythink.core.common.a.k();
                    kVar.a(cursor.getString(cursor.getColumnIndex("dsp_id")));
                    kVar.b(cursor.getString(cursor.getColumnIndex("dsp_offer_id")));
                    kVar.c(cursor.getString(cursor.getColumnIndex("package_name")));
                    arrayList.add(kVar);
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }
}
