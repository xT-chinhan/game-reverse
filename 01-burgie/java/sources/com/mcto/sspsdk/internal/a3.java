package com.mcto.sspsdk.internal;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public final class a3 extends Drawable.ConstantState {
    public final /* synthetic */ b3 a;

    public a3(b3 b3Var) {
        this.a = b3Var;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return this.a;
    }
}
