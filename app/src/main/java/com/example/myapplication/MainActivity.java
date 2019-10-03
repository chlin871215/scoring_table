package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    int scoreleft,scoreright,foulleft,foulright,period=1,teamchoice;


    public void scoreplus1(View v){
        TextView scoreL,event,scoreR,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        event.setText("罰球進");
        if(teamchoice==1 ){
            scoreL = findViewById(R.id.scoreL);
            scoreleft= scoreleft+1;
            scoreL.setText("" + scoreleft );
        }else if(teamchoice==2){
            scoreR = findViewById(R.id.scoreR);
            scoreright= scoreright+1;
            scoreR.setText("" + scoreright );
        }else{
            event.setText("");
            member.setText("");
        }
        teamchoice=0;
    }
    public void scoreplus2(View v){
        TextView scoreL,event,scoreR,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        event.setText("2分進");
        if(teamchoice==1 ){
            scoreL = findViewById(R.id.scoreL);
            scoreleft= scoreleft+2;
            scoreL.setText("" + scoreleft );
        }else if(teamchoice==2){
            scoreR = findViewById(R.id.scoreR);
            scoreright= scoreright+2;
            scoreR.setText("" + scoreright );
        }else{
            event.setText("");
            member.setText("");
        }
        teamchoice=0;
    }
    public void scoreplus3(View v){
        TextView scoreL,event,scoreR,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        event.setText("3分進");
        if(teamchoice==1 ){
            scoreL = findViewById(R.id.scoreL);
            scoreleft= scoreleft+3;
            scoreL.setText("" + scoreleft );
        }else if(teamchoice==2){
            scoreR = findViewById(R.id.scoreR);
            scoreright= scoreright+3;
            scoreR.setText("" + scoreright );
        }else{
            event.setText("");
            member.setText("");
        }
        teamchoice=0;
    }
    public void periodplus(View v){
        TextView perioD;
        perioD = findViewById(R.id.periodview);
        period++;
        perioD.setText("節數\n" + period );
    }
    public void periodminus(View v){
        TextView perioD;
        perioD = findViewById(R.id.periodview);
        period--;
        perioD.setText("節數\n" + period );
    }
    public void Offensivefoul(View v){
        TextView foulL,event,foulR,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        event.setText("進攻犯規");
        if(teamchoice==1 ){
            foulL = findViewById(R.id.foulleft);
            if(foulleft==5){
                foulleft=5;
            }else{
                foulleft++;
            }
            foulL.setText("" + foulleft );
        }else if(teamchoice==2){
            foulR = findViewById(R.id.foulright);
            if(foulright==5){
                foulright=5;
            }else{
                foulright++;
            }
            foulR.setText("" + foulright );
        }else{
            event.setText("");
            member.setText("");
        }
        teamchoice=0;
    }
    public void Defensivefoul(View v){
        TextView foulL,event,foulR,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        event.setText("防守犯規");
        if(teamchoice==1 ){
            foulL = findViewById(R.id.foulleft);
            if(foulleft==5){
                foulleft=5;
            }else{
                foulleft++;
            }
            foulL.setText("" + foulleft );
        }else if(teamchoice==2){
            foulR = findViewById(R.id.foulright);
            if(foulright==5){
                foulright=5;
            }else{
                foulright++;
            }
            foulR.setText("" + foulright );
        }else{
            event.setText("");
            member.setText("");
        }
        teamchoice=0;
    }
    public void member1(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 1;
        member.setText("1號");
        event.setText("");
    }
    public void member2(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 1;
        member.setText("2號");
        event.setText("");
    }
    public void member3(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 1;
        member.setText("3號");
        event.setText("");
    }
    public void member4(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 1;
        member.setText("4號");
        event.setText("");
    }
    public void member5(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 1;
        member.setText("5號");
        event.setText("");
    }
    public void member7(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 2;
        member.setText("7號");
        event.setText("");
    }
    public void member8(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 2;
        member.setText("8號");
        event.setText("");
    }
    public void member9(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 2;
        member.setText("9號");
        event.setText("");
    }
    public void member11(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 2;
        member.setText("11號");
        event.setText("");
    }
    public void member12(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 2;
        member.setText("12號");
        event.setText("");
    }



}
