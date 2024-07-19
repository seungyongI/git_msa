package org.example;

import org.example.box.Box;
import org.example.box.PaperBox;
import org.example.box.GoldBox;

public class Ex04 {

    public static void main(String[] args) {
        Box box1 = new Box();
        PaperBox box2 = new PaperBox();
        GoldBox box3 = new GoldBox();

        wrapBox(box1);
        wrapBox(box2);
        wrapBox(box3);
   }

   public static void wrapBox(Box box){
       if(box instanceof GoldBox) {
           ((GoldBox) box).goldbox();
       } else if (box instanceof PaperBox) {
           ((PaperBox) box).paperbox();
       } else {
           box.box();
       }
   }

}
