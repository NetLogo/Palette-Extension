import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.Reporter;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.AgentException;
import org.nlogo.api.Color;
import org.nlogo.core.LogoList;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;


public class ExtractSaturation implements Reporter {
  public Syntax getSyntax() {
    int[] values = {
      Syntax.NumberType() | Syntax.ListType()
    };
    int ret = Syntax.NumberType();
    return SyntaxJ.reporterSyntax(values, ret, 1);
  }

  public Object report(Argument args[], Context context) throws ExtensionException {
    ColorManager cm = new ColorManager();
    LogoList rgb;
    try{
        rgb = cm.extractColorFromArg(args[0]);
    }
    catch(ExtensionException e){
      throw new ExtensionException(e.getMessage());
    }
    ExtractHSB extractor = new ExtractHSB();
    return extractor.extract(rgb, 1);
  }
}
