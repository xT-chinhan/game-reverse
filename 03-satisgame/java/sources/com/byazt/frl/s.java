package com.byazt.frl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.core.common.f.e;
import com.byazt.qit.fs;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1654, 8})
public final class s {
    public static volatile s qg;
    public volatile SQLiteStatement l;
    public final SparseArray<Map<String, n>> n;
    public final Executor q;
    public final q s;

    private s(Context context) {
        SparseArray<Map<String, n>> sparseArray = new SparseArray<>(2);
        this.n = sparseArray;
        this.q = new com.byazt.xis.q(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new fs("/VideoProxyDB"));
        this.s = new q(context.getApplicationContext());
        sparseArray.put(0, new ConcurrentHashMap());
        sparseArray.put(1, new ConcurrentHashMap());
    }

    public static s n(Context context) {
        if (qg == null) {
            synchronized (s.class) {
                if (qg == null) {
                    qg = new s(context);
                }
            }
        }
        return qg;
    }

    public n query(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, n> map = this.n.get(i);
        n nVar = map == null ? null : map.get(str);
        if (nVar != null) {
            return nVar;
        }
        try {
            Cursor cursorQuery = this.s.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i)}, null, null, null, "1");
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0 && cursorQuery.moveToNext()) {
                    int columnIndex = cursorQuery.getColumnIndex(e.a.b);
                    String string = columnIndex != -1 ? cursorQuery.getString(columnIndex) : null;
                    int columnIndex2 = cursorQuery.getColumnIndex("mime");
                    String string2 = columnIndex2 != -1 ? cursorQuery.getString(columnIndex2) : null;
                    int columnIndex3 = cursorQuery.getColumnIndex("contentLength");
                    int i2 = columnIndex3 != -1 ? cursorQuery.getInt(columnIndex3) : -1;
                    int columnIndex4 = cursorQuery.getColumnIndex("extra");
                    nVar = new n(string, string2, i2, i, columnIndex4 != -1 ? cursorQuery.getString(columnIndex4) : null);
                }
                cursorQuery.close();
            }
            if (nVar != null && map != null) {
                map.put(str, nVar);
            }
            return nVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void insert(final n nVar) {
        if (nVar != null) {
            Map<String, n> map = this.n.get(nVar.q);
            if (map != null) {
                map.put(nVar.n, nVar);
            }
            this.q.execute(new Runnable() { // from class: com.byazt.frl.s.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (s.this.l != null) {
                            s.this.l.clearBindings();
                        } else {
                            s sVar = s.this;
                            sVar.l = sVar.s.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        }
                        s.this.l.bindString(1, nVar.n);
                        s.this.l.bindString(2, nVar.qg);
                        s.this.l.bindLong(3, nVar.s);
                        s.this.l.bindLong(4, nVar.q);
                        s.this.l.bindString(5, nVar.l);
                        s.this.l.executeInsert();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void delete(final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, n> map = this.n.get(i);
        if (map != null) {
            map.remove(str);
        }
        this.q.execute(new Runnable() { // from class: com.byazt.frl.s.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    s.this.s.getWritableDatabase().delete("video_http_header_t", "key=? AND flag=?", new String[]{str, String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void n(Collection<String> collection, int i) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        int size = collection.size() + 1;
        String[] strArr = new String[size];
        Map<String, n> map = this.n.get(i);
        int i2 = -1;
        for (String str : collection) {
            if (map != null) {
                map.remove(str);
            }
            i2++;
            strArr[i2] = str;
        }
        strArr[i2 + 1] = String.valueOf(i);
        try {
            this.s.getWritableDatabase().delete("video_http_header_t", "key IN(" + qg(size) + ") AND flag=?", strArr);
        } catch (Throwable unused) {
        }
    }

    private String qg(int i) {
        if (i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i << 1);
        sb.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public void n(final int i) {
        Map<String, n> map = this.n.get(i);
        if (map != null) {
            map.clear();
        }
        this.q.execute(new Runnable() { // from class: com.byazt.frl.s.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    s.this.s.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }
}
