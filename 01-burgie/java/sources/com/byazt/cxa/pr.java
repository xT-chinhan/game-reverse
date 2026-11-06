package com.byazt.cxa;

import com.mar.sdk.MARCode;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 228, 37})
public class pr {
    public String c;
    public String hn;
    public String hw;
    public String pr;
    public String x;

    public pr(C0037pr c0037pr) {
        this.hw = "";
        this.pr = c0037pr.pr;
        this.hw = c0037pr.hw;
        this.hn = c0037pr.hn;
        this.x = c0037pr.x;
        this.c = c0037pr.c;
    }

    /* JADX INFO: renamed from: com.byazt.cxa.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 228, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static class C0037pr {
        public String c;
        public String hn;
        public String hw;
        public String pr;
        public String x;

        public C0037pr pr(String str) {
            this.pr = str;
            return this;
        }

        public C0037pr hw(String str) {
            this.hw = str;
            return this;
        }

        public C0037pr hn(String str) {
            this.x = str;
            return this;
        }

        public C0037pr x(String str) {
            this.c = str;
            return this;
        }

        public pr pr() {
            return new pr(this);
        }
    }
}
