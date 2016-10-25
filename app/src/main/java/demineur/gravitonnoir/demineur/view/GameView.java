package demineur.gravitonnoir.demineur.view;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.ScaleGestureDetector;
import android.view.View;

/**
 * Created by Graviton Noir on 21/10/2016.
 */

public class GameView extends View {

    private ScaleGestureDetector mScaleDetector;
    private float mScaleFactor = 1.f;

    private void initAttr(Context context) {
        mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
    }

    public GameView(Context context) {
        super (context);

        initAttr(context);
    }

    public GameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        initAttr(context);
    }

    ///////////////////////

    /**
     * Give the correct axis measure for the layout
     * @param axisMeasure
     * @param screenAxisMeasure
     * @return
     */
    private int axisMeasure(int axisMeasure, int screenAxisMeasure) {
        int mode = MeasureSpec.getMode(axisMeasure);
        int size = MeasureSpec.getSize(axisMeasure);

        if (mode == MeasureSpec.UNSPECIFIED)
            return screenAxisMeasure;
        else
            return size;
    }


    private class ScaleListener implements ScaleGestureDetector.OnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            mScaleFactor *= scaleGestureDetector.getScaleFactor();

            // Permet d'avoir une limite de zoom in and zoom out
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 5.0f));

            invalidate();

            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return false;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {

        }
    }
}
