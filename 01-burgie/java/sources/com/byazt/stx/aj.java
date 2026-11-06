package com.byazt.stx;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 61})
public final class aj {
    public volatile long c;
    public int fw;
    public final long hn;
    public int hw;
    public volatile m pr;
    public long uc;
    public final AtomicLong x;
    public JSONObject zo;

    public aj(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.x = atomicLong;
        this.hw = 0;
        this.hn = j;
        atomicLong.set(j);
        this.c = j;
        if (j2 >= j) {
            this.uc = j2;
        } else {
            this.uc = -1L;
        }
    }

    public aj(aj ajVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.x = atomicLong;
        this.hw = 0;
        this.hn = ajVar.hn;
        this.uc = ajVar.uc;
        atomicLong.set(ajVar.x.get());
        this.c = atomicLong.get();
        this.fw = ajVar.fw;
    }

    public aj(JSONObject jSONObject) {
        this.x = new AtomicLong();
        this.hw = 0;
        this.hn = jSONObject.optLong("st");
        hn(jSONObject.optLong("en"));
        pr(jSONObject.optLong("cu"));
        x(x());
    }

    public long pr() {
        return this.x.get() - this.hn;
    }

    public long hw() {
        long j = this.uc;
        if (j >= this.hn) {
            return (j - c()) + 1;
        }
        return -1L;
    }

    public long hn() {
        return this.hn;
    }

    public long x() {
        long j = this.x.get();
        long j2 = this.uc;
        if (j2 > 0) {
            long j3 = j2 + 1;
            if (j > j3) {
                return j3;
            }
        }
        return j;
    }

    public long c() {
        m mVar = this.pr;
        if (mVar != null) {
            long jX = mVar.x();
            if (jX > this.c) {
                return jX;
            }
        }
        return this.c;
    }

    public void pr(long j) {
        long j2 = this.hn;
        if (j < j2) {
            j = j2;
        }
        long j3 = this.uc;
        if (j3 > 0) {
            long j4 = j3 + 1;
            if (j > j4) {
                j = j4;
            }
        }
        this.x.set(j);
    }

    public void hw(long j) {
        this.x.addAndGet(j);
    }

    public long uc() {
        return this.uc;
    }

    public void hn(long j) {
        if (j >= this.hn) {
            this.uc = j;
        } else if (j == -1) {
            this.uc = j;
        }
    }

    public void x(long j) {
        if (j >= this.x.get()) {
            this.c = j;
        }
    }

    public int fw() {
        return this.fw;
    }

    public void pr(int i) {
        this.fw = i;
    }

    public void zo() {
        this.hw++;
    }

    public void aj() {
        this.hw--;
    }

    public int vk() {
        return this.hw;
    }

    public void hw(int i) {
        this.hw = i;
    }

    public String toString() {
        return "Segment{startOffset=" + this.hn + ",\t currentOffset=" + this.x + ",\t currentOffsetRead=" + c() + ",\t endOffset=" + this.uc + AbstractJsonLexerKt.END_OBJ;
    }

    public static String pr(List<aj> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<aj>() { // from class: com.byazt.stx.aj.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public int compare(aj ajVar, aj ajVar2) {
                return (int) (ajVar.hn() - ajVar2.hn());
            }
        });
        StringBuilder sb = new StringBuilder();
        Iterator<aj> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append("\r\n");
        }
        return sb.toString();
    }

    public JSONObject w() throws JSONException {
        JSONObject jSONObject = this.zo;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.zo = jSONObject;
        }
        jSONObject.put("st", hn());
        jSONObject.put("cu", x());
        jSONObject.put("en", uc());
        return jSONObject;
    }
}
