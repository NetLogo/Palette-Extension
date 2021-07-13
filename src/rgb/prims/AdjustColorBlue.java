import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.Command;
import org.nlogo.api.ExtensionException;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;
import org.nlogo.core.LogoList;

public class AdjustColorBlue implements Command{
  public Syntax getSyntax(){
    int values[] = { Syntax.NumberType() };
    return SyntaxJ.commandSyntax(values, "-TPL");
  }

  public void perform(Argument args[], Context context) throws ExtensionException {
    ColorManager cm = new ColorManager();
    LogoList rgb = cm.getAgentColor(context);

    double newVal = 0;
    try{
      newVal = args[0].getDoubleValue();
    }
    catch(ExtensionException e){
      throw new ExtensionException(e.getMessage());
    }
    newVal = Math.min(255, Math.max(0, (double) rgb.get(2) + newVal));
    RGBUpdated update = new RGBUpdated();
    cm.setAgentColor(context, update.updateRGB(cm.getAgentColor(context), newVal, 2));
  }
}
