(function() {
  "use strict";
  let queued = 0, point = null;
  function send(x, y) {
    var _a, _b;
    (_b = (_a = document.getElementById("cottonFrame")) == null ? void 0 : _a.contentWindow) == null ? void 0 : _b.postMessage({ channel: "cotton-theatre-parent", type: "home-gaze", payload: { x, y } }, "*");
  }
  function flush() {
    queued = 0;
    if (!point || !document.body.classList.contains("in-home")) return;
    const r = document.getElementById("homePuppetSpace").getBoundingClientRect();
    send(Math.max(-1, Math.min(1, (point.x - r.left - r.width * 0.5) / Math.max(80, r.width * 0.7))), Math.max(-1, Math.min(1, (point.y - r.top - r.height * 0.4) / Math.max(80, r.height * 0.7))));
  }
  function follow(e) {
    if (!document.body.classList.contains("in-home") || document.getElementById("set").classList.contains("on") || document.getElementById("howToDiagram") && !document.getElementById("howToDiagram").hidden) return;
    point = { x: e.clientX, y: e.clientY };
    if (!queued) queued = requestAnimationFrame(flush);
  }
  function rest() {
    point = null;
    if (queued) cancelAnimationFrame(queued);
    queued = 0;
    send(0, 0);
  }
  document.addEventListener("touchmove", (e) => {
    const t = e.touches[0];
    if (t) follow(t);
  }, { passive: true });
  document.addEventListener("touchend", rest, { passive: true });
  document.addEventListener("pointermove", follow, { passive: true });
  document.addEventListener("pointerdown", follow, { passive: true });
  document.addEventListener("pointerup", (e) => {
    if (e.pointerType !== "mouse") rest();
  }, { passive: true });
  document.addEventListener("pointercancel", rest, { passive: true });
  document.documentElement.addEventListener("pointerleave", rest);
  window.addEventListener("blur", rest);
  new MutationObserver(() => {
    if (!document.body.classList.contains("in-home")) rest();
  }).observe(document.body, { attributes: true, attributeFilter: ["class"] });
})();
