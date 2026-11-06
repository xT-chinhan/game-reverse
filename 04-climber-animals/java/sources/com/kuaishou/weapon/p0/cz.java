package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class cz {
    private static volatile cz b;
    private Context a;

    private cz(Context context) {
        this.a = context;
    }

    public static cz a(Context context) {
        if (b == null) {
            synchronized (cz.class) {
                if (b == null) {
                    b = new cz(context);
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cz.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h hVarA = h.a(cz.this.a, "re_po_rt");
                    if (hVarA.b(df.G, 1) == 1) {
                        long jA = df.a(cz.this.a).a(df.bm);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jB = ((long) hVarA.b(df.I, 12)) * 3600000;
                        if (jA > 0 && jCurrentTimeMillis - jA < ((long) WeaponHI.ii) * 3600000 && WeaponHI.isList != null) {
                            if (WeaponHI.isList.contains(new StringBuilder().append(new Date(jCurrentTimeMillis).getHours()).toString())) {
                                return;
                            }
                        }
                        if (jCurrentTimeMillis - jA >= jB || i == 106) {
                            cp.a(cz.this.a, new cj(cz.this.a).a(ck.g), ck.g, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
