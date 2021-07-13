import java.util.ArrayList;
import java.lang.Math;
import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.Command;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;
import org.nlogo.core.LogoList;
import org.nlogo.api.LogoListBuilder;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;
import org.nlogo.core.AgentKindJ;
import org.nlogo.api.Version;

public class AdjustColorAlpha implements Command {
  public Syntax getSyntax() {
    int values[] = {Syntax.NumberType()};
    return SyntaxJ.commandSyntax(values, "-TPL");
  }

  public void perform(Argument args[], Context context) throws ExtensionException {
    double d_alpha, alpha, newAlpha = 0;
    try{
      d_alpha = args[0].getDoubleValue();
    }
    catch(ExtensionException e){
      throw new ExtensionException(e.getMessage());
    }
    GetColorAlpha gca = new GetColorAlpha();
    alpha = (double) gca.report(args, context);
    SetColorAlpha sca = new SetColorAlpha();
    newAlpha = alpha + d_alpha;
    newAlpha = Math.min(Math.max((double) 0, newAlpha), (double) 255);
    if(context.getAgent().kind() == AgentKindJ.Patch() && !org.nlogo.api.Version$.MODULE$.is3D()){
      throw new ExtensionException("Patches cannot have an alpha");
    }
    sca.sca(context, newAlpha);

  }
}
