import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.Reporter;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;
import org.nlogo.core.LogoList;
import org.nlogo.api.LogoListBuilder;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;

// TODO: Check cache handling

public class ScaleScheme implements Reporter
{

	public Syntax getSyntax()
	{
		int[] right = { Syntax.StringType() ,
				Syntax.StringType() ,
				Syntax.NumberType() ,
				Syntax.NumberType() ,
				Syntax.NumberType() ,
				Syntax.NumberType() } ;
		int ret = Syntax.ListType() ;
		return SyntaxJ.reporterSyntax( right , ret ) ;
	}


	public Object report( Argument args[] , Context context )
			throws ExtensionException
	{
		String schemename;
		String legendname;
		int size;
		double var;
		double min;
		double max;
		try
		{
			schemename = args[ 0 ].getString();
			legendname = args[ 1 ].getString();
			size = args[ 2 ].getIntValue();
			var  = args[ 3 ].getDoubleValue();
			min  = args[ 4 ].getDoubleValue();
			max  = args[ 5 ].getDoubleValue();
		}
		catch( LogoException e )
		{
			throw new ExtensionException( e.getMessage() ) ;
		}

		int index = 0;
		int [][] legend;

		double perc = 0.0 ;
		if( min > max )      // min and max are really reversed
		{
			if( var < max)
			{
				perc = 1.0 ;
			}
			else if ( var > min )
			{
				perc = 0.0 ;
			}
			else
			{
				double tempval = min - var ;
				double tempmax = min - max;
				perc = tempval / tempmax ;
			}
		}
		else
		{
			if( var > max )
			{
				perc = 1.0 ;
			}
			else if ( var < min )
			{
				perc = 0.0 ;
			}
			else
			{
				double tempval = var - min ;
				double tempmax = max - min ;
				perc = tempval / tempmax ;
			}
		}
		index = (int) Math.ceil((perc * (size - 1))) ;

		legend = ColorSchemes.getRGBArray(schemename, legendname, size);

		LogoListBuilder list = new LogoListBuilder() ;
		try
		{
			list.add(Double.valueOf(legend[index][0])) ;
			list.add(Double.valueOf(legend[index][1])) ;
			list.add(Double.valueOf(legend[index][2])) ;
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			throw new ExtensionException(
					"The number of colors in a scheme is limited to " +
					String.valueOf(ColorSchemes.getRGBArray( schemename , legendname ).length) +
					" but your third argument is " + size) ;
		}
		catch (NullPointerException e)
		{
			throw new ExtensionException(

					"The number of colors in a scheme is limited to " +
					String.valueOf(ColorSchemes.getRGBArray( schemename , legendname ).length) +
					" but your third argument is " + size) ;
		}

		return list.toLogoList() ;
	}
}
