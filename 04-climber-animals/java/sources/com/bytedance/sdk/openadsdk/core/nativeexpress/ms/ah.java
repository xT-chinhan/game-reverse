package com.bytedance.sdk.openadsdk.core.nativeexpress.ms;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static int f2973ms = 20;
    private static volatile ah xr;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.component.adexpress.ms.ah.ah> ka;
    private final Object ah = new Object();
    private final LruCache<String, ms> d = new LruCache<String, ms>(f2973ms) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ms.ah.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, ms msVar) {
            return 1;
        }
    };
    private AtomicBoolean c = new AtomicBoolean(false);

    public static String ah() {
        return "CREATE TABLE IF NOT EXISTS ugen_template (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , rit TEXT , update_time TEXT)";
    }

    private ah() {
    }

    public static ah ms() {
        if (xr == null) {
            synchronized (ah.class) {
                if (xr == null) {
                    xr = new ah();
                }
            }
        }
        return xr;
    }

    ms ms(String str, String str2) {
        ms msVar;
        ms msVarMs;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.ah) {
            msVar = this.d.get(str);
        }
        if (msVar != null) {
            if (TextUtils.equals(str2, msVar.xr())) {
                return msVar;
            }
            ah(str2);
            return null;
        }
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.ms.ms.query(re.getContext(), "ugen_template", null, "id=? AND md5=?", new String[]{str, str2}, null, null, null);
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
                int columnIndex3 = cursorQuery.getColumnIndex("url");
                int columnIndex4 = cursorQuery.getColumnIndex("data");
                int columnIndex5 = cursorQuery.getColumnIndex("update_time");
                if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                    int columnIndex6 = cursorQuery.getColumnIndex("rit");
                    String string = cursorQuery.getString(columnIndex);
                    String string2 = cursorQuery.getString(columnIndex2);
                    msVarMs = new ms().ms(string).xr(string2).d(cursorQuery.getString(columnIndex4)).ah(cursorQuery.getString(columnIndex3)).ka(columnIndex6 != -1 ? cursorQuery.getString(columnIndex6) : null).ms(Long.valueOf(cursorQuery.getLong(columnIndex5)));
                    synchronized (this.ah) {
                        this.d.put(string, msVarMs);
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
            return msVarMs;
        } catch (Throwable th) {
            try {
                sl.ah("UGTmplDbHelper", "getGgenTemplate error", th);
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return null;
    }

    void ms(ms msVar, boolean z) {
        if (msVar == null || TextUtils.isEmpty(msVar.ms())) {
            return;
        }
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.ms.ms.query(re.getContext(), "ugen_template", null, "id=?", new String[]{msVar.ms()}, null, null, null);
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
        contentValues.put("id", msVar.ms());
        contentValues.put("md5", msVar.xr());
        contentValues.put("url", msVar.ah());
        contentValues.put("data", msVar.ka());
        contentValues.put("rit", msVar.c());
        contentValues.put("update_time", msVar.d());
        if (z2) {
            com.bytedance.sdk.openadsdk.core.multipro.ms.ms.update(re.getContext(), "ugen_template", contentValues, "id=?", new String[]{msVar.ms()});
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.ms.ms.insert(re.getContext(), "ugen_template", contentValues);
        }
        synchronized (this.ah) {
            this.d.put(msVar.ms(), msVar);
        }
        if (z) {
            return;
        }
        try {
            if (this.ka == null) {
                this.ka = new ConcurrentHashMap<>();
            }
            com.bytedance.sdk.component.adexpress.ms.ah.ah ahVar = new com.bytedance.sdk.component.adexpress.ms.ah.ah(msVar.c(), msVar.ms(), msVar.xr());
            this.ka.put(msVar.ms(), ahVar);
            if (string != null) {
                com.bytedance.sdk.openadsdk.core.ah.xr.ms().delete(string, ahVar.xr(), true);
            }
            com.bytedance.sdk.openadsdk.core.ah.xr.ms().update(msVar.c(), ahVar, true);
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00e1 A[DONT_GENERATE] */
    List<ms> xr() {
        boolean z = this.c.get();
        this.c.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.ms.ms.query(re.getContext(), "ugen_template", null, null, null, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        int columnIndex = cursorQuery.getColumnIndex("id");
                        int columnIndex2 = cursorQuery.getColumnIndex("md5");
                        int columnIndex3 = cursorQuery.getColumnIndex("url");
                        int columnIndex4 = cursorQuery.getColumnIndex("data");
                        int columnIndex5 = cursorQuery.getColumnIndex("update_time");
                        if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                            int columnIndex6 = cursorQuery.getColumnIndex("rit");
                            String string = columnIndex6 != -1 ? cursorQuery.getString(columnIndex6) : null;
                            String string2 = cursorQuery.getString(columnIndex);
                            String string3 = cursorQuery.getString(columnIndex2);
                            String string4 = cursorQuery.getString(columnIndex3);
                            ms msVarMs = new ms().ms(string2).xr(string3).ah(string4).d(cursorQuery.getString(columnIndex4)).ka(string).ms(Long.valueOf(cursorQuery.getLong(columnIndex5)));
                            arrayList.add(msVarMs);
                            synchronized (this.ah) {
                                this.d.put(string2, msVarMs);
                            }
                            if (!z) {
                                if (this.ka == null) {
                                    this.ka = new ConcurrentHashMap<>();
                                }
                                if (string2 != null && !this.ka.contains(string2)) {
                                    this.ka.put(string2, new com.bytedance.sdk.component.adexpress.ms.ah.ah(string, string2, string3));
                                }
                            }
                        }
                    } while (cursorQuery.moveToNext());
                }
                if (cursorQuery != null) {
                }
            } catch (Throwable th) {
                try {
                    sl.ah("UGTmplDbHelper", "getUgenTemplate error", th);
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
    Set<ms> ms(String str) {
        ms msVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.ms.ms.query(re.getContext(), "ugen_template", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        int columnIndex = cursorQuery.getColumnIndex("id");
                        if (columnIndex != -1) {
                            String string = cursorQuery.getString(columnIndex);
                            if (!TextUtils.isEmpty(string)) {
                                synchronized (this.ah) {
                                    msVar = this.d.get(string);
                                }
                                if (msVar != null) {
                                    hashSet.add(msVar);
                                } else {
                                    ms msVar2 = new ms();
                                    int columnIndex2 = cursorQuery.getColumnIndex("data");
                                    if (columnIndex2 != -1) {
                                        String string2 = cursorQuery.getString(columnIndex2);
                                        if (!TextUtils.isEmpty(string2)) {
                                            msVar2.d(string2);
                                            msVar2.ms(string);
                                            msVar2.ka(str);
                                            int columnIndex3 = cursorQuery.getColumnIndex("md5");
                                            int columnIndex4 = cursorQuery.getColumnIndex("url");
                                            int columnIndex5 = cursorQuery.getColumnIndex("update_time");
                                            if (columnIndex3 != -1) {
                                                msVar2.xr(cursorQuery.getString(columnIndex3));
                                            }
                                            if (columnIndex4 != -1) {
                                                msVar2.ah(cursorQuery.getString(columnIndex4));
                                            }
                                            if (columnIndex5 != -1) {
                                                msVar2.ms(Long.valueOf(cursorQuery.getLong(columnIndex5)));
                                            }
                                            hashSet.add(msVar2);
                                            synchronized (this.ah) {
                                                this.d.put(string, msVar2);
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
                    sl.ah("UGTmplDbHelper", "getUgenTemplateFormRit error", th);
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

    void ms(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                ah(strArr[i]);
                com.bytedance.sdk.openadsdk.core.multipro.ms.ms.delete(re.getContext(), "ugen_template", "id=?", new String[]{strArr[i]});
                xr(strArr[i]);
            }
        }
    }

    void xr(String str) {
        com.bytedance.sdk.component.adexpress.ms.ah.ah ahVar;
        try {
            if (this.ka == null || this.ka.isEmpty() || (ahVar = this.ka.get(str)) == null) {
                return;
            }
            String strMs = ahVar.ms();
            if (!TextUtils.isEmpty(strMs)) {
                com.bytedance.sdk.openadsdk.core.ah.xr.ms().delete(strMs, str, true);
            }
            this.ka.remove(str);
        } catch (Throwable unused) {
        }
    }

    private void ah(String str) {
        if (!TextUtils.isEmpty(str) && this.d.size() > 0) {
            synchronized (this.ah) {
                this.d.remove(str);
            }
        }
    }
}
