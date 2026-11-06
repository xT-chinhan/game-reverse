package com.byazt.bv;

import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.byazt.phf.s;
import com.byazt.qk.oa;
import com.byazt.qk.x;
import com.byazt.tk.l;
import com.byazt.tk.rv;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1536, 26})
public class qg {
    public Map<String, com.byazt.bv.n> n;
    public ReentrantLock qg;
    public Set<String> s;

    @com.byazt.cp.n(n = {0, 1, 1536, 48})
    private static final class n {
        public static final qg n = new qg();
    }

    public static qg n() {
        return n.n;
    }

    private qg() {
        this.n = new HashMap();
        this.qg = new ReentrantLock();
        this.s = new HashSet();
        String strQg = com.byazt.ikv.n.n().qg("sdk_brand_video_cahce", "");
        if (TextUtils.isEmpty(strQg)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(strQg);
            for (int i = 0; i < jSONArray.length(); i++) {
                qg(jSONArray.optJSONObject(i));
            }
        } catch (Throwable unused) {
        }
    }

    private void qg(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.byazt.bv.n nVar = new com.byazt.bv.n(jSONObject);
            this.n.put(nVar.qg(), nVar);
        }
    }

    public void n(JSONObject jSONObject) {
        final JSONArray jSONArrayS = s(jSONObject);
        if (jSONArrayS == null || jSONArrayS.length() == 0) {
            return;
        }
        rv.n().postDelayed(new Runnable() { // from class: com.byazt.bv.qg.1
            @Override // java.lang.Runnable
            public void run() {
                jSONArrayS.length();
                qg.this.n(jSONArrayS);
            }
        }, 20000L);
    }

    private JSONArray s(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("creatives");
        JSONArray jSONArray = new JSONArray();
        if (jSONArrayOptJSONArray2 == null) {
            return jSONArray;
        }
        for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("precache_brand_video")) != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    jSONArray.put(jSONArrayOptJSONArray.opt(i2));
                }
            }
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONArray jSONArray) {
        try {
            this.qg.lock();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                qg(jSONArray.optJSONObject(i));
            }
            Map<String, com.byazt.bv.n> mapQ = q();
            int iQg = qg();
            s();
            delete(mapQ);
            this.qg.unlock();
            n(iQg);
        } catch (Throwable th) {
            this.qg.unlock();
            throw th;
        }
    }

    private void n(int i) {
        File[] fileArrListFiles = new File(com.byazt.ql.qg.n()).listFiles();
        int iVh = com.byazt.nf.rv.qg().vh();
        if (fileArrListFiles == null || fileArrListFiles.length <= iVh - i) {
            return;
        }
        for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
            if (!this.n.containsKey(n(fileArrListFiles[i2])) && fileArrListFiles[i2].exists()) {
                fileArrListFiles[i2].delete();
            }
        }
    }

    private String n(File file) {
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(i.E);
        return iLastIndexOf != -1 ? name.substring(0, iLastIndexOf) : name;
    }

    private void delete(Map<String, com.byazt.bv.n> map) {
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            map.get(it.next()).qg(com.byazt.ql.qg.n());
        }
    }

    private int qg() {
        Iterator<String> it = this.n.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            com.byazt.bv.n nVar = this.n.get(it.next());
            if (nVar != null) {
                String strN = com.byazt.ql.qg.n();
                String strQg = nVar.qg();
                if (TextUtils.isEmpty(strQg)) {
                    strQg = l.qg(nVar.n());
                }
                String strN2 = nVar.n();
                File file = new File(strN, strQg);
                if (!file.exists() || file.length() <= 0) {
                    i++;
                    if (!this.s.contains(strQg)) {
                        this.s.add(strQg);
                        n(strN2, strN, strQg);
                    }
                }
            }
        }
        return i;
    }

    private void n(final String str, String str2, final String str3) {
        s.n(str, str2, str3).n(new x() { // from class: com.byazt.bv.qg.2
            @Override // com.byazt.qk.x
            public void n(oa oaVar) {
                qg.this.n(str3);
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str4, Throwable th) {
                qg.this.n(str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        try {
            this.qg.lock();
            this.s.remove(str);
        } finally {
            this.qg.unlock();
        }
    }

    private void s() {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.n.keySet().iterator();
        while (it.hasNext()) {
            com.byazt.bv.n nVar = this.n.get(it.next());
            if (nVar != null) {
                jSONArray.put(nVar.l());
            }
        }
        com.byazt.ikv.n.n().n("sdk_brand_video_cahce", jSONArray.toString());
    }

    private Map<String, com.byazt.bv.n> q() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, com.byazt.bv.n>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, com.byazt.bv.n> next = it.next();
            if (next.getValue().q()) {
                map.put(next.getKey(), next.getValue());
                it.remove();
            } else {
                arrayList.add(next.getValue());
            }
        }
        int size = this.n.size() - com.byazt.nf.rv.qg().vh();
        if (size > 0) {
            Collections.sort(arrayList, new Comparator<com.byazt.bv.n>() { // from class: com.byazt.bv.qg.3
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                public int compare(com.byazt.bv.n nVar, com.byazt.bv.n nVar2) {
                    long jS = nVar2.s() - nVar.s();
                    if (jS == 0) {
                        String strN = com.byazt.ql.qg.n();
                        jS = nVar.n(strN) - nVar2.n(strN);
                    }
                    return (int) jS;
                }
            });
            for (int i = 0; i < size; i++) {
                com.byazt.bv.n nVar = (com.byazt.bv.n) arrayList.get(i);
                this.n.remove(nVar.qg());
                map.put(nVar.qg(), nVar);
            }
        }
        return map;
    }
}
