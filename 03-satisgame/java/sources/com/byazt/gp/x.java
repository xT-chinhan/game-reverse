package com.byazt.gp;

import android.content.Context;
import android.system.ErrnoException;
import android.system.Os;
import android.text.TextUtils;
import com.anythink.core.common.f.a;
import com.byazt.vf.k;
import com.byazt.vy.hu;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 80, 21})
public final class x {
    public final s s;
    public static final long qg = TimeUnit.DAYS.toMillis(30);
    public static final Comparator<fs> n = new Comparator<fs>() { // from class: com.byazt.gp.x.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public int compare(fs fsVar, fs fsVar2) {
            return Long.compare(fsVar.s, fsVar2.s);
        }
    };

    interface l {
        Map<?, ?> n();

        void n(String str, String str2);

        boolean n(String str);

        String qg(String str, String str2);

        void qg();

        void qg(String str);
    }

    interface s {
        File n();

        boolean n(File file);

        boolean n(File file, File file2);

        byte[] n(byte[] bArr);

        l qg();
    }

    @com.byazt.cp.n(n = {0, 1, 80, 2263})
    static final class fs {
        public final long l;
        public final String n;
        public final String q;
        public final String qg;
        public final long s;
        public final File w;

        public fs(String str, String str2, long j, String str3, long j2, File file) {
            this.n = str;
            this.qg = str2;
            this.s = j;
            this.q = str3;
            this.l = j2;
            this.w = file;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 80, 1181})
    static final class qg {
        public final fs n;
        public final int qg;

        public qg(fs fsVar, int i) {
            this.n = fsVar;
            this.qg = i;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 80, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    static final class n {
        public final List<fs> n;
        public final List<qg> qg;

        public n(List<fs> list, List<qg> list2) {
            this.n = list;
            this.qg = list2;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 80, 1800})
    static final class w {
        public final String l;
        public final String n;
        public final long q;
        public final byte[] qg;
        public final String s;

        public w(String str, byte[] bArr, String str2, long j, String str3) {
            this.n = str;
            this.qg = bArr;
            this.s = str2;
            this.q = j;
            this.l = str3;
        }
    }

    public x() {
        this(new C0185x());
    }

    public x(s sVar) {
        this.s = sVar == null ? new C0185x() : sVar;
    }

    public w n(byte[] bArr, String str, String str2, long j) {
        if (bArr != null && bArr.length != 0 && j > 0) {
            try {
                byte[] bArrN = this.s.n(bArr);
                if (bArrN != null && bArrN.length != 0) {
                    String strQg = com.byazt.vy.w.qg(bArrN);
                    if (TextUtils.isEmpty(strQg)) {
                        return null;
                    }
                    if (str2 == null) {
                        str2 = "";
                    }
                    return new w(strQg, bArrN, str2, j, q(str));
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public boolean n(w wVar) {
        if (wVar != null && !TextUtils.isEmpty(wVar.n) && wVar.qg != null && wVar.qg.length != 0) {
            try {
                File fileN = this.s.n();
                if (fileN == null) {
                    return false;
                }
                File file = new File(fileN, wVar.n);
                if (file.exists() && !TextUtils.equals(wVar.n, com.byazt.vy.w.n(file))) {
                    return false;
                }
                if (!file.exists()) {
                    File file2 = new File(fileN, wVar.n + ".tmp");
                    if (!n(file2, wVar.qg) || !n(file2, file)) {
                        file2.delete();
                        if (!file.isFile() || !TextUtils.equals(wVar.n, com.byazt.vy.w.n(file))) {
                            return false;
                        }
                    }
                }
                return n(wVar.n, wVar.s, wVar.q, wVar.l, wVar.qg.length);
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private boolean n(File file, File file2) {
        return this.s.n(file, file2);
    }

    private boolean n(String str, String str2, long j, String str3, long j2) {
        l lVarQg = this.s.qg();
        if (lVarQg == null) {
            qg(str);
            return false;
        }
        try {
            if (lVarQg.n(str)) {
                return true;
            }
            JSONObject jSONObject = new JSONObject();
            if (j > 0 && j2 > 0) {
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject.put("request_id", str2);
                jSONObject.put("create_ts", j);
                jSONObject.put(a.C0017a.d, q(str3));
                jSONObject.put("file_size", j2);
                String strN = n(jSONObject);
                if (TextUtils.isEmpty(strN)) {
                    n(lVarQg, str);
                    return false;
                }
                lVarQg.n(str, strN);
                lVarQg.qg();
                boolean zEquals = TextUtils.equals(strN, lVarQg.qg(str, null));
                if (!zEquals) {
                    n(lVarQg, str);
                }
                return zEquals;
            }
            n(lVarQg, str);
            return false;
        } catch (Throwable unused) {
            n(lVarQg, str);
            return false;
        }
    }

    private boolean n(File file, byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                fileOutputStream.getFD().sync();
                n((Closeable) fileOutputStream);
                return true;
            } catch (Throwable unused) {
                n((Closeable) fileOutputStream);
                return false;
            }
        } catch (Throwable unused2) {
            fileOutputStream = null;
        }
    }

    private void n(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public boolean n() {
        return !n(false).isEmpty();
    }

    private List<fs> n(boolean z) {
        l lVarQg = this.s.qg();
        if (lVarQg == null) {
            return Collections.emptyList();
        }
        try {
            Map<?, ?> mapN = lVarQg.n();
            if (mapN == null) {
                return Collections.emptyList();
            }
            if (mapN.isEmpty()) {
                n((Set<String>) null);
                return qg(Collections.emptyList());
            }
            HashMap map = new HashMap();
            File fileN = this.s.n();
            if (fileN == null) {
                return Collections.emptyList();
            }
            for (Map.Entry<?, ?> entry : mapN.entrySet()) {
                String strValueOf = String.valueOf(entry.getKey());
                fs fsVarN = n(fileN, strValueOf, entry.getValue(), z);
                if (fsVarN != null) {
                    map.put(strValueOf, fsVarN);
                    n(lVarQg, strValueOf, entry.getValue());
                } else {
                    n(lVarQg, strValueOf, s(strValueOf) ? new File(fileN, strValueOf) : null);
                }
            }
            n(map.keySet());
            return qg(map.values());
        } catch (Throwable unused) {
            return Collections.emptyList();
        }
    }

    private List<fs> qg(Collection<fs> collection) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList, n);
        return arrayList;
    }

    public n n(long j, boolean z) {
        List<fs> listN = n(z);
        ArrayList arrayList = new ArrayList();
        long j2 = j - qg;
        for (int size = listN.size() - 1; size >= 0; size--) {
            fs fsVar = listN.get(size);
            if (fsVar.s < j2 && n(fsVar.n)) {
                listN.remove(size);
                arrayList.add(new qg(fsVar, AVMDLDataLoader.KeyIsLiveGetP2pState));
            }
        }
        if (listN.size() >= 100) {
            int i = 0;
            int i2 = 0;
            while (i < listN.size() && i2 < 30) {
                fs fsVar2 = listN.get(i);
                if (n(fsVar2.n)) {
                    listN.remove(i);
                    arrayList.add(new qg(fsVar2, AVMDLDataLoader.KeyIsLiveSetP2pAllow));
                    i2++;
                } else {
                    i++;
                }
            }
        }
        return new n(listN, arrayList);
    }

    public boolean delete(String str) {
        return n(str);
    }

    public boolean n(Collection<String> collection) {
        if (collection != null && !collection.isEmpty()) {
            try {
                File fileN = this.s.n();
                if (fileN == null) {
                    return false;
                }
                l lVarQg = this.s.qg();
                Iterator<String> it = collection.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    if (n(fileN, lVarQg, it.next())) {
                        z = true;
                    }
                }
                if (z && lVarQg != null) {
                    lVarQg.qg();
                }
                return z;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private boolean n(String str) {
        if (!s(str)) {
            return false;
        }
        try {
            File fileN = this.s.n();
            if (fileN == null) {
                return false;
            }
            l lVarQg = this.s.qg();
            if (!n(fileN, lVarQg, str)) {
                return false;
            }
            if (lVarQg == null) {
                return true;
            }
            lVarQg.qg();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean n(File file, l lVar, String str) {
        if (!s(str)) {
            return false;
        }
        File file2 = new File(file, str);
        if (file2.exists() && !file2.isFile()) {
            return false;
        }
        if (file2.exists() && !this.s.n(file2)) {
            return false;
        }
        if (lVar == null) {
            return true;
        }
        lVar.qg(str);
        return true;
    }

    private void qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File fileN = this.s.n();
        File file = fileN == null ? null : new File(fileN, str);
        if (file == null || !file.isFile()) {
            return;
        }
        this.s.n(file);
    }

    private void n(l lVar, String str) {
        qg(str);
        if (lVar == null || str == null) {
            return;
        }
        try {
            lVar.qg(str);
            lVar.qg();
        } catch (Throwable unused) {
        }
    }

    private fs n(File file, String str, Object obj, boolean z) {
        if (!s(str)) {
            return null;
        }
        File file2 = new File(file, str);
        try {
            JSONObject jSONObjectN = n(obj);
            if (jSONObjectN == null) {
                return null;
            }
            long jOptLong = jSONObjectN.optLong("create_ts", 0L);
            long length = file2.length();
            long jOptLong2 = jSONObjectN.optLong("file_size", length);
            if (!jSONObjectN.has("request_id") || !jSONObjectN.has("create_ts") || !file2.isFile() || jOptLong2 <= 0 || length != jOptLong2 || jOptLong <= 0) {
                return null;
            }
            if (!z || TextUtils.equals(str, com.byazt.vy.w.n(file2))) {
                return new fs(str, jSONObjectN.optString("request_id"), jOptLong, q(jSONObjectN.optString(a.C0017a.d, "jpeg")), jOptLong2, file2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObjectN = hu.n(jSONObject);
            if (jSONObjectN != null && jSONObjectN.optInt("cypher", 0) == 2 && !TextUtils.isEmpty(jSONObjectN.optString("message"))) {
                return jSONObjectN.toString();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private JSONObject n(Object obj) {
        if (obj == null) {
            return null;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strValueOf);
            if (!qg(jSONObject)) {
                return jSONObject;
            }
            String strN = hu.n(jSONObject.optString("message"));
            if (TextUtils.isEmpty(strN)) {
                return null;
            }
            return new JSONObject(strN);
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean qg(JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.optInt("cypher", 0) != 2 || TextUtils.isEmpty(jSONObject.optString("message"))) ? false : true;
    }

    private void n(l lVar, String str, Object obj) {
        if (lVar == null || TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(String.valueOf(obj));
            if (qg(jSONObject)) {
                return;
            }
            String strN = n(jSONObject);
            if (TextUtils.isEmpty(strN)) {
                return;
            }
            lVar.n(str, strN);
            lVar.qg();
        } catch (Throwable unused) {
        }
    }

    private void n(l lVar, String str, File file) {
        n(file);
        if (lVar == null || str == null) {
            return;
        }
        try {
            lVar.qg(str);
            lVar.qg();
        } catch (Throwable unused) {
        }
    }

    private void n(Set<String> set) {
        File[] fileArrListFiles;
        try {
            File fileN = this.s.n();
            if (fileN != null && (fileArrListFiles = fileN.listFiles()) != null && fileArrListFiles.length != 0) {
                if (set == null) {
                    set = new HashSet<>();
                }
                for (File file : fileArrListFiles) {
                    if (file != null && file.isFile()) {
                        String name = file.getName();
                        if (name.endsWith(".tmp") || !set.contains(name)) {
                            n(file);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private boolean s(String str) {
        if (str == null || str.length() != 32) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < '0' || cCharAt > '9') && (cCharAt < 'a' || cCharAt > 'f')) {
                return false;
            }
        }
        return true;
    }

    private String q(String str) {
        return TextUtils.isEmpty(str) ? "jpeg" : str;
    }

    private boolean n(File file) {
        if (file != null) {
            try {
                if (file.isFile()) {
                    return this.s.n(file);
                }
            } catch (Throwable unused) {
            }
        }
        return file == null || !file.exists();
    }

    /* JADX INFO: renamed from: com.byazt.gp.x$x, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 80, 1799})
    private static final class C0185x implements s {
        private C0185x() {
        }

        @Override // com.byazt.gp.x.s
        public File n() {
            try {
                Context context = com.byazt.qt.qg.getContext();
                if (context == null) {
                    return null;
                }
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                File fileQg = com.byazt.qyu.qg.qg(context);
                if (fileQg == null) {
                    return null;
                }
                File file = new File(fileQg, "g_a_m_i");
                if (file.isDirectory()) {
                    return file;
                }
                if (file.exists()) {
                    return null;
                }
                if (file.mkdirs() || file.isDirectory()) {
                    return file;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // com.byazt.gp.x.s
        public l qg() {
            try {
                com.byazt.gwu.s sVarN = com.byazt.lk.l.n(com.byazt.qt.n.d().oa(), "g_a_m_i");
                if (sVarN == null) {
                    return null;
                }
                return new q(sVarN);
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // com.byazt.gp.x.s
        public byte[] n(byte[] bArr) {
            k kVar = (k) com.byazt.qp.q.n("encrypt_service");
            if (kVar == null) {
                return null;
            }
            return kVar.n(bArr);
        }

        @Override // com.byazt.gp.x.s
        public boolean n(File file, File file2) {
            try {
                Os.rename(file.getAbsolutePath(), file2.getAbsolutePath());
                return true;
            } catch (ErrnoException unused) {
                return false;
            }
        }

        @Override // com.byazt.gp.x.s
        public boolean n(File file) {
            return file.delete();
        }
    }

    @com.byazt.cp.n(n = {0, 1, 80, 1797})
    private static final class q implements l {
        public final com.byazt.gwu.s n;

        private q(com.byazt.gwu.s sVar) {
            this.n = sVar;
        }

        @Override // com.byazt.gp.x.l
        public Map<?, ?> n() {
            return this.n.getAll();
        }

        @Override // com.byazt.gp.x.l
        public boolean n(String str) {
            return this.n.contains(str);
        }

        @Override // com.byazt.gp.x.l
        public void n(String str, String str2) {
            this.n.n(str, str2);
        }

        @Override // com.byazt.gp.x.l
        public void qg() {
            this.n.s();
        }

        @Override // com.byazt.gp.x.l
        public String qg(String str, String str2) {
            return this.n.getString(str, str2);
        }

        @Override // com.byazt.gp.x.l
        public void qg(String str) {
            this.n.n(str);
        }
    }
}
