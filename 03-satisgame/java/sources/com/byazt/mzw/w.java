package com.byazt.mzw;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.anythink.core.common.f.k;
import com.anythink.core.common.l.f;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1346, 13})
public class w {
    public static int n = 2000;
    public static volatile w qg;
    public volatile ConcurrentHashMap<String, com.byazt.px.s> l;
    public final Object q = new Object();
    public AtomicBoolean w = new AtomicBoolean(false);
    public LruCache<String, com.byazt.px.qg> x = new LruCache<String, com.byazt.px.qg>(n) { // from class: com.byazt.mzw.w.1
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, com.byazt.px.qg qgVar) {
            return 1;
        }
    };
    public Set<String> s = Collections.synchronizedSet(new HashSet());

    public static String s() {
        return "CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)";
    }

    public static w n() {
        if (qg == null) {
            synchronized (w.class) {
                if (qg == null) {
                    qg = new w();
                }
            }
        }
        return qg;
    }

    private w() {
    }

    public com.byazt.px.qg n(String str) {
        com.byazt.px.qg qgVar;
        com.byazt.px.qg qgVarN;
        if (TextUtils.isEmpty(str) || com.byazt.gkj.n.n().qg() == null) {
            return null;
        }
        synchronized (this.q) {
            qgVar = this.x.get(String.valueOf(str));
        }
        if (qgVar != null) {
            return qgVar;
        }
        Cursor cursorQuery = com.byazt.gkj.n.n().qg().query("template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("rit"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("md5"));
                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex(ImagesContract.URL));
                        String string5 = cursorQuery.getString(cursorQuery.getColumnIndex(f.R));
                        qgVarN = new com.byazt.px.qg().n(string).qg(string2).s(string3).q(string4).l(string5).w(cursorQuery.getString(cursorQuery.getColumnIndex("version"))).n(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex(k.a.g))));
                        synchronized (this.q) {
                            this.x.put(string2, qgVarN);
                        }
                        this.s.add(string2);
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                    return qgVarN;
                }
            } catch (Throwable th) {
                try {
                    com.byazt.tk.k.n("TmplDbHelper", "getTemplate error", th);
                } finally {
                    cursorQuery.close();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00e8  */
    public Set<com.byazt.px.qg> qg(String str) {
        com.byazt.px.qg qgVar;
        if (TextUtils.isEmpty(str) || com.byazt.gkj.n.n().qg() == null) {
            return Collections.emptySet();
        }
        Cursor cursorQuery = com.byazt.gkj.n.n().qg().query("template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    HashSet hashSet = new HashSet();
                    if (cursorQuery.moveToFirst()) {
                        do {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                            if (!TextUtils.isEmpty(string)) {
                                synchronized (this.q) {
                                    qgVar = this.x.get(string);
                                }
                                if (qgVar != null) {
                                    hashSet.add(qgVar);
                                } else {
                                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("md5"));
                                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex(ImagesContract.URL));
                                    String string4 = cursorQuery.getString(cursorQuery.getColumnIndex(f.R));
                                    com.byazt.px.qg qgVarN = new com.byazt.px.qg().n(str).qg(string).s(string2).q(string3).l(string4).w(cursorQuery.getString(cursorQuery.getColumnIndex("version"))).n(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex(k.a.g))));
                                    hashSet.add(qgVarN);
                                    synchronized (this.q) {
                                        this.x.put(string, qgVarN);
                                    }
                                    this.s.add(string);
                                }
                            }
                        } while (cursorQuery.moveToNext());
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return hashSet;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception unused) {
                if (cursorQuery != null) {
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } else if (cursorQuery != null) {
            cursorQuery.close();
        }
        return Collections.emptySet();
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00f0 A[DONT_GENERATE] */
    public List<com.byazt.px.qg> qg() {
        if (com.byazt.gkj.n.n().qg() == null) {
            return null;
        }
        boolean z = this.w.get();
        this.w.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = com.byazt.gkj.n.n().qg().query("template_diff_new", null, null, null, null, null, null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("rit"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("md5"));
                    String string4 = cursorQuery.getString(cursorQuery.getColumnIndex(ImagesContract.URL));
                    String string5 = cursorQuery.getString(cursorQuery.getColumnIndex(f.R));
                    String string6 = cursorQuery.getString(cursorQuery.getColumnIndex("version"));
                    arrayList.add(new com.byazt.px.qg().n(string).qg(string2).s(string3).q(string4).l(string5).w(string6).n(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex(k.a.g)))));
                    synchronized (this.q) {
                        this.x.put(string2, (com.byazt.px.qg) arrayList.get(arrayList.size() - 1));
                    }
                    this.s.add(string2);
                    if (!z && com.byazt.gkj.n.n().w() != null) {
                        if (this.l == null) {
                            this.l = new ConcurrentHashMap<>();
                        }
                        if (string2 != null && !this.l.contains(string2)) {
                            this.l.put(string2, new com.byazt.px.s(string, string2, string3));
                        }
                    }
                } catch (Throwable th) {
                    try {
                        com.byazt.tk.k.n("TmplDbHelper", "getTemplate error", th);
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

    public void n(com.byazt.px.qg qgVar, boolean z) {
        if (qgVar == null || com.byazt.gkj.n.n().qg() == null || TextUtils.isEmpty(qgVar.qg())) {
            return;
        }
        Cursor cursorQuery = com.byazt.gkj.n.n().qg().query("template_diff_new", null, "id=?", new String[]{qgVar.qg()}, null, null, null);
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
        contentValues.put("rit", qgVar.n());
        contentValues.put("id", qgVar.qg());
        contentValues.put("md5", qgVar.s());
        contentValues.put(ImagesContract.URL, qgVar.q());
        contentValues.put(f.R, qgVar.l());
        contentValues.put("version", qgVar.w());
        contentValues.put(k.a.g, qgVar.x());
        if (z2) {
            com.byazt.gkj.n.n().qg().update("template_diff_new", contentValues, "id=?", new String[]{qgVar.qg()});
        } else {
            com.byazt.gkj.n.n().qg().insert("template_diff_new", contentValues);
        }
        synchronized (this.q) {
            this.x.put(qgVar.qg(), qgVar);
        }
        this.s.add(qgVar.qg());
        if (z) {
            return;
        }
        try {
            if (com.byazt.gkj.n.n().w() == null) {
                return;
            }
            if (this.l == null) {
                this.l = new ConcurrentHashMap<>();
            }
            com.byazt.px.s sVar = new com.byazt.px.s(qgVar.n(), qgVar.qg(), qgVar.s());
            this.l.put(qgVar.qg(), sVar);
            if (string != null) {
                com.byazt.gkj.n.n().w().delete(string, sVar.qg());
            }
            com.byazt.gkj.n.n().w().update(qgVar.n(), sVar);
        } catch (Throwable unused2) {
        }
    }

    public void n(Set<String> set) {
        if (set == null || set.isEmpty() || com.byazt.gkj.n.n().qg() == null) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                q(strArr[i]);
                com.byazt.gkj.n.n().qg().delete("template_diff_new", "id=?", new String[]{strArr[i]});
                s(strArr[i]);
            }
        }
    }

    public void s(String str) {
        com.byazt.px.s sVar;
        try {
            if (this.l == null || this.l.isEmpty() || (sVar = this.l.get(str)) == null) {
                return;
            }
            String strN = sVar.n();
            if (!TextUtils.isEmpty(strN) && com.byazt.gkj.n.n().w() != null) {
                com.byazt.gkj.n.n().w().delete(strN, str);
            }
            this.l.remove(str);
        } catch (Throwable unused) {
        }
    }

    private void q(String str) {
        LruCache<String, com.byazt.px.qg> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.x) == null || lruCache.size() <= 0) {
            return;
        }
        synchronized (this.q) {
            this.x.remove(str);
        }
    }
}
