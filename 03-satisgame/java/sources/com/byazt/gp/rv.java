package com.byazt.gp;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.l.b;
import com.byazt.qk.oa;
import com.byazt.vf.k;
import com.byazt.vy.hu;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 80, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public final class rv {
    public static final Charset n = Charset.forName("US-ASCII");

    @com.byazt.cp.n(n = {0, 1, 80, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME})
    static final class q {
        public final Set<String> n = new HashSet();
        public final Map<String, Integer> qg = new HashMap();
        public String s = "";
    }

    interface qg {
        void n(Set<String> set, Set<String> set2, Map<String, Integer> map);
    }

    private boolean n(int i) {
        return i >= 4000 && i <= 4999;
    }

    public void n(com.byazt.ng.qg.n nVar, List<x.fs> list, qg qgVar) {
        if (nVar != null) {
            try {
                if (!TextUtils.isEmpty(nVar.n)) {
                    n nVarN = n(list, nVar.qg);
                    if (nVarN != null && nVarN.n != null) {
                        n(nVar.n, nVarN.n, nVarN.qg, qgVar);
                        return;
                    }
                    n(qgVar, Collections.emptySet(), nVarN == null ? Collections.emptySet() : nVarN.qg, Collections.emptyMap());
                    return;
                }
            } catch (Throwable unused) {
                n(qgVar, Collections.emptySet(), Collections.emptySet(), Collections.emptyMap());
                return;
            }
        }
        n(qgVar, Collections.emptySet(), Collections.emptySet(), Collections.emptyMap());
    }

    public n n(List<x.fs> list, int i) throws Throwable {
        HashSet hashSet = new HashSet();
        if (list == null || list.isEmpty() || i <= 0) {
            return new n(null, hashSet);
        }
        String string = UUID.randomUUID().toString();
        String str = "----adn-material-image-" + UUID.randomUUID().toString().replace("-", "");
        ArrayList arrayList = new ArrayList();
        long j = 0;
        for (x.fs fsVar : list) {
            if (fsVar != null) {
                if (n(fsVar)) {
                    n(hashSet, fsVar);
                } else {
                    long j2 = fsVar.l + j;
                    if (j2 > i) {
                        if (!arrayList.isEmpty()) {
                            break;
                        }
                        n(hashSet, fsVar);
                    } else {
                        arrayList.add(fsVar);
                        j = j2;
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return new n(null, hashSet);
        }
        return new n(new s(string, str, new ArrayList(arrayList), n(str, arrayList)), hashSet);
    }

    private boolean n(x.fs fsVar) {
        return fsVar.w == null || !fsVar.w.isFile() || fsVar.l <= 0 || fsVar.w.length() != fsVar.l;
    }

    private void n(Set<String> set, x.fs fsVar) {
        if (set == null || fsVar == null || TextUtils.isEmpty(fsVar.n)) {
            return;
        }
        set.add(fsVar.n);
    }

    private byte[] n(String str, List<x.fs> list) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Closeable closeable = null;
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                Iterator<x.fs> it = list.iterator();
                while (it.hasNext()) {
                    n(gZIPOutputStream, str, it.next());
                }
                n(gZIPOutputStream, str);
                gZIPOutputStream.finish();
                n(gZIPOutputStream);
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                th = th;
                closeable = gZIPOutputStream;
                n(closeable);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void n(OutputStream outputStream, String str, x.fs fsVar) throws Throwable {
        qg(outputStream, "--" + str + "\r\n");
        qg(outputStream, "Content-Disposition: form-data; name=\"files\"; filename=\"" + fsVar.n + "\"\r\n");
        qg(outputStream, "Content-Type: application/octet-stream\r\n");
        qg(outputStream, "\r\n");
        n(fsVar.w, outputStream);
        qg(outputStream, "\r\n");
    }

    private void n(OutputStream outputStream, String str) throws IOException {
        qg(outputStream, "--" + str + "--\r\n");
    }

    private void qg(OutputStream outputStream, String str) throws IOException {
        if (str == null) {
            str = "";
        }
        outputStream.write(str.getBytes(n));
    }

    private void n(File file, OutputStream outputStream) throws Throwable {
        Closeable closeable = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i != -1) {
                        outputStream.write(bArr, 0, i);
                    } else {
                        n(fileInputStream);
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                closeable = fileInputStream;
                n(closeable);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
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

    private com.byazt.qk.rv n(String str, s sVar) {
        String str2 = "multipart/form-data; boundary=" + sVar.qg;
        return com.byazt.phf.s.q(str).n(str2, sVar.q).n(b.g, str2).n("Content-Encoding", "gzip");
    }

    public q n(oa oaVar, Set<String> set) {
        q qVar = new q();
        if (oaVar == null) {
            n(qVar, "response body is not a JSON object");
            return qVar;
        }
        if (set != null && !set.isEmpty()) {
            String strN = n(oaVar, qVar);
            if (TextUtils.isEmpty(strN)) {
                return qVar;
            }
            try {
                JSONObject jSONObject = new JSONObject(strN);
                int iOptInt = jSONObject.optInt("error_code", 0);
                String strOptString = jSONObject.optString("status", "");
                n(jSONObject.optJSONArray("items"), set, qVar);
                n(strOptString, iOptInt, set, qVar);
                return qVar;
            } catch (JSONException unused) {
                n(qVar, "response body is not a JSON object");
            }
        }
        return qVar;
    }

    private void n(JSONArray jSONArray, Set<String> set, q qVar) {
        if (jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            n(jSONArray, i, set, qVar);
        }
    }

    private void n(JSONArray jSONArray, int i, Set<String> set, q qVar) {
        try {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String strOptString = jSONObject.optString("file_name", "");
            String strOptString2 = jSONObject.optString("status", "");
            int iOptInt = jSONObject.optInt("error_code", 0);
            if (set.contains(strOptString)) {
                if ("success".equals(strOptString2)) {
                    qVar.n.add(strOptString);
                    qVar.qg.remove(strOptString);
                } else {
                    if (qVar.n.contains(strOptString) || !n(iOptInt)) {
                        return;
                    }
                    qVar.qg.put(strOptString, Integer.valueOf(iOptInt));
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void n(String str, int i, Set<String> set, q qVar) {
        if ("success".equals(str) || !n(i)) {
            return;
        }
        for (String str2 : set) {
            if (!qVar.n.contains(str2) && !qVar.qg.containsKey(str2)) {
                qVar.qg.put(str2, Integer.valueOf(i));
            }
        }
    }

    private String n(oa oaVar, q qVar) {
        String strFs = oaVar.fs();
        if (hu.n(oaVar)) {
            try {
                String strN = hu.n(oaVar.q());
                if (n(strN)) {
                    return strN;
                }
            } catch (Throwable unused) {
            }
            n(qVar, "decrypted response body is not a JSON object");
            return strFs;
        }
        if (TextUtils.isEmpty(strFs)) {
            n(qVar, "response body is not a JSON object");
            return strFs;
        }
        try {
            JSONObject jSONObject = new JSONObject(strFs);
            if (jSONObject.optInt("cypher", -1) != 4) {
                n(qVar, "response cypher is not 4");
                return strFs;
            }
            String strOptString = jSONObject.optString("message", "");
            k kVarS = com.byazt.cl.s.s();
            String strQg = kVarS == null ? null : kVarS.qg(strOptString);
            if (n(strQg)) {
                return strQg;
            }
            n(qVar, "decrypted response body is not a JSON object");
            return strFs;
        } catch (JSONException unused2) {
            n(qVar, "response body is not a JSON object");
            return strFs;
        } catch (Throwable unused3) {
        }
    }

    private boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(q qVar, String str) {
        if (qVar == null || !TextUtils.isEmpty(qVar.s)) {
            return;
        }
        qVar.s = str;
    }

    private void n(String str, final s sVar, Set<String> set, final qg qgVar) {
        final Set<String> setN = n(set);
        try {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            n(str, sVar).n(new com.byazt.qk.x() { // from class: com.byazt.gp.rv.1
                @Override // com.byazt.qk.x
                public void n(oa oaVar) {
                    q qVar = new q();
                    try {
                        rv rvVar = rv.this;
                        qVar = rvVar.n(oaVar, rvVar.n(sVar));
                    } catch (Throwable unused) {
                        rv.this.n(qVar, "response body is not a JSON object");
                    }
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    if (!TextUtils.isEmpty(qVar.s)) {
                        com.byazt.gp.s.n(-101, qVar.s, jElapsedRealtime2);
                    }
                    rv.this.n(qgVar, qVar.n, (Set<String>) setN, qVar.qg);
                }

                @Override // com.byazt.qk.x
                public void n(int i, String str2, Throwable th) {
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    if (TextUtils.isEmpty(str2) && th != null) {
                        str2 = th.getMessage();
                    }
                    com.byazt.gp.s.n(i, str2, jElapsedRealtime2);
                    rv.this.n(qgVar, (Set<String>) Collections.emptySet(), (Set<String>) setN, (Map<String, Integer>) Collections.emptyMap());
                }
            });
        } catch (Throwable unused) {
            n(qgVar, Collections.emptySet(), setN, Collections.emptyMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set<String> n(s sVar) {
        HashSet hashSet = new HashSet();
        if (sVar != null && sVar.s != null) {
            for (x.fs fsVar : sVar.s) {
                if (fsVar != null && !TextUtils.isEmpty(fsVar.n)) {
                    hashSet.add(fsVar.n);
                }
            }
        }
        return hashSet;
    }

    private Set<String> n(Set<String> set) {
        return set == null ? new HashSet() : new HashSet(set);
    }

    private Map<String, Integer> n(Map<String, Integer> map) {
        return map == null ? new HashMap() : new HashMap(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(qg qgVar, Set<String> set, Set<String> set2, Map<String, Integer> map) {
        if (qgVar == null) {
            return;
        }
        try {
            qgVar.n(n(set), n(set2), n(map));
        } catch (Throwable unused) {
        }
    }

    @com.byazt.cp.n(n = {0, 1, 80, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPENED_TIME})
    static final class s {
        public final String n;
        public final byte[] q;
        public final String qg;
        public final List<x.fs> s;

        public s(String str, String str2, List<x.fs> list, byte[] bArr) {
            this.n = str;
            this.qg = str2;
            this.s = list;
            this.q = bArr;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 80, 160})
    static final class n {
        public final s n;
        public final Set<String> qg;

        public n(s sVar, Set<String> set) {
            this.n = sVar;
            this.qg = set;
        }
    }
}
