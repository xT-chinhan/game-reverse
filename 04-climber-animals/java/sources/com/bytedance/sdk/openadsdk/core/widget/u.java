package com.bytedance.sdk.openadsdk.core.widget;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class u {
    private int ab;
    private int c;
    private float d;
    private boolean hi;
    private float ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ms f3740ms;
    private boolean xr = false;
    private boolean ah = false;
    private boolean x = true;
    private boolean ny = false;
    private final View.OnTouchListener ch = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.u.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (u.this.f3740ms.ub()) {
                return u.this.xr || !u.this.ah;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                u uVar = u.this;
                uVar.hi = uVar.ms(motionEvent);
                u.this.d = x;
                u.this.ka = y;
                u.this.c = (int) x;
                u.this.ab = (int) y;
                u.this.x = true;
                if (u.this.f3740ms != null && u.this.ah && !u.this.xr) {
                    u.this.f3740ms.ms(view, true);
                }
            } else if (action == 1) {
                if (Math.abs(x - u.this.c) > 20.0f || Math.abs(y - u.this.ab) > 20.0f) {
                    u.this.x = false;
                }
                if (!u.this.xr) {
                    u.this.x = true;
                }
                u.this.ny = false;
                u.this.d = 0.0f;
                u.this.ka = 0.0f;
                u.this.c = 0;
                if (u.this.f3740ms != null) {
                    u.this.f3740ms.ms(view, u.this.x);
                }
                u.this.hi = false;
            } else if (action != 2) {
                if (action == 3) {
                    u.this.hi = false;
                }
            } else if (u.this.xr && !u.this.hi) {
                float f = x - u.this.d;
                float f2 = y - u.this.ka;
                float fAbs = Math.abs(f);
                float fAbs2 = Math.abs(f2);
                if (!u.this.ny) {
                    if (fAbs <= 20.0f && fAbs2 <= 20.0f) {
                        return true;
                    }
                    u.this.ny = true;
                }
                if (u.this.f3740ms != null) {
                    u.this.f3740ms.u();
                }
                u.this.d = x;
                u.this.ka = y;
            }
            return u.this.xr || !u.this.ah;
        }
    };

    public interface ms {
        void ms(View view, boolean z);

        void u();

        boolean ub();
    }

    public u(ms msVar) {
        this.f3740ms = msVar;
    }

    public void ms(View view) {
        if (view != null) {
            view.setOnTouchListener(this.ch);
        }
    }

    public void ms(boolean z) {
        this.ah = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ms(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        int iD = ul.d(re.getContext().getApplicationContext());
        int iKa = ul.ka(re.getContext().getApplicationContext());
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f = iD;
        if (rawX <= f * 0.01f || rawX >= f * 0.99f) {
            return true;
        }
        float f2 = iKa;
        return rawY <= 0.01f * f2 || rawY >= f2 * 0.99f;
    }
}
