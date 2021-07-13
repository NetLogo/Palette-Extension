import java.util.ArrayList;
import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.Reporter;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;
import org.nlogo.core.LogoList;
import org.nlogo.api.LogoListBuilder;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;
//import org.nlogo.api.Color;


public class TransparencyUpdated implements Reporter{
  public Syntax getSyntax(){
    int[] values = {
      Syntax.NumberType() | Syntax.ListType(),
      Syntax.NumberType()
    };
    int ret = Syntax.ListType();

    return SyntaxJ.reporterSyntax(values, ret, "-TPL");
  }
  public Object report(Argument args[] , Context context)
    throws ExtensionException{

    ColorManager cm = new ColorManager();
    LogoList the_rgbcolor = cm.extractColorFromArg(args[0]);
    double alpha = 255;
  //  _extractrgb ergb = new _extractrgb();
    try{
      alpha = args[1].getDoubleValue();
    }
    catch(ExtensionException e){
      throw new ExtensionException(e.getMessage());
    }
    alpha = 255 * (1 - alpha / 100);
    if(alpha < 0 || alpha > 255){
      throw new ExtensionException("Transparency must be in the range from 0 to 100");
    }
    LogoListBuilder ans = new LogoListBuilder();
    for(int i = 0; i < 3; i++){
      ans.add(the_rgbcolor.get(i));
    }
    if(alpha != 255){
      ans.add(alpha);
    }

    return ans.toLogoList();
  }
}
