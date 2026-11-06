package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UMStoreManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class i {
    public static final int a = 2049;
    public static final int b = 2050;
    private static final int c = 1000;
    private static Context d = null;
    private static String e = null;
    private static final String f = "umeng+";
    private static final String g = "ek__id";
    private static final String h = "ek_key";
    private List<String> i;
    private List<Integer> j;
    private String k;
    private List<String> l;

    /* JADX INFO: compiled from: UMStoreManager.java */
    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    /* JADX INFO: compiled from: UMStoreManager.java */
    private static class b {
        private static final i a = new i();

        private b() {
        }
    }

    private i() {
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = null;
        this.l = new ArrayList();
    }

    public static i a(Context context) {
        i iVar = b.a;
        if (d == null && context != null) {
            d = context.getApplicationContext();
            iVar.k();
        }
        return iVar;
    }

    private void k() {
        synchronized (this) {
            l();
            this.i.clear();
            this.l.clear();
            this.j.clear();
        }
    }

    private Cursor a(String str, SQLiteDatabase sQLiteDatabase, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (sQLiteDatabase != null) {
            try {
                if (!sQLiteDatabase.isOpen()) {
                    return null;
                }
                return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    public void a() {
        this.i.clear();
    }

    public void b() {
        this.l.clear();
    }

    public boolean c() {
        return this.l.isEmpty();
    }

    public void a(JSONArray jSONArray) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                try {
                    sQLiteDatabaseA = g.a(d).a();
                    try {
                        sQLiteDatabaseA.beginTransaction();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            try {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                ContentValues contentValues = new ContentValues();
                                String strOptString = jSONObject.optString("__i");
                                if (TextUtils.isEmpty(strOptString) || "-1".equals(strOptString)) {
                                    strOptString = u.a().b();
                                    if (TextUtils.isEmpty(strOptString)) {
                                        strOptString = "-1";
                                    }
                                }
                                contentValues.put("__i", strOptString);
                                contentValues.put("__e", jSONObject.optString("id"));
                                contentValues.put("__t", Integer.valueOf(jSONObject.optInt("__t")));
                                contentValues.put("__av", UMUtils.getAppVersionName(d));
                                contentValues.put("__vc", UMUtils.getAppVersionCode(d));
                                jSONObject.remove("__i");
                                jSONObject.remove("__t");
                                contentValues.put("__s", c(jSONObject.toString()));
                                sQLiteDatabaseA.insert(e.b.a, null, contentValues);
                            } catch (Exception e2) {
                            }
                        }
                        sQLiteDatabaseA.setTransactionSuccessful();
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                        }
                    } catch (SQLiteDatabaseCorruptException e3) {
                        sQLiteDatabase = sQLiteDatabaseA;
                        h.a(d);
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                        g.a(d).b();
                    } catch (Throwable th) {
                        th = th;
                        if (sQLiteDatabaseA != null) {
                            try {
                                sQLiteDatabaseA.endTransaction();
                            } catch (Throwable th2) {
                            }
                        }
                        g.a(d).b();
                        throw th;
                    }
                } catch (Throwable th3) {
                }
            } catch (SQLiteDatabaseCorruptException e4) {
            } catch (Throwable th4) {
                sQLiteDatabaseA = null;
            }
            g.a(d).b();
        } catch (Throwable th5) {
            th = th5;
            sQLiteDatabaseA = sQLiteDatabase;
        }
    }

    public boolean a(String str, String str2, int i) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                try {
                    sQLiteDatabaseA = g.a(d).a();
                    try {
                        sQLiteDatabaseA.beginTransaction();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("__i", str);
                        String strC = c(str2);
                        if (!TextUtils.isEmpty(strC)) {
                            contentValues.put("__a", strC);
                            contentValues.put("__t", Integer.valueOf(i));
                            contentValues.put("__av", UMUtils.getAppVersionName(d));
                            contentValues.put("__vc", UMUtils.getAppVersionCode(d));
                            sQLiteDatabaseA.insert(e.a.a, null, contentValues);
                        }
                        sQLiteDatabaseA.setTransactionSuccessful();
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                        }
                    } catch (SQLiteDatabaseCorruptException e2) {
                        sQLiteDatabase = sQLiteDatabaseA;
                        h.a(d);
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                        g.a(d).b();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        if (sQLiteDatabaseA != null) {
                            try {
                                sQLiteDatabaseA.endTransaction();
                            } catch (Throwable th2) {
                            }
                        }
                        g.a(d).b();
                        throw th;
                    }
                } catch (Throwable th3) {
                }
            } catch (SQLiteDatabaseCorruptException e3) {
            } catch (Throwable th4) {
                sQLiteDatabaseA = null;
            }
            g.a(d).b();
            return false;
        } catch (Throwable th5) {
            th = th5;
            sQLiteDatabaseA = sQLiteDatabase;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.StringBuilder] */
    public void d() throws Throwable {
        ?? r1;
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        ?? th2 = 0;
        th2 = 0;
        try {
            try {
                try {
                    SQLiteDatabase sQLiteDatabaseA = g.a(d).a();
                    try {
                        sQLiteDatabaseA.beginTransaction();
                        th2 = u.a().c();
                        if (TextUtils.isEmpty(th2)) {
                            if (sQLiteDatabaseA != null) {
                                try {
                                    sQLiteDatabaseA.endTransaction();
                                } catch (Throwable th3) {
                                }
                            }
                            g.a(d).b();
                            return;
                        }
                        for (String str : new String[]{"", "-1"}) {
                            sQLiteDatabaseA.execSQL("update __et set __i=\"" + th2 + "\" where __i=\"" + str + "\"");
                        }
                        sQLiteDatabaseA.setTransactionSuccessful();
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                        }
                    } catch (SQLiteDatabaseCorruptException e2) {
                        th2 = sQLiteDatabaseA;
                        h.a(d);
                        if (th2 != 0) {
                            th2.endTransaction();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        r1 = sQLiteDatabaseA;
                        if (r1 != 0) {
                            try {
                                r1.endTransaction();
                            } catch (Throwable th5) {
                            }
                        }
                        g.a(d).b();
                        throw th;
                    }
                } catch (Throwable th6) {
                    r1 = th2;
                    th = th6;
                }
            } catch (SQLiteDatabaseCorruptException e3) {
            } catch (Throwable th7) {
                sQLiteDatabase = null;
            }
        } catch (Throwable th8) {
            th2 = th8;
        }
        g.a(d).b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public boolean a(String str, JSONObject jSONObject, a aVar) throws Throwable {
        ?? r2;
        SQLiteDatabase sQLiteDatabase;
        a aVar2;
        if (jSONObject == null) {
            return false;
        }
        ?? r1 = 0;
        r1 = 0;
        r1 = 0;
        r1 = 0;
        r1 = 0;
        r1 = 0;
        try {
            try {
                try {
                    SQLiteDatabase sQLiteDatabaseA = g.a(d).a();
                    try {
                        sQLiteDatabaseA.beginTransaction();
                        if (aVar == a.BEGIN) {
                            long jLongValue = ((Long) jSONObject.opt("__e")).longValue();
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("__ii", str);
                            contentValues.put("__e", String.valueOf(jLongValue));
                            contentValues.put("__av", UMUtils.getAppVersionName(d));
                            contentValues.put("__vc", UMUtils.getAppVersionCode(d));
                            sQLiteDatabaseA.insert(e.d.a, null, contentValues);
                        } else {
                            a aVar3 = a.INSTANTSESSIONBEGIN;
                            if (aVar == aVar3) {
                                b(str, jSONObject, sQLiteDatabaseA);
                                r1 = aVar3;
                            } else {
                                a aVar4 = a.END;
                                if (aVar == aVar4) {
                                    a(str, jSONObject, sQLiteDatabaseA);
                                    r1 = aVar4;
                                } else {
                                    a aVar5 = a.PAGE;
                                    if (aVar == aVar5) {
                                        a(str, jSONObject, sQLiteDatabaseA, "__a");
                                        r1 = aVar5;
                                    } else {
                                        a aVar6 = a.AUTOPAGE;
                                        if (aVar == aVar6) {
                                            a(str, jSONObject, sQLiteDatabaseA, e.d.a.c);
                                            r1 = aVar6;
                                        } else {
                                            aVar2 = a.NEWSESSION;
                                            if (aVar == aVar2) {
                                                r1 = aVar2;
                                                c(str, jSONObject, sQLiteDatabaseA);
                                                r1 = aVar2;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        r1 = aVar2;
                        sQLiteDatabaseA.setTransactionSuccessful();
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                        }
                    } catch (SQLiteDatabaseCorruptException e2) {
                        r1 = sQLiteDatabaseA;
                        h.a(d);
                        if (r1 != 0) {
                            r1.endTransaction();
                        }
                    } catch (Throwable th) {
                        th = th;
                        r2 = sQLiteDatabaseA;
                        if (r2 != 0) {
                            try {
                                r2.endTransaction();
                            } catch (Throwable th2) {
                            }
                        }
                        g.a(d).b();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r2 = r1;
                }
            } catch (SQLiteDatabaseCorruptException e3) {
            } catch (Throwable th4) {
                sQLiteDatabase = null;
            }
        } catch (Throwable th5) {
        }
        g.a(d).b();
        return false;
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long jLongValue = ((Long) jSONObject.opt(e.d.a.g)).longValue();
            long jLongValue2 = 0;
            Object objOpt = jSONObject.opt(e.d.a.h);
            if (objOpt != null && (objOpt instanceof Long)) {
                jLongValue2 = ((Long) objOpt).longValue();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__pp");
            String strC = "";
            String strC2 = "";
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                strC = c(jSONObjectOptJSONObject.toString());
            }
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                strC2 = c(jSONObjectOptJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + jLongValue + "\", " + e.d.a.h + "=\"" + jLongValue2 + "\", __sp=\"" + strC + "\", __pp=\"" + strC2 + "\" where __ii=\"" + str + "\"");
        } catch (Throwable th) {
        }
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long jLongValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__pp");
            String strC = "";
            String strC2 = "";
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                strC = c(jSONObjectOptJSONObject.toString());
            }
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                strC2 = c(jSONObjectOptJSONObject2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(jLongValue));
            contentValues.put("__sp", strC);
            contentValues.put("__pp", strC2);
            contentValues.put("__av", UMGlobalContext.getInstance(d).getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(d));
            sQLiteDatabase.insert(e.c.a, null, contentValues);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0061 A[Catch: Exception -> 0x005d, TRY_LEAVE, TryCatch #2 {Exception -> 0x005d, blocks: (B:25:0x0059, B:29:0x0061), top: B:44:0x0059 }] */
    public long a(String str) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorA;
        Cursor cursor = null;
        long j = 0;
        try {
            try {
                sQLiteDatabaseA = g.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    cursorA = a(e.d.a, sQLiteDatabaseA, new String[]{e.d.a.g}, "__ii=? ", new String[]{str}, null, null, null, null);
                    if (cursorA != null) {
                        try {
                            cursorA.moveToFirst();
                            j = cursorA.getLong(cursorA.getColumnIndex(e.d.a.g));
                        } catch (Exception e2) {
                            cursor = cursorA;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabaseA != null) {
                                sQLiteDatabaseA.endTransaction();
                            }
                        } catch (Throwable th) {
                            th = th;
                            Throwable th2 = th;
                            if (cursorA != null) {
                                try {
                                    cursorA.close();
                                    if (sQLiteDatabaseA != null) {
                                        sQLiteDatabaseA.endTransaction();
                                    }
                                } catch (Exception e3) {
                                    g.a(d).b();
                                    throw th2;
                                }
                            } else if (sQLiteDatabaseA != null) {
                                sQLiteDatabaseA.endTransaction();
                            }
                            g.a(d).b();
                            throw th2;
                        }
                    }
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    if (sQLiteDatabaseA != null) {
                        sQLiteDatabaseA.endTransaction();
                    }
                } catch (Exception e4) {
                } catch (Throwable th3) {
                    th = th3;
                    cursorA = null;
                }
            } catch (Exception e5) {
            }
        } catch (Exception e6) {
            sQLiteDatabaseA = null;
        } catch (Throwable th4) {
            th = th4;
            sQLiteDatabaseA = null;
            cursorA = null;
        }
        g.a(d).b();
        return j;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x012d  */
    /* JADX WARN: Code duplicated, block: B:56:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:? A[RETURN, SYNTHETIC] */
    private void c(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) throws Throwable {
        Throwable th;
        Cursor cursor;
        JSONObject jSONObject2;
        String str2;
        Throwable th2;
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(e.d.a.e);
            if (jSONObjectOptJSONObject != null) {
                jSONObject2 = jSONObjectOptJSONObject;
                Cursor cursorA = a(e.d.a, sQLiteDatabase, new String[]{e.d.a.e}, "__ii=? ", new String[]{str}, null, null, null, null);
                if (cursorA != null) {
                    String strD = null;
                    while (cursorA.moveToNext()) {
                        try {
                            strD = d(cursorA.getString(cursorA.getColumnIndex(e.d.a.e)));
                        } catch (Throwable th3) {
                            th2 = th3;
                            cursor = cursorA;
                            th = th2;
                            if (cursor != null) {
                                throw th;
                            }
                            cursor.close();
                            throw th;
                        }
                    }
                    cursor = cursorA;
                    str2 = strD;
                } else {
                    cursor = cursorA;
                    str2 = null;
                }
            } else {
                jSONObject2 = jSONObjectOptJSONObject;
                str2 = null;
                cursor = null;
            }
            if (jSONObject2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONArray = new JSONArray(str2);
                    }
                    jSONArray.put(jSONObject2);
                    String strC = c(jSONArray.toString());
                    if (!TextUtils.isEmpty(strC)) {
                        sQLiteDatabase.execSQL("update  __sd set __d=\"" + strC + "\" where __ii=\"" + str + "\"");
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    th = th2;
                    if (cursor != null) {
                        throw th;
                    }
                    cursor.close();
                    throw th;
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(e.d.a.d);
            if (jSONObjectOptJSONObject2 != null) {
                String strC2 = c(jSONObjectOptJSONObject2.toString());
                if (!TextUtils.isEmpty(strC2)) {
                    sQLiteDatabase.execSQL("update  __sd set __c=\"" + strC2 + "\" where __ii=\"" + str + "\"");
                }
            }
            sQLiteDatabase.execSQL("update  __sd set __f=\"" + String.valueOf(jSONObject.optLong(e.d.a.g)) + "\" where __ii=\"" + str + "\"");
            if (cursor == null) {
                return;
            }
        } catch (Throwable th5) {
            th = th5;
            cursor = null;
        }
        cursor.close();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0061 A[Catch: all -> 0x006e, Throwable -> 0x0072, LOOP:1: B:67:0x005b->B:26:0x0061, LOOP_END, TryCatch #4 {Throwable -> 0x0072, all -> 0x006e, blocks: (B:24:0x005b, B:26:0x0061, B:31:0x0075, B:33:0x0080, B:34:0x0085, B:41:0x0095, B:43:0x009b, B:45:0x00a2, B:47:0x00a9, B:48:0x00ac, B:50:0x00ba), top: B:67:0x005b }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0080 A[Catch: all -> 0x006e, Throwable -> 0x0072, TryCatch #4 {Throwable -> 0x0072, all -> 0x006e, blocks: (B:24:0x005b, B:26:0x0061, B:31:0x0075, B:33:0x0080, B:34:0x0085, B:41:0x0095, B:43:0x009b, B:45:0x00a2, B:47:0x00a9, B:48:0x00ac, B:50:0x00ba), top: B:67:0x005b }] */
    /* JADX WARN: Code duplicated, block: B:37:0x008d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x008f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0093  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a2 A[Catch: all -> 0x006e, Throwable -> 0x0072, TRY_ENTER, TryCatch #4 {Throwable -> 0x0072, all -> 0x006e, blocks: (B:24:0x005b, B:26:0x0061, B:31:0x0075, B:33:0x0080, B:34:0x0085, B:41:0x0095, B:43:0x009b, B:45:0x00a2, B:47:0x00a9, B:48:0x00ac, B:50:0x00ba), top: B:67:0x005b }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00ba A[Catch: all -> 0x006e, Throwable -> 0x0072, TRY_LEAVE, TryCatch #4 {Throwable -> 0x0072, all -> 0x006e, blocks: (B:24:0x005b, B:26:0x0061, B:31:0x0075, B:33:0x0080, B:34:0x0085, B:41:0x0095, B:43:0x009b, B:45:0x00a2, B:47:0x00a9, B:48:0x00ac, B:50:0x00ba), top: B:67:0x005b }] */
    /* JADX WARN: Code duplicated, block: B:63:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x005b A[EXC_TOP_SPLITTER, LOOP:1: B:67:0x005b->B:26:0x0061, LOOP_START, PHI: r14
      0x005b: PHI (r14v2 java.lang.String) = (r14v7 java.lang.String), (r14v3 java.lang.String) binds: [B:23:0x0059, B:26:0x0061] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:50:0x00ba, please report this as an issue */
    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase, String str2) throws Throwable {
        Cursor cursorA;
        JSONArray jSONArray;
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArray2;
        int i;
        String strC;
        JSONObject jSONObject2;
        Cursor cursor = null;
        strD = null;
        String strD = null;
        try {
            if (!"__a".equals(str2)) {
                if (e.d.a.c.equals(str2)) {
                    jSONArrayOptJSONArray = jSONObject.optJSONArray(e.d.a.c);
                    if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                        return;
                    }
                } else {
                    jSONArray = null;
                }
                cursorA = a(e.d.a, sQLiteDatabase, new String[]{str2}, "__ii=? ", new String[]{str}, null, null, null, null);
                if (cursorA != null) {
                    while (cursorA.moveToNext()) {
                        try {
                            strD = d(cursorA.getString(cursorA.getColumnIndex(str2)));
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorA;
                            Throwable th2 = th;
                            if (cursor == null) {
                                throw th2;
                            }
                            cursor.close();
                            throw th2;
                        }
                    }
                }
                jSONArray2 = new JSONArray();
                if (!TextUtils.isEmpty(strD)) {
                    jSONArray2 = new JSONArray(strD);
                }
                if (jSONArray2.length() > 1000) {
                    if (cursorA != null) {
                        cursorA.close();
                        return;
                    }
                    return;
                }
                for (i = 0; i < jSONArray.length(); i++) {
                    try {
                        jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            jSONArray2.put(jSONObject2);
                        }
                    } catch (JSONException e2) {
                    }
                }
                strC = c(jSONArray2.toString());
                if (!TextUtils.isEmpty(strC)) {
                    sQLiteDatabase.execSQL("update __sd set " + str2 + "=\"" + strC + "\" where __ii=\"" + str + "\"");
                }
                if (cursorA == null) {
                    return;
                }
                cursorA.close();
            }
            jSONArrayOptJSONArray = jSONObject.optJSONArray("__a");
            if (jSONArrayOptJSONArray == null) {
                return;
            }
            if (jSONArrayOptJSONArray.length() <= 0) {
                return;
            }
            jSONArray = jSONArrayOptJSONArray;
            cursorA = a(e.d.a, sQLiteDatabase, new String[]{str2}, "__ii=? ", new String[]{str}, null, null, null, null);
            if (cursorA != null) {
                while (cursorA.moveToNext()) {
                    strD = d(cursorA.getString(cursorA.getColumnIndex(str2)));
                }
            }
            jSONArray2 = new JSONArray();
            if (!TextUtils.isEmpty(strD)) {
                jSONArray2 = new JSONArray(strD);
            }
            if (jSONArray2.length() > 1000) {
                if (cursorA != null) {
                    cursorA.close();
                    return;
                }
                return;
            }
            while (i < jSONArray.length()) {
                jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    jSONArray2.put(jSONObject2);
                }
            }
            strC = c(jSONArray2.toString());
            if (!TextUtils.isEmpty(strC)) {
                sQLiteDatabase.execSQL("update __sd set " + str2 + "=\"" + strC + "\" where __ii=\"" + str + "\"");
            }
            if (cursorA == null) {
                return;
            }
            cursorA.close();
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public boolean e() {
        return this.i.isEmpty();
    }

    public JSONObject a(boolean z) throws Throwable {
        a();
        this.j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            a(jSONObject, z);
            b(jSONObject, (String) null);
            a(jSONObject, (String) null);
        } else {
            String strA = a(jSONObject, z);
            if (!TextUtils.isEmpty(strA)) {
                b(jSONObject, strA);
                a(jSONObject, strA);
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0079  */
    /* JADX WARN: Code duplicated, block: B:28:0x007e A[Catch: Throwable -> 0x009b, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Throwable -> 0x009b, blocks: (B:41:0x0097, B:28:0x007e), top: B:67:0x000a }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v23, types: [android.database.sqlite.SQLiteDatabase] */
    public JSONObject f() throws Throwable {
        Cursor cursorA;
        Throwable th;
        JSONObject jSONObject;
        SQLiteDatabase sQLiteDatabaseIsEmpty = this.l.isEmpty();
        JSONObject jSONObject2 = null;
        jSONObject2 = null;
        jSONObject2 = null;
        jSONObject2 = null;
        jSONObject2 = null;
        cursor = null;
        jSONObject2 = null;
        cursor = null;
        jSONObject2 = null;
        Cursor cursor = null;
        try {
            try {
                if (sQLiteDatabaseIsEmpty != 0) {
                    return null;
                }
                try {
                    sQLiteDatabaseIsEmpty = g.a(d).a();
                    try {
                        sQLiteDatabaseIsEmpty.beginTransaction();
                        cursorA = a(e.c.a, sQLiteDatabaseIsEmpty, null, "__ii=? ", new String[]{this.l.get(0)}, null, null, null, null);
                        if (cursorA != null) {
                            try {
                                try {
                                    if (cursorA.moveToNext()) {
                                        jSONObject = new JSONObject();
                                        try {
                                            String string = cursorA.getString(cursorA.getColumnIndex("__av"));
                                            String string2 = cursorA.getString(cursorA.getColumnIndex("__vc"));
                                            jSONObject.put("__av", string);
                                            jSONObject.put("__vc", string2);
                                            jSONObject2 = jSONObject;
                                        } catch (SQLiteDatabaseCorruptException e2) {
                                            cursor = cursorA;
                                            h.a(d);
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            if (sQLiteDatabaseIsEmpty != 0) {
                                                try {
                                                    sQLiteDatabaseIsEmpty.endTransaction();
                                                } catch (Throwable th2) {
                                                }
                                            }
                                            g.a(d).b();
                                            return jSONObject;
                                        } catch (Throwable th3) {
                                            jSONObject2 = jSONObject;
                                            if (cursorA != null) {
                                                cursorA.close();
                                            }
                                            if (sQLiteDatabaseIsEmpty != 0) {
                                                sQLiteDatabaseIsEmpty.endTransaction();
                                            }
                                            g.a(d).b();
                                            return jSONObject2;
                                        }
                                    }
                                    sQLiteDatabaseIsEmpty.setTransactionSuccessful();
                                    if (cursorA != null) {
                                        cursorA.close();
                                    }
                                    if (sQLiteDatabaseIsEmpty != 0) {
                                        sQLiteDatabaseIsEmpty.endTransaction();
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    if (cursorA != null) {
                                        cursorA.close();
                                    }
                                    if (sQLiteDatabaseIsEmpty != 0) {
                                        try {
                                            sQLiteDatabaseIsEmpty.endTransaction();
                                        } catch (Throwable th5) {
                                        }
                                    }
                                    g.a(d).b();
                                    throw th;
                                }
                            } catch (SQLiteDatabaseCorruptException e3) {
                                jSONObject = jSONObject2;
                            } catch (Throwable th6) {
                            }
                        } else {
                            sQLiteDatabaseIsEmpty.setTransactionSuccessful();
                            if (cursorA != null) {
                                cursorA.close();
                            }
                            if (sQLiteDatabaseIsEmpty != 0) {
                                sQLiteDatabaseIsEmpty.endTransaction();
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException e4) {
                        jSONObject = null;
                    } catch (Throwable th7) {
                        cursorA = null;
                    }
                } catch (SQLiteDatabaseCorruptException e5) {
                    sQLiteDatabaseIsEmpty = 0;
                    jSONObject = null;
                } catch (Throwable th8) {
                    cursorA = null;
                    th = th8;
                    sQLiteDatabaseIsEmpty = 0;
                }
            } catch (Throwable th9) {
            }
            g.a(d).b();
            return jSONObject2;
        } catch (Throwable th10) {
            cursorA = cursor;
            th = th10;
        }
    }

    public JSONObject b(boolean z) throws Throwable {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, z);
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.Cursor, android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r14v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r15v6, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r15v8, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r2v2, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object, org.json.JSONArray] */
    private void a(JSONObject jSONObject, String str) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        ?? A = 0;
        A = 0;
        A = 0;
        A = 0;
        try {
            try {
                try {
                    sQLiteDatabaseA = g.a(d).a();
                    try {
                        sQLiteDatabaseA.beginTransaction();
                        A = !TextUtils.isEmpty(str) ? a(e.b.a, sQLiteDatabaseA, null, "__i=? ", new String[]{str}, null, null, null, null) : a(e.b.a, sQLiteDatabaseA, null, null, null, null, null, null, null);
                        if (A != 0) {
                            ?? jSONObject2 = new JSONObject();
                            ?? jSONObject3 = new JSONObject();
                            String strB = u.a().b();
                            while (A.moveToNext()) {
                                int i = A.getInt(A.getColumnIndex("__t"));
                                String string = A.getString(A.getColumnIndex("__i"));
                                String string2 = A.getString(A.getColumnIndex("__s"));
                                if (TextUtils.isEmpty(string) || "-1".equals(string)) {
                                    if (!TextUtils.isEmpty(strB)) {
                                        string = strB;
                                    }
                                }
                                this.j.add(Integer.valueOf(A.getInt(0)));
                                switch (i) {
                                    case a /* 2049 */:
                                        if (!TextUtils.isEmpty(string2)) {
                                            JSONObject jSONObject4 = new JSONObject(d(string2));
                                            JSONArray jSONArrayOptJSONArray = jSONObject2.has(string) ? jSONObject2.optJSONArray(string) : new JSONArray();
                                            jSONArrayOptJSONArray.put(jSONObject4);
                                            jSONObject2.put(string, jSONArrayOptJSONArray);
                                        }
                                        break;
                                    case b /* 2050 */:
                                        if (!TextUtils.isEmpty(string2)) {
                                            JSONObject jSONObject5 = new JSONObject(d(string2));
                                            JSONArray jSONArrayOptJSONArray2 = jSONObject3.has(string) ? jSONObject3.optJSONArray(string) : new JSONArray();
                                            jSONArrayOptJSONArray2.put(jSONObject5);
                                            jSONObject3.put(string, jSONArrayOptJSONArray2);
                                        }
                                        break;
                                }
                            }
                            if (jSONObject2.length() > 0) {
                                ?? jSONArray = new JSONArray();
                                Iterator<String> itKeys = jSONObject2.keys();
                                while (itKeys.hasNext()) {
                                    JSONObject jSONObject6 = new JSONObject();
                                    String next = itKeys.next();
                                    jSONObject6.put(next, new JSONArray(jSONObject2.optString(next)));
                                    if (jSONObject6.length() > 0) {
                                        jSONArray.put(jSONObject6);
                                    }
                                }
                                if (jSONArray.length() > 0) {
                                    jSONObject.put("ekv", jSONArray);
                                }
                            }
                            if (jSONObject3.length() > 0) {
                                ?? jSONArray2 = new JSONArray();
                                Iterator<String> itKeys2 = jSONObject3.keys();
                                while (itKeys2.hasNext()) {
                                    JSONObject jSONObject7 = new JSONObject();
                                    String next2 = itKeys2.next();
                                    jSONObject7.put(next2, new JSONArray(jSONObject3.optString(next2)));
                                    if (jSONObject7.length() > 0) {
                                        jSONArray2.put(jSONObject7);
                                    }
                                }
                                if (jSONArray2.length() > 0) {
                                    jSONObject.put(d.T, jSONArray2);
                                }
                            }
                        }
                        sQLiteDatabaseA.setTransactionSuccessful();
                        if (A != 0) {
                            A.close();
                        }
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                        }
                    } catch (SQLiteDatabaseCorruptException e2) {
                        h.a(d);
                        if (A != 0) {
                            A.close();
                        }
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                        }
                        g.a(d).b();
                    } catch (Throwable th) {
                        h.a(d);
                        if (A != 0) {
                            A.close();
                        }
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                        }
                        g.a(d).b();
                    }
                } catch (Throwable th2) {
                }
            } catch (SQLiteDatabaseCorruptException e3) {
                sQLiteDatabaseA = null;
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                    A.close();
                }
                if (0 != 0) {
                    try {
                        A.endTransaction();
                    } catch (Throwable th4) {
                    }
                }
                g.a(d).b();
                throw th;
            }
            g.a(d).b();
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.Cursor, android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r13v0, types: [org.json.JSONObject] */
    private void b(JSONObject jSONObject, String str) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        ?? A = 0;
        A = 0;
        A = 0;
        A = 0;
        try {
            try {
                try {
                    sQLiteDatabaseA = g.a(d).a();
                    try {
                        sQLiteDatabaseA.beginTransaction();
                        A = !TextUtils.isEmpty(str) ? a(e.a.a, sQLiteDatabaseA, null, "__i=? ", new String[]{str}, null, null, null, null) : a(e.a.a, sQLiteDatabaseA, null, null, null, null, null, null, null);
                        if (A != 0) {
                            JSONArray jSONArray = new JSONArray();
                            while (A.moveToNext()) {
                                String string = A.getString(A.getColumnIndex("__a"));
                                if (!TextUtils.isEmpty(string)) {
                                    jSONArray.put(new JSONObject(d(string)));
                                }
                            }
                            if (jSONArray.length() > 0) {
                                jSONObject.put("error", jSONArray);
                            }
                        }
                        sQLiteDatabaseA.setTransactionSuccessful();
                        if (A != 0) {
                            A.close();
                        }
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                        }
                    } catch (SQLiteDatabaseCorruptException e2) {
                        h.a(d);
                        if (A != 0) {
                            A.close();
                        }
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                        }
                        g.a(d).b();
                    } catch (Throwable th) {
                        h.a(d);
                        if (A != 0) {
                            A.close();
                        }
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                        }
                        g.a(d).b();
                    }
                } catch (Throwable th2) {
                }
            } catch (SQLiteDatabaseCorruptException e3) {
                sQLiteDatabaseA = null;
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                    A.close();
                }
                if (0 != 0) {
                    try {
                        A.endTransaction();
                    } catch (Throwable th4) {
                    }
                }
                g.a(d).b();
                throw th;
            }
            g.a(d).b();
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0079  */
    /* JADX WARN: Code duplicated, block: B:28:0x007e A[Catch: Throwable -> 0x009b, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Throwable -> 0x009b, blocks: (B:41:0x0097, B:28:0x007e), top: B:67:0x000a }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v23, types: [android.database.sqlite.SQLiteDatabase] */
    public JSONObject g() throws Throwable {
        Cursor cursorA;
        Throwable th;
        JSONObject jSONObject;
        SQLiteDatabase sQLiteDatabaseIsEmpty = this.i.isEmpty();
        JSONObject jSONObject2 = null;
        jSONObject2 = null;
        jSONObject2 = null;
        jSONObject2 = null;
        jSONObject2 = null;
        cursor = null;
        jSONObject2 = null;
        cursor = null;
        jSONObject2 = null;
        Cursor cursor = null;
        try {
            try {
                if (sQLiteDatabaseIsEmpty != 0) {
                    return null;
                }
                try {
                    sQLiteDatabaseIsEmpty = g.a(d).a();
                    try {
                        sQLiteDatabaseIsEmpty.beginTransaction();
                        cursorA = a(e.d.a, sQLiteDatabaseIsEmpty, null, "__ii=? ", new String[]{this.i.get(0)}, null, null, null, null);
                        if (cursorA != null) {
                            try {
                                try {
                                    if (cursorA.moveToNext()) {
                                        jSONObject = new JSONObject();
                                        try {
                                            String string = cursorA.getString(cursorA.getColumnIndex("__av"));
                                            String string2 = cursorA.getString(cursorA.getColumnIndex("__vc"));
                                            jSONObject.put("__av", string);
                                            jSONObject.put("__vc", string2);
                                            jSONObject2 = jSONObject;
                                        } catch (SQLiteDatabaseCorruptException e2) {
                                            cursor = cursorA;
                                            h.a(d);
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            if (sQLiteDatabaseIsEmpty != 0) {
                                                try {
                                                    sQLiteDatabaseIsEmpty.endTransaction();
                                                } catch (Throwable th2) {
                                                }
                                            }
                                            g.a(d).b();
                                            return jSONObject;
                                        } catch (Throwable th3) {
                                            jSONObject2 = jSONObject;
                                            if (cursorA != null) {
                                                cursorA.close();
                                            }
                                            if (sQLiteDatabaseIsEmpty != 0) {
                                                sQLiteDatabaseIsEmpty.endTransaction();
                                            }
                                            g.a(d).b();
                                            return jSONObject2;
                                        }
                                    }
                                    sQLiteDatabaseIsEmpty.setTransactionSuccessful();
                                    if (cursorA != null) {
                                        cursorA.close();
                                    }
                                    if (sQLiteDatabaseIsEmpty != 0) {
                                        sQLiteDatabaseIsEmpty.endTransaction();
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    if (cursorA != null) {
                                        cursorA.close();
                                    }
                                    if (sQLiteDatabaseIsEmpty != 0) {
                                        try {
                                            sQLiteDatabaseIsEmpty.endTransaction();
                                        } catch (Throwable th5) {
                                        }
                                    }
                                    g.a(d).b();
                                    throw th;
                                }
                            } catch (SQLiteDatabaseCorruptException e3) {
                                jSONObject = jSONObject2;
                            } catch (Throwable th6) {
                            }
                        } else {
                            sQLiteDatabaseIsEmpty.setTransactionSuccessful();
                            if (cursorA != null) {
                                cursorA.close();
                            }
                            if (sQLiteDatabaseIsEmpty != 0) {
                                sQLiteDatabaseIsEmpty.endTransaction();
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException e4) {
                        jSONObject = null;
                    } catch (Throwable th7) {
                        cursorA = null;
                    }
                } catch (SQLiteDatabaseCorruptException e5) {
                    sQLiteDatabaseIsEmpty = 0;
                    jSONObject = null;
                } catch (Throwable th8) {
                    cursorA = null;
                    th = th8;
                    sQLiteDatabaseIsEmpty = 0;
                }
            } catch (Throwable th9) {
            }
            g.a(d).b();
            return jSONObject2;
        } catch (Throwable th10) {
            cursorA = cursor;
            th = th10;
        }
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("duration") > 0) {
                jSONArray2.put(jSONObjectOptJSONObject);
            }
        }
        return jSONArray2;
    }

    /* JADX WARN: Code duplicated, block: B:158:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:160:0x02fb A[Catch: Throwable -> 0x0313, TRY_ENTER, TRY_LEAVE, TryCatch #13 {Throwable -> 0x0313, blocks: (B:160:0x02fb, B:168:0x030f), top: B:190:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:166:0x030a  */
    /* JADX WARN: Code duplicated, block: B:168:0x030f A[Catch: Throwable -> 0x0313, TRY_ENTER, TRY_LEAVE, TryCatch #13 {Throwable -> 0x0313, blocks: (B:160:0x02fb, B:168:0x030f), top: B:190:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:176:0x0324  */
    /* JADX WARN: Code duplicated, block: B:194:0x0329 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private String a(JSONObject jSONObject, boolean z) throws Throwable {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        String string;
        Cursor cursor;
        Cursor cursor2;
        JSONArray jSONArray;
        SQLiteDatabase sQLiteDatabase2;
        Cursor cursor3 = null;
        str = null;
        str = null;
        str = null;
        String str = null;
        cursor3 = null;
        cursor3 = null;
        cursor3 = null;
        cursor3 = null;
        cursor3 = null;
        cursor3 = null;
        cursor3 = null;
        try {
            try {
                try {
                    SQLiteDatabase sQLiteDatabaseA = g.a(d).a();
                    try {
                        sQLiteDatabaseA.beginTransaction();
                        Cursor cursorA = a(e.d.a, sQLiteDatabaseA, null, null, null, null, null, null, null);
                        if (cursorA != null) {
                            try {
                                JSONArray jSONArray2 = new JSONArray();
                                while (true) {
                                    if (!cursorA.moveToNext()) {
                                        cursor2 = cursorA;
                                        jSONArray = jSONArray2;
                                        sQLiteDatabase2 = sQLiteDatabaseA;
                                        break;
                                    }
                                    try {
                                        try {
                                            JSONObject jSONObject2 = new JSONObject();
                                            String string2 = cursorA.getString(cursorA.getColumnIndex(e.d.a.g));
                                            String string3 = cursorA.getString(cursorA.getColumnIndex("__e"));
                                            String string4 = cursorA.getString(cursorA.getColumnIndex(e.d.a.h));
                                            string = cursorA.getString(cursorA.getColumnIndex("__ii"));
                                            try {
                                                if (TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                                                    cursor2 = cursorA;
                                                    jSONArray = jSONArray2;
                                                    string = string;
                                                    sQLiteDatabase2 = sQLiteDatabaseA;
                                                } else {
                                                    if (Long.parseLong(string2) - Long.parseLong(string3) > 0) {
                                                        String string5 = cursorA.getString(cursorA.getColumnIndex("__a"));
                                                        String string6 = cursorA.getString(cursorA.getColumnIndex(e.d.a.c));
                                                        String string7 = cursorA.getString(cursorA.getColumnIndex(e.d.a.d));
                                                        String string8 = cursorA.getString(cursorA.getColumnIndex(e.d.a.e));
                                                        this.i.add(string);
                                                        String string9 = cursorA.getString(cursorA.getColumnIndex("__sp"));
                                                        String string10 = cursorA.getString(cursorA.getColumnIndex("__pp"));
                                                        sQLiteDatabase2 = sQLiteDatabaseA;
                                                        try {
                                                            jSONObject2.put("id", string);
                                                            jSONObject2.put(d.p, string3);
                                                            jSONObject2.put(d.q, string2);
                                                            if (!FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                                                                cursor2 = cursorA;
                                                                jSONArray2 = jSONArray2;
                                                                string = string;
                                                                string9 = string9;
                                                                string10 = string10;
                                                                jSONObject2.put("duration", Long.parseLong(string2) - Long.parseLong(string3));
                                                            } else if (Long.parseLong(string4) <= 0) {
                                                                cursor2 = cursorA;
                                                                try {
                                                                    try {
                                                                        jSONObject2.put("duration", Long.parseLong(string2) - Long.parseLong(string3));
                                                                    } catch (Throwable th2) {
                                                                        th = th2;
                                                                        th = th;
                                                                        sQLiteDatabase = sQLiteDatabase2;
                                                                        cursor3 = cursor2;
                                                                        if (cursor3 != null) {
                                                                            cursor3.close();
                                                                        }
                                                                        if (sQLiteDatabase != null) {
                                                                            try {
                                                                                sQLiteDatabase.endTransaction();
                                                                            } catch (Throwable th3) {
                                                                            }
                                                                        }
                                                                        g.a(d).b();
                                                                        throw th;
                                                                    }
                                                                } catch (SQLiteDatabaseCorruptException e2) {
                                                                    string = string;
                                                                    sQLiteDatabase = sQLiteDatabase2;
                                                                    cursor3 = cursor2;
                                                                    h.a(d);
                                                                    if (cursor3 != null) {
                                                                        cursor3.close();
                                                                    }
                                                                    if (sQLiteDatabase != null) {
                                                                        sQLiteDatabase.endTransaction();
                                                                    }
                                                                    g.a(d).b();
                                                                    return string;
                                                                } catch (Throwable th4) {
                                                                    string = string;
                                                                    sQLiteDatabase = sQLiteDatabase2;
                                                                    cursor3 = cursor2;
                                                                    h.a(d);
                                                                    if (cursor3 != null) {
                                                                        cursor3.close();
                                                                    }
                                                                    if (sQLiteDatabase != null) {
                                                                        sQLiteDatabase.endTransaction();
                                                                    }
                                                                    g.a(d).b();
                                                                    return string;
                                                                }
                                                            } else {
                                                                cursor2 = cursorA;
                                                                jSONObject2.put("duration", Long.parseLong(string4));
                                                                jSONObject2.put(d.s, Long.parseLong(string2) - Long.parseLong(string3));
                                                            }
                                                            try {
                                                                if (!TextUtils.isEmpty(string5)) {
                                                                    jSONObject2.put(d.t, new JSONArray(d(string5)));
                                                                }
                                                                boolean z2 = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO;
                                                                if (!TextUtils.isEmpty(string6) && z2) {
                                                                    JSONArray jSONArray3 = new JSONArray(d(string6));
                                                                    JSONArray jSONArray4 = new JSONArray();
                                                                    if (jSONArray3 != null && jSONArray3.length() > 0) {
                                                                        jSONArray4 = b(jSONArray3);
                                                                    }
                                                                    jSONObject2.put(d.u, jSONArray4);
                                                                }
                                                                if (!TextUtils.isEmpty(string7)) {
                                                                    jSONObject2.put(d.F, new JSONObject(d(string7)));
                                                                }
                                                                if (!TextUtils.isEmpty(string8)) {
                                                                    jSONObject2.put(d.B, new JSONArray(d(string8)));
                                                                }
                                                                String str2 = string9;
                                                                if (!TextUtils.isEmpty(str2)) {
                                                                    jSONObject2.put(d.au, new JSONObject(d(str2)));
                                                                }
                                                                String str3 = string10;
                                                                if (!TextUtils.isEmpty(str3)) {
                                                                    jSONObject2.put(d.av, new JSONObject(d(str3)));
                                                                }
                                                                if (jSONObject2.length() > 0) {
                                                                    jSONArray = jSONArray2;
                                                                    jSONArray.put(jSONObject2);
                                                                } else {
                                                                    jSONArray = jSONArray2;
                                                                }
                                                            } catch (SQLiteDatabaseCorruptException e3) {
                                                                sQLiteDatabase = sQLiteDatabase2;
                                                                cursor3 = cursor2;
                                                                h.a(d);
                                                                if (cursor3 != null) {
                                                                    cursor3.close();
                                                                }
                                                                if (sQLiteDatabase != null) {
                                                                    sQLiteDatabase.endTransaction();
                                                                }
                                                                g.a(d).b();
                                                                return string;
                                                            } catch (Throwable th5) {
                                                                sQLiteDatabase = sQLiteDatabase2;
                                                                cursor3 = cursor2;
                                                                h.a(d);
                                                                if (cursor3 != null) {
                                                                    cursor3.close();
                                                                }
                                                                if (sQLiteDatabase != null) {
                                                                    sQLiteDatabase.endTransaction();
                                                                }
                                                                g.a(d).b();
                                                                return string;
                                                            }
                                                        } catch (SQLiteDatabaseCorruptException e4) {
                                                            cursor2 = cursorA;
                                                        } catch (Throwable th6) {
                                                            th = th6;
                                                            cursor2 = cursorA;
                                                        }
                                                    } else {
                                                        cursor2 = cursorA;
                                                        jSONArray = jSONArray2;
                                                        string = string;
                                                        sQLiteDatabase2 = sQLiteDatabaseA;
                                                    }
                                                    if (z) {
                                                        str = string;
                                                        break;
                                                    }
                                                }
                                                jSONArray2 = jSONArray;
                                                sQLiteDatabaseA = sQLiteDatabase2;
                                                cursorA = cursor2;
                                                str = string;
                                            } catch (SQLiteDatabaseCorruptException e5) {
                                                cursor2 = cursorA;
                                                string = string;
                                                sQLiteDatabase2 = sQLiteDatabaseA;
                                            } catch (Throwable th7) {
                                                cursor2 = cursorA;
                                                string = string;
                                                sQLiteDatabase2 = sQLiteDatabaseA;
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                            cursor2 = cursorA;
                                            sQLiteDatabase2 = sQLiteDatabaseA;
                                        }
                                    } catch (SQLiteDatabaseCorruptException e6) {
                                        cursor2 = cursorA;
                                        sQLiteDatabase2 = sQLiteDatabaseA;
                                        string = str;
                                    } catch (Throwable th9) {
                                        cursor2 = cursorA;
                                        sQLiteDatabase2 = sQLiteDatabaseA;
                                        string = str;
                                    }
                                }
                                try {
                                    if (this.i.size() < 1) {
                                        if (cursor2 != null) {
                                            cursor2.close();
                                        }
                                        if (sQLiteDatabase2 != null) {
                                            try {
                                                sQLiteDatabase2.endTransaction();
                                            } catch (Throwable th10) {
                                            }
                                        }
                                        g.a(d).b();
                                        return str;
                                    }
                                    sQLiteDatabase = sQLiteDatabase2;
                                    cursor = cursor2;
                                    try {
                                        if (jSONArray.length() > 0) {
                                            jSONObject.put(d.n, jSONArray);
                                        }
                                    } catch (SQLiteDatabaseCorruptException e7) {
                                        string = str;
                                        cursor3 = cursor;
                                        h.a(d);
                                        if (cursor3 != null) {
                                            cursor3.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                        g.a(d).b();
                                        return string;
                                    } catch (Throwable th11) {
                                        string = str;
                                        cursor3 = cursor;
                                        h.a(d);
                                        if (cursor3 != null) {
                                            cursor3.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                        g.a(d).b();
                                        return string;
                                    }
                                } catch (SQLiteDatabaseCorruptException e8) {
                                    sQLiteDatabase = sQLiteDatabase2;
                                    cursor = cursor2;
                                    string = str;
                                    cursor3 = cursor;
                                    h.a(d);
                                    if (cursor3 != null) {
                                        cursor3.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.endTransaction();
                                    }
                                    g.a(d).b();
                                    return string;
                                } catch (Throwable th12) {
                                    sQLiteDatabase = sQLiteDatabase2;
                                    cursor = cursor2;
                                    string = str;
                                    cursor3 = cursor;
                                    h.a(d);
                                    if (cursor3 != null) {
                                        cursor3.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.endTransaction();
                                    }
                                    g.a(d).b();
                                    return string;
                                }
                            } catch (SQLiteDatabaseCorruptException e9) {
                                cursor = cursorA;
                                sQLiteDatabase = sQLiteDatabaseA;
                            } catch (Throwable th13) {
                                cursor = cursorA;
                                sQLiteDatabase = sQLiteDatabaseA;
                            }
                        } else {
                            cursor = cursorA;
                            sQLiteDatabase = sQLiteDatabaseA;
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable th14) {
                            }
                        }
                        g.a(d).b();
                        return str;
                    } catch (SQLiteDatabaseCorruptException e10) {
                        sQLiteDatabase = sQLiteDatabaseA;
                        string = null;
                    } catch (Throwable th15) {
                        sQLiteDatabase = sQLiteDatabaseA;
                        string = null;
                    }
                } catch (Throwable th16) {
                    th = th16;
                }
            } catch (SQLiteDatabaseCorruptException e11) {
                sQLiteDatabase = null;
                string = null;
            } catch (Throwable th17) {
                th = th17;
                sQLiteDatabase = null;
            }
        } catch (Throwable th18) {
        }
    }

    private String b(JSONObject jSONObject, boolean z) throws Throwable {
        String string;
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorA;
        Cursor cursor = null;
        str = null;
        str = null;
        str = null;
        String str = null;
        cursor = null;
        cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                try {
                    sQLiteDatabaseA = g.a(d).a();
                    try {
                        sQLiteDatabaseA.beginTransaction();
                        cursorA = a(e.c.a, sQLiteDatabaseA, null, null, null, null, null, null, null);
                        if (cursorA != null) {
                            try {
                                try {
                                    JSONArray jSONArray = new JSONArray();
                                    while (cursorA.moveToNext()) {
                                        JSONObject jSONObject2 = new JSONObject();
                                        String string2 = cursorA.getString(cursorA.getColumnIndex("__e"));
                                        string = cursorA.getString(cursorA.getColumnIndex("__ii"));
                                        try {
                                            this.l.add(string);
                                            String string3 = cursorA.getString(cursorA.getColumnIndex("__sp"));
                                            String string4 = cursorA.getString(cursorA.getColumnIndex("__pp"));
                                            if (!TextUtils.isEmpty(string3)) {
                                                jSONObject2.put(d.au, new JSONObject(d(string3)));
                                            }
                                            if (!TextUtils.isEmpty(string4)) {
                                                jSONObject2.put(d.av, new JSONObject(d(string4)));
                                            }
                                            if (!TextUtils.isEmpty(string2)) {
                                                jSONObject2.put("id", string);
                                                jSONObject2.put(d.p, string2);
                                                if (jSONObject2.length() > 0) {
                                                    jSONArray.put(jSONObject2);
                                                }
                                                if (z) {
                                                    str = string;
                                                    break;
                                                }
                                            }
                                            str = string;
                                        } catch (SQLiteDatabaseCorruptException e2) {
                                            cursor2 = cursorA;
                                            h.a(d);
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            if (sQLiteDatabaseA != null) {
                                                sQLiteDatabaseA.endTransaction();
                                            }
                                            g.a(d).b();
                                            return string;
                                        } catch (Throwable th) {
                                            cursor = cursorA;
                                            h.a(d);
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            if (sQLiteDatabaseA != null) {
                                                sQLiteDatabaseA.endTransaction();
                                            }
                                            g.a(d).b();
                                            return string;
                                        }
                                    }
                                    if (jSONArray.length() > 0) {
                                        jSONObject.put(d.n, jSONArray);
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (cursorA != null) {
                                        cursorA.close();
                                    }
                                    if (sQLiteDatabaseA != null) {
                                        try {
                                            sQLiteDatabaseA.endTransaction();
                                        } catch (Throwable th3) {
                                        }
                                    }
                                    g.a(d).b();
                                    throw th;
                                }
                            } catch (SQLiteDatabaseCorruptException e3) {
                                string = str;
                            } catch (Throwable th4) {
                                string = str;
                            }
                        }
                        sQLiteDatabaseA.setTransactionSuccessful();
                        if (cursorA != null) {
                            cursorA.close();
                        }
                        if (sQLiteDatabaseA != null) {
                            try {
                                sQLiteDatabaseA.endTransaction();
                            } catch (Throwable th5) {
                            }
                        }
                        g.a(d).b();
                        return str;
                    } catch (SQLiteDatabaseCorruptException e4) {
                        string = null;
                    } catch (Throwable th6) {
                        string = null;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    cursorA = null;
                }
            } catch (SQLiteDatabaseCorruptException e5) {
                sQLiteDatabaseA = null;
                string = null;
            } catch (Throwable th8) {
                th = th8;
                sQLiteDatabaseA = null;
                cursorA = null;
            }
        } catch (Throwable th9) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.sqlite.SQLiteDatabase] */
    public void a(boolean z, boolean z2) throws Throwable {
        ?? A;
        ?? r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        try {
            try {
                try {
                    A = g.a(d).a();
                    try {
                        A.beginTransaction();
                        if (!z2) {
                            int size = this.l.size();
                            boolean z3 = false;
                            int i = 0;
                            if (size > 0) {
                                boolean z4 = false;
                                while (i < size) {
                                    String str = this.l.get(i);
                                    if (str == null) {
                                        z4 = true;
                                    }
                                    A.execSQL("delete from __is where __ii=\"" + str + "\"");
                                    i++;
                                    z4 = z4;
                                }
                                z3 = z4 ? 1 : 0;
                                r0 = z4;
                            }
                            if (z3) {
                                A.execSQL("delete from __is where __ii is null");
                            }
                        } else if (z) {
                            A.execSQL("delete from __is");
                        }
                        A.setTransactionSuccessful();
                        if (A != 0) {
                            A.endTransaction();
                            r0 = r0;
                        }
                    } catch (SQLiteDatabaseCorruptException e2) {
                        r0 = A;
                        h.a(d);
                        if (r0 != 0) {
                            r0.endTransaction();
                            r0 = r0;
                        }
                        g.a(d).b();
                    } catch (Throwable th) {
                        th = th;
                        if (A != 0) {
                            try {
                                A.endTransaction();
                            } catch (Throwable th2) {
                            }
                        }
                        g.a(d).b();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    A = r0;
                }
            } catch (SQLiteDatabaseCorruptException e3) {
            } catch (Throwable th4) {
            }
        } catch (Throwable th5) {
        }
        g.a(d).b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public void b(boolean z, boolean z2) throws Throwable {
        ?? r1;
        SQLiteDatabase sQLiteDatabase;
        ?? r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        ?? r2 = 0;
        r0 = 0;
        try {
            try {
                try {
                    SQLiteDatabase sQLiteDatabaseA = g.a(d).a();
                    try {
                        sQLiteDatabaseA.beginTransaction();
                        if (z2) {
                            if (z) {
                                sQLiteDatabaseA.execSQL("delete from __sd");
                            }
                        } else if (this.i.size() > 0) {
                            int i = 0;
                            while (i < this.i.size()) {
                                sQLiteDatabaseA.execSQL("delete from __sd where __ii=\"" + this.i.get(i) + "\"");
                                i++;
                                r0 = "\"";
                            }
                        }
                        sQLiteDatabaseA.setTransactionSuccessful();
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                            r0 = r0;
                        }
                    } catch (SQLiteDatabaseCorruptException e2) {
                        r0 = sQLiteDatabaseA;
                        h.a(d);
                        if (r0 != 0) {
                            r0.endTransaction();
                            r0 = r0;
                        }
                        g.a(d).b();
                    } catch (Throwable th) {
                        r2 = r0;
                        sQLiteDatabase = sQLiteDatabaseA;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                            r0 = r2;
                        }
                        g.a(d).b();
                    }
                } catch (Throwable th2) {
                }
            } catch (SQLiteDatabaseCorruptException e3) {
            } catch (Throwable th3) {
                sQLiteDatabase = null;
            }
            g.a(d).b();
        } catch (Throwable th4) {
            th = th4;
            r1 = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.util.List, java.util.List<java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.sqlite.SQLiteDatabase] */
    public void h() throws Throwable {
        ?? r1;
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        ?? th2 = 0;
        th2 = 0;
        try {
            try {
                try {
                    SQLiteDatabase sQLiteDatabaseA = g.a(d).a();
                    try {
                        sQLiteDatabaseA.beginTransaction();
                        if (this.j.size() > 0) {
                            for (int i = 0; i < this.j.size(); i++) {
                                sQLiteDatabaseA.execSQL("delete from __et where rowid=" + this.j.get(i));
                            }
                        }
                        th2 = this.j;
                        th2.clear();
                        sQLiteDatabaseA.setTransactionSuccessful();
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                        }
                    } catch (SQLiteDatabaseCorruptException e2) {
                        th2 = sQLiteDatabaseA;
                        h.a(d);
                        if (th2 != 0) {
                            th2.endTransaction();
                        }
                    } catch (Throwable th3) {
                        sQLiteDatabase = sQLiteDatabaseA;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                        g.a(d).b();
                    }
                } catch (Throwable th4) {
                    r1 = th2;
                    th = th4;
                }
            } catch (SQLiteDatabaseCorruptException e3) {
            } catch (Throwable th5) {
                sQLiteDatabase = null;
            }
        } catch (Throwable th6) {
            th2 = th6;
        }
        g.a(d).b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.database.sqlite.SQLiteDatabase] */
    public void i() throws Throwable {
        ?? r0;
        SQLiteDatabase sQLiteDatabaseA;
        ?? th = 0;
        th = 0;
        Throwable th2 = null;
        try {
            try {
                try {
                    sQLiteDatabaseA = g.a(d).a();
                    try {
                        sQLiteDatabaseA.beginTransaction();
                        th = "delete from __er";
                        sQLiteDatabaseA.execSQL("delete from __er");
                        sQLiteDatabaseA.setTransactionSuccessful();
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                            th = th;
                        }
                    } catch (SQLiteDatabaseCorruptException e2) {
                        th = sQLiteDatabaseA;
                        h.a(d);
                        if (th != 0) {
                            th.endTransaction();
                            th = th;
                        }
                        g.a(d).b();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                            th = th2;
                        }
                        g.a(d).b();
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (SQLiteDatabaseCorruptException e3) {
            } catch (Throwable th5) {
                sQLiteDatabaseA = null;
            }
            g.a(d).b();
        } catch (Throwable th6) {
            th = th6;
            r0 = th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v18, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v21, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v22 */
    public void j() throws Throwable {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase th = TextUtils.isEmpty(this.k);
        try {
            try {
                if (th == 0) {
                    try {
                        th = g.a(d).a();
                        try {
                            th.beginTransaction();
                            th.execSQL("delete from __er where __i=\"" + this.k + "\"");
                            th.execSQL("delete from __et where __i=\"" + this.k + "\"");
                            th.setTransactionSuccessful();
                            if (th != 0) {
                                th.endTransaction();
                            }
                        } catch (SQLiteDatabaseCorruptException e2) {
                            th = th;
                            h.a(d);
                            if (th != 0) {
                                th.endTransaction();
                            }
                        } catch (Throwable th2) {
                            sQLiteDatabase = th;
                            if (sQLiteDatabase != 0) {
                                sQLiteDatabase.endTransaction();
                            }
                            g.a(d).b();
                            this.k = null;
                        }
                    } catch (SQLiteDatabaseCorruptException e3) {
                        th = 0;
                    } catch (Throwable th3) {
                        th = th3;
                        th = 0;
                        if (th != 0) {
                            try {
                                th.endTransaction();
                            } catch (Throwable th4) {
                            }
                        }
                        g.a(d).b();
                        throw th;
                    }
                    g.a(d).b();
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
        }
        this.k = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [android.database.sqlite.SQLiteDatabase] */
    public void a(boolean z, String str) throws Throwable {
        ?? r0;
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        ?? th2 = 0;
        th2 = 0;
        try {
            try {
                try {
                    SQLiteDatabase sQLiteDatabaseA = g.a(d).a();
                    try {
                        sQLiteDatabaseA.beginTransaction();
                        boolean zIsEmpty = TextUtils.isEmpty(str);
                        th2 = zIsEmpty;
                        if (!zIsEmpty) {
                            sQLiteDatabaseA.execSQL("delete from __er where __i=\"" + str + "\"");
                            sQLiteDatabaseA.execSQL("delete from __et where __i=\"" + str + "\"");
                            this.j.clear();
                            String str2 = "delete from __sd where __ii=\"" + str + "\"";
                            sQLiteDatabaseA.execSQL(str2);
                            th2 = str2;
                        }
                        sQLiteDatabaseA.setTransactionSuccessful();
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                        }
                    } catch (SQLiteDatabaseCorruptException e2) {
                        th2 = sQLiteDatabaseA;
                        h.a(d);
                        if (th2 != 0) {
                            th2.endTransaction();
                        }
                    } catch (Throwable th3) {
                        sQLiteDatabase = sQLiteDatabaseA;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                        g.a(d).b();
                    }
                } catch (Throwable th4) {
                    r0 = th2;
                    th = th4;
                }
            } catch (SQLiteDatabaseCorruptException e3) {
            } catch (Throwable th5) {
                sQLiteDatabase = null;
            }
        } catch (Throwable th6) {
            th2 = th6;
        }
        g.a(d).b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public void b(String str) throws Throwable {
        ?? r1;
        SQLiteDatabase sQLiteDatabase;
        ?? r0 = 0;
        r0 = 0;
        r0 = 0;
        ?? r2 = 0;
        r0 = 0;
        try {
            try {
                try {
                    SQLiteDatabase sQLiteDatabaseA = g.a(d).a();
                    try {
                        sQLiteDatabaseA.beginTransaction();
                        boolean zIsEmpty = TextUtils.isEmpty(str);
                        r0 = zIsEmpty;
                        if (!zIsEmpty) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("delete from __is where __ii=\"");
                            sb.append(str);
                            sb.append("\"");
                            sQLiteDatabaseA.execSQL(sb.toString());
                            r0 = sb;
                        }
                        sQLiteDatabaseA.setTransactionSuccessful();
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                            r0 = r0;
                        }
                    } catch (SQLiteDatabaseCorruptException e2) {
                        r0 = sQLiteDatabaseA;
                        h.a(d);
                        if (r0 != 0) {
                            r0.endTransaction();
                            r0 = r0;
                        }
                        g.a(d).b();
                    } catch (Throwable th) {
                        th = th;
                        r1 = sQLiteDatabaseA;
                        if (r1 != 0) {
                            try {
                                r1.endTransaction();
                            } catch (Throwable th2) {
                            }
                        }
                        g.a(d).b();
                        throw th;
                    }
                } catch (Throwable th3) {
                }
            } catch (SQLiteDatabaseCorruptException e3) {
            } catch (Throwable th4) {
                sQLiteDatabase = null;
            }
            g.a(d).b();
        } catch (Throwable th5) {
            th = th5;
            r1 = r0;
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(d, g);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = PreferenceWrapper.getDefault(d).getString(g, null);
                    if (TextUtils.isEmpty(multiProcessSP)) {
                        multiProcessSP = UMUtils.genId();
                    }
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(d, g, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String strSubstring = multiProcessSP.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < strSubstring.length(); i++) {
                        char cCharAt = strSubstring.charAt(i);
                        if (Character.isDigit(cCharAt)) {
                            if (Integer.parseInt(Character.toString(cCharAt)) == 0) {
                                sb.append(0);
                            } else {
                                sb.append(10 - Integer.parseInt(Character.toString(cCharAt)));
                            }
                        } else {
                            sb.append(cCharAt);
                        }
                    }
                    e = sb.toString();
                }
                if (!TextUtils.isEmpty(e)) {
                    e += new StringBuilder(e).reverse().toString();
                    String multiProcessSP2 = UMUtils.getMultiProcessSP(d, h);
                    if (TextUtils.isEmpty(multiProcessSP2)) {
                        UMUtils.setMultiProcessSP(d, h, c(f));
                    } else if (!f.equals(d(multiProcessSP2))) {
                        b(true, false);
                        a(true, false);
                        h();
                        i();
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), e.getBytes()), 0);
        } catch (Exception e2) {
            return null;
        }
    }

    public String d(String str) {
        try {
            return TextUtils.isEmpty(e) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), e.getBytes()));
        } catch (Exception e2) {
            if (Build.VERSION.SDK_INT >= 29 && !TextUtils.isEmpty(str)) {
                try {
                    new JSONObject(str);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> UMStoreManager decrypt failed, return origin data.");
                    return str;
                } catch (Throwable th) {
                    return null;
                }
            }
            return null;
        }
    }
}
