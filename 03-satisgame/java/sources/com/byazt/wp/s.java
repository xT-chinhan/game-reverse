package com.byazt.wp;

import android.text.TextUtils;
import com.byazt.ph.q;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX, 8})
public final class s {
    public static final s n = new s();
    public final LinkedHashMap<String, n> qg = new LinkedHashMap<>();

    private s() {
    }

    public static s n() {
        return n;
    }

    public void n(final com.byazt.gd.n nVar) {
        if (nVar == null || TextUtils.isEmpty(nVar.n()) || !q.fs()) {
            return;
        }
        com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.wp.s.1
            @Override // java.lang.Runnable
            public void run() {
                s.this.qg(nVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void qg(com.byazt.gd.n nVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        n(jCurrentTimeMillis);
        this.qg.remove(nVar.n());
        this.qg.put(nVar.n(), new n(nVar, jCurrentTimeMillis));
    }

    public void n(final String str) {
        if (TextUtils.isEmpty(str) || !q.fs()) {
            return;
        }
        com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.wp.s.2
            @Override // java.lang.Runnable
            public void run() {
                s.this.qg(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void qg(String str) {
        n nVar = this.qg.get(str);
        if (nVar != null) {
            nVar.n(System.currentTimeMillis());
        }
        n(System.currentTimeMillis());
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0018 A[Catch: all -> 0x002f, TryCatch #0 {, blocks: (B:6:0x0008, B:7:0x000c, B:11:0x001c, B:10:0x0018), top: B:17:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x0015  */
    public synchronized qg n(com.byazt.gd.n nVar, long j) {
        String strN;
        List<n> listN;
        if (j <= 0) {
            j = System.currentTimeMillis();
            n(System.currentTimeMillis());
            if (nVar == null) {
                strN = "";
            } else {
                strN = nVar.n();
            }
            listN = n(j, strN);
        } else {
            n(System.currentTimeMillis());
            if (nVar == null) {
                strN = "";
            } else {
                strN = nVar.n();
            }
            listN = n(j, strN);
        }
        throw th;
        return new qg(listN.size(), j, n(listN));
    }

    private List<n> n(long j, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, n>> it = this.qg.entrySet().iterator();
        while (it.hasNext()) {
            n value = it.next().getValue();
            if (value.n(j, !TextUtils.isEmpty(str) && str.equals(value.n().n()))) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    private List<n> n(List<n> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size() && arrayList.size() < com.byazt.md.q.n().q(); i++) {
            arrayList.add(list.get(i));
        }
        return arrayList;
    }

    private void n(long j) {
        Iterator<Map.Entry<String, n>> it = this.qg.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().qg(j)) {
                it.remove();
            }
        }
    }
}
