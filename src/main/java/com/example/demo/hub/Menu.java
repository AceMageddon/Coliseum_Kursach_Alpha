package com.example.demo.hub;

import com.example.demo.controller.*;
import com.example.demo.data.Data;

import java.util.Random;

public class Menu {
    public static void codegenerator() {
        ControllerPlayer componentPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        Random rn = new Random();
        int code1 = rn.nextInt(9) + 0;
        int code2 = rn.nextInt(9) + 0;
        int code3 = rn.nextInt(9) + 0;
        int code4 = rn.nextInt(9) + 0;
        int code5 = rn.nextInt(9) + 0;
        int d1 = rn.nextInt(2) + 1;
        int d2 = rn.nextInt(2) + 1;
        int d3 = rn.nextInt(2) + 1;
        int d4 = rn.nextInt(2) + 1;
        int d5 = rn.nextInt(2) + 1;
        String rez1 = "";
        String rez2 = "";
        String rez3 = "";
        String rez4 = "";
        String rez5 = "";
        if (d1 == 1) {
            if (code1 == 0) {
                rez1 = "Z";
            }
            if (code1 == 1) {
                rez1 = "Y";
            }
            if (code1 == 2) {
                rez1 = "X";
            }
            if (code1 == 3) {
                rez1 = "W";
            }
            if (code1 == 4) {
                rez1 = "V";
            }
            if (code1 == 5) {
                rez1 = "U";
            }
            if (code1 == 6) {
                rez1 = "T";
            }
            if (code1 == 7) {
                rez1 = "S";
            }
            if (code1 == 8) {
                rez1 = "R";
            }
            if (code1 == 9) {
                rez1 = "Q";
            }
        } else {
            rez1 = String.valueOf(code1);
        }
        if (d2 == 1) {
            if (code2 == 0) {
                rez2 = "K";
            }
            if (code2 == 1) {
                rez2 = "L";
            }
            if (code2 == 2) {
                rez2 = "M";
            }
            if (code2 == 3) {
                rez2 = "N";
            }
            if (code2 == 4) {
                rez2 = "A";
            }
            if (code2 == 5) {
                rez2 = "P";
            }
            if (code2 == 6) {
                rez2 = "Q";
            }
            if (code2 == 7) {
                rez2 = "R";
            }
            if (code2 == 8) {
                rez2 = "S";
            }
            if (code2 == 9) {
                rez2 = "T";
            }
        } else {
            rez2 = String.valueOf(code2);
        }
        if (d3 == 1) {
            if (code3 == 0) {
                rez3 = "Q";
            }
            if (code3 == 1) {
                rez3 = "P";
            }
            if (code3 == 2) {
                rez3 = "B";
            }
            if (code3 == 3) {
                rez3 = "N";
            }
            if (code3 == 4) {
                rez3 = "M";
            }
            if (code3 == 5) {
                rez3 = "L";
            }
            if (code3 == 6) {
                rez3 = "K";
            }
            if (code3 == 7) {
                rez3 = "J";
            }
            if (code3 == 8) {
                rez3 = "I";
            }
            if (code3 == 9) {
                rez3 = "H";
            }
        } else {
            rez3 = String.valueOf(code3);
        }
        if (d4 == 1) {
            if (code4 == 0) {
                rez4 = "A";
            }
            if (code4 == 1) {
                rez4 = "B";
            }
            if (code4 == 2) {
                rez4 = "C";
            }
            if (code4 == 3) {
                rez4 = "D";
            }
            if (code4 == 4) {
                rez4 = "E";
            }
            if (code4 == 5) {
                rez4 = "F";
            }
            if (code4 == 6) {
                rez4 = "G";
            }
            if (code4 == 7) {
                rez4 = "H";
            }
            if (code4 == 8) {
                rez4 = "I";
            }
            if (code4 == 9) {
                rez4 = "J";
            }
        } else {
            rez4 = String.valueOf(code4);
        }
        if (d5 == 1) {
            if (code5 == 0) {
                rez5 = "A";
            }
            if (code5 == 1) {
                rez5 = "B";
            }
            if (code5 == 2) {
                rez5 = "Y";
            }
            if (code5 == 3) {
                rez5 = "Z";
            }
            if (code5 == 4) {
                rez5 = "E";
            }
            if (code5 == 5) {
                rez5 = "F";
            }
            if (code5 == 6) {
                rez5 = "G";
            }
            if (code5 == 7) {
                rez5 = "C";
            }
            if (code5 == 8) {
                rez5 = "Q";
            }
            if (code5 == 9) {
                rez5 = "X";
            }
        } else {
            rez5 = String.valueOf(code5);
        }
        Data.code = rez1 + rez2 + rez3 + rez4 + rez5;
        if (Data.reset != 1) {
            componentPlayer.sendregistrationemail();
        }
        if (Data.reset == 1) {
            componentPlayer.sendpasswordemail();
        }
    }
}
