package com.byazt.mzw;

import android.text.TextUtils;
import android.util.Pair;
import com.byazt.qk.oa;
import com.byazt.tk.bb;
import com.byazt.tk.k;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1346, 8})
public abstract class s {
    public abstract File n();

    public boolean n(Map<String, com.byazt.px.n> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            com.byazt.px.n nVar = map.get(it.next());
            if (nVar != null && !n(nVar.getResources())) {
                return false;
            }
        }
        return true;
    }

    public boolean n(List<com.byazt.px.n.C0308n> list) {
        if (list == null || list.size() <= 0 || n() == null) {
            return false;
        }
        for (com.byazt.px.n.C0308n c0308n : list) {
            String strQg = com.byazt.tk.l.qg(c0308n.n());
            if (TextUtils.isEmpty(strQg)) {
                return false;
            }
            File file = new File(n(), strQg);
            String strN = com.byazt.tk.l.n(file);
            if (!file.exists() || !file.isFile() || c0308n.qg() == null || !c0308n.qg().equals(strN)) {
                return false;
            }
        }
        return true;
    }

    public boolean n(com.byazt.px.n.qg qgVar) {
        if (qgVar == null || n() == null) {
            return false;
        }
        List<Pair<String, String>> listQg = qgVar.qg();
        if (listQg == null || listQg.size() <= 0) {
            return true;
        }
        Iterator<Pair<String, String>> it = listQg.iterator();
        while (it.hasNext()) {
            File file = new File(n(), (String) it.next().first);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
        }
        return true;
    }

    public List<com.byazt.px.n.C0308n> n(com.byazt.px.n nVar, com.byazt.px.n nVar2) {
        Map<String, com.byazt.px.n> mapN = nVar.n();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (mapN.size() == 0) {
            if (nVar2 != null && nVar2.n().size() != 0) {
                Map<String, com.byazt.px.n> mapN2 = nVar2.n();
                Iterator<String> it = mapN2.keySet().iterator();
                while (it.hasNext()) {
                    com.byazt.px.n nVar3 = mapN2.get(it.next());
                    if (nVar3 != null) {
                        arrayList.addAll(nVar3.getResources());
                    }
                }
            }
        } else if (nVar2 == null || nVar2.n().size() == 0) {
            if (mapN.size() != 0) {
                Iterator<String> it2 = mapN.keySet().iterator();
                while (it2.hasNext()) {
                    com.byazt.px.n nVar4 = mapN.get(it2.next());
                    if (nVar4 != null) {
                        arrayList2.addAll(nVar4.getResources());
                    }
                }
            }
        } else {
            Map<String, com.byazt.px.n> mapN3 = nVar2.n();
            for (String str : mapN.keySet()) {
                com.byazt.px.n nVar5 = mapN.get(str);
                com.byazt.px.n nVar6 = mapN3.get(str);
                if (nVar6 == null && nVar5 != null) {
                    arrayList2.addAll(nVar5.getResources());
                } else if (nVar5 == null && nVar6 != null) {
                    arrayList.addAll(nVar6.getResources());
                } else if (nVar5 != null) {
                    for (com.byazt.px.n.C0308n c0308n : nVar5.getResources()) {
                        if (c0308n != null && !nVar6.getResources().contains(c0308n) && c0308n.qg() != null && c0308n.n() != null) {
                            arrayList2.add(c0308n);
                        }
                    }
                    for (com.byazt.px.n.C0308n c0308n2 : nVar6.getResources()) {
                        if (c0308n2 != null && !nVar5.getResources().contains(c0308n2)) {
                            arrayList.add(c0308n2);
                        }
                    }
                }
            }
        }
        if (n(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    private boolean n(List<com.byazt.px.n.C0308n> list, List<com.byazt.px.n.C0308n> list2) {
        for (com.byazt.px.n.C0308n c0308n : list) {
            String strN = c0308n.n();
            String strQg = com.byazt.tk.l.qg(strN);
            File file = new File(n(), strQg);
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
            oa oaVarN = com.byazt.phf.s.n(strN, n().getAbsolutePath(), strQg).n();
            list2.add(c0308n);
            if (oaVarN == null || !oaVarN.x() || oaVarN.tj() == null || !oaVarN.tj().exists()) {
                s(list2);
                return false;
            }
        }
        return true;
    }

    public List<com.byazt.px.n.C0308n> qg(com.byazt.px.n nVar, com.byazt.px.n nVar2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (nVar2 == null || nVar2.getResources().isEmpty()) {
            arrayList2.addAll(nVar.getResources());
        } else if (nVar.getResources().isEmpty()) {
            arrayList.addAll(nVar2.getResources());
        } else {
            for (com.byazt.px.n.C0308n c0308n : nVar.getResources()) {
                if (!nVar2.getResources().contains(c0308n) && c0308n != null && c0308n.n() != null && c0308n.qg() != null) {
                    arrayList2.add(c0308n);
                }
            }
            for (com.byazt.px.n.C0308n c0308n2 : nVar2.getResources()) {
                if (!nVar.getResources().contains(c0308n2)) {
                    arrayList.add(c0308n2);
                }
            }
        }
        if (n(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    public void qg(List<com.byazt.px.n.C0308n> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<com.byazt.px.n.C0308n> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(n(), com.byazt.tk.l.qg(it.next().n()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public boolean n(String str) {
        File file = new File(n().getAbsoluteFile(), com.byazt.tk.l.qg(str) + ".zip");
        oa oaVarN = com.byazt.phf.s.n(str, file.getParent(), file.getName()).n();
        if (oaVarN.x() && oaVarN.tj() != null && oaVarN.tj().exists()) {
            File fileTj = oaVarN.tj();
            try {
                bb.n(fileTj.getAbsolutePath(), file.getParent());
                if (!fileTj.exists()) {
                    return true;
                }
                fileTj.delete();
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void n(int i) {
        if (com.byazt.gkj.n.n().q() != null) {
            com.byazt.gkj.n.n().q().n(i);
        }
    }

    public void s(List<com.byazt.px.n.C0308n> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<com.byazt.px.n.C0308n> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(n(), com.byazt.tk.l.qg(it.next().n()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public static void n(File file, com.byazt.px.n nVar, String str) {
        if (nVar == null) {
            return;
        }
        String strFs = nVar.fs();
        if (TextUtils.isEmpty(strFs)) {
            return;
        }
        File file2 = new File(file, str);
        File file3 = new File(file2 + ".tmp");
        if (file3.exists()) {
            file3.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
            try {
                fileOutputStream2.write(strFs.getBytes("utf-8"));
                if (file2.exists()) {
                    file2.delete();
                }
                file3.renameTo(file2);
                try {
                    fileOutputStream2.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    k.n("PlayComponentEngineCacheManager", "version save error3", th);
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean s(com.byazt.px.n nVar, com.byazt.px.n nVar2) {
        if (nVar != null) {
            try {
                if (!TextUtils.isEmpty(nVar.s())) {
                    if (nVar2 == null) {
                        return false;
                    }
                    if (n(nVar.s(), nVar2.s())) {
                        return true;
                    }
                    Map<String, com.byazt.px.n> mapN = nVar.n();
                    Map<String, com.byazt.px.n> mapN2 = nVar2.n();
                    if (mapN.isEmpty()) {
                        return !mapN2.isEmpty();
                    }
                    if (mapN2.isEmpty()) {
                        return false;
                    }
                    return n(mapN, mapN2);
                }
            } catch (Throwable th) {
                th.getMessage();
                return false;
            }
        }
        return true;
    }

    private static boolean n(Map<String, com.byazt.px.n> map, Map<String, com.byazt.px.n> map2) {
        if (map.size() != map2.size()) {
            return true;
        }
        for (String str : map2.keySet()) {
            com.byazt.px.n nVar = map.get(str);
            if (nVar == null) {
                return true;
            }
            com.byazt.px.n nVar2 = map2.get(str);
            if (nVar2 == null) {
                return false;
            }
            if (n(nVar.s(), nVar2.s())) {
                return true;
            }
        }
        return false;
    }

    private static boolean n(String str, String str2) {
        String[] strArrSplit = str2.split("\\.");
        String[] strArrSplit2 = str.split("\\.");
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        for (int i = 0; i < iMin; i++) {
            int length = strArrSplit[i].length() - strArrSplit2[i].length();
            if (length == 0) {
                int iCompareTo = strArrSplit[i].compareTo(strArrSplit2[i]);
                if (iCompareTo > 0) {
                    return true;
                }
                if (iCompareTo < 0) {
                    return false;
                }
                if (i == iMin - 1) {
                    return strArrSplit.length > strArrSplit2.length;
                }
            } else if (length > 0) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public static boolean n(com.byazt.px.n nVar, String str) {
        if (nVar == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(nVar.s())) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return n(nVar.s(), str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void qg(File file, com.byazt.px.n nVar, String str) {
        if (nVar == null || file == null) {
            return;
        }
        try {
            new File(file, str).delete();
        } catch (Throwable unused) {
        }
        if (nVar.getResources() != null) {
            Iterator<com.byazt.px.n.C0308n> it = nVar.getResources().iterator();
            while (it.hasNext()) {
                try {
                    new File(file, com.byazt.tk.l.qg(it.next().n())).delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }
}
