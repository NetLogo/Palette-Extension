import org.nlogo.api.Color;
import org.nlogo.api.LogoListBuilder;
import org.nlogo.core.LogoList;

public class HSBUpdated{
  public LogoList UpdateHSB(LogoList rgb, double newVal, int ind){
    double alpha = 255; //keep alpha and convert to HSB
    if(rgb.length() > 3){
      alpha = (double) rgb.get(3);
    }
    LogoList hsb = Color.getHSBListByARGB(Color.getARGBIntByRGBAList(rgb));
    LogoListBuilder newHSB = new LogoListBuilder();
    for(int i = 0; i < 3; i++){
      if(i == ind){ newHSB.add(newVal); }
      else { newHSB.add(hsb.get(i)); }
    }
    hsb = newHSB.toLogoList();
    Double h = new Double((double) hsb.get(0)); Double s = new Double((double) hsb.get(1)); Double b = new Double((double) hsb.get(2)); //prep for float conversion
    int newRGBint = java.awt.Color.HSBtoRGB(h.floatValue() / 360.0f, s.floatValue() / 100.0f, b.floatValue() / 100.0f); //get new rgb

    //convert rgbint to new RGBA list
    LogoListBuilder finalRGBA = new LogoListBuilder();
    int shift = 16;
    for(int i  = 0; i < 3; i++){
      finalRGBA.add((double) ((newRGBint >> shift) & 0xff));
      shift -= 8;
    }
    finalRGBA.add(alpha);
    return finalRGBA.toLogoList();
  }
}
