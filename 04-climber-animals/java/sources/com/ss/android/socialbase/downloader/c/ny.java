package com.ss.android.socialbase.downloader.c;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ny {
    private int ab;
    private final long ah;
    private long c;
    private final AtomicLong d;
    private volatile long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    volatile zb f4620ms;
    private JSONObject x;
    int xr;

    public ny(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.d = atomicLong;
        this.xr = 0;
        this.ah = j;
        atomicLong.set(j);
        this.ka = j;
        if (j2 >= j) {
            this.c = j2;
        } else {
            this.c = -1L;
        }
    }

    public ny(ny nyVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.d = atomicLong;
        this.xr = 0;
        this.ah = nyVar.ah;
        this.c = nyVar.c;
        atomicLong.set(nyVar.d.get());
        this.ka = atomicLong.get();
        this.ab = nyVar.ab;
    }

    public ny(JSONObject jSONObject) {
        this.d = new AtomicLong();
        this.xr = 0;
        this.ah = jSONObject.optLong("st");
        ah(jSONObject.optLong("en"));
        ms(jSONObject.optLong("cu"));
        d(d());
    }

    public long ms() {
        return this.d.get() - this.ah;
    }

    public long xr() {
        long j = this.c;
        if (j >= this.ah) {
            return (j - ka()) + 1;
        }
        return -1L;
    }

    public long ah() {
        return this.ah;
    }

    public long d() {
        long j = this.d.get();
        long j2 = this.c;
        if (j2 > 0) {
            long j3 = j2 + 1;
            if (j > j3) {
                return j3;
            }
        }
        return j;
    }

    public long ka() {
        zb zbVar = this.f4620ms;
        if (zbVar != null) {
            long jD = zbVar.d();
            if (jD > this.ka) {
                return jD;
            }
        }
        return this.ka;
    }

    public void ms(long j) {
        long j2 = this.ah;
        if (j < j2) {
            j = j2;
        }
        long j3 = this.c;
        if (j3 > 0) {
            long j4 = j3 + 1;
            if (j > j4) {
                j = j4;
            }
        }
        this.d.set(j);
    }

    void xr(long j) {
        this.d.addAndGet(j);
    }

    public long c() {
        return this.c;
    }

    void ah(long j) {
        if (j >= this.ah) {
            this.c = j;
            return;
        }
        com.bytedance.sdk.openadsdk.api.ab.d("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.c = j;
        }
    }

    public void d(long j) {
        if (j >= this.d.get()) {
            this.ka = j;
        }
    }

    public int ab() {
        return this.ab;
    }

    void ms(int i) {
        this.ab = i;
    }

    void x() {
        this.xr++;
    }

    void ny() {
        this.xr--;
    }

    int ch() {
        return this.xr;
    }

    void xr(int i) {
        this.xr = i;
    }

    public String toString() {
        return "Segment{startOffset=" + this.ah + ",\t currentOffset=" + this.d + ",\t currentOffsetRead=" + ka() + ",\t endOffset=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public static String ms(List<ny> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<ny>() { // from class: com.ss.android.socialbase.downloader.c.ny.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public int compare(ny nyVar, ny nyVar2) {
                return (int) (nyVar.ah() - nyVar2.ah());
            }
        });
        StringBuilder sb = new StringBuilder();
        Iterator<ny> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append("\r\n");
        }
        return sb.toString();
    }

    public JSONObject hi() throws JSONException {
        JSONObject jSONObject = this.x;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.x = jSONObject;
        }
        jSONObject.put("st", ah());
        jSONObject.put("cu", d());
        jSONObject.put("en", c());
        return jSONObject;
    }
}
