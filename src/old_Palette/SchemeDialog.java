import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;
import org.nlogo.api.Command;


public class SchemeDialog implements Command
{
	public Syntax getSyntax()
	{
		return SyntaxJ.commandSyntax
			( new int[] { } ) ;
	}
	public String getAgentClassString()
	{
		return "OTPL" ;
	}	
	public void perform( Argument args[] , Context context )
		throws ExtensionException, LogoException
	{
		ColorSchemesDialog csd = new ColorSchemesDialog(null, false);
		csd.showDialog();
	}
}

