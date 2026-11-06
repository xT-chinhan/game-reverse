package com.anythink.core.api;

/* JADX INFO: loaded from: classes.dex */
public class ATAdMixBidInfo {
    private static ATAdMixBidInfo sInstance;
    private XBiddingInfo xBiddingInfo;

    public static abstract class XBiddingInfo {
        public abstract BidEntity getBiddingInfo(ATAdInfo aTAdInfo);
    }

    public static ATAdMixBidInfo getInstance() {
        ATAdMixBidInfo aTAdMixBidInfo;
        synchronized (ATAdMixBidInfo.class) {
            if (sInstance == null) {
                sInstance = new ATAdMixBidInfo();
            }
            aTAdMixBidInfo = sInstance;
        }
        return aTAdMixBidInfo;
    }

    public void registerMixBiddingInfo(XBiddingInfo xBiddingInfo) {
        this.xBiddingInfo = xBiddingInfo;
    }

    public XBiddingInfo getXBiddingInfo() {
        return this.xBiddingInfo;
    }

    public static class BidEntity {
        private String adPackageName;
        private String adTittle;
        private String adUserName;

        public BidEntity() {
        }

        public BidEntity(String str, String str2) {
            this.adTittle = str;
            this.adUserName = str2;
        }

        public String getAdTittle() {
            return this.adTittle;
        }

        public void setAdTittle(String str) {
            this.adTittle = str;
        }

        public String getAdUserName() {
            return this.adUserName;
        }

        public void setAdUserName(String str) {
            this.adUserName = str;
        }

        public String getAdPackageName() {
            return this.adPackageName;
        }

        public void setAdPackageName(String str) {
            this.adPackageName = str;
        }
    }
}
