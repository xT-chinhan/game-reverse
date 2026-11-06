package com.byazt.ic;

import com.mar.sdk.MARCode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1038, 37})
public class pr {
    public int c;
    public JSONObject fw;
    public String hn;
    public String hw;
    public String pr;
    public long uc;
    public int x;

    public String pr() {
        return this.pr;
    }

    public String hw() {
        return this.hw;
    }

    public String hn() {
        return this.hn;
    }

    public int x() {
        return this.x;
    }

    public int c() {
        return this.c;
    }

    public long uc() {
        return this.uc;
    }

    public JSONObject fw() {
        return this.fw;
    }

    /* JADX INFO: renamed from: com.byazt.ic.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1038, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static class C0093pr {
        public int c;
        public JSONObject fw;
        public String hn;
        public String hw;
        public String pr;
        public long uc;
        public int x;

        public C0093pr pr(String str) {
            this.pr = str;
            return this;
        }

        public C0093pr hw(String str) {
            this.hw = str;
            return this;
        }

        public C0093pr hn(String str) {
            this.hn = str;
            return this;
        }

        public C0093pr pr(int i) {
            this.x = i;
            return this;
        }

        public C0093pr hw(int i) {
            this.c = i;
            return this;
        }

        public C0093pr pr(long j) {
            this.uc = j;
            return this;
        }

        public C0093pr pr(JSONObject jSONObject) {
            this.fw = jSONObject;
            return this;
        }

        public pr pr() {
            pr prVar = new pr();
            prVar.pr = this.pr;
            prVar.hw = this.hw;
            prVar.hn = this.hn;
            prVar.x = this.x;
            prVar.c = this.c;
            prVar.uc = this.uc;
            prVar.fw = this.fw;
            return prVar;
        }
    }
}
