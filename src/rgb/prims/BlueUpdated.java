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

public class BlueUpdated implements Reporter {
  public Syntax getSyntax(){
    int[] values = {
      Syntax.NumberType() | Syntax.ListType(),
      Syntax.NumberType()
    };
    int ret = Syntax.ListType();
    return SyntaxJ.reporterSyntax(values, ret, 2);
  }

  public Object report(Argument args[], Context context) throws ExtensionException {
    ColorManager cm = new ColorManager();
    LogoList rgb;

    try{ // testing input
      rgb = cm.extractColorFromArg(args[0]);
    }
    catch(ExtensionException e){
      throw new ExtensionException(e.getMessage());
    }

    double newHue = 0;
    try{
      newHue = args[1].getDoubleValue();
    }
    catch(ExtensionException e){
      throw new ExtensionException(e.getMessage());
    }
    if(newHue > 255 || newHue < 0){
      throw new ExtensionException("Value must be in the range from 0 to 255");
    }
    RGBUpdated update = new RGBUpdated();
    return update.updateRGB(rgb, newHue, 2); // now that input is managed, we do most of the work here
  }
}
