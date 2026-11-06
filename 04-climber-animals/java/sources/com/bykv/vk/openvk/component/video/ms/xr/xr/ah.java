package com.bykv.vk.openvk.component.video.ms.xr.xr;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.core.common.e.f;
import com.bytedance.sdk.component.ch.ch;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ah {
    private static volatile ah xr;
    private final d ah;
    private final Executor d;
    private volatile SQLiteStatement ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final SparseArray<Map<String, ms>> f108ms;

    private ah(Context context) {
        SparseArray<Map<String, ms>> sparseArray = new SparseArray<>(2);
        this.f108ms = sparseArray;
        this.d = new com.bytedance.sdk.component.ch.d.d(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ch(5, "video_proxy_db"));
        this.ah = new d(context.getApplicationContext());
        sparseArray.put(0, new ConcurrentHashMap());
        sparseArray.put(1, new ConcurrentHashMap());
    }

    public static ah ms(Context context) {
        if (xr == null) {
            synchronized (ah.class) {
                if (xr == null) {
                    xr = new ah(context);
                }
            }
        }
        return xr;
    }

    public ms query(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, ms> map = this.f108ms.get(i);
        ms msVar = map == null ? null : map.get(str);
        if (msVar != null) {
            return msVar;
        }
        try {
            Cursor cursorQuery = this.ah.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i)}, null, null, null, "1");
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0 && cursorQuery.moveToNext()) {
                    msVar = new ms(cursorQuery.getString(cursorQuery.getColumnIndex(f.a.b)), cursorQuery.getString(cursorQuery.getColumnIndex("mime")), cursorQuery.getInt(cursorQuery.getColumnIndex("contentLength")), i, cursorQuery.getString(cursorQuery.getColumnIndex("extra")));
                }
                cursorQuery.close();
            }
            if (msVar != null && map != null) {
                map.put(str, msVar);
            }
            return msVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void insert(final ms msVar) {
        if (msVar != null) {
            Map<String, ms> map = this.f108ms.get(msVar.d);
            if (map != null) {
                map.put(msVar.f112ms, msVar);
            }
            this.d.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.xr.xr.ah.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ah.this.ka != null) {
                            ah.this.ka.clearBindings();
                        } else {
                            ah ahVar = ah.this;
                            ahVar.ka = ahVar.ah.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        }
                        ah.this.ka.bindString(1, msVar.f112ms);
                        ah.this.ka.bindString(2, msVar.xr);
                        ah.this.ka.bindLong(3, msVar.ah);
                        ah.this.ka.bindLong(4, msVar.d);
                        ah.this.ka.bindString(5, msVar.ka);
                        ah.this.ka.executeInsert();
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
        Map<String, ms> map = this.f108ms.get(i);
        if (map != null) {
            map.remove(str);
        }
        this.d.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.xr.xr.ah.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ah.this.ah.getWritableDatabase().delete("video_http_header_t", "key=? AND flag=?", new String[]{str, String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void ms(Collection<String> collection, int i) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        int size = collection.size() + 1;
        String[] strArr = new String[size];
        Map<String, ms> map = this.f108ms.get(i);
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
            this.ah.getWritableDatabase().delete("video_http_header_t", "key IN(" + xr(size) + ") AND flag=?", strArr);
        } catch (Throwable unused) {
        }
    }

    private String xr(int i) {
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

    public void ms(final int i) {
        Map<String, ms> map = this.f108ms.get(i);
        if (map != null) {
            map.clear();
        }
        this.d.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.xr.xr.ah.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ah.this.ah.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }
}
