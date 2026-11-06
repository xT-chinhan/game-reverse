package com.smartdigimkt.o1;

import android.view.View;
import com.smartdigimkt.p1.c;
import com.smartdigimkt.p1.d;
import com.smartdigimkt.p1.f;
import com.smartdigimkt.p1.h;
import com.smartdigimkt.p1.i;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static com.smartdigimkt.p1.b a(View view, int i) {
        if (i == 2) {
            return new i(view);
        }
        if (i == 3) {
            return new f(view);
        }
        if (i != 4) {
            return i != 5 ? new h(view) : new c(view);
        }
        return new d(view);
    }
}
