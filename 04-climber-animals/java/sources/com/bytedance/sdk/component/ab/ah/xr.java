package com.bytedance.sdk.component.ab.ah;

import android.text.TextUtils;
import android.util.Pair;
import com.anythink.basead.b.f;
import com.anythink.core.common.d.j;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.kuaishou.weapon.p0.t;
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
public class xr implements com.bytedance.sdk.component.ab.ms, com.bytedance.sdk.component.ab.xr {
    private final boolean ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.component.d.ms.ms f748ms;
    private final com.bytedance.sdk.component.d.ms.ms xr;

    public xr(com.bytedance.sdk.component.d.ms.ms msVar, boolean z) {
        this.f748ms = msVar;
        this.xr = msVar;
        this.ah = z;
    }

    private void ms(String str) {
        int i;
        com.bytedance.sdk.component.d.xr xrVar;
        com.bytedance.sdk.component.d.ms.ms msVarMs;
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
            this.f748ms = null;
            return;
        }
        com.bytedance.sdk.component.d.ms.ms msVar = this.f748ms;
        if ((msVar != null && msVar.ms() == i) || (xrVar = (com.bytedance.sdk.component.d.xr) AutoService.ms(com.bytedance.sdk.component.d.xr.class)) == null || (msVarMs = xrVar.ms(i)) == null) {
            return;
        }
        this.f748ms = msVarMs;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00e4  */
    @Override // com.bytedance.sdk.component.ab.ms
    public Map<String, Object> ms(File file) {
        FileReader fileReader;
        byte b;
        if (file == null || !file.exists()) {
            return null;
        }
        if (!file.canRead()) {
            sl.xr("PropReaderWriter", "can't read file ".concat(String.valueOf(file)));
            return null;
        }
        Properties properties = new Properties();
        try {
            fileReader = new FileReader(file);
            try {
                properties.load(fileReader);
                Object obj = properties.get(".i.tt_ect");
                if (obj != null) {
                    ms(String.valueOf(obj));
                }
                Enumeration<?> enumerationPropertyNames = properties.propertyNames();
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(properties.size());
                while (enumerationPropertyNames.hasMoreElements()) {
                    String str = (String) enumerationPropertyNames.nextElement();
                    String property = properties.getProperty(str);
                    if (str != null && !str.startsWith(".i.tt_ect")) {
                        if (this.ah) {
                            str = (String) this.f748ms.xr(str);
                        }
                        com.bytedance.sdk.component.d.ms.ms msVar = this.f748ms;
                        if (msVar != null) {
                            property = (String) msVar.xr(property);
                        }
                        Pair<String, String> type = getType(str);
                        String str2 = (String) type.second;
                        String str3 = (String) type.first;
                        int iHashCode = str3.hashCode();
                        if (iHashCode != 98) {
                            if (iHashCode != 102) {
                                if (iHashCode != 105) {
                                    if (iHashCode != 108) {
                                        if (iHashCode != 115) {
                                            if (iHashCode == 3680 && str3.equals("ss")) {
                                                b = 4;
                                            } else {
                                                b = -1;
                                            }
                                        } else if (str3.equals("s")) {
                                            b = 6;
                                        } else {
                                            b = -1;
                                        }
                                    } else if (str3.equals(t.d)) {
                                        b = 1;
                                    } else {
                                        b = -1;
                                    }
                                } else if (str3.equals("i")) {
                                    b = 0;
                                } else {
                                    b = -1;
                                }
                            } else if (str3.equals(f.a)) {
                                b = 2;
                            } else {
                                b = -1;
                            }
                        } else if (str3.equals("b")) {
                            b = 3;
                        } else {
                            b = -1;
                        }
                        if (b == 0) {
                            concurrentHashMap.put(str2, Integer.valueOf(Integer.parseInt(property)));
                        } else if (b == 1) {
                            concurrentHashMap.put(str2, Long.valueOf(Long.parseLong(property)));
                        } else if (b == 2) {
                            concurrentHashMap.put(str2, Float.valueOf(Float.parseFloat(property)));
                        } else if (b == 3) {
                            concurrentHashMap.put(str2, Boolean.valueOf(Boolean.parseBoolean(property)));
                        } else if (b == 4) {
                            JSONArray jSONArray = new JSONArray(property);
                            HashSet hashSet = new HashSet((int) (((double) jSONArray.length()) / 0.75d));
                            for (int i = 0; i < jSONArray.length(); i++) {
                                hashSet.add(jSONArray.optString(i));
                            }
                            concurrentHashMap.put(str2, hashSet);
                        } else {
                            concurrentHashMap.put(str2, property);
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
                    com.bytedance.sdk.component.d.ms msVar2 = (com.bytedance.sdk.component.d.ms) AutoService.ms(com.bytedance.sdk.component.d.ms.class);
                    if (msVar2 != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("file", file.getAbsolutePath());
                            jSONObject.put("delete", zDelete);
                            jSONObject.put("msg", "read failed");
                            jSONObject.put("class", "PropReaderWriter");
                        } catch (JSONException unused2) {
                        }
                        msVar2.ms("kv", jSONObject, th);
                    }
                    sl.xr("PropReader", "read failed， try delete = " + zDelete + "," + file.getAbsolutePath(), th);
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
        if (str.contains(j.z)) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length >= 2) {
                return new Pair<>(strArrSplit[0], strArrSplit[1]);
            }
        }
        return new Pair<>("s", str);
    }

    @Override // com.bytedance.sdk.component.ab.xr
    public void ms(Map<String, Object> map, File file) throws Throwable {
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
                if (this.ah) {
                    strConcat = this.xr.ms(strConcat);
                }
                com.bytedance.sdk.component.d.ms.ms msVar = this.xr;
                if (msVar != null) {
                    strValueOf = msVar.ms(String.valueOf(strValueOf));
                }
                properties.put(strConcat, strValueOf);
            }
        }
        try {
            fileWriter = new FileWriter(file);
            try {
                com.bytedance.sdk.component.d.ms.ms msVar2 = this.xr;
                properties.put(".i.tt_ect", msVar2 != null ? String.valueOf(msVar2.ms()) : "0");
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
