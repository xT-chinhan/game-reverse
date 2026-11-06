package com.byazt.qd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1607, 26})
public class qg {
    public static qg qg;
    public final Map<String, n> s = new ConcurrentHashMap();
    public final Map<PluginBroadcastReceiver, BroadcastReceiver> q = new ConcurrentHashMap();
    public final Set<Integer> n = new CopyOnWriteArraySet();

    @com.byazt.cp.n(n = {0, 1, 1607, 48})
    public static class n {
        public String n;
        public final Set<PluginBroadcastReceiver> qg = new CopyOnWriteArraySet();

        public void registerReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
            if (pluginBroadcastReceiver != null) {
                this.qg.add(pluginBroadcastReceiver);
            }
        }

        public void unregisterReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
            if (pluginBroadcastReceiver != null) {
                try {
                    if (this.qg.size() > 0) {
                        this.qg.remove(pluginBroadcastReceiver);
                    }
                } catch (Throwable th) {
                    ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "unregisterReceiver-plugin-receiver->action:" + this.n + "[exception]:", th);
                }
            }
        }

        public void n(Context context, Intent intent) {
            Set<PluginBroadcastReceiver> set = this.qg;
            if (set == null || set.size() <= 0) {
                return;
            }
            for (PluginBroadcastReceiver pluginBroadcastReceiver : this.qg) {
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

    private qg() {
    }

    public static qg n() {
        if (qg == null) {
            synchronized (com.byazt.p000do.n.class) {
                if (qg == null) {
                    qg = new qg();
                }
            }
        }
        return qg;
    }

    public boolean n(int i) {
        return this.n.contains(Integer.valueOf(i));
    }

    private void n(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return;
        }
        Iterator<String> itActionsIterator = intentFilter.actionsIterator();
        while (itActionsIterator.hasNext()) {
            String next = itActionsIterator.next();
            if (next != null) {
                n nVar = this.s.get(next);
                if (nVar != null) {
                    nVar.registerReceiver(pluginBroadcastReceiver);
                } else {
                    n nVar2 = new n();
                    nVar2.n = next;
                    nVar2.registerReceiver(pluginBroadcastReceiver);
                    this.s.put(next, nVar2);
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
        this.q.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        n(intentFilter, pluginBroadcastReceiver);
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
        this.q.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        if (handler != null) {
            this.n.add(Integer.valueOf(broadcastReceiverProxy.hashCode()));
        }
        n(intentFilter, pluginBroadcastReceiver);
        return intentRegisterReceiver;
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, int i) {
        if (intentFilter == null || intentFilter.actionsIterator() == null || Build.VERSION.SDK_INT < 26) {
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
        this.q.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        n(intentFilter, pluginBroadcastReceiver);
        return intentRegisterReceiver;
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        if (intentFilter == null || intentFilter.actionsIterator() == null || Build.VERSION.SDK_INT < 26) {
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
        this.q.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        if (handler != null) {
            this.n.add(Integer.valueOf(broadcastReceiverProxy.hashCode()));
        }
        n(intentFilter, pluginBroadcastReceiver);
        return intentRegisterReceiver;
    }

    public void unregisterReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver) {
        Iterator<Map.Entry<String, n>> it = this.s.entrySet().iterator();
        while (it.hasNext()) {
            n value = it.next().getValue();
            if (value != null) {
                value.unregisterReceiver(pluginBroadcastReceiver);
            }
            BroadcastReceiver broadcastReceiver = this.q.get(pluginBroadcastReceiver);
            if (broadcastReceiver != null) {
                try {
                    this.n.remove(Integer.valueOf(broadcastReceiver.hashCode()));
                    this.q.remove(pluginBroadcastReceiver);
                    context.unregisterReceiver(broadcastReceiver);
                } catch (Throwable th) {
                    ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "unregisterReceiver-移除系统注册的广播发生异常:", th);
                }
            }
        }
    }

    public void n(Context context, Intent intent) {
        n value;
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        Map<String, n> map = this.s;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, n> entry : this.s.entrySet()) {
            if (action.equals(entry.getKey()) && (value = entry.getValue()) != null) {
                value.n(context, intent);
            }
        }
    }
}
