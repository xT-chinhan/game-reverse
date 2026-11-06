package com.anythink.core.common.f;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.ag;
import com.anythink.core.common.h.bi;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i extends b<com.anythink.core.common.a.e> {
    private static volatile i b = null;
    private static final int c = 500;
    private final String a;

    public static class a {
        public static final String a = "offer_data_cache";
        public static final String b = "placement_id";
        public static final String c = "bid_id";
        public static final String d = "adsource_id";
        public static final String e = "network_firm_id";
        public static final String f = "bid_result";
        public static final String g = "offer_data";
        public static final String h = "out_date_timestamp";
        public static final String i = "vast_parse_result";
        public static final String j = "CREATE TABLE IF NOT EXISTS offer_data_cache(placement_id TEXT ,bid_id TEXT ,adsource_id TEXT ,network_firm_id INTEGER ,bid_result TEXT ,offer_data TEXT ,out_date_timestamp INTEGER ,vast_parse_result TEXT)";
    }

    private i(c cVar) {
        super(cVar);
        this.a = i.class.getName();
    }

    public static i a(c cVar) {
        if (b == null) {
            synchronized (i.class) {
                if (b == null) {
                    b = new i(cVar);
                }
            }
        }
        return b;
    }

    public final synchronized void a(String str) {
        try {
            b().delete(a.a, "bid_id = ? ", new String[]{str});
        } catch (Throwable th) {
            com.anythink.core.common.t.f.b("Error_SQL_DELETE", th.getMessage(), s.b().r());
        }
    }

    private synchronized void a(List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        int i = 0;
        while (i < list.size()) {
            try {
                int i2 = i + 500;
                List<String> listSubList = list.subList(i, Math.min(i2, list.size()));
                StringBuilder sb = new StringBuilder();
                sb.append("bid_id IN (");
                for (int i3 = 0; i3 < listSubList.size(); i3++) {
                    if (i3 > 0) {
                        sb.append(",");
                    }
                    sb.append("?");
                }
                sb.append(")");
                b().delete(a.a, sb.toString(), (String[]) listSubList.toArray(new String[0]));
                i = i2;
            } catch (Throwable th) {
                com.anythink.core.common.t.f.b("Error_SQL_DELETE_2", th.getMessage(), s.b().r());
                return;
            }
        }
    }

    public final synchronized long a(String str, ad adVar) {
        if (b() == null || adVar == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("placement_id", str);
            contentValues.put(a.d, adVar.k);
            contentValues.put("network_firm_id", Integer.valueOf(adVar.d));
            contentValues.put(a.c, adVar.token);
            contentValues.put(a.f, adVar.b());
            contentValues.put(a.h, Long.valueOf(adVar.f));
            if (e(adVar.token)) {
                return b().update(a.a, contentValues, "bid_id = ? ", new String[]{adVar.token});
            }
            return b().insert(a.a, null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final synchronized int a(ad adVar) {
        if (e(adVar.token)) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(a.f, adVar.b());
                return b().update(a.a, contentValues, "bid_id = ? ", new String[]{adVar.token});
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public final synchronized ag b(String str) {
        ag agVar;
        Cursor cursorQuery;
        agVar = new ag();
        try {
            cursorQuery = a().query(a.a, new String[]{"placement_id", a.d, a.f, a.c, a.h}, "placement_id=?", new String[]{str}, null, null, null);
            try {
                ArrayList arrayList = new ArrayList();
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex(a.c));
                    if (System.currentTimeMillis() >= cursorQuery.getLong(cursorQuery.getColumnIndex(a.h))) {
                        arrayList.add(string);
                    } else {
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(a.d));
                        ad adVarA = ad.a(cursorQuery.getString(cursorQuery.getColumnIndex(a.f)));
                        if (adVarA != null) {
                            agVar.a(string2, adVarA);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    a(arrayList);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Throwable unused3) {
            }
        }
        return agVar;
    }

    public final synchronized long a(String str, String str2) {
        if (b() == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(a.g, str2);
            if (!e(str)) {
                return -1L;
            }
            return b().update(a.a, contentValues, "bid_id = ? ", new String[]{str});
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final synchronized long b(String str, String str2) {
        if (b() == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(a.i, str2);
            if (!e(str)) {
                return -1L;
            }
            return b().update(a.a, contentValues, "bid_id = ? ", new String[]{str});
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0047 A[Catch: all -> 0x004b, PHI: r12
      0x0047: PHI (r12v4 android.database.Cursor) = (r12v3 android.database.Cursor), (r12v5 android.database.Cursor) binds: [B:16:0x0045, B:13:0x0041] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x004b, blocks: (B:10:0x003c, B:17:0x0047), top: B:29:0x0002 }] */
    public final synchronized bi c(String str) {
        Cursor cursorQuery;
        try {
            try {
                cursorQuery = a().query(a.a, new String[]{a.g, a.h}, "bid_id=?", new String[]{str}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.moveToNext();
                            bi biVar = new bi(cursorQuery.getString(0), cursorQuery.getLong(1));
                            cursorQuery.close();
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return biVar;
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
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003c A[Catch: all -> 0x0040, PHI: r11
      0x003c: PHI (r11v4 android.database.Cursor) = (r11v3 android.database.Cursor), (r11v5 android.database.Cursor) binds: [B:16:0x003a, B:13:0x0036] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0040, blocks: (B:10:0x0031, B:17:0x003c), top: B:25:0x0002 }] */
    public final synchronized String d(String str) {
        Cursor cursorQuery;
        try {
            try {
                cursorQuery = a().query(a.a, new String[]{a.i}, "bid_id=?", new String[]{str}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.moveToNext();
                            String string = cursorQuery.getString(0);
                            cursorQuery.close();
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return string;
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
            } catch (Throwable th) {
                throw th;
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0034 A[Catch: all -> 0x0038, PHI: r11
      0x0034: PHI (r11v4 android.database.Cursor) = (r11v3 android.database.Cursor), (r11v5 android.database.Cursor) binds: [B:16:0x0032, B:13:0x002e] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0038, blocks: (B:10:0x0029, B:17:0x0034), top: B:29:0x0002 }] */
    private synchronized boolean e(String str) {
        Cursor cursorQuery;
        try {
            try {
                cursorQuery = a().query(a.a, new String[]{"placement_id"}, "bid_id=?", new String[]{str}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.close();
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
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
