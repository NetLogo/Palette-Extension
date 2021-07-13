import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.Reporter;
import org.nlogo.api.Color;
import org.nlogo.core.LogoList;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;

public class GetColorHue implements Reporter {
  public Syntax getSyntax(){
    int values[] = {};
    int ret = Syntax.NumberType();
    return SyntaxJ.reporterSyntax(values, ret, "-TPL");
  }

  public Object report(Argument args[], Context context){
    ColorManager cm = new ColorManager();
    ExtractHSB extractor = new ExtractHSB();
    LogoList rgb = cm.getAgentColor(context);
    return extractor.extract(rgb, 0);
  }
}
