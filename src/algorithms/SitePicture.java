package algorithms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Scanner;

public class SitePicture {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("US"));
        Scanner in = new Scanner(System.in);
        double pictureHeightD = in.nextInt();
        double pictureWidthD = in.nextInt();
        double frameHeightD = in.nextInt();
        double frameWidthD = in.nextInt();

        BigDecimal pictureHeight = new BigDecimal(pictureHeightD);
        BigDecimal pictureWidth = new BigDecimal(pictureWidthD);
        BigDecimal frameHeight = new BigDecimal(frameHeightD);
        BigDecimal frameWidth = new BigDecimal(frameWidthD);

//        BigDecimal pictureHeight = new BigDecimal(in.nextInt());
//        BigDecimal pictureWidth = new BigDecimal(in.nextInt());
//        BigDecimal frameHeight = new BigDecimal(in.nextInt());
//        BigDecimal frameWidth = new BigDecimal(in.nextInt());

        BigDecimal heightRatio = frameHeight.divide(pictureHeight, 1000, RoundingMode.HALF_UP);
        BigDecimal widthRatio = frameWidth.divide(pictureWidth, 1000, RoundingMode.HALF_UP);

        BigDecimal minRatio = heightRatio.min(widthRatio);
        BigDecimal newHeight = pictureHeight.multiply(minRatio).setScale(3, RoundingMode.HALF_UP);
        BigDecimal newWidth = pictureWidth.multiply(minRatio).setScale(3, RoundingMode.HALF_UP);

        System.out.print(newHeight.abs() + " " + newWidth.abs());


//        double pictureHeight = in.nextInt();
//        double pictureWidth = in.nextInt();
//        double frameHeight = in.nextInt();
//        double frameWidth = in.nextInt();
//

//
        double heightRatioD = frameHeightD / pictureHeightD;
        double widthRatioD = frameWidthD / pictureWidthD;
        double maxRatioD = Math.min(heightRatioD, widthRatioD);
        double newHeightD = pictureHeightD * maxRatioD;
        double newWidthD = pictureWidthD * maxRatioD;
        System.out.println();
        System.out.printf("%.4f %.4f", newHeightD, newWidthD);





        //        double pictureHeight = in.nextInt();
//        double pictureWidth = in.nextInt();
//        double frameHeight = in.nextInt();
//        double frameWidth = in.nextInt();
//        double heightRatioInc = pictureHeight / frameHeight;
//        double widthRatioInc = pictureWidth / frameWidth;
//        double maxRatioInc = Math.max(heightRatioInc, widthRatioInc);
//        double newHeightInc = pictureHeight / maxRatioInc;
//        double newWidthInc = pictureWidth / maxRatioInc;
//        System.out.printf("%.3f %.3f", newHeightInc, newWidthInc);



    }
}
