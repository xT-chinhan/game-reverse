package com.bytedance.pangle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private static xr xr;
    private final Map<String, ms> ah = new ConcurrentHashMap();
    private final Map<PluginBroadcastReceiver, BroadcastReceiver> d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final Set<Integer> f672ms = new CopyOnWriteArraySet();

    public static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public String f673ms;
        public final Set<PluginBroadcastReceiver> xr = new CopyOnWriteArraySet();

        public void registerReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
            if (pluginBroadcastReceiver != null) {
                this.xr.add(pluginBroadcastReceiver);
            }
        }

        public void unregisterReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
            if (pluginBroadcastReceiver != null) {
                try {
                    if (this.xr.size() > 0) {
                        this.xr.remove(pluginBroadcastReceiver);
                    }
                } catch (Throwable th) {
                    ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "unregisterReceiver-plugin-receiver->action:" + this.f673ms + "[exception]:", th);
                }
            }
        }

        public void ms(Context context, Intent intent) {
            Set<PluginBroadcastReceiver> set = this.xr;
            if (set == null || set.size() <= 0) {
                return;
            }
            for (PluginBroadcastReceiver pluginBroadcastReceiver : this.xr) {
                if (pluginBroadcastReceiver != null) {
                    try {
                        pluginBroadcastReceiver.onReceive(context, intent);
                    } catch (Throwable th) {
                        ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "plugin-receiver->action:" + (intent != null ? intent.getAction() : "") + "[exception]:", th);
                    }
                }
            }
        }
    }

    private xr() {
    }

    public static xr ms() {
        if (xr == null) {
            synchronized (com.bytedance.pangle.service.ms.ms.class) {
                if (xr == null) {
                    xr = new xr();
                }
            }
        }
        return xr;
    }

    public boolean ms(int i) {
        return this.f672ms.contains(Integer.valueOf(i));
    }

    private void ms(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return;
        }
        Iterator<String> itActionsIterator = intentFilter.actionsIterator();
        while (itActionsIterator.hasNext()) {
            String next = itActionsIterator.next();
            if (next != null) {
                ms msVar = this.ah.get(next);
                if (msVar != null) {
                    msVar.registerReceiver(pluginBroadcastReceiver);
                } else {
                    ms msVar2 = new ms();
                    msVar2.f673ms = next;
                    msVar2.registerReceiver(pluginBroadcastReceiver);
                    this.ah.put(next, msVar2);
                }
            }
        }
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter) {
        Intent intentRegisterReceiver;
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                return context.registerReceiver(null, intentFilter, 2);
            }
            return context.registerReceiver(null, intentFilter);
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
            intentRegisterReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, 2);
        } else {
            intentRegisterReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter);
        }
        this.d.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        ms(intentFilter, pluginBroadcastReceiver);
        return intentRegisterReceiver;
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        Intent intentRegisterReceiver;
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                return context.registerReceiver(null, intentFilter, 2);
            }
            return context.registerReceiver(null, intentFilter);
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
            intentRegisterReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, str, handler, 2);
        } else {
            intentRegisterReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, str, handler);
        }
        this.d.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        if (handler != null) {
            this.f672ms.add(Integer.valueOf(broadcastReceiverProxy.hashCode()));
        }
        ms(intentFilter, pluginBroadcastReceiver);
        return intentRegisterReceiver;
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, int i) {
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                return context.registerReceiver(null, intentFilter, 2);
            }
            return context.registerReceiver(null, intentFilter);
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        Intent intentRegisterReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, i);
        this.d.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        ms(intentFilter, pluginBroadcastReceiver);
        return intentRegisterReceiver;
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                return context.registerReceiver(null, intentFilter, 2);
            }
            return context.registerReceiver(null, intentFilter);
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        Intent intentRegisterReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, str, handler, i);
        this.d.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        if (handler != null) {
            this.f672ms.add(Integer.valueOf(broadcastReceiverProxy.hashCode()));
        }
        ms(intentFilter, pluginBroadcastReceiver);
        return intentRegisterReceiver;
    }

    public void unregisterReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver) {
        Iterator<Map.Entry<String, ms>> it = this.ah.entrySet().iterator();
        while (it.hasNext()) {
            ms value = it.next().getValue();
            if (value != null) {
                value.unregisterReceiver(pluginBroadcastReceiver);
            }
            BroadcastReceiver broadcastReceiver = this.d.get(pluginBroadcastReceiver);
            if (broadcastReceiver != null) {
                try {
                    this.f672ms.remove(Integer.valueOf(broadcastReceiver.hashCode()));
                    this.d.remove(pluginBroadcastReceiver);
                    context.unregisterReceiver(broadcastReceiver);
                } catch (Throwable th) {
                    ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "unregisterReceiver-移除系统注册的广播发生异常:", th);
                }
            }
        }
    }

    public void ms(Context context, Intent intent) {
        ms value;
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        Map<String, ms> map = this.ah;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, ms> entry : this.ah.entrySet()) {
            if (action.equals(entry.getKey()) && (value = entry.getValue()) != null) {
                value.ms(context, intent);
            }
        }
    }
}
