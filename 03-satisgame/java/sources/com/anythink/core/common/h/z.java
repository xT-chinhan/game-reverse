package com.anythink.core.common.h;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;

/* JADX INFO: loaded from: classes.dex */
public class z {
    public ATBiddingNotice biddingNotice;
    public com.anythink.core.common.f commonAdManager;
    public ATAdConst.CURRENCY currency;
    public String displayNoticeUrl;
    public String errorMsg;
    public Object extra;
    protected boolean isSuccess;
    public String loseNoticeUrl;
    public double originPrice;
    protected String originRequestId;
    protected double price;
    public double rmbPrice;
    protected double sortPrice;
    public String token;
    public int useType;
    public String winNoticeUrl;

    public z(boolean z, double d, String str, String str2, String str3, String str4, String str5, ATAdConst.CURRENCY currency) {
        this.useType = 1;
        this.isSuccess = z;
        this.originPrice = d;
        this.price = d;
        this.sortPrice = d;
        this.token = str;
        this.winNoticeUrl = str2;
        this.loseNoticeUrl = str3;
        this.displayNoticeUrl = str4;
        this.errorMsg = str5;
        this.currency = currency;
    }

    public z(boolean z, double d, String str, ATBiddingNotice aTBiddingNotice, String str2, ATAdConst.CURRENCY currency) {
        this.useType = 1;
        this.isSuccess = z;
        this.originPrice = d;
        this.price = d;
        this.sortPrice = d;
        this.token = str;
        this.biddingNotice = aTBiddingNotice;
        this.errorMsg = str2;
        this.currency = currency;
    }

    public z(boolean z, double d, double d2, String str, ATBiddingNotice aTBiddingNotice, String str2, ATAdConst.CURRENCY currency) {
        this(z, d2, str, aTBiddingNotice, str2, currency);
        this.sortPrice = d;
    }

    public com.anythink.core.common.f getCommonAdManager() {
        return this.commonAdManager;
    }

    public void setCommonAdManager(com.anythink.core.common.f fVar) {
        this.commonAdManager = fVar;
    }

    public boolean isSamePrice() {
        return this.sortPrice == this.originPrice;
    }

    public void setBiddingNotice(ATBiddingNotice aTBiddingNotice) {
        this.biddingNotice = aTBiddingNotice;
    }

    public boolean isSuccessWithUseType() {
        return this.isSuccess && this.useType == 1;
    }

    public void setPrice(double d) {
        this.price = d;
    }

    public double getPrice() {
        return this.price;
    }

    public double getOriginPrice() {
        return this.originPrice;
    }

    public void setSortPrice(double d) {
        this.sortPrice = d;
    }

    public double getSortPrice() {
        return this.sortPrice;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public Object getExtra() {
        return this.extra;
    }

    public String getOriginRequestId() {
        return this.originRequestId;
    }

    public void setOriginRequestId(String str) {
        this.originRequestId = str;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public double getRmbPrice() {
        return this.rmbPrice;
    }

    public ATAdConst.CURRENCY getCurrency() {
        return this.currency;
    }
}
