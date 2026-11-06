package com.bytedance.sdk.component.adexpress.ms.xr;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.utils.g;
import com.bytedance.sdk.component.utils.sl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ah {
    public abstract File ms();

    protected boolean ms(Map<String, com.bytedance.sdk.component.adexpress.ms.ah.ms> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.adexpress.ms.ah.ms msVar = map.get(it.next());
            if (msVar != null && !ms(msVar.getResources())) {
                return false;
            }
        }
        return true;
    }

    protected boolean ms(List<com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms> list) {
        if (list == null || list.size() <= 0 || ms() == null) {
            return false;
        }
        for (com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms c0231ms : list) {
            String strXr = com.bytedance.sdk.component.utils.ka.xr(c0231ms.ms());
            if (TextUtils.isEmpty(strXr)) {
                return false;
            }
            File file = new File(ms(), strXr);
            String strMs = com.bytedance.sdk.component.utils.ka.ms(file);
            if (!file.exists() || !file.isFile() || c0231ms.xr() == null || !c0231ms.xr().equals(strMs)) {
                return false;
            }
        }
        return true;
    }

    protected boolean ms(com.bytedance.sdk.component.adexpress.ms.ah.ms.xr xrVar) {
        if (xrVar == null || ms() == null) {
            return false;
        }
        List<Pair<String, String>> listXr = xrVar.xr();
        if (listXr == null || listXr.size() <= 0) {
            return true;
        }
        Iterator<Pair<String, String>> it = listXr.iterator();
        while (it.hasNext()) {
            File file = new File(ms(), (String) it.next().first);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
        }
        return true;
    }

    public List<com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms> ms(com.bytedance.sdk.component.adexpress.ms.ah.ms msVar, com.bytedance.sdk.component.adexpress.ms.ah.ms msVar2) {
        Map<String, com.bytedance.sdk.component.adexpress.ms.ah.ms> mapMs = msVar.ms();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (mapMs.size() == 0) {
            if (msVar2 != null && msVar2.ms().size() != 0) {
                Map<String, com.bytedance.sdk.component.adexpress.ms.ah.ms> mapMs2 = msVar2.ms();
                Iterator<String> it = mapMs2.keySet().iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.adexpress.ms.ah.ms msVar3 = mapMs2.get(it.next());
                    if (msVar3 != null) {
                        arrayList.addAll(msVar3.getResources());
                    }
                }
            }
        } else if (msVar2 == null || msVar2.ms().size() == 0) {
            if (mapMs.size() != 0) {
                Iterator<String> it2 = mapMs.keySet().iterator();
                while (it2.hasNext()) {
                    com.bytedance.sdk.component.adexpress.ms.ah.ms msVar4 = mapMs.get(it2.next());
                    if (msVar4 != null) {
                        arrayList2.addAll(msVar4.getResources());
                    }
                }
            }
        } else {
            Map<String, com.bytedance.sdk.component.adexpress.ms.ah.ms> mapMs3 = msVar2.ms();
            for (String str : mapMs.keySet()) {
                com.bytedance.sdk.component.adexpress.ms.ah.ms msVar5 = mapMs.get(str);
                com.bytedance.sdk.component.adexpress.ms.ah.ms msVar6 = mapMs3.get(str);
                if (msVar6 == null && msVar5 != null) {
                    arrayList2.addAll(msVar5.getResources());
                } else if (msVar5 == null && msVar6 != null) {
                    arrayList.addAll(msVar6.getResources());
                } else if (msVar5 != null) {
                    for (com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms c0231ms : msVar5.getResources()) {
                        if (c0231ms != null && !msVar6.getResources().contains(c0231ms) && c0231ms.xr() != null && c0231ms.ms() != null) {
                            arrayList2.add(c0231ms);
                        }
                    }
                    for (com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms c0231ms2 : msVar6.getResources()) {
                        if (c0231ms2 != null && !msVar5.getResources().contains(c0231ms2)) {
                            arrayList.add(c0231ms2);
                        }
                    }
                }
            }
        }
        if (ms(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    private boolean ms(List<com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms> list, List<com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms> list2) {
        for (com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms c0231ms : list) {
            String strMs = c0231ms.ms();
            String strXr = com.bytedance.sdk.component.utils.ka.xr(strMs);
            File file = new File(ms(), strXr);
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
            com.bytedance.sdk.component.ny.xr.xr xrVarD = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().d();
            xrVarD.ms(strMs);
            xrVarD.ms(ms().getAbsolutePath(), strXr);
            com.bytedance.sdk.component.ny.xr xrVarMs = xrVarD.ms();
            list2.add(c0231ms);
            if (xrVarMs == null || !xrVarMs.x() || xrVarMs.ab() == null || !xrVarMs.ab().exists()) {
                ah(list2);
                return false;
            }
        }
        return true;
    }

    public List<com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms> xr(com.bytedance.sdk.component.adexpress.ms.ah.ms msVar, com.bytedance.sdk.component.adexpress.ms.ah.ms msVar2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (msVar2 == null || msVar2.getResources().isEmpty()) {
            arrayList2.addAll(msVar.getResources());
        } else if (msVar.getResources().isEmpty()) {
            arrayList.addAll(msVar2.getResources());
        } else {
            for (com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms c0231ms : msVar.getResources()) {
                if (!msVar2.getResources().contains(c0231ms) && c0231ms != null && c0231ms.ms() != null && c0231ms.xr() != null) {
                    arrayList2.add(c0231ms);
                }
            }
            for (com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms c0231ms2 : msVar2.getResources()) {
                if (!msVar.getResources().contains(c0231ms2)) {
                    arrayList.add(c0231ms2);
                }
            }
        }
        if (ms(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    public void xr(List<com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(ms(), com.bytedance.sdk.component.utils.ka.xr(it.next().ms()));
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

    public boolean ms(String str) {
        File file = new File(ms().getAbsoluteFile(), com.bytedance.sdk.component.utils.ka.xr(str) + ".zip");
        com.bytedance.sdk.component.ny.xr.xr xrVarD = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().d();
        xrVarD.ms(str);
        xrVarD.ms(file.getParent(), file.getName());
        com.bytedance.sdk.component.ny.xr xrVarMs = xrVarD.ms();
        if (xrVarMs.x() && xrVarMs.ab() != null && xrVarMs.ab().exists()) {
            File fileAb = xrVarMs.ab();
            try {
                g.ms(fileAb.getAbsolutePath(), file.getParent());
                if (!fileAb.exists()) {
                    return true;
                }
                fileAb.delete();
                return true;
            } catch (Exception e) {
                sl.ms(e);
            }
        }
        return false;
    }

    public void ms(int i) {
        if (com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().d() != null) {
            com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().d().ms(i);
        }
    }

    public void ah(List<com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(ms(), com.bytedance.sdk.component.utils.ka.xr(it.next().ms()));
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

    public static void ms(File file, com.bytedance.sdk.component.adexpress.ms.ah.ms msVar, String str) {
        if (msVar == null) {
            return;
        }
        String strX = msVar.x();
        if (TextUtils.isEmpty(strX)) {
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
                fileOutputStream2.write(strX.getBytes("utf-8"));
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
                    sl.ah("PlayComponentEngineCacheManager", "version save error3", th);
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

    public static boolean ah(com.bytedance.sdk.component.adexpress.ms.ah.ms msVar, com.bytedance.sdk.component.adexpress.ms.ah.ms msVar2) {
        if (msVar != null) {
            try {
                if (!TextUtils.isEmpty(msVar.ah())) {
                    if (msVar2 == null) {
                        return false;
                    }
                    if (ms(msVar.ah(), msVar2.ah())) {
                        return true;
                    }
                    Map<String, com.bytedance.sdk.component.adexpress.ms.ah.ms> mapMs = msVar.ms();
                    Map<String, com.bytedance.sdk.component.adexpress.ms.ah.ms> mapMs2 = msVar2.ms();
                    if (mapMs.isEmpty()) {
                        return !mapMs2.isEmpty();
                    }
                    if (mapMs2.isEmpty()) {
                        return false;
                    }
                    return ms(mapMs, mapMs2);
                }
            } catch (Throwable th) {
                th.getMessage();
                return false;
            }
        }
        return true;
    }

    private static boolean ms(Map<String, com.bytedance.sdk.component.adexpress.ms.ah.ms> map, Map<String, com.bytedance.sdk.component.adexpress.ms.ah.ms> map2) {
        if (map.size() != map2.size()) {
            return true;
        }
        for (String str : map2.keySet()) {
            com.bytedance.sdk.component.adexpress.ms.ah.ms msVar = map.get(str);
            if (msVar == null) {
                return true;
            }
            com.bytedance.sdk.component.adexpress.ms.ah.ms msVar2 = map2.get(str);
            if (msVar2 == null) {
                return false;
            }
            if (ms(msVar.ah(), msVar2.ah())) {
                return true;
            }
        }
        return false;
    }

    private static boolean ms(String str, String str2) {
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
    public static boolean ms(com.bytedance.sdk.component.adexpress.ms.ah.ms msVar, String str) {
        if (msVar == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(msVar.ah())) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return ms(msVar.ah(), str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void xr(File file, com.bytedance.sdk.component.adexpress.ms.ah.ms msVar, String str) {
        if (msVar == null || file == null) {
            return;
        }
        try {
            new File(file, str).delete();
        } catch (Throwable unused) {
        }
        if (msVar.getResources() != null) {
            Iterator<com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms> it = msVar.getResources().iterator();
            while (it.hasNext()) {
                try {
                    new File(file, com.bytedance.sdk.component.utils.ka.xr(it.next().ms())).delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }
}
