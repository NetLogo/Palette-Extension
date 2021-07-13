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
import org.nlogo.api.Color;

public class ExtractTransparency implements Reporter {

  public Syntax getSyntax(){
    int[] values = {
      Syntax.NumberType() | Syntax.ListType() // color
    };
    int ret = Syntax.NumberType();
    return SyntaxJ.reporterSyntax(values, ret, 1);
  }

  public Object report(Argument args[] , Context context)
    throws ExtensionException{

    double alpha = 255;
    LogoList the_color;
    ColorManager cm = new ColorManager();
    the_color = cm.extractColorFromArg(args[0]);
    if(the_color.length() >= 4){
      alpha = (Double) the_color.get(3);
    }
    return (1 - alpha/255) * 100;
  }
}
