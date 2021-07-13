import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;
import org.nlogo.api.Reporter;
import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.ExtensionException;
import org.nlogo.core.LogoList;

public class WithTransparency implements Reporter {
  public Syntax getSyntax(){
    int left = Syntax.NumberType() | Syntax.ListType();
    int values[] = {Syntax.NumberType()};
    int ret = Syntax.ListType();
    return SyntaxJ.reporterSyntax(left, values, ret, Syntax.NormalPrecedence());
  }
  public Object report(Argument args[], Context context) throws ExtensionException {
    TransparencyUpdated tu = new TransparencyUpdated();
    LogoList ll;
    try{
      ll = (LogoList) tu.report(args, context);
    }
    catch(ExtensionException e){
      throw new ExtensionException(e.getMessage());
    }
    return ll;
  }
}
