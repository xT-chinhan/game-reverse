package com.byazt.qz;

import android.util.Xml;
import com.tapsdk.tapad.group.constants.Constants;
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
@com.byazt.vzx.pr(pr = {0, 1, 1192, 5})
public class uc implements com.byazt.to.hw, com.byazt.to.pr {
    public final boolean hw;
    public final com.byazt.cr.hn pr;

    public uc(com.byazt.cr.hn hnVar) {
        this.pr = hnVar;
        this.hw = false;
    }

    public uc(com.byazt.cr.hn hnVar, boolean z) {
        this.pr = hnVar;
        this.hw = z;
    }

    @Override // com.byazt.to.pr
    public Map<String, Object> pr(File file) throws Throwable {
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
                                String attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, Common.System.NAME);
                                Object objPr = pr(xmlPullParserNewPullParser, name);
                                if (attributeValue != null && objPr != null) {
                                    map.put(attributeValue, objPr);
                                }
                            }
                        }
                    }
                    fileInputStream2.close();
                } catch (Exception e) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return new com.byazt.ox.hw().pr(map, this.pr, this.hw);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
            }
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
        }
        return new com.byazt.ox.hw().pr(map, this.pr, this.hw);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    private Object pr(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        switch (str) {
            case "string":
                return xmlPullParser.nextText();
            case "int":
                return Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, Constants.VALUE_FIELD)));
            case "long":
                return Long.valueOf(Long.parseLong(xmlPullParser.getAttributeValue(null, Constants.VALUE_FIELD)));
            case "float":
                return Float.valueOf(Float.parseFloat(xmlPullParser.getAttributeValue(null, Constants.VALUE_FIELD)));
            case "boolean":
                return Boolean.valueOf(Boolean.parseBoolean(xmlPullParser.getAttributeValue(null, Constants.VALUE_FIELD)));
            case "set":
                return pr(xmlPullParser);
            default:
                return null;
        }
    }

    private Set<String> pr(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashSet hashSet = new HashSet();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !"set".equals(xmlPullParser.getName())) {
                if (eventType == 2 && "string".equals(xmlPullParser.getName())) {
                    hashSet.add(xmlPullParser.nextText());
                }
                eventType = xmlPullParser.next();
            } else {
                return hashSet;
            }
        }
    }

    private void pr(String str, Object obj, XmlSerializer xmlSerializer) throws IOException {
        if (obj instanceof String) {
            xmlSerializer.startTag(null, "string");
            xmlSerializer.attribute(null, Common.System.NAME, str);
            xmlSerializer.text(pr((String) obj));
            xmlSerializer.endTag(null, "string");
            return;
        }
        if (obj instanceof Integer) {
            pr(str, (Integer) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Long) {
            pr(str, (Long) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Float) {
            pr(str, (Float) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Double) {
            pr(str, (Double) obj, xmlSerializer);
        } else if (obj instanceof Boolean) {
            pr(str, (Boolean) obj, xmlSerializer);
        } else if (obj instanceof Set) {
            pr(str, (Set<String>) obj, xmlSerializer);
        }
    }

    private void pr(String str, Integer num, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "int");
        xmlSerializer.attribute(null, Common.System.NAME, str);
        xmlSerializer.attribute(null, Constants.VALUE_FIELD, Integer.toString(num.intValue()));
        xmlSerializer.endTag(null, "int");
    }

    private void pr(String str, Long l, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "long");
        xmlSerializer.attribute(null, Common.System.NAME, str);
        xmlSerializer.attribute(null, Constants.VALUE_FIELD, Long.toString(l.longValue()));
        xmlSerializer.endTag(null, "long");
    }

    private void pr(String str, Float f, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "float");
        xmlSerializer.attribute(null, Common.System.NAME, str);
        xmlSerializer.attribute(null, Constants.VALUE_FIELD, Float.toString(f.floatValue()));
        xmlSerializer.endTag(null, "float");
    }

    private void pr(String str, Double d, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "double");
        xmlSerializer.attribute(null, Common.System.NAME, str);
        xmlSerializer.attribute(null, Constants.VALUE_FIELD, Double.toString(d.doubleValue()));
        xmlSerializer.endTag(null, "double");
    }

    private void pr(String str, Boolean bool, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "boolean");
        xmlSerializer.attribute(null, Common.System.NAME, str);
        xmlSerializer.attribute(null, Constants.VALUE_FIELD, Boolean.toString(bool.booleanValue()));
        xmlSerializer.endTag(null, "boolean");
    }

    private void pr(String str, Set<String> set, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "set");
        xmlSerializer.attribute(null, Common.System.NAME, str);
        for (String str2 : set) {
            xmlSerializer.startTag(null, "string");
            xmlSerializer.text(pr(str2));
            xmlSerializer.endTag(null, "string");
        }
        xmlSerializer.endTag(null, "set");
    }

    @Override // com.byazt.to.hw
    public void pr(Map<String, Object> map, File file) throws Throwable {
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
        Map<String, Object> mapHw = new com.byazt.ox.hw().hw(map, this.pr, this.hw);
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
                    for (String str : mapHw.keySet()) {
                        if (str != null) {
                            pr(str, mapHw.get(str), xmlSerializerNewSerializer);
                        }
                    }
                    xmlSerializerNewSerializer.endTag(null, "map");
                    xmlSerializerNewSerializer.endDocument();
                    fileOutputStream2.close();
                } catch (Exception e2) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
            }
        } catch (Exception e5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String pr(String str) {
        int i;
        StringBuilder sb = null;
        if (str == null) {
            return null;
        }
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if ((cCharAt >= ' ' && cCharAt <= 55295) || ((cCharAt >= 57344 && cCharAt <= 65533) || cCharAt == '\t' || cCharAt == '\n' || cCharAt == '\r')) {
                if (sb != null) {
                    sb.append(cCharAt);
                }
            } else {
                if (sb == null) {
                    sb = new StringBuilder();
                    if (i2 > 0) {
                        sb.append(str.substring(0, i2));
                    }
                }
                switch (cCharAt) {
                    case '\"':
                        sb.append("&quot;");
                        break;
                    case '&':
                        sb.append("&amp;");
                        break;
                    case '\'':
                        sb.append("&apos;");
                        break;
                    case '<':
                        sb.append("&lt;");
                        break;
                    case '>':
                        sb.append("&gt;");
                        break;
                    default:
                        if (Character.isHighSurrogate(cCharAt) && (i = i2 + 1) < length) {
                            char cCharAt2 = str.charAt(i);
                            if (Character.isLowSurrogate(cCharAt2)) {
                                sb.append(cCharAt);
                                sb.append(cCharAt2);
                                i2 = i;
                            }
                        } else {
                            sb.append("&#").append((int) cCharAt).append(";");
                        }
                        break;
                }
            }
            i2++;
        }
        return sb != null ? sb.toString() : str;
    }
}
