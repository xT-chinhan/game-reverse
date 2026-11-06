package com.anythink.basead.exoplayer.d;

import android.util.Pair;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class p {
    public static final String a = "LicenseDurationRemaining";
    public static final String b = "PlaybackDurationRemaining";

    private p() {
    }

    public static Pair<Long, Long> a(f<?> fVar) {
        Map<String, String> mapH = fVar.h();
        if (mapH == null) {
            return null;
        }
        return new Pair<>(Long.valueOf(a(mapH, a)), Long.valueOf(a(mapH, b)));
    }

    private static long a(Map<String, String> map, String str) {
        if (map == null) {
            return -9223372036854775807L;
        }
        try {
            String str2 = map.get(str);
            if (str2 != null) {
                return Long.parseLong(str2);
            }
            return -9223372036854775807L;
        } catch (NumberFormatException unused) {
            return -9223372036854775807L;
        }
    }
}
