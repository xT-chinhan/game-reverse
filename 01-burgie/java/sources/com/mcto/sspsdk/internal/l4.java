package com.mcto.sspsdk.internal;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class l4 {
    public final k4 a;
    public final ArrayList b = new ArrayList();

    public l4(k4 k4Var) {
        this.a = k4Var;
        try {
            if (k4Var.a != null) {
                c();
                if (y4.r.j()) {
                    b();
                }
            }
        } catch (Exception e) {
            String str = this.a.b;
        }
    }

    public final void a(m4 m4Var) {
        try {
            String str = this.a.b;
            for (int i = 0; i < this.b.size(); i++) {
                if (m4Var.d > ((m4) this.b.get(i)).d) {
                    this.b.add(i, m4Var);
                    return;
                }
            }
            this.b.add(m4Var);
        } catch (Exception e) {
            String str2 = this.a.b;
        }
    }

    public final synchronized void b() {
        try {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                m4 m4Var = (m4) it.next();
                long j = m4Var.c;
                if (j > 0 && j < System.currentTimeMillis() / 1000 && !lj.b(m4Var.b) && p4.a(new File(m4Var.b))) {
                    String str = this.a.b;
                    it.remove();
                }
            }
        } catch (Exception e) {
            String str2 = this.a.b;
        }
    }

    public final void c() {
        File file = this.a.a;
        if (!file.exists() && !file.mkdirs()) {
            r9.a("ssp_splash_m", this.a.b, " init creates the directory error!");
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            String str = this.a.b;
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.getName().endsWith(".zip")) {
                zg.a.a(new o4(file2.getAbsolutePath()));
            } else if (!file2.getName().endsWith(".cdf")) {
                a(new m4(file2));
            }
        }
    }

    public final void a() {
        int size = this.b.size() - this.a.c;
        this.b.size();
        int i = this.a.c;
        if (size > 0) {
            b();
            int size2 = this.b.size() - this.a.c;
            if (size2 > this.b.size()) {
                size2 = this.b.size();
            }
            Iterator it = this.b.iterator();
            while (size2 > 0 && it.hasNext()) {
                m4 m4Var = (m4) it.next();
                ArrayList arrayList = n4.a().b;
                if (arrayList != null) {
                    Iterator it2 = arrayList.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String strD = gj.d((String) it2.next());
                            if (strD.equals(m4Var.a) || m4Var.b.contains(strD)) {
                            }
                        }
                    }
                }
                if (p4.a(new File(m4Var.b))) {
                    String str = this.a.b;
                    it.remove();
                    size2--;
                }
            }
        }
    }
}
