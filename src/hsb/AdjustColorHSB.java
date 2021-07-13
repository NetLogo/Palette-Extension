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
    ColorManager cm = new ColorManager();
    LogoList rgb = cm.getAgentColor(context);
    rgb = getNewColor(rgb, modifier, ind);
    cm.setAgentColor(context, rgb);
  }

  public LogoList getNewColor(LogoList rgb, double modifier, int ind){ //get new color to set
    ExtractHSB extract = new ExtractHSB();
    double val = extract.extract(rgb, ind) + modifier;
    if(ind == 0) { val = modDouble(val, 360); }
    else if(ind == 1){ val = Math.min(100, Math.max(val, 0)); }
    else { val = Math.min(100, Math.max(val, 5)); }

    HSBUpdated update = new HSBUpdated();
    rgb = update.updateHSB(rgb, val, ind);
    return rgb;
  }

  public double modDouble(double a, double b){
    while(a < 0){ a += b; }
    while(a >= b){ a -= b; }
    return a;
  }
}
