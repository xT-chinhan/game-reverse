package com.tapsdk.tapad.internal.runtime.plugin;

import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ProviderMediaSlots {
    private final List<View> slots = new ArrayList();

    public void clear() {
        this.slots.clear();
    }

    public void register(View view) {
        if (view == null || this.slots.contains(view)) {
            return;
        }
        this.slots.add(view);
    }

    public List<View> snapshot() {
        return this.slots.isEmpty() ? Collections.EMPTY_LIST : Collections.unmodifiableList(new ArrayList(this.slots));
    }

    public void unregister(View view) {
        this.slots.remove(view);
    }
}
