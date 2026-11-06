package com.anythink.core.common.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.af;
import com.anythink.core.common.h.bg;

/* JADX INFO: loaded from: classes.dex */
public class o extends c<com.anythink.core.common.a.m> {
    private static volatile o b;
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

    private o(d dVar) {
        super(dVar);
        this.a = o.class.getName();
    }

    public static o a(d dVar) {
        if (b == null) {
            synchronized (o.class) {
                if (b == null) {
                    b = new o(dVar);
                }
            }
        }
        return b;
    }

    public final synchronized void a(String str) {
        try {
            d().delete(a.a, "bid_id = ? ", new String[]{str});
        } catch (Throwable th) {
            com.anythink.core.common.u.e.b("Error_SQL_DELETE", th.getMessage(), t.b().r());
        }
    }

    public final synchronized long a(String str, ad adVar) {
        if (d() == null || adVar == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("placement_id", str);
            contentValues.put("adsource_id", adVar.k);
            contentValues.put("network_firm_id", Integer.valueOf(adVar.d));
            contentValues.put(a.c, adVar.token);
            contentValues.put(a.f, adVar.b());
            contentValues.put(a.h, Long.valueOf(adVar.f));
            if (!TextUtils.isEmpty(adVar.i)) {
                contentValues.put("offer_data", adVar.i);
            }
            if (e(adVar.token)) {
                String str2 = adVar.token;
                return d().update(a.a, contentValues, "bid_id = ? ", new String[]{adVar.token});
            }
            String str3 = adVar.token;
            String str4 = adVar.k;
            return d().insert(a.a, null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final synchronized int a(ad adVar) {
        if (e(adVar.token)) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(a.f, adVar.b());
                return d().update(a.a, contentValues, "bid_id = ? ", new String[]{adVar.token});
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public final synchronized af b(String str) {
        af afVar;
        Cursor cursorQuery;
        afVar = new af();
        try {
            cursorQuery = c().query(a.a, new String[]{"placement_id", "adsource_id", a.f}, "out_date_timestamp>? AND placement_id=?", new String[]{String.valueOf(System.currentTimeMillis()), str}, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("adsource_id"));
                    ad adVarA = ad.a(cursorQuery.getString(cursorQuery.getColumnIndex(a.f)));
                    if (adVarA != null) {
                        afVar.a(string, adVarA);
                    }
                } catch (Throwable unused) {
                }
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
        return afVar;
    }

    public final synchronized long a(String str, String str2, String str3) {
        if (d() == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("offer_data", str3);
            if (!e(str2)) {
                return -1L;
            }
            return d().update(a.a, contentValues, "bid_id = ? ", new String[]{str2});
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final synchronized long a(String str, String str2) {
        if (d() == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(a.i, str2);
            if (e(str)) {
                str2.length();
                return d().update(a.a, contentValues, "bid_id = ? ", new String[]{str});
            }
            str2.length();
            return -1L;
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0047 A[Catch: all -> 0x004b, PHI: r12
      0x0047: PHI (r12v4 android.database.Cursor) = (r12v3 android.database.Cursor), (r12v5 android.database.Cursor) binds: [B:16:0x0045, B:13:0x0041] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x004b, blocks: (B:10:0x003c, B:17:0x0047), top: B:29:0x0002 }] */
    public final synchronized bg c(String str) {
        Cursor cursorQuery;
        try {
            try {
                cursorQuery = c().query(a.a, new String[]{"offer_data", a.h}, "bid_id=?", new String[]{str}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.moveToNext();
                            bg bgVar = new bg(cursorQuery.getString(0), cursorQuery.getLong(1));
                            cursorQuery.close();
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return bgVar;
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

    /* JADX WARN: Code duplicated, block: B:17:0x003f A[Catch: all -> 0x0043, PHI: r11
      0x003f: PHI (r11v4 android.database.Cursor) = (r11v3 android.database.Cursor), (r11v5 android.database.Cursor) binds: [B:16:0x003d, B:13:0x0039] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0043, blocks: (B:10:0x0034, B:17:0x003f), top: B:25:0x0002 }] */
    public final synchronized String d(String str) {
        Cursor cursorQuery;
        try {
            try {
                cursorQuery = c().query(a.a, new String[]{a.i}, "bid_id=?", new String[]{str}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.moveToNext();
                            String string = cursorQuery.getString(0);
                            cursorQuery.close();
                            string.length();
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
                cursorQuery = c().query(a.a, new String[]{"offer_data"}, "bid_id=?", new String[]{str}, null, null, null);
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
