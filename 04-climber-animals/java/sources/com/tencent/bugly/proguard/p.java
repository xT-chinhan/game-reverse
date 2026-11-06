package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.bz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class p {
    private static p a = null;
    private static q b = null;
    private static boolean c = false;

    private p(Context context, List<com.tencent.bugly.a> list) {
        b = new q(context, list);
    }

    public static synchronized p a(Context context, List<com.tencent.bugly.a> list) {
        if (a == null) {
            a = new p(context, list);
        }
        return a;
    }

    public static synchronized p a() {
        return a;
    }

    public final long a(String str, ContentValues contentValues, o oVar, boolean z) {
        return a(str, contentValues, (o) null);
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2, o oVar, boolean z) {
        return a(false, str, strArr, str2, null, null, null, null, null, null);
    }

    public final int a(String str, String str2, String[] strArr, o oVar, boolean z) {
        return a(str, str2, (String[]) null, (o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized long a(String str, ContentValues contentValues, o oVar) {
        long j;
        j = 0;
        try {
            SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase != null && contentValues != null) {
                long jReplace = writableDatabase.replace(str, bz.d, contentValues);
                if (jReplace >= 0) {
                    x.c("[Database] insert %s success.", str);
                } else {
                    x.d("[Database] replace %s error.", str);
                }
                j = jReplace;
            }
            if (oVar != null) {
                Long.valueOf(j);
            }
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                if (oVar != null) {
                }
            } catch (Throwable th2) {
                if (oVar != null) {
                    Long.valueOf(0L);
                }
                throw th2;
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Cursor a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, o oVar) {
        Cursor cursorQuery;
        cursorQuery = null;
        try {
            SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase != null) {
                cursorQuery = writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cursorQuery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int a(String str, String str2, String[] strArr, o oVar) {
        int iDelete;
        iDelete = 0;
        try {
            SQLiteDatabase writableDatabase = b.getWritableDatabase();
            iDelete = writableDatabase != null ? writableDatabase.delete(str, str2, strArr) : 0;
            if (oVar != null) {
                Integer.valueOf(iDelete);
            }
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                if (oVar != null) {
                }
            } catch (Throwable th2) {
                if (oVar != null) {
                    Integer.valueOf(0);
                }
                throw th2;
            }
        }
        return iDelete;
    }

    public final boolean a(int i, String str, byte[] bArr, o oVar, boolean z) {
        if (!z) {
            a aVar = new a(4, null);
            aVar.a(i, str, bArr);
            w.a().a(aVar);
            return true;
        }
        return a(i, str, bArr, (o) null);
    }

    public final Map<String, byte[]> a(int i, o oVar, boolean z) {
        return a(i, (o) null);
    }

    public final boolean a(int i, String str, o oVar, boolean z) {
        return a(MediaPlayer.MEDIA_PLAYER_OPTION_ROTATION, str, (o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, String str, byte[] bArr, o oVar) {
        try {
            r rVar = new r();
            rVar.a = i;
            rVar.f = str;
            rVar.e = System.currentTimeMillis();
            rVar.g = bArr;
            boolean zB = b(rVar);
            if (oVar == null) {
                return zB;
            }
            Boolean.valueOf(zB);
            return zB;
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            } finally {
                if (oVar != null) {
                    Boolean.valueOf(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, byte[]> a(int i, o oVar) {
        HashMap map = null;
        try {
            List<r> listC = c(i);
            if (listC == null) {
                return null;
            }
            HashMap map2 = new HashMap();
            try {
                for (r rVar : listC) {
                    byte[] bArr = rVar.g;
                    if (bArr != null) {
                        map2.put(rVar.f, bArr);
                    }
                }
                return map2;
            } catch (Throwable th) {
                th = th;
                map = map2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (x.a(th)) {
            return map;
        }
        th.printStackTrace();
        return map;
    }

    public final synchronized boolean a(r rVar) {
        ContentValues contentValuesC;
        if (rVar == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase == null || (contentValuesC = c(rVar)) == null) {
                return false;
            }
            long jReplace = writableDatabase.replace("t_lr", bz.d, contentValuesC);
            if (jReplace < 0) {
                return false;
            }
            x.c("[Database] insert %s success.", "t_lr");
            rVar.a = jReplace;
            return true;
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private synchronized boolean b(r rVar) {
        ContentValues contentValuesD;
        if (rVar == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase == null || (contentValuesD = d(rVar)) == null) {
                return false;
            }
            long jReplace = writableDatabase.replace("t_pf", bz.d, contentValuesD);
            if (jReplace < 0) {
                return false;
            }
            x.c("[Database] insert %s success.", "t_pf");
            rVar.a = jReplace;
            return true;
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00ad A[Catch: all -> 0x00b6, TRY_LEAVE, TryCatch #1 {all -> 0x00b6, blocks: (B:36:0x00a7, B:38:0x00ad), top: B:52:0x00a7, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b2 A[Catch: all -> 0x00bf, TRY_ENTER, TryCatch #4 {, blocks: (B:3:0x0001, B:14:0x0032, B:31:0x009e, B:40:0x00b2, B:43:0x00b9, B:44:0x00bc, B:36:0x00a7, B:38:0x00ad), top: B:58:0x0001, inners: #1 }] */
    public final synchronized List<r> a(int i) {
        String str;
        Cursor cursor;
        SQLiteDatabase writableDatabase = b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                try {
                    str = "_tp = " + i;
                } catch (Throwable th) {
                    th = th;
                    cursor = null;
                    try {
                        if (!x.a(th)) {
                            th.printStackTrace();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th2;
                    }
                }
            } else {
                str = null;
            }
            Cursor cursorQuery = writableDatabase.query("t_lr", null, str, null, null, null, null);
            if (cursorQuery == null) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursorQuery.moveToNext()) {
                    r rVarA = a(cursorQuery);
                    if (rVarA != null) {
                        arrayList.add(rVarA);
                    } else {
                        try {
                            sb.append(" or _id").append(" = ").append(cursorQuery.getLong(cursorQuery.getColumnIndex(bz.d)));
                        } catch (Throwable unused) {
                            x.d("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String string = sb.toString();
                if (string.length() > 0) {
                    x.d("[Database] deleted %s illegal data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", string.substring(4), null)));
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayList;
            } catch (Throwable th3) {
                cursor = cursorQuery;
                th = th3;
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
        }
        return null;
    }

    public final synchronized void a(List<r> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    SQLiteDatabase writableDatabase = b.getWritableDatabase();
                    if (writableDatabase != null) {
                        StringBuilder sb = new StringBuilder();
                        Iterator<r> it = list.iterator();
                        while (it.hasNext()) {
                            sb.append(" or _id").append(" = ").append(it.next().a);
                        }
                        String string = sb.toString();
                        if (string.length() > 0) {
                            string = string.substring(4);
                        }
                        sb.setLength(0);
                        try {
                            x.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", string, null)));
                        } catch (Throwable th) {
                            try {
                                if (x.a(th)) {
                                    return;
                                }
                                th.printStackTrace();
                                return;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final synchronized void b(int i) {
        String str;
        SQLiteDatabase writableDatabase = b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                try {
                    str = "_tp = " + i;
                } catch (Throwable th) {
                    if (x.a(th)) {
                        return;
                    }
                    th.printStackTrace();
                    return;
                }
            } else {
                str = null;
            }
            x.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", str, null)));
        }
    }

    private static ContentValues c(r rVar) {
        if (rVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (rVar.a > 0) {
                contentValues.put(bz.d, Long.valueOf(rVar.a));
            }
            contentValues.put(bz.e, Integer.valueOf(rVar.b));
            contentValues.put("_pc", rVar.c);
            contentValues.put("_th", rVar.d);
            contentValues.put("_tm", Long.valueOf(rVar.e));
            if (rVar.g != null) {
                contentValues.put("_dt", rVar.g);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static r a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            r rVar = new r();
            rVar.a = cursor.getLong(cursor.getColumnIndex(bz.d));
            rVar.b = cursor.getInt(cursor.getColumnIndex(bz.e));
            rVar.c = cursor.getString(cursor.getColumnIndex("_pc"));
            rVar.d = cursor.getString(cursor.getColumnIndex("_th"));
            rVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            rVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return rVar;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private synchronized List<r> c(int i) {
        Cursor cursorQuery;
        try {
            SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase != null) {
                String str = "_id = " + i;
                cursorQuery = writableDatabase.query("t_pf", null, str, null, null, null, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    ArrayList arrayList = new ArrayList();
                    while (cursorQuery.moveToNext()) {
                        r rVarB = b(cursorQuery);
                        if (rVarB != null) {
                            arrayList.add(rVarB);
                        } else {
                            try {
                                sb.append(" or _tp").append(" = ").append(cursorQuery.getString(cursorQuery.getColumnIndex(bz.e)));
                            } catch (Throwable unused) {
                                x.d("[Database] unknown id.", new Object[0]);
                            }
                        }
                    }
                    if (sb.length() > 0) {
                        sb.append(" and _id").append(" = ").append(i);
                        x.d("[Database] deleted %s illegal data %d.", "t_pf", Integer.valueOf(writableDatabase.delete("t_pf", str.substring(4), null)));
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    try {
                        if (!x.a(th)) {
                            th.printStackTrace();
                        }
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
            }
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(int i, String str, o oVar) {
        boolean z;
        String str2;
        z = false;
        try {
            SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase != null) {
                if (z.a(str)) {
                    str2 = "_id = " + i;
                } else {
                    str2 = "_id = " + i + " and _tp = \"" + str + "\"";
                }
                int iDelete = writableDatabase.delete("t_pf", str2, null);
                x.c("[Database] deleted %s data %d", "t_pf", Integer.valueOf(iDelete));
                if (iDelete > 0) {
                    z = true;
                }
            }
            if (oVar != null) {
                Boolean.valueOf(z);
            }
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                if (oVar != null) {
                }
            } catch (Throwable th2) {
                if (oVar != null) {
                    Boolean.valueOf(false);
                }
                throw th2;
            }
        }
        return z;
    }

    private static ContentValues d(r rVar) {
        if (rVar != null && !z.a(rVar.f)) {
            try {
                ContentValues contentValues = new ContentValues();
                if (rVar.a > 0) {
                    contentValues.put(bz.d, Long.valueOf(rVar.a));
                }
                contentValues.put(bz.e, rVar.f);
                contentValues.put("_tm", Long.valueOf(rVar.e));
                if (rVar.g != null) {
                    contentValues.put("_dt", rVar.g);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    private static r b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            r rVar = new r();
            rVar.a = cursor.getLong(cursor.getColumnIndex(bz.d));
            rVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            rVar.f = cursor.getString(cursor.getColumnIndex(bz.e));
            rVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return rVar;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: BUGLY */
    class a extends Thread {
        private int a;
        private o b;
        private String c;
        private ContentValues d;
        private boolean e;
        private String[] f;
        private String g;
        private String[] h;
        private String i;
        private String j;
        private String k;
        private String l;
        private String m;
        private String[] n;
        private int o;
        private String p;
        private byte[] q;

        public a(int i, o oVar) {
            this.a = i;
            this.b = oVar;
        }

        public final void a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.e = z;
            this.c = str;
            this.f = strArr;
            this.g = str2;
            this.h = strArr2;
            this.i = str3;
            this.j = str4;
            this.k = str5;
            this.l = str6;
        }

        public final void a(int i, String str, byte[] bArr) {
            this.o = i;
            this.p = str;
            this.q = bArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.a) {
                case 1:
                    p.this.a(this.c, this.d, this.b);
                    break;
                case 2:
                    p.this.a(this.c, this.m, this.n, this.b);
                    break;
                case 3:
                    p.this.a(this.e, this.c, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.b);
                    break;
                case 4:
                    p.this.a(this.o, this.p, this.q, this.b);
                    break;
                case 5:
                    p.this.a(this.o, this.b);
                    break;
                case 6:
                    p.this.a(this.o, this.p, this.b);
                    break;
            }
        }
    }
}
