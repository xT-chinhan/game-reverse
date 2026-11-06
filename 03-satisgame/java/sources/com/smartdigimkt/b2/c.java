package com.smartdigimkt.b2;

import android.content.Context;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.smartdigimkt.sdk.api.DeviceDataInfo;
import com.smartdigimkt.sdk.basead.ui.BaseATView;
import com.smartdigimkt.sdk.basead.ui.SinglePictureSplashATView;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public final ViewGroup a;
    public final com.smartdigimkt.b3.c b;
    public final com.smartdigimkt.a3.a c;
    public final int d;
    public final ArrayList e;
    public final HashMap f = new HashMap();
    public final boolean g;

    /* JADX WARN: Code duplicated, block: B:121:0x0179  */
    /* JADX WARN: Code duplicated, block: B:122:0x017c  */
    /* JADX WARN: Code duplicated, block: B:128:0x0189  */
    /* JADX WARN: Code duplicated, block: B:142:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:152:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:158:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:16:0x0049  */
    /* JADX WARN: Code duplicated, block: B:171:0x01f5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:175:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:176:0x0202  */
    /* JADX WARN: Code duplicated, block: B:182:0x020c  */
    /* JADX WARN: Code duplicated, block: B:192:0x021e  */
    /* JADX WARN: Code duplicated, block: B:211:0x0242  */
    /* JADX WARN: Code duplicated, block: B:224:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:29:0x0065  */
    /* JADX WARN: Code duplicated, block: B:35:0x007e  */
    /* JADX WARN: Code duplicated, block: B:39:0x0089  */
    /* JADX WARN: Code duplicated, block: B:40:0x008b  */
    /* JADX WARN: Code duplicated, block: B:43:0x0092 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:49:0x009e  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:81:0x0102  */
    /* JADX WARN: Code duplicated, block: B:83:0x010e  */
    public c(ViewGroup viewGroup, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, int i, e eVar) {
        int i2;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        com.smartdigimkt.h.a aVar2;
        ArrayList arrayList;
        int i3;
        j0 j0Var;
        com.smartdigimkt.b3.e eVar2;
        Context context;
        p zVar;
        int i4;
        String strValueOf;
        boolean z;
        com.smartdigimkt.b3.e eVar3;
        com.smartdigimkt.b3.e eVar4;
        int i5;
        com.smartdigimkt.b3.e eVar5;
        int i6;
        boolean z2;
        boolean z3;
        com.smartdigimkt.b3.e eVar6;
        int i7;
        boolean z4;
        int i8;
        boolean z5;
        int i9;
        com.smartdigimkt.b3.e eVar7;
        boolean z6;
        boolean z7;
        SensorManager sensorManager;
        float f;
        int i10;
        boolean zC;
        this.g = false;
        this.a = viewGroup;
        this.b = cVar;
        this.c = aVar;
        this.d = i;
        cVar.getClass();
        if (i != 100) {
            switch (i) {
                case 1:
                case 2:
                    i4 = c(i) ? 16 : i4;
                    com.smartdigimkt.b3.e eVar8 = aVar.s;
                    i4 = (!eVar8.a0 || eVar8.b0 || eVar8.c0) ? i4 | 4 : i4;
                    if ((i != 1 || i == 2 || i == 3 || i == 4 || i == 6 || i == 5) && com.smartdigimkt.z.c0.d(aVar)) {
                        if (com.smartdigimkt.z.c0.i(cVar, aVar) && !com.smartdigimkt.z.c0.b(cVar, aVar)) {
                            strValueOf = String.valueOf(aVar.c);
                            strValueOf.getClass();
                            if (strValueOf.equals("4") && (cVar instanceof com.smartdigimkt.b3.l)) {
                                if (1 == ((com.smartdigimkt.b3.l) cVar).U) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                eVar3 = aVar.s;
                                if (eVar3.m != 1 && ((!z && eVar3.k1 == 2) || (z && eVar3.l1 == 2))) {
                                    if (com.smartdigimkt.z.c0.b(cVar, aVar)) {
                                    }
                                }
                            }
                            i4 |= 1;
                        } else if (com.smartdigimkt.z.c0.b(cVar, aVar)) {
                            i4 |= 1;
                        }
                    }
                    if ((i != 1 || i == 3) && aVar.s.Q == 1 && com.smartdigimkt.m1.d.a().c(com.anythink.core.common.a.b.d.i)) {
                    }
                    eVar4 = aVar.s;
                    i4 = eVar4.n0 == 1 ? i4 | 8 : i4;
                    if (aVar.c == 1) {
                        boolean zA = com.smartdigimkt.b3.h.a(eVar4.R1);
                        if (aVar.c == 1 || ((eVar4.n0 == 1 && !TextUtils.isEmpty(eVar4.p0)) || (eVar4.f1 == 1 && !zA))) {
                            zC = false;
                        } else {
                            zC = true;
                        }
                        if (zC && aVar.s.f1 == 2) {
                            if (com.smartdigimkt.r4.k.a()) {
                                zC = com.smartdigimkt.m1.d.a().c(com.anythink.core.common.a.b.d.o);
                            } else {
                                zC = com.smartdigimkt.m1.d.a().c(com.anythink.core.common.a.b.d.n);
                            }
                        }
                        if (zC) {
                            i4 |= 32;
                        }
                    }
                    com.smartdigimkt.b3.e eVar9 = aVar.s;
                    i5 = eVar9.j1;
                    if (i5 != 1 && ((i10 = aVar.c) == 3 ? !(i5 != 2 ? i5 != 3 || i != 2 || eVar9.m0 == 1 : com.smartdigimkt.z.c0.d(aVar) || ((TextUtils.isEmpty(cVar.l) && TextUtils.isEmpty(cVar.k)) || !com.smartdigimkt.m1.d.a().c(com.anythink.core.common.a.b.d.b))) : !(i10 != 4 || i5 != 2 || com.smartdigimkt.z.c0.d(aVar) || ((TextUtils.isEmpty(cVar.l) && TextUtils.isEmpty(cVar.k)) || !com.smartdigimkt.m1.d.a().c(com.anythink.core.common.a.b.d.b))))) {
                        i4 |= 64;
                    }
                    eVar5 = aVar.s;
                    if (eVar5 != null) {
                        i6 = eVar5.Q1;
                    } else {
                        i6 = -1;
                    }
                    if (com.smartdigimkt.z.c0.i(cVar, aVar) || i6 == 2 || i6 == 3) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (com.smartdigimkt.z.c0.b(cVar, aVar) && i6 != 2 && i6 != 3) {
                        z2 = true;
                    }
                    if (i != 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z2 && z3 && i6 == 3 && !SDKContext.getInstance().a(DeviceDataInfo.GYROSCOPE_DENY)) {
                        eVar7 = aVar.s;
                        if (eVar7 == null) {
                            z6 = false;
                        } else {
                            f = eVar7.U1;
                            float f2 = eVar7.V1;
                            float f3 = eVar7.W1;
                            if (f <= 0.0f || f2 > 0.0f || f3 > 0.0f) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                        }
                        try {
                            Context contextD = SDKContext.getInstance().d();
                            z7 = (contextD == null || (sensorManager = (SensorManager) contextD.getSystemService("sensor")) == null || sensorManager.getDefaultSensor(4) == null) ? false : true;
                        } catch (Throwable unused) {
                        }
                        if (z6 && z7) {
                            i4 |= 256;
                        }
                    }
                    eVar6 = this.c.s;
                    if (eVar6 != null) {
                        i7 = eVar6.S1;
                    } else {
                        i7 = 0;
                    }
                    if (i7 != 1 || i7 == 2 || i7 == 3) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    i8 = this.d;
                    if (i8 != 1 || i8 == 2 || i8 == 3 || ((i8 == 4 && z4) || i8 == 5)) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (!z2 && z5 && (((i8 != 4 && i8 != 5) || eVar6 == null || ((i9 = eVar6.e) != 1 && i9 != 2 && i9 != 3)) && i6 == 2)) {
                        i4 |= 128;
                    }
                    i2 = i4;
                case 3:
                case 4:
                case 5:
                case 6:
                    i4 = 0;
                    com.smartdigimkt.b3.e eVar10 = aVar.s;
                    if (eVar10.a0) {
                    }
                    if (i != 1) {
                        if (com.smartdigimkt.z.c0.i(cVar, aVar)) {
                            strValueOf = String.valueOf(aVar.c);
                            strValueOf.getClass();
                            if (strValueOf.equals("4")) {
                                if (1 == ((com.smartdigimkt.b3.l) cVar).U) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                eVar3 = aVar.s;
                                if (eVar3.m != 1) {
                                }
                            }
                            i4 |= 1;
                        } else if (com.smartdigimkt.z.c0.b(cVar, aVar)) {
                            i4 |= 1;
                        }
                    } else if (com.smartdigimkt.z.c0.i(cVar, aVar)) {
                        strValueOf = String.valueOf(aVar.c);
                        strValueOf.getClass();
                        if (strValueOf.equals("4")) {
                            if (1 == ((com.smartdigimkt.b3.l) cVar).U) {
                                z = true;
                            } else {
                                z = false;
                            }
                            eVar3 = aVar.s;
                            if (eVar3.m != 1) {
                            }
                        }
                        i4 |= 1;
                    } else if (com.smartdigimkt.z.c0.b(cVar, aVar)) {
                        i4 |= 1;
                    }
                    i4 = i != 1 ? i4 | 2 : i4 | 2;
                    eVar4 = aVar.s;
                    if (eVar4.n0 == 1) {
                    }
                    if (aVar.c == 1) {
                        boolean zA2 = com.smartdigimkt.b3.h.a(eVar4.R1);
                        if (aVar.c == 1) {
                            zC = false;
                        } else {
                            zC = false;
                        }
                        if (zC) {
                            if (com.smartdigimkt.r4.k.a()) {
                                zC = com.smartdigimkt.m1.d.a().c(com.anythink.core.common.a.b.d.o);
                            } else {
                                zC = com.smartdigimkt.m1.d.a().c(com.anythink.core.common.a.b.d.n);
                            }
                        }
                        if (zC) {
                            i4 |= 32;
                        }
                    }
                    com.smartdigimkt.b3.e eVar11 = aVar.s;
                    i5 = eVar11.j1;
                    if (i5 != 1) {
                    }
                    eVar5 = aVar.s;
                    if (eVar5 != null) {
                        i6 = eVar5.Q1;
                    } else {
                        i6 = -1;
                    }
                    if (com.smartdigimkt.z.c0.i(cVar, aVar)) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    if (com.smartdigimkt.z.c0.b(cVar, aVar)) {
                        z2 = true;
                    }
                    if (i != 1) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (!z2) {
                        eVar7 = aVar.s;
                        if (eVar7 == null) {
                            z6 = false;
                        } else {
                            f = eVar7.U1;
                            float f4 = eVar7.V1;
                            float f5 = eVar7.W1;
                            if (f <= 0.0f) {
                            }
                            z6 = true;
                        }
                        Context contextD2 = SDKContext.getInstance().d();
                        if (contextD2 == null) {
                            if (z6) {
                                i4 |= 256;
                            }
                        }
                        if (z6) {
                            i4 |= 256;
                        }
                    }
                    eVar6 = this.c.s;
                    if (eVar6 != null) {
                        i7 = eVar6.S1;
                    } else {
                        i7 = 0;
                    }
                    if (i7 != 1) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    i8 = this.d;
                    if (i8 != 1) {
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                    if (!z2) {
                        i4 |= 128;
                    }
                    i2 = i4;
                    break;
                default:
                    i2 = 0;
                    break;
            }
        } else if (com.smartdigimkt.z.c0.d(aVar)) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        Context context2 = this.a.getContext();
        int i11 = this.d;
        ArrayList arrayList2 = new ArrayList();
        RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(com.smartdigimkt.r4.k.a(context2, "myoffer_guide2click_container", "id"));
        View viewFindViewById = viewGroup.findViewById(com.smartdigimkt.r4.k.a(context2, "myoffer_guide2click_mask", "id"));
        if (i11 == 4) {
            View viewFindViewById2 = viewGroup.findViewById(com.smartdigimkt.r4.k.a(viewGroup.getContext(), "myoffer_banner_root", "id"));
            if (viewFindViewById2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) viewFindViewById2;
                viewGroup3 = viewGroup2;
            } else {
                viewGroup3 = viewGroup;
            }
        } else {
            View viewFindViewById3 = viewGroup.findViewById(com.smartdigimkt.r4.k.a(viewGroup.getContext(), "myoffer_rl_root", "id"));
            if (viewFindViewById3 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) viewFindViewById3;
            } else {
                View viewFindViewById4 = viewGroup.findViewById(com.smartdigimkt.r4.k.a(viewGroup.getContext(), "myoffer_splash_root", "id"));
                if (viewFindViewById4 instanceof ViewGroup) {
                    viewGroup2 = (ViewGroup) viewFindViewById4;
                } else {
                    viewGroup3 = viewGroup;
                }
            }
            viewGroup3 = viewGroup2;
        }
        boolean zIsRvDeepRewardListenerRegistered = viewGroup instanceof BaseATView ? ((BaseATView) viewGroup).isRvDeepRewardListenerRegistered() : false;
        Context context3 = viewGroup3.getContext();
        com.smartdigimkt.h.a aVar3 = com.smartdigimkt.h.a.a;
        if (aVar3 == null) {
            synchronized (com.smartdigimkt.h.a.class) {
                aVar2 = com.smartdigimkt.h.a.a;
                if (aVar2 == null) {
                    com.smartdigimkt.h.a.a = new com.smartdigimkt.h.a();
                    aVar2 = com.smartdigimkt.h.a.a;
                }
            }
            aVar3 = aVar2;
        }
        com.smartdigimkt.h.a aVar4 = aVar3;
        if ((i2 & 16) == 16) {
            g gVar = new g();
            arrayList = arrayList2;
            i3 = i11;
            gVar.a(viewGroup3.getContext(), cVar, aVar, viewGroup3, relativeLayout, viewFindViewById, i3, eVar);
            arrayList.add(gVar);
        } else {
            arrayList = arrayList2;
            i3 = i11;
        }
        if ((i2 & 2) == 2) {
            i iVar = new i();
            iVar.a(viewGroup3.getContext(), cVar, aVar, viewGroup3, relativeLayout, viewFindViewById, i3, eVar);
            arrayList.add(iVar);
        }
        if ((i2 & 4) == 4) {
            j0 j0Var2 = new j0();
            j0Var2.a(viewGroup3.getContext(), cVar, aVar, viewGroup3, relativeLayout, viewFindViewById, i3, eVar);
            arrayList.add(j0Var2);
        }
        if (relativeLayout != null && (i2 & 8) == 8) {
            j jVar = new j();
            jVar.a(viewGroup3.getContext(), cVar, aVar, viewGroup3, relativeLayout, viewFindViewById, i3, eVar);
            arrayList.add(jVar);
        }
        if ((i2 & 64) == 64) {
            d dVar = new d();
            dVar.a(viewGroup3.getContext(), cVar, aVar, viewGroup3, relativeLayout, viewFindViewById, i3, eVar);
            arrayList.add(dVar);
        }
        aVar4.getClass();
        if ((i2 & 1) == 1) {
            g0 g0Var = new g0();
            g0Var.a(context3, cVar, aVar, viewGroup3, relativeLayout, viewFindViewById, i3, eVar);
            arrayList.add(g0Var);
        }
        if ((i2 & 128) == 128) {
            q0 q0Var = new q0();
            q0Var.a(context3, cVar, aVar, viewGroup3, relativeLayout, viewFindViewById, i3, eVar);
            arrayList.add(q0Var);
        }
        if ((i2 & 256) == 256) {
            com.smartdigimkt.c.j jVar2 = new com.smartdigimkt.c.j();
            jVar2.a(context3, cVar, aVar, viewGroup3, relativeLayout, viewFindViewById, i3, eVar);
            arrayList.add(jVar2);
        }
        int i12 = i3;
        if (i12 == 3 && (com.smartdigimkt.z.c0.i(cVar, aVar) || com.smartdigimkt.z.c0.b(cVar, aVar))) {
            com.smartdigimkt.b.a aVar5 = new com.smartdigimkt.b.a();
            aVar5.a(context3, cVar, aVar, viewGroup3, relativeLayout, viewFindViewById, i12, eVar);
            arrayList.add(aVar5);
        }
        if (relativeLayout != null) {
            if ((i2 & 32) != 32) {
                Integer.toHexString(i2);
            } else {
                if (aVar == null || (eVar2 = aVar.s) == null) {
                    zVar = new p();
                } else if (com.smartdigimkt.b3.h.a(eVar2.R1)) {
                    if (zIsRvDeepRewardListenerRegistered) {
                        context = context3;
                        if (k.a(context, cVar)) {
                            int i13 = cVar.o;
                            if (i13 == 3 && context != null) {
                                if (TextUtils.isEmpty(cVar.k) || TextUtils.isEmpty(cVar.m)) {
                                    TextUtils.isEmpty(cVar.m);
                                    TextUtils.isEmpty(cVar.k);
                                } else {
                                    String strA = k.a(cVar);
                                    if (!TextUtils.isEmpty(strA)) {
                                        com.smartdigimkt.r4.k.c(context, strA);
                                    }
                                }
                            }
                            if (i13 == 6 && context != null) {
                                TextUtils.isEmpty(cVar.A);
                                com.smartdigimkt.r4.k.c(context, "com.tencent.mm");
                            }
                            TextUtils.isEmpty(cVar.k);
                            zVar = new p();
                        } else {
                            if (context != null) {
                                TextUtils.isEmpty(cVar.k);
                                int i14 = cVar.o;
                                if (i14 == 3) {
                                    if (!TextUtils.isEmpty(cVar.k) && !TextUtils.isEmpty(cVar.m)) {
                                        String strA2 = k.a(cVar);
                                        if (!TextUtils.isEmpty(strA2)) {
                                            com.smartdigimkt.r4.k.c(context, strA2);
                                        }
                                    }
                                } else if (i14 == 6 && !TextUtils.isEmpty(cVar.A)) {
                                    com.smartdigimkt.r4.k.c(context, "com.tencent.mm");
                                }
                            }
                            TextUtils.isEmpty(cVar.k);
                            zVar = new z();
                        }
                    } else {
                        zVar = new p();
                    }
                    p pVar = zVar;
                    pVar.a(context, cVar, aVar, viewGroup3, relativeLayout, viewFindViewById, i12, eVar);
                    arrayList.add(pVar);
                } else {
                    com.smartdigimkt.b3.d dVar2 = aVar.s.R1;
                    zVar = new p();
                }
                context = context3;
                p pVar2 = zVar;
                pVar2.a(context, cVar, aVar, viewGroup3, relativeLayout, viewFindViewById, i12, eVar);
                arrayList.add(pVar2);
            }
        }
        this.e = arrayList;
        this.g = c(this.d);
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    f fVar = (f) it.next();
                    if (fVar instanceof j0) {
                        j0Var = (j0) fVar;
                    }
                } else {
                    j0Var = null;
                }
            }
        } else {
            j0Var = null;
        }
        if (j0Var != null) {
            viewGroup.post(new a(this, j0Var));
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0070  */
    /* JADX WARN: Code duplicated, block: B:35:0x0092  */
    public final void a(int i) {
        if (i == 103) {
            if (!this.g && !com.smartdigimkt.z.c0.d(this.b, this.c)) {
                int iA = com.smartdigimkt.z.c0.a(this.c, this.a.getContext());
                com.smartdigimkt.b3.c cVar = this.b;
                com.smartdigimkt.a3.a aVar = this.c;
                com.smartdigimkt.b3.e eVar = cVar.w;
                com.smartdigimkt.n3.k.a(cVar, aVar, iA, false, 0, "", 0, eVar != null ? eVar.K0 : 1);
            }
        } else if (i != 113) {
            if (i == 118) {
                if (!this.g) {
                    int iA2 = com.smartdigimkt.z.c0.a(this.c, this.a.getContext());
                    com.smartdigimkt.b3.c cVar2 = this.b;
                    com.smartdigimkt.a3.a aVar2 = this.c;
                    com.smartdigimkt.b3.e eVar2 = cVar2.w;
                    com.smartdigimkt.n3.k.a(cVar2, aVar2, iA2, false, 0, "", 0, eVar2 != null ? eVar2.K0 : 1);
                }
            }
        } else if (com.smartdigimkt.i2.s.a(this.f)) {
            com.smartdigimkt.a3.a aVar3 = this.c;
            if (aVar3 != null && aVar3.s != null) {
                aVar3.t = true;
            }
            ViewGroup viewGroup = this.a;
            com.smartdigimkt.b3.c cVar3 = this.b;
            if (viewGroup != null && viewGroup.getContext() != null) {
                int iA3 = com.smartdigimkt.r4.k.a(viewGroup.getContext(), "myoffer_shake_hint_text", "id");
                int iA4 = com.smartdigimkt.r4.k.a(viewGroup.getContext(), "myoffer_splash_cta_shake", "id");
                int iA5 = com.smartdigimkt.r4.k.a(viewGroup.getContext(), "myoffer_splash_endcard_shake_hint_text", "id");
                String string = cVar3 == null ? null : viewGroup.getContext().getString(com.smartdigimkt.z.c0.a(viewGroup.getContext(), cVar3));
                if (viewGroup instanceof SinglePictureSplashATView) {
                    ((SinglePictureSplashATView) viewGroup).restoreCtaAfterShake();
                }
                com.smartdigimkt.i2.s.a(viewGroup, iA3, iA4, iA5, string);
            }
        }
        b(i);
    }

    public abstract ViewGroup.LayoutParams b();

    public final void b(int i) {
        ArrayList arrayList = this.e;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        com.smartdigimkt.q3.f.a().getClass();
        if (!com.smartdigimkt.q3.f.c()) {
            com.smartdigimkt.q3.f.a().a(new b(this, i));
            return;
        }
        HashMap map = new HashMap();
        HashMap map2 = this.f;
        if (map2 != null) {
            map.putAll(map2);
        }
        map.put("key_has_endcard_improve", Boolean.valueOf(this.g));
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((f) it.next()).a(i, map);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00cc, code lost:
    
        if (r0.j0 == 1) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean c(int r8) {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartdigimkt.b2.c.c(int):boolean");
    }

    public final p a() {
        ArrayList arrayList = this.e;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        for (f fVar : this.e) {
            if (fVar instanceof p) {
                return (p) fVar;
            }
        }
        return null;
    }

    public final void a(HashMap map) {
        if (map != null) {
            this.f.putAll(map);
        }
    }
}
