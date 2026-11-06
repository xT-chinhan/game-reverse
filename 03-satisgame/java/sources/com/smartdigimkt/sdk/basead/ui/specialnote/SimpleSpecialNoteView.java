package com.smartdigimkt.sdk.basead.ui.specialnote;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleSpecialNoteView extends BaseSpecialNoteView {
    public SimpleSpecialNoteView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.specialnote.BaseSpecialNoteView
    public final void a() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, getMeasuredHeight(), 0.0f);
        translateAnimation.setDuration(500L);
        startAnimation(translateAnimation);
        super.a();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.specialnote.BaseSpecialNoteView
    public final void c() {
        this.l = getContext().getString(k.a(SDKContext.getInstance().d(), "myoffer_special_note_delay_click_simple", "string"));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.specialnote.BaseSpecialNoteView
    public final void d() {
        setOrientation(0);
        int iA = k.a(getContext(), 5.0f);
        setPadding(iA, 0, iA, 0);
        setGravity(16);
        setBackgroundColor(Color.parseColor("#80000000"));
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_special_note_simple", "layout"), (ViewGroup) this, true);
        this.j = (TextView) findViewById(k.a(getContext(), "myoffer_special_countdown_text", "id"));
        this.k = (TextView) findViewById(k.a(getContext(), "myoffer_special_cancel_text", "id"));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.specialnote.BaseSpecialNoteView
    public final boolean e() {
        return true;
    }

    public SimpleSpecialNoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
