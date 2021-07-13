import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.Command;
import org.nlogo.api.ExtensionException;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;


public class AdjustColorSaturation implements Command{
  public Syntax getSyntax(){
    int values[] = { Syntax.NumberType() };
    return SyntaxJ.commandSyntax(values, "-TPL");
  }

  public void perform(Argument args[], Context context) throws ExtensionException {
    double newSaturation = 0;
    try{
      newSaturation = args[0].getDoubleValue();
    }
    catch(ExtensionException e){
      throw new ExtensionException(e.getMessage());
    }
    AdjustColorHSB adjuster = new AdjustColorHSB();
    adjuster.adjust(context, newSaturation, 1);
  }
}
