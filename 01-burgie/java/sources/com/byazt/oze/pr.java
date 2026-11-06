package com.byazt.oze;

import com.byazt.kj.aj;
import com.byazt.kj.c;
import com.byazt.kj.fw;
import com.byazt.kj.hn;
import com.byazt.kj.hw;
import com.byazt.kj.uc;
import com.byazt.kj.vk;
import com.byazt.kj.x;
import com.byazt.kj.zo;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 760, 37})
public class pr {
    public static final com.byazt.gb.pr pr;
    public String c;
    public com.byazt.awu.pr hn;
    public final com.byazt.gb.pr hw;
    public Deque<com.byazt.awu.pr> x = new LinkedList();

    static {
        int i = 8;
        uc[] ucVarArr = {new vk(), new x(), new aj(), new hw(), new c(), new com.byazt.kj.pr(), new fw(), new hn(), new zo()};
        final com.byazt.gb.pr prVar = new com.byazt.gb.pr() { // from class: com.byazt.oze.pr.1
            @Override // com.byazt.gb.pr
            public int pr(String str, int i2, Deque<com.byazt.awu.pr> deque) {
                return i2;
            }
        };
        while (i >= 0) {
            final uc ucVar = ucVarArr[i];
            i--;
            prVar = new com.byazt.gb.pr() { // from class: com.byazt.oze.pr.2
                @Override // com.byazt.gb.pr
                public int pr(String str, int i2, Deque<com.byazt.awu.pr> deque) {
                    return ucVar.pr(str, i2, deque, prVar);
                }
            };
        }
        pr = prVar;
    }

    private pr(String str, com.byazt.gb.pr prVar) {
        this.hw = prVar;
        this.c = str;
        try {
            pr();
        } catch (Exception e) {
            throw new com.byazt.zih.hw(str, e);
        }
    }

    public static pr pr(String str) {
        return new pr(str, pr);
    }

    private void pr() {
        int length = this.c.length();
        int i = 0;
        while (i < length) {
            int iPr = this.hw.pr(this.c, i, this.x);
            if (iPr == i) {
                throw new IllegalArgumentException("Unrecognized expression, unrecognized characters encountered during parsing:" + this.c.substring(0, i));
            }
            i = iPr;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            com.byazt.awu.pr prVarPollFirst = this.x.pollFirst();
            if (prVarPollFirst != null) {
                arrayList.add(0, prVarPollFirst);
            } else {
                this.hn = com.byazt.ha.hw.pr(arrayList, this.c, i);
                this.x = null;
                return;
            }
        }
    }

    public <T> T pr(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("default_key", jSONObject);
        return (T) pr(map);
    }

    public <T> T pr(Map<String, JSONObject> map) {
        return (T) this.hn.pr(map);
    }
}
