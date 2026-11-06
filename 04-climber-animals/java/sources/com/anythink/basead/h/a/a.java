package com.anythink.basead.h.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.b.f;
import com.anythink.basead.d.c;
import com.anythink.basead.d.g;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.az;
import com.anythink.core.common.h.ba;
import com.anythink.core.common.h.x;
import com.anythink.core.d.l;
import com.anythink.core.d.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static a a;
    private Context b;

    private a(Context context) {
        this.b = context.getApplicationContext();
    }

    public static a a(Context context) {
        if (a == null) {
            a = new a(context);
        }
        return a;
    }

    public final void a(az azVar) {
        List<ay> listAa;
        ba baVarZ;
        l lVarA = n.a(this.b).a(azVar.b);
        if (lVarA == null || (listAa = lVarA.aa()) == null || (baVarZ = lVarA.Z()) == null) {
            return;
        }
        f.a();
        if (listAa != null) {
            int size = listAa.size();
            for (int i = 0; i < size; i++) {
                x xVar = new x();
                xVar.o = baVarZ;
                if (azVar.a != null) {
                    xVar.u = azVar.a.getChannelSource();
                }
                f.a(azVar.b, true, listAa.get(i), xVar, null);
            }
        }
    }

    public final ay a(String str, String str2) {
        l lVarA = n.a(this.b).a(str);
        if (lVarA == null) {
            return null;
        }
        return lVarA.b(str2);
    }

    public final String a(String str) {
        l lVarA = n.a(this.b).a(str);
        if (lVarA == null) {
            return "";
        }
        List<ay> listAa = lVarA.aa();
        ArrayList arrayList = new ArrayList();
        if (listAa == null || listAa.size() == 0) {
            return "";
        }
        for (int size = listAa.size() - 1; size >= 0; size--) {
            ay ayVar = listAa.get(size);
            f.a();
            if (!f.a(ayVar, lVarA.aq(), lVarA.Z())) {
                listAa.remove(size);
            } else {
                arrayList.add(b.a(this.b).d(ayVar));
            }
        }
        if (arrayList.size() == 0) {
            return "";
        }
        Collections.sort(arrayList, new Comparator<c>() { // from class: com.anythink.basead.h.a.a.1
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(c cVar, c cVar2) {
                return Integer.valueOf(cVar.d).compareTo(Integer.valueOf(cVar2.d));
            }

            private static int a(c cVar, c cVar2) {
                return Integer.valueOf(cVar.d).compareTo(Integer.valueOf(cVar2.d));
            }
        });
        return ((c) arrayList.get(0)).a;
    }

    public final void a(String str, ay ayVar, x xVar, com.anythink.basead.b.c.c.b bVar) {
        if (a(ayVar)) {
            bVar.a(g.a(g.h, g.M));
            return;
        }
        if (b.a(this.b).b(ayVar)) {
            bVar.a(g.a(g.e, g.F));
        } else if (b.a(this.b).c(ayVar)) {
            bVar.a(g.a(g.f, g.G));
        } else {
            f.a();
            f.a(str, ayVar, xVar, bVar);
        }
    }

    private static boolean a(ay ayVar) {
        List<String> listK = t.b().k();
        if (listK == null) {
            return false;
        }
        Iterator<String> it = listK.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(ayVar.I(), it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(ay ayVar, x xVar, boolean z) {
        if (this.b == null || ayVar == null || a(ayVar)) {
            return false;
        }
        if (z) {
            f.a();
            return f.a(ayVar, xVar);
        }
        if (!b.a(this.b).b(ayVar) && !b.a(this.b).c(ayVar)) {
            f.a();
            if (f.a(ayVar, xVar)) {
                return true;
            }
        }
        return false;
    }
}
