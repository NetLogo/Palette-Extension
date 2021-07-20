import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.Command;
import org.nlogo.api.Color;
import org.nlogo.core.LogoList;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;
import org.nlogo.api.ExtensionException;

public class SetAgentHue implements Command {
  public Syntax getSyntax() {
    int values[] = {Syntax.NumberType()};
    return SyntaxJ.commandSyntax(values, "-TPL");
  }

  public void perform(Argument args[], Context context) throws ExtensionException {
    ColorManager colorManager = new ColorManager();
    HSBUpdated hsbupdated = new HSBUpdated();

    double newValue = 0;
    try {
      newValue = args[0].getDoubleValue();
    }
    catch(ExtensionException e) {
      throw new ExtensionException(e.getMessage());
    }
    if(newValue < 0 || newValue > 360) {
      throw new ExtensionException("Hue must be in the range from 0 to 360.");
    }
    LogoList rgb = colorManager.getAgentColor(context);
    rgb = hsbupdated.updateHSB(rgb, newValue, 0);
    colorManager.setAgentColor(context, rgb);
  }
}
