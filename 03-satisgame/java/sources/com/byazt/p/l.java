package com.byazt.p;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 914, 18})
public class l implements Serializable, Comparable<l> {
    public final long n;
    public DateFormat qg;

    public l(long j) {
        this.n = j;
    }

    public long n() {
        return this.n;
    }

    public long qg() {
        return n(this.n);
    }

    public Date s() {
        return new Date(n(this.n));
    }

    public static long n(long j) {
        long j2 = (j >>> 32) & 4294967295L;
        return (j2 * 1000) + ((2147483648L & j2) == 0 ? 2085978496000L : -2208988800000L) + Math.round(((j & 4294967295L) * 1000.0d) / 4.294967296E9d);
    }

    public static l qg(long j) {
        return new l(s(j));
    }

    public static l q() {
        return qg(System.currentTimeMillis());
    }

    public static long s(long j) {
        boolean z = j < 2085978496000L;
        long j2 = j - (z ? -2208988800000L : 2085978496000L);
        long j3 = j2 / 1000;
        long j4 = ((j2 % 1000) * 4294967296L) / 1000;
        if (z) {
            j3 |= 2147483648L;
        }
        return j4 | (j3 << 32);
    }

    public int hashCode() {
        long j = this.n;
        return (int) (j ^ (j >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof l) && this.n == ((l) obj).n();
    }

    public String toString() {
        return q(this.n);
    }

    private static void n(StringBuilder sb, long j) {
        String hexString = Long.toHexString(j);
        for (int length = hexString.length(); length < 8; length++) {
            sb.append('0');
        }
        sb.append(hexString);
    }

    public static String q(long j) {
        StringBuilder sb = new StringBuilder();
        n(sb, (j >>> 32) & 4294967295L);
        sb.append('.');
        n(sb, j & 4294967295L);
        return sb.toString();
    }

    public String l() {
        if (this.qg == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, MMM dd yyyy HH:mm:ss.SSS", Locale.US);
            this.qg = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
        }
        return this.qg.format(s());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int compareTo(l lVar) {
        long j = this.n;
        long j2 = lVar.n;
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }
}
