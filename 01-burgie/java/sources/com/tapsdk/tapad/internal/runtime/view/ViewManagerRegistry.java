package com.tapsdk.tapad.internal.runtime.view;

import android.util.SparseArray;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ViewManagerRegistry {
    private static final String TAG = "ViewManagerRegistry";
    private static ViewManagerRegistry sInstance;
    private final SparseArray<ViewManager<?, ?>> mManagersByType = new SparseArray<>();
    private final Map<String, ViewManager<?, ?>> mManagersByName = new HashMap();

    private ViewManagerRegistry() {
    }

    public static synchronized ViewManagerRegistry getInstance() {
        if (sInstance == null) {
            sInstance = new ViewManagerRegistry();
        }
        return sInstance;
    }

    public void clear() {
        this.mManagersByType.clear();
        this.mManagersByName.clear();
    }

    public <T extends View, P extends ViewProps> ViewManager<T, P> getByName(String str) {
        return (ViewManager) this.mManagersByName.get(str);
    }

    public <T extends View, P extends ViewProps> ViewManager<T, P> getByType(int i) {
        return (ViewManager) this.mManagersByType.get(i);
    }

    public boolean hasManager(int i) {
        return this.mManagersByType.get(i) != null;
    }

    public void register(ViewManager<?, ?> viewManager) {
        int viewType = viewManager.getViewType();
        String name = viewManager.getName();
        this.mManagersByType.get(viewType);
        this.mManagersByType.put(viewType, viewManager);
        this.mManagersByName.put(name, viewManager);
    }

    public int size() {
        return this.mManagersByType.size();
    }
}
