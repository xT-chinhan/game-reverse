package com.mcto.sspsdk.internal;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class td implements m7 {
    public final WeakReference a;

    public td(View view) {
        this.a = new WeakReference(view);
    }
}
