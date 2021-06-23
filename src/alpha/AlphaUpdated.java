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


public class AlphaUpdated implements Reporter{
  public Syntax getSyntax(){
    int[] values = {
      Syntax.NumberType() | Syntax.ListType(),
      Syntax.NumberType()
    };
    int ret = Syntax.ListType();

    return SyntaxJ.reporterSyntax(values, ret, 2);
  }
  public Object report(Argument args[] , Context context)
    throws ExtensionException{

    LogoList the_rgbcolor = null;
    double the_nlcolor = 0;
    double alpha = 255;
  //  _extractrgb ergb = new _extractrgb();

    try{
      the_rgbcolor = args[0].getList();
    }
    catch(ExtensionException e){
      org.nlogo.api.Exceptions.ignore( e ) ;
      try{
        the_nlcolor = args[0].getDoubleValue();
        the_nlcolor = org.nlogo.api.Color.modulateDouble(the_nlcolor);
        the_rgbcolor = org.nlogo.api.Color.getRGBListByARGB(org.nlogo.api.Color.getARGBbyPremodulatedColorNumber(the_nlcolor));

      }
      catch(ExtensionException e2){
        throw new ExtensionException("Input must be a list or a number");
      }
    }
    try{
      alpha = args[1].getDoubleValue();
    }
    catch(ExtensionException e){
      throw new ExtensionException(e.getMessage());
    }
    if(alpha < 0 || alpha > 255){
      throw new ExtensionException("alpha must be in the range from 0 to 255");
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
