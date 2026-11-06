package com.byazt.ir;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.byazt.ca.ho;
import com.byazt.sd.a;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1250, 20})
public class hn {
    public static volatile hn hw;
    public static int pr = 20;
    public volatile ConcurrentHashMap<String, com.byazt.hfm.hn> c;
    public final Object hn = new Object();
    public final LruCache<String, pr> x = new LruCache<String, pr>(pr) { // from class: com.byazt.ir.hn.1
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, pr prVar) {
            return 1;
        }
    };
    public AtomicBoolean uc = new AtomicBoolean(false);

    private hn() {
    }

    public static hn pr() {
        if (hw == null) {
            synchronized (hn.class) {
                if (hw == null) {
                    hw = new hn();
                }
            }
        }
        return hw;
    }

    public void hw() {
        try {
            Cursor cursorQuery = com.byazt.ad.pr.query(a.getContext(), "ugen_template", null, "id=? AND md5=?", new String[]{"-1", "-1"}, null, null, null);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th) {
            ho.pr("UGTmplDbHelper", "preconnectUgenTmplSQLite error", th);
        }
    }

    public pr pr(String str, String str2) {
        pr prVar;
        pr prVarPr;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.hn) {
            prVar = this.x.get(str);
        }
        if (prVar != null) {
            if (TextUtils.equals(str2, prVar.hw())) {
                return prVar;
            }
            hn(str2);
            return null;
        }
        Cursor cursorQuery = com.byazt.ad.pr.query(a.getContext(), "ugen_template", null, "id=? AND md5=?", new String[]{str, str2}, null, null, null);
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
                int columnIndex3 = cursorQuery.getColumnIndex(BreakpointSQLiteKey.URL);
                int columnIndex4 = cursorQuery.getColumnIndex("data");
                int columnIndex5 = cursorQuery.getColumnIndex("update_time");
                if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                    int columnIndex6 = cursorQuery.getColumnIndex("rit");
                    String string = cursorQuery.getString(columnIndex);
                    String string2 = cursorQuery.getString(columnIndex2);
                    prVarPr = new pr().pr(string).hw(string2).x(cursorQuery.getString(columnIndex4)).hn(cursorQuery.getString(columnIndex3)).c(columnIndex6 != -1 ? cursorQuery.getString(columnIndex6) : null).pr(Long.valueOf(cursorQuery.getLong(columnIndex5)));
                    synchronized (this.hn) {
                        this.x.put(string, prVarPr);
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
            return prVarPr;
        } catch (Throwable th) {
            try {
                ho.pr("UGTmplDbHelper", "getGgenTemplate error", th);
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return null;
    }

    public void pr(pr prVar, boolean z) {
        if (prVar == null || TextUtils.isEmpty(prVar.pr())) {
            return;
        }
        Cursor cursorQuery = com.byazt.ad.pr.query(a.getContext(), "ugen_template", null, "id=?", new String[]{prVar.pr()}, null, null, null);
        boolean z2 = cursorQuery != null && cursorQuery.getCount() > 0;
        String string = null;
        if (z2) {
            try {
                if (cursorQuery.moveToFirst()) {
                    string = cursorQuery.getString(cursorQuery.getColumnIndex("rit"));
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", prVar.pr());
        contentValues.put("md5", prVar.hw());
        contentValues.put(BreakpointSQLiteKey.URL, prVar.hn());
        contentValues.put("data", prVar.c());
        contentValues.put("rit", prVar.uc());
        contentValues.put("update_time", prVar.x());
        if (z2) {
            com.byazt.ad.pr.update(a.getContext(), "ugen_template", contentValues, "id=?", new String[]{prVar.pr()});
        } else {
            com.byazt.ad.pr.insert(a.getContext(), "ugen_template", contentValues);
        }
        synchronized (this.hn) {
            this.x.put(prVar.pr(), prVar);
        }
        if (z) {
            return;
        }
        try {
            if (this.c == null) {
                this.c = new ConcurrentHashMap<>();
            }
            com.byazt.hfm.hn hnVar = new com.byazt.hfm.hn(prVar.uc(), prVar.pr(), prVar.hw());
            this.c.put(prVar.pr(), hnVar);
            if (string != null) {
                com.byazt.mp.hw.pr().delete(string, hnVar.hw(), true);
            }
            com.byazt.mp.hw.pr().update(prVar.uc(), hnVar, true);
        } catch (Throwable th2) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00e0 A[DONT_GENERATE] */
    public List<pr> hn() {
        boolean z = this.uc.get();
        this.uc.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = com.byazt.ad.pr.query(a.getContext(), "ugen_template", null, null, null, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        int columnIndex = cursorQuery.getColumnIndex("id");
                        int columnIndex2 = cursorQuery.getColumnIndex("md5");
                        int columnIndex3 = cursorQuery.getColumnIndex(BreakpointSQLiteKey.URL);
                        int columnIndex4 = cursorQuery.getColumnIndex("data");
                        int columnIndex5 = cursorQuery.getColumnIndex("update_time");
                        if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                            int columnIndex6 = cursorQuery.getColumnIndex("rit");
                            String string = null;
                            if (columnIndex6 != -1) {
                                string = cursorQuery.getString(columnIndex6);
                            }
                            String string2 = cursorQuery.getString(columnIndex);
                            String string3 = cursorQuery.getString(columnIndex2);
                            String string4 = cursorQuery.getString(columnIndex3);
                            String string5 = cursorQuery.getString(columnIndex4);
                            pr prVarPr = new pr().pr(string2).hw(string3).hn(string4).x(string5).c(string).pr(Long.valueOf(cursorQuery.getLong(columnIndex5)));
                            arrayList.add(prVarPr);
                            synchronized (this.hn) {
                                this.x.put(string2, prVarPr);
                            }
                            if (!z) {
                                if (this.c == null) {
                                    this.c = new ConcurrentHashMap<>();
                                }
                                if (string2 != null && !this.c.contains(string2)) {
                                    this.c.put(string2, new com.byazt.hfm.hn(string, string2, string3));
                                }
                            }
                        }
                    } while (cursorQuery.moveToNext());
                }
                if (cursorQuery != null) {
                }
            } catch (Throwable th) {
                try {
                    ho.pr("UGTmplDbHelper", "getUgenTemplate error", th);
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
    public Set<pr> pr(String str) {
        pr prVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Cursor cursorQuery = com.byazt.ad.pr.query(a.getContext(), "ugen_template", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        int columnIndex = cursorQuery.getColumnIndex("id");
                        if (columnIndex != -1) {
                            String string = cursorQuery.getString(columnIndex);
                            if (!TextUtils.isEmpty(string)) {
                                synchronized (this.hn) {
                                    prVar = this.x.get(string);
                                }
                                if (prVar != null) {
                                    hashSet.add(prVar);
                                } else {
                                    pr prVar2 = new pr();
                                    int columnIndex2 = cursorQuery.getColumnIndex("data");
                                    if (columnIndex2 != -1) {
                                        String string2 = cursorQuery.getString(columnIndex2);
                                        if (!TextUtils.isEmpty(string2)) {
                                            prVar2.x(string2);
                                            prVar2.pr(string);
                                            prVar2.c(str);
                                            int columnIndex3 = cursorQuery.getColumnIndex("md5");
                                            int columnIndex4 = cursorQuery.getColumnIndex(BreakpointSQLiteKey.URL);
                                            int columnIndex5 = cursorQuery.getColumnIndex("update_time");
                                            if (columnIndex3 != -1) {
                                                prVar2.hw(cursorQuery.getString(columnIndex3));
                                            }
                                            if (columnIndex4 != -1) {
                                                prVar2.hn(cursorQuery.getString(columnIndex4));
                                            }
                                            if (columnIndex5 != -1) {
                                                prVar2.pr(Long.valueOf(cursorQuery.getLong(columnIndex5)));
                                            }
                                            hashSet.add(prVar2);
                                            synchronized (this.hn) {
                                                this.x.put(string, prVar2);
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
                    ho.pr("UGTmplDbHelper", "getUgenTemplateFormRit error", th);
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

    public void pr(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                hn(strArr[i]);
                com.byazt.ad.pr.delete(a.getContext(), "ugen_template", "id=?", new String[]{strArr[i]});
                hw(strArr[i]);
            }
        }
    }

    public void hw(String str) {
        com.byazt.hfm.hn hnVar;
        try {
            if (this.c == null || this.c.isEmpty() || (hnVar = this.c.get(str)) == null) {
                return;
            }
            String strPr = hnVar.pr();
            if (!TextUtils.isEmpty(strPr)) {
                com.byazt.mp.hw.pr().delete(strPr, str, true);
            }
            this.c.remove(str);
        } catch (Throwable th) {
        }
    }

    private void hn(String str) {
        if (TextUtils.isEmpty(str) || this.x.size() <= 0) {
            return;
        }
        synchronized (this.hn) {
            this.x.remove(str);
        }
    }

    public static String x() {
        return new StringBuilder("CREATE TABLE IF NOT EXISTS ugen_template (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , rit TEXT , update_time TEXT)").toString();
    }
}
