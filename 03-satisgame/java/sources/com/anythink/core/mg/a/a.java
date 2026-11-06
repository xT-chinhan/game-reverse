package com.anythink.core.mg.a;

import android.os.SystemClock;
import com.anythink.core.common.h.as;
import com.anythink.core.common.h.by;
import com.anythink.core.common.u.o;
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
    public void a(MgPreLoadAdRequest mgPreLoadAdRequest, by byVar, MgAdInfo mgAdInfo, long j, boolean z) {
        MgComparedResult mgComparedResultCreate = MgComparedResult.create(byVar, mgAdInfo, j > 0 ? SystemClock.elapsedRealtime() - j : 0L, z);
        if (mgPreLoadAdRequest != null) {
            mgPreLoadAdRequest.setMgComparedResult(mgComparedResultCreate);
        }
        a(mgComparedResultCreate);
    }

    private static boolean b(as asVar, by byVar) {
        MgPreLoadAdRequest preLoadInfo;
        return (byVar == null || asVar == null || asVar.b() == null || (preLoadInfo = asVar.b().getPreLoadInfo()) == null || !preLoadInfo.isEnableCpEcpm()) ? false : true;
    }

    public final MgComparedResult a() {
        return this.e.get();
    }

    private boolean a(by byVar) {
        MgComparedResult mgComparedResultA = a();
        if (mgComparedResultA != null && mgComparedResultA.isMgWin()) {
            double uSDEcpm = mgComparedResultA.getMgAdInfo() != null ? mgComparedResultA.getMgAdInfo().getUSDEcpm() : 0.0d;
            if (uSDEcpm > 0.0d && o.a(byVar) < uSDEcpm) {
                return true;
            }
        }
        return false;
    }

    private by b(by byVar) {
        MgComparedResult mgComparedResultA = a();
        if (o.a(byVar) > ((mgComparedResultA == null || mgComparedResultA.getMgAdInfo() == null) ? 0.0d : mgComparedResultA.getMgAdInfo().getUSDEcpm())) {
            return byVar;
        }
        return null;
    }

    public final void a(as asVar, final by byVar) {
        MgPreLoadAdRequest preLoadInfo;
        boolean z = false;
        if (byVar != null && asVar != null) {
            try {
                if (asVar.b() != null && (preLoadInfo = asVar.b().getPreLoadInfo()) != null && preLoadInfo.isEnableCpEcpm()) {
                    z = true;
                }
            } catch (Throwable unused) {
                a(MgComparedResult.create());
                return;
            }
        }
        if (!z) {
            a(MgComparedResult.create());
            return;
        }
        final MgPreLoadAdRequest preLoadInfo2 = asVar.b().getPreLoadInfo();
        MgPreLoadCallbackRegister preLoadCallbackRegister = preLoadInfo2 != null ? preLoadInfo2.getPreLoadCallbackRegister() : null;
        MgAdInfo mgAdInfo = preLoadCallbackRegister != null ? preLoadCallbackRegister.getMgAdInfo() : null;
        if (preLoadCallbackRegister != null && !MgAdInfo.isMgAdInfoValid(mgAdInfo)) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            preLoadCallbackRegister.registerPreLoadCallback(new MgPreLoadCallback() { // from class: com.anythink.core.mg.a.a.1
                @Override // com.anythink.core.mg.api.MgPreLoadCallback
                public final void onMgAdInfo(MgAdInfo mgAdInfo2, boolean z2) {
                    a.this.a(preLoadInfo2, byVar, mgAdInfo2, jElapsedRealtime, z2);
                }
            });
            preLoadCallbackRegister.startTimeoutCountDown(preLoadInfo2.getCpEcpmTimeout());
            return;
        }
        a(preLoadInfo2, byVar, mgAdInfo, 0L, false);
    }
}
