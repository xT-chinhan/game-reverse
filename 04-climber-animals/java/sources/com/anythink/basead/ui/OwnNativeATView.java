package com.anythink.basead.ui;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.basead.ui.guidetoclickv2.d;

/* JADX INFO: loaded from: classes.dex */
public class OwnNativeATView extends FrameLayout implements com.anythink.basead.ui.guidetoclickv2.c {
    d a;
    private com.anythink.basead.ui.f.c b;
    private a c;

    public interface a {
        void a();

        void b();
    }

    public OwnNativeATView(Context context) {
        super(context);
    }

    public OwnNativeATView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OwnNativeATView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setClickRecordHelper(com.anythink.basead.ui.f.c cVar) {
        this.b = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        com.anythink.basead.ui.f.c cVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            com.anythink.basead.ui.f.c cVar2 = this.b;
            if (cVar2 != null) {
                cVar2.a((int) motionEvent.getRawX(), (int) motionEvent.getRawY(), (int) motionEvent.getX(), (int) motionEvent.getY());
            }
        } else if ((action == 1 || action == 3) && (cVar = this.b) != null) {
            cVar.b((int) motionEvent.getRawX(), (int) motionEvent.getRawY(), (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean a(MotionEvent motionEvent) {
        synchronized (this) {
            try {
                d dVar = this.a;
                if (dVar != null && dVar.a(motionEvent)) {
                    return true;
                }
            } catch (Throwable unused) {
            }
            return false;
        }
    }

    public com.anythink.basead.d.a getAdClickRecord() {
        com.anythink.basead.ui.f.c cVar = this.b;
        if (cVar != null) {
            return cVar.a();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.c
    public void setCallback(d dVar) {
        synchronized (this) {
            this.a = dVar;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (z) {
            a();
        } else {
            b();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (Build.VERSION.SDK_INT < 28) {
            if (z) {
                a();
            } else {
                b();
            }
        }
    }

    private void a() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void b() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void setLifeCallback(a aVar) {
        this.c = aVar;
    }

    public void releaseAllCallback() {
        this.a = null;
        this.b = null;
        this.c = null;
    }
}
