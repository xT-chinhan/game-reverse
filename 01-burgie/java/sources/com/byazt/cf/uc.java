package com.byazt.cf;

import android.content.ContentValues;
import android.text.TextUtils;
import com.byazt.hg.zo;
import com.byazt.xlm.fw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 440, 5})
public class uc {
    public static volatile long hn;
    public static final pr hw;
    public static final uc pr = new uc();
    public static volatile pr x;
    public final Map<String, hw> c = new ConcurrentHashMap();

    interface pr {
        void pr(long j);

        void pr(ContentValues contentValues);
    }

    static {
        pr prVar = new pr() { // from class: com.byazt.cf.uc.1
            @Override // com.byazt.cf.uc.pr
            public void pr(ContentValues contentValues) {
                c.pr(contentValues);
            }

            @Override // com.byazt.cf.uc.pr
            public void pr(long j) {
                c.pr(j);
            }
        };
        hw = prVar;
        hn = -1L;
        x = prVar;
    }

    public static uc pr() {
        return pr;
    }

    public boolean pr(int i) {
        zo.hn hnVarPr = zo.pr(i);
        if (hnVarPr == null || hnVarPr.yb() == null) {
            return false;
        }
        return hnVarPr.yb().hw();
    }

    public void pr(String str, int i, String str2, long j) {
        hw hwVarPutIfAbsent;
        if (!pr(i) || TextUtils.isEmpty(str)) {
            return;
        }
        hw hwVar = this.c.get(str);
        if (hwVar == null && (hwVarPutIfAbsent = this.c.putIfAbsent(str, (hwVar = new hw()))) != null) {
            hwVar = hwVarPutIfAbsent;
        }
        synchronized (hwVar) {
            if (j > 0) {
                hwVar.pr = j;
                hwVar.hw = i;
                hwVar.hn = str2;
                hwVar.x = 0L;
                hwVar.c = 0L;
                hwVar.uc = 0L;
                hwVar.fw = false;
                hwVar.zo = false;
            } else {
                j = System.currentTimeMillis();
                hwVar.pr = j;
                hwVar.hw = i;
                hwVar.hn = str2;
                hwVar.x = 0L;
                hwVar.c = 0L;
                hwVar.uc = 0L;
                hwVar.fw = false;
                hwVar.zo = false;
            }
            throw th;
        }
    }

    public void pr(String str, long j) {
        hw hwVar;
        if (TextUtils.isEmpty(str) || (hwVar = this.c.get(str)) == null) {
            return;
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        synchronized (hwVar) {
            if (hwVar.pr <= 0) {
                hwVar.pr = j;
            }
            if (hwVar.x <= 0) {
                hwVar.x = Math.max(0L, j - hwVar.pr);
            }
            hwVar.zo = true;
        }
    }

    public void hw(final String str, final long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.zp.zo.pr(new fw("tmax_record_on_cached") { // from class: com.byazt.cf.uc.2
            @Override // java.lang.Runnable
            public void run() {
                hw hwVar = (hw) uc.this.c.get(str);
                if (hwVar == null) {
                    return;
                }
                long jCurrentTimeMillis = j;
                if (jCurrentTimeMillis <= 0) {
                    jCurrentTimeMillis = System.currentTimeMillis();
                }
                synchronized (hwVar) {
                    if (hwVar.pr <= 0) {
                        return;
                    }
                    if (hwVar.c <= 0) {
                        hwVar.c = Math.max(0L, jCurrentTimeMillis - hwVar.pr);
                    }
                }
            }
        });
    }

    public void hn(String str, long j) {
        hw hwVar;
        if (TextUtils.isEmpty(str) || (hwVar = this.c.get(str)) == null) {
            return;
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        synchronized (hwVar) {
            if (hwVar.fw) {
                return;
            }
            hwVar.fw = true;
            if (hwVar.pr <= 0) {
                hwVar.pr = j;
            }
            hwVar.uc = Math.max(0L, j - hwVar.pr);
        }
    }

    public void x(String str, long j) {
        hw hwVar;
        if (TextUtils.isEmpty(str) || (hwVar = this.c.get(str)) == null) {
            return;
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        synchronized (hwVar) {
            if (hwVar.zo) {
                if (hwVar.pr <= 0) {
                    hwVar.pr = j;
                }
                ContentValues contentValuesPr = pr(str, hwVar, j);
                this.c.remove(str);
                pr(contentValuesPr);
            }
        }
    }

    private ContentValues pr(String str, hw hwVar, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("load_id", str);
        contentValues.put("ad_slot_type", Integer.valueOf(hwVar.hw));
        contentValues.put("ad_slot_id", hwVar.hn);
        contentValues.put("loaded_duration", Long.valueOf(hwVar.x));
        contentValues.put("cached_duration", Long.valueOf(hwVar.c));
        contentValues.put("shown_duration", Long.valueOf(hwVar.uc));
        contentValues.put("is_shown", Integer.valueOf(hwVar.fw ? 1 : 0));
        contentValues.put("record_time", Long.valueOf(j));
        return contentValues;
    }

    private void pr(ContentValues contentValues) {
        x.pr(contentValues);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - hn > 86400000) {
            hn = jCurrentTimeMillis;
            final long j = jCurrentTimeMillis - 604800000;
            if (j > 0) {
                com.byazt.zp.zo.pr(new fw("tmax_record_cleanup") { // from class: com.byazt.cf.uc.3
                    @Override // java.lang.Runnable
                    public void run() {
                        uc.x.pr(j);
                    }
                });
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 440, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED})
    private static class hw {
        public long c;
        public boolean fw;
        public String hn;
        public int hw;
        public long pr;
        public long uc;
        public long x;
        public boolean zo;

        private hw() {
        }
    }
}
