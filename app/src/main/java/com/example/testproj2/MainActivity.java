package com.example.testproj2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;



public class MainActivity extends AppCompatActivity {

    int redCount;
    int yellowCount;
    int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void testbox(View view){
        //ImageView flashbox = (ImageView) this.findViewById(R.id.imageView);
        ImageView img= (ImageView) findViewById(R.id.flashbox);
        //img.setBackgroundColor(getResources().getColor(R.color.ic_yellow_background));
        //img.setImageResource(R.color.ic_yellow_background);

        String givenSequence = "";
        int size = new Random().nextInt(5) + 18; // DELTA .1
        int redCount = 0; int yellowCount = 0;

        String[] sequence = new String[size];
        //R.color[] cSequence = new R.color[size];
        for(int x = 0; x < size; x++){
            Random RNGr = new Random();
            int RNG = RNGr.nextInt(2);

            if(RNG == 0){
                sequence[x] = "red";
                givenSequence += "red, ";
                redCount++;
            }
            else{
                sequence[x] = "yellow";
                givenSequence += "yellow, ";
                yellowCount++;
            }
        }

        System.out.println(givenSequence);

        this.size = size;
        this.redCount = redCount;
        this.yellowCount = yellowCount;

        //THIS SUCKS

        //TIMERS ARE BROKEN AND THERE ARE 5 NON-FUNCTIONAL OPTIONS BECAUSE THEY ALL SUCK

        Timer blankTimer = new Timer();
        //TimerTask bTT = blankState();
        //blankTimer.schedule(bTT, 1000);
        //blankTimer.schedule(bTT, 1000);


        Timer timer = new Timer();
        TimerTask tTask = new TimerTask() {
            int x = 0;
            @Override
            public void run() {
                System.out.println("From TimerTask " + x + "    Turning: " + sequence[x]);
                if (sequence[x].equals("red")){
                    img.setImageResource(R.color.ic_red_background);

                }
                else if(sequence[x].equals("yellow")){
                    img.setImageResource(R.color.ic_yellow_background);

                }
                blankTimer.schedule(blankState(), 500);


                x++;

                if(x == size){
                    timer.cancel();
                }

            }
        };

        timer.schedule(tTask, 0, 1000);

        //blankTimer.schedule(blankState(), 1000);

            /*
            Timer T = new Timer(true);
            if(sequence[y].equals("red")) {
                T.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        img.setImageResource(R.color.ic_red_background);
                        System.out.println("Printing red after .5 sec");
                    }
                }, 500L);
            }
            else{
                T.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        img.setImageResource(R.color.ic_yellow_background);
                        System.out.println("Printing yellow after .5 sec");
                    }
                }, 500L);
            }
            */








        /* ANOTHER STUNNING FAILURE
        TimeUnit time = TimeUnit.MILLISECONDS;
        for(int y = 0; y < size; y++){
            try {
                System.out.println("In timer block " + y);
                if(sequence[y].equals("red")){

                    time.sleep(1000L);
                }
                else{

                    time.sleep(1000L);
                }

            }
            catch (InterruptedException e){}

            try{
                img.setImageResource(R.color.white);
                time.sleep(500L);
            }
            catch (InterruptedException e){}
        }
        */


        /*
        for(int x = 0; x < size; x++){

            System.out.println("sequence " + x + " = " + sequence[x]);
            int finalX = x;
            new CountDownTimer(1000L, 1000L){
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish(){
                    if(sequence[finalX].equals("red")){
                        img.setImageResource(R.color.ic_red_background);
                    }
                    else if(sequence[finalX].equals("yellow")){
                        img.setImageResource(R.color.ic_yellow_background);
                    }
                }
            }.start();
        */


            /*
            if(sequence[x] == "red"){
                new CountDownTimer(1000, 1000){
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    public void onFinish(){
                        img.setImageResource(R.color.ic_red_background);
                    }
                }.start();

            }
            //if(sequence[x] == "yellow")
            else{
                new CountDownTimer(1000, 1000){
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    public void onFinish(){

                        img.setImageResource(R.color.ic_yellow_background);
                    }
                }.start();
            }

            new CountDownTimer(500, 1000){
                @Override
                public void onTick(long millisUntilFinished) {

                }
                public void onFinish(){
                    img.setImageResource(R.color.white);
                }
            }.start();



        }
*/

        //ImageView img = (ImageView) findViewById(R.id.imageView);
        ///img.set
    }



    public TimerTask setRed(){
        ImageView img= (ImageView) findViewById(R.id.flashbox);
        img.setImageResource(R.color.ic_red_background);
        return null;
    }

    public TimerTask setYellow(){
        ImageView img= (ImageView) findViewById(R.id.flashbox);
        img.setImageResource(R.color.ic_yellow_background);
        return null;
    }

    public TimerTask setWhite(){
        ImageView img= (ImageView) findViewById(R.id.flashbox);
        img.setImageResource(R.color.white);
        return null;
    }

    public TimerTask blankState(){
        TimerTask bTTasl = new TimerTask() {
            @Override
            public void run() {
                System.out.println("test blankTimer");
                ImageView img = (ImageView) findViewById(R.id.flashbox);
                img.setImageResource(R.color.white);
                //blankTimer.cancel();
            }
        };
        return bTTasl;
    }

    public void SendEmail(View view) throws Exception {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        String resultString = "r: ";
        //simple encryption for results, just complex enough to obfuscate from people who did poorly ;)
        resultString += this.redCount + ",";
        resultString += this.yellowCount + ",";
        resultString += this.size + ",";

        //EditText tbTemp = (EditText) findViewById(R.id.editTextNumber4);
        //claimed red, yellow, total
        resultString += "c: ";
        resultString += ((EditText) findViewById(R.id.editTextNumber4)).getText() + ", ";
        resultString += ((EditText) findViewById(R.id.editTextNumber5)).getText() + ", ";
        resultString += ((EditText) findViewById(R.id.editTextNumber6)).getText() + ", ";

        //resultString += "(" + Math.round(Math.pow(Math.pow((this.redCount*13), 4), (1.0/4.0)) / 13.0) + ")";
        //testvals
        //resultString += this.redCount;
        //resultString += "(" + Math.round(Math.pow(Math.pow((this.yellowCount*13), 4), (1.0/4.0)) / 13.0) + ")";
        //testvals
        //resultString += this.yellowCount;

        final File file = new File("userReport");
        try {
            //fos = openFileOutput("userReport", Context.MODE_PRIVATE);
            FileOutputStream fos = openFileOutput("userReport", Context.MODE_PRIVATE);
            fos.write(resultString.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }





        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        //emailIntent.putExtra(Intent.EXTRA_EMAIL, "taylorburrowsresearchacct@gmail.com");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"taylorburrowsresearchacct@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Test data from user");
        resultString = encrypt(resultString);
        emailIntent.putExtra(Intent.EXTRA_TEXT, ("Please mail the result below to taylorburrowsresearchacct@gmail.com:\n"+ resultString));

        //Uri uri = Uri.fromFile(file);
        //emailIntent.putExtra(Intent.EXTRA_STREAM, uri); //attach file


        //String fileName = "userReport";
        //File fileLOC = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), fileName);
        //Uri path = Uri.fromFile(file);
        //emailIntent.putExtra(Intent.EXTRA_STREAM, path);

        //Uri uri = null;

        //Test of basic empty encryption
        //System.out.println(decrypt("2A84D457E200A86E6F4D4AD5A002FC0ACF26D31F0DB1B7912B9209E03544EA54"));


        startActivity(Intent.createChooser(emailIntent, "Send email via:"));

    }

    public static final byte[] keyValue = new byte[]{'r','a','n','d','o','m','x','y','r','a','n','d','o','m','x','y'};

    public String encrypt(String clearText) throws Exception {
        byte[] rawKey = getRawKey();
        byte[] result = encrypt(rawKey, clearText.getBytes());
        return toHex(result);
    }

    public static String decrypt(String encrypted)
            throws Exception {
        byte[] enc = toByte(encrypted);
        byte[] result = decrypt(enc);
        return new String(result);
    }

    private static byte[] getRawKey() throws Exception{
        SecretKey key = new SecretKeySpec(keyValue, "AES");
        byte[] raw = key.getEncoded();
        return raw;
    }

    private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception{
        SecretKey skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(clear);
        return encrypted;
    }

    private static byte[] decrypt(byte[] encrypted) throws Exception {
        SecretKey skeySpec = new SecretKeySpec(keyValue, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        return decrypted;
    }

    public static byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++){
            result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
        }
        return result;
    }
    public static String toHex(byte[] buf) {
        if (buf == null)
            return "";
        StringBuffer result = new StringBuffer(2 * buf.length);
        for (int i = 0; i < buf.length; i++) {
            appendHex(result, buf[i]);
        }
        return result.toString();
}
    private static void appendHex(StringBuffer sb, byte b) {
        String HEX = "0123456789ABCDEF";
        sb.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));
    }


}