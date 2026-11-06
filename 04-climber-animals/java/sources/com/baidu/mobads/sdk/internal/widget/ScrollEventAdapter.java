package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class ScrollEventAdapter extends RecyclerView.OnScrollListener {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = -1;
    private ViewPager2.OnPageChangeCallback g;
    private final ViewPager2 h;
    private final RecyclerView i;
    private final LinearLayoutManager j;
    private int k;
    private int l;
    private ScrollEventValues m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;

    @Retention(RetentionPolicy.SOURCE)
    private @interface AdapterState {
    }

    ScrollEventAdapter(ViewPager2 viewPager2) {
        this.h = viewPager2;
        RecyclerView recyclerView = viewPager2.j;
        this.i = recyclerView;
        this.j = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.m = new ScrollEventValues();
        i();
    }

    private void i() {
        this.k = 0;
        this.l = 0;
        this.m.a();
        this.n = -1;
        this.o = -1;
        this.p = false;
        this.q = false;
        this.s = false;
        this.r = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        boolean z = true;
        if ((this.k != 1 || this.l != 1) && i == 1) {
            a(false);
            return;
        }
        if (k() && i == 2) {
            if (this.q) {
                a(2);
                this.p = true;
                return;
            }
            return;
        }
        if (k() && i == 0) {
            j();
            if (!this.q) {
                if (this.m.a != -1) {
                    a(this.m.a, 0.0f, 0);
                }
            } else if (this.m.c != 0) {
                z = false;
            } else if (this.n != this.m.a) {
                b(this.m.a);
            }
            if (z) {
                a(0);
                i();
            }
        }
        if (this.k == 2 && i == 0 && this.r) {
            j();
            if (this.m.c == 0) {
                if (this.o != this.m.a) {
                    b(this.m.a == -1 ? 0 : this.m.a);
                }
                a(0);
                i();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0022  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        boolean z;
        this.q = true;
        j();
        if (this.p) {
            this.p = false;
            if (i2 > 0) {
                z = true;
            } else {
                if (i2 == 0) {
                    if ((i < 0) == this.h.c()) {
                        z = true;
                    }
                }
                z = false;
            }
            int i3 = (!z || this.m.c == 0) ? this.m.a : this.m.a + 1;
            this.o = i3;
            if (this.n != i3) {
                b(i3);
            }
        } else if (this.k == 0) {
            int i4 = this.m.a;
            if (i4 == -1) {
                i4 = 0;
            }
            b(i4);
        }
        a(this.m.a == -1 ? 0 : this.m.a, this.m.b, this.m.c);
        int i5 = this.m.a;
        int i6 = this.o;
        if ((i5 == i6 || i6 == -1) && this.m.c == 0 && this.l != 1) {
            a(0);
            i();
        }
    }

    private void j() {
        int top;
        ScrollEventValues scrollEventValues = this.m;
        scrollEventValues.a = this.j.findFirstVisibleItemPosition();
        if (scrollEventValues.a == -1) {
            scrollEventValues.a();
            return;
        }
        View viewFindViewByPosition = this.j.findViewByPosition(scrollEventValues.a);
        if (viewFindViewByPosition == null) {
            scrollEventValues.a();
            return;
        }
        int leftDecorationWidth = this.j.getLeftDecorationWidth(viewFindViewByPosition);
        int rightDecorationWidth = this.j.getRightDecorationWidth(viewFindViewByPosition);
        int topDecorationHeight = this.j.getTopDecorationHeight(viewFindViewByPosition);
        int bottomDecorationHeight = this.j.getBottomDecorationHeight(viewFindViewByPosition);
        ViewGroup.LayoutParams layoutParams = viewFindViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = viewFindViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = viewFindViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.j.getOrientation() == 0) {
            top = (viewFindViewByPosition.getLeft() - leftDecorationWidth) - this.i.getPaddingLeft();
            if (this.h.c()) {
                top = -top;
            }
            height = width;
        } else {
            top = (viewFindViewByPosition.getTop() - topDecorationHeight) - this.i.getPaddingTop();
        }
        scrollEventValues.c = -top;
        if (scrollEventValues.c < 0) {
            if (new AnimateLayoutChangeDetector(this.j).a()) {
                throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
            }
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.c)));
        }
        scrollEventValues.b = height == 0 ? 0.0f : scrollEventValues.c / height;
    }

    private void a(boolean z) {
        this.s = z;
        this.k = z ? 4 : 1;
        int i = this.o;
        if (i != -1) {
            this.n = i;
            this.o = -1;
        } else if (this.n == -1) {
            this.n = l();
        }
        a(1);
    }

    void a() {
        this.r = true;
    }

    void a(int i, boolean z) {
        this.k = z ? 2 : 3;
        this.s = false;
        boolean z2 = this.o != i;
        this.o = i;
        a(2);
        if (z2) {
            b(i);
        }
    }

    void b() {
        this.k = 4;
        a(true);
    }

    void c() {
        if (!f() || this.s) {
            this.s = false;
            j();
            if (this.m.c == 0) {
                if (this.m.a != this.n) {
                    b(this.m.a);
                }
                a(0);
                i();
                return;
            }
            a(2);
        }
    }

    void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.g = onPageChangeCallback;
    }

    int d() {
        return this.l;
    }

    boolean e() {
        return this.l == 0;
    }

    boolean f() {
        return this.l == 1;
    }

    boolean g() {
        return this.s;
    }

    private boolean k() {
        int i = this.k;
        return i == 1 || i == 4;
    }

    double h() {
        j();
        return ((double) this.m.a) + ((double) this.m.b);
    }

    private void a(int i) {
        if ((this.k == 3 && this.l == 0) || this.l == i) {
            return;
        }
        this.l = i;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(i);
        }
    }

    private void b(int i) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i);
        }
    }

    private void a(int i, float f2, int i2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i, f2, i2);
        }
    }

    private int l() {
        return this.j.findFirstVisibleItemPosition();
    }

    private static final class ScrollEventValues {
        int a;
        float b;
        int c;

        ScrollEventValues() {
        }

        void a() {
            this.a = -1;
            this.b = 0.0f;
            this.c = 0;
        }
    }
}
