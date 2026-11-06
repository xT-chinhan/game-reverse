package com.mcto.sspsdk.internal;

import android.os.Message;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e8 implements eb {
    @Override // com.mcto.sspsdk.internal.eb
    public final void a(Message message) {
        int i = message.what;
        if (i == 1) {
            y4.r.k();
            zg.a.a(new x4());
            return;
        }
        if (i != 2) {
            return;
        }
        if (e4.b == null) {
            synchronized (e4.class) {
                if (e4.b == null) {
                    e4.b = new e4();
                }
            }
        }
        HashMap map = new HashMap(1);
        map.put(UMModuleRegister.PROCESS, jd.a());
        map.put("csc", "" + v4.a(jd.a).b());
        za.d().getClass();
        ya yaVar = new ya(null);
        yaVar.a = "auu";
        yaVar.q = "2001";
        yaVar.j = gj.a("st" + j.a(51));
        yaVar.x = gj.a((Map) map, ";", ":", true);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(yaVar);
        za.a(za.a(arrayList));
    }
}
