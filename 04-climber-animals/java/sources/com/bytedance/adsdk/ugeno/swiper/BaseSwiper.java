package com.bytedance.adsdk.ugeno.swiper;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bytedance.adsdk.ugeno.swiper.indicator.BaseIndicator;
import com.bytedance.adsdk.ugeno.swiper.indicator.DotIndicator;
import com.bytedance.adsdk.ugeno.swiper.indicator.RectangleIndicator;
import com.bytedance.adsdk.ugeno.swiper.ms.ah;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;
import com.bytedance.sdk.component.utils.sl;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseSwiper<T> extends FrameLayout implements ViewPager.d {
    private static final Interpolator yu = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.swiper.BaseSwiper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private int ab;
    protected Context ah;
    private boolean ao;
    private FrameLayout b;
    private int c;
    private String ch;
    private int d;
    private boolean h;
    private float hi;
    private ms i;
    private int ka;
    private final Runnable le;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected List<T> f389ms;
    private int nw;
    private int ny;
    private final Runnable op;
    private int qv;
    private BaseIndicator re;
    private boolean sl;
    private int t;
    private boolean u;
    private boolean ub;
    private com.bytedance.adsdk.ugeno.swiper.ms w;
    private int x;
    protected ViewPager xr;
    private int y;
    private boolean zb;

    public abstract View ab(int i);

    public BaseSwiper(Context context) {
        super(context);
        this.f389ms = new CopyOnWriteArrayList();
        this.d = 2000;
        this.ka = 500;
        this.c = 500;
        this.ab = 0;
        this.x = -1;
        this.ny = -1;
        this.ch = PrerollVideoResponse.NORMAL;
        this.hi = 1.0f;
        this.sl = true;
        this.zb = true;
        this.u = true;
        this.ub = true;
        this.qv = 0;
        this.y = 0;
        this.t = 0;
        this.nw = 0;
        this.op = new Runnable() { // from class: com.bytedance.adsdk.ugeno.swiper.BaseSwiper.2
            @Override // java.lang.Runnable
            public void run() {
                int currentItem = BaseSwiper.this.xr.getCurrentItem() + 1;
                if (BaseSwiper.this.u) {
                    if (currentItem >= 1024) {
                        BaseSwiper.this.xr.ms(512, false);
                        return;
                    } else {
                        BaseSwiper.this.xr.ms(currentItem, true);
                        return;
                    }
                }
                if (currentItem >= BaseSwiper.this.xr.getAdapter().ms()) {
                    BaseSwiper.this.xr.ms(0, false);
                } else {
                    BaseSwiper.this.xr.ms(currentItem, true);
                }
            }
        };
        this.le = new Runnable() { // from class: com.bytedance.adsdk.ugeno.swiper.BaseSwiper.3
            @Override // java.lang.Runnable
            public void run() {
                if (BaseSwiper.this.zb) {
                    int currentItem = BaseSwiper.this.xr.getCurrentItem() + 1;
                    if (BaseSwiper.this.u) {
                        if (currentItem >= 1024) {
                            BaseSwiper.this.xr.ms(512, false);
                        } else {
                            BaseSwiper.this.xr.ms(currentItem, true);
                        }
                        BaseSwiper baseSwiper = BaseSwiper.this;
                        baseSwiper.postDelayed(baseSwiper.le, BaseSwiper.this.d);
                        return;
                    }
                    if (currentItem >= BaseSwiper.this.xr.getAdapter().ms()) {
                        BaseSwiper.this.xr.ms(0, false);
                        BaseSwiper baseSwiper2 = BaseSwiper.this;
                        baseSwiper2.postDelayed(baseSwiper2.le, BaseSwiper.this.d);
                    } else {
                        BaseSwiper.this.xr.ms(currentItem, true);
                        BaseSwiper baseSwiper3 = BaseSwiper.this;
                        baseSwiper3.postDelayed(baseSwiper3.le, BaseSwiper.this.d);
                    }
                }
            }
        };
        this.ah = context;
        this.b = new FrameLayout(context);
        this.xr = ms();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.b.addView(this.xr, layoutParams);
        addView(this.b);
    }

    public ViewPager ms() {
        return new SwiperViewPager(getContext());
    }

    public BaseSwiper ms(String str) {
        if (TextUtils.equals(str, "rectangle")) {
            this.re = new RectangleIndicator(this.ah);
        } else {
            this.re = new DotIndicator(this.ah);
        }
        addView(this.re, new FrameLayout.LayoutParams(-2, -2));
        return this;
    }

    public BaseSwiper ms(boolean z) {
        this.zb = z;
        ah();
        return this;
    }

    public BaseSwiper ms(int i) {
        this.d = i;
        ah();
        return this;
    }

    public BaseSwiper xr(boolean z) {
        this.ub = z;
        return this;
    }

    public BaseSwiper ah(boolean z) {
        this.sl = z;
        return this;
    }

    public BaseSwiper xr(int i) {
        this.re.setSelectedColor(i);
        return this;
    }

    public BaseSwiper ah(int i) {
        this.re.setUnSelectedColor(i);
        return this;
    }

    public BaseSwiper d(boolean z) {
        this.re.setLoop(z);
        if (this.u != z) {
            int iMs = xr.ms(z, this.xr.getCurrentItem(), this.f389ms.size());
            this.u = z;
            ms msVar = this.i;
            if (msVar != null) {
                msVar.ah();
                this.xr.setCurrentItem(iMs);
            }
        }
        return this;
    }

    public BaseSwiper ms(float f) {
        this.hi = f;
        return this;
    }

    public BaseSwiper xr(String str) {
        this.ch = str;
        ms(str, this.ab, this.x, this.ny, true);
        return this;
    }

    public BaseSwiper d(int i) {
        this.ab = i;
        ms(this.ch, i, this.x, this.ny, true);
        return this;
    }

    public BaseSwiper<T> ka(int i) {
        this.x = i;
        ms(this.ch, this.ab, i, this.ny, true);
        return this;
    }

    public BaseSwiper c(int i) {
        this.ny = i;
        ms(this.ch, this.ab, this.x, i, true);
        return this;
    }

    public void ms(String str, int i, int i2, int i3, boolean z) {
        ms msVar = this.i;
        if (msVar != null) {
            msVar.ah();
        }
        this.xr.setPageMargin(i);
        if (i2 > 0 || i3 > 0) {
            if (this.nw == 1) {
                this.xr.setPadding(0, i2 + i, 0, i3 + i);
            } else {
                this.xr.setPadding(i2 + i, 0, i3 + i, 0);
            }
            this.b.setClipChildren(false);
            this.xr.setClipChildren(false);
            this.xr.setClipToPadding(false);
        }
        if (this.nw == 1) {
            ah ahVar = new ah();
            ahVar.ms(str);
            this.xr.ms(true, (ViewPager.ka) ahVar);
            this.xr.setOverScrollMode(2);
        } else if (TextUtils.equals(str, "linear")) {
            this.xr.ms(false, (ViewPager.ka) new com.bytedance.adsdk.ugeno.swiper.ms.xr());
        } else if (TextUtils.equals(str, "cube")) {
            this.xr.ms(false, (ViewPager.ka) new com.bytedance.adsdk.ugeno.swiper.ms.ms());
        } else {
            this.xr.ms(false, (ViewPager.ka) null);
        }
        this.xr.setOffscreenPageLimit((int) this.hi);
    }

    public void xr() {
        int i;
        ms(this.ch, this.ab, this.x, this.ny, true);
        if (this.i == null) {
            this.i = new ms();
            this.xr.ms((ViewPager.d) this);
            this.xr.setAdapter(this.i);
        }
        int i2 = this.qv;
        if (i2 < 0 || i2 >= this.f389ms.size()) {
            this.qv = 0;
        }
        if (this.u) {
            i = this.qv + 512;
        } else {
            i = this.qv;
        }
        this.xr.ms(i, true);
        if (!this.u) {
            x(i);
        }
        if (this.zb) {
            ah();
        }
    }

    public void setTwoItems(boolean z) {
        this.h = z;
    }

    public View ms(int i, int i2) {
        if (this.f389ms.size() == 0) {
            return new View(getContext());
        }
        View viewAb = ab(i2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (viewAb instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (ab()) {
            viewAb.setTag("two_items_tag");
        }
        if (viewAb.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewAb.getParent()).removeView(viewAb);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(viewAb, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        if (ab()) {
            frameLayout.setTag(Integer.valueOf(i));
        }
        return frameLayout;
    }

    public BaseSwiper<T> ms(T t) {
        if (t != null) {
            this.f389ms.add(t);
            if (this.sl) {
                this.re.ms();
            }
        }
        ms msVar = this.i;
        if (msVar != null) {
            msVar.ah();
            this.re.ms(this.qv, this.xr.getCurrentItem());
        }
        return this;
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.d
    public void ms(int i, float f, int i2) {
        if (this.w != null) {
            xr.ms(this.u, i, this.f389ms.size());
        }
        if (ab()) {
            ms(i, findViewWithTag(Integer.valueOf(i)));
            if (f > 0.0f) {
                int i3 = i + 1;
                ms(i3, findViewWithTag(Integer.valueOf(i3)));
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.d
    public void x(int i) {
        if (this.w != null) {
            int iMs = xr.ms(this.u, i, this.f389ms.size());
            this.w.ms(this.u, iMs, i, iMs == 0, iMs == this.f389ms.size() - 1);
        }
        if (this.sl) {
            this.re.ms(i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.d
    public void ny(int i) {
        if (i == 1 && this.ao) {
            d();
        }
    }

    class ms extends com.bytedance.adsdk.ugeno.viewpager.xr {
        @Override // com.bytedance.adsdk.ugeno.viewpager.xr
        public int ms(Object obj) {
            return -2;
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.xr
        public boolean ms(View view, Object obj) {
            return view == obj;
        }

        ms() {
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.xr
        public int ms() {
            if (BaseSwiper.this.u) {
                return 1024;
            }
            return BaseSwiper.this.f389ms.size();
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.xr
        public Object ms(ViewGroup viewGroup, int i) {
            View viewMs = BaseSwiper.this.ms(i, xr.ms(BaseSwiper.this.u, i, BaseSwiper.this.f389ms.size()));
            viewGroup.addView(viewMs);
            return viewMs;
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.xr
        public void ms(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.xr
        public float ms(int i) {
            if (BaseSwiper.this.hi <= 0.0f) {
                return 1.0f;
            }
            return 1.0f / BaseSwiper.this.hi;
        }
    }

    public void ah() {
        removeCallbacks(this.le);
        postDelayed(this.le, this.d);
    }

    public void d() {
        removeCallbacks(this.le);
    }

    public void ka() {
        int i;
        ms(this.ch, this.ab, this.x, this.ny, true);
        if (this.i == null) {
            this.i = new ms();
            this.xr.ms((ViewPager.d) this);
            this.xr.setAdapter(this.i);
        }
        int i2 = this.qv;
        if (i2 < 0 || i2 >= this.f389ms.size()) {
            this.qv = 0;
        }
        if (this.u) {
            i = this.qv + 512;
        } else {
            i = this.qv;
        }
        this.xr.ms(i, true);
    }

    public void ch(int i) {
        ms(this.ch, this.ab, this.x, this.ny, true);
        if (this.i == null) {
            this.i = new ms();
            this.xr.ms((ViewPager.d) this);
            this.xr.setAdapter(this.i);
        }
        if (this.u) {
            if (i >= 1024) {
                this.xr.ms(512, false);
                return;
            } else {
                this.xr.ms(i, true);
                return;
            }
        }
        if (i < 0 || i >= this.f389ms.size()) {
            return;
        }
        this.xr.ms(i, true);
    }

    public void hi(int i) {
        removeCallbacks(this.op);
        postDelayed(this.op, i);
    }

    public void c() {
        removeCallbacks(this.op);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.zb) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                if (!this.ao) {
                    ah();
                }
            } else if (action == 0) {
                d();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCurrentItem() {
        return this.xr.getCurrentItem();
    }

    public com.bytedance.adsdk.ugeno.viewpager.xr getAdapter() {
        return this.xr.getAdapter();
    }

    public ViewPager getViewPager() {
        return this.xr;
    }

    public void setOnPageChangeListener(com.bytedance.adsdk.ugeno.swiper.ms msVar) {
        this.w = msVar;
    }

    public class SwiperViewPager extends ViewPager {
        public SwiperViewPager(Context context) {
            super(context);
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!BaseSwiper.this.ub) {
                return false;
            }
            try {
                if (BaseSwiper.this.nw == 1) {
                    boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(ms(motionEvent));
                    ms(motionEvent);
                    return zOnInterceptTouchEvent;
                }
                return super.onInterceptTouchEvent(motionEvent);
            } catch (IllegalArgumentException e) {
                sl.ms(e);
                return false;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!BaseSwiper.this.ub) {
                return false;
            }
            try {
                if (BaseSwiper.this.nw == 1) {
                    return super.onTouchEvent(ms(motionEvent));
                }
                return super.onTouchEvent(motionEvent);
            } catch (IllegalArgumentException e) {
                sl.ms(e);
                return false;
            }
        }

        private MotionEvent ms(MotionEvent motionEvent) {
            float width = getWidth();
            float height = getHeight();
            motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
            return motionEvent;
        }
    }

    private void ms(int i, View view) {
        View viewFindViewWithTag;
        if ((view instanceof ViewGroup) && (viewFindViewWithTag = view.findViewWithTag("two_items_tag")) == null) {
            T t = this.f389ms.get(xr.ms(true, i, this.f389ms.size()));
            if (t == null) {
                return;
            }
            if (t instanceof com.bytedance.adsdk.ugeno.xr.ah) {
                viewFindViewWithTag = ((com.bytedance.adsdk.ugeno.xr.ah) t).ny();
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

    private boolean ab() {
        return this.f389ms.size() <= 2 && this.u;
    }
}
