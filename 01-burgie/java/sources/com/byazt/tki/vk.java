package com.byazt.tki;

import com.byazt.tit.rc;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1549, 50})
public class vk implements com.byazt.awu.pr {
    public com.byazt.dg.pr hn;
    public String hw;
    public com.byazt.awu.pr[] pr;
    public boolean x;

    public vk(String str) {
        this.hw = str;
    }

    public void pr(com.byazt.awu.pr[] prVarArr) {
        this.pr = prVarArr;
    }

    public void pr(boolean z) {
        this.x = z;
    }

    public boolean hn() {
        return this.x;
    }

    @Override // com.byazt.awu.pr
    public Object pr(Map<String, JSONObject> map) {
        com.byazt.dg.pr prVar = new com.byazt.dg.pr();
        this.hn = prVar;
        prVar.pr(this.hw);
        Object[] objArr = new Object[this.pr.length];
        int i = 0;
        while (true) {
            com.byazt.awu.pr[] prVarArr = this.pr;
            if (i < prVarArr.length) {
                com.byazt.awu.pr prVar2 = prVarArr[i];
                if (prVar2 != null) {
                    objArr[i] = prVar2.pr(map);
                }
                i++;
            } else {
                this.hn.pr(objArr);
                return rc.pr(this.hw).pr(map.get("default_key"), objArr);
            }
        }
    }

    @Override // com.byazt.awu.pr
    public com.byazt.yiq.c pr() {
        return com.byazt.yiq.hw.METHOD;
    }

    @Override // com.byazt.awu.pr
    public String hw() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.hw).append("(");
        com.byazt.awu.pr[] prVarArr = this.pr;
        if (prVarArr != null && prVarArr.length > 0) {
            int i = 0;
            while (true) {
                com.byazt.awu.pr[] prVarArr2 = this.pr;
                if (i >= prVarArr2.length) {
                    break;
                }
                sb.append(prVarArr2[i].hw()).append(",");
                i++;
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
