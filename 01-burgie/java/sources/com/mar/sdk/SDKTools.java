package com.mar.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.text.ClipboardManager;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.mar.sdk.log.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class SDKTools {
    @SuppressLint({"MissingPermission"})
    public static boolean isNetworkAvailable(Context activity) {
        NetworkInfo info;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService("connectivity");
            if (connectivityManager == null || (info = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            if (info.getType() == 1 || info.getType() == 0) {
                return info.isAvailable();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String getRandomUrl() {
        List<String> list = new ArrayList<>();
        list.add("https://www.baidu.com");
        list.add("https://www.so.com/");
        list.add("https://www.qq.com/");
        list.add("https://www.aliyun.com/");
        Random random = new Random();
        int index = random.nextInt(4);
        return list.get(index);
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String getAssetConfigs(Context context, String assetsFile) throws Throwable {
        String string = null;
        InputStreamReader reader = null;
        BufferedReader br = null;
        try {
            try {
                InputStream inputStream = context.getAssets().open(assetsFile);
                if (inputStream == null) {
                    if (0 != 0) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (0 != 0) {
                        try {
                            reader.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else {
                    InputStreamReader reader2 = new InputStreamReader(inputStream);
                    try {
                        BufferedReader br2 = new BufferedReader(reader2);
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String line = br2.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line);
                            }
                            string = sb.toString();
                            if (br2 != null) {
                                try {
                                    br2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (reader2 != null) {
                                try {
                                    reader2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                            br = br2;
                            reader = reader2;
                            e.printStackTrace();
                            if (br != null) {
                                try {
                                    br.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (reader != null) {
                                try {
                                    reader.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            br = br2;
                            reader = reader2;
                            if (br != null) {
                                try {
                                    br.close();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                }
                            }
                            if (reader != null) {
                                try {
                                    reader.close();
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        reader = reader2;
                    } catch (Throwable th2) {
                        th = th2;
                        reader = reader2;
                    }
                }
            } catch (Exception e11) {
                e = e11;
            }
            return string;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static Map<String, String> getAssetPropConfig(Context context, String assetsPropertiesFile) {
        try {
            Properties pro = new Properties();
            pro.load(new InputStreamReader(context.getAssets().open(assetsPropertiesFile), Key.STRING_CHARSET_NAME));
            Map<String, String> result = new HashMap<>();
            for (Map.Entry<Object, Object> entry : pro.entrySet()) {
                String keyStr = entry.getKey().toString().trim();
                String keyVal = entry.getValue().toString().trim();
                if (!result.containsKey(keyStr)) {
                    result.put(keyStr, keyVal);
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getMetaData(Context ctx, String key) {
        try {
            ApplicationInfo appInfo = ctx.getPackageManager().getApplicationInfo(ctx.getPackageName(), 128);
            if (appInfo != null && appInfo.metaData != null && appInfo.metaData.containsKey(key)) {
                return "" + appInfo.metaData.get(key);
            }
            Log.e("MARSDK", "The meta-data key is not exists." + key);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyToClipBoard(final Activity activity, final String s) {
        activity.runOnUiThread(new Runnable() { // from class: com.mar.sdk.SDKTools.1
            @Override // java.lang.Runnable
            @SuppressLint({"NewApi"})
            public void run() {
                ClipboardManager cmb = (ClipboardManager) activity.getSystemService("clipboard");
                cmb.setText(s);
            }
        });
    }

    public static Map<String, String> collectDeviceInfo(Context ctx) {
        Map<String, String> info = new HashMap<>();
        try {
            PackageManager pm = ctx.getPackageManager();
            PackageInfo p = pm.getPackageInfo(ctx.getPackageName(), 1);
            if (p != null) {
                String versionName = p.versionName == null ? AbstractJsonLexerKt.NULL : p.versionName;
                String versionCode = p.versionCode + "";
                info.put("versionName", versionName);
                info.put("versionCode", versionCode);
            }
            Field[] fields = Build.class.getDeclaredFields();
            for (Field f : fields) {
                try {
                    f.setAccessible(true);
                    Object obj = f.get(null);
                    info.put(f.getName(), obj == null ? AbstractJsonLexerKt.NULL : obj.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            Log.e("MARSDK", "an error occured when collect package info...");
            e2.printStackTrace();
        }
        return info;
    }

    public static String getSystemKeyboard(final Activity activity) {
        FutureTask<String> futureResult = new FutureTask<>(new Callable<String>() { // from class: com.mar.sdk.SDKTools.2
            @Override // java.util.concurrent.Callable
            @SuppressLint({"NewApi"})
            public String call() throws Exception {
                ClipboardManager cmb = (ClipboardManager) activity.getSystemService("clipboard");
                return cmb.hasText() ? cmb.getText().toString() : "";
            }
        });
        activity.runOnUiThread(futureResult);
        try {
            return futureResult.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "";
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getLogicChannel(Context context, String prefix) throws Throwable {
        String strSubstring;
        String[] split;
        ApplicationInfo appInfo = context.getApplicationInfo();
        String sourceDir = appInfo.sourceDir;
        String key = "META-INF/" + prefix;
        ZipFile zip = null;
        try {
            try {
                ZipFile zip2 = new ZipFile(sourceDir);
                try {
                    Enumeration<?> entries = zip2.entries();
                    String ret = null;
                    while (entries.hasMoreElements()) {
                        ZipEntry entry = entries.nextElement();
                        String entryName = entry.getName();
                        if (entryName.startsWith(key)) {
                            ret = entryName;
                            break;
                        }
                    }
                    if (TextUtils.isEmpty(ret) || (split = ret.split("_")) == null || split.length < 2) {
                        if (zip2 != null) {
                            try {
                                zip2.close();
                                zip = zip2;
                            } catch (Exception e) {
                                e.printStackTrace();
                                zip = zip2;
                            }
                        } else {
                            zip = zip2;
                        }
                        strSubstring = null;
                    } else {
                        strSubstring = ret.substring(split[0].length() + 1);
                        if (zip2 != null) {
                            try {
                                zip2.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        zip = zip2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    zip = zip2;
                    e.printStackTrace();
                    if (zip != null) {
                        try {
                            zip.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    zip = zip2;
                    if (zip != null) {
                        try {
                            zip.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
        return strSubstring;
    }

    public static String getApplicationName(Context context) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = null;
        try {
            packageManager = context.getApplicationContext().getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            applicationInfo = null;
        }
        String applicationName = (String) packageManager.getApplicationLabel(applicationInfo);
        return applicationName;
    }

    public static ProgressDialog showProgressTip(Activity context, String title) {
        if (context == null) {
            return null;
        }
        if ((context instanceof Activity) && (context.isFinishing() || context.isDestroyed())) {
            return null;
        }
        ProgressDialog loadingActivity = new ProgressDialog(context);
        loadingActivity.setIndeterminate(true);
        loadingActivity.setCancelable(true);
        loadingActivity.setMessage(title);
        loadingActivity.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.mar.sdk.SDKTools.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface arg0) {
            }
        });
        loadingActivity.show();
        return loadingActivity;
    }

    public static void hideProgressTip(ProgressDialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public static boolean isProxy(Context context) {
        String proxyAddress;
        int proxyPort;
        if (Build.VERSION.SDK_INT >= 14) {
            proxyAddress = System.getProperty("http.proxyHost");
            String portStr = System.getProperty("http.proxyPort");
            if (portStr == null) {
                portStr = "-1";
            }
            proxyPort = Integer.parseInt(portStr);
        } else {
            proxyAddress = Proxy.getHost(context);
            proxyPort = Proxy.getPort(context);
        }
        return (TextUtils.isEmpty(proxyAddress) || proxyPort == -1) ? false : true;
    }

    public static boolean checkVPN(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connMgr.getNetworkInfo(17);
        return networkInfo != null && networkInfo.isConnected();
    }
}
