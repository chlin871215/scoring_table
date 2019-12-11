package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView perioD,foulL,foulR;
        perioD = findViewById(R.id.periodview);
        foulL = findViewById(R.id.foulleft);
        foulR = findViewById(R.id.foulright);
        perioD.setText("節數\n" + period );
        foulL.setText("犯規數\n" + foulleft );
        foulR.setText("犯規數\n" + foulright );
        //
        final TextView text_view = (TextView) findViewById(R.id.showtext);
        new Thread(new Runnable(){
            public void run(){
                MysqlCon con = new MysqlCon();
                con.run();
                final String data = con.getData();
                Log.v("OK",data);
                text_view.post(new Runnable() {
                    public void run() {
                        text_view.setText(data);
                    }
                });

            }
        }).start();
    }

    int scoreleft,scoreright,foulleft,foulright,scoreplus,foulplus,period=1,chmembe,chmemaf;
    String markmember,markevent,teamchoice;


    public void change(){

        int L[]={1,1,1,1,1};
        int RR[]={1,1,1,1,1};
        EditText chbe = findViewById(R.id.changememberbefore);
        EditText chaf = findViewById(R.id.changememberafter);
        chmembe=Integer.valueOf(chbe.getText().toString());
        chmemaf=Integer.valueOf(chaf.getText().toString());
        Button memberL1=findViewById(R.id.memberL1);
        Button memberL2=findViewById(R.id.memberL2);
        Button memberL3=findViewById(R.id.memberL3);
        Button memberL4=findViewById(R.id.memberL4);
        Button memberL5=findViewById(R.id.memberL5);
        Button memberR1=findViewById(R.id.memberR1);
        Button memberR2=findViewById(R.id.memberR2);
        Button memberR3=findViewById(R.id.memberR3);
        Button memberR4=findViewById(R.id.memberR4);
        Button memberR5=findViewById(R.id.memberR5);
        L[0]=Integer.valueOf(memberL1.getText().toString());
        L[1]=Integer.valueOf(memberL2.getText().toString());
        L[2]=Integer.valueOf(memberL3.getText().toString());
        L[3]=Integer.valueOf(memberL4.getText().toString());
        L[4]=Integer.valueOf(memberL5.getText().toString());
        RR[0]=Integer.valueOf(memberR1.getText().toString());
        RR[1]=Integer.valueOf(memberR2.getText().toString());
        RR[2]=Integer.valueOf(memberR3.getText().toString());
        RR[3]=Integer.valueOf(memberR4.getText().toString());
        RR[4]=Integer.valueOf(memberR5.getText().toString());

        if(teamchoice=="深色"){
            for(int i=0;i<5;i++) {
                while (chmemaf != RR[i]&&i==4) {
                    for(int k=0;k<5;k++) {
                        if (chmembe == RR[k]) {
                            RR[k]=chmemaf;
                        }
                    }
                }
            }
        }else if(teamchoice=="淺色"){
            for(int i=0;i<5;i++) {
                if (chmemaf != L[i]&&i==4) {
                    for(int k=0;k<5;k++) {
                        if (chmembe == L[k]) {
                            L[k]=chmemaf;
                        }
                    }
                }
            }
        }
        for(int i=0;i<5;i++){
            for(int k=i+1;k<5;k++){
                if(L[i]>L[k]){
                    int buffer=L[i];
                    L[i]=L[k];
                    L[k]=buffer;
                }
            }
        }
        for(int i=0;i<5;i++){
            for(int k=i+1;k<5;k++){
                if(RR[i]>RR[k]){
                    int buffer=RR[i];
                    RR[i]=RR[k];
                    RR[k]=buffer;
                }
            }
        }
        memberL1.setText(""+L[0]);
        memberL2.setText(""+L[1]);
        memberL3.setText(""+L[2]);
        memberL4.setText(""+L[3]);
        memberL5.setText(""+L[4]);
        memberR1.setText(""+RR[0]);
        memberR2.setText(""+RR[1]);
        memberR3.setText(""+RR[2]);
        memberR4.setText(""+RR[3]);
        memberR5.setText(""+RR[4]);
        teamchoice="";
        chbe.setText("");
        chaf.setText("");
    }
    public void changeL(View v){
        teamchoice="淺色";
        change();
    }
    public void changeR(View v){
        teamchoice="深色";
        change();
    }
    public void event() {
        TextView showt=findViewById(R.id.showtext);
        TextView event =findViewById(R.id.event);
        TextView member =findViewById(R.id.membernum);
        TextView scoreL = findViewById(R.id.scoreL);
        TextView scoreR = findViewById(R.id.scoreR);
        TextView foulL = findViewById(R.id.foulleft);
        TextView foulR = findViewById(R.id.foulright);
        event.setText(""+markevent);
        if(teamchoice=="" ){
            event.setText("");
            member.setText("");
        }else{
            switch (teamchoice){
                case "淺色":
                    scoreleft= scoreleft+scoreplus;
                    scoreL.setText("" + scoreleft );
                    if(foulleft==5){
                        foulleft=5;
                    }else{
                        foulleft=foulleft+foulplus;
                    }
                    foulL.setText("犯規數\n" + foulleft );
                    break;
                default:
                    scoreright=scoreright+scoreplus;
                    scoreR.setText("" + scoreright);
                    if(foulright==5){
                    foulright=5;
                    }else{
                    foulright++;
                    }
                    foulR.setText("犯規數\n" + foulright );
            }
            insert();
            //showt.append(""+teamchoice+"_"+markmember+"號_"+markevent+"\n");
        }
        markevent="";
        markmember="";
        teamchoice="";
        scoreplus=0;
        foulplus=0;
    }

    public void insert() {

        final TextView text_view = (TextView) findViewById(R.id.showtext);

        new Thread(new Runnable() {
            public void run() {
                // 取得資料
                String stringteam="1";
                final TextView membernum=(TextView) findViewById(R.id.membernum);
                String stringmemnum = membernum.getText().toString();
                final TextView event=(TextView) findViewById(R.id.event);
                String stringevent = event.getText().toString();

                // 將資料寫入資料庫
                MysqlCon con = new MysqlCon();
                con.insertData(stringteam,stringmemnum,stringevent);
                // 讀取更新後的資料
                final String updata = con.getData();
                Log.v("OK", updata);
                text_view.post(new Runnable() {
                    public void run() {
                        text_view.setText(updata);
                    }
                });

            }
        }).start();
    }
    public void scoreplus1(View v){
        markevent="罰球進";
        scoreplus=1;
        event();
    }
    public void scoreplus2(View v){
        markevent="二分進";
        scoreplus=2;
        event();
    }
    public void scoreplus3(View v){
        markevent="三分進";
        scoreplus=3;
        event();
    }
    public void scoren1(View v){
        markevent="罰球未進";
        event();
    }
    public void scoren2(View v){
        markevent="二分未進";
        event();
    }
    public void scoren3(View v){
        markevent="三分未進";
        event();
    }
    public void periodplus(View v){
        TextView perioD = findViewById(R.id.periodview);
        period++;
        perioD.setText("節數\n" + period );
    }
    public void periodminus(View v){
        TextView perioD = findViewById(R.id.periodview);
        period--;
        perioD.setText("節數\n" + period );
    }
    public void Offensivefoul(View v){
        markevent="進攻犯規";
        foulplus=1;
        event();
    }
    public void Defensivefoul(View v){
        markevent="防守犯規";
        foulplus=1;
        event();
    }
    public void Steal(View v){
        markevent="抄截";
        event();
    }
    public void Turnover(View v){
        markevent="失誤";
        event();
    }
    public void Block(View v){
        markevent="阻攻";
        event();
    }
    public void Assist(View v){
        markevent="助攻";
        event();
    }
    public void Offensive_rebound(View v){
        markevent="進攻籃板";
        event();
    }
    public void Defensive_rebound(View v){
        markevent="防守籃板";
        event();
    }
    public void member(){
        TextView event =findViewById(R.id.event);
        TextView member =findViewById(R.id.membernum);
        member.setText("" + markmember + "號");
        event.setText("");
    }
    public void memberL1(View v){
        Button mem=findViewById(R.id.memberL1);
        markmember=mem.getText().toString();
        teamchoice = "淺色";
        member();
    }
    public void memberL2(View v){
        Button mem=findViewById(R.id.memberL2);
        markmember=mem.getText().toString();
        teamchoice = "淺色";
        member();
    }
    public void memberL3(View v){
        Button mem=findViewById(R.id.memberL3);
        markmember=mem.getText().toString();
        teamchoice = "淺色";
        member();
    }
    public void memberL4(View v){
        Button mem=findViewById(R.id.memberL4);
        markmember=mem.getText().toString();
        teamchoice = "淺色";
        member();
    }
    public void memberL5(View v){
        Button mem=findViewById(R.id.memberL5);
        markmember=mem.getText().toString();
        teamchoice = "淺色";
        member();
    }
    public void memberR1(View v){
        Button mem=findViewById(R.id.memberR1);
        markmember=mem.getText().toString();
        teamchoice = "深色";
        member();
    }
    public void memberR2(View v){
        Button mem=findViewById(R.id.memberR2);
        markmember=mem.getText().toString();
        teamchoice = "深色";
        member();
    }
    public void memberR3(View v){
        Button mem=findViewById(R.id.memberR3);
        markmember=mem.getText().toString();
        teamchoice = "深色";
        member();
    }
    public void memberR4(View v){
        Button mem=findViewById(R.id.memberR4);
        markmember=mem.getText().toString();
        teamchoice = "深色";
        member();
    }
    public void memberR5(View v){
        Button mem=findViewById(R.id.memberR5);
        markmember=mem.getText().toString();
        teamchoice = "深色";
        member();
    }



}
