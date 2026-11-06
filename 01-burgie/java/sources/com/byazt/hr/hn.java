package com.byazt.hr;

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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 180, 20})
public class hn extends w {
    public static TimeInterpolator aj;
    public ArrayList<RecyclerView.fo> vk = new ArrayList<>();
    public ArrayList<RecyclerView.fo> w = new ArrayList<>();
    public ArrayList<hw> k = new ArrayList<>();
    public ArrayList<pr> m = new ArrayList<>();
    public ArrayList<ArrayList<RecyclerView.fo>> pr = new ArrayList<>();
    public ArrayList<ArrayList<hw>> hw = new ArrayList<>();
    public ArrayList<ArrayList<pr>> hn = new ArrayList<>();
    public ArrayList<RecyclerView.fo> x = new ArrayList<>();
    public ArrayList<RecyclerView.fo> c = new ArrayList<>();
    public ArrayList<RecyclerView.fo> uc = new ArrayList<>();
    public ArrayList<RecyclerView.fo> fw = new ArrayList<>();

    @Override // com.byazt.hr.RecyclerView.uc
    public void pr() {
        boolean z = !this.vk.isEmpty();
        boolean z2 = !this.k.isEmpty();
        boolean z3 = !this.m.isEmpty();
        boolean z4 = !this.w.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.fo> it = this.vk.iterator();
            while (it.hasNext()) {
                w(it.next());
            }
            this.vk.clear();
            if (z2) {
                final ArrayList<hw> arrayList = new ArrayList<>();
                arrayList.addAll(this.k);
                this.hw.add(arrayList);
                this.k.clear();
                Runnable runnable = new Runnable() { // from class: com.byazt.hr.hn.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (hw hwVar : arrayList) {
                            hn.this.hw(hwVar.pr, hwVar.hw, hwVar.hn, hwVar.x, hwVar.c);
                        }
                        arrayList.clear();
                        hn.this.hw.remove(arrayList);
                    }
                };
                if (z) {
                    com.byazt.vu.fw.pr(arrayList.get(0).pr.pr, runnable, fw());
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<pr> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.m);
                this.hn.add(arrayList2);
                this.m.clear();
                Runnable runnable2 = new Runnable() { // from class: com.byazt.hr.hn.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            hn.this.pr((pr) it2.next());
                        }
                        arrayList2.clear();
                        hn.this.hn.remove(arrayList2);
                    }
                };
                if (z) {
                    com.byazt.vu.fw.pr(arrayList2.get(0).pr.pr, runnable2, fw());
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final ArrayList<RecyclerView.fo> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.w);
                this.pr.add(arrayList3);
                this.w.clear();
                Runnable runnable3 = new Runnable() { // from class: com.byazt.hr.hn.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            hn.this.hn((RecyclerView.fo) it2.next());
                        }
                        arrayList3.clear();
                        hn.this.pr.remove(arrayList3);
                    }
                };
                if (!z && !z2 && !z3) {
                    runnable3.run();
                } else {
                    com.byazt.vu.fw.pr(arrayList3.get(0).pr, runnable3, (z ? fw() : 0L) + Math.max(z2 ? c() : 0L, z3 ? zo() : 0L));
                }
            }
        }
    }

    @Override // com.byazt.hr.w
    public boolean pr(RecyclerView.fo foVar) {
        k(foVar);
        this.vk.add(foVar);
        return true;
    }

    private void w(final RecyclerView.fo foVar) {
        final View view = foVar.pr;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.uc.add(foVar);
        viewPropertyAnimatorAnimate.setDuration(fw()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.byazt.hr.hn.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                view.setAlpha(1.0f);
                hn.this.zo(foVar);
                hn.this.uc.remove(foVar);
                hn.this.hn();
            }
        }).start();
    }

    @Override // com.byazt.hr.w
    public boolean hw(RecyclerView.fo foVar) {
        k(foVar);
        foVar.pr.setAlpha(0.0f);
        this.w.add(foVar);
        return true;
    }

    public void hn(final RecyclerView.fo foVar) {
        final View view = foVar.pr;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.x.add(foVar);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(uc()).setListener(new AnimatorListenerAdapter() { // from class: com.byazt.hr.hn.5
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
                hn.this.vk(foVar);
                hn.this.x.remove(foVar);
                hn.this.hn();
            }
        }).start();
    }

    @Override // com.byazt.hr.w
    public boolean pr(RecyclerView.fo foVar, int i, int i2, int i3, int i4) {
        View view = foVar.pr;
        int translationX = i + ((int) foVar.pr.getTranslationX());
        int translationY = i2 + ((int) foVar.pr.getTranslationY());
        k(foVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            aj(foVar);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.k.add(new hw(foVar, translationX, translationY, i3, i4));
        return true;
    }

    public void hw(final RecyclerView.fo foVar, int i, int i2, int i3, int i4) {
        final View view = foVar.pr;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.c.add(foVar);
        viewPropertyAnimatorAnimate.setDuration(c()).setListener(new AnimatorListenerAdapter() { // from class: com.byazt.hr.hn.6
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
                hn.this.aj(foVar);
                hn.this.c.remove(foVar);
                hn.this.hn();
            }
        }).start();
    }

    @Override // com.byazt.hr.w
    public boolean pr(RecyclerView.fo foVar, RecyclerView.fo foVar2, int i, int i2, int i3, int i4) {
        if (foVar == foVar2) {
            return pr(foVar, i, i2, i3, i4);
        }
        float translationX = foVar.pr.getTranslationX();
        float translationY = foVar.pr.getTranslationY();
        float alpha = foVar.pr.getAlpha();
        k(foVar);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        foVar.pr.setTranslationX(translationX);
        foVar.pr.setTranslationY(translationY);
        foVar.pr.setAlpha(alpha);
        if (foVar2 != null) {
            k(foVar2);
            foVar2.pr.setTranslationX(-i5);
            foVar2.pr.setTranslationY(-i6);
            foVar2.pr.setAlpha(0.0f);
        }
        this.m.add(new pr(foVar, foVar2, i, i2, i3, i4));
        return true;
    }

    public void pr(final pr prVar) {
        RecyclerView.fo foVar = prVar.pr;
        final View view = foVar == null ? null : foVar.pr;
        RecyclerView.fo foVar2 = prVar.hw;
        final View view2 = foVar2 != null ? foVar2.pr : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(zo());
            this.fw.add(prVar.pr);
            duration.translationX(prVar.c - prVar.hn);
            duration.translationY(prVar.uc - prVar.x);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.byazt.hr.hn.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    hn.this.pr(prVar.pr, true);
                    hn.this.fw.remove(prVar.pr);
                    hn.this.hn();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.fw.add(prVar.hw);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(zo()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.byazt.hr.hn.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    hn.this.pr(prVar.hw, false);
                    hn.this.fw.remove(prVar.hw);
                    hn.this.hn();
                }
            }).start();
        }
    }

    private void pr(List<pr> list, RecyclerView.fo foVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            pr prVar = list.get(size);
            if (pr(prVar, foVar) && prVar.pr == null && prVar.hw == null) {
                list.remove(prVar);
            }
        }
    }

    private void hw(pr prVar) {
        if (prVar.pr != null) {
            pr(prVar, prVar.pr);
        }
        if (prVar.hw != null) {
            pr(prVar, prVar.hw);
        }
    }

    private boolean pr(pr prVar, RecyclerView.fo foVar) {
        boolean z = false;
        if (prVar.hw == foVar) {
            prVar.hw = null;
        } else {
            if (prVar.pr != foVar) {
                return false;
            }
            prVar.pr = null;
            z = true;
        }
        foVar.pr.setAlpha(1.0f);
        foVar.pr.setTranslationX(0.0f);
        foVar.pr.setTranslationY(0.0f);
        pr(foVar, z);
        return true;
    }

    @Override // com.byazt.hr.RecyclerView.uc
    public void x(RecyclerView.fo foVar) {
        View view = foVar.pr;
        view.animate().cancel();
        int size = this.k.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.k.get(size).pr == foVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                aj(foVar);
                this.k.remove(size);
            }
        }
        pr(this.m, foVar);
        if (this.vk.remove(foVar)) {
            view.setAlpha(1.0f);
            zo(foVar);
        }
        if (this.w.remove(foVar)) {
            view.setAlpha(1.0f);
            vk(foVar);
        }
        for (int size2 = this.hn.size() - 1; size2 >= 0; size2--) {
            ArrayList<pr> arrayList = this.hn.get(size2);
            pr(arrayList, foVar);
            if (arrayList.isEmpty()) {
                this.hn.remove(size2);
            }
        }
        for (int size3 = this.hw.size() - 1; size3 >= 0; size3--) {
            ArrayList<hw> arrayList2 = this.hw.get(size3);
            for (int size4 = arrayList2.size() - 1; size4 >= 0; size4--) {
                if (arrayList2.get(size4).pr == foVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    aj(foVar);
                    arrayList2.remove(size4);
                    if (!arrayList2.isEmpty()) {
                        break;
                    }
                    this.hw.remove(size3);
                    break;
                }
            }
        }
        for (int size5 = this.pr.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.fo> arrayList3 = this.pr.get(size5);
            if (arrayList3.remove(foVar)) {
                view.setAlpha(1.0f);
                vk(foVar);
                if (arrayList3.isEmpty()) {
                    this.pr.remove(size5);
                }
            }
        }
        this.uc.remove(foVar);
        this.x.remove(foVar);
        this.fw.remove(foVar);
        this.c.remove(foVar);
        hn();
    }

    private void k(RecyclerView.fo foVar) {
        if (aj == null) {
            aj = new ValueAnimator().getInterpolator();
        }
        foVar.pr.animate().setInterpolator(aj);
        x(foVar);
    }

    @Override // com.byazt.hr.RecyclerView.uc
    public boolean hw() {
        return (this.w.isEmpty() && this.m.isEmpty() && this.k.isEmpty() && this.vk.isEmpty() && this.c.isEmpty() && this.uc.isEmpty() && this.x.isEmpty() && this.fw.isEmpty() && this.hw.isEmpty() && this.pr.isEmpty() && this.hn.isEmpty()) ? false : true;
    }

    public void hn() {
        if (!hw()) {
            aj();
        }
    }

    @Override // com.byazt.hr.RecyclerView.uc
    public void x() {
        int size = this.k.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            hw hwVar = this.k.get(size);
            View view = hwVar.pr.pr;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            aj(hwVar.pr);
            this.k.remove(size);
        }
        for (int size2 = this.vk.size() - 1; size2 >= 0; size2--) {
            zo(this.vk.get(size2));
            this.vk.remove(size2);
        }
        int size3 = this.w.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.fo foVar = this.w.get(size3);
            foVar.pr.setAlpha(1.0f);
            vk(foVar);
            this.w.remove(size3);
        }
        for (int size4 = this.m.size() - 1; size4 >= 0; size4--) {
            hw(this.m.get(size4));
        }
        this.m.clear();
        if (hw()) {
            for (int size5 = this.hw.size() - 1; size5 >= 0; size5--) {
                ArrayList<hw> arrayList = this.hw.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    hw hwVar2 = arrayList.get(size6);
                    View view2 = hwVar2.pr.pr;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    aj(hwVar2.pr);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.hw.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.pr.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.fo> arrayList2 = this.pr.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.fo foVar2 = arrayList2.get(size8);
                    foVar2.pr.setAlpha(1.0f);
                    vk(foVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.pr.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.hn.size() - 1; size9 >= 0; size9--) {
                ArrayList<pr> arrayList3 = this.hn.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    hw(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.hn.remove(arrayList3);
                    }
                }
            }
            pr(this.uc);
            pr(this.c);
            pr(this.x);
            pr(this.fw);
            aj();
        }
    }

    public void pr(List<RecyclerView.fo> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).pr.animate().cancel();
        }
    }

    @Override // com.byazt.hr.RecyclerView.uc
    public boolean pr(RecyclerView.fo foVar, List<Object> list) {
        return !list.isEmpty() || super.pr(foVar, list);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 116})
    private static class pr {
        public int c;
        public int hn;
        public RecyclerView.fo hw;
        public RecyclerView.fo pr;
        public int uc;
        public int x;

        private pr(RecyclerView.fo foVar, RecyclerView.fo foVar2) {
            this.pr = foVar;
            this.hw = foVar2;
        }

        public pr(RecyclerView.fo foVar, RecyclerView.fo foVar2, int i, int i2, int i3, int i4) {
            this(foVar, foVar2);
            this.hn = i;
            this.x = i2;
            this.c = i3;
            this.uc = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.pr + ", newHolder=" + this.hw + ", fromX=" + this.hn + ", fromY=" + this.x + ", toX=" + this.c + ", toY=" + this.uc + AbstractJsonLexerKt.END_OBJ;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 506})
    private static class hw {
        public int c;
        public int hn;
        public int hw;
        public RecyclerView.fo pr;
        public int x;

        public hw(RecyclerView.fo foVar, int i, int i2, int i3, int i4) {
            this.pr = foVar;
            this.hw = i;
            this.hn = i2;
            this.x = i3;
            this.c = i4;
        }
    }
}
