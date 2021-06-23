import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.Reporter;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.AgentException;
import org.nlogo.api.Color;
import org.nlogo.api.LogoListBuilder;
import org.nlogo.core.LogoList;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;

//NOTE: This code is mostly copied and pasted from HueUpdated
//some variable names may refer to hue instead of brightness

public class BrightnessUpdated implements Reporter{
  public Syntax getSyntax(){
    int[] values = {
      Syntax.NumberType() | Syntax.ListType(),
      Syntax.NumberType()
    };
    int ret = Syntax.ListType();
    return SyntaxJ.reporterSyntax(values, ret, 2);
  }
  public Object report(Argument args[], Context context) throws ExtensionException {
    LogoList rgb;
    double color = 0;

    try{ // testing input
      color = args[0].getDoubleValue();
      rgb = Color.getRGBAListByARGB(Color.getARGBbyPremodulatedColorNumber(Color.modulateDouble(color)));
    }
    catch(ExtensionException e){
      org.nlogo.api.Exceptions.ignore(e);
      try{
        rgb = args[0].getList();
        try{
          Color.validRGBList(rgb, true);
        }
        catch(AgentException a){
          throw new ExtensionException("Color must have valid RGB List");
        }
      }
      catch(ExtensionException e2){
        throw new ExtensionException(e2);
      }
    }
    double newHue = 0;
    try{
      newHue = args[1].getDoubleValue();
    }
    catch(ExtensionException e){
      throw new ExtensionException(e.getMessage());
    }
    if(newHue > 100 || newHue < 0){
      throw new ExtensionException("Brightness must be in the range from 0 to 100");
    }
    HSBUpdated update = new HSBUpdated();
    return update.UpdateHSB(rgb, newHue, 2); // now that input is managed, we do most of the work here
  }
}
