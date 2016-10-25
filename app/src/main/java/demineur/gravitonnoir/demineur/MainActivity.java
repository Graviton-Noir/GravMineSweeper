package demineur.gravitonnoir.demineur;

import android.app.Activity;
import android.os.Bundle;

import demineur.gravitonnoir.demineur.view.GameView;

public class MainActivity extends Activity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_menu);
    }
}
