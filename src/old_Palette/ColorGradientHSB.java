import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import org.nlogo.core.LogoList;

public class ColorGradientHSB {

	double[][] GradientHSBArray;

	// create a rectangle of 1 by 256 pixels with all the gradients.
	public void genArray(double[] startColor, double[] endColor, int width)
	{
		double[] inc = new double[3]; width--;
		if(endColor[0] > startColor[0]){
			if(startColor[0] + 360 - endColor[0] < endColor[0] - startColor[0]){
				inc[0] = (endColor[0] - (startColor[0] + 360.0)) / width;
			}
			else {inc[0] = (endColor[0] - startColor[0]) / width; }
		}
		else{
			if(endColor[0] + 360.0 - startColor[0] < startColor[0] - endColor[0]){
				inc[0] = (endColor[0] + 360.0 - startColor[0]) / width;
			}
			else {inc[0] = (endColor[0] - startColor[0]) / width; }
		}
		inc[1] = (endColor[1] - startColor[1]) / width;
		inc[2] = (endColor[2] - startColor[2]) / width;
		width++;

		GradientHSBArray = new double[width][3];
		GradientHSBArray[0] = startColor;
		for(int i = 1; i < width; i++){
			for(int j = 0; j < 3; j++){
				GradientHSBArray[i][j] = GradientHSBArray[i-1][j] + inc[j];
				if(j > 0){
					GradientHSBArray[i][j] = Math.min(100, Math.max(0, GradientHSBArray[i][j]));
				}
				else{
					if(GradientHSBArray[i][j] >= 360) {GradientHSBArray[i][j] -= 360; }
					if(GradientHSBArray[i][j] < 0) {GradientHSBArray[i][j] += 360; }
				}
			}
		}
	}

	public double[][] getHSBArray(){
		return GradientHSBArray;
	}

	// returns an array with 3 arrays with the separate rgb channels.
	/*public int [] getPixelRGBArray(int x , int y)
	{
		int rgb = getRGB(x,y);
		Color c = new Color(rgb);
		int[] pixelRGBArray = {c.getRed(), c.getGreen(), c.getBlue()};
		return pixelRGBArray;
	}

	// returns an array with arrays of rgb colors in the gradient
	public int [][] getGradientRGBArray()
	{
		// Get all the pixels
		final int w = getWidth();
		final int h = getHeight();
		final int[] gradientRGB = new int[w*h];
		getRGB(0, 0, w, h, gradientRGB, 0, w);

		GradientRGBArray = new int[gradientRGB.length][3];
		Color c;
		for (int i=0; i < gradientRGB.length; i++)
		{
			c = new Color(gradientRGB[i]);
			GradientRGBArray[i][0] = c.getRed();
			GradientRGBArray[i][1] = c.getGreen();
			GradientRGBArray[i][2] = c.getBlue();
		}
		return GradientRGBArray;
	};*/
}
