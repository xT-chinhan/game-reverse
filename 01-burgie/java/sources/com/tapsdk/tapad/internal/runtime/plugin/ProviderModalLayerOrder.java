package com.tapsdk.tapad.internal.runtime.plugin;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class ProviderModalLayerOrder implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    private boolean closed;
    private ViewTreeObserver observer;
    private final ViewGroup root;
    private final List<View> modals = new ArrayList();
    private final Map<View, Float> originalTranslationZ = new IdentityHashMap();

    public ProviderModalLayerOrder(ViewGroup viewGroup) {
        this.root = viewGroup;
        viewGroup.addOnAttachStateChangeListener(this);
        observe();
    }

    private void observe() {
        stopObserving();
        ViewTreeObserver viewTreeObserver = this.root.getViewTreeObserver();
        this.observer = viewTreeObserver;
        if (viewTreeObserver.isAlive()) {
            this.observer.addOnPreDrawListener(this);
        }
    }

    private void restore() {
        for (Map.Entry<View, Float> entry : this.originalTranslationZ.entrySet()) {
            entry.getKey().setTranslationZ(entry.getValue().floatValue());
        }
        this.originalTranslationZ.clear();
    }

    private void stopObserving() {
        ViewTreeObserver viewTreeObserver = this.observer;
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            this.observer.removeOnPreDrawListener(this);
        }
        this.observer = null;
    }

    private View visibleBranch(View view) {
        while (view != this.root && view.getVisibility() == 0) {
            Object parent = view.getParent();
            ViewGroup viewGroup = this.root;
            if (parent == viewGroup) {
                if (viewGroup.getVisibility() == 0) {
                    return view;
                }
                return null;
            }
            if (!(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
        return null;
    }

    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        stopObserving();
        this.root.removeOnAttachStateChangeListener(this);
        restore();
        this.modals.clear();
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        reconcile();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        observe();
        reconcile();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        stopObserving();
        restore();
    }

    public void reconcile() {
        if (this.closed) {
            return;
        }
        LinkedHashSet<View> linkedHashSet = new LinkedHashSet();
        Iterator<View> it = this.modals.iterator();
        while (it.hasNext()) {
            View viewVisibleBranch = visibleBranch(it.next());
            if (viewVisibleBranch != null) {
                linkedHashSet.add(viewVisibleBranch);
            }
        }
        ArrayList arrayList = new ArrayList(this.originalTranslationZ.keySet());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            View view = (View) obj;
            if (!linkedHashSet.contains(view)) {
                view.setTranslationZ(this.originalTranslationZ.remove(view).floatValue());
            }
        }
        if (linkedHashSet.isEmpty()) {
            return;
        }
        float z = 0.0f;
        for (int i2 = 0; i2 < this.root.getChildCount(); i2++) {
            View childAt = this.root.getChildAt(i2);
            if (!linkedHashSet.contains(childAt)) {
                z = Math.max(z, childAt.getZ());
            }
        }
        for (View view2 : linkedHashSet) {
            if (!this.originalTranslationZ.containsKey(view2)) {
                this.originalTranslationZ.put(view2, Float.valueOf(view2.getTranslationZ()));
            }
            float fMax = Math.max(this.originalTranslationZ.get(view2).floatValue(), (z + 1.0f) - view2.getElevation());
            if (view2.getTranslationZ() != fMax) {
                view2.setTranslationZ(fMax);
            }
            z = view2.getZ();
        }
    }

    public void register(View view, boolean z) {
        if (this.closed) {
            return;
        }
        if (z && !this.modals.contains(view)) {
            this.modals.add(view);
        }
        if (!z) {
            this.modals.remove(view);
        }
        reconcile();
    }
}
