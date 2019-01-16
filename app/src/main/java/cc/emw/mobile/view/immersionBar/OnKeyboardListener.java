package cc.emw.mobile.view.immersionBar;

/**
 * 软键盘监听
 * Created by liuwei on 2017/11/21.
 */
public interface OnKeyboardListener {
    /**
     * On keyboard change.
     *
     * @param isPopup        the is popup  是否弹出
     * @param keyboardHeight the keyboard height  软键盘高度
     */
    void onKeyboardChange(boolean isPopup, int keyboardHeight);
}
