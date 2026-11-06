package com.baidu.mobads.sdk.internal;

import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class ar implements Comparator<Map.Entry<String, Long>> {
    final /* synthetic */ aq a;

    ar(aq aqVar) {
        this.a = aqVar;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
        return entry2.getValue().compareTo(entry.getValue());
    }
}
