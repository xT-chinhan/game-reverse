package com.byazt.qz;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.byazt.vkw.lb;
import com.umeng.analytics.pro.an;
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
@com.byazt.vzx.pr(pr = {0, 1, 1192, 13})
public class hw implements com.byazt.to.hw, com.byazt.to.pr {
    public final boolean hn;
    public final com.byazt.cr.hn hw;
    public com.byazt.cr.hn pr;

    public hw(com.byazt.cr.hn hnVar, boolean z) {
        this.pr = hnVar;
        this.hw = hnVar;
        this.hn = z;
    }

    private void pr(String str) {
        int i;
        lb lbVar;
        com.byazt.cr.hn hnVarPr;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (Throwable th) {
                i = 0;
            }
        } else {
            i = 0;
        }
        if (i == 0) {
            this.pr = null;
            return;
        }
        com.byazt.cr.hn hnVar = this.pr;
        if ((hnVar == null || hnVar.pr() != i) && (lbVar = (lb) com.byazt.zs.uc.pr("kv_store_factory")) != null && (hnVarPr = lbVar.pr(i)) != null) {
            this.pr = hnVarPr;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:30:0x0080  */
    @Override // com.byazt.to.pr
    public Map<String, Object> pr(File file) {
        final Throwable th;
        FileReader fileReader;
        if (file == null || !file.exists() || !file.canRead()) {
            return null;
        }
        Properties properties = new Properties();
        try {
            fileReader = new FileReader(file);
            try {
                properties.load(fileReader);
                Object obj = properties.get(".i.tt_ect");
                if (obj != null) {
                    pr(String.valueOf(obj));
                }
                Enumeration<?> enumerationPropertyNames = properties.propertyNames();
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(properties.size());
                while (enumerationPropertyNames.hasMoreElements()) {
                    String strHw = (String) enumerationPropertyNames.nextElement();
                    String property = properties.getProperty(strHw);
                    if (strHw != null && !strHw.startsWith(".i.tt_ect")) {
                        if (this.hn) {
                            strHw = this.pr.hw(strHw);
                        }
                        com.byazt.cr.hn hnVar = this.pr;
                        if (hnVar != null) {
                            property = hnVar.hw(property);
                        }
                        Pair<String, String> type = getType(strHw);
                        String str = (String) type.second;
                        switch ((String) type.first) {
                            case "i":
                                concurrentHashMap.put(str, Integer.valueOf(Integer.parseInt(property)));
                                break;
                            case "l":
                                concurrentHashMap.put(str, Long.valueOf(Long.parseLong(property)));
                                break;
                            case "f":
                                concurrentHashMap.put(str, Float.valueOf(Float.parseFloat(property)));
                                break;
                            case "b":
                                concurrentHashMap.put(str, Boolean.valueOf(Boolean.parseBoolean(property)));
                                break;
                            case "ss":
                                JSONArray jSONArray = new JSONArray(property);
                                HashSet hashSet = new HashSet((int) (((double) jSONArray.length()) / 0.75d));
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    hashSet.add(jSONArray.optString(i));
                                }
                                concurrentHashMap.put(str, hashSet);
                                break;
                            case "s":
                            default:
                                concurrentHashMap.put(str, property);
                                break;
                        }
                    }
                }
                try {
                    fileReader.close();
                } catch (Throwable th2) {
                }
                return concurrentHashMap;
            } catch (Throwable th3) {
                th = th3;
                try {
                    boolean zDelete = file.delete();
                    com.byazt.fu.hn hnVar2 = (com.byazt.fu.hn) com.byazt.zs.uc.pr("ad_log", com.byazt.zs.uc.hw(null));
                    if (hnVar2 != null) {
                        final JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("file", file.getAbsolutePath());
                            jSONObject.put("delete", zDelete);
                            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, "read failed");
                            jSONObject.put("class", "PropReaderWriter");
                        } catch (JSONException e) {
                        }
                        hnVar2.pr("exception", (byte) 1, new com.byazt.ttf.pr() { // from class: com.byazt.qz.hw.1
                            @Override // com.byazt.ttf.pr
                            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("scene", "kv");
                                jSONObject3.put("object", jSONObject);
                                jSONObject3.put("exception", Log.getStackTraceString(th));
                                return jSONObject3;
                            }
                        });
                    }
                    file.getAbsolutePath();
                    return null;
                } finally {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable th4) {
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
            fileReader = null;
        }
    }

    private Pair<String, String> getType(String str) {
        if (str.contains(".")) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length >= 2) {
                return new Pair<>(strArrSplit[0], strArrSplit[1]);
            }
        }
        return new Pair<>(an.aB, str);
    }

    @Override // com.byazt.to.hw
    public void pr(Map<String, Object> map, File file) throws Throwable {
        FileWriter fileWriter;
        Throwable th;
        String strValueOf;
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
        } catch (IOException e) {
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
                String strValueOf2 = String.valueOf(value);
                if (this.hn) {
                    strConcat = this.hw.pr(strConcat);
                }
                com.byazt.cr.hn hnVar = this.hw;
                if (hnVar != null) {
                    strValueOf2 = hnVar.pr(String.valueOf(strValueOf2));
                }
                properties.put(strConcat, strValueOf2);
            }
        }
        try {
            fileWriter = new FileWriter(file);
            try {
                com.byazt.cr.hn hnVar2 = this.hw;
                if (hnVar2 != null) {
                    strValueOf = String.valueOf(hnVar2.pr());
                } else {
                    strValueOf = "0";
                }
                properties.put(".i.tt_ect", strValueOf);
                properties.store(fileWriter, (String) null);
                fileWriter.flush();
                try {
                    fileWriter.close();
                } catch (Exception e2) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (Exception e3) {
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
