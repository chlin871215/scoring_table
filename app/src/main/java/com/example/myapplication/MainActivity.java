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
    int assist,block,turnover,steal,offensive_rebound,defensive_rebound;
    int markmember,markevent;
    int p11i,p11o,p12i,p12o,p13i,p13o,p1dr,p1or,p1as,p1st,p1to,p1bl,p1df,p1of;
    int p21i,p21o,p22i,p22o,p23i,p23o,p2dr,p2or,p2as,p2st,p2to,p2bl,p2df,p2of;


    public void scoreplus1(View v){
        TextView scoreL,event,scoreR,member,showt;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        showt =findViewById(R.id.showtext);
        event.setText("罰球進");
        markevent=1;
        if(teamchoice==1 ){
            scoreL = findViewById(R.id.scoreL);
            scoreleft= scoreleft+1;
            scoreL.setText("" + scoreleft );
            showt.append("淺色_"+markmember+"號_罰球進\n");
        }else if(teamchoice==2){
            scoreR = findViewById(R.id.scoreR);
            scoreright= scoreright+1;
            scoreR.setText("" + scoreright );
            showt.append("深色_"+markmember+"號_罰球進\n");
        }else{
            event.setText("");
            member.setText("");
        }
        markevent=0;
        markmember=0;
        teamchoice=0;
    }
    public void scoreplus2(View v){
        TextView scoreL,event,scoreR,member,showt;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        showt =findViewById(R.id.showtext);
        event.setText("2分進");
        markevent=2;
        if(teamchoice==1 ){
            scoreL = findViewById(R.id.scoreL);
            scoreleft= scoreleft+2;
            scoreL.setText("" + scoreleft );
            showt.append("淺色_"+markmember+"號_2分進\n");
        }else if(teamchoice==2){
            scoreR = findViewById(R.id.scoreR);
            scoreright= scoreright+2;
            scoreR.setText("" + scoreright );
            showt.append("深色_"+markmember+"號_2分進\n");
        }else{
            event.setText("");
            member.setText("");
        }
        switch (markmember){
            case 1:
                p12i++;
                break;
            case 2:
                p22i++;
                break;
            case 3:
        }

        markevent=0;
        markmember=0;
        teamchoice=0;
    }
    public void scoreplus3(View v){
        TextView scoreL,event,scoreR,member,showt;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        showt =findViewById(R.id.showtext);
        event.setText("3分進");
        markevent=3;
        if(teamchoice==1 ){
            scoreL = findViewById(R.id.scoreL);
            scoreleft= scoreleft+3;
            scoreL.setText("" + scoreleft );
            showt.append("淺色_"+markmember+"號_3分進\n");
        }else if(teamchoice==2){
            scoreR = findViewById(R.id.scoreR);
            scoreright= scoreright+3;
            scoreR.setText("" + scoreright );
            showt.append("深色_"+markmember+"號_3分進\n");
        }else{
            event.setText("");
            member.setText("");
        }
        markevent=0;
        markmember=0;
        teamchoice=0;
    }
    public void scoren1(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        TextView showt;
        showt=findViewById(R.id.showtext);
        if(teamchoice==1 ){
            event.setText("罰球未進");
            showt.append("淺色_"+markmember+"號_罰球未進\n");
        }else if(teamchoice==2){
            event.setText("罰球未進");
            showt.append("深色_"+markmember+"號_罰球未進\n");
        }else{
            event.setText("");
            member.setText("");
        }
        teamchoice=0;
        markmember=0;
    }
    public void scoren2(View v){
        TextView event,member;
        TextView showt;
        showt=findViewById(R.id.showtext);
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        if(teamchoice==1 ){
            event.setText("2分未進");
            showt.append("淺色_"+markmember+"號_2分未進\n");
        }else if(teamchoice==2){
            event.setText("2分未進");
            showt.append("深色_"+markmember+"號_2分未進\n");
        }else{
            event.setText("");
            member.setText("");
        }
        teamchoice=0;
        markmember=0;
    }
    public void scoren3(View v){
        TextView event,member;
        TextView showt;
        showt=findViewById(R.id.showtext);
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        if(teamchoice==1 ){
            event.setText("3分未進");
            showt.append("淺色_"+markmember+"號_3分未進\n");
        }else if(teamchoice==2){
            event.setText("3分未進");
            showt.append("深色_"+markmember+"號_3分未進\n");
        }else{
            event.setText("");
            member.setText("");
        }
        teamchoice=0;
        markmember=0;
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
        TextView showt;
        showt=findViewById(R.id.showtext);
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        event.setText("進攻犯規");
        if(teamchoice==1 ){
            showt.append("淺色_"+markmember+"號_進攻犯規\n");
            foulL = findViewById(R.id.foulleft);
            if(foulleft==5){
                foulleft=5;
            }else{
                foulleft++;
            }
            foulL.setText("犯規數\n" + foulleft );
        }else if(teamchoice==2){
            showt.append("深色_"+markmember+"號_進攻犯規\n");
            foulR = findViewById(R.id.foulright);
            if(foulright==5){
                foulright=5;
            }else{
                foulright++;
            }
            foulR.setText("犯規數\n" + foulright );
        }else{
            event.setText("");
            member.setText("");
        }
        teamchoice=0;
        markmember=0;
    }
    public void Defensivefoul(View v){
        TextView foulL,event,foulR,member;
        TextView showt;
        showt=findViewById(R.id.showtext);
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        event.setText("防守犯規");
        if(teamchoice==1 ){
            showt.append("淺色_"+markmember+"號_防守犯規\n");
            foulL = findViewById(R.id.foulleft);
            if(foulleft==5){
                foulleft=5;
            }else{
                foulleft++;
            }
            foulL.setText("犯規數\n" + foulleft );
        }else if(teamchoice==2){
            showt.append("深色_"+markmember+"號_防守犯規\n");
            foulR = findViewById(R.id.foulright);
            if(foulright==5){
                foulright=5;
            }else{
                foulright++;
            }
            foulR.setText("犯規數\n" + foulright );
        }else{
            event.setText("");
            member.setText("");
        }
        teamchoice=0;
        markmember=0;
    }
    public void Steal(View v){
        TextView event,member;
        TextView showt;
        showt=findViewById(R.id.showtext);
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        if(teamchoice==1 ){
            event.setText("抄截");
            showt.append("淺色_"+markmember+"號_抄截\n");
        }else if(teamchoice==2){
            event.setText("抄截");
            showt.append("深色_"+markmember+"號_抄截\n");
        }else{
            event.setText("");
            member.setText("");
        }
        teamchoice=0;
        markmember=0;
    }
    public void Turnover(View v){
        TextView event,member;
        TextView showt;
        showt=findViewById(R.id.showtext);
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        if(teamchoice==1 ){
            event.setText("失誤");
            showt.append("淺色_"+markmember+"號_失誤\n");
        }else if(teamchoice==2){
            event.setText("失誤");
            showt.append("深色_"+markmember+"號_失誤\n");
        }else{
            event.setText("");
            member.setText("");
        }
        teamchoice=0;
        markmember=0;
    }
    public void Block(View v){
        TextView event,member;
        TextView showt;
        showt=findViewById(R.id.showtext);
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        if(teamchoice==1 ){
            event.setText("阻攻");
            showt.append("淺色_"+markmember+"號_阻攻\n");
        }else if(teamchoice==2){
            event.setText("阻攻");
            showt.append("深色_"+markmember+"號_阻攻\n");
        }else{
            event.setText("");
            member.setText("");
        }
        teamchoice=0;
        markmember=0;
    }
    public void Assist(View v){
        TextView event,member;
        TextView showt;
        showt=findViewById(R.id.showtext);
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        if(teamchoice==1 ){
            event.setText("助攻");
            showt.append("淺色_"+markmember+"號_助攻\n");
        }else if(teamchoice==2){
            event.setText("助攻");
            showt.append("深色_"+markmember+"號_助攻\n");
        }else{
            event.setText("");
            member.setText("");
        }
        teamchoice=0;
        markmember=0;
    }
    public void Offensive_rebound(View v){
        TextView event,member;
        TextView showt;
        showt=findViewById(R.id.showtext);
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        if(teamchoice==1 ){
            event.setText("進攻籃板");
            showt.append("淺色_"+markmember+"號_進攻籃板\n");
        }else if(teamchoice==2){
            event.setText("進攻籃板");
            showt.append("深色_"+markmember+"號_進攻籃板\n");
        }else{
            event.setText("");
            member.setText("");
        }
        teamchoice=0;
        markmember=0;
    }
    public void Defensive_rebound(View v){
        TextView event,member;
        TextView showt;
        showt=findViewById(R.id.showtext);
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        if(teamchoice==1 ){
            event.setText("防守籃板");
            showt.append("淺色_"+markmember+"號_防守籃板\n");
        }else if(teamchoice==2){
            event.setText("防守籃板");
            showt.append("深色_"+markmember+"號_防守籃板\n");
        }else{
            event.setText("");
            member.setText("");
        }
        teamchoice=0;
        markmember=0;
    }
    public void member1(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 1;
        member.setText("1號");
        event.setText("");
        markmember=1;
    }
    public void member2(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 1;
        member.setText("2號");
        event.setText("");
        markmember=2;
    }
    public void member3(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 1;
        member.setText("3號");
        event.setText("");
        markmember=3;
    }
    public void member4(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 1;
        member.setText("4號");
        event.setText("");
        markmember=4;
    }
    public void member5(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 1;
        member.setText("5號");
        event.setText("");
        markmember=5;
    }
    public void member7(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 2;
        member.setText("7號");
        event.setText("");
        markmember=7;
    }
    public void member8(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 2;
        member.setText("8號");
        event.setText("");
        markmember=8;
    }
    public void member9(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 2;
        member.setText("9號");
        event.setText("");
        markmember=9;
    }
    public void member11(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 2;
        member.setText("11號");
        event.setText("");
        markmember=11;
    }
    public void member12(View v){
        TextView event,member;
        event =findViewById(R.id.event);
        member =findViewById(R.id.membernum);
        teamchoice = 2;
        member.setText("12號");
        event.setText("");
        markmember=12;
    }



}
