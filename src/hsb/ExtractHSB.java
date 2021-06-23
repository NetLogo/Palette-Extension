import org.nlogo.api.Color;
import org.nlogo.core.LogoList;

public class ExtractHSB {
  public double extract(LogoList rgb, int ind){
    if(rgb.length() > 3) {rgb.butLast();}
    return (double) Color.getHSBListByRGBList(rgb).get(ind);
  }
}
