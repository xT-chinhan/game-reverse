package com.smartdigimkt.l1;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static volatile e c;
    public static final c d = new c();
    public final Context a;
    public final ConcurrentHashMap b = new ConcurrentHashMap();

    public e(Context context) {
        this.a = context.getApplicationContext();
    }

    public static e a(Context context) {
        if (c == null) {
            synchronized (e.class) {
                if (c == null) {
                    c = new e(context);
                }
            }
        }
        return c;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00c9 A[Catch: all -> 0x00cd, PHI: r3
      0x00c9: PHI (r3v9 android.database.Cursor) = 
      (r3v6 android.database.Cursor)
      (r3v7 android.database.Cursor)
      (r3v8 android.database.Cursor)
      (r3v15 android.database.Cursor)
     binds: [B:21:0x00b5, B:25:0x00bc, B:32:0x00c7, B:18:0x00b1] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #6 {, blocks: (B:15:0x00ab, B:33:0x00c9, B:29:0x00c2, B:30:0x00c5, B:24:0x00b9), top: B:50:0x0035, inners: #7 }] */
    public final com.smartdigimkt.h0.c a(com.smartdigimkt.e3.a aVar) {
        com.smartdigimkt.h0.c cVar;
        Cursor cursorQuery;
        String str = ((SimpleDateFormat) d.get()).format(new Date(System.currentTimeMillis()));
        com.smartdigimkt.h0.c cVar2 = (com.smartdigimkt.h0.c) this.b.get(aVar.a);
        if (cVar2 == null) {
            Context context = this.a;
            if (com.smartdigimkt.g0.a.b == null) {
                com.smartdigimkt.g0.a.b = new com.smartdigimkt.g0.a(context);
            }
            com.smartdigimkt.g0.a aVar2 = com.smartdigimkt.g0.a.b;
            String str2 = aVar.a;
            synchronized (aVar2) {
                cVar = null;
                try {
                    cursorQuery = com.smartdigimkt.g0.b.a(aVar2.a).getReadableDatabase().query("my_offer_cap_pacing", null, "offer_id = ?", new String[]{str2}, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.getCount() > 0) {
                                cursorQuery.moveToNext();
                                com.smartdigimkt.h0.c cVar3 = new com.smartdigimkt.h0.c();
                                cVar3.a = cursorQuery.getString(cursorQuery.getColumnIndex("offer_id"));
                                cVar3.d = cursorQuery.getInt(cursorQuery.getColumnIndex("show_num"));
                                cVar3.e = cursorQuery.getLong(cursorQuery.getColumnIndex("show_time"));
                                cVar3.f = cursorQuery.getString(cursorQuery.getColumnIndex("record_date"));
                                cVar3.b = cursorQuery.getInt(cursorQuery.getColumnIndex("offer_cap"));
                                cVar3.c = cursorQuery.getLong(cursorQuery.getColumnIndex("offer_pacing"));
                                cursorQuery.close();
                                cursorQuery.close();
                                cVar = cVar3;
                            }
                        } catch (Exception unused) {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        } catch (OutOfMemoryError unused2) {
                            try {
                                System.gc();
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                            } catch (Throwable th) {
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                throw th;
                            }
                        } catch (Throwable unused3) {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Exception unused4) {
                    cursorQuery = null;
                } catch (OutOfMemoryError unused5) {
                    cursorQuery = null;
                } catch (Throwable unused6) {
                    cursorQuery = null;
                }
            }
            if (cVar == null) {
                cVar2 = new com.smartdigimkt.h0.c();
                cVar2.a = aVar.a;
                cVar2.b = aVar.c0;
                cVar2.c = aVar.d0;
                cVar2.e = 0L;
                cVar2.d = 0;
                cVar2.f = str;
            } else {
                cVar2 = cVar;
            }
            this.b.put(aVar.a, cVar2);
        }
        if (!TextUtils.equals(str, cVar2.f)) {
            cVar2.f = str;
            cVar2.d = 0;
        }
        return cVar2;
    }
}
