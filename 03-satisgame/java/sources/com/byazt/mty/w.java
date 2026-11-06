package com.byazt.mty;

import android.util.Xml;
import com.anythink.core.common.f.e;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
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
@com.byazt.cp.n(n = {0, 1, 669, 13})
public class w implements com.byazt.uyg.n, com.byazt.uyg.qg {
    public final com.byazt.eau.s n;
    public final boolean qg;

    public w(com.byazt.eau.s sVar) {
        this.n = sVar;
        this.qg = false;
    }

    public w(com.byazt.eau.s sVar, boolean z) {
        this.n = sVar;
        this.qg = z;
    }

    @Override // com.byazt.uyg.n
    public Map<String, Object> n(File file) throws Throwable {
        HashMap map = new HashMap();
        if (!file.exists() || !file.canRead()) {
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
                            if ("string".equals(name) || "int".equals(name) || "long".equals(name) || "float".equals(name) || "boolean".equals(name) || "set".equals(name)) {
                                String attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, TapEventParamConstants.PARAM_NAME);
                                Object objN = n(xmlPullParserNewPullParser, name);
                                if (attributeValue != null && objN != null) {
                                    map.put(attributeValue, objN);
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
                    return new com.byazt.ga.qg().n(map, this.n, this.qg);
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
        return new com.byazt.ga.qg().n(map, this.n, this.qg);
    }

    private Object n(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        str.hashCode();
        switch (str) {
            case "string":
                return xmlPullParser.nextText();
            case "int":
                return Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, e.a.d)));
            case "set":
                return n(xmlPullParser);
            case "long":
                return Long.valueOf(Long.parseLong(xmlPullParser.getAttributeValue(null, e.a.d)));
            case "boolean":
                return Boolean.valueOf(Boolean.parseBoolean(xmlPullParser.getAttributeValue(null, e.a.d)));
            case "float":
                return Float.valueOf(Float.parseFloat(xmlPullParser.getAttributeValue(null, e.a.d)));
            default:
                return null;
        }
    }

    private Set<String> n(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
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

    private void n(String str, Object obj, XmlSerializer xmlSerializer) throws IOException {
        if (obj instanceof String) {
            xmlSerializer.startTag(null, "string");
            xmlSerializer.attribute(null, TapEventParamConstants.PARAM_NAME, str);
            xmlSerializer.text(n((String) obj));
            xmlSerializer.endTag(null, "string");
            return;
        }
        if (obj instanceof Integer) {
            n(str, (Integer) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Long) {
            n(str, (Long) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Float) {
            n(str, (Float) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Double) {
            n(str, (Double) obj, xmlSerializer);
        } else if (obj instanceof Boolean) {
            n(str, (Boolean) obj, xmlSerializer);
        } else if (obj instanceof Set) {
            n(str, (Set<String>) obj, xmlSerializer);
        }
    }

    private void n(String str, Integer num, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "int");
        xmlSerializer.attribute(null, TapEventParamConstants.PARAM_NAME, str);
        xmlSerializer.attribute(null, e.a.d, Integer.toString(num.intValue()));
        xmlSerializer.endTag(null, "int");
    }

    private void n(String str, Long l, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "long");
        xmlSerializer.attribute(null, TapEventParamConstants.PARAM_NAME, str);
        xmlSerializer.attribute(null, e.a.d, Long.toString(l.longValue()));
        xmlSerializer.endTag(null, "long");
    }

    private void n(String str, Float f, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "float");
        xmlSerializer.attribute(null, TapEventParamConstants.PARAM_NAME, str);
        xmlSerializer.attribute(null, e.a.d, Float.toString(f.floatValue()));
        xmlSerializer.endTag(null, "float");
    }

    private void n(String str, Double d, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "double");
        xmlSerializer.attribute(null, TapEventParamConstants.PARAM_NAME, str);
        xmlSerializer.attribute(null, e.a.d, Double.toString(d.doubleValue()));
        xmlSerializer.endTag(null, "double");
    }

    private void n(String str, Boolean bool, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "boolean");
        xmlSerializer.attribute(null, TapEventParamConstants.PARAM_NAME, str);
        xmlSerializer.attribute(null, e.a.d, Boolean.toString(bool.booleanValue()));
        xmlSerializer.endTag(null, "boolean");
    }

    private void n(String str, Set<String> set, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "set");
        xmlSerializer.attribute(null, TapEventParamConstants.PARAM_NAME, str);
        for (String str2 : set) {
            xmlSerializer.startTag(null, "string");
            xmlSerializer.text(n(str2));
            xmlSerializer.endTag(null, "string");
        }
        xmlSerializer.endTag(null, "set");
    }

    @Override // com.byazt.uyg.qg
    public void n(Map<String, Object> map, File file) throws Throwable {
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
        Map<String, Object> mapQg = new com.byazt.ga.qg().qg(map, this.n, this.qg);
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                xmlSerializerNewSerializer.setOutput(fileOutputStream2, "utf-8");
                xmlSerializerNewSerializer.startDocument(null, Boolean.TRUE);
                xmlSerializerNewSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                xmlSerializerNewSerializer.startTag(null, "map");
                for (String str : mapQg.keySet()) {
                    if (str != null) {
                        n(str, mapQg.get(str), xmlSerializerNewSerializer);
                    }
                }
                xmlSerializerNewSerializer.endTag(null, "map");
                xmlSerializerNewSerializer.endDocument();
                try {
                    fileOutputStream2.close();
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused4) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        } catch (Exception unused6) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String n(String str) {
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
