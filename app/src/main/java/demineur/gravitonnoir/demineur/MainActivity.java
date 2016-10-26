package demineur.gravitonnoir.demineur;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import demineur.gravitonnoir.demineur.game.GameManager;
import demineur.gravitonnoir.demineur.view.GameView;

public class MainActivity extends Activity {

    private GameManager gameManager;

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_menu);

        final Button new_game = (Button) findViewById(R.id.new_game_button);
        final Button quit_game = (Button) findViewById(R.id.quit_button);

        new_game.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gameManager = new GameManager();

                gameManager.newGame();

                setContentView(R.layout.game_view);
            }
        });

        quit_game.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
