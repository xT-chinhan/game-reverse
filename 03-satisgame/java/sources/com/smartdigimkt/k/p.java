package com.smartdigimkt.k;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements Handler.Callback {
    public final b0 a;
    public volatile HandlerThread b;
    public Handler c;
    public final List d = Collections.synchronizedList(new ArrayList());
    public final Map e = Collections.synchronizedMap(new HashMap());
    public int f;

    public p(b0 b0Var) {
        this.a = b0Var;
    }

    public final void a(r rVar, int i) {
        b0 b0Var;
        com.smartdigimkt.b3.e eVar;
        if (rVar == null || (b0Var = this.a) == null) {
            return;
        }
        rVar.y = i;
        com.smartdigimkt.b3.c cVar = rVar.j;
        if (cVar == null || (eVar = cVar.w) == null || eVar.y0 == 1) {
            ((com.smartdigimkt.j.u) b0Var).a(rVar);
        } else if (SDKContext.getInstance().l) {
            ((com.smartdigimkt.j.u) this.a).a(rVar);
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        try {
            int i = message.what;
            Object obj = message.obj;
            if (obj instanceof r) {
                r rVar = (r) obj;
                String str = rVar.o;
                List list = this.d;
                if (list != null) {
                    if (list.contains(str)) {
                        return false;
                    }
                    this.d.add(str);
                }
                a(rVar, i);
                List list2 = (List) this.e.get(Integer.valueOf(i));
                if (list2 != null) {
                    list2.remove(rVar);
                    this.e.put(Integer.valueOf(i), list2);
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return false;
    }

    public final void a(ArrayList arrayList) {
        b0 b0Var;
        List list;
        Context contextD = SDKContext.getInstance().d();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            r rVar = (r) arrayList.get(i);
            if (!com.smartdigimkt.n.b.b(contextD, rVar.e) && (b0Var = this.a) != null) {
                if (((com.smartdigimkt.j.u) b0Var).a(rVar.o) && ((list = this.d) == null || !list.contains(rVar.o))) {
                    arrayList2.add(rVar);
                }
            }
        }
        arrayList2.size();
        if (arrayList2.size() == 0) {
            return;
        }
        this.e.put(3, arrayList2);
        if (this.b == null) {
            synchronized (p.class) {
                if (this.b == null) {
                    try {
                        this.b = new HandlerThread("sdm_apk_installer");
                        this.b.start();
                        this.c = new Handler(this.b.getLooper(), this);
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
            }
        }
        this.f = (new Random().nextInt(121) + 60) * 1000;
        Handler handler = this.c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Message messageObtainMessage = this.c.obtainMessage(3);
            messageObtainMessage.obj = arrayList2.get(0);
            this.c.sendMessageDelayed(messageObtainMessage, this.f);
        }
    }
}
