package com.tapsdk.tapad.internal.runtime.web;

import android.support.v4.app.NotificationCompat;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.c;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class DirichletCreativeWebBridge {
    public static final String BRIDGE_VERSION = "web-creative-bridge/v1";
    private static final long EVENT_WINDOW_MS = 60000;
    public static final String JS_INTERFACE_NAME = "DirichletCreativeHost";
    private static final int MAX_EVENTS_PER_WINDOW = 240;
    private static final int MAX_MESSAGE_BYTES = 16384;
    private static final int MAX_PAYLOAD_BYTES = 4096;
    private static final Set<String> MEDIA_EVENTS = Collections.unmodifiableSet(new HashSet(Arrays.asList("loadedmetadata", "play", "playing", "pause", "ended", "error", "quartile")));
    private final Set<String> allowedActions;
    private final Set<String> allowedEvents;
    private volatile boolean attached;
    private final JSONObject context;
    private final String creativeKey;
    private int eventCount;
    private long eventWindowStartedAt = System.currentTimeMillis();
    private final int instanceId;
    private final Listener listener;
    private final String nonce;
    private final String packageHash;
    private final DirichletRuntime runtime;
    private final String sessionId;
    private final int surfaceId;
    private volatile WebView webView;

    public static final class BridgeException extends Exception {
        final String code;

        public BridgeException(String str, String str2) {
            super(str2);
            this.code = str;
        }
    }

    public interface Listener {
        void onAccepted(JSONObject jSONObject);

        void onRejected(String str, String str2);
    }

    public DirichletCreativeWebBridge(DirichletRuntime dirichletRuntime, int i, int i2, JSONObject jSONObject, Set<String> set, Set<String> set2, Listener listener) {
        this.runtime = dirichletRuntime;
        this.instanceId = i;
        this.surfaceId = i2;
        JSONObject jSONObjectCopyObject = copyObject(jSONObject);
        this.context = jSONObjectCopyObject;
        String strOptString = jSONObjectCopyObject.optString("nonce", "");
        this.nonce = strOptString;
        String strOptString2 = jSONObjectCopyObject.optString("session_id", "");
        this.sessionId = strOptString2;
        String strOptString3 = jSONObjectCopyObject.optString("creative_key", "");
        this.creativeKey = strOptString3;
        this.packageHash = jSONObjectCopyObject.optString("package_hash", "");
        this.allowedEvents = immutableStrings(set, jSONObjectCopyObject.optJSONArray("allowed_events"));
        this.allowedActions = immutableStrings(set2, jSONObjectCopyObject.optJSONArray("allowed_actions"));
        this.listener = listener;
        if (!BRIDGE_VERSION.equals(jSONObjectCopyObject.optString("bridge_version", BRIDGE_VERSION))) {
            throw new IllegalArgumentException("unsupported bridge_version");
        }
        if (strOptString.length() == 0 || strOptString2.length() == 0 || strOptString3.length() == 0) {
            throw new IllegalArgumentException("creative bridge context is missing session identity");
        }
    }

    private static String bridgeJson(String str) {
        return str.replace("<", "\\u003c").replace("\u2028", "\\u2028").replace("\u2029", "\\u2029");
    }

    private void checkRateLimit() throws BridgeException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.eventWindowStartedAt >= EVENT_WINDOW_MS) {
            this.eventWindowStartedAt = jCurrentTimeMillis;
            this.eventCount = 0;
        }
        int i = this.eventCount + 1;
        this.eventCount = i;
        if (i > 240) {
            throw new BridgeException("BRIDGE_RATE_LIMITED", "too many creative bridge messages");
        }
    }

    private static void copyFiniteNumber(JSONObject jSONObject, JSONObject jSONObject2, String str) throws JSONException {
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return;
        }
        Object objOpt = jSONObject.opt(str);
        if (objOpt instanceof Number) {
            double dDoubleValue = ((Number) objOpt).doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                return;
            }
            jSONObject2.put(str, Math.max(0.0d, dDoubleValue));
        }
    }

    private static JSONObject copyObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        try {
            return new JSONObject(jSONObject.toString());
        } catch (JSONException e) {
            throw new IllegalArgumentException("invalid creative context", e);
        }
    }

    private static Set<String> immutableStrings(Set<String> set, JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (set != null) {
            hashSet.addAll(set);
        }
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String strOptString = jSONArray.optString(i, null);
                if (strOptString != null && strOptString.length() > 0) {
                    hashSet.add(strOptString);
                }
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00db  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:43:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:49:0x010e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0114  */
    /* JADX WARN: Code duplicated, block: B:67:0x0175  */
    /* JADX WARN: Code duplicated, block: B:70:0x0186  */
    /* JADX WARN: Code duplicated, block: B:71:0x018b  */
    /* JADX WARN: Code duplicated, block: B:74:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:76:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:79:0x01b7  */
    private JSONObject normalize(JSONObject jSONObject) throws JSONException, BridgeException {
        String str;
        String str2;
        String strNullableString;
        String strNullableString2;
        JSONObject jSONObject2;
        String strOptString;
        String strNullableString3;
        checkRateLimit();
        if (!BRIDGE_VERSION.equals(jSONObject.optString("bridge_version", ""))) {
            throw new BridgeException("BRIDGE_VERSION_UNSUPPORTED", "bridge_version");
        }
        if (!this.nonce.equals(jSONObject.optString("nonce", ""))) {
            throw new BridgeException("BRIDGE_NONCE_INVALID", "nonce does not match the session");
        }
        if (!this.sessionId.equals(jSONObject.optString("session_id", ""))) {
            throw new BridgeException("BRIDGE_SESSION_INVALID", "session_id does not match the session");
        }
        if (!this.creativeKey.equals(jSONObject.optString("creative_key", ""))) {
            throw new BridgeException("BRIDGE_CREATIVE_KEY_MISMATCH", "creative_key does not match the package");
        }
        String strNullableString4 = nullableString(jSONObject, "package_hash", 128);
        if (this.packageHash.length() > 0 && !this.packageHash.equals(strNullableString4)) {
            throw new BridgeException("BRIDGE_PACKAGE_HASH_MISMATCH", "package_hash does not match the verified package");
        }
        String strOptString2 = jSONObject.optString("type", "");
        if (!Arrays.asList("creative.ready", "creative.event", "creative.action_request", "creative.media").contains(strOptString2)) {
            throw new BridgeException("BRIDGE_TYPE_UNSUPPORTED", "unsupported message type");
        }
        Object objOpt = jSONObject.opt("payload");
        if (objOpt != null) {
            str2 = "payload";
            if (objOpt != JSONObject.NULL) {
                str = strNullableString4;
                if (objOpt.toString().getBytes(StandardCharsets.UTF_8).length > 4096) {
                    throw new BridgeException("BRIDGE_PAYLOAD_TOO_LARGE", "payload exceeds 4KB");
                }
                JSONObject jSONObject3 = objOpt instanceof JSONObject ? (JSONObject) objOpt : null;
                strNullableString = nullableString(jSONObject, NotificationCompat.CATEGORY_EVENT, 64);
                strNullableString2 = nullableString(jSONObject, "action", 32);
                if ("creative.event".equals(strOptString2)) {
                    if (strNullableString != null || !this.allowedEvents.contains(strNullableString)) {
                        throw new BridgeException("BRIDGE_EVENT_NOT_ALLOWED", "event is not declared by telemetry intent");
                    }
                    validateTelemetryPayload(strNullableString, jSONObject3);
                } else if ("creative.action_request".equals(strOptString2)) {
                    if (strNullableString2 != null || !this.allowedActions.contains(strNullableString2)) {
                        throw new BridgeException("BRIDGE_ACTION_NOT_ALLOWED", "action is not allowed by host policy");
                    }
                } else if ("creative.media".equals(strOptString2)) {
                    if (strNullableString != null || !MEDIA_EVENTS.contains(strNullableString)) {
                        throw new BridgeException("BRIDGE_MEDIA_EVENT_UNSUPPORTED", "unsupported media event");
                    }
                    if (jSONObject.has("quartile") && !jSONObject.isNull("quartile") && !Arrays.asList("25", "50", "75").contains(jSONObject.optString("quartile", ""))) {
                        throw new BridgeException("BRIDGE_QUARTILE_INVALID", "quartile must be 25, 50 or 75");
                    }
                }
                jSONObject2 = new JSONObject();
                jSONObject2.put("type", strOptString2);
                jSONObject2.put("bridge_version", BRIDGE_VERSION);
                jSONObject2.put("nonce", this.nonce);
                jSONObject2.put("session_id", this.sessionId);
                jSONObject2.put("creative_key", this.creativeKey);
                if (str != null) {
                    jSONObject2.put("package_hash", str);
                }
                if (nullableString(jSONObject, "event_id", 96) != null) {
                    strOptString = jSONObject.optString("event_id");
                } else {
                    strOptString = "evt-" + UUID.randomUUID();
                }
                jSONObject2.put("event_id", strOptString);
                if (strNullableString != null) {
                    jSONObject2.put(NotificationCompat.CATEGORY_EVENT, strNullableString);
                }
                if (strNullableString2 != null) {
                    jSONObject2.put("action", strNullableString2);
                }
                strNullableString3 = nullableString(jSONObject, "node_id", 96);
                if (strNullableString3 != null) {
                    jSONObject2.put("node_id", strNullableString3);
                }
                if (objOpt != null && objOpt != JSONObject.NULL) {
                    jSONObject2.put(str2, objOpt);
                }
                copyFiniteNumber(jSONObject, jSONObject2, "current_time");
                copyFiniteNumber(jSONObject, jSONObject2, "duration");
                if (jSONObject.has("quartile") && !jSONObject.isNull("quartile")) {
                    jSONObject2.put("quartile", jSONObject.optString("quartile"));
                }
                return jSONObject2;
            }
            str = strNullableString4;
        } else {
            str = strNullableString4;
            str2 = "payload";
        }
        strNullableString = nullableString(jSONObject, NotificationCompat.CATEGORY_EVENT, 64);
        strNullableString2 = nullableString(jSONObject, "action", 32);
        if ("creative.event".equals(strOptString2)) {
            if (strNullableString != null) {
            }
            throw new BridgeException("BRIDGE_EVENT_NOT_ALLOWED", "event is not declared by telemetry intent");
        }
        if ("creative.action_request".equals(strOptString2)) {
            if (strNullableString2 != null) {
            }
            throw new BridgeException("BRIDGE_ACTION_NOT_ALLOWED", "action is not allowed by host policy");
        }
        if ("creative.media".equals(strOptString2)) {
            if (strNullableString != null) {
            }
            throw new BridgeException("BRIDGE_MEDIA_EVENT_UNSUPPORTED", "unsupported media event");
        }
        jSONObject2 = new JSONObject();
        jSONObject2.put("type", strOptString2);
        jSONObject2.put("bridge_version", BRIDGE_VERSION);
        jSONObject2.put("nonce", this.nonce);
        jSONObject2.put("session_id", this.sessionId);
        jSONObject2.put("creative_key", this.creativeKey);
        if (str != null) {
            jSONObject2.put("package_hash", str);
        }
        if (nullableString(jSONObject, "event_id", 96) != null) {
            strOptString = jSONObject.optString("event_id");
        } else {
            strOptString = "evt-" + UUID.randomUUID();
        }
        jSONObject2.put("event_id", strOptString);
        if (strNullableString != null) {
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, strNullableString);
        }
        if (strNullableString2 != null) {
            jSONObject2.put("action", strNullableString2);
        }
        strNullableString3 = nullableString(jSONObject, "node_id", 96);
        if (strNullableString3 != null) {
            jSONObject2.put("node_id", strNullableString3);
        }
        if (objOpt != null) {
            jSONObject2.put(str2, objOpt);
        }
        copyFiniteNumber(jSONObject, jSONObject2, "current_time");
        copyFiniteNumber(jSONObject, jSONObject2, "duration");
        if (jSONObject.has("quartile")) {
            jSONObject2.put("quartile", jSONObject.optString("quartile"));
        }
        return jSONObject2;
    }

    private static String nullableString(JSONObject jSONObject, String str, int i) throws BridgeException {
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        String strOptString = jSONObject.optString(str, null);
        if (strOptString == null || strOptString.length() == 0 || strOptString.length() > i) {
            throw new BridgeException("BRIDGE_" + str.toUpperCase() + "_INVALID", str.concat(" is invalid"));
        }
        return strOptString;
    }

    private void reject(String str, String str2) {
        Listener listener = this.listener;
        if (listener != null) {
            if (str2 == null) {
                str2 = "";
            }
            listener.onRejected(str, str2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00cb  */
    private void validateTelemetryPayload(String str, JSONObject jSONObject) throws BridgeException {
        JSONObject jSONObjectOptJSONObject = this.context.optJSONObject("telemetry_schema");
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject2.length() == 0) {
            return;
        }
        if (jSONObject == null) {
            throw new BridgeException("BRIDGE_PAYLOAD_OBJECT_REQUIRED", "event payload must be an object");
        }
        Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(next);
            if (jSONObjectOptJSONObject3 != null) {
                boolean z = false;
                if (jSONObjectOptJSONObject3.optBoolean("required", false) && (!jSONObject.has(next) || jSONObject.isNull(next))) {
                    throw new BridgeException(c.a("BRIDGE_PROPERTY_REQUIRED:", next), "required telemetry property missing");
                }
                if (jSONObject.has(next)) {
                    Object objOpt = jSONObject.opt(next);
                    String strOptString = jSONObjectOptJSONObject3.optString("type", "");
                    if (objOpt == null || objOpt == JSONObject.NULL) {
                        throw new BridgeException(c.a("BRIDGE_PROPERTY_TYPE_INVALID:", next), "telemetry property type mismatch");
                    }
                    if ("string".equals(strOptString)) {
                        z = objOpt instanceof String;
                    } else if ("integer".equals(strOptString)) {
                        if (objOpt instanceof Number) {
                            Number number = (Number) objOpt;
                            if (Math.rint(number.doubleValue()) == number.doubleValue()) {
                                z = true;
                            }
                        }
                    } else if ("number".equals(strOptString)) {
                        z = objOpt instanceof Number;
                    } else if ("boolean".equals(strOptString)) {
                        z = objOpt instanceof Boolean;
                    } else if ("array".equals(strOptString)) {
                        z = objOpt instanceof JSONArray;
                    } else if ("object".equals(strOptString) && (objOpt instanceof JSONObject)) {
                        z = true;
                    }
                    if (!z) {
                        throw new BridgeException(c.a("BRIDGE_PROPERTY_TYPE_INVALID:", next), "telemetry property type mismatch");
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public void attach(WebView webView) {
        if (webView == null) {
            throw new IllegalArgumentException("view == null");
        }
        WebView webView2 = this.webView;
        if (webView2 != null && webView2 != webView) {
            webView2.removeJavascriptInterface(JS_INTERFACE_NAME);
        }
        this.webView = webView;
        this.attached = true;
        this.eventWindowStartedAt = System.currentTimeMillis();
        this.eventCount = 0;
        webView.addJavascriptInterface(this, JS_INTERFACE_NAME);
    }

    public String bootstrapScript() {
        return "(function(ctx){'use strict';var TYPE='web-creative-bridge/v1';if(window.DirichletCreative&&window.DirichletCreative.version===TYPE)return;var host=window.DirichletCreativeHost,listeners=[],ready=false,events=Array.isArray(ctx.allowed_events)?ctx.allowed_events:[],actions=Array.isArray(ctx.allowed_actions)?ctx.allowed_actions:[];function id(){return 'evt-'+Date.now()+'-'+Math.random().toString(16).slice(2)};function payload(v){if(v===undefined)return undefined;try{if(JSON.stringify(v).length>4096)return {bridge_error:'payload_too_large'};return v}catch(e){return {bridge_error:'payload_not_serializable'}}}function post(type,extra){var m=Object.assign({type:type,bridge_version:TYPE,nonce:ctx.nonce,session_id:ctx.session_id,creative_key:ctx.creative_key,package_hash:ctx.package_hash||undefined,event_id:id()},extra||{});host.postMessage(JSON.stringify(m));return m.event_id;}var api={version:TYPE,context:Object.freeze(ctx),ready:function(){if(!ready){ready=true;post('creative.ready',{package_hash:ctx.package_hash||null})}return Promise.resolve(ctx)},track:function(e,p,n){if(events.indexOf(e)<0)throw Error('creative event is not allowed: '+e);return post('creative.event',{event:e,payload:payload(p),node_id:n||undefined})},requestAction:function(a,p,n){if(actions.indexOf(a)<0)throw Error('creative action is not allowed: '+a);return post('creative.action_request',{action:a,payload:payload(p),node_id:n||undefined})},media:function(e,d){d=d||{};return post('creative.media',{event:e,node_id:d.node_id||d.nodeId||undefined,current_time:Number(d.current_time||d.currentTime||0),duration:Number(d.duration||0),quartile:d.quartile==null?undefined:String(d.quartile)})},onHostResult:function(cb){if(typeof cb==='function')listeners.push(cb);return function(){var i=listeners.indexOf(cb);if(i>=0)listeners.splice(i,1)}}};window.DirichletCreative=api;window.addEventListener('message',function(e){var m=e.data;if(e.source!==window||!m||m.type!=='creative.host_result'||m.nonce!==ctx.nonce)return;listeners.slice().forEach(function(cb){try{cb(m)}catch(_){}})});function bind(v,i){if(typeof window.__dirichletWebMediaMuted!=='boolean')window.__dirichletWebMediaMuted=!!ctx.media_muted;v.muted=window.__dirichletWebMediaMuted;if(v.dataset.creativeBridgeBound)return;v.dataset.creativeBridgeBound='1';var real=ctx.ad&&ctx.ad.video&&ctx.ad.video.source==='ad.video'?ctx.ad.video.url:'',id=v.dataset.creativeVideo||v.id||'video-'+i,seen={};function emit(e,q){api.media(e,{node_id:id,current_time:Number(v.currentTime||0),duration:Number(v.duration||0),quartile:q||null})}['loadedmetadata','play','playing','pause','ended','error'].forEach(function(e){v.addEventListener(e,function(){emit(e)})});v.addEventListener('timeupdate',function(){var d=Number(v.duration||0),p=d?Number(v.currentTime||0)/d:0;[[.25,'25'],[.5,'50'],[.75,'75']].forEach(function(x){if(p>=x[0]&&!seen[x[1]]){seen[x[1]]=1;emit('quartile',x[1])}})});if(real&&(i===0||v.dataset.creativeSource==='ad.video')){v.pause();v.removeAttribute('src');while(v.firstChild&&v.firstChild.tagName==='SOURCE')v.removeChild(v.firstChild);if(/\\.m3u8(?:$|[?#])/i.test(real)||/[?&]format=m3u8(?:&|$)/i.test(real))v.setAttribute('data-dirichlet-hls-src',real);else{var t=setTimeout(function(){v.dataset.dirichletMediaError='REAL_MEDIA_FIRST_FRAME_TIMEOUT';console.error('[DirichletCreative] '+v.dataset.dirichletMediaError);v.dispatchEvent(new Event('error'))},15000);function clear(){if(t){clearTimeout(t);t=0}}v.addEventListener('playing',clear,{once:true});v.addEventListener('error',clear,{once:true});v.addEventListener('loadedmetadata',function(){var p=v.play();if(p&&p.catch)p.catch(function(e){v.dataset.dirichletMediaError='REAL_MEDIA_PLAY_REJECTED:'+(e&&e.name||'unknown');console.error('[DirichletCreative] '+v.dataset.dirichletMediaError);v.dispatchEvent(new Event('error'))})},{once:true});v.src=real;}}}function media(){Array.prototype.forEach.call(document.querySelectorAll('video'),bind);if(window.MutationObserver){new MutationObserver(function(){Array.prototype.forEach.call(document.querySelectorAll('video'),bind)}).observe(document.documentElement||document,{childList:true,subtree:true})}}function boot(){api.ready();media()}if(document.readyState==='loading')document.addEventListener('DOMContentLoaded',boot);else setTimeout(boot,0);})(" + bridgeJson(this.context.toString()) + ");";
    }

    public void detach() {
        WebView webView = this.webView;
        this.attached = false;
        this.webView = null;
        if (webView != null) {
            webView.removeJavascriptInterface(JS_INTERFACE_NAME);
        }
    }

    /* JADX INFO: renamed from: lambda$onPageFinished$0$com-tapsdk-tapad-internal-runtime-web-DirichletCreativeWebBridge, reason: not valid java name */
    /* synthetic */ void m344lambda$onPageFinished$0$comtapsdktapadinternalruntimewebDirichletCreativeWebBridge(WebView webView) {
        webView.evaluateJavascript(bootstrapScript(), null);
    }

    public void onPageFinished() {
        final WebView webView = this.webView;
        if (webView == null) {
            return;
        }
        webView.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.web.DirichletCreativeWebBridge$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m344lambda$onPageFinished$0$comtapsdktapadinternalruntimewebDirichletCreativeWebBridge(webView);
            }
        });
    }

    @JavascriptInterface
    public void postMessage(String str) {
        Listener listener;
        if (!this.attached) {
            reject("BRIDGE_SESSION_DETACHED", "creative bridge is no longer attached");
            return;
        }
        if (str == null) {
            reject("BRIDGE_MESSAGE_NOT_OBJECT", "message is null");
            return;
        }
        if (str.getBytes(StandardCharsets.UTF_8).length > 16384) {
            reject("BRIDGE_MESSAGE_TOO_LARGE", "message exceeds 16KB");
            return;
        }
        try {
            JSONObject jSONObjectNormalize = normalize(new JSONObject(str));
            String strOptString = jSONObjectNormalize.optString("type", "");
            DirichletRuntime dirichletRuntime = this.runtime;
            boolean z = dirichletRuntime != null && dirichletRuntime.dispatchCreativeWebEvent(this.instanceId, this.surfaceId, jSONObjectNormalize.toString());
            if (z && (listener = this.listener) != null) {
                listener.onAccepted(jSONObjectNormalize);
            }
            if ("creative.action_request".equals(strOptString)) {
                sendHostResult(jSONObjectNormalize.optString("event_id", ""), jSONObjectNormalize.optString("action", ""), z, z ? "sdk_dispatched" : "runtime_unavailable");
            }
        } catch (BridgeException e) {
            reject(e.code, e.getMessage());
        } catch (JSONException e2) {
            reject("BRIDGE_JSON_INVALID", e2.getMessage());
        } catch (Throwable th) {
            reject("BRIDGE_HOST_FAILURE", th.getClass().getSimpleName());
        }
    }

    public void sendHostResult(String str, String str2, boolean z, String str3) {
        final WebView webView = this.webView;
        if (webView == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "creative.host_result");
            jSONObject.put("bridge_version", BRIDGE_VERSION);
            jSONObject.put("nonce", this.nonce);
            jSONObject.put("session_id", this.sessionId);
            jSONObject.put("creative_key", this.creativeKey);
            Object obj = str;
            if (str == null) {
                obj = JSONObject.NULL;
            }
            jSONObject.put("event_id", obj);
            Object obj2 = str2;
            if (str2 == null) {
                obj2 = JSONObject.NULL;
            }
            jSONObject.put("action", obj2);
            jSONObject.put("accepted", z);
            if (str3 == null) {
                str3 = "unknown";
            }
            jSONObject.put(MediationConstant.KEY_REASON, str3);
            final String str4 = "window.postMessage(" + bridgeJson(jSONObject.toString()) + ", '*');";
            webView.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.web.DirichletCreativeWebBridge$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    webView.evaluateJavascript(str4, null);
                }
            });
        } catch (JSONException e) {
        }
    }
}
