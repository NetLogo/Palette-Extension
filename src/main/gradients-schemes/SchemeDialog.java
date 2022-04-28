import org.nlogo.api.Argument;
import org.nlogo.api.Command;
import org.nlogo.api.Context;
import org.nlogo.app.App;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;
import org.nlogo.window.GUIWorkspace;
import org.nlogo.window.GUIWorkspaceScala;

public class SchemeDialog implements Command {
	public Syntax getSyntax() {
		return SyntaxJ.commandSyntax(new int[] { });
	}

	public String getAgentClassString() {
		return "OTPL" ;
	}

	public void perform(Argument args[], Context context)
		throws ExtensionException, LogoException {
      java.awt.Frame frame  = ((GUIWorkspaceScala)context.workspace()).getFrame();
  		ColorSchemesDialog csd = new ColorSchemesDialog(frame);
		csd.showDialog();
	}
}
