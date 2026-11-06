package com.mcto.sspsdk.internal;

import android.transition.Transition;

/* JADX INFO: loaded from: classes2.dex */
public final class oe extends je {
    public final /* synthetic */ ve a;

    public oe(ve veVar) {
        this.a = veVar;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        r0.a(this.a.g);
    }
}
