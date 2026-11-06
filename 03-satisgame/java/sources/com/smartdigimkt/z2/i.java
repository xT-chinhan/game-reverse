package com.smartdigimkt.z2;

import android.database.Cursor;
import com.smartdigimkt.t2.t;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends b {
    public static volatile i b;

    public i(d dVar) {
        super(dVar);
    }

    public final synchronized t a(String str, String str2) {
        Cursor cursorQuery;
        try {
            cursorQuery = a().query("dsp_offer_show_record", null, "dsp_id = ?  AND dsp_offer_id = ? ", new String[]{str, str2}, null, null, null);
            try {
                ArrayList arrayListA = a(cursorQuery);
                cursorQuery.close();
                if (arrayListA.size() > 0) {
                    t tVar = (t) arrayListA.get(0);
                    cursorQuery.close();
                    return tVar;
                }
            } catch (Exception unused) {
                if (cursorQuery != null) {
                }
                return null;
            } catch (OutOfMemoryError unused2) {
                try {
                    System.gc();
                    if (cursorQuery != null) {
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
                }
                return null;
            }
        } catch (Exception unused4) {
            cursorQuery = null;
        } catch (OutOfMemoryError unused5) {
            cursorQuery = null;
        } catch (Throwable unused6) {
            cursorQuery = null;
        }
        cursorQuery.close();
        return null;
    }

    public final synchronized ArrayList a(Cursor cursor) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                try {
                    t tVar = new t();
                    tVar.a = cursor.getString(cursor.getColumnIndex("dsp_id"));
                    tVar.b = cursor.getString(cursor.getColumnIndex("dsp_offer_id"));
                    cursor.getInt(cursor.getColumnIndex("show_limit"));
                    tVar.c = cursor.getInt(cursor.getColumnIndex("show_count"));
                    arrayList.add(tVar);
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }
}
