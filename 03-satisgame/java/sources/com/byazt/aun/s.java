package com.byazt.aun;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.anythink.core.common.f.a;
import com.anythink.core.common.f.e;
import com.byazt.nf.rv;
import com.byazt.tk.k;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 898, 8})
public class s {

    @com.byazt.cp.n(n = {0, 1, 898, 546})
    public static class n {
        public String cp;
        public long d;
        public double fs;
        public long l;
        public String n;
        public String q;
        public String qg;
        public String rv;
        public int s;
        public long tj;
        public long w;
        public String x;

        public static String n(String str, String str2, long j, String str3) {
            return str + "_" + str2 + "_" + j + "_" + str3;
        }

        public String toString() {
            return "id :" + this.n + " ruleId :" + this.qg + " ruleVersion :" + this.s + " groupKey :" + this.q + " bucketKey :" + this.l + " bucketSize :" + this.w + " asName :" + this.x + " value :" + this.fs + " function :" + this.rv + " cnt :" + this.tj + " resultValue :" + this.cp + " timestamp :" + this.d;
        }
    }

    public static void n(n nVar) {
        if (nVar == null || TextUtils.isEmpty(nVar.qg) || TextUtils.isEmpty(nVar.x)) {
            return;
        }
        if (TextUtils.isEmpty(nVar.n)) {
            nVar.n = n.n(nVar.qg, nVar.q, nVar.l, nVar.x);
        }
        ContentValues contentValuesQg = qg(nVar);
        if (com.byazt.xp.n.update(rv.getContext(), "tt_feature_bucket", contentValuesQg, "id=?", new String[]{nVar.n}) <= 0) {
            com.byazt.xp.n.insert(rv.getContext(), "tt_feature_bucket", contentValuesQg);
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0084 A[DONT_GENERATE, PHI: r4
      0x0084: PHI (r4v4 android.database.Cursor) = (r4v3 android.database.Cursor), (r4v5 android.database.Cursor) binds: [B:25:0x0082, B:21:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
    public static List<n> query(String str, String str2, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        StringBuilder sb = new StringBuilder("rule_id=?");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(str);
        if (str2 != null) {
            sb.append(" AND group_key=?");
            arrayList2.add(str2);
        }
        if (j >= 0) {
            sb.append(" AND bucket_key>=?");
            arrayList2.add(String.valueOf(j));
        }
        if (j2 >= 0) {
            sb.append(" AND bucket_key<=?");
            arrayList2.add(String.valueOf(j2));
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = com.byazt.xp.n.query(rv.getContext(), "tt_feature_bucket", null, sb.toString(), (String[]) arrayList2.toArray(new String[0]), null, null, "bucket_key ASC");
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    arrayList.add(n(cursorQuery));
                }
            }
            if (cursorQuery != null) {
            }
        } catch (Throwable th) {
            try {
                k.n("Tme_feature_center-FeaCacheDb", "query error", th);
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return arrayList;
    }

    public static int n(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return com.byazt.xp.n.delete(rv.getContext(), "tt_feature_bucket", "rule_id=? AND bucket_key<?", new String[]{str, String.valueOf(j)});
    }

    private static ContentValues qg(n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", nVar.n);
        contentValues.put(a.C0017a.o, nVar.qg);
        contentValues.put("rule_version", Integer.valueOf(nVar.s));
        contentValues.put("group_key", nVar.q);
        contentValues.put("bucket_key", Long.valueOf(nVar.l));
        contentValues.put("bucket_size", Long.valueOf(nVar.w));
        contentValues.put("as_name", nVar.x);
        contentValues.put(e.a.d, Double.valueOf(nVar.fs));
        contentValues.put("function", nVar.rv);
        contentValues.put("cnt", Long.valueOf(nVar.tj));
        contentValues.put("result_value", nVar.cp);
        contentValues.put(TapEventParamConstants.PARAM_SUB_TIMESTAMP, Long.valueOf(nVar.d));
        return contentValues;
    }

    private static n n(Cursor cursor) {
        n nVar = new n();
        nVar.n = cursor.getString(cursor.getColumnIndex("id"));
        nVar.qg = cursor.getString(cursor.getColumnIndex(a.C0017a.o));
        nVar.s = cursor.getInt(cursor.getColumnIndex("rule_version"));
        nVar.q = cursor.getString(cursor.getColumnIndex("group_key"));
        nVar.l = cursor.getLong(cursor.getColumnIndex("bucket_key"));
        nVar.w = cursor.getLong(cursor.getColumnIndex("bucket_size"));
        nVar.x = cursor.getString(cursor.getColumnIndex("as_name"));
        nVar.fs = cursor.getDouble(cursor.getColumnIndex(e.a.d));
        nVar.rv = cursor.getString(cursor.getColumnIndex("function"));
        nVar.tj = cursor.getLong(cursor.getColumnIndex("cnt"));
        nVar.cp = cursor.getString(cursor.getColumnIndex("result_value"));
        nVar.d = cursor.getLong(cursor.getColumnIndex(TapEventParamConstants.PARAM_SUB_TIMESTAMP));
        return nVar;
    }
}
