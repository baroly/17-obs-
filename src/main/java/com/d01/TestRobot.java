package com.d01;

import java.awt.*;
import java.io.IOException;

public class TestRobot {
    public static void main(String[] args) {
        System.out.println("正在等待關閉錄影...");

        try {
            //調用robot類別
            Robot robot = new Robot();
            //這邊我把RGB弄成字串做比對，也可以用別的方式
            String colerString = "";
            //判斷是否要留在判斷並等待的迴圈
            boolean endWait = true;
            Point point = MouseInfo.getPointerInfo().getLocation();
            while (endWait) {
                point = MouseInfo.getPointerInfo().getLocation();
                //30秒掃描一次
                Thread.sleep(1000L);
                //取得該pixel的RGB顏色
                Color color = robot.getPixelColor(2000, 250);

                //把RGB顏色串成字串
                colerString = color.getRed() + "," + color.getGreen() + "," + color.getBlue();
                System.out.println(colerString);
                //判斷目標pixel的RGB是否為黑
                if (!colerString.equals("0,0,0")) {
                    //離開迴圈
                    endWait = false;
                }
            }
            if(!endWait){
                return;
            }
            //keyPress裡面可以填keycode或是emun
            robot.keyPress(18);
            robot.keyPress(109);
            robot.keyPress(16);

            robot.delay(1000);

            //keyRelease來釋放案件，不釋放的話會如同一直按著
            robot.keyRelease(18);
            robot.keyRelease(109);
            robot.keyRelease(16);
            System.out.println("end");

            //robot.delay(20000);

            //調用cmd關機
            //Process process = Runtime.getRuntime().exec("shutdown -s -t 0");
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
