package com.byazt.qu;

import android.text.TextUtils;
import com.byazt.ca.aj;
import com.byazt.ca.c;
import com.byazt.hcx.fw;
import com.byazt.hcx.m;
import com.byazt.sd.a;
import com.byazt.tf.hn;
import com.byazt.zp.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1011, 13})
public class hw {
    public Set<String> hn;
    public ReentrantLock hw;
    public Map<String, com.byazt.qu.pr> pr;

    @com.byazt.vzx.pr(pr = {0, 1, 1011, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private static final class pr {
        public static final hw pr = new hw();
    }

    public static hw pr() {
        return pr.pr;
    }

    private hw() {
        this.pr = new HashMap();
        this.hw = new ReentrantLock();
        this.hn = new HashSet();
        String strHw = com.byazt.sd.hw.pr().hw("sdk_brand_video_cahce", "");
        if (TextUtils.isEmpty(strHw)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(strHw);
            for (int i = 0; i < jSONArray.length(); i++) {
                hw(jSONArray.optJSONObject(i));
            }
        } catch (Throwable th) {
        }
    }

    private void hw(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.byazt.qu.pr prVar = new com.byazt.qu.pr(jSONObject);
            this.pr.put(prVar.hw(), prVar);
        }
    }

    public void pr(JSONObject jSONObject) {
        final JSONArray jSONArrayHn = hn(jSONObject);
        if (jSONArrayHn == null || jSONArrayHn.length() == 0) {
            return;
        }
        aj.pr().postDelayed(new Runnable() { // from class: com.byazt.qu.hw.1
            @Override // java.lang.Runnable
            public void run() {
                jSONArrayHn.length();
                hw.this.pr(jSONArrayHn);
            }
        }, 20000L);
    }

    private JSONArray hn(JSONObject jSONObject) {
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
    public void pr(JSONArray jSONArray) {
        try {
            this.hw.lock();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                hw(jSONArray.optJSONObject(i));
            }
            Map<String, com.byazt.qu.pr> mapX = x();
            int iHw = hw();
            hn();
            delete(mapX);
            this.hw.unlock();
            pr(iHw);
        } catch (Throwable th) {
            this.hw.unlock();
            throw th;
        }
    }

    private void pr(int i) {
        File[] fileArrListFiles = new File(w.pr()).listFiles();
        int iFh = a.hw().fh();
        if (fileArrListFiles == null || fileArrListFiles.length <= iFh - i) {
            return;
        }
        for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
            if (!this.pr.containsKey(pr(fileArrListFiles[i2])) && fileArrListFiles[i2].exists()) {
                fileArrListFiles[i2].delete();
            }
        }
    }

    private String pr(File file) {
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(".");
        if (iLastIndexOf != -1) {
            return name.substring(0, iLastIndexOf);
        }
        return name;
    }

    private void delete(Map<String, com.byazt.qu.pr> map) {
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            map.get(it.next()).hw(w.pr());
        }
    }

    private int hw() {
        Iterator<String> it = this.pr.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            com.byazt.qu.pr prVar = this.pr.get(it.next());
            if (prVar != null) {
                String strPr = w.pr();
                String strHw = prVar.hw();
                if (TextUtils.isEmpty(strHw)) {
                    strHw = c.hw(prVar.pr());
                }
                String strPr2 = prVar.pr();
                File file = new File(strPr, strHw);
                if (!file.exists() || file.length() <= 0) {
                    i++;
                    if (!this.hn.contains(strHw)) {
                        this.hn.add(strHw);
                        pr(strPr2, strPr, strHw);
                    }
                }
            }
        }
        return i;
    }

    private void pr(final String str, String str2, final String str3) {
        hn.pr(str, str2, str3).pr(new fw() { // from class: com.byazt.qu.hw.2
            @Override // com.byazt.hcx.fw
            public void pr(m mVar) {
                hw.this.pr(str3);
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str4, Throwable th) {
                hw.this.pr(str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str) {
        try {
            this.hw.lock();
            this.hn.remove(str);
        } finally {
            this.hw.unlock();
        }
    }

    private void hn() {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.pr.keySet().iterator();
        while (it.hasNext()) {
            com.byazt.qu.pr prVar = this.pr.get(it.next());
            if (prVar != null) {
                jSONArray.put(prVar.c());
            }
        }
        com.byazt.sd.hw.pr().pr("sdk_brand_video_cahce", jSONArray.toString());
    }

    private Map<String, com.byazt.qu.pr> x() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, com.byazt.qu.pr>> it = this.pr.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, com.byazt.qu.pr> next = it.next();
            if (next.getValue().x()) {
                map.put(next.getKey(), next.getValue());
                it.remove();
            } else {
                arrayList.add(next.getValue());
            }
        }
        int size = this.pr.size() - a.hw().fh();
        if (size > 0) {
            Collections.sort(arrayList, new Comparator<com.byazt.qu.pr>() { // from class: com.byazt.qu.hw.3
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
                public int compare(com.byazt.qu.pr prVar, com.byazt.qu.pr prVar2) {
                    long jHn = prVar2.hn() - prVar.hn();
                    if (jHn == 0) {
                        String strPr = w.pr();
                        jHn = prVar.pr(strPr) - prVar2.pr(strPr);
                    }
                    return (int) jHn;
                }
            });
            for (int i = 0; i < size; i++) {
                com.byazt.qu.pr prVar = (com.byazt.qu.pr) arrayList.get(i);
                this.pr.remove(prVar.hw());
                map.put(prVar.hw(), prVar);
            }
        }
        return map;
    }
}
