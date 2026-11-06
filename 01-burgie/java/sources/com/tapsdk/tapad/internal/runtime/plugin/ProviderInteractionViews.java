package com.tapsdk.tapad.internal.runtime.plugin;

import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ProviderInteractionViews {
    public static final String ROLE_CLICK = "click";
    public static final String ROLE_CREATIVE = "creative";
    public static final String ROLE_DIRECT_DOWNLOAD = "direct_download";
    private final List<View> clickViews;
    private final List<View> creativeViews;
    private final List<View> directDownloadViews;

    public ProviderInteractionViews(List<View> list, List<View> list2, List<View> list3) {
        this.clickViews = immutable(list);
        this.creativeViews = immutable(list2);
        this.directDownloadViews = immutable(list3);
    }

    private static void addUnique(List<View> list, List<View> list2) {
        if (list2 == null) {
            return;
        }
        for (View view : list2) {
            if (view != null && !list.contains(view)) {
                list.add(view);
            }
        }
    }

    private static List<View> immutable(List<View> list) {
        if (list == null || list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        addUnique(arrayList, list);
        return arrayList.isEmpty() ? Collections.EMPTY_LIST : Collections.unmodifiableList(arrayList);
    }

    public List<View> allViews() {
        ArrayList arrayList = new ArrayList();
        addUnique(arrayList, this.clickViews);
        addUnique(arrayList, this.creativeViews);
        addUnique(arrayList, this.directDownloadViews);
        return arrayList.isEmpty() ? Collections.EMPTY_LIST : Collections.unmodifiableList(arrayList);
    }

    public List<View> getClickViews() {
        return this.clickViews;
    }

    public List<View> getCreativeViews() {
        return this.creativeViews;
    }

    public List<View> getDirectDownloadViews() {
        return this.directDownloadViews;
    }

    public boolean sameViews(ProviderInteractionViews providerInteractionViews) {
        return providerInteractionViews != null && this.clickViews.equals(providerInteractionViews.clickViews) && this.creativeViews.equals(providerInteractionViews.creativeViews) && this.directDownloadViews.equals(providerInteractionViews.directDownloadViews);
    }
}
