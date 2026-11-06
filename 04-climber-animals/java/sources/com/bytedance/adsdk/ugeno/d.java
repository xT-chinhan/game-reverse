package com.bytedance.adsdk.ugeno;

import android.content.Context;
import com.bytedance.adsdk.ugeno.ka.ch;
import com.bytedance.adsdk.ugeno.ka.ka;
import com.bytedance.adsdk.ugeno.ka.x;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile d f352ms;
    private com.bytedance.adsdk.ugeno.ah.ms.ms ab;
    private com.bytedance.adsdk.ugeno.ah.ah ah;
    private com.bytedance.adsdk.ugeno.ah.xr.d c;
    private ms d;
    private com.bytedance.adsdk.ugeno.d.ms ka;
    private List<com.bytedance.adsdk.ugeno.ah.xr> xr;

    public static d ms() {
        if (f352ms == null) {
            synchronized (d.class) {
                if (f352ms == null) {
                    f352ms = new d();
                }
            }
        }
        return f352ms;
    }

    private d() {
    }

    public void ms(Context context, com.bytedance.adsdk.ugeno.ah.ah ahVar, ms msVar) {
        this.ah = ahVar;
        this.d = msVar;
        c();
    }

    public ms xr() {
        return this.d;
    }

    private void c() {
        ArrayList arrayList = new ArrayList();
        this.xr = arrayList;
        com.bytedance.adsdk.ugeno.ah.ah ahVar = this.ah;
        if (ahVar != null) {
            arrayList.addAll(ahVar.ms());
        }
        com.bytedance.adsdk.ugeno.ah.d.ms(this.xr);
    }

    public void ms(com.bytedance.adsdk.ugeno.d.ms msVar) {
        this.ka = msVar;
    }

    public com.bytedance.adsdk.ugeno.d.ms ah() {
        return this.ka;
    }

    public void ms(x xVar) {
        ArrayList arrayList = new ArrayList(new com.bytedance.adsdk.ugeno.ka.ms().ms());
        if (xVar != null) {
            arrayList.addAll(xVar.ms());
        }
        ch.ms(arrayList);
    }

    public void ms(com.bytedance.adsdk.ugeno.ka.ah ahVar) {
        ArrayList arrayList = new ArrayList(new ka().ms());
        if (ahVar != null) {
            arrayList.addAll(ahVar.ms());
        }
        com.bytedance.adsdk.ugeno.ka.d.ms(arrayList);
    }

    public void ms(com.bytedance.adsdk.ugeno.ah.xr.d dVar) {
        this.c = dVar;
    }

    public com.bytedance.adsdk.ugeno.ah.xr.d d() {
        return this.c;
    }

    public void ms(com.bytedance.adsdk.ugeno.ah.ms.ms msVar) {
        this.ab = msVar;
    }

    public com.bytedance.adsdk.ugeno.ah.ms.ms ka() {
        return this.ab;
    }
}
