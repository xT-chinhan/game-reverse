package com.tapsdk.tapad.internal.runtime.plugin;

import android.view.View;
import com.tapsdk.tapad.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ProviderActionSlots {
    private final List<View> slots = new ArrayList();
    private final List<Listener> listeners = new ArrayList();

    public interface Listener {
        void onSlotsChanged(List<View> list);
    }

    private static boolean isDescendantOrSame(View view, View view2) {
        while (view != null) {
            if (view == view2) {
                return true;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return false;
    }

    private static boolean isEffectivelyVisibleDescendant(View view, View view2) {
        if (view != null && view2 != null) {
            while (view != null && view.getVisibility() == 0) {
                if (view == view2) {
                    return true;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            return false;
        }
        return false;
    }

    private void notifyChanged() {
        List<View> listSnapshot = snapshot();
        ArrayList arrayList = new ArrayList(this.listeners);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Listener) obj).onSlotsChanged(listSnapshot);
        }
    }

    public void addListener(Listener listener) {
        if (listener == null || this.listeners.contains(listener)) {
            return;
        }
        this.listeners.add(listener);
    }

    public void clear() {
        this.slots.clear();
        this.listeners.clear();
    }

    public void onVisibilityChanged(View view) {
        if (view == null) {
            return;
        }
        Iterator<View> it = this.slots.iterator();
        while (it.hasNext()) {
            if (isDescendantOrSame(it.next(), view)) {
                notifyChanged();
                return;
            }
        }
    }

    public void register(View view) {
        if (view == null || this.slots.contains(view)) {
            return;
        }
        this.slots.add(view);
        notifyChanged();
    }

    public void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }

    public List<View> snapshot() {
        return this.slots.isEmpty() ? Collections.EMPTY_LIST : Collections.unmodifiableList(new ArrayList(this.slots));
    }

    public void unregister(View view) {
        if (this.slots.remove(view)) {
            notifyChanged();
        }
    }

    public ProviderInteractionViews snapshot(View view) {
        List list;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (View view2 : this.slots) {
            if (isEffectivelyVisibleDescendant(view2, view)) {
                Object tag = view2.getTag(R.id.tapad_dirichlet_provider_action_role_tag);
                if ("click".equals(tag)) {
                    list = arrayList;
                } else {
                    list = ProviderInteractionViews.ROLE_DIRECT_DOWNLOAD.equals(tag) ? arrayList3 : arrayList2;
                }
                if (!list.contains(view2)) {
                    list.add(view2);
                }
            }
        }
        return new ProviderInteractionViews(arrayList, arrayList2, arrayList3);
    }
}
