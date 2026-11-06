package com.byazt.nv;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 734, 121})
public class x implements pr {
    public final ConcurrentHashMap<Integer, pr> pr = new ConcurrentHashMap<>();

    public void pr(pr prVar) {
        if (prVar != null) {
            this.pr.put(Integer.valueOf(prVar.hashCode()), prVar);
        }
    }

    public void hw() {
        if (!this.pr.isEmpty()) {
            this.pr.clear();
        }
    }

    @Override // com.byazt.nv.pr
    public void pr() {
        Iterator<Map.Entry<Integer, pr>> it = this.pr.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, pr> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new hw.pr().pr(next.getValue()).pr("onIdle").pr();
            }
        }
    }

    @Override // com.byazt.nv.pr
    public void pr(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, pr>> it = this.pr.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, pr> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new hw.pr().pr(next.getValue()).pr("onDownloadActive").pr(j).hw(j2).hw(str).hn(str2).pr();
            }
        }
    }

    @Override // com.byazt.nv.pr
    public void hw(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, pr>> it = this.pr.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, pr> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new hw.pr().pr(next.getValue()).pr("onDownloadPaused").pr(j).hw(j2).hw(str).hn(str2).pr();
            }
        }
    }

    @Override // com.byazt.nv.pr
    public void hn(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, pr>> it = this.pr.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, pr> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new hw.pr().pr(next.getValue()).pr("onDownloadFailed").pr(j).hw(j2).hw(str).hn(str2).pr();
            }
        }
    }

    @Override // com.byazt.nv.pr
    public void pr(String str, String str2) {
        Iterator<Map.Entry<Integer, pr>> it = this.pr.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, pr> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.getValue().pr(str, str2);
                new hw.pr().pr(next.getValue()).pr("onInstalled").hw(str).hn(str2).pr();
            }
        }
    }

    @Override // com.byazt.nv.pr
    public void pr(long j, String str, String str2) {
        Iterator<Map.Entry<Integer, pr>> it = this.pr.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, pr> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new hw.pr().pr(next.getValue()).pr("onDownloadFinished").pr(j).hw(str).hn(str2).pr();
            }
        }
    }
}
