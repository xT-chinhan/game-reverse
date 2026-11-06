package com.byazt.ce;

import android.text.TextUtils;
import android.util.Pair;
import com.byazt.ca.gz;
import com.byazt.ca.ho;
import com.byazt.hcx.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, 20})
public abstract class hn {
    public abstract File pr();

    public boolean pr(Map<String, com.byazt.hfm.pr> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            com.byazt.hfm.pr prVar = map.get(it.next());
            if (prVar != null && !pr(prVar.getResources())) {
                return false;
            }
        }
        return true;
    }

    public boolean pr(List<com.byazt.hfm.pr.C0084pr> list) {
        if (list == null || list.size() <= 0 || pr() == null) {
            return false;
        }
        for (com.byazt.hfm.pr.C0084pr c0084pr : list) {
            String strHw = com.byazt.ca.c.hw(c0084pr.pr());
            if (TextUtils.isEmpty(strHw)) {
                return false;
            }
            File file = new File(pr(), strHw);
            String strPr = com.byazt.ca.c.pr(file);
            if (!file.exists() || !file.isFile() || c0084pr.hw() == null || !c0084pr.hw().equals(strPr)) {
                return false;
            }
        }
        return true;
    }

    public boolean pr(com.byazt.hfm.pr.hw hwVar) {
        if (hwVar == null || pr() == null) {
            return false;
        }
        List<Pair<String, String>> listHw = hwVar.hw();
        if (listHw != null && listHw.size() > 0) {
            Iterator<Pair<String, String>> it = listHw.iterator();
            while (it.hasNext()) {
                File file = new File(pr(), (String) it.next().first);
                if (!file.exists() || !file.isFile()) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public List<com.byazt.hfm.pr.C0084pr> pr(com.byazt.hfm.pr prVar, com.byazt.hfm.pr prVar2) {
        Map<String, com.byazt.hfm.pr> mapPr = prVar.pr();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (mapPr.size() == 0) {
            if (prVar2 != null && prVar2.pr().size() != 0) {
                Map<String, com.byazt.hfm.pr> mapPr2 = prVar2.pr();
                Iterator<String> it = mapPr2.keySet().iterator();
                while (it.hasNext()) {
                    com.byazt.hfm.pr prVar3 = mapPr2.get(it.next());
                    if (prVar3 != null) {
                        arrayList.addAll(prVar3.getResources());
                    }
                }
            }
        } else if (prVar2 == null || prVar2.pr().size() == 0) {
            if (mapPr.size() != 0) {
                Iterator<String> it2 = mapPr.keySet().iterator();
                while (it2.hasNext()) {
                    com.byazt.hfm.pr prVar4 = mapPr.get(it2.next());
                    if (prVar4 != null) {
                        arrayList2.addAll(prVar4.getResources());
                    }
                }
            }
        } else {
            Map<String, com.byazt.hfm.pr> mapPr3 = prVar2.pr();
            for (String str : mapPr.keySet()) {
                com.byazt.hfm.pr prVar5 = mapPr.get(str);
                com.byazt.hfm.pr prVar6 = mapPr3.get(str);
                if (prVar6 == null && prVar5 != null) {
                    arrayList2.addAll(prVar5.getResources());
                } else if (prVar5 == null && prVar6 != null) {
                    arrayList.addAll(prVar6.getResources());
                } else if (prVar5 != null) {
                    for (com.byazt.hfm.pr.C0084pr c0084pr : prVar5.getResources()) {
                        if (c0084pr != null && !prVar6.getResources().contains(c0084pr) && c0084pr.hw() != null && c0084pr.pr() != null) {
                            arrayList2.add(c0084pr);
                        }
                    }
                    for (com.byazt.hfm.pr.C0084pr c0084pr2 : prVar6.getResources()) {
                        if (c0084pr2 != null && !prVar5.getResources().contains(c0084pr2)) {
                            arrayList.add(c0084pr2);
                        }
                    }
                }
            }
        }
        if (!pr(arrayList2, arrayList3)) {
            return null;
        }
        return arrayList;
    }

    private boolean pr(List<com.byazt.hfm.pr.C0084pr> list, List<com.byazt.hfm.pr.C0084pr> list2) {
        for (com.byazt.hfm.pr.C0084pr c0084pr : list) {
            String strPr = c0084pr.pr();
            String strHw = com.byazt.ca.c.hw(strPr);
            File file = new File(pr(), strHw);
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable th) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable th2) {
                }
            }
            m mVarPr = com.byazt.tf.hn.pr(strPr, pr().getAbsolutePath(), strHw).pr();
            list2.add(c0084pr);
            if (mVarPr == null || !mVarPr.fw() || mVarPr.vk() == null || !mVarPr.vk().exists()) {
                hn(list2);
                return false;
            }
        }
        return true;
    }

    public List<com.byazt.hfm.pr.C0084pr> hw(com.byazt.hfm.pr prVar, com.byazt.hfm.pr prVar2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (prVar2 == null || prVar2.getResources().isEmpty()) {
            arrayList2.addAll(prVar.getResources());
        } else if (prVar.getResources().isEmpty()) {
            arrayList.addAll(prVar2.getResources());
        } else {
            for (com.byazt.hfm.pr.C0084pr c0084pr : prVar.getResources()) {
                if (!prVar2.getResources().contains(c0084pr) && c0084pr != null && c0084pr.pr() != null && c0084pr.hw() != null) {
                    arrayList2.add(c0084pr);
                }
            }
            for (com.byazt.hfm.pr.C0084pr c0084pr2 : prVar2.getResources()) {
                if (!prVar.getResources().contains(c0084pr2)) {
                    arrayList.add(c0084pr2);
                }
            }
        }
        if (!pr(arrayList2, arrayList3)) {
            return null;
        }
        return arrayList;
    }

    public void hw(List<com.byazt.hfm.pr.C0084pr> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<com.byazt.hfm.pr.C0084pr> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(pr(), com.byazt.ca.c.hw(it.next().pr()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable th) {
                }
            }
            if (file2.exists()) {
                file2.delete();
            }
        }
    }

    public boolean pr(String str) {
        File file = new File(pr().getAbsoluteFile(), com.byazt.ca.c.hw(str) + ".zip");
        m mVarPr = com.byazt.tf.hn.pr(str, file.getParent(), file.getName()).pr();
        if (!mVarPr.fw() || mVarPr.vk() == null || !mVarPr.vk().exists()) {
            return false;
        }
        File fileVk = mVarPr.vk();
        try {
            gz.pr(fileVk.getAbsolutePath(), file.getParent());
            if (fileVk.exists()) {
                fileVk.delete();
                return true;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void pr(int i) {
        if (com.byazt.bg.pr.pr().x() != null) {
            com.byazt.bg.pr.pr().x().pr(i);
        }
    }

    public void hn(List<com.byazt.hfm.pr.C0084pr> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<com.byazt.hfm.pr.C0084pr> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(pr(), com.byazt.ca.c.hw(it.next().pr()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable th) {
                }
            }
            if (file2.exists()) {
                file2.delete();
            }
        }
    }

    public static void pr(File file, com.byazt.hfm.pr prVar, String str) {
        if (prVar == null) {
            return;
        }
        String strZo = prVar.zo();
        if (TextUtils.isEmpty(strZo)) {
            return;
        }
        File file2 = new File(file, str);
        File file3 = new File(file2 + ".tmp");
        if (file3.exists()) {
            file3.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                try {
                    fileOutputStream2.write(strZo.getBytes("utf-8"));
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file3.renameTo(file2);
                    fileOutputStream2.close();
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        ho.pr("PlayComponentEngineCacheManager", "version save error3", th);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th2) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (IOException e2) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean hn(com.byazt.hfm.pr prVar, com.byazt.hfm.pr prVar2) {
        if (prVar != null) {
            try {
                if (!TextUtils.isEmpty(prVar.hn())) {
                    if (prVar2 == null) {
                        return false;
                    }
                    if (pr(prVar.hn(), prVar2.hn())) {
                        return true;
                    }
                    Map<String, com.byazt.hfm.pr> mapPr = prVar.pr();
                    Map<String, com.byazt.hfm.pr> mapPr2 = prVar2.pr();
                    if (mapPr.isEmpty()) {
                        return !mapPr2.isEmpty();
                    }
                    if (mapPr2.isEmpty()) {
                        return false;
                    }
                    return pr(mapPr, mapPr2);
                }
            } catch (Throwable th) {
                th.getMessage();
                return false;
            }
        }
        return true;
    }

    private static boolean pr(Map<String, com.byazt.hfm.pr> map, Map<String, com.byazt.hfm.pr> map2) {
        if (map.size() != map2.size()) {
            return true;
        }
        for (String str : map2.keySet()) {
            com.byazt.hfm.pr prVar = map.get(str);
            if (prVar == null) {
                return true;
            }
            com.byazt.hfm.pr prVar2 = map2.get(str);
            if (prVar2 == null) {
                return false;
            }
            if (pr(prVar.hn(), prVar2.hn())) {
                return true;
            }
        }
        return false;
    }

    private static boolean pr(String str, String str2) {
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
                    if (strArrSplit.length <= strArrSplit2.length) {
                        return false;
                    }
                    return true;
                }
            } else {
                if (length <= 0) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public static boolean pr(com.byazt.hfm.pr prVar, String str) {
        if (prVar == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(prVar.hn())) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return pr(prVar.hn(), str);
        } catch (Throwable th) {
            return false;
        }
    }

    public static void hw(File file, com.byazt.hfm.pr prVar, String str) {
        if (prVar == null || file == null) {
            return;
        }
        try {
            new File(file, str).delete();
        } catch (Throwable th) {
        }
        if (prVar.getResources() != null) {
            Iterator<com.byazt.hfm.pr.C0084pr> it = prVar.getResources().iterator();
            while (it.hasNext()) {
                new File(file, com.byazt.ca.c.hw(it.next().pr())).delete();
            }
        }
    }
}
