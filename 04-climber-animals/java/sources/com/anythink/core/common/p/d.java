package com.anythink.core.common.p;

import android.content.Context;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface d {
    void a(int i);

    void a(Context context, ATAdRequest aTAdRequest, int i);

    void a(AdError adError, int i, boolean z);

    void a(b bVar);

    boolean a(int i, List<String> list);

    boolean b();

    void c();

    void d();
}
