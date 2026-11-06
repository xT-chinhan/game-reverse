package com.anythink.basead.ui.improveclick;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.v.o;
import com.anythink.core.common.v.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    protected static final String b = "key_has_endcard_improve";
    ViewGroup c;
    w d;
    x e;
    private int f;
    private List<c> g;
    private boolean i;
    private final String a = getClass().getSimpleName();
    private Map<String, Object> h = new HashMap();

    public abstract ViewGroup.LayoutParams a();

    /* JADX WARN: Code duplicated, block: B:135:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:136:0x0200  */
    /* JADX WARN: Code duplicated, block: B:154:0x0268  */
    /* JADX WARN: Code duplicated, block: B:155:0x028a  */
    /* JADX WARN: Code duplicated, block: B:158:0x0292  */
    /* JADX WARN: Code duplicated, block: B:161:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:164:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:175:0x0347  */
    /* JADX WARN: Code duplicated, block: B:178:0x0375  */
    /* JADX WARN: Code duplicated, block: B:180:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x0065  */
    /* JADX WARN: Code duplicated, block: B:23:0x0068  */
    /* JADX WARN: Code duplicated, block: B:32:0x0079  */
    /* JADX WARN: Code duplicated, block: B:34:0x0081  */
    /* JADX WARN: Code duplicated, block: B:36:0x0087 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:55:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:57:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:58:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:60:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:75:0x0101  */
    /* JADX WARN: Code duplicated, block: B:77:0x0104  */
    /* JADX WARN: Code duplicated, block: B:80:0x010c  */
    /* JADX WARN: Code duplicated, block: B:89:0x0136  */
    /* JADX WARN: Code duplicated, block: B:95:0x0149  */
    /* JADX WARN: Code duplicated, block: B:96:0x0154  */
    /* JADX WARN: Code duplicated, block: B:98:0x0160  */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x003e. Please report as an issue. */
    public a(ViewGroup viewGroup, w wVar, x xVar, int i, c.a aVar) {
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        ArrayList arrayList;
        final k kVarC;
        int i2;
        y yVar;
        boolean z;
        int i3;
        boolean z2;
        w wVar2;
        boolean z3;
        int i4;
        boolean z4;
        boolean z5;
        int i5;
        boolean zB;
        int i6 = 0;
        this.i = false;
        this.c = viewGroup;
        this.d = wVar;
        this.e = xVar;
        this.f = i;
        if (!this.d.c()) {
            int i7 = this.f;
            if (i7 != 100) {
                switch (i7) {
                    case 1:
                    case 2:
                        i2 = c(i7) ? 16 : i2;
                        yVar = this.e.o;
                        if (!yVar.af() || yVar.ag() || yVar.ah()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        i2 = z ? i2 | 4 : i2;
                        i3 = this.f;
                        if (i3 != 1 || i3 == 2 || i3 == 3 || i3 == 5 || i3 == 6) {
                            if (com.anythink.basead.b.e.a(this.e)) {
                                wVar2 = this.d;
                                x xVar2 = this.e;
                                if (wVar2 != null || xVar2 == null) {
                                    z3 = false;
                                } else {
                                    String strValueOf = String.valueOf(xVar2.j);
                                    strValueOf.hashCode();
                                    if (strValueOf.equals("4") && (wVar2 instanceof bj)) {
                                        boolean z6 = 1 == ((bj) wVar2).aI();
                                        if (xVar2.o.A() != 1 || ((z6 || xVar2.o.bt() != 2) && !(z6 && xVar2.o.bu() == 2))) {
                                            z3 = false;
                                        } else {
                                            z3 = true;
                                        }
                                    } else {
                                        z3 = false;
                                    }
                                }
                                if (z3) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                i2 |= 1;
                            }
                        }
                        i4 = this.f;
                        if (i4 != 1 || i4 == 3) {
                            if (this.e.o.s() == 1 || !com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.i)) {
                                z4 = false;
                            } else {
                                z4 = true;
                            }
                            if (z4) {
                                i2 |= 2;
                            }
                        }
                        if (this.e.o.as() == 1) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        i2 = z5 ? i2 | 8 : i2;
                        if (this.e.j == 1) {
                            if (this.e.j == 1 || ((this.e.o.as() == 1 && !TextUtils.isEmpty(this.e.o.au())) || this.e.o.bo() == 1)) {
                                zB = false;
                            } else {
                                zB = true;
                            }
                            if (zB && this.e.o.bo() == 2) {
                                if (q.b()) {
                                    zB = com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.o);
                                } else {
                                    zB = com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.n);
                                }
                            }
                            if (zB) {
                                i2 |= 32;
                            }
                        }
                        if (this.e.o.bs() != 1 && ((i5 = this.e.j) == 3 ? !(this.e.o.bs() != 2 ? this.e.o.bs() != 3 || this.f != 2 || this.e.o.ar() == 1 : com.anythink.basead.b.e.a(this.e) || ((TextUtils.isEmpty(this.d.H()) && TextUtils.isEmpty(this.d.G())) || !com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.b))) : !(i5 != 4 || this.e.o.bs() != 2 || com.anythink.basead.b.e.a(this.e) || ((TextUtils.isEmpty(this.d.H()) && TextUtils.isEmpty(this.d.G())) || !com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.b))))) {
                            i6 = 1;
                        }
                        if (i6 == 0) {
                            i6 = i2 | 64;
                            break;
                        } else {
                            i6 = i2;
                            break;
                        }
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        i2 = 0;
                        yVar = this.e.o;
                        if (yVar.af()) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (z) {
                        }
                        i3 = this.f;
                        if (i3 != 1) {
                            if (com.anythink.basead.b.e.a(this.e)) {
                                wVar2 = this.d;
                                x xVar3 = this.e;
                                if (wVar2 != null) {
                                    z3 = false;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                i2 |= 1;
                            }
                        } else {
                            if (com.anythink.basead.b.e.a(this.e)) {
                                wVar2 = this.d;
                                x xVar4 = this.e;
                                if (wVar2 != null) {
                                    z3 = false;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                i2 |= 1;
                            }
                        }
                        i4 = this.f;
                        if (i4 != 1) {
                            if (this.e.o.s() == 1) {
                                z4 = false;
                            } else {
                                z4 = false;
                            }
                            if (z4) {
                                i2 |= 2;
                            }
                        } else {
                            if (this.e.o.s() == 1) {
                                z4 = false;
                            } else {
                                z4 = false;
                            }
                            if (z4) {
                                i2 |= 2;
                            }
                        }
                        if (this.e.o.as() == 1) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                        }
                        if (this.e.j == 1) {
                            if (this.e.j == 1) {
                                zB = false;
                            } else {
                                zB = false;
                            }
                            if (zB) {
                                if (q.b()) {
                                    zB = com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.o);
                                } else {
                                    zB = com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.n);
                                }
                            }
                            if (zB) {
                                i2 |= 32;
                            }
                        }
                        if (this.e.o.bs() != 1) {
                        }
                        if (i6 == 0) {
                            i6 = i2;
                        } else {
                            i6 = i2 | 64;
                        }
                        break;
                }
            } else if (com.anythink.basead.b.e.a(this.e)) {
                i6 = 1;
            }
        }
        Context context = this.c.getContext();
        int i8 = this.f;
        ArrayList arrayList2 = new ArrayList();
        RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(q.a(context, "myoffer_guide2click_container", "id"));
        View viewFindViewById = viewGroup.findViewById(q.a(context, "myoffer_guide2click_mask", "id"));
        View viewFindViewById2 = viewGroup.findViewById(q.a(viewGroup.getContext(), "myoffer_rl_root", "id"));
        if (viewFindViewById2 != null && (viewFindViewById2 instanceof ViewGroup)) {
            viewGroup3 = (ViewGroup) viewFindViewById2;
        } else {
            View viewFindViewById3 = viewGroup.findViewById(q.a(viewGroup.getContext(), "myoffer_splash_root", "id"));
            if (viewFindViewById3 == null || !(viewFindViewById3 instanceof ViewGroup)) {
                viewGroup2 = viewGroup;
            } else {
                viewGroup3 = (ViewGroup) viewFindViewById3;
            }
            if ((i6 & 16) == 16) {
                d dVar = new d();
                arrayList = arrayList2;
                dVar.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i8, aVar);
                arrayList.add(dVar);
            } else {
                arrayList = arrayList2;
            }
            if ((i6 & 1) == 1) {
                j jVar = new j();
                jVar.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i8, aVar);
                arrayList.add(jVar);
            }
            if ((i6 & 2) == 2) {
                e eVar = new e();
                eVar.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i8, aVar);
                arrayList.add(eVar);
            }
            if ((i6 & 4) == 4) {
                k kVar = new k();
                kVar.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i8, aVar);
                arrayList.add(kVar);
            }
            if (relativeLayout != null && (i6 & 8) == 8) {
                f fVar = new f();
                fVar.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i8, aVar);
                arrayList.add(fVar);
            }
            if (relativeLayout != null && (i6 & 32) == 32) {
                h hVar = new h();
                hVar.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i8, aVar);
                arrayList.add(hVar);
            }
            if ((i6 & 64) == 64) {
                b bVar = new b();
                bVar.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i8, aVar);
                arrayList.add(bVar);
            }
            this.g = arrayList;
            this.i = c(this.f);
            kVarC = c();
            if (kVarC != null) {
                viewGroup.post(new Runnable() { // from class: com.anythink.basead.ui.improveclick.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewGroup.LayoutParams layoutParamsA = a.this.a();
                        if (kVarC == null || a.this.a() == null) {
                            return;
                        }
                        k kVar2 = kVarC;
                        if (kVar2.a != null) {
                            kVar2.a.setLayoutParams(layoutParamsA);
                        }
                    }
                });
            }
        }
        viewGroup2 = viewGroup3;
        if ((i6 & 16) == 16) {
            d dVar2 = new d();
            arrayList = arrayList2;
            dVar2.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i8, aVar);
            arrayList.add(dVar2);
        } else {
            arrayList = arrayList2;
        }
        if ((i6 & 1) == 1) {
            j jVar2 = new j();
            jVar2.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i8, aVar);
            arrayList.add(jVar2);
        }
        if ((i6 & 2) == 2) {
            e eVar2 = new e();
            eVar2.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i8, aVar);
            arrayList.add(eVar2);
        }
        if ((i6 & 4) == 4) {
            k kVar2 = new k();
            kVar2.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i8, aVar);
            arrayList.add(kVar2);
        }
        if (relativeLayout != null) {
            f fVar2 = new f();
            fVar2.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i8, aVar);
            arrayList.add(fVar2);
        }
        if (relativeLayout != null) {
            h hVar2 = new h();
            hVar2.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i8, aVar);
            arrayList.add(hVar2);
        }
        if ((i6 & 64) == 64) {
            b bVar2 = new b();
            bVar2.a(viewGroup2.getContext(), wVar, xVar, viewGroup2, relativeLayout, viewFindViewById, i8, aVar);
            arrayList.add(bVar2);
        }
        this.g = arrayList;
        this.i = c(this.f);
        kVarC = c();
        if (kVarC != null) {
            viewGroup.post(new Runnable() { // from class: com.anythink.basead.ui.improveclick.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    ViewGroup.LayoutParams layoutParamsA = a.this.a();
                    if (kVarC == null || a.this.a() == null) {
                        return;
                    }
                    k kVar3 = kVarC;
                    if (kVar3.a != null) {
                        kVar3.a.setLayoutParams(layoutParamsA);
                    }
                }
            });
        }
    }

    public final void a(long j) {
        k kVarC = c();
        if (kVarC != null) {
            kVarC.a(j);
        }
    }

    public final void a(int i) {
        if ((i == 103 || i == 118) && !this.i && !com.anythink.basead.b.e.e(this.d, this.e)) {
            com.anythink.core.common.u.e.a(this.d, this.e, com.anythink.basead.b.e.a(this.e, this.c.getContext()));
        }
        b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i) {
        List<c> list = this.g;
        if (list == null || list.size() <= 0) {
            return;
        }
        com.anythink.core.common.v.b.b.a();
        if (com.anythink.core.common.v.b.b.b()) {
            HashMap map = new HashMap();
            Map<String, Object> map2 = this.h;
            if (map2 != null) {
                map.putAll(map2);
            }
            map.put(b, Boolean.valueOf(this.i));
            Iterator<c> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().a(i, map);
            }
            return;
        }
        t.b().b(new Runnable() { // from class: com.anythink.basead.ui.improveclick.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.this.b(i);
            }
        });
    }

    private k c() {
        List<c> list = this.g;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (c cVar : this.g) {
            if (cVar instanceof k) {
                return (k) cVar;
            }
        }
        return null;
    }

    private d d() {
        List<c> list = this.g;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (c cVar : this.g) {
            if (cVar instanceof d) {
                return (d) cVar;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:136:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:137:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:21:0x0039  */
    /* JADX WARN: Code duplicated, block: B:23:0x003c  */
    /* JADX WARN: Code duplicated, block: B:32:0x004e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0056  */
    /* JADX WARN: Code duplicated, block: B:36:0x005c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:55:0x009d  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:89:0x010b  */
    /* JADX WARN: Code duplicated, block: B:95:0x011e  */
    /* JADX WARN: Code duplicated, block: B:96:0x0129  */
    /* JADX WARN: Code duplicated, block: B:98:0x0135  */
    private int e() {
        int i;
        y yVar;
        boolean z;
        int i2;
        boolean z2;
        w wVar;
        boolean z3;
        int i3;
        boolean z4;
        boolean z5;
        int i4;
        boolean zB;
        boolean z6 = false;
        if (this.d.c()) {
            return 0;
        }
        int i5 = this.f;
        if (i5 == 100) {
            return com.anythink.basead.b.e.a(this.e) ? 1 : 0;
        }
        switch (i5) {
            case 1:
            case 2:
                i = c(i5) ? 16 : 0;
                yVar = this.e.o;
                if (!yVar.af() || yVar.ag() || yVar.ah()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    i |= 4;
                }
                i2 = this.f;
                if (i2 != 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 6) {
                    if (com.anythink.basead.b.e.a(this.e)) {
                        wVar = this.d;
                        x xVar = this.e;
                        if (wVar != null || xVar == null) {
                            z3 = false;
                        } else {
                            String strValueOf = String.valueOf(xVar.j);
                            strValueOf.hashCode();
                            if (strValueOf.equals("4") && (wVar instanceof bj)) {
                                boolean z7 = 1 == ((bj) wVar).aI();
                                if (xVar.o.A() != 1 || ((z7 || xVar.o.bt() != 2) && !(z7 && xVar.o.bu() == 2))) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                            } else {
                                z3 = false;
                            }
                        }
                        if (z3) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        i |= 1;
                    }
                }
                i3 = this.f;
                if (i3 != 1 || i3 == 3) {
                    if (this.e.o.s() == 1 || !com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.i)) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    if (z4) {
                        i |= 2;
                    }
                }
                if (this.e.o.as() == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5) {
                    i |= 8;
                }
                if (this.e.j == 1) {
                    if (this.e.j == 1 || ((this.e.o.as() == 1 && !TextUtils.isEmpty(this.e.o.au())) || this.e.o.bo() == 1)) {
                        zB = false;
                    } else {
                        zB = true;
                    }
                    if (zB && this.e.o.bo() == 2) {
                        if (q.b()) {
                            zB = com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.o);
                        } else {
                            zB = com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.n);
                        }
                    }
                    if (zB) {
                        i |= 32;
                    }
                }
                if (this.e.o.bs() != 1 && ((i4 = this.e.j) == 3 ? !(this.e.o.bs() != 2 ? this.e.o.bs() != 3 || this.f != 2 || this.e.o.ar() == 1 : com.anythink.basead.b.e.a(this.e) || ((TextUtils.isEmpty(this.d.H()) && TextUtils.isEmpty(this.d.G())) || !com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.b))) : !(i4 != 4 || this.e.o.bs() != 2 || com.anythink.basead.b.e.a(this.e) || ((TextUtils.isEmpty(this.d.H()) && TextUtils.isEmpty(this.d.G())) || !com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.b))))) {
                    z6 = true;
                }
                return z6 ? i | 64 : i;
            case 3:
            case 4:
            case 5:
            case 6:
                yVar = this.e.o;
                if (yVar.af()) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    i |= 4;
                }
                i2 = this.f;
                if (i2 != 1) {
                    if (com.anythink.basead.b.e.a(this.e)) {
                        wVar = this.d;
                        x xVar2 = this.e;
                        if (wVar != null) {
                            z3 = false;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        i |= 1;
                    }
                } else {
                    if (com.anythink.basead.b.e.a(this.e)) {
                        wVar = this.d;
                        x xVar3 = this.e;
                        if (wVar != null) {
                            z3 = false;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        i |= 1;
                    }
                }
                i3 = this.f;
                if (i3 != 1) {
                    if (this.e.o.s() == 1) {
                        z4 = false;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        i |= 2;
                    }
                } else {
                    if (this.e.o.s() == 1) {
                        z4 = false;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        i |= 2;
                    }
                }
                if (this.e.o.as() == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5) {
                    i |= 8;
                }
                if (this.e.j == 1) {
                    if (this.e.j == 1) {
                        zB = false;
                    } else {
                        zB = false;
                    }
                    if (zB) {
                        if (q.b()) {
                            zB = com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.o);
                        } else {
                            zB = com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.n);
                        }
                    }
                    if (zB) {
                        i |= 32;
                    }
                }
                if (this.e.o.bs() != 1) {
                }
                if (z6) {
                }
                break;
            default:
                return 0;
        }
    }

    private boolean f() {
        y yVar = this.e.o;
        return yVar.af() || yVar.ag() || yVar.ah();
    }

    private boolean g() {
        return this.e.o.s() == 1 && com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.i);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0052  */
    private boolean h() {
        boolean z;
        if (com.anythink.basead.b.e.a(this.e)) {
            w wVar = this.d;
            x xVar = this.e;
            if (wVar == null || xVar == null) {
                z = false;
            } else {
                String strValueOf = String.valueOf(xVar.j);
                strValueOf.hashCode();
                if (strValueOf.equals("4") && (wVar instanceof bj)) {
                    boolean z2 = 1 == ((bj) wVar).aI();
                    if (xVar.o.A() != 1 || ((z2 || xVar.o.bt() != 2) && !(z2 && xVar.o.bu() == 2))) {
                        z = false;
                    } else {
                        z = true;
                    }
                } else {
                    z = false;
                }
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    private boolean i() {
        return this.e.o.as() == 1;
    }

    private boolean j() {
        boolean z = this.e.j == 1 && (this.e.o.as() != 1 || TextUtils.isEmpty(this.e.o.au())) && this.e.o.bo() != 1;
        if (!z || this.e.o.bo() != 2) {
            return z;
        }
        if (q.b()) {
            return com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.o);
        }
        return com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.n);
    }

    private boolean k() {
        if (this.e.o.bs() != 1) {
            int i = this.e.j;
            if (i != 3) {
                if (i == 4 && this.e.o.bs() == 2 && !com.anythink.basead.b.e.a(this.e)) {
                    return !(TextUtils.isEmpty(this.d.H()) && TextUtils.isEmpty(this.d.G())) && com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.b);
                }
                return false;
            }
            if (this.e.o.bs() == 2) {
                if (com.anythink.basead.b.e.a(this.e)) {
                    return false;
                }
                return !(TextUtils.isEmpty(this.d.H()) && TextUtils.isEmpty(this.d.G())) && com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.b);
            }
            if (this.e.o.bs() == 3 && this.f == 2 && this.e.o.ar() != 1) {
                return true;
            }
        }
        return false;
    }

    private boolean c(int i) {
        if (i == 2) {
            return this.e.o.aO() == 5;
        }
        if (i != 1) {
            return false;
        }
        int iAO = this.e.o.aO();
        if (iAO != 2 && iAO != 3 && iAO != 4) {
            return iAO == 5;
        }
        boolean zB = !com.anythink.basead.b.e.e(this.d, this.e);
        if (this.e.o.aO() == 4 && zB) {
            if (TextUtils.isEmpty(this.e.o.aZ())) {
                zB = false;
            } else {
                zB = com.anythink.core.common.res.d.a(this.c.getContext()).b(3, o.a(this.e.o.aZ()));
                this.e.o.aZ();
            }
        }
        if (zB) {
            if (this.e.o.aO() == 3) {
                zB = com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.a);
            }
            if (this.e.o.aO() == 2) {
                zB = com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.i);
            }
            if (this.e.o.aO() == 4) {
                zB = com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.p);
            }
        }
        if (zB && TextUtils.equals(String.valueOf(this.e.j), "1") && TextUtils.isEmpty(this.d.E())) {
            if (this.e.o.an() == 1) {
                zB = false;
            }
            if (this.e.o.ao() == 1) {
                return false;
            }
        }
        return zB;
    }

    public final void a(Map<String, Object> map) {
        if (map != null) {
            this.h.putAll(map);
        }
    }

    public final Map<String, Object> b() {
        return this.h;
    }

    public final void a(d.a aVar) {
        d dVar;
        List<c> list = this.g;
        if (list != null && list.size() > 0) {
            Iterator<c> it = this.g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    dVar = null;
                    break;
                }
                c next = it.next();
                if (next instanceof d) {
                    dVar = (d) next;
                    break;
                }
            }
        } else {
            dVar = null;
            break;
        }
        if (dVar == null || dVar.m == null) {
            return;
        }
        dVar.m.a(aVar);
    }
}
