// [color] palette:with-component [number]
// changes the component of the color to number while leaving the other components in the same colorspace unchanged
import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.Reporter;
import org.nlogo.core.LogoList;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;

public class WithBrightness implements Reporter {
  public Syntax getSyntax() {
    int left = Syntax.NumberType() | Syntax.ListType();
    int values[] = {Syntax.NumberType()};
    int ret = Syntax.ListType();
    return SyntaxJ.reporterSyntax(left, values, ret, Syntax.NormalPrecedence());
  }
  public Object report(Argument args[], Context context) throws ExtensionException {
    ColorManager colorManager = new ColorManager();
    LogoList rgb;

    try { // testing input
      rgb = colorManager.extractColorFromArg(args[0]);
    }
    catch (ExtensionException e) {
      throw new ExtensionException(e.getMessage());
    }

    double newVal = 0;
    try {
      newVal = args[1].getDoubleValue();
    }
    catch (ExtensionException e) {
      throw new ExtensionException(e.getMessage());
    }
    HSBUpdated hsbupdated = new HSBUpdated();
    return hsbupdated.updateHSB(rgb, newVal, 2);
  }
}
