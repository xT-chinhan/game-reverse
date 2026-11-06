package com.anythink.basead.ui.specialnote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class ScreenSpecialNoteView extends BaseSpecialNoteView {
    @Override // com.anythink.basead.ui.specialnote.BaseSpecialNoteView
    protected final boolean d() {
        return false;
    }

    public ScreenSpecialNoteView(Context context) {
        super(context);
    }

    public ScreenSpecialNoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.anythink.basead.ui.specialnote.BaseSpecialNoteView
    protected final void b() {
        setOrientation(0);
        setPadding(q.a(getContext(), 10.0f), 0, q.a(getContext(), 12.0f), 0);
        setGravity(16);
        setBackgroundResource(q.a(t.b().g(), "myoffer_bg_shake_border_thumb", "drawable"));
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_special_note", "layout"), (ViewGroup) this, true);
        this.l = (TextView) findViewById(q.a(getContext(), "myoffer_special_countdown_text", "id"));
        this.m = (TextView) findViewById(q.a(getContext(), "myoffer_special_cancel_text", "id"));
    }

    @Override // com.anythink.basead.ui.specialnote.BaseSpecialNoteView
    protected final void c() {
        TranslateAnimation translateAnimation = new TranslateAnimation(getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(500L);
        startAnimation(translateAnimation);
        super.c();
    }
}
