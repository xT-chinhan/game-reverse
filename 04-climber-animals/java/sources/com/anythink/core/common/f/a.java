package com.anythink.core.common.f;

import android.content.Context;
import com.anythink.core.common.e.e;
import com.anythink.core.common.e.n;
import com.anythink.core.common.h.be;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {
    n a;
    protected int b;

    protected a(Context context) {
        this.a = n.a(e.a(context));
    }

    public final void a(String str, int i, int i2) {
        this.a.a(this.b, str, i, i2);
    }

    public final void a(String str, long j) {
        this.a.a(this.b, str, j);
    }

    public final void a(String str, String str2) {
        this.a.a(str, this.b, str2);
    }

    private List<be> a() {
        return this.a.a(this.b);
    }

    public final List<be> a(List<String> list) {
        return this.a.a(list, this.b);
    }
}
