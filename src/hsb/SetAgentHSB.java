import org.nlogo.api.Argument;
import org.nlogo.api.Color;
import org.nlogo.api.Command;
import org.nlogo.api.Context;
import org.nlogo.api.ExtensionException;
import org.nlogo.core.LogoList;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;

public class SetAgentHSB implements Command {

  private int index;
  private String type[] = {"Hue", "Saturation", "Brightness"};
  private int range[] = {360, 100, 100};

  public SetAgentHSB(int ind) {
    index = ind;
  }

  public Syntax getSyntax() {
    int values[] = {Syntax.NumberType()};
    return SyntaxJ.commandSyntax(values, "-TPL");
  }

  public void perform(Argument args[], Context context) throws ExtensionException {
    double newValue = 0;
    try {
      newValue = args[0].getDoubleValue();
    }
    catch (ExtensionException e) {
      throw new ExtensionException(e.getMessage());
    }
    if (newValue < 0 || newValue > 100) {
      throw new ExtensionException(type[index] + " must be in the range from 0 to " + range[index] + ".");
    }
    LogoList rgb = ColorManager.getAgentColor(context);
    rgb = HSBUpdated.updateHSB(rgb, newValue, index);
    ColorManager.setAgentColor(context, rgb);
  }
}
