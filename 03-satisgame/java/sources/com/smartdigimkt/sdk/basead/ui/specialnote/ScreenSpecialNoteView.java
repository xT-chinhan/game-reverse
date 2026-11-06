package com.smartdigimkt.sdk.basead.ui.specialnote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public class ScreenSpecialNoteView extends BaseSpecialNoteView {
    public ScreenSpecialNoteView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.specialnote.BaseSpecialNoteView
    public final void a() {
        TranslateAnimation translateAnimation = new TranslateAnimation(getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(500L);
        startAnimation(translateAnimation);
        super.a();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.specialnote.BaseSpecialNoteView
    public final void d() {
        setOrientation(0);
        setPadding(k.a(getContext(), 10.0f), 0, k.a(getContext(), 12.0f), 0);
        setGravity(16);
        setBackgroundResource(k.a(SDKContext.getInstance().d(), "myoffer_bg_shake_border_thumb", "drawable"));
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_special_note", "layout"), (ViewGroup) this, true);
        this.j = (TextView) findViewById(k.a(getContext(), "myoffer_special_countdown_text", "id"));
        this.k = (TextView) findViewById(k.a(getContext(), "myoffer_special_cancel_text", "id"));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.specialnote.BaseSpecialNoteView
    public final boolean e() {
        return false;
    }

    public ScreenSpecialNoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
