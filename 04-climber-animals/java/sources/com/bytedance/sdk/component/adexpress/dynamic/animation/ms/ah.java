package com.bytedance.sdk.component.adexpress.dynamic.animation.ms;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ah f769ms;

    private ah() {
    }

    public static ah ms() {
        if (f769ms == null) {
            synchronized (ah.class) {
                if (f769ms == null) {
                    f769ms = new ah();
                }
            }
        }
        return f769ms;
    }

    public d ms(View view, com.bytedance.sdk.component.adexpress.dynamic.ah.ms msVar) {
        if (msVar == null) {
            return null;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).setClipChildren(false);
        }
        if (view.getParent().getParent() != null) {
            ((ViewGroup) view.getParent().getParent()).setClipChildren(false);
        }
        if ("scale".equals(msVar.ny())) {
            return new hi(view, msVar);
        }
        if ("translate".equals(msVar.ny())) {
            return new ub(view, msVar);
        }
        if ("ripple".equals(msVar.ny())) {
            return new x(view, msVar);
        }
        if ("marquee".equals(msVar.ny())) {
            return new ab(view, msVar);
        }
        if ("waggle".equals(msVar.ny())) {
            return new ao(view, msVar);
        }
        if ("shine".equals(msVar.ny())) {
            return new sl(view, msVar);
        }
        if ("swing".equals(msVar.ny())) {
            return new u(view, msVar);
        }
        if ("fade".equals(msVar.ny())) {
            return new ms(view, msVar);
        }
        if ("rubIn".equals(msVar.ny())) {
            return new ch(view, msVar);
        }
        if ("rotate".equals(msVar.ny())) {
            return new ny(view, msVar);
        }
        if ("cutIn".equals(msVar.ny())) {
            return new c(view, msVar);
        }
        if ("stretch".equals(msVar.ny())) {
            return new zb(view, msVar);
        }
        if ("bounce".equals(msVar.ny())) {
            return new ka(view, msVar);
        }
        return null;
    }
}
