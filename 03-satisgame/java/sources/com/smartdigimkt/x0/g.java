package com.smartdigimkt.x0;

import android.text.TextUtils;
import com.smartdigimkt.i0.s;
import com.smartdigimkt.z0.u;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends j {
    public final AtomicReference a = new AtomicReference(d.s);

    public static int a(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    public static boolean a(int i, boolean z) {
        int i2 = i & 7;
        return i2 == 4 || (z && i2 == 3);
    }

    public static boolean a(s sVar, String str) {
        return str != null && TextUtils.equals(str, u.b(sVar.y));
    }
}
