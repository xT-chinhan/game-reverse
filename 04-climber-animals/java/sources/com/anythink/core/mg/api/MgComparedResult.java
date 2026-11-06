package com.anythink.core.mg.api;

import com.anythink.core.common.h.bv;
import com.anythink.core.common.v.p;
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

    public static MgComparedResult create(bv bvVar, MgAdInfo mgAdInfo, long j, boolean z) {
        try {
            double dA = p.a(bvVar);
            double uSDEcpm = mgAdInfo != null ? mgAdInfo.getUSDEcpm() : 0.0d;
            boolean z2 = uSDEcpm > dA;
            if (bvVar != null && bvVar.br()) {
                z2 = false;
            }
            Object[] objArr = new Object[3];
            Double.valueOf(dA);
            Double.valueOf(uSDEcpm);
            if (mgAdInfo != null) {
                mgAdInfo.getCurrency();
            }
            MgComparedResult mgComparedResult = new MgComparedResult(z2, mgAdInfo);
            mgComparedResult.isCompared = MgAdInfo.isMgAdInfoValid(mgAdInfo);
            mgComparedResult.cpCostTime = j;
            mgComparedResult.isCpTimeout = z;
            mgComparedResult.cpPrice = dA;
            return mgComparedResult;
        } catch (Throwable th) {
            Object[] objArr2 = new Object[1];
            th.getMessage();
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
