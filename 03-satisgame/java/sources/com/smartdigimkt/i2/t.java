package com.smartdigimkt.i2;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes3.dex */
public final class t {
    public int b;
    public int c;
    public com.smartdigimkt.e2.a e;
    public int a = -1;
    public boolean d = false;

    /* JADX WARN: Code duplicated, block: B:21:0x003f  */
    public final boolean a(MotionEvent motionEvent) {
        com.smartdigimkt.e2.a aVar;
        int iFindPointerIndex;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.b = (int) motionEvent.getY();
            this.c = (int) motionEvent.getX();
            this.a = motionEvent.getPointerId(0);
            this.d = false;
        } else if (action == 1) {
            if (this.d && (aVar = this.e) != null) {
                aVar.a(13, 13);
            }
            int iFindPointerIndex2 = motionEvent.findPointerIndex(this.a);
            this.c = (int) motionEvent.getX(iFindPointerIndex2);
            this.b = (int) motionEvent.getY(iFindPointerIndex2);
            this.d = false;
            this.a = -1;
        } else if (action == 2) {
            int i = this.a;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                int y = (int) motionEvent.getY(iFindPointerIndex);
                int x = (int) motionEvent.getX(iFindPointerIndex);
                int iAbs = Math.abs(y - this.b);
                int iAbs2 = Math.abs(x - this.c);
                if (iAbs > 10 || iAbs2 > 10) {
                    this.d = true;
                }
            }
        } else if (action == 3) {
            if (this.d) {
                aVar.a(13, 13);
            }
            int iFindPointerIndex3 = motionEvent.findPointerIndex(this.a);
            this.c = (int) motionEvent.getX(iFindPointerIndex3);
            this.b = (int) motionEvent.getY(iFindPointerIndex3);
            this.d = false;
            this.a = -1;
        }
        return this.d;
    }

    public final void a(View view, MotionEvent motionEvent) {
        com.smartdigimkt.e2.a aVar;
        int iFindPointerIndex;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.b = (int) motionEvent.getY();
            this.c = (int) motionEvent.getX();
            this.a = motionEvent.getPointerId(0);
            this.d = false;
            return;
        }
        if (action == 1) {
            if (this.d && (aVar = this.e) != null) {
                aVar.a(13, 13);
            }
            int iFindPointerIndex2 = motionEvent.findPointerIndex(this.a);
            this.c = (int) motionEvent.getX(iFindPointerIndex2);
            this.b = (int) motionEvent.getY(iFindPointerIndex2);
            this.d = false;
            this.a = -1;
            return;
        }
        if (action == 2 && (iFindPointerIndex = motionEvent.findPointerIndex(this.a)) != -1) {
            int x = (int) motionEvent.getX(iFindPointerIndex);
            int y = (int) motionEvent.getY(iFindPointerIndex);
            int iAbs = Math.abs(x - this.c);
            if (Math.abs(y - this.b) > 10 || iAbs > 10) {
                this.d = true;
                ViewParent parent = view.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
    }
}
