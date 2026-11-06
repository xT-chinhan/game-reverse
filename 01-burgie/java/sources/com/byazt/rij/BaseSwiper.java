package com.byazt.rij;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.byazt.cqf.ViewPager;
import com.byazt.ngw.hn;
import com.byazt.ngw.x;
import com.byazt.rsw.BaseIndicator;
import com.byazt.rsw.DotIndicator;
import com.byazt.rsw.RectangleIndicator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.internal.runtime.view.LinearContainerViewManager;
import com.taptap.sdk.update.download.DownloadTask;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH, 878})
public abstract class BaseSwiper<T> extends FrameLayout implements ViewPager.x {
    public static final Interpolator gz = new Interpolator() { // from class: com.byazt.rij.BaseSwiper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    public int a;
    public int aj;
    public com.byazt.rij.pr b;
    public int c;
    public int cz;
    public FrameLayout fo;
    public int fw;
    public boolean g;
    public Context hn;
    public boolean ho;
    public ViewPager hw;
    public Scroller iu;
    public float k;
    public boolean lb;
    public boolean m;
    public final Runnable nl;
    public boolean nt;
    public int ny;
    public List<T> pr;
    public int qa;
    public BaseIndicator rc;
    public int uc;
    public boolean ve;
    public int vk;
    public String w;
    public int x;
    public final Runnable y;
    public boolean yb;
    public pr z;
    public int zo;

    public abstract View w(int i);

    public BaseSwiper(Context context) {
        super(context);
        this.pr = new CopyOnWriteArrayList();
        this.x = -1;
        this.c = DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS;
        this.uc = 500;
        this.fw = 500;
        this.zo = 0;
        this.aj = -1;
        this.vk = -1;
        this.w = "normal";
        this.k = 1.0f;
        this.m = true;
        this.g = true;
        this.ho = true;
        this.nt = true;
        this.qa = 0;
        this.a = 0;
        this.cz = 0;
        this.ny = 0;
        this.ve = true;
        this.nl = new Runnable() { // from class: com.byazt.rij.BaseSwiper.2
            @Override // java.lang.Runnable
            public void run() {
                int currentItem = BaseSwiper.this.hw.getCurrentItem() + 1;
                if (BaseSwiper.this.ho) {
                    if (currentItem >= 1024) {
                        BaseSwiper.this.hw.pr(512, false);
                        return;
                    } else {
                        BaseSwiper.this.hw.pr(currentItem, true);
                        return;
                    }
                }
                com.byazt.cqf.hw adapter = BaseSwiper.this.hw.getAdapter();
                if (adapter != null) {
                    if (currentItem >= adapter.pr()) {
                        BaseSwiper.this.hw.pr(0, false);
                    } else {
                        BaseSwiper.this.hw.pr(currentItem, true);
                    }
                }
            }
        };
        this.y = new Runnable() { // from class: com.byazt.rij.BaseSwiper.3
            @Override // java.lang.Runnable
            public void run() {
                if (BaseSwiper.this.g) {
                    BaseSwiper.this.ve = false;
                    int currentItem = BaseSwiper.this.hw.getCurrentItem() + 1;
                    if (BaseSwiper.this.ho) {
                        if (currentItem >= 1024) {
                            BaseSwiper.this.hw.pr(512, false);
                        } else {
                            BaseSwiper.this.hw.pr(currentItem, true);
                        }
                        BaseSwiper baseSwiper = BaseSwiper.this;
                        baseSwiper.postDelayed(baseSwiper.y, BaseSwiper.this.c);
                        return;
                    }
                    com.byazt.cqf.hw adapter = BaseSwiper.this.hw.getAdapter();
                    if (adapter != null) {
                        if (currentItem >= adapter.pr()) {
                            BaseSwiper.this.hw.pr(0, false);
                            BaseSwiper baseSwiper2 = BaseSwiper.this;
                            baseSwiper2.postDelayed(baseSwiper2.y, BaseSwiper.this.c);
                        } else {
                            BaseSwiper.this.hw.pr(currentItem, true);
                            BaseSwiper baseSwiper3 = BaseSwiper.this;
                            baseSwiper3.postDelayed(baseSwiper3.y, BaseSwiper.this.c);
                        }
                    }
                }
            }
        };
        this.hn = context;
        this.fo = new FrameLayout(context);
        this.hw = pr();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.fo.addView(this.hw, layoutParams);
        addView(this.fo);
    }

    public ViewPager pr() {
        return new SwiperViewPager(getContext());
    }

    public BaseSwiper pr(String str) {
        if (TextUtils.equals(str, "rectangle")) {
            this.rc = new RectangleIndicator(this.hn);
        } else {
            this.rc = new DotIndicator(this.hn);
        }
        addView(this.rc, new FrameLayout.LayoutParams(-2, -2));
        return this;
    }

    public BaseSwiper pr(float f) {
        this.rc.setIndicatorWidth((int) f);
        return this;
    }

    public BaseSwiper hw(float f) {
        this.rc.setIndicatorHeight((int) f);
        return this;
    }

    public BaseSwiper hn(float f) {
        this.rc.setIndicatorX(f);
        return this;
    }

    public BaseSwiper x(float f) {
        this.rc.setIndicatorY(f);
        return this;
    }

    public BaseSwiper hw() {
        this.rc.pr();
        return this;
    }

    public BaseSwiper hw(String str) {
        this.rc.setIndicatorDirection(str);
        return this;
    }

    public BaseSwiper pr(int i) {
        this.ny = i;
        return this;
    }

    public BaseSwiper pr(boolean z) {
        this.g = z;
        x();
        return this;
    }

    public BaseSwiper hw(int i) {
        this.uc = i;
        return this;
    }

    public BaseSwiper hn(int i) {
        this.fw = i;
        if (this.iu == null) {
            this.iu = new hw(this.hn, gz);
        }
        this.hw.setScroller(this.iu);
        return this;
    }

    public BaseSwiper x(int i) {
        this.c = i;
        x();
        return this;
    }

    public BaseSwiper c(int i) {
        if (i < 0) {
            i = this.c;
        }
        this.x = i;
        x();
        return this;
    }

    public BaseSwiper hw(boolean z) {
        this.nt = z;
        return this;
    }

    public BaseSwiper hn(boolean z) {
        this.m = z;
        return this;
    }

    public BaseSwiper uc(int i) {
        this.rc.setSelectedColor(i);
        return this;
    }

    public BaseSwiper fw(int i) {
        this.rc.setUnSelectedColor(i);
        return this;
    }

    public BaseSwiper x(boolean z) {
        this.rc.setLoop(z);
        if (this.ho != z) {
            int iPr = com.byazt.rij.hw.pr(z, this.hw.getCurrentItem(), this.pr.size());
            this.ho = z;
            pr prVar = this.z;
            if (prVar != null) {
                prVar.hn();
                this.hw.setCurrentItem(iPr);
            }
        }
        return this;
    }

    public BaseSwiper c(float f) {
        this.k = f;
        return this;
    }

    public BaseSwiper hn(String str) {
        this.w = str;
        pr(str, this.zo, this.aj, this.vk, true);
        return this;
    }

    public BaseSwiper zo(int i) {
        this.zo = i;
        pr(this.w, i, this.aj, this.vk, true);
        return this;
    }

    public BaseSwiper<T> aj(int i) {
        this.aj = i;
        pr(this.w, this.zo, i, this.vk, true);
        return this;
    }

    public BaseSwiper vk(int i) {
        this.vk = i;
        pr(this.w, this.zo, this.aj, i, true);
        return this;
    }

    public BaseSwiper c(boolean z) {
        this.yb = z;
        return this;
    }

    public void pr(String str, int i, int i2, int i3, boolean z) {
        pr prVar = this.z;
        if (prVar != null) {
            prVar.hn();
        }
        this.hw.setPageMargin(i);
        if (i2 > 0 || i3 > 0) {
            if (this.ny == 1) {
                this.hw.setPadding(0, i2 + i, 0, i3 + i);
            } else {
                this.hw.setPadding(i2 + i, 0, i3 + i, 0);
            }
            this.fo.setClipChildren(false);
            this.hw.setClipChildren(false);
            this.hw.setClipToPadding(false);
        }
        if (this.ny == 1) {
            x xVar = new x();
            xVar.pr(str);
            this.hw.pr(true, (ViewPager.c) xVar);
            this.hw.setOverScrollMode(2);
        } else if (TextUtils.equals(str, LinearContainerViewManager.NAME)) {
            this.hw.pr(false, (ViewPager.c) new hn());
        } else if (TextUtils.equals(str, "cube")) {
            this.hw.pr(false, (ViewPager.c) new com.byazt.ngw.pr());
        } else if (TextUtils.equals(str, "fade")) {
            this.hw.pr(false, (ViewPager.c) new com.byazt.ngw.hw());
        } else {
            this.hw.pr(false, (ViewPager.c) null);
        }
        this.hw.setOffscreenPageLimit((int) this.k);
    }

    public void hn() {
        int i;
        pr(this.w, this.zo, this.aj, this.vk, true);
        if (this.z == null) {
            this.z = new pr();
            this.hw.pr((ViewPager.x) this);
            this.hw.setAdapter(this.z);
        }
        int i2 = this.qa;
        if (i2 < 0 || i2 >= this.pr.size()) {
            this.qa = 0;
        }
        if (this.ho) {
            i = this.qa + 512;
        } else {
            i = this.qa;
        }
        this.hw.pr(i, true);
        if (!this.ho) {
            k(i);
        }
        if (this.g) {
            x();
        }
    }

    public void setTwoItems(boolean z) {
        this.lb = z;
    }

    public View pr(int i, int i2) {
        if (this.pr.size() == 0) {
            return new View(getContext());
        }
        View viewW = w(i2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (viewW instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (zo()) {
            viewW.setTag("two_items_tag");
        }
        if (viewW.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewW.getParent()).removeView(viewW);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(viewW, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        if (zo()) {
            frameLayout.setTag(Integer.valueOf(i));
        }
        return frameLayout;
    }

    public BaseSwiper<T> pr(T t) {
        if (t != null) {
            this.pr.add(t);
            if (this.m) {
                this.rc.hw();
            }
        }
        pr prVar = this.z;
        if (prVar != null) {
            prVar.hn();
            this.rc.pr(this.qa, this.hw.getCurrentItem());
        }
        return this;
    }

    @Override // com.byazt.cqf.ViewPager.x
    public void pr(int i, float f, int i2) {
        com.byazt.rij.pr prVar = this.b;
        if (prVar != null) {
            boolean z = this.ho;
            prVar.pr(z, com.byazt.rij.hw.pr(z, i, this.pr.size()), f, i2);
        }
        if (zo()) {
            pr(i, findViewWithTag(Integer.valueOf(i)));
            if (f > 0.0f) {
                int i3 = i + 1;
                pr(i3, findViewWithTag(Integer.valueOf(i3)));
            }
        }
    }

    public void k(int i) {
        if (this.b != null) {
            int iPr = com.byazt.rij.hw.pr(this.ho, i, this.pr.size());
            this.b.pr(this.ho, iPr, i, iPr == 0, iPr == this.pr.size() - 1);
        }
        if (this.m) {
            this.rc.pr(i);
        }
    }

    public void m(int i) {
        if (i == 1 && this.yb) {
            c();
        }
        com.byazt.rij.pr prVar = this.b;
        if (prVar != null) {
            prVar.pr(this.ho, i);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_TYPE})
    class pr extends com.byazt.cqf.hw {
        public pr() {
        }

        @Override // com.byazt.cqf.hw
        public int pr() {
            if (BaseSwiper.this.ho) {
                return 1024;
            }
            return BaseSwiper.this.pr.size();
        }

        @Override // com.byazt.cqf.hw
        public boolean pr(View view, Object obj) {
            return view == obj;
        }

        @Override // com.byazt.cqf.hw
        public Object pr(ViewGroup viewGroup, int i) {
            View viewPr = BaseSwiper.this.pr(i, com.byazt.rij.hw.pr(BaseSwiper.this.ho, i, BaseSwiper.this.pr.size()));
            viewGroup.addView(viewPr);
            return viewPr;
        }

        @Override // com.byazt.cqf.hw
        public void pr(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // com.byazt.cqf.hw
        public float pr(int i) {
            if (BaseSwiper.this.k <= 0.0f) {
                return 1.0f;
            }
            return 1.0f / BaseSwiper.this.k;
        }

        @Override // com.byazt.cqf.hw
        public int pr(Object obj) {
            return -2;
        }
    }

    public void x() {
        int i;
        removeCallbacks(this.y);
        int i2 = this.c;
        if (this.ve && (i = this.x) > 0) {
            i2 = i;
        }
        postDelayed(this.y, i2);
    }

    public void c() {
        removeCallbacks(this.y);
    }

    public void uc() {
        int i;
        pr(this.w, this.zo, this.aj, this.vk, true);
        if (this.z == null) {
            this.z = new pr();
            this.hw.pr((ViewPager.x) this);
            this.hw.setAdapter(this.z);
        }
        int i2 = this.qa;
        if (i2 < 0 || i2 >= this.pr.size()) {
            this.qa = 0;
        }
        if (this.ho) {
            i = this.qa + 512;
        } else {
            i = this.qa;
        }
        this.hw.pr(i, true);
    }

    public void g(int i) {
        pr(this.w, this.zo, this.aj, this.vk, true);
        if (this.z == null) {
            this.z = new pr();
            this.hw.pr((ViewPager.x) this);
            this.hw.setAdapter(this.z);
        }
        if (this.ho) {
            if (i >= 1024) {
                this.hw.pr(512, false);
                return;
            } else {
                this.hw.pr(i, true);
                return;
            }
        }
        if (i < 0 || i >= this.pr.size()) {
            return;
        }
        this.hw.pr(i, true);
    }

    public void ho(int i) {
        removeCallbacks(this.nl);
        postDelayed(this.nl, i);
    }

    public void fw() {
        removeCallbacks(this.nl);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.g && this.nt) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                if (!this.yb) {
                    x();
                }
            } else if (action == 0) {
                c();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCurrentItem() {
        return this.hw.getCurrentItem();
    }

    public com.byazt.cqf.hw getAdapter() {
        return this.hw.getAdapter();
    }

    public ViewPager getViewPager() {
        return this.hw;
    }

    public void setOnPageChangeListener(com.byazt.rij.pr prVar) {
        this.b = prVar;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH, 1611})
    public class SwiperViewPager extends ViewPager {
        public SwiperViewPager(Context context) {
            super(context);
        }

        @Override // com.byazt.cqf.ViewPager, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (BaseSwiper.this.nt) {
                try {
                    if (BaseSwiper.this.ny == 1) {
                        boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(pr(motionEvent));
                        pr(motionEvent);
                        return zOnInterceptTouchEvent;
                    }
                    return super.onInterceptTouchEvent(motionEvent);
                } catch (IllegalArgumentException e) {
                    return false;
                }
            }
            return false;
        }

        @Override // com.byazt.cqf.ViewPager, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (BaseSwiper.this.nt) {
                try {
                    if (BaseSwiper.this.ny == 1) {
                        return super.onTouchEvent(pr(motionEvent));
                    }
                    return super.onTouchEvent(motionEvent);
                } catch (IllegalArgumentException e) {
                    return false;
                }
            }
            return false;
        }

        private MotionEvent pr(MotionEvent motionEvent) {
            float width = getWidth();
            float height = getHeight();
            motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
            return motionEvent;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH, 696})
    private class hw extends Scroller {
        public hw(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, BaseSwiper.this.fw);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4) {
            super.startScroll(i, i2, i3, i4, BaseSwiper.this.fw);
        }
    }

    private void pr(int i, View view) {
        View viewFindViewWithTag;
        if (!(view instanceof ViewGroup) || (viewFindViewWithTag = view.findViewWithTag("two_items_tag")) != null) {
            return;
        }
        T t = this.pr.get(com.byazt.rij.hw.pr(true, i, this.pr.size()));
        if (t == null) {
            return;
        }
        if (t instanceof com.byazt.ik.hn) {
            viewFindViewWithTag = ((com.byazt.ik.hn) t).aj();
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

    private boolean zo() {
        return this.pr.size() <= 2 && this.ho;
    }
}
