package com.anythink.basead.exoplayer.k;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class w {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    private static boolean b(int i, int i2) {
        if (i == 0) {
            return true;
        }
        if (i != 1) {
            return i == 2 && (i2 & 2) != 0;
        }
        return (i2 & 1) != 0;
    }

    private w() {
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001a  */
    private static int a(int i, int i2) {
        boolean z;
        for (int i3 = 1; i3 <= 2; i3++) {
            int i4 = (i + i3) % 3;
            if (i4 != 0) {
                z = false;
                if (i4 == 1 ? (i2 & 1) != 0 : !(i4 != 2 || (i2 & 2) == 0)) {
                    z = true;
                }
            } else {
                z = true;
            }
            if (z) {
                return i4;
            }
        }
        return i;
    }
}
