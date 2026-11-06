package com.mcto.sspsdk.internal;

import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class n4 {
    public static volatile n4 d;
    public HashMap a;
    public final ArrayList b = new ArrayList();
    public final File c = new File(jd.a.getFilesDir(), ".issp_splash");

    public static n4 a() {
        if (d == null) {
            synchronized (n4.class) {
                if (d == null) {
                    d = new n4();
                }
            }
        }
        return d;
    }

    public final void b(File file, String str) {
        l4 l4VarA = a(str);
        synchronized (l4VarA) {
            try {
                Iterator it = l4VarA.b.iterator();
                while (it.hasNext()) {
                    if (((m4) it.next()).b.equals(file.getAbsolutePath())) {
                        it.remove();
                        String str2 = l4VarA.a.b;
                        file.getName();
                    }
                }
            } catch (Exception e) {
                String str3 = l4VarA.a.b;
            }
        }
    }

    public final String a(String str, String str2) {
        l4 l4VarA = a(str2);
        synchronized (l4VarA) {
            try {
                String strD = gj.d(str);
                for (m4 m4Var : l4VarA.b) {
                    if (m4Var.a.equals(strD) || m4Var.b.contains(strD)) {
                        return m4Var.b;
                    }
                }
            } catch (Exception e) {
                String str3 = l4VarA.a.b;
            }
            String str4 = l4VarA.a.b;
            return null;
        }
    }

    public final void a(File file, String str) {
        file.getName();
        l4 l4VarA = a(str);
        synchronized (l4VarA) {
            try {
                Iterator it = l4VarA.b.iterator();
                while (it.hasNext()) {
                    if (((m4) it.next()).b.equals(file.getAbsolutePath())) {
                        String str2 = l4VarA.a.b;
                        file.getName();
                    }
                }
            } catch (Exception e) {
                try {
                    String str3 = l4VarA.a.b;
                } catch (Exception e2) {
                    String str4 = l4VarA.a.b;
                }
            }
            l4VarA.a(new m4(file));
            l4VarA.a();
        }
    }

    public final synchronized l4 a(String str) {
        l4 l4Var;
        if (this.a == null) {
            this.a = new HashMap();
        }
        l4Var = (l4) this.a.get(str);
        if (l4Var == null) {
            File file = this.c;
            k4 k4Var = new k4();
            k4Var.b = str;
            if (ImageViewManager.NAME.equals(str)) {
                k4Var.a = new File(file, ImageViewManager.NAME);
                k4Var.c = 14;
            } else {
                k4Var.a = new File(file, "video");
                k4Var.c = 7;
            }
            l4Var = new l4(k4Var);
            this.a.put(str, l4Var);
        }
        return l4Var;
    }
}
