package com.byazt.msp;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.LruCache;
import com.byazt.gct.fs;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.byazt.qit.x;
import com.qq.e.comm.pi.ACTD;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 107, 8})
public class s {
    public static final LruCache<String, Integer> n = new LruCache<>(20);
    public static final Map<Integer, qg> qg = new ConcurrentHashMap();

    public static JSONObject n(int i, String str) {
        Map<Integer, qg> map = qg;
        if (map.get(Integer.valueOf(i)) == null) {
            map.put(Integer.valueOf(i), new qg());
        }
        qg qgVar = map.get(Integer.valueOf(i));
        if (qgVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObjectN = qgVar.n();
        if (jSONObjectN == null) {
            JSONObject jSONObjectN2 = qgVar.n(i, str);
            return jSONObjectN2 != null ? jSONObjectN2 : new JSONObject();
        }
        qgVar.qg(i, str);
        return jSONObjectN;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    public static JSONObject qg(int i, String str) {
        long jS;
        JSONObject jSONObject = new JSONObject();
        boolean zQg = 3;
        try {
            try {
                if (i == 3 || i == 4) {
                    if ((com.byazt.ed.q.n().cp() & 16) == 16) {
                        com.byazt.ci.l lVarN = com.byazt.ci.l.n(3);
                        zQg = lVarN.q(str);
                        jS = lVarN.l(str);
                    } else {
                        com.byazt.mz.q qVar = new com.byazt.mz.q();
                        zQg = qVar.qg(str);
                        jS = qVar.s(str);
                    }
                } else {
                    com.byazt.ci.l lVarN2 = com.byazt.ci.l.n(i);
                    zQg = lVarN2.q(str);
                    jS = lVarN2.l(str);
                }
            } catch (Throwable unused) {
                zQg = 0;
                jS = 0;
            }
        } catch (Throwable unused2) {
            jS = 0;
        }
        try {
            jSONObject.put("has_cache", zQg);
            zQg = "cache_exp_ts";
            jSONObject.put("cache_exp_ts", Math.max(0L, jS));
        } catch (Throwable unused3) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject q(int i, String str) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int iSz = fs.n(i).sz();
        if (iSz <= 0) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - (((long) iSz) * 60000);
        int i8 = 0;
        int i9 = 1;
        Cursor cursorQuery = com.byazt.xp.n.query(rv.getContext(), "meta_req_record_v1", null, "slot_type = ? and create_time >= ? and event_type = 1 and appid = ?", new String[]{String.valueOf(i), String.valueOf(jCurrentTimeMillis), str}, null, null, null);
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            int i10 = 0;
            int i11 = 0;
            i4 = 0;
            int i12 = 0;
            i5 = 0;
            while (true) {
                int i13 = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                if (i13 == i9) {
                    i10 += cursorQuery.getInt(cursorQuery.getColumnIndex("request_count"));
                } else if (i13 == 2) {
                    i11 += cursorQuery.getInt(cursorQuery.getColumnIndex("request_count"));
                    i4 += cursorQuery.getInt(cursorQuery.getColumnIndex("response_count"));
                } else if (i13 == 3) {
                    i12 += cursorQuery.getInt(cursorQuery.getColumnIndex("request_count"));
                    i5 += cursorQuery.getInt(cursorQuery.getColumnIndex("response_count"));
                }
                if (!cursorQuery.moveToNext()) {
                    break;
                }
                i9 = 1;
            }
            i3 = i10 + i11 + i12;
            i2 = i4 + i5;
        }
        Cursor cursorQuery2 = com.byazt.xp.n.query(rv.getContext(), "meta_req_record_v1", null, "slot_type = ? and create_time >= ? and event_type = 2 and appid = ?", new String[]{String.valueOf(i), String.valueOf(jCurrentTimeMillis), str}, null, null, null);
        if (cursorQuery2 == null || !cursorQuery2.moveToFirst()) {
            i6 = 0;
            i7 = 0;
        } else {
            i6 = 0;
            do {
                int i14 = Integer.parseInt(cursorQuery2.getString(cursorQuery2.getColumnIndex("status")));
                if (i14 == 1) {
                    i8++;
                } else if (i14 == 2) {
                    i6++;
                }
            } while (cursorQuery2.moveToNext());
            int i15 = i8;
            i8 += i6;
            i7 = i15;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (cursorQuery2 != null) {
            cursorQuery2.close();
        }
        int i16 = i3 <= 0 ? -1 : (int) ((i2 * 100.0f) / i3);
        int i17 = i2 <= 0 ? -1 : (int) ((i4 * 100.0f) / i2);
        int i18 = i2 <= 0 ? -1 : (int) ((i5 * 100.0f) / i2);
        int i19 = (i8 <= 0 || i2 <= 0) ? -1 : (int) ((i8 * 100.0f) / i2);
        int i20 = i8 <= 0 ? -1 : (int) ((i6 * 100.0f) / i8);
        int i21 = i8 > 0 ? (int) ((i7 * 100.0f) / i8) : -1;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("send_request_sum", i3);
            jSONObject.put("send_response_sum", i2);
            jSONObject.put("send_fill_rate", i16);
            jSONObject.put("send_net_rate", i17);
            jSONObject.put("send_cache_rate", i18);
            jSONObject.put("show_sum", i8);
            jSONObject.put("show_rate", i19);
            jSONObject.put("show_cache_rate", i20);
            jSONObject.put("show_net_rate", i21);
            jSONObject.put("interval_minute", iSz);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void n(final n nVar, final int i) {
        if (nVar != null && fs.n(nVar.n).sz() > 0) {
            com.byazt.ag.qg.n(new x("cacheDataCenter-recordSend") { // from class: com.byazt.msp.s.1
                @Override // java.lang.Runnable
                public void run() {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("rit", nVar.qg);
                    contentValues.put(ACTD.APPID_KEY, nVar.w == null ? "" : nVar.w.an());
                    contentValues.put("slot_type", Integer.valueOf(nVar.n));
                    contentValues.put("create_time", Long.valueOf(nVar.s));
                    contentValues.put("status", Integer.valueOf(i));
                    contentValues.put("request_count", Integer.valueOf(nVar.q));
                    contentValues.put("response_count", Integer.valueOf(nVar.l));
                    contentValues.put("event_type", (Integer) 1);
                    com.byazt.xp.n.insert(rv.getContext(), "meta_req_record_v1", contentValues);
                }
            });
        }
    }

    public static void n(final pk pkVar) {
        LruCache<String, Integer> lruCache = n;
        if (lruCache.get(pkVar.cs()) != null) {
            return;
        }
        lruCache.put(pkVar.cs(), 1);
        final int iD = com.byazt.vgx.w.d(pkVar);
        if (fs.n(iD).sz() <= 0) {
            return;
        }
        com.byazt.ag.qg.n(new x("cacheDataCenter-recordShow") { // from class: com.byazt.msp.s.2
            @Override // java.lang.Runnable
            public void run() {
                String strN = com.byazt.vgx.w.n(pkVar, "");
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit", strN);
                contentValues.put(ACTD.APPID_KEY, pkVar.mk());
                contentValues.put("slot_type", Integer.valueOf(iD));
                contentValues.put("create_time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("status", Integer.valueOf(pkVar.wn() ? 2 : 1));
                contentValues.put("event_type", (Integer) 2);
                com.byazt.xp.n.insert(rv.getContext(), "meta_req_record_v1", contentValues);
            }
        });
    }

    public static void n() {
        com.byazt.ag.qg.n(new x("cacheDataCenter-clearOldData") { // from class: com.byazt.msp.s.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.xp.n.delete(rv.getContext(), "meta_req_record_v1", "create_time < ?", new String[]{String.valueOf(System.currentTimeMillis() - 86400000)});
            }
        });
    }

    @com.byazt.cp.n(n = {0, 1, 107, 546})
    public static class n {
        public int l = 0;
        public int n;
        public int q;
        public String qg;
        public long s;
        public com.byazt.zq.qg w;

        public n(int i, String str, int i2, long j, com.byazt.zq.qg qgVar) {
            this.n = i;
            this.qg = str;
            this.q = i2;
            this.s = j;
            this.w = qgVar;
        }

        public void n(int i) {
            this.l = i;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 107, 782})
    public static class qg {
        public volatile long n;
        public volatile JSONObject qg;
        public final AtomicBoolean s = new AtomicBoolean(false);

        public JSONObject n(int i, String str) {
            if (!n(i)) {
                this.qg = s.q(i, str);
                this.n = System.currentTimeMillis();
            }
            return this.qg;
        }

        public JSONObject n() {
            return this.qg;
        }

        public void qg(final int i, final String str) {
            if (!n(i) && this.s.compareAndSet(false, true)) {
                com.byazt.ag.qg.n(new x("cacheDataCenter-intervalInfo-refresh") { // from class: com.byazt.msp.s.qg.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            qg.this.qg = s.q(i, str);
                            qg.this.n = System.currentTimeMillis();
                        } finally {
                            qg.this.s.set(false);
                        }
                    }
                });
            }
        }

        private boolean n(int i) {
            return System.currentTimeMillis() - this.n <= ((long) ((Math.max(0, fs.n(i).k()) * 60) * 1000)) && this.qg != null;
        }
    }
}
