package com.anythink.dlopt.common.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.anythink.core.common.d.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class g implements Handler.Callback {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    private static final String f = "g";
    private final n g;
    private volatile HandlerThread h;
    private Handler i;
    private final List<String> j = Collections.synchronizedList(new ArrayList());
    private final Map<Integer, List<j>> k = Collections.synchronizedMap(new HashMap());
    private int l;

    public g(n nVar) {
        this.g = nVar;
    }

    public final void a(j jVar, int i) {
        if (jVar == null) {
            return;
        }
        String str = jVar.o;
        Object[] objArr = new Object[2];
        Integer.valueOf(i);
        if (this.g != null) {
            jVar.b(i);
            if ((jVar.j == null || jVar.j.r() == null) ? true : jVar.j.r().az()) {
                this.g.a(jVar);
            } else if (t.b().W()) {
                this.g.a(jVar);
            } else {
                Object[] objArr2 = new Object[1];
            }
        }
    }

    private List<j> b(List<j> list) {
        n nVar;
        List<String> list2;
        Context contextG = t.b().g();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            j jVar = list.get(i);
            if (!com.anythink.dlopt.common.c.a.a(contextG, jVar.e) && (nVar = this.g) != null && nVar.a(jVar.o) && ((list2 = this.j) == null || !list2.contains(jVar.o))) {
                arrayList.add(jVar);
            }
        }
        Object[] objArr = new Object[1];
        Integer.valueOf(arrayList.size());
        return arrayList;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            int i = message.what;
            if (message.obj instanceof j) {
                j jVar = (j) message.obj;
                String str = jVar.o;
                List<String> list = this.j;
                if (list != null) {
                    if (list.contains(str)) {
                        Object[] objArr = new Object[1];
                        return false;
                    }
                    this.j.add(str);
                }
                a(jVar, i);
                List<j> list2 = this.k.get(Integer.valueOf(i));
                if (list2 != null) {
                    list2.remove(jVar);
                    this.k.put(Integer.valueOf(i), list2);
                }
            }
        } catch (Throwable th) {
            Object[] objArr2 = new Object[1];
            th.getMessage();
        }
        return false;
    }

    public final void a() {
        Handler handler = this.i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void a(List<j> list) {
        n nVar;
        List<String> list2;
        Context contextG = t.b().g();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            j jVar = list.get(i);
            if (!com.anythink.dlopt.common.c.a.a(contextG, jVar.e) && (nVar = this.g) != null && nVar.a(jVar.o) && ((list2 = this.j) == null || !list2.contains(jVar.o))) {
                arrayList.add(jVar);
            }
        }
        Object[] objArr = new Object[1];
        Integer.valueOf(arrayList.size());
        if (arrayList.size() == 0) {
            return;
        }
        this.k.put(3, arrayList);
        if (this.h == null) {
            synchronized (g.class) {
                if (this.h == null) {
                    try {
                        this.h = new HandlerThread("anythink_apk_installer");
                        this.h.start();
                        this.i = new Handler(this.h.getLooper(), this);
                    } catch (Throwable th) {
                        Object[] objArr2 = new Object[1];
                        th.getMessage();
                    }
                }
            }
        }
        int iNextInt = (new Random().nextInt(121) + 60) * 1000;
        this.l = iNextInt;
        Object[] objArr3 = new Object[2];
        Integer.valueOf(iNextInt);
        Integer.valueOf(3);
        Handler handler = this.i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Message messageObtainMessage = this.i.obtainMessage(3);
            messageObtainMessage.obj = arrayList.get(0);
            this.i.sendMessageDelayed(messageObtainMessage, this.l);
        }
    }
}
