import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;
import org.nlogo.api.Reporter;
import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.ExtensionException;
import org.nlogo.core.LogoList;

public class WithBlue implements Reporter {
  public Syntax getSyntax(){
    int left = Syntax.NumberType() | Syntax.ListType();
    int values[] = {Syntax.NumberType()};
    int ret = Syntax.ListType();
    return SyntaxJ.reporterSyntax(left, values, ret, Syntax.NormalPrecedence());
  }
  public Object report(Argument args[], Context context) throws ExtensionException {
    BlueUpdated bu = new BlueUpdated();
    LogoList ll;
    try{
      ll = (LogoList) bu.report(args, context);
    }
    catch(ExtensionException e){
      throw new ExtensionException(e.getMessage());
    }
    return ll;
  }
}