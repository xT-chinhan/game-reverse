package com.tapsdk.tapad.group.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tapsdk.tapad.internal.AppContextHolder;
import com.tapsdk.tapad.internal.runtime.AndroidDeviceFacts;
import com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class RewardCapsuleProcessBridge {
    private static final String ACTION_SUFFIX = ".tapad.reward_fallback_capsule";
    private static final String COMMAND_SELECT = "select";
    private static final String COMMAND_START = "start";
    private static final String COMMAND_STOP = "stop";
    private static final String EXTRA_COMMAND = "command";
    private static final String EXTRA_ENDPOINTS = "endpoints";
    private static final String EXTRA_OWNER_ENDPOINT = "owner_endpoint";
    private static final String EXTRA_OWNER_PID = "owner_pid";
    private static final String EXTRA_SESSION_ID = "session_id";
    private static final String EXTRA_SESSION_TOKEN = "session_token";
    private static final String EXTRA_TARGET_PID = "target_pid";
    private static final RewardCapsuleProcessBridge INSTANCE = new RewardCapsuleProcessBridge();
    private static final int OWNER_ATTACHED = 2;
    private static final int OWNER_CLICK = 5;
    private static final int OWNER_CLOSE_RESULT = 6;
    private static final String OWNER_DESCRIPTOR = "com.tapsdk.tapad.reward_capsule.owner.v1";
    private static final int OWNER_DISCOVERED = 1;
    private static final int OWNER_PAUSED = 4;
    private static final int OWNER_RESUMED = 3;
    private static final int REMOTE_ACTIVATE = 1;
    private static final long REMOTE_ATTACH_TIMEOUT_MS = 15000;
    private static final int REMOTE_CLOSE = 3;
    private static final String REMOTE_DESCRIPTOR = "com.tapsdk.tapad.reward_capsule.remote.v1";
    private static final int REMOTE_RENDER = 2;
    private static final int REMOTE_SELECT = 5;
    private static final int REMOTE_STOP = 4;
    private static final String TAG = "RewardCapsuleProcessBridge";
    private BroadcastReceiver receiver;
    private final Handler main = new Handler(Looper.getMainLooper());
    private final AtomicBoolean registered = new AtomicBoolean(false);
    private final Map<String, OwnerRegistration> owners = new ConcurrentHashMap();
    private final ConcurrentMap<String, RemoteSession> remotes = new ConcurrentHashMap();

    public interface OwnerCallback {
        void onRemoteCloseResult(RemoteEvent remoteEvent, boolean z, String str);

        void onRemoteHostAttached(RemoteEvent remoteEvent);

        void onRemoteHostClick(RemoteEvent remoteEvent);

        void onRemoteHostPaused(RemoteEvent remoteEvent);

        void onRemoteHostResumed(RemoteEvent remoteEvent);
    }

    public final class OwnerEndpoint extends Binder {
        private final OwnerRegistration owner;

        public OwnerEndpoint(OwnerRegistration ownerRegistration) {
            this.owner = ownerRegistration;
            attachInterface(null, RewardCapsuleProcessBridge.OWNER_DESCRIPTOR);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                if (parcel2 != null) {
                    parcel2.writeString(RewardCapsuleProcessBridge.OWNER_DESCRIPTOR);
                }
                return true;
            }
            if (i < 1 || i > 6) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            if (Binder.getCallingUid() != Process.myUid()) {
                return false;
            }
            parcel.enforceInterface(RewardCapsuleProcessBridge.OWNER_DESCRIPTOR);
            RewardCapsuleProcessBridge.this.onOwnerTransaction(this.owner, i, parcel);
            return true;
        }
    }

    public final class OwnerRegistration {
        final OwnerCallback callback;
        final OwnerEndpoint endpoint;
        final String sessionId;
        final String token = UUID.randomUUID().toString();
        final int ownerPid = Process.myPid();
        final Map<Integer, IBinder> remoteEndpoints = new ConcurrentHashMap();
        volatile int selectedPid = -1;
        volatile String latestPayload = "";

        public OwnerRegistration(String str, OwnerCallback ownerCallback) {
            this.sessionId = str;
            this.callback = ownerCallback;
            this.endpoint = RewardCapsuleProcessBridge.this.new OwnerEndpoint(this);
        }

        public boolean matches(String str, String str2) {
            return this.sessionId.equals(str) && this.token.equals(str2);
        }
    }

    public interface ParcelWriter {
        void write(Parcel parcel);
    }

    public final class RemoteEndpoint extends Binder {
        private final RemoteSession remote;

        public RemoteEndpoint(RemoteSession remoteSession) {
            this.remote = remoteSession;
            attachInterface(null, RewardCapsuleProcessBridge.REMOTE_DESCRIPTOR);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                if (parcel2 != null) {
                    parcel2.writeString(RewardCapsuleProcessBridge.REMOTE_DESCRIPTOR);
                }
                return true;
            }
            if (i < 1 || i > 5) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            if (Binder.getCallingUid() != Process.myUid()) {
                return false;
            }
            parcel.enforceInterface(RewardCapsuleProcessBridge.REMOTE_DESCRIPTOR);
            String string = parcel.readString();
            String string2 = parcel.readString();
            RemoteSession remoteSession = this.remote;
            if (remoteSession.matches(string, string2, remoteSession.ownerPid)) {
                Object obj = RewardCapsuleProcessBridge.this.remotes.get(this.remote.sessionId);
                RemoteSession remoteSession2 = this.remote;
                if (obj == remoteSession2) {
                    if (i == 1) {
                        remoteSession2.activate();
                    } else if (i == 2) {
                        remoteSession2.render(parcel.readString());
                    } else if (i == 3) {
                        remoteSession2.close();
                    } else if (i == 4) {
                        RewardCapsuleProcessBridge.this.stopRemoteSession(remoteSession2);
                    } else if (i == 5 && parcel.readInt() != Process.myPid()) {
                        RewardCapsuleProcessBridge.this.stopRemoteSession(this.remote);
                    }
                }
            }
            return true;
        }
    }

    public static final class RemoteEvent {
        final String remoteActivityName;
        final int remotePid;
        final String remoteProcessName;

        public RemoteEvent(int i, String str, String str2) {
            this.remotePid = i;
            this.remoteProcessName = RewardCapsuleProcessBridge.safe(str);
            this.remoteActivityName = RewardCapsuleProcessBridge.safe(str2);
        }
    }

    public final class RemoteSession implements RewardCapsuleHost.Callback {
        volatile boolean active;
        volatile boolean attached;
        final Context context;
        final RemoteEndpoint endpoint;
        final IBinder.DeathRecipient ownerDeathRecipient = new IBinder.DeathRecipient() { // from class: com.tapsdk.tapad.group.ads.RewardCapsuleProcessBridge$RemoteSession$$ExternalSyntheticLambda1
            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                this.f$0.m91lambda$new$1$comtapsdktapadgroupadsRewardCapsuleProcessBridge$RemoteSession();
            }
        };
        final IBinder ownerEndpoint;
        final int ownerPid;
        final String sessionId;
        volatile boolean stopped;
        final String token;

        public RemoteSession(Context context, String str, String str2, int i, IBinder iBinder) {
            this.context = context;
            this.sessionId = str;
            this.token = str2;
            this.ownerPid = i;
            this.ownerEndpoint = iBinder;
            this.endpoint = RewardCapsuleProcessBridge.this.new RemoteEndpoint(this);
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Throwable] */
        private void transactOwner(int i, RewardCapsuleHost.HostEvent hostEvent, boolean z, String str, IBinder iBinder) {
            if (this.stopped || this.ownerEndpoint == null) {
                return;
            }
            Parcel parcelObtain = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(RewardCapsuleProcessBridge.OWNER_DESCRIPTOR);
                parcelObtain.writeString(this.sessionId);
                parcelObtain.writeString(this.token);
                parcelObtain.writeInt(Process.myPid());
                parcelObtain.writeString(hostEvent == null ? AndroidDeviceFacts.processName(this.context) : hostEvent.processName);
                parcelObtain.writeString(hostEvent == null ? "" : hostEvent.activityName);
                if (i == 1 || i == 2) {
                    parcelObtain.writeStrongBinder(iBinder);
                }
                if (i == 6) {
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeString(RewardCapsuleProcessBridge.safe(str));
                }
                this.ownerEndpoint.transact(i, parcelObtain, null, 1);
                parcelObtain.recycle();
            } catch (Throwable th) {
                parcelObtain.recycle();
            }
        }

        public void activate() {
            if (this.stopped || this.active) {
                return;
            }
            this.active = true;
            RewardCapsuleHost.getInstance().start(this.context, this.sessionId, null, this);
        }

        public void announce() {
            try {
                this.ownerEndpoint.linkToDeath(this.ownerDeathRecipient, 0);
                transactOwner(1, null, false, "", this.endpoint);
            } catch (RemoteException e) {
                RewardCapsuleProcessBridge.this.stopRemoteSession(this);
            }
        }

        public void close() {
            RewardCapsuleHost.getInstance().close(this.context, this.sessionId);
        }

        /* JADX INFO: renamed from: lambda$new$0$com-tapsdk-tapad-group-ads-RewardCapsuleProcessBridge$RemoteSession, reason: not valid java name */
        /* synthetic */ void m90lambda$new$0$comtapsdktapadgroupadsRewardCapsuleProcessBridge$RemoteSession() {
            RewardCapsuleProcessBridge.this.stopRemoteSession(this);
        }

        /* JADX INFO: renamed from: lambda$new$1$com-tapsdk-tapad-group-ads-RewardCapsuleProcessBridge$RemoteSession, reason: not valid java name */
        /* synthetic */ void m91lambda$new$1$comtapsdktapadgroupadsRewardCapsuleProcessBridge$RemoteSession() {
            RewardCapsuleProcessBridge.this.main.post(new Runnable() { // from class: com.tapsdk.tapad.group.ads.RewardCapsuleProcessBridge$RemoteSession$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m90lambda$new$0$comtapsdktapadgroupadsRewardCapsuleProcessBridge$RemoteSession();
                }
            });
        }

        public boolean matches(String str, String str2, int i) {
            return this.sessionId.equals(str) && this.token.equals(str2) && this.ownerPid == i;
        }

        @Override // com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost.Callback
        public void onCloseResult(RewardCapsuleHost.HostEvent hostEvent, boolean z, String str) {
            transactOwner(6, hostEvent, z, str, null);
        }

        @Override // com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost.Callback
        public void onHostAttached(RewardCapsuleHost.HostEvent hostEvent) {
            this.attached = true;
            transactOwner(2, hostEvent, false, "", this.endpoint);
        }

        @Override // com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost.Callback
        public void onHostClick(RewardCapsuleHost.HostEvent hostEvent) {
            transactOwner(5, hostEvent, false, "", null);
        }

        @Override // com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost.Callback
        public void onHostPaused(RewardCapsuleHost.HostEvent hostEvent) {
            transactOwner(4, hostEvent, false, "", null);
        }

        @Override // com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost.Callback
        public void onHostResumed(RewardCapsuleHost.HostEvent hostEvent) {
            transactOwner(3, hostEvent, false, "", null);
        }

        public void render(String str) {
            try {
                RewardCapsuleHost.getInstance().render(this.context, this.sessionId, new JSONObject(RewardCapsuleProcessBridge.safe(str)));
            } catch (Throwable th) {
            }
        }

        public void stop() {
            if (this.stopped) {
                return;
            }
            this.stopped = true;
            try {
                this.ownerEndpoint.unlinkToDeath(this.ownerDeathRecipient, 0);
            } catch (Throwable th) {
            }
            RewardCapsuleHost.getInstance().stop(this.context, this.sessionId);
        }
    }

    private String action(Context context) {
        return context.getPackageName() + ACTION_SUFFIX;
    }

    public static RewardCapsuleProcessBridge getInstance() {
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBroadcast(Context context, Intent intent) {
        RemoteSession remoteSessionMatchingRemote;
        if (intent == null || !action(context).equals(intent.getAction())) {
            return;
        }
        String stringExtra = intent.getStringExtra(EXTRA_COMMAND);
        String stringExtra2 = intent.getStringExtra("session_id");
        String stringExtra3 = intent.getStringExtra(EXTRA_SESSION_TOKEN);
        int intExtra = intent.getIntExtra(EXTRA_OWNER_PID, -1);
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(stringExtra3) || intExtra <= 0 || intExtra == Process.myPid()) {
            return;
        }
        if ("start".equals(stringExtra)) {
            Bundle bundleExtra = intent.getBundleExtra(EXTRA_ENDPOINTS);
            IBinder binder = bundleExtra == null ? null : bundleExtra.getBinder(EXTRA_OWNER_ENDPOINT);
            if (binder != null) {
                startRemoteSession(context, stringExtra2, stringExtra3, intExtra, binder);
                return;
            }
            return;
        }
        if (!COMMAND_SELECT.equals(stringExtra)) {
            if (!COMMAND_STOP.equals(stringExtra) || (remoteSessionMatchingRemote = matchingRemote(stringExtra2, stringExtra3, intExtra)) == null) {
                return;
            }
            stopRemoteSession(remoteSessionMatchingRemote);
            return;
        }
        RemoteSession remoteSessionMatchingRemote2 = matchingRemote(stringExtra2, stringExtra3, intExtra);
        int intExtra2 = intent.getIntExtra(EXTRA_TARGET_PID, -1);
        if (remoteSessionMatchingRemote2 == null || intExtra2 == Process.myPid()) {
            return;
        }
        stopRemoteSession(remoteSessionMatchingRemote2);
    }

    private RemoteSession matchingRemote(String str, String str2, int i) {
        RemoteSession remoteSession = this.remotes.get(str);
        if (remoteSession == null || !remoteSession.matches(str, str2, i)) {
            return null;
        }
        return remoteSession;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOwnerTransaction(final OwnerRegistration ownerRegistration, final int i, Parcel parcel) {
        String string = parcel.readString();
        String string2 = parcel.readString();
        final int i2 = parcel.readInt();
        String string3 = parcel.readString();
        String string4 = parcel.readString();
        final IBinder strongBinder = (i == 1 || i == 2) ? parcel.readStrongBinder() : null;
        final boolean z = i == 6 && parcel.readInt() != 0;
        final String string5 = i == 6 ? parcel.readString() : "";
        if (!ownerRegistration.matches(string, string2) || i2 <= 0 || i2 == ownerRegistration.ownerPid) {
            return;
        }
        final RemoteEvent remoteEvent = new RemoteEvent(i2, string3, string4);
        this.main.post(new Runnable() { // from class: com.tapsdk.tapad.group.ads.RewardCapsuleProcessBridge$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m88lambda$onOwnerTransaction$1$comtapsdktapadgroupadsRewardCapsuleProcessBridge(ownerRegistration, i, strongBinder, i2, remoteEvent, z, string5);
            }
        });
    }

    private Intent ownerIntent(Context context, String str, OwnerRegistration ownerRegistration) {
        Intent intent = new Intent(action(context));
        intent.setPackage(context.getPackageName());
        intent.putExtra(EXTRA_COMMAND, str);
        intent.putExtra("session_id", ownerRegistration.sessionId);
        intent.putExtra(EXTRA_SESSION_TOKEN, ownerRegistration.token);
        intent.putExtra(EXTRA_OWNER_PID, ownerRegistration.ownerPid);
        return intent;
    }

    private Context resolveContext(Context context) {
        Context applicationContext = context == null ? null : context.getApplicationContext();
        return applicationContext == null ? AppContextHolder.get() : applicationContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String safe(String str) {
        return str == null ? "" : str;
    }

    private void send(Context context, Intent intent) {
        try {
            context.sendBroadcast(intent);
        } catch (Throwable th) {
        }
    }

    private void startRemoteSession(Context context, final String str, String str2, int i, IBinder iBinder) {
        Context contextResolveContext = resolveContext(context);
        if (contextResolveContext == null) {
            return;
        }
        RemoteSession remoteSession = this.remotes.get(str);
        if (remoteSession != null) {
            if (remoteSession.matches(str, str2, i)) {
                return;
            } else {
                stopRemoteSession(remoteSession);
            }
        }
        final RemoteSession remoteSession2 = new RemoteSession(contextResolveContext, str, str2, i, iBinder);
        this.remotes.put(str, remoteSession2);
        remoteSession2.announce();
        if (this.remotes.get(str) != remoteSession2) {
            return;
        }
        this.main.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.group.ads.RewardCapsuleProcessBridge$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m89lambda$startRemoteSession$0$comtapsdktapadgroupadsRewardCapsuleProcessBridge(str, remoteSession2);
            }
        }, 15000L);
        Process.myPid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRemoteSession(RemoteSession remoteSession) {
        if (remoteSession == null || !this.remotes.remove(remoteSession.sessionId, remoteSession)) {
            return;
        }
        remoteSession.stop();
    }

    private void transactRemote(OwnerRegistration ownerRegistration, IBinder iBinder, int i, ParcelWriter parcelWriter) {
        if (iBinder == null) {
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(REMOTE_DESCRIPTOR);
            parcelObtain.writeString(ownerRegistration.sessionId);
            parcelObtain.writeString(ownerRegistration.token);
            if (parcelWriter != null) {
                parcelWriter.write(parcelObtain);
            }
            iBinder.transact(i, parcelObtain, null, 1);
            parcelObtain.recycle();
        } catch (Throwable th) {
            parcelObtain.recycle();
        }
    }

    private void transactRender(OwnerRegistration ownerRegistration, IBinder iBinder, final String str) {
        transactRemote(ownerRegistration, iBinder, 2, new ParcelWriter() { // from class: com.tapsdk.tapad.group.ads.RewardCapsuleProcessBridge$$ExternalSyntheticLambda3
            @Override // com.tapsdk.tapad.group.ads.RewardCapsuleProcessBridge.ParcelWriter
            public final void write(Parcel parcel) {
                parcel.writeString(str);
            }
        });
    }

    private void transactSelect(OwnerRegistration ownerRegistration, IBinder iBinder, final int i) {
        transactRemote(ownerRegistration, iBinder, 5, new ParcelWriter() { // from class: com.tapsdk.tapad.group.ads.RewardCapsuleProcessBridge$$ExternalSyntheticLambda1
            @Override // com.tapsdk.tapad.group.ads.RewardCapsuleProcessBridge.ParcelWriter
            public final void write(Parcel parcel) {
                parcel.writeInt(i);
            }
        });
    }

    private void transactSimple(OwnerRegistration ownerRegistration, IBinder iBinder, int i) {
        transactRemote(ownerRegistration, iBinder, i, null);
    }

    public void closeRemote(Context context, String str) {
        OwnerRegistration ownerRegistration = this.owners.get(str);
        if (ownerRegistration == null) {
            return;
        }
        int i = ownerRegistration.selectedPid;
        for (Map.Entry<Integer, IBinder> entry : ownerRegistration.remoteEndpoints.entrySet()) {
            if (i <= 0 || entry.getKey().intValue() == i) {
                transactSimple(ownerRegistration, entry.getValue(), 3);
            }
        }
    }

    public void init(Context context) {
        Context contextResolveContext = resolveContext(context);
        if (contextResolveContext == null || this.registered.get()) {
            return;
        }
        synchronized (this) {
            if (this.registered.get()) {
                return;
            }
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.tapsdk.tapad.group.ads.RewardCapsuleProcessBridge.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    RewardCapsuleProcessBridge.this.handleBroadcast(context2, intent);
                }
            };
            try {
                IntentFilter intentFilter = new IntentFilter(action(contextResolveContext));
                if (Build.VERSION.SDK_INT >= 33) {
                    contextResolveContext.registerReceiver(broadcastReceiver, intentFilter, 4);
                } else {
                    contextResolveContext.registerReceiver(broadcastReceiver, intentFilter);
                }
                this.receiver = broadcastReceiver;
                this.registered.set(true);
                Process.myPid();
                AndroidDeviceFacts.processName(contextResolveContext);
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: renamed from: lambda$onOwnerTransaction$1$com-tapsdk-tapad-group-ads-RewardCapsuleProcessBridge, reason: not valid java name */
    /* synthetic */ void m88lambda$onOwnerTransaction$1$comtapsdktapadgroupadsRewardCapsuleProcessBridge(OwnerRegistration ownerRegistration, int i, IBinder iBinder, int i2, RemoteEvent remoteEvent, boolean z, String str) {
        if (this.owners.get(ownerRegistration.sessionId) != ownerRegistration) {
            return;
        }
        if (i == 1) {
            if (iBinder == null) {
                return;
            }
            ownerRegistration.remoteEndpoints.put(Integer.valueOf(i2), iBinder);
            if (ownerRegistration.selectedPid <= 0 || ownerRegistration.selectedPid == i2) {
                transactSimple(ownerRegistration, iBinder, 1);
                return;
            } else {
                transactSimple(ownerRegistration, iBinder, 4);
                return;
            }
        }
        if (i == 2) {
            if (iBinder == null) {
                return;
            }
            ownerRegistration.remoteEndpoints.put(Integer.valueOf(i2), iBinder);
            String str2 = remoteEvent.remoteProcessName;
            if (ownerRegistration.selectedPid > 0 && ownerRegistration.selectedPid != i2) {
                transactSimple(ownerRegistration, iBinder, 4);
                return;
            }
            if (!TextUtils.isEmpty(ownerRegistration.latestPayload)) {
                transactRender(ownerRegistration, iBinder, ownerRegistration.latestPayload);
            }
            ownerRegistration.callback.onRemoteHostAttached(remoteEvent);
            return;
        }
        if (ownerRegistration.selectedPid <= 0 || ownerRegistration.selectedPid == i2) {
            if (i == 3) {
                ownerRegistration.callback.onRemoteHostResumed(remoteEvent);
                return;
            }
            if (i == 4) {
                ownerRegistration.callback.onRemoteHostPaused(remoteEvent);
            } else if (i == 5) {
                ownerRegistration.callback.onRemoteHostClick(remoteEvent);
            } else if (i == 6) {
                ownerRegistration.callback.onRemoteCloseResult(remoteEvent, z, safe(str));
            }
        }
    }

    /* JADX INFO: renamed from: lambda$startRemoteSession$0$com-tapsdk-tapad-group-ads-RewardCapsuleProcessBridge, reason: not valid java name */
    /* synthetic */ void m89lambda$startRemoteSession$0$comtapsdktapadgroupadsRewardCapsuleProcessBridge(String str, RemoteSession remoteSession) {
        if (this.remotes.get(str) != remoteSession || remoteSession.attached) {
            return;
        }
        Process.myPid();
        stopRemoteSession(remoteSession);
    }

    public void registerOwner(String str, OwnerCallback ownerCallback) {
        if (TextUtils.isEmpty(str) || ownerCallback == null) {
            return;
        }
        this.owners.put(str, new OwnerRegistration(str, ownerCallback));
    }

    public void renderRemote(Context context, String str, JSONObject jSONObject) {
        OwnerRegistration ownerRegistration = this.owners.get(str);
        if (ownerRegistration == null) {
            return;
        }
        ownerRegistration.latestPayload = jSONObject == null ? "{}" : jSONObject.toString();
        int i = ownerRegistration.selectedPid;
        for (Map.Entry<Integer, IBinder> entry : ownerRegistration.remoteEndpoints.entrySet()) {
            if (i <= 0 || entry.getKey().intValue() == i) {
                transactRender(ownerRegistration, entry.getValue(), ownerRegistration.latestPayload);
            }
        }
    }

    public void selectHost(Context context, String str, int i) {
        Context contextResolveContext = resolveContext(context);
        OwnerRegistration ownerRegistration = this.owners.get(str);
        if (contextResolveContext == null || ownerRegistration == null || i <= 0) {
            return;
        }
        ownerRegistration.selectedPid = i;
        Iterator<Map.Entry<Integer, IBinder>> it = ownerRegistration.remoteEndpoints.entrySet().iterator();
        while (it.hasNext()) {
            transactSelect(ownerRegistration, it.next().getValue(), i);
        }
        Intent intentOwnerIntent = ownerIntent(contextResolveContext, COMMAND_SELECT, ownerRegistration);
        intentOwnerIntent.putExtra(EXTRA_TARGET_PID, i);
        send(contextResolveContext, intentOwnerIntent);
    }

    public void startRemote(Context context, String str) {
        Context contextResolveContext = resolveContext(context);
        OwnerRegistration ownerRegistration = this.owners.get(str);
        if (contextResolveContext == null || ownerRegistration == null || ownerRegistration.selectedPid == ownerRegistration.ownerPid) {
            return;
        }
        init(contextResolveContext);
        Intent intentOwnerIntent = ownerIntent(contextResolveContext, "start", ownerRegistration);
        Bundle bundle = new Bundle();
        bundle.putBinder(EXTRA_OWNER_ENDPOINT, ownerRegistration.endpoint);
        intentOwnerIntent.putExtra(EXTRA_ENDPOINTS, bundle);
        send(contextResolveContext, intentOwnerIntent);
    }

    public void stopRemote(Context context, String str) {
        Context contextResolveContext = resolveContext(context);
        OwnerRegistration ownerRegistration = this.owners.get(str);
        if (contextResolveContext == null || ownerRegistration == null) {
            return;
        }
        Iterator<IBinder> it = ownerRegistration.remoteEndpoints.values().iterator();
        while (it.hasNext()) {
            transactSimple(ownerRegistration, it.next(), 4);
        }
        send(contextResolveContext, ownerIntent(contextResolveContext, COMMAND_STOP, ownerRegistration));
    }

    public void unregisterOwner(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.owners.remove(str);
    }
}
