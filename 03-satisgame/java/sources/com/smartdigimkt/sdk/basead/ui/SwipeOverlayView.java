package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.smartdigimkt.n1.i6;
import com.smartdigimkt.n1.j6;
import com.smartdigimkt.r4.k;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SwipeOverlayView extends FrameLayout {
    public static final int SWIPE_TYPE_ALL_DIRECTION = 3;
    public static final int SWIPE_TYPE_HORIZONTAL = 1;
    public static final int SWIPE_TYPE_VERTICAL = 2;
    public int a;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public Map f;
    public float g;
    public float h;
    public long i;
    public j6 j;
    public i6 k;

    public SwipeOverlayView(Context context) {
        super(context);
        setBackgroundColor(0);
    }

    public boolean checkSwipeTrigger(float f, float f2) {
        int i = this.a;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return false;
                }
                if (Math.sqrt((f2 * f2) + (f * f)) < this.b) {
                    return false;
                }
            } else if (Math.abs(f2) < this.b) {
                return false;
            }
        } else if (Math.abs(f) < this.b) {
            return false;
        }
        return true;
    }

    public Integer findClickAreaAt(float f, float f2) {
        int i;
        try {
            Map map = this.f;
            if (map != null && !map.isEmpty()) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                int i2 = (int) (iArr[0] + f);
                int i3 = (int) (iArr[1] + f2);
                for (Map.Entry entry : this.f.entrySet()) {
                    View view = (View) entry.getKey();
                    if (view != null && view.getVisibility() == 0 && view.getWidth() != 0 && view.getHeight() != 0) {
                        int[] iArr2 = new int[2];
                        view.getLocationOnScreen(iArr2);
                        int i4 = iArr2[0];
                        if (i2 >= i4 && i2 < view.getWidth() + i4 && i3 >= (i = iArr2[1]) && i3 < view.getHeight() + i) {
                            Integer num = (Integer) entry.getValue();
                            view.getClass();
                            return num;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0063  */
    /* JADX WARN: Code duplicated, block: B:30:0x0065  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (motionEvent == null) {
            return false;
        }
        if (motionEvent.getAction() != 0) {
            return this.d;
        }
        Map map = this.f;
        if (map != null && !map.isEmpty()) {
            if (findClickAreaAt(motionEvent.getX(), motionEvent.getY()) != null) {
                this.d = false;
                return false;
            }
        }
        if (this.e) {
            if (!k.b(getContext())) {
                if (motionEvent.getY() >= getHeight() / 2) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                float width = getWidth();
                float f = width / 4.0f;
                float f2 = (width * 3.0f) / 4.0f;
                float x = motionEvent.getX();
                if (x < f || x > f2) {
                    z = false;
                } else {
                    z = true;
                }
            }
            if (!z) {
                this.d = false;
                return false;
            }
        }
        this.d = true;
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null || !this.d) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.g = motionEvent.getX();
            this.h = motionEvent.getY();
            this.i = System.currentTimeMillis();
            this.c = false;
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                if (this.c) {
                    return true;
                }
                if (checkSwipeTrigger(motionEvent.getX() - this.g, motionEvent.getY() - this.h)) {
                    this.c = true;
                    j6 j6Var = this.j;
                    if (j6Var != null) {
                        j6Var.a();
                    }
                }
                return true;
            }
            if (action != 3) {
                return false;
            }
        }
        if (findClickAreaAt(motionEvent.getX(), motionEvent.getY()) != null) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        long jCurrentTimeMillis = System.currentTimeMillis();
        float f = x - this.g;
        float f2 = y - this.h;
        if (!(((float) Math.sqrt((double) ((f2 * f2) + (f * f)))) <= 10.0f && jCurrentTimeMillis - this.i <= 300)) {
            return false;
        }
        i6 i6Var = this.k;
        if (i6Var != null) {
            i6Var.a(x, y);
        }
        return true;
    }

    public void setEndCardClickArea(int i) {
        this.e = i == 1;
    }

    public void setExcludeViews(Map<View, Integer> map) {
        if (map != null) {
            this.f = map;
        }
    }

    public void setOnCommonClickListener(i6 i6Var) {
        this.k = i6Var;
    }

    public void setOnSwipeClickListener(j6 j6Var) {
        this.j = j6Var;
    }

    public void setSwipeThreshold(int i) {
        this.b = i;
    }

    public void setSwipeType(int i) {
        this.a = i;
    }
}
