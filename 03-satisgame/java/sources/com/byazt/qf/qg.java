package com.byazt.qf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 817, 26})
public class qg {
    public Map<s, List<n>> n = new HashMap();
    public Map<String, String> qg = new HashMap();
    public final List<Object> s = new CopyOnWriteArrayList();
    public final List<Object> q = new CopyOnWriteArrayList();
    public final List<Object> l = new CopyOnWriteArrayList();
    public final List<Object> w = new CopyOnWriteArrayList();
    public w x = null;

    public List<n> n(s sVar) {
        return this.n.get(sVar);
    }

    public void n(Map<? extends String, ? extends String> map) {
        this.qg.putAll(map);
    }

    public Map<String, String> n() {
        return this.qg;
    }

    public List<Object> qg() {
        return this.q;
    }

    public List<Object> s() {
        return this.w;
    }

    public void n(w wVar) {
        this.x = wVar;
    }

    public w q() {
        return this.x;
    }
}
