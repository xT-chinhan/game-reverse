package com.anythink.basead.ui.a;

import android.view.View;
import com.anythink.basead.ui.a.a.c;
import com.anythink.basead.ui.a.a.d;
import com.anythink.basead.ui.a.a.e;
import com.anythink.basead.ui.a.a.f;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;

    private static b a(int i, View view) {
        if (i == 2) {
            return new f(view);
        }
        if (i == 3) {
            return new d(view);
        }
        if (i == 4) {
            return new c(view);
        }
        if (i == 5) {
            return new com.anythink.basead.ui.a.a.b(view);
        }
        return new e(view);
    }
}
