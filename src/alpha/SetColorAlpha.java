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

public class SetColorAlpha implements Command{
  public Syntax getSyntax() {
    int values[] = {Syntax.NumberType()};
    return SyntaxJ.commandSyntax(values);
  }

  public void perform(Argument args[], Context context) throws ExtensionException {
    double alpha = 255;

    try{
       alpha = args[0].getDoubleValue();
    }
    catch(ExtensionException e){
      throw new ExtensionException(e.getMessage());
    }
    try{
      sca(alpha, context.getAgent());
    }
    catch(ExtensionException e){
      throw new ExtensionException(e.getMessage());
    }

  }
  public void sca(double alpha, Agent agent) throws ExtensionException {
    if(alpha < 0 || alpha > 255){
      throw new ExtensionException("Alpha must be in the range from 0 to 255");
    }
    if(agent.kind() == AgentKindJ.Turtle()){ // for turtles
      Turtle t = (Turtle) agent;
      int ind = Turtle.VAR_COLOR; // creates a warning
      LogoList rgb;

      if(t.color() instanceof Double){
        double nlColor = (double) t.color();
        nlColor = org.nlogo.api.Color.modulateDouble(nlColor);
        rgb = org.nlogo.api.Color.getRGBListByARGB(org.nlogo.api.Color.getARGBbyPremodulatedColorNumber(nlColor));
      }
      else{ rgb = (LogoList) t.color(); }

      LogoListBuilder rgba = new LogoListBuilder();
      for(int i = 0; i < 3; i++){
        rgba.add(rgb.get(i));
      }
      rgba.add(alpha);
      try{
        t.color(rgba.toLogoList(), ind);
      }
      catch(AgentException e){
        throw new ExtensionException("Internal Error");
      }

    }
    else if(agent.kind() == AgentKindJ.Link()){ // for links
      Link l = (Link) agent;
      int ind = Link.VAR_COLOR;
      LogoList rgb;

      if(l.color() instanceof Double){
        double nlColor = (double) l.color();
        nlColor = org.nlogo.api.Color.modulateDouble(nlColor);
        rgb = org.nlogo.api.Color.getRGBListByARGB(org.nlogo.api.Color.getARGBbyPremodulatedColorNumber(nlColor));
      }
      else{ rgb = (LogoList) l.color(); }

      LogoListBuilder rgba = new LogoListBuilder();
      for(int i = 0; i < 3; i++){
        rgba.add(rgb.get(i));
      }
      rgba.add(alpha);
      try{
        l.setLinkVariable(ind, rgba.toLogoList());
      }
      catch(AgentException e){
        throw new ExtensionException("Internal Error");
      }
    }
    else if(agent.kind() == AgentKindJ.Patch()){ // for patches (works in 2D)
      Patch p = (Patch) agent;
      int ind = Patch.VAR_PCOLOR;
      LogoList rgb;

      if(p.pcolor() instanceof Double){
        double nlColor = (double) p.pcolor();
        nlColor = org.nlogo.api.Color.modulateDouble(nlColor);
        rgb = org.nlogo.api.Color.getRGBListByARGB(org.nlogo.api.Color.getARGBbyPremodulatedColorNumber(nlColor));
      }
      else{ rgb = (LogoList) p.pcolor(); }

      LogoListBuilder rgba = new LogoListBuilder();
      for(int i = 0; i < 3; i++){
        rgba.add(rgb.get(i));
      }
      rgba.add(alpha);
      try{
    //    p.setPatchVariable(ind, rgba.toLogoList());
        p.pcolor(rgba.toLogoList());
      }
      catch(AgentException e){
        throw new ExtensionException("Internal Error");
      }
    }
  }
}
