package com.anythink.core.common.inner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class CloseShadeView extends View {
    private final String a;
    private boolean b;
    private View.OnClickListener c;
    private View.OnTouchListener d;

    public CloseShadeView(Context context) {
        this(context, null);
    }

    public CloseShadeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CloseShadeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = "CloseShadeView";
        this.b = false;
        setClickable(true);
    }

    private void a() {
        setClickable(true);
    }

    public boolean isTouch() {
        return this.b;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.c = onClickListener;
        super.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.core.common.inner.ui.CloseShadeView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CloseShadeView.a(CloseShadeView.this);
                if (CloseShadeView.this.c != null) {
                    CloseShadeView.this.c.onClick(view);
                }
            }
        });
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.d = onTouchListener;
        super.setOnTouchListener(new View.OnTouchListener() { // from class: com.anythink.core.common.inner.ui.CloseShadeView.2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                CloseShadeView.a(CloseShadeView.this, motionEvent);
                if (CloseShadeView.this.d != null) {
                    return CloseShadeView.this.d.onTouch(view, motionEvent);
                }
                return false;
            }
        });
    }

    private void b() {
        this.b = true;
        c();
    }

    private void c() {
        if (getVisibility() != 8) {
            setVisibility(8);
        }
    }

    private void a(MotionEvent motionEvent) {
        this.b = true;
        if (motionEvent.getAction() != 0) {
            return;
        }
        c();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    static /* synthetic */ void a(CloseShadeView closeShadeView) {
        closeShadeView.b = true;
        closeShadeView.c();
    }

    static /* synthetic */ void a(CloseShadeView closeShadeView, MotionEvent motionEvent) {
        closeShadeView.b = true;
        if (motionEvent.getAction() != 0) {
            return;
        }
        closeShadeView.c();
    }
}
