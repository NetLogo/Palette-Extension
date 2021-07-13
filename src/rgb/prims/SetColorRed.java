import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.Command;
import org.nlogo.api.Color;
import org.nlogo.core.LogoList;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;
import org.nlogo.api.ExtensionException;

public class SetColorRed implements Command {
  public Syntax getSyntax(){
    int values[] = { Syntax.NumberType() };
    return SyntaxJ.commandSyntax(values, "-TPL");
  }

  public void perform(Argument args[], Context context) throws ExtensionException {
    ColorManager cm = new ColorManager();
    RGBUpdated update = new RGBUpdated();

    double newVal = 255;
    try{
      newVal = args[0].getDoubleValue();
    }
    catch(ExtensionException e){
      throw new ExtensionException(e.getMessage());
    }
    if(newVal < 0 || newVal > 255){
      throw new ExtensionException("Value must be in the range from 0 to 255");
    }
    cm.setAgentColor(context, update.updateRGB(cm.getAgentColor(context), newVal, 0));
  }
}
