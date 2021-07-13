import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.Command;
import org.nlogo.api.Color;
import org.nlogo.core.LogoList;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;
import org.nlogo.api.ExtensionException;

public class SetColorSaturation implements Command{
  public Syntax getSyntax(){
    int values[] = {Syntax.NumberType()};
    return SyntaxJ.commandSyntax(values, "-TPL");
  }

  public void perform(Argument args[], Context context) throws ExtensionException {
    ColorManager cm = new ColorManager();
    HSBUpdated update = new HSBUpdated();

    LogoList rgb;
    double newValue = 0;
    try{
      newValue = args[0].getDoubleValue();
    }
    catch(ExtensionException e){
      throw new ExtensionException(e.getMessage());
    }
    if(newValue < 0 || newValue > 100){
      throw new ExtensionException("Saturation must be in the range from 0 to 100");
    }
    rgb = cm.getAgentColor(context);
    rgb = update.updateHSB(rgb, newValue, 1);
    cm.setAgentColor(context, rgb);
  }
}
