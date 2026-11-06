package com.byazt.kl;

import com.anythink.core.e.b;
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
@com.byazt.cp.n(n = {0, 1, 445, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public final class rv {
    public JSONObject fs;
    public volatile long l;
    public volatile oa n;
    public final AtomicLong q;
    public int qg;
    public final long s;
    public long w;
    public int x;

    public rv(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.q = atomicLong;
        this.qg = 0;
        this.s = j;
        atomicLong.set(j);
        this.l = j;
        if (j2 >= j) {
            this.w = j2;
        } else {
            this.w = -1L;
        }
    }

    public rv(rv rvVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.q = atomicLong;
        this.qg = 0;
        this.s = rvVar.s;
        this.w = rvVar.w;
        atomicLong.set(rvVar.q.get());
        this.l = atomicLong.get();
        this.x = rvVar.x;
    }

    public rv(JSONObject jSONObject) {
        this.q = new AtomicLong();
        this.qg = 0;
        this.s = jSONObject.optLong(b.a.C);
        s(jSONObject.optLong("en"));
        n(jSONObject.optLong("cu"));
        q(q());
    }

    public long n() {
        return this.q.get() - this.s;
    }

    public long qg() {
        long j = this.w;
        if (j >= this.s) {
            return (j - l()) + 1;
        }
        return -1L;
    }

    public long s() {
        return this.s;
    }

    public long q() {
        long j = this.q.get();
        long j2 = this.w;
        if (j2 > 0) {
            long j3 = j2 + 1;
            if (j > j3) {
                return j3;
            }
        }
        return j;
    }

    public long l() {
        oa oaVar = this.n;
        if (oaVar != null) {
            long jQ = oaVar.q();
            if (jQ > this.l) {
                return jQ;
            }
        }
        return this.l;
    }

    public void n(long j) {
        long j2 = this.s;
        if (j < j2) {
            j = j2;
        }
        long j3 = this.w;
        if (j3 > 0) {
            long j4 = j3 + 1;
            if (j > j4) {
                j = j4;
            }
        }
        this.q.set(j);
    }

    public void qg(long j) {
        this.q.addAndGet(j);
    }

    public long w() {
        return this.w;
    }

    public void s(long j) {
        if (j >= this.s) {
            this.w = j;
        } else if (j == -1) {
            this.w = j;
        }
    }

    public void q(long j) {
        if (j >= this.q.get()) {
            this.l = j;
        }
    }

    public int x() {
        return this.x;
    }

    public void n(int i) {
        this.x = i;
    }

    public void fs() {
        this.qg++;
    }

    public void rv() {
        this.qg--;
    }

    public int tj() {
        return this.qg;
    }

    public void qg(int i) {
        this.qg = i;
    }

    public String toString() {
        return "Segment{startOffset=" + this.s + ",\t currentOffset=" + this.q + ",\t currentOffsetRead=" + l() + ",\t endOffset=" + this.w + AbstractJsonLexerKt.END_OBJ;
    }

    public static String n(List<rv> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<rv>() { // from class: com.byazt.kl.rv.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public int compare(rv rvVar, rv rvVar2) {
                return (int) (rvVar.s() - rvVar2.s());
            }
        });
        StringBuilder sb = new StringBuilder();
        Iterator<rv> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append("\r\n");
        }
        return sb.toString();
    }

    public JSONObject cp() throws JSONException {
        JSONObject jSONObject = this.fs;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.fs = jSONObject;
        }
        jSONObject.put(b.a.C, s());
        jSONObject.put("cu", q());
        jSONObject.put("en", w());
        return jSONObject;
    }
}
