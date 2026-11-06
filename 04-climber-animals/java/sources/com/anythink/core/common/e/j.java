package com.anythink.core.common.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.anythink.core.common.h.al;
import com.anythink.core.common.h.am;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class j extends c<al> {
    private static final String a = "j";
    private static volatile j b;

    public static class a {
        static final String a = "dyn_wf_ad_source_filter";
        static final String b = "placement_id";
        static final String c = "ad_source_id";
        static final String d = "request_id";
        static final String e = "expired_timestamp";
        static final String f = "match_error_code";
        public static final String g = "CREATE TABLE IF NOT EXISTS dyn_wf_ad_source_filter(placement_id TEXT ,ad_source_id TEXT ,request_id TEXT ,match_error_code TEXT ,expired_timestamp INTEGER)";
        public static final String h = "CREATE INDEX IF NOT EXISTS idx_placement_id ON dyn_wf_ad_source_filter(placement_id)";
        public static final String i = "CREATE INDEX IF NOT EXISTS idx_ad_source_id ON dyn_wf_ad_source_filter(ad_source_id)";
        public static final String j = "CREATE INDEX IF NOT EXISTS idx_ad_request_id ON dyn_wf_ad_source_filter(request_id)";
        public static final String k = "CREATE INDEX IF NOT EXISTS idx_expired_timestamp ON dyn_wf_ad_source_filter(expired_timestamp)";
        public static final String l = "CREATE INDEX IF NOT EXISTS idx_match_error_code ON dyn_wf_ad_source_filter(match_error_code)";
    }

    private j(d dVar) {
        super(dVar);
    }

    public static j a(Context context) {
        if (b == null) {
            synchronized (j.class) {
                if (b == null) {
                    b = new j(e.a(context));
                }
            }
        }
        return b;
    }

    public final synchronized void a(al alVar) {
        boolean z;
        if (alVar == null) {
            return;
        }
        try {
            Object[] objArr = new Object[1];
            SQLiteDatabase sQLiteDatabaseD = d();
            ContentValues contentValues = new ContentValues();
            contentValues.put("placement_id", alVar.b());
            contentValues.put("ad_source_id", alVar.a());
            contentValues.put("request_id", alVar.g());
            contentValues.put("match_error_code", alVar.h());
            contentValues.put("expired_timestamp", Long.valueOf(alVar.f()));
            Cursor cursorQuery = c().query("dyn_wf_ad_source_filter", new String[]{"request_id"}, "request_id = ? AND ad_source_id = ?", new String[]{alVar.g(), alVar.a()}, null, null, null);
            if (cursorQuery == null || cursorQuery.getCount() <= 0) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                z = false;
            } else {
                cursorQuery.close();
                z = true;
            }
            if (z) {
                long jUpdate = sQLiteDatabaseD.update("dyn_wf_ad_source_filter", contentValues, "request_id = ? AND ad_source_id = ?", new String[]{alVar.g(), alVar.a()});
                Object[] objArr2 = new Object[1];
                Long.valueOf(jUpdate);
            } else {
                Object[] objArr3 = new Object[1];
                Long.valueOf(sQLiteDatabaseD.insertOrThrow("dyn_wf_ad_source_filter", null, contentValues));
            }
        } catch (Throwable th) {
            Object[] objArr4 = new Object[1];
            th.getMessage();
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0059 A[PHI: r3
      0x0059: PHI (r3v2 android.database.Cursor) = (r3v1 android.database.Cursor), (r3v3 android.database.Cursor) binds: [B:12:0x0057, B:8:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    private Map<String, Integer> c(String str) {
        HashMap map = new HashMap();
        Cursor cursorQuery = null;
        try {
            cursorQuery = c().query("dyn_wf_ad_source_filter", new String[]{"ad_source_id", "count(request_id)"}, "placement_id = ? AND expired_timestamp >= ?", new String[]{str, String.valueOf(System.currentTimeMillis())}, "ad_source_id", null, null);
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(a(cursorQuery, "ad_source_id"));
                int i = cursorQuery.getInt(1);
                Object[] objArr = new Object[2];
                Integer.valueOf(i);
                map.put(string, Integer.valueOf(i));
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th) {
            try {
                Object[] objArr2 = new Object[1];
                th.getMessage();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th2) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th2;
            }
        }
        Object[] objArr3 = new Object[1];
        Integer.valueOf(map.size());
        return map;
    }

    public final synchronized am a(String str) {
        am amVar;
        amVar = new am(str);
        Cursor cursorQuery = null;
        try {
            cursorQuery = c().query("dyn_wf_ad_source_filter", new String[]{"ad_source_id", "match_error_code", "count(request_id)"}, "placement_id = ? AND match_error_code IS NOT NULL AND match_error_code != ? AND expired_timestamp >= ?", new String[]{str, "", String.valueOf(System.currentTimeMillis())}, "ad_source_id,match_error_code", null, "ad_source_id");
            HashMap map = new HashMap();
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(a(cursorQuery, "ad_source_id"));
                String string2 = cursorQuery.getString(a(cursorQuery, "match_error_code"));
                int i = cursorQuery.getInt(2);
                List<am.a> arrayList = map.get(string);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(new am.a(string2, i));
                Object[] objArr = new Object[3];
                Integer.valueOf(i);
                map.put(string, arrayList);
            }
            Object[] objArr2 = new Object[1];
            Integer.valueOf(map.size());
            amVar.a(map);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th) {
            try {
                Object[] objArr3 = new Object[1];
                th.getMessage();
                if (cursorQuery != null) {
                }
            } catch (Throwable th2) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th2;
            }
        }
        amVar.b(c(str));
        return amVar;
    }

    public final synchronized void b(String str) {
        try {
            Object[] objArr = new Object[2];
            Integer.valueOf(d().delete("dyn_wf_ad_source_filter", "placement_id = ? AND expired_timestamp < ?", new String[]{str, String.valueOf(System.currentTimeMillis())}));
        } catch (Throwable th) {
            Object[] objArr2 = new Object[1];
            th.getMessage();
        }
    }

    private static int a(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        throw new IllegalArgumentException("columnIndex must >= 0.");
    }

    private boolean b(al alVar) {
        Cursor cursorQuery = c().query("dyn_wf_ad_source_filter", new String[]{"request_id"}, "request_id = ? AND ad_source_id = ?", new String[]{alVar.g(), alVar.a()}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }
}
