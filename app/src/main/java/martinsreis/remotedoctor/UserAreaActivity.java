package martinsreis.remotedoctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        final TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
        final TextView tvMsgUserArea = (TextView) findViewById(R.id.tvMsgUserArea);
        final Button bSendData = (Button) findViewById(R.id.bSendData);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");

        String messageUser = "Olá "+ nome +", tudo bem?";
        tvWelcomeMsg.setText(messageUser);
        String messageMedicoes = "Não se esqueça de fazer todas as medições e atualizar o dados no Samsung Health antes de enviar os dados.";
        tvMsgUserArea.setText(messageMedicoes);


        bSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //implementar ação do botão enviar dados
            }
        });

    }
}
