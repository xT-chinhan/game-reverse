package com.smartdigimkt.h2;

import android.animation.ValueAnimator;
import com.smartdigimkt.sdk.basead.ui.specialnote.BaseSpecialNoteView;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BaseSpecialNoteView a;

    public e(BaseSpecialNoteView baseSpecialNoteView) {
        this.a = baseSpecialNoteView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
