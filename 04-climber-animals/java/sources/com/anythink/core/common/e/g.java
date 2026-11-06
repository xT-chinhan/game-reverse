package com.anythink.core.common.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.anythink.core.common.h.ag;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g extends c<ag> {
    private static final String a = "g";
    private static volatile g b;

    public static class a {
        public static final String A = "ad_source_id";
        public static final String B = "network_firm_id";
        public static final String C = "progress";
        public static final String D = "file_size";
        public static final String E = "apk_redownload";
        public static final String F = "apk_allow_install_in_bg";
        public static final String G = "offer_cache_time";
        public static final String H = "app_name";
        public static final String I = "downloading_scene";
        public static final String J = "recover_download_scene";
        public static final String K = "download_failed_scene_list";
        public static final String L = "dsp_id";
        public static final String M = "action_offer_download_tk";
        public static final String N = "app_desc";
        public static final String O = "CREATE TABLE IF NOT EXISTS download_task(unique_id TEXT ,click_id TEXT ,request_id TEXT ,offer_id TEXT ,pkg_name TEXT ,url TEXT ,title TEXT ,deeplink_click_action TEXT ,icon_url TEXT ,deeplink_url TEXT ,file_path TEXT ,placement_id TEXT ,ad_source_id TEXT ,network_firm_id TEXT ,app_name TEXT ,download_failed_scene_list TEXT ,dsp_id TEXT ,action_offer_download_tk TEXT ,app_desc TEXT ,apk_verify INTEGER ,enable_use_webview_ua INTEGER ,download_type INTEGER ,notification_type INTEGER ,int_open_switch INTEGER ,int_open_time INTEGER ,offer_source_type INTEGER ,part_count INTEGER ,enable_part_download INTEGER ,download_start_timestamp INTEGER ,download_end_timestamp INTEGER ,status INTEGER ,is_upload_installed_agentevent INTEGER ,progress INTEGER ,file_size INTEGER ,apk_redownload INTEGER ,apk_allow_install_in_bg INTEGER ,offer_cache_time INTEGER ,downloading_scene INTEGER ,recover_download_scene INTEGER)";
        public static final String a = "download_task";
        public static final String b = "unique_id";
        public static final String c = "click_id";
        public static final String d = "request_id";
        public static final String e = "offer_id";
        public static final String f = "url";
        public static final String g = "pkg_name";
        public static final String h = "title";
        public static final String i = "deeplink_click_action";
        public static final String j = "apk_verify";
        public static final String k = "enable_use_webview_ua";
        public static final String l = "download_type";
        public static final String m = "notification_type";
        public static final String n = "int_open_switch";
        public static final String o = "int_open_time";
        public static final String p = "icon_url";
        public static final String q = "deeplink_url";
        public static final String r = "offer_source_type";
        public static final String s = "file_path";
        public static final String t = "part_count";
        public static final String u = "enable_part_download";
        public static final String v = "download_start_timestamp";
        public static final String w = "download_end_timestamp";
        public static final String x = "status";
        public static final String y = "is_upload_installed_agentevent";
        public static final String z = "placement_id";
    }

    private g(d dVar) {
        super(dVar);
    }

    public static g a(Context context) {
        if (b == null) {
            synchronized (g.class) {
                if (b == null) {
                    b = new g(e.a(context));
                }
            }
        }
        return b;
    }

    public final synchronized void a(ag agVar) {
        try {
            SQLiteDatabase sQLiteDatabaseD = d();
            if (c(agVar)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("progress", Long.valueOf(agVar.F()));
                sQLiteDatabaseD.update(a.a, contentValues, "unique_id = ?", new String[]{agVar.j()});
            }
        } catch (Throwable th) {
            Object[] objArr = new Object[1];
            th.getMessage();
        }
    }

    public final synchronized void b(ag agVar) {
        if (agVar != null) {
            try {
                if (!TextUtils.isEmpty(agVar.j())) {
                    Object[] objArr = new Object[1];
                    SQLiteDatabase sQLiteDatabaseD = d();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("unique_id", agVar.j());
                    contentValues.put("click_id", agVar.k());
                    contentValues.put("request_id", agVar.l());
                    contentValues.put("offer_id", agVar.m());
                    contentValues.put(a.g, agVar.o());
                    contentValues.put("url", agVar.n());
                    contentValues.put("title", agVar.p());
                    contentValues.put(a.i, agVar.q());
                    contentValues.put("icon_url", agVar.v());
                    contentValues.put("deeplink_url", agVar.w());
                    contentValues.put("file_path", agVar.g());
                    contentValues.put(a.j, Integer.valueOf(agVar.C()));
                    contentValues.put(a.k, Integer.valueOf(agVar.y()));
                    contentValues.put(a.l, Integer.valueOf(agVar.r()));
                    contentValues.put(a.m, Integer.valueOf(agVar.s()));
                    contentValues.put(a.n, Integer.valueOf(agVar.t()));
                    contentValues.put(a.o, Integer.valueOf(agVar.u()));
                    contentValues.put(a.r, Integer.valueOf(agVar.z()));
                    contentValues.put(a.t, Integer.valueOf(agVar.h()));
                    contentValues.put(a.u, Integer.valueOf(agVar.i() ? 1 : 0));
                    contentValues.put(a.v, Long.valueOf(agVar.A()));
                    contentValues.put(a.w, Long.valueOf(agVar.B()));
                    contentValues.put("status", Integer.valueOf(agVar.D()));
                    contentValues.put(a.y, Integer.valueOf(agVar.E()));
                    contentValues.put("placement_id", agVar.d());
                    contentValues.put("ad_source_id", agVar.e());
                    contentValues.put("network_firm_id", agVar.f());
                    contentValues.put("progress", Long.valueOf(agVar.F()));
                    contentValues.put(a.D, Long.valueOf(agVar.G()));
                    contentValues.put(a.E, Integer.valueOf(agVar.H()));
                    contentValues.put(a.F, Integer.valueOf(agVar.I()));
                    contentValues.put(a.G, Long.valueOf(agVar.J()));
                    contentValues.put("app_name", agVar.K());
                    contentValues.put(a.I, Integer.valueOf(agVar.a()));
                    contentValues.put(a.J, Integer.valueOf(agVar.b()));
                    contentValues.put(a.K, agVar.c());
                    contentValues.put("dsp_id", agVar.c());
                    contentValues.put(a.M, agVar.M());
                    contentValues.put(a.N, agVar.N());
                    if (c(agVar)) {
                        sQLiteDatabaseD.update(a.a, contentValues, "unique_id = ?", new String[]{agVar.j()});
                    } else {
                        Object[] objArr2 = new Object[1];
                        Long.valueOf(sQLiteDatabaseD.insertOrThrow(a.a, null, contentValues));
                    }
                }
            } catch (Throwable th) {
                Object[] objArr3 = new Object[1];
                th.getMessage();
            }
        }
    }

    private boolean c(ag agVar) {
        Cursor cursorQuery = c().query(a.a, new String[]{"unique_id"}, "unique_id = ?", new String[]{agVar.j()}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }

    public final synchronized ag a(String str) {
        Cursor cursorQuery;
        try {
            ag agVar = new ag();
            String str2 = "download_start_timestamp > " + System.currentTimeMillis() + " - offer_cache_time AND unique_id = '" + str + "'";
            Object[] objArr = new Object[1];
            cursorQuery = c().query(a.a, null, str2, null, null, null, a.v);
            try {
                if (cursorQuery.moveToFirst()) {
                    agVar = a(cursorQuery);
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return agVar;
            } catch (Throwable th) {
                th = th;
                try {
                    Object[] objArr2 = new Object[1];
                    th.getMessage();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    public final synchronized List<ag> a() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            cursorQuery = c().query(a.a, null, "download_start_timestamp <= " + System.currentTimeMillis() + " - offer_cache_time", null, null, null, a.v);
            while (cursorQuery.moveToNext()) {
                arrayList.add(a(cursorQuery));
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th) {
            try {
                Object[] objArr = new Object[1];
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
        return arrayList;
    }

    public final synchronized List<ag> b() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            cursorQuery = c().query(a.a, null, "status = 5 AND is_upload_installed_agentevent != 1 AND download_end_timestamp >= " + (System.currentTimeMillis() - 604800000), null, null, null, a.v);
            while (cursorQuery.moveToNext()) {
                arrayList.add(a(cursorQuery));
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th) {
            try {
                Object[] objArr = new Object[1];
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
        return arrayList;
    }

    public final synchronized List<ag> a(List<Integer> list, int i) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("status IN (");
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(list.get(i2));
                if (i2 != list.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
            sb.append(" AND ");
            sb.append(a.v);
            sb.append(" > ");
            sb.append(System.currentTimeMillis());
            sb.append(" - ");
            sb.append(a.G);
            if (i > 0) {
                sb.append(" AND ");
                sb.append(a.E);
                sb.append(" = ");
                sb.append(i);
            }
            Object[] objArr = new Object[1];
            cursorQuery = c().query(a.a, null, sb.toString(), null, null, null, a.v);
            while (cursorQuery.moveToNext()) {
                arrayList.add(a(cursorQuery));
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th) {
            try {
                Object[] objArr2 = new Object[1];
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
        return arrayList;
    }

    private synchronized ag b(List<Integer> list, int i) {
        Cursor cursor;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("status IN (");
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(list.get(i2));
                if (i2 != list.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
            sb.append(" AND ");
            sb.append(a.v);
            sb.append(" > ");
            sb.append(System.currentTimeMillis());
            sb.append(" - ");
            sb.append(a.G);
            Object[] objArr = new Object[1];
            Cursor cursorQuery = c().query(a.a, null, sb.toString(), null, null, null, a.v, String.valueOf(i));
            try {
                if (cursorQuery.moveToFirst()) {
                    ag agVarA = a(cursorQuery);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return agVarA;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                cursor = cursorQuery;
                th = th;
                try {
                    Object[] objArr2 = new Object[1];
                    th.getMessage();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th2) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        return null;
    }

    public final synchronized void e() {
        try {
            Object[] objArr = new Object[1];
            Integer.valueOf(d().delete(a.a, "download_start_timestamp <= " + System.currentTimeMillis() + " - offer_cache_time", null));
        } catch (Throwable th) {
            Object[] objArr2 = new Object[1];
            th.getMessage();
        }
    }

    public final synchronized void b(String str) {
        try {
            Object[] objArr = new Object[2];
            Integer.valueOf(d().delete(a.a, "unique_id = ?", new String[]{str}));
        } catch (Throwable th) {
            Object[] objArr2 = new Object[1];
            th.getMessage();
        }
    }

    private static ag a(Cursor cursor) {
        ag agVar = new ag();
        try {
            agVar.f(cursor.getString(a(cursor, "unique_id")));
            agVar.g(cursor.getString(a(cursor, "click_id")));
            agVar.h(cursor.getString(a(cursor, "request_id")));
            agVar.i(cursor.getString(a(cursor, "offer_id")));
            agVar.j(cursor.getString(a(cursor, "url")));
            agVar.k(cursor.getString(a(cursor, a.g)));
            agVar.l(cursor.getString(a(cursor, "title")));
            agVar.m(cursor.getString(a(cursor, a.i)));
            agVar.n(cursor.getString(a(cursor, "icon_url")));
            agVar.o(cursor.getString(a(cursor, "deeplink_url")));
            agVar.e(cursor.getString(a(cursor, "file_path")));
            agVar.b(cursor.getString(a(cursor, "placement_id")));
            agVar.c(cursor.getString(a(cursor, "ad_source_id")));
            agVar.d(cursor.getString(a(cursor, "network_firm_id")));
            agVar.p(cursor.getString(a(cursor, "app_name")));
            agVar.a(cursor.getString(a(cursor, a.K)));
            agVar.q(cursor.getString(a(cursor, "dsp_id")));
            agVar.r(cursor.getString(a(cursor, a.M)));
            agVar.s(cursor.getString(a(cursor, a.N)));
            agVar.j(cursor.getInt(a(cursor, a.j)));
            agVar.h(cursor.getInt(a(cursor, a.k)));
            agVar.d(cursor.getInt(a(cursor, a.l)));
            agVar.e(cursor.getInt(a(cursor, a.m)));
            agVar.f(cursor.getInt(a(cursor, a.n)));
            agVar.g(cursor.getInt(a(cursor, a.o)));
            agVar.i(cursor.getInt(a(cursor, a.r)));
            agVar.c(cursor.getInt(a(cursor, a.t)));
            agVar.a(cursor.getInt(a(cursor, a.u)) == 1);
            agVar.a(cursor.getLong(a(cursor, a.v)));
            agVar.b(cursor.getLong(a(cursor, a.w)));
            agVar.k(cursor.getInt(a(cursor, "status")));
            agVar.l(cursor.getInt(a(cursor, a.y)));
            agVar.c(cursor.getLong(a(cursor, "progress")));
            agVar.d(cursor.getLong(a(cursor, a.D)));
            agVar.m(cursor.getInt(a(cursor, a.E)));
            agVar.n(cursor.getInt(a(cursor, a.F)));
            agVar.e(cursor.getLong(a(cursor, a.G)));
            agVar.a(cursor.getInt(a(cursor, a.I)));
            agVar.b(cursor.getInt(a(cursor, a.J)));
        } catch (Throwable th) {
            Object[] objArr = new Object[1];
            th.getMessage();
        }
        return agVar;
    }

    private static int a(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        throw new IllegalArgumentException("columnIndex must >= 0.");
    }
}
