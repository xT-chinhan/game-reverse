package com.byazt.ce;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.byazt.ca.ho;
import com.byazt.js.vk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, 13})
public class hw {
    public static Object pr = new Object();

    public static void pr() {
        c.hw();
    }

    public static void hw() {
        try {
            zo.x();
            File fileFw = c.fw();
            if (fileFw != null && fileFw.exists()) {
                if (fileFw.getParentFile() != null) {
                    com.byazt.ca.fw.hn(fileFw.getParentFile());
                } else {
                    com.byazt.ca.fw.hn(fileFw);
                }
            }
        } catch (Throwable th) {
        }
    }

    public static String hn() {
        return uc.hn();
    }

    public static void pr(com.byazt.hfm.x xVar) {
        fw.pr().pr(xVar, xVar.uc);
    }

    public static Set<com.byazt.hfm.hw> pr(String str, boolean z) {
        final Set<com.byazt.hfm.hw> setHw = fw.pr().hw(str);
        if (setHw != null && setHw.size() > 0) {
            if (z) {
                com.byazt.js.c.pr(new com.byazt.xlm.fw("updateTmplTime") { // from class: com.byazt.ce.hw.1
                    @Override // java.lang.Runnable
                    public void run() {
                        hw.hw((Set<com.byazt.hfm.hw>) setHw);
                    }
                }, 5);
            } else {
                hw(setHw);
            }
        }
        return setHw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(Set<com.byazt.hfm.hw> set) {
        try {
            for (com.byazt.hfm.hw hwVar : set) {
                hwVar.pr(Long.valueOf(System.currentTimeMillis()));
                uc.pr().pr(hwVar, true);
            }
        } catch (Throwable th) {
        }
    }

    public static com.byazt.hfm.hw pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.byazt.hfm.hw hwVarPr = fw.pr().pr(str);
        if (hwVarPr != null) {
            hwVarPr.pr(Long.valueOf(System.currentTimeMillis()));
            pr(hwVarPr);
        }
        return hwVarPr;
    }

    private static void pr(final com.byazt.hfm.hw hwVar) {
        com.byazt.js.c.pr(new com.byazt.xlm.fw("updateTmplTime") { // from class: com.byazt.ce.hw.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (hw.pr) {
                    uc.pr().pr(hwVar, true);
                }
            }
        }, 10);
    }

    public static com.byazt.hfm.pr x() {
        return c.hw().c();
    }

    @Deprecated
    private static String uc() {
        com.byazt.hfm.pr prVarX = x();
        if (prVarX == null) {
            return null;
        }
        return prVarX.x();
    }

    public static String hw(String str) {
        com.byazt.hfm.pr prVar;
        com.byazt.hfm.pr prVarX = x();
        if (prVarX == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            Map<String, com.byazt.hfm.pr> mapPr = prVarX.pr();
            if (mapPr == null || mapPr.size() <= 0 || (prVar = mapPr.get(str)) == null) {
                return null;
            }
            return prVar.x();
        }
        return uc();
    }

    public static boolean c() {
        return c.hw().x();
    }

    public static pr pr(String str, vk.pr prVar, String str2, String str3) {
        File fileX;
        pr prVar2 = new pr();
        if (TextUtils.isEmpty(str3)) {
            fileX = null;
        } else {
            fileX = hw(str3, str);
            if (fileX != null) {
                prVar2.pr(1);
            }
        }
        if (fileX == null && (fileX = c(str)) != null) {
            prVar2.pr(3);
        }
        if (fileX == null && (fileX = x(str)) != null) {
            prVar2.pr(2);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (!pr(str, str3)) {
                prVar2.pr(4);
            }
        } else if (!hn(str)) {
            prVar2.pr(6);
        }
        prVar2.getType();
        if (fileX != null) {
            try {
                prVar2.pr(new WebResourceResponse(prVar.getType(), "utf-8", new FileInputStream(fileX)));
            } catch (Throwable th) {
                ho.pr("TTDynamic", "get html WebResourceResponse error", th);
            }
        }
        return prVar2;
    }

    private static boolean pr(String str, String str2) {
        com.byazt.hfm.pr prVarX;
        com.byazt.hfm.pr prVar;
        if (c() && (prVarX = x()) != null) {
            Map<String, com.byazt.hfm.pr> mapPr = prVarX.pr();
            if (mapPr.size() != 0 && (prVar = mapPr.get(str2)) != null) {
                for (com.byazt.hfm.pr.C0084pr c0084pr : prVar.getResources()) {
                    if (c0084pr != null && TextUtils.equals(str, c0084pr.pr())) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static boolean hn(String str) {
        com.byazt.hfm.pr prVarX;
        List<com.byazt.hfm.pr.C0084pr> resources;
        if (c() && (prVarX = x()) != null && (resources = prVarX.getResources()) != null) {
            for (com.byazt.hfm.pr.C0084pr c0084pr : resources) {
                if (c0084pr != null && TextUtils.equals(str, c0084pr.pr())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static File x(String str) {
        if (!c()) {
            return null;
        }
        for (com.byazt.hfm.pr.C0084pr c0084pr : x().getResources()) {
            if (c0084pr.pr() != null && c0084pr.pr().equals(str)) {
                File file = new File(c.fw(), com.byazt.ca.c.hw(c0084pr.pr()));
                String strPr = com.byazt.ca.c.pr(file);
                if (c0084pr.hw() == null || !c0084pr.hw().equals(strPr)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    private static File c(String str) {
        List<Pair<String, String>> listHw;
        com.byazt.hfm.pr.hw hwVarC = x().c();
        if (hwVarC == null || (listHw = hwVarC.hw()) == null || listHw.size() <= 0) {
            return null;
        }
        for (Pair<String, String> pair : listHw) {
            if (pair.second != null && ((String) pair.second).equals(str)) {
                return new File(c.fw(), (String) pair.first);
            }
        }
        return null;
    }

    private static File hw(String str, String str2) {
        com.byazt.hfm.pr prVar;
        com.byazt.hfm.pr prVarX = x();
        if (prVarX == null || !c()) {
            return null;
        }
        Map<String, com.byazt.hfm.pr> mapPr = prVarX.pr();
        if (mapPr.size() == 0 || (prVar = mapPr.get(str)) == null) {
            return null;
        }
        for (com.byazt.hfm.pr.C0084pr c0084pr : prVar.getResources()) {
            if (c0084pr.pr() != null && c0084pr.pr().equals(str2)) {
                File file = new File(c.fw(), com.byazt.ca.c.hw(c0084pr.pr()));
                String strPr = com.byazt.ca.c.pr(file);
                if (c0084pr.hw() == null || !c0084pr.hw().equals(strPr)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    public static boolean pr(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }

    public static boolean hw(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("xTemplate")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }

    public static boolean hn(JSONObject jSONObject) {
        Object objOpt;
        if (jSONObject == null) {
            return false;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject == null || (objOpt = jSONObjectOptJSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }
}
