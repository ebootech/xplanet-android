package tech.eboot.xplanet;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import tech.eboot.xplanet.client.TcpClient;
import tech.eboot.xplanet.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        binding.btnStartClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //连接服务器
                //www.eboot.tech  服务器地址
                TcpClient.startClient( "www.eboot.tech", 10937);
            }
        });
        binding.btnSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TcpClient.sendTcpMessage("Android发送一条数据");
            }
        });
    }

}