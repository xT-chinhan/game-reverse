package com.mcto.sspsdk.internal;

import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ei implements i7 {
    @Override // com.mcto.sspsdk.internal.i7
    public final void a(String str, h7 h7Var) {
        ArrayList<ui> arrayList;
        n4 n4VarA = n4.a();
        r3 r3VarA = fi.a(str);
        n4VarA.a(ImageViewManager.NAME);
        if (r3VarA == null || (arrayList = r3VarA.a) == null) {
            return;
        }
        ArrayList<ui> arrayList2 = new ArrayList();
        for (ui uiVar : arrayList) {
            if (!lj.b(uiVar.a) && !n4VarA.b.contains(uiVar.a)) {
                arrayList2.add(uiVar);
                n4VarA.b.add(uiVar.a);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ui uiVar2 = (ui) it.next();
            l4 l4VarA = n4VarA.a(uiVar2.b);
            String str2 = uiVar2.a;
            synchronized (l4VarA) {
                try {
                    if (!lj.b(str2)) {
                        String strD = gj.d(str2);
                        Iterator it2 = l4VarA.b.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                m4 m4Var = (m4) it2.next();
                                if (strD.equals(m4Var.a) || m4Var.b.contains(strD)) {
                                    String str3 = l4VarA.a.b;
                                    it.remove();
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    String str4 = l4VarA.a.b;
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        for (ui uiVar3 : arrayList2) {
            if (!lj.b(uiVar3.a)) {
                String str5 = gj.d(uiVar3.a) + "_e" + uiVar3.d + "_s" + uiVar3.c;
                if ("html".equals(uiVar3.b)) {
                    str5 = str5 + ".zip";
                }
                z5 z5Var = new z5();
                z5Var.a = uiVar3.a;
                String str6 = uiVar3.b;
                if (lj.b(str6)) {
                    str6 = ImageViewManager.NAME;
                }
                File file = new File(n4VarA.c, str6);
                if (!file.exists() && !file.mkdirs()) {
                    file = null;
                }
                z5Var.d = file;
                z5Var.c = str5;
                z5Var.b = 3;
                String str7 = uiVar3.b;
                if (!ImageViewManager.NAME.equals(str7) && !"html".equals(str7)) {
                    "video".equals(str7);
                }
                a6 a6Var = new a6(z5Var);
                o0 o0Var = new o0(uiVar3.a, uiVar3.b);
                if (!lj.b(a6Var.a) && a6Var.b != null) {
                    zg.a.a(new b6(a6Var, o0Var));
                }
            }
        }
    }

    @Override // com.mcto.sspsdk.internal.i7
    public final void a(h7 h7Var) {
        if (-4 != h7Var.c) {
            try {
                if (lj.b(nh.a(jd.a).a.getSharedPreferences("iad_spa", 0).getString("csalio", ""))) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(nh.a(jd.a).a.getSharedPreferences("iad_spa", 0).getString("csabr", ""));
                AtomicInteger atomicInteger = gj.a;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
                String str = simpleDateFormat.format(new Date());
                if (jSONObject.has(str)) {
                    jSONObject.remove(str);
                    jSONObject.toString();
                    nh.a(jd.a).a("iad_spa", "csabr", jSONObject.toString());
                }
            } catch (Throwable th) {
                r9.a("ssp_sdk", "updateLocalResponse(): ", th);
            }
        }
    }
}
