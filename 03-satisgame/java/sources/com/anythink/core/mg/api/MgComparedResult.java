package com.anythink.core.mg.api;

import com.anythink.core.common.h.by;
import com.anythink.core.common.u.o;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public class MgComparedResult {
    private long cpCostTime;
    private double cpPrice;
    private boolean isCompared;
    private boolean isCpTimeout;
    private final boolean isMgWin;
    private final MgAdInfo mgAdInfo;

    private MgComparedResult(boolean z) {
        this(z, null);
    }

    private MgComparedResult(boolean z, MgAdInfo mgAdInfo) {
        this.isMgWin = z;
        this.mgAdInfo = mgAdInfo;
    }

    public static MgComparedResult create() {
        return create(null, null, 0L, false);
    }

    public static MgComparedResult create(by byVar, MgAdInfo mgAdInfo, long j, boolean z) {
        try {
            double dA = o.a(byVar);
            boolean z2 = (mgAdInfo != null ? mgAdInfo.getUSDEcpm() : 0.0d) > dA;
            if (byVar != null && byVar.bz()) {
                z2 = false;
            }
            MgComparedResult mgComparedResult = new MgComparedResult(z2, mgAdInfo);
            mgComparedResult.isCompared = MgAdInfo.isMgAdInfoValid(mgAdInfo);
            mgComparedResult.cpCostTime = j;
            mgComparedResult.isCpTimeout = z;
            mgComparedResult.cpPrice = dA;
            return mgComparedResult;
        } catch (Throwable unused) {
            return new MgComparedResult(false);
        }
    }

    public String toString() {
        return "MgComparedResult{isMgWin=" + this.isMgWin + ", mgAdInfo=" + this.mgAdInfo + ", cpCostTime=" + this.cpCostTime + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean isMgWin() {
        return this.isMgWin;
    }

    public boolean isCompared() {
        return this.isCompared;
    }

    public MgAdInfo getMgAdInfo() {
        return this.mgAdInfo;
    }

    public long getCpCostTime() {
        return this.cpCostTime;
    }

    public boolean isCpTimeout() {
        return this.isCpTimeout;
    }

    public double getCpPrice() {
        return this.cpPrice;
    }
}
