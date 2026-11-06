package com.mar.sdk.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Xml;
import com.mar.sdk.MARSDK;
import com.mar.sdk.SDKParams;
import com.mar.sdk.SDKTools;
import com.mar.sdk.http.HttpListener;
import com.mar.sdk.http.MARHttp;
import com.mar.sdk.log.Log;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"UseSparseArrays"})
public class PluginFactory {
    private static PluginFactory instance;
    private Map<Integer, List<String>> supportedPlugins = new HashMap();

    private PluginFactory() {
    }

    public static PluginFactory getInstance() {
        if (instance == null) {
            instance = new PluginFactory();
        }
        return instance;
    }

    private boolean isSupportPlugin(int type) {
        return this.supportedPlugins.containsKey(Integer.valueOf(type));
    }

    private String getPluginName(int type) {
        if (this.supportedPlugins.containsKey(Integer.valueOf(type))) {
            List<String> names = this.supportedPlugins.get(Integer.valueOf(type));
            if (names.size() > 0) {
                return names.get(0);
            }
        }
        return null;
    }

    public Map<String, Object> initPlugins(int type) {
        try {
            if (!this.supportedPlugins.containsKey(Integer.valueOf(type))) {
                if (type == 1 || type == 2) {
                    Log.e("MARSDK", "The config of the MARSDK is not support plugin type:" + type);
                } else {
                    Log.w("MARSDK", "The config of the MARSDK is not support plugin type:" + type);
                }
                return null;
            }
            List<String> names = this.supportedPlugins.get(Integer.valueOf(type));
            Map<String, Object> result = new HashMap<>();
            for (String name : names) {
                Object t = doPluginInstance(name);
                if (t != null) {
                    result.put(name, t);
                } else {
                    Log.e("MARSDK", "plugin instance failed. plugin name:" + name);
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Bundle getMetaData(Context context) {
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (appInfo != null && appInfo.metaData != null) {
                return appInfo.metaData;
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
        return new Bundle();
    }

    public SDKParams getSDKParams(Context context) {
        Map<String, String> configs = SDKTools.getAssetPropConfig(context, "mar_developer_config.properties");
        return new SDKParams(configs);
    }

    public void getMarUrlConfig(final SDKParams sdkParams) {
        MARHttp.getRequest("https://marsdkserver-1300810349.file.myqcloud.com/marsdk-client/config/marsdk_config.json", (Map<String, String>) null, new HttpListener() { // from class: com.mar.sdk.base.PluginFactory.1
            @Override // com.mar.sdk.http.HttpListener
            public void onSuccess(String response) {
                Log.d("MARSDK", "getMarUrlConfig:" + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String MARSERVER_URL = jsonObject.optString("MARSERVER_URL", "");
                    String MAR_ARCHIVE = jsonObject.optString("MAR_ARCHIVE", "");
                    sdkParams.put("MARSERVER_URL", MARSERVER_URL);
                    sdkParams.put("MAR_ARCHIVE", MAR_ARCHIVE);
                } catch (Exception e) {
                    Log.e("MARSDK", "plugin getMarUrlConfig failed:" + e);
                }
            }

            @Override // com.mar.sdk.http.HttpListener
            public void onFail() {
                Log.e("MARSDK", "plugin getMarUrlConfig onFail");
            }
        });
    }

    public Object initPlugin(int type) {
        if (!isSupportPlugin(type)) {
            if (type == 1 || type == 2) {
                Log.e("MARSDK", "The config of the MARSDK is not support plugin type:" + type);
            } else {
                Log.w("MARSDK", "The config of the MARSDK is not support plugin type:" + type);
            }
            return null;
        }
        String pluginName = getPluginName(type);
        return doPluginInstance(pluginName);
    }

    private Object doPluginInstance(String className) {
        try {
            Class<?> cls = Class.forName(className);
            try {
                return cls.getDeclaredConstructor(Activity.class).newInstance(MARSDK.getInstance().getContext());
            } catch (Exception e) {
                try {
                    return cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception e1) {
                    e1.printStackTrace();
                    e.printStackTrace();
                    return null;
                }
            }
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void loadPluginInfo(Context context) {
        String xmlPlugins = SDKTools.getAssetConfigs(context, "mar_plugin_config.xml");
        if (xmlPlugins == null) {
            Log.e("MARSDK", "fail to load plugin_config.xml");
            return;
        }
        XmlPullParser parser = Xml.newPullParser();
        try {
            parser.setInput(new StringReader(xmlPlugins));
            for (int eventType = parser.getEventType(); eventType != 1; eventType = parser.next()) {
                switch (eventType) {
                    case 2:
                        String tag = parser.getName();
                        if ("plugin".equals(tag)) {
                            String name = parser.getAttributeValue(0);
                            int type = Integer.parseInt(parser.getAttributeValue(1));
                            if (!this.supportedPlugins.containsKey(Integer.valueOf(type))) {
                                this.supportedPlugins.put(Integer.valueOf(type), new ArrayList());
                            }
                            if (!this.supportedPlugins.get(Integer.valueOf(type)).contains(name)) {
                                this.supportedPlugins.get(Integer.valueOf(type)).add(name);
                            }
                            Log.d("MARSDK", "Curr Supported Plugin: " + type + "; name:" + name);
                        }
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    public void printMarSdk(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            String packageName = packageInfo.packageName;
            String versionName = packageInfo.versionName;
            int versionCode = packageInfo.versionCode;
            Log.d("MARSDK", "packageName：" + packageName);
            Log.d("MARSDK", "versionName：" + versionName);
            Log.d("MARSDK", "versionCode：" + versionCode);
            String xmlString = SDKTools.getAssetConfigs(context, "mar_sdk_version.xml");
            JSONArray sdkArray = new JSONArray();
            JSONArray pluginArray = new JSONArray();
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(xmlString));
            JSONObject currentItem = null;
            for (int eventType = parser.getEventType(); eventType != 1; eventType = parser.next()) {
                switch (eventType) {
                    case 2:
                        String tagName = parser.getName();
                        if ("sdk".equals(tagName) || "plugin".equals(tagName)) {
                            currentItem = new JSONObject();
                            currentItem.put("type", tagName);
                            for (int i = 0; i < parser.getAttributeCount(); i++) {
                                String attrName = parser.getAttributeName(i);
                                String attrValue = parser.getAttributeValue(i);
                                currentItem.put(attrName, attrValue);
                            }
                        }
                        break;
                    case 3:
                        String endTagName = parser.getName();
                        if (("sdk".equals(endTagName) || "plugin".equals(endTagName)) && currentItem != null) {
                            String type = currentItem.getString("type");
                            if ("sdk".equals(type)) {
                                sdkArray.put(currentItem);
                            } else if ("plugin".equals(type)) {
                                pluginArray.put(currentItem);
                            }
                            currentItem = null;
                        }
                        break;
                }
            }
            Log.d("MARSDK", "SDK：" + sdkArray.toString());
            Log.d("MARSDK", "Plugin：" + pluginArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
