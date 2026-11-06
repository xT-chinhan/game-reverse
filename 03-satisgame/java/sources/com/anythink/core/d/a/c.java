package com.anythink.core.d.a;

import android.text.TextUtils;
import com.anythink.core.e.g;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    g a;
    List<a> b;
    Map<Integer, List<a>> c = new ConcurrentHashMap(3);

    public final synchronized void a(int i, List<a> list) {
        try {
            if (i == -1) {
                this.b = list;
            } else {
                this.c.put(Integer.valueOf(i), list);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized List<a> a(int i) {
        try {
            if (i == -1) {
                return this.b;
            }
            return this.c.get(Integer.valueOf(i));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void a(g gVar) {
        this.a = gVar;
    }

    private synchronized g a() {
        return this.a;
    }

    public final synchronized boolean b(g gVar) {
        g gVar2 = this.a;
        if (gVar2 == null) {
            return false;
        }
        return gVar2.b() == gVar.b() && this.a.a() == gVar.a() && this.a.c() == gVar.c() && this.a.d() == gVar.d();
    }

    public final synchronized void a(a aVar) {
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
        int iMax = Math.max(0, this.a.c());
        while (list.size() > iMax) {
            list.remove(list.size() - 1);
        }
    }

    public final synchronized d b(int i) {
        List<a> list;
        try {
            if (i == -1) {
                list = this.b;
            } else {
                list = this.c.get(Integer.valueOf(i));
            }
            if (this.a == null || list == null || list.size() < this.a.d()) {
                return null;
            }
            String strD = "";
            double d = 0.0d;
            for (a aVar : list) {
                double dF = aVar.f();
                if (dF > d) {
                    strD = aVar.d();
                    d = dF;
                }
            }
            return new d(d, strD);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c(int i) {
        List<a> listA = a(i);
        if (this.a != null && listA != null) {
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
}
