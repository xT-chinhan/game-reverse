package com.byazt.ysr;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.anythink.core.common.l.f;
import com.byazt.nf.rv;
import com.byazt.tk.k;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 68, 8})
public class s {
    public static int n = 20;
    public static volatile s qg;
    public volatile ConcurrentHashMap<String, com.byazt.px.s> l;
    public final Object s = new Object();
    public final LruCache<String, n> q = new LruCache<String, n>(n) { // from class: com.byazt.ysr.s.1
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, n nVar) {
            return 1;
        }
    };
    public AtomicBoolean w = new AtomicBoolean(false);

    public static String q() {
        return "CREATE TABLE IF NOT EXISTS ugen_template (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , rit TEXT , update_time TEXT)";
    }

    private s() {
    }

    public static s n() {
        if (qg == null) {
            synchronized (s.class) {
                if (qg == null) {
                    qg = new s();
                }
            }
        }
        return qg;
    }

    public void qg() {
        try {
            Cursor cursorQuery = com.byazt.xp.n.query(rv.getContext(), "ugen_template", null, "id=? AND md5=?", new String[]{"-1", "-1"}, null, null, null);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th) {
            k.n("UGTmplDbHelper", "preconnectUgenTmplSQLite error", th);
        }
    }

    public n n(String str, String str2) {
        n nVar;
        n nVarN;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.s) {
            nVar = this.q.get(str);
        }
        if (nVar != null) {
            if (TextUtils.equals(str2, nVar.qg())) {
                return nVar;
            }
            s(str2);
            return null;
        }
        Cursor cursorQuery = com.byazt.xp.n.query(rv.getContext(), "ugen_template", null, "id=? AND md5=?", new String[]{str, str2}, null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        try {
            if (!cursorQuery.moveToFirst()) {
                if (cursorQuery != null) {
                }
                return null;
            }
            do {
                int columnIndex = cursorQuery.getColumnIndex("id");
                int columnIndex2 = cursorQuery.getColumnIndex("md5");
                int columnIndex3 = cursorQuery.getColumnIndex(ImagesContract.URL);
                int columnIndex4 = cursorQuery.getColumnIndex(f.R);
                int columnIndex5 = cursorQuery.getColumnIndex(com.anythink.core.common.f.k.a.g);
                if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                    int columnIndex6 = cursorQuery.getColumnIndex("rit");
                    String string = cursorQuery.getString(columnIndex);
                    String string2 = cursorQuery.getString(columnIndex2);
                    nVarN = new n().n(string).qg(string2).q(cursorQuery.getString(columnIndex4)).s(cursorQuery.getString(columnIndex3)).l(columnIndex6 != -1 ? cursorQuery.getString(columnIndex6) : null).n(Long.valueOf(cursorQuery.getLong(columnIndex5)));
                    synchronized (this.s) {
                        this.q.put(string, nVarN);
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            } while (cursorQuery.moveToNext());
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return nVarN;
        } catch (Throwable th) {
            try {
                k.n("UGTmplDbHelper", "getGgenTemplate error", th);
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return null;
    }

    public void n(n nVar, boolean z) {
        if (nVar == null || TextUtils.isEmpty(nVar.n())) {
            return;
        }
        Cursor cursorQuery = com.byazt.xp.n.query(rv.getContext(), "ugen_template", null, "id=?", new String[]{nVar.n()}, null, null, null);
        boolean z2 = cursorQuery != null && cursorQuery.getCount() > 0;
        String string = null;
        if (z2) {
            try {
                string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("rit")) : null;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", nVar.n());
        contentValues.put("md5", nVar.qg());
        contentValues.put(ImagesContract.URL, nVar.s());
        contentValues.put(f.R, nVar.l());
        contentValues.put("rit", nVar.w());
        contentValues.put(com.anythink.core.common.f.k.a.g, nVar.q());
        if (z2) {
            com.byazt.xp.n.update(rv.getContext(), "ugen_template", contentValues, "id=?", new String[]{nVar.n()});
        } else {
            com.byazt.xp.n.insert(rv.getContext(), "ugen_template", contentValues);
        }
        synchronized (this.s) {
            this.q.put(nVar.n(), nVar);
        }
        if (z) {
            return;
        }
        try {
            if (this.l == null) {
                this.l = new ConcurrentHashMap<>();
            }
            com.byazt.px.s sVar = new com.byazt.px.s(nVar.w(), nVar.n(), nVar.qg());
            this.l.put(nVar.n(), sVar);
            if (string != null) {
                com.byazt.ed.n.n().delete(string, sVar.qg(), true);
            }
            com.byazt.ed.n.n().update(nVar.w(), sVar, true);
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00e1 A[DONT_GENERATE] */
    public List<n> s() {
        boolean z = this.w.get();
        this.w.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = com.byazt.xp.n.query(rv.getContext(), "ugen_template", null, null, null, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        int columnIndex = cursorQuery.getColumnIndex("id");
                        int columnIndex2 = cursorQuery.getColumnIndex("md5");
                        int columnIndex3 = cursorQuery.getColumnIndex(ImagesContract.URL);
                        int columnIndex4 = cursorQuery.getColumnIndex(f.R);
                        int columnIndex5 = cursorQuery.getColumnIndex(com.anythink.core.common.f.k.a.g);
                        if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                            int columnIndex6 = cursorQuery.getColumnIndex("rit");
                            String string = columnIndex6 != -1 ? cursorQuery.getString(columnIndex6) : null;
                            String string2 = cursorQuery.getString(columnIndex);
                            String string3 = cursorQuery.getString(columnIndex2);
                            String string4 = cursorQuery.getString(columnIndex3);
                            n nVarN = new n().n(string2).qg(string3).s(string4).q(cursorQuery.getString(columnIndex4)).l(string).n(Long.valueOf(cursorQuery.getLong(columnIndex5)));
                            arrayList.add(nVarN);
                            synchronized (this.s) {
                                this.q.put(string2, nVarN);
                            }
                            if (!z) {
                                if (this.l == null) {
                                    this.l = new ConcurrentHashMap<>();
                                }
                                if (string2 != null && !this.l.contains(string2)) {
                                    this.l.put(string2, new com.byazt.px.s(string, string2, string3));
                                }
                            }
                        }
                    } while (cursorQuery.moveToNext());
                }
                if (cursorQuery != null) {
                }
            } catch (Throwable th) {
                try {
                    k.n("UGTmplDbHelper", "getUgenTemplate error", th);
                    return arrayList;
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
        } else if (cursorQuery != null) {
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00cf A[DONT_GENERATE] */
    public Set<n> n(String str) {
        n nVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Cursor cursorQuery = com.byazt.xp.n.query(rv.getContext(), "ugen_template", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        int columnIndex = cursorQuery.getColumnIndex("id");
                        if (columnIndex != -1) {
                            String string = cursorQuery.getString(columnIndex);
                            if (!TextUtils.isEmpty(string)) {
                                synchronized (this.s) {
                                    nVar = this.q.get(string);
                                }
                                if (nVar != null) {
                                    hashSet.add(nVar);
                                } else {
                                    n nVar2 = new n();
                                    int columnIndex2 = cursorQuery.getColumnIndex(f.R);
                                    if (columnIndex2 != -1) {
                                        String string2 = cursorQuery.getString(columnIndex2);
                                        if (!TextUtils.isEmpty(string2)) {
                                            nVar2.q(string2);
                                            nVar2.n(string);
                                            nVar2.l(str);
                                            int columnIndex3 = cursorQuery.getColumnIndex("md5");
                                            int columnIndex4 = cursorQuery.getColumnIndex(ImagesContract.URL);
                                            int columnIndex5 = cursorQuery.getColumnIndex(com.anythink.core.common.f.k.a.g);
                                            if (columnIndex3 != -1) {
                                                nVar2.qg(cursorQuery.getString(columnIndex3));
                                            }
                                            if (columnIndex4 != -1) {
                                                nVar2.s(cursorQuery.getString(columnIndex4));
                                            }
                                            if (columnIndex5 != -1) {
                                                nVar2.n(Long.valueOf(cursorQuery.getLong(columnIndex5)));
                                            }
                                            hashSet.add(nVar2);
                                            synchronized (this.s) {
                                                this.q.put(string, nVar2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } while (cursorQuery.moveToNext());
                }
                if (cursorQuery != null) {
                }
            } catch (Throwable th) {
                try {
                    k.n("UGTmplDbHelper", "getUgenTemplateFormRit error", th);
                    return hashSet;
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
        } else if (cursorQuery != null) {
        }
        return hashSet;
    }

    public void n(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                s(strArr[i]);
                com.byazt.xp.n.delete(rv.getContext(), "ugen_template", "id=?", new String[]{strArr[i]});
                qg(strArr[i]);
            }
        }
    }

    public void qg(String str) {
        com.byazt.px.s sVar;
        try {
            if (this.l == null || this.l.isEmpty() || (sVar = this.l.get(str)) == null) {
                return;
            }
            String strN = sVar.n();
            if (!TextUtils.isEmpty(strN)) {
                com.byazt.ed.n.n().delete(strN, str, true);
            }
            this.l.remove(str);
        } catch (Throwable unused) {
        }
    }

    private void s(String str) {
        if (!TextUtils.isEmpty(str) && this.q.size() > 0) {
            synchronized (this.s) {
                this.q.remove(str);
            }
        }
    }
}
