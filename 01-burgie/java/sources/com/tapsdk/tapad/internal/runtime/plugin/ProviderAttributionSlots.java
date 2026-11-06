package com.tapsdk.tapad.internal.runtime.plugin;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ProviderAttributionSlots {
    private final List<ViewGroup> slots = new ArrayList();
    private final List<Listener> listeners = new ArrayList();

    public interface Listener {
        void onSlotAvailable(ViewGroup viewGroup);
    }

    private void notifySlot(ViewGroup viewGroup) {
        ArrayList arrayList = new ArrayList(this.listeners);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Listener) obj).onSlotAvailable(viewGroup);
        }
    }

    public void addListener(Listener listener) {
        if (listener == null) {
            return;
        }
        if (!this.listeners.contains(listener)) {
            this.listeners.add(listener);
        }
        ArrayList arrayList = new ArrayList(this.slots);
        int i = 0;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            listener.onSlotAvailable((ViewGroup) obj);
        }
    }

    public void clear() {
        this.slots.clear();
        this.listeners.clear();
    }

    public boolean contains(ViewGroup viewGroup) {
        return viewGroup != null && this.slots.contains(viewGroup);
    }

    public void refresh(ViewGroup viewGroup) {
        if (viewGroup == null || !this.slots.contains(viewGroup)) {
            return;
        }
        notifySlot(viewGroup);
    }

    public void register(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (!this.slots.contains(viewGroup)) {
            this.slots.add(viewGroup);
        }
        notifySlot(viewGroup);
    }

    public void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }

    public List<ViewGroup> snapshot() {
        return this.slots.isEmpty() ? Collections.EMPTY_LIST : Collections.unmodifiableList(new ArrayList(this.slots));
    }

    public void unregister(View view) {
        if (view instanceof ViewGroup) {
            this.slots.remove(view);
        }
    }
}
