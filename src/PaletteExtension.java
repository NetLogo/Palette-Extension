import org.nlogo.api.DefaultClassManager;
import org.nlogo.api.PrimitiveManager;

public class PaletteExtension extends DefaultClassManager {
    public void load(PrimitiveManager primitiveManager) {
    	//Scale gradient for only 2 colors is in the process of being depreciated
        //primitiveManager.addPrimitive ("scale-gradient", new ScaleGradient());
        primitiveManager.addPrimitive ("scale-gradient", new ScaleGradient());
        primitiveManager.addPrimitive ("scale-gradient-hsb", new ScaleGradientHSB());
        primitiveManager.addPrimitive ("scale-scheme", new ScaleScheme());
        primitiveManager.addPrimitive ("scheme-colors", new SchemeColors());
        primitiveManager.addPrimitive ("scheme-dialog", new SchemeDialog());
        //alpha
        primitiveManager.addPrimitive ("extract-alpha", new ExtractAlpha());
        primitiveManager.addPrimitive ("alpha-updated", new AlphaUpdated());
        primitiveManager.addPrimitive ("get-color-alpha", new GetColorAlpha());
        primitiveManager.addPrimitive ("set-color-alpha", new SetColorAlpha());
        primitiveManager.addPrimitive ("adjust-color-alpha", new AdjustColorAlpha());
        primitiveManager.addPrimitive ("with-alpha", new WithAlpha());

        primitiveManager.addPrimitive ("extract-transparency", new ExtractTransparency());
        primitiveManager.addPrimitive ("get-color-transparency", new GetColorTransparency());
        primitiveManager.addPrimitive ("set-color-transparency", new SetColorTransparency());
        primitiveManager.addPrimitive ("transparency-updated", new TransparencyUpdated());
        primitiveManager.addPrimitive ("with-transparency", new WithTransparency());
        primitiveManager.addPrimitive ("adjust-color-transparency", new AdjustColorTransparency());
        //HSB
        primitiveManager.addPrimitive ("get-color-hue", new GetColorHue());
        primitiveManager.addPrimitive ("get-color-saturation", new GetColorSaturation());
        primitiveManager.addPrimitive ("get-color-brightness", new GetColorBrightness());

        primitiveManager.addPrimitive ("set-color-hue", new SetColorHue());
        primitiveManager.addPrimitive ("set-color-saturation", new SetColorSaturation());
        primitiveManager.addPrimitive ("set-color-brightness", new SetColorBrightness());

        primitiveManager.addPrimitive ("extract-hue", new ExtractHue());
        primitiveManager.addPrimitive ("extract-saturation", new ExtractSaturation());
        primitiveManager.addPrimitive ("extract-brightness", new ExtractBrightness());

        primitiveManager.addPrimitive ("hue-updated", new HueUpdated());
        primitiveManager.addPrimitive ("saturation-updated", new SaturationUpdated());
        primitiveManager.addPrimitive ("brightness-updated", new BrightnessUpdated());

        primitiveManager.addPrimitive ("adjust-color-hue", new AdjustColorHue());
        primitiveManager.addPrimitive ("adjust-color-saturation", new AdjustColorSaturation());
        primitiveManager.addPrimitive ("adjust-color-brightness", new AdjustColorBrightness());

        primitiveManager.addPrimitive ("with-hue", new WithHue());
        primitiveManager.addPrimitive ("with-saturation", new WithSaturation());
        primitiveManager.addPrimitive ("with-brightness", new WithBrightness());
        //RGB
        primitiveManager.addPrimitive ("get-color-red", new GetColorRed());
        primitiveManager.addPrimitive ("get-color-green", new GetColorGreen());
        primitiveManager.addPrimitive ("get-color-blue", new GetColorBlue());

        primitiveManager.addPrimitive ("set-color-red", new SetColorRed());
        primitiveManager.addPrimitive ("set-color-green", new SetColorGreen());
        primitiveManager.addPrimitive ("set-color-blue", new SetColorBlue());

        primitiveManager.addPrimitive ("extract-red", new ExtractRed());
        primitiveManager.addPrimitive ("extract-green", new ExtractGreen());
        primitiveManager.addPrimitive ("extract-blue", new ExtractBlue());

        primitiveManager.addPrimitive ("red-updated", new RedUpdated());
        primitiveManager.addPrimitive ("green-updated", new GreenUpdated());
        primitiveManager.addPrimitive ("blue-updated", new BlueUpdated());

        primitiveManager.addPrimitive ("adjust-color-red", new AdjustColorRed());
        primitiveManager.addPrimitive ("adjust-color-blue", new AdjustColorBlue());
        primitiveManager.addPrimitive ("adjust-color-green", new AdjustColorGreen());

        primitiveManager.addPrimitive ("with-red", new WithRed());
        primitiveManager.addPrimitive ("with-green", new WithGreen());
        primitiveManager.addPrimitive ("with-blue", new WithBlue());
        //primitiveManager.addPrimitive ("infix-test", new InfixTest());
    }
}
