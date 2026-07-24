package com.example.hospital.vista;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.hospital.R;

public class WifiActivity extends AppCompatActivity {

    private TextView txtSsid, txtBssid, txtVelocidad, txtRssi, txtIp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        txtSsid = findViewById(R.id.txtSsid);
        txtBssid = findViewById(R.id.txtBssid);
        txtVelocidad = findViewById(R.id.txtVelocidad);
        txtRssi = findViewById(R.id.txtRssi);
        txtIp = findViewById(R.id.txtIp);

        mostrarDatosWifi();
    }

    private void mostrarDatosWifi() {
        WifiManager wifiManager = (WifiManager) getApplicationContext()
                .getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();

        txtSsid.setText("SSID: " + wifiInfo.getSSID());
        txtBssid.setText("BSSID: " + wifiInfo.getBSSID());
        txtVelocidad.setText("Velocidad: " + wifiInfo.getLinkSpeed() + " Mbps");
        txtRssi.setText("Señal (RSSI): " + wifiInfo.getRssi() + " dBm");
        txtIp.setText("Dirección IP: " + Formatter.formatIpAddress(wifiInfo.getIpAddress()));
    }
}