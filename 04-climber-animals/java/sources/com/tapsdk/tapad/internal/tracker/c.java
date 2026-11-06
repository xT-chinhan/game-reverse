package com.tapsdk.tapad.internal.tracker;

import com.tapsdk.tapad.internal.utils.s;
import com.tapsdk.tapad.model.entities.DynamicHeader;
import com.tapsdk.tapad.model.entities.InteractionInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    static e a;

    static class b {
        static c a = new c();

        b() {
        }
    }

    static {
        e eVar = new e("TapADTracker_Thread");
        a = eVar;
        eVar.start();
    }

    private c() {
    }

    public static c a() {
        return b.a;
    }

    private void a(String str, Map<String, String> map) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (map == null || map.size() == 0) {
            a.a(str);
        } else {
            a.a(str, map);
        }
    }

    private void a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public void a(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        a.a(str);
    }

    public void a(String str, Map<String, String> map, List<DynamicHeader> list) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (list == null || list.size() == 0) {
            a.a(str, map);
        } else {
            a.a(str, map, list);
        }
    }

    public void a(String str, Map<String, String> map, List<DynamicHeader> list, Map<String, String> map2) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (map2 == null || map2.size() == 0) {
            a.a(str, map, list);
        } else {
            a.a(str, map, list, map2);
        }
    }

    public void a(List<String> list, InteractionInfo interactionInfo, List<DynamicHeader> list2) {
        if (a(interactionInfo)) {
            List<String> listA = s.a(list, 3);
            if (list2 == null || list2.size() == 0) {
                a(listA);
            } else {
                a(listA, (Map<String, String>) null, list2);
            }
        }
    }

    public void a(List<String> list, Map<String, String> map) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            a(it.next(), map);
        }
    }

    public void a(List<String> list, Map<String, String> map, List<DynamicHeader> list2) {
        if (list2 == null || list2.size() == 0) {
            a(list, map);
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            a(it.next(), map, list2);
        }
    }

    public void a(List<String> list, Map<String, String> map, List<DynamicHeader> list2, Map<String, String> map2) {
        if (map2 == null || map2.size() == 0) {
            a(list, map, list2);
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            a(it.next(), map, list2, map2);
        }
    }

    public boolean a(InteractionInfo interactionInfo) {
        return interactionInfo != null;
    }
}
