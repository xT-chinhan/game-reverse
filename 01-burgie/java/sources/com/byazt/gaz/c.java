package com.byazt.gaz;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1689, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements Serializable, Comparable<c> {
    public DateFormat hw;
    public final long pr;

    public c(long j) {
        this.pr = j;
    }

    public long pr() {
        return this.pr;
    }

    public long hw() {
        return pr(this.pr);
    }

    public Date hn() {
        return new Date(pr(this.pr));
    }

    public static long pr(long j) {
        long j2 = (j >>> 32) & 4294967295L;
        long jRound = Math.round(((j & 4294967295L) * 1000.0d) / 4.294967296E9d);
        if ((2147483648L & j2) == 0) {
            return (j2 * 1000) + 2085978496000L + jRound;
        }
        return ((j2 * 1000) - 2208988800000L) + jRound;
    }

    public static c hw(long j) {
        return new c(hn(j));
    }

    public static c x() {
        return hw(System.currentTimeMillis());
    }

    public static long hn(long j) {
        long j2;
        boolean z = j < 2085978496000L;
        if (z) {
            j2 = j - (-2208988800000L);
        } else {
            j2 = j - 2085978496000L;
        }
        long j3 = j2 / 1000;
        long j4 = ((j2 % 1000) * 4294967296L) / 1000;
        if (z) {
            j3 |= 2147483648L;
        }
        return j4 | (j3 << 32);
    }

    public int hashCode() {
        long j = this.pr;
        return (int) (j ^ (j >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.pr == ((c) obj).pr();
    }

    public String toString() {
        return x(this.pr);
    }

    private static void pr(StringBuilder sb, long j) {
        String hexString = Long.toHexString(j);
        for (int length = hexString.length(); length < 8; length++) {
            sb.append('0');
        }
        sb.append(hexString);
    }

    public static String x(long j) {
        StringBuilder sb = new StringBuilder();
        pr(sb, (j >>> 32) & 4294967295L);
        sb.append('.');
        pr(sb, j & 4294967295L);
        return sb.toString();
    }

    public String c() {
        if (this.hw == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, MMM dd yyyy HH:mm:ss.SSS", Locale.US);
            this.hw = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
        }
        return this.hw.format(hn());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        long j = this.pr;
        long j2 = cVar.pr;
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }
}
