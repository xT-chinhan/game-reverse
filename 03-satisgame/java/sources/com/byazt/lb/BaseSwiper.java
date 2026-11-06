package com.byazt.lb;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.byazt.dsg.BaseIndicator;
import com.byazt.dsg.DotIndicator;
import com.byazt.dsg.RectangleIndicator;
import com.byazt.fg.q;
import com.byazt.fg.s;
import com.byazt.ln.ViewPager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 766, 931})
public abstract class BaseSwiper<T> extends FrameLayout implements ViewPager.q {
    public static final Interpolator bb = new Interpolator() { // from class: com.byazt.lb.BaseSwiper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    public int a;
    public boolean cd;
    public String cp;
    public boolean cy;
    public float d;
    public int fs;
    public com.byazt.lb.n h;
    public boolean hd;
    public n hu;
    public boolean k;
    public int l;
    public final Runnable lh;
    public final Runnable ln;
    public BaseIndicator m;
    public List<T> n;
    public boolean oa;
    public int ou;
    public int py;
    public int q;
    public ViewPager qg;
    public int rv;
    public Context s;
    public boolean sz;
    public Scroller t;
    public int tj;
    public int um;
    public boolean ur;
    public int w;
    public FrameLayout wm;
    public int x;

    public abstract View cp(int i);

    public BaseSwiper(Context context) {
        super(context);
        this.n = new CopyOnWriteArrayList();
        this.q = -1;
        this.l = 2000;
        this.w = 500;
        this.x = 500;
        this.fs = 0;
        this.rv = -1;
        this.tj = -1;
        this.cp = "normal";
        this.d = 1.0f;
        this.oa = true;
        this.sz = true;
        this.k = true;
        this.cy = true;
        this.um = 0;
        this.a = 0;
        this.py = 0;
        this.ou = 0;
        this.ur = true;
        this.ln = new Runnable() { // from class: com.byazt.lb.BaseSwiper.2
            @Override // java.lang.Runnable
            public void run() {
                int currentItem = BaseSwiper.this.qg.getCurrentItem() + 1;
                if (BaseSwiper.this.k) {
                    if (currentItem >= 1024) {
                        BaseSwiper.this.qg.n(512, false);
                        return;
                    } else {
                        BaseSwiper.this.qg.n(currentItem, true);
                        return;
                    }
                }
                com.byazt.ln.qg adapter = BaseSwiper.this.qg.getAdapter();
                if (adapter != null) {
                    if (currentItem >= adapter.n()) {
                        BaseSwiper.this.qg.n(0, false);
                    } else {
                        BaseSwiper.this.qg.n(currentItem, true);
                    }
                }
            }
        };
        this.lh = new Runnable() { // from class: com.byazt.lb.BaseSwiper.3
            @Override // java.lang.Runnable
            public void run() {
                if (BaseSwiper.this.sz) {
                    BaseSwiper.this.ur = false;
                    int currentItem = BaseSwiper.this.qg.getCurrentItem() + 1;
                    if (BaseSwiper.this.k) {
                        if (currentItem >= 1024) {
                            BaseSwiper.this.qg.n(512, false);
                        } else {
                            BaseSwiper.this.qg.n(currentItem, true);
                        }
                        BaseSwiper baseSwiper = BaseSwiper.this;
                        baseSwiper.postDelayed(baseSwiper.lh, BaseSwiper.this.l);
                        return;
                    }
                    com.byazt.ln.qg adapter = BaseSwiper.this.qg.getAdapter();
                    if (adapter != null) {
                        if (currentItem >= adapter.n()) {
                            BaseSwiper.this.qg.n(0, false);
                            BaseSwiper baseSwiper2 = BaseSwiper.this;
                            baseSwiper2.postDelayed(baseSwiper2.lh, BaseSwiper.this.l);
                        } else {
                            BaseSwiper.this.qg.n(currentItem, true);
                            BaseSwiper baseSwiper3 = BaseSwiper.this;
                            baseSwiper3.postDelayed(baseSwiper3.lh, BaseSwiper.this.l);
                        }
                    }
                }
            }
        };
        this.s = context;
        this.wm = new FrameLayout(context);
        this.qg = n();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.wm.addView(this.qg, layoutParams);
        addView(this.wm);
    }

    public ViewPager n() {
        return new SwiperViewPager(getContext());
    }

    public BaseSwiper n(String str) {
        if (TextUtils.equals(str, "rectangle")) {
            this.m = new RectangleIndicator(this.s);
        } else {
            this.m = new DotIndicator(this.s);
        }
        addView(this.m, new FrameLayout.LayoutParams(-2, -2));
        return this;
    }

    public BaseSwiper n(float f) {
        this.m.setIndicatorWidth((int) f);
        return this;
    }

    public BaseSwiper qg(float f) {
        this.m.setIndicatorHeight((int) f);
        return this;
    }

    public BaseSwiper s(float f) {
        this.m.setIndicatorX(f);
        return this;
    }

    public BaseSwiper q(float f) {
        this.m.setIndicatorY(f);
        return this;
    }

    public BaseSwiper qg() {
        this.m.n();
        return this;
    }

    public BaseSwiper qg(String str) {
        this.m.setIndicatorDirection(str);
        return this;
    }

    public BaseSwiper n(int i) {
        this.ou = i;
        return this;
    }

    public BaseSwiper n(boolean z) {
        this.sz = z;
        q();
        return this;
    }

    public BaseSwiper qg(int i) {
        this.w = i;
        return this;
    }

    public BaseSwiper s(int i) {
        this.x = i;
        if (this.t == null) {
            this.t = new qg(this.s, bb);
        }
        this.qg.setScroller(this.t);
        return this;
    }

    public BaseSwiper q(int i) {
        this.l = i;
        q();
        return this;
    }

    public BaseSwiper l(int i) {
        if (i < 0) {
            i = this.l;
        }
        this.q = i;
        q();
        return this;
    }

    public BaseSwiper qg(boolean z) {
        this.cy = z;
        return this;
    }

    public BaseSwiper s(boolean z) {
        this.oa = z;
        return this;
    }

    public BaseSwiper w(int i) {
        this.m.setSelectedColor(i);
        return this;
    }

    public BaseSwiper x(int i) {
        this.m.setUnSelectedColor(i);
        return this;
    }

    public BaseSwiper q(boolean z) {
        this.m.setLoop(z);
        if (this.k != z) {
            int iN = com.byazt.lb.qg.n(z, this.qg.getCurrentItem(), this.n.size());
            this.k = z;
            n nVar = this.hu;
            if (nVar != null) {
                nVar.s();
                this.qg.setCurrentItem(iN);
            }
        }
        return this;
    }

    public BaseSwiper l(float f) {
        this.d = f;
        return this;
    }

    public BaseSwiper s(String str) {
        this.cp = str;
        n(str, this.fs, this.rv, this.tj, true);
        return this;
    }

    public BaseSwiper fs(int i) {
        this.fs = i;
        n(this.cp, i, this.rv, this.tj, true);
        return this;
    }

    public BaseSwiper<T> rv(int i) {
        this.rv = i;
        n(this.cp, this.fs, i, this.tj, true);
        return this;
    }

    public BaseSwiper tj(int i) {
        this.tj = i;
        n(this.cp, this.fs, this.rv, i, true);
        return this;
    }

    public BaseSwiper l(boolean z) {
        this.hd = z;
        return this;
    }

    public void n(String str, int i, int i2, int i3, boolean z) {
        n nVar = this.hu;
        if (nVar != null) {
            nVar.s();
        }
        this.qg.setPageMargin(i);
        if (i2 > 0 || i3 > 0) {
            if (this.ou == 1) {
                this.qg.setPadding(0, i2 + i, 0, i3 + i);
            } else {
                this.qg.setPadding(i2 + i, 0, i3 + i, 0);
            }
            this.wm.setClipChildren(false);
            this.qg.setClipChildren(false);
            this.qg.setClipToPadding(false);
        }
        if (this.ou == 1) {
            q qVar = new q();
            qVar.n(str);
            this.qg.n(true, (ViewPager.l) qVar);
            this.qg.setOverScrollMode(2);
        } else if (TextUtils.equals(str, "linear")) {
            this.qg.n(false, (ViewPager.l) new s());
        } else if (TextUtils.equals(str, "cube")) {
            this.qg.n(false, (ViewPager.l) new com.byazt.fg.n());
        } else if (TextUtils.equals(str, "fade")) {
            this.qg.n(false, (ViewPager.l) new com.byazt.fg.qg());
        } else {
            this.qg.n(false, (ViewPager.l) null);
        }
        this.qg.setOffscreenPageLimit((int) this.d);
    }

    public void s() {
        int i;
        n(this.cp, this.fs, this.rv, this.tj, true);
        if (this.hu == null) {
            this.hu = new n();
            this.qg.n((ViewPager.q) this);
            this.qg.setAdapter(this.hu);
        }
        int i2 = this.um;
        if (i2 < 0 || i2 >= this.n.size()) {
            this.um = 0;
        }
        if (this.k) {
            i = this.um + 512;
        } else {
            i = this.um;
        }
        this.qg.n(i, true);
        if (!this.k) {
            d(i);
        }
        if (this.sz) {
            q();
        }
    }

    public void setTwoItems(boolean z) {
        this.cd = z;
    }

    public View n(int i, int i2) {
        if (this.n.size() == 0) {
            return new View(getContext());
        }
        View viewCp = cp(i2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (viewCp instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (fs()) {
            viewCp.setTag("two_items_tag");
        }
        if (viewCp.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewCp.getParent()).removeView(viewCp);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(viewCp, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        if (fs()) {
            frameLayout.setTag(Integer.valueOf(i));
        }
        return frameLayout;
    }

    public BaseSwiper<T> n(T t) {
        if (t != null) {
            this.n.add(t);
            if (this.oa) {
                this.m.qg();
            }
        }
        n nVar = this.hu;
        if (nVar != null) {
            nVar.s();
            this.m.n(this.um, this.qg.getCurrentItem());
        }
        return this;
    }

    @Override // com.byazt.ln.ViewPager.q
    public void n(int i, float f, int i2) {
        com.byazt.lb.n nVar = this.h;
        if (nVar != null) {
            boolean z = this.k;
            nVar.n(z, com.byazt.lb.qg.n(z, i, this.n.size()), f, i2);
        }
        if (fs()) {
            n(i, findViewWithTag(Integer.valueOf(i)));
            if (f > 0.0f) {
                int i3 = i + 1;
                n(i3, findViewWithTag(Integer.valueOf(i3)));
            }
        }
    }

    public void d(int i) {
        if (this.h != null) {
            int iN = com.byazt.lb.qg.n(this.k, i, this.n.size());
            this.h.n(this.k, iN, i, iN == 0, iN == this.n.size() - 1);
        }
        if (this.oa) {
            this.m.n(i);
        }
    }

    public void oa(int i) {
        if (i == 1 && this.hd) {
            l();
        }
        com.byazt.lb.n nVar = this.h;
        if (nVar != null) {
            nVar.n(this.k, i);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 766, 2250})
    class n extends com.byazt.ln.qg {
        @Override // com.byazt.ln.qg
        public int n(Object obj) {
            return -2;
        }

        @Override // com.byazt.ln.qg
        public boolean n(View view, Object obj) {
            return view == obj;
        }

        public n() {
        }

        @Override // com.byazt.ln.qg
        public int n() {
            if (BaseSwiper.this.k) {
                return 1024;
            }
            return BaseSwiper.this.n.size();
        }

        @Override // com.byazt.ln.qg
        public Object n(ViewGroup viewGroup, int i) {
            View viewN = BaseSwiper.this.n(i, com.byazt.lb.qg.n(BaseSwiper.this.k, i, BaseSwiper.this.n.size()));
            viewGroup.addView(viewN);
            return viewN;
        }

        @Override // com.byazt.ln.qg
        public void n(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // com.byazt.ln.qg
        public float n(int i) {
            if (BaseSwiper.this.d <= 0.0f) {
                return 1.0f;
            }
            return 1.0f / BaseSwiper.this.d;
        }
    }

    public void q() {
        int i;
        removeCallbacks(this.lh);
        int i2 = this.l;
        if (this.ur && (i = this.q) > 0) {
            i2 = i;
        }
        postDelayed(this.lh, i2);
    }

    public void l() {
        removeCallbacks(this.lh);
    }

    public void w() {
        int i;
        n(this.cp, this.fs, this.rv, this.tj, true);
        if (this.hu == null) {
            this.hu = new n();
            this.qg.n((ViewPager.q) this);
            this.qg.setAdapter(this.hu);
        }
        int i2 = this.um;
        if (i2 < 0 || i2 >= this.n.size()) {
            this.um = 0;
        }
        if (this.k) {
            i = this.um + 512;
        } else {
            i = this.um;
        }
        this.qg.n(i, true);
    }

    public void sz(int i) {
        n(this.cp, this.fs, this.rv, this.tj, true);
        if (this.hu == null) {
            this.hu = new n();
            this.qg.n((ViewPager.q) this);
            this.qg.setAdapter(this.hu);
        }
        if (this.k) {
            if (i >= 1024) {
                this.qg.n(512, false);
                return;
            } else {
                this.qg.n(i, true);
                return;
            }
        }
        if (i < 0 || i >= this.n.size()) {
            return;
        }
        this.qg.n(i, true);
    }

    public void k(int i) {
        removeCallbacks(this.ln);
        postDelayed(this.ln, i);
    }

    public void x() {
        removeCallbacks(this.ln);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.sz && this.cy) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                if (!this.hd) {
                    q();
                }
            } else if (action == 0) {
                l();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCurrentItem() {
        return this.qg.getCurrentItem();
    }

    public com.byazt.ln.qg getAdapter() {
        return this.qg.getAdapter();
    }

    public ViewPager getViewPager() {
        return this.qg;
    }

    public void setOnPageChangeListener(com.byazt.lb.n nVar) {
        this.h = nVar;
    }

    @com.byazt.cp.n(n = {0, 1, 766, 1757})
    public class SwiperViewPager extends ViewPager {
        public SwiperViewPager(Context context) {
            super(context);
        }

        @Override // com.byazt.ln.ViewPager, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!BaseSwiper.this.cy) {
                return false;
            }
            try {
                if (BaseSwiper.this.ou == 1) {
                    boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(n(motionEvent));
                    n(motionEvent);
                    return zOnInterceptTouchEvent;
                }
                return super.onInterceptTouchEvent(motionEvent);
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        @Override // com.byazt.ln.ViewPager, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!BaseSwiper.this.cy) {
                return false;
            }
            try {
                if (BaseSwiper.this.ou == 1) {
                    return super.onTouchEvent(n(motionEvent));
                }
                return super.onTouchEvent(motionEvent);
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        private MotionEvent n(MotionEvent motionEvent) {
            float width = getWidth();
            float height = getHeight();
            motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
            return motionEvent;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 766, 767})
    private class qg extends Scroller {
        public qg(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, BaseSwiper.this.x);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4) {
            super.startScroll(i, i2, i3, i4, BaseSwiper.this.x);
        }
    }

    private void n(int i, View view) {
        View viewFindViewWithTag;
        if ((view instanceof ViewGroup) && (viewFindViewWithTag = view.findViewWithTag("two_items_tag")) == null) {
            T t = this.n.get(com.byazt.lb.qg.n(true, i, this.n.size()));
            if (t == null) {
                return;
            }
            if (t instanceof com.byazt.ih.s) {
                viewFindViewWithTag = ((com.byazt.ih.s) t).rv();
            } else if (t instanceof View) {
                viewFindViewWithTag = (View) t;
            }
            if (viewFindViewWithTag == null) {
                return;
            }
            if (viewFindViewWithTag.getParent() instanceof ViewGroup) {
                ((ViewGroup) viewFindViewWithTag.getParent()).removeView(viewFindViewWithTag);
            }
            ((ViewGroup) view).addView(viewFindViewWithTag);
        }
    }

    private boolean fs() {
        return this.n.size() <= 2 && this.k;
    }
}
