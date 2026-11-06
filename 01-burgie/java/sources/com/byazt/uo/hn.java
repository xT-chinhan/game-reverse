package com.byazt.uo;

import android.text.TextUtils;
import com.byazt.is.vk;
import com.byazt.kf.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 217, 20})
public final class hn {
    public static final hn pr = new hn();
    public final LinkedHashMap<String, pr> hw = new LinkedHashMap<>();

    private hn() {
    }

    public static hn pr() {
        return pr;
    }

    public void pr(final com.byazt.tj.pr prVar) {
        if (prVar == null || TextUtils.isEmpty(prVar.pr()) || !vk.zo()) {
            return;
        }
        com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.uo.hn.1
            @Override // java.lang.Runnable
            public void run() {
                hn.this.hw(prVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void hw(com.byazt.tj.pr prVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        pr(jCurrentTimeMillis);
        this.hw.remove(prVar.pr());
        this.hw.put(prVar.pr(), new pr(prVar, jCurrentTimeMillis));
    }

    public void pr(final String str) {
        if (TextUtils.isEmpty(str) || !vk.zo()) {
            return;
        }
        com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.uo.hn.2
            @Override // java.lang.Runnable
            public void run() {
                hn.this.hw(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void hw(String str) {
        pr prVar = this.hw.get(str);
        if (prVar != null) {
            prVar.pr(System.currentTimeMillis());
        }
        pr(System.currentTimeMillis());
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0018 A[Catch: all -> 0x002f, TryCatch #0 {, blocks: (B:6:0x0008, B:7:0x000c, B:11:0x001c, B:10:0x0018), top: B:17:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x0015  */
    public synchronized hw pr(com.byazt.tj.pr prVar, long j) {
        String strPr;
        List<pr> listPr;
        if (j > 0) {
            pr(System.currentTimeMillis());
            if (prVar == null) {
                strPr = "";
            } else {
                strPr = prVar.pr();
            }
            listPr = pr(j, strPr);
        } else {
            j = System.currentTimeMillis();
            pr(System.currentTimeMillis());
            if (prVar == null) {
                strPr = "";
            } else {
                strPr = prVar.pr();
            }
            listPr = pr(j, strPr);
        }
        throw th;
        return new hw(listPr.size(), j, pr(listPr));
    }

    private List<pr> pr(long j, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, pr>> it = this.hw.entrySet().iterator();
        while (it.hasNext()) {
            pr value = it.next().getValue();
            if (value.pr(j, !TextUtils.isEmpty(str) && str.equals(value.pr().pr()))) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    private List<pr> pr(List<pr> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size() && arrayList.size() < x.pr().x(); i++) {
            arrayList.add(list.get(i));
        }
        return arrayList;
    }

    private void pr(long j) {
        Iterator<Map.Entry<String, pr>> it = this.hw.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().hw(j)) {
                it.remove();
            }
        }
    }
}
