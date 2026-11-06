package com.mcto.sspsdk.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class wk implements Runnable {
    public final /* synthetic */ kk a;
    public final /* synthetic */ xk b;

    public wk(xk xkVar, kk kkVar) {
        this.b = xkVar;
        this.a = kkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        fl flVar;
        List list;
        bl blVarA = this.b.a.a();
        jl jlVar = blVarA == null ? new jl(Integer.MAX_VALUE, 0) : new jl(blVarA.g, (int) blVarA.c);
        vk vkVar = new vk(this);
        ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(gh.a.g);
        boolean z = false;
        while (jlVar.c <= jlVar.a && !z) {
            gl glVarA = gl.a();
            int i = jlVar.c;
            synchronized (glVarA) {
                HashMap map = glVarA.a;
                flVar = null;
                if (map != null && (list = (List) map.get("fullscreen")) != null && !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        fl flVar2 = (fl) it.next();
                        if (flVar2.a >= i) {
                            flVar = flVar2;
                            break;
                        }
                    }
                }
            }
            if (flVar == null) {
                break;
            }
            jlVar.c = flVar.a + 1;
            int i2 = 0;
            for (cl clVar : flVar.b) {
                if (flVar.a == jlVar.a && clVar.b <= jlVar.b) {
                    break;
                }
                i2++;
                executorCompletionService.submit(new hl(jlVar, clVar));
            }
            for (int i3 = 0; i3 < i2; i3++) {
                try {
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    Future futurePoll = executorCompletionService.poll(5L, timeUnit);
                    if (futurePoll != null && futurePoll.get(1L, timeUnit) != null) {
                        vkVar.a.b.a.a("fullscreen", (bl) futurePoll.get());
                        z = true;
                    }
                } catch (Exception e) {
                }
            }
        }
        vkVar.a();
    }
}
