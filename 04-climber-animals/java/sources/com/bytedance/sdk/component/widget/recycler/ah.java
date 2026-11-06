package com.bytedance.sdk.component.widget.recycler;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends hi {
    private static TimeInterpolator ny;
    private ArrayList<RecyclerView.re> ch = new ArrayList<>();
    private ArrayList<RecyclerView.re> hi = new ArrayList<>();
    private ArrayList<xr> sl = new ArrayList<>();
    private ArrayList<ms> zb = new ArrayList<>();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.re>> f1398ms = new ArrayList<>();
    ArrayList<ArrayList<xr>> xr = new ArrayList<>();
    ArrayList<ArrayList<ms>> ah = new ArrayList<>();
    ArrayList<RecyclerView.re> d = new ArrayList<>();
    ArrayList<RecyclerView.re> ka = new ArrayList<>();
    ArrayList<RecyclerView.re> c = new ArrayList<>();
    ArrayList<RecyclerView.re> ab = new ArrayList<>();

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public void ms() {
        boolean z = !this.ch.isEmpty();
        boolean z2 = !this.sl.isEmpty();
        boolean z3 = !this.zb.isEmpty();
        boolean z4 = !this.hi.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.re> it = this.ch.iterator();
            while (it.hasNext()) {
                hi(it.next());
            }
            this.ch.clear();
            if (z2) {
                final ArrayList<xr> arrayList = new ArrayList<>();
                arrayList.addAll(this.sl);
                this.xr.add(arrayList);
                this.sl.clear();
                Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.ah.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (xr xrVar : arrayList) {
                            ah.this.xr(xrVar.f1408ms, xrVar.xr, xrVar.ah, xrVar.d, xrVar.ka);
                        }
                        arrayList.clear();
                        ah.this.xr.remove(arrayList);
                    }
                };
                if (z) {
                    com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ms(arrayList.get(0).f1408ms.f1391ms, runnable, ab());
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<ms> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.zb);
                this.ah.add(arrayList2);
                this.zb.clear();
                Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.ah.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            ah.this.ms((ms) it2.next());
                        }
                        arrayList2.clear();
                        ah.this.ah.remove(arrayList2);
                    }
                };
                if (z) {
                    com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ms(arrayList2.get(0).f1407ms.f1391ms, runnable2, ab());
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final ArrayList<RecyclerView.re> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.hi);
                this.f1398ms.add(arrayList3);
                this.hi.clear();
                Runnable runnable3 = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.ah.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            ah.this.ah((RecyclerView.re) it2.next());
                        }
                        arrayList3.clear();
                        ah.this.f1398ms.remove(arrayList3);
                    }
                };
                if (!z && !z2 && !z3) {
                    runnable3.run();
                } else {
                    com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ms(arrayList3.get(0).f1391ms, runnable3, (z ? ab() : 0L) + Math.max(z2 ? ka() : 0L, z3 ? x() : 0L));
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.hi
    public boolean ms(RecyclerView.re reVar) {
        sl(reVar);
        this.ch.add(reVar);
        return true;
    }

    private void hi(final RecyclerView.re reVar) {
        final View view = reVar.f1391ms;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.c.add(reVar);
        viewPropertyAnimatorAnimate.setDuration(ab()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.ah.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                view.setAlpha(1.0f);
                ah.this.x(reVar);
                ah.this.c.remove(reVar);
                ah.this.ah();
            }
        }).start();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.hi
    public boolean xr(RecyclerView.re reVar) {
        sl(reVar);
        reVar.f1391ms.setAlpha(0.0f);
        this.hi.add(reVar);
        return true;
    }

    void ah(final RecyclerView.re reVar) {
        final View view = reVar.f1391ms;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.d.add(reVar);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(c()).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.ah.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                ah.this.ch(reVar);
                ah.this.d.remove(reVar);
                ah.this.ah();
            }
        }).start();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.hi
    public boolean ms(RecyclerView.re reVar, int i, int i2, int i3, int i4) {
        View view = reVar.f1391ms;
        int translationX = i + ((int) reVar.f1391ms.getTranslationX());
        int translationY = i2 + ((int) reVar.f1391ms.getTranslationY());
        sl(reVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            ny(reVar);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.sl.add(new xr(reVar, translationX, translationY, i3, i4));
        return true;
    }

    void xr(final RecyclerView.re reVar, int i, int i2, int i3, int i4) {
        final View view = reVar.f1391ms;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.ka.add(reVar);
        viewPropertyAnimatorAnimate.setDuration(ka()).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.ah.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i5 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i6 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                ah.this.ny(reVar);
                ah.this.ka.remove(reVar);
                ah.this.ah();
            }
        }).start();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.hi
    public boolean ms(RecyclerView.re reVar, RecyclerView.re reVar2, int i, int i2, int i3, int i4) {
        if (reVar == reVar2) {
            return ms(reVar, i, i2, i3, i4);
        }
        float translationX = reVar.f1391ms.getTranslationX();
        float translationY = reVar.f1391ms.getTranslationY();
        float alpha = reVar.f1391ms.getAlpha();
        sl(reVar);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        reVar.f1391ms.setTranslationX(translationX);
        reVar.f1391ms.setTranslationY(translationY);
        reVar.f1391ms.setAlpha(alpha);
        if (reVar2 != null) {
            sl(reVar2);
            reVar2.f1391ms.setTranslationX(-i5);
            reVar2.f1391ms.setTranslationY(-i6);
            reVar2.f1391ms.setAlpha(0.0f);
        }
        this.zb.add(new ms(reVar, reVar2, i, i2, i3, i4));
        return true;
    }

    void ms(final ms msVar) {
        RecyclerView.re reVar = msVar.f1407ms;
        final View view = reVar == null ? null : reVar.f1391ms;
        RecyclerView.re reVar2 = msVar.xr;
        final View view2 = reVar2 != null ? reVar2.f1391ms : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(x());
            this.ab.add(msVar.f1407ms);
            duration.translationX(msVar.ka - msVar.ah);
            duration.translationY(msVar.c - msVar.d);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.ah.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    ah.this.ms(msVar.f1407ms, true);
                    ah.this.ab.remove(msVar.f1407ms);
                    ah.this.ah();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.ab.add(msVar.xr);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(x()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.ah.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    ah.this.ms(msVar.xr, false);
                    ah.this.ab.remove(msVar.xr);
                    ah.this.ah();
                }
            }).start();
        }
    }

    private void ms(List<ms> list, RecyclerView.re reVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ms msVar = list.get(size);
            if (ms(msVar, reVar) && msVar.f1407ms == null && msVar.xr == null) {
                list.remove(msVar);
            }
        }
    }

    private void xr(ms msVar) {
        if (msVar.f1407ms != null) {
            ms(msVar, msVar.f1407ms);
        }
        if (msVar.xr != null) {
            ms(msVar, msVar.xr);
        }
    }

    private boolean ms(ms msVar, RecyclerView.re reVar) {
        boolean z = false;
        if (msVar.xr == reVar) {
            msVar.xr = null;
        } else {
            if (msVar.f1407ms != reVar) {
                return false;
            }
            msVar.f1407ms = null;
            z = true;
        }
        reVar.f1391ms.setAlpha(1.0f);
        reVar.f1391ms.setTranslationX(0.0f);
        reVar.f1391ms.setTranslationY(0.0f);
        ms(reVar, z);
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public void d(RecyclerView.re reVar) {
        View view = reVar.f1391ms;
        view.animate().cancel();
        int size = this.sl.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.sl.get(size).f1408ms == reVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                ny(reVar);
                this.sl.remove(size);
            }
        }
        ms(this.zb, reVar);
        if (this.ch.remove(reVar)) {
            view.setAlpha(1.0f);
            x(reVar);
        }
        if (this.hi.remove(reVar)) {
            view.setAlpha(1.0f);
            ch(reVar);
        }
        for (int size2 = this.ah.size() - 1; size2 >= 0; size2--) {
            ArrayList<ms> arrayList = this.ah.get(size2);
            ms(arrayList, reVar);
            if (arrayList.isEmpty()) {
                this.ah.remove(size2);
            }
        }
        for (int size3 = this.xr.size() - 1; size3 >= 0; size3--) {
            ArrayList<xr> arrayList2 = this.xr.get(size3);
            for (int size4 = arrayList2.size() - 1; size4 >= 0; size4--) {
                if (arrayList2.get(size4).f1408ms == reVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    ny(reVar);
                    arrayList2.remove(size4);
                    if (!arrayList2.isEmpty()) {
                        break;
                    }
                    this.xr.remove(size3);
                    break;
                }
            }
        }
        for (int size5 = this.f1398ms.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.re> arrayList3 = this.f1398ms.get(size5);
            if (arrayList3.remove(reVar)) {
                view.setAlpha(1.0f);
                ch(reVar);
                if (arrayList3.isEmpty()) {
                    this.f1398ms.remove(size5);
                }
            }
        }
        this.c.remove(reVar);
        this.d.remove(reVar);
        this.ab.remove(reVar);
        this.ka.remove(reVar);
        ah();
    }

    private void sl(RecyclerView.re reVar) {
        if (ny == null) {
            ny = new ValueAnimator().getInterpolator();
        }
        reVar.f1391ms.animate().setInterpolator(ny);
        d(reVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public boolean xr() {
        return (this.hi.isEmpty() && this.zb.isEmpty() && this.sl.isEmpty() && this.ch.isEmpty() && this.ka.isEmpty() && this.c.isEmpty() && this.d.isEmpty() && this.ab.isEmpty() && this.xr.isEmpty() && this.f1398ms.isEmpty() && this.ah.isEmpty()) ? false : true;
    }

    void ah() {
        if (xr()) {
            return;
        }
        ny();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public void d() {
        int size = this.sl.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            xr xrVar = this.sl.get(size);
            View view = xrVar.f1408ms.f1391ms;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            ny(xrVar.f1408ms);
            this.sl.remove(size);
        }
        for (int size2 = this.ch.size() - 1; size2 >= 0; size2--) {
            x(this.ch.get(size2));
            this.ch.remove(size2);
        }
        int size3 = this.hi.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.re reVar = this.hi.get(size3);
            reVar.f1391ms.setAlpha(1.0f);
            ch(reVar);
            this.hi.remove(size3);
        }
        for (int size4 = this.zb.size() - 1; size4 >= 0; size4--) {
            xr(this.zb.get(size4));
        }
        this.zb.clear();
        if (xr()) {
            for (int size5 = this.xr.size() - 1; size5 >= 0; size5--) {
                ArrayList<xr> arrayList = this.xr.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    xr xrVar2 = arrayList.get(size6);
                    View view2 = xrVar2.f1408ms.f1391ms;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    ny(xrVar2.f1408ms);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.xr.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f1398ms.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.re> arrayList2 = this.f1398ms.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.re reVar2 = arrayList2.get(size8);
                    reVar2.f1391ms.setAlpha(1.0f);
                    ch(reVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f1398ms.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.ah.size() - 1; size9 >= 0; size9--) {
                ArrayList<ms> arrayList3 = this.ah.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    xr(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.ah.remove(arrayList3);
                    }
                }
            }
            ms(this.c);
            ms(this.ka);
            ms(this.d);
            ms(this.ab);
            ny();
        }
    }

    void ms(List<RecyclerView.re> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f1391ms.animate().cancel();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public boolean ms(RecyclerView.re reVar, List<Object> list) {
        return !list.isEmpty() || super.ms(reVar, list);
    }

    private static class ms {
        public int ah;
        public int c;
        public int d;
        public int ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public RecyclerView.re f1407ms;
        public RecyclerView.re xr;

        private ms(RecyclerView.re reVar, RecyclerView.re reVar2) {
            this.f1407ms = reVar;
            this.xr = reVar2;
        }

        ms(RecyclerView.re reVar, RecyclerView.re reVar2, int i, int i2, int i3, int i4) {
            this(reVar, reVar2);
            this.ah = i;
            this.d = i2;
            this.ka = i3;
            this.c = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f1407ms + ", newHolder=" + this.xr + ", fromX=" + this.ah + ", fromY=" + this.d + ", toX=" + this.ka + ", toY=" + this.c + AbstractJsonLexerKt.END_OBJ;
        }
    }

    private static class xr {
        public int ah;
        public int d;
        public int ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public RecyclerView.re f1408ms;
        public int xr;

        xr(RecyclerView.re reVar, int i, int i2, int i3, int i4) {
            this.f1408ms = reVar;
            this.xr = i;
            this.ah = i2;
            this.d = i3;
            this.ka = i4;
        }
    }
}
