package com.anythink.core.mg.a;

import android.os.SystemClock;
import com.anythink.core.common.h.ar;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.v.p;
import com.anythink.core.common.v.q;
import com.anythink.core.mg.api.MgAdInfo;
import com.anythink.core.mg.api.MgComparedResult;
import com.anythink.core.mg.api.MgPreLoadAdRequest;
import com.anythink.core.mg.api.MgPreLoadCallback;
import com.anythink.core.mg.api.MgPreLoadCallbackRegister;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String a = "a";
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final Object c = new Object();
    private final AtomicReference<MgComparedResult> e = new AtomicReference<>();
    private final List<b> d = new ArrayList(2);

    private static boolean a(int i) {
        return i == 0 || i == 9 || i == 8 || i == 5;
    }

    public final void a(b bVar) {
        synchronized (this.c) {
            this.d.add(bVar);
        }
    }

    private void a(MgComparedResult mgComparedResult) {
        ArrayList<b> arrayList;
        this.e.set(mgComparedResult);
        if (this.d.isEmpty() || !this.b.compareAndSet(false, true)) {
            return;
        }
        Object[] objArr = new Object[2];
        q.a(Thread.currentThread().getStackTrace());
        if (mgComparedResult == null) {
            mgComparedResult = MgComparedResult.create();
        }
        synchronized (this.c) {
            arrayList = new ArrayList(this.d);
            this.d.clear();
        }
        if (arrayList.isEmpty()) {
            return;
        }
        for (b bVar : arrayList) {
            if (bVar != null) {
                bVar.a(mgComparedResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MgPreLoadAdRequest mgPreLoadAdRequest, bv bvVar, MgAdInfo mgAdInfo, long j, boolean z) {
        MgComparedResult mgComparedResultCreate = MgComparedResult.create(bvVar, mgAdInfo, j > 0 ? SystemClock.elapsedRealtime() - j : 0L, z);
        if (mgPreLoadAdRequest != null) {
            mgPreLoadAdRequest.setMgComparedResult(mgComparedResultCreate);
        }
        Object[] objArr = new Object[2];
        q.a(Thread.currentThread().getStackTrace());
        a(mgComparedResultCreate);
    }

    private static boolean b(ar arVar, bv bvVar) {
        boolean z = false;
        if (bvVar == null || arVar == null || arVar.b() == null) {
            Object[] objArr = new Object[1];
            Boolean bool = Boolean.FALSE;
            return false;
        }
        MgPreLoadAdRequest preLoadInfo = arVar.b().getPreLoadInfo();
        if (preLoadInfo != null && preLoadInfo.isEnableCpEcpm()) {
            z = true;
        }
        Object[] objArr2 = new Object[2];
        Boolean.valueOf(z);
        Integer.valueOf(arVar.c);
        return z;
    }

    public final MgComparedResult a() {
        return this.e.get();
    }

    private boolean a(bv bvVar) {
        MgComparedResult mgComparedResultA = a();
        if (mgComparedResultA != null && mgComparedResultA.isMgWin()) {
            double uSDEcpm = mgComparedResultA.getMgAdInfo() != null ? mgComparedResultA.getMgAdInfo().getUSDEcpm() : 0.0d;
            if (uSDEcpm > 0.0d && p.a(bvVar) < uSDEcpm) {
                return true;
            }
        }
        return false;
    }

    private bv b(bv bvVar) {
        MgComparedResult mgComparedResultA = a();
        if (p.a(bvVar) > ((mgComparedResultA == null || mgComparedResultA.getMgAdInfo() == null) ? 0.0d : mgComparedResultA.getMgAdInfo().getUSDEcpm())) {
            return bvVar;
        }
        return null;
    }

    public final void a(ar arVar, final bv bvVar) {
        boolean z = false;
        if (bvVar != null && arVar != null) {
            try {
                if (arVar.b() == null) {
                    Object[] objArr = new Object[1];
                    Boolean bool = Boolean.FALSE;
                } else {
                    MgPreLoadAdRequest preLoadInfo = arVar.b().getPreLoadInfo();
                    if (preLoadInfo != null && preLoadInfo.isEnableCpEcpm()) {
                        z = true;
                    }
                    Object[] objArr2 = new Object[2];
                    Boolean.valueOf(z);
                    Integer.valueOf(arVar.c);
                }
            } catch (Throwable th) {
                Object[] objArr3 = new Object[1];
                th.getMessage();
                a(MgComparedResult.create());
                return;
            }
        } else {
            Object[] objArr4 = new Object[1];
            Boolean bool2 = Boolean.FALSE;
        }
        if (!z) {
            a(MgComparedResult.create());
            return;
        }
        final MgPreLoadAdRequest preLoadInfo2 = arVar.b().getPreLoadInfo();
        MgPreLoadCallbackRegister preLoadCallbackRegister = preLoadInfo2 != null ? preLoadInfo2.getPreLoadCallbackRegister() : null;
        MgAdInfo mgAdInfo = preLoadCallbackRegister != null ? preLoadCallbackRegister.getMgAdInfo() : null;
        if (preLoadCallbackRegister != null && !MgAdInfo.isMgAdInfoValid(mgAdInfo)) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            preLoadCallbackRegister.registerPreLoadCallback(new MgPreLoadCallback() { // from class: com.anythink.core.mg.a.a.1
                @Override // com.anythink.core.mg.api.MgPreLoadCallback
                public final void onMgAdInfo(MgAdInfo mgAdInfo2, boolean z2) {
                    String unused = a.a;
                    Object[] objArr5 = new Object[2];
                    Boolean.valueOf(z2);
                    a.this.a(preLoadInfo2, bvVar, mgAdInfo2, jElapsedRealtime, z2);
                }
            });
            preLoadCallbackRegister.startTimeoutCountDown(preLoadInfo2.getCpEcpmTimeout());
            return;
        }
        a(preLoadInfo2, bvVar, mgAdInfo, 0L, false);
    }
}
