package com.byazt.ra;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v4.app.NotificationCompat;
import android.util.LruCache;
import com.byazt.hg.of;
import com.byazt.hg.zo;
import com.byazt.sd.a;
import com.byazt.wt.ls;
import com.byazt.xlm.fw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.pi.ACTD;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER, 20})
public class hn {
    public static final LruCache<String, Integer> pr = new LruCache<>(20);
    public static final Map<Integer, hw> hw = new ConcurrentHashMap();

    public static JSONObject pr(int i, String str) {
        Map<Integer, hw> map = hw;
        if (map.get(Integer.valueOf(i)) == null) {
            map.put(Integer.valueOf(i), new hw());
        }
        hw hwVar = map.get(Integer.valueOf(i));
        if (hwVar != null) {
            return hwVar.pr(i, str);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:10:0x001d
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static org.json.JSONObject hw(int r5, java.lang.String r6) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r1 = 3
            r2 = 0
            if (r5 == r1) goto L1f
            r4 = 4
            if (r5 != r4) goto L10
            goto L1f
        L10:
            com.byazt.py.c r5 = com.byazt.py.c.pr(r5)     // Catch: java.lang.Throwable -> L47
            boolean r1 = r5.x(r6)     // Catch: java.lang.Throwable -> L47
            long r5 = r5.c(r6)     // Catch: java.lang.Throwable -> L1d
            goto L4a
        L1d:
            r5 = move-exception
            goto L49
        L1f:
            com.byazt.mp.c r5 = com.byazt.mp.c.pr()     // Catch: java.lang.Throwable -> L47
            int r5 = r5.w()     // Catch: java.lang.Throwable -> L47
            r4 = 16
            r5 = r5 & r4
            if (r5 != r4) goto L39
            com.byazt.py.c r5 = com.byazt.py.c.pr(r1)     // Catch: java.lang.Throwable -> L47
            boolean r1 = r5.x(r6)     // Catch: java.lang.Throwable -> L47
            long r5 = r5.c(r6)     // Catch: java.lang.Throwable -> L1d
            goto L4a
        L39:
            com.byazt.ks.x r5 = new com.byazt.ks.x     // Catch: java.lang.Throwable -> L47
            r5.<init>()     // Catch: java.lang.Throwable -> L47
            boolean r1 = r5.pr(r6)     // Catch: java.lang.Throwable -> L47
            long r5 = r5.hw(r6)     // Catch: java.lang.Throwable -> L1d
            goto L4a
        L47:
            r5 = move-exception
            r1 = 0
        L49:
            r5 = r2
        L4a:
            java.lang.String r4 = "has_cache"
            r0.put(r4, r1)     // Catch: java.lang.Throwable -> L59
            java.lang.String r1 = "cache_exp_ts"
            long r5 = java.lang.Math.max(r2, r5)     // Catch: java.lang.Throwable -> L59
            r0.put(r1, r5)     // Catch: java.lang.Throwable -> L59
            goto L5a
        L59:
            r5 = move-exception
        L5a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.ra.hn.hw(int, java.lang.String):org.json.JSONObject");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject x(int i, String str) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int iG = zo.pr(i).g();
        if (iG <= 0) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - (((long) iG) * 60000);
        int i8 = 0;
        int i9 = 1;
        Cursor cursorQuery = com.byazt.ad.pr.query(a.getContext(), "meta_req_record_v1", null, "slot_type = ? and create_time >= ? and event_type = 1 and appid = ?", new String[]{String.valueOf(i), String.valueOf(jCurrentTimeMillis), str}, null, null, null);
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            int i10 = 0;
            int i11 = 0;
            i4 = 0;
            int i12 = 0;
            i5 = 0;
            while (true) {
                int i13 = cursorQuery.getInt(cursorQuery.getColumnIndex(NotificationCompat.CATEGORY_STATUS));
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
        } else {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        Cursor cursorQuery2 = com.byazt.ad.pr.query(a.getContext(), "meta_req_record_v1", null, "slot_type = ? and create_time >= ? and event_type = 2 and appid = ?", new String[]{String.valueOf(i), String.valueOf(jCurrentTimeMillis), str}, null, null, null);
        if (cursorQuery2 != null && cursorQuery2.moveToFirst()) {
            i6 = 0;
            do {
                int i14 = Integer.parseInt(cursorQuery2.getString(cursorQuery2.getColumnIndex(NotificationCompat.CATEGORY_STATUS)));
                if (i14 == 1) {
                    i8++;
                } else if (i14 == 2) {
                    i6++;
                }
            } while (cursorQuery2.moveToNext());
            int i15 = i8;
            i8 += i6;
            i7 = i15;
        } else {
            i6 = 0;
            i7 = 0;
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
            jSONObject.put("interval_minute", iG);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    public static void pr(final pr prVar, final int i) {
        if (prVar == null || zo.pr(prVar.pr).g() <= 0) {
            return;
        }
        com.byazt.zp.zo.pr(new fw("cacheDataCenter-recordSend") { // from class: com.byazt.ra.hn.1
            @Override // java.lang.Runnable
            public void run() {
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit", prVar.hw);
                contentValues.put(ACTD.APPID_KEY, prVar.uc == null ? "" : prVar.uc.gz());
                contentValues.put("slot_type", Integer.valueOf(prVar.pr));
                contentValues.put("create_time", Long.valueOf(prVar.hn));
                contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(i));
                contentValues.put("request_count", Integer.valueOf(prVar.x));
                contentValues.put("response_count", Integer.valueOf(prVar.c));
                contentValues.put("event_type", (Integer) 1);
                com.byazt.ad.pr.insert(a.getContext(), "meta_req_record_v1", contentValues);
            }
        });
    }

    public static void pr(final of ofVar) {
        LruCache<String, Integer> lruCache = pr;
        if (lruCache.get(ofVar.ri()) != null) {
            return;
        }
        lruCache.put(ofVar.ri(), 1);
        final int iK = ls.k(ofVar);
        if (zo.pr(iK).g() <= 0) {
            return;
        }
        com.byazt.zp.zo.pr(new fw("cacheDataCenter-recordShow") { // from class: com.byazt.ra.hn.2
            @Override // java.lang.Runnable
            public void run() {
                String strPr = ls.pr(ofVar, "");
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit", strPr);
                contentValues.put(ACTD.APPID_KEY, ofVar.yn());
                contentValues.put("slot_type", Integer.valueOf(iK));
                contentValues.put("create_time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(ofVar.ji() ? 2 : 1));
                contentValues.put("event_type", (Integer) 2);
                com.byazt.ad.pr.insert(a.getContext(), "meta_req_record_v1", contentValues);
            }
        });
    }

    public static void pr() {
        com.byazt.zp.zo.pr(new fw("cacheDataCenter-clearOldData") { // from class: com.byazt.ra.hn.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.ad.pr.delete(a.getContext(), "meta_req_record_v1", "create_time < ?", new String[]{String.valueOf(System.currentTimeMillis() - 86400000)});
            }
        });
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER, 116})
    public static class pr {
        public int c = 0;
        public long hn;
        public String hw;
        public int pr;
        public com.byazt.qe.hw uc;
        public int x;

        public pr(int i, String str, int i2, long j, com.byazt.qe.hw hwVar) {
            this.pr = i;
            this.hw = str;
            this.x = i2;
            this.hn = j;
            this.uc = hwVar;
        }

        public void pr(int i) {
            this.c = i;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER, 506})
    public static class hw {
        public JSONObject hw;
        public long pr;

        public JSONObject pr(int i, String str) {
            if (!pr(i)) {
                this.hw = hn.x(i, str);
                this.pr = System.currentTimeMillis();
            }
            return this.hw;
        }

        private boolean pr(int i) {
            return System.currentTimeMillis() - this.pr <= ((long) ((Math.max(0, zo.pr(i).ho()) * 60) * 1000)) && this.hw != null;
        }
    }
}
