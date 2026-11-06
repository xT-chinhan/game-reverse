package com.byazt.mty;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.d.i;
import com.byazt.vf.um;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 669, 26})
public class qg implements com.byazt.uyg.n, com.byazt.uyg.qg {
    public com.byazt.eau.s n;
    public final com.byazt.eau.s qg;
    public final boolean s;

    public qg(com.byazt.eau.s sVar, boolean z) {
        this.n = sVar;
        this.qg = sVar;
        this.s = z;
    }

    private void n(String str) {
        int i;
        um umVar;
        com.byazt.eau.s sVarN;
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            try {
                i = Integer.parseInt(str);
            } catch (Throwable unused) {
                i = 0;
            }
        }
        if (i == 0) {
            this.n = null;
            return;
        }
        com.byazt.eau.s sVar = this.n;
        if ((sVar != null && sVar.n() == i) || (umVar = (um) com.byazt.qp.q.n("kv_store_factory")) == null || (sVarN = umVar.n(i)) == null) {
            return;
        }
        this.n = sVarN;
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00d2  */
    @Override // com.byazt.uyg.n
    public Map<String, Object> n(File file) {
        FileReader fileReader;
        byte b;
        if (file == null || !file.exists()) {
            return null;
        }
        if (!file.canRead()) {
            return null;
        }
        Properties properties = new Properties();
        try {
            fileReader = new FileReader(file);
            try {
                properties.load(fileReader);
                Object obj = properties.get(".i.tt_ect");
                if (obj != null) {
                    n(String.valueOf(obj));
                }
                Enumeration<?> enumerationPropertyNames = properties.propertyNames();
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(properties.size());
                while (enumerationPropertyNames.hasMoreElements()) {
                    String strQg = (String) enumerationPropertyNames.nextElement();
                    String property = properties.getProperty(strQg);
                    if (strQg != null && !strQg.startsWith(".i.tt_ect")) {
                        if (this.s) {
                            strQg = this.n.qg(strQg);
                        }
                        com.byazt.eau.s sVar = this.n;
                        if (sVar != null) {
                            property = sVar.qg(property);
                        }
                        Pair<String, String> type = getType(strQg);
                        String str = (String) type.second;
                        String str2 = (String) type.first;
                        int iHashCode = str2.hashCode();
                        if (iHashCode != 98) {
                            if (iHashCode != 102) {
                                if (iHashCode != 105) {
                                    if (iHashCode != 108) {
                                        if (iHashCode != 115) {
                                            if (iHashCode == 3680 && str2.equals("ss")) {
                                                b = 4;
                                            } else {
                                                b = -1;
                                            }
                                        } else if (str2.equals(com.anythink.core.common.s.a)) {
                                            b = 6;
                                        } else {
                                            b = -1;
                                        }
                                    } else if (str2.equals(com.anythink.core.common.l.a)) {
                                        b = 1;
                                    } else {
                                        b = -1;
                                    }
                                } else if (str2.equals("i")) {
                                    b = 0;
                                } else {
                                    b = -1;
                                }
                            } else if (str2.equals("f")) {
                                b = 2;
                            } else {
                                b = -1;
                            }
                        } else if (str2.equals("b")) {
                            b = 3;
                        } else {
                            b = -1;
                        }
                        if (b == 0) {
                            concurrentHashMap.put(str, Integer.valueOf(Integer.parseInt(property)));
                        } else if (b == 1) {
                            concurrentHashMap.put(str, Long.valueOf(Long.parseLong(property)));
                        } else if (b == 2) {
                            concurrentHashMap.put(str, Float.valueOf(Float.parseFloat(property)));
                        } else if (b == 3) {
                            concurrentHashMap.put(str, Boolean.valueOf(Boolean.parseBoolean(property)));
                        } else if (b == 4) {
                            JSONArray jSONArray = new JSONArray(property);
                            HashSet hashSet = new HashSet((int) (((double) jSONArray.length()) / 0.75d));
                            for (int i = 0; i < jSONArray.length(); i++) {
                                hashSet.add(jSONArray.optString(i));
                            }
                            concurrentHashMap.put(str, hashSet);
                        } else {
                            concurrentHashMap.put(str, property);
                        }
                    }
                }
                try {
                    fileReader.close();
                } catch (Throwable unused) {
                }
                return concurrentHashMap;
            } catch (Throwable th) {
                th = th;
                try {
                    boolean zDelete = file.delete();
                    com.byazt.sf.s sVar2 = (com.byazt.sf.s) com.byazt.qp.q.n("ad_log", com.byazt.qp.q.qg(null));
                    if (sVar2 != null) {
                        final JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("file", file.getAbsolutePath());
                            jSONObject.put("delete", zDelete);
                            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, "read failed");
                            jSONObject.put("class", "PropReaderWriter");
                        } catch (JSONException unused2) {
                        }
                        sVar2.n("exception", (byte) 1, new com.byazt.rs.n() { // from class: com.byazt.mty.qg.1
                            @Override // com.byazt.rs.n
                            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("scene", "kv");
                                jSONObject3.put("object", jSONObject);
                                jSONObject3.put("exception", Log.getStackTraceString(th));
                                return jSONObject3;
                            }
                        });
                    }
                    file.getAbsolutePath();
                    if (fileReader == null) {
                        return null;
                    }
                    try {
                        return null;
                    } catch (Throwable unused3) {
                        return null;
                    }
                } finally {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused4) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileReader = null;
        }
    }

    private Pair<String, String> getType(String str) {
        if (str.contains(i.E)) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length >= 2) {
                return new Pair<>(strArrSplit[0], strArrSplit[1]);
            }
        }
        return new Pair<>(com.anythink.core.common.s.a, str);
    }

    @Override // com.byazt.uyg.qg
    public void n(Map<String, Object> map, File file) throws IOException {
        FileWriter fileWriter;
        Throwable th;
        String strConcat;
        if (file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        Properties properties = new Properties();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null) {
                if (entry.getValue() instanceof Set) {
                    Set set = (Set) entry.getValue();
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                    strConcat = "ss.".concat(String.valueOf(key));
                    value = jSONArray.toString();
                } else if (entry.getValue() instanceof Boolean) {
                    strConcat = "b.".concat(String.valueOf(key));
                } else if (entry.getValue() instanceof Integer) {
                    strConcat = "i.".concat(String.valueOf(key));
                } else if (entry.getValue() instanceof Long) {
                    strConcat = "l.".concat(String.valueOf(key));
                } else if ((entry.getValue() instanceof Float) || (entry.getValue() instanceof Double)) {
                    strConcat = "f.".concat(String.valueOf(key));
                } else {
                    strConcat = "s.".concat(String.valueOf(key));
                }
                String strValueOf = String.valueOf(value);
                if (this.s) {
                    strConcat = this.qg.n(strConcat);
                }
                com.byazt.eau.s sVar = this.qg;
                if (sVar != null) {
                    strValueOf = sVar.n(String.valueOf(strValueOf));
                }
                properties.put(strConcat, strValueOf);
            }
        }
        try {
            fileWriter = new FileWriter(file);
            try {
                com.byazt.eau.s sVar2 = this.qg;
                properties.put(".i.tt_ect", sVar2 != null ? String.valueOf(sVar2.n()) : "0");
                properties.store(fileWriter, (String) null);
                fileWriter.flush();
                try {
                    fileWriter.close();
                } catch (Exception unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            fileWriter = null;
            th = th3;
        }
    }
}
