import org.nlogo.agent.Turtle;
import org.nlogo.agent.Link;
import org.nlogo.agent.Patch;
import org.nlogo.agent.Agent;
import org.nlogo.core.AgentKind;
import org.nlogo.core.AgentKindJ;
import org.nlogo.api.AgentException;
import org.nlogo.api.ExtensionException;

import org.nlogo.api.Context;
import org.nlogo.api.Color;
import org.nlogo.core.LogoList;

public class AdjustColorHSB {
  public void adjust(Context context, double modifier, int ind) throws ExtensionException {
    LogoList rgb;
    //Get original color of agent
    if(context.getAgent().kind() ==  AgentKindJ.Link()){ //Link
      Link link = (Link) context.getAgent();
      if(link.color() instanceof Double){
        rgb = Color.getRGBListByARGB(Color.getARGBbyPremodulatedColorNumber(Color.modulateDouble((double) link.color())));
      }
      else{
        rgb = (LogoList) link.color();
      }
      rgb = getNewColor(rgb, modifier, ind);

      try{ link.color(rgb); }
      catch(AgentException a){
        throw new ExtensionException("Internal error when setting color of Links in AdjustColorHSB.java");
      }
    }
    else if(context.getAgent().kind() == AgentKindJ.Patch()){ //Patch
      Patch patch = (Patch) context.getAgent();
      if(patch.pcolor() instanceof Double){
        rgb = Color.getRGBListByARGB(Color.getARGBbyPremodulatedColorNumber(Color.modulateDouble((double) patch.pcolor())));
      }
      else{
        rgb = (LogoList) patch.pcolor();
      }
      rgb = getNewColor(rgb, modifier, ind);

      try{ patch.pcolor(rgb); }
      catch(AgentException a){
        throw new ExtensionException("Internal error when setting color of Patch in AdjustColorHSB.java");
      }
    }
    else if(context.getAgent().kind() == AgentKindJ.Turtle()){ //Turtle
      Turtle turtle = (Turtle) context.getAgent();
      if(turtle.color() instanceof Double){
        rgb = Color.getRGBListByARGB(Color.getARGBbyPremodulatedColorNumber(Color.modulateDouble((double) turtle.color())));
      }
      else{
        rgb = (LogoList) turtle.color();
      }
      rgb = getNewColor(rgb, modifier, ind);

      try{ turtle.color(rgb, Turtle.VAR_COLOR); }
      catch(AgentException a){
        throw new ExtensionException("Internal error when setting color of Turtles in AdjustColorHSB.java");
      }
    }
  }

  public LogoList getNewColor(LogoList rgb, double modifier, int ind){ //get new color to set
    ExtractHSB extract = new ExtractHSB();
    double val = extract.extract(rgb, ind) + modifier;
    if(ind == 0) { val = modDouble(val, 360); }
    else { val = modDouble(val,100); }

    HSBUpdated update = new HSBUpdated();
    rgb = update.UpdateHSB(rgb, val, ind);
    return rgb;
  }

  public double modDouble(double a, double b){
    while(a < 0){ a += b; }
    while(a >= b){ a -= b; }
    return a;
  }
}
