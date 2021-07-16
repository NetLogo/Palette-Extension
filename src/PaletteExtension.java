import org.nlogo.api.DefaultClassManager;
import org.nlogo.api.PrimitiveManager;

public class PaletteExtension extends DefaultClassManager {
    public void load(PrimitiveManager primitiveManager) {
        primitiveManager.addPrimitive ("scale-gradient", new ScaleGradient());
        primitiveManager.addPrimitive ("scale-gradient-hsb", new ScaleGradientHSB());
        primitiveManager.addPrimitive ("scale-scheme", new ScaleScheme());
        primitiveManager.addPrimitive ("scheme-colors", new SchemeColors());
        primitiveManager.addPrimitive ("scheme-dialog", new SchemeDialog());
        //alpha
        primitiveManager.addPrimitive ("alpha-of", new ExtractAlpha());
        primitiveManager.addPrimitive ("alpha", new GetAgentAlpha());
        primitiveManager.addPrimitive ("set-alpha", new SetAgentAlpha());
        primitiveManager.addPrimitive ("with-alpha", new WithAlpha());
        primitiveManager.addPrimitive ("transparency-of", new ExtractTransparency());
        primitiveManager.addPrimitive ("transparency", new GetAgentTransparency());
        primitiveManager.addPrimitive ("set-transparency", new SetAgentTransparency());
        primitiveManager.addPrimitive ("with-transparency", new WithTransparency());
        //HSB
        primitiveManager.addPrimitive ("hue", new GetAgentHue());
        primitiveManager.addPrimitive ("saturation", new GetAgentSaturation());
        primitiveManager.addPrimitive ("brightness", new GetAgentBrightness());

        primitiveManager.addPrimitive ("set-hue", new SetAgentHue());
        primitiveManager.addPrimitive ("set-saturation", new SetAgentSaturation());
        primitiveManager.addPrimitive ("set-brightness", new SetAgentBrightness());

        primitiveManager.addPrimitive ("hue-of", new ExtractHue());
        primitiveManager.addPrimitive ("saturation-of", new ExtractSaturation());
        primitiveManager.addPrimitive ("brightness-of", new ExtractBrightness());

        primitiveManager.addPrimitive ("with-hue", new WithHue());
        primitiveManager.addPrimitive ("with-saturation", new WithSaturation());
        primitiveManager.addPrimitive ("with-brightness", new WithBrightness());
        //RGB
        primitiveManager.addPrimitive ("R", new GetAgentRed());
        primitiveManager.addPrimitive ("G", new GetAgentGreen());
        primitiveManager.addPrimitive ("B", new GetAgentBlue());

        primitiveManager.addPrimitive ("set-R", new SetAgentRed());
        primitiveManager.addPrimitive ("set-G", new SetAgentGreen());
        primitiveManager.addPrimitive ("set-B", new SetAgentBlue());

        primitiveManager.addPrimitive ("R-of", new ExtractRed());
        primitiveManager.addPrimitive ("G-of", new ExtractGreen());
        primitiveManager.addPrimitive ("B-of", new ExtractBlue());

        primitiveManager.addPrimitive ("with-R", new WithRed());
        primitiveManager.addPrimitive ("with-G", new WithGreen());
        primitiveManager.addPrimitive ("with-B", new WithBlue());
    }
}
