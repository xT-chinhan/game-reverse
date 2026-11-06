package com.anythink.core.c.a;

import android.text.TextUtils;
import com.anythink.core.d.f;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    f a;
    List<a> b;
    Map<Integer, List<a>> c = new ConcurrentHashMap(3);

    public final void a(int i, List<a> list) {
        if (i == -1) {
            this.b = list;
        } else {
            this.c.put(Integer.valueOf(i), list);
        }
    }

    public final List<a> a(int i) {
        if (i == -1) {
            return this.b;
        }
        return this.c.get(Integer.valueOf(i));
    }

    public final void a(f fVar) {
        this.a = fVar;
    }

    private f a() {
        return this.a;
    }

    public final boolean b(f fVar) {
        f fVar2 = this.a;
        return fVar2 != null && fVar2.b() == fVar.b() && this.a.a() == fVar.a() && this.a.c() == fVar.c() && this.a.d() == fVar.d();
    }

    public final void a(a aVar) {
        if (this.a == null) {
            return;
        }
        List<a> list = this.b;
        if (list != null) {
            a(list, aVar);
        }
        List<a> list2 = this.c.get(Integer.valueOf(aVar.a()));
        if (list2 != null) {
            a(list2, aVar);
        }
    }

    private void a(List<a> list, a aVar) {
        boolean z;
        Iterator<a> it = list.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else {
                if (TextUtils.equals(it.next().b(), aVar.b())) {
                    list.set(i, aVar);
                    z = true;
                    break;
                }
                i++;
            }
        }
        if (!z) {
            list.add(0, aVar);
        }
        while (list.size() > this.a.c()) {
            list.remove(list.size() - 1);
        }
    }

    public final d b(int i) {
        List<a> list;
        if (i == -1) {
            list = this.b;
        } else {
            list = this.c.get(Integer.valueOf(i));
        }
        if (list == null || list.size() < this.a.d()) {
            return null;
        }
        double d = 0.0d;
        String strD = "";
        for (a aVar : list) {
            double dF = aVar.f();
            if (dF > d) {
                strD = aVar.d();
                d = dF;
            }
        }
        return new d(d, strD);
    }

    public final void c(int i) {
        List<a> listA = a(i);
        if (this.a == null || listA == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - (((long) (((this.a.b() * 24) * 60) * 60)) * 1000);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(jCurrentTimeMillis);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        Iterator<a> it = listA.iterator();
        while (it.hasNext()) {
            if (it.next().g() < timeInMillis) {
                it.remove();
            }
        }
    }
}
