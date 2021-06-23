import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.Reporter;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.AgentException;
import org.nlogo.api.Color;
import org.nlogo.core.LogoList;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;


public class ExtractHue implements Reporter {
  public Syntax getSyntax() {
    int[] values = {
      Syntax.NumberType() | Syntax.ListType()
    };
    int ret = Syntax.NumberType();
    return SyntaxJ.reporterSyntax(values, ret, 1);
  }

  public Object report(Argument args[], Context context) throws ExtensionException {
    LogoList rgb;
    double color = 0;

    try{
      color = args[0].getDoubleValue();
      rgb = Color.getRGBListByARGB(Color.getARGBbyPremodulatedColorNumber(Color.modulateDouble(color)));
    }
    catch(ExtensionException e){
      org.nlogo.api.Exceptions.ignore(e);
      try{
        rgb = args[0].getList();
        try{
          Color.validRGBList(rgb, true);
        }
        catch(AgentException a){
          throw new ExtensionException("Color must have valid RGB List");
        }
      }
      catch(ExtensionException e2){
        throw new ExtensionException(e2);
      }
    }
    ExtractHSB extractor = new ExtractHSB();
    return extractor.extract(rgb, 0);
  }
}
