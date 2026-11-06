package com.byazt.d;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.xlm.zo;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1027, 20})
public final class hn {
    public static volatile hn hw;
    public volatile SQLiteStatement c;
    public final x hn;
    public final SparseArray<Map<String, pr>> pr;
    public final Executor x;

    private hn(Context context) {
        SparseArray<Map<String, pr>> sparseArray = new SparseArray<>(2);
        this.pr = sparseArray;
        this.x = new com.byazt.fr.x(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new zo("/VideoProxyDB"));
        this.hn = new x(context.getApplicationContext());
        sparseArray.put(0, new ConcurrentHashMap());
        sparseArray.put(1, new ConcurrentHashMap());
    }

    public static hn pr(Context context) {
        if (hw == null) {
            synchronized (hn.class) {
                if (hw == null) {
                    hw = new hn(context);
                }
            }
        }
        return hw;
    }

    public pr query(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, pr> map = this.pr.get(i);
        pr prVar = map == null ? null : map.get(str);
        if (prVar != null) {
            return prVar;
        }
        try {
            Cursor cursorQuery = this.hn.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i)}, null, null, null, "1");
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0 && cursorQuery.moveToNext()) {
                    int columnIndex = cursorQuery.getColumnIndex("key");
                    String string = columnIndex != -1 ? cursorQuery.getString(columnIndex) : null;
                    int columnIndex2 = cursorQuery.getColumnIndex("mime");
                    String string2 = columnIndex2 != -1 ? cursorQuery.getString(columnIndex2) : null;
                    int columnIndex3 = cursorQuery.getColumnIndex("contentLength");
                    int i2 = columnIndex3 != -1 ? cursorQuery.getInt(columnIndex3) : -1;
                    int columnIndex4 = cursorQuery.getColumnIndex("extra");
                    prVar = new pr(string, string2, i2, i, columnIndex4 != -1 ? cursorQuery.getString(columnIndex4) : null);
                }
                cursorQuery.close();
            }
            if (prVar != null && map != null) {
                map.put(str, prVar);
            }
            return prVar;
        } catch (Throwable th) {
            return null;
        }
    }

    public void insert(final pr prVar) {
        if (prVar != null) {
            Map<String, pr> map = this.pr.get(prVar.x);
            if (map != null) {
                map.put(prVar.pr, prVar);
            }
            this.x.execute(new Runnable() { // from class: com.byazt.d.hn.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (hn.this.c != null) {
                            hn.this.c.clearBindings();
                        } else {
                            hn hnVar = hn.this;
                            hnVar.c = hnVar.hn.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        }
                        hn.this.c.bindString(1, prVar.pr);
                        hn.this.c.bindString(2, prVar.hw);
                        hn.this.c.bindLong(3, prVar.hn);
                        hn.this.c.bindLong(4, prVar.x);
                        hn.this.c.bindString(5, prVar.c);
                        hn.this.c.executeInsert();
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }

    public void delete(final String str, final int i) {
        if (!TextUtils.isEmpty(str)) {
            Map<String, pr> map = this.pr.get(i);
            if (map != null) {
                map.remove(str);
            }
            this.x.execute(new Runnable() { // from class: com.byazt.d.hn.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        hn.this.hn.getWritableDatabase().delete("video_http_header_t", "key=? AND flag=?", new String[]{str, String.valueOf(i)});
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }

    public void pr(Collection<String> collection, int i) {
        if (collection != null && !collection.isEmpty()) {
            int size = collection.size() + 1;
            String[] strArr = new String[size];
            int i2 = -1;
            Map<String, pr> map = this.pr.get(i);
            for (String str : collection) {
                if (map != null) {
                    map.remove(str);
                }
                i2++;
                strArr[i2] = str;
            }
            strArr[i2 + 1] = String.valueOf(i);
            try {
                this.hn.getWritableDatabase().delete("video_http_header_t", "key IN(" + hw(size) + ") AND flag=?", strArr);
            } catch (Throwable th) {
            }
        }
    }

    private String hw(int i) {
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

    public void pr(final int i) {
        Map<String, pr> map = this.pr.get(i);
        if (map != null) {
            map.clear();
        }
        this.x.execute(new Runnable() { // from class: com.byazt.d.hn.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    hn.this.hn.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i)});
                } catch (Throwable th) {
                }
            }
        });
    }
}
