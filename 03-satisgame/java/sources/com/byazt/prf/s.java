package com.byazt.prf;

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
@com.byazt.cp.n(n = {0, 1, 102, 8})
public class s extends d {
    public static TimeInterpolator rv;
    public ArrayList<RecyclerView.m> tj = new ArrayList<>();
    public ArrayList<RecyclerView.m> cp = new ArrayList<>();
    public ArrayList<qg> d = new ArrayList<>();
    public ArrayList<n> oa = new ArrayList<>();
    public ArrayList<ArrayList<RecyclerView.m>> n = new ArrayList<>();
    public ArrayList<ArrayList<qg>> qg = new ArrayList<>();
    public ArrayList<ArrayList<n>> s = new ArrayList<>();
    public ArrayList<RecyclerView.m> q = new ArrayList<>();
    public ArrayList<RecyclerView.m> l = new ArrayList<>();
    public ArrayList<RecyclerView.m> w = new ArrayList<>();
    public ArrayList<RecyclerView.m> x = new ArrayList<>();

    @Override // com.byazt.prf.RecyclerView.w
    public void n() {
        boolean z = !this.tj.isEmpty();
        boolean z2 = !this.d.isEmpty();
        boolean z3 = !this.oa.isEmpty();
        boolean z4 = !this.cp.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.m> it = this.tj.iterator();
            while (it.hasNext()) {
                cp(it.next());
            }
            this.tj.clear();
            if (z2) {
                final ArrayList<qg> arrayList = new ArrayList<>();
                arrayList.addAll(this.d);
                this.qg.add(arrayList);
                this.d.clear();
                Runnable runnable = new Runnable() { // from class: com.byazt.prf.s.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (qg qgVar : arrayList) {
                            s.this.qg(qgVar.n, qgVar.qg, qgVar.s, qgVar.q, qgVar.l);
                        }
                        arrayList.clear();
                        s.this.qg.remove(arrayList);
                    }
                };
                if (z) {
                    com.byazt.mgr.x.n(arrayList.get(0).n.n, runnable, x());
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<n> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.oa);
                this.s.add(arrayList2);
                this.oa.clear();
                Runnable runnable2 = new Runnable() { // from class: com.byazt.prf.s.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            s.this.n((n) it2.next());
                        }
                        arrayList2.clear();
                        s.this.s.remove(arrayList2);
                    }
                };
                if (z) {
                    com.byazt.mgr.x.n(arrayList2.get(0).n.n, runnable2, x());
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final ArrayList<RecyclerView.m> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.cp);
                this.n.add(arrayList3);
                this.cp.clear();
                Runnable runnable3 = new Runnable() { // from class: com.byazt.prf.s.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            s.this.s((RecyclerView.m) it2.next());
                        }
                        arrayList3.clear();
                        s.this.n.remove(arrayList3);
                    }
                };
                if (!z && !z2 && !z3) {
                    runnable3.run();
                } else {
                    com.byazt.mgr.x.n(arrayList3.get(0).n, runnable3, (z ? x() : 0L) + Math.max(z2 ? l() : 0L, z3 ? fs() : 0L));
                }
            }
        }
    }

    @Override // com.byazt.prf.d
    public boolean n(RecyclerView.m mVar) {
        d(mVar);
        this.tj.add(mVar);
        return true;
    }

    private void cp(final RecyclerView.m mVar) {
        final View view = mVar.n;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.w.add(mVar);
        viewPropertyAnimatorAnimate.setDuration(x()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.byazt.prf.s.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                view.setAlpha(1.0f);
                s.this.fs(mVar);
                s.this.w.remove(mVar);
                s.this.s();
            }
        }).start();
    }

    @Override // com.byazt.prf.d
    public boolean qg(RecyclerView.m mVar) {
        d(mVar);
        mVar.n.setAlpha(0.0f);
        this.cp.add(mVar);
        return true;
    }

    public void s(final RecyclerView.m mVar) {
        final View view = mVar.n;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.q.add(mVar);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(w()).setListener(new AnimatorListenerAdapter() { // from class: com.byazt.prf.s.5
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
                s.this.tj(mVar);
                s.this.q.remove(mVar);
                s.this.s();
            }
        }).start();
    }

    @Override // com.byazt.prf.d
    public boolean n(RecyclerView.m mVar, int i, int i2, int i3, int i4) {
        View view = mVar.n;
        int translationX = i + ((int) mVar.n.getTranslationX());
        int translationY = i2 + ((int) mVar.n.getTranslationY());
        d(mVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            rv(mVar);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.d.add(new qg(mVar, translationX, translationY, i3, i4));
        return true;
    }

    public void qg(final RecyclerView.m mVar, int i, int i2, int i3, int i4) {
        final View view = mVar.n;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.l.add(mVar);
        viewPropertyAnimatorAnimate.setDuration(l()).setListener(new AnimatorListenerAdapter() { // from class: com.byazt.prf.s.6
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
                s.this.rv(mVar);
                s.this.l.remove(mVar);
                s.this.s();
            }
        }).start();
    }

    @Override // com.byazt.prf.d
    public boolean n(RecyclerView.m mVar, RecyclerView.m mVar2, int i, int i2, int i3, int i4) {
        if (mVar == mVar2) {
            return n(mVar, i, i2, i3, i4);
        }
        float translationX = mVar.n.getTranslationX();
        float translationY = mVar.n.getTranslationY();
        float alpha = mVar.n.getAlpha();
        d(mVar);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        mVar.n.setTranslationX(translationX);
        mVar.n.setTranslationY(translationY);
        mVar.n.setAlpha(alpha);
        if (mVar2 != null) {
            d(mVar2);
            mVar2.n.setTranslationX(-i5);
            mVar2.n.setTranslationY(-i6);
            mVar2.n.setAlpha(0.0f);
        }
        this.oa.add(new n(mVar, mVar2, i, i2, i3, i4));
        return true;
    }

    public void n(final n nVar) {
        RecyclerView.m mVar = nVar.n;
        final View view = mVar == null ? null : mVar.n;
        RecyclerView.m mVar2 = nVar.qg;
        final View view2 = mVar2 != null ? mVar2.n : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(fs());
            this.x.add(nVar.n);
            duration.translationX(nVar.l - nVar.s);
            duration.translationY(nVar.w - nVar.q);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.byazt.prf.s.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    s.this.n(nVar.n, true);
                    s.this.x.remove(nVar.n);
                    s.this.s();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.x.add(nVar.qg);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(fs()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.byazt.prf.s.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    s.this.n(nVar.qg, false);
                    s.this.x.remove(nVar.qg);
                    s.this.s();
                }
            }).start();
        }
    }

    private void n(List<n> list, RecyclerView.m mVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            n nVar = list.get(size);
            if (n(nVar, mVar) && nVar.n == null && nVar.qg == null) {
                list.remove(nVar);
            }
        }
    }

    private void qg(n nVar) {
        if (nVar.n != null) {
            n(nVar, nVar.n);
        }
        if (nVar.qg != null) {
            n(nVar, nVar.qg);
        }
    }

    private boolean n(n nVar, RecyclerView.m mVar) {
        boolean z = false;
        if (nVar.qg == mVar) {
            nVar.qg = null;
        } else {
            if (nVar.n != mVar) {
                return false;
            }
            nVar.n = null;
            z = true;
        }
        mVar.n.setAlpha(1.0f);
        mVar.n.setTranslationX(0.0f);
        mVar.n.setTranslationY(0.0f);
        n(mVar, z);
        return true;
    }

    @Override // com.byazt.prf.RecyclerView.w
    public void q(RecyclerView.m mVar) {
        View view = mVar.n;
        view.animate().cancel();
        int size = this.d.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.d.get(size).n == mVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                rv(mVar);
                this.d.remove(size);
            }
        }
        n(this.oa, mVar);
        if (this.tj.remove(mVar)) {
            view.setAlpha(1.0f);
            fs(mVar);
        }
        if (this.cp.remove(mVar)) {
            view.setAlpha(1.0f);
            tj(mVar);
        }
        for (int size2 = this.s.size() - 1; size2 >= 0; size2--) {
            ArrayList<n> arrayList = this.s.get(size2);
            n(arrayList, mVar);
            if (arrayList.isEmpty()) {
                this.s.remove(size2);
            }
        }
        for (int size3 = this.qg.size() - 1; size3 >= 0; size3--) {
            ArrayList<qg> arrayList2 = this.qg.get(size3);
            for (int size4 = arrayList2.size() - 1; size4 >= 0; size4--) {
                if (arrayList2.get(size4).n == mVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    rv(mVar);
                    arrayList2.remove(size4);
                    if (!arrayList2.isEmpty()) {
                        break;
                    }
                    this.qg.remove(size3);
                    break;
                }
            }
        }
        for (int size5 = this.n.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.m> arrayList3 = this.n.get(size5);
            if (arrayList3.remove(mVar)) {
                view.setAlpha(1.0f);
                tj(mVar);
                if (arrayList3.isEmpty()) {
                    this.n.remove(size5);
                }
            }
        }
        this.w.remove(mVar);
        this.q.remove(mVar);
        this.x.remove(mVar);
        this.l.remove(mVar);
        s();
    }

    private void d(RecyclerView.m mVar) {
        if (rv == null) {
            rv = new ValueAnimator().getInterpolator();
        }
        mVar.n.animate().setInterpolator(rv);
        q(mVar);
    }

    @Override // com.byazt.prf.RecyclerView.w
    public boolean qg() {
        return (this.cp.isEmpty() && this.oa.isEmpty() && this.d.isEmpty() && this.tj.isEmpty() && this.l.isEmpty() && this.w.isEmpty() && this.q.isEmpty() && this.x.isEmpty() && this.qg.isEmpty() && this.n.isEmpty() && this.s.isEmpty()) ? false : true;
    }

    public void s() {
        if (qg()) {
            return;
        }
        rv();
    }

    @Override // com.byazt.prf.RecyclerView.w
    public void q() {
        int size = this.d.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            qg qgVar = this.d.get(size);
            View view = qgVar.n.n;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            rv(qgVar.n);
            this.d.remove(size);
        }
        for (int size2 = this.tj.size() - 1; size2 >= 0; size2--) {
            fs(this.tj.get(size2));
            this.tj.remove(size2);
        }
        int size3 = this.cp.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.m mVar = this.cp.get(size3);
            mVar.n.setAlpha(1.0f);
            tj(mVar);
            this.cp.remove(size3);
        }
        for (int size4 = this.oa.size() - 1; size4 >= 0; size4--) {
            qg(this.oa.get(size4));
        }
        this.oa.clear();
        if (qg()) {
            for (int size5 = this.qg.size() - 1; size5 >= 0; size5--) {
                ArrayList<qg> arrayList = this.qg.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    qg qgVar2 = arrayList.get(size6);
                    View view2 = qgVar2.n.n;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    rv(qgVar2.n);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.qg.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.n.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.m> arrayList2 = this.n.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.m mVar2 = arrayList2.get(size8);
                    mVar2.n.setAlpha(1.0f);
                    tj(mVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.n.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.s.size() - 1; size9 >= 0; size9--) {
                ArrayList<n> arrayList3 = this.s.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    qg(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.s.remove(arrayList3);
                    }
                }
            }
            n(this.w);
            n(this.l);
            n(this.q);
            n(this.x);
            rv();
        }
    }

    public void n(List<RecyclerView.m> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).n.animate().cancel();
        }
    }

    @Override // com.byazt.prf.RecyclerView.w
    public boolean n(RecyclerView.m mVar, List<Object> list) {
        return !list.isEmpty() || super.n(mVar, list);
    }

    @com.byazt.cp.n(n = {0, 1, 102, 546})
    private static class n {
        public int l;
        public RecyclerView.m n;
        public int q;
        public RecyclerView.m qg;
        public int s;
        public int w;

        private n(RecyclerView.m mVar, RecyclerView.m mVar2) {
            this.n = mVar;
            this.qg = mVar2;
        }

        public n(RecyclerView.m mVar, RecyclerView.m mVar2, int i, int i2, int i3, int i4) {
            this(mVar, mVar2);
            this.s = i;
            this.q = i2;
            this.l = i3;
            this.w = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.n + ", newHolder=" + this.qg + ", fromX=" + this.s + ", fromY=" + this.q + ", toX=" + this.l + ", toY=" + this.w + AbstractJsonLexerKt.END_OBJ;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 782})
    private static class qg {
        public int l;
        public RecyclerView.m n;
        public int q;
        public int qg;
        public int s;

        public qg(RecyclerView.m mVar, int i, int i2, int i3, int i4) {
            this.n = mVar;
            this.qg = i;
            this.s = i2;
            this.q = i3;
            this.l = i4;
        }
    }
}
