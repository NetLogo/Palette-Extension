import org.nlogo.agent.Turtle;
import org.nlogo.agent.Link;
import org.nlogo.agent.Patch;
import org.nlogo.agent.Agent;
import org.nlogo.core.AgentKind;
import org.nlogo.core.AgentKindJ;
import org.nlogo.api.AgentException;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.Context;
import org.nlogo.api.Argument;

import org.nlogo.api.Color;
import org.nlogo.core.LogoList;

public class ColorManager {
  public LogoList getAgentColor(Context context){
    LogoList rgb = Color.getRGBListByARGB(1); // initialized with random value to avoid compiler error
    if(context.getAgent().kind() ==  AgentKindJ.Link()){ //Link
      Link link = (Link) context.getAgent();
      if(link.color() instanceof Double){
        rgb = Color.getRGBListByARGB(Color.getARGBbyPremodulatedColorNumber(Color.modulateDouble((double) link.color())));
      }
      else{
        rgb = (LogoList) link.color();
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
    }
    else if(context.getAgent().kind() == AgentKindJ.Turtle()){ //Turtle
      Turtle turtle = (Turtle) context.getAgent();
      if(turtle.color() instanceof Double){
        rgb = Color.getRGBListByARGB(Color.getARGBbyPremodulatedColorNumber(Color.modulateDouble((double) turtle.color())));
      }
      else{
        rgb = (LogoList) turtle.color();
      }
    }
    return rgb;
  }
  public void setAgentColor(Context context, LogoList rgb) throws ExtensionException {
    if(context.getAgent().kind() ==  AgentKindJ.Link()){ //Link
      Link link = (Link) context.getAgent();
      try{ link.color(rgb); }
      catch(AgentException a){
        throw new ExtensionException("Internal error when setting color of Links in ColorManager.java");
      }
    }
    else if(context.getAgent().kind() == AgentKindJ.Patch()){ //Patch
      Patch patch = (Patch) context.getAgent();
      try{ patch.pcolor(rgb); }
      catch(AgentException a){
        throw new ExtensionException("Internal error when setting color of Patch in ColorManager.java");
      }
    }
    else if(context.getAgent().kind() == AgentKindJ.Turtle()){ //Turtle
      Turtle turtle = (Turtle) context.getAgent();
      try{ turtle.color(rgb, Turtle.VAR_COLOR); }
      catch(AgentException a){
        throw new ExtensionException("Internal error when setting color of Turtles in ColorManager.java");
      }
    }
  }

  public LogoList extractColorFromArg(Argument arg) throws ExtensionException {
    LogoList rgb = Color.getRGBListByARGB(1); // initialized with random value to avoid compiler error
    try{
      double color = arg.getDoubleValue();
      rgb = Color.getRGBListByARGB(Color.getARGBbyPremodulatedColorNumber(Color.modulateDouble(color)));
    }
    catch(ExtensionException e){
      org.nlogo.api.Exceptions.ignore(e);
      try{
        rgb = arg.getList();
        try{
          Color.validRGBList(rgb, true);
        }
        catch(AgentException a){
          throw new ExtensionException("Colors must have valid RGB List.");
        }
      }
      catch(ExtensionException e2){
        throw new ExtensionException(e2);
      }
    }
    return rgb;
  }
}
