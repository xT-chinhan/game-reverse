package com.anythink.basead.ui.f;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    private static final String a = "TouchEventClickTrigger";
    private static final int b = -1;
    private static final int c = 10;
    private int e;
    private int f;
    private com.anythink.basead.ui.d.a h;
    private boolean i;
    private int d = -1;
    private boolean g = false;

    public final e a(boolean z) {
        this.i = z;
        return this;
    }

    public final e a(com.anythink.basead.ui.d.a aVar) {
        this.h = aVar;
        return this;
    }

    private void a(final View view) {
        if (this.i) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.anythink.basead.ui.f.e.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    try {
                        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        View view2 = view;
                        while (view2.getParent() != null) {
                            Object parent = view2.getParent();
                            if (!(parent instanceof View)) {
                                break;
                            } else {
                                view2 = (View) parent;
                            }
                        }
                        View view3 = view;
                        if (view2 == view3) {
                            return;
                        }
                        final int[] iArr = new int[2];
                        view3.getLocationOnScreen(iArr);
                        final int width = view.getWidth();
                        final int height = view.getHeight();
                        final boolean[] zArr = {false};
                        view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.anythink.basead.ui.f.e.1.1
                            @Override // android.view.View.OnTouchListener
                            public final boolean onTouch(View view4, MotionEvent motionEvent) {
                                int rawX = (int) motionEvent.getRawX();
                                int rawY = (int) motionEvent.getRawY();
                                int[] iArr2 = iArr;
                                int i = iArr2[0];
                                int i2 = iArr2[1];
                                int action = motionEvent.getAction();
                                if (action == 0) {
                                    zArr[0] = false;
                                } else if (action != 1) {
                                    if (action == 2 && rawX > i && rawX < i + width && rawY > i2 && rawY < i2 + height) {
                                        zArr[0] = true;
                                    }
                                } else if (zArr[0]) {
                                    e.this.a(12);
                                }
                                return false;
                            }
                        });
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.anythink.basead.ui.d.a aVar = this.h;
        if (aVar != null) {
            aVar.a(i, 13);
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0042  */
    public final boolean a(MotionEvent motionEvent) {
        int iFindPointerIndex;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.e = (int) motionEvent.getY();
            this.f = (int) motionEvent.getX();
            this.d = motionEvent.getPointerId(0);
            this.g = false;
        } else if (action == 1) {
            if (this.g) {
                a(13);
            }
            int iFindPointerIndex2 = motionEvent.findPointerIndex(this.d);
            this.f = (int) motionEvent.getX(iFindPointerIndex2);
            this.e = (int) motionEvent.getY(iFindPointerIndex2);
            this.g = false;
            this.d = -1;
        } else if (action == 2) {
            int i = this.d;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                int y = (int) motionEvent.getY(iFindPointerIndex);
                int x = (int) motionEvent.getX(iFindPointerIndex);
                int iAbs = Math.abs(y - this.e);
                int iAbs2 = Math.abs(x - this.f);
                if (iAbs > 10 || iAbs2 > 10) {
                    this.g = true;
                }
            }
        } else if (action == 3) {
            if (this.g) {
                a(13);
            }
            int iFindPointerIndex3 = motionEvent.findPointerIndex(this.d);
            this.f = (int) motionEvent.getX(iFindPointerIndex3);
            this.e = (int) motionEvent.getY(iFindPointerIndex3);
            this.g = false;
            this.d = -1;
        }
        return this.g;
    }

    public final boolean a(View view, MotionEvent motionEvent) {
        int iFindPointerIndex;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.e = (int) motionEvent.getY();
            this.f = (int) motionEvent.getX();
            this.d = motionEvent.getPointerId(0);
            this.g = false;
        } else if (action == 1) {
            if (this.g) {
                a(13);
            }
            int iFindPointerIndex2 = motionEvent.findPointerIndex(this.d);
            this.f = (int) motionEvent.getX(iFindPointerIndex2);
            this.e = (int) motionEvent.getY(iFindPointerIndex2);
            this.g = false;
            this.d = -1;
        } else if (action == 2 && (iFindPointerIndex = motionEvent.findPointerIndex(this.d)) != -1) {
            int x = (int) motionEvent.getX(iFindPointerIndex);
            int y = (int) motionEvent.getY(iFindPointerIndex);
            int iAbs = Math.abs(x - this.f);
            if (Math.abs(y - this.e) > 10 || iAbs > 10) {
                this.g = true;
                ViewParent parent = view.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        return true;
    }
}
