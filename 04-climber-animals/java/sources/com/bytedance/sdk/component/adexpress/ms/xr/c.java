package com.bytedance.sdk.component.adexpress.ms.xr;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.utils.sl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static int f896ms = 2000;
    private static volatile c xr;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.component.adexpress.ms.ah.ah> ka;
    private final Object d = new Object();
    private AtomicBoolean c = new AtomicBoolean(false);
    private LruCache<String, com.bytedance.sdk.component.adexpress.ms.ah.xr> ab = new LruCache<String, com.bytedance.sdk.component.adexpress.ms.ah.xr>(f896ms) { // from class: com.bytedance.sdk.component.adexpress.ms.xr.c.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, com.bytedance.sdk.component.adexpress.ms.ah.xr xrVar) {
            return 1;
        }
    };
    private Set<String> ah = Collections.synchronizedSet(new HashSet());

    public static String ah() {
        return "CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)";
    }

    public static c ms() {
        if (xr == null) {
            synchronized (c.class) {
                if (xr == null) {
                    xr = new c();
                }
            }
        }
        return xr;
    }

    private c() {
    }

    com.bytedance.sdk.component.adexpress.ms.ah.xr ms(String str) {
        com.bytedance.sdk.component.adexpress.ms.ah.xr xrVar;
        com.bytedance.sdk.component.adexpress.ms.ah.xr xrVarMs;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().xr() == null) {
            return null;
        }
        synchronized (this.d) {
            xrVar = this.ab.get(String.valueOf(str));
        }
        if (xrVar != null) {
            return xrVar;
        }
        Cursor cursorQuery = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().xr().query("template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("rit"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("md5"));
                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                        String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                        xrVarMs = new com.bytedance.sdk.component.adexpress.ms.ah.xr().ms(string).xr(string2).ah(string3).d(string4).ka(string5).c(cursorQuery.getString(cursorQuery.getColumnIndex("version"))).ms(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("update_time"))));
                        synchronized (this.d) {
                            this.ab.put(string2, xrVarMs);
                        }
                        this.ah.add(string2);
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                    return xrVarMs;
                }
            } catch (Throwable th) {
                try {
                    sl.ah("TmplDbHelper", "getTemplate error", th);
                } finally {
                    cursorQuery.close();
                }
            }
        }
        return null;
    }

    Set<com.bytedance.sdk.component.adexpress.ms.ah.xr> xr(String str) {
        com.bytedance.sdk.component.adexpress.ms.ah.xr xrVar;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().xr() == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Cursor cursorQuery = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().xr().query("template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        if (!TextUtils.isEmpty(string)) {
                            synchronized (this.d) {
                                xrVar = this.ab.get(string);
                            }
                            if (xrVar != null) {
                                hashSet.add(xrVar);
                            } else {
                                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("md5"));
                                String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                                String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                                com.bytedance.sdk.component.adexpress.ms.ah.xr xrVarMs = new com.bytedance.sdk.component.adexpress.ms.ah.xr().ms(str).xr(string).ah(string2).d(string3).ka(string4).c(cursorQuery.getString(cursorQuery.getColumnIndex("version"))).ms(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("update_time"))));
                                hashSet.add(xrVarMs);
                                synchronized (this.d) {
                                    this.ab.put(string, xrVarMs);
                                }
                                this.ah.add(string);
                            }
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
            cursorQuery.close();
        }
        return hashSet;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00f0 A[DONT_GENERATE] */
    List<com.bytedance.sdk.component.adexpress.ms.ah.xr> xr() {
        if (com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().xr() == null) {
            return null;
        }
        boolean z = this.c.get();
        this.c.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().xr().query("template_diff_new", null, null, null, null, null, null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("rit"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("md5"));
                    String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                    String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                    String string6 = cursorQuery.getString(cursorQuery.getColumnIndex("version"));
                    arrayList.add(new com.bytedance.sdk.component.adexpress.ms.ah.xr().ms(string).xr(string2).ah(string3).d(string4).ka(string5).c(string6).ms(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("update_time")))));
                    synchronized (this.d) {
                        this.ab.put(string2, (com.bytedance.sdk.component.adexpress.ms.ah.xr) arrayList.get(arrayList.size() - 1));
                    }
                    this.ah.add(string2);
                    if (!z && com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().c() != null) {
                        if (this.ka == null) {
                            this.ka = new ConcurrentHashMap<>();
                        }
                        if (string2 != null && !this.ka.contains(string2)) {
                            this.ka.put(string2, new com.bytedance.sdk.component.adexpress.ms.ah.ah(string, string2, string3));
                        }
                    }
                } catch (Throwable th) {
                    try {
                        sl.ah("TmplDbHelper", "getTemplate error", th);
                    } finally {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                }
            }
            if (cursorQuery != null) {
            }
        }
        return arrayList;
    }

    void ms(com.bytedance.sdk.component.adexpress.ms.ah.xr xrVar, boolean z) {
        if (xrVar == null || com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().xr() == null || TextUtils.isEmpty(xrVar.xr())) {
            return;
        }
        Cursor cursorQuery = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().xr().query("template_diff_new", null, "id=?", new String[]{xrVar.xr()}, null, null, null);
        boolean z2 = cursorQuery != null && cursorQuery.getCount() > 0;
        String string = null;
        if (cursorQuery != null) {
            try {
                string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("rit")) : null;
                cursorQuery.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", xrVar.ms());
        contentValues.put("id", xrVar.xr());
        contentValues.put("md5", xrVar.ah());
        contentValues.put("url", xrVar.d());
        contentValues.put("data", xrVar.ka());
        contentValues.put("version", xrVar.c());
        contentValues.put("update_time", xrVar.ab());
        if (z2) {
            com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().xr().update("template_diff_new", contentValues, "id=?", new String[]{xrVar.xr()});
        } else {
            com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().xr().insert("template_diff_new", contentValues);
        }
        synchronized (this.d) {
            this.ab.put(xrVar.xr(), xrVar);
        }
        this.ah.add(xrVar.xr());
        if (z) {
            return;
        }
        try {
            if (com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().c() == null) {
                return;
            }
            if (this.ka == null) {
                this.ka = new ConcurrentHashMap<>();
            }
            com.bytedance.sdk.component.adexpress.ms.ah.ah ahVar = new com.bytedance.sdk.component.adexpress.ms.ah.ah(xrVar.ms(), xrVar.xr(), xrVar.ah());
            this.ka.put(xrVar.xr(), ahVar);
            if (string != null) {
                com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().c().delete(string, ahVar.xr());
            }
            com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().c().update(xrVar.ms(), ahVar);
        } catch (Throwable unused2) {
        }
    }

    void ms(Set<String> set) {
        if (set == null || set.isEmpty() || com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().xr() == null) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                d(strArr[i]);
                com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().xr().delete("template_diff_new", "id=?", new String[]{strArr[i]});
                ah(strArr[i]);
            }
        }
    }

    void ah(String str) {
        com.bytedance.sdk.component.adexpress.ms.ah.ah ahVar;
        try {
            if (this.ka == null || this.ka.isEmpty() || (ahVar = this.ka.get(str)) == null) {
                return;
            }
            String strMs = ahVar.ms();
            if (!TextUtils.isEmpty(strMs) && com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().c() != null) {
                com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().c().delete(strMs, str);
            }
            this.ka.remove(str);
        } catch (Throwable unused) {
        }
    }

    private void d(String str) {
        LruCache<String, com.bytedance.sdk.component.adexpress.ms.ah.xr> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.ab) == null || lruCache.size() <= 0) {
            return;
        }
        synchronized (this.d) {
            this.ab.remove(str);
        }
    }
}
