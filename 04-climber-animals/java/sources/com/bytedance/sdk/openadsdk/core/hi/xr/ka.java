package com.bytedance.sdk.openadsdk.core.hi.xr;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, ms> f2651ms = new ConcurrentHashMap<>();

    public void ms(ms msVar) {
        if (msVar != null) {
            this.f2651ms.put(Integer.valueOf(msVar.hashCode()), msVar);
        }
    }

    public void xr() {
        if (this.f2651ms.isEmpty()) {
            return;
        }
        this.f2651ms.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
    public void ms() {
        Iterator<Map.Entry<Integer, ms>> it = this.f2651ms.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ms> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new xr.ms().ms(next.getValue()).ms("onIdle").ms();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
    public void ms(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, ms>> it = this.f2651ms.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ms> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new xr.ms().ms(next.getValue()).ms("onDownloadActive").ms(j).xr(j2).xr(str).ah(str2).ms();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
    public void xr(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, ms>> it = this.f2651ms.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ms> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new xr.ms().ms(next.getValue()).ms("onDownloadPaused").ms(j).xr(j2).xr(str).ah(str2).ms();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
    public void ah(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, ms>> it = this.f2651ms.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ms> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new xr.ms().ms(next.getValue()).ms("onDownloadFailed").ms(j).xr(j2).xr(str).ah(str2).ms();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
    public void ms(String str, String str2) {
        Iterator<Map.Entry<Integer, ms>> it = this.f2651ms.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ms> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.getValue().ms(str, str2);
                new xr.ms().ms(next.getValue()).ms("onInstalled").xr(str).ah(str2).ms();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
    public void ms(long j, String str, String str2) {
        Iterator<Map.Entry<Integer, ms>> it = this.f2651ms.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ms> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new xr.ms().ms(next.getValue()).ms("onDownloadFinished").ms(j).xr(str).ah(str2).ms();
            }
        }
    }

    public boolean ah() {
        return this.f2651ms.size() > 0;
    }
}
