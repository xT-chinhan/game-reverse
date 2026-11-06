package com.byazt.sz;

import com.byazt.sm.fs;
import com.byazt.sm.l;
import com.byazt.sm.q;
import com.byazt.sm.qg;
import com.byazt.sm.rv;
import com.byazt.sm.s;
import com.byazt.sm.tj;
import com.byazt.sm.w;
import com.byazt.sm.x;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 110, 19})
public class n {
    public static final com.byazt.bm.n n;
    public String l;
    public Deque<com.byazt.uk.n> q = new LinkedList();
    public final com.byazt.bm.n qg;
    public com.byazt.uk.n s;

    static {
        int i = 8;
        w[] wVarArr = {new tj(), new q(), new rv(), new qg(), new l(), new com.byazt.sm.n(), new x(), new s(), new fs()};
        final com.byazt.bm.n nVar = new com.byazt.bm.n() { // from class: com.byazt.sz.n.1
            @Override // com.byazt.bm.n
            public int n(String str, int i2, Deque<com.byazt.uk.n> deque) {
                return i2;
            }
        };
        while (i >= 0) {
            final w wVar = wVarArr[i];
            i--;
            nVar = new com.byazt.bm.n() { // from class: com.byazt.sz.n.2
                @Override // com.byazt.bm.n
                public int n(String str, int i2, Deque<com.byazt.uk.n> deque) {
                    return wVar.n(str, i2, deque, nVar);
                }
            };
        }
        n = nVar;
    }

    private n(String str, com.byazt.bm.n nVar) {
        this.qg = nVar;
        this.l = str;
        try {
            n();
        } catch (Exception e) {
            throw new com.byazt.sc.qg(str, e);
        }
    }

    public static n n(String str) {
        return new n(str, n);
    }

    private void n() {
        int length = this.l.length();
        int i = 0;
        while (i < length) {
            int iN = this.qg.n(this.l, i, this.q);
            if (iN == i) {
                throw new IllegalArgumentException("Unrecognized expression, unrecognized characters encountered during parsing:" + this.l.substring(0, i));
            }
            i = iN;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            com.byazt.uk.n nVarPollFirst = this.q.pollFirst();
            if (nVarPollFirst != null) {
                arrayList.add(0, nVarPollFirst);
            } else {
                this.s = com.byazt.dr.qg.n(arrayList, this.l, i);
                this.q = null;
                return;
            }
        }
    }

    public <T> T n(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("default_key", jSONObject);
        return (T) n(map);
    }

    public <T> T n(Map<String, JSONObject> map) {
        return (T) this.s.n(map);
    }
}
