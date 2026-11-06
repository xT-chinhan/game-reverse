package com.smartdigimkt.z2;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends b {
    public static p c;
    public final String b;

    public p(d dVar) {
        super(dVar);
        this.b = p.class.getName();
    }

    public static p a(d dVar) {
        if (c == null) {
            synchronized (p.class) {
                if (c == null) {
                    c = new p(dVar);
                }
            }
        }
        return c;
    }

    public final synchronized void b(int i, String str, String str2) {
        com.smartdigimkt.q3.f.a().c(new n(this, str, i, str2));
    }

    public final synchronized com.smartdigimkt.b3.i a(int i, com.smartdigimkt.b3.i iVar, String str, int i2, int i3) {
        if (iVar == null) {
            try {
                iVar = a(i, str);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (iVar != null) {
            iVar.e += i2;
            iVar.d += i3;
            a(iVar);
        }
        return iVar;
    }

    public final synchronized com.smartdigimkt.b3.i a(int i, com.smartdigimkt.b3.i iVar, String str, long j) {
        if (iVar == null) {
            try {
                iVar = a(i, str);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (iVar != null) {
            iVar.c = j;
            a(iVar);
        }
        return iVar;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x007f A[Catch: all -> 0x0084, PHI: r1
      0x007f: PHI (r1v5 android.database.Cursor) = 
      (r1v2 android.database.Cursor)
      (r1v3 android.database.Cursor)
      (r1v4 android.database.Cursor)
      (r1v6 android.database.Cursor)
     binds: [B:15:0x006d, B:18:0x0073, B:24:0x007d, B:13:0x006a] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:25:0x007f, B:22:0x0079, B:23:0x007c, B:17:0x0070), top: B:31:0x0001, inners: #2 }] */
    public final synchronized ArrayList a(int i) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = a().query("offer_action_record", null, "type = ?", new String[]{String.valueOf(i)}, null, null, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    while (cursorQuery.moveToNext()) {
                        com.smartdigimkt.b3.i iVar = new com.smartdigimkt.b3.i(i, cursorQuery.getString(cursorQuery.getColumnIndex("unit_id")));
                        iVar.e = cursorQuery.getInt(cursorQuery.getColumnIndex("click_count"));
                        iVar.d = cursorQuery.getInt(cursorQuery.getColumnIndex("show_count"));
                        iVar.c = cursorQuery.getLong(cursorQuery.getColumnIndex("expire_time"));
                        arrayList.add(iVar);
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Exception unused) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (OutOfMemoryError unused2) {
            System.gc();
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable unused3) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        return arrayList;
    }

    public final synchronized void a(com.smartdigimkt.b3.i iVar) {
        if (b() != null) {
            com.smartdigimkt.q3.f.a().c(new o(this, iVar));
        }
    }

    public final synchronized void a(int i, String str, String str2) {
        if (b() == null) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(com.anythink.core.common.f.i.a.d, str);
            contentValues.put("type", Integer.valueOf(i));
            contentValues.put("unit_id", str2);
            com.smartdigimkt.b3.i iVarA = a(i, str2);
            if (iVarA != null) {
                contentValues.put("click_count", Integer.valueOf(iVarA.e));
                contentValues.put("show_count", Integer.valueOf(iVarA.d));
                contentValues.put("expire_time", Long.valueOf(iVarA.c));
            } else {
                contentValues.put("click_count", (Integer) 0);
                contentValues.put("show_count", (Integer) 0);
                contentValues.put("expire_time", (Integer) (-1));
            }
            b().insert("offer_action_record", null, contentValues);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x007b A[Catch: all -> 0x007f, PHI: r1
      0x007b: PHI (r1v5 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v4 android.database.Cursor), (r1v6 android.database.Cursor) binds: [B:17:0x0067, B:21:0x006e, B:28:0x0079] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #7 {, blocks: (B:9:0x005a, B:13:0x0061, B:29:0x007b, B:25:0x0074, B:26:0x0077, B:20:0x006b), top: B:41:0x0002, inners: #0 }] */
    public final synchronized com.smartdigimkt.b3.i a(int i, String str) {
        Cursor cursorQuery;
        try {
            cursorQuery = a().query("offer_action_record", null, "type=? and unit_id = ?", new String[]{String.valueOf(i), str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToNext();
                        com.smartdigimkt.b3.i iVar = new com.smartdigimkt.b3.i(i, str);
                        iVar.e = cursorQuery.getInt(cursorQuery.getColumnIndex("click_count"));
                        iVar.d = cursorQuery.getInt(cursorQuery.getColumnIndex("show_count"));
                        iVar.c = cursorQuery.getLong(cursorQuery.getColumnIndex("expire_time"));
                        cursorQuery.close();
                        cursorQuery.close();
                        return iVar;
                    }
                } catch (Exception unused) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                } catch (OutOfMemoryError unused2) {
                    try {
                        System.gc();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
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
                    return null;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Exception unused4) {
            cursorQuery = null;
        } catch (OutOfMemoryError unused5) {
            cursorQuery = null;
        } catch (Throwable unused6) {
            cursorQuery = null;
        }
    }
}
