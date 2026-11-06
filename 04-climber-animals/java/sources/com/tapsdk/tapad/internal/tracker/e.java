package com.tapsdk.tapad.internal.tracker;

import android.os.HandlerThread;
import com.tapsdk.tapad.model.entities.DynamicHeader;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class e extends HandlerThread {
    private d a;

    public e(String str) {
        super(str, 5);
    }

    void a(String str) {
        a(str, null);
    }

    void a(String str, Map<String, String> map) {
        d dVar = this.a;
        if (dVar == null) {
            return;
        }
        dVar.a(str, map);
    }

    void a(String str, Map<String, String> map, List<DynamicHeader> list) {
        if (this.a == null) {
            return;
        }
        if (list == null || list.size() == 0) {
            a(str, map);
        }
        this.a.a(str, map, list);
    }

    void a(String str, Map<String, String> map, List<DynamicHeader> list, Map<String, String> map2) {
        if (this.a == null) {
            return;
        }
        if (map2 == null || map2.size() == 0) {
            a(str, map, list);
        }
        this.a.a(str, map, list, map2);
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        this.a = new d(getLooper());
    }
}
