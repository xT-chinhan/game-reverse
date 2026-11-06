package com.anythink.basead.b;

import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.az;
import com.anythink.core.common.h.ba;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.v.o;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static final String a = "f";
    private static volatile f b;

    private f() {
    }

    public static f a() {
        if (b == null) {
            synchronized (f.class) {
                if (b == null) {
                    b = new f();
                }
            }
        }
        return b;
    }

    private static boolean a(String str, InputStream inputStream) {
        return a(str, inputStream, 1);
    }

    private static void a(az azVar, List<ay> list, ba baVar) {
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            x xVar = new x();
            xVar.o = baVar;
            if (azVar.a != null) {
                xVar.u = azVar.a.getChannelSource();
            }
            a(azVar.b, true, list.get(i), xVar, null);
        }
    }

    public static void a(String str, w wVar, x xVar, com.anythink.basead.b.c.c.b bVar) {
        a(str, false, wVar, xVar, bVar);
    }

    public static void a(String str, boolean z, w wVar, x xVar, com.anythink.basead.b.c.c.b bVar) {
        new com.anythink.basead.b.c.c(str, z, wVar, xVar).a(bVar);
    }

    public static boolean a(ay ayVar, x xVar) {
        return com.anythink.basead.b.c.d.a(ayVar, xVar);
    }

    public static boolean a(ay ayVar, int i, y yVar) {
        return com.anythink.basead.b.c.d.a(ayVar, i, yVar);
    }

    public static boolean a(String str, InputStream inputStream, int i) {
        if (str == null || inputStream == null) {
            return false;
        }
        return com.anythink.core.common.res.d.a(t.b().g()).a(i, o.a(str), inputStream);
    }

    private static FileInputStream b(int i, String str) {
        return com.anythink.core.common.res.d.a(t.b().g()).a(i, o.a(str));
    }

    public static String a(int i, String str) {
        return com.anythink.core.common.res.d.a(t.b().g()).c(i, o.a(str));
    }
}
