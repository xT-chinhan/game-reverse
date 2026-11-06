using System;
using System.CodeDom.Compiler;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Reflection;
using System.Runtime.CompilerServices;
using Project.RuntimeInput;
using TMPro;
using UnityEngine;
using UnityEngine.EventSystems;
using UnityEngine.Events;
using UnityEngine.UI;

[assembly: CompilationRelaxations(8)]
[assembly: RuntimeCompatibility(WrapNonExceptionThrows = true)]
[assembly: Debuggable(DebuggableAttribute.DebuggingModes.IgnoreSymbolStoreSequencePoints)]
[assembly: AssemblyVersion("0.0.0.0")]
public class AudioManager : MonoBehaviour
{
	[SerializeField]
	[Header("音频源设置")]
	private AudioSource sfxSource;

	[SerializeField]
	private AudioSource voiceSource;

	[SerializeField]
	private AudioSource ambientSource;

	[SerializeField]
	private AudioSource musicSource;

	[SerializeField]
	private bool playMusicOnStart = true;

	[SerializeField]
	private string defaultMusicKey = "background_music";

	[SerializeField]
	[Header("音频资源")]
	private AudioClip doorCreakClip;

	[SerializeField]
	private AudioClip creepingFootstepsClip;

	[SerializeField]
	private AudioClip monsterGrowlClip;

	[SerializeField]
	private AudioClip whisper1Clip;

	[SerializeField]
	private AudioClip footstepsClip;

	[SerializeField]
	private AudioClip backgroundMusicClip;

	private Dictionary<string, AudioClip> audioClips = new Dictionary<string, AudioClip>();

	public static AudioManager Instance { get; private set; }

	private void Awake()
	{
		EnsureAudioSources();
		if ((Object)(object)Instance == (Object)null)
		{
			Instance = this;
			Object.DontDestroyOnLoad((Object)(object)((Component)this).gameObject);
			InitializeAudioClips();
		}
		else
		{
			Object.Destroy((Object)(object)((Component)this).gameObject);
		}
	}

	private void OnValidate()
	{
		EnsureAudioSources();
	}

	private void Start()
	{
		if (playMusicOnStart)
		{
			string text = (string.IsNullOrEmpty(defaultMusicKey) ? "background_music" : defaultMusicKey);
			if (audioClips.ContainsKey(text))
			{
				PlayBackgroundMusic(text);
			}
		}
	}

	private void InitializeAudioClips()
	{
		if ((Object)(object)doorCreakClip != (Object)null)
		{
			audioClips["door_creak"] = doorCreakClip;
		}
		if ((Object)(object)creepingFootstepsClip != (Object)null)
		{
			audioClips["creeping_footsteps"] = creepingFootstepsClip;
		}
		if ((Object)(object)monsterGrowlClip != (Object)null)
		{
			audioClips["monster_growl"] = monsterGrowlClip;
		}
		if ((Object)(object)whisper1Clip != (Object)null)
		{
			audioClips["whisper_1"] = whisper1Clip;
		}
		if ((Object)(object)footstepsClip != (Object)null)
		{
			audioClips["footsteps"] = footstepsClip;
		}
		if ((Object)(object)backgroundMusicClip != (Object)null)
		{
			audioClips["background_music"] = backgroundMusicClip;
		}
	}

	public void PlaySFX(string clipName, float volume = 1f)
	{
		if (audioClips.ContainsKey(clipName) && (Object)(object)sfxSource != (Object)null)
		{
			sfxSource.PlayOneShot(audioClips[clipName], volume);
		}
		else
		{
			Debug.LogWarning((object)("音效文件未找到: " + clipName));
		}
	}

	public void PlayVoice(string clipName, float volume = 1f)
	{
		if (audioClips.ContainsKey(clipName) && (Object)(object)voiceSource != (Object)null)
		{
			voiceSource.clip = audioClips[clipName];
			voiceSource.volume = volume;
			voiceSource.Play();
		}
		else
		{
			Debug.LogWarning((object)("语音文件未找到: " + clipName));
		}
	}

	public void PlayAmbient(string clipName, bool loop = true, float volume = 0.5f)
	{
		if (audioClips.ContainsKey(clipName) && (Object)(object)ambientSource != (Object)null)
		{
			ambientSource.clip = audioClips[clipName];
			ambientSource.loop = loop;
			ambientSource.volume = volume;
			ambientSource.Play();
		}
		else
		{
			Debug.LogWarning((object)("环境音文件未找到: " + clipName));
		}
	}

	public void StopVoice()
	{
		if ((Object)(object)voiceSource != (Object)null && voiceSource.isPlaying)
		{
			voiceSource.Stop();
		}
	}

	public void StopAmbient()
	{
		if ((Object)(object)ambientSource != (Object)null && ambientSource.isPlaying)
		{
			ambientSource.Stop();
		}
	}

	public void SetSFXVolume(float volume)
	{
		if ((Object)(object)sfxSource != (Object)null)
		{
			sfxSource.volume = volume;
		}
	}

	public void SetVoiceVolume(float volume)
	{
		if ((Object)(object)voiceSource != (Object)null)
		{
			voiceSource.volume = volume;
		}
	}

	public void PlayBackgroundMusic(string clipName = "background_music", bool loop = true, float volume = 0.6f)
	{
		if ((Object)(object)musicSource == (Object)null)
		{
			Debug.LogWarning((object)"背景音乐源未初始化");
		}
		else if (!audioClips.ContainsKey(clipName))
		{
			Debug.LogWarning((object)("背景音乐文件未找到: " + clipName));
		}
		else if (!((Object)(object)musicSource.clip == (Object)(object)audioClips[clipName]) || !musicSource.isPlaying)
		{
			musicSource.clip = audioClips[clipName];
			musicSource.loop = loop;
			musicSource.volume = volume;
			musicSource.Play();
		}
	}

	public void StopBackgroundMusic()
	{
		if ((Object)(object)musicSource != (Object)null && musicSource.isPlaying)
		{
			musicSource.Stop();
		}
	}

	public void SetMusicVolume(float volume)
	{
		if ((Object)(object)musicSource != (Object)null)
		{
			musicSource.volume = volume;
		}
	}

	private void EnsureAudioSources()
	{
		if ((Object)(object)sfxSource == (Object)null)
		{
			sfxSource = ((Component)this).gameObject.AddComponent<AudioSource>();
			sfxSource.playOnAwake = false;
		}
		if ((Object)(object)voiceSource == (Object)null)
		{
			voiceSource = ((Component)this).gameObject.AddComponent<AudioSource>();
			voiceSource.playOnAwake = false;
		}
		if ((Object)(object)ambientSource == (Object)null)
		{
			ambientSource = ((Component)this).gameObject.AddComponent<AudioSource>();
			ambientSource.loop = true;
			ambientSource.playOnAwake = false;
		}
		if ((Object)(object)musicSource == (Object)null)
		{
			musicSource = ((Component)this).gameObject.AddComponent<AudioSource>();
			musicSource.loop = true;
			musicSource.playOnAwake = false;
		}
	}
}
public class CameraController : MonoBehaviour
{
	[SerializeField]
	[Header("相机设置")]
	private Camera mainCamera;

	[SerializeField]
	private float transitionSpeed = 2f;

	[SerializeField]
	private AnimationCurve transitionCurve = AnimationCurve.EaseInOut(0f, 0f, 1f, 1f);

	private Vector3 targetPosition;

	private Quaternion targetRotation;

	private bool isTransitioning;

	private Coroutine currentTransition;

	public static CameraController Instance { get; private set; }

	private void Awake()
	{
		if ((Object)(object)Instance == (Object)null)
		{
			Instance = this;
		}
		else
		{
			Object.Destroy((Object)(object)((Component)this).gameObject);
		}
		if ((Object)(object)mainCamera == (Object)null)
		{
			mainCamera = Camera.main;
		}
	}

	public void MoveToPosition(Vector3 targetPos, float duration = 2f)
	{
		//IL_0017: Unknown result type (might be due to invalid IL or missing references)
		if (currentTransition != null)
		{
			((MonoBehaviour)this).StopCoroutine(currentTransition);
		}
		currentTransition = ((MonoBehaviour)this).StartCoroutine(SmoothMoveToPosition(targetPos, duration));
	}

	public void MoveToPositionAndLookAt(Vector3 targetPos, Vector3 lookAtPoint, float duration = 2f)
	{
		//IL_0017: Unknown result type (might be due to invalid IL or missing references)
		//IL_0018: Unknown result type (might be due to invalid IL or missing references)
		if (currentTransition != null)
		{
			((MonoBehaviour)this).StopCoroutine(currentTransition);
		}
		currentTransition = ((MonoBehaviour)this).StartCoroutine(SmoothMoveAndLookAt(targetPos, lookAtPoint, duration));
	}

	public void DollyForward(Vector3 direction, float distance, float duration = 2f)
	{
		//IL_001a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0021: Unknown result type (might be due to invalid IL or missing references)
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0031: Unknown result type (might be due to invalid IL or missing references)
		//IL_0035: Unknown result type (might be due to invalid IL or missing references)
		if (currentTransition != null)
		{
			((MonoBehaviour)this).StopCoroutine(currentTransition);
		}
		Vector3 targetPos = ((Component)this).transform.position + direction.normalized * distance;
		currentTransition = ((MonoBehaviour)this).StartCoroutine(SmoothMoveToPosition(targetPos, duration));
	}

	public void FocusOnPoint(Vector3 focusPoint, float duration = 2f)
	{
		//IL_0017: Unknown result type (might be due to invalid IL or missing references)
		if (currentTransition != null)
		{
			((MonoBehaviour)this).StopCoroutine(currentTransition);
		}
		currentTransition = ((MonoBehaviour)this).StartCoroutine(SmoothLookAt(focusPoint, duration));
	}

	private IEnumerator SmoothMoveToPosition(Vector3 targetPos, float duration)
	{
		//IL_000e: Unknown result type (might be due to invalid IL or missing references)
		//IL_000f: Unknown result type (might be due to invalid IL or missing references)
		isTransitioning = true;
		Vector3 startPos = ((Component)this).transform.position;
		float elapsed = 0f;
		while (elapsed < duration)
		{
			elapsed += Time.deltaTime;
			float num = elapsed / duration;
			float num2 = transitionCurve.Evaluate(num);
			((Component)this).transform.position = Vector3.Lerp(startPos, targetPos, num2);
			yield return null;
		}
		((Component)this).transform.position = targetPos;
		isTransitioning = false;
		currentTransition = null;
	}

	private IEnumerator SmoothMoveAndLookAt(Vector3 targetPos, Vector3 lookAtPoint, float duration)
	{
		//IL_000e: Unknown result type (might be due to invalid IL or missing references)
		//IL_000f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0015: Unknown result type (might be due to invalid IL or missing references)
		//IL_0016: Unknown result type (might be due to invalid IL or missing references)
		isTransitioning = true;
		Vector3 startPos = ((Component)this).transform.position;
		Quaternion startRot = ((Component)this).transform.rotation;
		Quaternion targetRot = Quaternion.LookRotation(lookAtPoint - targetPos);
		float elapsed = 0f;
		while (elapsed < duration)
		{
			elapsed += Time.deltaTime;
			float num = elapsed / duration;
			float num2 = transitionCurve.Evaluate(num);
			((Component)this).transform.position = Vector3.Lerp(startPos, targetPos, num2);
			((Component)this).transform.rotation = Quaternion.Lerp(startRot, targetRot, num2);
			yield return null;
		}
		((Component)this).transform.position = targetPos;
		((Component)this).transform.rotation = targetRot;
		isTransitioning = false;
		currentTransition = null;
	}

	private IEnumerator SmoothLookAt(Vector3 focusPoint, float duration)
	{
		//IL_000e: Unknown result type (might be due to invalid IL or missing references)
		//IL_000f: Unknown result type (might be due to invalid IL or missing references)
		isTransitioning = true;
		Quaternion startRot = ((Component)this).transform.rotation;
		Quaternion targetRot = Quaternion.LookRotation(focusPoint - ((Component)this).transform.position);
		float elapsed = 0f;
		while (elapsed < duration)
		{
			elapsed += Time.deltaTime;
			float num = elapsed / duration;
			float num2 = transitionCurve.Evaluate(num);
			((Component)this).transform.rotation = Quaternion.Lerp(startRot, targetRot, num2);
			yield return null;
		}
		((Component)this).transform.rotation = targetRot;
		isTransitioning = false;
		currentTransition = null;
	}

	public bool IsTransitioning()
	{
		return isTransitioning;
	}

	public void StopTransition()
	{
		if (currentTransition != null)
		{
			((MonoBehaviour)this).StopCoroutine(currentTransition);
			isTransitioning = false;
			currentTransition = null;
		}
	}
}
[DisallowMultipleComponent]
public class CoinPickup : MonoBehaviour
{
	[SerializeField]
	[Min(1f)]
	private int coinValue = 1;

	[SerializeField]
	private string playerTag = "Player";

	[SerializeField]
	private bool destroyOnPickup = true;

	private bool picked;

	private void Reset()
	{
		Collider component = ((Component)this).GetComponent<Collider>();
		if ((Object)(object)component != (Object)null)
		{
			component.isTrigger = true;
		}
	}

	private void Awake()
	{
		EnsureTriggerPhysicsSetup();
	}

	private void EnsureTriggerPhysicsSetup()
	{
		Collider component = ((Component)this).GetComponent<Collider>();
		if ((Object)(object)component != (Object)null && !component.isTrigger)
		{
			component.isTrigger = true;
		}
		Rigidbody val = ((Component)this).GetComponent<Rigidbody>();
		if ((Object)(object)val == (Object)null)
		{
			val = ((Component)this).gameObject.AddComponent<Rigidbody>();
		}
		val.isKinematic = true;
		val.useGravity = false;
	}

	private void OnTriggerEnter(Collider other)
	{
		if (!picked && ((Component)other).CompareTag(playerTag))
		{
			picked = true;
			GameProgressTracker.Instance?.AddCoinCollected(coinValue);
			if (destroyOnPickup)
			{
				Object.Destroy((Object)(object)((Component)this).gameObject);
			}
			else
			{
				((Component)this).gameObject.SetActive(false);
			}
		}
	}
}
[DisallowMultipleComponent]
public class CoinSpawner : MonoBehaviour
{
	[SerializeField]
	[Header("生成目标")]
	private Transform player;

	[SerializeField]
	private string playerTag = "Player";

	[Header("金币预制体")]
	[SerializeField]
	private GameObject coinPrefab;

	[Header("生成参数")]
	[SerializeField]
	[Min(0.5f)]
	private float spawnRadius = 6f;

	[Min(0f)]
	[SerializeField]
	private float minDistanceFromPlayer = 1.5f;

	[Min(0.1f)]
	[SerializeField]
	private float spawnIntervalSeconds = 2f;

	[SerializeField]
	[Min(0f)]
	private int maxAliveCoins = 15;

	[SerializeField]
	private float yOffset = 0.2f;

	[SerializeField]
	private bool spawnOnStart = true;

	[SerializeField]
	[Min(0f)]
	private int initialSpawnCount = 8;

	private float nextSpawnTime;

	private void Start()
	{
		if ((Object)(object)player == (Object)null)
		{
			GameObject val = GameObject.FindGameObjectWithTag(playerTag);
			if ((Object)(object)val != (Object)null)
			{
				player = val.transform;
			}
		}
		nextSpawnTime = Time.time + spawnIntervalSeconds;
		if (spawnOnStart)
		{
			for (int i = 0; i < initialSpawnCount; i++)
			{
				TrySpawnOne();
			}
		}
	}

	private void Update()
	{
		if (!((Object)(object)coinPrefab == (Object)null) && !((Object)(object)player == (Object)null) && (maxAliveCoins <= 0 || CountAliveCoins() < maxAliveCoins) && Time.time >= nextSpawnTime)
		{
			TrySpawnOne();
			nextSpawnTime = Time.time + spawnIntervalSeconds;
		}
	}

	private int CountAliveCoins()
	{
		return Object.FindObjectsOfType<CoinPickup>(false).Length;
	}

	private void TrySpawnOne()
	{
		//IL_001d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0022: Unknown result type (might be due to invalid IL or missing references)
		//IL_0025: Unknown result type (might be due to invalid IL or missing references)
		//IL_003b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0040: Unknown result type (might be due to invalid IL or missing references)
		//IL_0047: Unknown result type (might be due to invalid IL or missing references)
		//IL_004c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0057: Unknown result type (might be due to invalid IL or missing references)
		//IL_005d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0062: Unknown result type (might be due to invalid IL or missing references)
		//IL_0067: Unknown result type (might be due to invalid IL or missing references)
		//IL_007f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0080: Unknown result type (might be due to invalid IL or missing references)
		if (!((Object)(object)coinPrefab == (Object)null) && !((Object)(object)player == (Object)null))
		{
			Vector2 insideUnitCircle = Random.insideUnitCircle;
			Vector2 val = insideUnitCircle.normalized * Random.Range(minDistanceFromPlayer, spawnRadius);
			Vector3 val2 = player.position + new Vector3(val.x, 0f, val.y);
			val2.y += yOffset;
			Object.Instantiate<GameObject>(coinPrefab, val2, Quaternion.identity);
		}
	}
}
public class DemoGame : MonoBehaviour
{
	private void Start()
	{
	}

	private void Update()
	{
	}
}
public class DoorInteractable : Interactable
{
	[Header("门设置")]
	[SerializeField]
	private Transform doorTransform;

	[SerializeField]
	private Vector3 openRotation = new Vector3(0f, 90f, 0f);

	[SerializeField]
	private float openDuration = 1f;

	[SerializeField]
	private AnimationCurve openCurve = AnimationCurve.EaseInOut(0f, 0f, 1f, 1f);

	[Header("事件设置")]
	[SerializeField]
	private bool playDoorSound = true;

	[SerializeField]
	private string doorSoundName = "door_creak";

	[SerializeField]
	private bool showDialogue = true;

	[SerializeField]
	private string dialogueText = "你听到门慢慢开启的声音。";

	[SerializeField]
	private float dialogueDuration = 2f;

	[Header("相机过渡")]
	[SerializeField]
	private bool triggerCameraTransition = true;

	[SerializeField]
	private Vector3 cameraTargetPosition;

	[SerializeField]
	private Vector3 cameraLookAtPoint;

	[SerializeField]
	private float cameraTransitionDuration = 2f;

	private bool isOpen;

	private bool isAnimating;

	private Vector3 closedRotation;

	private void Start()
	{
		//IL_0021: Unknown result type (might be due to invalid IL or missing references)
		//IL_0026: Unknown result type (might be due to invalid IL or missing references)
		if ((Object)(object)doorTransform == (Object)null)
		{
			doorTransform = ((Component)this).transform;
		}
		closedRotation = doorTransform.localEulerAngles;
	}

	public override void Interact()
	{
		if (CanInteract() && !isAnimating)
		{
			if (isOpen)
			{
				CloseDoor();
			}
			else
			{
				OpenDoor();
			}
		}
	}

	public override bool CanInteract()
	{
		if (!canInteractMultipleTimes)
		{
			return !hasBeenInteracted;
		}
		return true;
	}

	private void OpenDoor()
	{
		//IL_0003: Unknown result type (might be due to invalid IL or missing references)
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_000f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0014: Unknown result type (might be due to invalid IL or missing references)
		((MonoBehaviour)this).StartCoroutine(AnimateDoor(closedRotation, closedRotation + openRotation, opening: true));
	}

	private void CloseDoor()
	{
		//IL_0003: Unknown result type (might be due to invalid IL or missing references)
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_000e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0014: Unknown result type (might be due to invalid IL or missing references)
		((MonoBehaviour)this).StartCoroutine(AnimateDoor(closedRotation + openRotation, closedRotation, opening: false));
	}

	private IEnumerator AnimateDoor(Vector3 startRot, Vector3 endRot, bool opening)
	{
		//IL_000e: Unknown result type (might be due to invalid IL or missing references)
		//IL_000f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0015: Unknown result type (might be due to invalid IL or missing references)
		//IL_0016: Unknown result type (might be due to invalid IL or missing references)
		isAnimating = true;
		if (playDoorSound & opening)
		{
			AudioManager.Instance?.PlaySFX(doorSoundName);
		}
		if (showDialogue & opening)
		{
			NarrativeManager.Instance?.ShowDialogue(dialogueText, dialogueDuration);
		}
		float elapsed = 0f;
		while (elapsed < openDuration)
		{
			elapsed += Time.deltaTime;
			float num = elapsed / openDuration;
			float num2 = openCurve.Evaluate(num);
			doorTransform.localEulerAngles = Vector3.Lerp(startRot, endRot, num2);
			yield return null;
		}
		doorTransform.localEulerAngles = endRot;
		isOpen = opening;
		hasBeenInteracted = true;
		isAnimating = false;
		if (opening)
		{
			((MonoBehaviour)this).StartCoroutine(UpdateGameProgress());
		}
		if (opening && triggerCameraTransition)
		{
			if (cameraLookAtPoint != Vector3.zero)
			{
				CameraController.Instance?.MoveToPositionAndLookAt(cameraTargetPosition, cameraLookAtPoint, cameraTransitionDuration);
			}
			else
			{
				CameraController.Instance?.MoveToPosition(cameraTargetPosition, cameraTransitionDuration);
			}
		}
	}

	private void OnDrawGizmos()
	{
		//IL_0008: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Unknown result type (might be due to invalid IL or missing references)
		//IL_0023: Unknown result type (might be due to invalid IL or missing references)
		//IL_0028: Unknown result type (might be due to invalid IL or missing references)
		//IL_0034: Unknown result type (might be due to invalid IL or missing references)
		//IL_003f: Unknown result type (might be due to invalid IL or missing references)
		//IL_004f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0055: Unknown result type (might be due to invalid IL or missing references)
		if (triggerCameraTransition)
		{
			Gizmos.color = Color.cyan;
			Gizmos.DrawWireSphere(cameraTargetPosition, 0.5f);
			if (cameraLookAtPoint != Vector3.zero)
			{
				Gizmos.color = Color.magenta;
				Gizmos.DrawWireSphere(cameraLookAtPoint, 0.3f);
				Gizmos.DrawLine(cameraTargetPosition, cameraLookAtPoint);
			}
		}
	}

	private IEnumerator UpdateGameProgress()
	{
		yield return (object)new WaitForEndOfFrame();
		yield return null;
		GameProgressTracker gameProgressTracker = Object.FindObjectOfType<GameProgressTracker>();
		if ((Object)(object)gameProgressTracker != (Object)null)
		{
			gameProgressTracker.SetDoorOpened(value: true);
		}
		GameFlowManager gameFlowManager = Object.FindObjectOfType<GameFlowManager>();
		if ((Object)(object)gameFlowManager != (Object)null)
		{
			gameFlowManager.CheckGameCompletion();
		}
	}

	public DoorInteractable()
	{
		//IL_0010: Unknown result type (might be due to invalid IL or missing references)
		//IL_0015: Unknown result type (might be due to invalid IL or missing references)
	}
}
public class GameFlowManager : MonoBehaviour
{
	[SerializeField]
	[Header("游戏流程设置")]
	private float darkRoomIntroDelay = 1f;

	[SerializeField]
	private float corridorIntroDelay = 2f;

	[SerializeField]
	private float cellarTransitionDelay = 3f;

	[Header("场景对象引用")]
	[SerializeField]
	private NarrativeTrigger darkRoomTrigger;

	[SerializeField]
	private NarrativeTrigger corridorTrigger;

	[SerializeField]
	private NarrativeTrigger ghostAppearanceTrigger;

	[SerializeField]
	private DoorInteractable mainDoor;

	[SerializeField]
	private ItemPickup[] collectibleItems;

	[SerializeField]
	private GameObject cellarArea;

	private bool gameStarted;

	private bool gameCompleted;

	public static GameFlowManager Instance { get; private set; }

	private void Awake()
	{
		if ((Object)(object)Instance == (Object)null)
		{
			Instance = this;
		}
		else
		{
			Object.Destroy((Object)(object)((Component)this).gameObject);
		}
	}

	private void Start()
	{
		InitializeGame();
	}

	private void InitializeGame()
	{
		//IL_0012: Unknown result type (might be due to invalid IL or missing references)
		//IL_002f: Unknown result type (might be due to invalid IL or missing references)
		//IL_004c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0069: Unknown result type (might be due to invalid IL or missing references)
		//IL_0086: Unknown result type (might be due to invalid IL or missing references)
		if ((Object)(object)AudioManager.Instance == (Object)null)
		{
			new GameObject("AudioManager").AddComponent<AudioManager>();
		}
		if ((Object)(object)CameraController.Instance == (Object)null)
		{
			new GameObject("CameraController").AddComponent<CameraController>();
		}
		if ((Object)(object)NarrativeManager.Instance == (Object)null)
		{
			new GameObject("NarrativeManager").AddComponent<NarrativeManager>();
		}
		if ((Object)(object)GameUIManager.Instance == (Object)null)
		{
			new GameObject("UIManager").AddComponent<GameUIManager>();
		}
		if ((Object)(object)GameProgressTracker.Instance == (Object)null)
		{
			new GameObject("GameProgressTracker").AddComponent<GameProgressTracker>();
		}
		ConnectUIReferences();
		InitializeScene();
		gameStarted = true;
		Debug.Log((object)"游戏初始化完成");
	}

	private void ConnectUIReferences()
	{
		if ((Object)(object)NarrativeManager.Instance != (Object)null && (Object)(object)GameUIManager.Instance != (Object)null)
		{
			_ = NarrativeManager.Instance;
		}
		if ((Object)(object)Object.FindObjectOfType<InteractionSystem>() != (Object)null)
		{
			_ = (Object)(object)GameUIManager.Instance != (Object)null;
		}
	}

	private void InitializeScene()
	{
		if ((Object)(object)cellarArea != (Object)null)
		{
			cellarArea.SetActive(false);
		}
	}

	public void TriggerCellarTransition()
	{
		if (!gameCompleted)
		{
			((MonoBehaviour)this).StartCoroutine(CellarTransitionSequence());
		}
	}

	private IEnumerator CellarTransitionSequence()
	{
		AudioManager.Instance?.PlaySFX("footsteps");
		NarrativeManager.Instance?.ShowDialogue("你听到远处传来沉闷的脚步声和地下的风声...", 3f);
		yield return (object)new WaitForSeconds(cellarTransitionDelay);
		if ((Object)(object)cellarArea != (Object)null)
		{
			cellarArea.SetActive(true);
		}
		GameProgressTracker.Instance?.SetCellarReached(value: true);
		NarrativeManager.Instance?.ShowDialogue("你来到了一个阴冷的地窖，空气中弥漫着腐朽的气息...", 4f);
		AudioManager.Instance?.PlayAmbient("underground_wind", loop: true, 0.4f);
	}

	public void CheckGameCompletion()
	{
		if (!gameCompleted)
		{
			GameProgressTracker instance = GameProgressTracker.Instance;
			if ((Object)(object)instance != (Object)null && instance.IsEventCompleted("进入暗房") && instance.IsEventCompleted("进入走廊") && instance.IsEventCompleted("打开门") && instance.IsEventCompleted("拾取物品") && instance.IsEventCompleted("到达地窖"))
			{
				CompleteGame();
			}
		}
	}

	private void CompleteGame()
	{
		gameCompleted = true;
		((MonoBehaviour)this).StartCoroutine(GameEndSequence());
	}

	private IEnumerator GameEndSequence()
	{
		NarrativeManager.Instance?.ShowDialogue("你完成了这次探索...但黑暗中似乎还有更多秘密等待发现。", 5f);
		yield return (object)new WaitForSeconds(6f);
		float num = GameProgressTracker.Instance?.GetGameTime() ?? 0f;
		int num2 = GameProgressTracker.Instance?.GetItemsCollected() ?? 0;
		NarrativeManager.Instance?.ShowDialogue($"游戏结束！\n探索时间: {Mathf.FloorToInt(num / 60f)}分{Mathf.FloorToInt(num % 60f)}秒\n收集物品: {num2}个", 8f);
	}

	public bool IsGameCompleted()
	{
		return gameCompleted;
	}

	public bool IsGameStarted()
	{
		return gameStarted;
	}
}
public class GameProgressTracker : MonoBehaviour
{
	[Serializable]
	public class ProgressEvent
	{
		public string eventName;

		public bool isCompleted;

		public float completionTime;
	}

	[Header("进度设置")]
	[SerializeField]
	private List<ProgressEvent> progressEvents = new List<ProgressEvent>();

	[Header("游戏状态")]
	[SerializeField]
	private bool hasEnteredDarkRoom;

	[SerializeField]
	private bool hasEnteredCorridor;

	[SerializeField]
	private bool hasOpenedDoor;

	[SerializeField]
	private bool hasPickedUpItem;

	[SerializeField]
	private bool hasReachedCellar;

	[SerializeField]
	private int itemsCollected;

	[SerializeField]
	private int coinsCollected;

	private float gameStartTime;

	private float currentGameTime;

	public static GameProgressTracker Instance { get; private set; }

	private void Awake()
	{
		if ((Object)(object)Instance == (Object)null)
		{
			Instance = this;
		}
		else
		{
			Object.Destroy((Object)(object)((Component)this).gameObject);
		}
	}

	private void Start()
	{
		gameStartTime = Time.time;
		InitializeProgressEvents();
	}

	private void Update()
	{
		currentGameTime = Time.time - gameStartTime;
	}

	private void InitializeProgressEvents()
	{
		progressEvents = new List<ProgressEvent>
		{
			new ProgressEvent
			{
				eventName = "进入暗房",
				isCompleted = false
			},
			new ProgressEvent
			{
				eventName = "听到门声",
				isCompleted = false
			},
			new ProgressEvent
			{
				eventName = "进入走廊",
				isCompleted = false
			},
			new ProgressEvent
			{
				eventName = "听到脚步声",
				isCompleted = false
			},
			new ProgressEvent
			{
				eventName = "打开门",
				isCompleted = false
			},
			new ProgressEvent
			{
				eventName = "拾取物品",
				isCompleted = false
			},
			new ProgressEvent
			{
				eventName = "到达地窖",
				isCompleted = false
			}
		};
	}

	public void MarkEventComplete(string eventName)
	{
		foreach (ProgressEvent progressEvent in progressEvents)
		{
			if (progressEvent.eventName == eventName && !progressEvent.isCompleted)
			{
				progressEvent.isCompleted = true;
				progressEvent.completionTime = currentGameTime;
				Debug.Log((object)$"进度事件完成: {eventName} (时间: {currentGameTime:F1}秒)");
				break;
			}
		}
	}

	public void SetDarkRoomEntered(bool value)
	{
		hasEnteredDarkRoom = value;
		if (value)
		{
			MarkEventComplete("进入暗房");
		}
	}

	public void SetCorridorEntered(bool value)
	{
		hasEnteredCorridor = value;
		if (value)
		{
			MarkEventComplete("进入走廊");
		}
	}

	public void SetDoorOpened(bool value)
	{
		hasOpenedDoor = value;
		if (value)
		{
			MarkEventComplete("打开门");
		}
	}

	public void SetItemPickedUp(bool value)
	{
		hasPickedUpItem = value;
		itemsCollected++;
		if (value)
		{
			MarkEventComplete("拾取物品");
		}
	}

	public void SetCellarReached(bool value)
	{
		hasReachedCellar = value;
		if (value)
		{
			MarkEventComplete("到达地窖");
		}
	}

	public float GetGameTime()
	{
		return currentGameTime;
	}

	public int GetItemsCollected()
	{
		return itemsCollected;
	}

	public int GetCoinsCollected()
	{
		return coinsCollected;
	}

	public void AddCoinCollected(int amount = 1)
	{
		if (amount > 0)
		{
			coinsCollected += amount;
		}
	}

	public bool IsEventCompleted(string eventName)
	{
		foreach (ProgressEvent progressEvent in progressEvents)
		{
			if (progressEvent.eventName == eventName)
			{
				return progressEvent.isCompleted;
			}
		}
		return false;
	}

	public List<ProgressEvent> GetProgressEvents()
	{
		return progressEvents;
	}
}
public class GameSetupGuide : MonoBehaviour
{
}
public class GameUIManager : MonoBehaviour
{
	[SerializeField]
	private TMP_FontAsset defaultFontAsset;

	private Canvas uiCanvas;

	private GameObject dialoguePanel;

	private TextMeshProUGUI dialogueText;

	private GameObject itemInfoPanel;

	private TextMeshProUGUI itemNameText;

	private TextMeshProUGUI itemDescriptionText;

	private Image itemIconImage;

	private GameObject interactionPrompt;

	private TextMeshProUGUI promptText;

	private GameObject gameInfoPanel;

	private TextMeshProUGUI gameTimeText;

	private TextMeshProUGUI itemsCollectedText;

	private TextMeshProUGUI coinsCollectedText;

	private Button settingsButton;

	private GameObject settingsPanel;

	private Button continueButton;

	private Button exitButton;

	private bool uiCreated;

	public static GameUIManager Instance { get; private set; }

	private void Awake()
	{
		if ((Object)(object)Instance == (Object)null)
		{
			Instance = this;
			CreateUIElements();
			HideAllUI();
			uiCreated = true;
		}
		else
		{
			Object.Destroy((Object)(object)((Component)this).gameObject);
		}
	}

	private void Start()
	{
		if (!uiCreated)
		{
			CreateUIElements();
			HideAllUI();
		}
	}

	private void Update()
	{
		UpdateGameInfo();
	}

	private void CreateUIElements()
	{
		if (!((Object)(object)dialoguePanel != (Object)null))
		{
			Canvas orCreateCanvas = GetOrCreateCanvas();
			dialoguePanel = CreateDialoguePanel(((Component)orCreateCanvas).transform);
			itemInfoPanel = CreateItemInfoPanel(((Component)orCreateCanvas).transform);
			interactionPrompt = CreateInteractionPrompt(((Component)orCreateCanvas).transform);
			gameInfoPanel = CreateGameInfoPanel(((Component)orCreateCanvas).transform);
			settingsButton = CreateSettingsButton(((Component)orCreateCanvas).transform);
			settingsPanel = CreateSettingsPanel(((Component)orCreateCanvas).transform);
		}
	}

	private GameObject CreateDialoguePanel(Transform parent)
	{
		//IL_0005: Unknown result type (might be due to invalid IL or missing references)
		//IL_000b: Expected Obj, but got Unknown
		//IL_0029: Unknown result type (might be due to invalid IL or missing references)
		//IL_003e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0049: Unknown result type (might be due to invalid IL or missing references)
		//IL_0053: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Unknown result type (might be due to invalid IL or missing references)
		//IL_0072: Unknown result type (might be due to invalid IL or missing references)
		//IL_0078: Expected Obj, but got Unknown
		//IL_00bc: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f8: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fd: Unknown result type (might be due to invalid IL or missing references)
		//IL_012a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0135: Unknown result type (might be due to invalid IL or missing references)
		//IL_014a: Unknown result type (might be due to invalid IL or missing references)
		//IL_015e: Unknown result type (might be due to invalid IL or missing references)
		GameObject val = new GameObject("DialoguePanel");
		val.transform.SetParent(parent, false);
		RectTransform val2 = val.AddComponent<RectTransform>();
		val2.anchorMin = new Vector2(0.1f, 0.1f);
		val2.anchorMax = new Vector2(0.9f, 0.3f);
		val2.offsetMin = Vector2.zero;
		val2.offsetMax = Vector2.zero;
		((Graphic)val.AddComponent<Image>()).color = WarmUITheme.PanelDark;
		GameObject val3 = new GameObject("DialogueText");
		val3.transform.SetParent(val.transform, false);
		dialogueText = val3.AddComponent<TextMeshProUGUI>();
		((TMP_Text)dialogueText).text = "";
		((TMP_Text)dialogueText).fontSize = 24f;
		((Graphic)dialogueText).color = WarmUITheme.TextPrimary;
		((TMP_Text)dialogueText).alignment = (TextAlignmentOptions)514;
		((TMP_Text)dialogueText).verticalAlignment = (VerticalAlignmentOptions)512;
		((TMP_Text)dialogueText).fontStyle = (FontStyles)1;
		((TMP_Text)dialogueText).outlineColor = Color32.op_Implicit(WarmUITheme.TextOutline);
		((TMP_Text)dialogueText).outlineWidth = 0.15f;
		ApplyDefaultFont(dialogueText);
		RectTransform component = val3.GetComponent<RectTransform>();
		component.anchorMin = Vector2.zero;
		component.anchorMax = Vector2.one;
		component.offsetMin = new Vector2(10f, 10f);
		component.offsetMax = new Vector2(-10f, -10f);
		val.SetActive(false);
		return val;
	}

	private GameObject CreateItemInfoPanel(Transform parent)
	{
		//IL_0005: Unknown result type (might be due to invalid IL or missing references)
		//IL_000b: Expected Obj, but got Unknown
		//IL_0029: Unknown result type (might be due to invalid IL or missing references)
		//IL_003e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0049: Unknown result type (might be due to invalid IL or missing references)
		//IL_0053: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Unknown result type (might be due to invalid IL or missing references)
		//IL_0072: Unknown result type (might be due to invalid IL or missing references)
		//IL_0078: Expected Obj, but got Unknown
		//IL_00a7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bc: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e0: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e6: Expected Obj, but got Unknown
		//IL_012a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0146: Unknown result type (might be due to invalid IL or missing references)
		//IL_014b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0182: Unknown result type (might be due to invalid IL or missing references)
		//IL_0197: Unknown result type (might be due to invalid IL or missing references)
		//IL_01a2: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ac: Unknown result type (might be due to invalid IL or missing references)
		//IL_01bb: Unknown result type (might be due to invalid IL or missing references)
		//IL_01c1: Expected Obj, but got Unknown
		//IL_0205: Unknown result type (might be due to invalid IL or missing references)
		//IL_0215: Unknown result type (might be due to invalid IL or missing references)
		//IL_021a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0251: Unknown result type (might be due to invalid IL or missing references)
		//IL_0266: Unknown result type (might be due to invalid IL or missing references)
		//IL_0271: Unknown result type (might be due to invalid IL or missing references)
		//IL_027b: Unknown result type (might be due to invalid IL or missing references)
		GameObject val = new GameObject("ItemInfoPanel");
		val.transform.SetParent(parent, false);
		RectTransform val2 = val.AddComponent<RectTransform>();
		val2.anchorMin = new Vector2(0.2f, 0.6f);
		val2.anchorMax = new Vector2(0.8f, 0.9f);
		val2.offsetMin = Vector2.zero;
		val2.offsetMax = Vector2.zero;
		((Graphic)val.AddComponent<Image>()).color = WarmUITheme.PanelDark;
		GameObject val3 = new GameObject("ItemIcon");
		val3.transform.SetParent(val.transform, false);
		itemIconImage = val3.AddComponent<Image>();
		RectTransform component = val3.GetComponent<RectTransform>();
		component.anchorMin = new Vector2(0.05f, 0.5f);
		component.anchorMax = new Vector2(0.3f, 0.95f);
		component.offsetMin = Vector2.zero;
		component.offsetMax = Vector2.zero;
		GameObject val4 = new GameObject("ItemName");
		val4.transform.SetParent(val.transform, false);
		itemNameText = val4.AddComponent<TextMeshProUGUI>();
		((TMP_Text)itemNameText).text = "";
		((TMP_Text)itemNameText).fontSize = 28f;
		((Graphic)itemNameText).color = WarmUITheme.TextAccent;
		((TMP_Text)itemNameText).fontStyle = (FontStyles)1;
		((TMP_Text)itemNameText).outlineColor = Color32.op_Implicit(WarmUITheme.TextOutline);
		((TMP_Text)itemNameText).outlineWidth = 0.15f;
		ApplyDefaultFont(itemNameText);
		RectTransform component2 = val4.GetComponent<RectTransform>();
		component2.anchorMin = new Vector2(0.35f, 0.7f);
		component2.anchorMax = new Vector2(0.95f, 0.95f);
		component2.offsetMin = Vector2.zero;
		component2.offsetMax = Vector2.zero;
		GameObject val5 = new GameObject("ItemDescription");
		val5.transform.SetParent(val.transform, false);
		itemDescriptionText = val5.AddComponent<TextMeshProUGUI>();
		((TMP_Text)itemDescriptionText).text = "";
		((TMP_Text)itemDescriptionText).fontSize = 18f;
		((Graphic)itemDescriptionText).color = WarmUITheme.TextPrimary;
		((TMP_Text)itemDescriptionText).outlineColor = Color32.op_Implicit(WarmUITheme.TextOutline);
		((TMP_Text)itemDescriptionText).outlineWidth = 0.08f;
		ApplyDefaultFont(itemDescriptionText);
		RectTransform component3 = val5.GetComponent<RectTransform>();
		component3.anchorMin = new Vector2(0.35f, 0.05f);
		component3.anchorMax = new Vector2(0.95f, 0.65f);
		component3.offsetMin = Vector2.zero;
		component3.offsetMax = Vector2.zero;
		val.SetActive(false);
		return val;
	}

	private GameObject CreateInteractionPrompt(Transform parent)
	{
		//IL_0005: Unknown result type (might be due to invalid IL or missing references)
		//IL_000b: Expected Obj, but got Unknown
		//IL_0029: Unknown result type (might be due to invalid IL or missing references)
		//IL_003e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0049: Unknown result type (might be due to invalid IL or missing references)
		//IL_0053: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Unknown result type (might be due to invalid IL or missing references)
		//IL_0072: Unknown result type (might be due to invalid IL or missing references)
		//IL_0078: Expected Obj, but got Unknown
		//IL_00bc: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e8: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ed: Unknown result type (might be due to invalid IL or missing references)
		//IL_010e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0119: Unknown result type (might be due to invalid IL or missing references)
		//IL_0124: Unknown result type (might be due to invalid IL or missing references)
		//IL_012e: Unknown result type (might be due to invalid IL or missing references)
		GameObject val = new GameObject("InteractionPrompt");
		val.transform.SetParent(parent, false);
		RectTransform val2 = val.AddComponent<RectTransform>();
		val2.anchorMin = new Vector2(0.4f, 0.25f);
		val2.anchorMax = new Vector2(0.6f, 0.35f);
		val2.offsetMin = Vector2.zero;
		val2.offsetMax = Vector2.zero;
		((Graphic)val.AddComponent<Image>()).color = WarmUITheme.PanelDarker;
		GameObject val3 = new GameObject("PromptText");
		val3.transform.SetParent(val.transform, false);
		promptText = val3.AddComponent<TextMeshProUGUI>();
		((TMP_Text)promptText).text = "";
		((TMP_Text)promptText).fontSize = 20f;
		((Graphic)promptText).color = WarmUITheme.TextPrimary;
		((TMP_Text)promptText).alignment = (TextAlignmentOptions)514;
		ApplyDefaultFont(promptText);
		((TMP_Text)promptText).outlineColor = Color32.op_Implicit(WarmUITheme.TextOutline);
		((TMP_Text)promptText).outlineWidth = 0.1f;
		RectTransform component = val3.GetComponent<RectTransform>();
		component.anchorMin = Vector2.zero;
		component.anchorMax = Vector2.one;
		component.offsetMin = Vector2.zero;
		component.offsetMax = Vector2.zero;
		val.SetActive(false);
		return val;
	}

	private GameObject CreateGameInfoPanel(Transform parent)
	{
		//IL_0005: Unknown result type (might be due to invalid IL or missing references)
		//IL_000b: Expected Obj, but got Unknown
		//IL_0029: Unknown result type (might be due to invalid IL or missing references)
		//IL_003e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0049: Unknown result type (might be due to invalid IL or missing references)
		//IL_0053: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Unknown result type (might be due to invalid IL or missing references)
		//IL_009f: Unknown result type (might be due to invalid IL or missing references)
		//IL_00cb: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e0: Unknown result type (might be due to invalid IL or missing references)
		//IL_00eb: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f5: Unknown result type (might be due to invalid IL or missing references)
		//IL_0105: Unknown result type (might be due to invalid IL or missing references)
		//IL_0141: Unknown result type (might be due to invalid IL or missing references)
		//IL_016d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0182: Unknown result type (might be due to invalid IL or missing references)
		//IL_018d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0197: Unknown result type (might be due to invalid IL or missing references)
		//IL_01a7: Unknown result type (might be due to invalid IL or missing references)
		//IL_01e3: Unknown result type (might be due to invalid IL or missing references)
		//IL_020f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0224: Unknown result type (might be due to invalid IL or missing references)
		//IL_022f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0239: Unknown result type (might be due to invalid IL or missing references)
		GameObject val = new GameObject("GameInfoPanel");
		val.transform.SetParent(parent, false);
		RectTransform val2 = val.AddComponent<RectTransform>();
		val2.anchorMin = new Vector2(0.02f, 0.9f);
		val2.anchorMax = new Vector2(0.3f, 0.98f);
		val2.offsetMin = Vector2.zero;
		val2.offsetMax = Vector2.zero;
		gameTimeText = new GameObject("GameTimeText").AddComponent<TextMeshProUGUI>();
		((TMP_Text)gameTimeText).transform.SetParent(val.transform, false);
		((TMP_Text)gameTimeText).fontSize = 16f;
		((Graphic)gameTimeText).color = Color.white;
		ApplyDefaultFont(gameTimeText);
		RectTransform component = ((Component)gameTimeText).GetComponent<RectTransform>();
		component.anchorMin = new Vector2(0f, 0.66f);
		component.anchorMax = new Vector2(1f, 1f);
		component.offsetMin = Vector2.zero;
		component.offsetMax = Vector2.zero;
		itemsCollectedText = new GameObject("ItemsCollectedText").AddComponent<TextMeshProUGUI>();
		((TMP_Text)itemsCollectedText).transform.SetParent(val.transform, false);
		((TMP_Text)itemsCollectedText).fontSize = 16f;
		((Graphic)itemsCollectedText).color = Color.white;
		ApplyDefaultFont(itemsCollectedText);
		RectTransform component2 = ((Component)itemsCollectedText).GetComponent<RectTransform>();
		component2.anchorMin = new Vector2(0f, 0.33f);
		component2.anchorMax = new Vector2(1f, 0.66f);
		component2.offsetMin = Vector2.zero;
		component2.offsetMax = Vector2.zero;
		coinsCollectedText = new GameObject("CoinsCollectedText").AddComponent<TextMeshProUGUI>();
		((TMP_Text)coinsCollectedText).transform.SetParent(val.transform, false);
		((TMP_Text)coinsCollectedText).fontSize = 16f;
		((Graphic)coinsCollectedText).color = Color.white;
		ApplyDefaultFont(coinsCollectedText);
		RectTransform component3 = ((Component)coinsCollectedText).GetComponent<RectTransform>();
		component3.anchorMin = new Vector2(0f, 0f);
		component3.anchorMax = new Vector2(1f, 0.33f);
		component3.offsetMin = Vector2.zero;
		component3.offsetMax = Vector2.zero;
		return val;
	}

	private Button CreateSettingsButton(Transform parent)
	{
		//IL_0005: Unknown result type (might be due to invalid IL or missing references)
		//IL_000b: Expected Obj, but got Unknown
		//IL_0029: Unknown result type (might be due to invalid IL or missing references)
		//IL_003e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0049: Unknown result type (might be due to invalid IL or missing references)
		//IL_0053: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Unknown result type (might be due to invalid IL or missing references)
		//IL_0080: Unknown result type (might be due to invalid IL or missing references)
		//IL_008a: Expected Obj, but got Unknown
		//IL_008f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0094: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a6: Unknown result type (might be due to invalid IL or missing references)
		//IL_00cf: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e6: Unknown result type (might be due to invalid IL or missing references)
		//IL_0108: Unknown result type (might be due to invalid IL or missing references)
		//IL_0113: Unknown result type (might be due to invalid IL or missing references)
		//IL_011e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0128: Unknown result type (might be due to invalid IL or missing references)
		GameObject val = new GameObject("SettingsButton");
		val.transform.SetParent(parent, false);
		RectTransform val2 = val.AddComponent<RectTransform>();
		val2.anchorMin = new Vector2(0.9f, 0.9f);
		val2.anchorMax = new Vector2(0.98f, 0.98f);
		val2.offsetMin = Vector2.zero;
		val2.offsetMax = Vector2.zero;
		((Graphic)val.AddComponent<Image>()).color = WarmUITheme.PanelDarker;
		Button val3 = val.AddComponent<Button>();
		((UnityEvent)val3.onClick).AddListener((UnityAction)(() =>
		{
			bool show = (Object)(object)settingsPanel == (Object)null || !settingsPanel.activeSelf;
			ToggleSettingsPanel(show);
		}));
		GameObject val4 = new GameObject("SettingsLabel");
		val4.transform.SetParent(val.transform, false);
		TextMeshProUGUI val5 = val4.AddComponent<TextMeshProUGUI>();
		((TMP_Text)val5).text = "设置";
		((TMP_Text)val5).fontSize = 20f;
		((TMP_Text)val5).alignment = (TextAlignmentOptions)514;
		((Graphic)val5).color = WarmUITheme.TextPrimary;
		((TMP_Text)val5).fontStyle = (FontStyles)1;
		((TMP_Text)val5).outlineColor = Color32.op_Implicit(WarmUITheme.TextOutline);
		((TMP_Text)val5).outlineWidth = 0.12f;
		ApplyDefaultFont(val5);
		RectTransform component = val4.GetComponent<RectTransform>();
		component.anchorMin = Vector2.zero;
		component.anchorMax = Vector2.one;
		component.offsetMin = Vector2.zero;
		component.offsetMax = Vector2.zero;
		return val3;
	}

	private GameObject CreateSettingsPanel(Transform parent)
	{
		//IL_0005: Unknown result type (might be due to invalid IL or missing references)
		//IL_000a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0017: Unknown result type (might be due to invalid IL or missing references)
		//IL_0028: Unknown result type (might be due to invalid IL or missing references)
		//IL_003d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0048: Unknown result type (might be due to invalid IL or missing references)
		//IL_0052: Unknown result type (might be due to invalid IL or missing references)
		//IL_005c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0062: Unknown result type (might be due to invalid IL or missing references)
		//IL_006c: Unknown result type (might be due to invalid IL or missing references)
		//IL_008e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0098: Expected Obj, but got Unknown
		//IL_00a6: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b6: Expected Obj, but got Unknown
		//IL_00c9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d9: Expected Obj, but got Unknown
		//IL_00de: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e6: Expected Obj, but got Unknown
		GameObject val = new GameObject("SettingsPanel");
		val.transform.SetParent(parent, false);
		RectTransform val2 = val.AddComponent<RectTransform>();
		val2.anchorMin = new Vector2(0.35f, 0.3f);
		val2.anchorMax = new Vector2(0.65f, 0.7f);
		val2.offsetMin = Vector2.zero;
		val2.offsetMax = Vector2.zero;
		((Graphic)val.AddComponent<Image>()).color = WarmUITheme.PanelDark;
		VerticalLayoutGroup val3 = val.AddComponent<VerticalLayoutGroup>();
		((LayoutGroup)val3).childAlignment = (TextAnchor)4;
		((HorizontalOrVerticalLayoutGroup)val3).spacing = 15f;
		((LayoutGroup)val3).padding = new RectOffset(20, 20, 20, 20);
		continueButton = CreateSettingsOptionButton("继续", HandleContinueClicked, ((Component)val3).transform);
		exitButton = CreateSettingsOptionButton("退出", HandleExitClicked, ((Component)val3).transform);
		val.SetActive(false);
		return val;
	}

	private Button CreateSettingsOptionButton(string label, UnityAction onClick, Transform parent)
	{
		//IL_000b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0011: Expected Obj, but got Unknown
		//IL_0024: Unknown result type (might be due to invalid IL or missing references)
		//IL_0050: Unknown result type (might be due to invalid IL or missing references)
		//IL_0080: Unknown result type (might be due to invalid IL or missing references)
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_0097: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bc: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ce: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f5: Unknown result type (might be due to invalid IL or missing references)
		//IL_0100: Unknown result type (might be due to invalid IL or missing references)
		//IL_010b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0115: Unknown result type (might be due to invalid IL or missing references)
		GameObject val = new GameObject(label + "Button");
		val.transform.SetParent(parent, false);
		((Graphic)val.AddComponent<Image>()).color = WarmUITheme.PanelDarker;
		Button val2 = val.AddComponent<Button>();
		((UnityEvent)val2.onClick).AddListener(onClick);
		val.GetComponent<RectTransform>().sizeDelta = new Vector2(0f, 60f);
		LayoutElement val3 = val.AddComponent<LayoutElement>();
		val3.preferredHeight = 60f;
		val3.flexibleWidth = 1f;
		GameObject val4 = new GameObject(label + "Text");
		val4.transform.SetParent(val.transform, false);
		TextMeshProUGUI val5 = val4.AddComponent<TextMeshProUGUI>();
		((TMP_Text)val5).text = label;
		((TMP_Text)val5).fontSize = 26f;
		((TMP_Text)val5).alignment = (TextAlignmentOptions)514;
		((Graphic)val5).color = WarmUITheme.TextPrimary;
		((TMP_Text)val5).fontStyle = (FontStyles)1;
		((TMP_Text)val5).outlineColor = Color32.op_Implicit(WarmUITheme.TextOutline);
		((TMP_Text)val5).outlineWidth = 0.12f;
		ApplyDefaultFont(val5);
		RectTransform component = val4.GetComponent<RectTransform>();
		component.anchorMin = Vector2.zero;
		component.anchorMax = Vector2.one;
		component.offsetMin = Vector2.zero;
		component.offsetMax = Vector2.zero;
		return val2;
	}

	private void ToggleSettingsPanel(bool show)
	{
		if (!((Object)(object)settingsPanel == (Object)null))
		{
			settingsPanel.SetActive(show);
		}
	}

	private void HandleContinueClicked()
	{
		ToggleSettingsPanel(show: false);
	}

	private void HandleExitClicked()
	{
		Application.Quit();
	}

	private void HideAllUI()
	{
		if ((Object)(object)dialoguePanel != (Object)null)
		{
			dialoguePanel.SetActive(false);
		}
		if ((Object)(object)itemInfoPanel != (Object)null)
		{
			itemInfoPanel.SetActive(false);
		}
		if ((Object)(object)interactionPrompt != (Object)null)
		{
			interactionPrompt.SetActive(false);
		}
		if ((Object)(object)settingsPanel != (Object)null)
		{
			settingsPanel.SetActive(false);
		}
	}

	private void UpdateGameInfo()
	{
		if ((Object)(object)gameTimeText != (Object)null && (Object)(object)GameProgressTracker.Instance != (Object)null)
		{
			float gameTime = GameProgressTracker.Instance.GetGameTime();
			int num = Mathf.FloorToInt(gameTime / 60f);
			int num2 = Mathf.FloorToInt(gameTime % 60f);
			((TMP_Text)gameTimeText).text = $"时间: {num:00}:{num2:00}";
		}
		if ((Object)(object)itemsCollectedText != (Object)null && (Object)(object)GameProgressTracker.Instance != (Object)null)
		{
			int itemsCollected = GameProgressTracker.Instance.GetItemsCollected();
			((TMP_Text)itemsCollectedText).text = $"物品: {itemsCollected}";
		}
		if ((Object)(object)coinsCollectedText != (Object)null && (Object)(object)GameProgressTracker.Instance != (Object)null)
		{
			int coinsCollected = GameProgressTracker.Instance.GetCoinsCollected();
			((TMP_Text)coinsCollectedText).text = $"金币: {coinsCollected}";
		}
	}

	public GameObject GetDialoguePanel()
	{
		return dialoguePanel;
	}

	public TextMeshProUGUI GetDialogueText()
	{
		return dialogueText;
	}

	public GameObject GetItemInfoPanel()
	{
		return itemInfoPanel;
	}

	public TextMeshProUGUI GetItemNameText()
	{
		return itemNameText;
	}

	public TextMeshProUGUI GetItemDescriptionText()
	{
		return itemDescriptionText;
	}

	public Image GetItemIconImage()
	{
		return itemIconImage;
	}

	public GameObject GetInteractionPrompt()
	{
		return interactionPrompt;
	}

	public TextMeshProUGUI GetPromptText()
	{
		return promptText;
	}

	public TMP_FontAsset GetDefaultFontAsset()
	{
		return defaultFontAsset;
	}

	public Canvas GetOrCreateCanvas()
	{
		//IL_0033: Unknown result type (might be due to invalid IL or missing references)
		//IL_0039: Expected Obj, but got Unknown
		if ((Object)(object)uiCanvas != (Object)null)
		{
			return uiCanvas;
		}
		uiCanvas = Object.FindObjectOfType<Canvas>();
		if ((Object)(object)uiCanvas == (Object)null)
		{
			GameObject val = new GameObject("Canvas");
			uiCanvas = val.AddComponent<Canvas>();
			uiCanvas.renderMode = (RenderMode)0;
			CanvasScaler scaler = val.AddComponent<CanvasScaler>();
			ConfigureCanvasScaler(scaler);
			val.AddComponent<GraphicRaycaster>();
		}
		else
		{
			CanvasScaler val2 = ((Component)uiCanvas).GetComponent<CanvasScaler>();
			if ((Object)(object)val2 == (Object)null)
			{
				val2 = ((Component)uiCanvas).gameObject.AddComponent<CanvasScaler>();
			}
			ConfigureCanvasScaler(val2);
			if ((Object)(object)((Component)uiCanvas).GetComponent<GraphicRaycaster>() == (Object)null)
			{
				((Component)uiCanvas).gameObject.AddComponent<GraphicRaycaster>();
			}
		}
		return uiCanvas;
	}

	private void ApplyDefaultFont(TextMeshProUGUI text)
	{
		if ((Object)(object)text != (Object)null && (Object)(object)defaultFontAsset != (Object)null)
		{
			((TMP_Text)text).font = defaultFontAsset;
		}
	}

	private void ConfigureCanvasScaler(CanvasScaler scaler)
	{
		//IL_001c: Unknown result type (might be due to invalid IL or missing references)
		if (!((Object)(object)scaler == (Object)null))
		{
			scaler.uiScaleMode = (ScaleMode)1;
			scaler.referenceResolution = new Vector2(1920f, 1080f);
			scaler.screenMatchMode = (ScreenMatchMode)0;
			scaler.matchWidthOrHeight = 0.5f;
		}
	}
}
public class InteractionButtons : MonoBehaviour
{
	[Header("按钮设置")]
	[SerializeField]
	private Button interactButton;

	[SerializeField]
	private Button pickupButton;

	[SerializeField]
	private Button jumpButton;

	[SerializeField]
	private TextMeshProUGUI interactButtonText;

	[SerializeField]
	private TextMeshProUGUI pickupButtonText;

	[SerializeField]
	private TextMeshProUGUI jumpButtonText;

	[SerializeField]
	[Header("外观设置")]
	private TMP_FontAsset buttonFontAsset;

	[SerializeField]
	private float buttonSize = 140f;

	[SerializeField]
	private Color buttonColor = new Color(0.2f, 0.6f, 0.9f, 0.8f);

	[SerializeField]
	private Vector2 interactAnchor = new Vector2(0.9f, 0.26f);

	[SerializeField]
	private Vector2 pickupAnchor = new Vector2(0.9f, 0.08f);

	[SerializeField]
	private Vector2 jumpAnchor = new Vector2(0.74f, 0.08f);

	private Canvas canvas;

	private RectTransform interactButtonRect;

	private RectTransform pickupButtonRect;

	private RectTransform jumpButtonRect;

	public static InteractionButtons Instance { get; private set; }

	private void Awake()
	{
		if ((Object)(object)Instance == (Object)null)
		{
			Instance = this;
			CreateButtons();
		}
		else
		{
			Object.Destroy((Object)(object)((Component)this).gameObject);
		}
	}

	private void Start()
	{
		if ((Object)(object)interactButton == (Object)null || (Object)(object)pickupButton == (Object)null || (Object)(object)jumpButton == (Object)null)
		{
			CreateButtons();
		}
	}

	private void CreateButtons()
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Unknown result type (might be due to invalid IL or missing references)
		//IL_0048: Unknown result type (might be due to invalid IL or missing references)
		//IL_004e: Expected Obj, but got Unknown
		//IL_0095: Unknown result type (might be due to invalid IL or missing references)
		//IL_009a: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00da: Unknown result type (might be due to invalid IL or missing references)
		//IL_0115: Unknown result type (might be due to invalid IL or missing references)
		//IL_011a: Unknown result type (might be due to invalid IL or missing references)
		buttonColor = WarmUITheme.ButtonFill;
		EnsureGameUIManagerExists();
		canvas = (((Object)(object)GameUIManager.Instance != (Object)null) ? GameUIManager.Instance.GetOrCreateCanvas() : Object.FindObjectOfType<Canvas>());
		if ((Object)(object)canvas == (Object)null)
		{
			GameObject val = new GameObject("Canvas");
			canvas = val.AddComponent<Canvas>();
			canvas.renderMode = (RenderMode)0;
			val.AddComponent<CanvasScaler>();
			val.AddComponent<GraphicRaycaster>();
		}
		EnsureEventSystem();
		if ((Object)(object)interactButton == (Object)null)
		{
			interactButton = CreateButton("InteractButton", "开门", interactAnchor, WarmUITheme.ButtonFill);
			interactButtonRect = ((Component)interactButton).GetComponent<RectTransform>();
		}
		if ((Object)(object)pickupButton == (Object)null)
		{
			pickupButton = CreateButton("PickupButton", "拾取", pickupAnchor, WarmUITheme.ButtonFillSecondary);
			pickupButtonRect = ((Component)pickupButton).GetComponent<RectTransform>();
		}
		if ((Object)(object)jumpButton == (Object)null)
		{
			jumpButton = CreateButton("JumpButton", "跳跃", jumpAnchor, WarmUITheme.ButtonFill);
			jumpButtonRect = ((Component)jumpButton).GetComponent<RectTransform>();
			WireJumpButton(jumpButton);
		}
	}

	private void EnsureGameUIManagerExists()
	{
		//IL_0021: Unknown result type (might be due to invalid IL or missing references)
		if (!((Object)(object)GameUIManager.Instance != (Object)null) && !((Object)(object)Object.FindObjectOfType<GameUIManager>() != (Object)null))
		{
			new GameObject("GameUIManager").AddComponent<GameUIManager>();
		}
	}

	private Button CreateButton(string name, string text, Vector2 anchorPosition, Color fillColor)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Expected Obj, but got Unknown
		//IL_0025: Unknown result type (might be due to invalid IL or missing references)
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_003d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0054: Unknown result type (might be due to invalid IL or missing references)
		//IL_005e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0070: Unknown result type (might be due to invalid IL or missing references)
		//IL_0087: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ac: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00dd: Unknown result type (might be due to invalid IL or missing references)
		//IL_0105: Unknown result type (might be due to invalid IL or missing references)
		//IL_010a: Unknown result type (might be due to invalid IL or missing references)
		//IL_013f: Unknown result type (might be due to invalid IL or missing references)
		//IL_014a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0155: Unknown result type (might be due to invalid IL or missing references)
		//IL_015f: Unknown result type (might be due to invalid IL or missing references)
		GameObject val = new GameObject(name);
		val.transform.SetParent(((Component)canvas).transform, false);
		RectTransform val2 = val.AddComponent<RectTransform>();
		val2.anchorMin = anchorPosition;
		val2.anchorMax = anchorPosition;
		val2.pivot = new Vector2(0.5f, 0.5f);
		val2.sizeDelta = new Vector2(buttonSize, buttonSize);
		val2.anchoredPosition = Vector2.zero;
		Image val3 = val.AddComponent<Image>();
		((Graphic)val3).color = fillColor;
		int num = Mathf.RoundToInt(buttonSize);
		val3.sprite = CreateCircleSprite(num, num, fillColor);
		val3.preserveAspect = true;
		Button val4 = val.AddComponent<Button>();
		((Selectable)val4).targetGraphic = (Graphic)(object)val3;
		GameObject val5 = new GameObject("Text");
		val5.transform.SetParent(val.transform, false);
		TextMeshProUGUI val6 = val5.AddComponent<TextMeshProUGUI>();
		((TMP_Text)val6).text = text;
		((TMP_Text)val6).fontSize = 22f;
		((Graphic)val6).color = WarmUITheme.TextPrimary;
		((TMP_Text)val6).alignment = (TextAlignmentOptions)514;
		((TMP_Text)val6).verticalAlignment = (VerticalAlignmentOptions)512;
		((TMP_Text)val6).fontStyle = (FontStyles)1;
		((TMP_Text)val6).outlineColor = Color32.op_Implicit(WarmUITheme.TextOutline);
		((TMP_Text)val6).outlineWidth = 0.2f;
		TMP_FontAsset val7 = ResolveButtonFont();
		if ((Object)(object)val7 != (Object)null)
		{
			((TMP_Text)val6).font = val7;
		}
		RectTransform component = val5.GetComponent<RectTransform>();
		component.anchorMin = Vector2.zero;
		component.anchorMax = Vector2.one;
		component.offsetMin = Vector2.zero;
		component.offsetMax = Vector2.zero;
		switch (name)
		{
		case "InteractButton":
			interactButtonText = val6;
			return val4;
		case "PickupButton":
			pickupButtonText = val6;
			return val4;
		case "JumpButton":
			jumpButtonText = val6;
			break;
		}
		return val4;
	}

	private void EnsureEventSystem()
	{
		//IL_0013: Unknown result type (might be due to invalid IL or missing references)
		//IL_0018: Unknown result type (might be due to invalid IL or missing references)
		if (!((Object)(object)Object.FindObjectOfType<EventSystem>() != (Object)null))
		{
			GameObject val = new GameObject("EventSystem");
			val.AddComponent<EventSystem>();
			val.AddComponent<StandaloneInputModule>();
		}
	}

	private void WireJumpButton(Button button)
	{
		//IL_004d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0052: Unknown result type (might be due to invalid IL or missing references)
		//IL_0054: Unknown result type (might be due to invalid IL or missing references)
		//IL_005a: Expected Obj, but got Unknown
		if (!((Object)(object)button == (Object)null))
		{
			EventTrigger val = ((Component)button).gameObject.GetComponent<EventTrigger>();
			if ((Object)(object)val == (Object)null)
			{
				val = ((Component)button).gameObject.AddComponent<EventTrigger>();
			}
			EventTrigger val2 = val;
			if (val2.triggers == null)
			{
				List<Entry> list = (val2.triggers = new List<Entry>());
			}
			val.triggers.Clear();
			Entry val3 = new Entry
			{
				eventID = (EventTriggerType)2
			};
			((UnityEvent<BaseEventData>)(object)val3.callback).AddListener((UnityAction<BaseEventData>)((BaseEventData _) =>
			{
				MobileInputController.Instance?.QueueJump();
			}));
			val.triggers.Add(val3);
		}
	}

	private TMP_FontAsset ResolveButtonFont()
	{
		if ((Object)(object)buttonFontAsset != (Object)null)
		{
			return buttonFontAsset;
		}
		if ((Object)(object)GameUIManager.Instance != (Object)null)
		{
			return GameUIManager.Instance.GetDefaultFontAsset();
		}
		return null;
	}

	public void ShowInteractButton(string buttonText = "开门")
	{
		if ((Object)(object)interactButton != (Object)null)
		{
			((Component)interactButton).gameObject.SetActive(true);
			if ((Object)(object)interactButtonText != (Object)null)
			{
				((TMP_Text)interactButtonText).text = buttonText;
			}
		}
	}

	public void ShowPickupButton(string buttonText = "拾取")
	{
		if ((Object)(object)pickupButton != (Object)null)
		{
			((Component)pickupButton).gameObject.SetActive(true);
			if ((Object)(object)pickupButtonText != (Object)null)
			{
				((TMP_Text)pickupButtonText).text = buttonText;
			}
		}
	}

	public void HideInteractButton()
	{
		if ((Object)(object)interactButton != (Object)null)
		{
			((Component)interactButton).gameObject.SetActive(true);
		}
	}

	public void HidePickupButton()
	{
		if ((Object)(object)pickupButton != (Object)null)
		{
			((Component)pickupButton).gameObject.SetActive(true);
		}
	}

	public void HideAllButtons()
	{
		HideInteractButton();
		HidePickupButton();
	}

	public Button GetInteractButton()
	{
		return interactButton;
	}

	public Button GetPickupButton()
	{
		return pickupButton;
	}

	public Button GetJumpButton()
	{
		return jumpButton;
	}

	private Sprite CreateCircleSprite(int width, int height, Color color)
	{
		//IL_0004: Unknown result type (might be due to invalid IL or missing references)
		//IL_000a: Expected Obj, but got Unknown
		//IL_001c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0041: Unknown result type (might be due to invalid IL or missing references)
		//IL_0046: Unknown result type (might be due to invalid IL or missing references)
		//IL_0100: Unknown result type (might be due to invalid IL or missing references)
		//IL_010f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0068: Unknown result type (might be due to invalid IL or missing references)
		//IL_006d: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a6: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ac: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b8: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c6: Unknown result type (might be due to invalid IL or missing references)
		Texture2D val = new Texture2D(width, height, (TextureFormat)4, false);
		Vector2 val2 = new Vector2((float)width / 2f, (float)height / 2f);
		float num = (float)Mathf.Min(width, height) / 2f;
		Color[] array = new Color[width * height];
		for (int i = 0; i < array.Length; i++)
		{
			array[i] = Color.clear;
		}
		for (int j = 0; j < height; j++)
		{
			for (int k = 0; k < width; k++)
			{
				float num2 = Vector2.Distance(new Vector2((float)k, (float)j), val2);
				if (num2 <= num)
				{
					float num3 = 1f;
					if (num2 > num - 1f)
					{
						num3 = 1f - (num2 - (num - 1f));
					}
					array[j * width + k] = new Color(color.r, color.g, color.b, color.a * num3);
				}
			}
		}
		val.SetPixels(array);
		val.Apply();
		return Sprite.Create(val, new Rect(0f, 0f, (float)width, (float)height), new Vector2(0.5f, 0.5f), 100f);
	}

	public InteractionButtons()
	{
		//IL_0020: Unknown result type (might be due to invalid IL or missing references)
		//IL_0025: Unknown result type (might be due to invalid IL or missing references)
		//IL_0035: Unknown result type (might be due to invalid IL or missing references)
		//IL_003a: Unknown result type (might be due to invalid IL or missing references)
		//IL_004a: Unknown result type (might be due to invalid IL or missing references)
		//IL_004f: Unknown result type (might be due to invalid IL or missing references)
		//IL_005f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0064: Unknown result type (might be due to invalid IL or missing references)
	}
}
public class InteractionSystem : MonoBehaviour
{
	[SerializeField]
	[Header("交互设置")]
	private float interactionRange = 2f;

	[SerializeField]
	private KeyCode interactKey = (KeyCode)101;

	[SerializeField]
	private KeyCode pickupKey = (KeyCode)102;

	[SerializeField]
	private LayerMask interactableLayer = LayerMask.op_Implicit(-1);

	private GameObject interactionPrompt;

	private TextMeshProUGUI promptText;

	private Camera playerCamera;

	private Interactable currentInteractable;

	private void Awake()
	{
	}

	private void Start()
	{
		playerCamera = Camera.main;
		if ((Object)(object)playerCamera == (Object)null)
		{
			playerCamera = Object.FindObjectOfType<Camera>();
		}
		InitializeUIReferences();
		InitializeInteractionButtons();
	}

	private void InitializeInteractionButtons()
	{
		//IL_0012: Unknown result type (might be due to invalid IL or missing references)
		//IL_0056: Unknown result type (might be due to invalid IL or missing references)
		//IL_0060: Expected Obj, but got Unknown
		//IL_008c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0096: Expected Obj, but got Unknown
		if ((Object)(object)InteractionButtons.Instance == (Object)null)
		{
			new GameObject("InteractionButtons").AddComponent<InteractionButtons>();
		}
		if ((Object)(object)InteractionButtons.Instance != (Object)null)
		{
			Button interactButton = InteractionButtons.Instance.GetInteractButton();
			if ((Object)(object)interactButton != (Object)null)
			{
				((UnityEventBase)interactButton.onClick).RemoveAllListeners();
				((UnityEvent)interactButton.onClick).AddListener((UnityAction)OnInteractButtonClicked);
			}
			Button pickupButton = InteractionButtons.Instance.GetPickupButton();
			if ((Object)(object)pickupButton != (Object)null)
			{
				((UnityEventBase)pickupButton.onClick).RemoveAllListeners();
				((UnityEvent)pickupButton.onClick).AddListener((UnityAction)OnPickupButtonClicked);
			}
		}
	}

	private void OnInteractButtonClicked()
	{
		if ((Object)(object)currentInteractable != (Object)null && currentInteractable is DoorInteractable)
		{
			currentInteractable.Interact();
		}
	}

	private void OnPickupButtonClicked()
	{
		if ((Object)(object)currentInteractable != (Object)null && currentInteractable is ItemPickup)
		{
			currentInteractable.Interact();
		}
	}

	private void InitializeUIReferences()
	{
		if ((Object)(object)GameUIManager.Instance != (Object)null)
		{
			interactionPrompt = GameUIManager.Instance.GetInteractionPrompt();
			promptText = GameUIManager.Instance.GetPromptText();
		}
		if ((Object)(object)interactionPrompt == (Object)null)
		{
			((MonoBehaviour)this).StartCoroutine(DelayedUIInitialization());
		}
		else
		{
			interactionPrompt.SetActive(false);
		}
	}

	private IEnumerator DelayedUIInitialization()
	{
		while ((Object)(object)GameUIManager.Instance == (Object)null || (Object)(object)GameUIManager.Instance.GetInteractionPrompt() == (Object)null)
		{
			yield return null;
		}
		interactionPrompt = GameUIManager.Instance.GetInteractionPrompt();
		promptText = GameUIManager.Instance.GetPromptText();
		if ((Object)(object)interactionPrompt != (Object)null)
		{
			interactionPrompt.SetActive(false);
		}
	}

	private void Update()
	{
		CheckForInteractables();
		HandleInput();
	}

	private void CheckForInteractables()
	{
		//IL_0022: Unknown result type (might be due to invalid IL or missing references)
		//IL_0032: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Unknown result type (might be due to invalid IL or missing references)
		//IL_0045: Unknown result type (might be due to invalid IL or missing references)
		//IL_009d: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ed: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f9: Unknown result type (might be due to invalid IL or missing references)
		if ((Object)(object)playerCamera == (Object)null)
		{
			return;
		}
		Interactable interactable = null;
		float num = float.MaxValue;
		RaycastHit val = default;
		if (Physics.Raycast(new Ray(((Component)playerCamera).transform.position, ((Component)playerCamera).transform.forward), ref val, interactionRange, LayerMask.op_Implicit(interactableLayer)))
		{
			Interactable component = ((Component)val.collider).GetComponent<Interactable>();
			if ((Object)(object)component != (Object)null && component.CanInteract())
			{
				interactable = component;
				num = val.distance;
			}
		}
		if ((Object)(object)interactable == (Object)null || !(interactable is ItemPickup))
		{
			Collider[] array = Physics.OverlapSphere(((Component)playerCamera).transform.position, interactionRange, LayerMask.op_Implicit(interactableLayer));
			foreach (Collider val2 in array)
			{
				ItemPickup component2 = ((Component)val2).GetComponent<ItemPickup>();
				if ((Object)(object)component2 != (Object)null && component2.CanInteract())
				{
					float num2 = Vector3.Distance(((Component)playerCamera).transform.position, ((Component)val2).transform.position);
					if (num2 < num)
					{
						interactable = component2;
						num = num2;
					}
				}
			}
		}
		if ((Object)(object)interactable != (Object)null && interactable.CanInteract())
		{
			currentInteractable = interactable;
			ShowInteractionPrompt(interactable.GetPromptText());
		}
		else
		{
			currentInteractable = null;
			HideInteractionPrompt();
		}
	}

	private void HandleInput()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0053: Unknown result type (might be due to invalid IL or missing references)
		if ((Object)(object)currentInteractable == (Object)null)
		{
			if ((Object)(object)InteractionButtons.Instance != (Object)null)
			{
				InteractionButtons.Instance.HideAllButtons();
			}
			return;
		}
		UpdateButtons();
		if (LegacyInputCompat.GetKeyDown(interactKey))
		{
			if (currentInteractable is DoorInteractable)
			{
				currentInteractable.Interact();
			}
		}
		else if (LegacyInputCompat.GetKeyDown(pickupKey) && currentInteractable is ItemPickup)
		{
			currentInteractable.Interact();
		}
	}

	private void UpdateButtons()
	{
		if (!((Object)(object)InteractionButtons.Instance == (Object)null))
		{
			if (currentInteractable is DoorInteractable)
			{
				InteractionButtons.Instance.ShowInteractButton();
				InteractionButtons.Instance.HidePickupButton();
			}
			else if (currentInteractable is ItemPickup)
			{
				InteractionButtons.Instance.HideInteractButton();
				InteractionButtons.Instance.ShowPickupButton();
			}
			else
			{
				InteractionButtons.Instance.HideAllButtons();
			}
		}
	}

	private void ShowInteractionPrompt(string text)
	{
		if ((Object)(object)interactionPrompt != (Object)null)
		{
			interactionPrompt.SetActive(true);
			if ((Object)(object)promptText != (Object)null)
			{
				((TMP_Text)promptText).text = text;
			}
		}
	}

	private void HideInteractionPrompt()
	{
		if ((Object)(object)interactionPrompt != (Object)null)
		{
			interactionPrompt.SetActive(false);
		}
	}

	public InteractionSystem()
	{
		//IL_000e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0016: Unknown result type (might be due to invalid IL or missing references)
		//IL_001d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0022: Unknown result type (might be due to invalid IL or missing references)
	}
}
public abstract class Interactable : MonoBehaviour
{
	[Header("交互设置")]
	[SerializeField]
	protected string promptText = "按 [开门] 按钮交互";

	[SerializeField]
	protected bool canInteractMultipleTimes;

	[SerializeField]
	protected bool hasBeenInteracted;

	public abstract void Interact();

	public abstract bool CanInteract();

	public virtual string GetPromptText()
	{
		return promptText;
	}
}
public class ItemPickup : Interactable
{
	[Serializable]
	public class ItemData
	{
		public string itemName;

		[TextArea(3, 5)]
		public string itemDescription;

		public Sprite itemIcon;
	}

	[SerializeField]
	[Header("物品信息")]
	private ItemData itemData;

	[Header("距离检测")]
	[SerializeField]
	private float detectionRange = 3f;

	[SerializeField]
	[Header("音效")]
	private bool playPickupSound = true;

	[SerializeField]
	private string pickupSoundName = "item_pickup";

	private bool isPickedUp;

	private Transform playerTransform;

	public ItemData Data => itemData;

	public string ItemName
	{
		get
		{
			if (itemData == null)
			{
				return string.Empty;
			}
			return itemData.itemName;
		}
	}

	public string ItemDescription
	{
		get
		{
			if (itemData == null)
			{
				return string.Empty;
			}
			return itemData.itemDescription;
		}
	}

	public Sprite ItemIcon
	{
		get
		{
			if (itemData == null)
			{
				return null;
			}
			return itemData.itemIcon;
		}
	}

	public override void Interact()
	{
		if (CanInteract() && !isPickedUp)
		{
			PickupItem();
		}
	}

	public override bool CanInteract()
	{
		//IL_006b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0076: Unknown result type (might be due to invalid IL or missing references)
		if (isPickedUp)
		{
			return false;
		}
		if ((Object)(object)playerTransform == (Object)null)
		{
			GameObject val = GameObject.FindGameObjectWithTag("Player");
			if ((Object)(object)val != (Object)null)
			{
				playerTransform = val.transform;
			}
			else
			{
				Camera main = Camera.main;
				if ((Object)(object)main != (Object)null)
				{
					playerTransform = ((Component)main).transform;
				}
			}
		}
		if ((Object)(object)playerTransform == (Object)null)
		{
			return false;
		}
		return Vector3.Distance(((Component)this).transform.position, playerTransform.position) <= detectionRange;
	}

	public override string GetPromptText()
	{
		return "按 [拾取] 按钮拾取 " + itemData.itemName;
	}

	private void PickupItem()
	{
		isPickedUp = true;
		hasBeenInteracted = true;
		((MonoBehaviour)this).StartCoroutine(UpdateGameProgress());
		NotifyTreasureHuntGame();
		if (playPickupSound && !string.IsNullOrEmpty(pickupSoundName))
		{
			AudioManager.Instance?.PlaySFX(pickupSoundName);
		}
		((MonoBehaviour)this).StartCoroutine(HideItemAfterDelay());
	}

	private IEnumerator HideItemAfterDelay()
	{
		yield return (object)new WaitForSeconds(0.5f);
		((Component)this).gameObject.SetActive(false);
	}

	private IEnumerator UpdateGameProgress()
	{
		yield return (object)new WaitForEndOfFrame();
		yield return null;
		GameProgressTracker gameProgressTracker = Object.FindObjectOfType<GameProgressTracker>();
		if ((Object)(object)gameProgressTracker != (Object)null)
		{
			gameProgressTracker.SetItemPickedUp(value: true);
		}
		GameFlowManager gameFlowManager = Object.FindObjectOfType<GameFlowManager>();
		if ((Object)(object)gameFlowManager != (Object)null)
		{
			gameFlowManager.CheckGameCompletion();
		}
	}

	private void NotifyTreasureHuntGame()
	{
		if (itemData != null)
		{
			((MonoBehaviour)this).StartCoroutine(DelayedNotifyTreasureHuntGame());
		}
	}

	private IEnumerator DelayedNotifyTreasureHuntGame()
	{
		yield return (object)new WaitForEndOfFrame();
		yield return null;
		MonoBehaviour[] array = Object.FindObjectsOfType<MonoBehaviour>();
		foreach (MonoBehaviour val in array)
		{
			if (((object)val).GetType().Name == "TreasureHuntGame")
			{
				MethodInfo method = ((object)val).GetType().GetMethod("OnItemCollected", BindingFlags.Instance | BindingFlags.Public);
				if (method != null)
				{
					method.Invoke(val, new object[1] { itemData.itemName });
					Debug.Log((object)("通知探宝游戏：拾取物品 " + itemData.itemName));
					break;
				}
			}
		}
	}
}
public class MobileInputController : MonoBehaviour
{
	[Min(0.1f)]
	[SerializeField]
	[Header("触摸设置")]
	private float touchSensitivity = 3.5f;

	[SerializeField]
	private bool invertY;

	private const float pixelToRotationScale = 0.02f;

	private VirtualJoystick virtualJoystick;

	private Vector2 lastTouchPosition;

	private Vector2 touchDelta;

	private bool isDragging;

	private int touchFingerId = -1;

	private float horizontalInput;

	private float verticalInput;

	private float mouseXInput;

	private float mouseYInput;

	private bool jumpQueued;

	public static MobileInputController Instance { get; private set; }

	private void Awake()
	{
		if ((Object)(object)Instance == (Object)null)
		{
			Instance = this;
		}
		else
		{
			Object.Destroy((Object)(object)((Component)this).gameObject);
		}
	}

	private void Start()
	{
		((MonoBehaviour)this).StartCoroutine(FindJoystickDelayed());
	}

	private IEnumerator FindJoystickDelayed()
	{
		yield return null;
		virtualJoystick = Object.FindObjectOfType<VirtualJoystick>();
		if ((Object)(object)virtualJoystick == (Object)null)
		{
			GameObject val = new GameObject("VirtualJoystick");
			virtualJoystick = val.AddComponent<VirtualJoystick>();
			yield return null;
			virtualJoystick = Object.FindObjectOfType<VirtualJoystick>();
		}
	}

	private void Update()
	{
		HandleTouchInput();
		if (!Application.isMobilePlatform && LegacyInputCompat.touchCount == 0)
		{
			HandleMouseAsTouch();
		}
	}

	private void HandleTouchInput()
	{
		//IL_003c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0041: Unknown result type (might be due to invalid IL or missing references)
		//IL_0098: Unknown result type (might be due to invalid IL or missing references)
		//IL_009d: Unknown result type (might be due to invalid IL or missing references)
		//IL_009e: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b8: Expected I4, but got Unknown
		//IL_0065: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c8: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ec: Unknown result type (might be due to invalid IL or missing references)
		//IL_0119: Unknown result type (might be due to invalid IL or missing references)
		//IL_011f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0124: Unknown result type (might be due to invalid IL or missing references)
		//IL_0129: Unknown result type (might be due to invalid IL or missing references)
		//IL_017b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0180: Unknown result type (might be due to invalid IL or missing references)
		if ((Object)(object)virtualJoystick != (Object)null)
		{
			horizontalInput = virtualJoystick.GetHorizontal();
			verticalInput = virtualJoystick.GetVertical();
		}
		if (LegacyInputCompat.touchCount <= 0)
		{
			return;
		}
		Touch touch = LegacyInputCompat.GetTouch(0);
		if ((Object)(object)EventSystem.current != (Object)null && EventSystem.current.IsPointerOverGameObject(touch.fingerId) && !IsTouchOnJoystick(touch.position))
		{
			isDragging = false;
			touchFingerId = -1;
			mouseXInput = 0f;
			mouseYInput = 0f;
			return;
		}
		TouchPhase phase = touch.phase;
		switch ((int)phase)
		{
		case 0:
			if (touchFingerId == -1 && !IsTouchOnJoystick(touch.position))
			{
				touchFingerId = touch.fingerId;
				lastTouchPosition = touch.position;
				isDragging = true;
			}
			break;
		case 1:
			if (touch.fingerId == touchFingerId && isDragging)
			{
				touchDelta = touch.position - lastTouchPosition;
				mouseXInput = touchDelta.x * touchSensitivity * 0.02f;
				mouseYInput = (float)((!invertY) ? 1 : (-1)) * touchDelta.y * touchSensitivity * 0.02f;
				lastTouchPosition = touch.position;
			}
			break;
		case 3:
		case 4:
			if (touch.fingerId == touchFingerId)
			{
				isDragging = false;
				touchFingerId = -1;
				mouseXInput = 0f;
				mouseYInput = 0f;
			}
			break;
		case 2:
			break;
		}
	}

	private void HandleMouseAsTouch()
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0005: Unknown result type (might be due to invalid IL or missing references)
		//IL_000a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0064: Unknown result type (might be due to invalid IL or missing references)
		//IL_0025: Unknown result type (might be due to invalid IL or missing references)
		//IL_002e: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ae: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ba: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fa: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fc: Unknown result type (might be due to invalid IL or missing references)
		//IL_0101: Unknown result type (might be due to invalid IL or missing references)
		//IL_0106: Unknown result type (might be due to invalid IL or missing references)
		//IL_00cd: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ce: Unknown result type (might be due to invalid IL or missing references)
		//IL_0156: Unknown result type (might be due to invalid IL or missing references)
		//IL_0157: Unknown result type (might be due to invalid IL or missing references)
		Vector2 val = Vector2.op_Implicit(LegacyInputCompat.mousePosition);
		if ((Object)(object)EventSystem.current != (Object)null && EventSystem.current.IsPointerOverGameObject() && !IsTouchOnJoystick(val) && !IsTouchOnInteractionButton(val))
		{
			if (!LegacyInputCompat.GetMouseButton(0))
			{
				isDragging = false;
				touchFingerId = -1;
				mouseXInput = 0f;
				mouseYInput = 0f;
			}
		}
		else if (IsTouchOnInteractionButton(val))
		{
			if (!LegacyInputCompat.GetMouseButton(0))
			{
				isDragging = false;
				touchFingerId = -1;
				mouseXInput = 0f;
				mouseYInput = 0f;
			}
		}
		else if (LegacyInputCompat.GetMouseButtonDown(0))
		{
			if (touchFingerId == -1 && !IsTouchOnJoystick(val) && !IsTouchOnInteractionButton(val))
			{
				touchFingerId = 0;
				lastTouchPosition = val;
				isDragging = true;
			}
		}
		else if (LegacyInputCompat.GetMouseButton(0))
		{
			if (touchFingerId == 0 && isDragging)
			{
				touchDelta = val - lastTouchPosition;
				mouseXInput = touchDelta.x * touchSensitivity * 0.02f;
				mouseYInput = (float)((!invertY) ? 1 : (-1)) * touchDelta.y * touchSensitivity * 0.02f;
				lastTouchPosition = val;
			}
		}
		else if (LegacyInputCompat.GetMouseButtonUp(0))
		{
			if (touchFingerId == 0)
			{
				isDragging = false;
				touchFingerId = -1;
				mouseXInput = 0f;
				mouseYInput = 0f;
			}
		}
		else if (touchFingerId == 0)
		{
			isDragging = false;
			touchFingerId = -1;
			mouseXInput = 0f;
			mouseYInput = 0f;
		}
	}

	private bool IsTouchOnJoystick(Vector2 screenPosition)
	{
		//IL_0028: Unknown result type (might be due to invalid IL or missing references)
		//IL_0033: Unknown result type (might be due to invalid IL or missing references)
		//IL_0038: Unknown result type (might be due to invalid IL or missing references)
		//IL_003b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0045: Unknown result type (might be due to invalid IL or missing references)
		//IL_004a: Unknown result type (might be due to invalid IL or missing references)
		//IL_004b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0056: Unknown result type (might be due to invalid IL or missing references)
		//IL_005e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0069: Unknown result type (might be due to invalid IL or missing references)
		if ((Object)(object)virtualJoystick == (Object)null)
		{
			return false;
		}
		RectTransform joystickBackground = virtualJoystick.JoystickBackground;
		if ((Object)(object)joystickBackground == (Object)null)
		{
			return false;
		}
		Vector2 val = default;
		RectTransformUtility.ScreenPointToLocalPointInRectangle(joystickBackground, screenPosition, (Camera)null, ref val);
		Rect rect = joystickBackground.rect;
		Vector2 val2 = rect.size * 0.5f;
		if (Mathf.Abs(val.x) <= val2.x)
		{
			return Mathf.Abs(val.y) <= val2.y;
		}
		return false;
	}

	private bool IsTouchOnInteractionButton(Vector2 screenPosition)
	{
		//IL_001c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0025: Unknown result type (might be due to invalid IL or missing references)
		float num = Screen.width;
		float num2 = Screen.height;
		float num3 = num * 0.85f;
		float num4 = num2 * 0.25f;
		if (screenPosition.x >= num3)
		{
			return screenPosition.y <= num4;
		}
		return false;
	}

	public float GetHorizontal()
	{
		return horizontalInput;
	}

	public float GetVertical()
	{
		return verticalInput;
	}

	public float GetMouseX()
	{
		return mouseXInput;
	}

	public float GetMouseY()
	{
		return mouseYInput;
	}

	public void QueueJump()
	{
		jumpQueued = true;
	}

	public bool ConsumeJumpQueued()
	{
		if (!jumpQueued)
		{
			return false;
		}
		jumpQueued = false;
		return true;
	}

	public bool IsMobile()
	{
		return true;
	}
}
public class NarrativeGameSetup : MonoBehaviour
{
	[SerializeField]
	[Header("场景区域标记")]
	private Transform darkRoomMarker;

	[SerializeField]
	private Transform shadowCorridorMarker;

	[SerializeField]
	[Header("触发器引用")]
	private NarrativeTrigger startStoryTrigger;

	[SerializeField]
	private NarrativeTrigger corridorSoundTrigger;

	[SerializeField]
	private NarrativeTrigger ghostAppearanceTrigger;

	[SerializeField]
	[Header("交互对象")]
	private DoorInteractable doorInteractable;

	[SerializeField]
	private ItemPickup[] itemPickups;

	private void Start()
	{
		SetupNarrativeSystem();
	}

	private void SetupNarrativeSystem()
	{
		//IL_0014: Unknown result type (might be due to invalid IL or missing references)
		//IL_0041: Unknown result type (might be due to invalid IL or missing references)
		//IL_005d: Unknown result type (might be due to invalid IL or missing references)
		//IL_007a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0097: Unknown result type (might be due to invalid IL or missing references)
		if ((Object)(object)darkRoomMarker != (Object)null)
		{
			darkRoomMarker.position = Vector3.zero;
		}
		if ((Object)(object)shadowCorridorMarker != (Object)null)
		{
			shadowCorridorMarker.position = new Vector3(10f, 0f, 0f);
		}
		if ((Object)(object)AudioManager.Instance == (Object)null)
		{
			new GameObject("AudioManager").AddComponent<AudioManager>();
		}
		if ((Object)(object)CameraController.Instance == (Object)null)
		{
			new GameObject("CameraController").AddComponent<CameraController>();
		}
		if ((Object)(object)NarrativeManager.Instance == (Object)null)
		{
			new GameObject("NarrativeManager").AddComponent<NarrativeManager>();
		}
		Debug.Log((object)"叙事系统初始化完成");
	}

	public void TriggerCellarTransition()
	{
		if ((Object)(object)GameFlowManager.Instance != (Object)null)
		{
			GameFlowManager.Instance.TriggerCellarTransition();
		}
	}
}
public class NarrativeManager : MonoBehaviour
{
	[SerializeField]
	[Header("UI设置")]
	private float defaultDialogueDuration = 3f;

	private GameObject dialoguePanel;

	private TextMeshProUGUI dialogueText;

	[SerializeField]
	[Header("场景设置")]
	private Transform darkRoomLocation;

	[SerializeField]
	private Transform shadowCorridorLocation;

	private Coroutine currentDialogueCoroutine;

	public static NarrativeManager Instance { get; private set; }

	private void Awake()
	{
		if ((Object)(object)Instance == (Object)null)
		{
			Instance = this;
		}
		else
		{
			Object.Destroy((Object)(object)((Component)this).gameObject);
		}
	}

	private void Start()
	{
		InitializeUIReferences();
	}

	private void InitializeUIReferences()
	{
		if ((Object)(object)GameUIManager.Instance != (Object)null)
		{
			dialoguePanel = GameUIManager.Instance.GetDialoguePanel();
			dialogueText = GameUIManager.Instance.GetDialogueText();
		}
		if ((Object)(object)dialoguePanel == (Object)null)
		{
			((MonoBehaviour)this).StartCoroutine(DelayedUIInitialization());
		}
		else
		{
			dialoguePanel.SetActive(false);
		}
	}

	private IEnumerator DelayedUIInitialization()
	{
		while ((Object)(object)GameUIManager.Instance == (Object)null || (Object)(object)GameUIManager.Instance.GetDialoguePanel() == (Object)null)
		{
			yield return null;
		}
		dialoguePanel = GameUIManager.Instance.GetDialoguePanel();
		dialogueText = GameUIManager.Instance.GetDialogueText();
		if ((Object)(object)dialoguePanel != (Object)null)
		{
			dialoguePanel.SetActive(false);
		}
	}

	public void ShowDialogue(string text, float duration = -1f)
	{
		if (currentDialogueCoroutine != null)
		{
			((MonoBehaviour)this).StopCoroutine(currentDialogueCoroutine);
		}
		if (duration < 0f)
		{
			duration = defaultDialogueDuration;
		}
		currentDialogueCoroutine = ((MonoBehaviour)this).StartCoroutine(DisplayDialogue(text, duration));
	}

	private IEnumerator DisplayDialogue(string text, float duration)
	{
		if ((Object)(object)dialoguePanel != (Object)null)
		{
			dialoguePanel.SetActive(true);
		}
		if ((Object)(object)dialogueText != (Object)null)
		{
			((TMP_Text)dialogueText).text = text;
		}
		if ((Object)(object)dialoguePanel != (Object)null)
		{
			CanvasGroup canvasGroup = dialoguePanel.GetComponent<CanvasGroup>();
			if ((Object)(object)canvasGroup == (Object)null)
			{
				canvasGroup = dialoguePanel.AddComponent<CanvasGroup>();
			}
			float fadeTime = 0.3f;
			float elapsed = 0f;
			while (elapsed < fadeTime)
			{
				elapsed += Time.deltaTime;
				canvasGroup.alpha = Mathf.Lerp(0f, 1f, elapsed / fadeTime);
				yield return null;
			}
			canvasGroup.alpha = 1f;
		}
		yield return (object)new WaitForSeconds(duration);
		if ((Object)(object)dialoguePanel != (Object)null)
		{
			CanvasGroup canvasGroup = dialoguePanel.GetComponent<CanvasGroup>();
			if ((Object)(object)canvasGroup != (Object)null)
			{
				float elapsed = 0.3f;
				float fadeTime = 0f;
				while (fadeTime < elapsed)
				{
					fadeTime += Time.deltaTime;
					canvasGroup.alpha = Mathf.Lerp(1f, 0f, fadeTime / elapsed);
					yield return null;
				}
				canvasGroup.alpha = 0f;
			}
		}
		if ((Object)(object)dialoguePanel != (Object)null)
		{
			dialoguePanel.SetActive(false);
		}
		currentDialogueCoroutine = null;
	}

	public Vector3 GetDarkRoomPosition()
	{
		//IL_001a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0014: Unknown result type (might be due to invalid IL or missing references)
		if ((Object)(object)darkRoomLocation != (Object)null)
		{
			return darkRoomLocation.position;
		}
		return Vector3.zero;
	}

	public Vector3 GetShadowCorridorPosition()
	{
		//IL_0029: Unknown result type (might be due to invalid IL or missing references)
		//IL_0014: Unknown result type (might be due to invalid IL or missing references)
		if ((Object)(object)shadowCorridorLocation != (Object)null)
		{
			return shadowCorridorLocation.position;
		}
		return new Vector3(10f, 0f, 0f);
	}
}
public class NarrativeTrigger : MonoBehaviour
{
	[Serializable]
	public class NarrativeEvent
	{
		[Header("触发设置")]
		public string eventName;

		public bool triggerOnce = true;

		[Header("相机设置")]
		public bool moveCamera;

		public Vector3 cameraTargetPosition;

		public Vector3 cameraLookAtPoint;

		public float cameraTransitionDuration = 2f;

		[Header("音效设置")]
		public bool playSFX;

		public string sfxClipName;

		public float sfxVolume = 1f;

		[Header("语音设置")]
		public bool playVoice;

		public string voiceClipName;

		public float voiceVolume = 1f;

		[Header("对白设置")]
		public bool showDialogue;

		public string dialogueText;

		public float dialogueDuration = 3f;
	}

	[SerializeField]
	[Header("触发器设置")]
	private bool isActive = true;

	[SerializeField]
	private NarrativeEvent[] narrativeEvents;

	[SerializeField]
	private bool hasBeenTriggered;

	[SerializeField]
	[Header("调试")]
	private bool showDebugInfo;

	private void OnTriggerEnter(Collider other)
	{
		if (isActive && ((Component)other).CompareTag("Player"))
		{
			if (showDebugInfo)
			{
				Debug.Log((object)("玩家进入触发器: " + ((Object)((Component)this).gameObject).name));
			}
			if (((Object)((Component)this).gameObject).name.Contains("DarkRoom") || ((Object)((Component)this).gameObject).name.Contains("暗房"))
			{
				GameProgressTracker.Instance?.SetDarkRoomEntered(value: true);
			}
			else if (((Object)((Component)this).gameObject).name.Contains("Corridor") || ((Object)((Component)this).gameObject).name.Contains("走廊"))
			{
				GameProgressTracker.Instance?.SetCorridorEntered(value: true);
			}
			if (narrativeEvents != null && narrativeEvents.Length != 0)
			{
				((MonoBehaviour)this).StartCoroutine(ExecuteNarrativeEvents());
			}
		}
	}

	private IEnumerator ExecuteNarrativeEvents()
	{
		NarrativeEvent[] array = narrativeEvents;
		foreach (NarrativeEvent narrativeEvent in array)
		{
			if (showDebugInfo)
			{
				Debug.Log((object)("执行叙事事件: " + narrativeEvent.eventName));
			}
			if (narrativeEvent.playSFX && !string.IsNullOrEmpty(narrativeEvent.sfxClipName))
			{
				AudioManager.Instance?.PlaySFX(narrativeEvent.sfxClipName, narrativeEvent.sfxVolume);
			}
			if (narrativeEvent.playVoice && !string.IsNullOrEmpty(narrativeEvent.voiceClipName))
			{
				AudioManager.Instance?.PlayVoice(narrativeEvent.voiceClipName, narrativeEvent.voiceVolume);
			}
			if (narrativeEvent.showDialogue && !string.IsNullOrEmpty(narrativeEvent.dialogueText))
			{
				NarrativeManager.Instance?.ShowDialogue(narrativeEvent.dialogueText, narrativeEvent.dialogueDuration);
			}
			if (narrativeEvent.moveCamera)
			{
				if (narrativeEvent.cameraLookAtPoint != Vector3.zero)
				{
					CameraController.Instance?.MoveToPositionAndLookAt(narrativeEvent.cameraTargetPosition, narrativeEvent.cameraLookAtPoint, narrativeEvent.cameraTransitionDuration);
				}
				else
				{
					CameraController.Instance?.MoveToPosition(narrativeEvent.cameraTargetPosition, narrativeEvent.cameraTransitionDuration);
				}
			}
			yield return (object)new WaitForSeconds(Mathf.Max(narrativeEvent.cameraTransitionDuration, narrativeEvent.dialogueDuration));
		}
		if (narrativeEvents.Length != 0 && narrativeEvents[0].triggerOnce)
		{
			hasBeenTriggered = true;
			isActive = false;
		}
	}

	public void Activate()
	{
		isActive = true;
	}

	public void Deactivate()
	{
		isActive = false;
	}

	public void ResetTrigger()
	{
		hasBeenTriggered = false;
		isActive = true;
	}

	private void OnDrawGizmos()
	{
		//IL_001f: Unknown result type (might be due to invalid IL or missing references)
		//IL_002a: Unknown result type (might be due to invalid IL or missing references)
		//IL_003a: Unknown result type (might be due to invalid IL or missing references)
		//IL_003f: Unknown result type (might be due to invalid IL or missing references)
		//IL_004b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0056: Unknown result type (might be due to invalid IL or missing references)
		//IL_0066: Unknown result type (might be due to invalid IL or missing references)
		//IL_006c: Unknown result type (might be due to invalid IL or missing references)
		if (narrativeEvents == null)
		{
			return;
		}
		NarrativeEvent[] array = narrativeEvents;
		foreach (NarrativeEvent narrativeEvent in array)
		{
			if (narrativeEvent.moveCamera)
			{
				Gizmos.color = Color.yellow;
				Gizmos.DrawWireSphere(narrativeEvent.cameraTargetPosition, 0.5f);
				if (narrativeEvent.cameraLookAtPoint != Vector3.zero)
				{
					Gizmos.color = Color.red;
					Gizmos.DrawWireSphere(narrativeEvent.cameraLookAtPoint, 0.3f);
					Gizmos.DrawLine(narrativeEvent.cameraTargetPosition, narrativeEvent.cameraLookAtPoint);
				}
			}
		}
	}
}
public class SceneSetup : MonoBehaviour
{
	[Serializable]
	public class SceneArea
	{
		public string areaName;

		public Vector3 position;

		[TextArea(3, 5)]
		public string description;

		public Transform areaTransform;
	}

	[SerializeField]
	[Header("场景区域")]
	private SceneArea[] sceneAreas;

	[Header("相机初始设置")]
	[SerializeField]
	private Transform initialCameraPosition;

	[SerializeField]
	private Vector3 initialCameraRotation;

	private void Start()
	{
		SetupScene();
	}

	private void SetupScene()
	{
		//IL_004c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0051: Unknown result type (might be due to invalid IL or missing references)
		//IL_0029: Unknown result type (might be due to invalid IL or missing references)
		//IL_003f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0073: Unknown result type (might be due to invalid IL or missing references)
		//IL_0078: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b2: Unknown result type (might be due to invalid IL or missing references)
		if ((Object)(object)initialCameraPosition != (Object)null)
		{
			Camera main = Camera.main;
			if ((Object)(object)main != (Object)null)
			{
				((Component)main).transform.position = initialCameraPosition.position;
				((Component)main).transform.rotation = initialCameraPosition.rotation;
			}
		}
		else if (initialCameraRotation != Vector3.zero)
		{
			Camera main2 = Camera.main;
			if ((Object)(object)main2 != (Object)null)
			{
				((Component)main2).transform.rotation = Quaternion.Euler(initialCameraRotation);
			}
		}
		if (sceneAreas == null)
		{
			return;
		}
		SceneArea[] array = sceneAreas;
		foreach (SceneArea sceneArea in array)
		{
			if ((Object)(object)sceneArea.areaTransform != (Object)null)
			{
				sceneArea.areaTransform.position = sceneArea.position;
			}
		}
	}

	public SceneArea GetArea(string areaName)
	{
		if (sceneAreas != null)
		{
			SceneArea[] array = sceneAreas;
			foreach (SceneArea sceneArea in array)
			{
				if (sceneArea.areaName == areaName)
				{
					return sceneArea;
				}
			}
		}
		return null;
	}

	private void OnDrawGizmos()
	{
		//IL_0047: Unknown result type (might be due to invalid IL or missing references)
		//IL_0057: Unknown result type (might be due to invalid IL or missing references)
		//IL_006c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0077: Unknown result type (might be due to invalid IL or missing references)
		//IL_0082: Unknown result type (might be due to invalid IL or missing references)
		//IL_008c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0091: Unknown result type (might be due to invalid IL or missing references)
		//IL_0016: Unknown result type (might be due to invalid IL or missing references)
		//IL_0020: Unknown result type (might be due to invalid IL or missing references)
		if (sceneAreas != null)
		{
			SceneArea[] array = sceneAreas;
			foreach (SceneArea obj in array)
			{
				Gizmos.color = Color.green;
				Gizmos.DrawWireSphere(obj.position, 1f);
			}
		}
		if ((Object)(object)initialCameraPosition != (Object)null)
		{
			Gizmos.color = Color.blue;
			Gizmos.DrawWireSphere(initialCameraPosition.position, 0.5f);
			Gizmos.DrawLine(initialCameraPosition.position, initialCameraPosition.position + initialCameraPosition.forward * 2f);
		}
	}
}
[RequireComponent(typeof(CharacterController))]
public class SimplePlayerController : MonoBehaviour
{
	[SerializeField]
	[Header("移动设置")]
	private float moveSpeed = 5f;

	[SerializeField]
	private float mouseSensitivity = 2f;

	[SerializeField]
	private float verticalRotationLimit = 80f;

	[SerializeField]
	private float gravity = -9.81f;

	[Min(0.1f)]
	[SerializeField]
	[Header("跳跃设置")]
	private float jumpHeight = 1.2f;

	[SerializeField]
	private float jumpCooldownSeconds = 0.05f;

	private float lastJumpTime = -999f;

	[SerializeField]
	[Header("相机设置")]
	private Camera playerCamera;

	[SerializeField]
	private Vector3 cameraOffset = new Vector3(0f, 1.6f, 0f);

	private CharacterController characterController;

	private float verticalRotation;

	private Vector3 velocity;

	private void Start()
	{
		characterController = ((Component)this).GetComponent<CharacterController>();
		if ((Object)(object)playerCamera == (Object)null)
		{
			playerCamera = Camera.main;
		}
		Cursor.lockState = (CursorLockMode)0;
		Cursor.visible = true;
	}

	private void Update()
	{
		HandleMovement();
		HandleMouseLook();
	}

	private void HandleMovement()
	{
		//IL_0065: Unknown result type (might be due to invalid IL or missing references)
		//IL_006b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0076: Unknown result type (might be due to invalid IL or missing references)
		//IL_007c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0081: Unknown result type (might be due to invalid IL or missing references)
		//IL_0086: Unknown result type (might be due to invalid IL or missing references)
		//IL_0089: Unknown result type (might be due to invalid IL or missing references)
		//IL_0094: Unknown result type (might be due to invalid IL or missing references)
		//IL_0099: Unknown result type (might be due to invalid IL or missing references)
		//IL_0155: Unknown result type (might be due to invalid IL or missing references)
		//IL_015b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0160: Unknown result type (might be due to invalid IL or missing references)
		//IL_0180: Unknown result type (might be due to invalid IL or missing references)
		//IL_0182: Unknown result type (might be due to invalid IL or missing references)
		bool isGrounded = characterController.isGrounded;
		float num = 0f;
		float num2 = 0f;
		if ((Object)(object)MobileInputController.Instance != (Object)null && MobileInputController.Instance.IsMobile())
		{
			num = MobileInputController.Instance.GetHorizontal();
			num2 = MobileInputController.Instance.GetVertical();
		}
		else
		{
			num = LegacyInputCompat.GetAxis("Horizontal");
			num2 = LegacyInputCompat.GetAxis("Vertical");
		}
		Vector3 val = ((Component)this).transform.right * num + ((Component)this).transform.forward * num2;
		val = val.normalized * moveSpeed;
		if (isGrounded && velocity.y < 0f)
		{
			velocity.y = -2f;
		}
		bool flag = false;
		flag = ((!((Object)(object)MobileInputController.Instance != (Object)null) || !MobileInputController.Instance.IsMobile()) ? LegacyInputCompat.GetKeyDown((KeyCode)32) : MobileInputController.Instance.ConsumeJumpQueued());
		if ((flag & isGrounded) && Time.time - lastJumpTime >= jumpCooldownSeconds)
		{
			velocity.y = Mathf.Sqrt(jumpHeight * -2f * gravity);
			lastJumpTime = Time.time;
		}
		velocity.y += gravity * Time.deltaTime;
		Vector3 val2 = val * Time.deltaTime;
		val2.y = velocity.y * Time.deltaTime;
		characterController.Move(val2);
	}

	private void HandleMouseLook()
	{
		//IL_00c6: Unknown result type (might be due to invalid IL or missing references)
		//IL_00cb: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e2: Unknown result type (might be due to invalid IL or missing references)
		//IL_0104: Unknown result type (might be due to invalid IL or missing references)
		//IL_0109: Unknown result type (might be due to invalid IL or missing references)
		//IL_010e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0113: Unknown result type (might be due to invalid IL or missing references)
		//IL_011f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0136: Unknown result type (might be due to invalid IL or missing references)
		//IL_014b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0150: Unknown result type (might be due to invalid IL or missing references)
		if (!((Object)(object)playerCamera == (Object)null))
		{
			float num = 0f;
			float num2 = 0f;
			if ((Object)(object)MobileInputController.Instance != (Object)null && MobileInputController.Instance.IsMobile())
			{
				num = MobileInputController.Instance.GetMouseX() * mouseSensitivity;
				num2 = MobileInputController.Instance.GetMouseY() * mouseSensitivity;
			}
			else
			{
				num = LegacyInputCompat.GetAxis("Mouse X") * mouseSensitivity;
				num2 = LegacyInputCompat.GetAxis("Mouse Y") * mouseSensitivity;
			}
			((Component)this).transform.Rotate(0f, num, 0f);
			verticalRotation -= num2;
			verticalRotation = Mathf.Clamp(verticalRotation, 0f - verticalRotationLimit, verticalRotationLimit);
			Vector3 position = ((Component)this).transform.position;
			position.y += cameraOffset.y;
			position += ((Component)this).transform.TransformDirection(new Vector3(cameraOffset.x, 0f, cameraOffset.z));
			((Component)playerCamera).transform.position = position;
			((Component)playerCamera).transform.rotation = ((Component)this).transform.rotation * Quaternion.Euler(verticalRotation, 0f, 0f);
		}
	}

	private void OnDisable()
	{
		Cursor.lockState = (CursorLockMode)0;
		Cursor.visible = true;
	}

	public SimplePlayerController()
	{
		//IL_005d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0062: Unknown result type (might be due to invalid IL or missing references)
	}
}
public class TaskListUI : MonoBehaviour
{
	[Header("UI元素")]
	private GameObject taskListPanel;

	private TextMeshProUGUI timerText;

	private TextMeshProUGUI progressText;

	private RectTransform taskItemsContent;

	private readonly Dictionary<int, TextMeshProUGUI> taskEntryTexts = new Dictionary<int, TextMeshProUGUI>();

	private TMP_FontAsset sharedFont;

	private readonly Color completedTaskColor = new Color(0.4f, 0.9f, 0.5f);

	public static TaskListUI Instance { get; private set; }

	private void Awake()
	{
		if ((Object)(object)Instance == (Object)null)
		{
			Instance = this;
		}
		else
		{
			Object.Destroy((Object)(object)((Component)this).gameObject);
		}
	}

	private void Start()
	{
		ResolveSharedFont();
		CreateTaskListUI();
		HideOldGameInfoUI();
		((MonoBehaviour)this).StartCoroutine(DelayedSubscribeEvents());
	}

	private void Update()
	{
		UpdateTimer();
	}

	private void CreateTaskListUI()
	{
		//IL_0059: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Expected Obj, but got Unknown
		//IL_0090: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b0: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ba: Unknown result type (might be due to invalid IL or missing references)
		//IL_0033: Unknown result type (might be due to invalid IL or missing references)
		//IL_0038: Unknown result type (might be due to invalid IL or missing references)
		//IL_0046: Unknown result type (might be due to invalid IL or missing references)
		EnsureGameUIManagerExists();
		Canvas val = (((Object)(object)GameUIManager.Instance != (Object)null) ? GameUIManager.Instance.GetOrCreateCanvas() : Object.FindObjectOfType<Canvas>());
		if ((Object)(object)val == (Object)null)
		{
			GameObject val2 = new GameObject("Canvas");
			val = val2.AddComponent<Canvas>();
			val.renderMode = (RenderMode)0;
			val2.AddComponent<CanvasScaler>();
			val2.AddComponent<GraphicRaycaster>();
		}
		taskListPanel = new GameObject("TaskListPanel");
		taskListPanel.transform.SetParent(((Component)val).transform, false);
		RectTransform val3 = taskListPanel.AddComponent<RectTransform>();
		val3.anchorMin = new Vector2(0.02f, 0.45f);
		val3.anchorMax = new Vector2(0.15f, 0.92f);
		val3.offsetMin = Vector2.zero;
		val3.offsetMax = Vector2.zero;
		CreateOverviewPanel(taskListPanel.transform);
		CreateTaskItemsPanel(taskListPanel.transform);
	}

	private void EnsureGameUIManagerExists()
	{
		//IL_0021: Unknown result type (might be due to invalid IL or missing references)
		if (!((Object)(object)GameUIManager.Instance != (Object)null) && !((Object)(object)Object.FindObjectOfType<GameUIManager>() != (Object)null))
		{
			new GameObject("GameUIManager").AddComponent<GameUIManager>();
		}
	}

	private GameObject CreateOverviewPanel(Transform parent)
	{
		//IL_0005: Unknown result type (might be due to invalid IL or missing references)
		//IL_000b: Expected Obj, but got Unknown
		//IL_0029: Unknown result type (might be due to invalid IL or missing references)
		//IL_003e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0049: Unknown result type (might be due to invalid IL or missing references)
		//IL_0053: Unknown result type (might be due to invalid IL or missing references)
		//IL_0077: Unknown result type (might be due to invalid IL or missing references)
		//IL_0086: Unknown result type (might be due to invalid IL or missing references)
		//IL_008b: Unknown result type (might be due to invalid IL or missing references)
		//IL_009d: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fc: Unknown result type (might be due to invalid IL or missing references)
		//IL_0111: Unknown result type (might be due to invalid IL or missing references)
		//IL_0125: Unknown result type (might be due to invalid IL or missing references)
		//IL_0134: Unknown result type (might be due to invalid IL or missing references)
		//IL_013a: Expected Obj, but got Unknown
		//IL_017e: Unknown result type (might be due to invalid IL or missing references)
		//IL_01b5: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ca: Unknown result type (might be due to invalid IL or missing references)
		//IL_01df: Unknown result type (might be due to invalid IL or missing references)
		//IL_01f3: Unknown result type (might be due to invalid IL or missing references)
		GameObject val = new GameObject("TaskOverviewPanel");
		val.transform.SetParent(parent, false);
		RectTransform val2 = val.AddComponent<RectTransform>();
		val2.anchorMin = new Vector2(0f, 0.8f);
		val2.anchorMax = new Vector2(1f, 1f);
		val2.offsetMin = Vector2.zero;
		val2.offsetMax = Vector2.zero;
		((Graphic)val.AddComponent<Image>()).color = new Color(0.08f, 0.08f, 0.08f, 0.9f);
		GameObject val3 = new GameObject("Title");
		val3.transform.SetParent(val.transform, false);
		TextMeshProUGUI val4 = val3.AddComponent<TextMeshProUGUI>();
		((TMP_Text)val4).text = "农场任务";
		((TMP_Text)val4).fontSize = 22f;
		((Graphic)val4).color = Color.yellow;
		((TMP_Text)val4).alignment = (TextAlignmentOptions)513;
		ApplySharedFont(val4);
		RectTransform component = val3.GetComponent<RectTransform>();
		component.anchorMin = new Vector2(0f, 0.85f);
		component.anchorMax = new Vector2(1f, 1f);
		component.offsetMin = new Vector2(10f, 0f);
		component.offsetMax = new Vector2(-10f, -5f);
		GameObject val5 = new GameObject("Timer");
		val5.transform.SetParent(val.transform, false);
		timerText = val5.AddComponent<TextMeshProUGUI>();
		((TMP_Text)timerText).text = "10:00";
		((TMP_Text)timerText).fontSize = 20f;
		((Graphic)timerText).color = Color.red;
		((TMP_Text)timerText).alignment = (TextAlignmentOptions)513;
		ApplySharedFont(timerText);
		RectTransform component2 = val5.GetComponent<RectTransform>();
		component2.anchorMin = new Vector2(0f, 0.25f);
		component2.anchorMax = new Vector2(1f, 0.6f);
		component2.offsetMin = new Vector2(10f, 0f);
		component2.offsetMax = new Vector2(-10f, 0f);
		return val;
	}

	private GameObject CreateTaskItemsPanel(Transform parent)
	{
		//IL_0005: Unknown result type (might be due to invalid IL or missing references)
		//IL_000b: Expected Obj, but got Unknown
		//IL_0029: Unknown result type (might be due to invalid IL or missing references)
		//IL_003e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0049: Unknown result type (might be due to invalid IL or missing references)
		//IL_0053: Unknown result type (might be due to invalid IL or missing references)
		//IL_0077: Unknown result type (might be due to invalid IL or missing references)
		//IL_0086: Unknown result type (might be due to invalid IL or missing references)
		//IL_008c: Expected Obj, but got Unknown
		//IL_00d0: Unknown result type (might be due to invalid IL or missing references)
		//IL_0107: Unknown result type (might be due to invalid IL or missing references)
		//IL_011c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0131: Unknown result type (might be due to invalid IL or missing references)
		//IL_0145: Unknown result type (might be due to invalid IL or missing references)
		//IL_0154: Unknown result type (might be due to invalid IL or missing references)
		//IL_0159: Unknown result type (might be due to invalid IL or missing references)
		//IL_016b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0189: Unknown result type (might be due to invalid IL or missing references)
		//IL_01b5: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ca: Unknown result type (might be due to invalid IL or missing references)
		//IL_01df: Unknown result type (might be due to invalid IL or missing references)
		//IL_01f3: Unknown result type (might be due to invalid IL or missing references)
		//IL_0202: Unknown result type (might be due to invalid IL or missing references)
		//IL_0208: Expected Obj, but got Unknown
		//IL_0236: Unknown result type (might be due to invalid IL or missing references)
		//IL_0250: Unknown result type (might be due to invalid IL or missing references)
		//IL_026a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0284: Unknown result type (might be due to invalid IL or missing references)
		GameObject val = new GameObject("TaskItemsPanel");
		val.transform.SetParent(parent, false);
		RectTransform val2 = val.AddComponent<RectTransform>();
		val2.anchorMin = new Vector2(0f, 0f);
		val2.anchorMax = new Vector2(1f, 0.8f);
		val2.offsetMin = Vector2.zero;
		val2.offsetMax = Vector2.zero;
		((Graphic)val.AddComponent<Image>()).color = new Color(0.05f, 0.05f, 0.05f, 0.85f);
		GameObject val3 = new GameObject("Progress");
		val3.transform.SetParent(val.transform, false);
		progressText = val3.AddComponent<TextMeshProUGUI>();
		((TMP_Text)progressText).text = "0/10";
		((TMP_Text)progressText).fontSize = 18f;
		((Graphic)progressText).color = Color.white;
		((TMP_Text)progressText).alignment = (TextAlignmentOptions)513;
		ApplySharedFont(progressText);
		RectTransform component = val3.GetComponent<RectTransform>();
		component.anchorMin = new Vector2(0f, 0.88f);
		component.anchorMax = new Vector2(1f, 1f);
		component.offsetMin = new Vector2(10f, -4f);
		component.offsetMax = new Vector2(-10f, -4f);
		GameObject val4 = new GameObject("TaskItemsTitle");
		val4.transform.SetParent(val.transform, false);
		TextMeshProUGUI val5 = val4.AddComponent<TextMeshProUGUI>();
		((TMP_Text)val5).text = "搜寻目标";
		((TMP_Text)val5).fontSize = 20f;
		((Graphic)val5).color = Color.cyan;
		((TMP_Text)val5).alignment = (TextAlignmentOptions)513;
		ApplySharedFont(val5);
		RectTransform component2 = val4.GetComponent<RectTransform>();
		component2.anchorMin = new Vector2(0f, 0.72f);
		component2.anchorMax = new Vector2(1f, 0.88f);
		component2.offsetMin = new Vector2(10f, -2f);
		component2.offsetMax = new Vector2(-10f, -2f);
		GameObject val6 = new GameObject("TaskItemsContainer");
		val6.transform.SetParent(val.transform, false);
		taskItemsContent = val6.AddComponent<RectTransform>();
		taskItemsContent.anchorMin = new Vector2(0f, 0f);
		taskItemsContent.anchorMax = new Vector2(1f, 0.72f);
		taskItemsContent.offsetMin = new Vector2(10f, 10f);
		taskItemsContent.offsetMax = new Vector2(-10f, -10f);
		VerticalLayoutGroup val7 = val6.AddComponent<VerticalLayoutGroup>();
		((LayoutGroup)val7).childAlignment = (TextAnchor)0;
		((HorizontalOrVerticalLayoutGroup)val7).childForceExpandHeight = false;
		((HorizontalOrVerticalLayoutGroup)val7).childForceExpandWidth = true;
		((HorizontalOrVerticalLayoutGroup)val7).spacing = 6f;
		ContentSizeFitter val8 = val6.AddComponent<ContentSizeFitter>();
		val8.verticalFit = (FitMode)2;
		val8.horizontalFit = (FitMode)0;
		return val;
	}

	private void UpdateTimer()
	{
		//IL_0075: Unknown result type (might be due to invalid IL or missing references)
		//IL_009f: Unknown result type (might be due to invalid IL or missing references)
		//IL_008e: Unknown result type (might be due to invalid IL or missing references)
		if ((Object)(object)timerText != (Object)null && (Object)(object)TreasureHuntGame.Instance != (Object)null)
		{
			float remainingTime = TreasureHuntGame.Instance.GetRemainingTime();
			int num = Mathf.FloorToInt(remainingTime / 60f);
			int num2 = Mathf.FloorToInt(remainingTime % 60f);
			((TMP_Text)timerText).text = $"倒计时: {num:00}:{num2:00}";
			if (remainingTime < 60f)
			{
				((Graphic)timerText).color = Color.red;
			}
			else if (remainingTime < 180f)
			{
				((Graphic)timerText).color = Color.yellow;
			}
			else
			{
				((Graphic)timerText).color = Color.white;
			}
		}
	}

	private void UpdateProgress()
	{
		if ((Object)(object)progressText != (Object)null && (Object)(object)TreasureHuntGame.Instance != (Object)null)
		{
			int completedTasks = TreasureHuntGame.Instance.GetCompletedTasks();
			int totalTasks = TreasureHuntGame.Instance.GetTotalTasks();
			((TMP_Text)progressText).text = $"任务进度：{completedTasks}/{totalTasks}";
			RefreshAllTaskEntries();
		}
	}

	private void HideOldGameInfoUI()
	{
		if ((Object)(object)GameUIManager.Instance != (Object)null)
		{
			GameObject val = GameObject.Find("GameInfoPanel");
			if ((Object)(object)val != (Object)null)
			{
				val.SetActive(false);
			}
		}
	}

	private IEnumerator DelayedSubscribeEvents()
	{
		while ((Object)(object)TreasureHuntGame.Instance == (Object)null)
		{
			yield return null;
		}
		while (TreasureHuntGame.Instance.GetAllTasks() == null || TreasureHuntGame.Instance.GetAllTasks().Count == 0)
		{
			yield return null;
		}
		TreasureHuntGame instance = TreasureHuntGame.Instance;
		instance.OnTaskCompleted = (Action<int>)Delegate.Combine(instance.OnTaskCompleted, new Action<int>(OnTaskCompleted));
		InitializeTaskEntries();
		UpdateProgress();
	}

	private void OnDisable()
	{
		if ((Object)(object)TreasureHuntGame.Instance != (Object)null)
		{
			TreasureHuntGame instance = TreasureHuntGame.Instance;
			instance.OnTaskCompleted = (Action<int>)Delegate.Remove(instance.OnTaskCompleted, new Action<int>(OnTaskCompleted));
		}
	}

	private void OnTaskCompleted(int completedCount)
	{
		UpdateProgress();
		Debug.Log((object)$"任务完成事件触发，已完成：{completedCount}");
	}

	private void ResolveSharedFont()
	{
		if ((Object)(object)GameUIManager.Instance != (Object)null)
		{
			sharedFont = GameUIManager.Instance.GetDefaultFontAsset();
		}
	}

	private void ApplySharedFont(TextMeshProUGUI text)
	{
		if (!((Object)(object)text == (Object)null))
		{
			if ((Object)(object)sharedFont == (Object)null)
			{
				ResolveSharedFont();
			}
			if ((Object)(object)sharedFont != (Object)null)
			{
				((TMP_Text)text).font = sharedFont;
			}
		}
	}

	private void InitializeTaskEntries()
	{
		//IL_0030: Unknown result type (might be due to invalid IL or missing references)
		//IL_008b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0090: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b7: Unknown result type (might be due to invalid IL or missing references)
		if ((Object)(object)taskItemsContent == (Object)null || (Object)(object)TreasureHuntGame.Instance == (Object)null)
		{
			return;
		}
		foreach (Transform item in (Transform)taskItemsContent)
		{
			Object.Destroy((Object)(object)((Component)item).gameObject);
		}
		taskEntryTexts.Clear();
		List<TreasureHuntTask> allTasks = TreasureHuntGame.Instance.GetAllTasks();
		if (allTasks != null)
		{
			for (int i = 0; i < allTasks.Count; i++)
			{
				GameObject val = new GameObject($"TaskEntry_{i}");
				val.transform.SetParent((Transform)(object)taskItemsContent, false);
				TextMeshProUGUI val2 = val.AddComponent<TextMeshProUGUI>();
				((TMP_Text)val2).fontSize = 16f;
				((Graphic)val2).color = Color.white;
				((TMP_Text)val2).alignment = (TextAlignmentOptions)513;
				((TMP_Text)val2).enableWordWrapping = true;
				ApplySharedFont(val2);
				taskEntryTexts[i] = val2;
				UpdateTaskEntryText(i, allTasks[i]);
			}
		}
	}

	private void RefreshAllTaskEntries()
	{
		if ((Object)(object)TreasureHuntGame.Instance == (Object)null || taskEntryTexts.Count == 0)
		{
			return;
		}
		List<TreasureHuntTask> allTasks = TreasureHuntGame.Instance.GetAllTasks();
		if (allTasks != null)
		{
			int num = Mathf.Min(allTasks.Count, taskEntryTexts.Count);
			for (int i = 0; i < num; i++)
			{
				UpdateTaskEntryText(i, allTasks[i]);
			}
		}
	}

	private void UpdateTaskEntryText(int taskIndex, TreasureHuntTask taskData)
	{
		//IL_003b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0033: Unknown result type (might be due to invalid IL or missing references)
		if (taskData != null && taskEntryTexts.TryGetValue(taskIndex, out var value))
		{
			string text = (taskData.isCompleted ? "已完成" : "未完成");
			((Graphic)value).color = (taskData.isCompleted ? completedTaskColor : Color.white);
			((TMP_Text)value).text = "• " + taskData.taskName + "（" + text + "）";
		}
	}

	public TaskListUI()
	{
		//IL_001b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0020: Unknown result type (might be due to invalid IL or missing references)
	}
}
public class TreasureHuntGame : MonoBehaviour
{
	[SerializeField]
	[Header("游戏设置")]
	private float timeLimitMinutes = 10f;

	[SerializeField]
	private int totalTasks = 10;

	[SerializeField]
	[Header("任务列表")]
	private List<TreasureHuntTask> taskList = new List<TreasureHuntTask>();

	[SerializeField]
	[Header("道具引用")]
	private ItemPickup[] treasureItems;

	private int currentTaskIndex;

	private int completedTasks;

	private float gameStartTime;

	private float remainingTime;

	private bool gameStarted;

	private bool gameCompleted;

	private bool gameFailed;

	public Action<int> OnTaskCompleted;

	public Action OnAllTasksCompleted;

	public Action OnTimeUp;

	public static TreasureHuntGame Instance { get; private set; }

	private void Awake()
	{
		if ((Object)(object)Instance == (Object)null)
		{
			Instance = this;
		}
		else
		{
			Object.Destroy((Object)(object)((Component)this).gameObject);
		}
	}

	private void Start()
	{
		InitializeGame();
	}

	private void InitializeGame()
	{
		BuildTasksFromItemPickups();
		gameStartTime = Time.time;
		remainingTime = timeLimitMinutes * 60f;
		gameStarted = true;
		gameCompleted = false;
		gameFailed = false;
		currentTaskIndex = 0;
		completedTasks = 0;
		foreach (TreasureHuntTask task in taskList)
		{
			task.isCompleted = false;
			task.completionTime = 0f;
		}
		Debug.Log((object)$"探宝游戏开始！找到 {totalTasks} 个道具，时间限制：{timeLimitMinutes} 分钟");
	}

	private void BuildTasksFromItemPickups()
	{
		IEnumerable<ItemPickup> source;
		if (treasureItems == null || treasureItems.Length == 0)
		{
			IEnumerable<ItemPickup> enumerable = Object.FindObjectsOfType<ItemPickup>(true);
			source = enumerable;
		}
		else
		{
			source = treasureItems.Where((ItemPickup i) => (Object)(object)i != (Object)null);
		}
		List<ItemPickup> list = (from i in source
			where (Object)(object)i != (Object)null && !string.IsNullOrWhiteSpace(i.ItemName)
			orderby i.ItemName
			select i).ToList();
		treasureItems = list.ToArray();
		taskList.Clear();
		foreach (ItemPickup item in list)
		{
			TreasureHuntTask treasureHuntTask = new TreasureHuntTask("寻找：" + item.ItemName, item.ItemName, item.ItemDescription);
			treasureHuntTask.itemIcon = item.ItemIcon;
			taskList.Add(treasureHuntTask);
		}
		totalTasks = taskList.Count;
	}

	private void Update()
	{
		if (gameStarted && !gameCompleted && !gameFailed)
		{
			remainingTime = timeLimitMinutes * 60f - (Time.time - gameStartTime);
			if (remainingTime <= 0f)
			{
				OnTimeLimitReached();
			}
		}
	}

	public void OnItemCollected(string itemName)
	{
		if (gameCompleted || gameFailed)
		{
			return;
		}
		Debug.Log((object)("收到物品拾取通知：" + itemName));
		TreasureHuntTask treasureHuntTask = FindTaskByItemName(itemName);
		if (treasureHuntTask != null && !treasureHuntTask.isCompleted)
		{
			Debug.Log((object)("找到对应任务：" + treasureHuntTask.taskName));
			CompleteTask(treasureHuntTask);
			return;
		}
		Debug.Log((object)"未找到完全匹配的任务，尝试匹配当前任务...");
		if (currentTaskIndex < taskList.Count)
		{
			TreasureHuntTask treasureHuntTask2 = taskList[currentTaskIndex];
			Debug.Log((object)("当前任务：" + treasureHuntTask2.itemName + "，拾取物品：" + itemName));
			if (treasureHuntTask2.itemName == itemName || itemName.Contains(treasureHuntTask2.itemName) || treasureHuntTask2.itemName.Contains(itemName))
			{
				Debug.Log((object)("匹配成功，完成任务：" + treasureHuntTask2.taskName));
				CompleteTask(treasureHuntTask2);
			}
			else
			{
				Debug.LogWarning((object)("物品名称不匹配！当前任务需要：" + treasureHuntTask2.itemName + "，但拾取了：" + itemName));
			}
		}
	}

	private TreasureHuntTask FindTaskByItemName(string itemName)
	{
		foreach (TreasureHuntTask task in taskList)
		{
			if (task.itemName == itemName || itemName.Contains(task.itemName) || task.itemName.Contains(itemName))
			{
				return task;
			}
		}
		return null;
	}

	private void CompleteTask(TreasureHuntTask task)
	{
		if (!task.isCompleted)
		{
			task.isCompleted = true;
			task.completionTime = Time.time - gameStartTime;
			completedTasks++;
			OnTaskCompleted?.Invoke(completedTasks);
			NarrativeManager.Instance?.ShowDialogue($"任务完成：{task.taskName}\n进度：{completedTasks}/{totalTasks}", 3f);
			AudioManager.Instance?.PlaySFX("item_pickup");
			if (currentTaskIndex < taskList.Count - 1)
			{
				currentTaskIndex++;
			}
			if (completedTasks >= totalTasks)
			{
				OnAllTasksCompleted?.Invoke();
				((MonoBehaviour)this).StartCoroutine(GameSuccessSequence());
			}
		}
	}

	private void OnTimeLimitReached()
	{
		if (!gameCompleted && !gameFailed)
		{
			gameFailed = true;
			OnTimeUp?.Invoke();
			((MonoBehaviour)this).StartCoroutine(GameFailureSequence());
		}
	}

	private IEnumerator GameSuccessSequence()
	{
		gameCompleted = true;
		gameStarted = false;
		yield return (object)new WaitForSeconds(1f);
		NarrativeManager.Instance?.ShowDialogue("恭喜！你成功找到了所有宝藏！", 3f);
		yield return (object)new WaitForSeconds(3.5f);
		float num = Time.time - gameStartTime;
		int num2 = Mathf.FloorToInt(num / 60f);
		int num3 = Mathf.FloorToInt(num % 60f);
		NarrativeManager.Instance?.ShowDialogue("探宝成功！\n" + $"完成时间：{num2}分{num3}秒\n" + $"找到道具：{completedTasks}/{totalTasks}个\n" + $"剩余时间：{Mathf.FloorToInt(remainingTime / 60f)}分{Mathf.FloorToInt(remainingTime % 60f)}秒", 8f);
	}

	private IEnumerator GameFailureSequence()
	{
		yield return (object)new WaitForSeconds(1f);
		NarrativeManager.Instance?.ShowDialogue("时间到了！你未能找到所有宝藏...", 3f);
		yield return (object)new WaitForSeconds(3.5f);
		NarrativeManager.Instance?.ShowDialogue("探宝失败！\n" + $"找到道具：{completedTasks}/{totalTasks}个\n" + $"剩余任务：{totalTasks - completedTasks}个", 6f);
	}

	public float GetRemainingTime()
	{
		return Mathf.Max(0f, remainingTime);
	}

	public int GetCompletedTasks()
	{
		return completedTasks;
	}

	public int GetTotalTasks()
	{
		return totalTasks;
	}

	public TreasureHuntTask GetCurrentTask()
	{
		if (currentTaskIndex < taskList.Count)
		{
			return taskList[currentTaskIndex];
		}
		return null;
	}

	public List<TreasureHuntTask> GetAllTasks()
	{
		return taskList;
	}

	public bool IsGameCompleted()
	{
		return gameCompleted;
	}

	public bool IsGameFailed()
	{
		return gameFailed;
	}

	public bool IsGameStarted()
	{
		return gameStarted;
	}
}
[Serializable]
public class TreasureHuntTask
{
	public string taskName;

	public string itemName;

	public string itemDescription;

	public bool isCompleted;

	public float completionTime;

	public Sprite itemIcon;

	public TreasureHuntTask(string name, string item, string desc)
	{
		taskName = name;
		itemName = item;
		itemDescription = desc;
		isCompleted = false;
		completionTime = 0f;
	}
}
public class VirtualJoystick : MonoBehaviour, IPointerDownHandler, IEventSystemHandler, IPointerUpHandler, IDragHandler
{
	[Header("摇杆设置")]
	[SerializeField]
	private RectTransform joystickBackground;

	[SerializeField]
	private RectTransform joystickHandle;

	[SerializeField]
	private float joystickRange = 110f;

	private Vector2 inputVector = Vector2.zero;

	private bool isPressed;

	public RectTransform JoystickBackground => joystickBackground;

	private void Start()
	{
		if ((Object)(object)joystickBackground == (Object)null)
		{
			CreateJoystickUI();
		}
		if (!((Object)(object)joystickBackground != (Object)null))
		{
			return;
		}
		((Component)joystickBackground).gameObject.SetActive(true);
		if ((Object)(object)((Component)this).gameObject != (Object)(object)((Component)joystickBackground).gameObject)
		{
			if ((Object)(object)((Component)joystickBackground).GetComponent<VirtualJoystick>() == (Object)null)
			{
				VirtualJoystick virtualJoystick = ((Component)joystickBackground).gameObject.AddComponent<VirtualJoystick>();
				virtualJoystick.joystickBackground = joystickBackground;
				virtualJoystick.joystickHandle = joystickHandle;
				virtualJoystick.joystickRange = joystickRange;
			}
			if (((Object)((Component)this).gameObject).name != "JoystickBackground")
			{
				Object.Destroy((Object)(object)this);
			}
		}
	}

	private void CreateJoystickUI()
	{
		//IL_0012: Unknown result type (might be due to invalid IL or missing references)
		//IL_0017: Unknown result type (might be due to invalid IL or missing references)
		//IL_007c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0082: Expected Obj, but got Unknown
		//IL_00b0: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ca: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e4: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fe: Unknown result type (might be due to invalid IL or missing references)
		//IL_010f: Unknown result type (might be due to invalid IL or missing references)
		//IL_012c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0146: Unknown result type (might be due to invalid IL or missing references)
		//IL_014c: Expected Obj, but got Unknown
		//IL_017a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0194: Unknown result type (might be due to invalid IL or missing references)
		//IL_01a4: Unknown result type (might be due to invalid IL or missing references)
		//IL_01be: Unknown result type (might be due to invalid IL or missing references)
		//IL_01cf: Unknown result type (might be due to invalid IL or missing references)
		//IL_01df: Unknown result type (might be due to invalid IL or missing references)
		//IL_0057: Unknown result type (might be due to invalid IL or missing references)
		//IL_005c: Unknown result type (might be due to invalid IL or missing references)
		//IL_006a: Unknown result type (might be due to invalid IL or missing references)
		if ((Object)(object)Object.FindObjectOfType<EventSystem>() == (Object)null)
		{
			GameObject val = new GameObject("EventSystem");
			val.AddComponent<EventSystem>();
			val.AddComponent<StandaloneInputModule>();
		}
		EnsureGameUIManagerExists();
		Canvas val2 = (((Object)(object)GameUIManager.Instance != (Object)null) ? GameUIManager.Instance.GetOrCreateCanvas() : Object.FindObjectOfType<Canvas>());
		if ((Object)(object)val2 == (Object)null)
		{
			GameObject val3 = new GameObject("Canvas");
			val2 = val3.AddComponent<Canvas>();
			val2.renderMode = (RenderMode)0;
			val3.AddComponent<CanvasScaler>();
			val3.AddComponent<GraphicRaycaster>();
		}
		GameObject val4 = new GameObject("JoystickBackground");
		val4.transform.SetParent(((Component)val2).transform, false);
		joystickBackground = val4.AddComponent<RectTransform>();
		joystickBackground.anchorMin = new Vector2(0f, 0f);
		joystickBackground.anchorMax = new Vector2(0f, 0f);
		joystickBackground.anchoredPosition = new Vector2(180f, 180f);
		joystickBackground.sizeDelta = new Vector2(260f, 260f);
		Image val5 = val4.AddComponent<Image>();
		((Graphic)val5).color = WarmUITheme.JoystickBg;
		((Graphic)val5).raycastTarget = true;
		val5.sprite = CreateCircleSprite(260, 260, WarmUITheme.JoystickBg);
		val5.type = (Type)0;
		GameObject val6 = new GameObject("JoystickHandle");
		val6.transform.SetParent((Transform)(object)joystickBackground, false);
		joystickHandle = val6.AddComponent<RectTransform>();
		joystickHandle.anchorMin = new Vector2(0.5f, 0.5f);
		joystickHandle.anchorMax = new Vector2(0.5f, 0.5f);
		joystickHandle.anchoredPosition = Vector2.zero;
		joystickHandle.sizeDelta = new Vector2(110f, 110f);
		Image val7 = val6.AddComponent<Image>();
		((Graphic)val7).color = WarmUITheme.JoystickHandle;
		val7.sprite = CreateCircleSprite(110, 110, WarmUITheme.JoystickHandle);
		val7.type = (Type)0;
		((Graphic)val7).raycastTarget = false;
	}

	private void EnsureGameUIManagerExists()
	{
		//IL_0021: Unknown result type (might be due to invalid IL or missing references)
		if (!((Object)(object)GameUIManager.Instance != (Object)null) && !((Object)(object)Object.FindObjectOfType<GameUIManager>() != (Object)null))
		{
			new GameObject("GameUIManager").AddComponent<GameUIManager>();
		}
	}

	public void OnPointerDown(PointerEventData eventData)
	{
		isPressed = true;
		OnDrag(eventData);
	}

	public void OnPointerUp(PointerEventData eventData)
	{
		//IL_0008: Unknown result type (might be due to invalid IL or missing references)
		//IL_000d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0026: Unknown result type (might be due to invalid IL or missing references)
		isPressed = false;
		inputVector = Vector2.zero;
		if ((Object)(object)joystickHandle != (Object)null)
		{
			joystickHandle.anchoredPosition = Vector2.zero;
		}
	}

	public void OnDrag(PointerEventData eventData)
	{
		//IL_0024: Unknown result type (might be due to invalid IL or missing references)
		//IL_0038: Unknown result type (might be due to invalid IL or missing references)
		//IL_003f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0044: Unknown result type (might be due to invalid IL or missing references)
		//IL_004b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0052: Unknown result type (might be due to invalid IL or missing references)
		//IL_0059: Unknown result type (might be due to invalid IL or missing references)
		//IL_005e: Unknown result type (might be due to invalid IL or missing references)
		Vector2 val = default;
		if (!((Object)(object)joystickBackground == (Object)null) && !((Object)(object)joystickHandle == (Object)null) && RectTransformUtility.ScreenPointToLocalPointInRectangle(joystickBackground, eventData.position, eventData.pressEventCamera, ref val))
		{
			val = Vector2.ClampMagnitude(val, joystickRange);
			joystickHandle.anchoredPosition = val;
			inputVector = val / joystickRange;
		}
	}

	public float GetHorizontal()
	{
		return inputVector.x;
	}

	public float GetVertical()
	{
		return inputVector.y;
	}

	public Vector2 GetInputVector()
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		return inputVector;
	}

	public bool IsPressed()
	{
		return isPressed;
	}

	private Sprite CreateCircleSprite(int width, int height, Color color)
	{
		//IL_0004: Unknown result type (might be due to invalid IL or missing references)
		//IL_000a: Expected Obj, but got Unknown
		//IL_001c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0041: Unknown result type (might be due to invalid IL or missing references)
		//IL_0046: Unknown result type (might be due to invalid IL or missing references)
		//IL_0100: Unknown result type (might be due to invalid IL or missing references)
		//IL_010f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0068: Unknown result type (might be due to invalid IL or missing references)
		//IL_006d: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a6: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ac: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b8: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c6: Unknown result type (might be due to invalid IL or missing references)
		Texture2D val = new Texture2D(width, height, (TextureFormat)4, false);
		Vector2 val2 = new Vector2((float)width / 2f, (float)height / 2f);
		float num = (float)Mathf.Min(width, height) / 2f;
		Color[] array = new Color[width * height];
		for (int i = 0; i < array.Length; i++)
		{
			array[i] = Color.clear;
		}
		for (int j = 0; j < height; j++)
		{
			for (int k = 0; k < width; k++)
			{
				float num2 = Vector2.Distance(new Vector2((float)k, (float)j), val2);
				if (num2 <= num)
				{
					float num3 = 1f;
					if (num2 > num - 1f)
					{
						num3 = 1f - (num2 - (num - 1f));
					}
					array[j * width + k] = new Color(color.r, color.g, color.b, color.a * num3);
				}
			}
		}
		val.SetPixels(array);
		val.Apply();
		return Sprite.Create(val, new Rect(0f, 0f, (float)width, (float)height), new Vector2(0.5f, 0.5f), 100f);
	}

	public VirtualJoystick()
	{
		//IL_000c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0011: Unknown result type (might be due to invalid IL or missing references)
	}
}
public static class WarmUITheme
{
	public static readonly Color PanelDark = new Color(0.18f, 0.12f, 0.08f, 0.88f);

	public static readonly Color PanelDarker = new Color(0.12f, 0.08f, 0.05f, 0.78f);

	public static readonly Color TextPrimary = new Color(1f, 0.97f, 0.92f, 1f);

	public static readonly Color TextAccent = new Color(1f, 0.86f, 0.45f, 1f);

	public static readonly Color ButtonFill = new Color(0.95f, 0.55f, 0.2f, 0.92f);

	public static readonly Color ButtonFillSecondary = new Color(0.85f, 0.34f, 0.2f, 0.92f);

	public static readonly Color JoystickBg = new Color(1f, 0.9f, 0.75f, 0.28f);

	public static readonly Color JoystickHandle = new Color(1f, 0.9f, 0.75f, 0.55f);

	public static readonly Color TextOutline = new Color(0.2f, 0.1f, 0.05f, 1f);

	static WarmUITheme()
	{
		//IL_0014: Unknown result type (might be due to invalid IL or missing references)
		//IL_0019: Unknown result type (might be due to invalid IL or missing references)
		//IL_0032: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Unknown result type (might be due to invalid IL or missing references)
		//IL_0050: Unknown result type (might be due to invalid IL or missing references)
		//IL_0055: Unknown result type (might be due to invalid IL or missing references)
		//IL_006e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0073: Unknown result type (might be due to invalid IL or missing references)
		//IL_008c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0091: Unknown result type (might be due to invalid IL or missing references)
		//IL_00aa: Unknown result type (might be due to invalid IL or missing references)
		//IL_00af: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c8: Unknown result type (might be due to invalid IL or missing references)
		//IL_00cd: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e6: Unknown result type (might be due to invalid IL or missing references)
		//IL_00eb: Unknown result type (might be due to invalid IL or missing references)
		//IL_0104: Unknown result type (might be due to invalid IL or missing references)
		//IL_0109: Unknown result type (might be due to invalid IL or missing references)
	}
}
[CompilerGenerated]
[GeneratedCode("Unity.MonoScriptGenerator.MonoScriptInfoGenerator", null)]
[EditorBrowsable(EditorBrowsableState.Never)]
internal class UnitySourceGeneratedAssemblyMonoScriptTypes_v1
{
	private struct MonoScriptData
	{
		public byte[] FilePathsData;

		public byte[] TypesData;

		public int TotalTypes;

		public int TotalFiles;

		public bool IsEditorOnly;
	}

	[MethodImpl(MethodImplOptions.AggressiveInlining)]
	private static MonoScriptData Get()
	{
		return new MonoScriptData
		{
			FilePathsData = new byte[1478]
			{
				0, 0, 0, 1, 0, 0, 0, 51, 92, 65,
				115, 115, 101, 116, 115, 92, 80, 108, 117, 103,
				105, 110, 115, 92, 65, 110, 105, 109, 97, 108,
				115, 71, 97, 109, 101, 92, 83, 99, 114, 105,
				112, 116, 115, 92, 65, 117, 100, 105, 111, 77,
				97, 110, 97, 103, 101, 114, 46, 99, 115, 0,
				0, 0, 1, 0, 0, 0, 55, 92, 65, 115,
				115, 101, 116, 115, 92, 80, 108, 117, 103, 105,
				110, 115, 92, 65, 110, 105, 109, 97, 108, 115,
				71, 97, 109, 101, 92, 83, 99, 114, 105, 112,
				116, 115, 92, 67, 97, 109, 101, 114, 97, 67,
				111, 110, 116, 114, 111, 108, 108, 101, 114, 46,
				99, 115, 0, 0, 0, 1, 0, 0, 0, 49,
				92, 65, 115, 115, 101, 116, 115, 92, 80, 108,
				117, 103, 105, 110, 115, 92, 65, 110, 105, 109,
				97, 108, 115, 71, 97, 109, 101, 92, 83, 99,
				114, 105, 112, 116, 115, 92, 67, 111, 105, 110,
				80, 105, 99, 107, 117, 112, 46, 99, 115, 0,
				0, 0, 1, 0, 0, 0, 50, 92, 65, 115,
				115, 101, 116, 115, 92, 80, 108, 117, 103, 105,
				110, 115, 92, 65, 110, 105, 109, 97, 108, 115,
				71, 97, 109, 101, 92, 83, 99, 114, 105, 112,
				116, 115, 92, 67, 111, 105, 110, 83, 112, 97,
				119, 110, 101, 114, 46, 99, 115, 0, 0, 0,
				1, 0, 0, 0, 47, 92, 65, 115, 115, 101,
				116, 115, 92, 80, 108, 117, 103, 105, 110, 115,
				92, 65, 110, 105, 109, 97, 108, 115, 71, 97,
				109, 101, 92, 83, 99, 114, 105, 112, 116, 115,
				92, 68, 101, 109, 111, 71, 97, 109, 101, 46,
				99, 115, 0, 0, 0, 1, 0, 0, 0, 55,
				92, 65, 115, 115, 101, 116, 115, 92, 80, 108,
				117, 103, 105, 110, 115, 92, 65, 110, 105, 109,
				97, 108, 115, 71, 97, 109, 101, 92, 83, 99,
				114, 105, 112, 116, 115, 92, 68, 111, 111, 114,
				73, 110, 116, 101, 114, 97, 99, 116, 97, 98,
				108, 101, 46, 99, 115, 0, 0, 0, 1, 0,
				0, 0, 54, 92, 65, 115, 115, 101, 116, 115,
				92, 80, 108, 117, 103, 105, 110, 115, 92, 65,
				110, 105, 109, 97, 108, 115, 71, 97, 109, 101,
				92, 83, 99, 114, 105, 112, 116, 115, 92, 71,
				97, 109, 101, 70, 108, 111, 119, 77, 97, 110,
				97, 103, 101, 114, 46, 99, 115, 0, 0, 0,
				2, 0, 0, 0, 58, 92, 65, 115, 115, 101,
				116, 115, 92, 80, 108, 117, 103, 105, 110, 115,
				92, 65, 110, 105, 109, 97, 108, 115, 71, 97,
				109, 101, 92, 83, 99, 114, 105, 112, 116, 115,
				92, 71, 97, 109, 101, 80, 114, 111, 103, 114,
				101, 115, 115, 84, 114, 97, 99, 107, 101, 114,
				46, 99, 115, 0, 0, 0, 1, 0, 0, 0,
				53, 92, 65, 115, 115, 101, 116, 115, 92, 80,
				108, 117, 103, 105, 110, 115, 92, 65, 110, 105,
				109, 97, 108, 115, 71, 97, 109, 101, 92, 83,
				99, 114, 105, 112, 116, 115, 92, 71, 97, 109,
				101, 83, 101, 116, 117, 112, 71, 117, 105, 100,
				101, 46, 99, 115, 0, 0, 0, 1, 0, 0,
				0, 52, 92, 65, 115, 115, 101, 116, 115, 92,
				80, 108, 117, 103, 105, 110, 115, 92, 65, 110,
				105, 109, 97, 108, 115, 71, 97, 109, 101, 92,
				83, 99, 114, 105, 112, 116, 115, 92, 71, 97,
				109, 101, 85, 73, 77, 97, 110, 97, 103, 101,
				114, 46, 99, 115, 0, 0, 0, 1, 0, 0,
				0, 57, 92, 65, 115, 115, 101, 116, 115, 92,
				80, 108, 117, 103, 105, 110, 115, 92, 65, 110,
				105, 109, 97, 108, 115, 71, 97, 109, 101, 92,
				83, 99, 114, 105, 112, 116, 115, 92, 73, 110,
				116, 101, 114, 97, 99, 116, 105, 111, 110, 66,
				117, 116, 116, 111, 110, 115, 46, 99, 115, 0,
				0, 0, 2, 0, 0, 0, 56, 92, 65, 115,
				115, 101, 116, 115, 92, 80, 108, 117, 103, 105,
				110, 115, 92, 65, 110, 105, 109, 97, 108, 115,
				71, 97, 109, 101, 92, 83, 99, 114, 105, 112,
				116, 115, 92, 73, 110, 116, 101, 114, 97, 99,
				116, 105, 111, 110, 83, 121, 115, 116, 101, 109,
				46, 99, 115, 0, 0, 0, 2, 0, 0, 0,
				49, 92, 65, 115, 115, 101, 116, 115, 92, 80,
				108, 117, 103, 105, 110, 115, 92, 65, 110, 105,
				109, 97, 108, 115, 71, 97, 109, 101, 92, 83,
				99, 114, 105, 112, 116, 115, 92, 73, 116, 101,
				109, 80, 105, 99, 107, 117, 112, 46, 99, 115,
				0, 0, 0, 1, 0, 0, 0, 60, 92, 65,
				115, 115, 101, 116, 115, 92, 80, 108, 117, 103,
				105, 110, 115, 92, 65, 110, 105, 109, 97, 108,
				115, 71, 97, 109, 101, 92, 83, 99, 114, 105,
				112, 116, 115, 92, 77, 111, 98, 105, 108, 101,
				73, 110, 112, 117, 116, 67, 111, 110, 116, 114,
				111, 108, 108, 101, 114, 46, 99, 115, 0, 0,
				0, 1, 0, 0, 0, 57, 92, 65, 115, 115,
				101, 116, 115, 92, 80, 108, 117, 103, 105, 110,
				115, 92, 65, 110, 105, 109, 97, 108, 115, 71,
				97, 109, 101, 92, 83, 99, 114, 105, 112, 116,
				115, 92, 78, 97, 114, 114, 97, 116, 105, 118,
				101, 71, 97, 109, 101, 83, 101, 116, 117, 112,
				46, 99, 115, 0, 0, 0, 1, 0, 0, 0,
				55, 92, 65, 115, 115, 101, 116, 115, 92, 80,
				108, 117, 103, 105, 110, 115, 92, 65, 110, 105,
				109, 97, 108, 115, 71, 97, 109, 101, 92, 83,
				99, 114, 105, 112, 116, 115, 92, 78, 97, 114,
				114, 97, 116, 105, 118, 101, 77, 97, 110, 97,
				103, 101, 114, 46, 99, 115, 0, 0, 0, 2,
				0, 0, 0, 55, 92, 65, 115, 115, 101, 116,
				115, 92, 80, 108, 117, 103, 105, 110, 115, 92,
				65, 110, 105, 109, 97, 108, 115, 71, 97, 109,
				101, 92, 83, 99, 114, 105, 112, 116, 115, 92,
				78, 97, 114, 114, 97, 116, 105, 118, 101, 84,
				114, 105, 103, 103, 101, 114, 46, 99, 115, 0,
				0, 0, 2, 0, 0, 0, 49, 92, 65, 115,
				115, 101, 116, 115, 92, 80, 108, 117, 103, 105,
				110, 115, 92, 65, 110, 105, 109, 97, 108, 115,
				71, 97, 109, 101, 92, 83, 99, 114, 105, 112,
				116, 115, 92, 83, 99, 101, 110, 101, 83, 101,
				116, 117, 112, 46, 99, 115, 0, 0, 0, 1,
				0, 0, 0, 61, 92, 65, 115, 115, 101, 116,
				115, 92, 80, 108, 117, 103, 105, 110, 115, 92,
				65, 110, 105, 109, 97, 108, 115, 71, 97, 109,
				101, 92, 83, 99, 114, 105, 112, 116, 115, 92,
				83, 105, 109, 112, 108, 101, 80, 108, 97, 121,
				101, 114, 67, 111, 110, 116, 114, 111, 108, 108,
				101, 114, 46, 99, 115, 0, 0, 0, 1, 0,
				0, 0, 49, 92, 65, 115, 115, 101, 116, 115,
				92, 80, 108, 117, 103, 105, 110, 115, 92, 65,
				110, 105, 109, 97, 108, 115, 71, 97, 109, 101,
				92, 83, 99, 114, 105, 112, 116, 115, 92, 84,
				97, 115, 107, 76, 105, 115, 116, 85, 73, 46,
				99, 115, 0, 0, 0, 1, 0, 0, 0, 55,
				92, 65, 115, 115, 101, 116, 115, 92, 80, 108,
				117, 103, 105, 110, 115, 92, 65, 110, 105, 109,
				97, 108, 115, 71, 97, 109, 101, 92, 83, 99,
				114, 105, 112, 116, 115, 92, 84, 114, 101, 97,
				115, 117, 114, 101, 72, 117, 110, 116, 71, 97,
				109, 101, 46, 99, 115, 0, 0, 0, 1, 0,
				0, 0, 55, 92, 65, 115, 115, 101, 116, 115,
				92, 80, 108, 117, 103, 105, 110, 115, 92, 65,
				110, 105, 109, 97, 108, 115, 71, 97, 109, 101,
				92, 83, 99, 114, 105, 112, 116, 115, 92, 84,
				114, 101, 97, 115, 117, 114, 101, 72, 117, 110,
				116, 84, 97, 115, 107, 46, 99, 115, 0, 0,
				0, 1, 0, 0, 0, 54, 92, 65, 115, 115,
				101, 116, 115, 92, 80, 108, 117, 103, 105, 110,
				115, 92, 65, 110, 105, 109, 97, 108, 115, 71,
				97, 109, 101, 92, 83, 99, 114, 105, 112, 116,
				115, 92, 86, 105, 114, 116, 117, 97, 108, 74,
				111, 121, 115, 116, 105, 99, 107, 46, 99, 115,
				0, 0, 0, 1, 0, 0, 0, 50, 92, 65,
				115, 115, 101, 116, 115, 92, 80, 108, 117, 103,
				105, 110, 115, 92, 65, 110, 105, 109, 97, 108,
				115, 71, 97, 109, 101, 92, 83, 99, 114, 105,
				112, 116, 115, 92, 87, 97, 114, 109, 85, 73,
				84, 104, 101, 109, 101, 46, 99, 115
			},
			TypesData = new byte[635]
			{
				0, 0, 0, 0, 13, 124, 65, 117, 100, 105,
				111, 77, 97, 110, 97, 103, 101, 114, 0, 0,
				0, 0, 17, 124, 67, 97, 109, 101, 114, 97,
				67, 111, 110, 116, 114, 111, 108, 108, 101, 114,
				0, 0, 0, 0, 11, 124, 67, 111, 105, 110,
				80, 105, 99, 107, 117, 112, 0, 0, 0, 0,
				12, 124, 67, 111, 105, 110, 83, 112, 97, 119,
				110, 101, 114, 0, 0, 0, 0, 9, 124, 68,
				101, 109, 111, 71, 97, 109, 101, 0, 0, 0,
				0, 17, 124, 68, 111, 111, 114, 73, 110, 116,
				101, 114, 97, 99, 116, 97, 98, 108, 101, 0,
				0, 0, 0, 16, 124, 71, 97, 109, 101, 70,
				108, 111, 119, 77, 97, 110, 97, 103, 101, 114,
				0, 0, 0, 0, 20, 124, 71, 97, 109, 101,
				80, 114, 111, 103, 114, 101, 115, 115, 84, 114,
				97, 99, 107, 101, 114, 0, 0, 0, 0, 33,
				71, 97, 109, 101, 80, 114, 111, 103, 114, 101,
				115, 115, 84, 114, 97, 99, 107, 101, 114, 124,
				80, 114, 111, 103, 114, 101, 115, 115, 69, 118,
				101, 110, 116, 0, 0, 0, 0, 15, 124, 71,
				97, 109, 101, 83, 101, 116, 117, 112, 71, 117,
				105, 100, 101, 0, 0, 0, 0, 14, 124, 71,
				97, 109, 101, 85, 73, 77, 97, 110, 97, 103,
				101, 114, 0, 0, 0, 0, 19, 124, 73, 110,
				116, 101, 114, 97, 99, 116, 105, 111, 110, 66,
				117, 116, 116, 111, 110, 115, 0, 0, 0, 0,
				18, 124, 73, 110, 116, 101, 114, 97, 99, 116,
				105, 111, 110, 83, 121, 115, 116, 101, 109, 0,
				0, 0, 0, 13, 124, 73, 110, 116, 101, 114,
				97, 99, 116, 97, 98, 108, 101, 0, 0, 0,
				0, 11, 124, 73, 116, 101, 109, 80, 105, 99,
				107, 117, 112, 0, 0, 0, 0, 19, 73, 116,
				101, 109, 80, 105, 99, 107, 117, 112, 124, 73,
				116, 101, 109, 68, 97, 116, 97, 0, 0, 0,
				0, 22, 124, 77, 111, 98, 105, 108, 101, 73,
				110, 112, 117, 116, 67, 111, 110, 116, 114, 111,
				108, 108, 101, 114, 0, 0, 0, 0, 19, 124,
				78, 97, 114, 114, 97, 116, 105, 118, 101, 71,
				97, 109, 101, 83, 101, 116, 117, 112, 0, 0,
				0, 0, 17, 124, 78, 97, 114, 114, 97, 116,
				105, 118, 101, 77, 97, 110, 97, 103, 101, 114,
				0, 0, 0, 0, 17, 124, 78, 97, 114, 114,
				97, 116, 105, 118, 101, 84, 114, 105, 103, 103,
				101, 114, 0, 0, 0, 0, 31, 78, 97, 114,
				114, 97, 116, 105, 118, 101, 84, 114, 105, 103,
				103, 101, 114, 124, 78, 97, 114, 114, 97, 116,
				105, 118, 101, 69, 118, 101, 110, 116, 0, 0,
				0, 0, 11, 124, 83, 99, 101, 110, 101, 83,
				101, 116, 117, 112, 0, 0, 0, 0, 20, 83,
				99, 101, 110, 101, 83, 101, 116, 117, 112, 124,
				83, 99, 101, 110, 101, 65, 114, 101, 97, 0,
				0, 0, 0, 23, 124, 83, 105, 109, 112, 108,
				101, 80, 108, 97, 121, 101, 114, 67, 111, 110,
				116, 114, 111, 108, 108, 101, 114, 0, 0, 0,
				0, 11, 124, 84, 97, 115, 107, 76, 105, 115,
				116, 85, 73, 0, 0, 0, 0, 17, 124, 84,
				114, 101, 97, 115, 117, 114, 101, 72, 117, 110,
				116, 71, 97, 109, 101, 0, 0, 0, 0, 17,
				124, 84, 114, 101, 97, 115, 117, 114, 101, 72,
				117, 110, 116, 84, 97, 115, 107, 0, 0, 0,
				0, 16, 124, 86, 105, 114, 116, 117, 97, 108,
				74, 111, 121, 115, 116, 105, 99, 107, 0, 0,
				0, 0, 12, 124, 87, 97, 114, 109, 85, 73,
				84, 104, 101, 109, 101
			},
			TotalFiles = 24,
			TotalTypes = 29,
			IsEditorOnly = false
		};
	}
}
