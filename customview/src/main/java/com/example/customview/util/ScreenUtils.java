package com.example.customview.util;


import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.Gravity;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;


import com.example.customview.R;

import java.util.List;

/**
 * 屏幕尺寸相关
 */
public class ScreenUtils {

	private static int navigationBarHeight = 0;
	/**
	 * 状态栏高度
	 */
	private static int statusHeight = -1;

	/**
	 * 将px值转换为dip或dp值，保证尺寸大小不变
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = getDisplayMetrics(context).density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * 将dip或dp值转换为px值，保证尺寸大小不变
	 */
	public static int dip2px(Context context, float dipValue) {
		final float scale = getDisplayMetrics(context).density;
		return (int) (dipValue * scale + 0.5f);
	}

	/**
	 * 将px值转换为sp值，保证文字大小不变
	 */
	public static int px2sp(Context context, float pxValue) {
		final float fontScale = getDisplayMetrics(context).scaledDensity;
		return (int) (pxValue / fontScale + 0.5f);
	}

	/**
	 * 将sp值转换为px值，保证文字大小不变
	 */
	public static int sp2px(Context context, float spValue) {
		final float fontScale = getDisplayMetrics(context).scaledDensity;
		return (int) (spValue * fontScale + 0.5f);
	}


	public static boolean isNavigationBarExist(Context context) {
		boolean hasMenuKey = ViewConfiguration.get(context).hasPermanentMenuKey();
		boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
		return !hasMenuKey && !hasBackKey;
	}


	public static void initAppNavigationBarHeight(final Activity context, final View contentView) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			contentView.postDelayed(new Runnable() {
				@Override
				public void run() {
					try {
						ViewGroup vp = (ViewGroup) context.getWindow().getDecorView();
						View view = vp.findViewById(android.R.id.navigationBarBackground);
						if (view == null) {
							String NAVIGATION = "navigationBarBackground";
							for (int i = 0; i < vp.getChildCount(); i++) {
								View child = vp.getChildAt(i);
								int id = child.getId();
								if (id != -1 && NAVIGATION.equals(context.getResources().getResourceEntryName(id))) {
									view = child;
									break;
								}
							}
						}
						if (view == null) {
							//navigationBarHeight = 0;
							return;
						}
						int height = view.getMeasuredHeight();
						if (height == 0) {
							height = view.getHeight();
						}
						navigationBarHeight = height;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}, 200);
		} else {
			Resources resources = context.getResources();
			int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
			if (resourceId > -1) {
				navigationBarHeight = resources.getDimensionPixelSize(resourceId);
			} else {
				navigationBarHeight = dip2px(context, 48);
			}
		}
	}

	//获取系统当前的NavigationBar的高度
	public static int getAppNavigationBarHeight() {
		return navigationBarHeight;
	}

	//获取当前Activity的NavigationBar的高度
	public static int getNavigationBarHeight(Activity context) {
		if (isNavigationBarShow(context) && isNavigationBarExist(context)) {
			return navigationBarHeight;
		}
		return 0;
	}

	/**
	 * 获取状态栏高度
	 *
	 * @param context
	 * @return
	 */
	public static int getStatusHeight(Context context) {

		if (statusHeight == -1) {
			int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
			if (resourceId > 0) {
				return context.getResources().getDimensionPixelSize(resourceId);
			}
			try {
				Class<?> clazz = Class.forName("com.android.internal.R$dimen");
				Object object = clazz.newInstance();
				int height = Integer.parseInt(clazz.getField("status_bar_height")
						.get(object).toString());
				statusHeight = context.getResources().getDimensionPixelSize(height);
			} catch (Exception e) {
				e.printStackTrace();
				statusHeight = dip2px(context, 25);
			}
		}
		return statusHeight;
	}

	public static int getStatusHeightDp(Context context) {
		return px2dip(context, getStatusHeight(context));
	}

	/**
	 * 获取屏幕宽度
	 *
	 * @param context
	 * @return
	 */
	public static int getScreenWidth(Context context) {
		return getScreenDisplayMetrics(context).widthPixels;
	}

	/**
	 * 获取屏幕高度
	 *
	 * @param context
	 * @return
	 */
	public static int getScreenHeight(Context context) {
		return getScreenDisplayMetrics(context).heightPixels;
	}

	/**
	 * 屏幕缩放比
	 */
	public static float getScreenScale(Context context) {
		return getScreenDisplayMetrics(context).density;
	}

	/**
	 * 屏幕像素密度
	 */
	public static int getScreenDpi(Context context) {
		return getScreenDisplayMetrics(context).densityDpi;
	}

	/**
	 * 获取屏幕物理英寸
	 */
	public static double getScreenPhysicalInches(Context context) {
		Point point = getRealScreenPoint(context.getApplicationContext());
		DisplayMetrics dm = getDisplayMetrics(context);
		double x = Math.pow(point.x / dm.xdpi, 2);
		double y = Math.pow(point.y / dm.ydpi, 2);
		return Math.sqrt(x + y);
	}

	/**
	 * 获取屏幕英寸宽
	 */
	public static double getScreenPhysicalWidth(Context context) {
		Point point = getRealScreenPoint(context);
		DisplayMetrics dm = getDisplayMetrics(context);
		return point.x / dm.xdpi;
	}

	/**
	 * 获取屏幕英寸高
	 */
	public static double getScreenPhysicalHeight(Context context) {
		Point point = getRealScreenPoint(context);
		DisplayMetrics dm = getDisplayMetrics(context);
		return point.y / dm.ydpi;
	}

	public static boolean isPad(Context context) {
		return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
	}

	/**
	 * 竖屏模式下，屏幕比例不是手机1080/1920的尺寸
	 * 例如折叠手机
	 */
	public static boolean isNotScalePhone(Context context) {
		Point point = getRealScreenPoint(context);
		DisplayMetrics dm = getDisplayMetrics(context);
		double physicalWidth = point.x / dm.xdpi;
		double physicalHeight = point.y / dm.ydpi;
		double scaleDex = Math.abs(physicalWidth / physicalHeight - 1080.0 / 1920);
		return scaleDex >= 0.125F;
	}

	/**
	 * 获取屏幕真实宽度（包含虚拟导航栏区域）
	 *
	 * @param context
	 * @return
	 */
	public static int getRealScreenWidth(Context context) {
		return getRealScreenPoint(context).x;
	}


	/**
	 * 获取屏幕真实高度（包含虚拟导航栏区域）
	 *
	 * @param context
	 * @return
	 */
	public static int getRealScreenHeight(Context context) {
		return getRealScreenPoint(context).y;
	}


	public static DisplayMetrics getScreenDisplayMetrics(Context context) {
		Display d = getWindowManager(context).getDefaultDisplay();
		DisplayMetrics displayMetrics = new DisplayMetrics();
		d.getMetrics(displayMetrics);
		return displayMetrics;
	}

	/**
	 * 得到屏幕真实高度包含NavigationBar
	 */
	private static Point getRealScreenPoint(Context context) {
		int widthPixels = -1;
		int heightPixels = -1;

		Display d = getWindowManager(context).getDefaultDisplay();

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
			DisplayMetrics displayMetrics = new DisplayMetrics();
			d.getRealMetrics(displayMetrics);
			widthPixels = displayMetrics.widthPixels;
			heightPixels = displayMetrics.heightPixels;
			return new Point(widthPixels, heightPixels);
		}
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH && Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
			try {
				widthPixels = (Integer) Display.class.getMethod("getRawWidth").invoke(d);
				heightPixels = (Integer) Display.class.getMethod("getRawHeight").invoke(d);
			} catch (Exception ignored) {
				ignored.printStackTrace();
			}
		} else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
			try {
				Point realSize = new Point();
				Display.class.getMethod("getRealSize", Point.class).invoke(d, realSize);
				widthPixels = realSize.x;
				heightPixels = realSize.y;
			} catch (Exception ignored) {
				ignored.printStackTrace();
			}
		}
		return new Point(widthPixels, heightPixels);
	}


	/**
	 * 是否设备是全面屏
	 *
	 * @param context
	 * @return
	 */
	public static boolean isDeviceFullScreen(Context context) {

		int realScreenWidth = getRealScreenWidth(context);
		int realScreenHeight = getRealScreenHeight(context);

		int w = 0, h = 0;
		if (realScreenHeight > realScreenWidth) {
			w = realScreenWidth;
			h = realScreenHeight;
		} else if (realScreenWidth > realScreenHeight) {
			w = realScreenHeight;
			h = realScreenWidth;
		}

		double minScale = 1080.0 / 2160;

		if (h < 1920 - 50) {
			if (w >= 720) {
				return w * 1.0 / h * 1.0 <= minScale;
			}
			return false;
		} else if (h < 1920 + 50) {
			return false;
		} else {
			if (w >= 1080 && w < 1080 + 20) {
				return true;
			} else {
				return w * 1.0 / h * 1.0 <= minScale;
			}
		}

	}

	private static WindowManager getWindowManager(Context context) {
		if (context instanceof Activity && !((Activity) context).isFinishing()) {
			return ((Activity) context).getWindowManager();
		}
		return (WindowManager)context.getApplicationContext().
				getSystemService(Context.WINDOW_SERVICE);
	}

	public static DisplayMetrics getDisplayMetrics(Context context) {
		return context.getResources().getDisplayMetrics();
	}

	public static boolean isStatusBarShow(@NonNull Activity activity) {
		View decorView = activity.getWindow().getDecorView();
		int systemUiVisibility = decorView.getSystemUiVisibility();
		WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
		boolean windowFullScreen = (attributes.flags & WindowManager.LayoutParams.FLAG_FULLSCREEN) == WindowManager.LayoutParams.FLAG_FULLSCREEN;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
			boolean layoutFullScreen = (systemUiVisibility & View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN) == View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
			boolean fullScreen = (systemUiVisibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == View.SYSTEM_UI_FLAG_FULLSCREEN;
			return windowFullScreen || layoutFullScreen || fullScreen;
		}
		return windowFullScreen;
	}

	public static void fitCutoutScreenTop(@NonNull Activity activity, @NonNull View view) {
		fitCutoutScreen(activity, view, false, true);
	}

	public static void fitCutoutScreenLeft(@NonNull Activity activity, @NonNull View view) {
		fitCutoutScreen(activity, view, true, false);
	}

	public static void fitCutoutScreen(@NonNull Activity activity, @NonNull View view, boolean isPaddingLeft, boolean isPaddingTop) {
		fitCutoutScreen(activity, view, isPaddingLeft, isPaddingTop, false, false);
	}

	public static void fitCutoutScreen(@NonNull final Activity activity, @NonNull final View view, final boolean isPaddingLeft, final boolean isPaddingTop, final boolean isPaddingRight, final boolean isPaddingBottom) {
		Runnable runnable = new Runnable() {
			@SuppressLint("ObsoleteSdkInt")
			@Override
			public void run() {
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
					Object tag = view.getTag(R.id.TAG_VIEW_ORIGINAL_PADDING);
					Rect originalPadding;
					if (tag instanceof Rect) {
						originalPadding = (Rect) tag;
					} else {
						originalPadding = new Rect(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
						view.setTag(R.id.TAG_VIEW_ORIGINAL_PADDING, originalPadding);
					}
					Object tag1 = view.getTag(R.id.TAG_VIEW_ORIGINAL_LAYOUT_PARAM);
					ViewGroup.LayoutParams originalLayoutParams; // 只记录view的宽高。
					if (tag1 instanceof ViewGroup.LayoutParams) {
						originalLayoutParams = (ViewGroup.LayoutParams) tag1;
					} else {
						originalLayoutParams = new ViewGroup.LayoutParams(view.getLayoutParams());
						view.setTag(R.id.TAG_VIEW_ORIGINAL_LAYOUT_PARAM, originalLayoutParams);
					}

					int[] viewLocation = new int[2];
					view.getLocationInWindow(viewLocation);
					Rect viewRect = new Rect(viewLocation[0], viewLocation[1], viewLocation[0] + view.getWidth(), viewLocation[1] + view.getHeight());

					DisplayCutout disPlayCount = view.getRootWindowInsets().getDisplayCutout();
					if (disPlayCount == null) {
						view.setPadding(originalPadding.left, originalPadding.top, originalPadding.right, originalPadding.bottom);
						view.getLayoutParams().height = originalLayoutParams.height;
						view.getLayoutParams().width = originalLayoutParams.width;
						view.requestLayout();
						return;
					}
					int appendLeftPadding = 0;
					int appendTopPadding = 0;
					int appendRightPadding = 0;
					int appendBottomPadding = 0;

					// 只处理 View完全在Window内部，没有超出Window边界的情况。
					if (Build.VERSION.SDK_INT >= 29) {
						if (isPaddingTop) {
							Rect intersect = new Rect(disPlayCount.getBoundingRectTop());
							if (!intersect.isEmpty() && intersect.intersect(viewRect)) {
								appendTopPadding = intersect.height();
							}
						}
						if (isPaddingLeft) {
							Rect intersect = new Rect(disPlayCount.getBoundingRectLeft());
							if (!intersect.isEmpty() && intersect.intersect(viewRect)) {
								appendLeftPadding = intersect.width();
							}
						}
						if (isPaddingRight) {
							Rect intersect = new Rect(disPlayCount.getBoundingRectRight());
							if (!intersect.isEmpty() && intersect.intersect(viewRect)) {
								appendRightPadding = intersect.width();
							}
						}
						if (isPaddingBottom) {
							Rect intersect = new Rect(disPlayCount.getBoundingRectBottom());
							if (!intersect.isEmpty() && intersect.intersect(viewRect)) {
								appendBottomPadding = intersect.height();
							}
						}

					} else {
						List<Rect> boundingRects = disPlayCount.getBoundingRects();
						for (Rect rect : boundingRects) {
							Rect intersect = new Rect(rect);
							if (!intersect.isEmpty() && intersect.intersect(viewRect)) {

								int topDiff = intersect.top - viewRect.top;
								int leftDiff = intersect.left - viewRect.left;
								int rightDiff = viewRect.right - intersect.right;
								int bottomDiff = viewRect.bottom - intersect.bottom;

								if (isPaddingTop && topDiff <= leftDiff && topDiff <= rightDiff) {
									appendTopPadding += intersect.height() + (intersect.top - viewRect.top);
								}
								if (isPaddingLeft && leftDiff <= topDiff && leftDiff <= bottomDiff) {
									appendLeftPadding += intersect.width() + (intersect.left - viewRect.left);
								}

								if (isPaddingRight && rightDiff <= topDiff && rightDiff <= bottomDiff) {
									appendRightPadding += intersect.width() + (viewRect.right - intersect.right);
								}

								if (isPaddingBottom && bottomDiff <= leftDiff && bottomDiff <= rightDiff) {
									appendBottomPadding += intersect.height() + (viewRect.bottom - intersect.bottom);
								}
							}
						}
					}
					// 根据当前显示区域大小，在长边增加padding。
					Point outSize = new Point();
					Display display = view.getDisplay();
					if (display != null) {
						display.getSize(outSize);
					}
					if (isPaddingLeft && isPaddingTop && appendLeftPadding != 0 && appendTopPadding != 0) {
						if (outSize.x > outSize.y) { // 宽大于高，在侧边加padding
							appendTopPadding = 0;
						} else if (outSize.y > outSize.x) { // 高大于宽，在上下加padding
							appendLeftPadding = 0;
						} else {
							appendLeftPadding = 0;
						}
					}

					if (isPaddingRight && isPaddingTop && appendRightPadding != 0 && appendTopPadding != 0) {
						if (outSize.y > outSize.x) {
							appendRightPadding = 0;
						} else if (outSize.x > outSize.y) {
							appendTopPadding = 0;
						} else {
							appendRightPadding = 0;
						}
					}

					view.setPadding(originalPadding.left + appendLeftPadding, originalPadding.top + appendTopPadding, originalPadding.right + appendRightPadding,
							originalPadding.bottom + appendBottomPadding);
					if (originalLayoutParams.height >= 0 && (isPaddingTop || isPaddingBottom)) {
						view.getLayoutParams().height = originalLayoutParams.height + appendBottomPadding + appendTopPadding;
						view.requestLayout();
					}
					if (originalLayoutParams.width >= 0 && (isPaddingRight || isPaddingLeft)) {
						view.getLayoutParams().width = originalLayoutParams.width + appendLeftPadding + appendRightPadding;
						view.requestLayout();
					}
				}
			}
		};
		OneShotPreDrawListener.add(view, runnable);
	}

	/**
	 * 获取屏幕的安全区域
	 * 当decorView没有attach时获取不到正确的安全区域
	 *
	 * @return 屏幕的安全区域。
	 */
	@RequiresApi(Build.VERSION_CODES.P)
	public static Rect getSafeArea(@NonNull Activity activity) {
		Rect safeArea = new Rect();
		View decorView = activity.getWindow().getDecorView();
		WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
		// decorView没有attach时，rootWindowInsets 为 Null
		if (rootWindowInsets == null) {
			return safeArea;
		}
		DisplayCutout displayCutout = rootWindowInsets.getDisplayCutout();
		if (displayCutout == null) {
			return safeArea;
		}
		safeArea.set(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom());
		return safeArea;
	}

	@RequiresApi(Build.VERSION_CODES.P)
	public static DisplayCutout getDisPlayCount(@NonNull Activity activity) {
		View decorView = activity.getWindow().getDecorView();
		WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
		// decorView没有attach时，rootWindowInsets 为 Null
		if (rootWindowInsets == null) {
			return null;
		}
		return rootWindowInsets.getDisplayCutout();
	}

	/**
	 * 是否显示导航栏
	 *
	 * @param activity
	 * @return
	 */
	public static boolean isNavigationBarShow(Activity activity) {
		if (activity == null) {
			return false;
		}
		if (Build.FINGERPRINT.startsWith("generic")) {
			return true;
		}
		//虚拟键的view,为空或者不可见时是隐藏状态
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			View view = activity.findViewById(android.R.id.navigationBarBackground);
			return view != null && view.getVisibility() == View.VISIBLE;
		}
		Resources resources = activity.getResources();
		int id = resources.getIdentifier("config_showNavigationBar", "bool", "android");
		if (id > 0) {
			return resources.getBoolean(id);
		} else {    // Check for keys
			boolean hasMenuKey = ViewConfiguration.get(activity).hasPermanentMenuKey();
			boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
			return !hasMenuKey && !hasBackKey;
		}
	}


	/**
	 * 跳过躲避异形
	 */
	public static void fitCutoutView(final FragmentActivity activity, final View view) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
			if (activity == null || activity.isFinishing() || view == null || view.getVisibility() == View.GONE) {
				return;
			}
			OneShotPreDrawListener.add(view, new Runnable() {
				@Override
				public void run() {
					try {
						doFitCutoutView(activity, view, false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	public static void doFitCutoutView(final FragmentActivity activity, final View view, boolean doAnim) throws Exception {

		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
			return;
		}

		if (activity == null || activity.isFinishing() || view == null || view.getVisibility() == View.GONE) {
			return;
		}
		Window window = activity.getWindow();
		final View decorView = window.getDecorView();

		WindowInsets windowInsets = decorView.getRootWindowInsets();
		if (windowInsets == null) {
			return;
		}
		DisplayCutout displayCutout = windowInsets.getDisplayCutout();
		if (displayCutout == null) {
			return;
		}

		List<Rect> boundingRectList = displayCutout.getBoundingRects();

		Rect boundingRect = null;

		if (boundingRectList != null && boundingRectList.size() > 0) {
			boundingRect = boundingRectList.get(0);
		}

		if (boundingRect == null) {
			return;
		}

		int[] outLocation = new int[2];
		view.getLocationOnScreen(outLocation);

		DisplayMetrics displayMetrics = getScreenDisplayMetrics(decorView.getContext());

		int width = view.getWidth();
		int height = view.getHeight();

		Rect viewRect = new Rect(outLocation[0], outLocation[1], outLocation[0] + width, outLocation[1] + height);

		if (viewRect.intersect(boundingRect)) {
			ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
			if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
				final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;

				int widthPixels = displayMetrics.widthPixels;
				int heightPixels = displayMetrics.heightPixels;

				int boundingWidth = boundingRect.right - boundingRect.left;
				int boundingHeight = boundingRect.bottom - boundingRect.top;

				int startMarginTB = 0, endMarginTB = 0;
				int startMarginLR = 0, endMarginLR = 0;
				int marginGravityTB = Gravity.NO_GRAVITY;
				int marginGravityLR = Gravity.NO_GRAVITY;

				if (boundingRect.bottom < heightPixels / 2 && boundingRect.top < 20) {
					startMarginTB = marginLayoutParams.topMargin;
					endMarginTB = marginLayoutParams.topMargin + boundingHeight;
					marginGravityTB = Gravity.TOP;
				} else if (boundingRect.top > heightPixels / 2 && Math.abs(boundingRect.bottom - heightPixels) < 20) {
					startMarginTB = marginLayoutParams.bottomMargin;
					endMarginTB = marginLayoutParams.bottomMargin + boundingHeight;
					marginGravityTB = Gravity.BOTTOM;
				}

				if (boundingRect.right < widthPixels / 2) {
					startMarginLR = marginLayoutParams.leftMargin;
					endMarginLR = marginLayoutParams.leftMargin + boundingWidth;
					marginGravityLR = Gravity.LEFT;
				} else if (boundingRect.left > widthPixels / 2) {
					startMarginLR = marginLayoutParams.rightMargin;
					endMarginLR = marginLayoutParams.rightMargin + boundingWidth;
					marginGravityLR = Gravity.RIGHT;
				}

				int dexTB = Math.abs(endMarginTB - startMarginTB);
				int dexLR = Math.abs(endMarginLR - startMarginLR);

				int startMargin = 0, endMargin = 0;
				int marginGravity = Gravity.NO_GRAVITY;

				if (dexTB != 0 && dexLR != 0) {
					if (dexLR < dexTB) {
						startMargin = startMarginLR;
						endMargin = endMarginLR;
						marginGravity = marginGravityLR;
					} else {
						startMargin = endMarginTB;
						endMargin = endMarginTB;
						marginGravity = marginGravityTB;
					}
				} else if (dexTB != 0) {
					startMargin = endMarginTB;
					endMargin = endMarginTB;
					marginGravity = marginGravityTB;
				} else if (dexLR != 0) {
					startMargin = startMarginLR;
					endMargin = endMarginLR;
					marginGravity = marginGravityLR;
				}

				if (marginGravity == Gravity.NO_GRAVITY) {
					return;
				}

				if (doAnim) {
					doCutViewAnim(activity, view, marginLayoutParams, startMargin, endMargin, marginGravity);
				} else {
					setMargin(view, marginLayoutParams, endMarginTB, endMarginLR, marginGravity);
				}
			}
		}
	}

	private static void setMargin(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int endMarginTB, int endMarginLR, int marginGravity) {
		try {
			switch (marginGravity) {
				case Gravity.TOP:
					marginLayoutParams.topMargin = endMarginTB;
					break;
				case Gravity.BOTTOM:
					marginLayoutParams.bottomMargin = endMarginTB;
					break;
				case Gravity.LEFT:
					marginLayoutParams.leftMargin = endMarginLR;
					break;
				case Gravity.RIGHT:
					marginLayoutParams.rightMargin = endMarginLR;
					break;
			}
			view.setLayoutParams(marginLayoutParams);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void doCutViewAnim(FragmentActivity activity, final View view, final ViewGroup.MarginLayoutParams marginLayoutParams, int startMargin, int endMargin, int marginGravity) throws Exception {
		final Lifecycle lifecycle = activity.getLifecycle();

		final int marginGravityFinal = marginGravity;

		final ValueAnimator animator = ValueAnimator.ofInt(startMargin, endMargin);

		final OnDestroyLifecycleObserver lifecycleObserver = new OnDestroyLifecycleObserver() {
			@Override
			public void onDestroy() {
				try {
					if (animator.isRunning()) {
						animator.cancel();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		animator.addListener(new Animator.AnimatorListener() {
			@Override
			public void onAnimationStart(Animator animation) {

			}

			@Override
			public void onAnimationEnd(Animator animation) {
				try {
					lifecycle.removeObserver(lifecycleObserver);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			@Override
			public void onAnimationCancel(Animator animation) {

			}

			@Override
			public void onAnimationRepeat(Animator animation) {

			}
		});
		animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				try {
					int margin = (int) animation.getAnimatedValue();
					switch (marginGravityFinal) {
						case Gravity.TOP:
							marginLayoutParams.topMargin = margin;
							break;
						case Gravity.BOTTOM:
							marginLayoutParams.bottomMargin = margin;
							break;
						case Gravity.LEFT:
							marginLayoutParams.leftMargin = margin;
							break;
						case Gravity.RIGHT:
							marginLayoutParams.rightMargin = margin;
							break;
					}
					view.setLayoutParams(marginLayoutParams);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		animator.setDuration(280);
		animator.start();

		lifecycle.addObserver(lifecycleObserver);
	}

}
