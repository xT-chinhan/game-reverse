package com.byazt.jfs;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1191, 8})
public class s {
    public static volatile s n;

    private s() {
    }

    public static s n() {
        if (n == null) {
            synchronized (s.class) {
                if (n == null) {
                    n = new s();
                }
            }
        }
        return n;
    }

    public q n(View view, com.byazt.lh.n nVar) {
        if (nVar == null) {
            return null;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).setClipChildren(false);
        }
        if (view.getParent().getParent() != null) {
            ((ViewGroup) view.getParent().getParent()).setClipChildren(false);
        }
        if ("scale".equals(nVar.rv())) {
            return new cp(view, nVar);
        }
        if ("translate".equals(nVar.rv())) {
            return new k(view, nVar);
        }
        if ("ripple".equals(nVar.rv())) {
            return new fs(view, nVar);
        }
        if ("marquee".equals(nVar.rv())) {
            return new x(view, nVar);
        }
        if ("waggle".equals(nVar.rv())) {
            return new cy(view, nVar);
        }
        if ("shine".equals(nVar.rv())) {
            return new d(view, nVar);
        }
        if ("swing".equals(nVar.rv())) {
            return new sz(view, nVar);
        }
        if ("fade".equals(nVar.rv())) {
            return new n(view, nVar);
        }
        if ("rubIn".equals(nVar.rv())) {
            return new tj(view, nVar);
        }
        if ("rotate".equals(nVar.rv())) {
            return new rv(view, nVar);
        }
        if ("cutIn".equals(nVar.rv())) {
            return new w(view, nVar);
        }
        if ("stretch".equals(nVar.rv())) {
            return new oa(view, nVar);
        }
        if ("bounce".equals(nVar.rv())) {
            return new l(view, nVar);
        }
        return null;
    }
}
