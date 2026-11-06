var __defProp = Object.defineProperty;
var __getOwnPropSymbols = Object.getOwnPropertySymbols;
var __hasOwnProp = Object.prototype.hasOwnProperty;
var __propIsEnum = Object.prototype.propertyIsEnumerable;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __spreadValues = (a, b) => {
  for (var prop in b || (b = {}))
    if (__hasOwnProp.call(b, prop))
      __defNormalProp(a, prop, b[prop]);
  if (__getOwnPropSymbols)
    for (var prop of __getOwnPropSymbols(b)) {
      if (__propIsEnum.call(b, prop))
        __defNormalProp(a, prop, b[prop]);
    }
  return a;
};
(function() {
  "use strict";
  const $ = (id) => document.getElementById(id), rain = $("homeRain");
  for (let i = 0; i < 6; i++) {
    const item = document.createElement("span");
    item.className = "home-drop";
    item.innerHTML = CottonTileArt[i * 7 % 10].svg;
    item.style.cssText = "--x:".concat([0, 90, 3, 91, 1, 89][i], "%;--s:").concat(23 + i % 3 * 4, "px;--d:").concat(24 + i * 3, "s;--delay:").concat(-i * 7.7, "s;--r:").concat(i * 17 % 30 - 15, "deg;--drift:").concat(i % 2 ? -15 : 15, "px");
    rain.append(item);
  }
  for (const index of [0, 2, 7]) {
    const art = document.createElement("span");
    art.className = "home-feature-item";
    art.innerHTML = CottonTileArt[index].svg;
    $("homeMergeArt").append(art);
  }
  $("bFree").addEventListener("click", () => YuzuLevels.start(-1));
  $("bVoiceOpen").addEventListener("click", () => {
    $("bSetOpen").click();
  });
  function rainSize() {
    rain.style.setProperty("--fall", $("menu").clientHeight + 110 + "px");
  }
  new ResizeObserver(rainSize).observe($("menu"));
  rainSize();
  const stats = $("stats");
  $("route").append(stats);
  $("bAgain").textContent = "↻";
  $("bAgain").setAttribute("aria-label", "重开");
  $("bAgain").title = "重新开始";
  const panel = $("set").querySelector(".panel"), title = panel.querySelector(".ttl"), done = $("bSetClose");
  title.textContent = "捏声音";
  title.classList.add("simple-volume-title");
  const more = document.createElement("details");
  more.className = "audio-more";
  const summary = document.createElement("summary");
  summary.textContent = "更多声音调节";
  more.append(summary);
  for (const child of [...panel.children]) if (child !== title && child !== done) more.append(child);
  const master = document.createElement("div");
  master.className = "master-volume-row";
  master.innerHTML = '<label for="setMasterVolume"><span>总音量</span><output id="setMasterValue">80%</output></label><input id="setMasterVolume" type="range" min="0" max="100" value="80" aria-label="设置总音量">';
  panel.insertBefore(master, done);
  panel.insertBefore(more, done);
  for (const id of ["homeMasterVolume", "setMasterVolume"]) $(id).addEventListener("input", function() {
    CottonMusic.setMasterVolume(this.value / 100);
  });
  function sync() {
    const n = Math.round(CottonMusic.getStatus().master * 100);
    for (const id of ["homeMasterVolume", "setMasterVolume"]) $(id).value = n;
    for (const id of ["homeMasterValue", "setMasterValue"]) $(id).textContent = n + "%";
    $("homeVolumeLabel").textContent = n ? "音量" : "静音";
  }
  window.addEventListener("cotton-volume", sync);
  sync();
  more.insertBefore(master, summary.nextSibling);
  const controls = [
    ["voicePitch", "pitch", "音高", -12, 12, 0.5, 1, "低一点", "高一点"],
    ["voiceSize", "size", "声线大小", 65, 160, 1, 100, "厚一点", "幼一点"],
    ["voiceSoft", "softness", "柔和度", 0, 100, 1, 100, "清亮", "软糯"],
    ["voiceBright", "brightness", "明亮度", 0, 100, 1, 100, "温暖", "通透"],
    ["voiceBreath", "breath", "气声", 0, 100, 1, 100, "干净", "轻轻呼气"],
    ["voiceVibrato", "vibrato", "颤音", 0, 100, 1, 100, "平稳", "摇曳"],
    ["voiceGlide", "glide", "滑音", 0, 100, 1, 100, "利落", "连绵"],
    ["voiceEcho", "echo", "回声", 0, 100, 1, 100, "贴近", "空灵"]
  ];
  function voiceRow(c) {
    return '<label class="voice-row"><span>'.concat(c[2], '</span><output id="').concat(c[0], 'Value"></output><input id="').concat(c[0], '" type="range" min="').concat(c[3], '" max="').concat(c[4], '" step="').concat(c[5], '" aria-label="').concat(c[2], '"><small>').concat(c[7], "<span>").concat(c[8], "</span></small></label>");
  }
  const editor = document.createElement("section");
  editor.className = "voice-editor";
  editor.setAttribute("aria-label", "声音塑形");
  editor.innerHTML = '<p class="voice-note">调一调，松手试听；会自动记住你的声线</p><div class="voice-presets"><button type="button" data-voice="soft">软糯</button><button type="button" data-voice="bright">元气</button><button type="button" data-voice="tiny">奶声</button></div>' + controls.slice(0, 3).map(voiceRow).join("") + '<details class="voice-extra"><summary>更多捏声 · 5 项</summary>' + controls.slice(3).map(voiceRow).join("") + '</details><div class="voice-preview"><button type="button" id="voicePreview">试听一下</button><button type="button" id="voiceReset">恢复原声</button></div>';
  panel.insertBefore(editor, more);
  const defaults = CottonSynth.voiceDefaults;
  const voices = { soft: { pitch: -3, size: 0.87, softness: 0.95, brightness: 0.26, breath: 0.36, vibrato: 0.3, glide: 0.82, echo: 0.16 }, bright: { pitch: 1, size: 1.04, softness: 0.3, brightness: 0.75, breath: 0.03, vibrato: 0.08, glide: 0.12, echo: 0.12 }, tiny: { pitch: 4, size: 1.38, softness: 0.8, brightness: 0.58, breath: 0.14, vibrato: 0.14, glide: 0.4, echo: 0.2 } };
  const voiceDescriptions = { soft: "软糯 · 温暖偏低，带一点气声和连绵的尾音", bright: "元气 · 清楚利落，咬字轻快有弹性", tiny: "奶声 · 小小的幼声，圆润轻巧的啦啦啦" };
  for (const b of editor.querySelectorAll("[data-voice]")) b.title = voiceDescriptions[b.dataset.voice];
  function syncVoice() {
    const v = CottonMusic.getStatus().voice;
    for (const c of controls) {
      const n = Math.round(v[c[1]] * c[6] * 10) / 10;
      $(c[0]).value = n;
      $(c[0] + "Value").textContent = c[1] === "pitch" ? (n > 0 ? "+" : "") + n + " 半音" : n + "%";
    }
    for (const b of editor.querySelectorAll("[data-voice]")) {
      const p = voices[b.dataset.voice];
      b.setAttribute("aria-pressed", String(Object.keys(defaults).every((k) => Math.abs(p[k] - v[k]) < 1e-3)));
    }
  }
  for (const [id, key, label, min, max, step, scale] of controls) {
    $(id).addEventListener("input", function() {
      CottonMusic.setVoiceShape({ [key]: Number(this.value) / scale });
    });
    $(id).addEventListener("change", () => CottonMusic.previewVoice());
  }
  for (const b of editor.querySelectorAll("[data-voice]")) b.addEventListener("click", () => {
    CottonMusic.setVoiceShape(voices[b.dataset.voice]);
    editor.querySelector(".voice-note").textContent = voiceDescriptions[b.dataset.voice];
    CottonMusic.previewVoice();
  });
  $("voicePreview").onclick = () => CottonMusic.previewVoice();
  $("voiceReset").onclick = () => {
    CottonMusic.setVoiceShape(defaults);
    CottonMusic.previewVoice();
  };
  window.addEventListener("cotton-voice-shape", syncVoice);
  syncVoice();
  window.CottonHome = Object.freeze({ getStatus: () => ({ title: document.title, fallingItems: rain.children.length, master: CottonMusic.getStatus().master, characterText: false }) });
  const reduced = matchMedia("(prefers-reduced-motion: reduce)"), motions = /* @__PURE__ */ new WeakMap();
  let presses = 0, entries = 0, rebounds = 0;
  function tween(el, frames, settings = {}) {
    if (reduced.matches) return;
    const old = motions.get(el);
    if (old) old.cancel();
    const animation = el.animate(frames, __spreadValues({ duration: 260, easing: "cubic-bezier(.22,.8,.25,1)" }, settings));
    motions.set(el, animation);
    animation.onfinish = () => {
      if (settings.fill !== "forwards" && motions.get(el) === animation) motions.delete(el);
    };
  }
  for (const el of document.querySelectorAll("#bStart,#bFree,#bWear,#bVoiceOpen,.subtle-button,#bSetClose,#bVocalDemo,#bFeedDemo,#bExportMusic,.wardrobe-done,.voice-editor button")) {
    const angle = () => Math.min(2.1, 220 / Math.max(80, el.getBoundingClientRect().width));
    const hover = () => tween(el, [{ transform: "scale(1)" }, { transform: "scale(1.055) rotate(".concat(-angle(), "deg)") }], { duration: 170, fill: "forwards" });
    const rest = () => tween(el, [{ transform: getComputedStyle(el).transform }, { transform: "scale(1) rotate(0deg)" }], { duration: 220 });
    el.addEventListener("pointerenter", (e) => {
      if (e.pointerType !== "touch") hover();
    });
    el.addEventListener("focus", hover);
    el.addEventListener("pointerleave", rest);
    el.addEventListener("blur", rest);
    el.addEventListener("pointerdown", () => {
      presses++;
      el.dataset.uiPress = String(presses);
      tween(el, [{ transform: getComputedStyle(el).transform }, { transform: "scale(.91) rotate(0deg)" }], { duration: 80, fill: "forwards" });
    });
    el.addEventListener("pointerup", () => {
      rebounds++;
      tween(el, [{ transform: "scale(.91)" }, { transform: "scale(1.075)", offset: 0.42 }, { transform: "scale(.98)", offset: 0.72 }, { transform: "scale(1)" }], { duration: 180 });
    });
    el.addEventListener("pointercancel", rest);
  }
  function enter() {
    if (!$("menu").classList.contains("on")) return;
    entries++;
    for (const [i, el] of [...document.querySelectorAll(".home-top,.home-eyebrow,.home-copy h1,.home-description,.home-stage-wrap,.home-actions,.home-foot")].entries()) tween(el, [{ opacity: 0.65, transform: "translateY(6px)" }, { opacity: 1, transform: "translateY(0)" }], { duration: 220, delay: i * 10 });
  }
  let atHome = document.body.classList.contains("in-home");
  new MutationObserver(() => {
    const next = document.body.classList.contains("in-home");
    if (next && !atHome) enter();
    atHome = next;
  }).observe(document.body, { attributes: true, attributeFilter: ["class"] });
  document.fonts.ready.then(enter);
  new MutationObserver(() => {
    if ($("set").classList.contains("on")) {
      tween(panel, [{ opacity: 0, transform: "translateY(8px) scale(.985)" }, { opacity: 1, transform: "translateY(0) scale(1)" }], { duration: 280 });
      for (const [i, el] of [...editor.children].entries()) tween(el, [{ opacity: 0, transform: "translateY(5px)" }, { opacity: 1, transform: "translateY(0)" }], { duration: 240, delay: i * 30 });
    }
  }).observe($("set"), { attributes: true, attributeFilter: ["class"] });
  for (const el of document.querySelectorAll("#homeBest,#homeMasterValue,#setMasterValue,#startLabel")) {
    let text = el.textContent;
    new MutationObserver(() => {
      if (text === el.textContent) return;
      text = el.textContent;
      tween(el, [{ transform: "scale(1)" }, { transform: "scale(1.07)", offset: 0.38 }, { transform: "scale(1)" }], { duration: 250 });
    }).observe(el, { childList: true, characterData: true, subtree: true });
  }
  window.CottonUI = Object.freeze({ getStatus: () => ({ presses, entries, rebounds, reducedMotion: reduced.matches, kind: "dimension-aware spring and stagger" }) });
})();
