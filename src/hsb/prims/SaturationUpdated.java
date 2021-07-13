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

public class SaturationUpdated implements Reporter{
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
    HSBUpdated update = new HSBUpdated();
    return update.updateHSB(rgb, newHue, 1); // now that input is managed, we do most of the work here
  }
}
