package com.bytedance.sdk.component.ab.ah;

import android.util.Xml;
import com.anythink.core.common.e.f;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.component.utils.sl;
import com.taptap.sdk.db.constant.Common;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes2.dex */
public class c implements com.bytedance.sdk.component.ab.ms, com.bytedance.sdk.component.ab.xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final com.bytedance.sdk.component.d.ms.ms f741ms;
    private final boolean xr;

    public c(com.bytedance.sdk.component.d.ms.ms msVar) {
        this.f741ms = msVar;
        this.xr = false;
    }

    public c(com.bytedance.sdk.component.d.ms.ms msVar, boolean z) {
        this.f741ms = msVar;
        this.xr = z;
    }

    @Override // com.bytedance.sdk.component.ab.ms
    public Map<String, Object> ms(File file) throws Throwable {
        HashMap map = new HashMap();
        if (!file.exists()) {
            return map;
        }
        if (!file.canRead()) {
            sl.xr("XmlSimpleReader", "can't read file " + file);
            return map;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                    xmlPullParserNewPullParser.setInput(fileInputStream2, null);
                    for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                        if (eventType == 2) {
                            String name = xmlPullParserNewPullParser.getName();
                            if ("string".equals(name) || IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL.equals(name) || "long".equals(name) || "float".equals(name) || "boolean".equals(name) || "set".equals(name)) {
                                String attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, Common.System.NAME);
                                Object objMs = ms(xmlPullParserNewPullParser, name);
                                if (attributeValue != null && objMs != null) {
                                    map.put(attributeValue, objMs);
                                }
                            }
                        }
                    }
                    fileInputStream2.close();
                } catch (Exception unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return new com.bytedance.sdk.component.ab.ms.xr().ms(map, this.f741ms, this.xr);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            }
        } catch (Exception unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
        return new com.bytedance.sdk.component.ab.ms.xr().ms(map, this.f741ms, this.xr);
    }

    private Object ms(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        str.hashCode();
        switch (str) {
            case "string":
                return xmlPullParser.nextText();
            case "int":
                return Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, f.a.d)));
            case "set":
                return ms(xmlPullParser);
            case "long":
                return Long.valueOf(Long.parseLong(xmlPullParser.getAttributeValue(null, f.a.d)));
            case "boolean":
                return Boolean.valueOf(Boolean.parseBoolean(xmlPullParser.getAttributeValue(null, f.a.d)));
            case "float":
                return Float.valueOf(Float.parseFloat(xmlPullParser.getAttributeValue(null, f.a.d)));
            default:
                return null;
        }
    }

    private Set<String> ms(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashSet hashSet = new HashSet();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && "set".equals(xmlPullParser.getName())) {
                return hashSet;
            }
            if (eventType == 2 && "string".equals(xmlPullParser.getName())) {
                hashSet.add(xmlPullParser.nextText());
            }
            eventType = xmlPullParser.next();
        }
    }

    private void ms(String str, Object obj, XmlSerializer xmlSerializer) throws IOException {
        if (obj instanceof String) {
            xmlSerializer.startTag(null, "string");
            xmlSerializer.attribute(null, Common.System.NAME, str);
            xmlSerializer.text(ms((String) obj));
            xmlSerializer.endTag(null, "string");
            return;
        }
        if (obj instanceof Integer) {
            ms(str, (Integer) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Long) {
            ms(str, (Long) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Float) {
            ms(str, (Float) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Double) {
            ms(str, (Double) obj, xmlSerializer);
        } else if (obj instanceof Boolean) {
            ms(str, (Boolean) obj, xmlSerializer);
        } else if (obj instanceof Set) {
            ms(str, (Set<String>) obj, xmlSerializer);
        }
    }

    private void ms(String str, Integer num, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
        xmlSerializer.attribute(null, Common.System.NAME, str);
        xmlSerializer.attribute(null, f.a.d, Integer.toString(num.intValue()));
        xmlSerializer.endTag(null, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
    }

    private void ms(String str, Long l, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "long");
        xmlSerializer.attribute(null, Common.System.NAME, str);
        xmlSerializer.attribute(null, f.a.d, Long.toString(l.longValue()));
        xmlSerializer.endTag(null, "long");
    }

    private void ms(String str, Float f, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "float");
        xmlSerializer.attribute(null, Common.System.NAME, str);
        xmlSerializer.attribute(null, f.a.d, Float.toString(f.floatValue()));
        xmlSerializer.endTag(null, "float");
    }

    private void ms(String str, Double d, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "double");
        xmlSerializer.attribute(null, Common.System.NAME, str);
        xmlSerializer.attribute(null, f.a.d, Double.toString(d.doubleValue()));
        xmlSerializer.endTag(null, "double");
    }

    private void ms(String str, Boolean bool, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "boolean");
        xmlSerializer.attribute(null, Common.System.NAME, str);
        xmlSerializer.attribute(null, f.a.d, Boolean.toString(bool.booleanValue()));
        xmlSerializer.endTag(null, "boolean");
    }

    private void ms(String str, Set<String> set, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "set");
        xmlSerializer.attribute(null, Common.System.NAME, str);
        for (String str2 : set) {
            xmlSerializer.startTag(null, "string");
            xmlSerializer.text(ms(str2));
            xmlSerializer.endTag(null, "string");
        }
        xmlSerializer.endTag(null, "set");
    }

    @Override // com.bytedance.sdk.component.ab.xr
    public void ms(Map<String, Object> map, File file) throws Throwable {
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
        Map<String, Object> mapXr = new com.bytedance.sdk.component.ab.ms.xr().xr(map, this.f741ms, this.xr);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                    xmlSerializerNewSerializer.setOutput(fileOutputStream2, "utf-8");
                    xmlSerializerNewSerializer.startDocument(null, Boolean.TRUE);
                    xmlSerializerNewSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                    xmlSerializerNewSerializer.startTag(null, "map");
                    for (String str : mapXr.keySet()) {
                        if (str != null) {
                            ms(str, mapXr.get(str), xmlSerializerNewSerializer);
                        }
                    }
                    xmlSerializerNewSerializer.endTag(null, "map");
                    xmlSerializerNewSerializer.endDocument();
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused2) {
                    }
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    sl.xr("XmlSimpleReader", "write file exception ", e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String ms(String str) {
        int i;
        StringBuilder sb = null;
        if (str == null) {
            return null;
        }
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if ((cCharAt < ' ' || cCharAt > 55295) && !((cCharAt >= 57344 && cCharAt <= 65533) || cCharAt == '\t' || cCharAt == '\n' || cCharAt == '\r')) {
                if (sb == null) {
                    sb = new StringBuilder();
                    if (i2 > 0) {
                        sb.append(str.substring(0, i2));
                    }
                }
                if (cCharAt == '\"') {
                    sb.append("&quot;");
                } else if (cCharAt == '<') {
                    sb.append("&lt;");
                } else if (cCharAt == '>') {
                    sb.append("&gt;");
                } else if (cCharAt == '&') {
                    sb.append("&amp;");
                } else if (cCharAt == '\'') {
                    sb.append("&apos;");
                } else if (Character.isHighSurrogate(cCharAt) && (i = i2 + 1) < length) {
                    char cCharAt2 = str.charAt(i);
                    if (Character.isLowSurrogate(cCharAt2)) {
                        sb.append(cCharAt);
                        sb.append(cCharAt2);
                        i2 = i;
                    }
                } else {
                    sb.append("&#").append((int) cCharAt).append(";");
                }
            } else if (sb != null) {
                sb.append(cCharAt);
            }
            i2++;
        }
        return sb != null ? sb.toString() : str;
    }
}
