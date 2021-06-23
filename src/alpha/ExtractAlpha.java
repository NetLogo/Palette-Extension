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

public class ExtractAlpha implements Reporter {

  private LogoList the_color = null;

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

    try{
      the_color = args[0].getList();
    }
    catch(ExtensionException e){
      org.nlogo.api.Exceptions.ignore( e ) ;
      return alpha;
    }

    //org.nlogo.api.Color.validRGBList(the_color, true); //not working
  //  catch(ExtensionException e){throw new ExtensionException(e.getMessage());}

    if(the_color.length() >= 4){
      alpha = (Double) the_color.get(3);
    }
    return alpha;
  }
}
