package com.byazt.bh;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.byazt.nf.rv;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 125, 18})
public class l {
    public static final Object n = new Object();

    public static void insert(ContentValues contentValues) {
        if (contentValues == null) {
            return;
        }
        com.byazt.xp.n.insert(rv.getContext(), "union_tmax_record", contentValues);
    }

    public static void n(ContentValues contentValues) {
        if (contentValues == null) {
            return;
        }
        String asString = contentValues.getAsString("load_id");
        if (TextUtils.isEmpty(asString)) {
            return;
        }
        synchronized (n) {
            if (n(asString)) {
                com.byazt.xp.n.update(rv.getContext(), "union_tmax_record", contentValues, "load_id=?", new String[]{asString});
            } else {
                com.byazt.xp.n.insert(rv.getContext(), "union_tmax_record", contentValues);
            }
        }
    }

    private static boolean n(String str) {
        Cursor cursorQuery;
        boolean z = false;
        try {
            cursorQuery = com.byazt.xp.n.query(rv.getContext(), "union_tmax_record", new String[]{"load_id"}, "load_id=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        z = true;
                    }
                } catch (Throwable unused) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return false;
                }
            }
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable unused3) {
                }
            }
            return z;
        } catch (Throwable unused4) {
            cursorQuery = null;
        }
    }

    public static Cursor n(int i, String str, long j, String str2) {
        if (TextUtils.isEmpty(str) || j <= 0) {
            return null;
        }
        return com.byazt.xp.n.query(rv.getContext(), "union_tmax_record", null, "ad_slot_type=? AND ad_slot_id=? AND record_time>=?", new String[]{String.valueOf(i), str, String.valueOf(j)}, null, null, str2);
    }

    public static Cursor n(int i, long j, String str) {
        if (j <= 0) {
            return null;
        }
        return com.byazt.xp.n.query(rv.getContext(), "union_tmax_record", null, "ad_slot_type=? AND record_time>=?", new String[]{String.valueOf(i), String.valueOf(j)}, null, null, str);
    }

    public static int n(long j) {
        return com.byazt.xp.n.delete(rv.getContext(), "union_tmax_record", "record_time<?", new String[]{String.valueOf(j)});
    }
}
