package tw.edu.pu.csim.mis2b.wcchen.snake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GameView extends View {
    private Bitmap bmGrass1, bmGrass2, bmSnake;
    public static int size0fMap = 75*Constants.SCREEN_WIDTH/1080;
    private int h = 21, w = 12;
    private ArrayList<Grass> arrGrass = new ArrayList<>();
    private Snake snake;        //Create Snake in GameView
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bmGrass1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.grass);
        bmGrass1 = Bitmap.createScaledBitmap(bmGrass1, size0fMap, size0fMap, true);
        bmGrass2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.grass03);
        bmGrass2 = Bitmap.createScaledBitmap(bmGrass2, size0fMap, size0fMap, true);
        bmSnake = BitmapFactory.decodeResource(this.getResources(), R.drawable.snake1);
        bmSnake = Bitmap.createScaledBitmap(bmSnake, 14*size0fMap, size0fMap, true);
        for (int i = 0; i < h; i++){
            for (int j = 0; j < w; j++){
                if((i+j)%2==0){
                    arrGrass.add(new Grass(bmGrass1, j*size0fMap + Constants.SCREEN_WIDTH/2-(w/2)*size0fMap,
                            i*size0fMap+100*Constants.SCREEN_HEIGHT/1920, size0fMap, size0fMap));
                }else{
                    arrGrass.add(new Grass(bmGrass2, j*size0fMap + Constants.SCREEN_WIDTH/2-(w/2)*size0fMap,
                            i*size0fMap+100*Constants.SCREEN_HEIGHT/1920, size0fMap, size0fMap));
                }
            }
        }
        snake = new Snake(bmSnake, arrGrass.get(126).getX(), arrGrass.get(126).getY(), 4);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(0xFF208C0D);
        for (int i = 0; i < arrGrass.size(); i++){
            canvas.drawBitmap(arrGrass.get(i).getBm(), arrGrass.get(i).getX(), arrGrass.get(i).getY(), null);
        }
        snake.draw(canvas);
    }
}
