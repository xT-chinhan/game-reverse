package com.anythink.core.api;

import com.anythink.core.common.h.z;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public class ATBiddingResult extends z {
    private ATBiddingResult(boolean z, double d, double d2, String str, ATBiddingNotice aTBiddingNotice, String str2, ATAdConst.CURRENCY currency) {
        super(z, d, d2, str, aTBiddingNotice, str2, currency);
    }

    public static ATBiddingResult success(double d, String str, ATBiddingNotice aTBiddingNotice) {
        return new ATBiddingResult(true, d, d, str, aTBiddingNotice, null, ATAdConst.CURRENCY.USD);
    }

    public static ATBiddingResult success(double d, String str, ATBiddingNotice aTBiddingNotice, ATAdConst.CURRENCY currency) {
        return new ATBiddingResult(true, d, d, str, aTBiddingNotice, null, currency);
    }

    public static ATBiddingResult success(double d, double d2, String str, ATBiddingNotice aTBiddingNotice, ATAdConst.CURRENCY currency) {
        return new ATBiddingResult(true, d, d2, str, aTBiddingNotice, null, currency);
    }

    public static ATBiddingResult fail(String str) {
        return new ATBiddingResult(false, 0.0d, 0.0d, null, null, str, ATAdConst.CURRENCY.USD);
    }

    public static ATBiddingResult fail(String str, ATBiddingNotice aTBiddingNotice, ATAdConst.CURRENCY currency) {
        return new ATBiddingResult(false, 0.0d, 0.0d, null, aTBiddingNotice, str, currency);
    }

    @Override // com.anythink.core.common.h.z
    public void setExtra(Object obj) {
        super.setExtra(obj);
    }

    public void setLoseNoticeUrl(String str) {
        this.loseNoticeUrl = str;
    }

    public void setWinNoticeUrl(String str) {
        this.winNoticeUrl = str;
    }

    public String toString() {
        return "ATBiddingResult{isSuccess=" + this.isSuccess + ", originPrice=" + this.originPrice + ", price=" + this.price + ", sortPrice=" + this.sortPrice + ", token='" + this.token + "', errorMsg='" + this.errorMsg + "', winNoticeUrl='" + this.winNoticeUrl + "', loseNoticeUrl='" + this.loseNoticeUrl + "', displayNoticeUrl='" + this.displayNoticeUrl + "', useType=" + this.useType + ", currency=" + this.currency + ", biddingNotice=" + this.biddingNotice + ", extra=" + this.extra + AbstractJsonLexerKt.END_OBJ;
    }
}
