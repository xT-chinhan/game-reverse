package com.smartdigimkt.d0;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class u {
    public static volatile u b;
    public final CopyOnWriteArrayList a = new CopyOnWriteArrayList();

    public static u a() {
        if (b == null) {
            synchronized (u.class) {
                if (b == null) {
                    b = new u();
                }
            }
        }
        return b;
    }

    public final synchronized void b(t tVar) {
        int size = this.a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (tVar == this.a.get(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            this.a.remove(i);
        }
    }

    public final synchronized void a(t tVar) {
        this.a.add(tVar);
    }

    public final void a(int i, String str) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.a;
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                q qVar = (q) ((t) it.next());
                qVar.d.size();
                synchronized (qVar) {
                    s.b(i, str);
                    ArrayList arrayList = qVar.d;
                    if (arrayList != null && arrayList.contains(str) && (!qVar.f.a(str) || qVar.g.S <= i)) {
                        qVar.d.remove(str);
                        if (qVar.f.a(str)) {
                            c0.a(qVar.f, qVar.g);
                        }
                        if (qVar.d.isEmpty()) {
                            qVar.a(1);
                        } else if (com.smartdigimkt.z.c0.f(qVar.f, qVar.h)) {
                            String strA = qVar.f.f;
                            if (TextUtils.equals(String.valueOf(qVar.h.s.a), "2")) {
                                strA = qVar.f.a(qVar.g);
                            }
                            if (qVar.f.a(str) && !TextUtils.isEmpty(strA)) {
                                qVar.d.remove(strA);
                                if (qVar.d.isEmpty()) {
                                    qVar.a(1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void a(String str, com.smartdigimkt.h0.g gVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.a;
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                q qVar = (q) ((t) it.next());
                qVar.d.size();
                gVar.a();
                synchronized (qVar) {
                    byte b2 = -1;
                    s.b(-1, str);
                    ArrayList arrayList = qVar.d;
                    if (arrayList != null) {
                        arrayList.remove(str);
                    }
                    if (qVar.f.a(str) && com.smartdigimkt.z.c0.f(qVar.f, qVar.h)) {
                        com.smartdigimkt.n3.k.a(qVar.h, qVar.f, 1, gVar.a());
                    }
                    String strValueOf = String.valueOf(qVar.h.s.a);
                    switch (strValueOf.hashCode()) {
                        case 48:
                            if (strValueOf.equals("0")) {
                                b2 = 2;
                            }
                            break;
                        case 49:
                            if (strValueOf.equals("1")) {
                                b2 = 0;
                            }
                            break;
                        case 50:
                            if (strValueOf.equals("2")) {
                                b2 = 4;
                            }
                            break;
                        case 51:
                            if (strValueOf.equals("3")) {
                                b2 = 1;
                            }
                            break;
                        case 52:
                            if (strValueOf.equals("4")) {
                                b2 = 3;
                            }
                            break;
                    }
                    if (b2 == 0 || b2 == 1) {
                        qVar.a(gVar);
                    } else if (b2 == 2) {
                        qVar.a(1);
                    } else if (b2 == 3 || b2 == 4) {
                        String strA = qVar.f.f;
                        if (TextUtils.equals(String.valueOf(qVar.h.s.a), "2")) {
                            strA = qVar.f.a(qVar.g);
                        }
                        if (!qVar.f.a(str) && (TextUtils.isEmpty(strA) || !TextUtils.equals(strA, str))) {
                            qVar.a(gVar);
                        } else if (TextUtils.isEmpty(strA)) {
                            qVar.a(gVar);
                        } else if (qVar.f.a(str) && qVar.d.size() == 0) {
                            qVar.a(1);
                        } else {
                            ArrayList arrayList2 = qVar.d;
                            if (arrayList2 == null || (!arrayList2.contains(qVar.f.i) && !qVar.d.contains(qVar.f.f))) {
                                qVar.a(gVar);
                            }
                        }
                    }
                }
            }
        }
    }
}
