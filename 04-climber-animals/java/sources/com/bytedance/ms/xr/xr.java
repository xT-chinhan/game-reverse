package com.bytedance.ms.xr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Map<ah, List<ms>> f598ms = new HashMap();
    private Map<String, String> xr = new HashMap();
    private final List<Object> ah = new CopyOnWriteArrayList();
    private final List<Object> d = new CopyOnWriteArrayList();
    private final List<Object> ka = new CopyOnWriteArrayList();
    private final List<Object> c = new CopyOnWriteArrayList();
    private c ab = null;

    public List<ms> ms(ah ahVar) {
        return this.f598ms.get(ahVar);
    }

    void ms(Map<? extends String, ? extends String> map) {
        this.xr.putAll(map);
    }

    public Map<String, String> ms() {
        return this.xr;
    }

    public List<Object> xr() {
        return this.d;
    }

    public List<Object> ah() {
        return this.c;
    }

    void ms(c cVar) {
        this.ab = cVar;
    }

    public c d() {
        return this.ab;
    }
}
