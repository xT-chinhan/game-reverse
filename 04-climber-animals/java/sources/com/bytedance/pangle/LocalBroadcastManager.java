package com.bytedance.pangle;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import com.umeng.ccg.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = new Object();
    private final Context mAppContext;
    private final Handler mHandler;
    private final HashMap<PluginBroadcastReceiver, ArrayList<xr>> mReceivers = new HashMap<>();
    private final HashMap<String, ArrayList<xr>> mActions = new HashMap<>();
    private final ArrayList<ms> mPendingBroadcasts = new ArrayList<>();

    private static final class xr {
        boolean ah;
        boolean d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final IntentFilter f607ms;
        final PluginBroadcastReceiver xr;

        xr(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
            this.f607ms = intentFilter;
            this.xr = pluginBroadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.xr);
            sb.append(" filter=");
            sb.append(this.f607ms);
            if (this.d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private static final class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final Intent f606ms;
        final ArrayList<xr> xr;

        ms(Intent intent, ArrayList<xr> arrayList) {
            this.f606ms = intent;
            this.xr = arrayList;
        }
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = mInstance;
        }
        return localBroadcastManager;
    }

    private LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) { // from class: com.bytedance.pangle.LocalBroadcastManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    LocalBroadcastManager.this.executePendingBroadcasts();
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    public void registerReceiver(PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            xr xrVar = new xr(intentFilter, pluginBroadcastReceiver);
            ArrayList<xr> arrayList = this.mReceivers.get(pluginBroadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.mReceivers.put(pluginBroadcastReceiver, arrayList);
            }
            arrayList.add(xrVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<xr> arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(xrVar);
            }
        }
    }

    public void unregisterReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList<xr> arrayListRemove = this.mReceivers.remove(pluginBroadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                xr xrVar = arrayListRemove.get(size);
                xrVar.d = true;
                for (int i = 0; i < xrVar.f607ms.countActions(); i++) {
                    String action = xrVar.f607ms.getAction(i);
                    ArrayList<xr> arrayList = this.mActions.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            xr xrVar2 = arrayList.get(size2);
                            if (xrVar2.xr == pluginBroadcastReceiver) {
                                xrVar2.d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.mActions.remove(action);
                        }
                    }
                }
            }
        }
    }

    public boolean sendBroadcast(Intent intent) {
        int i;
        String str;
        ArrayList arrayList;
        ArrayList<xr> arrayList2;
        String str2;
        String str3;
        synchronized (this.mReceivers) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                com.bytedance.sdk.openadsdk.api.ab.ms(TAG, "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<xr> arrayList3 = this.mActions.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(TAG, "Action list: ".concat(String.valueOf(arrayList3)));
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    xr xrVar = arrayList3.get(i2);
                    if (z) {
                        com.bytedance.sdk.openadsdk.api.ab.ms(TAG, "Matching against filter " + xrVar.f607ms);
                    }
                    if (xrVar.ah) {
                        if (z) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(TAG, "  Filter's target already added");
                        }
                        i = i2;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = strResolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i = i2;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = strResolveTypeIfNeeded;
                        int iMatch = xrVar.f607ms.match(action, strResolveTypeIfNeeded, scheme, data, categories, TAG);
                        if (iMatch >= 0) {
                            if (z) {
                                com.bytedance.sdk.openadsdk.api.ab.ms(TAG, "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(xrVar);
                            xrVar.ah = true;
                        } else if (z) {
                            if (iMatch == -4) {
                                str3 = "category";
                            } else if (iMatch == -3) {
                                str3 = a.z;
                            } else if (iMatch != -2) {
                                str3 = iMatch != -1 ? "unknown reason" : "type";
                            } else {
                                str3 = "data";
                            }
                            com.bytedance.sdk.openadsdk.api.ab.ms(TAG, "  Filter did not match: ".concat(str3));
                        }
                        i2 = i + 1;
                        action = str;
                        arrayList3 = arrayList2;
                        strResolveTypeIfNeeded = str2;
                    }
                    arrayList4 = arrayList;
                    i2 = i + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    strResolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                        ((xr) arrayList5.get(i3)).ah = false;
                    }
                    this.mPendingBroadcasts.add(new ms(intent, arrayList5));
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    void executePendingBroadcasts() {
        int size;
        ms[] msVarArr;
        while (true) {
            synchronized (this.mReceivers) {
                size = this.mPendingBroadcasts.size();
                if (size <= 0) {
                    return;
                }
                msVarArr = new ms[size];
                this.mPendingBroadcasts.toArray(msVarArr);
                this.mPendingBroadcasts.clear();
            }
            for (int i = 0; i < size; i++) {
                ms msVar = msVarArr[i];
                int size2 = msVar.xr.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    xr xrVar = msVar.xr.get(i2);
                    if (!xrVar.d) {
                        xrVar.xr.onReceive(this.mAppContext, msVar.f606ms);
                    }
                }
            }
        }
    }
}
