package com.anythink.basead.ui.specialnote;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class SimpleSpecialNoteView extends BaseSpecialNoteView {
    @Override // com.anythink.basead.ui.specialnote.BaseSpecialNoteView
    protected final boolean d() {
        return true;
    }

    public SimpleSpecialNoteView(Context context) {
        super(context);
    }

    public SimpleSpecialNoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.anythink.basead.ui.specialnote.BaseSpecialNoteView
    protected final void b() {
        setOrientation(0);
        int iA = q.a(getContext(), 5.0f);
        setPadding(iA, 0, iA, 0);
        setGravity(16);
        setBackgroundColor(Color.parseColor("#80000000"));
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_special_note_simple", "layout"), (ViewGroup) this, true);
        this.l = (TextView) findViewById(q.a(getContext(), "myoffer_special_countdown_text", "id"));
        this.m = (TextView) findViewById(q.a(getContext(), "myoffer_special_cancel_text", "id"));
    }

    @Override // com.anythink.basead.ui.specialnote.BaseSpecialNoteView
    protected final void a() {
        this.n = getContext().getString(q.a(t.b().g(), "myoffer_special_note_delay_click_simple", "string"));
    }

    @Override // com.anythink.basead.ui.specialnote.BaseSpecialNoteView
    protected final void c() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, getMeasuredHeight(), 0.0f);
        translateAnimation.setDuration(500L);
        startAnimation(translateAnimation);
        super.c();
    }
}
