package com.mcto.sspsdk.internal;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public final class vj extends b3 {
    public Drawable g;
    public int h = -1;

    public vj(Drawable drawable) {
        this.g = drawable;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.g = this.g.mutate();
        return this;
    }
}
