package com.byazt.cm;

import android.text.TextUtils;
import com.byazt.vkw.er;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1395, 20})
public class hn implements er {
    public hw hw = new hw();
    public pr hn = new pr();
    public boolean pr = !this.hw.pr();

    @Override // com.byazt.vkw.er
    public String pr(String str) {
        String strPr;
        if (!this.hw.pr()) {
            strPr = "";
        } else {
            strPr = this.hw.pr(str);
        }
        if (this.pr && TextUtils.isEmpty(strPr)) {
            return this.hn.pr(str);
        }
        return strPr;
    }

    @Override // com.byazt.vkw.er
    public int hw(String str) {
        int iHw;
        if (!this.hw.pr()) {
            iHw = Integer.MAX_VALUE;
        } else {
            iHw = this.hw.hw(str);
        }
        if (this.pr && iHw == Integer.MAX_VALUE) {
            return this.hn.hw(str);
        }
        return iHw;
    }

    @Override // com.byazt.vkw.er
    public long hn(String str) {
        long jHn;
        if (!this.hw.pr()) {
            jHn = LongCompanionObject.MAX_VALUE;
        } else {
            jHn = this.hw.hn(str);
        }
        if (this.pr && jHn == 2147483647L) {
            return this.hn.hn(str);
        }
        return jHn;
    }

    @Override // com.byazt.vkw.er
    public boolean x(String str) {
        boolean zX;
        if (!this.hw.pr()) {
            zX = false;
        } else {
            zX = this.hw.x(str);
        }
        if (this.pr && !zX) {
            return this.hn.x(str);
        }
        return zX;
    }

    @Override // com.byazt.vkw.er
    public void pr(String str, String str2) {
        if (this.hw.pr()) {
            this.hw.pr(str, str2);
        }
    }
}
