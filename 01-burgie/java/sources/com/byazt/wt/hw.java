package com.byazt.wt;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 13})
public class hw {
    public static volatile hw pr = null;
    public com.byazt.cr.c aj;
    public com.byazt.cr.c fw;
    public com.byazt.cr.c vk;
    public com.byazt.cr.c zo;
    public volatile int w = 0;
    public int k = 0;
    public int m = 0;
    public final Map<String, Integer> hw = new HashMap();
    public final ConcurrentHashMap<String, Integer> hn = new ConcurrentHashMap<>();
    public final Map<String, Long> x = new HashMap();
    public final ConcurrentHashMap<String, Long> c = new ConcurrentHashMap<>();
    public final long uc = SystemClock.elapsedRealtime();

    private hw() {
    }

    public static hw pr() {
        if (pr == null) {
            synchronized (hw.class) {
                if (pr == null) {
                    pr = new hw();
                }
            }
        }
        return pr;
    }

    public void pr(String str) {
        if (!TextUtils.isEmpty(str)) {
            Integer num = this.hw.get(str);
            this.hw.put(str, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
            this.c.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
            if (this.c.size() > 1) {
                this.k++;
            }
            hw(str);
        }
    }

    public void hw(final String str) {
        com.byazt.ca.aj.pr().post(new Runnable() { // from class: com.byazt.wt.hw.1
            @Override // java.lang.Runnable
            public void run() {
                hw.this.x().pr(str, hw.this.x().hw(str, 0) + 1);
                if (hw.this.w == 0) {
                    hw hwVar = hw.this;
                    hwVar.w = hwVar.fw().hw("histRunningCount", 0) + 1;
                    hw.this.fw().pr("histRunningCount", hw.this.w);
                }
            }
        });
    }

    public void hn(String str) {
        Long lRemove;
        if (!TextUtils.isEmpty(str) && (lRemove = this.c.remove(str)) != null) {
            long jElapsedRealtime = (SystemClock.elapsedRealtime() - lRemove.longValue()) / 1000;
            if (jElapsedRealtime >= 0) {
                Long l = this.x.get(str);
                if (l == null || l.longValue() < 0) {
                    l = 0L;
                }
                this.x.put(str, Long.valueOf(l.longValue() + jElapsedRealtime));
                pr(str, jElapsedRealtime);
            }
        }
    }

    public void pr(final String str, final long j) {
        com.byazt.ca.aj.pr().post(new Runnable() { // from class: com.byazt.wt.hw.2
            @Override // java.lang.Runnable
            public void run() {
                long jHw = hw.this.uc().hw(str, 0L);
                hw.this.uc().pr(str, (jHw >= 0 ? jHw : 0L) + j);
                hw.this.hn();
                hw.this.pr(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(long j) {
        int i = this.m;
        if (i == 0) {
            try {
                Map all = uc().getAll();
                if (all != null) {
                    Iterator it = all.values().iterator();
                    while (it.hasNext()) {
                        this.m = (int) (((long) this.m) + ((Long) it.next()).longValue());
                    }
                }
            } catch (Throwable th) {
                this.m = -1;
            }
        } else {
            this.m = (int) (((long) i) + j);
        }
        rc.pr(this.m, this.w);
    }

    public void hw() {
        if (this.c.size() == 1) {
            for (String str : this.c.keySet()) {
                Integer num = this.hn.get(str);
                this.hn.put(str, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
                x(str);
            }
        }
    }

    public void x(final String str) {
        com.byazt.ca.aj.pr().post(new Runnable() { // from class: com.byazt.wt.hw.3
            @Override // java.lang.Runnable
            public void run() {
                hw.this.c().pr(str, hw.this.c().hw(str, 0) + 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn() {
        try {
            Map all = x().getAll();
            if (all == null) {
                return;
            }
            Iterator it = all.values().iterator();
            int iIntValue = 0;
            while (it.hasNext()) {
                iIntValue += ((Integer) it.next()).intValue();
            }
            if (iIntValue != 0 && iIntValue % 75 == 0) {
                final JSONArray jSONArray = new JSONArray();
                for (String str : this.hw.keySet()) {
                    Integer num = this.hw.get(str);
                    Long l = this.x.get(str);
                    Integer num2 = this.hn.get(str);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(Common.System.NAME, str);
                        jSONObject.put("rc", num != null ? num.intValue() : 0);
                        jSONObject.put("ft", l != null ? l.longValue() : 0L);
                        jSONObject.put("asc", num2 != null ? num2.intValue() : 0);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                    }
                }
                final JSONArray jSONArray2 = new JSONArray();
                Map all2 = uc().getAll();
                Map all3 = c().getAll();
                if (all2 != null && all3 != null) {
                    for (String str2 : all.keySet()) {
                        Integer num3 = (Integer) all.get(str2);
                        Long l2 = (Long) all2.get(str2);
                        Integer num4 = (Integer) all3.get(str2);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(Common.System.NAME, str2);
                            jSONObject2.put("rc", num3 != null ? num3.intValue() : 0);
                            jSONObject2.put("ft", l2 != null ? l2.longValue() : 0L);
                            jSONObject2.put("asc", num4 != null ? num4.intValue() : 0);
                            jSONArray2.put(jSONObject2);
                        } catch (JSONException e2) {
                        }
                    }
                }
                final long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.uc) / 1000;
                com.byazt.xk.hw.pr().pr("ad_activity_record", new com.byazt.ttf.pr() { // from class: com.byazt.wt.hw.4
                    @Override // com.byazt.ttf.pr
                    public JSONObject pr(JSONObject jSONObject3) throws JSONException {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("ara", jSONArray);
                        jSONObject4.put("hara", jSONArray2);
                        jSONObject4.put("rt", jElapsedRealtime);
                        jSONObject4.put("hrc", hw.this.w);
                        jSONObject4.put("drc", hw.this.k);
                        return jSONObject4;
                    }
                });
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.cr.c x() {
        if (this.fw == null) {
            this.fw = y.pr("activity_resume_count");
        }
        return this.fw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.cr.c c() {
        if (this.zo == null) {
            this.zo = y.pr("activity_adshow_count");
        }
        return this.zo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.cr.c uc() {
        if (this.aj == null) {
            this.aj = y.pr("activity_foreground_time");
        }
        return this.aj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.cr.c fw() {
        if (this.vk == null) {
            this.vk = y.pr("activity_recorder");
        }
        return this.vk;
    }
}
