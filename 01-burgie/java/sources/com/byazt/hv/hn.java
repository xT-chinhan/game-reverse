package com.byazt.hv;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 802, 20})
public class hn {
    public static volatile hn pr;

    private hn() {
    }

    public static hn pr() {
        if (pr == null) {
            synchronized (hn.class) {
                if (pr == null) {
                    pr = new hn();
                }
            }
        }
        return pr;
    }

    public x pr(View view, com.byazt.rk.pr prVar) {
        if (prVar == null) {
            return null;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).setClipChildren(false);
        }
        if (view.getParent().getParent() != null) {
            ((ViewGroup) view.getParent().getParent()).setClipChildren(false);
        }
        if ("scale".equals(prVar.aj())) {
            return new w(view, prVar);
        }
        if ("translate".equals(prVar.aj())) {
            return new ho(view, prVar);
        }
        if ("ripple".equals(prVar.aj())) {
            return new zo(view, prVar);
        }
        if ("marquee".equals(prVar.aj())) {
            return new fw(view, prVar);
        }
        if ("waggle".equals(prVar.aj())) {
            return new nt(view, prVar);
        }
        if ("shine".equals(prVar.aj())) {
            return new k(view, prVar);
        }
        if ("swing".equals(prVar.aj())) {
            return new g(view, prVar);
        }
        if ("fade".equals(prVar.aj())) {
            return new pr(view, prVar);
        }
        if ("rubIn".equals(prVar.aj())) {
            return new vk(view, prVar);
        }
        if ("rotate".equals(prVar.aj())) {
            return new aj(view, prVar);
        }
        if ("cutIn".equals(prVar.aj())) {
            return new uc(view, prVar);
        }
        if ("stretch".equals(prVar.aj())) {
            return new m(view, prVar);
        }
        if (!"bounce".equals(prVar.aj())) {
            return null;
        }
        return new c(view, prVar);
    }
}
