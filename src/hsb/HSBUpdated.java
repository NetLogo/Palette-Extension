import org.nlogo.api.Color;
import org.nlogo.api.LogoListBuilder;
import org.nlogo.core.LogoList;

public class HSBUpdated {
  public LogoList updateHSB(LogoList rgb, double newVal, int ind) {
    double alpha = 255; //keep alpha and convert to HSB
    if (rgb.length() > 3) {
      alpha = (double) rgb.get(3);
    }

    if (ind == 0) { newVal = modDouble(newVal, 360); }
    else if (ind == 1) { newVal = Math.min(100, Math.max(newVal, 0)); }
    else { newVal = Math.min(100, Math.max(newVal, 0)); }

    LogoList hsb = Color.getHSBListByRGBList(rgb);
    LogoListBuilder newHSB = new LogoListBuilder();
    for (int i = 0; i < 3; i++) {
      if (i == ind) { newHSB.add(newVal); }
      else { newHSB.add(hsb.get(i)); }
    }
    hsb = newHSB.toLogoList();
    LogoList newRGB = HSBtoRGB(hsb);
    LogoListBuilder finalRGBA = new LogoListBuilder();
    for (int i = 0; i < 3; i++) { finalRGBA.add(newRGB.get(i)); }
    if (alpha != 255) { finalRGBA.add(alpha); }
    return finalRGBA.toLogoList();
  }
  
  public LogoList HSBtoRGB(LogoList hsb) {
    Double h = new Double((double) hsb.get(0)); Double s = new Double((double) hsb.get(1)); Double b = new Double((double) hsb.get(2)); //prep for float conversion
    int newRGBint = java.awt.Color.HSBtoRGB(h.floatValue() / 360.0f, s.floatValue() / 100.0f, b.floatValue() / 100.0f); //get new rgb

    //convert rgbint to new RGBA list
    LogoListBuilder rgb = new LogoListBuilder();
    int shift = 16;
    for (int i  = 0; i < 3; i++) {
    rgb.add((double) ((newRGBint >> shift) & 0xff));
      shift -= 8;
    }
    return rgb.toLogoList();
  }

  public double modDouble(double a, double b) {
    while (a < 0) { a += b; }
    while (a >= b) { a -= b; }
    return a;
  }
}
