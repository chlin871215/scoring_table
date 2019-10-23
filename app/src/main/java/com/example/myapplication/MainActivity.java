package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    }
    int scoreleft,scoreright,foulleft,foulright,scoreplus,foulplus,period=1;
    String markmember,markevent,teamchoice,chmembe,chmemaf;

    public void change(View v){
        EditText chbe = findViewById(R.id.changememberbefore);
        EditText chaf = findViewById(R.id.changememberafter);
        chmembe = chbe.getText().toString();
        chmemaf = chaf.getText().toString();

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
            showt.append(""+teamchoice+"_"+markmember+"號_"+markevent+"\n");
        }
        markevent="";
        markmember="";
        teamchoice="";
        scoreplus=0;
        foulplus=0;
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
