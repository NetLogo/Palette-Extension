import org.nlogo.agent.Turtle;
import org.nlogo.agent.Link;
import org.nlogo.agent.Patch;
import org.nlogo.core.AgentKind;
import org.nlogo.core.AgentKindJ;
import org.nlogo.api.AgentException;

import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.Command;
import org.nlogo.core.LogoList;
import org.nlogo.api.LogoListBuilder;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.Agent;

public class SetColorTransparency implements Command{
  public Syntax getSyntax() {
    int values[] = {Syntax.NumberType()};
    return SyntaxJ.commandSyntax(values, "-TPL");
  }
  public void perform(Argument args[], Context context) throws ExtensionException {
    ColorManager cm = new ColorManager();
    LogoList the_rgbcolor = cm.getAgentColor(context);
    double alpha = 255;
  //  _extractrgb ergb = new _extractrgb();
    try{
      alpha = args[0].getDoubleValue();
    }
    catch(ExtensionException e){
      throw new ExtensionException(e.getMessage());
    }
    if(alpha < 0 || alpha > 100){
      throw new ExtensionException("Transparency must be in the range from 0 to 100");
    }
    if(context.getAgent().kind() == AgentKindJ.Patch() && !org.nlogo.api.Version$.MODULE$.is3D()){
      throw new ExtensionException("Patches do not have a transparency");
    }
    alpha = 255 * (1 - alpha / 100);
    SetColorAlpha sca = new SetColorAlpha();
    sca.sca(context, alpha);
  }
}
