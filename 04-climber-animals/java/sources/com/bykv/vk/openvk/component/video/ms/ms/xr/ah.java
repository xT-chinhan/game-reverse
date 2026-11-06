package com.bykv.vk.openvk.component.video.ms.ms.xr;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.ah.d;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final ConcurrentHashMap<String, xr> f57ms = new ConcurrentHashMap<>();

    public static synchronized void ms(Context context, d dVar, com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms interfaceC0178ms) {
        try {
            if (dVar == null) {
                com.bykv.vk.openvk.component.video.api.c.ah.ms(" url、dir and hash is must property   in VideoInfoModel");
                return;
            }
            ConcurrentHashMap<String, xr> concurrentHashMap = f57ms;
            xr xrVar = concurrentHashMap.get(dVar.h());
            if (xrVar == null) {
                xrVar = new xr(context, dVar);
                concurrentHashMap.put(dVar.h(), xrVar);
                Object[] objArr = new Object[3];
                Integer.valueOf(dVar.c());
                dVar.h();
            }
            xrVar.ms(interfaceC0178ms);
            Object[] objArr2 = new Object[3];
            Integer.valueOf(dVar.c());
            dVar.h();
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void ms(d dVar) {
        xr xrVarRemove = f57ms.remove(dVar.h());
        if (xrVarRemove != null) {
            xrVarRemove.ms(true);
        }
        Object[] objArr = new Object[3];
        Integer.valueOf(dVar.c());
        dVar.h();
    }
}
